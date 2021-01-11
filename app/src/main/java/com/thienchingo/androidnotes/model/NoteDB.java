package com.thienchingo.androidnotes.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class NoteDB {
    @Id(autoincrement = true)
    Long id;
    private String title;
    private String content;
    private Date creationDate;
    @Generated(hash = 467177920)
    public NoteDB(Long id, String title, String content, Date creationDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
    }
    @Generated(hash = 251473405)
    public NoteDB() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Date getCreationDate() {
        return this.creationDate;
    }
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
