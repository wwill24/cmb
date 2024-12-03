package com.google.android.gms.internal.play_billing;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public abstract class zzu extends zzr implements List, RandomAccess {
    private static final zzai zza = new zzs(zzaa.zza, 0);
    public static final /* synthetic */ int zzd = 0;

    zzu() {
    }

    static zzu zzi(Object[] objArr, int i10) {
        if (i10 == 0) {
            return zzaa.zza;
        }
        return new zzaa(objArr, i10);
    }

    public static zzu zzj(Collection collection) {
        if (collection instanceof zzr) {
            zzu zzd2 = ((zzr) collection).zzd();
            if (!zzd2.zzf()) {
                return zzd2;
            }
            Object[] array2 = zzd2.toArray();
            return zzi(array2, array2.length);
        }
        Object[] array3 = collection.toArray();
        int length = array3.length;
        int i10 = 0;
        while (i10 < length) {
            if (array3[i10] != null) {
                i10++;
            } else {
                throw new NullPointerException("at index " + i10);
            }
        }
        return zzi(array3, length);
    }

    public static zzu zzk() {
        return zzaa.zza;
    }

    @Deprecated
    public final void add(int i10, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(int i10, Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    int i10 = 0;
                    while (i10 < size) {
                        if (zzl.zza(get(i10), list.get(i10))) {
                            i10++;
                        }
                    }
                    return true;
                }
                Iterator it = iterator();
                Iterator it2 = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it2.hasNext()) {
                            if (!zzl.zza(it.next(), it2.next())) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else if (!it2.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int size = size();
        int i10 = 1;
        for (int i11 = 0; i11 < size; i11++) {
            i10 = (i10 * 31) + get(i11).hashCode();
        }
        return i10;
    }

    public final int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (obj.equals(get(i10))) {
                return i10;
            }
        }
        return -1;
    }

    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    public final int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Deprecated
    public final Object remove(int i10) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Object set(int i10, Object obj) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int zza(Object[] objArr, int i10) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            objArr[i11] = get(i11);
        }
        return size;
    }

    @Deprecated
    public final zzu zzd() {
        return this;
    }

    public final zzah zze() {
        return listIterator(0);
    }

    /* renamed from: zzh */
    public zzu subList(int i10, int i11) {
        zzm.zzd(i10, i11, size());
        int i12 = i11 - i10;
        if (i12 == size()) {
            return this;
        }
        if (i12 == 0) {
            return zzaa.zza;
        }
        return new zzt(this, i10, i12);
    }

    /* renamed from: zzl */
    public final zzai listIterator(int i10) {
        zzm.zzb(i10, size(), FirebaseAnalytics.Param.INDEX);
        if (isEmpty()) {
            return zza;
        }
        return new zzs(this, i10);
    }
}
