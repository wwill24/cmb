package com.google.android.gms.internal.mlkit_vision_text_common;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

final class zzag extends zzcc {
    final transient Map zza;
    final /* synthetic */ zzao zzb;

    zzag(zzao zzao, Map map) {
        this.zzb = zzao;
        this.zza = map;
    }

    public final void clear() {
        Map map = this.zza;
        zzao zzao = this.zzb;
        if (map == zzao.zza) {
            zzao.zzn();
        } else {
            zzbq.zza(new zzaf(this));
        }
    }

    public final boolean containsKey(Object obj) {
        return zzcd.zzb(this.zza, obj);
    }

    public final boolean equals(Object obj) {
        return this == obj || this.zza.equals(obj);
    }

    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        Collection collection = (Collection) zzcd.zza(this.zza, obj);
        if (collection == null) {
            return null;
        }
        return this.zzb.zzb(obj, collection);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final Set keySet() {
        return this.zzb.zzq();
    }

    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        Collection collection = (Collection) this.zza.remove(obj);
        if (collection == null) {
            return null;
        }
        Collection zza2 = this.zzb.zza();
        zza2.addAll(collection);
        zzao.zzg(this.zzb, collection.size());
        collection.clear();
        return zza2;
    }

    public final int size() {
        return this.zza.size();
    }

    public final String toString() {
        return this.zza.toString();
    }

    /* access modifiers changed from: protected */
    public final Set zza() {
        return new zzae(this);
    }
}
