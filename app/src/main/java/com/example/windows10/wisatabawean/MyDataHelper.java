package com.example.windows10.wisatabawean;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDataHelper extends SQLiteOpenHelper {
    // Nama database yang akan dibuat
    private static final String NAMA_DB = "wisata.db";
    // Nama tabel
    private static final String WISATA = "wisata";
    private static final String HOMESTAY = "homestay";
    // Versi database
    private static final int VERSI_DB = 1;

    // Nama kolom dalam tabel
    private static final String ID = "_id";
    private static final String NAMA = "nama";
    private static final String DESKRIPSI = "deskripsi";

    // Nama kolom dalam tabel
    private static final String ID_HOME = "id_home";
    private static final String NAMA_HOME = "nama_home";
    private static final String ALAMAT = "alamat";
    private static final String FASILITAS = "fasilitas";

    // SQL untuk membuat table
    private static final String CREATE_WISATA =
            "CREATE TABLE "
                    + WISATA
                    + " ("
                    +ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    +NAMA + " VARCHAR(255), "
                    +DESKRIPSI + " VARCHAR(1024) "
                    +");";

    // SQL untuk membuat table
    private static final String CREATE_HOMESTAY =
            "CREATE TABLE "
                    + HOMESTAY
                    + " ("
                    +ID_HOME + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    +NAMA_HOME + " VARCHAR(255), "
                    +ALAMAT + " VARCHAR(255), "
                    +FASILITAS + " VARCHAR(1024) "
                    +");";

    // SQL untuk drop table
    private static final String DROP_WISATA = "DROP TABLE IF EXISTS " + WISATA;
    private static final String DROP_HOMESTAY = "DROP TABLE IF EXISTS " + HOMESTAY;

    //MyDataHelper diinstantiasi pada constructor
    public MyDataHelper(Context context){
        super(context, NAMA_DB, null, VERSI_DB);
    }

    //Mengeksekusi perintah SQL di atas untuk membuat tabel database baru
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_WISATA);
        db.execSQL(CREATE_HOMESTAY);
    }

    // Dijalankan apabila ingin mengupgrade database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL(DROP_TABLE);
        //onCreate(db);
    }
}
