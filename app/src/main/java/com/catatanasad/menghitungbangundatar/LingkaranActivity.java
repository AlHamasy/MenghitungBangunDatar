package com.catatanasad.menghitungbangundatar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LingkaranActivity extends AppCompatActivity {

    TextView txtHasil;
    EditText edtJarijari;
    Button btnHitung;
    String STATE_HASIL = "state_hasil";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lingkaran);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtHasil = findViewById(R.id.txt_hasil);
        edtJarijari = findViewById(R.id.edt_jari_jari);
        btnHitung = findViewById(R.id.btn_hitung);

        //todo kondisional jika orientasi dirubah
        if (savedInstanceState != null){
            String hasil = savedInstanceState.getString(STATE_HASIL);
            txtHasil.setText(hasil);
        }

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(edtJarijari.getText().toString())){
                    edtJarijari.setError("Masukkan nilai jari-jari");
                }
                else {
                    double jarijari = Double.parseDouble(edtJarijari.getText().toString());

                    double keliling = 2 * 3.14 * jarijari;
                    double luas = 2 * jarijari * jarijari;

                    txtHasil.setText("Keliling : " + keliling + "\n Luas : " + luas);
                    edtJarijari.requestFocus();
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
