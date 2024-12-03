package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.common.api.a;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

abstract class zzbv extends zzci {
    zzbv() {
    }

    public final void clear() {
        zza().clear();
    }

    public boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Object zza = zzbz.zza(zza(), key);
        if (!zzx.zza(zza, entry.getValue())) {
            return false;
        }
        if (zza != null) {
            return true;
        }
        if (!zzbz.zzb(((zzah) zza()).zza, key)) {
            return false;
        }
        return true;
    }

    public final boolean isEmpty() {
        return zza().isEmpty();
    }

    public boolean remove(Object obj) {
        if (!contains(obj) || !(obj instanceof Map.Entry)) {
            return false;
        }
        return ((zzah) zza()).zzb.zzq().remove(((Map.Entry) obj).getKey());
    }

    public final boolean removeAll(Collection collection) {
        collection.getClass();
        try {
            return zzcj.zzb(this, collection);
        } catch (UnsupportedOperationException unused) {
            return zzcj.zzc(this, collection.iterator());
        }
    }

    public final boolean retainAll(Collection collection) {
        int i10;
        collection.getClass();
        try {
            return super.retainAll(collection);
        } catch (UnsupportedOperationException unused) {
            int size = collection.size();
            if (size < 3) {
                zzau.zza(size, "expectedSize");
                i10 = size + 1;
            } else if (size < 1073741824) {
                i10 = (int) Math.ceil(((double) size) / 0.75d);
            } else {
                i10 = a.e.API_PRIORITY_OTHER;
            }
            HashSet hashSet = new HashSet(i10);
            for (Object next : collection) {
                if (contains(next) && (next instanceof Map.Entry)) {
                    hashSet.add(((Map.Entry) next).getKey());
                }
            }
            return ((zzah) zza()).zzb.zzq().retainAll(hashSet);
        }
    }

    public final int size() {
        return zza().size();
    }

    /* access modifiers changed from: package-private */
    public abstract Map zza();
}
