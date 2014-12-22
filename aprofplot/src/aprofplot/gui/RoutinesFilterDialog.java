package aprofplot.gui;

import java.util.ArrayList;
import aprofplot.gui.RoutinesTableModel.COLUMN;
import java.util.Vector;

public class RoutinesFilterDialog extends javax.swing.JDialog {

    /**
     * Creates new form RoutinesFilterDialog - modal means if it's a blocking
     * activity
     */
    public RoutinesFilterDialog(java.awt.Frame parent, boolean modal,
        java.util.ArrayList<String> v, String[] criteria,
        boolean is_routine_table, COLUMN[] config) {

        super(parent, modal);
        this.is_routine_table = is_routine_table;

        liblist = v;
        initComponents();

        if (liblist != null) {
            jCheckBox1.setEnabled(true);
        }

        setResizable(false);
        setSize(260, 300);
        setLocationRelativeTo(parent);

        if (criteria == null) {
            return;
        }

        // Time
        if (criteria[0] != null) {
            jCheckBox1.setSelected(true);
            jTextField1.setEnabled(true);
            jTextField1.setText(criteria[0]);
        }

        // lib
        if (criteria[1] != null) {
            jCheckBox2.setSelected(true);
            jComboBox1.setEnabled(true);
            jComboBox1.setSelectedItem(criteria[1]);
        }

        // Calls
        if (criteria[2] != null) {
            jCheckBox3.setSelected(true);
            jTextField2.setEnabled(true);
            jTextField2.setText(criteria[2]);
        }

        // # Rms
        if (criteria[3] != null) {
            jCheckBox5.setSelected(true);
            jTextField4.setEnabled(true);
            jTextField4.setText(criteria[3]);
        }

        if (((MainWindow) this.getParent()).isInputMetricRms()) {
            jCheckBox5.setText("#RMS");
        } else {
            jCheckBox5.setText("#DRMS");
        }

        if (!((MainWindow) this.getParent()).isVisibleFittingData()) {
            jPanel8.setVisible(false);
            jPanel9.setVisible(false);
            jPanel10.setVisible(false);
        } else {

            if (criteria[4] != null && criteria[5] != null) {
                jCheckBox6.setSelected(true);
                jTextField5.setEnabled(true);
                jTextField5.setText(criteria[4]);
                jTextField6.setEnabled(true);
                jTextField6.setText(criteria[5]);
            }

            if (criteria[6] != null) {
                jCheckBox7.setSelected(true);
                jTextField7.setEnabled(true);
                jTextField7.setText(criteria[6]);
            }

            if (criteria[7] != null) {
                jCheckBox8.setSelected(true);
            }
        }

        for (COLUMN c : config) {
            switch (c) {
                case NAME:
                    break;
                case LIB:
                    jCheckBox4.setSelected(true);
                    break;
                case COST:
                    jCheckBox9.setSelected(true);
                    break;
                case N_INPUT:
                    jCheckBox10.setSelected(true);
                    break;
                case P_COST:
                    jCheckBox11.setSelected(true);
                    break;
                case COST_PLOT:
                    jCheckBox12.setSelected(true);
                    break;
                case CALL:
                    jCheckBox13.setSelected(true);
                    break;
                case P_CALL:
                    jCheckBox14.setSelected(true);
                    break;
                case P_SYSCALL:
                    jCheckBox15.setSelected(true);
                    break;
                case P_THREAD:
                    jCheckBox16.setSelected(true);
                    break;
                case FIT_A:
                    jCheckBox17.setSelected(true);
                    break;
                case FIT_B:
                    jCheckBox18.setSelected(true);
                    break;
                case FIT_C:
                    jCheckBox19.setSelected(true);
                    break;
                case FIT_R2:
                    jCheckBox20.setSelected(true);
                    break;
                case CONTEXT:
                    jCheckBox22.setSelected(true);
                    break;
                case CONTEXT_COLLAPSED:
                    jCheckBox23.setSelected(true);
                    break;
                case FAVORITE:
                    jCheckBox21.setSelected(true);
                    break;
                default:
                    throw new RuntimeException("Invalid column: " + c);

            }
        }
    }

    public RoutinesFilterDialog(java.awt.Frame parent, boolean modal,
        java.util.ArrayList<String> v, String[] criteria, COLUMN[] config) {
        this(parent, modal, v, criteria, true, config);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel11 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox13 = new javax.swing.JCheckBox();
        jCheckBox14 = new javax.swing.JCheckBox();
        jCheckBox15 = new javax.swing.JCheckBox();
        jCheckBox16 = new javax.swing.JCheckBox();
        jCheckBox17 = new javax.swing.JCheckBox();
        jCheckBox18 = new javax.swing.JCheckBox();
        jCheckBox19 = new javax.swing.JCheckBox();
        jCheckBox20 = new javax.swing.JCheckBox();
        jCheckBox22 = new javax.swing.JCheckBox();
        jCheckBox23 = new javax.swing.JCheckBox();
        jCheckBox21 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jComboBox1 = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jCheckBox5 = new javax.swing.JCheckBox();
        jTextField4 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jCheckBox6 = new javax.swing.JCheckBox();
        jTextField5 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jCheckBox7 = new javax.swing.JCheckBox();
        jTextField7 = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jCheckBox8 = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Filter routines");
        setIconImage((new javax.swing.ImageIcon(getClass().getResource("/aprofplot/gui/resources/Filter-icon.png"))).getImage());
        setMaximumSize(new java.awt.Dimension(610, 308));
        setMinimumSize(new java.awt.Dimension(610, 308));
        setModal(true);
        setPreferredSize(new java.awt.Dimension(610, 308));

        jPanel11.setLayout(new javax.swing.BoxLayout(jPanel11, javax.swing.BoxLayout.LINE_AXIS));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Routine Table Columns"));
        jPanel6.setPreferredSize(new java.awt.Dimension(256, 300));
        jPanel6.setLayout(new java.awt.GridLayout(8, 2, 0, 4));

        jCheckBox4.setText("Binary");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });
        jPanel6.add(jCheckBox4);

        jCheckBox9.setText("Cost");
        jCheckBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox9ActionPerformed(evt);
            }
        });
        jPanel6.add(jCheckBox9);

        jCheckBox10.setText("#RMS");
        jCheckBox10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox10ActionPerformed(evt);
            }
        });
        jPanel6.add(jCheckBox10);

        jCheckBox12.setText("Cost Plot");
        jCheckBox12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox12ActionPerformed(evt);
            }
        });
        jPanel6.add(jCheckBox12);

        jCheckBox11.setText("Cost %");
        jCheckBox11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox11ActionPerformed(evt);
            }
        });
        jPanel6.add(jCheckBox11);

        jCheckBox13.setText("Calls");
        jCheckBox13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox13ActionPerformed(evt);
            }
        });
        jPanel6.add(jCheckBox13);

        jCheckBox14.setText("Calls %");
        jCheckBox14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox14ActionPerformed(evt);
            }
        });
        jPanel6.add(jCheckBox14);

        jCheckBox15.setText("Syscall %");
        jCheckBox15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox15ActionPerformed(evt);
            }
        });
        jPanel6.add(jCheckBox15);

        jCheckBox16.setText("Thread %");
        jCheckBox16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox16ActionPerformed(evt);
            }
        });
        jPanel6.add(jCheckBox16);

        jCheckBox17.setText("Fitting: a");
        jCheckBox17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox17ActionPerformed(evt);
            }
        });
        jPanel6.add(jCheckBox17);

        jCheckBox18.setText("Fitting: b");
        jCheckBox18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox18ActionPerformed(evt);
            }
        });
        jPanel6.add(jCheckBox18);

        jCheckBox19.setText("Fitting: c");
        jCheckBox19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox19ActionPerformed(evt);
            }
        });
        jPanel6.add(jCheckBox19);

        jCheckBox20.setText("Fit.quality");
        jCheckBox20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox20ActionPerformed(evt);
            }
        });
        jPanel6.add(jCheckBox20);

        jCheckBox22.setText("#Contexts");
        jCheckBox22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox22ActionPerformed(evt);
            }
        });
        jPanel6.add(jCheckBox22);

        jCheckBox23.setText("Ctx Collapsed");
        jCheckBox23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox23ActionPerformed(evt);
            }
        });
        jPanel6.add(jCheckBox23);

        jCheckBox21.setText("Favorite");
        jCheckBox21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox21ActionPerformed(evt);
            }
        });
        jPanel6.add(jCheckBox21);

        jPanel11.add(jPanel6);
        jPanel6.getAccessibleContext().setAccessibleName("Routine Table Fields");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Criteria"));
        jPanel1.setLayout(new java.awt.GridLayout(7, 1, 0, 4));

        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        jCheckBox2.setText("Library: ");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        jPanel4.add(jCheckBox2);

        jComboBox1.setBackground(java.awt.Color.white);
        jComboBox1.setModel(new RoutinesFilterComboBoxModel(liblist));
        jComboBox1.setEnabled(false);
        jComboBox1.setMaximumSize(new java.awt.Dimension(150, 27));
        jComboBox1.setMinimumSize(new java.awt.Dimension(150, 27));
        jComboBox1.setPreferredSize(new java.awt.Dimension(150, 27));
        jPanel4.add(jComboBox1);

        jPanel1.add(jPanel4);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jCheckBox1.setText("Cost %  >=  ");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel3.add(jCheckBox1);

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField1.setEnabled(false);
        jTextField1.setMaximumSize(new java.awt.Dimension(100, 27));
        jTextField1.setMinimumSize(new java.awt.Dimension(100, 27));
        jTextField1.setPreferredSize(new java.awt.Dimension(100, 27));
        jPanel3.add(jTextField1);

        jLabel2.setText(" %");
        jPanel3.add(jLabel2);

        jPanel1.add(jPanel3);

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        jCheckBox3.setText("Calls %  >=  ");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });
        jPanel5.add(jCheckBox3);

        jTextField2.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField2.setEnabled(false);
        jTextField2.setMaximumSize(new java.awt.Dimension(100, 27));
        jTextField2.setMinimumSize(new java.awt.Dimension(100, 27));
        jTextField2.setPreferredSize(new java.awt.Dimension(100, 27));
        jPanel5.add(jTextField2);

        jLabel3.setText(" %");
        jPanel5.add(jLabel3);

        jPanel1.add(jPanel5);

        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));

        jCheckBox5.setText("#Rms  >=    ");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });
        jPanel7.add(jCheckBox5);

        jTextField4.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField4.setEnabled(false);
        jTextField4.setMaximumSize(new java.awt.Dimension(100, 27));
        jTextField4.setMinimumSize(new java.awt.Dimension(100, 27));
        jTextField4.setPreferredSize(new java.awt.Dimension(100, 27));
        jPanel7.add(jTextField4);

        jPanel1.add(jPanel7);

        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.LINE_AXIS));

        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });
        jPanel8.add(jCheckBox6);

        jTextField5.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField5.setEnabled(false);
        jTextField5.setMaximumSize(new java.awt.Dimension(60, 27));
        jTextField5.setMinimumSize(new java.awt.Dimension(60, 27));
        jTextField5.setPreferredSize(new java.awt.Dimension(60, 27));
        jPanel8.add(jTextField5);

        jLabel1.setText(" < b <= ");
        jPanel8.add(jLabel1);

        jTextField6.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField6.setEnabled(false);
        jTextField6.setMaximumSize(new java.awt.Dimension(60, 27));
        jTextField6.setMinimumSize(new java.awt.Dimension(60, 27));
        jTextField6.setPreferredSize(new java.awt.Dimension(60, 27));
        jPanel8.add(jTextField6);

        jPanel1.add(jPanel8);

        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.LINE_AXIS));

        jCheckBox7.setText("fitting quality >=");
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });
        jPanel9.add(jCheckBox7);

        jTextField7.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField7.setEnabled(false);
        jTextField7.setMaximumSize(new java.awt.Dimension(100, 27));
        jTextField7.setMinimumSize(new java.awt.Dimension(100, 27));
        jTextField7.setPreferredSize(new java.awt.Dimension(100, 27));
        jPanel9.add(jTextField7);

        jPanel1.add(jPanel9);

        jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.LINE_AXIS));

        jCheckBox8.setText("Hide unfitted routine");
        jCheckBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox8ActionPerformed(evt);
            }
        });
        jPanel10.add(jCheckBox8);

        jPanel1.add(jPanel10);

        jPanel11.add(jPanel1);

        getContentPane().add(jPanel11, java.awt.BorderLayout.CENTER);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 3, 3, 3));
        jPanel2.setRequestFocusEnabled(false);
        jPanel2.setLayout(new java.awt.GridLayout());

        jButton1.setText("    Ok    ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(javax.swing.Box.createHorizontalGlue());
        jPanel2.add(jButton1);

        jButton2.setText(" Cancel ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed

        // % time checkbox
        if (jCheckBox1.isSelected()) {
            jTextField1.setEnabled(true);
        } else {
            jTextField1.setEnabled(false);
        }

	}//GEN-LAST:event_jCheckBox1ActionPerformed

	private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed

        // % calls checkbox
        if (jCheckBox3.isSelected()) {
            jTextField2.setEnabled(true);
        } else {
            jTextField2.setEnabled(false);
        }

	}//GEN-LAST:event_jCheckBox3ActionPerformed

	private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed

        // lib checkbox
        if (jCheckBox2.isSelected()) {
            jComboBox1.setEnabled(true);
        } else {
            jComboBox1.setEnabled(false);
        }

	}//GEN-LAST:event_jCheckBox2ActionPerformed

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        // pressed OK button
        if (validateUserInput()) {

            this.dispose();
            String[] criteria = new String[8];

            if (jCheckBox1.isSelected()) {
                criteria[0] = jTextField1.getText();
            }
            if (jCheckBox2.isSelected()) {
                criteria[1] = (String) jComboBox1.getSelectedItem();
            }
            if (jCheckBox3.isSelected()) {
                criteria[2] = jTextField2.getText();
            }
            if (jCheckBox5.isSelected()) {
                criteria[3] = jTextField4.getText();
            }

            // b values
            if (jCheckBox6.isSelected()) {
                criteria[4] = jTextField5.getText();
            }
            if (jCheckBox6.isSelected()) {
                criteria[5] = jTextField6.getText();
            }

            // fitting quality
            if (jCheckBox7.isSelected()) {
                criteria[6] = jTextField7.getText();
            }

            // hide unfitted routine
            if (jCheckBox5.isSelected()) {
                criteria[7] = "hide";
            }

            Vector<COLUMN> conf = new Vector<COLUMN>();
            conf.add(COLUMN.NAME);
            if (jCheckBox4.isSelected()) {
                conf.add(COLUMN.LIB);
            }
            if (jCheckBox9.isSelected()) {
                conf.add(COLUMN.COST);
            }
            if (jCheckBox10.isSelected()) {
                conf.add(COLUMN.N_INPUT);
            }
            if (jCheckBox11.isSelected()) {
                conf.add(COLUMN.P_COST);
            }
            if (jCheckBox12.isSelected()) {
                conf.add(COLUMN.COST_PLOT);
            }
            if (jCheckBox13.isSelected()) {
                conf.add(COLUMN.CALL);
            }
            if (jCheckBox14.isSelected()) {
                conf.add(COLUMN.P_CALL);
            }
            if (jCheckBox15.isSelected()) {
                conf.add(COLUMN.P_SYSCALL);
            }
            if (jCheckBox16.isSelected()) {
                conf.add(COLUMN.P_THREAD);
            }
            if (jCheckBox17.isSelected()) {
                conf.add(COLUMN.FIT_A);
            }
            if (jCheckBox18.isSelected()) {
                conf.add(COLUMN.FIT_B);
            }
            if (jCheckBox19.isSelected()) {
                conf.add(COLUMN.FIT_C);
            }
            if (jCheckBox20.isSelected()) {
                conf.add(COLUMN.FIT_R2);
            }
            if (jCheckBox22.isSelected()) {
                conf.add(COLUMN.CONTEXT);
            }
            if (jCheckBox23.isSelected()) {
                conf.add(COLUMN.CONTEXT_COLLAPSED);
            }
            if (jCheckBox21.isSelected()) {
                conf.add(COLUMN.FAVORITE);
            }
            COLUMN[] config = conf.toArray(new COLUMN[conf.size()]);
            ((MainWindow) this.getParent()).updateRoutineTableConfig(config);

            if (is_routine_table) {
                ((MainWindow) this.getParent()).setRoutinesTableFilter(criteria);
            } else {
                ((MainWindow) this.getParent()).setContextsTableFilter(criteria);
            }
        }
	}//GEN-LAST:event_jButton1ActionPerformed

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        // Pressed CANCEL button
        this.dispose();

	}//GEN-LAST:event_jButton2ActionPerformed

	private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed

        // # rms checkbox
        if (jCheckBox5.isSelected()) {
            jTextField4.setEnabled(true);
        } else {
            jTextField4.setEnabled(false);
        }

	}//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed

        // b checkbox
        if (jCheckBox6.isSelected()) {
            jTextField5.setEnabled(true);
            jTextField6.setEnabled(true);
        } else {
            jTextField5.setEnabled(false);
            jTextField6.setEnabled(false);
        }

    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed

        // fitting qualiy checkbox
        if (jCheckBox7.isSelected()) {
            jTextField7.setEnabled(true);
        } else {
            jTextField7.setEnabled(false);
        }

    }//GEN-LAST:event_jCheckBox7ActionPerformed

    private void jCheckBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox8ActionPerformed
        // hide unfitter routine
    }//GEN-LAST:event_jCheckBox8ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox9ActionPerformed

    private void jCheckBox10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox10ActionPerformed

    private void jCheckBox11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox11ActionPerformed

    private void jCheckBox12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox12ActionPerformed

    private void jCheckBox13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox13ActionPerformed

    private void jCheckBox14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox14ActionPerformed

    private void jCheckBox15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox15ActionPerformed

    private void jCheckBox16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox16ActionPerformed

    private void jCheckBox17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox17ActionPerformed

    private void jCheckBox18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox18ActionPerformed

    private void jCheckBox19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox19ActionPerformed

    private void jCheckBox20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox20ActionPerformed

    private void jCheckBox21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox21ActionPerformed

    private void jCheckBox22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox22ActionPerformed

    private void jCheckBox23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox23ActionPerformed

    private boolean validateUserInput() {

        if (jCheckBox1.isSelected()) {

            try {

                double time_perc = Double.parseDouble(jTextField1.getText());
                if (time_perc < 0 || time_perc > 100) {
                    throw (new Exception());
                }

            } catch (Exception e) {

                javax.swing.JOptionPane.showMessageDialog(this,
                    "Time % must be a positive decimal\nwithin the range 0-100",
                    "Invalid input",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        if (jCheckBox3.isSelected()) {

            try {

                double calls_perc = Double.parseDouble(jTextField2.getText());
                if (calls_perc < 0 || calls_perc > 100) {
                    throw (new Exception());
                }

            } catch (Exception e) {

                javax.swing.JOptionPane.showMessageDialog(this,
                    "Calls % must be a positive decimal\nwithin the range 0-100",
                    "Invalid input",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
                return false;

            }
        }

        if (jCheckBox5.isSelected()) {

            try {

                double n_rms = Double.parseDouble(jTextField4.getText());
                if (n_rms < 0 || n_rms != Math.ceil(n_rms)) {
                    throw (new Exception());
                }

            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(this,
                    "#Rms must be a positive integer",
                    "Invalid input",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
                return false;
            }

        }

        if (jCheckBox6.isSelected()) {

            try {

                double b_down = Double.parseDouble(jTextField5.getText());
                double b_up = Double.parseDouble(jTextField6.getText());

            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(this,
                    "b bound values must be valid",
                    "Invalid input",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
                return false;
            }

        }

        if (jCheckBox7.isSelected()) {

            try {

                double q = Double.parseDouble(jTextField7.getText());
                if (q < 0 || q > 1.0) {
                    throw (new Exception());
                }

            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(this,
                    "Fitting quality must be in the range [0, 1.0]",
                    "Invalid input",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
                return false;
            }

        }

        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox18;
    private javax.swing.JCheckBox jCheckBox19;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox20;
    private javax.swing.JCheckBox jCheckBox21;
    private javax.swing.JCheckBox jCheckBox22;
    private javax.swing.JCheckBox jCheckBox23;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
	private ArrayList<String> liblist = null;
    private boolean is_routine_table = true;
}
