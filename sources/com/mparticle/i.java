package com.mparticle;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class i extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    Context f22320a;

    /* renamed from: b  reason: collision with root package name */
    m0 f22321b = a();

    public i(Context context) {
        super(context, e0.a(), (SQLiteDatabase.CursorFactory) null, 9);
        this.f22320a = context;
    }

    /* access modifiers changed from: protected */
    public m0 a() {
        return new e0(this.f22320a);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.f22321b.a(sQLiteDatabase);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        this.f22321b.b(sQLiteDatabase, i10, i11);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        this.f22321b.a(sQLiteDatabase, i10, i11);
    }
}
