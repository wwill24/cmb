package com.google.android.gms.internal.mlkit_vision_face;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

final class zzbd extends AbstractMap implements Serializable {
    /* access modifiers changed from: private */
    public static final Object zzd = new Object();
    transient int[] zza;
    transient Object[] zzb;
    transient Object[] zzc;
    private transient Object zze;
    /* access modifiers changed from: private */
    public transient int zzf;
    private transient int zzg;
    private transient Set zzh;
    private transient Set zzi;
    private transient Collection zzj;

    zzbd() {
        zzo(3);
    }

    /* access modifiers changed from: private */
    public final Object[] zzA() {
        Object[] objArr = this.zzb;
        objArr.getClass();
        return objArr;
    }

    /* access modifiers changed from: private */
    public final Object[] zzB() {
        Object[] objArr = this.zzc;
        objArr.getClass();
        return objArr;
    }

    static /* synthetic */ int zzb(zzbd zzbd) {
        int i10 = zzbd.zzg;
        zzbd.zzg = i10 - 1;
        return i10;
    }

    static /* synthetic */ Object zzg(zzbd zzbd, int i10) {
        return zzbd.zzA()[i10];
    }

    static /* synthetic */ Object zzj(zzbd zzbd, int i10) {
        return zzbd.zzB()[i10];
    }

    static /* synthetic */ Object zzk(zzbd zzbd) {
        Object obj = zzbd.zze;
        obj.getClass();
        return obj;
    }

    static /* synthetic */ void zzm(zzbd zzbd, int i10, Object obj) {
        zzbd.zzB()[i10] = obj;
    }

    /* access modifiers changed from: private */
    public final int zzu() {
        return (1 << (this.zzf & 31)) - 1;
    }

    /* access modifiers changed from: private */
    public final int zzv(Object obj) {
        if (zzq()) {
            return -1;
        }
        int zza2 = zzbf.zza(obj);
        int zzu = zzu();
        Object obj2 = this.zze;
        obj2.getClass();
        int zzc2 = zzbe.zzc(obj2, zza2 & zzu);
        if (zzc2 != 0) {
            int i10 = ~zzu;
            int i11 = zza2 & i10;
            do {
                int i12 = zzc2 - 1;
                int i13 = zzz()[i12];
                if ((i13 & i10) == i11 && zzx.zza(obj, zzA()[i12])) {
                    return i12;
                }
                zzc2 = i13 & zzu;
            } while (zzc2 != 0);
        }
        return -1;
    }

    private final int zzw(int i10, int i11, int i12, int i13) {
        Object zzd2 = zzbe.zzd(i11);
        int i14 = i11 - 1;
        if (i13 != 0) {
            zzbe.zze(zzd2, i12 & i14, i13 + 1);
        }
        Object obj = this.zze;
        obj.getClass();
        int[] zzz = zzz();
        for (int i15 = 0; i15 <= i10; i15++) {
            int zzc2 = zzbe.zzc(obj, i15);
            while (zzc2 != 0) {
                int i16 = zzc2 - 1;
                int i17 = zzz[i16];
                int i18 = ((~i10) & i17) | i15;
                int i19 = i18 & i14;
                int zzc3 = zzbe.zzc(zzd2, i19);
                zzbe.zze(zzd2, i19, zzc2);
                zzz[i16] = ((~i14) & i18) | (zzc3 & i14);
                zzc2 = i17 & i10;
            }
        }
        this.zze = zzd2;
        zzy(i14);
        return i14;
    }

    /* access modifiers changed from: private */
    public final Object zzx(Object obj) {
        if (zzq()) {
            return zzd;
        }
        int zzu = zzu();
        Object obj2 = this.zze;
        obj2.getClass();
        int zzb2 = zzbe.zzb(obj, (Object) null, zzu, obj2, zzz(), zzA(), (Object[]) null);
        if (zzb2 == -1) {
            return zzd;
        }
        Object obj3 = zzB()[zzb2];
        zzp(zzb2, zzu);
        this.zzg--;
        zzn();
        return obj3;
    }

    private final void zzy(int i10) {
        this.zzf = ((32 - Integer.numberOfLeadingZeros(i10)) & 31) | (this.zzf & -32);
    }

    /* access modifiers changed from: private */
    public final int[] zzz() {
        int[] iArr = this.zza;
        iArr.getClass();
        return iArr;
    }

    public final void clear() {
        if (!zzq()) {
            zzn();
            Map zzl = zzl();
            if (zzl != null) {
                this.zzf = zzcn.zza(size(), 3, 1073741823);
                zzl.clear();
                this.zze = null;
                this.zzg = 0;
                return;
            }
            Arrays.fill(zzA(), 0, this.zzg, (Object) null);
            Arrays.fill(zzB(), 0, this.zzg, (Object) null);
            Object obj = this.zze;
            obj.getClass();
            if (obj instanceof byte[]) {
                Arrays.fill((byte[]) obj, (byte) 0);
            } else if (obj instanceof short[]) {
                Arrays.fill((short[]) obj, 0);
            } else {
                Arrays.fill((int[]) obj, 0);
            }
            Arrays.fill(zzz(), 0, this.zzg, 0);
            this.zzg = 0;
        }
    }

    public final boolean containsKey(Object obj) {
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.containsKey(obj);
        }
        if (zzv(obj) == -1) {
            return false;
        }
        return true;
    }

    public final boolean containsValue(Object obj) {
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.containsValue(obj);
        }
        for (int i10 = 0; i10 < this.zzg; i10++) {
            if (zzx.zza(obj, zzB()[i10])) {
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
        zzay zzay = new zzay(this);
        this.zzi = zzay;
        return zzay;
    }

    public final Object get(Object obj) {
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.get(obj);
        }
        int zzv = zzv(obj);
        if (zzv == -1) {
            return null;
        }
        return zzB()[zzv];
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final Set keySet() {
        Set set = this.zzh;
        if (set != null) {
            return set;
        }
        zzba zzba = new zzba(this);
        this.zzh = zzba;
        return zzba;
    }

    public final Object put(Object obj, Object obj2) {
        int min;
        Object obj3 = obj;
        Object obj4 = obj2;
        if (zzq()) {
            zzab.zzd(zzq(), "Arrays already allocated");
            int i10 = this.zzf;
            int max = Math.max(i10 + 1, 2);
            int highestOneBit = Integer.highestOneBit(max);
            if (max > ((int) ((double) highestOneBit)) && (highestOneBit = highestOneBit + highestOneBit) <= 0) {
                highestOneBit = 1073741824;
            }
            int max2 = Math.max(4, highestOneBit);
            this.zze = zzbe.zzd(max2);
            zzy(max2 - 1);
            this.zza = new int[i10];
            this.zzb = new Object[i10];
            this.zzc = new Object[i10];
        }
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.put(obj3, obj4);
        }
        int[] zzz = zzz();
        Object[] zzA = zzA();
        Object[] zzB = zzB();
        int i11 = this.zzg;
        int i12 = i11 + 1;
        int zza2 = zzbf.zza(obj);
        int zzu = zzu();
        int i13 = zza2 & zzu;
        Object obj5 = this.zze;
        obj5.getClass();
        int zzc2 = zzbe.zzc(obj5, i13);
        if (zzc2 != 0) {
            int i14 = ~zzu;
            int i15 = zza2 & i14;
            int i16 = 0;
            while (true) {
                int i17 = zzc2 - 1;
                int i18 = zzz[i17];
                int i19 = i18 & i14;
                if (i19 != i15 || !zzx.zza(obj3, zzA[i17])) {
                    int i20 = i18 & zzu;
                    i16++;
                    if (i20 != 0) {
                        zzc2 = i20;
                    } else if (i16 >= 9) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap(zzu() + 1, 1.0f);
                        for (int zze2 = zze(); zze2 >= 0; zze2 = zzf(zze2)) {
                            linkedHashMap.put(zzA()[zze2], zzB()[zze2]);
                        }
                        this.zze = linkedHashMap;
                        this.zza = null;
                        this.zzb = null;
                        this.zzc = null;
                        zzn();
                        return linkedHashMap.put(obj3, obj4);
                    } else if (i12 > zzu) {
                        zzu = zzw(zzu, zzbe.zza(zzu), zza2, i11);
                    } else {
                        zzz[i17] = (i12 & zzu) | i19;
                    }
                } else {
                    Object obj6 = zzB[i17];
                    zzB[i17] = obj4;
                    return obj6;
                }
            }
        } else if (i12 > zzu) {
            zzu = zzw(zzu, zzbe.zza(zzu), zza2, i11);
        } else {
            Object obj7 = this.zze;
            obj7.getClass();
            zzbe.zze(obj7, i13, i12);
        }
        int length = zzz().length;
        if (i12 > length && (min = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            this.zza = Arrays.copyOf(zzz(), min);
            this.zzb = Arrays.copyOf(zzA(), min);
            this.zzc = Arrays.copyOf(zzB(), min);
        }
        zzz()[i11] = (~zzu) & zza2;
        zzA()[i11] = obj3;
        zzB()[i11] = obj4;
        this.zzg = i12;
        zzn();
        return null;
    }

    public final Object remove(Object obj) {
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.remove(obj);
        }
        Object zzx = zzx(obj);
        if (zzx == zzd) {
            return null;
        }
        return zzx;
    }

    public final int size() {
        Map zzl = zzl();
        if (zzl != null) {
            return zzl.size();
        }
        return this.zzg;
    }

    public final Collection values() {
        Collection collection = this.zzj;
        if (collection != null) {
            return collection;
        }
        zzbc zzbc = new zzbc(this);
        this.zzj = zzbc;
        return zzbc;
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
    public final Map zzl() {
        Object obj = this.zze;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void zzn() {
        this.zzf += 32;
    }

    /* access modifiers changed from: package-private */
    public final void zzo(int i10) {
        this.zzf = zzcn.zza(12, 1, 1073741823);
    }

    /* access modifiers changed from: package-private */
    public final void zzp(int i10, int i11) {
        Object obj = this.zze;
        obj.getClass();
        int[] zzz = zzz();
        Object[] zzA = zzA();
        Object[] zzB = zzB();
        int size = size() - 1;
        if (i10 < size) {
            Object obj2 = zzA[size];
            zzA[i10] = obj2;
            zzB[i10] = zzB[size];
            zzA[size] = null;
            zzB[size] = null;
            zzz[i10] = zzz[size];
            zzz[size] = 0;
            int zza2 = zzbf.zza(obj2) & i11;
            int zzc2 = zzbe.zzc(obj, zza2);
            int i12 = size + 1;
            if (zzc2 != i12) {
                while (true) {
                    int i13 = zzc2 - 1;
                    int i14 = zzz[i13];
                    int i15 = i14 & i11;
                    if (i15 != i12) {
                        zzc2 = i15;
                    } else {
                        zzz[i13] = ((i10 + 1) & i11) | (i14 & (~i11));
                        return;
                    }
                }
            } else {
                zzbe.zze(obj, zza2, i10 + 1);
            }
        } else {
            zzA[i10] = null;
            zzB[i10] = null;
            zzz[i10] = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzq() {
        return this.zze == null;
    }

    zzbd(int i10) {
        zzo(12);
    }
}
