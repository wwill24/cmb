package com.leanplum.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.leanplum.Leanplum;

public class LeanplumEventDataManager {
    private static final String COLUMN_DATA = "data";
    private static final String DATABASE_NAME = "__leanplum.db";
    private static final int DATABASE_VERSION = 1;
    private static final String EVENT_TABLE_NAME = "event";
    private static final String KEY_ROWID = "rowid";
    private static LeanplumEventDataManager instance;
    private ContentValues contentValues = new ContentValues();
    private SQLiteDatabase database;
    private LeanplumDataBaseManager databaseManager;
    private boolean hasDatabaseError = false;

    private static class LeanplumDataBaseManager extends SQLiteOpenHelper {
        LeanplumDataBaseManager(Context context) {
            super(context, LeanplumEventDataManager.DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS event(data TEXT)");
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        }
    }

    private LeanplumEventDataManager() {
        try {
            if (Leanplum.getContext() != null) {
                if (this.databaseManager == null) {
                    this.databaseManager = new LeanplumDataBaseManager(Leanplum.getContext());
                }
                this.database = this.databaseManager.getWritableDatabase();
            }
        } catch (Throwable th2) {
            handleSQLiteError("Cannot create database.", th2);
        }
    }

    private void handleSQLiteError(String str, Throwable th2) {
        Log.e(str, th2);
        if (!this.hasDatabaseError) {
            this.hasDatabaseError = true;
            Log.exception(th2);
        }
    }

    public static LeanplumEventDataManager sharedInstance() {
        if (instance == null) {
            instance = new LeanplumEventDataManager();
        }
        return instance;
    }

    /* access modifiers changed from: package-private */
    public void deleteEvents(int i10) {
        SQLiteDatabase sQLiteDatabase = this.database;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.delete("event", "rowid in (select rowid from event ORDER BY rowid ASC LIMIT " + i10 + ")", (String[]) null);
                this.hasDatabaseError = false;
            } catch (Throwable th2) {
                handleSQLiteError("Unable to delete events from the table.", th2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0052, code lost:
        if (r11 == null) goto L_0x0057;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getEvents(int r14) {
        /*
            r13 = this;
            java.lang.String r0 = "data"
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            android.database.sqlite.SQLiteDatabase r2 = r13.database
            if (r2 != 0) goto L_0x000c
            return r1
        L_0x000c:
            r11 = 0
            java.lang.String r3 = "event"
            java.lang.String[] r4 = new java.lang.String[]{r0}     // Catch:{ all -> 0x004c }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            java.lang.String r9 = "rowid ASC"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x004c }
            r10.<init>()     // Catch:{ all -> 0x004c }
            java.lang.String r12 = ""
            r10.append(r12)     // Catch:{ all -> 0x004c }
            r10.append(r14)     // Catch:{ all -> 0x004c }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x004c }
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x004c }
            r14 = 0
            r13.hasDatabaseError = r14     // Catch:{ all -> 0x004c }
        L_0x0031:
            boolean r14 = r11.moveToNext()     // Catch:{ all -> 0x004c }
            if (r14 == 0) goto L_0x0054
            org.json.b r14 = new org.json.b     // Catch:{ all -> 0x004c }
            int r2 = r11.getColumnIndex(r0)     // Catch:{ all -> 0x004c }
            java.lang.String r2 = r11.getString(r2)     // Catch:{ all -> 0x004c }
            r14.<init>((java.lang.String) r2)     // Catch:{ all -> 0x004c }
            java.util.Map r14 = com.leanplum.internal.JsonConverter.mapFromJson(r14)     // Catch:{ all -> 0x004c }
            r1.add(r14)     // Catch:{ all -> 0x004c }
            goto L_0x0031
        L_0x004c:
            r14 = move-exception
            java.lang.String r0 = "Unable to get events from the table."
            r13.handleSQLiteError(r0, r14)     // Catch:{ all -> 0x0058 }
            if (r11 == 0) goto L_0x0057
        L_0x0054:
            r11.close()
        L_0x0057:
            return r1
        L_0x0058:
            r14 = move-exception
            if (r11 == 0) goto L_0x005e
            r11.close()
        L_0x005e:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.leanplum.internal.LeanplumEventDataManager.getEvents(int):java.util.List");
    }

    /* access modifiers changed from: package-private */
    public long getEventsCount() {
        SQLiteDatabase sQLiteDatabase = this.database;
        long j10 = 0;
        if (sQLiteDatabase == null) {
            return 0;
        }
        try {
            j10 = DatabaseUtils.queryNumEntries(sQLiteDatabase, "event");
            this.hasDatabaseError = false;
            return j10;
        } catch (Throwable th2) {
            handleSQLiteError("Unable to get a number of rows in the table.", th2);
            return j10;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean hasDatabaseError() {
        return this.hasDatabaseError;
    }

    /* access modifiers changed from: package-private */
    public void insertEvent(String str) {
        if (this.database != null) {
            this.contentValues.put("data", str);
            try {
                this.database.insert("event", (String) null, this.contentValues);
                this.hasDatabaseError = false;
            } catch (Throwable th2) {
                handleSQLiteError("Unable to insert event to database.", th2);
            }
            this.contentValues.clear();
        }
    }
}
