package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.MultiFactor;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.MultiFactorSession;
import java.util.List;

public final class zzac extends MultiFactor {
    /* access modifiers changed from: private */
    public final zzx zza;

    public zzac(zzx zzx) {
        p.k(zzx);
        this.zza = zzx;
    }

    public final Task<Void> enroll(MultiFactorAssertion multiFactorAssertion, String str) {
        p.k(multiFactorAssertion);
        zzx zzx = this.zza;
        return FirebaseAuth.getInstance(zzx.zza()).zzb(zzx, multiFactorAssertion, str);
    }

    public final List<MultiFactorInfo> getEnrolledFactors() {
        return this.zza.zzn();
    }

    public final Task<MultiFactorSession> getSession() {
        return this.zza.getIdToken(false).continueWithTask(new zzab(this));
    }

    public final Task<Void> unenroll(MultiFactorInfo multiFactorInfo) {
        p.k(multiFactorInfo);
        String uid = multiFactorInfo.getUid();
        p.g(uid);
        zzx zzx = this.zza;
        return FirebaseAuth.getInstance(zzx.zza()).zzo(zzx, uid);
    }

    public final Task<Void> unenroll(String str) {
        p.g(str);
        zzx zzx = this.zza;
        return FirebaseAuth.getInstance(zzx.zza()).zzo(zzx, str);
    }
}
