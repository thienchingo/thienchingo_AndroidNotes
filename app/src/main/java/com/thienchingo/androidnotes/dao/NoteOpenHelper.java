package com.thienchingo.androidnotes.dao;

import android.content.Context;
import android.util.Log;

import com.thienchingo.androidnotes.NoteApplication;
import com.thienchingo.androidnotes.model.DaoMaster;

import org.apache.commons.io.IOUtils;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseOpenHelper;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class NoteOpenHelper extends DatabaseOpenHelper {
    private Context context;
    private static final int SCHEMA_VERSION = 3;

//    public NoteOpenHelper(Context context, String name) {
//        super(context, name, SCHEMA_VERSION);
//    }

    public NoteOpenHelper(Context context, String name) {
        super(context, name, SCHEMA_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(Database db) {
        super.onCreate(db);
        Log.i("greenDAO", "Creating tables for schema version " + SCHEMA_VERSION);
        DaoMaster.createAllTables(db, false);
        RunSql(db, "note.sql");
    }

    private void RunSql(Database db, String fileName) {
        try {
            InputStream inputStream = context.getAssets().open(fileName);
            List<String> lines = IOUtils.readLines(inputStream, String.valueOf(StandardCharsets.UTF_8));
            for (String line : lines) {
                db.execSQL(line);
            }
        } catch (Exception e) {
            Log.i("greenDAO", "Error creating tables for schema version "+ e.toString() + SCHEMA_VERSION);
        }
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, SCHEMA_VERSION);
        if (oldVersion == 2 && newVersion == 3) {
            RunSql(db, "note_update.sql");
        }
    }
}
