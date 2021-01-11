package com.thienchingo.androidnotes;

import android.app.Application;

import com.thienchingo.androidnotes.dao.NoteOpenHelper;
import com.thienchingo.androidnotes.model.DaoMaster;
import com.thienchingo.androidnotes.model.DaoSession;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseOpenHelper;

public class NoteApplication extends Application {
    private DaoSession daoSession;
    static NoteApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        NoteOpenHelper helper = new NoteOpenHelper(this, "notedb");
//        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"notedb");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public static NoteApplication getInstance() {
        return instance;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
