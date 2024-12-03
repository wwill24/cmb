package com.google.android.gms.internal.p003firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.internal.p;
import java.util.ArrayList;
import java.util.List;
import me.c;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaal  reason: invalid package */
final class zzaal implements zzafe {
    final /* synthetic */ zzahn zza;
    final /* synthetic */ zzags zzb;
    final /* synthetic */ zzadx zzc;
    final /* synthetic */ zzahb zzd;
    final /* synthetic */ zzafd zze;
    final /* synthetic */ zzabz zzf;

    zzaal(zzabz zzabz, zzahn zzahn, zzags zzags, zzadx zzadx, zzahb zzahb, zzafd zzafd) {
        this.zzf = zzabz;
        this.zza = zzahn;
        this.zzb = zzags;
        this.zzc = zzadx;
        this.zzd = zzahb;
        this.zze = zzafd;
    }

    public final void zza(String str) {
        this.zze.zza(str);
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzaho zzaho = (zzaho) obj;
        if (this.zza.zzn("EMAIL")) {
            this.zzb.zzg((String) null);
        } else {
            zzahn zzahn = this.zza;
            if (zzahn.zzk() != null) {
                this.zzb.zzg(zzahn.zzk());
            }
        }
        if (this.zza.zzn("DISPLAY_NAME")) {
            this.zzb.zzf((String) null);
        } else {
            zzahn zzahn2 = this.zza;
            if (zzahn2.zzj() != null) {
                this.zzb.zzf(zzahn2.zzj());
            }
        }
        if (this.zza.zzn("PHOTO_URL")) {
            this.zzb.zzj((String) null);
        } else {
            zzahn zzahn3 = this.zza;
            if (zzahn3.zzm() != null) {
                this.zzb.zzj(zzahn3.zzm());
            }
        }
        if (!TextUtils.isEmpty(this.zza.zzl())) {
            this.zzb.zzi(c.c("redacted".getBytes()));
        }
        List zzf2 = zzaho.zzf();
        if (zzf2 == null) {
            zzf2 = new ArrayList();
        }
        this.zzb.zzk(zzf2);
        zzadx zzadx = this.zzc;
        zzahb zzahb = this.zzd;
        p.k(zzahb);
        p.k(zzaho);
        String zzd2 = zzaho.zzd();
        String zze2 = zzaho.zze();
        if (!TextUtils.isEmpty(zzd2) && !TextUtils.isEmpty(zze2)) {
            zzahb = new zzahb(zze2, zzd2, Long.valueOf(zzaho.zzb()), zzahb.zzg());
        }
        zzadx.zzk(zzahb, this.zzb);
    }
}
