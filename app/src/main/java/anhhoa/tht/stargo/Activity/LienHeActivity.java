package anhhoa.tht.stargo.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import java.util.Objects;

import anhhoa.tht.stargo.R;

public class LienHeActivity extends AppCompatActivity {
    Toolbar toolbarlienhe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lien_he);
        toolbarlienhe = findViewById(R.id.toolbarlienhe);
        ActionToolbar();
    }
    private void ActionToolbar() {
        setSupportActionBar(toolbarlienhe);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbarlienhe.setNavigationOnClickListener(v -> finish());
    }
}