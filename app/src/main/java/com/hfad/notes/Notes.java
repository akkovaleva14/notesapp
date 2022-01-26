package com.hfad.notes;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

// наш класс. то, что описывает нашу заметку: id, title, note
// set/get всякое. описали, как выглядит таблица в нашей базе данных

@Entity
public class Notes {

    @PrimaryKey(autoGenerate = true)
    int noteId;
    String title;
    String note;

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
