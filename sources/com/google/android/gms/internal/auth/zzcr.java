package com.google.android.gms.internal.auth;

import android.net.Uri;
import androidx.collection.a;

public final class zzcr {
    private static final a zza = new a();

    public static synchronized Uri zza(String str) {
        synchronized (zzcr.class) {
            a aVar = zza;
            Uri uri = (Uri) aVar.get("com.google.android.gms.auth_account");
            if (uri != null) {
                return uri;
            }
            Uri parse = Uri.parse("content://com.google.android.gms.phenotype/".concat(String.valueOf(Uri.encode("com.google.android.gms.auth_account"))));
            aVar.put("com.google.android.gms.auth_account", parse);
            return parse;
        }
    }
}
