package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.collection.a;
import androidx.collection.f;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.internal.measurement.zzd;
import com.google.android.gms.internal.measurement.zzfb;
import com.google.android.gms.internal.measurement.zzfc;
import com.google.android.gms.internal.measurement.zzfe;
import com.google.android.gms.internal.measurement.zzff;
import com.google.android.gms.internal.measurement.zzfj;
import com.google.android.gms.internal.measurement.zzgr;
import com.google.android.gms.internal.measurement.zzgt;
import com.google.android.gms.internal.measurement.zzll;
import com.google.android.gms.internal.measurement.zzr;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.jivesoftware.smackx.softwareinfo.form.SoftwareInfoForm;
import we.j;
import we.p;

public final class o4 extends b9 implements f {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Map f40103d = new a();

    /* renamed from: e  reason: collision with root package name */
    final Map f40104e = new a();

    /* renamed from: f  reason: collision with root package name */
    final Map f40105f = new a();

    /* renamed from: g  reason: collision with root package name */
    final Map f40106g = new a();

    /* renamed from: h  reason: collision with root package name */
    private final Map f40107h = new a();

    /* renamed from: i  reason: collision with root package name */
    private final Map f40108i = new a();

    /* renamed from: j  reason: collision with root package name */
    final f f40109j = new l4(this, 20);

    /* renamed from: k  reason: collision with root package name */
    final zzr f40110k = new m4(this);

    /* renamed from: l  reason: collision with root package name */
    private final Map f40111l = new a();

    /* renamed from: m  reason: collision with root package name */
    private final Map f40112m = new a();

    /* renamed from: n  reason: collision with root package name */
    private final Map f40113n = new a();

    o4(n9 n9Var) {
        super(n9Var);
    }

    private final zzff m(String str, byte[] bArr) {
        Long l10;
        if (bArr == null) {
            return zzff.zzg();
        }
        try {
            zzff zzff = (zzff) ((zzfe) p9.E(zzff.zze(), bArr)).zzaD();
            o3 v10 = this.f40059a.d().v();
            String str2 = null;
            if (zzff.zzu()) {
                l10 = Long.valueOf(zzff.zzc());
            } else {
                l10 = null;
            }
            if (zzff.zzt()) {
                str2 = zzff.zzh();
            }
            v10.c("Parsed config. version, gmp_app_id", l10, str2);
            return zzff;
        } catch (zzll e10) {
            this.f40059a.d().w().c("Unable to merge remote config. appId", q3.z(str), e10);
            return zzff.zzg();
        } catch (RuntimeException e11) {
            this.f40059a.d().w().c("Unable to merge remote config. appId", q3.z(str), e11);
            return zzff.zzg();
        }
    }

    private final void n(String str, zzfe zzfe) {
        HashSet hashSet = new HashSet();
        a aVar = new a();
        a aVar2 = new a();
        a aVar3 = new a();
        for (zzfb zzb : zzfe.zzg()) {
            hashSet.add(zzb.zzb());
        }
        for (int i10 = 0; i10 < zzfe.zza(); i10++) {
            zzfc zzfc = (zzfc) zzfe.zzb(i10).zzbB();
            if (zzfc.zzc().isEmpty()) {
                this.f40059a.d().w().a("EventConfig contained null event name");
            } else {
                String zzc = zzfc.zzc();
                String b10 = p.b(zzfc.zzc());
                if (!TextUtils.isEmpty(b10)) {
                    zzfc.zzb(b10);
                    zzfe.zzd(i10, zzfc);
                }
                if (zzfc.zzf() && zzfc.zzd()) {
                    aVar.put(zzc, Boolean.TRUE);
                }
                if (zzfc.zzg() && zzfc.zze()) {
                    aVar2.put(zzfc.zzc(), Boolean.TRUE);
                }
                if (zzfc.zzh()) {
                    if (zzfc.zza() < 2 || zzfc.zza() > 65535) {
                        this.f40059a.d().w().c("Invalid sampling rate. Event name, sample rate", zzfc.zzc(), Integer.valueOf(zzfc.zza()));
                    } else {
                        aVar3.put(zzfc.zzc(), Integer.valueOf(zzfc.zza()));
                    }
                }
            }
        }
        this.f40104e.put(str, hashSet);
        this.f40105f.put(str, aVar);
        this.f40106g.put(str, aVar2);
        this.f40108i.put(str, aVar3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0094, code lost:
        if (r2 != null) goto L_0x0096;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0118  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void o(java.lang.String r13) {
        /*
            r12 = this;
            r12.i()
            r12.h()
            com.google.android.gms.common.internal.p.g(r13)
            java.util.Map r0 = r12.f40107h
            java.lang.Object r0 = r0.get(r13)
            if (r0 != 0) goto L_0x011c
            com.google.android.gms.measurement.internal.n9 r0 = r12.f39651b
            com.google.android.gms.measurement.internal.k r0 = r0.V()
            com.google.android.gms.common.internal.p.g(r13)
            r0.h()
            r0.i()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r0.P()     // Catch:{ SQLiteException -> 0x007e, all -> 0x007b }
            java.lang.String r3 = "apps"
            java.lang.String r4 = "remote_config"
            java.lang.String r5 = "config_last_modified_time"
            java.lang.String r6 = "e_tag"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5, r6}     // Catch:{ SQLiteException -> 0x007e, all -> 0x007b }
            java.lang.String r5 = "app_id=?"
            r10 = 1
            java.lang.String[] r6 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x007e, all -> 0x007b }
            r11 = 0
            r6[r11] = r13     // Catch:{ SQLiteException -> 0x007e, all -> 0x007b }
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x007e, all -> 0x007b }
            boolean r3 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0079 }
            if (r3 != 0) goto L_0x0047
            goto L_0x0096
        L_0x0047:
            byte[] r3 = r2.getBlob(r11)     // Catch:{ SQLiteException -> 0x0079 }
            java.lang.String r4 = r2.getString(r10)     // Catch:{ SQLiteException -> 0x0079 }
            r5 = 2
            java.lang.String r5 = r2.getString(r5)     // Catch:{ SQLiteException -> 0x0079 }
            boolean r6 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x0079 }
            if (r6 == 0) goto L_0x006d
            com.google.android.gms.measurement.internal.u4 r6 = r0.f40059a     // Catch:{ SQLiteException -> 0x0079 }
            com.google.android.gms.measurement.internal.q3 r6 = r6.d()     // Catch:{ SQLiteException -> 0x0079 }
            com.google.android.gms.measurement.internal.o3 r6 = r6.r()     // Catch:{ SQLiteException -> 0x0079 }
            java.lang.String r7 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.q3.z(r13)     // Catch:{ SQLiteException -> 0x0079 }
            r6.b(r7, r8)     // Catch:{ SQLiteException -> 0x0079 }
        L_0x006d:
            if (r3 != 0) goto L_0x0070
            goto L_0x0096
        L_0x0070:
            com.google.android.gms.measurement.internal.h r6 = new com.google.android.gms.measurement.internal.h     // Catch:{ SQLiteException -> 0x0079 }
            r6.<init>(r3, r4, r5)     // Catch:{ SQLiteException -> 0x0079 }
            r2.close()
            goto L_0x009a
        L_0x0079:
            r3 = move-exception
            goto L_0x0081
        L_0x007b:
            r13 = move-exception
            goto L_0x0116
        L_0x007e:
            r2 = move-exception
            r3 = r2
            r2 = r1
        L_0x0081:
            com.google.android.gms.measurement.internal.u4 r0 = r0.f40059a     // Catch:{ all -> 0x0114 }
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()     // Catch:{ all -> 0x0114 }
            com.google.android.gms.measurement.internal.o3 r0 = r0.r()     // Catch:{ all -> 0x0114 }
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.q3.z(r13)     // Catch:{ all -> 0x0114 }
            r0.c(r4, r5, r3)     // Catch:{ all -> 0x0114 }
            if (r2 == 0) goto L_0x0099
        L_0x0096:
            r2.close()
        L_0x0099:
            r6 = r1
        L_0x009a:
            if (r6 != 0) goto L_0x00ca
            java.util.Map r0 = r12.f40103d
            r0.put(r13, r1)
            java.util.Map r0 = r12.f40105f
            r0.put(r13, r1)
            java.util.Map r0 = r12.f40104e
            r0.put(r13, r1)
            java.util.Map r0 = r12.f40106g
            r0.put(r13, r1)
            java.util.Map r0 = r12.f40107h
            r0.put(r13, r1)
            java.util.Map r0 = r12.f40111l
            r0.put(r13, r1)
            java.util.Map r0 = r12.f40112m
            r0.put(r13, r1)
            java.util.Map r0 = r12.f40113n
            r0.put(r13, r1)
            java.util.Map r0 = r12.f40108i
            r0.put(r13, r1)
            return
        L_0x00ca:
            byte[] r0 = r6.f39885a
            com.google.android.gms.internal.measurement.zzff r0 = r12.m(r13, r0)
            com.google.android.gms.internal.measurement.zzkx r0 = r0.zzbB()
            com.google.android.gms.internal.measurement.zzfe r0 = (com.google.android.gms.internal.measurement.zzfe) r0
            r12.n(r13, r0)
            java.util.Map r1 = r12.f40103d
            com.google.android.gms.internal.measurement.zzlb r2 = r0.zzaD()
            com.google.android.gms.internal.measurement.zzff r2 = (com.google.android.gms.internal.measurement.zzff) r2
            java.util.Map r2 = q(r2)
            r1.put(r13, r2)
            java.util.Map r1 = r12.f40107h
            com.google.android.gms.internal.measurement.zzlb r2 = r0.zzaD()
            com.google.android.gms.internal.measurement.zzff r2 = (com.google.android.gms.internal.measurement.zzff) r2
            r1.put(r13, r2)
            com.google.android.gms.internal.measurement.zzlb r1 = r0.zzaD()
            com.google.android.gms.internal.measurement.zzff r1 = (com.google.android.gms.internal.measurement.zzff) r1
            r12.p(r13, r1)
            java.util.Map r1 = r12.f40111l
            java.lang.String r0 = r0.zze()
            r1.put(r13, r0)
            java.util.Map r0 = r12.f40112m
            java.lang.String r1 = r6.f39886b
            r0.put(r13, r1)
            java.util.Map r0 = r12.f40113n
            java.lang.String r1 = r6.f39887c
            r0.put(r13, r1)
            return
        L_0x0114:
            r13 = move-exception
            r1 = r2
        L_0x0116:
            if (r1 == 0) goto L_0x011b
            r1.close()
        L_0x011b:
            throw r13
        L_0x011c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.o4.o(java.lang.String):void");
    }

    private final void p(String str, zzff zzff) {
        if (zzff.zza() != 0) {
            this.f40059a.d().v().b("EES programs found", Integer.valueOf(zzff.zza()));
            zzgt zzgt = (zzgt) zzff.zzo().get(0);
            try {
                zzc zzc = new zzc();
                zzc.zzd("internal.remoteConfig", new j4(this, str));
                zzc.zzd("internal.appMetadata", new j(this, str));
                zzc.zzd("internal.logger", new k4(this));
                zzc.zzc(zzgt);
                this.f40109j.put(str, zzc);
                this.f40059a.d().v().c("EES program loaded for appId, activities", str, Integer.valueOf(zzgt.zza().zza()));
                for (zzgr zzb : zzgt.zza().zzd()) {
                    this.f40059a.d().v().b("EES program activity", zzb.zzb());
                }
            } catch (zzd unused) {
                this.f40059a.d().r().b("Failed to load EES program. appId", str);
            }
        } else {
            this.f40109j.remove(str);
        }
    }

    private static final Map q(zzff zzff) {
        a aVar = new a();
        if (zzff != null) {
            for (zzfj zzfj : zzff.zzp()) {
                aVar.put(zzfj.zzb(), zzfj.zzc());
            }
        }
        return aVar;
    }

    static /* bridge */ /* synthetic */ zzc s(o4 o4Var, String str) {
        o4Var.i();
        com.google.android.gms.common.internal.p.g(str);
        if (!o4Var.C(str)) {
            return null;
        }
        if (!o4Var.f40107h.containsKey(str) || o4Var.f40107h.get(str) == null) {
            o4Var.o(str);
        } else {
            o4Var.p(str, (zzff) o4Var.f40107h.get(str));
        }
        return (zzc) o4Var.f40109j.snapshot().get(str);
    }

    /* access modifiers changed from: package-private */
    public final void A(String str) {
        h();
        this.f40107h.remove(str);
    }

    /* access modifiers changed from: package-private */
    public final boolean B(String str) {
        h();
        zzff t10 = t(str);
        if (t10 == null) {
            return false;
        }
        return t10.zzs();
    }

    public final boolean C(String str) {
        zzff zzff;
        if (TextUtils.isEmpty(str) || (zzff = (zzff) this.f40107h.get(str)) == null || zzff.zza() == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean D(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(e(str, "measurement.upload.blacklist_internal"));
    }

    /* access modifiers changed from: package-private */
    public final boolean E(String str, String str2) {
        Boolean bool;
        h();
        o(str);
        if ("ecommerce_purchase".equals(str2) || "purchase".equals(str2) || "refund".equals(str2)) {
            return true;
        }
        Map map = (Map) this.f40106g.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final boolean F(String str, String str2) {
        Boolean bool;
        h();
        o(str);
        if (D(str) && t9.Y(str2)) {
            return true;
        }
        if (G(str) && t9.Z(str2)) {
            return true;
        }
        Map map = (Map) this.f40105f.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final boolean G(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(e(str, "measurement.upload.blacklist_public"));
    }

    /* access modifiers changed from: protected */
    public final boolean H(String str, byte[] bArr, String str2, String str3) {
        i();
        h();
        com.google.android.gms.common.internal.p.g(str);
        zzfe zzfe = (zzfe) m(str, bArr).zzbB();
        n(str, zzfe);
        p(str, (zzff) zzfe.zzaD());
        this.f40107h.put(str, (zzff) zzfe.zzaD());
        this.f40111l.put(str, zzfe.zze());
        this.f40112m.put(str, str2);
        this.f40113n.put(str, str3);
        this.f40103d.put(str, q((zzff) zzfe.zzaD()));
        this.f39651b.V().n(str, new ArrayList(zzfe.zzf()));
        try {
            zzfe.zzc();
            bArr = ((zzff) zzfe.zzaD()).zzbx();
        } catch (RuntimeException e10) {
            this.f40059a.d().w().c("Unable to serialize reduced-size config. Storing full config instead. appId", q3.z(str), e10);
        }
        k V = this.f39651b.V();
        com.google.android.gms.common.internal.p.g(str);
        V.h();
        V.i();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        contentValues.put("config_last_modified_time", str2);
        contentValues.put("e_tag", str3);
        try {
            if (((long) V.P().update("apps", contentValues, "app_id = ?", new String[]{str})) == 0) {
                V.f40059a.d().r().b("Failed to update remote config (got 0). appId", q3.z(str));
            }
        } catch (SQLiteException e11) {
            V.f40059a.d().r().c("Error storing remote config. appId", q3.z(str), e11);
        }
        this.f40107h.put(str, (zzff) zzfe.zzaD());
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean I(String str) {
        h();
        o(str);
        if (this.f40104e.get(str) == null || !((Set) this.f40104e.get(str)).contains("app_instance_id")) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean J(String str) {
        h();
        o(str);
        if (this.f40104e.get(str) == null || (!((Set) this.f40104e.get(str)).contains("device_model") && !((Set) this.f40104e.get(str)).contains(DeviceRequestsHelper.DEVICE_INFO_PARAM))) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean K(String str) {
        h();
        o(str);
        if (this.f40104e.get(str) == null || !((Set) this.f40104e.get(str)).contains("enhanced_user_id")) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean L(String str) {
        h();
        o(str);
        if (this.f40104e.get(str) == null || !((Set) this.f40104e.get(str)).contains("google_signals")) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean M(String str) {
        h();
        o(str);
        if (this.f40104e.get(str) == null || (!((Set) this.f40104e.get(str)).contains(SoftwareInfoForm.OS_VERSION) && !((Set) this.f40104e.get(str)).contains(DeviceRequestsHelper.DEVICE_INFO_PARAM))) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean N(String str) {
        h();
        o(str);
        if (this.f40104e.get(str) == null || !((Set) this.f40104e.get(str)).contains("user_id")) {
            return false;
        }
        return true;
    }

    public final String e(String str, String str2) {
        h();
        o(str);
        Map map = (Map) this.f40103d.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final boolean l() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final int r(String str, String str2) {
        Integer num;
        h();
        o(str);
        Map map = (Map) this.f40108i.get(str);
        if (map == null || (num = (Integer) map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    /* access modifiers changed from: protected */
    public final zzff t(String str) {
        i();
        h();
        com.google.android.gms.common.internal.p.g(str);
        o(str);
        return (zzff) this.f40107h.get(str);
    }

    /* access modifiers changed from: protected */
    public final String u(String str) {
        h();
        return (String) this.f40113n.get(str);
    }

    /* access modifiers changed from: protected */
    public final String v(String str) {
        h();
        return (String) this.f40112m.get(str);
    }

    /* access modifiers changed from: package-private */
    public final String w(String str) {
        h();
        o(str);
        return (String) this.f40111l.get(str);
    }

    /* access modifiers changed from: package-private */
    public final Set y(String str) {
        h();
        o(str);
        return (Set) this.f40104e.get(str);
    }

    /* access modifiers changed from: protected */
    public final void z(String str) {
        h();
        this.f40112m.put(str, (Object) null);
    }
}
