/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.TimKiem_DTO;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TimKiem_DAL {
    Connection conn = new DBConnection().conn();
    public ArrayList<TimKiem_DTO> getList(String s , String SDT){
        ArrayList<TimKiem_DTO> list = new ArrayList<>();
        
        String sql = "SELECT sobaodanh.SoBaoDanh , phongthi.TenPhongThi , phongthi.IDKhoaThi ,Nghe,Noi,Doc,Viet "
            + "FROM sobaodanh,thisinh,danhsachphongthi,ketquathi,phongthi "
            + "WHERE  ketquathi.IDThiSinh=sobaodanh.IDThiSinh AND thisinh.IDThiSinh=danhsachphongthi.IDThiSinh "
            + "AND danhsachphongthi.IDPhongThi=phongthi.IDPhongThi AND thisinh.IDThiSinh=ketquathi.IDThiSinh "
            + "AND CONCAT(thisinh.Ho,' ',thisinh.Ten)='"+s+"'  AND thisinh.SDT='"+SDT+"'";

        //PreparedStatement ps = new DBConnectionUtil.connection.prepareStatement(sql);
        //PreparedStatement ps;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TimKiem_DTO pt = new TimKiem_DTO();
                
                pt.setSBD(rs.getString("SoBaoDanh"));
                pt.setPhongThi(rs.getString("TenPhongThi"));
                pt.setKhoaThi(rs.getInt("IDKhoaThi"));
                pt.setNghe(rs.getDouble("Nghe"));
                pt.setNoi(rs.getDouble("Noi"));
                pt.setDoc(rs.getDouble("Doc"));
                pt.setViet(rs.getDouble("Viet"));
                list.add(pt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoaThi_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
