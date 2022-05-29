/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.TimKiem_DAL;
import java.util.ArrayList;

public class TimKiem_BLL {
    TimKiem_DAL dal = new TimKiem_DAL();
    
    public ArrayList getAll(String hoten ,String sdt)
    {
        return dal.getList(hoten, sdt);
    }
}
