package com.facebook.stetho.inspector.database;

import android.annotation.TargetApi;
import android.database.sqlite.SQLiteDatabase;

public abstract class SQLiteDatabaseCompat {
    public static final int ENABLE_FOREIGN_KEY_CONSTRAINTS = 2;
    public static final int ENABLE_WRITE_AHEAD_LOGGING = 1;
    private static final SQLiteDatabaseCompat sInstance = new JellyBeanAndBeyondImpl();

    @TargetApi(14)
    private static class IceCreamSandwichImpl extends SQLiteDatabaseCompat {
        private IceCreamSandwichImpl() {
        }

        public void enableFeatures(@SQLiteOpenOptions int i10, SQLiteDatabase sQLiteDatabase) {
            if ((i10 & 1) != 0) {
                sQLiteDatabase.enableWriteAheadLogging();
            }
            if ((i10 & 2) != 0) {
                sQLiteDatabase.execSQL("PRAGMA foreign_keys = ON");
            }
        }

        public int provideOpenFlags(@SQLiteOpenOptions int i10) {
            return 0;
        }
    }

    @TargetApi(16)
    private static class JellyBeanAndBeyondImpl extends SQLiteDatabaseCompat {
        private JellyBeanAndBeyondImpl() {
        }

        public void enableFeatures(@SQLiteOpenOptions int i10, SQLiteDatabase sQLiteDatabase) {
            if ((i10 & 2) != 0) {
                sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
            }
        }

        public int provideOpenFlags(@SQLiteOpenOptions int i10) {
            return (i10 & 1) != 0 ? 536870912 : 0;
        }
    }

    public @interface SQLiteOpenOptions {
    }

    public static SQLiteDatabaseCompat getInstance() {
        return sInstance;
    }

    public abstract void enableFeatures(@SQLiteOpenOptions int i10, SQLiteDatabase sQLiteDatabase);

    public abstract int provideOpenFlags(@SQLiteOpenOptions int i10);
}
