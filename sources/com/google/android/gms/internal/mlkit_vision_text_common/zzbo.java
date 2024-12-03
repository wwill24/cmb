package com.google.android.gms.internal.mlkit_vision_text_common;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public abstract class zzbo implements Map, Serializable {
    private transient zzbp zza;
    private transient zzbp zzb;
    private transient zzbh zzc;

    zzbo() {
    }

    public static zzbo zzc(Object obj, Object obj2) {
        zzat.zzb("optional-module-barcode", "com.google.android.gms.vision.barcode");
        return zzcl.zzg(1, new Object[]{"optional-module-barcode", "com.google.android.gms.vision.barcode"}, (zzbn) null);
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
        return zzcn.zza(entrySet());
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final /* bridge */ /* synthetic */ Set keySet() {
        zzbp zzbp = this.zzb;
        if (zzbp != null) {
            return zzbp;
        }
        zzbp zze = zze();
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
        zzat.zza(size, "size");
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
    public abstract zzbh zza();

    /* renamed from: zzb */
    public final zzbh values() {
        zzbh zzbh = this.zzc;
        if (zzbh != null) {
            return zzbh;
        }
        zzbh zza2 = zza();
        this.zzc = zza2;
        return zza2;
    }

    /* access modifiers changed from: package-private */
    public abstract zzbp zzd();

    /* access modifiers changed from: package-private */
    public abstract zzbp zze();

    /* renamed from: zzf */
    public final zzbp entrySet() {
        zzbp zzbp = this.zza;
        if (zzbp != null) {
            return zzbp;
        }
        zzbp zzd = zzd();
        this.zza = zzd;
        return zzd;
    }
}
