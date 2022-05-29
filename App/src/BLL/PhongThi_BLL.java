/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.PhongThi_DAL;
import DTO.PhongThi_DTO;
import DTO.SapXepPhongThi_DTO;
import DTO.ThiSinh_DTO;
import java.util.ArrayList;

public class PhongThi_BLL {
    PhongThi_DAL pt = new PhongThi_DAL();

    public ArrayList<PhongThi_DTO> getDSPhongThi(int idkt) {
        return pt.getDSPhongThi(idkt);
    }

    public void addPhongThi(String query) {
        pt.addPhongThi(query);
    }

    public void delete(int idp) {
        pt.delete(idp);
    }
    public ArrayList<SapXepPhongThi_DTO> getDSTS(int idpt){
        return pt.getDSTS(idpt);
    }
    public ArrayList<ThiSinh_DTO> DSThiSinh_ChuaCoPhong(){
        return pt.DSThiSinh_ChuaCoPhong();
    }

    public ArrayList<ThiSinh_DTO> getDSTS_ChuaThemPhong(String trinhDo,int slts) {
        return pt.getDSTS_ChuaThemPhong(trinhDo,slts);
    }

    public void ThemDSTS(int idphong, ArrayList<Integer> listIDTS) {
        pt.ThemDSTS(idphong,listIDTS);
    }

    public void CapNhatSBD(int idKhoaThi, ArrayList<Integer> listIDTS,String trinhDo) {
        pt.CapNhatSBD(idKhoaThi,listIDTS,trinhDo);
    }

    public void CapNhatKQT(ArrayList<Integer> listIDTS, int idKhoaThi) {
        pt.CapNhatKQT(listIDTS,idKhoaThi);
    }

    public void ResetKhoaThi(int idkt) {
        pt.ResetKhoaThi(idkt);
    }

    public void xoakhoiKQT(int idp) {
        pt.xoakhoiKQT(idp);
    }

    public void xoakhoiDSPT(int idp) {
        pt.xoakhoiDSPT(idp);
    }

    public void xoakhoiSBD(int idp) {
        pt.xoakhoiSBD(idp);
    }
}
