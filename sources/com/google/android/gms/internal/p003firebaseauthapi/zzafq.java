package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.b;
import he.a;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafq  reason: invalid package */
final class zzafq extends zzadx {
    final /* synthetic */ zzaft zza;
    private final String zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzafq(zzaft zzaft, zzadx zzadx, String str) {
        super(zzadx);
        this.zza = zzaft;
        this.zzb = str;
    }

    public final void zzb(String str) {
        zzaft.zza.a("onCodeSent", new Object[0]);
        zzafs zzafs = (zzafs) this.zza.zzd.get(this.zzb);
        if (zzafs != null) {
            for (zzadx zzb2 : zzafs.zzb) {
                zzb2.zzb(str);
            }
            zzafs.zzg = true;
            zzafs.zzd = str;
            if (zzafs.zza <= 0) {
                this.zza.zzg(this.zzb);
            } else if (!zzafs.zzc) {
                this.zza.zzm(this.zzb);
            } else if (!zzac.zzd(zzafs.zze)) {
                zzaft.zzd(this.zza, this.zzb);
            }
        }
    }

    public final void zzh(Status status) {
        a zza2 = zzaft.zza;
        String a10 = b.a(status.Y());
        String c02 = status.c0();
        zza2.c("SMS verification code request failed: " + a10 + " " + c02, new Object[0]);
        zzafs zzafs = (zzafs) this.zza.zzd.get(this.zzb);
        if (zzafs != null) {
            for (zzadx zzh : zzafs.zzb) {
                zzh.zzh(status);
            }
            this.zza.zzi(this.zzb);
        }
    }
}
