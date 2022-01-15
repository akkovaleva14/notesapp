package com.hfad.notes;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Notes {

    @PrimaryKey(autoGenerate = true)
    int noteId;
    String title;
    String note;
    String image;

    public Notes(int noteId, String title, String note, String image) {
        this.noteId = noteId;
        this.title = title;
        this.note = note;
        this.image = image;
    }

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


  /*  public String getTitle() {
        return title;
    }

    public String getNote() {
        return note;
    }

    public String getImage() {
        return image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setImage(String image) {
        this.image = image;
    } */

}
