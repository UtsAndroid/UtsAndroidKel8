package com.example.windows10.wisatabawean;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertHomestay extends AppCompatActivity {
    //Inisialisasi Cursor
    protected Cursor cursor;
    //Inisialisasi kelas MyDataHelper
    MyDataHelper dbHelper;
    //Inisilisasi elemen-elemen yang ada pada layout (variable)
    Button btn1, btn2;
    EditText text2, text3, text4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_homestay);

        // instanstiasi kelas MyDataHelper
        dbHelper = new MyDataHelper(this);
        // Inisialisasi fields EditText dan Button
        text2 = (EditText) findViewById(R.id.editText2);
        text3 = (EditText) findViewById(R.id.editText3);
        text4 = (EditText) findViewById(R.id.editText4);

        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);

        // mengeset  even onClick pada button1 yaitu button simpan untuk menyimpan data
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Memanggil database agar bisa dimasuki data
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                // Membuat sebuah value untuk meginsertkan, memasangkan data dengan nama-nama kolom pada database
                db.execSQL("INSERT INTO homestay(nama_home, alamat, fasilitas) values('"
                        +text2.getText().toString() + "','" +
                        text3.getText().toString() + "','" +
                        text4.getText().toString() + "')");
                // Notif jika data berhasil ditambahkan
                Toast.makeText(getApplicationContext(), " Berhasil ditambahkan", Toast.LENGTH_LONG).show();
                // Setelah berhasil menambah data maka akan pindah ke halaman awal yaitu halaman list activity_main.xml
                DataHomestay.layarutama.TampilkanList();
                finish();
            }
        });
        // Mengeset  even onClick pada button2 yaitu button kembali
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });
    }
}
