package com.example.windows10.wisatabawean.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.windows10.wisatabawean.R;
import com.example.windows10.wisatabawean.model.Galeri;

import java.util.List;

public class GaleriAdapter extends RecyclerView.Adapter<GaleriAdapter.MyViewHolder> {
    private Context mContext;
    private List<Galeri> galeriList;

    public GaleriAdapter( List<Galeri> galeriList) {
        this.mContext = mContext;
        this.galeriList = galeriList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, jenis;
        public ImageView imageF;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.fotoTitle);
            jenis = (TextView) view.findViewById(R.id.txtJenis);
            imageF = (ImageView) view.findViewById(R.id.imgView);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_galeri, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final Galeri galeri = galeriList.get(position);
        holder.title.setText(galeri.getTitle());
        holder.jenis.setText(galeri.getJenis());
        holder.imageF.setImageResource(galeri.getImageF());
    }

    @Override
    public int getItemCount() {
        return galeriList.size();
    }
}
