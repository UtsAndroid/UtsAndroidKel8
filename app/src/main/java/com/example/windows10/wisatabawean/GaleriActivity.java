package com.example.windows10.wisatabawean;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class GaleriActivity extends AppCompatActivity {
    private TextView ttitle, tjenis;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeri);
        ttitle = (TextView) findViewById(R.id.title1);
        tjenis = (TextView) findViewById(R.id.jenis1);
        img = (ImageView) findViewById(R.id.imgF);

        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        String Jenis = intent.getExtras().getString("Jenis");
        int image = intent.getExtras().getInt("Image");

        ttitle.setText(Title);
        tjenis.setText(Jenis);
        img.setImageResource(image);
    }
}
