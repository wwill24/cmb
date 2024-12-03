package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jivesoftware.smack.datatypes.UInt32;

public final class zzh {
    public static double zza(double d10) {
        int i10;
        int i11;
        if (Double.isNaN(d10)) {
            return 0.0d;
        }
        if (Double.isInfinite(d10) || d10 == 0.0d || i10 == 0) {
            return d10;
        }
        if (i10 > 0) {
            i11 = 1;
        } else {
            i11 = -1;
        }
        return ((double) i11) * Math.floor(Math.abs(d10));
    }

    public static int zzb(double d10) {
        int i10;
        int i11;
        if (Double.isNaN(d10) || Double.isInfinite(d10) || d10 == 0.0d) {
            return 0;
        }
        if (i10 > 0) {
            i11 = 1;
        } else {
            i11 = -1;
        }
        return (int) ((long) ((((double) i11) * Math.floor(Math.abs(d10))) % 4.294967296E9d));
    }

    public static int zzc(zzg zzg) {
        int zzb = zzb(zzg.zzd("runtime.counter").zzh().doubleValue() + 1.0d);
        if (zzb <= 1000000) {
            zzg.zzg("runtime.counter", new zzah(Double.valueOf((double) zzb)));
            return zzb;
        }
        throw new IllegalStateException("Instructions allowed exceeded");
    }

    public static long zzd(double d10) {
        return ((long) zzb(d10)) & UInt32.MAX_VALUE_LONG;
    }

    public static zzbl zze(String str) {
        zzbl zzbl = null;
        if (str != null && !str.isEmpty()) {
            zzbl = zzbl.zza(Integer.parseInt(str));
        }
        if (zzbl != null) {
            return zzbl;
        }
        throw new IllegalArgumentException(String.format("Unsupported commandId %s", new Object[]{str}));
    }

    public static Object zzf(zzap zzap) {
        if (zzap.zzg.equals(zzap)) {
            return null;
        }
        if (zzap.zzf.equals(zzap)) {
            return "";
        }
        if (zzap instanceof zzam) {
            return zzg((zzam) zzap);
        }
        if (zzap instanceof zzae) {
            ArrayList arrayList = new ArrayList();
            Iterator it = ((zzae) zzap).iterator();
            while (it.hasNext()) {
                Object zzf = zzf((zzap) it.next());
                if (zzf != null) {
                    arrayList.add(zzf);
                }
            }
            return arrayList;
        } else if (!zzap.zzh().isNaN()) {
            return zzap.zzh();
        } else {
            return zzap.zzi();
        }
    }

    public static Map zzg(zzam zzam) {
        HashMap hashMap = new HashMap();
        for (String str : zzam.zzb()) {
            Object zzf = zzf(zzam.zzf(str));
            if (zzf != null) {
                hashMap.put(str, zzf);
            }
        }
        return hashMap;
    }

    public static void zzh(String str, int i10, List list) {
        if (list.size() != i10) {
            throw new IllegalArgumentException(String.format("%s operation requires %s parameters found %s", new Object[]{str, Integer.valueOf(i10), Integer.valueOf(list.size())}));
        }
    }

    public static void zzi(String str, int i10, List list) {
        if (list.size() < i10) {
            throw new IllegalArgumentException(String.format("%s operation requires at least %s parameters found %s", new Object[]{str, Integer.valueOf(i10), Integer.valueOf(list.size())}));
        }
    }

    public static void zzj(String str, int i10, List list) {
        if (list.size() > i10) {
            throw new IllegalArgumentException(String.format("%s operation requires at most %s parameters found %s", new Object[]{str, Integer.valueOf(i10), Integer.valueOf(list.size())}));
        }
    }

    public static boolean zzk(zzap zzap) {
        if (zzap == null) {
            return false;
        }
        Double zzh = zzap.zzh();
        if (zzh.isNaN() || zzh.doubleValue() < 0.0d || !zzh.equals(Double.valueOf(Math.floor(zzh.doubleValue())))) {
            return false;
        }
        return true;
    }

    public static boolean zzl(zzap zzap, zzap zzap2) {
        if (!zzap.getClass().equals(zzap2.getClass())) {
            return false;
        }
        if ((zzap instanceof zzau) || (zzap instanceof zzan)) {
            return true;
        }
        if (zzap instanceof zzah) {
            if (Double.isNaN(zzap.zzh().doubleValue()) || Double.isNaN(zzap2.zzh().doubleValue())) {
                return false;
            }
            return zzap.zzh().equals(zzap2.zzh());
        } else if (zzap instanceof zzat) {
            return zzap.zzi().equals(zzap2.zzi());
        } else {
            if (zzap instanceof zzaf) {
                return zzap.zzg().equals(zzap2.zzg());
            }
            if (zzap == zzap2) {
                return true;
            }
            return false;
        }
    }
}
