package anhhoa.tht.stargo.Model;

public class Loaisp {
    public int Id;
    public String Tenloaisp;
    public String Hinhloaisp;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTenloaisp() {
        return Tenloaisp;
    }

    public void setTenloaisp(String tenloaisp) {

        Tenloaisp = tenloaisp;
    }

    public String getHinhloaisp() {

        return Hinhloaisp;
    }

    public void setHinhloaisp(String hinhloaisp) {

        Hinhloaisp = hinhloaisp;
    }

    public Loaisp(int id, String tenloaisp, String hinhloaisp) {
        Id = id;
        Tenloaisp = tenloaisp;
        Hinhloaisp = hinhloaisp;
    }
}
