package anhhoa.tht.stargo.Model;

import java.io.Serializable;

public class Sanpham implements Serializable {
    public int ID;
    public String Tensp;
    public Integer Giasp;
    public String Hinhsp;
    public String Motasp;
    public int IDloaisp;

    public Sanpham(int ID, String tensp, Integer giasp, String hinhsp, String motasp, int IDloaisp) {
        this.ID = ID;
        Tensp = tensp;
        Giasp = giasp;
        Hinhsp = hinhsp;
        Motasp = motasp;
        this.IDloaisp = IDloaisp;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTensp() {
        return Tensp;
    }

    public void setTensp(String tensp) {
        Tensp = tensp;
    }

    public Integer getGiasp() {
        return Giasp;
    }

    public void setGiasp(Integer giasp) {
        Giasp = giasp;
    }

    public String getHinhsp() {
        return Hinhsp;
    }

    public void setHinhsp(String hinhsp) {
        Hinhsp = hinhsp;
    }

    public String getMotasp() {
        return Motasp;
    }

    public void setMotasp(String motasp) {
        Motasp = motasp;
    }

    public int getIDloaisp() {
        return IDloaisp;
    }

    public void setIDloaisp(int IDloaisp) {
        this.IDloaisp = IDloaisp;
    }
}
