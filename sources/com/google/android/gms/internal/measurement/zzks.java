package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class zzks {
    private static final zzks zzb = new zzks(true);
    final zzng zza = new zzmw(16);
    private boolean zzc;
    private boolean zzd;

    private zzks() {
    }

    public static zzks zza() {
        throw null;
    }

    private static final void zzd(zzkr zzkr, Object obj) {
        boolean z10;
        zzoa zzb2 = zzkr.zzb();
        byte[] bArr = zzlj.zzd;
        obj.getClass();
        zzoa zzoa = zzoa.DOUBLE;
        zzob zzob = zzob.INT;
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
                if ((obj instanceof zzka) || (obj instanceof byte[])) {
                    return;
                }
            case 7:
                if ((obj instanceof Integer) || (obj instanceof zzld)) {
                    return;
                }
            case 8:
                if ((obj instanceof zzmi) || (obj instanceof zzln)) {
                    return;
                }
        }
        if (z10) {
            return;
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzkr.zza()), zzkr.zzb().zza(), obj.getClass().getName()}));
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzks zzks = new zzks();
        for (int i10 = 0; i10 < this.zza.zzb(); i10++) {
            Map.Entry zzg = this.zza.zzg(i10);
            zzks.zzc((zzkr) zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzks.zzc((zzkr) entry.getKey(), entry.getValue());
        }
        zzks.zzd = this.zzd;
        return zzks;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzks)) {
            return false;
        }
        return this.zza.equals(((zzks) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (!this.zzc) {
            for (int i10 = 0; i10 < this.zza.zzb(); i10++) {
                Map.Entry zzg = this.zza.zzg(i10);
                if (zzg.getValue() instanceof zzlb) {
                    ((zzlb) zzg.getValue()).zzbM();
                }
            }
            this.zza.zza();
            this.zzc = true;
        }
    }

    public final void zzc(zzkr zzkr, Object obj) {
        if (!zzkr.zzc()) {
            zzd(zzkr, obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                zzd(zzkr, arrayList.get(i10));
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzln) {
            this.zzd = true;
        }
        this.zza.put(zzkr, obj);
    }

    private zzks(boolean z10) {
        zzb();
        zzb();
    }
}
