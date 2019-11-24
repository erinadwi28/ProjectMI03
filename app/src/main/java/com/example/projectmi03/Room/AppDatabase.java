package com.example.projectmi03.Room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

    @Database(entities = {Mahasiswa.class}, version = 1)
    public abstract class AppDatabase extends RoomDatabase{
        public abstract MahasiswaDao userDao();
    }

