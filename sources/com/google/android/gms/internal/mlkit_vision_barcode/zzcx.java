package com.google.android.gms.internal.mlkit_vision_barcode;

final class zzcx extends zzcf {
    static final zzcf zza = new zzcx((Object) null, new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    private zzcx(Object obj, Object[] objArr, int i10) {
        this.zzb = objArr;
        this.zzc = i10;
    }

    static zzcx zzg(int i10, Object[] objArr, zzce zzce) {
        Object obj = objArr[0];
        obj.getClass();
        Object obj2 = objArr[1];
        obj2.getClass();
        zzbj.zzb(obj, obj2);
        return new zzcx((Object) null, objArr, 1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0020 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001f A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object get(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r4.zzb
            int r1 = r4.zzc
            r2 = 0
            if (r5 != 0) goto L_0x0009
        L_0x0007:
            r5 = r2
            goto L_0x001d
        L_0x0009:
            r3 = 1
            if (r1 != r3) goto L_0x0007
            r1 = 0
            r1 = r0[r1]
            r1.getClass()
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x0007
            r5 = r0[r3]
            r5.getClass()
        L_0x001d:
            if (r5 != 0) goto L_0x0020
            return r2
        L_0x0020:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode.zzcx.get(java.lang.Object):java.lang.Object");
    }

    public final int size() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final zzby zza() {
        return new zzcw(this.zzb, 1, this.zzc);
    }

    /* access modifiers changed from: package-private */
    public final zzcg zzd() {
        return new zzcu(this, this.zzb, 0, this.zzc);
    }

    /* access modifiers changed from: package-private */
    public final zzcg zze() {
        return new zzcv(this, new zzcw(this.zzb, 0, this.zzc));
    }
}
