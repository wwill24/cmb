package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.firebase.analytics.FirebaseAnalytics;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzv  reason: invalid package */
final class zzv extends zzz {
    final /* synthetic */ zzw zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzv(zzw zzw, zzab zzab, CharSequence charSequence) {
        super(zzab, charSequence);
        this.zza = zzw;
    }

    /* access modifiers changed from: package-private */
    public final int zzc(int i10) {
        return i10 + 1;
    }

    /* access modifiers changed from: package-private */
    public final int zzd(int i10) {
        CharSequence charSequence = this.zzb;
        int length = charSequence.length();
        zzu.zzb(i10, length, FirebaseAnalytics.Param.INDEX);
        while (i10 < length) {
            zzw zzw = this.zza;
            if (zzw.zza.zza(charSequence.charAt(i10))) {
                return i10;
            }
            i10++;
        }
        return -1;
    }
}
