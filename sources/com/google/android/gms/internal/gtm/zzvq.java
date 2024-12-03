package com.google.android.gms.internal.gtm;

public class zzvq {
    private static final zzuj zzb = zzuj.zza();
    protected volatile zzwk zza;
    private volatile zztd zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzvq)) {
            return false;
        }
        zzvq zzvq = (zzvq) obj;
        zzwk zzwk = this.zza;
        zzwk zzwk2 = zzvq.zza;
        if (zzwk == null && zzwk2 == null) {
            return zzb().equals(zzvq.zzb());
        }
        if (zzwk != null && zzwk2 != null) {
            return zzwk.equals(zzwk2);
        }
        if (zzwk != null) {
            zzvq.zzd(zzwk.zzar());
            return zzwk.equals(zzvq.zza);
        }
        zzd(zzwk2.zzar());
        return this.zza.equals(zzwk2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzta) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzX();
        }
        return 0;
    }

    public final zztd zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                zztd zztd = this.zzc;
                return zztd;
            }
            if (this.zza == null) {
                this.zzc = zztd.zzb;
            } else {
                this.zzc = this.zza.zzR();
            }
            zztd zztd2 = this.zzc;
            return zztd2;
        }
    }

    public final zzwk zzc(zzwk zzwk) {
        zzwk zzwk2 = this.zza;
        this.zzc = null;
        this.zza = zzwk;
        return zzwk2;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(com.google.android.gms.internal.gtm.zzwk r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.gtm.zzwk r0 = r1.zza
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r1)
            com.google.android.gms.internal.gtm.zzwk r0 = r1.zza     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            r1.zza = r2     // Catch:{ zzvk -> 0x0011 }
            com.google.android.gms.internal.gtm.zztd r0 = com.google.android.gms.internal.gtm.zztd.zzb     // Catch:{ zzvk -> 0x0011 }
            r1.zzc = r0     // Catch:{ zzvk -> 0x0011 }
            goto L_0x0017
        L_0x0011:
            r1.zza = r2     // Catch:{ all -> 0x001b }
            com.google.android.gms.internal.gtm.zztd r2 = com.google.android.gms.internal.gtm.zztd.zzb     // Catch:{ all -> 0x001b }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzvq.zzd(com.google.android.gms.internal.gtm.zzwk):void");
    }
}
