/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BLL.KhoaThi_BLL;
import BLL.NhapDiem_BLL;
import DTO.KetQuaThi_DTO;
import DTO.KhoaThi_DTO;
import DTO.PhongThi_DTO;
import java.awt.event.ItemEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class NhapDiem extends javax.swing.JFrame {

    /**
     * Creates new form NhapDiem
     */
    DefaultTableModel model;

    public NhapDiem() throws SQLException {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Nhập điểm thí sinh");
        model = (DefaultTableModel) tbDiem.getModel();
        loadComboBox();
        loadCBPhongThi();
        loadTable();
    }

    public void loadComboBox() throws SQLException {
        ArrayList<KhoaThi_DTO> listkt = new ArrayList<>();

        listkt = new KhoaThi_BLL().getAll();

        //cbKhoaThi.addItem("Tất cả");
        for (KhoaThi_DTO kt : listkt) {
            cbKhoaThi.addItem(kt.getIDKhoaThi() + ":" + kt.getTenKhoaThi());
        }

    }

    public void loadCBPhongThi() throws SQLException {
        cbKhoaThi.addItemListener(event -> {
            // The item affected by the event.
            String item = (String) event.getItem();
            ArrayList<PhongThi_DTO> listpt = new ArrayList<>();
            //textArea.append("Affected items: " + item + "\n");
            if (event.getStateChange() == ItemEvent.SELECTED) {
                //textArea.append(item + " selected\n");
                if (!item.equalsIgnoreCase("--Chọn khóa thi--")) {
                    //try {
                    int khoathi = Integer.parseInt(String.valueOf(item.split(":")[0]));

                    listpt = new NhapDiem_BLL().getAll(khoathi);

//                    } catch (SQLException ex) {
//                        Logger.getLogger(NhapDiem.class.getName()).log(Level.SEVERE, null, ex);
//                    }
                    cbPhongThi.removeAllItems();
                    int dem = 0;
                    cbPhongThi.addItem("--Có " + listpt.size() + " Phòng--");
                    for (PhongThi_DTO pt : listpt) {
                        cbPhongThi.addItem(pt.getIDPhongThi()+":"+pt.getTenPhongThi());
                        dem++;
                    }
                } else {

                    cbPhongThi.removeAllItems();

                }

            }

            //JOptionPane.showMessageDialog(rootPane, dem);
//            cbPhongThi.setSelectedIndex(dem);
        });
    }

    public void loadTable() {

        cbPhongThi.addItemListener(event -> {

            // The item affected by the event.
            String item1 = (String) event.getItem();

            ArrayList<KetQuaThi_DTO> listpt = new ArrayList<>();
            //textArea.append("Affected items: " + item + "\n");
            if (event.getStateChange() == ItemEvent.SELECTED) {
                //textArea.append(item + " selected\n");
                if (item1.startsWith("--Có")) {

                    model.setRowCount(0);

                } else {
                    //try {
                    int idpt = Integer.parseInt(String.valueOf(cbPhongThi.getSelectedItem()).split(":")[0]);
//                    String item = String.valueOf(cbKhoaThi.getSelectedItem()).substring(0, 1);
                    //int khoathi = Integer.parseInt(item1.substring(0, 1));
                    //JOptionPane.showMessageDialog(rootPane, item + "  :  " + item1);
                    //listpt = new NhapDiem_BLL().getAll(khoathi);
                    listpt = new NhapDiem_BLL().getListThiSinh(idpt);
                    int dem = 1;
                    model.setRowCount(0);
                    for (KetQuaThi_DTO pt : listpt) {
                        model.addRow(new Object[]{dem++, pt.getSoBaoDanh(), pt.getHo(), pt.getTen(), pt.getNghe(), pt.getNoi(), pt.getDoc(), pt.getViet()});
                    }
                    //JOptionPane.showMessageDialog(rootPane, item1);

//                    } catch (SQLException ex) {
//                        Logger.getLogger(NhapDiem.class.getName()).log(Level.SEVERE, null, ex);
//                    }
                    //cbPhongThi.removeAllItems();
                }
            }
            //cbPhongThi.removeAllItems();

//            cbPhongThi.addItem("--Có " + dem + " Phòng--");
//            cbPhongThi.setSelectedIndex(dem);
        });
    }

    public double ktraDiem(String s) {
        try {
            double roundOff = 0;
            double num = Double.parseDouble(s);
            if (num < 0 || num > 10) {
                roundOff = -1;
            } else {
                roundOff = Math.round(num * 10.0) / 10.0;
            }
            return roundOff;

        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDiem = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btnLuu = new javax.swing.JButton();
        cbKhoaThi = new javax.swing.JComboBox<>();
        cbPhongThi = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/icons8-back-96 (1).png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel8MousePressed(evt);
            }
        });

        tbDiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "SBD", "Họ", "Tên", "Nghe", "Nói", "Đọc", "Viết"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbDiem.setRowHeight(30);
        tbDiem.setShowGrid(true);
        tbDiem.setShowVerticalLines(false);
        tbDiem.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbDiem);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 204));
        jLabel4.setText("NHẬP ĐIỂM THÍ SINH");

        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        cbKhoaThi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Chọn khóa thi--" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(198, 198, 198)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(cbKhoaThi, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(cbPhongThi, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 193, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuu)
                    .addComponent(cbKhoaThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPhongThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MousePressed
        // TODO add your handling code here:
        new Home().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel8MousePressed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        tbDiem.clearSelection();
    }//GEN-LAST:event_formMousePressed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
       // TODO add your handling code here:
        //JOptionPane.showMessageDialog(rootPane, new NhapDiem_BLL().getIDThiSinh("A2_1", 1));
        tbDiem.clearSelection();
        if (tbDiem.isEditing()) {

            tbDiem.getCellEditor().stopCellEditing();
        }

        //JOptionPane.showMessageDialog(rootPane, tbDiem.getValueAt(1, 4));
        //JOptionPane.showMessageDialog(rootPane, tbDiem.getRowCount());
        //String khoathi = String.valueOf(cbKhoaThi.getSelectedItem()).substring(0,1);
        //int khoathi = Integer.parseInt(String.valueOf(cbKhoaThi.getSelectedItem()).substring(0,1)) ;
        String item = String.valueOf(cbKhoaThi.getSelectedItem()).substring(0, 1);
        String item1 = String.valueOf(cbPhongThi.getSelectedItem());
        int loi = 0;
        for (int i = 0; i < tbDiem.getRowCount(); i++) {
            String sbd = String.valueOf(tbDiem.getValueAt(i, 1));
            String nghe = String.valueOf(tbDiem.getValueAt(i, 4));
            String noi = String.valueOf(tbDiem.getValueAt(i, 5));
            String doc = String.valueOf(tbDiem.getValueAt(i, 6));
            String viet = String.valueOf(tbDiem.getValueAt(i, 7));
            if (ktraDiem(nghe) == -1 || ktraDiem(noi) == -1 || ktraDiem(doc) == -1 || ktraDiem(viet) == -1) {
                JOptionPane.showMessageDialog(rootPane, "Nhập điểm không hợp lệ");
                loi++;
                break;
            }
//            JOptionPane.showMessageDialog(rootPane, nghe);
            //new NhapDiem_BLL().updateDiemThi(new NhapDiem_BLL().getIDThiSinh(Integer.parseInt(item), sbd), nghe, noi, doc, viet);
            //if()

        }

        if (loi == 0) {
            for (int i = 0; i < tbDiem.getRowCount(); i++) {
                String sbd = String.valueOf(tbDiem.getValueAt(i, 1));
                double nghe = ktraDiem(String.valueOf(tbDiem.getValueAt(i, 4)));
                double noi = ktraDiem(String.valueOf(tbDiem.getValueAt(i, 5)));
                double doc = ktraDiem(String.valueOf(tbDiem.getValueAt(i, 6)));
                double viet = ktraDiem(String.valueOf(tbDiem.getValueAt(i, 7)));
                double tb = ktraDiem(String.valueOf((nghe + noi + doc + viet) / 4));
                String xl = "";
                if (tb < 4) {
                    xl = "F";
                } else if (tb >= 4 && tb < 5.5) {
                    xl = "D";
                } else if (tb >= 5.5 && tb < 7) {
                    xl = "C";
                } else if (tb >= 7 && tb < 8.5) {
                    xl = "B";
                } else {
                    xl = "A";
                }
//            JOptionPane.showMessageDialog(rootPane, nghe);
                int idts = Integer.parseInt(String.valueOf(model.getValueAt(i, 1)).split("_")[1]);
                new NhapDiem_BLL().updateDiemThi(idts, nghe, noi, doc, viet, tb, xl);
                //if()

            }
        }

//        new NhapDiem_BLL().updateDiemThi(new NhapDiem_BLL().getIDThiSinh("A2_1", 1), 3, 3, 3, 3);
        ArrayList<KetQuaThi_DTO> listpt = new ArrayList<>();
        int idpt = Integer.parseInt(String.valueOf(cbPhongThi.getSelectedItem()).split(":")[0]);
        listpt = new NhapDiem_BLL().getListThiSinh(idpt);
        int dem = 1;
        model.setRowCount(0);
        for (KetQuaThi_DTO pt : listpt) {
            model.addRow(new Object[]{dem++, pt.getSoBaoDanh(), pt.getHo(), pt.getTen(), pt.getNghe(), pt.getNoi(), pt.getDoc(), pt.getViet()});
        }
        JOptionPane.showMessageDialog(rootPane, "Đã lưu");
    }//GEN-LAST:event_btnLuuActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(NhapDiem.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(NhapDiem.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(NhapDiem.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(NhapDiem.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new NhapDiem().setVisible(true);
//                    //System.out.println(ktraDiem("9.125"));
//                } catch (SQLException ex) {
//                    Logger.getLogger(NhapDiem.class
//                            .getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLuu;
    private javax.swing.JComboBox<String> cbKhoaThi;
    private javax.swing.JComboBox<String> cbPhongThi;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbDiem;
    // End of variables declaration//GEN-END:variables
}
