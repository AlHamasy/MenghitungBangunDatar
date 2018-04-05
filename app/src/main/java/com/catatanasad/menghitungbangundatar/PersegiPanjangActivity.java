package com.catatanasad.menghitungbangundatar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PersegiPanjangActivity extends AppCompatActivity {

    TextView txtHasil;
    EditText edtPanjang;
    EditText edtLebar;
    Button btnHitung;
    String STATE_HASIL = "state_hasil";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persegi_panjang);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtHasil = findViewById(R.id.txt_hasil);
        edtPanjang = findViewById(R.id.edt_panjang);
        edtLebar = findViewById(R.id.edt_lebar);
        btnHitung = findViewById(R.id.btn_hitung);

        //todo kondisional jika orientasi dirubah
        if (savedInstanceState != null){
            String hasil = savedInstanceState.getString(STATE_HASIL);
            txtHasil.setText(hasil);
        }

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(edtPanjang.getText().toString())){
                    edtPanjang.setError("Masukkan nilai panjang");
                }
                else if (TextUtils.isEmpty(edtLebar.getText().toString())){
                    edtLebar.setError("Masukkan nilai lebar");
                }
                else {

                    double panjang = Double.parseDouble(edtPanjang.getText().toString());
                    double lebar = Double.parseDouble(edtLebar.getText().toString());

                    double keliling = 2 * (panjang + lebar);
                    double luas = panjang * lebar;

                    txtHasil.setText("Keliling : " + keliling + "\n Luas : " + luas);
                    edtPanjang.requestFocus();

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
