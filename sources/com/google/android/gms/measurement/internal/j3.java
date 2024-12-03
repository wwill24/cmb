package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.leanplum.internal.Constants;

final class j3 extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k3 f39952a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    j3(k3 k3Var, Context context, String str) {
        super(context, "google_app_measurement_local.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.f39952a = k3Var;
    }

    public final SQLiteDatabase getWritableDatabase() throws SQLiteException {
        try {
            return super.getWritableDatabase();
        } catch (SQLiteDatabaseLockedException e10) {
            throw e10;
        } catch (SQLiteException unused) {
            this.f39952a.f40059a.d().r().a("Opening the local database failed, dropping and recreating it");
            this.f39952a.f40059a.z();
            if (!this.f39952a.f40059a.c().getDatabasePath("google_app_measurement_local.db").delete()) {
                this.f39952a.f40059a.d().r().b("Failed to delete corrupted local db file", "google_app_measurement_local.db");
            }
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException e11) {
                this.f39952a.f40059a.d().r().b("Failed to open local database. Events will bypass local storage", e11);
                return null;
            }
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        l.b(this.f39952a.f40059a.d(), sQLiteDatabase);
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }

    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        l.a(this.f39952a.f40059a.d(), sQLiteDatabase, Constants.Keys.MESSAGES, "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", (String[]) null);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }
}
