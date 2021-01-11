package com.thienchingo.androidnotes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thienchingo.androidnotes.model.Note;
import com.thienchingo.androidnotes.model.NoteDB;
import com.thienchingo.androidnotes.model.NoteDBDao;
import com.thienchingo.androidnotes.model.NoteDao;

import java.util.List;


public class fragment_note_list extends Fragment {
    public fragment_note_list() {
    }

    public static Fragment newInstance() {
        return new fragment_note_list();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_note_lists, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.list_note_fragment);
        NoteDBDao noteDBDao = NoteApplication.getInstance().getDaoSession().getNoteDBDao();
        List<NoteDB> notelists = noteDBDao.loadAll();
        NotesAdapter notesAdapter = new NotesAdapter(notelists);
//        NotesAdapter notesAdapter = new NotesAdapter(Note.generateNote());
        recyclerView.setAdapter(notesAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return v;
    }
}