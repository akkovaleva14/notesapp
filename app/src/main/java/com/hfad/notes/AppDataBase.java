package com.hfad.notes;

import androidx.room.RoomDatabase;

public abstract class AppDataBase extends RoomDatabase {

    public abstract NotesDao getNotesDao();
}
