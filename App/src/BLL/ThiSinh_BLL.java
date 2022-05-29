/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.ThiSinh_DAL;
import DTO.ThiSinh_DTO;
import java.util.ArrayList;

public class ThiSinh_BLL {
    ThiSinh_DAL tsd;
    public ThiSinh_BLL(){
        tsd = new ThiSinh_DAL();
    }
    public ArrayList<ThiSinh_DTO> getListThiSinh(){
        return tsd.getListThiSinh();
    }

    public void add(ThiSinh_DTO ts) {
        tsd.add(ts);
    }

    public ThiSinh_DTO getThiSinh(int idts) {
        return tsd.get(idts);
    }

    public void update(ThiSinh_DTO ts) {
        tsd.update(ts);
    }

    public void delete(int idts) {
        tsd.delete(idts);
    }

    public void xoakhoiDSPT(int idts) {
        tsd.xoakhoiDSPT(idts);
    }

    public void xoakhoiSBD(int idts) {
        tsd.xoakhoiSBD(idts);
    }

    public void xoakhoiKQT(int idts) {
        tsd.xoakhoiKQT(idts);
    }
}
