package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabu  reason: invalid package */
final class zzabu implements zzafe {
    final /* synthetic */ UserProfileChangeRequest zza;
    final /* synthetic */ zzadx zzb;
    final /* synthetic */ zzabz zzc;

    zzabu(zzabz zzabz, UserProfileChangeRequest userProfileChangeRequest, zzadx zzadx) {
        this.zzc = zzabz;
        this.zza = userProfileChangeRequest;
        this.zzb = zzadx;
    }

    public final void zza(String str) {
        this.zzb.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzahb zzahb = (zzahb) obj;
        zzahn zzahn = new zzahn();
        zzahn.zze(zzahb.zze());
        if (this.zza.zzb() || this.zza.getDisplayName() != null) {
            zzahn.zzc(this.zza.getDisplayName());
        }
        if (this.zza.zzc() || this.zza.getPhotoUri() != null) {
            zzahn.zzh(this.zza.zza());
        }
        zzabz.zze(this.zzc, this.zzb, zzahb, zzahn, this);
    }
}
