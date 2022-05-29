/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.NhapDiem_DAL;
import java.sql.SQLException;
import java.util.ArrayList;

public class NhapDiem_BLL {
    NhapDiem_DAL dal = new NhapDiem_DAL();
     public ArrayList getAll(int khoathi)
     {
         return dal.getList(khoathi);
     }
     
     public ArrayList getListThiSinh(int phongthi)
     {
         return dal.getListThiSinh(phongthi);
     }
     
     public int getIDThiSinh( int khoathi , String sbd )
     {
         return dal.getIDThiSinh( khoathi , sbd);
     }
     
     public boolean updateDiemThi(int thisinh , double nghe , double noi , double doc , double viet , double trungbinh , String xeploai)
     {
         return dal.updateDiemThi(thisinh, nghe, noi, doc, viet, trungbinh ,xeploai);
     }
}
