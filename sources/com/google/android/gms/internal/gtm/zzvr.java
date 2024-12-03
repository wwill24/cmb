package com.google.android.gms.internal.gtm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzvr extends zzsj<String> implements RandomAccess, zzvs {
    public static final zzvs zza;
    private static final zzvr zzb;
    private final List<Object> zzc;

    static {
        zzvr zzvr = new zzvr(10);
        zzb = zzvr;
        zzvr.zzb();
        zza = zzvr;
    }

    public zzvr() {
        this(10);
    }

    private static String zzj(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zztd) {
            return ((zztd) obj).zzr(zzvi.zza);
        }
        return zzvi.zzh((byte[]) obj);
    }

    public final /* bridge */ /* synthetic */ void add(int i10, Object obj) {
        zza();
        this.zzc.add(i10, (String) obj);
        this.modCount++;
    }

    public final boolean addAll(int i10, Collection<? extends String> collection) {
        zza();
        if (collection instanceof zzvs) {
            collection = ((zzvs) collection).zzh();
        }
        boolean addAll = this.zzc.addAll(i10, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        zza();
        this.zzc.clear();
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i10) {
        zza();
        Object remove = this.zzc.remove(i10);
        this.modCount++;
        return zzj(remove);
    }

    public final /* bridge */ /* synthetic */ Object set(int i10, Object obj) {
        zza();
        return zzj(this.zzc.set(i10, (String) obj));
    }

    public final int size() {
        return this.zzc.size();
    }

    public final /* bridge */ /* synthetic */ zzvh zzd(int i10) {
        if (i10 >= size()) {
            ArrayList arrayList = new ArrayList(i10);
            arrayList.addAll(this.zzc);
            return new zzvr((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final zzvs zze() {
        return zzc() ? new zzxt(this) : this;
    }

    public final Object zzf(int i10) {
        return this.zzc.get(i10);
    }

    /* renamed from: zzg */
    public final String get(int i10) {
        Object obj = this.zzc.get(i10);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zztd) {
            zztd zztd = (zztd) obj;
            String zzr = zztd.zzr(zzvi.zza);
            if (zztd.zzj()) {
                this.zzc.set(i10, zzr);
            }
            return zzr;
        }
        byte[] bArr = (byte[]) obj;
        String zzh = zzvi.zzh(bArr);
        if (zzvi.zzj(bArr)) {
            this.zzc.set(i10, zzh);
        }
        return zzh;
    }

    public final List<?> zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final void zzi(zztd zztd) {
        zza();
        this.zzc.add(zztd);
        this.modCount++;
    }

    public zzvr(int i10) {
        this.zzc = new ArrayList(i10);
    }

    private zzvr(ArrayList<Object> arrayList) {
        this.zzc = arrayList;
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }
}
