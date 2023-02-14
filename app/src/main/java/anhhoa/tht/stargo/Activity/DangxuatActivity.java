package anhhoa.tht.stargo.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import java.util.Objects;
import anhhoa.tht.stargo.R;
import anhhoa.tht.stargo.Ultil.CheckConnect;

public class DangxuatActivity extends AppCompatActivity {
    Toolbar toolbarlogout;
    Button btnlogout,btnhome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangxuat);
        Anhxa();
        btnhome.setOnClickListener(v -> finish());
        if (CheckConnect.haveNetworkConnection(getApplicationContext())){
            ActionToolbar();
            EventButton();
        }else {
            CheckConnect.ShowToast_shor(getApplicationContext(),"Bạn Hãy Kiểm tra lại Kết Nối");
            finish();
        }
    }

    private void EventButton() {
        btnlogout.setOnClickListener(v -> {
            MainActivity.Username = null;
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        });
    }

    private void ActionToolbar() {
        setSupportActionBar(toolbarlogout);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbarlogout.setNavigationOnClickListener(v -> finish());
    }

    private void Anhxa() {
        toolbarlogout = findViewById(R.id.toolbarlogout);
        btnlogout = findViewById(R.id.buttonlogout);
        btnhome = findViewById(R.id.buttonhome);
    }
}