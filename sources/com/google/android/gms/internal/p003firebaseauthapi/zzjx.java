package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.Arrays;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjx  reason: invalid package */
public final class zzjx extends zzlg {
    /* access modifiers changed from: private */
    public static final Set zza = ((Set) zzpc.zza(zzjp.zza));
    private final zzjs zzb;
    private final zzjt zzc;
    private final zzju zzd;
    private final zzjv zze;
    private final zzce zzf;
    private final zzzo zzg;

    /* synthetic */ zzjx(zzjs zzjs, zzjt zzjt, zzju zzju, zzce zzce, zzjv zzjv, zzzo zzzo, zzjw zzjw) {
        this.zzb = zzjs;
        this.zzc = zzjt;
        this.zzd = zzju;
        this.zzf = zzce;
        this.zze = zzjv;
        this.zzg = zzzo;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzjx)) {
            return false;
        }
        zzjx zzjx = (zzjx) obj;
        if (!zzjo.zza(zzjx.zzb, this.zzb) || !zzjo.zza(zzjx.zzc, this.zzc) || !zzjo.zza(zzjx.zzd, this.zzd) || !zzjo.zza(zzjx.zzf, this.zzf) || !zzjo.zza(zzjx.zze, this.zze) || !zzjo.zza(zzjx.zzg, this.zzg)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzjx.class, this.zzb, this.zzc, this.zzd, this.zzf, this.zze, this.zzg});
    }

    public final String toString() {
        return String.format("EciesParameters(curveType=%s, hashType=%s, pointFormat=%s, demParameters=%s, variant=%s, salt=%s)", new Object[]{this.zzb, this.zzc, this.zzd, this.zzf, this.zze, this.zzg});
    }

    public final boolean zza() {
        throw null;
    }

    public final zzce zzb() {
        return this.zzf;
    }

    public final zzjs zzc() {
        return this.zzb;
    }

    public final zzjt zzd() {
        return this.zzc;
    }

    public final zzju zze() {
        return this.zzd;
    }

    public final zzjv zzf() {
        return this.zze;
    }

    public final zzzo zzg() {
        return this.zzg;
    }
}
