package io.sentry.android.core;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import io.sentry.android.core.internal.util.d;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
abstract class o0 extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    private final d f31076a = new d();

    o0() {
    }

    public final int delete(Uri uri, String str, String[] strArr) {
        this.f31076a.a(this);
        return 0;
    }

    public final Uri insert(Uri uri, ContentValues contentValues) {
        this.f31076a.a(this);
        return null;
    }

    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        this.f31076a.a(this);
        return null;
    }

    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        this.f31076a.a(this);
        return 0;
    }
}
