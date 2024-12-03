package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class zzjl extends AbstractList implements zzli {
    private boolean zza;

    zzjl(boolean z10) {
        this.zza = z10;
    }

    public void add(int i10, Object obj) {
        zzbW();
        super.add(i10, obj);
    }

    public boolean addAll(int i10, Collection collection) {
        zzbW();
        return super.addAll(i10, collection);
    }

    public void clear() {
        zzbW();
        super.clear();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i10 = 0; i10 < size; i10++) {
            if (!get(i10).equals(list.get(i10))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int i10 = 1;
        for (int i11 = 0; i11 < size; i11++) {
            i10 = (i10 * 31) + get(i11).hashCode();
        }
        return i10;
    }

    public Object remove(int i10) {
        zzbW();
        return super.remove(i10);
    }

    public final boolean removeAll(Collection collection) {
        zzbW();
        return super.removeAll(collection);
    }

    public final boolean retainAll(Collection collection) {
        zzbW();
        return super.retainAll(collection);
    }

    public Object set(int i10, Object obj) {
        zzbW();
        return super.set(i10, obj);
    }

    public final void zzb() {
        if (this.zza) {
            this.zza = false;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzbW() {
        if (!this.zza) {
            throw new UnsupportedOperationException();
        }
    }

    public final boolean zzc() {
        return this.zza;
    }

    public boolean add(Object obj) {
        zzbW();
        return super.add(obj);
    }

    public boolean addAll(Collection collection) {
        zzbW();
        return super.addAll(collection);
    }

    public final boolean remove(Object obj) {
        zzbW();
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }
}
