package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzakv  reason: invalid package */
public class zzakv {
    private static final zzajx zzb = zzajx.zza;
    protected volatile zzalp zza;
    private volatile zzajf zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzakv)) {
            return false;
        }
        zzakv zzakv = (zzakv) obj;
        zzalp zzalp = this.zza;
        zzalp zzalp2 = zzakv.zza;
        if (zzalp == null && zzalp2 == null) {
            return zzb().equals(zzakv.zzb());
        }
        if (zzalp != null && zzalp2 != null) {
            return zzalp.equals(zzalp2);
        }
        if (zzalp != null) {
            zzakv.zzc(zzalp.zzM());
            return zzalp.equals(zzakv.zza);
        }
        zzc(zzalp2.zzM());
        return this.zza.equals(zzalp2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzajc) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzs();
        }
        return 0;
    }

    public final zzajf zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                zzajf zzajf = this.zzc;
                return zzajf;
            }
            if (this.zza == null) {
                this.zzc = zzajf.zzb;
            } else {
                this.zzc = this.zza.zzo();
            }
            zzajf zzajf2 = this.zzc;
            return zzajf2;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(com.google.android.gms.internal.p003firebaseauthapi.zzalp r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.firebase-auth-api.zzalp r0 = r1.zza
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r1)
            com.google.android.gms.internal.firebase-auth-api.zzalp r0 = r1.zza     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            r1.zza = r2     // Catch:{ zzaks -> 0x0011 }
            com.google.android.gms.internal.firebase-auth-api.zzajf r0 = com.google.android.gms.internal.p003firebaseauthapi.zzajf.zzb     // Catch:{ zzaks -> 0x0011 }
            r1.zzc = r0     // Catch:{ zzaks -> 0x0011 }
            goto L_0x0017
        L_0x0011:
            r1.zza = r2     // Catch:{ all -> 0x001b }
            com.google.android.gms.internal.firebase-auth-api.zzajf r2 = com.google.android.gms.internal.p003firebaseauthapi.zzajf.zzb     // Catch:{ all -> 0x001b }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p003firebaseauthapi.zzakv.zzc(com.google.android.gms.internal.firebase-auth-api.zzalp):void");
    }
}
