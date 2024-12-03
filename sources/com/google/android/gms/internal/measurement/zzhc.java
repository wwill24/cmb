package com.google.android.gms.internal.measurement;

import android.content.Context;

final class zzhc extends zzhz {
    private final Context zza;
    private final zzim zzb;

    zzhc(Context context, zzim zzim) {
        this.zza = context;
        this.zzb = zzim;
    }

    public final boolean equals(Object obj) {
        zzim zzim;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzhz) {
            zzhz zzhz = (zzhz) obj;
            if (!this.zza.equals(zzhz.zza()) || ((zzim = this.zzb) != null ? !zzim.equals(zzhz.zzb()) : zzhz.zzb() != null)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i10;
        int hashCode = this.zza.hashCode() ^ 1000003;
        zzim zzim = this.zzb;
        if (zzim == null) {
            i10 = 0;
        } else {
            i10 = zzim.hashCode();
        }
        return (hashCode * 1000003) ^ i10;
    }

    public final String toString() {
        String obj = this.zza.toString();
        String valueOf = String.valueOf(this.zzb);
        return "FlagsContext{context=" + obj + ", hermeticFileOverrides=" + valueOf + "}";
    }

    /* access modifiers changed from: package-private */
    public final Context zza() {
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final zzim zzb() {
        return this.zzb;
    }
}
