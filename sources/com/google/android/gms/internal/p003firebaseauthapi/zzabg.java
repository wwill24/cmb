package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabg  reason: invalid package */
final class zzabg implements zzafe {
    final /* synthetic */ zzabh zza;

    zzabg(zzabh zzabh) {
        this.zza = zzabh;
    }

    public final void zza(String str) {
        this.zza.zzb.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzagh zzagh = (zzagh) obj;
        zzahb zzahb = new zzahb(zzagh.zzc(), zzagh.zzb(), Long.valueOf(zzahd.zza(zzagh.zzb())), "Bearer");
        Boolean bool = Boolean.FALSE;
        zzabh zzabh = this.zza;
        zzabh.zzc.zzR(zzahb, (String) null, (String) null, bool, (zze) null, zzabh.zzb, this);
    }
}
