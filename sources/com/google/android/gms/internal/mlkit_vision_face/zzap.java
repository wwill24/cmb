package com.google.android.gms.internal.mlkit_vision_face;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;

abstract class zzap extends zzar implements Serializable {
    /* access modifiers changed from: private */
    public transient Map zza;
    private transient int zzb;

    protected zzap(Map map) {
        if (map.isEmpty()) {
            this.zza = map;
            return;
        }
        throw new IllegalArgumentException();
    }

    static /* synthetic */ int zzd(zzap zzap) {
        int i10 = zzap.zzb;
        zzap.zzb = i10 + 1;
        return i10;
    }

    static /* synthetic */ int zze(zzap zzap) {
        int i10 = zzap.zzb;
        zzap.zzb = i10 - 1;
        return i10;
    }

    static /* synthetic */ int zzf(zzap zzap, int i10) {
        int i11 = zzap.zzb + i10;
        zzap.zzb = i11;
        return i11;
    }

    static /* synthetic */ int zzg(zzap zzap, int i10) {
        int i11 = zzap.zzb - i10;
        zzap.zzb = i11;
        return i11;
    }

    static /* synthetic */ void zzm(zzap zzap, Object obj) {
        Object obj2;
        Map map = zzap.zza;
        map.getClass();
        try {
            obj2 = map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            obj2 = null;
        }
        Collection collection = (Collection) obj2;
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            zzap.zzb -= size;
        }
    }

    /* access modifiers changed from: package-private */
    public abstract Collection zza();

    /* access modifiers changed from: package-private */
    public Collection zzb(Object obj, Collection collection) {
        throw null;
    }

    public final Collection zzh(Object obj) {
        Collection collection = (Collection) this.zza.get(obj);
        if (collection == null) {
            collection = zza();
        }
        return zzb(obj, collection);
    }

    /* access modifiers changed from: package-private */
    public final List zzi(Object obj, List list, zzam zzam) {
        if (list instanceof RandomAccess) {
            return new zzak(this, obj, list, zzam);
        }
        return new zzao(this, obj, list, zzam);
    }

    /* access modifiers changed from: package-private */
    public final Map zzk() {
        return new zzah(this, this.zza);
    }

    /* access modifiers changed from: package-private */
    public final Set zzl() {
        return new zzaj(this, this.zza);
    }

    public final void zzn() {
        for (Collection clear : this.zza.values()) {
            clear.clear();
        }
        this.zza.clear();
        this.zzb = 0;
    }

    public final boolean zzo(Object obj, Object obj2) {
        Collection collection = (Collection) this.zza.get(obj);
        if (collection == null) {
            Collection zza2 = zza();
            if (zza2.add(obj2)) {
                this.zzb++;
                this.zza.put(obj, zza2);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        } else if (!collection.add(obj2)) {
            return false;
        } else {
            this.zzb++;
            return true;
        }
    }
}
