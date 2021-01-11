package com.thienchingo.androidnotes;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thienchingo.androidnotes.event.NoteItemOnClickEvent;
import com.thienchingo.androidnotes.model.Note;
import com.thienchingo.androidnotes.model.NoteDB;

import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {
private List<NoteDB> notes;


    int i = 0, j =0;
    @NonNull
    @Override
    public NotesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_notes, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        Log.d("Note", "onCreateViewHolder " + ++i);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(j > 20) return;
        NoteDB note = notes.get(position);
        holder.mTvTile.setText(note.getTitle());
        Date dates = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String date = simpleDateFormat.format(dates);
        holder.mTvDate.setText(date);
        holder.mTvContent.setText(note.getContent());
        Log.d("Note", "onBindViewHolder " + ++j);
        holder.setNote(note);

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mTvTile;
        public final TextView mTvContent;
        public final TextView mTvDate;
        private NoteDB note;
        public void setNote(NoteDB note) {
            this.note = note;
        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvTile = itemView.findViewById(R.id.item_note_title);
            mTvContent = itemView.findViewById(R.id.item_notes_content);
            mTvDate = itemView.findViewById(R.id.item_notes_date);
            itemView.setOnClickListener(v -> {
                EventBus.getDefault().post(new NoteItemOnClickEvent(note));

            });
        }
    }
    public NotesAdapter(List<NoteDB> notes) {
        this.notes = notes;
    }
}
