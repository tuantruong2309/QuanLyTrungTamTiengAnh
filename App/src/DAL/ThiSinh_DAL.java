/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.ThiSinh_DTO;
import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThiSinh_DAL {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd");
    Connection conn = new DBConnection().conn();
    PreparedStatement ps;
    ResultSet rs;
    public ThiSinh_DAL(){
        
    }
    public ArrayList<ThiSinh_DTO> getListThiSinh(){
        ArrayList<ThiSinh_DTO> list = new ArrayList<>();
        String sql = "select * from thisinh";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                ThiSinh_DTO ts = new ThiSinh_DTO();
                ts.setIDThiSinh(rs.getInt(1));
                ts.setHo(rs.getString(2));
                ts.setTen(rs.getString(3));
                ts.setNgaySinh(rs.getDate(4).toLocalDate());
                ts.setGioiTinh(rs.getString(5));
                ts.setCMND(rs.getString(6));
                ts.setSDT(rs.getString(7));
                ts.setTrinhDo(rs.getString(8));
                list.add(ts);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThiSinh_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void add(ThiSinh_DTO ts) {
        String sql = "insert into thisinh(ho,ten,ngaysinh,gioitinh,cmnd,sdt,trinhdo) values(?,?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, ts.getHo());
            ps.setString(2, ts.getTen());
            ps.setString(3, ts.getNgaySinh().format(formatter));
            ps.setString(4, ts.getGioiTinh());
            ps.setString(5, ts.getCMND());
            ps.setString(6, ts.getSDT());
            ps.setString(7, ts.getTrinhDo());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ThiSinh_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public ThiSinh_DTO get(int idts) {
        ThiSinh_DTO ts = new ThiSinh_DTO();
        try {
            String sql = "select * from thisinh where idthisinh = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idts);
            rs = ps.executeQuery();
            while(rs.next()){
                ts.setIDThiSinh(rs.getInt(1));
                ts.setHo(rs.getString(2));
                ts.setTen(rs.getString(3));
                ts.setNgaySinh(rs.getDate(4).toLocalDate());
                ts.setGioiTinh(rs.getString(5));
                ts.setCMND(rs.getString(6));
                ts.setSDT(rs.getString(7));
                ts.setTrinhDo(rs.getString(8));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThiSinh_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ts;
    }

    public void update(ThiSinh_DTO ts) {
        String sql = "update thisinh set ho=?,ten=?,ngaysinh=?,gioitinh=?,cmnd=?,sdt=?,trinhdo=? where idthisinh=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, ts.getHo());
            ps.setString(2, ts.getTen());
            ps.setString(3, ts.getNgaySinh().format(formatter));
            ps.setString(4, ts.getGioiTinh());
            ps.setString(5, ts.getCMND());
            ps.setString(6, ts.getSDT());
            ps.setString(7, ts.getTrinhDo());
            ps.setInt(8, ts.getIDThiSinh());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ThiSinh_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(int idts) {
        try {
            String sql = "delete from thisinh where idthisinh="+idts+"";
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ThiSinh_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void xoakhoiDSPT(int idts) {
         try {
            String sql = "delete from danhsachphongthi where idthisinh="+idts+"";
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ThiSinh_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void xoakhoiSBD(int idts) {
         try {
            String sql = "delete from sobaodanh where idthisinh="+idts+"";
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ThiSinh_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void xoakhoiKQT(int idts) {
         try {
            String sql = "delete from ketquathi where idthisinh="+idts+"";
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ThiSinh_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
