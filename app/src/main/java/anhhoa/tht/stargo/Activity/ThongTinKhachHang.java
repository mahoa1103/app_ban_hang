package anhhoa.tht.stargo.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;
import anhhoa.tht.stargo.R;
import anhhoa.tht.stargo.Ultil.CheckConnect;
import anhhoa.tht.stargo.Ultil.Server;

public class ThongTinKhachHang extends AppCompatActivity {
    EditText edttenkhachhang,edtdiachi,edtsdt;
    Button btnxacnhan,btntrove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_khach_hang);
        Anhxa();
        btntrove.setOnClickListener(v -> finish());
        if (CheckConnect.haveNetworkConnection(getApplicationContext())){
            EventButton();
        }else {
            CheckConnect.ShowToast_shor(getApplicationContext(),"Bạn Hãy Kiểm tra lại Kết Nối");
            finish();
        }
    }

    private void EventButton() {
        btnxacnhan.setOnClickListener(v -> {
            final String tenKH = edttenkhachhang.getText().toString().trim();
            final String diachiKH = edtdiachi.getText().toString().trim();
            final String sdtKH = edtsdt.getText().toString().trim();
            if(tenKH.length()>0 && diachiKH.length()>0 && sdtKH.length()>0){
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.duongdanhoadon, responsehd -> {
                    Log.d("idhoadon",responsehd);
                    if(Integer.parseInt(responsehd) > 0 ){
                        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                        StringRequest request = new StringRequest(Request.Method.POST, Server.duongdanchitiethd, response -> {
                                MainActivity.manggiohang.clear();
                                CheckConnect.ShowToast_shor(getApplicationContext(),"Bạn Đã Đặt Hàng Thành Công");
                                Intent intent =  new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                                CheckConnect.ShowToast_shor(getApplicationContext(),"Mời bạn tiếp tục mua hàng");

                        }, error -> {

                        }){
                            @Override
                            protected Map<String, String> getParams() {
                                JSONArray jsonArray = new JSONArray();
                                for(int i = 0;i < MainActivity.manggiohang.size();i++){
                                    JSONObject jsonObject = new JSONObject();
                                    try {
                                        jsonObject.put("idhoadon",responsehd);
                                        jsonObject.put("idsp",MainActivity.manggiohang.get(i).getId());
                                        jsonObject.put("tensanpham",MainActivity.manggiohang.get(i).getTensp());
                                        jsonObject.put("soluong",MainActivity.manggiohang.get(i).getSoluongsp());
                                        jsonObject.put("giatien",MainActivity.manggiohang.get(i).getGiasp());
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    jsonArray.put(jsonObject);
                                }
                                HashMap<String, String> hashMapp = new HashMap<>();
                                hashMapp.put("json",jsonArray.toString());
                                return hashMapp;
                            }
                        };
                        queue.add(request);
                    }
                }, error -> {

                }){
                    @Override
                    protected Map<String, String> getParams() {
                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put("tenkhachhang",tenKH);
                        hashMap.put("diachi",diachiKH);
                        hashMap.put("sdt",sdtKH);
                        return hashMap;
                    }
                };
                requestQueue.add(stringRequest);
            }else {
                CheckConnect.ShowToast_shor(getApplicationContext(),"Hãy Kiểm Tra Lại Dữ Liệu");
            }
        });
    }

    private void Anhxa() {
        edttenkhachhang = findViewById(R.id.edittexttenKH);
        edtdiachi = findViewById(R.id.edittextdiachiKH);
        edtsdt = findViewById(R.id.edittextsdtKH);
        btnxacnhan = findViewById(R.id.buttonxacnhan);
        btntrove = findViewById(R.id.buttontrove);
    }
}