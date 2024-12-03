package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzaj;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacg  reason: invalid package */
final class zzacg extends zzaez {
    private final String zza;
    private final String zzb;

    public zzacg(String str, String str2) {
        super(3);
        p.h(str, "email cannot be null or empty");
        this.zza = str;
        this.zzb = str2;
    }

    public final String zza() {
        return "fetchSignInMethodsForEmail";
    }

    public final void zzb() {
        List list;
        if (this.zzp.zzb() == null) {
            list = zzam.zzi();
        } else {
            list = (List) p.k(this.zzp.zzb());
        }
        zzm(new zzaj(list));
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzady zzady) {
        this.zzk = new zzaey(this, taskCompletionSource);
        zzady.zzl(this.zza, this.zzb, this.zzf);
    }
}
