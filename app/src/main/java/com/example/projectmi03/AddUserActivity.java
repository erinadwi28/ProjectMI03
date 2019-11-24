package com.example.projectmi03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projectmi03.Room.Mahasiswa;
import static com.example.projectmi03.AppAplication.db;

public class AddUserActivity extends AppCompatActivity {

    private Button insertData;
    private EditText etAlamat;
    private EditText etKejuruan;
    private EditText etNama;
    private EditText etNim;
    Mahasiswa mahasiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        insertData = findViewById(R.id.btInsert);
        etAlamat = findViewById(R.id.etAlamat);
        etKejuruan = findViewById(R.id.etKejuruan);
        etNim = findViewById(R.id.etNim);
        etNama = findViewById(R.id.etNama);

        insertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!etAlamat.getText().toString().isEmpty() && !etKejuruan.getText().toString().isEmpty() && !etNama.getText().toString().isEmpty() && !etNim.getText().toString().isEmpty()) {

                    mahasiswa = new Mahasiswa();
                    mahasiswa.setAlamat(etAlamat.getText().toString());
                    mahasiswa.setKejuruan(etKejuruan.getText().toString());
                    mahasiswa.setNama(etNama.getText().toString());
                    mahasiswa.setNim(etNim.getText().toString());

                    //insert data in database
                    db.userDao().insertAll(mahasiswa);
                    startActivity(new Intent(AddUserActivity.this,DetailActivity.class));
                }else {
                    Toast.makeText(getApplicationContext(),"Mohon masukkan dengan benar",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
