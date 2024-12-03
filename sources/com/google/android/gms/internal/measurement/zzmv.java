package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;

final class zzmv {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zznk zzc;
    private static final zznk zzd = new zznm();

    static {
        Class<?> cls;
        Class<?> cls2;
        zznk zznk = null;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zzb = cls;
        try {
            cls2 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused2) {
            cls2 = null;
        }
        if (cls2 != null) {
            try {
                zznk = (zznk) cls2.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable unused3) {
            }
        }
        zzc = zznk;
    }

    static Object zzA(Object obj, int i10, int i11, Object obj2, zznk zznk) {
        if (obj2 == null) {
            obj2 = zznk.zzc(obj);
        }
        zznk.zzf(obj2, i10, (long) i11);
        return obj2;
    }

    static void zzB(zznk zznk, Object obj, Object obj2) {
        zznk.zzh(obj, zznk.zze(zznk.zzd(obj), zznk.zzd(obj2)));
    }

    public static void zzC(Class cls) {
        Class cls2;
        if (!zzlb.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzD(int i10, List list, zzoc zzoc, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzoc.zzc(i10, list, z10);
        }
    }

    public static void zzE(int i10, List list, zzoc zzoc) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzoc.zze(i10, list);
        }
    }

    public static void zzF(int i10, List list, zzoc zzoc, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzoc.zzg(i10, list, z10);
        }
    }

    public static void zzG(int i10, List list, zzoc zzoc, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzoc.zzj(i10, list, z10);
        }
    }

    public static void zzH(int i10, List list, zzoc zzoc, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzoc.zzl(i10, list, z10);
        }
    }

    public static void zzI(int i10, List list, zzoc zzoc, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzoc.zzn(i10, list, z10);
        }
    }

    public static void zzJ(int i10, List list, zzoc zzoc, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzoc.zzp(i10, list, z10);
        }
    }

    public static void zzK(int i10, List list, zzoc zzoc, zzmt zzmt) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i11 = 0; i11 < list.size(); i11++) {
                ((zzkj) zzoc).zzq(i10, list.get(i11), zzmt);
            }
        }
    }

    public static void zzL(int i10, List list, zzoc zzoc, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzoc.zzs(i10, list, z10);
        }
    }

    public static void zzM(int i10, List list, zzoc zzoc, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzoc.zzu(i10, list, z10);
        }
    }

    public static void zzN(int i10, List list, zzoc zzoc, zzmt zzmt) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i11 = 0; i11 < list.size(); i11++) {
                ((zzkj) zzoc).zzv(i10, list.get(i11), zzmt);
            }
        }
    }

    public static void zzO(int i10, List list, zzoc zzoc, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzoc.zzx(i10, list, z10);
        }
    }

    public static void zzP(int i10, List list, zzoc zzoc, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzoc.zzz(i10, list, z10);
        }
    }

    public static void zzQ(int i10, List list, zzoc zzoc, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzoc.zzB(i10, list, z10);
        }
    }

    public static void zzR(int i10, List list, zzoc zzoc, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzoc.zzD(i10, list, z10);
        }
    }

    public static void zzS(int i10, List list, zzoc zzoc) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzoc.zzG(i10, list);
        }
    }

    public static void zzT(int i10, List list, zzoc zzoc, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzoc.zzI(i10, list, z10);
        }
    }

    public static void zzU(int i10, List list, zzoc zzoc, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzoc.zzK(i10, list, z10);
        }
    }

    static boolean zzV(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static int zza(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzki.zzx(i10 << 3) + 1);
    }

    static int zzb(int i10, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzx = size * zzki.zzx(i10 << 3);
        for (int i11 = 0; i11 < list.size(); i11++) {
            int zzd2 = ((zzka) list.get(i11)).zzd();
            zzx += zzki.zzx(zzd2) + zzd2;
        }
        return zzx;
    }

    static int zzc(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzki.zzx(i10 << 3));
    }

    static int zzd(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlc) {
            zzlc zzlc = (zzlc) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzki.zzu(zzlc.zze(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + zzki.zzu(((Integer) list.get(i11)).intValue());
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
        return size * (zzki.zzx(i10 << 3) + 4);
    }

    static int zzf(List list) {
        return list.size() * 4;
    }

    static int zzg(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzki.zzx(i10 << 3) + 8);
    }

    static int zzh(List list) {
        return list.size() * 8;
    }

    static int zzi(int i10, List list, zzmt zzmt) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            i11 += zzki.zzt(i10, (zzmi) list.get(i12), zzmt);
        }
        return i11;
    }

    static int zzj(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzk(list) + (size * zzki.zzx(i10 << 3));
    }

    static int zzk(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlc) {
            zzlc zzlc = (zzlc) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzki.zzu(zzlc.zze(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + zzki.zzu(((Integer) list.get(i11)).intValue());
                i11++;
            }
        }
        return i10;
    }

    static int zzl(int i10, List list, boolean z10) {
        if (list.size() == 0) {
            return 0;
        }
        return zzm(list) + (list.size() * zzki.zzx(i10 << 3));
    }

    static int zzm(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlx) {
            zzlx zzlx = (zzlx) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzki.zzy(zzlx.zza(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + zzki.zzy(((Long) list.get(i11)).longValue());
                i11++;
            }
        }
        return i10;
    }

    static int zzn(int i10, Object obj, zzmt zzmt) {
        if (obj instanceof zzlo) {
            int i11 = zzki.zzb;
            int zza2 = ((zzlo) obj).zza();
            return zzki.zzx(i10 << 3) + zzki.zzx(zza2) + zza2;
        }
        return zzki.zzx(i10 << 3) + zzki.zzv((zzmi) obj, zzmt);
    }

    static int zzo(int i10, List list, zzmt zzmt) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzx = zzki.zzx(i10 << 3) * size;
        for (int i11 = 0; i11 < size; i11++) {
            Object obj = list.get(i11);
            if (obj instanceof zzlo) {
                int zza2 = ((zzlo) obj).zza();
                zzx += zzki.zzx(zza2) + zza2;
            } else {
                zzx += zzki.zzv((zzmi) obj, zzmt);
            }
        }
        return zzx;
    }

    static int zzp(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzq(list) + (size * zzki.zzx(i10 << 3));
    }

    static int zzq(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlc) {
            zzlc zzlc = (zzlc) list;
            i10 = 0;
            while (i11 < size) {
                int zze = zzlc.zze(i11);
                i10 += zzki.zzx((zze >> 31) ^ (zze + zze));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                int intValue = ((Integer) list.get(i11)).intValue();
                i12 = i10 + zzki.zzx((intValue >> 31) ^ (intValue + intValue));
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
        return zzs(list) + (size * zzki.zzx(i10 << 3));
    }

    static int zzs(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlx) {
            zzlx zzlx = (zzlx) list;
            i10 = 0;
            while (i11 < size) {
                long zza2 = zzlx.zza(i11);
                i10 += zzki.zzy((zza2 >> 63) ^ (zza2 + zza2));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                long longValue = ((Long) list.get(i11)).longValue();
                i12 = i10 + zzki.zzy((longValue >> 63) ^ (longValue + longValue));
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
        boolean z10 = list instanceof zzlq;
        int zzx = zzki.zzx(i10 << 3) * size;
        if (z10) {
            zzlq zzlq = (zzlq) list;
            while (i11 < size) {
                Object zzf = zzlq.zzf(i11);
                if (zzf instanceof zzka) {
                    int zzd2 = ((zzka) zzf).zzd();
                    zzx += zzki.zzx(zzd2) + zzd2;
                } else {
                    zzx += zzki.zzw((String) zzf);
                }
                i11++;
            }
        } else {
            while (i11 < size) {
                Object obj = list.get(i11);
                if (obj instanceof zzka) {
                    int zzd3 = ((zzka) obj).zzd();
                    zzw = zzx + zzki.zzx(zzd3) + zzd3;
                } else {
                    zzw = zzx + zzki.zzw((String) obj);
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
        return zzv(list) + (size * zzki.zzx(i10 << 3));
    }

    static int zzv(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlc) {
            zzlc zzlc = (zzlc) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzki.zzx(zzlc.zze(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + zzki.zzx(((Integer) list.get(i11)).intValue());
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
        return zzx(list) + (size * zzki.zzx(i10 << 3));
    }

    static int zzx(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlx) {
            zzlx zzlx = (zzlx) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzki.zzy(zzlx.zza(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + zzki.zzy(((Long) list.get(i11)).longValue());
                i11++;
            }
        }
        return i10;
    }

    public static zznk zzy() {
        return zzc;
    }

    public static zznk zzz() {
        return zzd;
    }
}
