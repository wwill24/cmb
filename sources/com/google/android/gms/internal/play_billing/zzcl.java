package com.google.android.gms.internal.play_billing;

public class zzcl {
    private static final zzbn zzb = zzbn.zza;
    protected volatile zzdf zza;
    private volatile zzba zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcl)) {
            return false;
        }
        zzcl zzcl = (zzcl) obj;
        zzdf zzdf = this.zza;
        zzdf zzdf2 = zzcl.zza;
        if (zzdf == null && zzdf2 == null) {
            return zzb().equals(zzcl.zzb());
        }
        if (zzdf != null && zzdf2 != null) {
            return zzdf.equals(zzdf2);
        }
        if (zzdf != null) {
            zzcl.zzc(zzdf.zzf());
            return zzdf.equals(zzcl.zza);
        }
        zzc(zzdf2.zzf());
        return this.zza.equals(zzdf2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzax) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzd();
        }
        return 0;
    }

    public final zzba zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                zzba zzba = this.zzc;
                return zzba;
            }
            if (this.zza == null) {
                this.zzc = zzba.zzb;
            } else {
                this.zzc = this.zza.zzb();
            }
            zzba zzba2 = this.zzc;
            return zzba2;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(com.google.android.gms.internal.play_billing.zzdf r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.play_billing.zzdf r0 = r1.zza
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r1)
            com.google.android.gms.internal.play_billing.zzdf r0 = r1.zza     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            r1.zza = r2     // Catch:{ zzci -> 0x0011 }
            com.google.android.gms.internal.play_billing.zzba r0 = com.google.android.gms.internal.play_billing.zzba.zzb     // Catch:{ zzci -> 0x0011 }
            r1.zzc = r0     // Catch:{ zzci -> 0x0011 }
            goto L_0x0017
        L_0x0011:
            r1.zza = r2     // Catch:{ all -> 0x001b }
            com.google.android.gms.internal.play_billing.zzba r2 = com.google.android.gms.internal.play_billing.zzba.zzb     // Catch:{ all -> 0x001b }
            r1.zzc = r2     // Catch:{ all -> 0x001b }
        L_0x0017:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x0019:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x001b:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzcl.zzc(com.google.android.gms.internal.play_billing.zzdf):void");
    }
}
