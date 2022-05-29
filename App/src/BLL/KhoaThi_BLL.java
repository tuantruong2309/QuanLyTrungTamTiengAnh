/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.KhoaThi_DAL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class KhoaThi_BLL {
    KhoaThi_DAL dal = new KhoaThi_DAL();
    
    public ArrayList getAll() throws SQLException
    {
        return dal.getList();
    }
    
    public boolean themKhoaThi(String tenKhoaThi , LocalDate NgayThi)
    {
        return dal.themKhoaThi(tenKhoaThi, NgayThi);
    }
    
    public boolean suaKhoaThi(int IDKhoaThi , String tenKhoaThi , String NgayThi)
    {
        return dal.suaKhoaThi(IDKhoaThi , tenKhoaThi, NgayThi);
    }

    public void xoa(int idkt) {
        dal.xoaKhoaThi(idkt);
    }
}
