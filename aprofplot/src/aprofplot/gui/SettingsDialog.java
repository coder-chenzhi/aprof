package aprofplot.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import aprofplot.*;
import java.awt.GridLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.event.*;

public class SettingsDialog extends javax.swing.JDialog {

    /**
     * Creates new form SettingsDialog
     */
    public SettingsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(450, 350);
        setLocationRelativeTo(parent);
        boolean blacklist_enabled = Main.getBlackListEnabled();
        jCheckBox1.setSelected(blacklist_enabled);
        jTextArea1.setEnabled(blacklist_enabled);
        java.util.ArrayList<String> blacklist = Main.getBlackList();
        for (int i = 0; i < blacklist.size(); i++) {
            jTextArea1.append(blacklist.get(i) + ", ");
        }

        if (Main.getRtnNameMode() == Main.RtnNameMode.DEMANGLED) {
            jRadioButton1.setSelected(true);
        } else {
            jRadioButton2.setSelected(true);
        }

        if (Main.getRtnCostMode() == Input.CostType.CUMULATIVE) {
            jRadioButton5.setSelected(true);
        } else {
            jRadioButton6.setSelected(true);
        }

        if (Main.getChartCostMode() == Input.CostType.CUMULATIVE) {
            jRadioButton7.setSelected(true);
        } else {
            jRadioButton8.setSelected(true);
        }

        jButton2.setEnabled(false);
        this.setResizable(false);
        jTextField1.setText(Main.getCtagsPath());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new ButtonGroup();
        buttonGroup2 = new ButtonGroup();
        buttonGroup3 = new ButtonGroup();
        jTabbedPane1 = new JTabbedPane();
        jPanel4 = new JPanel();
        jPanel7 = new JPanel();
        jRadioButton1 = new JRadioButton();
        jRadioButton2 = new JRadioButton();
        jPanel8 = new JPanel();
        jRadioButton5 = new JRadioButton();
        jRadioButton6 = new JRadioButton();
        jPanel9 = new JPanel();
        jRadioButton7 = new JRadioButton();
        jRadioButton8 = new JRadioButton();
        jPanel1 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jPanel3 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jCheckBox1 = new JCheckBox();
        jPanel5 = new JPanel();
        jPanel6 = new JPanel();
        jLabel3 = new JLabel();
        jTextField1 = new JTextField();
        jPanel2 = new JPanel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Settings");

        jTabbedPane1.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));

        jPanel4.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel4.setLayout(new GridLayout(3, 1));

        jPanel7.setBorder(BorderFactory.createTitledBorder("Routine naming policy"));
        jPanel7.setLayout(new BoxLayout(jPanel7, BoxLayout.Y_AXIS));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Show demangled names ");
        jRadioButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel7.add(jRadioButton1);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Show demangled names with full signature ");
        jRadioButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel7.add(jRadioButton2);

        jPanel4.add(jPanel7);

        jPanel8.setBorder(BorderFactory.createTitledBorder("Displayed cost in routine table"));
        jPanel8.setLayout(new BoxLayout(jPanel8, BoxLayout.Y_AXIS));

        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setText("Cumulative total cost");
        jRadioButton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });
        jPanel8.add(jRadioButton5);

        buttonGroup2.add(jRadioButton6);
        jRadioButton6.setText("Self total cost ");
        jRadioButton6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });
        jPanel8.add(jRadioButton6);

        jPanel4.add(jPanel8);
        jPanel8.getAccessibleContext().setAccessibleName("Displayed cost in routine table");

        jPanel9.setBorder(BorderFactory.createTitledBorder("Displayed cost in charts"));
        jPanel9.setLayout(new BoxLayout(jPanel9, BoxLayout.Y_AXIS));

        buttonGroup3.add(jRadioButton7);
        jRadioButton7.setText("Cumulative cost");
        jRadioButton7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jRadioButton7ActionPerformed(evt);
            }
        });
        jPanel9.add(jRadioButton7);

        buttonGroup3.add(jRadioButton8);
        jRadioButton8.setText("Self cost ");
        jRadioButton8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jRadioButton8ActionPerformed(evt);
            }
        });
        jPanel9.add(jRadioButton8);

        jPanel4.add(jPanel9);

        jTabbedPane1.addTab("Display", jPanel4);
        jPanel4.getAccessibleContext().setAccessibleName("");

        jPanel1.setLayout(new BorderLayout());

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                // text was changed
                jButton2.setEnabled(true);
            }
            public void removeUpdate(DocumentEvent e) {
                // text was deleted
                jButton2.setEnabled(true);
            }
            public void insertUpdate(DocumentEvent e) {
                // text was inserted
                jButton2.setEnabled(true);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, BorderLayout.CENTER);

        jPanel3.setLayout(new BoxLayout(jPanel3, BoxLayout.Y_AXIS));

        jLabel1.setText("Routines whose name is blacklisted won't be displayed.");
        jPanel3.add(jLabel1);

        jLabel2.setText("Entries must be comma-separated.");
        jPanel3.add(jLabel2);

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Enable routine blacklist");
        jCheckBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel3.add(jCheckBox1);

        jPanel1.add(jPanel3, BorderLayout.PAGE_START);

        jTabbedPane1.addTab("Routine blacklist", jPanel1);

        jPanel6.setLayout(new BoxLayout(jPanel6, BoxLayout.LINE_AXIS));

        jLabel3.setText("      ctags binary:   ");
        jPanel6.add(jLabel3);

        jTextField1.setMaximumSize(new Dimension(2147483647, 26));
        jTextField1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addInputMethodListener(new InputMethodListener() {
            public void caretPositionChanged(InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(InputMethodEvent evt) {
                jTextField1InputMethodTextChanged(evt);
            }
        });
        jTextField1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        jPanel6.add(jTextField1);

        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(Alignment.LEADING)
            .addComponent(jPanel6, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tools", jPanel5);

        getContentPane().add(jTabbedPane1, BorderLayout.CENTER);

        jPanel2.setBorder(BorderFactory.createEmptyBorder(2, 2, 4, 4));
        jPanel2.setLayout(new BoxLayout(jPanel2, BoxLayout.LINE_AXIS));

        jButton1.setText("   Ok   ");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(Box.createHorizontalGlue());
        jPanel2.add(jButton1);

        jButton2.setText(" Apply ");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        jButton3.setText("Cancel");
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);

        getContentPane().add(jPanel2, BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void save() {
        java.util.ArrayList<String> blacklist = new java.util.ArrayList<String>();
        String list = jTextArea1.getText().trim();
        if (!list.equals("")) {
            java.util.StringTokenizer tokenizer = new java.util.StringTokenizer(list, ",");
            while (tokenizer.hasMoreTokens()) {
                blacklist.add(tokenizer.nextToken().trim());
            }
        }
        if (jRadioButton1.isSelected()) {
            Main.setRtnNameMode(Main.RtnNameMode.DEMANGLED);
        } else {
            Main.setRtnNameMode(Main.RtnNameMode.DEMANGLED_FULL);
        }

        Input.CostType old_display_tcost = Main.getRtnCostMode();
        Input.CostType old_chart_cost = Main.getChartCostMode();

        if (jRadioButton5.isSelected()) {
            Main.setRtnCostMode(Input.CostType.CUMULATIVE);
        } else {
            Main.setRtnCostMode(Input.CostType.SELF);
        }

        if (jRadioButton7.isSelected()) {
            Main.setChartCostMode(Input.CostType.CUMULATIVE);
        } else {
            Main.setChartCostMode(Input.CostType.SELF);
        }

        boolean refresh_rt = false;

        if (old_display_tcost != Main.getRtnCostMode()) {
            ((MainWindow) getParent()).refreshRoutinesTable();
            refresh_rt = true;
        }

        if (old_chart_cost != Main.getChartCostMode()) {

            ((MainWindow) getParent()).refreshRoutine();
            ((MainWindow) getParent()).refreshRmsTable(false);
            if (!refresh_rt) {
                ((MainWindow) getParent()).refreshRoutinesTable();
            }
        }

        Main.setBlacklist(blacklist, jCheckBox1.isSelected());
        ((MainWindow) getParent()).refreshRoutinesTableFilter();

        if (!jTextField1.getText().equals("")) {
            Main.setCtagsPath(jTextField1.getText());
            ((MainWindow) getParent()).checkEditor();
        }

    }

	private void jCheckBox1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // Enable/disable blacklist checkbox
        jTextArea1.setEnabled(jCheckBox1.isSelected());
        jButton2.setEnabled(true);
	}//GEN-LAST:event_jCheckBox1ActionPerformed

	private void jButton3ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Cancel button
        this.dispose();
	}//GEN-LAST:event_jButton3ActionPerformed

	private void jButton2ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Apply button
        save();
        jButton2.setEnabled(false);
	}//GEN-LAST:event_jButton2ActionPerformed

	private void jButton1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Ok button
        if (jButton2.isEnabled()) {
            save();
        }
        this.dispose();
	}//GEN-LAST:event_jButton1ActionPerformed

	private void jRadioButton1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // demangled names
        jButton2.setEnabled(true);
	}//GEN-LAST:event_jRadioButton1ActionPerformed

	private void jRadioButton2ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // Full demangled names
        jButton2.setEnabled(true);
	}//GEN-LAST:event_jRadioButton2ActionPerformed

	private void jTextField1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        jButton2.setEnabled(true);
	}//GEN-LAST:event_jTextField1ActionPerformed

	private void jTextField1InputMethodTextChanged(InputMethodEvent evt) {//GEN-FIRST:event_jTextField1InputMethodTextChanged
        jButton2.setEnabled(true);
	}//GEN-LAST:event_jTextField1InputMethodTextChanged

	private void jTextField1KeyPressed(KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        jButton2.setEnabled(true);
	}//GEN-LAST:event_jTextField1KeyPressed

    private void jRadioButton5ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        jButton2.setEnabled(true);
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton6ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
        jButton2.setEnabled(true);
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jRadioButton7ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jRadioButton7ActionPerformed
        jButton2.setEnabled(true);
    }//GEN-LAST:event_jRadioButton7ActionPerformed

    private void jRadioButton8ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jRadioButton8ActionPerformed
        jButton2.setEnabled(true);
    }//GEN-LAST:event_jRadioButton8ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
    private ButtonGroup buttonGroup3;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JCheckBox jCheckBox1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JPanel jPanel9;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;
    private JRadioButton jRadioButton5;
    private JRadioButton jRadioButton6;
    private JRadioButton jRadioButton7;
    private JRadioButton jRadioButton8;
    private JScrollPane jScrollPane1;
    private JTabbedPane jTabbedPane1;
    private JTextArea jTextArea1;
    private JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}
