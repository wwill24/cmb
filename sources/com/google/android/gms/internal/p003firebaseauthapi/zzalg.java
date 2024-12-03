package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzalg  reason: invalid package */
final class zzalg implements zzaln {
    private final zzaln[] zza;

    zzalg(zzaln... zzalnArr) {
        this.zza = zzalnArr;
    }

    public final zzalm zzb(Class cls) {
        for (int i10 = 0; i10 < 2; i10++) {
            zzaln zzaln = this.zza[i10];
            if (zzaln.zzc(cls)) {
                return zzaln.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    public final boolean zzc(Class cls) {
        for (int i10 = 0; i10 < 2; i10++) {
            if (this.zza[i10].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
