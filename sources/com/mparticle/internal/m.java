package com.mparticle.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class m extends SQLiteOpenHelper {
    m(Context context) {
        super(context, "mparticle_segment.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS segments (_id INTEGER PRIMARY KEY, name TEXT NOT NULL, endpoint_ids TEXT );");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS segment_memberships (_id INTEGER PRIMARY KEY AUTOINCREMENT, segment_id INTEGER NOT NULL, timestamp REAL NOT NULL, action INTEGER NOT NULL,  FOREIGN KEY (segment_id) REFERENCES segments (_id));");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS segments (_id INTEGER PRIMARY KEY, name TEXT NOT NULL, endpoint_ids TEXT );");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS segment_memberships (_id INTEGER PRIMARY KEY AUTOINCREMENT, segment_id INTEGER NOT NULL, timestamp REAL NOT NULL, action INTEGER NOT NULL,  FOREIGN KEY (segment_id) REFERENCES segments (_id));");
    }
}
