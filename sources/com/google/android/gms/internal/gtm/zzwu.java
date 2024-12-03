package com.google.android.gms.internal.gtm;

import java.util.Arrays;
import java.util.RandomAccess;

final class zzwu<E> extends zzsj<E> implements RandomAccess {
    private static final zzwu<Object> zza;
    private E[] zzb;
    private int zzc;

    static {
        zzwu<Object> zzwu = new zzwu<>(new Object[0], 0);
        zza = zzwu;
        zzwu.zzb();
    }

    zzwu() {
        this(new Object[10], 0);
    }

    public static <E> zzwu<E> zze() {
        return zza;
    }

    private final String zzf(int i10) {
        int i11 = this.zzc;
        StringBuilder sb2 = new StringBuilder(35);
        sb2.append("Index:");
        sb2.append(i10);
        sb2.append(", Size:");
        sb2.append(i11);
        return sb2.toString();
    }

    private final void zzg(int i10) {
        if (i10 < 0 || i10 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzf(i10));
        }
    }

    public final void add(int i10, E e10) {
        int i11;
        zza();
        if (i10 < 0 || i10 > (i11 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzf(i10));
        }
        E[] eArr = this.zzb;
        if (i11 < eArr.length) {
            System.arraycopy(eArr, i10, eArr, i10 + 1, i11 - i10);
        } else {
            E[] eArr2 = new Object[(((i11 * 3) / 2) + 1)];
            System.arraycopy(eArr, 0, eArr2, 0, i10);
            System.arraycopy(this.zzb, i10, eArr2, i10 + 1, this.zzc - i10);
            this.zzb = eArr2;
        }
        this.zzb[i10] = e10;
        this.zzc++;
        this.modCount++;
    }

    public final E get(int i10) {
        zzg(i10);
        return this.zzb[i10];
    }

    public final E remove(int i10) {
        zza();
        zzg(i10);
        E[] eArr = this.zzb;
        E e10 = eArr[i10];
        int i11 = this.zzc;
        if (i10 < i11 - 1) {
            System.arraycopy(eArr, i10 + 1, eArr, i10, (i11 - i10) - 1);
        }
        this.zzc--;
        this.modCount++;
        return e10;
    }

    public final E set(int i10, E e10) {
        zza();
        zzg(i10);
        E[] eArr = this.zzb;
        E e11 = eArr[i10];
        eArr[i10] = e10;
        this.modCount++;
        return e11;
    }

    public final int size() {
        return this.zzc;
    }

    public final /* bridge */ /* synthetic */ zzvh zzd(int i10) {
        if (i10 >= this.zzc) {
            return new zzwu(Arrays.copyOf(this.zzb, i10), this.zzc);
        }
        throw new IllegalArgumentException();
    }

    private zzwu(E[] eArr, int i10) {
        this.zzb = eArr;
        this.zzc = i10;
    }

    public final boolean add(E e10) {
        zza();
        int i10 = this.zzc;
        E[] eArr = this.zzb;
        if (i10 == eArr.length) {
            this.zzb = Arrays.copyOf(eArr, ((i10 * 3) / 2) + 1);
        }
        E[] eArr2 = this.zzb;
        int i11 = this.zzc;
        this.zzc = i11 + 1;
        eArr2[i11] = e10;
        this.modCount++;
        return true;
    }
}
