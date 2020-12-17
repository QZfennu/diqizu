package com.example.day_03_zy_sanyemian.db;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.day_03_zy_sanyemian.db.DaoMaster;
import com.example.day_03_zy_sanyemian.db.DaoSession;

public class App extends Application {
    private static DaoSession mDaoSession;

    @Override
    public void onCreate() {
        //当前程序一运行，onCreate就先执行
        super.onCreate();
        initDB();
    }

    private void initDB() {
        // 参数1 上下文 参数2.数据库名字
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "person");
        SQLiteDatabase db = helper.getWritableDatabase();
        mDaoSession = new DaoMaster(db).newSession();
    }

    //对外提供DaoSession对象
    public static DaoSession getDaoSession() {
        return mDaoSession;
    }
}