/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.KetQuaThi_DTO;
import DTO.KhoaThi_DTO;
import DTO.PhongThi_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NhapDiem_DAL {
    Connection conn = new DBConnection().conn();

    public ArrayList<PhongThi_DTO> getList(int khoathi){
        ArrayList<PhongThi_DTO> list = new ArrayList<>();
        String where = "";
        if(khoathi == 0)
        {
            where = "1";
        }else
        {
            where = "IDKhoaThi=" +khoathi;
        }
        
        String sql = "SELECT * FROM phongthi WHERE "+where+" ORDER by CAST(SUBSTRING_INDEX(TenPhongThi,'_P',-1) AS UNSIGNED) ASC";

        //PreparedStatement ps = new DBConnectionUtil.connection.prepareStatement(sql);
        //PreparedStatement ps;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PhongThi_DTO pt = new PhongThi_DTO();
                //kt.setIDKhoaThi(rs.getInt("IDKhoaThi"));
                pt.setTenPhongThi(rs.getString("TenPhongThi"));
                pt.setIDPhongThi(rs.getInt("IDPhongThi"));
                //kt.setNgayThi(rs.getDate("NgayThi").toLocalDate());
                //t.setSoLuong(rs.getInt("SoLuong"));
                list.add(pt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoaThi_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public ArrayList<KetQuaThi_DTO> getListThiSinh(int phongthi ) {
        ArrayList<KetQuaThi_DTO> list = new ArrayList<>();
        
        
        String sql = "SELECT sobaodanh.SoBaoDanh , thisinh.Ho , thisinh.Ten , Nghe , Noi ,Doc , Viet "
                + "FROM ketquathi,thisinh,sobaodanh,danhsachphongthi,phongthi "
                + "WHERE ketquathi.IDThiSinh=thisinh.IDThiSinh AND ketquathi.IDThiSinh=sobaodanh.IDThiSinh "
                + "AND thisinh.IDThiSinh=danhsachphongthi.IDThiSinh AND phongthi.IDPhongThi=danhsachphongthi.IDPhongThi "
                + "AND phongthi.IDPhongThi='"+phongthi+"'";

        //PreparedStatement ps = new DBConnectionUtil.connection.prepareStatement(sql);
        //PreparedStatement ps;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KetQuaThi_DTO pt = new KetQuaThi_DTO();
                //kt.setIDKhoaThi(rs.getInt("IDKhoaThi"));
                pt.setSoBaoDanh(rs.getString("SoBaoDanh"));
                pt.setHo(rs.getString("Ho"));
                pt.setTen(rs.getString("Ten"));
                pt.setNghe(rs.getFloat("Nghe"));
                pt.setNoi(rs.getFloat("Noi"));
                pt.setDoc(rs.getFloat("Doc"));
                pt.setViet(rs.getFloat("Viet"));
                //kt.setNgayThi(rs.getDate("NgayThi").toLocalDate());
                //t.setSoLuong(rs.getInt("SoLuong"));
                list.add(pt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoaThi_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public int getIDThiSinh(int khoathi ,String sbd)
    {
        String sql = "SELECT sobaodanh.IDThiSinh FROM sobaodanh WHERE sobaodanh.SoBaoDanh='"+sbd+"' AND sobaodanh.IDKhoaThi="+khoathi+"";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("IDThiSinh");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(NhapDiem_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public boolean updateDiemThi(int thisinh , double nghe , double noi , double doc , double viet , double trungbinh , String xeploai)
    {
        String sql = "UPDATE ketquathi SET Nghe="+nghe+" , Noi="+noi+" , Doc="+doc+" , Viet="+viet+" , TrungBinh="+trungbinh+" , XepLoai='"+xeploai+"' "
        + "WHERE IDThiSinh="+thisinh+"";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(NhapDiem_DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
}
