package com.example.administrator.shixun.db_util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Util {
    private static MyHelper mHelper=null;
    /** 
    打开数据库写

    */ 
    public static SQLiteDatabase getWriteDb(Context context){
        if (mHelper==null){
            mHelper=new MyHelper(context);
        }
        SQLiteDatabase db=mHelper.getWritableDatabase();
        return db;
    }
    /** 
    打开数据库读

    */ 
    public static SQLiteDatabase getReadDb(Context context){
        if (mHelper==null){
            mHelper=new MyHelper(context);
        }
        SQLiteDatabase db=mHelper.getReadableDatabase();
        return db;
    }
}
