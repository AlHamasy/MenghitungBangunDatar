package com.catatanasad.menghitungbangundatar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PersegiActivity extends AppCompatActivity {

    TextView txtHasil;
    EditText edtSisi;
    Button btnHitung;
    String STATE_HASIL = "state_hasil";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persegi);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtHasil = findViewById(R.id.txt_hasil);
        edtSisi = findViewById(R.id.edt_sisi);
        btnHitung = findViewById(R.id.btn_hitung);

        //todo kondisional jika orientasi dirubah
        if (savedInstanceState != null){
            String hasil = savedInstanceState.getString(STATE_HASIL);
            txtHasil.setText(hasil);
        }

        btnHitung.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(edtSisi.getText().toString())){
                    edtSisi.setError("Masukkan nilai sisi");
                }
                else{
                    double sisi = Double.parseDouble(edtSisi.getText().toString());

                    double keliling = sisi * 4;
                    double luas = sisi * sisi;

                    txtHasil.setText("Keliling : " + keliling + "\n Luas : " + luas);
                    edtSisi.requestFocus();
                }
            }
        });

    }

    // todo nilai tidak hilang jika orientasi dirubah
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(STATE_HASIL, txtHasil.getText().toString());
        super.onSaveInstanceState(outState);
    }
}
