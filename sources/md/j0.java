package md;

import android.database.sqlite.SQLiteDatabase;
import md.m0;

public final /* synthetic */ class j0 implements m0.d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteDatabase f41207a;

    public /* synthetic */ j0(SQLiteDatabase sQLiteDatabase) {
        this.f41207a = sQLiteDatabase;
    }

    public final Object a() {
        return this.f41207a.beginTransaction();
    }
}
