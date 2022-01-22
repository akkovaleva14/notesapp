package com.hfad.notes;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Notes.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract NotesDao getNotesDao();
}
