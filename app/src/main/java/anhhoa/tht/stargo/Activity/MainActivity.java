package anhhoa.tht.stargo.Activity;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

import anhhoa.tht.stargo.Adapter.LoaispAdapter;
import anhhoa.tht.stargo.Adapter.SanphamAdapter;
import anhhoa.tht.stargo.Model.Giohang;
import anhhoa.tht.stargo.Model.Loaisp;
import anhhoa.tht.stargo.Model.Sanpham;
import anhhoa.tht.stargo.R;
import anhhoa.tht.stargo.Ultil.CheckConnect;
import anhhoa.tht.stargo.Ultil.Server;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerView;
    NavigationView navigationView;
    ListView listviewindex;
    DrawerLayout drawerLayout;
    ArrayList<Loaisp> mangloaisp;
    LoaispAdapter loaispAdapter;
    int id = 0;
    String tenloaisp = "";
    String hinhloaisp = "";
    ArrayList<Sanpham> mangsanpham;
    SanphamAdapter sanphamAdapter;
    public static String Username;
    public static ArrayList<Giohang> manggiohang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        if (CheckConnect.haveNetworkConnection(getApplicationContext())){
            ActionBar();
            ActionViewFlipper();
            Getdulieuloaisp();
            GetdulieuSPMoiNhat();
            CatchOnItemListView();
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

    private void CatchOnItemListView() {
        listviewindex.setOnItemClickListener((parent, view, position, id) -> {
            switch (position){
                case 0:
                    if(CheckConnect.haveNetworkConnection(getApplicationContext())){
                        if(Username == null){
                            Intent intent = new Intent(MainActivity.this,DangNhapActivity.class);
                            startActivity(intent);
                        }else {
                            Intent intent = new Intent(MainActivity.this,DangxuatActivity.class);
                            startActivity(intent);
                        }
                    }else {
                        CheckConnect.ShowToast_shor(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");

                    }
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case 1:
                    if(CheckConnect.haveNetworkConnection(getApplicationContext())){
                        Intent intent = new Intent(MainActivity.this,MainActivity.class);
                        startActivity(intent);
                    }else {
                        CheckConnect.ShowToast_shor(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");

                    }
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case 2:
                    if(CheckConnect.haveNetworkConnection(getApplicationContext())){
                        Intent intent = new Intent(MainActivity.this,DienthoaiActivity.class);
                        intent.putExtra("idloaisp",mangloaisp.get(position).getId());
                        startActivity(intent);
                    }else {
                        CheckConnect.ShowToast_shor(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");

                    }
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case 3:
                    if(CheckConnect.haveNetworkConnection(getApplicationContext())){
                        Intent intent = new Intent(MainActivity.this,LaptopActivity.class);
                        intent.putExtra("idloaisp",mangloaisp.get(position).getId());
                        startActivity(intent);
                    }else {
                        CheckConnect.ShowToast_shor(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");

                    }
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case 4:
                    if(CheckConnect.haveNetworkConnection(getApplicationContext())){
                        Intent intent = new Intent(MainActivity.this,TimKiemActivity.class);
                        startActivity(intent);
                    }else {
                        CheckConnect.ShowToast_shor(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");

                    }
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case 5:
                    if(CheckConnect.haveNetworkConnection(getApplicationContext())){
                        Intent intent = new Intent(MainActivity.this,LienHeActivity.class);
                        startActivity(intent);
                    }else {
                        CheckConnect.ShowToast_shor(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");

                    }
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case 6:
                    if(CheckConnect.haveNetworkConnection(getApplicationContext())){
                        Intent intent = new Intent(MainActivity.this,ThongTinActivity.class);
                        startActivity(intent);
                    }else {
                        CheckConnect.ShowToast_shor(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");

                    }
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
            }
        });
    }

    private void GetdulieuSPMoiNhat() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.duongdanspmoinhat, response -> {
            if (response != null) {
                int ID;
                String Tensp;
                int Giasp;
                String Hinhsp;
                String Motasp;
                int Idloaisp;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        ID = jsonObject.getInt("id");
                        Tensp = jsonObject.getString("tensp");
                        Giasp = jsonObject.getInt("giasp");
                        Hinhsp = jsonObject.getString("hinhsp");
                        Motasp = jsonObject.getString("motasp");
                        Idloaisp = jsonObject.getInt("idloaisp");
                        mangsanpham.add(new Sanpham(ID, Tensp, Giasp, Hinhsp, Motasp, Idloaisp));
                        sanphamAdapter.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, error -> {

        });

        requestQueue.add(jsonArrayRequest);
    }

    private void Getdulieuloaisp() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest;
        jsonArrayRequest = new JsonArrayRequest(Server.duonganloaisp, response -> {
            if (response != null){
                for (int i = 0 ;i < response.length();i++){
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        id = jsonObject.getInt("id") + 1;
                        tenloaisp = jsonObject.getString("tenloaisp");
                        hinhloaisp = jsonObject.getString("hinhloaisp");
                        mangloaisp.add(new Loaisp(id,tenloaisp,hinhloaisp));
                        loaispAdapter.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                mangloaisp.add(4,new Loaisp(0,"Tìm Kiếm","https://banner2.cleanpng.com/20180326/ugw/kisspng-computer-icons-google-search-symbol-search-engine-search-5ab9a4670a02b0.319626391522115687041.jpg"));
                mangloaisp.add(5,new Loaisp(0,"Liên Hệ","http://file.hstatic.net/1000068742/article/nhiet_tinh.png"));
                mangloaisp.add(6,new Loaisp(0,"Thông Tin","https://www.circulareconomy.brussels/wp-content/uploads/2017/05/BeCircular-Avatar-Man-Orange.png"));
            }
        }, error -> CheckConnect.ShowToast_shor(getApplicationContext(),error.toString()));
        requestQueue.add(jsonArrayRequest);
    }

    private void ActionViewFlipper() {
        ArrayList<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://salt.tikicdn.com/ts/banner/23/89/b7/5b46dce836d6daf985ac68e990c1f672.jpg");
        mangquangcao.add("https://salt.tikicdn.com/ts/banner/45/33/5c/7fcc628cd0a1add0edb0069627ceefc3.jpg");
        mangquangcao.add("https://salt.tikicdn.com/ts/banner/c7/1e/29/cad2cd9b123bf09897e902400910d4cb.jpg");
        mangquangcao.add("https://salt.tikicdn.com/ts/banner/86/49/a6/6c4e2a8692a02d66287ace7beb7ebc3d.jpg");
        for(int i = 0;i < mangquangcao.size();i++){
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.get().load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right );
        Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right );
        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setOutAnimation(animation_slide_out);
    }

    private void ActionBar(){
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(v -> drawerLayout.openDrawer(GravityCompat.START));
    }

    private void Anhxa() {
        toolbar = findViewById(R.id.toobarindex);
        viewFlipper = findViewById(R.id.viewflipper);
        recyclerView = findViewById(R.id.recyclerview);
        navigationView = findViewById(R.id.navigationView);
        listviewindex = findViewById(R.id.listviewindex);
        drawerLayout = findViewById(R.id.drawerlayout);
        mangloaisp = new ArrayList<>();
        if(Username == null){
            mangloaisp.add(0,new Loaisp(0,"Đăng Nhập","http://cdn.onlinewebfonts.com/svg/img_568656.png"));
        }else {
            mangloaisp.add(0,new Loaisp(0,Username,"http://cdn.onlinewebfonts.com/svg/img_568656.png"));
        }
        mangloaisp.add(1,new Loaisp(0,"Trang Chủ","https://sites.google.com/site/khoivinhphankhoivinhseo/_/rsrc/1489649407204/noi-bat/cac-mau-tick-icon-dep/home.png"));
        loaispAdapter = new LoaispAdapter(mangloaisp,getApplicationContext());
        listviewindex.setAdapter(loaispAdapter);
        mangsanpham =new ArrayList<>();
        sanphamAdapter = new SanphamAdapter(getApplicationContext(),mangsanpham);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        recyclerView.setAdapter(sanphamAdapter);
        if(manggiohang != null){

        }else {
            manggiohang = new ArrayList<>();
        }
    }
}