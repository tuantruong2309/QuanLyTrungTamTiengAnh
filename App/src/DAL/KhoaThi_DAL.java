/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.KhoaThi_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KhoaThi_DAL {
    Connection conn = new DBConnection().conn();

    public ArrayList<KhoaThi_DTO> getList() throws SQLException {
        ArrayList<KhoaThi_DTO> list = new ArrayList<>();

        String sql = "SELECT * FROM khoathi ";

        //PreparedStatement ps = new DBConnectionUtil.connection.prepareStatement(sql);
        //PreparedStatement ps;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhoaThi_DTO kt = new KhoaThi_DTO();
                kt.setIDKhoaThi(rs.getInt("IDKhoaThi"));
                kt.setTenKhoaThi(rs.getString("TenKhoaThi"));
                kt.setNgayThi(rs.getDate("NgayThi").toLocalDate());
                //t.setSoLuong(rs.getInt("SoLuong"));
                list.add(kt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoaThi_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public boolean themKhoaThi(String TenKhoaThi , LocalDate NgayThi)
    {
        String sql = "INSERT INTO khoathi(TenKhoaThi,NgayThi) VALUES(?,?) ";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd");
        
        try {
            PreparedStatement sm = conn.prepareStatement(sql);
            //sm.setString(1, t.getMaTour());
            sm.setString(1, TenKhoaThi);
            sm.setString(2, NgayThi.format(formatter));
            

            return sm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean suaKhoaThi(int IDKhoaThi , String TenKhoaThi , String NgayThi)
    {
        String sql = "UPDATE khoathi SET TenKhoaThi = '"+TenKhoaThi+"' , NgayThi = '"+NgayThi+"' WHERE IDKhoaThi = "+IDKhoaThi+" ";
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd");
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void xoaKhoaThi(int idkt) {
       xoaDSPT(idkt);
       xoaKQT(idkt);
       xoaSBD(idkt);
       xoaPT(idkt);
       xoaKT(idkt);
    }

    private void xoaKT(int idkt) {
        try {
            String sql = "delete from khoathi where idkhoathi="+idkt+"";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
                    } catch (SQLException ex) {
            Logger.getLogger(KhoaThi_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void xoaKQT(int idkt) {
         try {
            String sql = "delete from ketquathi where idkhoathi="+idkt+"";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
                    } catch (SQLException ex) {
            Logger.getLogger(KhoaThi_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void xoaSBD(int idkt) {
         try {
            String sql = "delete from sobaodanh where idkhoathi="+idkt+"";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
                    } catch (SQLException ex) {
            Logger.getLogger(KhoaThi_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void xoaPT(int idkt) {
         try {
            String sql = "delete from phongthi where idkhoathi="+idkt+"";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
                    } catch (SQLException ex) {
            Logger.getLogger(KhoaThi_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void xoaDSPT(int idkt) {
         try {
            String sql = "delete from danhsachphongthi where idphongthi in (select idphongthi from phongthi where idkhoathi="+idkt+")";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
                    } catch (SQLException ex) {
            Logger.getLogger(KhoaThi_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
