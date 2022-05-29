/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.PhongThi_DTO;
import DTO.SapXepPhongThi_DTO;
import DTO.ThiSinh_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhongThi_DAL {

    Connection conn = new DBConnection().conn();
    PreparedStatement ps;
    ResultSet rs;

    public PhongThi_DAL() {

    }

    public ArrayList<PhongThi_DTO> getDSPhongThi(int idkt) {
        ArrayList<PhongThi_DTO> list = new ArrayList<>();
        String sql = "select * from phongthi as TT where idkhoathi=? ORDER by CAST(SUBSTRING_INDEX(TenPhongThi,'_P',-1) AS UNSIGNED) ASC";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idkt);
            rs = ps.executeQuery();
            while (rs.next()) {
                PhongThi_DTO pt = new PhongThi_DTO();
                pt.setIDPhongThi(rs.getInt(1));
                pt.setTenPhongThi(rs.getString(2));
                pt.setIDKhoaThi(rs.getInt(3));
                pt.setTrinhDo(rs.getString(4));
                list.add(pt);
            }
        } catch (SQLException ex) {

        }
        return list;
    }

    public ArrayList<SapXepPhongThi_DTO> getDSTS(int idpt) {
        ArrayList<SapXepPhongThi_DTO> list = new ArrayList<>();
        String sql = "SELECT danhsachphongthi.IDThiSinh,sobaodanh.SoBaoDanh,thisinh.ho,thisinh.Ten \n"
                + "FROM danhsachphongthi,sobaodanh,thisinh\n"
                + "WHERE danhsachphongthi.IDThiSinh = sobaodanh.IDThiSinh AND thisinh.IDThiSinh = danhsachphongthi.IDThiSinh\n"
                + "and danhsachphongthi.IDPhongThi =?\n"
                + "ORDER BY thisinh.Ten ASC";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idpt);
            rs = ps.executeQuery();
            while (rs.next()) {
                SapXepPhongThi_DTO pt = new SapXepPhongThi_DTO();
                pt.setIdts(rs.getInt(1));
                pt.setSbd(rs.getString(2));
                pt.setHo(rs.getString(3));
                pt.setTen(rs.getString(4));
                list.add(pt);
            }
        } catch (SQLException ex) {

        }
        return list;
    }

    public void addPhongThi(String query) {
        try {
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhongThi_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(int idp) {
        try {
            String sql = "delete from phongthi where idphongthi=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idp);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhongThi_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<ThiSinh_DTO> DSThiSinh_ChuaCoPhong() {
        ArrayList<ThiSinh_DTO> list = new ArrayList<>();
        try {

            String sql = "SELECT * FROM thisinh \n"
                    + "where not EXISTS \n"
                    + "(select * FROM danhsachphongthi \n"
                    + "WHERE danhsachphongthi.IDThiSinh = thisinh.IDThiSinh) \n"
                    + "ORDER BY Ten ASC";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
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
            Logger.getLogger(PhongThi_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<ThiSinh_DTO> getDSTS_ChuaThemPhong(String trinhDo,int slts) {
        ArrayList<ThiSinh_DTO> list = new ArrayList<>();
        try {

            String sql = "SELECT * FROM thisinh \n"
                    + "where not EXISTS \n"
                    + "(select * FROM danhsachphongthi \n"
                    + "WHERE danhsachphongthi.IDThiSinh = thisinh.IDThiSinh) \n"
                    + "and TrinhDo = '"+trinhDo+"'\n"
                    + "ORDER BY Ten ASC LIMIT "+slts;
            
            ps = conn.prepareStatement(sql);
            
            rs = ps.executeQuery();
            while (rs.next()) {
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
            Logger.getLogger(PhongThi_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void ThemDSTS(int idphong, ArrayList<Integer> listIDTS) {
        try {
            String sql = "insert into danhsachphongthi values";
            for(Integer i:listIDTS){
                sql+="("+idphong+","+i+"),";
            }
            sql = sql.substring(0,sql.length()-1);
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhongThi_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void CapNhatSBD(int idKhoaThi, ArrayList<Integer> listIDTS,String trinhDo) {
        try {
            String sql = "insert into sobaodanh values";
            for(Integer i:listIDTS){
                String sbd = trinhDo+"_"+i;
                sql+="("+i+","+idKhoaThi+",'"+sbd+"'),";
            }
            sql = sql.substring(0,sql.length()-1);
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhongThi_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void CapNhatKQT(ArrayList<Integer> listIDTS, int idKhoaThi) {
        try {
            String sql = "insert into ketquathi values";
            for(Integer i:listIDTS){
                
                sql+="("+i+","+idKhoaThi+","+0+","+0+","+0+","+0+","+0+",'F'"+"),";
            }
            sql = sql.substring(0,sql.length()-1);
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
//            System.out.println(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PhongThi_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        new PhongThi_DAL().ResetKhoaThi(1);
    }
    public void ResetKhoaThi(int idkt){
        ResetKQT(idkt);
        ResetSBD(idkt);
        ResetPhongThi(idkt);
    }
    public void ResetKQT(int idkt) {
        try {
            String sql = "delete from ketquathi where idkhoathi=?";      
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idkt);
            ps.executeUpdate();
            System.out.println(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PhongThi_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ResetSBD(int idkt) {
        try {
            String sql = "delete from sobaodanh where idkhoathi=?";
            
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idkt);
            ps.executeUpdate();
            System.out.println(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PhongThi_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ResetPhongThi(int idkt) {
        try {
            String sql = "delete from danhsachphongthi where IDPhongThi in (select IDPhongThi FROM phongthi WHERE IDKhoaThi="+idkt+")";
            //ps.setInt(1, idkt);
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PhongThi_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void xoakhoiKQT(int idp) {
        try {
            String sql = "delete from ketquathi where idthisinh in (select idthisinh from danhsachphongthi where idphongthi='"+idp+"')";
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhongThi_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void xoakhoiDSPT(int idp) {
         try {
            String sql = "delete from danhsachphongthi where idphongthi ="+idp+" ";
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhongThi_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void xoakhoiSBD(int idp) {
      
        try {
            String sql = "delete from sobaodanh where idthisinh in(select idthisinh from danhsachphongthi where idphongthi="+idp+")";
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhongThi_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
   
}
