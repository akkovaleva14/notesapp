package com.hfad.notes;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NotesDao {

    // добавление 1й заметки
    @Insert
    void insert(Notes note);

    @Insert
    void insertAll(Notes... notes);

    @Delete
    void delete(Notes note);

    @Query("SELECT*FROM notes")
    List<Notes> getAllNotes();


}
