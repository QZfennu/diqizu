package com.example.myapplication;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.db.DaoMaster;
import com.example.myapplication.db.DaoSession;

public class App extends Application {
    private static DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        initDB();
    }

    //初始化数据库
    private void initDB() {
        //DaoMaster 作用：创建数据库
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(this, "user");
        SQLiteDatabase db = openHelper.getWritableDatabase();
        //DaoSession 里面有增删改查
        mDaoSession = new DaoMaster(db).newSession();
    }
    //对外提供DaoSession对象
    public static DaoSession getmDaoSession() {
        return mDaoSession;
    }
}
