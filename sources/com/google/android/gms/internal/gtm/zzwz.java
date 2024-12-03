package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zzwz {
    private static final Class<?> zza;
    private static final zzxo<?, ?> zzb = zzab(false);
    private static final zzxo<?, ?> zzc = zzab(true);
    private static final zzxo<?, ?> zzd = new zzxq();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zza = cls;
    }

    public static zzxo<?, ?> zzA() {
        return zzc;
    }

    public static zzxo<?, ?> zzB() {
        return zzd;
    }

    static <UT, UB> UB zzC(int i10, List<Integer> list, zzvd zzvd, UB ub2, zzxo<UT, UB> zzxo) {
        if (zzvd == null) {
            return ub2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                int intValue = list.get(i12).intValue();
                if (zzvd.zza(intValue)) {
                    if (i12 != i11) {
                        list.set(i11, Integer.valueOf(intValue));
                    }
                    i11++;
                } else {
                    ub2 = zzD(i10, intValue, ub2, zzxo);
                }
            }
            if (i11 != size) {
                list.subList(i11, size).clear();
                return ub2;
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzvd.zza(intValue2)) {
                    ub2 = zzD(i10, intValue2, ub2, zzxo);
                    it.remove();
                }
            }
        }
        return ub2;
    }

    static <UT, UB> UB zzD(int i10, int i11, UB ub2, zzxo<UT, UB> zzxo) {
        if (ub2 == null) {
            ub2 = zzxo.zzf();
        }
        zzxo.zzl(ub2, i10, (long) i11);
        return ub2;
    }

    static <T, FT extends zzun<FT>> void zzE(zzuk<FT> zzuk, T t10, T t11) {
        zzuo<FT> zzb2 = zzuk.zzb(t11);
        if (!zzb2.zza.isEmpty()) {
            zzuk.zzc(t10).zzh(zzb2);
        }
    }

    static <T, UT, UB> void zzF(zzxo<UT, UB> zzxo, T t10, T t11) {
        zzxo.zzo(t10, zzxo.zze(zzxo.zzd(t10), zzxo.zzd(t11)));
    }

    public static void zzG(Class<?> cls) {
        Class<?> cls2;
        if (!zzuz.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    static boolean zzH(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static <T> void zzI(zzwf zzwf, T t10, T t11, long j10) {
        zzxy.zzs(t10, j10, zzwf.zzc(zzxy.zzf(t10, j10), zzxy.zzf(t11, j10)));
    }

    public static void zzJ(int i10, List<Boolean> list, zztp zztp, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zztp.zzc(i10, list, z10);
        }
    }

    public static void zzK(int i10, List<zztd> list, zztp zztp) throws IOException {
        if (list != null && !list.isEmpty()) {
            zztp.zze(i10, list);
        }
    }

    public static void zzL(int i10, List<Double> list, zztp zztp, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zztp.zzg(i10, list, z10);
        }
    }

    public static void zzM(int i10, List<Integer> list, zztp zztp, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zztp.zzj(i10, list, z10);
        }
    }

    public static void zzN(int i10, List<Integer> list, zztp zztp, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zztp.zzl(i10, list, z10);
        }
    }

    public static void zzO(int i10, List<Long> list, zztp zztp, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zztp.zzn(i10, list, z10);
        }
    }

    public static void zzP(int i10, List<Float> list, zztp zztp, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zztp.zzp(i10, list, z10);
        }
    }

    public static void zzQ(int i10, List<?> list, zztp zztp, zzwx zzwx) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i11 = 0; i11 < list.size(); i11++) {
                zztp.zzq(i10, list.get(i11), zzwx);
            }
        }
    }

    public static void zzR(int i10, List<Integer> list, zztp zztp, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zztp.zzs(i10, list, z10);
        }
    }

    public static void zzS(int i10, List<Long> list, zztp zztp, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zztp.zzu(i10, list, z10);
        }
    }

    public static void zzT(int i10, List<?> list, zztp zztp, zzwx zzwx) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i11 = 0; i11 < list.size(); i11++) {
                zztp.zzv(i10, list.get(i11), zzwx);
            }
        }
    }

    public static void zzU(int i10, List<Integer> list, zztp zztp, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zztp.zzy(i10, list, z10);
        }
    }

    public static void zzV(int i10, List<Long> list, zztp zztp, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zztp.zzA(i10, list, z10);
        }
    }

    public static void zzW(int i10, List<Integer> list, zztp zztp, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zztp.zzC(i10, list, z10);
        }
    }

    public static void zzX(int i10, List<Long> list, zztp zztp, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zztp.zzE(i10, list, z10);
        }
    }

    public static void zzY(int i10, List<String> list, zztp zztp) throws IOException {
        if (list != null && !list.isEmpty()) {
            zztp.zzH(i10, list);
        }
    }

    public static void zzZ(int i10, List<Integer> list, zztp zztp, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zztp.zzJ(i10, list, z10);
        }
    }

    static int zza(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzto.zzD(i10 << 3) + 1);
    }

    public static void zzaa(int i10, List<Long> list, zztp zztp, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zztp.zzL(i10, list, z10);
        }
    }

    private static zzxo<?, ?> zzab(boolean z10) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (zzxo) cls.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z10)});
        } catch (Throwable unused2) {
            return null;
        }
    }

    static int zzb(List<?> list) {
        return list.size();
    }

    static int zzc(int i10, List<zztd> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzC = size * zzto.zzC(i10);
        for (int i11 = 0; i11 < list.size(); i11++) {
            zzC += zzto.zzu(list.get(i11));
        }
        return zzC;
    }

    static int zzd(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzto.zzC(i10));
    }

    static int zze(List<Integer> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzva) {
            zzva zzva = (zzva) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzto.zzx(zzva.zze(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + zzto.zzx(list.get(i11).intValue());
                i11++;
            }
        }
        return i10;
    }

    static int zzf(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzto.zzD(i10 << 3) + 4);
    }

    static int zzg(List<?> list) {
        return list.size() * 4;
    }

    static int zzh(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzto.zzD(i10 << 3) + 8);
    }

    static int zzi(List<?> list) {
        return list.size() * 8;
    }

    static int zzj(int i10, List<zzwk> list, zzwx zzwx) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            i11 += zzto.zzv(i10, list.get(i12), zzwx);
        }
        return i11;
    }

    static int zzk(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzl(list) + (size * zzto.zzC(i10));
    }

    static int zzl(List<Integer> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzva) {
            zzva zzva = (zzva) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzto.zzx(zzva.zze(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + zzto.zzx(list.get(i11).intValue());
                i11++;
            }
        }
        return i10;
    }

    static int zzm(int i10, List<Long> list, boolean z10) {
        if (list.size() == 0) {
            return 0;
        }
        return zzn(list) + (list.size() * zzto.zzC(i10));
    }

    static int zzn(List<Long> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzvz) {
            zzvz zzvz = (zzvz) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzto.zzE(zzvz.zze(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + zzto.zzE(list.get(i11).longValue());
                i11++;
            }
        }
        return i10;
    }

    static int zzo(int i10, Object obj, zzwx zzwx) {
        if (!(obj instanceof zzvq)) {
            return zzto.zzD(i10 << 3) + zzto.zzA((zzwk) obj, zzwx);
        }
        int zzD = zzto.zzD(i10 << 3);
        int zza2 = ((zzvq) obj).zza();
        return zzD + zzto.zzD(zza2) + zza2;
    }

    static int zzp(int i10, List<?> list, zzwx zzwx) {
        int i11;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzC = zzto.zzC(i10) * size;
        for (int i12 = 0; i12 < size; i12++) {
            Object obj = list.get(i12);
            if (obj instanceof zzvq) {
                i11 = zzto.zzy((zzvq) obj);
            } else {
                i11 = zzto.zzA((zzwk) obj, zzwx);
            }
            zzC += i11;
        }
        return zzC;
    }

    static int zzq(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzr(list) + (size * zzto.zzC(i10));
    }

    static int zzr(List<Integer> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzva) {
            zzva zzva = (zzva) list;
            i10 = 0;
            while (i11 < size) {
                int zze = zzva.zze(i11);
                i10 += zzto.zzD((zze >> 31) ^ (zze + zze));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                int intValue = list.get(i11).intValue();
                i12 = i10 + zzto.zzD((intValue >> 31) ^ (intValue + intValue));
                i11++;
            }
        }
        return i10;
    }

    static int zzs(int i10, List<Long> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzt(list) + (size * zzto.zzC(i10));
    }

    static int zzt(List<Long> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzvz) {
            zzvz zzvz = (zzvz) list;
            i10 = 0;
            while (i11 < size) {
                long zze = zzvz.zze(i11);
                i10 += zzto.zzE((zze >> 63) ^ (zze + zze));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                long longValue = list.get(i11).longValue();
                i12 = i10 + zzto.zzE((longValue >> 63) ^ (longValue + longValue));
                i11++;
            }
        }
        return i10;
    }

    static int zzu(int i10, List<?> list) {
        int i11;
        int i12;
        int size = list.size();
        int i13 = 0;
        if (size == 0) {
            return 0;
        }
        int zzC = zzto.zzC(i10) * size;
        if (list instanceof zzvs) {
            zzvs zzvs = (zzvs) list;
            while (i13 < size) {
                Object zzf = zzvs.zzf(i13);
                if (zzf instanceof zztd) {
                    i12 = zzto.zzu((zztd) zzf);
                } else {
                    i12 = zzto.zzB((String) zzf);
                }
                zzC += i12;
                i13++;
            }
        } else {
            while (i13 < size) {
                Object obj = list.get(i13);
                if (obj instanceof zztd) {
                    i11 = zzto.zzu((zztd) obj);
                } else {
                    i11 = zzto.zzB((String) obj);
                }
                zzC += i11;
                i13++;
            }
        }
        return zzC;
    }

    static int zzv(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzw(list) + (size * zzto.zzC(i10));
    }

    static int zzw(List<Integer> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzva) {
            zzva zzva = (zzva) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzto.zzD(zzva.zze(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + zzto.zzD(list.get(i11).intValue());
                i11++;
            }
        }
        return i10;
    }

    static int zzx(int i10, List<Long> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzy(list) + (size * zzto.zzC(i10));
    }

    static int zzy(List<Long> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzvz) {
            zzvz zzvz = (zzvz) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzto.zzE(zzvz.zze(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + zzto.zzE(list.get(i11).longValue());
                i11++;
            }
        }
        return i10;
    }

    public static zzxo<?, ?> zzz() {
        return zzb;
    }
}
