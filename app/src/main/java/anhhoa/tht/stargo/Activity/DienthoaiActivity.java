package anhhoa.tht.stargo.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import anhhoa.tht.stargo.Adapter.DienThoaiAdapter;
import anhhoa.tht.stargo.Model.Sanpham;
import anhhoa.tht.stargo.R;
import anhhoa.tht.stargo.Ultil.CheckConnect;
import anhhoa.tht.stargo.Ultil.Server;

public class DienthoaiActivity extends AppCompatActivity {
    Toolbar toolbardt ;
    ListView lvdt;
    DienThoaiAdapter dienThoaiAdapter;
    ArrayList<Sanpham> mangdt;
    int iddt = 0;
    int page = 1;
    View fooderview;
    boolean isloading = false;
    boolean limitdata = false;
    DTHandler dtHandler;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dienthoai);
        Anhxa();
        if (CheckConnect.haveNetworkConnection(getApplicationContext())){
            GetIdloaisp();
            ActionToolbar();
            GetData(page);
            LoadmoreData();
        }else {
            CheckConnect.ShowToast_shor(getApplicationContext(),"Bạn Hãy Kiểm tra lại Kết Nối");
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menugiohang) {
            Intent intent = new Intent(getApplicationContext(), GioHang.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void LoadmoreData() {
        lvdt.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(getApplicationContext(),ChiTietSanPham.class);
            intent.putExtra("Thongtinsanpham",mangdt.get(position));
            startActivity(intent);
        });
        lvdt.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if(firstVisibleItem+visibleItemCount == totalItemCount && totalItemCount != 0 && !isloading && !limitdata){
                    isloading = true;
                    ThreadData threadData = new ThreadData();
                    threadData.start();
                }
            }
        });
    }

    private void GetData(int Page) {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String duongdan = Server.duongdansanpham + Page;
        StringRequest stringRequest = new StringRequest(Request.Method.POST,duongdan, response -> {
            int ID;
            String Tensp;
            int Giasp;
            String Hinhsp;
            String Motasp;
            int Idloaisp;
            if (response != null && response.length() != 2){
                lvdt.removeFooterView(fooderview);
                JSONArray jsonArray;
                try {
                    jsonArray = new JSONArray(response);
                    for(int i =0; i < jsonArray.length();i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        ID = jsonObject.getInt("id");
                        Tensp = jsonObject.getString("tensp");
                        Giasp = jsonObject.getInt("giasp");
                        Hinhsp = jsonObject.getString("hinhsp");
                        Motasp = jsonObject.getString("motasp");
                        Idloaisp = jsonObject.getInt("idloaisp");
                        mangdt.add(new Sanpham(ID,Tensp,Giasp,Hinhsp,Motasp,Idloaisp));
                        dienThoaiAdapter.notifyDataSetChanged();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }else {
                limitdata = true;
                lvdt.removeFooterView(fooderview);
                CheckConnect.ShowToast_shor(getApplicationContext(),"Đã Hết Dữ Liệu");
            }
        }, error -> {

        }){
            @Override
            public Map<String, String> getParams() {
                HashMap<String, String> params = new HashMap<>();
                params.put("idloaisp",String.valueOf(iddt));
                return params;
            }
        };

        requestQueue.add(stringRequest);
    }

    private void ActionToolbar() {
        setSupportActionBar(toolbardt);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbardt.setNavigationOnClickListener(v -> finish());
    }

    private void GetIdloaisp() {
        iddt = getIntent().getIntExtra("idloaisp",-1);
        Log.d("giatriloaisp",iddt+"");
    }

    @SuppressLint("InflateParams")
    private void Anhxa() {
        toolbardt = findViewById(R.id.toobardienthoai);
        lvdt = findViewById(R.id.listviewdienthoai);
        mangdt = new ArrayList<>();
        dienThoaiAdapter = new DienThoaiAdapter(getApplicationContext(),mangdt);
        lvdt.setAdapter(dienThoaiAdapter);
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        fooderview = inflater.inflate(R.layout.progressbar, null);
        dtHandler = new DTHandler();
    }
    @SuppressLint("HandlerLeak")
    public class DTHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch(msg.what){
                case 0:
                    lvdt.addFooterView(fooderview);
                    break;
                case 1:
                    GetData(++page);
                    isloading = false;
                    break;
            }
            super.handleMessage(msg);
        }
    }
    public class ThreadData extends Thread{
        @Override
        public void run() {
            dtHandler.sendEmptyMessage(0);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message message = dtHandler.obtainMessage(1);
            dtHandler.sendMessage(message);
            super.run();
        }
    }
}