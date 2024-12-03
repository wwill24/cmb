package com.google.android.gms.internal.p003firebaseauthapi;

import org.bouncycastle.jcajce.spec.XDHParameterSpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjs  reason: invalid package */
public final class zzjs {
    public static final zzjs zza = new zzjs("NIST_P256");
    public static final zzjs zzb = new zzjs("NIST_P384");
    public static final zzjs zzc = new zzjs("NIST_P521");
    public static final zzjs zzd = new zzjs(XDHParameterSpec.X25519);
    private final String zze;

    private zzjs(String str) {
        this.zze = str;
    }

    public final String toString() {
        return this.zze;
    }
}
