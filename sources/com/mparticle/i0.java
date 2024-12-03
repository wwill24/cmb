package com.mparticle;

import android.content.ContentValues;

public abstract class i0 {
    public abstract String a();

    public void a(w wVar, long j10, long j11) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mp_id", Long.valueOf(j11));
        wVar.a(a(), contentValues, "mp_id = ?", new String[]{String.valueOf(j10)});
    }
}
