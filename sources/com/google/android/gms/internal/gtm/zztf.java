package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.api.a;
import java.io.IOException;

final class zztf extends zztj {
    private final byte[] zze;
    private int zzf;
    private int zzg;
    private int zzh = a.e.API_PRIORITY_OTHER;

    /* synthetic */ zztf(byte[] bArr, int i10, int i11, boolean z10, zzte zzte) {
        super((zzti) null);
        this.zze = bArr;
        this.zzf = 0;
    }

    public final int zza() {
        throw null;
    }

    public final int zzb(int i10) throws zzvk {
        int i11 = this.zzh;
        this.zzh = 0;
        int i12 = this.zzf + this.zzg;
        this.zzf = i12;
        if (i12 > 0) {
            this.zzg = i12;
            this.zzf = 0;
        } else {
            this.zzg = 0;
        }
        return i11;
    }

    public final int zzc() throws IOException {
        throw null;
    }

    public final zztd zzd() throws IOException {
        throw null;
    }

    public final String zze() throws IOException {
        throw null;
    }

    public final String zzf() throws IOException {
        throw null;
    }

    public final void zzg(int i10) throws zzvk {
        throw null;
    }

    public final void zzh(int i10) {
        throw null;
    }

    public final boolean zzi() throws IOException {
        throw null;
    }

    public final boolean zzj() throws IOException {
        throw null;
    }

    public final boolean zzk(int i10) throws IOException {
        throw null;
    }
}
