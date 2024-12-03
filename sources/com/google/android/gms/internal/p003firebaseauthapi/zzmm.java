package com.google.android.gms.internal.p003firebaseauthapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.io.IOException;

@Deprecated
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmm  reason: invalid package */
final class zzmm implements zzca {
    private final SharedPreferences.Editor zza;
    private final String zzb;

    public zzmm(Context context, String str, String str2) {
        if (str != null) {
            this.zzb = str;
            Context applicationContext = context.getApplicationContext();
            if (str2 == null) {
                this.zza = PreferenceManager.getDefaultSharedPreferences(applicationContext).edit();
            } else {
                this.zza = applicationContext.getSharedPreferences(str2, 0).edit();
            }
        } else {
            throw new IllegalArgumentException("keysetName cannot be null");
        }
    }

    public final void zzb(zzva zzva) throws IOException {
        if (!this.zza.putString(this.zzb, zzze.zza(zzva.zzq())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
    }

    public final void zzc(zzwv zzwv) throws IOException {
        if (!this.zza.putString(this.zzb, zzze.zza(zzwv.zzq())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
    }
}
