/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BLL.KhoaThi_BLL;
import BLL.PhongThi_BLL;
import DTO.KhoaThi_DTO;
import DTO.PhongThi_DTO;
import DTO.ThiSinh_DTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class popupXepPT extends javax.swing.JFrame {

    PhongThi_BLL pb = new PhongThi_BLL();
    KhoaThi_BLL kb = new KhoaThi_BLL();

    public popupXepPT() {
        initComponents();
        setLocationRelativeTo(rootPane);
        setResizable(false);
        setComboKhoaThi();
        setTitle("Sắp xếp tự động");
    }

    public void setComboKhoaThi() {

        try {
            ArrayList<KhoaThi_DTO> list = kb.getAll();
            for (KhoaThi_DTO k : list) {
                cbKhoaThi.addItem(k.getIDKhoaThi() + ":" + k.getTenKhoaThi());

            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongThi.class.getName()).log(Level.SEVERE, null, ex);
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

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbKhoaThi = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtSL = new javax.swing.JTextField();

        jButton1.setText("Đồng ý");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Sắp xếp các thí sinh sau vào khóa");

        cbKhoaThi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Chọn khóa thi--" }));

        jLabel2.setText("Số lượng thí sinh / phòng (tối đa 35)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbKhoaThi, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbKhoaThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean ok = false;
        int slts = 0;
        try {
            slts= Integer.parseInt(txtSL.getText());
            if(slts>=1&&slts<=35){
                ok=true;
            }
            
        } catch (NumberFormatException ex) {
           
        }
        if (cbKhoaThi.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn khóa thi trước !");
        } 
        else if((!ok)){
             JOptionPane.showMessageDialog(rootPane, "Số lượng thí sinh không hợp lệ");
        }
        else {
            int conf = JOptionPane.showConfirmDialog(rootPane, "Lưu ý, việc sắp xếp sẽ reset phần điểm của thí sinh trong khóa đó . Tiếp tục ?", "Sắp xếp phòng thi ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (conf == JOptionPane.YES_OPTION) {
                int idkt = Integer.parseInt(String.valueOf(cbKhoaThi.getSelectedItem()).split(":")[0]);
                SapXepThiSinh(idkt,slts);
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed
    public void SapXepThiSinh(int idkt,int slts) {

        pb.ResetKhoaThi(idkt);
        String s = "";
        ArrayList<PhongThi_DTO> list = pb.getDSPhongThi(idkt);
        ArrayList<PhongThi_DTO> listA2 = new ArrayList<>();
        ArrayList<PhongThi_DTO> listB1 = new ArrayList<>();
        for (PhongThi_DTO pt : list) {
            if (pt.getTrinhDo().equals("A2")) {
                listA2.add(pt);
            } else {
                listB1.add(pt);
            }
        }
        /////Xu ly A2
        for (PhongThi_DTO pt : listA2) {
            s += pt.getTenPhongThi() + "\n";
            ArrayList<ThiSinh_DTO> listTS = pb.getDSTS_ChuaThemPhong("A2",slts);
            if (listTS.size() == 0) {
                break;
            }

            ArrayList<Integer> listIDTS = new ArrayList<>();
            int idphong = pt.getIDPhongThi();
            for (ThiSinh_DTO t : listTS) {
                listIDTS.add(t.getIDThiSinh());
            }
            pb.ThemDSTS(idphong, listIDTS);
            pb.CapNhatSBD(pt.getIDKhoaThi(), listIDTS, "A2");
            pb.CapNhatKQT(listIDTS, pt.getIDKhoaThi());

        }
        /////Xu ly A2
        for (PhongThi_DTO pt : listB1) {
            s += pt.getTenPhongThi() + "\n";
            ArrayList<ThiSinh_DTO> listTS = pb.getDSTS_ChuaThemPhong("B1",slts);
            if (listTS.size() == 0) {
                break;
            }

            ArrayList<Integer> listIDTS = new ArrayList<>();
            int idphong = pt.getIDPhongThi();
            for (ThiSinh_DTO t : listTS) {
                listIDTS.add(t.getIDThiSinh());
            }
            pb.ThemDSTS(idphong, listIDTS);
            pb.CapNhatSBD(pt.getIDKhoaThi(), listIDTS, "B1");
            pb.CapNhatKQT(listIDTS, pt.getIDKhoaThi());

        }
        //System.out.println(s);
        JOptionPane.showMessageDialog(rootPane, "Đã sắp xếp");
        dispose();
    }
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
//            java.util.logging.Logger.getLogger(popupXepPT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(popupXepPT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(popupXepPT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(popupXepPT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new popupXepPT().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbKhoaThi;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtSL;
    // End of variables declaration//GEN-END:variables
}