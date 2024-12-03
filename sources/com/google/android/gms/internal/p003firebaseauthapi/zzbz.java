package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbz  reason: invalid package */
public final class zzbz {
    private final zzws zza;

    private zzbz(zzws zzws) {
        this.zza = zzws;
    }

    public static zzbz zze() {
        return new zzbz(zzwv.zzc());
    }

    public static zzbz zzf(zzby zzby) {
        return new zzbz((zzws) zzby.zzc().zzu());
    }

    private final synchronized int zzg() {
        int zza2;
        zza2 = zzpd.zza();
        while (zzj(zza2)) {
            zza2 = zzpd.zza();
        }
        return zza2;
    }

    private final synchronized zzwu zzh(zzwi zzwi, zzxo zzxo) throws GeneralSecurityException {
        zzwt zzc;
        int zzg = zzg();
        if (zzxo != zzxo.UNKNOWN_PREFIX) {
            zzc = zzwu.zzc();
            zzc.zza(zzwi);
            zzc.zzb(zzg);
            zzc.zzd(3);
            zzc.zzc(zzxo);
        } else {
            throw new GeneralSecurityException("unknown output prefix type");
        }
        return (zzwu) zzc.zzi();
    }

    private final synchronized zzwu zzi(zzwn zzwn) throws GeneralSecurityException {
        return zzh(zzcq.zzb(zzwn), zzwn.zze());
    }

    private final synchronized boolean zzj(int i10) {
        boolean z10;
        Iterator it = this.zza.zze().iterator();
        while (true) {
            if (it.hasNext()) {
                if (((zzwu) it.next()).zza() == i10) {
                    z10 = true;
                    break;
                }
            } else {
                z10 = false;
                break;
            }
        }
        return z10;
    }

    public final synchronized int zza(zzwn zzwn, boolean z10) throws GeneralSecurityException {
        zzwu zzi;
        zzws zzws = this.zza;
        zzi = zzi(zzwn);
        zzws.zzb(zzi);
        return zzi.zza();
    }

    public final synchronized zzby zzb() throws GeneralSecurityException {
        return zzby.zza((zzwv) this.zza.zzi());
    }

    public final synchronized zzbz zzc(zzbv zzbv) throws GeneralSecurityException {
        zza(zzbv.zzb(), false);
        return this;
    }

    public final synchronized zzbz zzd(int i10) throws GeneralSecurityException {
        int i11 = 0;
        while (i11 < this.zza.zza()) {
            zzwu zzd = this.zza.zzd(i11);
            if (zzd.zza() != i10) {
                i11++;
            } else if (zzd.zzk() == 3) {
                this.zza.zzc(i10);
            } else {
                throw new GeneralSecurityException("cannot set key as primary because it's not enabled: " + i10);
            }
        }
        throw new GeneralSecurityException("key not found: " + i10);
        return this;
    }
}
