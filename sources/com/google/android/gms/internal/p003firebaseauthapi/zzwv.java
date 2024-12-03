package com.google.android.gms.internal.p003firebaseauthapi;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwv  reason: invalid package */
public final class zzwv extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zzwv zzb;
    /* access modifiers changed from: private */
    public int zzd;
    private zzakp zze = zzakk.zzA();

    static {
        zzwv zzwv = new zzwv();
        zzb = zzwv;
        zzakk.zzH(zzwv.class, zzwv);
    }

    private zzwv() {
    }

    public static zzws zzc() {
        return (zzws) zzb.zzt();
    }

    public static zzwv zzf(InputStream inputStream, zzajx zzajx) throws IOException {
        return (zzwv) zzakk.zzy(zzb, inputStream, zzajx);
    }

    public static zzwv zzg(byte[] bArr, zzajx zzajx) throws zzaks {
        return (zzwv) zzakk.zzz(zzb, bArr, zzajx);
    }

    static /* synthetic */ void zzk(zzwv zzwv, zzwu zzwu) {
        zzwu.getClass();
        zzakp zzakp = zzwv.zze;
        if (!zzakp.zzc()) {
            zzwv.zze = zzakk.zzB(zzakp);
        }
        zzwv.zze.add(zzwu);
    }

    public final int zza() {
        return this.zze.size();
    }

    public final int zzb() {
        return this.zzd;
    }

    public final zzwu zzd(int i10) {
        return (zzwu) this.zze.get(i10);
    }

    public final List zzh() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzakk.zzE(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzd", "zze", zzwu.class});
        } else if (i11 == 3) {
            return new zzwv();
        } else {
            if (i11 == 4) {
                return new zzws((zzwr) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
