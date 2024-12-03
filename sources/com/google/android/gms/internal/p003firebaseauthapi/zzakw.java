package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzakw  reason: invalid package */
public final class zzakw extends zzaiq implements RandomAccess, zzakx {
    @Deprecated
    public static final zzakx zza;
    private static final zzakw zzb;
    private final List zzc;

    static {
        zzakw zzakw = new zzakw(false);
        zzb = zzakw;
        zza = zzakw;
    }

    public zzakw() {
        this(10);
    }

    private static String zzj(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzajf) {
            return ((zzajf) obj).zzo(zzakq.zzb);
        }
        return zzakq.zzd((byte[]) obj);
    }

    public final /* bridge */ /* synthetic */ void add(int i10, Object obj) {
        zza();
        this.zzc.add(i10, (String) obj);
        this.modCount++;
    }

    public final boolean addAll(int i10, Collection collection) {
        zza();
        if (collection instanceof zzakx) {
            collection = ((zzakx) collection).zzh();
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

    public final /* bridge */ /* synthetic */ zzakp zzd(int i10) {
        if (i10 >= size()) {
            ArrayList arrayList = new ArrayList(i10);
            arrayList.addAll(this.zzc);
            return new zzakw(arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final zzakx zze() {
        return zzc() ? new zzana(this) : this;
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
        if (obj instanceof zzajf) {
            zzajf zzajf = (zzajf) obj;
            String zzo = zzajf.zzo(zzakq.zzb);
            if (zzajf.zzk()) {
                this.zzc.set(i10, zzo);
            }
            return zzo;
        }
        byte[] bArr = (byte[]) obj;
        String zzd = zzakq.zzd(bArr);
        if (zzank.zze(bArr)) {
            this.zzc.set(i10, zzd);
        }
        return zzd;
    }

    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final void zzi(zzajf zzajf) {
        zza();
        this.zzc.add(zzajf);
        this.modCount++;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzakw(int i10) {
        super(true);
        ArrayList arrayList = new ArrayList(i10);
        this.zzc = arrayList;
    }

    private zzakw(ArrayList arrayList) {
        super(true);
        this.zzc = arrayList;
    }

    private zzakw(boolean z10) {
        super(false);
        this.zzc = Collections.emptyList();
    }

    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
