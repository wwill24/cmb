package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzou  reason: invalid package */
public final class zzou {
    /* access modifiers changed from: private */
    public final Map zza;
    /* access modifiers changed from: private */
    public final Map zzb;
    /* access modifiers changed from: private */
    public final Map zzc;
    /* access modifiers changed from: private */
    public final Map zzd;

    public zzou() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
        this.zzc = new HashMap();
        this.zzd = new HashMap();
    }

    public final zzou zza(zzna zzna) throws GeneralSecurityException {
        zzow zzow = new zzow(zzna.zzd(), zzna.zzc(), (zzov) null);
        if (this.zzb.containsKey(zzow)) {
            zzna zzna2 = (zzna) this.zzb.get(zzow);
            if (!zzna2.equals(zzna) || !zzna.equals(zzna2)) {
                throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzow.toString()));
            }
        } else {
            this.zzb.put(zzow, zzna);
        }
        return this;
    }

    public final zzou zzb(zzne zzne) throws GeneralSecurityException {
        zzoy zzoy = new zzoy(zzne.zzb(), zzne.zzc(), (zzox) null);
        if (this.zza.containsKey(zzoy)) {
            zzne zzne2 = (zzne) this.zza.get(zzoy);
            if (!zzne2.equals(zzne) || !zzne.equals(zzne2)) {
                throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzoy.toString()));
            }
        } else {
            this.zza.put(zzoy, zzne);
        }
        return this;
    }

    public final zzou zzc(zznx zznx) throws GeneralSecurityException {
        zzow zzow = new zzow(zznx.zzd(), zznx.zzc(), (zzov) null);
        if (this.zzd.containsKey(zzow)) {
            zznx zznx2 = (zznx) this.zzd.get(zzow);
            if (!zznx2.equals(zznx) || !zznx.equals(zznx2)) {
                throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzow.toString()));
            }
        } else {
            this.zzd.put(zzow, zznx);
        }
        return this;
    }

    public final zzou zzd(zzob zzob) throws GeneralSecurityException {
        zzoy zzoy = new zzoy(zzob.zzc(), zzob.zzd(), (zzox) null);
        if (this.zzc.containsKey(zzoy)) {
            zzob zzob2 = (zzob) this.zzc.get(zzoy);
            if (!zzob2.equals(zzob) || !zzob.equals(zzob2)) {
                throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzoy.toString()));
            }
        } else {
            this.zzc.put(zzoy, zzob);
        }
        return this;
    }

    public zzou(zzpa zzpa) {
        this.zza = new HashMap(zzpa.zza);
        this.zzb = new HashMap(zzpa.zzb);
        this.zzc = new HashMap(zzpa.zzc);
        this.zzd = new HashMap(zzpa.zzd);
    }
}
