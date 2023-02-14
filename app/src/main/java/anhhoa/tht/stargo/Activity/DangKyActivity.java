package anhhoa.tht.stargo.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
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

public class DangKyActivity extends AppCompatActivity {
    Toolbar toolbardangky;
    EditText edttk,edtmk1,edtmk2;
    Button btndk,btnbhome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        Anhxa();
        btnbhome.setOnClickListener(v -> finish());
        if (CheckConnect.haveNetworkConnection(getApplicationContext())){
            ActionToolbar();
            EventButton();
        }else {
            CheckConnect.ShowToast_shor(getApplicationContext(),"Bạn Hãy Kiểm tra lại Kết Nối");
            finish();
        }
    }
    private void ActionToolbar() {
        setSupportActionBar(toolbardangky);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbardangky.setNavigationOnClickListener(v -> finish());
    }
    private void EventButton() {
        btndk.setOnClickListener(v -> {
            final String taikhoan = edttk.getText().toString().trim();
            final String matkhau = edtmk1.getText().toString().trim();
            if(taikhoan.length() >0 && matkhau.length() > 0){
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.duongdandangky, response -> {
                        CheckConnect.ShowToast_shor(getApplicationContext(),"Đăng Ký Thành Công");
                        Intent intent =  new Intent(getApplicationContext(),DangNhapActivity.class);
                        startActivity(intent);
                        CheckConnect.ShowToast_shor(getApplicationContext(),"Mời bạn đăng nhập");
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
                        hashMapp.put("jsondk",jsonArray.toString());
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
        toolbardangky = findViewById(R.id.toolbardangky);
        edttk = findViewById(R.id.edittexttk);
        edtmk1 = findViewById(R.id.edittextmk1);
        edtmk2 = findViewById(R.id.edittextmk2);
        btndk = findViewById(R.id.buttonDk);
        btnbhome = findViewById(R.id.buttonbackhome);
    }
}