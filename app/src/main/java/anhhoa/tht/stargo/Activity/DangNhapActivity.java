package anhhoa.tht.stargo.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
import java.util.Objects;

import anhhoa.tht.stargo.R;
import anhhoa.tht.stargo.Ultil.CheckConnect;
import anhhoa.tht.stargo.Ultil.Server;

public class DangNhapActivity extends AppCompatActivity {
    Toolbar toolbarlogin;
    EditText edttaikhoan,edtmatkhau;
    Button btnlogin,btngohome,btndanky;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        Anhxa();
        btngohome.setOnClickListener(v -> finish());
        if (CheckConnect.haveNetworkConnection(getApplicationContext())){
            ActionToolbar();
            EventButton();
        }else {
            CheckConnect.ShowToast_shor(getApplicationContext(),"Bạn Hãy Kiểm tra lại Kết Nối");
            finish();
        }
    }
    private void ActionToolbar() {
        setSupportActionBar(toolbarlogin);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbarlogin.setNavigationOnClickListener(v -> finish());
    }
    private void EventButton() {
        btndanky.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),DangKyActivity.class);
            startActivity(intent);
        });
        btnlogin.setOnClickListener(v -> {
            final String taikhoan = edttaikhoan.getText().toString().trim();
            final String matkhau = edtmatkhau.getText().toString().trim();
            if(taikhoan.length() >0 && matkhau.length() > 0){
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.duongdandangnhap, response -> {
                    MainActivity.Username = taikhoan;
                    Intent intent =  new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    CheckConnect.ShowToast_shor(getApplicationContext(),"Đăng Nhập Thành Công");
                }, error -> {

                }){
                    @Override
                    protected Map<String, String> getParams() {
                        JSONArray jsonArray = new JSONArray();
                        JSONObject jsonObject = new JSONObject();
                        try {
                            jsonObject.put("taikhoan",taikhoan);
                            jsonObject.put("matkhau",matkhau);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        jsonArray.put(jsonObject);
                        HashMap<String, String> hashMapp = new HashMap<>();
                        hashMapp.put("json",jsonArray.toString());
                        return hashMapp;
                    }
                };
                requestQueue.add(stringRequest);
            }else {
                CheckConnect.ShowToast_shor(getApplicationContext(),"Tài khoản và Mật khẩu không được bỏ trống");
            }
        });
    }

    private void Anhxa() {
        toolbarlogin = findViewById(R.id.toolbarlogin);
        edttaikhoan = findViewById(R.id.edittexttaikhoan);
        edtmatkhau = findViewById(R.id.edittextmatkhau);
        btndanky = findViewById(R.id.buttondangky);
        btngohome = findViewById(R.id.buttongohome);
        btnlogin = findViewById(R.id.buttonlogin);
    }
}