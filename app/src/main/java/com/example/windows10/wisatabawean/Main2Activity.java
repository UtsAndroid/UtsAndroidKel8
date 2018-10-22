package com.example.windows10.wisatabawean;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.windows10.wisatabawean.adapter.ClickListener;
import com.example.windows10.wisatabawean.adapter.GaleriAdapter;
import com.example.windows10.wisatabawean.adapter.RecyclerTouchListener;
import com.example.windows10.wisatabawean.model.Galeri;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private List<Galeri> galeriList = new ArrayList<>();
    private RecyclerView recyclerView;
    private GaleriAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i = getIntent();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mAdapter = new GaleriAdapter(galeriList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int i) {
                Galeri galeri = galeriList.get(i);
                Intent intent = new Intent(getApplicationContext(),GaleriActivity.class);
                intent.putExtra("Title",galeri.getTitle());
                intent.putExtra("Jenis",galeri.getJenis());
                intent.putExtra("Image",galeri.getImageF());
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int i) {

            }
        }));

        setData();
    }
    private void setData() {
        Galeri dataGaleri1 = new Galeri("Pulau Bawean","Wisata Alam Indonesia", R.drawable.img3);
        Galeri dataGaleri2 = new Galeri("Pantai Ria","Wisata Alam Indonesia", R.drawable.img4);
        Galeri dataGaleri3 = new Galeri("Danau Kastoba","Wisata Alam Indonesia", R.drawable.img5);
        Galeri dataGaleri4 = new Galeri("Tanjung Gaang","Wisata Alam Indonesia", R.drawable.img6);
        Galeri dataGaleri5 = new Galeri("Wisata Pulau Gili Bawean","Wisata Alam Indonesia", R.drawable.img7);
        Galeri dataGaleri6 = new Galeri("Pulau Noko","Wisata Alam Indonesia", R.drawable.img8);
        Galeri dataGaleri7 = new Galeri("Pulau Noko Selayar","Wisata Alam Indonesia", R.drawable.img9);
        Galeri dataGaleri8 = new Galeri("Pantai Mayangkara","Wisata Alam Indonesia", R.drawable.img10);
        Galeri dataGaleri9 = new Galeri("Pantai Kuburan Panjang","Wisata Alam Indonesia", R.drawable.img11);
        Galeri dataGaleri10 = new Galeri("Air Terjun Lancar","Wisata Alam Indonesia", R.drawable.img12);
        Galeri dataGaleri11 = new Galeri("Gili lyang","Wisata Alam Indonesia", R.drawable.img13);
        Galeri dataGaleri12 = new Galeri("Penangkaran Rusa Bawean","Wisata Alam Indonesia", R.drawable.img14);
        Galeri dataGaleri13 = new Galeri("Air Terjun Laccar","Wisata Alam Indonesia", R.drawable.img15);
        Galeri dataGaleri14 = new Galeri("Pantai Labuhan","Wisata Alam Indonesia", R.drawable.img16);
        Galeri dataGaleri15 = new Galeri("Gunung Sabu","Wisata Alam Indonesia", R.drawable.img17);



        galeriList.add(dataGaleri1);
        galeriList.add(dataGaleri2);
        galeriList.add(dataGaleri3);
        galeriList.add(dataGaleri4);
        galeriList.add(dataGaleri5);
        galeriList.add(dataGaleri6);
        galeriList.add(dataGaleri7);
        galeriList.add(dataGaleri8);
        galeriList.add(dataGaleri9);
        galeriList.add(dataGaleri10);
        galeriList.add(dataGaleri11);
        galeriList.add(dataGaleri12);
        galeriList.add(dataGaleri13);
        galeriList.add(dataGaleri14);
        galeriList.add(dataGaleri15);

    }
}
