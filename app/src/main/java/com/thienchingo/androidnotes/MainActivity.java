package com.thienchingo.androidnotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;

import com.thienchingo.androidnotes.event.NoteItemOnClickEvent;
import com.thienchingo.androidnotes.model.Note;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BindFragmentToPlaceholder();
    }
    private void BindFragmentToPlaceholder() {
        Fragment fragment_list = fragment_note_list.newInstance();
        Fragment fragment_detail = fragment_note_detail.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_list_notes, fragment_list);
        if (findViewById(R.id.fragment_detail_notes) != null) {
            transaction.replace(R.id.fragment_detail_notes, fragment_detail);
        }
        transaction.commit();
    }
}