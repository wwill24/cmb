package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.HashMap;
import rd.m;

public final class zzav extends m<zzav> {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("appName", this.zza);
        hashMap.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, this.zzb);
        hashMap.put("appId", this.zzc);
        hashMap.put("appInstallerId", this.zzd);
        return m.zza(hashMap);
    }

    public final String zzd() {
        return this.zzc;
    }

    public final String zze() {
        return this.zzd;
    }

    public final String zzf() {
        return this.zza;
    }

    public final String zzg() {
        return this.zzb;
    }

    /* renamed from: zzh */
    public final void zzc(zzav zzav) {
        if (!TextUtils.isEmpty(this.zza)) {
            zzav.zza = this.zza;
        }
        if (!TextUtils.isEmpty(this.zzb)) {
            zzav.zzb = this.zzb;
        }
        if (!TextUtils.isEmpty(this.zzc)) {
            zzav.zzc = this.zzc;
        }
        if (!TextUtils.isEmpty(this.zzd)) {
            zzav.zzd = this.zzd;
        }
    }

    public final void zzi(String str) {
        this.zzc = str;
    }

    public final void zzj(String str) {
        this.zzd = str;
    }

    public final void zzk(String str) {
        this.zza = str;
    }

    public final void zzl(String str) {
        this.zzb = str;
    }
}
