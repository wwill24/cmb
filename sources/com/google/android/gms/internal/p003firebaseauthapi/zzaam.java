package com.google.android.gms.internal.p003firebaseauthapi;

import android.text.TextUtils;
import com.google.firebase.auth.zze;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaam  reason: invalid package */
final class zzaam implements zzafe {
    final /* synthetic */ zzafd zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ Boolean zzd;
    final /* synthetic */ zze zze;
    final /* synthetic */ zzadx zzf;
    final /* synthetic */ zzahb zzg;

    zzaam(zzabz zzabz, zzafd zzafd, String str, String str2, Boolean bool, zze zze2, zzadx zzadx, zzahb zzahb) {
        this.zza = zzafd;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bool;
        this.zze = zze2;
        this.zzf = zzadx;
        this.zzg = zzahb;
    }

    public final void zza(String str) {
        this.zza.zza(str);
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        List list;
        List zzb2 = ((zzagr) obj).zzb();
        if (zzb2 == null || zzb2.isEmpty()) {
            this.zza.zza("No users.");
            return;
        }
        int i10 = 0;
        zzags zzags = (zzags) zzb2.get(0);
        zzahh zzl = zzags.zzl();
        if (zzl != null) {
            list = zzl.zzc();
        } else {
            list = null;
        }
        if (list != null && !list.isEmpty()) {
            if (!TextUtils.isEmpty(this.zzb)) {
                while (true) {
                    if (i10 >= list.size()) {
                        break;
                    } else if (((zzahg) list.get(i10)).zzf().equals(this.zzb)) {
                        ((zzahg) list.get(i10)).zzh(this.zzc);
                        break;
                    } else {
                        i10++;
                    }
                }
            } else {
                ((zzahg) list.get(0)).zzh(this.zzc);
            }
        }
        zzags.zzh(this.zzd.booleanValue());
        zzags.zze(this.zze);
        this.zzf.zzk(this.zzg, zzags);
    }
}
