package com.thienchingo.androidnotes.event;

import com.thienchingo.androidnotes.model.NoteDB;


public class NoteItemOnClickEvent {
    private NoteDB note;

    public NoteItemOnClickEvent(NoteDB note) {
        this.note = note;
    }

    public NoteDB getNote() {
        return note;
    }

    public void setNote(NoteDB note) {
        this.note = note;
    }
}
