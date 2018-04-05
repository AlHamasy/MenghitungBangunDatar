package com.catatanasad.menghitungbangundatar;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by asadullah on 3/29/18.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyHolder> {

    int gambar [] = {R.drawable.persegi,
            R.drawable.persegi_panjang,
            R.drawable.lingkaran,
            R.drawable.segitiga,
            R.drawable.trapesium,
            R.drawable.jajar_genjang,
            R.drawable.belah_ketupat,
            R.drawable.layang};

    String nama_gambar [] = {"Persegi",
            "Persegi Panjang",
            "Lingkaran",
            "Segitiga",
            "Trapesium",
            "Jajar Genjang",
            "Belah Ketupat",
            "Layang - layang"};


    @Override
    public RecyclerViewAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new RecyclerViewAdapter.MyHolder(v);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewAdapter.MyHolder holder, final int position) {

        holder.text.setText(nama_gambar[position]);
        holder.image.setImageResource(gambar[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (position == 0){
                    Intent intent = new Intent(view.getContext(), PersegiActivity.class);
                    view.getContext().startActivity(intent);
                }
                else if (position == 1){
                    Intent intent = new Intent(view.getContext(), PersegiPanjangActivity.class);
                    view.getContext().startActivity(intent);
                }
                else if (position == 2){
                    Intent intent = new Intent(view.getContext(), LingkaranActivity.class);
                    view.getContext().startActivity(intent);
                }
                else if (position == 3){
                    Intent intent = new Intent(view.getContext(), SegitigaActivity.class);
                    view.getContext().startActivity(intent);
                }
                else if (position == 4){
                    Intent intent = new Intent(view.getContext(), TrapesiumActivity.class);
                    view.getContext().startActivity(intent);
                }
                else if (position == 5){
                    Intent intent = new Intent(view.getContext(), JajarGenjangActivity.class);
                    view.getContext().startActivity(intent);
                }
                else if (position == 6){
                    Intent intent = new Intent(view.getContext(), BelahKetupatActivity.class);
                    view.getContext().startActivity(intent);
                }
                else if (position == 7){
                    Intent intent = new Intent(view.getContext(), LayangActivity.class);
                    view.getContext().startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return nama_gambar.length;
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView text;
        ImageView image;

        public MyHolder(View itemView) {
            super(itemView);

            text = (TextView)itemView.findViewById(R.id.txt);
            image = (ImageView)itemView.findViewById(R.id.img);
        }
    }
}