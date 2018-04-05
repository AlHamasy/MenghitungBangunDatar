package com.catatanasad.menghitungbangundatar;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

public class MainActivity extends AppCompatActivity {

    // todo deklarasi
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //todo inisialisasi dengan casting view
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        //todo atur jenis layoutya
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        //todo ukuran tetap
        recyclerView.setHasFixedSize(true);

        //todo jadikan sebuah adapter
        RecyclerViewAdapter adapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(adapter);
    }
}