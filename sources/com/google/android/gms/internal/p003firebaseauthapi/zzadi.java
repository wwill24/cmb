package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzag;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadi  reason: invalid package */
final class zzadi extends zzaez {
    private final boolean zzC;
    private final boolean zzD;
    private final String zzE;
    private final String zzF;
    private final boolean zzG;
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final long zzd;

    public zzadi(zzag zzag, String str, String str2, long j10, boolean z10, boolean z11, String str3, String str4, boolean z12) {
        super(8);
        p.k(zzag);
        p.g(str);
        this.zza = p.g(zzag.zzd());
        this.zzb = str;
        this.zzc = str2;
        this.zzd = j10;
        this.zzC = z10;
        this.zzD = z11;
        this.zzE = str3;
        this.zzF = str4;
        this.zzG = z12;
    }

    public final String zza() {
        return "startMfaEnrollment";
    }

    public final void zzb() {
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzady zzady) {
        this.zzk = new zzaey(this, taskCompletionSource);
        zzady.zzB(this.zza, this.zzb, this.zzc, this.zzd, this.zzC, this.zzD, this.zzE, this.zzF, this.zzG, this.zzf);
    }
}
