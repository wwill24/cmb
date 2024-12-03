package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.common.api.a;
import java.util.Arrays;

class zzbw extends zzbx {
    Object[] zza = new Object[4];
    int zzb = 0;
    boolean zzc;

    zzbw(int i10) {
    }

    private final void zzd(int i10) {
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (length < i10) {
            int i11 = length + (length >> 1) + 1;
            if (i11 < i10) {
                int highestOneBit = Integer.highestOneBit(i10 - 1);
                i11 = highestOneBit + highestOneBit;
            }
            if (i11 < 0) {
                i11 = a.e.API_PRIORITY_OTHER;
            }
            this.zza = Arrays.copyOf(objArr, i11);
            this.zzc = false;
        } else if (this.zzc) {
            this.zza = (Object[]) objArr.clone();
            this.zzc = false;
        }
    }

    public final zzbw zza(Object obj) {
        obj.getClass();
        zzd(this.zzb + 1);
        Object[] objArr = this.zza;
        int i10 = this.zzb;
        this.zzb = i10 + 1;
        objArr[i10] = obj;
        return this;
    }

    public /* bridge */ /* synthetic */ zzbx zzb(Object obj) {
        throw null;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.util.Collection, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.mlkit_vision_barcode.zzbx zzc(java.lang.Iterable r3) {
        /*
            r2 = this;
            boolean r0 = r3 instanceof java.util.Collection
            if (r0 == 0) goto L_0x0020
            int r0 = r2.zzb
            int r1 = r3.size()
            int r0 = r0 + r1
            r2.zzd(r0)
            boolean r0 = r3 instanceof com.google.android.gms.internal.mlkit_vision_barcode.zzby
            if (r0 != 0) goto L_0x0013
            goto L_0x0020
        L_0x0013:
            com.google.android.gms.internal.mlkit_vision_barcode.zzby r3 = (com.google.android.gms.internal.mlkit_vision_barcode.zzby) r3
            java.lang.Object[] r0 = r2.zza
            int r1 = r2.zzb
            int r3 = r3.zza(r0, r1)
            r2.zzb = r3
            return r2
        L_0x0020:
            java.util.Iterator r3 = r3.iterator()
        L_0x0024:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0032
            java.lang.Object r0 = r3.next()
            r2.zzb(r0)
            goto L_0x0024
        L_0x0032:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode.zzbw.zzc(java.lang.Iterable):com.google.android.gms.internal.mlkit_vision_barcode.zzbx");
    }
}
