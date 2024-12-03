package com.google.android.gms.internal.p003firebaseauthapi;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzby  reason: invalid package */
public final class zzby {
    private final zzwv zza;
    private final List zzb;
    private final zzro zzc = zzro.zza;

    private zzby(zzwv zzwv, List list) {
        this.zza = zzwv;
        this.zzb = list;
    }

    static final zzby zza(zzwv zzwv) throws GeneralSecurityException {
        zzl(zzwv);
        return new zzby(zzwv, zzk(zzwv));
    }

    public static final zzby zzh(zzbe zzbe, zzbd zzbd) throws GeneralSecurityException, IOException {
        byte[] bArr = new byte[0];
        zzva zza2 = zzbe.zza();
        if (zza2 == null || zza2.zzd().zzd() == 0) {
            throw new GeneralSecurityException("empty keyset");
        }
        try {
            zzwv zzg = zzwv.zzg(zzbd.zza(zza2.zzd().zzq(), bArr), zzajx.zza());
            zzl(zzg);
            return zza(zzg);
        } catch (zzaks unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    private static zzoo zzi(zzwu zzwu) {
        Integer num;
        int zza2 = zzwu.zza();
        if (zzwu.zze() == zzxo.RAW) {
            num = null;
        } else {
            num = Integer.valueOf(zza2);
        }
        try {
            return zzoo.zza(zzwu.zzb().zzf(), zzwu.zzb().zze(), zzwu.zzb().zzb(), zzwu.zze(), num);
        } catch (GeneralSecurityException e10) {
            throw new zzpc("Creating a protokey serialization failed", e10);
        }
    }

    private static Object zzj(zzmw zzmw, zzwu zzwu, Class cls) throws GeneralSecurityException {
        try {
            return zzcq.zzd(zzwu.zzb(), cls);
        } catch (GeneralSecurityException e10) {
            if (e10.getMessage().contains("No key manager found for key type ") || e10.getMessage().contains(" not supported by key manager of type ")) {
                return null;
            }
            throw e10;
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }

    private static List zzk(zzwv zzwv) {
        zzbu zzbu;
        boolean z10;
        ArrayList arrayList = new ArrayList(zzwv.zza());
        for (zzwu zzwu : zzwv.zzh()) {
            int zza2 = zzwu.zza();
            try {
                zzbn zza3 = zznt.zzc().zza(zzi(zzwu), zzcr.zza());
                int zzk = zzwu.zzk() - 2;
                if (zzk == 1) {
                    zzbu = zzbu.zza;
                } else if (zzk == 2) {
                    zzbu = zzbu.zzb;
                } else if (zzk == 3) {
                    zzbu = zzbu.zzc;
                } else {
                    throw new GeneralSecurityException("Unknown key status");
                }
                zzbu zzbu2 = zzbu;
                if (zza2 == zzwv.zzb()) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                arrayList.add(new zzbx(zza3, zzbu2, zza2, z10, (zzbw) null));
            } catch (GeneralSecurityException unused) {
                arrayList.add((Object) null);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static void zzl(zzwv zzwv) throws GeneralSecurityException {
        if (zzwv == null || zzwv.zza() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    private static final Object zzm(zzmw zzmw, zzbn zzbn, Class cls) throws GeneralSecurityException {
        try {
            return zznq.zza().zzc(zzbn, cls);
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    public final String toString() {
        return zzct.zza(this.zza).toString();
    }

    public final zzby zzb() throws GeneralSecurityException {
        zzwv zzwv = this.zza;
        if (zzwv != null) {
            zzws zzc2 = zzwv.zzc();
            for (zzwu zzwu : zzwv.zzh()) {
                zzwi zzb2 = zzwu.zzb();
                if (zzb2.zzb() == zzwh.ASYMMETRIC_PRIVATE) {
                    String zzf = zzb2.zzf();
                    zzajf zze = zzb2.zze();
                    zzbo zza2 = zzcq.zza(zzf);
                    if (zza2 instanceof zzcn) {
                        zzwi zzd = ((zzcn) zza2).zzd(zze);
                        String zzf2 = zzd.zzf();
                        zzcq.zza(zzf2).zzb(zzd.zze());
                        zzwt zzwt = (zzwt) zzwu.zzu();
                        zzwt.zza(zzd);
                        zzc2.zzb((zzwu) zzwt.zzi());
                    } else {
                        throw new GeneralSecurityException("manager for key type " + zzf + " is not a PrivateKeyManager");
                    }
                } else {
                    throw new GeneralSecurityException("The keyset contains a non-private key");
                }
            }
            zzc2.zzc(this.zza.zzb());
            return zza((zzwv) zzc2.zzi());
        }
        throw new GeneralSecurityException("cleartext keyset is not available");
    }

    /* access modifiers changed from: package-private */
    public final zzwv zzc() {
        return this.zza;
    }

    public final zzxa zzd() {
        return zzct.zza(this.zza);
    }

    public final Object zze(zzbh zzbh, Class cls) throws GeneralSecurityException {
        Object obj;
        boolean z10;
        Class zzc2 = zzcq.zzc(cls);
        if (zzc2 != null) {
            zzwv zzwv = this.zza;
            Charset charset = zzct.zza;
            int zzb2 = zzwv.zzb();
            int i10 = 0;
            boolean z11 = false;
            boolean z12 = true;
            for (zzwu zzwu : zzwv.zzh()) {
                if (zzwu.zzk() == 3) {
                    if (!zzwu.zzi()) {
                        throw new GeneralSecurityException(String.format("key %d has no key data", new Object[]{Integer.valueOf(zzwu.zza())}));
                    } else if (zzwu.zze() == zzxo.UNKNOWN_PREFIX) {
                        throw new GeneralSecurityException(String.format("key %d has unknown prefix", new Object[]{Integer.valueOf(zzwu.zza())}));
                    } else if (zzwu.zzk() != 2) {
                        if (zzwu.zza() == zzb2) {
                            if (!z11) {
                                z11 = true;
                            } else {
                                throw new GeneralSecurityException("keyset contains multiple primary keys");
                            }
                        }
                        if (zzwu.zzb().zzb() != zzwh.ASYMMETRIC_PUBLIC) {
                            z10 = false;
                        } else {
                            z10 = true;
                        }
                        z12 &= z10;
                        i10++;
                    } else {
                        throw new GeneralSecurityException(String.format("key %d has unknown status", new Object[]{Integer.valueOf(zzwu.zza())}));
                    }
                }
            }
            if (i10 == 0) {
                throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
            } else if (z11 || z12) {
                zzcg zzcg = new zzcg(zzc2, (zzcf) null);
                zzcg.zzc(this.zzc);
                for (int i11 = 0; i11 < this.zza.zza(); i11++) {
                    zzwu zzd = this.zza.zzd(i11);
                    if (zzd.zzk() == 3) {
                        zzmw zzmw = (zzmw) zzbh;
                        Object zzj = zzj(zzmw, zzd, zzc2);
                        if (this.zzb.get(i11) != null) {
                            obj = zzm(zzmw, ((zzbx) this.zzb.get(i11)).zza(), zzc2);
                        } else {
                            obj = null;
                        }
                        if (obj == null && zzj == null) {
                            throw new GeneralSecurityException("Unable to get primitive " + zzc2.toString() + " for key of type " + zzd.zzb().zzf());
                        } else if (zzd.zza() == this.zza.zzb()) {
                            zzcg.zzb(obj, zzj, zzd);
                        } else {
                            zzcg.zza(obj, zzj, zzd);
                        }
                    }
                }
                return zznq.zza().zzd(zzcg.zzd(), cls);
            } else {
                throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
            }
        } else {
            throw new GeneralSecurityException("No wrapper found for ".concat(cls.getName()));
        }
    }

    public final void zzf(zzca zzca, zzbd zzbd) throws GeneralSecurityException, IOException {
        zzwv zzwv = this.zza;
        byte[] bArr = new byte[0];
        byte[] zzb2 = zzbd.zzb(zzwv.zzq(), bArr);
        try {
            if (zzwv.zzg(zzbd.zza(zzb2, bArr), zzajx.zza()).equals(zzwv)) {
                int length = zzb2.length;
                zzuz zza2 = zzva.zza();
                zza2.zza(zzajf.zzn(zzb2, 0, length));
                zza2.zzb(zzct.zza(zzwv));
                zzca.zzb((zzva) zza2.zzi());
                return;
            }
            throw new GeneralSecurityException("cannot encrypt keyset");
        } catch (zzaks unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0010  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzg(com.google.android.gms.internal.p003firebaseauthapi.zzca r5) throws java.security.GeneralSecurityException, java.io.IOException {
        /*
            r4 = this;
            com.google.android.gms.internal.firebase-auth-api.zzwv r0 = r4.zza
            java.util.List r0 = r0.zzh()
            java.util.Iterator r0 = r0.iterator()
        L_0x000a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0064
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.firebase-auth-api.zzwu r1 = (com.google.android.gms.internal.p003firebaseauthapi.zzwu) r1
            com.google.android.gms.internal.firebase-auth-api.zzwi r2 = r1.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzwh r2 = r2.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzwh r3 = com.google.android.gms.internal.p003firebaseauthapi.zzwh.UNKNOWN_KEYMATERIAL
            if (r2 == r3) goto L_0x003b
            com.google.android.gms.internal.firebase-auth-api.zzwi r2 = r1.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzwh r2 = r2.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzwh r3 = com.google.android.gms.internal.p003firebaseauthapi.zzwh.SYMMETRIC
            if (r2 == r3) goto L_0x003b
            com.google.android.gms.internal.firebase-auth-api.zzwi r2 = r1.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzwh r2 = r2.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzwh r3 = com.google.android.gms.internal.p003firebaseauthapi.zzwh.ASYMMETRIC_PRIVATE
            if (r2 == r3) goto L_0x003b
            goto L_0x000a
        L_0x003b:
            java.security.GeneralSecurityException r5 = new java.security.GeneralSecurityException
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r2 = 0
            com.google.android.gms.internal.firebase-auth-api.zzwi r3 = r1.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzwh r3 = r3.zzb()
            java.lang.String r3 = r3.name()
            r0[r2] = r3
            r2 = 1
            com.google.android.gms.internal.firebase-auth-api.zzwi r1 = r1.zzb()
            java.lang.String r1 = r1.zzf()
            r0[r2] = r1
            java.lang.String r1 = "keyset contains key material of type %s for type url %s"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            r5.<init>(r0)
            throw r5
        L_0x0064:
            com.google.android.gms.internal.firebase-auth-api.zzwv r0 = r4.zza
            r5.zzc(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p003firebaseauthapi.zzby.zzg(com.google.android.gms.internal.firebase-auth-api.zzca):void");
    }
}
