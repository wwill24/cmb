package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrr  reason: invalid package */
public final class zzrr {
    private ArrayList zza = new ArrayList();
    private zzro zzb = zzro.zza;
    private Integer zzc = null;

    public final zzrr zza(zzbu zzbu, int i10, String str, String str2) {
        ArrayList arrayList = this.zza;
        if (arrayList != null) {
            arrayList.add(new zzrt(zzbu, i10, str, str2, (zzrs) null));
            return this;
        }
        throw new IllegalStateException("addEntry cannot be called after build()");
    }

    public final zzrr zzb(zzro zzro) {
        if (this.zza != null) {
            this.zzb = zzro;
            return this;
        }
        throw new IllegalStateException("setAnnotations cannot be called after build()");
    }

    public final zzrr zzc(int i10) {
        if (this.zza != null) {
            this.zzc = Integer.valueOf(i10);
            return this;
        }
        throw new IllegalStateException("setPrimaryKeyId cannot be called after build()");
    }

    public final zzrv zzd() throws GeneralSecurityException {
        if (this.zza != null) {
            Integer num = this.zzc;
            if (num != null) {
                int intValue = num.intValue();
                ArrayList arrayList = this.zza;
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    int zza2 = ((zzrt) arrayList.get(i10)).zza();
                    i10++;
                    if (zza2 == intValue) {
                    }
                }
                throw new GeneralSecurityException("primary key ID is not present in entries");
            }
            zzrv zzrv = new zzrv(this.zzb, Collections.unmodifiableList(this.zza), this.zzc, (zzru) null);
            this.zza = null;
            return zzrv;
        }
        throw new IllegalStateException("cannot call build() twice");
    }
}
