package com.facebook.stetho.inspector.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.facebook.stetho.inspector.database.SQLiteDatabaseCompat;
import java.io.File;

public class DefaultDatabaseConnectionProvider implements DatabaseConnectionProvider {
    /* access modifiers changed from: protected */
    @SQLiteDatabaseCompat.SQLiteOpenOptions
    public int determineOpenOptions(File file) {
        String parent = file.getParent();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(file.getName());
        sb2.append("-wal");
        return new File(parent, sb2.toString()).exists() ? 1 : 0;
    }

    public SQLiteDatabase openDatabase(File file) throws SQLiteException {
        return performOpen(file, determineOpenOptions(file));
    }

    /* access modifiers changed from: protected */
    public SQLiteDatabase performOpen(File file, @SQLiteDatabaseCompat.SQLiteOpenOptions int i10) {
        SQLiteDatabaseCompat instance = SQLiteDatabaseCompat.getInstance();
        SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(file.getAbsolutePath(), (SQLiteDatabase.CursorFactory) null, instance.provideOpenFlags(i10) | 0);
        instance.enableFeatures(i10, openDatabase);
        return openDatabase;
    }
}
