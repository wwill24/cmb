package com.google.android.gms.internal.play_billing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class zzbs {
    private static final zzbs zzb = new zzbs(true);
    final zzec zza = new zzds(16);
    private boolean zzc;
    private boolean zzd;

    private zzbs() {
    }

    public static zzbs zza() {
        throw null;
    }

    private static final void zzd(zzbr zzbr, Object obj) {
        boolean z10;
        zzew zzb2 = zzbr.zzb();
        byte[] bArr = zzcg.zzd;
        obj.getClass();
        zzew zzew = zzew.DOUBLE;
        zzex zzex = zzex.INT;
        switch (zzb2.zza().ordinal()) {
            case 0:
                z10 = obj instanceof Integer;
                break;
            case 1:
                z10 = obj instanceof Long;
                break;
            case 2:
                z10 = obj instanceof Float;
                break;
            case 3:
                z10 = obj instanceof Double;
                break;
            case 4:
                z10 = obj instanceof Boolean;
                break;
            case 5:
                z10 = obj instanceof String;
                break;
            case 6:
                if ((obj instanceof zzba) || (obj instanceof byte[])) {
                    return;
                }
            case 7:
                if ((obj instanceof Integer) || (obj instanceof zzfp)) {
                    return;
                }
            case 8:
                if ((obj instanceof zzdf) || (obj instanceof zzck)) {
                    return;
                }
        }
        if (z10) {
            return;
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzbr.zza()), zzbr.zzb().zza(), obj.getClass().getName()}));
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzbs zzbs = new zzbs();
        for (int i10 = 0; i10 < this.zza.zzb(); i10++) {
            Map.Entry zzg = this.zza.zzg(i10);
            zzbs.zzc((zzbr) zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzbs.zzc((zzbr) entry.getKey(), entry.getValue());
        }
        zzbs.zzd = this.zzd;
        return zzbs;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbs)) {
            return false;
        }
        return this.zza.equals(((zzbs) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (!this.zzc) {
            for (int i10 = 0; i10 < this.zza.zzb(); i10++) {
                Map.Entry zzg = this.zza.zzg(i10);
                if (zzg.getValue() instanceof zzcb) {
                    ((zzcb) zzg.getValue()).zzm();
                }
            }
            this.zza.zza();
            this.zzc = true;
        }
    }

    public final void zzc(zzbr zzbr, Object obj) {
        if (!zzbr.zzc()) {
            zzd(zzbr, obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                zzd(zzbr, arrayList.get(i10));
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzck) {
            this.zzd = true;
        }
        this.zza.put(zzbr, obj);
    }

    private zzbs(boolean z10) {
        zzb();
        zzb();
    }
}
