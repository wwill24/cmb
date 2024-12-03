package com.google.android.gms.internal.mlkit_vision_face;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

class zzam extends AbstractCollection {
    final Object zza;
    Collection zzb;
    final zzam zzc;
    final Collection zzd;
    final /* synthetic */ zzap zze;

    zzam(zzap zzap, Object obj, Collection collection, zzam zzam) {
        this.zze = zzap;
        this.zza = obj;
        this.zzb = collection;
        this.zzc = zzam;
        this.zzd = zzam == null ? null : zzam.zzb;
    }

    public final boolean add(Object obj) {
        zzb();
        boolean isEmpty = this.zzb.isEmpty();
        boolean add = this.zzb.add(obj);
        if (!add) {
            return add;
        }
        zzap.zzd(this.zze);
        if (!isEmpty) {
            return add;
        }
        zza();
        return true;
    }

    public final boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = this.zzb.addAll(collection);
        if (!addAll) {
            return addAll;
        }
        zzap.zzf(this.zze, this.zzb.size() - size);
        if (size != 0) {
            return addAll;
        }
        zza();
        return true;
    }

    public final void clear() {
        int size = size();
        if (size != 0) {
            this.zzb.clear();
            zzap.zzg(this.zze, size);
            zzc();
        }
    }

    public final boolean contains(Object obj) {
        zzb();
        return this.zzb.contains(obj);
    }

    public final boolean containsAll(Collection collection) {
        zzb();
        return this.zzb.containsAll(collection);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        zzb();
        return this.zzb.equals(obj);
    }

    public final int hashCode() {
        zzb();
        return this.zzb.hashCode();
    }

    public final Iterator iterator() {
        zzb();
        return new zzal(this);
    }

    public final boolean remove(Object obj) {
        zzb();
        boolean remove = this.zzb.remove(obj);
        if (remove) {
            zzap.zze(this.zze);
            zzc();
        }
        return remove;
    }

    public final boolean removeAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean removeAll = this.zzb.removeAll(collection);
        if (removeAll) {
            zzap.zzf(this.zze, this.zzb.size() - size);
            zzc();
        }
        return removeAll;
    }

    public final boolean retainAll(Collection collection) {
        collection.getClass();
        int size = size();
        boolean retainAll = this.zzb.retainAll(collection);
        if (retainAll) {
            zzap.zzf(this.zze, this.zzb.size() - size);
            zzc();
        }
        return retainAll;
    }

    public final int size() {
        zzb();
        return this.zzb.size();
    }

    public final String toString() {
        zzb();
        return this.zzb.toString();
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        zzam zzam = this.zzc;
        if (zzam != null) {
            zzam.zza();
        } else {
            this.zze.zza.put(this.zza, this.zzb);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb() {
        Collection collection;
        zzam zzam = this.zzc;
        if (zzam != null) {
            zzam.zzb();
            if (this.zzc.zzb != this.zzd) {
                throw new ConcurrentModificationException();
            }
        } else if (this.zzb.isEmpty() && (collection = (Collection) this.zze.zza.get(this.zza)) != null) {
            this.zzb = collection;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc() {
        zzam zzam = this.zzc;
        if (zzam != null) {
            zzam.zzc();
        } else if (this.zzb.isEmpty()) {
            this.zze.zza.remove(this.zza);
        }
    }
}
