package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.List;

final class zzdr {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zzeg zzc = zzX(false);
    private static final zzeg zzd = zzX(true);
    private static final zzeg zze = new zzei();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zzb = cls;
    }

    public static zzeg zzA() {
        return zze;
    }

    static Object zzB(Object obj, int i10, int i11, Object obj2, zzeg zzeg) {
        if (obj2 == null) {
            obj2 = zzeg.zzc(obj);
        }
        zzeg.zzf(obj2, i10, (long) i11);
        return obj2;
    }

    static void zzC(zzeg zzeg, Object obj, Object obj2) {
        zzeg.zzh(obj, zzeg.zze(zzeg.zzd(obj), zzeg.zzd(obj2)));
    }

    public static void zzD(Class cls) {
        Class cls2;
        if (!zzcb.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzE(int i10, List list, zzey zzey, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzey.zzc(i10, list, z10);
        }
    }

    public static void zzF(int i10, List list, zzey zzey) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzey.zze(i10, list);
        }
    }

    public static void zzG(int i10, List list, zzey zzey, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzey.zzg(i10, list, z10);
        }
    }

    public static void zzH(int i10, List list, zzey zzey, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzey.zzj(i10, list, z10);
        }
    }

    public static void zzI(int i10, List list, zzey zzey, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzey.zzl(i10, list, z10);
        }
    }

    public static void zzJ(int i10, List list, zzey zzey, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzey.zzn(i10, list, z10);
        }
    }

    public static void zzK(int i10, List list, zzey zzey, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzey.zzp(i10, list, z10);
        }
    }

    public static void zzL(int i10, List list, zzey zzey, zzdp zzdp) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i11 = 0; i11 < list.size(); i11++) {
                ((zzbj) zzey).zzq(i10, list.get(i11), zzdp);
            }
        }
    }

    public static void zzM(int i10, List list, zzey zzey, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzey.zzs(i10, list, z10);
        }
    }

    public static void zzN(int i10, List list, zzey zzey, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzey.zzu(i10, list, z10);
        }
    }

    public static void zzO(int i10, List list, zzey zzey, zzdp zzdp) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i11 = 0; i11 < list.size(); i11++) {
                ((zzbj) zzey).zzv(i10, list.get(i11), zzdp);
            }
        }
    }

    public static void zzP(int i10, List list, zzey zzey, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzey.zzx(i10, list, z10);
        }
    }

    public static void zzQ(int i10, List list, zzey zzey, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzey.zzz(i10, list, z10);
        }
    }

    public static void zzR(int i10, List list, zzey zzey, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzey.zzB(i10, list, z10);
        }
    }

    public static void zzS(int i10, List list, zzey zzey, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzey.zzD(i10, list, z10);
        }
    }

    public static void zzT(int i10, List list, zzey zzey) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzey.zzG(i10, list);
        }
    }

    public static void zzU(int i10, List list, zzey zzey, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzey.zzI(i10, list, z10);
        }
    }

    public static void zzV(int i10, List list, zzey zzey, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzey.zzK(i10, list, z10);
        }
    }

    static boolean zzW(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private static zzeg zzX(boolean z10) {
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
            return (zzeg) cls.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z10)});
        } catch (Throwable unused2) {
            return null;
        }
    }

    static int zza(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzbi.zzx(i10 << 3) + 1);
    }

    static int zzb(int i10, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzx = size * zzbi.zzx(i10 << 3);
        for (int i11 = 0; i11 < list.size(); i11++) {
            int zzd2 = ((zzba) list.get(i11)).zzd();
            zzx += zzbi.zzx(zzd2) + zzd2;
        }
        return zzx;
    }

    static int zzc(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzbi.zzx(i10 << 3));
    }

    static int zzd(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzcc) {
            zzcc zzcc = (zzcc) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzbi.zzu(zzcc.zze(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + zzbi.zzu(((Integer) list.get(i11)).intValue());
                i11++;
            }
        }
        return i10;
    }

    static int zze(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzbi.zzx(i10 << 3) + 4);
    }

    static int zzf(List list) {
        return list.size() * 4;
    }

    static int zzg(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzbi.zzx(i10 << 3) + 8);
    }

    static int zzh(List list) {
        return list.size() * 8;
    }

    static int zzi(int i10, List list, zzdp zzdp) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            i11 += zzbi.zzt(i10, (zzdf) list.get(i12), zzdp);
        }
        return i11;
    }

    static int zzj(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzk(list) + (size * zzbi.zzx(i10 << 3));
    }

    static int zzk(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzcc) {
            zzcc zzcc = (zzcc) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzbi.zzu(zzcc.zze(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + zzbi.zzu(((Integer) list.get(i11)).intValue());
                i11++;
            }
        }
        return i10;
    }

    static int zzl(int i10, List list, boolean z10) {
        if (list.size() == 0) {
            return 0;
        }
        return zzm(list) + (list.size() * zzbi.zzx(i10 << 3));
    }

    static int zzm(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzcu) {
            zzcu zzcu = (zzcu) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzbi.zzy(zzcu.zze(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + zzbi.zzy(((Long) list.get(i11)).longValue());
                i11++;
            }
        }
        return i10;
    }

    static int zzn(int i10, Object obj, zzdp zzdp) {
        if (obj instanceof zzcl) {
            int i11 = zzbi.zzb;
            int zza2 = ((zzcl) obj).zza();
            return zzbi.zzx(i10 << 3) + zzbi.zzx(zza2) + zza2;
        }
        return zzbi.zzx(i10 << 3) + zzbi.zzv((zzdf) obj, zzdp);
    }

    static int zzo(int i10, List list, zzdp zzdp) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzx = zzbi.zzx(i10 << 3) * size;
        for (int i11 = 0; i11 < size; i11++) {
            Object obj = list.get(i11);
            if (obj instanceof zzcl) {
                int zza2 = ((zzcl) obj).zza();
                zzx += zzbi.zzx(zza2) + zza2;
            } else {
                zzx += zzbi.zzv((zzdf) obj, zzdp);
            }
        }
        return zzx;
    }

    static int zzp(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzq(list) + (size * zzbi.zzx(i10 << 3));
    }

    static int zzq(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzcc) {
            zzcc zzcc = (zzcc) list;
            i10 = 0;
            while (i11 < size) {
                int zze2 = zzcc.zze(i11);
                i10 += zzbi.zzx((zze2 >> 31) ^ (zze2 + zze2));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                int intValue = ((Integer) list.get(i11)).intValue();
                i12 = i10 + zzbi.zzx((intValue >> 31) ^ (intValue + intValue));
                i11++;
            }
        }
        return i10;
    }

    static int zzr(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzs(list) + (size * zzbi.zzx(i10 << 3));
    }

    static int zzs(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzcu) {
            zzcu zzcu = (zzcu) list;
            i10 = 0;
            while (i11 < size) {
                long zze2 = zzcu.zze(i11);
                i10 += zzbi.zzy((zze2 >> 63) ^ (zze2 + zze2));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                long longValue = ((Long) list.get(i11)).longValue();
                i12 = i10 + zzbi.zzy((longValue >> 63) ^ (longValue + longValue));
                i11++;
            }
        }
        return i10;
    }

    static int zzt(int i10, List list) {
        int zzw;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        int i12 = zzbi.zzb;
        boolean z10 = list instanceof zzcn;
        int zzx = zzbi.zzx(i10 << 3) * size;
        if (z10) {
            zzcn zzcn = (zzcn) list;
            while (i11 < size) {
                Object zzf = zzcn.zzf(i11);
                if (zzf instanceof zzba) {
                    int zzd2 = ((zzba) zzf).zzd();
                    zzx += zzbi.zzx(zzd2) + zzd2;
                } else {
                    zzx += zzbi.zzw((String) zzf);
                }
                i11++;
            }
        } else {
            while (i11 < size) {
                Object obj = list.get(i11);
                if (obj instanceof zzba) {
                    int zzd3 = ((zzba) obj).zzd();
                    zzw = zzx + zzbi.zzx(zzd3) + zzd3;
                } else {
                    zzw = zzx + zzbi.zzw((String) obj);
                }
                i11++;
            }
        }
        return zzx;
    }

    static int zzu(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzv(list) + (size * zzbi.zzx(i10 << 3));
    }

    static int zzv(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzcc) {
            zzcc zzcc = (zzcc) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzbi.zzx(zzcc.zze(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + zzbi.zzx(((Integer) list.get(i11)).intValue());
                i11++;
            }
        }
        return i10;
    }

    static int zzw(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzx(list) + (size * zzbi.zzx(i10 << 3));
    }

    static int zzx(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzcu) {
            zzcu zzcu = (zzcu) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzbi.zzy(zzcu.zze(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + zzbi.zzy(((Long) list.get(i11)).longValue());
                i11++;
            }
        }
        return i10;
    }

    public static zzeg zzy() {
        return zzc;
    }

    public static zzeg zzz() {
        return zzd;
    }
}
