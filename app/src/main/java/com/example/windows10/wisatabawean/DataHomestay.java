package com.example.windows10.wisatabawean;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class DataHomestay extends AppCompatActivity {
    //Inisilisasi elemen-elemen pada layout
    ListView ListView02;
    //Inisialisasi Cursor
    protected Cursor cursor;
    //Inisialisasi kelas MyDataHelper
    MyDataHelper datahomestay;
    public static DataHomestay layarutama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_homestay);

        //Inisialisasi Button
        Button btn = (Button) findViewById(R.id.button1);
        // mengeset  even onClick dan intent pada button untuk masuk/pindah ke activity InsertHomestay
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(DataHomestay.this, InsertHomestay.class);
                startActivity(myintent);
            }
        });
        layarutama = this;
        TampilkanList();
    }

    public void TampilkanList(){
        // Instanstiasi kelas MyDataHelper
        datahomestay = new MyDataHelper(this);
        //Memanggil database agar bisa dibaca datanya
        SQLiteDatabase db = datahomestay.getReadableDatabase();
        //Perintah SQL Select menggunakan Cursor untuk meselect table homestay
        cursor = db.rawQuery("SELECT * FROM homestay", null);
        final String[] databaru = new String[cursor.getCount()];
        // pindah ke data pertama
        cursor.moveToFirst();

        for(int cc=0; cc < cursor.getCount(); cc++){
            cursor.moveToPosition(cc);
            databaru[cc] = cursor.getString(1);
        }

        ListView02 = (ListView) findViewById(R.id.listView2);
        // Masukkan data ke array adapter
        ListView02.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, databaru));
        ListView02.setSelected(true);
        // Mengambil listview untuk diset onItemClickListener
        ListView02.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // Apabila mengklik salah satu judul
            @Override
            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
                final String selection = databaru[arg2];

                final CharSequence[] dialogitem = {"Lihat Homestay", "Update Homestay", "Hapus Homestay"};

                AlertDialog.Builder builder = new AlertDialog.Builder(DataHomestay.this);

                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item) {

                            case 0:
                                Intent intent0 = new Intent(getApplicationContext(), ViewHomestay.class);
                                intent0.putExtra("nama_home", selection);
                                startActivity(intent0);
                                break;

                            case 1 :
                                Intent intent1 = new Intent(getApplicationContext(), UpdateHomestay.class);
                                intent1.putExtra("nama_home", selection);
                                startActivity(intent1);
                                break;

                            case 2:
                                SQLiteDatabase db = datahomestay.getWritableDatabase();
                                db.execSQL("DELETE FROM homestay WHERE nama_home = '" + selection + "'");
                                TampilkanList();
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });
        ((ArrayAdapter)ListView02.getAdapter()).notifyDataSetInvalidated();
        //cursor/pengaksesan data ditutup
        cursor.close();
    }
}
