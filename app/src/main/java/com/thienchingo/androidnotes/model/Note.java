package com.thienchingo.androidnotes.model;

import android.util.Log;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.greenrobot.greendao.annotation.Generated;
@Entity
public class Note {
    @Id(autoincrement = true)
    Long id;
    private String titel;
    private String content;
    private Date creationDate;

    public Note(String titel, String content, Date creationDate) {
        this.titel = titel;
        this.content = content;
        this.creationDate = creationDate;
    }

    @Generated(hash = 13670758)
    public Note(Long id, String titel, String content, Date creationDate) {
        this.id = id;
        this.titel = titel;
        this.content = content;
        this.creationDate = creationDate;
    }

    @Generated(hash = 1272611929)
    public Note() {
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public static List<Note> generateNote() {
        List<Note> notes = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            String title = String.format("Note #%d", i);
            Date creationDate = new Date();
            notes.add(new Note(title,String.format("Hello  #%d", i), creationDate));
            Log.i("generateNote",title);
        }
        return notes;
    }

}
