package com.hfad.notes;

import android.app.Application;

import androidx.room.Room;

public class App extends Application {

    static App instance;
    // создаем базу данных
    AppDataBase db;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //  при вызове этого кода room будет создавать новый экземпляр AppDataBase
        db = Room.databaseBuilder(this, AppDataBase.class, "database").build();
    }

    AppDataBase getDataBase() {
        return db;
    }
}
