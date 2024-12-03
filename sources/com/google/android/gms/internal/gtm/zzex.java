package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.common.internal.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class zzex {
    private final Map<String, String> zza;
    private final List<zzcp> zzb;
    private final long zzc;
    private final long zzd;
    private final int zze;
    private final boolean zzf;
    private final String zzg;

    public zzex(zzbr zzbr, Map<String, String> map, long j10, boolean z10) {
        this(zzbr, map, j10, z10, 0, 0, (List<zzcp>) null);
    }

    public static zzex zze(zzbr zzbr, zzex zzex, Map<String, String> map) {
        return new zzex(zzbr, map, zzex.zzd, zzex.zzf, zzex.zzc, zzex.zze, zzex.zzb);
    }

    private final String zzi(String str, String str2) {
        p.g(str);
        p.b(!str.startsWith("&"), "Short param name required");
        String str3 = this.zza.get(str);
        if (str3 != null) {
            return str3;
        }
        return str2;
    }

    private static String zzj(zzbr zzbr, Object obj) {
        if (obj == null) {
            return null;
        }
        String obj2 = obj.toString();
        if (obj2.startsWith("&")) {
            obj2 = obj2.substring(1);
        }
        int length = obj2.length();
        if (length > 256) {
            obj2 = obj2.substring(0, 256);
            zzbr.zzT("Hit param name is too long and will be trimmed", Integer.valueOf(length), obj2);
        }
        if (TextUtils.isEmpty(obj2)) {
            return null;
        }
        return obj2;
    }

    private static String zzk(zzbr zzbr, Object obj) {
        String str;
        if (obj == null) {
            str = "";
        } else {
            str = obj.toString();
        }
        int length = str.length();
        if (length <= 8192) {
            return str;
        }
        String substring = str.substring(0, 8192);
        zzbr.zzT("Hit param value is too long and will be trimmed", Integer.valueOf(length), substring);
        return substring;
    }

    private static boolean zzl(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj.toString().startsWith("&");
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ht=");
        sb2.append(this.zzd);
        if (this.zzc != 0) {
            sb2.append(", dbId=");
            sb2.append(this.zzc);
        }
        if (this.zze != 0) {
            sb2.append(", appUID=");
            sb2.append(this.zze);
        }
        ArrayList arrayList = new ArrayList(this.zza.keySet());
        Collections.sort(arrayList);
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            String str = (String) arrayList.get(i10);
            sb2.append(", ");
            sb2.append(str);
            sb2.append("=");
            sb2.append(this.zza.get(str));
        }
        return sb2.toString();
    }

    public final int zza() {
        return this.zze;
    }

    public final long zzb() {
        return this.zzc;
    }

    public final long zzc() {
        return zzfs.zza(zzi("_s", "0"));
    }

    public final long zzd() {
        return this.zzd;
    }

    public final String zzf() {
        return zzi("_m", "");
    }

    public final Map<String, String> zzg() {
        return this.zza;
    }

    public final boolean zzh() {
        return this.zzf;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzex(com.google.android.gms.internal.gtm.zzbr r1, java.util.Map<java.lang.String, java.lang.String> r2, long r3, boolean r5, long r6, int r8, java.util.List<com.google.android.gms.internal.gtm.zzcp> r9) {
        /*
            r0 = this;
            r0.<init>()
            com.google.android.gms.common.internal.p.k(r1)
            com.google.android.gms.common.internal.p.k(r2)
            r0.zzd = r3
            r0.zzf = r5
            r0.zzc = r6
            r0.zze = r8
            if (r9 == 0) goto L_0x0015
            r3 = r9
            goto L_0x0019
        L_0x0015:
            java.util.List r3 = java.util.Collections.emptyList()
        L_0x0019:
            r0.zzb = r3
            r3 = 0
            if (r9 == 0) goto L_0x003f
            java.util.Iterator r4 = r9.iterator()
        L_0x0022:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x003f
            java.lang.Object r5 = r4.next()
            com.google.android.gms.internal.gtm.zzcp r5 = (com.google.android.gms.internal.gtm.zzcp) r5
            java.lang.String r6 = r5.zza()
            java.lang.String r7 = "appendVersion"
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto L_0x0022
            java.lang.String r4 = r5.zzb()
            goto L_0x0040
        L_0x003f:
            r4 = r3
        L_0x0040:
            r5 = 1
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            if (r5 != r6) goto L_0x0048
            goto L_0x0049
        L_0x0048:
            r3 = r4
        L_0x0049:
            r0.zzg = r3
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.util.Set r4 = r2.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x0058:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0084
            java.lang.Object r5 = r4.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r6 = r5.getKey()
            boolean r6 = zzl(r6)
            if (r6 == 0) goto L_0x0058
            java.lang.Object r6 = r5.getKey()
            java.lang.String r6 = zzj(r1, r6)
            if (r6 == 0) goto L_0x0058
            java.lang.Object r5 = r5.getValue()
            java.lang.String r5 = zzk(r1, r5)
            r3.put(r6, r5)
            goto L_0x0058
        L_0x0084:
            java.util.Set r2 = r2.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x008c:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x00b8
            java.lang.Object r4 = r2.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            boolean r5 = zzl(r5)
            if (r5 != 0) goto L_0x008c
            java.lang.Object r5 = r4.getKey()
            java.lang.String r5 = zzj(r1, r5)
            if (r5 == 0) goto L_0x008c
            java.lang.Object r4 = r4.getValue()
            java.lang.String r4 = zzk(r1, r4)
            r3.put(r5, r4)
            goto L_0x008c
        L_0x00b8:
            java.lang.String r1 = r0.zzg
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x00e0
            java.lang.String r1 = r0.zzg
            java.lang.String r2 = "_v"
            com.google.android.gms.internal.gtm.zzfs.zzg(r3, r2, r1)
            java.lang.String r1 = r0.zzg
            java.lang.String r2 = "ma4.0.0"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00db
            java.lang.String r1 = r0.zzg
            java.lang.String r2 = "ma4.0.1"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00e0
        L_0x00db:
            java.lang.String r1 = "adid"
            r3.remove(r1)
        L_0x00e0:
            java.util.Map r1 = java.util.Collections.unmodifiableMap(r3)
            r0.zza = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzex.<init>(com.google.android.gms.internal.gtm.zzbr, java.util.Map, long, boolean, long, int, java.util.List):void");
    }
}
