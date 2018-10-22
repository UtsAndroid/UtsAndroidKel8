package com.example.windows10.wisatabawean;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewHomestay extends AppCompatActivity {
    protected Cursor cursor;
    //Inisialisasi kelas MyDataHelper
    MyDataHelper dbHelper;
    //Inisilisasi elemen-elemen yang ada pada layout (variable)
    Button btn2;
    TextView text1, text2, text3, text4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_homestay);

        dbHelper = new MyDataHelper(this);
        // Inisialisasi fields TextView
        text1 = (TextView) findViewById(R.id.textView1);
        text2 = (TextView) findViewById(R.id.textView2);
        text3 = (TextView) findViewById(R.id.textView3);
        text4 = (TextView) findViewById(R.id.textView4);

        //Memanggil database agar bisa dibaca datanya
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM homestay WHERE nama_home = '" + getIntent().getStringExtra("nama_home") + "'", null);
        // pindah ke record pertama
        cursor.moveToFirst();

        // untuk mengambil jumlah data
        if(cursor.getCount()>0){
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0));
            text2.setText(cursor.getString(1));
            text3.setText(cursor.getString(2));
            text4.setText(cursor.getString(3));

        }
        btn2 = (Button) findViewById(R.id.button1);
        // Mengeset  even onClick pada button2 yaitu button kembali
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
