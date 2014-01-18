package testes;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractListModel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.UIManager;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Dvr
 */
public class DefaultTable extends javax.swing.JFrame {

    private ListModel lm;

    public DefaultTable() {
        initComponents();
        addHeadLine();
    }

    private void addHeadLine() {
        lm = new AbstractListModel() {

            String headers[] = {
                "00:00",
                "00:30",
                "01:00",
                "01:30",
                "02:00",
                "02:30",
                "03:00",
                "03:30",
                "04:00",
                "04:30",
                "05:00",
                "05:30",
                "06:00",
                "06:30",
                "07:00",
                "07:30",
                "08:00",
                "08:30",
                "09:00",
                "09:30",
                "10:00",
                "10:30",
                "11:00",
                "11:30",
                "12:00",
                "12:30",
                "13:00",
                "13:30",
                "14:00",
                "14:30",
                "15:00",
                "15:30",
                "16:00",
                "16:30",
                "17:00",
                "17:30",
                "18:00",
                "18:30",
                "19:00",
                "19:30",
                "20:00",
                "20:30",
                "21:00",
                "21:30",
                "22:00",
                "22:30",
                "23:00",
                "23:30",};

            public int getSize() {
                return headers.length;
            }

            public Object getElementAt(int index) {
                return headers[index];
            }
        };

        JList rowHeader = new JList(lm);
        rowHeader.setFixedCellWidth(50);

        rowHeader.setFixedCellHeight(16);
        //                           + table.getIntercellSpacing().height);
        rowHeader.setCellRenderer(new RowHeaderRenderer(tbTime));

        jScrollPane1.setRowHeaderView(rowHeader);

        tbTime.getTableHeader().addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                JTableHeader header = (JTableHeader) e.getSource();
                String identifier = tbTime.getColumnName(header.columnAtPoint(e.getPoint()));

                int col = tbTime.getColumn(identifier).getModelIndex();
                int row = tbTime.getRowCount();

                for (int i = 0; i < row; i++) {
                    if (tbTime.getValueAt(i, col).equals(true)) {
                        tbTime.setValueAt(false, i, col);
                    } else {
                        tbTime.setValueAt(true, i, col);
                    }
                    tbTimeMouseClicked(e);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbTime = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        tbTime.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false},
                {false, false, false, false, false, false, false}
            },
            new String [] {
                "Domingo", "Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta-Feira", "Sábado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbTime.setCellSelectionEnabled(true);
        tbTime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTimeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbTime);

        jButton1.setText("Mostrar itens selecionados");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
                    .addComponent(jButton1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    int col = 7;
    int row = tbTime.getRowCount();

    for (int c = 0; c < col; c++) {
        for (int r = 0; r < row; r++) {
            Boolean selected = (Boolean) tbTime.getValueAt(r, c);
            if (selected) {
                System.out.println(tbTime.getColumnName(c));
                System.out.println(lm.getElementAt(r));
            }
        }
    }
}//GEN-LAST:event_jButton1ActionPerformed

private void tbTimeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTimeMouseClicked
    int col = 7;
    int row = 48;

    for (int c = 0; c < col; c++) {
        for (int r = 0; r < row; r++) {
            Boolean selected = (Boolean) tbTime.getValueAt(r, c);
            if (selected) {
                TableColumn column = tbTime.getColumn(tbTime.getColumnName(c));
                column.setCellRenderer(new CheckBoxRenderer());
            }
        }
    }
}//GEN-LAST:event_tbTimeMouseClicked

    private class CheckBoxRenderer extends JCheckBox implements TableCellRenderer {

        CheckBoxRenderer() {
            setHorizontalAlignment(JLabel.CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            if (((Boolean) value) == true) {
                setBackground(Color.ORANGE);
            } else {
                setBackground(table.getBackground());
            }
            setSelected((value != null && ((Boolean) value).booleanValue()));
            return this;
        }
    }

    class RowHeaderRenderer extends JLabel implements ListCellRenderer {

        RowHeaderRenderer(JTable table) {
            JTableHeader header = table.getTableHeader();
            setOpaque(true);
            setBorder(UIManager.getBorder("TableHeader.cellBorder"));
            setHorizontalAlignment(CENTER);
            setForeground(header.getForeground());
            setBackground(header.getBackground());
            setFont(header.getFont());
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean cellHasFocus) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DefaultTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DefaultTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DefaultTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DefaultTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new DefaultTable().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbTime;
    // End of variables declaration//GEN-END:variables
}
