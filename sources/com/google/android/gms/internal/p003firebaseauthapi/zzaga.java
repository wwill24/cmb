package com.google.android.gms.internal.p003firebaseauthapi;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaga  reason: invalid package */
public final class zzaga implements zzaek {
    private static final String zza = "com.google.android.gms.internal.firebase-auth-api.zzaga";
    private String zzb;

    public final /* bridge */ /* synthetic */ zzaek zza(@NonNull String str) throws zzaca {
        zzb(str);
        return this;
    }

    public final zzaga zzb(@NonNull String str) throws zzaca {
        try {
            b bVar = new b(new b(str).getString("error"));
            bVar.getInt("code");
            this.zzb = bVar.getString("message");
            return this;
        } catch (NullPointerException | JSONException e10) {
            String message = e10.getMessage();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to parse error for string [");
            sb2.append(str);
            sb2.append("] with exception: ");
            sb2.append(message);
            throw new zzaca("Failed to parse error for string [" + str + "]", e10);
        }
    }

    public final String zzc() {
        return this.zzb;
    }

    public final boolean zzd() {
        return !TextUtils.isEmpty(this.zzb);
    }
}
