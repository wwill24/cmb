package com.google.android.gms.internal.auth;

import android.net.Uri;
import androidx.collection.g;

public final class zzci {
    private final g zza;

    zzci(g gVar) {
        this.zza = gVar;
    }

    public final String zza(Uri uri, String str, String str2, String str3) {
        if (uri == null) {
            return null;
        }
        g gVar = (g) this.zza.get(uri.toString());
        if (gVar == null) {
            return null;
        }
        return (String) gVar.get("".concat(String.valueOf(str3)));
    }
}
