package anhhoa.tht.stargo.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ImageButton;
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
import anhhoa.tht.stargo.Adapter.TimkiemAdapter;
import anhhoa.tht.stargo.Model.Sanpham;
import anhhoa.tht.stargo.R;
import anhhoa.tht.stargo.Ultil.CheckConnect;
import anhhoa.tht.stargo.Ultil.Server;

public class TimKiemActivity extends AppCompatActivity {
    Toolbar toolbartk;
    ListView lvtk;
    EditText edttimkiem;
    ImageButton ibtntk;
    TimkiemAdapter timkiemAdapter;
    ArrayList<Sanpham> mangtimkiem;
    int page = 1;
    View fooderview;
    boolean isloading = false;
    boolean limitdata = false;
    DTHandler tkHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tim_kiem);
        Anhxa();
        if (CheckConnect.haveNetworkConnection(getApplicationContext())){
            ActionToolbar();
            GetData(page);
            LoadmoreData();
        }else {
            CheckConnect.ShowToast_shor(getApplicationContext(),"Bạn Hãy Kiểm tra lại Kết Nối");
            finish();
        }
    }

    private void LoadmoreData() {
        lvtk.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(getApplicationContext(),ChiTietSanPham.class);
            intent.putExtra("Thongtinsanpham",mangtimkiem.get(position));
            startActivity(intent);
        });
        lvtk.setOnScrollListener(new AbsListView.OnScrollListener() {
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
        ibtntk.setOnClickListener(v -> {
            String tukhoa = edttimkiem.getText().toString().trim();
            if(tukhoa.length() > 0){
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                String duongdan = Server.duongdantimkiem + Page;
                StringRequest stringRequest = new StringRequest(Request.Method.POST,duongdan, response -> {
                    int ID;
                    String Tensp;
                    int Giasp;
                    String Hinhsp;
                    String Motasp;
                    int Idloaisp;
                    if (response != null && response.length() != 2){
                        lvtk.removeFooterView(fooderview);
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
                                mangtimkiem.add(new Sanpham(ID,Tensp,Giasp,Hinhsp,Motasp,Idloaisp));
                                timkiemAdapter.notifyDataSetChanged();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }else {
                        limitdata = true;
                        lvtk.removeFooterView(fooderview);
                        CheckConnect.ShowToast_shor(getApplicationContext(),"Đã Hết Dữ Liệu");
                    }
                }, error -> {

                }){
                    @Override
                    public Map<String, String> getParams() {
                        HashMap<String, String> params = new HashMap<>();
                        params.put("tukhoa",tukhoa);
                        return params;
                    }
                };

                requestQueue.add(stringRequest);
            }else {
                CheckConnect.ShowToast_shor(getApplicationContext(),"Từ khóa không thể để trống ");
            }
        });
    }

    private void ActionToolbar() {
        setSupportActionBar(toolbartk);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbartk.setNavigationOnClickListener(v -> finish());
    }
    @SuppressLint("InflateParams")
    private void Anhxa() {
        toolbartk = findViewById(R.id.toolbartimkiem);
        lvtk = findViewById(R.id.listviewtimkiem);
        edttimkiem = findViewById(R.id.edittexttimkiem);
        ibtntk = findViewById(R.id.buttontimkiem);
        mangtimkiem = new ArrayList<>();
        timkiemAdapter = new TimkiemAdapter(getApplicationContext(),mangtimkiem);
        lvtk.setAdapter(timkiemAdapter);
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        fooderview = inflater.inflate(R.layout.progressbar, null);
        tkHandler = new DTHandler();
    }
    @SuppressLint("HandlerLeak")
    public class DTHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch(msg.what){
                case 0:
                    lvtk.addFooterView(fooderview);
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
            tkHandler.sendEmptyMessage(0);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message message = tkHandler.obtainMessage(1);
            tkHandler.sendMessage(message);
            super.run();
        }
    }
}