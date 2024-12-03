package rd;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.gtm.zzav;
import com.google.android.gms.internal.gtm.zzbe;
import com.google.android.gms.internal.gtm.zzbr;
import com.google.android.gms.internal.gtm.zzbt;
import com.google.android.gms.internal.gtm.zzbv;
import com.google.android.gms.internal.gtm.zzbx;
import com.google.android.gms.internal.gtm.zzex;
import com.google.android.gms.internal.gtm.zzfs;
import com.mparticle.kits.ReportingMessage;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public final class f extends zzbr implements w {

    /* renamed from: d  reason: collision with root package name */
    private static DecimalFormat f41849d;

    /* renamed from: a  reason: collision with root package name */
    private final zzbv f41850a;

    /* renamed from: b  reason: collision with root package name */
    private final String f41851b;

    /* renamed from: c  reason: collision with root package name */
    private final Uri f41852c;

    public f(zzbv zzbv, String str) {
        super(zzbv);
        p.g(str);
        this.f41850a = zzbv;
        this.f41851b = str;
        this.f41852c = b(str);
    }

    static Uri b(String str) {
        p.g(str);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("uri");
        builder.authority("google-analytics.com");
        builder.path(str);
        return builder.build();
    }

    static String c(double d10) {
        if (f41849d == null) {
            f41849d = new DecimalFormat("0.######");
        }
        return f41849d.format(d10);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003c, code lost:
        if (android.text.TextUtils.isEmpty(r6) != false) goto L_0x0030;
     */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x001e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, java.lang.String> e(rd.k r12) {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.Class<com.google.android.gms.internal.gtm.zzaz> r1 = com.google.android.gms.internal.gtm.zzaz.class
            rd.m r1 = r12.c(r1)
            com.google.android.gms.internal.gtm.zzaz r1 = (com.google.android.gms.internal.gtm.zzaz) r1
            r2 = 0
            r4 = 0
            if (r1 == 0) goto L_0x0071
            java.util.Map r1 = r1.zzd()
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x001e:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x0071
            java.lang.Object r5 = r1.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r6 = r5.getValue()
            if (r6 != 0) goto L_0x0032
        L_0x0030:
            r6 = r4
            goto L_0x0065
        L_0x0032:
            boolean r7 = r6 instanceof java.lang.String
            if (r7 == 0) goto L_0x003f
            java.lang.String r6 = (java.lang.String) r6
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 == 0) goto L_0x0065
            goto L_0x0030
        L_0x003f:
            boolean r7 = r6 instanceof java.lang.Double
            if (r7 == 0) goto L_0x0056
            java.lang.Double r6 = (java.lang.Double) r6
            double r7 = r6.doubleValue()
            int r7 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r7 == 0) goto L_0x0030
            double r6 = r6.doubleValue()
            java.lang.String r6 = c(r6)
            goto L_0x0065
        L_0x0056:
            boolean r7 = r6 instanceof java.lang.Boolean
            if (r7 == 0) goto L_0x0061
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            if (r6 == r7) goto L_0x0030
            java.lang.String r6 = "1"
            goto L_0x0065
        L_0x0061:
            java.lang.String r6 = java.lang.String.valueOf(r6)
        L_0x0065:
            if (r6 == 0) goto L_0x001e
            java.lang.Object r5 = r5.getKey()
            java.lang.String r5 = (java.lang.String) r5
            r0.put(r5, r6)
            goto L_0x001e
        L_0x0071:
            java.lang.Class<com.google.android.gms.internal.gtm.zzbe> r1 = com.google.android.gms.internal.gtm.zzbe.class
            rd.m r1 = r12.c(r1)
            com.google.android.gms.internal.gtm.zzbe r1 = (com.google.android.gms.internal.gtm.zzbe) r1
            if (r1 == 0) goto L_0x00b6
            java.lang.String r5 = r1.zzf()
            java.lang.String r6 = "t"
            f(r0, r6, r5)
            java.lang.String r5 = r1.zze()
            java.lang.String r6 = "cid"
            f(r0, r6, r5)
            java.lang.String r5 = r1.zzg()
            java.lang.String r6 = "uid"
            f(r0, r6, r5)
            java.lang.String r5 = "sc"
            f(r0, r5, r4)
            boolean r5 = r1.zzo()
            java.lang.String r6 = "ni"
            g(r0, r6, r5)
            java.lang.String r5 = r1.zzd()
            java.lang.String r6 = "adid"
            f(r0, r6, r5)
            boolean r1 = r1.zzn()
            java.lang.String r5 = "ate"
            g(r0, r5, r1)
        L_0x00b6:
            java.lang.Class<com.google.android.gms.internal.gtm.zzbf> r1 = com.google.android.gms.internal.gtm.zzbf.class
            rd.m r1 = r12.c(r1)
            com.google.android.gms.internal.gtm.zzbf r1 = (com.google.android.gms.internal.gtm.zzbf) r1
            if (r1 == 0) goto L_0x00dc
            java.lang.String r5 = "cd"
            f(r0, r5, r4)
            int r1 = r1.zzd()
            double r5 = (double) r1
            int r1 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r1 == 0) goto L_0x00d7
            java.lang.String r1 = c(r5)
            java.lang.String r2 = "a"
            r0.put(r2, r1)
        L_0x00d7:
            java.lang.String r1 = "dr"
            f(r0, r1, r4)
        L_0x00dc:
            java.lang.Class<com.google.android.gms.internal.gtm.zzbc> r1 = com.google.android.gms.internal.gtm.zzbc.class
            rd.m r1 = r12.c(r1)
            com.google.android.gms.internal.gtm.zzbc r1 = (com.google.android.gms.internal.gtm.zzbc) r1
            if (r1 == 0) goto L_0x00f5
            java.lang.String r1 = "ec"
            f(r0, r1, r4)
            java.lang.String r1 = "ea"
            f(r0, r1, r4)
            java.lang.String r1 = "el"
            f(r0, r1, r4)
        L_0x00f5:
            java.lang.Class<com.google.android.gms.internal.gtm.zzaw> r1 = com.google.android.gms.internal.gtm.zzaw.class
            rd.m r1 = r12.c(r1)
            com.google.android.gms.internal.gtm.zzaw r1 = (com.google.android.gms.internal.gtm.zzaw) r1
            if (r1 == 0) goto L_0x0159
            java.lang.String r2 = r1.zzl()
            java.lang.String r3 = "cn"
            f(r0, r3, r2)
            java.lang.String r2 = r1.zzm()
            java.lang.String r3 = "cs"
            f(r0, r3, r2)
            java.lang.String r2 = r1.zzk()
            java.lang.String r3 = "cm"
            f(r0, r3, r2)
            java.lang.String r2 = r1.zzj()
            java.lang.String r3 = "ck"
            f(r0, r3, r2)
            java.lang.String r2 = r1.zzf()
            java.lang.String r3 = "cc"
            f(r0, r3, r2)
            java.lang.String r2 = r1.zzi()
            java.lang.String r3 = "ci"
            f(r0, r3, r2)
            java.lang.String r2 = r1.zze()
            java.lang.String r3 = "anid"
            f(r0, r3, r2)
            java.lang.String r2 = r1.zzh()
            java.lang.String r3 = "gclid"
            f(r0, r3, r2)
            java.lang.String r2 = r1.zzg()
            java.lang.String r3 = "dclid"
            f(r0, r3, r2)
            java.lang.String r1 = r1.zzd()
            java.lang.String r2 = "aclid"
            f(r0, r2, r1)
        L_0x0159:
            java.lang.Class<com.google.android.gms.internal.gtm.zzbd> r1 = com.google.android.gms.internal.gtm.zzbd.class
            rd.m r1 = r12.c(r1)
            com.google.android.gms.internal.gtm.zzbd r1 = (com.google.android.gms.internal.gtm.zzbd) r1
            if (r1 == 0) goto L_0x0168
            java.lang.String r1 = "exd"
            f(r0, r1, r4)
        L_0x0168:
            java.lang.Class<com.google.android.gms.internal.gtm.zzbg> r1 = com.google.android.gms.internal.gtm.zzbg.class
            rd.m r1 = r12.c(r1)
            com.google.android.gms.internal.gtm.zzbg r1 = (com.google.android.gms.internal.gtm.zzbg) r1
            if (r1 == 0) goto L_0x0181
            java.lang.String r1 = "sn"
            f(r0, r1, r4)
            java.lang.String r1 = "sa"
            f(r0, r1, r4)
            java.lang.String r1 = "st"
            f(r0, r1, r4)
        L_0x0181:
            java.lang.Class<com.google.android.gms.internal.gtm.zzbh> r1 = com.google.android.gms.internal.gtm.zzbh.class
            rd.m r1 = r12.c(r1)
            com.google.android.gms.internal.gtm.zzbh r1 = (com.google.android.gms.internal.gtm.zzbh) r1
            if (r1 == 0) goto L_0x019a
            java.lang.String r1 = "utv"
            f(r0, r1, r4)
            java.lang.String r1 = "utc"
            f(r0, r1, r4)
            java.lang.String r1 = "utl"
            f(r0, r1, r4)
        L_0x019a:
            java.lang.Class<com.google.android.gms.internal.gtm.zzax> r1 = com.google.android.gms.internal.gtm.zzax.class
            rd.m r1 = r12.c(r1)
            com.google.android.gms.internal.gtm.zzax r1 = (com.google.android.gms.internal.gtm.zzax) r1
            if (r1 == 0) goto L_0x01da
            java.util.Map r1 = r1.zzd()
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x01b0:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x01da
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            java.lang.String r3 = rd.g.a(r3)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L_0x01b0
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = (java.lang.String) r2
            r0.put(r3, r2)
            goto L_0x01b0
        L_0x01da:
            java.lang.Class<com.google.android.gms.internal.gtm.zzay> r1 = com.google.android.gms.internal.gtm.zzay.class
            rd.m r1 = r12.c(r1)
            com.google.android.gms.internal.gtm.zzay r1 = (com.google.android.gms.internal.gtm.zzay) r1
            if (r1 == 0) goto L_0x0222
            java.util.Map r1 = r1.zzd()
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x01f0:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0222
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            java.lang.String r3 = rd.g.b(r3)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L_0x01f0
            java.lang.Object r2 = r2.getValue()
            java.lang.Double r2 = (java.lang.Double) r2
            double r4 = r2.doubleValue()
            java.lang.String r2 = c(r4)
            r0.put(r3, r2)
            goto L_0x01f0
        L_0x0222:
            java.lang.Class<com.google.android.gms.internal.gtm.zzbb> r1 = com.google.android.gms.internal.gtm.zzbb.class
            rd.m r1 = r12.c(r1)
            com.google.android.gms.internal.gtm.zzbb r1 = (com.google.android.gms.internal.gtm.zzbb) r1
            if (r1 == 0) goto L_0x02ee
            java.util.List r2 = r1.zze()
            java.util.Iterator r2 = r2.iterator()
            r3 = 1
            r4 = r3
        L_0x0236:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x024f
            java.lang.Object r5 = r2.next()
            sd.b r5 = (sd.b) r5
            java.lang.String r6 = rd.g.f(r4)
            java.util.Map r5 = r5.a(r6)
            r0.putAll(r5)
            int r4 = r4 + r3
            goto L_0x0236
        L_0x024f:
            java.util.List r2 = r1.zzd()
            java.util.Iterator r2 = r2.iterator()
            r4 = r3
        L_0x0258:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x0271
            java.lang.Object r5 = r2.next()
            sd.a r5 = (sd.a) r5
            java.lang.String r6 = rd.g.e(r4)
            java.util.Map r5 = r5.a(r6)
            r0.putAll(r5)
            int r4 = r4 + r3
            goto L_0x0258
        L_0x0271:
            java.util.Map r1 = r1.zzf()
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
            r2 = r3
        L_0x027e:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x02ee
            java.lang.Object r4 = r1.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getValue()
            java.util.List r5 = (java.util.List) r5
            java.lang.String r6 = rd.g.c(r2)
            java.util.Iterator r5 = r5.iterator()
            r7 = r3
        L_0x0299:
            boolean r8 = r5.hasNext()
            if (r8 == 0) goto L_0x02cc
            java.lang.Object r8 = r5.next()
            sd.a r8 = (sd.a) r8
            java.lang.String r9 = java.lang.String.valueOf(r6)
            java.lang.String r10 = rd.g.d(r7)
            java.lang.String r10 = java.lang.String.valueOf(r10)
            int r11 = r10.length()
            if (r11 == 0) goto L_0x02bc
            java.lang.String r9 = r9.concat(r10)
            goto L_0x02c2
        L_0x02bc:
            java.lang.String r10 = new java.lang.String
            r10.<init>(r9)
            r9 = r10
        L_0x02c2:
            java.util.Map r8 = r8.a(r9)
            r0.putAll(r8)
            int r7 = r7 + 1
            goto L_0x0299
        L_0x02cc:
            java.lang.Object r5 = r4.getKey()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x02eb
            java.lang.String r5 = java.lang.String.valueOf(r6)
            java.lang.String r6 = "nm"
            java.lang.String r5 = r5.concat(r6)
            java.lang.Object r4 = r4.getKey()
            java.lang.String r4 = (java.lang.String) r4
            r0.put(r5, r4)
        L_0x02eb:
            int r2 = r2 + 1
            goto L_0x027e
        L_0x02ee:
            java.lang.Class<com.google.android.gms.internal.gtm.zzba> r1 = com.google.android.gms.internal.gtm.zzba.class
            rd.m r1 = r12.c(r1)
            com.google.android.gms.internal.gtm.zzba r1 = (com.google.android.gms.internal.gtm.zzba) r1
            if (r1 == 0) goto L_0x0324
            java.lang.String r2 = r1.zzd()
            java.lang.String r3 = "ul"
            f(r0, r3, r2)
            int r2 = r1.zza
            int r1 = r1.zzb
            if (r2 <= 0) goto L_0x0324
            if (r1 <= 0) goto L_0x0324
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r4 = 23
            r3.<init>(r4)
            r3.append(r2)
            java.lang.String r2 = "x"
            r3.append(r2)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            java.lang.String r2 = "sr"
            r0.put(r2, r1)
        L_0x0324:
            java.lang.Class<com.google.android.gms.internal.gtm.zzav> r1 = com.google.android.gms.internal.gtm.zzav.class
            rd.m r12 = r12.c(r1)
            com.google.android.gms.internal.gtm.zzav r12 = (com.google.android.gms.internal.gtm.zzav) r12
            if (r12 == 0) goto L_0x0352
            java.lang.String r1 = r12.zzf()
            java.lang.String r2 = "an"
            f(r0, r2, r1)
            java.lang.String r1 = r12.zzd()
            java.lang.String r2 = "aid"
            f(r0, r2, r1)
            java.lang.String r1 = r12.zze()
            java.lang.String r2 = "aiid"
            f(r0, r2, r1)
            java.lang.String r12 = r12.zzg()
            java.lang.String r1 = "av"
            f(r0, r1, r12)
        L_0x0352:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rd.f.e(rd.k):java.util.Map");
    }

    private static void f(Map<String, String> map, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    private static void g(Map<String, String> map, String str, boolean z10) {
        if (z10) {
            map.put(str, AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
    }

    public final void a(k kVar) {
        p.k(kVar);
        p.b(kVar.m(), "Can't deliver not submitted measurement");
        p.j("deliver should be called on worker thread");
        k kVar2 = new k(kVar);
        zzbe zzbe = (zzbe) kVar2.b(zzbe.class);
        if (TextUtils.isEmpty(zzbe.zzf())) {
            zzz().zzc(e(kVar2), "Ignoring measurement without type");
        } else if (TextUtils.isEmpty(zzbe.zze())) {
            zzz().zzc(e(kVar2), "Ignoring measurement without client id");
        } else if (this.f41850a.zzc().i()) {
        } else {
            if (zzfs.zzj(0.0d, zzbe.zze())) {
                zzG("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(0.0d));
                return;
            }
            Map<String, String> e10 = e(kVar2);
            e10.put(ReportingMessage.MessageType.SCREEN_VIEW, AppEventsConstants.EVENT_PARAM_VALUE_YES);
            e10.put("_v", zzbt.zzb);
            e10.put("tid", this.f41851b);
            if (this.f41850a.zzc().k()) {
                StringBuilder sb2 = new StringBuilder();
                for (Map.Entry next : e10.entrySet()) {
                    if (sb2.length() != 0) {
                        sb2.append(", ");
                    }
                    sb2.append((String) next.getKey());
                    sb2.append("=");
                    sb2.append((String) next.getValue());
                }
                zzN("Dry run is enabled. GoogleAnalytics would have sent", sb2.toString());
                return;
            }
            HashMap hashMap = new HashMap();
            zzfs.zzg(hashMap, "uid", zzbe.zzg());
            zzav zzav = (zzav) kVar.c(zzav.class);
            if (zzav != null) {
                zzfs.zzg(hashMap, "an", zzav.zzf());
                zzfs.zzg(hashMap, "aid", zzav.zzd());
                zzfs.zzg(hashMap, "av", zzav.zzg());
                zzfs.zzg(hashMap, "aiid", zzav.zze());
            }
            e10.put("_s", String.valueOf(zzs().zza(new zzbx(0, zzbe.zze(), this.f41851b, !TextUtils.isEmpty(zzbe.zzd()), 0, hashMap))));
            zzs().zzh(new zzex(zzz(), e10, kVar.a(), true));
        }
    }

    public final Uri zzb() {
        return this.f41852c;
    }
}
