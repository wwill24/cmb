package com.google.android.gms.internal.p003firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcg  reason: invalid package */
public final class zzcg {
    private final Class zza;
    private ConcurrentMap zzb = new ConcurrentHashMap();
    private final List zzc = new ArrayList();
    private zzch zzd;
    private zzro zze;

    /* synthetic */ zzcg(Class cls, zzcf zzcf) {
        this.zza = cls;
        this.zze = zzro.zza;
    }

    private final zzcg zze(Object obj, Object obj2, zzwu zzwu, boolean z10) throws GeneralSecurityException {
        byte[] bArr;
        if (this.zzb == null) {
            throw new IllegalStateException("addPrimitive cannot be called after build");
        } else if (obj == null && obj2 == null) {
            throw new GeneralSecurityException("at least one of the `fullPrimitive` or `primitive` must be set");
        } else if (zzwu.zzk() == 3) {
            Integer valueOf = Integer.valueOf(zzwu.zza());
            if (zzwu.zze() == zzxo.RAW) {
                valueOf = null;
            }
            zzbn zza2 = zznt.zzc().zza(zzoo.zza(zzwu.zzb().zzf(), zzwu.zzb().zze(), zzwu.zzb().zzb(), zzwu.zze(), valueOf), zzcr.zza());
            int ordinal = zzwu.zze().ordinal();
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal == 3) {
                        bArr = zzbi.zza;
                    } else if (ordinal != 4) {
                        throw new GeneralSecurityException("unknown output prefix type");
                    }
                }
                bArr = ByteBuffer.allocate(5).put((byte) 0).putInt(zzwu.zza()).array();
            } else {
                bArr = ByteBuffer.allocate(5).put((byte) 1).putInt(zzwu.zza()).array();
            }
            zzch zzch = new zzch(obj, obj2, bArr, zzwu.zzk(), zzwu.zze(), zzwu.zza(), zzwu.zzb().zzf(), zza2);
            ConcurrentMap concurrentMap = this.zzb;
            List list = this.zzc;
            ArrayList arrayList = new ArrayList();
            arrayList.add(zzch);
            zzcj zzcj = new zzcj(zzch.zzg(), (zzci) null);
            List list2 = (List) concurrentMap.put(zzcj, Collections.unmodifiableList(arrayList));
            if (list2 != null) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(list2);
                arrayList2.add(zzch);
                concurrentMap.put(zzcj, Collections.unmodifiableList(arrayList2));
            }
            list.add(zzch);
            if (z10) {
                if (this.zzd == null) {
                    this.zzd = zzch;
                } else {
                    throw new IllegalStateException("you cannot set two primary primitives");
                }
            }
            return this;
        } else {
            throw new GeneralSecurityException("only ENABLED key is allowed");
        }
    }

    public final zzcg zza(Object obj, Object obj2, zzwu zzwu) throws GeneralSecurityException {
        zze(obj, obj2, zzwu, false);
        return this;
    }

    public final zzcg zzb(Object obj, Object obj2, zzwu zzwu) throws GeneralSecurityException {
        zze(obj, obj2, zzwu, true);
        return this;
    }

    public final zzcg zzc(zzro zzro) {
        if (this.zzb != null) {
            this.zze = zzro;
            return this;
        }
        throw new IllegalStateException("setAnnotations cannot be called after build");
    }

    public final zzcl zzd() throws GeneralSecurityException {
        ConcurrentMap concurrentMap = this.zzb;
        if (concurrentMap != null) {
            zzcl zzcl = new zzcl(concurrentMap, this.zzc, this.zzd, this.zze, this.zza, (zzck) null);
            this.zzb = null;
            return zzcl;
        }
        throw new IllegalStateException("build cannot be called twice");
    }
}
