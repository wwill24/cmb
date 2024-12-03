package com.google.android.gms.internal.mlkit_vision_text_common;

final class zzcl extends zzbo {
    static final zzbo zza = new zzcl((Object) null, new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    private zzcl(Object obj, Object[] objArr, int i10) {
        this.zzb = objArr;
        this.zzc = i10;
    }

    static zzcl zzg(int i10, Object[] objArr, zzbn zzbn) {
        Object obj = objArr[0];
        obj.getClass();
        Object obj2 = objArr[1];
        obj2.getClass();
        zzat.zzb(obj, obj2);
        return new zzcl((Object) null, objArr, 1);
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_text_common.zzcl.get(java.lang.Object):java.lang.Object");
    }

    public final int size() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final zzbh zza() {
        return new zzck(this.zzb, 1, this.zzc);
    }

    /* access modifiers changed from: package-private */
    public final zzbp zzd() {
        return new zzci(this, this.zzb, 0, this.zzc);
    }

    /* access modifiers changed from: package-private */
    public final zzbp zze() {
        return new zzcj(this, new zzck(this.zzb, 0, this.zzc));
    }
}
