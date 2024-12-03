package com.google.android.gms.internal.mlkit_vision_barcode;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public abstract class zzcf implements Map, Serializable {
    private transient zzcg zza;
    private transient zzcg zzb;
    private transient zzby zzc;

    zzcf() {
    }

    public static zzcf zzc(Object obj, Object obj2) {
        zzbj.zzb("optional-module-barcode", "com.google.android.gms.vision.barcode");
        return zzcx.zzg(1, new Object[]{"optional-module-barcode", "com.google.android.gms.vision.barcode"}, (zzce) null);
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    public final boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        return entrySet().equals(((Map) obj).entrySet());
    }

    public abstract Object get(Object obj);

    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    public final int hashCode() {
        return zzcz.zza(entrySet());
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final /* bridge */ /* synthetic */ Set keySet() {
        zzcg zzcg = this.zzb;
        if (zzcg != null) {
            return zzcg;
        }
        zzcg zze = zze();
        this.zzb = zze;
        return zze;
    }

    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        zzbj.zza(size, "size");
        StringBuilder sb2 = new StringBuilder((int) Math.min(((long) size) * 8, 1073741824));
        sb2.append('{');
        boolean z10 = true;
        for (Map.Entry entry : entrySet()) {
            if (!z10) {
                sb2.append(", ");
            }
            sb2.append(entry.getKey());
            sb2.append(SignatureVisitor.INSTANCEOF);
            sb2.append(entry.getValue());
            z10 = false;
        }
        sb2.append('}');
        return sb2.toString();
    }

    /* access modifiers changed from: package-private */
    public abstract zzby zza();

    /* renamed from: zzb */
    public final zzby values() {
        zzby zzby = this.zzc;
        if (zzby != null) {
            return zzby;
        }
        zzby zza2 = zza();
        this.zzc = zza2;
        return zza2;
    }

    /* access modifiers changed from: package-private */
    public abstract zzcg zzd();

    /* access modifiers changed from: package-private */
    public abstract zzcg zze();

    /* renamed from: zzf */
    public final zzcg entrySet() {
        zzcg zzcg = this.zza;
        if (zzcg != null) {
            return zzcg;
        }
        zzcg zzd = zzd();
        this.zza = zzd;
        return zzd;
    }
}
