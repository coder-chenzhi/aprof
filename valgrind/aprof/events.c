/*
 * Event handlers and instrumentation
 * 
 * Last changed: $Date: 2013-05-13 15:39:52 +0200 (lun, 13 mag 2013) $
 * Revision:     $Rev: 838 $
 */

/*
   This file is part of aprof, an input sensitive profiler.

   Copyright (C) 2011-2014, Emilio Coppa (ercoppa@gmail.com),
                            Camil Demetrescu,
                            Irene Finocchi,
                            Romolo Marotta

   This program is free software; you can redistribute it and/or
   modify it under the terms of the GNU General Public License as
   published by the Free Software Foundation; either version 2 of the
   License, or (at your option) any later version.

   This program is distributed in the hope that it will be useful, but
   WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
   General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program; if not, write to the Free Software
   Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA
   02111-1307, USA.

   The GNU General Public License is contained in the file COPYING.
*/

#include "aprof.h"

/* Maintain an ordered list of memory events which are outstanding, in
   the sense that no IR has yet been generated to do the relevant
   helper calls.  The SB is scanned top to bottom and memory events
   are added to the end of the list, merging with the most recent
   notified event where possible (Dw immediately following Dr and
   having the same size and EA can be merged).

   This merging is done so that for architectures which have
   load-op-store instructions (x86, amd64), the instr is treated as if
   it makes just one memory reference (a modify), rather than two (a
   read followed by a write at the same address).

   At various points the list will need to be flushed, that is, IR
   generated from it.  That must happen before any possible exit from
   the block (the end, or an IRStmt_Exit).  Flushing also takes place
   when there is no space to add a new event.

   If we require the simulation statistics to be up to date with
   respect to possible memory exceptions, then the list would have to
   be flushed before each memory reference.  That's a pain so we don't
   bother.

   Flushing the list consists of walking it start to end and emitting
   instrumentation IR for each event, in the order in which they
   appear. 
*/

void APROF_(flush_events_rms)(IRSB * sb) {
    
    Int        i;
    const HChar *    helperName = NULL;
    void*      helperAddr = NULL;
    IRExpr**   argv = NULL;
    IRDirty*   di;
    Event*     ev;

    for (i = 0; i < APROF_(runtime).events_used; i++) {

        ev = &(APROF_(runtime).events[i]);

        // Decide on helper fn to call and args to pass it.
        switch (ev->ekind) {
        
            case Event_Ir: break;
            
            case Event_Dr:  helperName = "trace_load";
                            argv = mkIRExprVec_3(   mkIRExpr_HWord(LOAD), 
                                                    ev->addr, 
                                                    mkIRExpr_HWord( ev->size ));
                            helperAddr = APROF_(trace_access_rms);
                            break;

            case Event_Dw:  helperName = "trace_store";
                            argv = mkIRExprVec_3(   mkIRExpr_HWord(STORE), 
                                                    ev->addr, 
                                                    mkIRExpr_HWord( ev->size ));
                            helperAddr =  APROF_(trace_access_rms); break;

            case Event_Dm:  helperName = "trace_modify";
                            argv = mkIRExprVec_3(   mkIRExpr_HWord(MODIFY), 
                                                    ev->addr, 
                                                    mkIRExpr_HWord( ev->size ));
                            helperAddr =  APROF_(trace_access_rms); break;
            
            default:
                tl_assert(0);
        
        }

        // Add the helper.
        if (ev->ekind != Event_Ir) {
            
            di = unsafeIRDirty_0_N(3, helperName, 
                                    VG_(fnptr_to_fnentry)(helperAddr),
                                    argv);
            
            addStmtToIRSB(sb, IRStmt_Dirty(di));
        }
    }

    APROF_(runtime).events_used = 0;
}

void APROF_(flush_events_drms)(IRSB * sb) {
    
    Int        i;
    const HChar *    helperName = NULL;
    void*      helperAddr = NULL;
    IRExpr**   argv = NULL;
    IRDirty*   di;
    Event*     ev;

    for (i = 0; i < APROF_(runtime).events_used; i++) {

        ev = &(APROF_(runtime).events[i]);

        // Decide on helper fn to call and args to pass it.
        switch (ev->ekind) {
        
            case Event_Ir: break;
            
            case Event_Dr:  helperName = "trace_load";
                            argv = mkIRExprVec_4(   mkIRExpr_HWord(LOAD), 
                                                    ev->addr, 
                                                    mkIRExpr_HWord( ev->size ),
                                                    mkIRExpr_HWord(False) );
                            helperAddr = APROF_(trace_access_drms);
                            break;

            case Event_Dw:  helperName = "trace_store";
                            argv = mkIRExprVec_4(   mkIRExpr_HWord(STORE), 
                                                    ev->addr, 
                                                    mkIRExpr_HWord( ev->size ),
                                                    mkIRExpr_HWord(False) );
                            helperAddr =  APROF_(trace_access_drms); break;

            case Event_Dm:  helperName = "trace_modify";
                            argv = mkIRExprVec_4(   mkIRExpr_HWord(MODIFY), 
                                                    ev->addr, 
                                                    mkIRExpr_HWord( ev->size ),
                                                    mkIRExpr_HWord(False) );
                            helperAddr =  APROF_(trace_access_drms); break;
            
            default:
                tl_assert(0);
        
        }

        // Add the helper.
        if (ev->ekind != Event_Ir) {
            
            di = unsafeIRDirty_0_N( 3, helperName, 
                                    VG_(fnptr_to_fnentry)( helperAddr ),
                                    argv );
            
            addStmtToIRSB( sb, IRStmt_Dirty(di) );
        }
    }

    APROF_(runtime).events_used = 0;
}

// WARNING:  If you aren't interested in instruction reads, you can omit the
// code that adds calls to trace_instr() in flushEvents().  However, you
// must still call this function, addEvent_Ir() -- it is necessary to add
// the Ir events to the events list so that merging of paired load/store
// events into modify events works correctly.
void APROF_(addEvent_Ir) ( IRSB* sb, IRExpr * iaddr, UInt isize) {
    
    APROF_(debug_assert)((VG_MIN_INSTR_SZB <= isize && isize <= VG_MAX_INSTR_SZB)
                            || VG_CLREQ_SZB == isize, "Invalid instruction" );
    
    if (APROF_(runtime).events_used == N_EVENTS)
        APROF_(runtime).flush_events(sb);

    Event * evt = &(APROF_(runtime).events[APROF_(runtime).events_used]);
    evt->ekind = Event_Ir;
    evt->addr  = iaddr;
    evt->size  = isize;
    APROF_(runtime).events_used++;
}

void APROF_(addEvent_Dr) (IRSB* sb, IRExpr * daddr, Int dsize) {
    
    APROF_(debug_assert)(isIRAtom(daddr), "Invalid address");
    APROF_(debug_assert)(dsize >= 1 && dsize <= MAX_DSIZE, "Invalid size");

    if (APROF_(runtime).events_used == N_EVENTS)
        APROF_(runtime).flush_events(sb);

    Event * evt = &(APROF_(runtime).events[APROF_(runtime).events_used]);
    evt->ekind = Event_Dr;
    evt->addr  = daddr;
    evt->size  = dsize;
    APROF_(runtime).events_used++;
}

void APROF_(addEvent_Dw) (IRSB* sb, IRExpr * daddr, Int dsize) {
    
    APROF_(debug_assert)(isIRAtom(daddr), "Invalid address");
    APROF_(debug_assert)(dsize >= 1 && dsize <= MAX_DSIZE, "Invalid size");

    // Is it possible to merge this write with the preceding read?
    if (APROF_(runtime).events_used > 0) {
        
        Event * lastEvt = &(APROF_(runtime).events[APROF_(runtime).events_used -1]);
        if (lastEvt->ekind == Event_Dr
            && lastEvt->size  == dsize
            && eqIRAtom(lastEvt->addr, daddr)) {
        
            lastEvt->ekind = Event_Dm;
            return;
        }
    }

    // No.  Add as normal.
    if (APROF_(runtime).events_used == N_EVENTS)
        APROF_(runtime).flush_events(sb);
    
    Event * evt = &(APROF_(runtime).events[APROF_(runtime).events_used]);
    evt->ekind = Event_Dw;
    evt->size  = dsize;
    evt->addr  = daddr;
    APROF_(runtime).events_used++;
}
