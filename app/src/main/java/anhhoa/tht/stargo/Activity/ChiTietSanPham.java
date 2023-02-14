package anhhoa.tht.stargo.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.squareup.picasso.Picasso;
import java.text.DecimalFormat;
import java.util.Objects;

import anhhoa.tht.stargo.Model.Giohang;
import anhhoa.tht.stargo.Model.Sanpham;
import anhhoa.tht.stargo.R;

public class ChiTietSanPham extends AppCompatActivity {
    Toolbar toolbarCTSP;
    ImageView imageViewCTSP;
    TextView txttenCTSP,txtgiaCTSP,txtmotaCTSP;
    Spinner spinner;
    Button btndatmua;
    int ID;
    String Tensp;
    int Giasp;
    String Hinhsp;
    String Motasp;
    int Idloaisp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_san_pham);
        Anhxa();
        ActionToobar();
        GetInformation();
        CatchEvenSpinnner();
        EventButton();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menugiohang:
                Intent intent = new Intent(getApplicationContext(),GioHang.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void EventButton() {
        btndatmua.setOnClickListener(v -> {
            if(MainActivity.manggiohang.size() >0){
                int sl = Integer.parseInt(spinner.getSelectedItem().toString());
                boolean exists = false;
                for(int i = 0;i < MainActivity.manggiohang.size();i++){
                    if(MainActivity.manggiohang.get(i).getId() == ID){
                        MainActivity.manggiohang.get(i).setSoluongsp(MainActivity.manggiohang.get(i).getSoluongsp()+ sl);
                        if(MainActivity.manggiohang.get(i).getSoluongsp() >= 10){
                            MainActivity.manggiohang.get(i).setSoluongsp(10);
                        }
                        MainActivity.manggiohang.get(i).setGiasp(Giasp * MainActivity.manggiohang.get(i).getSoluongsp());
                        exists = true;
                    }
                }
                if(!exists){
                    int soluong =  Integer.parseInt(spinner.getSelectedItem().toString());
                    long giamoi = soluong * Giasp;
                    MainActivity.manggiohang.add(new Giohang(ID,Tensp,giamoi,Hinhsp,soluong));
                }
            }else {
                int soluong =  Integer.parseInt(spinner.getSelectedItem().toString());
                long giamoi = soluong * Giasp;
                MainActivity.manggiohang.add(new Giohang(ID,Tensp,giamoi,Hinhsp,soluong));
            }
            Intent intent = new Intent(getApplicationContext(),GioHang.class);
            startActivity(intent);
        });
    }

    private void ActionToobar() {
        setSupportActionBar(toolbarCTSP);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbarCTSP.setNavigationOnClickListener(v -> finish());
    }

    private void CatchEvenSpinnner() {
        Integer[] soluong = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, soluong);
        spinner.setAdapter(arrayAdapter);

    }

    @SuppressLint("SetTextI18n")
    private void GetInformation() {
        Sanpham sanpham = (Sanpham) getIntent().getSerializableExtra("Thongtinsanpham");
        ID = sanpham.getID();
        Tensp = sanpham.getTensp();
        Giasp = sanpham.getGiasp();
        Hinhsp = sanpham.getHinhsp();
        Motasp = sanpham.getMotasp();
        Idloaisp = sanpham.getIDloaisp();
        txttenCTSP.setText(Tensp);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txtgiaCTSP.setText("Giá : "+ decimalFormat.format(Giasp)+" Đ");
        txtmotaCTSP.setText(Motasp);
        Picasso.get().load(Hinhsp).placeholder(R.drawable.noimage).error(R.drawable.error).into(imageViewCTSP);

    }


    private void Anhxa() {
        toolbarCTSP = findViewById(R.id.toobarCTSP);
        imageViewCTSP = findViewById(R.id.imageCTSP);
        txttenCTSP = findViewById(R.id.textviewtenCTSP);
        txtgiaCTSP = findViewById(R.id.textviewgiaCTSP);
        txtmotaCTSP = findViewById(R.id.textviewmotaCTSP);
        spinner = findViewById(R.id.spinner);
        btndatmua = findViewById(R.id.buttondatmua);
    }

}