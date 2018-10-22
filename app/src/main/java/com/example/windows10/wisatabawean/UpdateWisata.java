package com.example.windows10.wisatabawean;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateWisata extends AppCompatActivity {
    protected Cursor cursor;
    //Inisialisasi kelas MyDataHelper
    MyDataHelper dbHelper;
    //Inisilisasi elemen-elemen yang ada pada layout (variable)
    Button btn1, btn2;
    TextView text1;
    EditText text2, text3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_wisata);

        // instanstiasi kelas MyDataHelper
        dbHelper = new MyDataHelper(this);
        // Inisialisasi fields TextView dan EditText
        text1 = (TextView) findViewById(R.id.textView1);
        text2 = (EditText) findViewById(R.id.editText2);
        text3 = (EditText) findViewById(R.id.editText3);

        //Memanggil database agar bisa dibaca datanya
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        // untuk mengakses data, memanggil semua data dari tabel wisata sesuai dengan nama yang dipilih
        cursor = db.rawQuery("SELECT * FROM wisata WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'",null);
        // pindah ke record pertama
        cursor.moveToFirst();
        //Untuk mengambil jumlah data
        if (cursor.getCount() > 0)
        {
            cursor.moveToPosition(0);
            //Set atribut pada objek text dengan data cursor yang diambil dari database
            text1.setText(cursor.getString(0));
            text2.setText(cursor.getString(1));
            text3.setText(cursor.getString(2));
        }
        // Inisialisasi Button
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);

        // mengeset  even onClick pada button1 yaitu button simpan untuk menyimpan data yang diedit
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Memanggil database agar bisa dimasuki data
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                // Untuk mengeksekusi sintaks SQL mengupdate data wisata sesuai dengan nama yang dipilih
                db.execSQL("UPDATE wisata SET nama='"+
                        text2.getText().toString() +"', deskripsi='" +
                        text3.getText().toString() + "' WHERE _id='" +
                        text1.getText().toString() + "'");
                // Notif jika data berhasil diupdate
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();

                DataWisata.layarutama.TampilkanList();
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
