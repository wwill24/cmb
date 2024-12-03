package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.p;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

final class zzfd {
    final /* synthetic */ zzfe zza;
    private int zzb;
    private final ByteArrayOutputStream zzc = new ByteArrayOutputStream();

    public zzfd(zzfe zzfe) {
        this.zza = zzfe;
    }

    public final int zza() {
        return this.zzb;
    }

    public final boolean zzb(zzex zzex) {
        p.k(zzex);
        int i10 = this.zzb;
        this.zza.zzw();
        if (i10 + 1 > zzct.zzg()) {
            return false;
        }
        String zza2 = this.zza.zza(zzex, false);
        if (zza2 == null) {
            this.zza.zzz().zzb(zzex, "Error formatting hit");
            return true;
        }
        byte[] bytes = zza2.getBytes();
        int length = bytes.length;
        this.zza.zzw();
        if (length > zzct.zzf()) {
            this.zza.zzz().zzb(zzex, "Hit size exceeds the maximum size limit");
            return true;
        }
        if (this.zzc.size() > 0) {
            length++;
        }
        int size = this.zzc.size();
        this.zza.zzw();
        if (size + length > zzeu.zzA.zzb().intValue()) {
            return false;
        }
        try {
            if (this.zzc.size() > 0) {
                this.zzc.write(zzfe.zza);
            }
            this.zzc.write(bytes);
            this.zzb++;
            return true;
        } catch (IOException e10) {
            this.zza.zzK("Failed to write payload when batching hits", e10);
            return true;
        }
    }

    public final byte[] zzc() {
        return this.zzc.toByteArray();
    }
}
