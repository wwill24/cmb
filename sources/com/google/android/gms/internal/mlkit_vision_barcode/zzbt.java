package com.google.android.gms.internal.mlkit_vision_barcode;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

final class zzbt extends AbstractMap implements Serializable {
    /* access modifiers changed from: private */
    public static final Object zzd = new Object();
    transient int[] zza;
    transient Object[] zzb;
    transient Object[] zzc;
    private transient Object zze;
    /* access modifiers changed from: private */
    public transient int zzf;
    /* access modifiers changed from: private */
    public transient int zzg;
    private transient Set zzh;
    private transient Set zzi;
    private transient Collection zzj;

    zzbt() {
        zzm(3);
    }

    static /* synthetic */ Object zzh(zzbt zzbt) {
        Object obj = zzbt.zze;
        obj.getClass();
        return obj;
    }

    /* access modifiers changed from: private */
    public final int zzp() {
        return (1 << (this.zzf & 31)) - 1;
    }

    /* access modifiers changed from: private */
    public final int zzq(Object obj) {
        if (zzo()) {
            return -1;
        }
        int zza2 = zzbv.zza(obj);
        int zzp = zzp();
        Object obj2 = this.zze;
        obj2.getClass();
        int zzc2 = zzbu.zzc(obj2, zza2 & zzp);
        if (zzc2 != 0) {
            int i10 = ~zzp;
            int i11 = zza2 & i10;
            do {
                int i12 = zzc2 - 1;
                int[] iArr = this.zza;
                iArr.getClass();
                int i13 = iArr[i12];
                if ((i13 & i10) == i11) {
                    Object[] objArr = this.zzb;
                    objArr.getClass();
                    if (zzam.zza(obj, objArr[i12])) {
                        return i12;
                    }
                }
                zzc2 = i13 & zzp;
            } while (zzc2 != 0);
        }
        return -1;
    }

    private final int zzr(int i10, int i11, int i12, int i13) {
        int i14 = i11 - 1;
        Object zzd2 = zzbu.zzd(i11);
        if (i13 != 0) {
            zzbu.zze(zzd2, i12 & i14, i13 + 1);
        }
        Object obj = this.zze;
        obj.getClass();
        int[] iArr = this.zza;
        iArr.getClass();
        for (int i15 = 0; i15 <= i10; i15++) {
            int zzc2 = zzbu.zzc(obj, i15);
            while (zzc2 != 0) {
                int i16 = zzc2 - 1;
                int i17 = iArr[i16];
                int i18 = ((~i10) & i17) | i15;
                int i19 = i18 & i14;
                int zzc3 = zzbu.zzc(zzd2, i19);
                zzbu.zze(zzd2, i19, zzc2);
                iArr[i16] = ((~i14) & i18) | (zzc3 & i14);
                zzc2 = i17 & i10;
            }
        }
        this.zze = zzd2;
        zzt(i14);
        return i14;
    }

    /* access modifiers changed from: private */
    public final Object zzs(Object obj) {
        if (zzo()) {
            return zzd;
        }
        int zzp = zzp();
        Object obj2 = this.zze;
        obj2.getClass();
        int[] iArr = this.zza;
        iArr.getClass();
        Object[] objArr = this.zzb;
        objArr.getClass();
        int zzb2 = zzbu.zzb(obj, (Object) null, zzp, obj2, iArr, objArr, (Object[]) null);
        if (zzb2 == -1) {
            return zzd;
        }
        Object[] objArr2 = this.zzc;
        objArr2.getClass();
        Object obj3 = objArr2[zzb2];
        zzn(zzb2, zzp);
        this.zzg--;
        zzl();
        return obj3;
    }

    private final void zzt(int i10) {
        this.zzf = ((32 - Integer.numberOfLeadingZeros(i10)) & 31) | (this.zzf & -32);
    }

    public final void clear() {
        if (!zzo()) {
            zzl();
            Map zzj2 = zzj();
            if (zzj2 == null) {
                Object[] objArr = this.zzb;
                objArr.getClass();
                Arrays.fill(objArr, 0, this.zzg, (Object) null);
                Object[] objArr2 = this.zzc;
                objArr2.getClass();
                Arrays.fill(objArr2, 0, this.zzg, (Object) null);
                Object obj = this.zze;
                obj.getClass();
                if (obj instanceof byte[]) {
                    Arrays.fill((byte[]) obj, (byte) 0);
                } else if (obj instanceof short[]) {
                    Arrays.fill((short[]) obj, 0);
                } else {
                    Arrays.fill((int[]) obj, 0);
                }
                int[] iArr = this.zza;
                iArr.getClass();
                Arrays.fill(iArr, 0, this.zzg, 0);
                this.zzg = 0;
                return;
            }
            this.zzf = zzdd.zza(size(), 3, 1073741823);
            zzj2.clear();
            this.zze = null;
            this.zzg = 0;
        }
    }

    public final boolean containsKey(Object obj) {
        Map zzj2 = zzj();
        if (zzj2 != null) {
            return zzj2.containsKey(obj);
        }
        if (zzq(obj) == -1) {
            return false;
        }
        return true;
    }

    public final boolean containsValue(Object obj) {
        Map zzj2 = zzj();
        if (zzj2 != null) {
            return zzj2.containsValue(obj);
        }
        for (int i10 = 0; i10 < this.zzg; i10++) {
            Object[] objArr = this.zzc;
            objArr.getClass();
            if (zzam.zza(obj, objArr[i10])) {
                return true;
            }
        }
        return false;
    }

    public final Set entrySet() {
        Set set = this.zzi;
        if (set != null) {
            return set;
        }
        zzbn zzbn = new zzbn(this);
        this.zzi = zzbn;
        return zzbn;
    }

    public final Object get(Object obj) {
        Map zzj2 = zzj();
        if (zzj2 != null) {
            return zzj2.get(obj);
        }
        int zzq = zzq(obj);
        if (zzq == -1) {
            return null;
        }
        Object[] objArr = this.zzc;
        objArr.getClass();
        return objArr[zzq];
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final Set keySet() {
        Set set = this.zzh;
        if (set != null) {
            return set;
        }
        zzbq zzbq = new zzbq(this);
        this.zzh = zzbq;
        return zzbq;
    }

    public final Object put(Object obj, Object obj2) {
        int min;
        Object obj3 = obj;
        Object obj4 = obj2;
        if (zzo()) {
            zzaq.zzd(zzo(), "Arrays already allocated");
            int i10 = this.zzf;
            int max = Math.max(i10 + 1, 2);
            int highestOneBit = Integer.highestOneBit(max);
            if (max > ((int) ((double) highestOneBit)) && (highestOneBit = highestOneBit + highestOneBit) <= 0) {
                highestOneBit = 1073741824;
            }
            int max2 = Math.max(4, highestOneBit);
            this.zze = zzbu.zzd(max2);
            zzt(max2 - 1);
            this.zza = new int[i10];
            this.zzb = new Object[i10];
            this.zzc = new Object[i10];
        }
        Map zzj2 = zzj();
        if (zzj2 != null) {
            return zzj2.put(obj3, obj4);
        }
        int[] iArr = this.zza;
        iArr.getClass();
        Object[] objArr = this.zzb;
        objArr.getClass();
        Object[] objArr2 = this.zzc;
        objArr2.getClass();
        int i11 = this.zzg;
        int i12 = i11 + 1;
        int zza2 = zzbv.zza(obj);
        int zzp = zzp();
        int i13 = zza2 & zzp;
        Object obj5 = this.zze;
        obj5.getClass();
        int zzc2 = zzbu.zzc(obj5, i13);
        if (zzc2 != 0) {
            int i14 = ~zzp;
            int i15 = zza2 & i14;
            int i16 = 0;
            while (true) {
                int i17 = zzc2 - 1;
                int i18 = iArr[i17];
                int i19 = i18 & i14;
                if (i19 != i15 || !zzam.zza(obj3, objArr[i17])) {
                    int i20 = i18 & zzp;
                    i16++;
                    if (i20 != 0) {
                        zzc2 = i20;
                    } else if (i16 >= 9) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap(zzp() + 1, 1.0f);
                        for (int zze2 = zze(); zze2 >= 0; zze2 = zzf(zze2)) {
                            Object[] objArr3 = this.zzb;
                            objArr3.getClass();
                            Object obj6 = objArr3[zze2];
                            Object[] objArr4 = this.zzc;
                            objArr4.getClass();
                            linkedHashMap.put(obj6, objArr4[zze2]);
                        }
                        this.zze = linkedHashMap;
                        this.zza = null;
                        this.zzb = null;
                        this.zzc = null;
                        zzl();
                        return linkedHashMap.put(obj3, obj4);
                    } else if (i12 > zzp) {
                        zzp = zzr(zzp, zzbu.zza(zzp), zza2, i11);
                    } else {
                        iArr[i17] = (i12 & zzp) | i19;
                    }
                } else {
                    Object obj7 = objArr2[i17];
                    objArr2[i17] = obj4;
                    return obj7;
                }
            }
        } else if (i12 > zzp) {
            zzp = zzr(zzp, zzbu.zza(zzp), zza2, i11);
        } else {
            Object obj8 = this.zze;
            obj8.getClass();
            zzbu.zze(obj8, i13, i12);
        }
        int[] iArr2 = this.zza;
        iArr2.getClass();
        int length = iArr2.length;
        if (i12 > length && (min = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            int[] iArr3 = this.zza;
            iArr3.getClass();
            this.zza = Arrays.copyOf(iArr3, min);
            Object[] objArr5 = this.zzb;
            objArr5.getClass();
            this.zzb = Arrays.copyOf(objArr5, min);
            Object[] objArr6 = this.zzc;
            objArr6.getClass();
            this.zzc = Arrays.copyOf(objArr6, min);
        }
        int[] iArr4 = this.zza;
        iArr4.getClass();
        iArr4[i11] = (~zzp) & zza2;
        Object[] objArr7 = this.zzb;
        objArr7.getClass();
        objArr7[i11] = obj3;
        Object[] objArr8 = this.zzc;
        objArr8.getClass();
        objArr8[i11] = obj4;
        this.zzg = i12;
        zzl();
        return null;
    }

    public final Object remove(Object obj) {
        Map zzj2 = zzj();
        if (zzj2 != null) {
            return zzj2.remove(obj);
        }
        Object zzs = zzs(obj);
        if (zzs == zzd) {
            return null;
        }
        return zzs;
    }

    public final int size() {
        Map zzj2 = zzj();
        if (zzj2 != null) {
            return zzj2.size();
        }
        return this.zzg;
    }

    public final Collection values() {
        Collection collection = this.zzj;
        if (collection != null) {
            return collection;
        }
        zzbs zzbs = new zzbs(this);
        this.zzj = zzbs;
        return zzbs;
    }

    /* access modifiers changed from: package-private */
    public final int zze() {
        return isEmpty() ? -1 : 0;
    }

    /* access modifiers changed from: package-private */
    public final int zzf(int i10) {
        int i11 = i10 + 1;
        if (i11 < this.zzg) {
            return i11;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public final Map zzj() {
        Object obj = this.zze;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void zzl() {
        this.zzf += 32;
    }

    /* access modifiers changed from: package-private */
    public final void zzm(int i10) {
        this.zzf = zzdd.zza(12, 1, 1073741823);
    }

    /* access modifiers changed from: package-private */
    public final void zzn(int i10, int i11) {
        Object obj = this.zze;
        obj.getClass();
        int[] iArr = this.zza;
        iArr.getClass();
        Object[] objArr = this.zzb;
        objArr.getClass();
        Object[] objArr2 = this.zzc;
        objArr2.getClass();
        int size = size() - 1;
        if (i10 < size) {
            Object obj2 = objArr[size];
            objArr[i10] = obj2;
            objArr2[i10] = objArr2[size];
            objArr[size] = null;
            objArr2[size] = null;
            iArr[i10] = iArr[size];
            iArr[size] = 0;
            int zza2 = zzbv.zza(obj2) & i11;
            int zzc2 = zzbu.zzc(obj, zza2);
            int i12 = size + 1;
            if (zzc2 != i12) {
                while (true) {
                    int i13 = zzc2 - 1;
                    int i14 = iArr[i13];
                    int i15 = i14 & i11;
                    if (i15 != i12) {
                        zzc2 = i15;
                    } else {
                        iArr[i13] = ((i10 + 1) & i11) | (i14 & (~i11));
                        return;
                    }
                }
            } else {
                zzbu.zze(obj, zza2, i10 + 1);
            }
        } else {
            objArr[i10] = null;
            objArr2[i10] = null;
            iArr[i10] = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzo() {
        return this.zze == null;
    }

    zzbt(int i10) {
        zzm(12);
    }
}
