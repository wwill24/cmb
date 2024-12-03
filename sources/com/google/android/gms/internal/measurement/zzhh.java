package com.google.android.gms.internal.measurement;

import android.net.Uri;
import androidx.collection.g;

public final class zzhh {
    private final g zza;

    zzhh(g gVar) {
        this.zza = gVar;
    }

    public final String zza(Uri uri, String str, String str2, String str3) {
        g gVar;
        if (uri != null) {
            gVar = (g) this.zza.get(uri.toString());
        } else {
            gVar = null;
        }
        if (gVar == null) {
            return null;
        }
        return (String) gVar.get("".concat(str3));
    }
}
