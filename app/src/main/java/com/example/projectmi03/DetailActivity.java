package com.example.projectmi03;


import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.projectmi03.Room.AppDatabase;
import com.example.projectmi03.Room.Mahasiswa;
import static com.example.projectmi03.AppAplication.db;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    RecyclerView myRecyclerview;
    RecycleAdapter recycleAdapter;
    List<Mahasiswa> listMahasiswa = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        myRecyclerview = findViewById(R.id.myRecyclerview);
        fetchDataFromRoom();
        initRecyclerView();
        setAdapter();
    }

    private void fetchDataFromRoom() {
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class,"mahasiswa").allowMainThreadQueries().build();
        listMahasiswa = db.userDao().getAll();

        //just checcking data from db
        for (int i = 0 ; i <listMahasiswa.size();i++){
            Log.e("Aplikasi",listMahasiswa.get(i).getAlamat()+i);
            Log.e("Aplikasi",listMahasiswa.get(i).getKejuruan()+i);
            Log.e("Aplikasi",listMahasiswa.get(i).getNama()+i);
            Log.e("Aplikasi",listMahasiswa.get(i).getNim()+i);
        }
        Log.e("cek list",""+listMahasiswa.size());
    }

    private void initRecyclerView() {
        myRecyclerview.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        myRecyclerview.setLayoutManager(llm);
        recycleAdapter = new RecycleAdapter(this,listMahasiswa);
    }

    private void setAdapter() {
        myRecyclerview.setAdapter(recycleAdapter);
    }
}

