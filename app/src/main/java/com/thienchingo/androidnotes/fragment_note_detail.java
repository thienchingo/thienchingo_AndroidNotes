package com.thienchingo.androidnotes;

import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thienchingo.androidnotes.event.NoteItemOnClickEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_note_detail#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_note_detail extends Fragment {
    private TextView mTvTitle;
//    private TextView mTvContent;
//    private TextView mTvTime;

    public fragment_note_detail() {
    }
    public static Fragment newInstance(){
        return new fragment_note_detail();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_note_detail,container,false);
        mTvTitle = v.findViewById(R.id.notes_title);
//        mTvTime = v.findViewById(R.id.notes_date);
//        mTvContent = v.findViewById(R.id.notes_content);
       // EventBus.getDefault().register(this);
        return v;
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCriminalClick(NoteItemOnClickEvent event){

//        mTvContent.setText(event.getNote().getContent());
        Date dates = new Date();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String date = df.format(dates);
        mTvTitle.setText(event.getNote().getTitle()+ "\n"+ event.getNote().getContent()+ "\n"+date);
//        mTvTime.setText(date);
        Log.i("event",event.getNote().getTitle());
    }
    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }
}