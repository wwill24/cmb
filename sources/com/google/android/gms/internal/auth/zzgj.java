package com.google.android.gms.internal.auth;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zzgj {
    private static final Class zza;
    private static final zzgy zzb = zzj(false);
    private static final zzgy zzc = zzj(true);
    private static final zzgy zzd = new zzha();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zza = cls;
    }

    public static zzgy zza() {
        return zzb;
    }

    public static zzgy zzb() {
        return zzc;
    }

    public static zzgy zzc() {
        return zzd;
    }

    static Object zzd(int i10, List list, zzex zzex, Object obj, zzgy zzgy) {
        if (zzex == null) {
            return obj;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                int intValue = ((Integer) list.get(i12)).intValue();
                if (zzex.zza()) {
                    if (i12 != i11) {
                        list.set(i11, Integer.valueOf(intValue));
                    }
                    i11++;
                } else {
                    obj = zze(i10, intValue, obj, zzgy);
                }
            }
            if (i11 != size) {
                list.subList(i11, size).clear();
                return obj;
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = ((Integer) it.next()).intValue();
                if (!zzex.zza()) {
                    obj = zze(i10, intValue2, obj, zzgy);
                    it.remove();
                }
            }
        }
        return obj;
    }

    static Object zze(int i10, int i11, Object obj, zzgy zzgy) {
        if (obj == null) {
            obj = zzgy.zzc();
        }
        zzgy.zzd(obj, i10, (long) i11);
        return obj;
    }

    static void zzf(zzgy zzgy, Object obj, Object obj2) {
        zzgy.zzf(obj, zzgy.zzb(zzgy.zza(obj), zzgy.zza(obj2)));
    }

    public static void zzg(Class cls) {
        Class cls2;
        if (!zzeu.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    static boolean zzh(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static void zzi(zzfr zzfr, Object obj, Object obj2, long j10) {
        zzhi.zzp(obj, j10, zzfr.zza(zzhi.zzf(obj, j10), zzhi.zzf(obj2, j10)));
    }

    private static zzgy zzj(boolean z10) {
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
            return (zzgy) cls.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z10)});
        } catch (Throwable unused2) {
            return null;
        }
    }
}
