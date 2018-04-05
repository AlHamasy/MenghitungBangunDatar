package com.catatanasad.menghitungbangundatar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SegitigaActivity extends AppCompatActivity implements View.OnClickListener {

    //todo luas
    EditText edtAlas;
    EditText edtTinggi;
    Button btnHitungLuas;
    TextView txtHasilLuas;

    //todo keliling
    EditText edtSisiA;
    EditText edtSisiB;
    EditText edtSisiC;
    Button btnHitungKeliling;
    TextView txtHasilKeliling;

    String STATE_HASIL_LUAS = "state_hasil_luas";
    String STATE_HASIL_KELILING = "state_hasil_keliling";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segitiga);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //todo luas
        edtAlas = findViewById(R.id.edt_alas);
        edtTinggi = findViewById(R.id.edt_tinggi);
        btnHitungLuas = findViewById(R.id.btn_hitung_luas);
        txtHasilLuas = findViewById(R.id.txt_hasil_luas);

        //todo keliling
        edtSisiA = findViewById(R.id.edt_sisi_a);
        edtSisiB = findViewById(R.id.edt_sisi_b);
        edtSisiC = findViewById(R.id.edt_sisi_c);
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

                if (TextUtils.isEmpty(edtAlas.getText().toString())){
                    edtAlas.setError("Masukkan nilai alas");
                }
                else if (TextUtils.isEmpty(edtTinggi.getText().toString())){
                    edtTinggi.setError("Masukkan nilai tinggi");
                }
                else {

                    double alas = Double.parseDouble(edtAlas.getText().toString());
                    double tinggi = Double.parseDouble(edtTinggi.getText().toString());

                    double luas = 0.5 * alas * tinggi;

                    txtHasilLuas.setText("Luas : " + luas);
                    edtAlas.requestFocus();
                }
                break;

            case R.id.btn_hitung_keliling:

                if (TextUtils.isEmpty(edtSisiA.getText().toString())){
                    edtSisiA.setError("Masukkan nilai sisi a");
                }
                else if (TextUtils.isEmpty(edtSisiB.getText().toString())){
                    edtSisiB.setError("Masukkan nilai sisi b");
                }
                else if (TextUtils.isEmpty(edtSisiC.getText().toString())){
                    edtSisiC.setError("Masukkan nilai sisi c");
                }
                else {

                    double sisiA = Double.parseDouble(edtSisiA.getText().toString());
                    double sisiB = Double.parseDouble(edtSisiB.getText().toString());
                    double sisiC = Double.parseDouble(edtSisiC.getText().toString());

                    double keliling = sisiA + sisiB + sisiC;

                    txtHasilKeliling.setText("Keliling : " + keliling);
                    edtSisiA.requestFocus();
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
