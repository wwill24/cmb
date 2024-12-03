package com.google.android.gms.internal.p003firebaseauthapi;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzva  reason: invalid package */
public final class zzva extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zzva zzb;
    private int zzd;
    /* access modifiers changed from: private */
    public zzajf zze = zzajf.zzb;
    private zzxa zzf;

    static {
        zzva zzva = new zzva();
        zzb = zzva;
        zzakk.zzH(zzva.class, zzva);
    }

    private zzva() {
    }

    public static zzuz zza() {
        return (zzuz) zzb.zzt();
    }

    public static zzva zzc(InputStream inputStream, zzajx zzajx) throws IOException {
        return (zzva) zzakk.zzy(zzb, inputStream, zzajx);
    }

    static /* synthetic */ void zzf(zzva zzva, zzxa zzxa) {
        zzxa.getClass();
        zzva.zzf = zzxa;
        zzva.zzd |= 1;
    }

    public final zzajf zzd() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzakk.zzE(zzb, "\u0000\u0002\u0000\u0001\u0002\u0003\u0002\u0000\u0000\u0000\u0002\n\u0003ဉ\u0000", new Object[]{"zzd", "zze", "zzf"});
        } else if (i11 == 3) {
            return new zzva();
        } else {
            if (i11 == 4) {
                return new zzuz((zzuy) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
