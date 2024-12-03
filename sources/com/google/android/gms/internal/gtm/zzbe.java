package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.leanplum.internal.Constants;
import java.util.HashMap;
import rd.m;

public final class zzbe extends m<zzbe> {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private boolean zze;
    private boolean zzf;

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("hitType", this.zza);
        hashMap.put("clientId", this.zzb);
        hashMap.put(Constants.Params.USER_ID, this.zzc);
        hashMap.put("androidAdId", this.zzd);
        hashMap.put("AdTargetingEnabled", Boolean.valueOf(this.zze));
        hashMap.put("sessionControl", (Object) null);
        hashMap.put("nonInteraction", Boolean.valueOf(this.zzf));
        hashMap.put("sampleRate", Double.valueOf(0.0d));
        return m.zza(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zzc(m mVar) {
        zzbe zzbe = (zzbe) mVar;
        if (!TextUtils.isEmpty(this.zza)) {
            zzbe.zza = this.zza;
        }
        if (!TextUtils.isEmpty(this.zzb)) {
            zzbe.zzb = this.zzb;
        }
        if (!TextUtils.isEmpty(this.zzc)) {
            zzbe.zzc = this.zzc;
        }
        if (!TextUtils.isEmpty(this.zzd)) {
            zzbe.zzd = this.zzd;
        }
        if (this.zze) {
            zzbe.zze = true;
        }
        TextUtils.isEmpty((CharSequence) null);
        if (this.zzf) {
            zzbe.zzf = true;
        }
    }

    public final String zzd() {
        return this.zzd;
    }

    public final String zze() {
        return this.zzb;
    }

    public final String zzf() {
        return this.zza;
    }

    public final String zzg() {
        return this.zzc;
    }

    public final void zzh(boolean z10) {
        this.zze = z10;
    }

    public final void zzi(String str) {
        this.zzd = str;
    }

    public final void zzj(String str) {
        this.zzb = str;
    }

    public final void zzk(String str) {
        this.zza = "data";
    }

    public final void zzl(boolean z10) {
        this.zzf = true;
    }

    public final void zzm(String str) {
        this.zzc = str;
    }

    public final boolean zzn() {
        return this.zze;
    }

    public final boolean zzo() {
        return this.zzf;
    }
}
