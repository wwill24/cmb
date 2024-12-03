package com.google.android.gms.internal.p003firebaseauthapi;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzamd  reason: invalid package */
final class zzamd {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zzamv zzc;
    private static final zzamv zzd = new zzamx();

    static {
        Class<?> cls;
        Class<?> cls2;
        zzamv zzamv = null;
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
                zzamv = (zzamv) cls2.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable unused3) {
            }
        }
        zzc = zzamv;
    }

    public static void zzA(int i10, List list, zzajt zzajt, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzajt.zzu(i10, list, z10);
        }
    }

    public static void zzB(int i10, List list, zzajt zzajt, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzajt.zzx(i10, list, z10);
        }
    }

    public static void zzC(int i10, List list, zzajt zzajt, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzajt.zzz(i10, list, z10);
        }
    }

    public static void zzD(int i10, List list, zzajt zzajt, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzajt.zzB(i10, list, z10);
        }
    }

    public static void zzE(int i10, List list, zzajt zzajt, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzajt.zzD(i10, list, z10);
        }
    }

    public static void zzF(int i10, List list, zzajt zzajt, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzajt.zzI(i10, list, z10);
        }
    }

    public static void zzG(int i10, List list, zzajt zzajt, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzajt.zzK(i10, list, z10);
        }
    }

    static int zza(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzakl) {
            zzakl zzakl = (zzakl) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzajs.zzx(zzakl.zze(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + zzajs.zzx(((Integer) list.get(i11)).intValue());
                i11++;
            }
        }
        return i10;
    }

    static int zzb(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzajs.zzA(i10 << 3) + 4);
    }

    static int zzc(List list) {
        return list.size() * 4;
    }

    static int zzd(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzajs.zzA(i10 << 3) + 8);
    }

    static int zze(List list) {
        return list.size() * 8;
    }

    static int zzf(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzakl) {
            zzakl zzakl = (zzakl) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzajs.zzx(zzakl.zze(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + zzajs.zzx(((Integer) list.get(i11)).intValue());
                i11++;
            }
        }
        return i10;
    }

    static int zzg(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzale) {
            zzale zzale = (zzale) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzajs.zzB(zzale.zze(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + zzajs.zzB(((Long) list.get(i11)).longValue());
                i11++;
            }
        }
        return i10;
    }

    static int zzh(int i10, Object obj, zzamb zzamb) {
        int i11 = i10 << 3;
        if (obj instanceof zzakv) {
            int i12 = zzajs.zzf;
            int zza2 = ((zzakv) obj).zza();
            return zzajs.zzA(i11) + zzajs.zzA(zza2) + zza2;
        }
        return zzajs.zzA(i11) + zzajs.zzy((zzalp) obj, zzamb);
    }

    static int zzi(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzakl) {
            zzakl zzakl = (zzakl) list;
            i10 = 0;
            while (i11 < size) {
                int zze = zzakl.zze(i11);
                i10 += zzajs.zzA((zze >> 31) ^ (zze + zze));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                int intValue = ((Integer) list.get(i11)).intValue();
                i12 = i10 + zzajs.zzA((intValue >> 31) ^ (intValue + intValue));
                i11++;
            }
        }
        return i10;
    }

    static int zzj(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzale) {
            zzale zzale = (zzale) list;
            i10 = 0;
            while (i11 < size) {
                long zze = zzale.zze(i11);
                i10 += zzajs.zzB((zze >> 63) ^ (zze + zze));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                long longValue = ((Long) list.get(i11)).longValue();
                i12 = i10 + zzajs.zzB((longValue >> 63) ^ (longValue + longValue));
                i11++;
            }
        }
        return i10;
    }

    static int zzk(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzakl) {
            zzakl zzakl = (zzakl) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzajs.zzA(zzakl.zze(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + zzajs.zzA(((Integer) list.get(i11)).intValue());
                i11++;
            }
        }
        return i10;
    }

    static int zzl(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzale) {
            zzale zzale = (zzale) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzajs.zzB(zzale.zze(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + zzajs.zzB(((Long) list.get(i11)).longValue());
                i11++;
            }
        }
        return i10;
    }

    public static zzamv zzm() {
        return zzc;
    }

    public static zzamv zzn() {
        return zzd;
    }

    static Object zzo(Object obj, int i10, List list, zzako zzako, Object obj2, zzamv zzamv) {
        if (zzako == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                int intValue = ((Integer) list.get(i12)).intValue();
                if (zzako.zza()) {
                    if (i12 != i11) {
                        list.set(i11, Integer.valueOf(intValue));
                    }
                    i11++;
                } else {
                    obj2 = zzp(obj, i10, intValue, obj2, zzamv);
                }
            }
            if (i11 != size) {
                list.subList(i11, size).clear();
                return obj2;
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = ((Integer) it.next()).intValue();
                if (!zzako.zza()) {
                    obj2 = zzp(obj, i10, intValue2, obj2, zzamv);
                    it.remove();
                }
            }
        }
        return obj2;
    }

    static Object zzp(Object obj, int i10, int i11, Object obj2, zzamv zzamv) {
        if (obj2 == null) {
            obj2 = zzamv.zzc(obj);
        }
        zzamv.zzl(obj2, i10, (long) i11);
        return obj2;
    }

    static void zzq(zzamv zzamv, Object obj, Object obj2) {
        zzamv.zzo(obj, zzamv.zze(zzamv.zzd(obj), zzamv.zzd(obj2)));
    }

    public static void zzr(Class cls) {
        Class cls2;
        if (!zzakk.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    static boolean zzs(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static void zzt(int i10, List list, zzajt zzajt, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzajt.zzc(i10, list, z10);
        }
    }

    public static void zzu(int i10, List list, zzajt zzajt, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzajt.zzg(i10, list, z10);
        }
    }

    public static void zzv(int i10, List list, zzajt zzajt, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzajt.zzj(i10, list, z10);
        }
    }

    public static void zzw(int i10, List list, zzajt zzajt, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzajt.zzl(i10, list, z10);
        }
    }

    public static void zzx(int i10, List list, zzajt zzajt, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzajt.zzn(i10, list, z10);
        }
    }

    public static void zzy(int i10, List list, zzajt zzajt, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzajt.zzp(i10, list, z10);
        }
    }

    public static void zzz(int i10, List list, zzajt zzajt, boolean z10) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzajt.zzs(i10, list, z10);
        }
    }
}
