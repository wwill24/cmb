package com.squareup.picasso;

import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;

public final class PicassoProvider extends ContentProvider {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    static Context f23051a;

    public int delete(@NonNull Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(@NonNull Uri uri) {
        return null;
    }

    public Uri insert(@NonNull Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        f23051a = getContext();
        return true;
    }

    public Cursor query(@NonNull Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(@NonNull Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
