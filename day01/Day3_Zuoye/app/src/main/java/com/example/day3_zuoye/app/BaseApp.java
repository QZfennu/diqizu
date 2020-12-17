package com.example.day3_zuoye.app;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.day3_zuoye.db.DaoMaster;
import com.example.day3_zuoye.db.DaoSession;

public class BaseApp extends Application {
    private static BaseApp sInstance;
    private DaoMaster daoMaster;
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        getData();
    }

    private void getData() {
        DaoMaster.DevOpenHelper myDb = new DaoMaster.DevOpenHelper(this, "MyDb", null);
        SQLiteDatabase writableDatabase = myDb.getWritableDatabase();
        writableDatabase.disableWriteAheadLogging();
        daoMaster = new DaoMaster(writableDatabase);
        daoSession = daoMaster.newSession();
    }

    public static BaseApp getsInstance() {
        return sInstance;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
