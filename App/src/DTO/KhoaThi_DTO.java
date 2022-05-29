/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.time.LocalDate;

public class KhoaThi_DTO {
    int IDKhoaThi ;
    String TenKhoaThi ;
    LocalDate NgayThi;

    public KhoaThi_DTO() {
    }
    

    public int getIDKhoaThi() {
        return IDKhoaThi;
    }

    public void setIDKhoaThi(int IDKhoaThi) {
        this.IDKhoaThi = IDKhoaThi;
    }

    public String getTenKhoaThi() {
        return TenKhoaThi;
    }

    public void setTenKhoaThi(String TenKhoaThi) {
        this.TenKhoaThi = TenKhoaThi;
    }

    public LocalDate getNgayThi() {
        return NgayThi;
    }

    public void setNgayThi(LocalDate NgayThi) {
        this.NgayThi = NgayThi;
    }
    
    
}
