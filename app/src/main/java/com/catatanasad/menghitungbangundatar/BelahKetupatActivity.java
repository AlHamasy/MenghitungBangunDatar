package com.catatanasad.menghitungbangundatar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BelahKetupatActivity extends AppCompatActivity implements View.OnClickListener {

    //todo luas
    EditText edtDiagonal1;
    EditText edtDiagonal2;
    Button btnHitungLuas;
    TextView txtHasilLuas;

    //todo keliling
    EditText edtSisi;
    Button btnHitungKeliling;
    TextView txtHasilKeliling;

    String STATE_HASIL_LUAS = "state_hasil_luas";
    String STATE_HASIL_KELILING = "state_hasil_keliling";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belah_ketupat);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //todo luas
        edtDiagonal1 = findViewById(R.id.edt_diagonal_1);
        edtDiagonal2 = findViewById(R.id.edt_diagonal_2);
        btnHitungLuas = findViewById(R.id.btn_hitung_luas);
        txtHasilLuas = findViewById(R.id.txt_hasil_luas);

        //todo keliling
        edtSisi = findViewById(R.id.edt_sisi);
        btnHitungKeliling = findViewById(R.id.btn_hitung_keliling);
        txtHasilKeliling = findViewById(R.id.txt_hasil_keliling);

        //todo kondisional jika orientasi dirubah
        if (savedInstanceState != null){
            String hasilLuas = savedInstanceState.getString(STATE_HASIL_LUAS);
            String hasilKeliling = savedInstanceState.getString(STATE_HASIL_KELILING);
            txtHasilLuas.setText(hasilLuas);
            txtHasilKeliling.setText(hasilKeliling);
        }

        btnHitungLuas.setOnClickListener(this);
        btnHitungKeliling.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_hitung_luas:

                if (TextUtils.isEmpty(edtDiagonal1.getText().toString())){
                    edtDiagonal1.setError("Masukkan nilai diagonal 1");
                }
                else if (TextUtils.isEmpty(edtDiagonal2.getText().toString())){
                    edtDiagonal2.setError("Masukkan nilai diagonal 2");
                }
                else {

                    double d1 = Double.parseDouble(edtDiagonal1.getText().toString());
                    double d2 = Double.parseDouble(edtDiagonal2.getText().toString());

                    double luas = 0.5 * d1 * d2;

                    txtHasilLuas.setText("Luas : " + luas);
                    edtDiagonal1.requestFocus();
                }
                break;

            case R.id.btn_hitung_keliling:

                if (TextUtils.isEmpty(edtSisi.getText().toString())){
                    edtSisi.setError("Masukkan nilai sisi");
                }
                else {

                    double sisi = Double.parseDouble(edtSisi.getText().toString());

                    double keliling = 4 * sisi;

                    txtHasilKeliling.setText("Keliling : " + keliling);
                    edtSisi.requestFocus();
                }
            break;
        }
    }

    // todo nilai tidak hilang jika orientasi dirubah
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(STATE_HASIL_LUAS, txtHasilLuas.getText().toString());
        outState.putString(STATE_HASIL_KELILING, txtHasilKeliling.getText().toString());
        super.onSaveInstanceState(outState);
    }
}
