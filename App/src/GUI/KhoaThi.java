/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BLL.KhoaThi_BLL;
import DTO.KhoaThi_DTO;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class KhoaThi extends javax.swing.JFrame {

    /**
     * Creates new form KhoaThi
     */
    DefaultTableModel model;
    ArrayList<KhoaThi_DTO> list = new ArrayList<>();
    KhoaThi_BLL kb = new KhoaThi_BLL();
    public KhoaThi() throws SQLException {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        model = (DefaultTableModel) tbKhoaThi.getModel();
        loadTable();
        setTitle("Quản lý khóa thi");
    }

    public void loadTable() throws SQLException {
        model.setRowCount(0);
        list = kb.getAll();
        for (KhoaThi_DTO kt : list) {

            model.addRow(new Object[]{kt.getIDKhoaThi(), kt.getTenKhoaThi(), kt.getNgayThi()});
        }
    }

    public void Reset() {
        txtIDKhoaThi.setText("");
        txtTenKhoaThi.setText("");
        txtNgayThi.setDate(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnXoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbKhoaThi = new javax.swing.JTable();
        btnSua = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIDKhoaThi = new javax.swing.JTextField();
        txtTenKhoaThi = new javax.swing.JTextField();
        txtNgayThi = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnXoa.setForeground(new java.awt.Color(255, 51, 51));
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        tbKhoaThi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khóa thi", "Tên khóa thi", "Ngày thi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbKhoaThi.setRowHeight(30);
        tbKhoaThi.setShowGrid(true);
        tbKhoaThi.setShowVerticalLines(false);
        tbKhoaThi.getTableHeader().setReorderingAllowed(false);
        tbKhoaThi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbKhoaThiMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbKhoaThi);

        btnSua.setText("Sửa");
        btnSua.setToolTipText("");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Mã khóa thi");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Tên khóa thi");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Ngày thi");

        txtIDKhoaThi.setEditable(false);

        txtTenKhoaThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKhoaThiActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 204));
        jLabel4.setText("QUẢN LÝ KHÓA THI");

        btnReset.setText("RESET");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/icons8-back-96 (1).png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel8MousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIDKhoaThi, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenKhoaThi, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayThi, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(663, 663, 663)
                                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(222, 222, 222)
                                .addComponent(jLabel4)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReset))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIDKhoaThi)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenKhoaThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(btnThem)
                                .addGap(18, 18, 18)
                                .addComponent(btnSua)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoa))
                            .addComponent(txtNgayThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenKhoaThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKhoaThiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKhoaThiActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        int i = tbKhoaThi.getSelectedRow();
        if (i < 0) {
            JOptionPane.showMessageDialog(rootPane, "Chọn dòng cần thực hiện");
        } else {
            if (txtTenKhoaThi.getText().isEmpty() || txtNgayThi.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Chưa nhập đủ thông tin");
            } //            else if(!InputValidatorUtil.isValidName(txtTenLoaiHinhDuLich.getText(), true).isEmpty()){
            //             JOptionPane.showMessageDialog(rootPane, "Tên loại hình du lịch không hợp lệ");
            //        }
            else {

                //DichVuDTO dv = new DichVuDTO();
                int ID = Integer.parseInt(String.valueOf(txtIDKhoaThi.getText()));
                String Ten = txtTenKhoaThi.getText();
                //String dateString = String.valueOf(txtNgayThi.getDate());
                //JOptionPane.showMessageDialog(rootPane, dateString);
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
                String strDate = dateFormat.format(txtNgayThi.getDate());  

                int conf = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn sửa KHÓA THI này ?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (conf == JOptionPane.YES_OPTION) {
                    if (new KhoaThi_BLL().suaKhoaThi(ID, Ten, strDate)) {
                        try {
                            JOptionPane.showMessageDialog(rootPane, "Sửa thành công");
                            Reset();
                            loadTable();
                        } catch (SQLException ex) {
                            Logger.getLogger(KhoaThi.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "ERROR");
                    }
                }
            }
        }

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        Reset();

    }//GEN-LAST:event_btnResetActionPerformed

    private void jLabel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MousePressed
        // TODO add your handling code here:
        new Home().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel8MousePressed

    private void tbKhoaThiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKhoaThiMousePressed
        // TODO add your handling code here:
        int i = tbKhoaThi.getSelectedRow();
        if (i >= 0) {
            txtIDKhoaThi.setText(String.valueOf(model.getValueAt(i, 0)));
            txtTenKhoaThi.setText(String.valueOf(model.getValueAt(i, 1)));
            String date = String.valueOf(model.getValueAt(i, 2));
            Date date1;
            try {
                date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
                txtNgayThi.setDate(date1);
            } catch (ParseException ex) {
                Logger.getLogger(KhoaThi.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_tbKhoaThiMousePressed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if(txtIDKhoaThi.getText().isEmpty())
        {
           if (txtTenKhoaThi.getText().isEmpty() || txtNgayThi.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Chưa điền đầy đủ thông tin");
        } else {
            String ten = txtTenKhoaThi.getText();
            LocalDate ngaythi = txtNgayThi.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            //Date date = Date.from(ngaythi.atStartOfDay(ZoneId.systemDefault()).toInstant());
            if (new KhoaThi_BLL().themKhoaThi(ten, ngaythi)) {
                try {
                    JOptionPane.showMessageDialog(rootPane, "Thêm thành công !");
                    loadTable();
                    Reset();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoaThi.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Thêm thất bại...");
            }
            //JOptionPane.showMessageDialog(rootPane, date);
        } 
        }else {
            JOptionPane.showMessageDialog(rootPane, "Trùng ID Khóa Thi");
            Reset();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int i = tbKhoaThi.getSelectedRow();
        if (i < 0) {
            JOptionPane.showMessageDialog(rootPane, "Chọn khóa thi cần xóa");
        } else{
            int idkt = (int)tbKhoaThi.getValueAt(i, 0);
             int conf = JOptionPane.showConfirmDialog(rootPane, "Xác nhận xóa khóa thi ?", "Thông báo !!!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (conf == JOptionPane.YES_OPTION) {
               kb.xoa(idkt);
                try {
                    loadTable();
                } catch (SQLException ex) {
                    Logger.getLogger(KhoaThi.class.getName()).log(Level.SEVERE, null, ex);
                }
                Reset();
               JOptionPane.showMessageDialog(rootPane, "Đã xóa");
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

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
//            java.util.logging.Logger.getLogger(KhoaThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(KhoaThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(KhoaThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(KhoaThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new KhoaThi().setVisible(true);
//                } catch (SQLException ex) {
//                    Logger.getLogger(KhoaThi.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbKhoaThi;
    private javax.swing.JTextField txtIDKhoaThi;
    private com.toedter.calendar.JDateChooser txtNgayThi;
    private javax.swing.JTextField txtTenKhoaThi;
    // End of variables declaration//GEN-END:variables
}
