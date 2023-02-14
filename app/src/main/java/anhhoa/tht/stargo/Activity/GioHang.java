package anhhoa.tht.stargo.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.util.Objects;
import anhhoa.tht.stargo.Adapter.GioHangAdapter;
import anhhoa.tht.stargo.R;
import anhhoa.tht.stargo.Ultil.CheckConnect;

public class GioHang extends AppCompatActivity {
    ListView lvgiohang;
    TextView txtthongbao;
    static TextView txttongtien;
    Button btnthanhtoan,btntieptucmua;
    Toolbar toolbargiohang;
    GioHangAdapter gioHangAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);
        Anhxa();
        ActionToolbar();
        CheckData();
        EventUtil();
        CartOnItiemListView();
        EventButton();
    }

    private void EventButton() {
        btntieptucmua.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        });
        btnthanhtoan.setOnClickListener(v -> {
            if(MainActivity.manggiohang.size() > 0){
                Intent intent = new Intent(getApplicationContext(),ThongTinKhachHang.class);
                startActivity(intent);
            }else {
                CheckConnect.ShowToast_shor(getApplicationContext(),"Giỏ Hàng Của Bạn Đang Trống");
            }
        });
    }

    private void CartOnItiemListView() {
        lvgiohang.setOnItemLongClickListener((parent, view, position, id) -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(GioHang.this);
            builder.setTitle("Xác Nhận Xóa Sản Phẩm");
            builder.setMessage("Bạn Có Chắc Muốn Xóa Sản Phẩm Này");
            builder.setPositiveButton("Có", (dialog, which) -> {
                if (MainActivity.manggiohang.size() <= 0){
                    txtthongbao.setVisibility(View.VISIBLE);
                }else {
                    MainActivity.manggiohang.remove(position);
                    gioHangAdapter.notifyDataSetChanged();
                    EventUtil();
                    if (MainActivity.manggiohang.size() <= 0){
                        txtthongbao.setVisibility(View.VISIBLE);
                    }else {
                        txtthongbao.setVisibility(View.INVISIBLE);
                        gioHangAdapter.notifyDataSetChanged();
                        EventUtil();
                    }
                }
            });
            builder.setNegativeButton("Không", (dialog, which) -> {
                gioHangAdapter.notifyDataSetChanged();
                EventUtil();
            });
            builder.show();
            return true;
        });
    }

    @SuppressLint("SetTextI18n")
    public static void EventUtil() {
        long tongtien = 0;
        for(int i = 0; i < MainActivity.manggiohang.size();i++){
            tongtien += MainActivity.manggiohang.get(i).getGiasp();
        }
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txttongtien.setText(decimalFormat.format(tongtien) + "Đ");
    }

    private void CheckData() {
        if(MainActivity.manggiohang.size() <=0){
            gioHangAdapter.notifyDataSetChanged();
            txtthongbao.setVisibility(View.VISIBLE);
            lvgiohang.setVisibility(View.INVISIBLE);
        }else {
            gioHangAdapter.notifyDataSetChanged();
            txtthongbao.setVisibility(View.INVISIBLE);
            lvgiohang.setVisibility(View.VISIBLE);
        }
    }

    private void ActionToolbar() {
        setSupportActionBar(toolbargiohang);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbargiohang.setNavigationOnClickListener(v -> finish());
    }

    private void Anhxa() {
        lvgiohang = findViewById(R.id.listviewgiohang);
        txtthongbao = findViewById(R.id.textviewthongbao);
        txttongtien = findViewById(R.id.textviewtongtien);
        btnthanhtoan = findViewById(R.id.buttonthanhtoan);
        btntieptucmua = findViewById(R.id.buttontieptucmuahang);
        toolbargiohang = findViewById(R.id.toolbargiohang);
        gioHangAdapter = new GioHangAdapter(GioHang.this,MainActivity.manggiohang);
        lvgiohang.setAdapter(gioHangAdapter);
    }
}