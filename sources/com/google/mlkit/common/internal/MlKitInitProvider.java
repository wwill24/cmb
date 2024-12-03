package com.google.mlkit.common.internal;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.mlkit.common.sdkinternal.i;

public class MlKitInitProvider extends ContentProvider {
    public final void attachInfo(@NonNull Context context, @NonNull ProviderInfo providerInfo) {
        p.p(!providerInfo.authority.equals("com.google.mlkit.common.mlkitinitprovider"), "Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
        super.attachInfo(context, providerInfo);
    }

    public final int delete(@NonNull Uri uri, String str, String[] strArr) {
        return 0;
    }

    public final String getType(@NonNull Uri uri) {
        return null;
    }

    public final Uri insert(@NonNull Uri uri, ContentValues contentValues) {
        return null;
    }

    public final boolean onCreate() {
        Context context = getContext();
        if (context == null) {
            return false;
        }
        i.d(context);
        return false;
    }

    public final Cursor query(@NonNull Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public final int update(@NonNull Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
