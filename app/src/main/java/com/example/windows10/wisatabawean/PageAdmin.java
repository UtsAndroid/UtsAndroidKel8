package com.example.windows10.wisatabawean;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PageAdmin extends AppCompatActivity {
    private Button btn1, btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_admin);

        Bundle b = getIntent().getExtras();

        TextView username = (TextView) findViewById(R.id.username);
        username.setText(b.getCharSequence("username"));
        btn1 = (Button) findViewById(R.id.btn_wisata);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PageAdmin.this, DataWisata.class);
                startActivity(intent);
            }
        });
        btn2 = (Button) findViewById(R.id.btn_homestay);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PageAdmin.this, DataHomestay.class);
                startActivity(intent);
            }
        });
    }

    public void button_onClick(View view){
        SharedPreferences set = this.getSharedPreferences("key", Context.MODE_PRIVATE );
        SharedPreferences . Editor editor = set.edit();
        editor.clear();
        editor.commit();
        finish();

        Intent i = new Intent(this.getApplicationContext(), MainActivity.class);
    }
}
