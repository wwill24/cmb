package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzak;
import com.google.android.gms.internal.gtm.zzal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class zzfv {
    private static final Long zza = new Long(0);
    private static final Double zzb = new Double(0.0d);
    private static final zzfu zzc = zzfu.zzd(0);
    private static final String zzd;
    private static final Boolean zze = new Boolean(false);
    private static final List<Object> zzf = new ArrayList(0);
    private static final Map<Object, Object> zzg = new HashMap();
    private static final zzak zzh;

    static {
        String str = new String("");
        zzd = str;
        zzh = zzc(str);
    }

    public static zzak zzc(Object obj) {
        String str;
        String str2;
        zzal zzg2 = zzak.zzg();
        zzg2.zzt(1);
        if (obj instanceof zzak) {
            return (zzak) obj;
        }
        boolean z10 = false;
        if (obj instanceof String) {
            zzg2.zzt(1);
            zzg2.zzs((String) obj);
        } else if (obj instanceof List) {
            zzg2.zzt(2);
            List<Object> list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            boolean z11 = false;
            for (Object zzc2 : list) {
                zzak zzc3 = zzc(zzc2);
                zzak zzak = zzh;
                if (zzc3 == zzak) {
                    return zzak;
                }
                if (z11 || zzc3.zzN()) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                arrayList.add(zzc3);
            }
            zzg2.zzj();
            zzg2.zzb(arrayList);
            z10 = z11;
        } else if (obj instanceof Map) {
            zzg2.zzt(3);
            Set<Map.Entry> entrySet = ((Map) obj).entrySet();
            ArrayList arrayList2 = new ArrayList(entrySet.size());
            ArrayList arrayList3 = new ArrayList(entrySet.size());
            boolean z12 = false;
            for (Map.Entry entry : entrySet) {
                zzak zzc4 = zzc(entry.getKey());
                zzak zzc5 = zzc(entry.getValue());
                zzak zzak2 = zzh;
                if (zzc4 == zzak2 || zzc5 == zzak2) {
                    return zzak2;
                }
                if (z12 || zzc4.zzN() || zzc5.zzN()) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                arrayList2.add(zzc4);
                arrayList3.add(zzc5);
            }
            zzg2.zzk();
            zzg2.zzc(arrayList2);
            zzg2.zzl();
            zzg2.zzd(arrayList3);
            z10 = z12;
        } else if (zzr(obj)) {
            zzg2.zzt(1);
            zzg2.zzs(obj.toString());
        } else if (zzs(obj)) {
            zzg2.zzt(6);
            zzg2.zzq(zzp(obj));
        } else if (obj instanceof Boolean) {
            zzg2.zzt(8);
            zzg2.zzn(((Boolean) obj).booleanValue());
        } else {
            if (obj == null) {
                str = "null";
            } else {
                str = obj.getClass().toString();
            }
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2 = "Converting to Value from unknown object type: ".concat(valueOf);
            } else {
                str2 = new String("Converting to Value from unknown object type: ");
            }
            zzdh.zza(str2);
            return zzh;
        }
        zzg2.zzo(z10);
        return (zzak) zzg2.zzC();
    }

    public static Object zzl(zzak zzak) {
        String str;
        if (zzak == null) {
            return null;
        }
        switch (zzak.zzO()) {
            case 1:
                return zzak.zzp();
            case 2:
                ArrayList arrayList = new ArrayList(zzak.zza());
                for (zzak zzl : zzak.zzr()) {
                    Object zzl2 = zzl(zzl);
                    if (zzl2 == null) {
                        return null;
                    }
                    arrayList.add(zzl2);
                }
                return arrayList;
            case 3:
                if (zzak.zzc() != zzak.zzd()) {
                    String valueOf = String.valueOf(zzak.toString());
                    if (valueOf.length() != 0) {
                        str = "Converting an invalid value to object: ".concat(valueOf);
                    } else {
                        str = new String("Converting an invalid value to object: ");
                    }
                    zzdh.zza(str);
                    return null;
                }
                HashMap hashMap = new HashMap(zzak.zzd());
                for (int i10 = 0; i10 < zzak.zzc(); i10++) {
                    Object zzl3 = zzl(zzak.zzk(i10));
                    Object zzl4 = zzl(zzak.zzl(i10));
                    if (zzl3 == null || zzl4 == null) {
                        return null;
                    }
                    hashMap.put(zzl3, zzl4);
                }
                return hashMap;
            case 4:
                zzdh.zza("Trying to convert a macro reference to object");
                return null;
            case 5:
                zzdh.zza("Trying to convert a function id to object");
                return null;
            case 6:
                return Long.valueOf(zzak.zzf());
            case 7:
                StringBuilder sb2 = new StringBuilder();
                for (zzak zzl5 : zzak.zzs()) {
                    String zzn = zzn(zzl(zzl5));
                    if (zzn == zzd) {
                        return null;
                    }
                    sb2.append(zzn);
                }
                return sb2.toString();
            default:
                return Boolean.valueOf(zzak.zzM());
        }
    }

    public static String zzn(Object obj) {
        return obj == null ? zzd : obj.toString();
    }

    private static long zzp(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        zzdh.zza("getInt64 received non-Number");
        return 0;
    }

    private static boolean zzr(Object obj) {
        if ((obj instanceof Double) || (obj instanceof Float) || ((obj instanceof zzfu) && ((zzfu) obj).zzf())) {
            return true;
        }
        return false;
    }

    private static boolean zzs(Object obj) {
        if ((obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || ((obj instanceof zzfu) && ((zzfu) obj).zzg())) {
            return true;
        }
        return false;
    }
}
