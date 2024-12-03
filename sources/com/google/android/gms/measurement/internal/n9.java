package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.collection.a;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.measurement.zzcl;
import com.google.android.gms.internal.measurement.zzff;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzfx;
import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzgl;
import com.google.android.gms.internal.measurement.zzgm;
import com.google.android.gms.internal.measurement.zzop;
import com.google.android.gms.internal.measurement.zzpz;
import com.google.android.gms.internal.measurement.zzqu;
import com.google.android.gms.internal.measurement.zzrd;
import com.google.firebase.messaging.Constants;
import com.leanplum.internal.Constants;
import com.mparticle.kits.DataplanFilterImpl;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import me.f;
import oe.d;
import we.o;

public final class n9 implements p5 {
    private static volatile n9 F;
    private final Map A;
    private final Map B;
    private z6 C;
    private String D;
    private final s9 E = new k9(this);

    /* renamed from: a  reason: collision with root package name */
    private final o4 f40065a;

    /* renamed from: b  reason: collision with root package name */
    private final v3 f40066b;

    /* renamed from: c  reason: collision with root package name */
    private k f40067c;

    /* renamed from: d  reason: collision with root package name */
    private y3 f40068d;

    /* renamed from: e  reason: collision with root package name */
    private z8 f40069e;

    /* renamed from: f  reason: collision with root package name */
    private b f40070f;

    /* renamed from: g  reason: collision with root package name */
    private final p9 f40071g;

    /* renamed from: h  reason: collision with root package name */
    private y6 f40072h;

    /* renamed from: i  reason: collision with root package name */
    private j8 f40073i;

    /* renamed from: j  reason: collision with root package name */
    private final d9 f40074j;

    /* renamed from: k  reason: collision with root package name */
    private h4 f40075k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final u4 f40076l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f40077m = false;

    /* renamed from: n  reason: collision with root package name */
    private boolean f40078n;

    /* renamed from: o  reason: collision with root package name */
    long f40079o;

    /* renamed from: p  reason: collision with root package name */
    private List f40080p;

    /* renamed from: q  reason: collision with root package name */
    private int f40081q;

    /* renamed from: r  reason: collision with root package name */
    private int f40082r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f40083s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f40084t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f40085u;

    /* renamed from: v  reason: collision with root package name */
    private FileLock f40086v;

    /* renamed from: w  reason: collision with root package name */
    private FileChannel f40087w;

    /* renamed from: x  reason: collision with root package name */
    private List f40088x;

    /* renamed from: y  reason: collision with root package name */
    private List f40089y;

    /* renamed from: z  reason: collision with root package name */
    private long f40090z;

    n9(o9 o9Var, u4 u4Var) {
        p.k(o9Var);
        this.f40076l = u4.H(o9Var.f40121a, (zzcl) null, (Long) null);
        this.f40090z = -1;
        this.f40074j = new d9(this);
        p9 p9Var = new p9(this);
        p9Var.j();
        this.f40071g = p9Var;
        v3 v3Var = new v3(this);
        v3Var.j();
        this.f40066b = v3Var;
        o4 o4Var = new o4(this);
        o4Var.j();
        this.f40065a = o4Var;
        this.A = new HashMap();
        this.B = new HashMap();
        f().z(new e9(this, o9Var));
    }

    static final void G(zzfs zzfs, int i10, String str) {
        List zzp = zzfs.zzp();
        int i11 = 0;
        while (i11 < zzp.size()) {
            if (!"_err".equals(((zzfx) zzp.get(i11)).zzg())) {
                i11++;
            } else {
                return;
            }
        }
        zzfw zze = zzfx.zze();
        zze.zzj("_err");
        zze.zzi(Long.valueOf((long) i10).longValue());
        zzfw zze2 = zzfx.zze();
        zze2.zzj("_ev");
        zze2.zzk(str);
        zzfs.zzf((zzfx) zze.zzaD());
        zzfs.zzf((zzfx) zze2.zzaD());
    }

    static final void H(zzfs zzfs, @NonNull String str) {
        List zzp = zzfs.zzp();
        for (int i10 = 0; i10 < zzp.size(); i10++) {
            if (str.equals(((zzfx) zzp.get(i10)).zzg())) {
                zzfs.zzh(i10);
                return;
            }
        }
    }

    private final zzq I(String str) {
        String str2 = str;
        k kVar = this.f40067c;
        R(kVar);
        q5 R = kVar.R(str2);
        if (R == null || TextUtils.isEmpty(R.o0())) {
            d().q().b("No app data available; dropping", str2);
            return null;
        }
        Boolean J = J(R);
        if (J == null || J.booleanValue()) {
            q5 q5Var = R;
            q5Var.A();
            return new zzq(str, R.a(), R.o0(), R.R(), R.n0(), R.c0(), R.Z(), (String) null, R.O(), false, R.p0(), 0, 0, 0, q5Var.N(), false, q5Var.j0(), q5Var.i0(), q5Var.a0(), q5Var.e(), (String) null, c0(str).i(), "", (String) null, q5Var.Q(), q5Var.h0());
        }
        d().r().b("App version does not match; dropping. appId", q3.z(str));
        return null;
    }

    private final Boolean J(q5 q5Var) {
        try {
            if (q5Var.R() != -2147483648L) {
                if (q5Var.R() == ((long) d.a(this.f40076l.c()).e(q5Var.l0(), 0).versionCode)) {
                    return Boolean.TRUE;
                }
            } else {
                String str = d.a(this.f40076l.c()).e(q5Var.l0(), 0).versionName;
                String o02 = q5Var.o0();
                if (o02 != null && o02.equals(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final void K() {
        f().h();
        if (this.f40083s || this.f40084t || this.f40085u) {
            d().v().d("Not stopping services. fetch, network, upload", Boolean.valueOf(this.f40083s), Boolean.valueOf(this.f40084t), Boolean.valueOf(this.f40085u));
            return;
        }
        d().v().a("Stopping uploading service(s)");
        List<Runnable> list = this.f40080p;
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
            ((List) p.k(this.f40080p)).clear();
        }
    }

    private final void L(zzgc zzgc, long j10, boolean z10) {
        String str;
        r9 r9Var;
        String str2;
        k kVar = this.f40067c;
        R(kVar);
        if (true != z10) {
            str = "_lte";
        } else {
            str = "_se";
        }
        r9 X = kVar.X(zzgc.zzaq(), str);
        if (X == null || X.f40235e == null) {
            r9Var = new r9(zzgc.zzaq(), "auto", str, a().currentTimeMillis(), Long.valueOf(j10));
        } else {
            r9Var = new r9(zzgc.zzaq(), "auto", str, a().currentTimeMillis(), Long.valueOf(((Long) X.f40235e).longValue() + j10));
        }
        zzgl zzd = zzgm.zzd();
        zzd.zzf(str);
        zzd.zzg(a().currentTimeMillis());
        zzd.zze(((Long) r9Var.f40235e).longValue());
        zzgm zzgm = (zzgm) zzd.zzaD();
        int x10 = p9.x(zzgc, str);
        if (x10 >= 0) {
            zzgc.zzan(x10, zzgm);
        } else {
            zzgc.zzm(zzgm);
        }
        if (j10 > 0) {
            k kVar2 = this.f40067c;
            R(kVar2);
            kVar2.x(r9Var);
            if (true != z10) {
                str2 = "lifetime";
            } else {
                str2 = "session-scoped";
            }
            d().v().c("Updated engagement user property. scope, value", str2, r9Var.f40235e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0238  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void M() {
        /*
            r20 = this;
            r0 = r20
            com.google.android.gms.measurement.internal.s4 r1 = r20.f()
            r1.h()
            r20.g()
            long r1 = r0.f40079o
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x004e
            r1 = 3600000(0x36ee80, double:1.7786363E-317)
            me.f r5 = r20.a()
            long r5 = r5.b()
            long r7 = r0.f40079o
            long r5 = r5 - r7
            long r5 = java.lang.Math.abs(r5)
            long r1 = r1 - r5
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x004c
            com.google.android.gms.measurement.internal.q3 r3 = r20.d()
            com.google.android.gms.measurement.internal.o3 r3 = r3.v()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            java.lang.String r2 = "Upload has been suspended. Will update scheduling later in approximately ms"
            r3.b(r2, r1)
            com.google.android.gms.measurement.internal.y3 r1 = r20.Y()
            r1.c()
            com.google.android.gms.measurement.internal.z8 r1 = r0.f40069e
            R(r1)
            r1.m()
            return
        L_0x004c:
            r0.f40079o = r3
        L_0x004e:
            com.google.android.gms.measurement.internal.u4 r1 = r0.f40076l
            boolean r1 = r1.r()
            if (r1 == 0) goto L_0x0255
            boolean r1 = r20.O()
            if (r1 != 0) goto L_0x005e
            goto L_0x0255
        L_0x005e:
            me.f r1 = r20.a()
            long r1 = r1.currentTimeMillis()
            r20.U()
            com.google.android.gms.measurement.internal.f3 r5 = com.google.android.gms.measurement.internal.g3.C
            r6 = 0
            java.lang.Object r5 = r5.a(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r7 = r5.longValue()
            long r7 = java.lang.Math.max(r3, r7)
            com.google.android.gms.measurement.internal.k r5 = r0.f40067c
            R(r5)
            boolean r5 = r5.t()
            r10 = 1
            if (r5 != 0) goto L_0x0093
            com.google.android.gms.measurement.internal.k r5 = r0.f40067c
            R(r5)
            boolean r5 = r5.s()
            if (r5 == 0) goto L_0x0092
            goto L_0x0093
        L_0x0092:
            r10 = 0
        L_0x0093:
            if (r10 == 0) goto L_0x00d3
            com.google.android.gms.measurement.internal.g r5 = r20.U()
            java.lang.String r5 = r5.u()
            boolean r11 = android.text.TextUtils.isEmpty(r5)
            if (r11 != 0) goto L_0x00bf
            java.lang.String r11 = ".none."
            boolean r5 = r11.equals(r5)
            if (r5 != 0) goto L_0x00bf
            r20.U()
            com.google.android.gms.measurement.internal.f3 r5 = com.google.android.gms.measurement.internal.g3.f39851x
            java.lang.Object r5 = r5.a(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
            goto L_0x00e6
        L_0x00bf:
            r20.U()
            com.google.android.gms.measurement.internal.f3 r5 = com.google.android.gms.measurement.internal.g3.f39849w
            java.lang.Object r5 = r5.a(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
            goto L_0x00e6
        L_0x00d3:
            r20.U()
            com.google.android.gms.measurement.internal.f3 r5 = com.google.android.gms.measurement.internal.g3.f39847v
            java.lang.Object r5 = r5.a(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
        L_0x00e6:
            com.google.android.gms.measurement.internal.j8 r5 = r0.f40073i
            com.google.android.gms.measurement.internal.b4 r5 = r5.f39966g
            long r13 = r5.a()
            com.google.android.gms.measurement.internal.j8 r5 = r0.f40073i
            com.google.android.gms.measurement.internal.b4 r5 = r5.f39967h
            long r15 = r5.a()
            com.google.android.gms.measurement.internal.k r5 = r0.f40067c
            R(r5)
            r17 = r10
            long r9 = r5.M()
            com.google.android.gms.measurement.internal.k r5 = r0.f40067c
            R(r5)
            r18 = r7
            long r6 = r5.N()
            long r5 = java.lang.Math.max(r9, r6)
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 != 0) goto L_0x0117
        L_0x0114:
            r9 = r3
            goto L_0x018f
        L_0x0117:
            long r5 = r5 - r1
            long r5 = java.lang.Math.abs(r5)
            long r5 = r1 - r5
            long r13 = r13 - r1
            long r7 = java.lang.Math.abs(r13)
            long r7 = r1 - r7
            long r15 = r15 - r1
            long r9 = java.lang.Math.abs(r15)
            long r1 = r1 - r9
            long r9 = r5 + r18
            long r7 = java.lang.Math.max(r7, r1)
            if (r17 == 0) goto L_0x013c
            int r13 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r13 <= 0) goto L_0x013c
            long r9 = java.lang.Math.min(r5, r7)
            long r9 = r9 + r11
        L_0x013c:
            com.google.android.gms.measurement.internal.p9 r13 = r0.f40071g
            R(r13)
            boolean r13 = r13.O(r7, r11)
            if (r13 != 0) goto L_0x0149
            long r9 = r7 + r11
        L_0x0149:
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 == 0) goto L_0x018f
            int r5 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r5 < 0) goto L_0x018f
            r5 = 0
        L_0x0152:
            r20.U()
            r6 = 20
            com.google.android.gms.measurement.internal.f3 r7 = com.google.android.gms.measurement.internal.g3.E
            r8 = 0
            java.lang.Object r7 = r7.a(r8)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r11 = 0
            int r7 = java.lang.Math.max(r11, r7)
            int r6 = java.lang.Math.min(r6, r7)
            if (r5 >= r6) goto L_0x0114
            r6 = 1
            long r6 = r6 << r5
            r20.U()
            com.google.android.gms.measurement.internal.f3 r12 = com.google.android.gms.measurement.internal.g3.D
            java.lang.Object r12 = r12.a(r8)
            java.lang.Long r12 = (java.lang.Long) r12
            long r12 = r12.longValue()
            long r12 = java.lang.Math.max(r3, r12)
            long r12 = r12 * r6
            long r9 = r9 + r12
            int r6 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r6 <= 0) goto L_0x018c
            goto L_0x018f
        L_0x018c:
            int r5 = r5 + 1
            goto L_0x0152
        L_0x018f:
            int r1 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x0238
            com.google.android.gms.measurement.internal.v3 r1 = r0.f40066b
            R(r1)
            boolean r1 = r1.m()
            if (r1 == 0) goto L_0x021b
            com.google.android.gms.measurement.internal.j8 r1 = r0.f40073i
            com.google.android.gms.measurement.internal.b4 r1 = r1.f39965f
            long r1 = r1.a()
            r20.U()
            com.google.android.gms.measurement.internal.f3 r5 = com.google.android.gms.measurement.internal.g3.f39843t
            r6 = 0
            java.lang.Object r5 = r5.a(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            long r5 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.p9 r7 = r0.f40071g
            R(r7)
            boolean r7 = r7.O(r1, r5)
            if (r7 != 0) goto L_0x01ca
            long r1 = r1 + r5
            long r9 = java.lang.Math.max(r9, r1)
        L_0x01ca:
            com.google.android.gms.measurement.internal.y3 r1 = r20.Y()
            r1.c()
            me.f r1 = r20.a()
            long r1 = r1.currentTimeMillis()
            long r9 = r9 - r1
            int r1 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x0201
            r20.U()
            com.google.android.gms.measurement.internal.f3 r1 = com.google.android.gms.measurement.internal.g3.f39853y
            r2 = 0
            java.lang.Object r1 = r1.a(r2)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            long r9 = java.lang.Math.max(r3, r1)
            com.google.android.gms.measurement.internal.j8 r1 = r0.f40073i
            com.google.android.gms.measurement.internal.b4 r1 = r1.f39966g
            me.f r2 = r20.a()
            long r2 = r2.currentTimeMillis()
            r1.b(r2)
        L_0x0201:
            com.google.android.gms.measurement.internal.q3 r1 = r20.d()
            com.google.android.gms.measurement.internal.o3 r1 = r1.v()
            java.lang.Long r2 = java.lang.Long.valueOf(r9)
            java.lang.String r3 = "Upload scheduled in approximately ms"
            r1.b(r3, r2)
            com.google.android.gms.measurement.internal.z8 r1 = r0.f40069e
            R(r1)
            r1.n(r9)
            return
        L_0x021b:
            com.google.android.gms.measurement.internal.q3 r1 = r20.d()
            com.google.android.gms.measurement.internal.o3 r1 = r1.v()
            java.lang.String r2 = "No network"
            r1.a(r2)
            com.google.android.gms.measurement.internal.y3 r1 = r20.Y()
            r1.b()
            com.google.android.gms.measurement.internal.z8 r1 = r0.f40069e
            R(r1)
            r1.m()
            return
        L_0x0238:
            com.google.android.gms.measurement.internal.q3 r1 = r20.d()
            com.google.android.gms.measurement.internal.o3 r1 = r1.v()
            java.lang.String r2 = "Next upload time is 0"
            r1.a(r2)
            com.google.android.gms.measurement.internal.y3 r1 = r20.Y()
            r1.c()
            com.google.android.gms.measurement.internal.z8 r1 = r0.f40069e
            R(r1)
            r1.m()
            return
        L_0x0255:
            com.google.android.gms.measurement.internal.q3 r1 = r20.d()
            com.google.android.gms.measurement.internal.o3 r1 = r1.v()
            java.lang.String r2 = "Nothing to upload or uploading impossible"
            r1.a(r2)
            com.google.android.gms.measurement.internal.y3 r1 = r20.Y()
            r1.c()
            com.google.android.gms.measurement.internal.z8 r1 = r0.f40069e
            R(r1)
            r1.m()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.n9.M():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:360:0x0b33, code lost:
        if (r10 > (com.google.android.gms.measurement.internal.g.i() + r8)) goto L_0x0b35;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0383 A[Catch:{ NumberFormatException -> 0x079c, all -> 0x0ccc }] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0447 A[Catch:{ NumberFormatException -> 0x079c, all -> 0x0ccc }] */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0489 A[Catch:{ NumberFormatException -> 0x079c, all -> 0x0ccc }] */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x07d7 A[Catch:{ NumberFormatException -> 0x079c, all -> 0x0ccc }] */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x0820 A[Catch:{ NumberFormatException -> 0x079c, all -> 0x0ccc }] */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x0843 A[Catch:{ NumberFormatException -> 0x079c, all -> 0x0ccc }] */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x08ba A[Catch:{ NumberFormatException -> 0x079c, all -> 0x0ccc }] */
    /* JADX WARNING: Removed duplicated region for block: B:280:0x08bc A[Catch:{ NumberFormatException -> 0x079c, all -> 0x0ccc }] */
    /* JADX WARNING: Removed duplicated region for block: B:283:0x08c4 A[Catch:{ NumberFormatException -> 0x079c, all -> 0x0ccc }] */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x08f0 A[Catch:{ NumberFormatException -> 0x079c, all -> 0x0ccc }] */
    /* JADX WARNING: Removed duplicated region for block: B:359:0x0b23 A[Catch:{ NumberFormatException -> 0x079c, all -> 0x0ccc }] */
    /* JADX WARNING: Removed duplicated region for block: B:368:0x0baa A[Catch:{ NumberFormatException -> 0x079c, all -> 0x0ccc }] */
    /* JADX WARNING: Removed duplicated region for block: B:372:0x0bc6 A[Catch:{ SQLiteException -> 0x0bde }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:55:0x01c0=Splitter:B:55:0x01c0, B:399:0x0cba=Splitter:B:399:0x0cba} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean N(java.lang.String r41, long r42) {
        /*
            r40 = this;
            r1 = r40
            java.lang.String r2 = "_npa"
            java.lang.String r3 = "_ai"
            com.google.android.gms.measurement.internal.k r4 = r1.f40067c
            R(r4)
            r4.e0()
            com.google.android.gms.measurement.internal.l9 r4 = new com.google.android.gms.measurement.internal.l9     // Catch:{ all -> 0x0ccc }
            r12 = 0
            r4.<init>(r1, r12)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.k r5 = r1.f40067c     // Catch:{ all -> 0x0ccc }
            R(r5)     // Catch:{ all -> 0x0ccc }
            r6 = 0
            long r9 = r1.f40090z     // Catch:{ all -> 0x0ccc }
            r7 = r42
            r11 = r4
            r5.G(r6, r7, r9, r11)     // Catch:{ all -> 0x0ccc }
            java.util.List r5 = r4.f40023c     // Catch:{ all -> 0x0ccc }
            if (r5 == 0) goto L_0x0cba
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0ccc }
            if (r5 == 0) goto L_0x002e
            goto L_0x0cba
        L_0x002e:
            com.google.android.gms.internal.measurement.zzgd r5 = r4.f40021a     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzkx r5 = r5.zzbB()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzgc r5 = (com.google.android.gms.internal.measurement.zzgc) r5     // Catch:{ all -> 0x0ccc }
            r5.zzr()     // Catch:{ all -> 0x0ccc }
            r11 = r12
            r14 = r11
            r8 = 0
            r9 = 0
            r10 = 0
            r13 = -1
            r15 = -1
        L_0x0040:
            java.util.List r12 = r4.f40023c     // Catch:{ all -> 0x0ccc }
            int r12 = r12.size()     // Catch:{ all -> 0x0ccc }
            java.lang.String r6 = "_fr"
            java.lang.String r7 = "_et"
            r16 = r10
            java.lang.String r10 = "_e"
            r17 = r13
            r18 = r14
            if (r8 >= r12) goto L_0x04f9
            java.util.List r12 = r4.f40023c     // Catch:{ all -> 0x0ccc }
            java.lang.Object r12 = r12.get(r8)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzft r12 = (com.google.android.gms.internal.measurement.zzft) r12     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzkx r12 = r12.zzbB()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzfs r12 = (com.google.android.gms.internal.measurement.zzfs) r12     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.o4 r14 = r1.f40065a     // Catch:{ all -> 0x0ccc }
            R(r14)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzgd r13 = r4.f40021a     // Catch:{ all -> 0x0ccc }
            java.lang.String r13 = r13.zzy()     // Catch:{ all -> 0x0ccc }
            r19 = r2
            java.lang.String r2 = r12.zzo()     // Catch:{ all -> 0x0ccc }
            boolean r2 = r14.F(r13, r2)     // Catch:{ all -> 0x0ccc }
            java.lang.String r13 = "_err"
            if (r2 == 0) goto L_0x00f7
            com.google.android.gms.measurement.internal.q3 r2 = r40.d()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.o3 r2 = r2.w()     // Catch:{ all -> 0x0ccc }
            java.lang.String r6 = "Dropping blocked raw event. appId"
            com.google.android.gms.internal.measurement.zzgd r7 = r4.f40021a     // Catch:{ all -> 0x0ccc }
            java.lang.String r7 = r7.zzy()     // Catch:{ all -> 0x0ccc }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.q3.z(r7)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.u4 r10 = r1.f40076l     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.l3 r10 = r10.D()     // Catch:{ all -> 0x0ccc }
            java.lang.String r14 = r12.zzo()     // Catch:{ all -> 0x0ccc }
            java.lang.String r10 = r10.d(r14)     // Catch:{ all -> 0x0ccc }
            r2.c(r6, r7, r10)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.o4 r2 = r1.f40065a     // Catch:{ all -> 0x0ccc }
            R(r2)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzgd r6 = r4.f40021a     // Catch:{ all -> 0x0ccc }
            java.lang.String r6 = r6.zzy()     // Catch:{ all -> 0x0ccc }
            boolean r2 = r2.D(r6)     // Catch:{ all -> 0x0ccc }
            if (r2 != 0) goto L_0x00e8
            com.google.android.gms.measurement.internal.o4 r2 = r1.f40065a     // Catch:{ all -> 0x0ccc }
            R(r2)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzgd r6 = r4.f40021a     // Catch:{ all -> 0x0ccc }
            java.lang.String r6 = r6.zzy()     // Catch:{ all -> 0x0ccc }
            boolean r2 = r2.G(r6)     // Catch:{ all -> 0x0ccc }
            if (r2 == 0) goto L_0x00c3
            goto L_0x00e8
        L_0x00c3:
            java.lang.String r2 = r12.zzo()     // Catch:{ all -> 0x0ccc }
            boolean r2 = r13.equals(r2)     // Catch:{ all -> 0x0ccc }
            if (r2 != 0) goto L_0x00e8
            com.google.android.gms.measurement.internal.t9 r20 = r40.h0()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.s9 r2 = r1.E     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzgd r6 = r4.f40021a     // Catch:{ all -> 0x0ccc }
            java.lang.String r22 = r6.zzy()     // Catch:{ all -> 0x0ccc }
            r23 = 11
            java.lang.String r24 = "_ev"
            java.lang.String r25 = r12.zzo()     // Catch:{ all -> 0x0ccc }
            r26 = 0
            r21 = r2
            r20.C(r21, r22, r23, r24, r25, r26)     // Catch:{ all -> 0x0ccc }
        L_0x00e8:
            r21 = r3
            r6 = r8
            r23 = r11
            r10 = r16
            r13 = r17
            r14 = r18
            r11 = r5
            r5 = -1
            goto L_0x04ee
        L_0x00f7:
            java.lang.String r2 = r12.zzo()     // Catch:{ all -> 0x0ccc }
            java.lang.String r14 = we.p.a(r3)     // Catch:{ all -> 0x0ccc }
            boolean r2 = r2.equals(r14)     // Catch:{ all -> 0x0ccc }
            if (r2 == 0) goto L_0x016d
            r12.zzi(r3)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.q3 r2 = r40.d()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.o3 r2 = r2.v()     // Catch:{ all -> 0x0ccc }
            java.lang.String r14 = "Renaming ad_impression to _ai"
            r2.a(r14)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.q3 r2 = r40.d()     // Catch:{ all -> 0x0ccc }
            java.lang.String r2 = r2.D()     // Catch:{ all -> 0x0ccc }
            r14 = 5
            boolean r2 = android.util.Log.isLoggable(r2, r14)     // Catch:{ all -> 0x0ccc }
            if (r2 == 0) goto L_0x016d
            r2 = 0
        L_0x0125:
            int r14 = r12.zza()     // Catch:{ all -> 0x0ccc }
            if (r2 >= r14) goto L_0x016d
            java.lang.String r14 = "ad_platform"
            com.google.android.gms.internal.measurement.zzfx r20 = r12.zzn(r2)     // Catch:{ all -> 0x0ccc }
            r21 = r3
            java.lang.String r3 = r20.zzg()     // Catch:{ all -> 0x0ccc }
            boolean r3 = r14.equals(r3)     // Catch:{ all -> 0x0ccc }
            if (r3 == 0) goto L_0x0168
            com.google.android.gms.internal.measurement.zzfx r3 = r12.zzn(r2)     // Catch:{ all -> 0x0ccc }
            java.lang.String r3 = r3.zzh()     // Catch:{ all -> 0x0ccc }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0ccc }
            if (r3 != 0) goto L_0x0168
            java.lang.String r3 = "admob"
            com.google.android.gms.internal.measurement.zzfx r14 = r12.zzn(r2)     // Catch:{ all -> 0x0ccc }
            java.lang.String r14 = r14.zzh()     // Catch:{ all -> 0x0ccc }
            boolean r3 = r3.equalsIgnoreCase(r14)     // Catch:{ all -> 0x0ccc }
            if (r3 == 0) goto L_0x0168
            com.google.android.gms.measurement.internal.q3 r3 = r40.d()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.o3 r3 = r3.x()     // Catch:{ all -> 0x0ccc }
            java.lang.String r14 = "AdMob ad impression logged from app. Potentially duplicative."
            r3.a(r14)     // Catch:{ all -> 0x0ccc }
        L_0x0168:
            int r2 = r2 + 1
            r3 = r21
            goto L_0x0125
        L_0x016d:
            r21 = r3
            com.google.android.gms.measurement.internal.o4 r2 = r1.f40065a     // Catch:{ all -> 0x0ccc }
            R(r2)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzgd r3 = r4.f40021a     // Catch:{ all -> 0x0ccc }
            java.lang.String r3 = r3.zzy()     // Catch:{ all -> 0x0ccc }
            java.lang.String r14 = r12.zzo()     // Catch:{ all -> 0x0ccc }
            boolean r2 = r2.E(r3, r14)     // Catch:{ all -> 0x0ccc }
            java.lang.String r3 = "_c"
            if (r2 != 0) goto L_0x01b7
            com.google.android.gms.measurement.internal.p9 r14 = r1.f40071g     // Catch:{ all -> 0x0ccc }
            R(r14)     // Catch:{ all -> 0x0ccc }
            java.lang.String r14 = r12.zzo()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.common.internal.p.g(r14)     // Catch:{ all -> 0x0ccc }
            r20 = r9
            int r9 = r14.hashCode()     // Catch:{ all -> 0x0ccc }
            r22 = r8
            r8 = 95027(0x17333, float:1.33161E-40)
            if (r9 == r8) goto L_0x01a0
            goto L_0x01aa
        L_0x01a0:
            java.lang.String r8 = "_ui"
            boolean r8 = r14.equals(r8)
            if (r8 == 0) goto L_0x01aa
            r8 = 0
            goto L_0x01ab
        L_0x01aa:
            r8 = -1
        L_0x01ab:
            if (r8 == 0) goto L_0x01bb
            r25 = r6
            r24 = r7
            r23 = r11
            r2 = 0
            r11 = r5
            goto L_0x0381
        L_0x01b7:
            r22 = r8
            r20 = r9
        L_0x01bb:
            r23 = r11
            r8 = 0
            r9 = 0
            r14 = 0
        L_0x01c0:
            int r11 = r12.zza()     // Catch:{ all -> 0x0ccc }
            r24 = r7
            java.lang.String r7 = "_r"
            if (r8 >= r11) goto L_0x0227
            com.google.android.gms.internal.measurement.zzfx r11 = r12.zzn(r8)     // Catch:{ all -> 0x0ccc }
            java.lang.String r11 = r11.zzg()     // Catch:{ all -> 0x0ccc }
            boolean r11 = r3.equals(r11)     // Catch:{ all -> 0x0ccc }
            if (r11 == 0) goto L_0x01f5
            com.google.android.gms.internal.measurement.zzfx r7 = r12.zzn(r8)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzkx r7 = r7.zzbB()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzfw r7 = (com.google.android.gms.internal.measurement.zzfw) r7     // Catch:{ all -> 0x0ccc }
            r11 = r5
            r25 = r6
            r5 = 1
            r7.zzi(r5)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzlb r5 = r7.zzaD()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzfx r5 = (com.google.android.gms.internal.measurement.zzfx) r5     // Catch:{ all -> 0x0ccc }
            r12.zzk(r8, r5)     // Catch:{ all -> 0x0ccc }
            r9 = 1
            goto L_0x021f
        L_0x01f5:
            r11 = r5
            r25 = r6
            com.google.android.gms.internal.measurement.zzfx r5 = r12.zzn(r8)     // Catch:{ all -> 0x0ccc }
            java.lang.String r5 = r5.zzg()     // Catch:{ all -> 0x0ccc }
            boolean r5 = r7.equals(r5)     // Catch:{ all -> 0x0ccc }
            if (r5 == 0) goto L_0x021f
            com.google.android.gms.internal.measurement.zzfx r5 = r12.zzn(r8)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzkx r5 = r5.zzbB()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzfw r5 = (com.google.android.gms.internal.measurement.zzfw) r5     // Catch:{ all -> 0x0ccc }
            r6 = 1
            r5.zzi(r6)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzlb r5 = r5.zzaD()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzfx r5 = (com.google.android.gms.internal.measurement.zzfx) r5     // Catch:{ all -> 0x0ccc }
            r12.zzk(r8, r5)     // Catch:{ all -> 0x0ccc }
            r14 = 1
        L_0x021f:
            int r8 = r8 + 1
            r5 = r11
            r7 = r24
            r6 = r25
            goto L_0x01c0
        L_0x0227:
            r11 = r5
            r25 = r6
            if (r9 != 0) goto L_0x0258
            if (r2 == 0) goto L_0x0258
            com.google.android.gms.measurement.internal.q3 r5 = r40.d()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.o3 r5 = r5.v()     // Catch:{ all -> 0x0ccc }
            java.lang.String r6 = "Marking event as conversion"
            com.google.android.gms.measurement.internal.u4 r8 = r1.f40076l     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.l3 r8 = r8.D()     // Catch:{ all -> 0x0ccc }
            java.lang.String r9 = r12.zzo()     // Catch:{ all -> 0x0ccc }
            java.lang.String r8 = r8.d(r9)     // Catch:{ all -> 0x0ccc }
            r5.b(r6, r8)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzfw r5 = com.google.android.gms.internal.measurement.zzfx.zze()     // Catch:{ all -> 0x0ccc }
            r5.zzj(r3)     // Catch:{ all -> 0x0ccc }
            r8 = 1
            r5.zzi(r8)     // Catch:{ all -> 0x0ccc }
            r12.zze(r5)     // Catch:{ all -> 0x0ccc }
        L_0x0258:
            if (r14 != 0) goto L_0x0284
            com.google.android.gms.measurement.internal.q3 r5 = r40.d()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.o3 r5 = r5.v()     // Catch:{ all -> 0x0ccc }
            java.lang.String r6 = "Marking event as real-time"
            com.google.android.gms.measurement.internal.u4 r8 = r1.f40076l     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.l3 r8 = r8.D()     // Catch:{ all -> 0x0ccc }
            java.lang.String r9 = r12.zzo()     // Catch:{ all -> 0x0ccc }
            java.lang.String r8 = r8.d(r9)     // Catch:{ all -> 0x0ccc }
            r5.b(r6, r8)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzfw r5 = com.google.android.gms.internal.measurement.zzfx.zze()     // Catch:{ all -> 0x0ccc }
            r5.zzj(r7)     // Catch:{ all -> 0x0ccc }
            r8 = 1
            r5.zzi(r8)     // Catch:{ all -> 0x0ccc }
            r12.zze(r5)     // Catch:{ all -> 0x0ccc }
        L_0x0284:
            com.google.android.gms.measurement.internal.k r5 = r1.f40067c     // Catch:{ all -> 0x0ccc }
            R(r5)     // Catch:{ all -> 0x0ccc }
            long r27 = r40.F()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzgd r6 = r4.f40021a     // Catch:{ all -> 0x0ccc }
            java.lang.String r29 = r6.zzy()     // Catch:{ all -> 0x0ccc }
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 1
            r26 = r5
            com.google.android.gms.measurement.internal.i r5 = r26.T(r27, r29, r30, r31, r32, r33, r34)     // Catch:{ all -> 0x0ccc }
            long r5 = r5.f39912e     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.g r8 = r40.U()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzgd r9 = r4.f40021a     // Catch:{ all -> 0x0ccc }
            java.lang.String r9 = r9.zzy()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.f3 r14 = com.google.android.gms.measurement.internal.g3.f39837q     // Catch:{ all -> 0x0ccc }
            int r8 = r8.o(r9, r14)     // Catch:{ all -> 0x0ccc }
            long r8 = (long) r8     // Catch:{ all -> 0x0ccc }
            int r5 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r5 <= 0) goto L_0x02be
            H(r12, r7)     // Catch:{ all -> 0x0ccc }
            goto L_0x02c0
        L_0x02be:
            r16 = 1
        L_0x02c0:
            java.lang.String r5 = r12.zzo()     // Catch:{ all -> 0x0ccc }
            boolean r5 = com.google.android.gms.measurement.internal.t9.Z(r5)     // Catch:{ all -> 0x0ccc }
            if (r5 == 0) goto L_0x0381
            if (r2 == 0) goto L_0x0381
            com.google.android.gms.measurement.internal.k r5 = r1.f40067c     // Catch:{ all -> 0x0ccc }
            R(r5)     // Catch:{ all -> 0x0ccc }
            long r27 = r40.F()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzgd r6 = r4.f40021a     // Catch:{ all -> 0x0ccc }
            java.lang.String r29 = r6.zzy()     // Catch:{ all -> 0x0ccc }
            r30 = 0
            r31 = 0
            r32 = 1
            r33 = 0
            r34 = 0
            r26 = r5
            com.google.android.gms.measurement.internal.i r5 = r26.T(r27, r29, r30, r31, r32, r33, r34)     // Catch:{ all -> 0x0ccc }
            long r5 = r5.f39910c     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.g r7 = r40.U()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzgd r8 = r4.f40021a     // Catch:{ all -> 0x0ccc }
            java.lang.String r8 = r8.zzy()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.f3 r9 = com.google.android.gms.measurement.internal.g3.f39835p     // Catch:{ all -> 0x0ccc }
            int r7 = r7.o(r8, r9)     // Catch:{ all -> 0x0ccc }
            long r7 = (long) r7     // Catch:{ all -> 0x0ccc }
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x0381
            com.google.android.gms.measurement.internal.q3 r5 = r40.d()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.o3 r5 = r5.w()     // Catch:{ all -> 0x0ccc }
            java.lang.String r6 = "Too many conversions. Not logging as conversion. appId"
            com.google.android.gms.internal.measurement.zzgd r7 = r4.f40021a     // Catch:{ all -> 0x0ccc }
            java.lang.String r7 = r7.zzy()     // Catch:{ all -> 0x0ccc }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.q3.z(r7)     // Catch:{ all -> 0x0ccc }
            r5.b(r6, r7)     // Catch:{ all -> 0x0ccc }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = -1
        L_0x031d:
            int r9 = r12.zza()     // Catch:{ all -> 0x0ccc }
            if (r6 >= r9) goto L_0x0347
            com.google.android.gms.internal.measurement.zzfx r9 = r12.zzn(r6)     // Catch:{ all -> 0x0ccc }
            java.lang.String r14 = r9.zzg()     // Catch:{ all -> 0x0ccc }
            boolean r14 = r3.equals(r14)     // Catch:{ all -> 0x0ccc }
            if (r14 == 0) goto L_0x0339
            com.google.android.gms.internal.measurement.zzkx r5 = r9.zzbB()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzfw r5 = (com.google.android.gms.internal.measurement.zzfw) r5     // Catch:{ all -> 0x0ccc }
            r8 = r6
            goto L_0x0344
        L_0x0339:
            java.lang.String r9 = r9.zzg()     // Catch:{ all -> 0x0ccc }
            boolean r9 = r13.equals(r9)     // Catch:{ all -> 0x0ccc }
            if (r9 == 0) goto L_0x0344
            r7 = 1
        L_0x0344:
            int r6 = r6 + 1
            goto L_0x031d
        L_0x0347:
            if (r7 == 0) goto L_0x0350
            if (r5 == 0) goto L_0x034f
            r12.zzh(r8)     // Catch:{ all -> 0x0ccc }
            goto L_0x0381
        L_0x034f:
            r5 = 0
        L_0x0350:
            if (r5 == 0) goto L_0x036a
            com.google.android.gms.internal.measurement.zzkx r5 = r5.zzav()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzfw r5 = (com.google.android.gms.internal.measurement.zzfw) r5     // Catch:{ all -> 0x0ccc }
            r5.zzj(r13)     // Catch:{ all -> 0x0ccc }
            r6 = 10
            r5.zzi(r6)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzlb r5 = r5.zzaD()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzfx r5 = (com.google.android.gms.internal.measurement.zzfx) r5     // Catch:{ all -> 0x0ccc }
            r12.zzk(r8, r5)     // Catch:{ all -> 0x0ccc }
            goto L_0x0381
        L_0x036a:
            com.google.android.gms.measurement.internal.q3 r5 = r40.d()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.o3 r5 = r5.r()     // Catch:{ all -> 0x0ccc }
            java.lang.String r6 = "Did not find conversion parameter. appId"
            com.google.android.gms.internal.measurement.zzgd r7 = r4.f40021a     // Catch:{ all -> 0x0ccc }
            java.lang.String r7 = r7.zzy()     // Catch:{ all -> 0x0ccc }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.q3.z(r7)     // Catch:{ all -> 0x0ccc }
            r5.b(r6, r7)     // Catch:{ all -> 0x0ccc }
        L_0x0381:
            if (r2 == 0) goto L_0x043a
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0ccc }
            java.util.List r5 = r12.zzp()     // Catch:{ all -> 0x0ccc }
            r2.<init>(r5)     // Catch:{ all -> 0x0ccc }
            r5 = 0
            r6 = -1
            r7 = -1
        L_0x038f:
            int r8 = r2.size()     // Catch:{ all -> 0x0ccc }
            java.lang.String r9 = "currency"
            java.lang.String r13 = "value"
            if (r5 >= r8) goto L_0x03bf
            java.lang.Object r8 = r2.get(r5)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzfx r8 = (com.google.android.gms.internal.measurement.zzfx) r8     // Catch:{ all -> 0x0ccc }
            java.lang.String r8 = r8.zzg()     // Catch:{ all -> 0x0ccc }
            boolean r8 = r13.equals(r8)     // Catch:{ all -> 0x0ccc }
            if (r8 == 0) goto L_0x03ab
            r6 = r5
            goto L_0x03bc
        L_0x03ab:
            java.lang.Object r8 = r2.get(r5)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzfx r8 = (com.google.android.gms.internal.measurement.zzfx) r8     // Catch:{ all -> 0x0ccc }
            java.lang.String r8 = r8.zzg()     // Catch:{ all -> 0x0ccc }
            boolean r8 = r9.equals(r8)     // Catch:{ all -> 0x0ccc }
            if (r8 == 0) goto L_0x03bc
            r7 = r5
        L_0x03bc:
            int r5 = r5 + 1
            goto L_0x038f
        L_0x03bf:
            r5 = -1
            if (r6 != r5) goto L_0x03c4
            goto L_0x043b
        L_0x03c4:
            java.lang.Object r5 = r2.get(r6)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzfx r5 = (com.google.android.gms.internal.measurement.zzfx) r5     // Catch:{ all -> 0x0ccc }
            boolean r5 = r5.zzw()     // Catch:{ all -> 0x0ccc }
            if (r5 != 0) goto L_0x03f5
            java.lang.Object r5 = r2.get(r6)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzfx r5 = (com.google.android.gms.internal.measurement.zzfx) r5     // Catch:{ all -> 0x0ccc }
            boolean r5 = r5.zzu()     // Catch:{ all -> 0x0ccc }
            if (r5 != 0) goto L_0x03f5
            com.google.android.gms.measurement.internal.q3 r2 = r40.d()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.o3 r2 = r2.x()     // Catch:{ all -> 0x0ccc }
            java.lang.String r5 = "Value must be specified with a numeric type."
            r2.a(r5)     // Catch:{ all -> 0x0ccc }
            r12.zzh(r6)     // Catch:{ all -> 0x0ccc }
            H(r12, r3)     // Catch:{ all -> 0x0ccc }
            r2 = 18
            G(r12, r2, r13)     // Catch:{ all -> 0x0ccc }
            goto L_0x043a
        L_0x03f5:
            r5 = -1
            if (r7 != r5) goto L_0x03f9
            goto L_0x0421
        L_0x03f9:
            java.lang.Object r2 = r2.get(r7)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzfx r2 = (com.google.android.gms.internal.measurement.zzfx) r2     // Catch:{ all -> 0x0ccc }
            java.lang.String r2 = r2.zzh()     // Catch:{ all -> 0x0ccc }
            int r7 = r2.length()     // Catch:{ all -> 0x0ccc }
            r8 = 3
            if (r7 != r8) goto L_0x0421
            r7 = 0
        L_0x040b:
            int r8 = r2.length()     // Catch:{ all -> 0x0ccc }
            if (r7 >= r8) goto L_0x043b
            int r8 = r2.codePointAt(r7)     // Catch:{ all -> 0x0ccc }
            boolean r13 = java.lang.Character.isLetter(r8)     // Catch:{ all -> 0x0ccc }
            if (r13 == 0) goto L_0x0421
            int r8 = java.lang.Character.charCount(r8)     // Catch:{ all -> 0x0ccc }
            int r7 = r7 + r8
            goto L_0x040b
        L_0x0421:
            com.google.android.gms.measurement.internal.q3 r2 = r40.d()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.o3 r2 = r2.x()     // Catch:{ all -> 0x0ccc }
            java.lang.String r7 = "Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter."
            r2.a(r7)     // Catch:{ all -> 0x0ccc }
            r12.zzh(r6)     // Catch:{ all -> 0x0ccc }
            H(r12, r3)     // Catch:{ all -> 0x0ccc }
            r2 = 19
            G(r12, r2, r9)     // Catch:{ all -> 0x0ccc }
            goto L_0x043b
        L_0x043a:
            r5 = -1
        L_0x043b:
            java.lang.String r2 = r12.zzo()     // Catch:{ all -> 0x0ccc }
            boolean r2 = r10.equals(r2)     // Catch:{ all -> 0x0ccc }
            r6 = 1000(0x3e8, double:4.94E-321)
            if (r2 == 0) goto L_0x0489
            com.google.android.gms.measurement.internal.p9 r2 = r1.f40071g     // Catch:{ all -> 0x0ccc }
            R(r2)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzlb r2 = r12.zzaD()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzft r2 = (com.google.android.gms.internal.measurement.zzft) r2     // Catch:{ all -> 0x0ccc }
            r3 = r25
            com.google.android.gms.internal.measurement.zzfx r2 = com.google.android.gms.measurement.internal.p9.o(r2, r3)     // Catch:{ all -> 0x0ccc }
            if (r2 != 0) goto L_0x04d5
            if (r18 == 0) goto L_0x0482
            long r2 = r18.zzc()     // Catch:{ all -> 0x0ccc }
            long r8 = r12.zzc()     // Catch:{ all -> 0x0ccc }
            long r2 = r2 - r8
            long r2 = java.lang.Math.abs(r2)     // Catch:{ all -> 0x0ccc }
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 > 0) goto L_0x0482
            com.google.android.gms.internal.measurement.zzkx r2 = r18.zzav()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzfs r2 = (com.google.android.gms.internal.measurement.zzfs) r2     // Catch:{ all -> 0x0ccc }
            boolean r3 = r1.P(r12, r2)     // Catch:{ all -> 0x0ccc }
            if (r3 == 0) goto L_0x0482
            r11.zzS(r15, r2)     // Catch:{ all -> 0x0ccc }
            r13 = r17
        L_0x047e:
            r14 = 0
            r23 = 0
            goto L_0x04da
        L_0x0482:
            r23 = r12
            r14 = r18
            r13 = r20
            goto L_0x04da
        L_0x0489:
            java.lang.String r2 = "_vs"
            java.lang.String r3 = r12.zzo()     // Catch:{ all -> 0x0ccc }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0ccc }
            if (r2 == 0) goto L_0x04d5
            com.google.android.gms.measurement.internal.p9 r2 = r1.f40071g     // Catch:{ all -> 0x0ccc }
            R(r2)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzlb r2 = r12.zzaD()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzft r2 = (com.google.android.gms.internal.measurement.zzft) r2     // Catch:{ all -> 0x0ccc }
            r8 = r24
            com.google.android.gms.internal.measurement.zzfx r2 = com.google.android.gms.measurement.internal.p9.o(r2, r8)     // Catch:{ all -> 0x0ccc }
            if (r2 != 0) goto L_0x04d5
            if (r23 == 0) goto L_0x04ce
            long r2 = r23.zzc()     // Catch:{ all -> 0x0ccc }
            long r8 = r12.zzc()     // Catch:{ all -> 0x0ccc }
            long r2 = r2 - r8
            long r2 = java.lang.Math.abs(r2)     // Catch:{ all -> 0x0ccc }
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 > 0) goto L_0x04ce
            com.google.android.gms.internal.measurement.zzkx r2 = r23.zzav()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzfs r2 = (com.google.android.gms.internal.measurement.zzfs) r2     // Catch:{ all -> 0x0ccc }
            boolean r3 = r1.P(r2, r12)     // Catch:{ all -> 0x0ccc }
            if (r3 == 0) goto L_0x04ce
            r7 = r17
            r11.zzS(r7, r2)     // Catch:{ all -> 0x0ccc }
            r13 = r7
            goto L_0x047e
        L_0x04ce:
            r7 = r17
            r13 = r7
            r14 = r12
            r15 = r20
            goto L_0x04da
        L_0x04d5:
            r7 = r17
            r13 = r7
            r14 = r18
        L_0x04da:
            java.util.List r2 = r4.f40023c     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzlb r3 = r12.zzaD()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzft r3 = (com.google.android.gms.internal.measurement.zzft) r3     // Catch:{ all -> 0x0ccc }
            r6 = r22
            r2.set(r6, r3)     // Catch:{ all -> 0x0ccc }
            int r9 = r20 + 1
            r11.zzk(r12)     // Catch:{ all -> 0x0ccc }
            r10 = r16
        L_0x04ee:
            int r8 = r6 + 1
            r5 = r11
            r2 = r19
            r3 = r21
            r11 = r23
            goto L_0x0040
        L_0x04f9:
            r19 = r2
            r11 = r5
            r3 = r6
            r8 = r7
            r20 = r9
            r5 = 0
            r12 = r5
            r2 = 0
        L_0x0504:
            if (r2 >= r9) goto L_0x0554
            com.google.android.gms.internal.measurement.zzft r7 = r11.zze(r2)     // Catch:{ all -> 0x0ccc }
            java.lang.String r14 = r7.zzh()     // Catch:{ all -> 0x0ccc }
            boolean r14 = r10.equals(r14)     // Catch:{ all -> 0x0ccc }
            if (r14 == 0) goto L_0x0527
            com.google.android.gms.measurement.internal.p9 r14 = r1.f40071g     // Catch:{ all -> 0x0ccc }
            R(r14)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzfx r14 = com.google.android.gms.measurement.internal.p9.o(r7, r3)     // Catch:{ all -> 0x0ccc }
            if (r14 == 0) goto L_0x0527
            r11.zzA(r2)     // Catch:{ all -> 0x0ccc }
            int r9 = r9 + -1
            int r2 = r2 + -1
            goto L_0x0551
        L_0x0527:
            com.google.android.gms.measurement.internal.p9 r14 = r1.f40071g     // Catch:{ all -> 0x0ccc }
            R(r14)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzfx r7 = com.google.android.gms.measurement.internal.p9.o(r7, r8)     // Catch:{ all -> 0x0ccc }
            if (r7 == 0) goto L_0x0551
            boolean r14 = r7.zzw()     // Catch:{ all -> 0x0ccc }
            if (r14 == 0) goto L_0x0541
            long r14 = r7.zzd()     // Catch:{ all -> 0x0ccc }
            java.lang.Long r7 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x0ccc }
            goto L_0x0542
        L_0x0541:
            r7 = 0
        L_0x0542:
            if (r7 == 0) goto L_0x0551
            long r14 = r7.longValue()     // Catch:{ all -> 0x0ccc }
            int r14 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r14 <= 0) goto L_0x0551
            long r14 = r7.longValue()     // Catch:{ all -> 0x0ccc }
            long r12 = r12 + r14
        L_0x0551:
            r7 = 1
            int r2 = r2 + r7
            goto L_0x0504
        L_0x0554:
            r2 = 0
            r1.L(r11, r12, r2)     // Catch:{ all -> 0x0ccc }
            java.util.List r2 = r11.zzat()     // Catch:{ all -> 0x0ccc }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0ccc }
        L_0x0560:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0ccc }
            java.lang.String r7 = "_se"
            if (r3 == 0) goto L_0x0586
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzft r3 = (com.google.android.gms.internal.measurement.zzft) r3     // Catch:{ all -> 0x0ccc }
            java.lang.String r8 = "_s"
            java.lang.String r3 = r3.zzh()     // Catch:{ all -> 0x0ccc }
            boolean r3 = r8.equals(r3)     // Catch:{ all -> 0x0ccc }
            if (r3 == 0) goto L_0x0560
            com.google.android.gms.measurement.internal.k r2 = r1.f40067c     // Catch:{ all -> 0x0ccc }
            R(r2)     // Catch:{ all -> 0x0ccc }
            java.lang.String r3 = r11.zzaq()     // Catch:{ all -> 0x0ccc }
            r2.m(r3, r7)     // Catch:{ all -> 0x0ccc }
        L_0x0586:
            java.lang.String r2 = "_sid"
            int r2 = com.google.android.gms.measurement.internal.p9.x(r11, r2)     // Catch:{ all -> 0x0ccc }
            if (r2 < 0) goto L_0x0593
            r2 = 1
            r1.L(r11, r12, r2)     // Catch:{ all -> 0x0ccc }
            goto L_0x05b3
        L_0x0593:
            int r2 = com.google.android.gms.measurement.internal.p9.x(r11, r7)     // Catch:{ all -> 0x0ccc }
            if (r2 < 0) goto L_0x05b3
            r11.zzB(r2)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.q3 r2 = r40.d()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.o3 r2 = r2.r()     // Catch:{ all -> 0x0ccc }
            java.lang.String r3 = "Session engagement user property is in the bundle without session ID. appId"
            com.google.android.gms.internal.measurement.zzgd r7 = r4.f40021a     // Catch:{ all -> 0x0ccc }
            java.lang.String r7 = r7.zzy()     // Catch:{ all -> 0x0ccc }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.q3.z(r7)     // Catch:{ all -> 0x0ccc }
            r2.b(r3, r7)     // Catch:{ all -> 0x0ccc }
        L_0x05b3:
            com.google.android.gms.measurement.internal.p9 r2 = r1.f40071g     // Catch:{ all -> 0x0ccc }
            R(r2)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.u4 r3 = r2.f40059a     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.q3 r3 = r3.d()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.o3 r3 = r3.v()     // Catch:{ all -> 0x0ccc }
            java.lang.String r7 = "Checking account type status for ad personalization signals"
            r3.a(r7)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.n9 r3 = r2.f39651b     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.o4 r3 = r3.f40065a     // Catch:{ all -> 0x0ccc }
            R(r3)     // Catch:{ all -> 0x0ccc }
            java.lang.String r7 = r11.zzaq()     // Catch:{ all -> 0x0ccc }
            boolean r3 = r3.B(r7)     // Catch:{ all -> 0x0ccc }
            if (r3 == 0) goto L_0x064a
            com.google.android.gms.measurement.internal.n9 r3 = r2.f39651b     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.k r3 = r3.f40067c     // Catch:{ all -> 0x0ccc }
            R(r3)     // Catch:{ all -> 0x0ccc }
            java.lang.String r7 = r11.zzaq()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.q5 r3 = r3.R(r7)     // Catch:{ all -> 0x0ccc }
            if (r3 == 0) goto L_0x064a
            boolean r3 = r3.N()     // Catch:{ all -> 0x0ccc }
            if (r3 == 0) goto L_0x064a
            com.google.android.gms.measurement.internal.u4 r3 = r2.f40059a     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.o r3 = r3.A()     // Catch:{ all -> 0x0ccc }
            boolean r3 = r3.s()     // Catch:{ all -> 0x0ccc }
            if (r3 == 0) goto L_0x064a
            com.google.android.gms.measurement.internal.u4 r3 = r2.f40059a     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.q3 r3 = r3.d()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.o3 r3 = r3.q()     // Catch:{ all -> 0x0ccc }
            java.lang.String r7 = "Turning off ad personalization due to account type"
            r3.a(r7)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzgl r3 = com.google.android.gms.internal.measurement.zzgm.zzd()     // Catch:{ all -> 0x0ccc }
            r7 = r19
            r3.zzf(r7)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.u4 r2 = r2.f40059a     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.o r2 = r2.A()     // Catch:{ all -> 0x0ccc }
            long r8 = r2.o()     // Catch:{ all -> 0x0ccc }
            r3.zzg(r8)     // Catch:{ all -> 0x0ccc }
            r8 = 1
            r3.zze(r8)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzlb r2 = r3.zzaD()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzgm r2 = (com.google.android.gms.internal.measurement.zzgm) r2     // Catch:{ all -> 0x0ccc }
            r3 = 0
        L_0x062c:
            int r8 = r11.zzb()     // Catch:{ all -> 0x0ccc }
            if (r3 >= r8) goto L_0x0647
            com.google.android.gms.internal.measurement.zzgm r8 = r11.zzap(r3)     // Catch:{ all -> 0x0ccc }
            java.lang.String r8 = r8.zzf()     // Catch:{ all -> 0x0ccc }
            boolean r8 = r7.equals(r8)     // Catch:{ all -> 0x0ccc }
            if (r8 == 0) goto L_0x0644
            r11.zzan(r3, r2)     // Catch:{ all -> 0x0ccc }
            goto L_0x064a
        L_0x0644:
            int r3 = r3 + 1
            goto L_0x062c
        L_0x0647:
            r11.zzm(r2)     // Catch:{ all -> 0x0ccc }
        L_0x064a:
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r11.zzai(r2)     // Catch:{ all -> 0x0ccc }
            r2 = -9223372036854775808
            r11.zzQ(r2)     // Catch:{ all -> 0x0ccc }
            r2 = 0
        L_0x0658:
            int r3 = r11.zza()     // Catch:{ all -> 0x0ccc }
            if (r2 >= r3) goto L_0x068b
            com.google.android.gms.internal.measurement.zzft r3 = r11.zze(r2)     // Catch:{ all -> 0x0ccc }
            long r7 = r3.zzd()     // Catch:{ all -> 0x0ccc }
            long r9 = r11.zzd()     // Catch:{ all -> 0x0ccc }
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 >= 0) goto L_0x0675
            long r7 = r3.zzd()     // Catch:{ all -> 0x0ccc }
            r11.zzai(r7)     // Catch:{ all -> 0x0ccc }
        L_0x0675:
            long r7 = r3.zzd()     // Catch:{ all -> 0x0ccc }
            long r9 = r11.zzc()     // Catch:{ all -> 0x0ccc }
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 <= 0) goto L_0x0688
            long r7 = r3.zzd()     // Catch:{ all -> 0x0ccc }
            r11.zzQ(r7)     // Catch:{ all -> 0x0ccc }
        L_0x0688:
            int r2 = r2 + 1
            goto L_0x0658
        L_0x068b:
            r11.zzz()     // Catch:{ all -> 0x0ccc }
            r11.zzo()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.b r2 = r1.f40070f     // Catch:{ all -> 0x0ccc }
            R(r2)     // Catch:{ all -> 0x0ccc }
            java.lang.String r20 = r11.zzaq()     // Catch:{ all -> 0x0ccc }
            java.util.List r21 = r11.zzat()     // Catch:{ all -> 0x0ccc }
            java.util.List r22 = r11.zzau()     // Catch:{ all -> 0x0ccc }
            long r7 = r11.zzd()     // Catch:{ all -> 0x0ccc }
            java.lang.Long r23 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0ccc }
            long r7 = r11.zzc()     // Catch:{ all -> 0x0ccc }
            java.lang.Long r24 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0ccc }
            r19 = r2
            java.util.List r2 = r19.m(r20, r21, r22, r23, r24)     // Catch:{ all -> 0x0ccc }
            r11.zzf(r2)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.g r2 = r40.U()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzgd r3 = r4.f40021a     // Catch:{ all -> 0x0ccc }
            java.lang.String r3 = r3.zzy()     // Catch:{ all -> 0x0ccc }
            boolean r2 = r2.F(r3)     // Catch:{ all -> 0x0ccc }
            if (r2 == 0) goto L_0x0a07
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x0ccc }
            r2.<init>()     // Catch:{ all -> 0x0ccc }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0ccc }
            r3.<init>()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.t9 r7 = r40.h0()     // Catch:{ all -> 0x0ccc }
            java.security.SecureRandom r7 = r7.u()     // Catch:{ all -> 0x0ccc }
            r8 = 0
        L_0x06de:
            int r9 = r11.zza()     // Catch:{ all -> 0x0ccc }
            if (r8 >= r9) goto L_0x09d1
            com.google.android.gms.internal.measurement.zzft r9 = r11.zze(r8)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzkx r9 = r9.zzbB()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzfs r9 = (com.google.android.gms.internal.measurement.zzfs) r9     // Catch:{ all -> 0x0ccc }
            java.lang.String r10 = r9.zzo()     // Catch:{ all -> 0x0ccc }
            java.lang.String r12 = "_ep"
            boolean r10 = r10.equals(r12)     // Catch:{ all -> 0x0ccc }
            java.lang.String r12 = "_efs"
            java.lang.String r13 = "_sr"
            if (r10 == 0) goto L_0x0780
            com.google.android.gms.measurement.internal.p9 r10 = r1.f40071g     // Catch:{ all -> 0x0ccc }
            R(r10)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzlb r10 = r9.zzaD()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzft r10 = (com.google.android.gms.internal.measurement.zzft) r10     // Catch:{ all -> 0x0ccc }
            java.lang.String r14 = "_en"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.p9.p(r10, r14)     // Catch:{ all -> 0x0ccc }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0ccc }
            java.lang.Object r14 = r2.get(r10)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.q r14 = (com.google.android.gms.measurement.internal.q) r14     // Catch:{ all -> 0x0ccc }
            if (r14 != 0) goto L_0x0735
            com.google.android.gms.measurement.internal.k r14 = r1.f40067c     // Catch:{ all -> 0x0ccc }
            R(r14)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzgd r15 = r4.f40021a     // Catch:{ all -> 0x0ccc }
            java.lang.String r15 = r15.zzy()     // Catch:{ all -> 0x0ccc }
            java.lang.Object r17 = com.google.android.gms.common.internal.p.k(r10)     // Catch:{ all -> 0x0ccc }
            r5 = r17
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.q r14 = r14.V(r15, r5)     // Catch:{ all -> 0x0ccc }
            if (r14 == 0) goto L_0x0735
            r2.put(r10, r14)     // Catch:{ all -> 0x0ccc }
        L_0x0735:
            if (r14 == 0) goto L_0x0774
            java.lang.Long r5 = r14.f40153i     // Catch:{ all -> 0x0ccc }
            if (r5 != 0) goto L_0x0774
            java.lang.Long r5 = r14.f40154j     // Catch:{ all -> 0x0ccc }
            if (r5 == 0) goto L_0x0753
            long r5 = r5.longValue()     // Catch:{ all -> 0x0ccc }
            r17 = 1
            int r5 = (r5 > r17 ? 1 : (r5 == r17 ? 0 : -1))
            if (r5 <= 0) goto L_0x0753
            com.google.android.gms.measurement.internal.p9 r5 = r1.f40071g     // Catch:{ all -> 0x0ccc }
            R(r5)     // Catch:{ all -> 0x0ccc }
            java.lang.Long r5 = r14.f40154j     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.p9.m(r9, r13, r5)     // Catch:{ all -> 0x0ccc }
        L_0x0753:
            java.lang.Boolean r5 = r14.f40155k     // Catch:{ all -> 0x0ccc }
            if (r5 == 0) goto L_0x076b
            boolean r5 = r5.booleanValue()     // Catch:{ all -> 0x0ccc }
            if (r5 == 0) goto L_0x076b
            com.google.android.gms.measurement.internal.p9 r5 = r1.f40071g     // Catch:{ all -> 0x0ccc }
            R(r5)     // Catch:{ all -> 0x0ccc }
            r5 = 1
            java.lang.Long r10 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.p9.m(r9, r12, r10)     // Catch:{ all -> 0x0ccc }
        L_0x076b:
            com.google.android.gms.internal.measurement.zzlb r5 = r9.zzaD()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzft r5 = (com.google.android.gms.internal.measurement.zzft) r5     // Catch:{ all -> 0x0ccc }
            r3.add(r5)     // Catch:{ all -> 0x0ccc }
        L_0x0774:
            r11.zzS(r8, r9)     // Catch:{ all -> 0x0ccc }
        L_0x0777:
            r10 = r3
            r21 = r7
            r5 = r11
            r7 = r2
            r2 = 1
            goto L_0x09c6
        L_0x0780:
            com.google.android.gms.measurement.internal.o4 r5 = r1.f40065a     // Catch:{ all -> 0x0ccc }
            R(r5)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzgd r6 = r4.f40021a     // Catch:{ all -> 0x0ccc }
            java.lang.String r6 = r6.zzy()     // Catch:{ all -> 0x0ccc }
            java.lang.String r10 = "measurement.account.time_zone_offset_minutes"
            java.lang.String r10 = r5.e(r6, r10)     // Catch:{ all -> 0x0ccc }
            boolean r14 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0ccc }
            if (r14 != 0) goto L_0x07b1
            long r5 = java.lang.Long.parseLong(r10)     // Catch:{ NumberFormatException -> 0x079c }
            goto L_0x07b3
        L_0x079c:
            r0 = move-exception
            r10 = r0
            com.google.android.gms.measurement.internal.u4 r5 = r5.f40059a     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.q3 r5 = r5.d()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.o3 r5 = r5.w()     // Catch:{ all -> 0x0ccc }
            java.lang.String r14 = "Unable to parse timezone offset. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.q3.z(r6)     // Catch:{ all -> 0x0ccc }
            r5.c(r14, r6, r10)     // Catch:{ all -> 0x0ccc }
        L_0x07b1:
            r5 = 0
        L_0x07b3:
            com.google.android.gms.measurement.internal.t9 r10 = r40.h0()     // Catch:{ all -> 0x0ccc }
            long r14 = r9.zzc()     // Catch:{ all -> 0x0ccc }
            long r14 = r10.u0(r14, r5)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzlb r10 = r9.zzaD()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzft r10 = (com.google.android.gms.internal.measurement.zzft) r10     // Catch:{ all -> 0x0ccc }
            r43 = r12
            r17 = 1
            java.lang.Long r12 = java.lang.Long.valueOf(r17)     // Catch:{ all -> 0x0ccc }
            r17 = r5
            java.lang.String r5 = "_dbg"
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0ccc }
            if (r6 != 0) goto L_0x080b
            java.util.List r6 = r10.zzi()     // Catch:{ all -> 0x0ccc }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0ccc }
        L_0x07df:
            boolean r10 = r6.hasNext()     // Catch:{ all -> 0x0ccc }
            if (r10 == 0) goto L_0x080b
            java.lang.Object r10 = r6.next()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzfx r10 = (com.google.android.gms.internal.measurement.zzfx) r10     // Catch:{ all -> 0x0ccc }
            r21 = r6
            java.lang.String r6 = r10.zzg()     // Catch:{ all -> 0x0ccc }
            boolean r6 = r5.equals(r6)     // Catch:{ all -> 0x0ccc }
            if (r6 == 0) goto L_0x0808
            long r5 = r10.zzd()     // Catch:{ all -> 0x0ccc }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0ccc }
            boolean r5 = r12.equals(r5)     // Catch:{ all -> 0x0ccc }
            if (r5 != 0) goto L_0x0806
            goto L_0x080b
        L_0x0806:
            r5 = 1
            goto L_0x081e
        L_0x0808:
            r6 = r21
            goto L_0x07df
        L_0x080b:
            com.google.android.gms.measurement.internal.o4 r5 = r1.f40065a     // Catch:{ all -> 0x0ccc }
            R(r5)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzgd r6 = r4.f40021a     // Catch:{ all -> 0x0ccc }
            java.lang.String r6 = r6.zzy()     // Catch:{ all -> 0x0ccc }
            java.lang.String r10 = r9.zzo()     // Catch:{ all -> 0x0ccc }
            int r5 = r5.r(r6, r10)     // Catch:{ all -> 0x0ccc }
        L_0x081e:
            if (r5 > 0) goto L_0x0843
            com.google.android.gms.measurement.internal.q3 r6 = r40.d()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.o3 r6 = r6.w()     // Catch:{ all -> 0x0ccc }
            java.lang.String r10 = "Sample rate must be positive. event, rate"
            java.lang.String r12 = r9.zzo()     // Catch:{ all -> 0x0ccc }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0ccc }
            r6.c(r10, r12, r5)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzlb r5 = r9.zzaD()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzft r5 = (com.google.android.gms.internal.measurement.zzft) r5     // Catch:{ all -> 0x0ccc }
            r3.add(r5)     // Catch:{ all -> 0x0ccc }
            r11.zzS(r8, r9)     // Catch:{ all -> 0x0ccc }
            goto L_0x0777
        L_0x0843:
            java.lang.String r6 = r9.zzo()     // Catch:{ all -> 0x0ccc }
            java.lang.Object r6 = r2.get(r6)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.q r6 = (com.google.android.gms.measurement.internal.q) r6     // Catch:{ all -> 0x0ccc }
            if (r6 != 0) goto L_0x08a3
            com.google.android.gms.measurement.internal.k r6 = r1.f40067c     // Catch:{ all -> 0x0ccc }
            R(r6)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzgd r10 = r4.f40021a     // Catch:{ all -> 0x0ccc }
            java.lang.String r10 = r10.zzy()     // Catch:{ all -> 0x0ccc }
            java.lang.String r12 = r9.zzo()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.q r6 = r6.V(r10, r12)     // Catch:{ all -> 0x0ccc }
            if (r6 != 0) goto L_0x08a3
            com.google.android.gms.measurement.internal.q3 r6 = r40.d()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.o3 r6 = r6.w()     // Catch:{ all -> 0x0ccc }
            java.lang.String r10 = "Event being bundled has no eventAggregate. appId, eventName"
            com.google.android.gms.internal.measurement.zzgd r12 = r4.f40021a     // Catch:{ all -> 0x0ccc }
            java.lang.String r12 = r12.zzy()     // Catch:{ all -> 0x0ccc }
            r21 = r14
            java.lang.String r14 = r9.zzo()     // Catch:{ all -> 0x0ccc }
            r6.c(r10, r12, r14)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.q r6 = new com.google.android.gms.measurement.internal.q     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzgd r10 = r4.f40021a     // Catch:{ all -> 0x0ccc }
            java.lang.String r24 = r10.zzy()     // Catch:{ all -> 0x0ccc }
            java.lang.String r25 = r9.zzo()     // Catch:{ all -> 0x0ccc }
            r26 = 1
            r28 = 1
            r30 = 1
            long r32 = r9.zzc()     // Catch:{ all -> 0x0ccc }
            r34 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r23 = r6
            r23.<init>(r24, r25, r26, r28, r30, r32, r34, r36, r37, r38, r39)     // Catch:{ all -> 0x0ccc }
            goto L_0x08a5
        L_0x08a3:
            r21 = r14
        L_0x08a5:
            com.google.android.gms.measurement.internal.p9 r10 = r1.f40071g     // Catch:{ all -> 0x0ccc }
            R(r10)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzlb r10 = r9.zzaD()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzft r10 = (com.google.android.gms.internal.measurement.zzft) r10     // Catch:{ all -> 0x0ccc }
            java.lang.String r12 = "_eid"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.p9.p(r10, r12)     // Catch:{ all -> 0x0ccc }
            java.lang.Long r10 = (java.lang.Long) r10     // Catch:{ all -> 0x0ccc }
            if (r10 == 0) goto L_0x08bc
            r12 = 1
            goto L_0x08bd
        L_0x08bc:
            r12 = 0
        L_0x08bd:
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)     // Catch:{ all -> 0x0ccc }
            r14 = 1
            if (r5 != r14) goto L_0x08f0
            com.google.android.gms.internal.measurement.zzlb r5 = r9.zzaD()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzft r5 = (com.google.android.gms.internal.measurement.zzft) r5     // Catch:{ all -> 0x0ccc }
            r3.add(r5)     // Catch:{ all -> 0x0ccc }
            boolean r5 = r12.booleanValue()     // Catch:{ all -> 0x0ccc }
            if (r5 == 0) goto L_0x08eb
            java.lang.Long r5 = r6.f40153i     // Catch:{ all -> 0x0ccc }
            if (r5 != 0) goto L_0x08df
            java.lang.Long r5 = r6.f40154j     // Catch:{ all -> 0x0ccc }
            if (r5 != 0) goto L_0x08df
            java.lang.Boolean r5 = r6.f40155k     // Catch:{ all -> 0x0ccc }
            if (r5 == 0) goto L_0x08eb
        L_0x08df:
            r5 = 0
            com.google.android.gms.measurement.internal.q r6 = r6.a(r5, r5, r5)     // Catch:{ all -> 0x0ccc }
            java.lang.String r5 = r9.zzo()     // Catch:{ all -> 0x0ccc }
            r2.put(r5, r6)     // Catch:{ all -> 0x0ccc }
        L_0x08eb:
            r11.zzS(r8, r9)     // Catch:{ all -> 0x0ccc }
            goto L_0x0777
        L_0x08f0:
            int r14 = r7.nextInt(r5)     // Catch:{ all -> 0x0ccc }
            if (r14 != 0) goto L_0x0931
            com.google.android.gms.measurement.internal.p9 r10 = r1.f40071g     // Catch:{ all -> 0x0ccc }
            R(r10)     // Catch:{ all -> 0x0ccc }
            long r14 = (long) r5     // Catch:{ all -> 0x0ccc }
            java.lang.Long r5 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.p9.m(r9, r13, r5)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzlb r10 = r9.zzaD()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzft r10 = (com.google.android.gms.internal.measurement.zzft) r10     // Catch:{ all -> 0x0ccc }
            r3.add(r10)     // Catch:{ all -> 0x0ccc }
            boolean r10 = r12.booleanValue()     // Catch:{ all -> 0x0ccc }
            if (r10 == 0) goto L_0x0917
            r10 = 0
            com.google.android.gms.measurement.internal.q r6 = r6.a(r10, r5, r10)     // Catch:{ all -> 0x0ccc }
        L_0x0917:
            java.lang.String r5 = r9.zzo()     // Catch:{ all -> 0x0ccc }
            long r12 = r9.zzc()     // Catch:{ all -> 0x0ccc }
            r14 = r21
            com.google.android.gms.measurement.internal.q r6 = r6.b(r12, r14)     // Catch:{ all -> 0x0ccc }
            r2.put(r5, r6)     // Catch:{ all -> 0x0ccc }
            r10 = r3
            r21 = r7
            r5 = r11
            r7 = r2
            r2 = 1
            goto L_0x09c3
        L_0x0931:
            r14 = r21
            r21 = r7
            java.lang.Long r7 = r6.f40152h     // Catch:{ all -> 0x0ccc }
            if (r7 == 0) goto L_0x0946
            long r17 = r7.longValue()     // Catch:{ all -> 0x0ccc }
            r24 = r2
            r25 = r3
            r23 = r10
            r22 = r11
            goto L_0x095c
        L_0x0946:
            com.google.android.gms.measurement.internal.t9 r7 = r40.h0()     // Catch:{ all -> 0x0ccc }
            r23 = r10
            r22 = r11
            long r10 = r9.zzb()     // Catch:{ all -> 0x0ccc }
            r24 = r2
            r25 = r3
            r2 = r17
            long r17 = r7.u0(r10, r2)     // Catch:{ all -> 0x0ccc }
        L_0x095c:
            int r2 = (r17 > r14 ? 1 : (r17 == r14 ? 0 : -1))
            if (r2 == 0) goto L_0x09a7
            com.google.android.gms.measurement.internal.p9 r2 = r1.f40071g     // Catch:{ all -> 0x0ccc }
            R(r2)     // Catch:{ all -> 0x0ccc }
            r2 = 1
            java.lang.Long r7 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0ccc }
            r10 = r43
            com.google.android.gms.measurement.internal.p9.m(r9, r10, r7)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.p9 r7 = r1.f40071g     // Catch:{ all -> 0x0ccc }
            R(r7)     // Catch:{ all -> 0x0ccc }
            long r10 = (long) r5     // Catch:{ all -> 0x0ccc }
            java.lang.Long r5 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.p9.m(r9, r13, r5)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzlb r7 = r9.zzaD()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzft r7 = (com.google.android.gms.internal.measurement.zzft) r7     // Catch:{ all -> 0x0ccc }
            r10 = r25
            r10.add(r7)     // Catch:{ all -> 0x0ccc }
            boolean r7 = r12.booleanValue()     // Catch:{ all -> 0x0ccc }
            if (r7 == 0) goto L_0x0995
            java.lang.Boolean r7 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0ccc }
            r11 = 0
            com.google.android.gms.measurement.internal.q r6 = r6.a(r11, r5, r7)     // Catch:{ all -> 0x0ccc }
        L_0x0995:
            java.lang.String r5 = r9.zzo()     // Catch:{ all -> 0x0ccc }
            long r11 = r9.zzc()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.q r6 = r6.b(r11, r14)     // Catch:{ all -> 0x0ccc }
            r7 = r24
            r7.put(r5, r6)     // Catch:{ all -> 0x0ccc }
            goto L_0x09c1
        L_0x09a7:
            r7 = r24
            r10 = r25
            r2 = 1
            boolean r5 = r12.booleanValue()     // Catch:{ all -> 0x0ccc }
            if (r5 == 0) goto L_0x09c1
            java.lang.String r5 = r9.zzo()     // Catch:{ all -> 0x0ccc }
            r11 = r23
            r12 = 0
            com.google.android.gms.measurement.internal.q r6 = r6.a(r11, r12, r12)     // Catch:{ all -> 0x0ccc }
            r7.put(r5, r6)     // Catch:{ all -> 0x0ccc }
        L_0x09c1:
            r5 = r22
        L_0x09c3:
            r5.zzS(r8, r9)     // Catch:{ all -> 0x0ccc }
        L_0x09c6:
            int r8 = r8 + 1
            r11 = r5
            r2 = r7
            r3 = r10
            r7 = r21
            r5 = 0
            goto L_0x06de
        L_0x09d1:
            r7 = r2
            r10 = r3
            r5 = r11
            int r2 = r10.size()     // Catch:{ all -> 0x0ccc }
            int r3 = r5.zza()     // Catch:{ all -> 0x0ccc }
            if (r2 >= r3) goto L_0x09e4
            r5.zzr()     // Catch:{ all -> 0x0ccc }
            r5.zzg(r10)     // Catch:{ all -> 0x0ccc }
        L_0x09e4:
            java.util.Set r2 = r7.entrySet()     // Catch:{ all -> 0x0ccc }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0ccc }
        L_0x09ec:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0ccc }
            if (r3 == 0) goto L_0x0a08
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0ccc }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.k r6 = r1.f40067c     // Catch:{ all -> 0x0ccc }
            R(r6)     // Catch:{ all -> 0x0ccc }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.q r3 = (com.google.android.gms.measurement.internal.q) r3     // Catch:{ all -> 0x0ccc }
            r6.q(r3)     // Catch:{ all -> 0x0ccc }
            goto L_0x09ec
        L_0x0a07:
            r5 = r11
        L_0x0a08:
            com.google.android.gms.internal.measurement.zzgd r2 = r4.f40021a     // Catch:{ all -> 0x0ccc }
            java.lang.String r2 = r2.zzy()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.k r3 = r1.f40067c     // Catch:{ all -> 0x0ccc }
            R(r3)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.q5 r3 = r3.R(r2)     // Catch:{ all -> 0x0ccc }
            if (r3 != 0) goto L_0x0a31
            com.google.android.gms.measurement.internal.q3 r3 = r40.d()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.o3 r3 = r3.r()     // Catch:{ all -> 0x0ccc }
            java.lang.String r6 = "Bundling raw events w/o app info. appId"
            com.google.android.gms.internal.measurement.zzgd r7 = r4.f40021a     // Catch:{ all -> 0x0ccc }
            java.lang.String r7 = r7.zzy()     // Catch:{ all -> 0x0ccc }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.q3.z(r7)     // Catch:{ all -> 0x0ccc }
            r3.b(r6, r7)     // Catch:{ all -> 0x0ccc }
            goto L_0x0a8d
        L_0x0a31:
            int r6 = r5.zza()     // Catch:{ all -> 0x0ccc }
            if (r6 <= 0) goto L_0x0a8d
            long r6 = r3.d0()     // Catch:{ all -> 0x0ccc }
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x0a45
            r5.zzab(r6)     // Catch:{ all -> 0x0ccc }
            goto L_0x0a48
        L_0x0a45:
            r5.zzv()     // Catch:{ all -> 0x0ccc }
        L_0x0a48:
            long r8 = r3.f0()     // Catch:{ all -> 0x0ccc }
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 != 0) goto L_0x0a53
            goto L_0x0a54
        L_0x0a53:
            r6 = r8
        L_0x0a54:
            int r8 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r8 == 0) goto L_0x0a5c
            r5.zzac(r6)     // Catch:{ all -> 0x0ccc }
            goto L_0x0a5f
        L_0x0a5c:
            r5.zzw()     // Catch:{ all -> 0x0ccc }
        L_0x0a5f:
            r3.g()     // Catch:{ all -> 0x0ccc }
            long r6 = r3.e0()     // Catch:{ all -> 0x0ccc }
            int r6 = (int) r6     // Catch:{ all -> 0x0ccc }
            r5.zzI(r6)     // Catch:{ all -> 0x0ccc }
            long r6 = r5.zzd()     // Catch:{ all -> 0x0ccc }
            r3.E(r6)     // Catch:{ all -> 0x0ccc }
            long r6 = r5.zzc()     // Catch:{ all -> 0x0ccc }
            r3.C(r6)     // Catch:{ all -> 0x0ccc }
            java.lang.String r6 = r3.k0()     // Catch:{ all -> 0x0ccc }
            if (r6 == 0) goto L_0x0a82
            r5.zzW(r6)     // Catch:{ all -> 0x0ccc }
            goto L_0x0a85
        L_0x0a82:
            r5.zzs()     // Catch:{ all -> 0x0ccc }
        L_0x0a85:
            com.google.android.gms.measurement.internal.k r6 = r1.f40067c     // Catch:{ all -> 0x0ccc }
            R(r6)     // Catch:{ all -> 0x0ccc }
            r6.p(r3)     // Catch:{ all -> 0x0ccc }
        L_0x0a8d:
            int r3 = r5.zza()     // Catch:{ all -> 0x0ccc }
            if (r3 <= 0) goto L_0x0c11
            com.google.android.gms.measurement.internal.u4 r3 = r1.f40076l     // Catch:{ all -> 0x0ccc }
            r3.b()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.o4 r3 = r1.f40065a     // Catch:{ all -> 0x0ccc }
            R(r3)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzgd r6 = r4.f40021a     // Catch:{ all -> 0x0ccc }
            java.lang.String r6 = r6.zzy()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzff r3 = r3.t(r6)     // Catch:{ all -> 0x0ccc }
            r6 = -1
            if (r3 == 0) goto L_0x0aba
            boolean r8 = r3.zzu()     // Catch:{ all -> 0x0ccc }
            if (r8 != 0) goto L_0x0ab2
            goto L_0x0aba
        L_0x0ab2:
            long r8 = r3.zzc()     // Catch:{ all -> 0x0ccc }
            r5.zzK(r8)     // Catch:{ all -> 0x0ccc }
            goto L_0x0ae1
        L_0x0aba:
            com.google.android.gms.internal.measurement.zzgd r3 = r4.f40021a     // Catch:{ all -> 0x0ccc }
            java.lang.String r3 = r3.zzG()     // Catch:{ all -> 0x0ccc }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0ccc }
            if (r3 == 0) goto L_0x0aca
            r5.zzK(r6)     // Catch:{ all -> 0x0ccc }
            goto L_0x0ae1
        L_0x0aca:
            com.google.android.gms.measurement.internal.q3 r3 = r40.d()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.o3 r3 = r3.w()     // Catch:{ all -> 0x0ccc }
            java.lang.String r8 = "Did not find measurement config or missing version info. appId"
            com.google.android.gms.internal.measurement.zzgd r9 = r4.f40021a     // Catch:{ all -> 0x0ccc }
            java.lang.String r9 = r9.zzy()     // Catch:{ all -> 0x0ccc }
            java.lang.Object r9 = com.google.android.gms.measurement.internal.q3.z(r9)     // Catch:{ all -> 0x0ccc }
            r3.b(r8, r9)     // Catch:{ all -> 0x0ccc }
        L_0x0ae1:
            com.google.android.gms.measurement.internal.k r3 = r1.f40067c     // Catch:{ all -> 0x0ccc }
            R(r3)     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzlb r5 = r5.zzaD()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.internal.measurement.zzgd r5 = (com.google.android.gms.internal.measurement.zzgd) r5     // Catch:{ all -> 0x0ccc }
            r3.h()     // Catch:{ all -> 0x0ccc }
            r3.i()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.common.internal.p.k(r5)     // Catch:{ all -> 0x0ccc }
            java.lang.String r8 = r5.zzy()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.common.internal.p.g(r8)     // Catch:{ all -> 0x0ccc }
            boolean r8 = r5.zzbg()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.common.internal.p.o(r8)     // Catch:{ all -> 0x0ccc }
            r3.h0()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.u4 r8 = r3.f40059a     // Catch:{ all -> 0x0ccc }
            me.f r8 = r8.a()     // Catch:{ all -> 0x0ccc }
            long r8 = r8.currentTimeMillis()     // Catch:{ all -> 0x0ccc }
            long r10 = r5.zzk()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.u4 r12 = r3.f40059a     // Catch:{ all -> 0x0ccc }
            r12.z()     // Catch:{ all -> 0x0ccc }
            long r12 = com.google.android.gms.measurement.internal.g.i()     // Catch:{ all -> 0x0ccc }
            long r12 = r8 - r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 < 0) goto L_0x0b35
            long r10 = r5.zzk()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.u4 r12 = r3.f40059a     // Catch:{ all -> 0x0ccc }
            r12.z()     // Catch:{ all -> 0x0ccc }
            long r12 = com.google.android.gms.measurement.internal.g.i()     // Catch:{ all -> 0x0ccc }
            long r12 = r12 + r8
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 <= 0) goto L_0x0b58
        L_0x0b35:
            com.google.android.gms.measurement.internal.u4 r10 = r3.f40059a     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.q3 r10 = r10.d()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.o3 r10 = r10.w()     // Catch:{ all -> 0x0ccc }
            java.lang.String r11 = "Storing bundle outside of the max uploading time span. appId, now, timestamp"
            java.lang.String r12 = r5.zzy()     // Catch:{ all -> 0x0ccc }
            java.lang.Object r12 = com.google.android.gms.measurement.internal.q3.z(r12)     // Catch:{ all -> 0x0ccc }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0ccc }
            long r13 = r5.zzk()     // Catch:{ all -> 0x0ccc }
            java.lang.Long r9 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x0ccc }
            r10.d(r11, r12, r8, r9)     // Catch:{ all -> 0x0ccc }
        L_0x0b58:
            byte[] r8 = r5.zzbx()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.n9 r9 = r3.f39651b     // Catch:{ IOException -> 0x0bf8 }
            com.google.android.gms.measurement.internal.p9 r9 = r9.f40071g     // Catch:{ IOException -> 0x0bf8 }
            R(r9)     // Catch:{ IOException -> 0x0bf8 }
            byte[] r8 = r9.Q(r8)     // Catch:{ IOException -> 0x0bf8 }
            com.google.android.gms.measurement.internal.u4 r9 = r3.f40059a     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.q3 r9 = r9.d()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.o3 r9 = r9.v()     // Catch:{ all -> 0x0ccc }
            java.lang.String r10 = "Saving bundle, size"
            int r11 = r8.length     // Catch:{ all -> 0x0ccc }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0ccc }
            r9.b(r10, r11)     // Catch:{ all -> 0x0ccc }
            android.content.ContentValues r9 = new android.content.ContentValues     // Catch:{ all -> 0x0ccc }
            r9.<init>()     // Catch:{ all -> 0x0ccc }
            java.lang.String r10 = "app_id"
            java.lang.String r11 = r5.zzy()     // Catch:{ all -> 0x0ccc }
            r9.put(r10, r11)     // Catch:{ all -> 0x0ccc }
            java.lang.String r10 = "bundle_end_timestamp"
            long r11 = r5.zzk()     // Catch:{ all -> 0x0ccc }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0ccc }
            r9.put(r10, r11)     // Catch:{ all -> 0x0ccc }
            java.lang.String r10 = "data"
            r9.put(r10, r8)     // Catch:{ all -> 0x0ccc }
            java.lang.String r8 = "has_realtime"
            java.lang.Integer r10 = java.lang.Integer.valueOf(r16)     // Catch:{ all -> 0x0ccc }
            r9.put(r8, r10)     // Catch:{ all -> 0x0ccc }
            boolean r8 = r5.zzbm()     // Catch:{ all -> 0x0ccc }
            if (r8 == 0) goto L_0x0bb7
            java.lang.String r8 = "retry_count"
            int r10 = r5.zze()     // Catch:{ all -> 0x0ccc }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0ccc }
            r9.put(r8, r10)     // Catch:{ all -> 0x0ccc }
        L_0x0bb7:
            android.database.sqlite.SQLiteDatabase r8 = r3.P()     // Catch:{ SQLiteException -> 0x0bde }
            java.lang.String r10 = "queue"
            r11 = 0
            long r8 = r8.insert(r10, r11, r9)     // Catch:{ SQLiteException -> 0x0bde }
            int r6 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r6 != 0) goto L_0x0c11
            com.google.android.gms.measurement.internal.u4 r6 = r3.f40059a     // Catch:{ SQLiteException -> 0x0bde }
            com.google.android.gms.measurement.internal.q3 r6 = r6.d()     // Catch:{ SQLiteException -> 0x0bde }
            com.google.android.gms.measurement.internal.o3 r6 = r6.r()     // Catch:{ SQLiteException -> 0x0bde }
            java.lang.String r7 = "Failed to insert bundle (got -1). appId"
            java.lang.String r8 = r5.zzy()     // Catch:{ SQLiteException -> 0x0bde }
            java.lang.Object r8 = com.google.android.gms.measurement.internal.q3.z(r8)     // Catch:{ SQLiteException -> 0x0bde }
            r6.b(r7, r8)     // Catch:{ SQLiteException -> 0x0bde }
            goto L_0x0c11
        L_0x0bde:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.u4 r3 = r3.f40059a     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.q3 r3 = r3.d()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.o3 r3 = r3.r()     // Catch:{ all -> 0x0ccc }
            java.lang.String r7 = "Error storing bundle. appId"
            java.lang.String r5 = r5.zzy()     // Catch:{ all -> 0x0ccc }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.q3.z(r5)     // Catch:{ all -> 0x0ccc }
            r3.c(r7, r5, r6)     // Catch:{ all -> 0x0ccc }
            goto L_0x0c11
        L_0x0bf8:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.u4 r3 = r3.f40059a     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.q3 r3 = r3.d()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.o3 r3 = r3.r()     // Catch:{ all -> 0x0ccc }
            java.lang.String r7 = "Data loss. Failed to serialize bundle. appId"
            java.lang.String r5 = r5.zzy()     // Catch:{ all -> 0x0ccc }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.q3.z(r5)     // Catch:{ all -> 0x0ccc }
            r3.c(r7, r5, r6)     // Catch:{ all -> 0x0ccc }
        L_0x0c11:
            com.google.android.gms.measurement.internal.k r3 = r1.f40067c     // Catch:{ all -> 0x0ccc }
            R(r3)     // Catch:{ all -> 0x0ccc }
            java.util.List r4 = r4.f40022b     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.common.internal.p.k(r4)     // Catch:{ all -> 0x0ccc }
            r3.h()     // Catch:{ all -> 0x0ccc }
            r3.i()     // Catch:{ all -> 0x0ccc }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0ccc }
            java.lang.String r6 = "rowid in ("
            r5.<init>(r6)     // Catch:{ all -> 0x0ccc }
            r6 = 0
        L_0x0c29:
            int r7 = r4.size()     // Catch:{ all -> 0x0ccc }
            if (r6 >= r7) goto L_0x0c46
            if (r6 == 0) goto L_0x0c36
            java.lang.String r7 = ","
            r5.append(r7)     // Catch:{ all -> 0x0ccc }
        L_0x0c36:
            java.lang.Object r7 = r4.get(r6)     // Catch:{ all -> 0x0ccc }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x0ccc }
            long r7 = r7.longValue()     // Catch:{ all -> 0x0ccc }
            r5.append(r7)     // Catch:{ all -> 0x0ccc }
            int r6 = r6 + 1
            goto L_0x0c29
        L_0x0c46:
            java.lang.String r6 = ")"
            r5.append(r6)     // Catch:{ all -> 0x0ccc }
            android.database.sqlite.SQLiteDatabase r6 = r3.P()     // Catch:{ all -> 0x0ccc }
            java.lang.String r7 = "raw_events"
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0ccc }
            r8 = 0
            int r5 = r6.delete(r7, r5, r8)     // Catch:{ all -> 0x0ccc }
            int r6 = r4.size()     // Catch:{ all -> 0x0ccc }
            if (r5 == r6) goto L_0x0c7b
            com.google.android.gms.measurement.internal.u4 r3 = r3.f40059a     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.q3 r3 = r3.d()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.o3 r3 = r3.r()     // Catch:{ all -> 0x0ccc }
            java.lang.String r6 = "Deleted fewer rows from raw events table than expected"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0ccc }
            int r4 = r4.size()     // Catch:{ all -> 0x0ccc }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0ccc }
            r3.c(r6, r5, r4)     // Catch:{ all -> 0x0ccc }
        L_0x0c7b:
            com.google.android.gms.measurement.internal.k r3 = r1.f40067c     // Catch:{ all -> 0x0ccc }
            R(r3)     // Catch:{ all -> 0x0ccc }
            android.database.sqlite.SQLiteDatabase r4 = r3.P()     // Catch:{ all -> 0x0ccc }
            java.lang.String r5 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0c93 }
            r7 = 0
            r6[r7] = r2     // Catch:{ SQLiteException -> 0x0c93 }
            r7 = 1
            r6[r7] = r2     // Catch:{ SQLiteException -> 0x0c93 }
            r4.execSQL(r5, r6)     // Catch:{ SQLiteException -> 0x0c93 }
            goto L_0x0ca8
        L_0x0c93:
            r0 = move-exception
            r4 = r0
            com.google.android.gms.measurement.internal.u4 r3 = r3.f40059a     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.q3 r3 = r3.d()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.o3 r3 = r3.r()     // Catch:{ all -> 0x0ccc }
            java.lang.String r5 = "Failed to remove unused event metadata. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.q3.z(r2)     // Catch:{ all -> 0x0ccc }
            r3.c(r5, r2, r4)     // Catch:{ all -> 0x0ccc }
        L_0x0ca8:
            com.google.android.gms.measurement.internal.k r2 = r1.f40067c     // Catch:{ all -> 0x0ccc }
            R(r2)     // Catch:{ all -> 0x0ccc }
            r2.o()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.k r2 = r1.f40067c
            R(r2)
            r2.f0()
            r2 = 1
            return r2
        L_0x0cba:
            com.google.android.gms.measurement.internal.k r2 = r1.f40067c     // Catch:{ all -> 0x0ccc }
            R(r2)     // Catch:{ all -> 0x0ccc }
            r2.o()     // Catch:{ all -> 0x0ccc }
            com.google.android.gms.measurement.internal.k r2 = r1.f40067c
            R(r2)
            r2.f0()
            r2 = 0
            return r2
        L_0x0ccc:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.k r3 = r1.f40067c
            R(r3)
            r3.f0()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.n9.N(java.lang.String, long):boolean");
    }

    private final boolean O() {
        f().h();
        g();
        k kVar = this.f40067c;
        R(kVar);
        if (kVar.r()) {
            return true;
        }
        k kVar2 = this.f40067c;
        R(kVar2);
        if (!TextUtils.isEmpty(kVar2.Z())) {
            return true;
        }
        return false;
    }

    private final boolean P(zzfs zzfs, zzfs zzfs2) {
        String str;
        p.a("_e".equals(zzfs.zzo()));
        R(this.f40071g);
        zzfx o10 = p9.o((zzft) zzfs.zzaD(), "_sc");
        String str2 = null;
        if (o10 == null) {
            str = null;
        } else {
            str = o10.zzh();
        }
        R(this.f40071g);
        zzfx o11 = p9.o((zzft) zzfs2.zzaD(), "_pc");
        if (o11 != null) {
            str2 = o11.zzh();
        }
        if (str2 == null || !str2.equals(str)) {
            return false;
        }
        p.a("_e".equals(zzfs.zzo()));
        R(this.f40071g);
        zzfx o12 = p9.o((zzft) zzfs.zzaD(), "_et");
        if (o12 == null || !o12.zzw() || o12.zzd() <= 0) {
            return true;
        }
        long zzd = o12.zzd();
        R(this.f40071g);
        zzfx o13 = p9.o((zzft) zzfs2.zzaD(), "_et");
        if (o13 != null && o13.zzd() > 0) {
            zzd += o13.zzd();
        }
        R(this.f40071g);
        p9.m(zzfs2, "_et", Long.valueOf(zzd));
        R(this.f40071g);
        p9.m(zzfs, "_fr", 1L);
        return true;
    }

    private static final boolean Q(zzq zzq) {
        return !TextUtils.isEmpty(zzq.f40507b) || !TextUtils.isEmpty(zzq.f40522w);
    }

    private static final b9 R(b9 b9Var) {
        if (b9Var == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (b9Var.k()) {
            return b9Var;
        } else {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(b9Var.getClass())));
        }
    }

    public static n9 f0(Context context) {
        p.k(context);
        p.k(context.getApplicationContext());
        if (F == null) {
            synchronized (n9.class) {
                if (F == null) {
                    F = new n9((o9) p.k(new o9(context)), (u4) null);
                }
            }
        }
        return F;
    }

    static /* bridge */ /* synthetic */ void k0(n9 n9Var, o9 o9Var) {
        n9Var.f().h();
        n9Var.f40075k = new h4(n9Var);
        k kVar = new k(n9Var);
        kVar.j();
        n9Var.f40067c = kVar;
        n9Var.U().z((f) p.k(n9Var.f40065a));
        j8 j8Var = new j8(n9Var);
        j8Var.j();
        n9Var.f40073i = j8Var;
        b bVar = new b(n9Var);
        bVar.j();
        n9Var.f40070f = bVar;
        y6 y6Var = new y6(n9Var);
        y6Var.j();
        n9Var.f40072h = y6Var;
        z8 z8Var = new z8(n9Var);
        z8Var.j();
        n9Var.f40069e = z8Var;
        n9Var.f40068d = new y3(n9Var);
        if (n9Var.f40081q != n9Var.f40082r) {
            n9Var.d().r().c("Not all upload components initialized", Integer.valueOf(n9Var.f40081q), Integer.valueOf(n9Var.f40082r));
        }
        n9Var.f40077m = true;
    }

    /* access modifiers changed from: package-private */
    public final void A(String str, o oVar) {
        f().h();
        g();
        this.A.put(str, oVar);
        k kVar = this.f40067c;
        R(kVar);
        p.k(str);
        p.k(oVar);
        kVar.h();
        kVar.i();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", oVar.i());
        try {
            if (kVar.P().insertWithOnConflict("consent_settings", (String) null, contentValues, 5) == -1) {
                kVar.f40059a.d().r().b("Failed to insert/update consent setting (got -1). appId", q3.z(str));
            }
        } catch (SQLiteException e10) {
            kVar.f40059a.d().r().c("Error storing consent setting. appId, error", q3.z(str), e10);
        }
    }

    /* access modifiers changed from: package-private */
    public final void B(zzlk zzlk, zzq zzq) {
        long j10;
        int i10;
        zzlk zzlk2 = zzlk;
        zzq zzq2 = zzq;
        f().h();
        g();
        if (Q(zzq)) {
            if (!zzq2.f40513h) {
                S(zzq2);
                return;
            }
            int p02 = h0().p0(zzlk2.f40500b);
            int i11 = 0;
            if (p02 != 0) {
                t9 h02 = h0();
                String str = zzlk2.f40500b;
                U();
                String r10 = h02.r(str, 24, true);
                String str2 = zzlk2.f40500b;
                if (str2 != null) {
                    i10 = str2.length();
                } else {
                    i10 = 0;
                }
                h0().C(this.E, zzq2.f40506a, p02, "_ev", r10, i10);
                return;
            }
            int l02 = h0().l0(zzlk2.f40500b, zzlk.S());
            if (l02 != 0) {
                t9 h03 = h0();
                String str3 = zzlk2.f40500b;
                U();
                String r11 = h03.r(str3, 24, true);
                Object S = zzlk.S();
                if (S != null && ((S instanceof String) || (S instanceof CharSequence))) {
                    i11 = S.toString().length();
                }
                h0().C(this.E, zzq2.f40506a, l02, "_ev", r11, i11);
                return;
            }
            Object p10 = h0().p(zzlk2.f40500b, zzlk.S());
            if (p10 != null) {
                if ("_sid".equals(zzlk2.f40500b)) {
                    long j11 = zzlk2.f40501c;
                    String str4 = zzlk2.f40504f;
                    String str5 = (String) p.k(zzq2.f40506a);
                    k kVar = this.f40067c;
                    R(kVar);
                    r9 X = kVar.X(str5, "_sno");
                    if (X != null) {
                        Object obj = X.f40235e;
                        if (obj instanceof Long) {
                            j10 = ((Long) obj).longValue();
                            B(new zzlk("_sno", j11, Long.valueOf(j10 + 1), str4), zzq2);
                        }
                    }
                    if (X != null) {
                        d().w().b("Retrieved last session number from database does not contain a valid (long) value", X.f40235e);
                    }
                    k kVar2 = this.f40067c;
                    R(kVar2);
                    q V = kVar2.V(str5, "_s");
                    if (V != null) {
                        j10 = V.f40147c;
                        d().v().b("Backfill the session number. Last used session number", Long.valueOf(j10));
                    } else {
                        j10 = 0;
                    }
                    B(new zzlk("_sno", j11, Long.valueOf(j10 + 1), str4), zzq2);
                }
                r9 r9Var = new r9((String) p.k(zzq2.f40506a), (String) p.k(zzlk2.f40504f), zzlk2.f40500b, zzlk2.f40501c, p10);
                d().v().c("Setting user property", this.f40076l.D().f(r9Var.f40233c), p10);
                k kVar3 = this.f40067c;
                R(kVar3);
                kVar3.e0();
                try {
                    if ("_id".equals(r9Var.f40233c)) {
                        k kVar4 = this.f40067c;
                        R(kVar4);
                        r9 X2 = kVar4.X(zzq2.f40506a, "_id");
                        if (X2 != null && !r9Var.f40235e.equals(X2.f40235e)) {
                            k kVar5 = this.f40067c;
                            R(kVar5);
                            kVar5.m(zzq2.f40506a, "_lair");
                        }
                    }
                    S(zzq2);
                    k kVar6 = this.f40067c;
                    R(kVar6);
                    boolean x10 = kVar6.x(r9Var);
                    if (U().B((String) null, g3.J0) && "_sid".equals(zzlk2.f40500b)) {
                        p9 p9Var = this.f40071g;
                        R(p9Var);
                        long y10 = p9Var.y(zzq2.E);
                        k kVar7 = this.f40067c;
                        R(kVar7);
                        q5 R = kVar7.R(zzq2.f40506a);
                        if (R != null) {
                            R.K(y10);
                            if (R.P()) {
                                k kVar8 = this.f40067c;
                                R(kVar8);
                                kVar8.p(R);
                            }
                        }
                    }
                    k kVar9 = this.f40067c;
                    R(kVar9);
                    kVar9.o();
                    if (!x10) {
                        d().r().c("Too many unique user properties are set. Ignoring user property", this.f40076l.D().f(r9Var.f40233c), r9Var.f40235e);
                        h0().C(this.E, zzq2.f40506a, 9, (String) null, (String) null, 0);
                    }
                } finally {
                    k kVar10 = this.f40067c;
                    R(kVar10);
                    kVar10.f0();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:217|218) */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0211, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0212, code lost:
        r8.f40059a.d().r().c("Failed to merge queued bundle. appId", com.google.android.gms.measurement.internal.q3.z(r6), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:?, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x026b, code lost:
        r0 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:?, code lost:
        r0 = r0.subList(0, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x02fb, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x02fc, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:?, code lost:
        d().r().c("Failed to parse upload URL. Not uploading. appId", com.google.android.gms.measurement.internal.q3.z(r6), r0.a());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x050e, code lost:
        if (r3 != null) goto L_0x04eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x0538, code lost:
        r1.f40085u = r2;
        K();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x053d, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0126, code lost:
        if (r11 != null) goto L_0x0108;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:217:0x048c */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0294 A[SYNTHETIC, Splitter:B:142:0x0294] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x029d A[Catch:{ all -> 0x03cc, all -> 0x0533 }] */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x04a7 A[Catch:{ all -> 0x03cc, all -> 0x0533 }] */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x0518 A[Catch:{ all -> 0x03cc, all -> 0x0533 }] */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x052f A[SYNTHETIC, Splitter:B:257:0x052f] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0130 A[Catch:{ all -> 0x012c, all -> 0x0536 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:170:0x0302=Splitter:B:170:0x0302, B:247:0x0512=Splitter:B:247:0x0512, B:129:0x0268=Splitter:B:129:0x0268, B:139:0x027b=Splitter:B:139:0x027b, B:231:0x04eb=Splitter:B:231:0x04eb, B:217:0x048c=Splitter:B:217:0x048c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void C() {
        /*
            r22 = this;
            r1 = r22
            com.google.android.gms.measurement.internal.s4 r0 = r22.f()
            r0.h()
            r22.g()
            r2 = 1
            r1.f40085u = r2
            r3 = 0
            com.google.android.gms.measurement.internal.u4 r0 = r1.f40076l     // Catch:{ all -> 0x0536 }
            r0.b()     // Catch:{ all -> 0x0536 }
            com.google.android.gms.measurement.internal.u4 r0 = r1.f40076l     // Catch:{ all -> 0x0536 }
            com.google.android.gms.measurement.internal.g8 r0 = r0.L()     // Catch:{ all -> 0x0536 }
            java.lang.Boolean r0 = r0.J()     // Catch:{ all -> 0x0536 }
            if (r0 != 0) goto L_0x0034
            com.google.android.gms.measurement.internal.q3 r0 = r22.d()     // Catch:{ all -> 0x0536 }
            com.google.android.gms.measurement.internal.o3 r0 = r0.w()     // Catch:{ all -> 0x0536 }
            java.lang.String r2 = "Upload data called on the client side before use of service was decided"
            r0.a(r2)     // Catch:{ all -> 0x0536 }
            r1.f40085u = r3
        L_0x0030:
            r22.K()
            return
        L_0x0034:
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0536 }
            if (r0 == 0) goto L_0x004a
            com.google.android.gms.measurement.internal.q3 r0 = r22.d()     // Catch:{ all -> 0x0536 }
            com.google.android.gms.measurement.internal.o3 r0 = r0.r()     // Catch:{ all -> 0x0536 }
            java.lang.String r2 = "Upload called in the client side when service should be used"
            r0.a(r2)     // Catch:{ all -> 0x0536 }
            r1.f40085u = r3
            goto L_0x0030
        L_0x004a:
            long r4 = r1.f40079o     // Catch:{ all -> 0x0536 }
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x0058
            r22.M()     // Catch:{ all -> 0x0536 }
            r1.f40085u = r3
            goto L_0x0030
        L_0x0058:
            com.google.android.gms.measurement.internal.s4 r0 = r22.f()     // Catch:{ all -> 0x0536 }
            r0.h()     // Catch:{ all -> 0x0536 }
            java.util.List r0 = r1.f40088x     // Catch:{ all -> 0x0536 }
            if (r0 == 0) goto L_0x0073
            com.google.android.gms.measurement.internal.q3 r0 = r22.d()     // Catch:{ all -> 0x0536 }
            com.google.android.gms.measurement.internal.o3 r0 = r0.v()     // Catch:{ all -> 0x0536 }
            java.lang.String r2 = "Uploading requested multiple times"
            r0.a(r2)     // Catch:{ all -> 0x0536 }
            r1.f40085u = r3
            goto L_0x0030
        L_0x0073:
            com.google.android.gms.measurement.internal.v3 r0 = r1.f40066b     // Catch:{ all -> 0x0536 }
            R(r0)     // Catch:{ all -> 0x0536 }
            boolean r0 = r0.m()     // Catch:{ all -> 0x0536 }
            if (r0 != 0) goto L_0x0091
            com.google.android.gms.measurement.internal.q3 r0 = r22.d()     // Catch:{ all -> 0x0536 }
            com.google.android.gms.measurement.internal.o3 r0 = r0.v()     // Catch:{ all -> 0x0536 }
            java.lang.String r2 = "Network not connected, ignoring upload request"
            r0.a(r2)     // Catch:{ all -> 0x0536 }
            r22.M()     // Catch:{ all -> 0x0536 }
            r1.f40085u = r3
            goto L_0x0030
        L_0x0091:
            me.f r0 = r22.a()     // Catch:{ all -> 0x0536 }
            long r4 = r0.currentTimeMillis()     // Catch:{ all -> 0x0536 }
            com.google.android.gms.measurement.internal.g r0 = r22.U()     // Catch:{ all -> 0x0536 }
            com.google.android.gms.measurement.internal.f3 r8 = com.google.android.gms.measurement.internal.g3.T     // Catch:{ all -> 0x0536 }
            r9 = 0
            int r0 = r0.o(r9, r8)     // Catch:{ all -> 0x0536 }
            r22.U()     // Catch:{ all -> 0x0536 }
            long r10 = com.google.android.gms.measurement.internal.g.I()     // Catch:{ all -> 0x0536 }
            long r10 = r4 - r10
            r8 = r3
        L_0x00ae:
            if (r8 >= r0) goto L_0x00b9
            boolean r12 = r1.N(r9, r10)     // Catch:{ all -> 0x0536 }
            if (r12 == 0) goto L_0x00b9
            int r8 = r8 + 1
            goto L_0x00ae
        L_0x00b9:
            com.google.android.gms.measurement.internal.j8 r0 = r1.f40073i     // Catch:{ all -> 0x0536 }
            com.google.android.gms.measurement.internal.b4 r0 = r0.f39966g     // Catch:{ all -> 0x0536 }
            long r10 = r0.a()     // Catch:{ all -> 0x0536 }
            int r0 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x00dc
            com.google.android.gms.measurement.internal.q3 r0 = r22.d()     // Catch:{ all -> 0x0536 }
            com.google.android.gms.measurement.internal.o3 r0 = r0.q()     // Catch:{ all -> 0x0536 }
            java.lang.String r6 = "Uploading events. Elapsed time since last upload attempt (ms)"
            long r7 = r4 - r10
            long r7 = java.lang.Math.abs(r7)     // Catch:{ all -> 0x0536 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0536 }
            r0.b(r6, r7)     // Catch:{ all -> 0x0536 }
        L_0x00dc:
            com.google.android.gms.measurement.internal.k r0 = r1.f40067c     // Catch:{ all -> 0x0536 }
            R(r0)     // Catch:{ all -> 0x0536 }
            java.lang.String r6 = r0.Z()     // Catch:{ all -> 0x0536 }
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0536 }
            r7 = -1
            if (r0 != 0) goto L_0x04ab
            long r10 = r1.f40090z     // Catch:{ all -> 0x0536 }
            int r0 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x0134
            com.google.android.gms.measurement.internal.k r10 = r1.f40067c     // Catch:{ all -> 0x0536 }
            R(r10)     // Catch:{ all -> 0x0536 }
            android.database.sqlite.SQLiteDatabase r0 = r10.P()     // Catch:{ SQLiteException -> 0x0115, all -> 0x0113 }
            java.lang.String r11 = "select rowid from raw_events order by rowid desc limit 1;"
            android.database.Cursor r11 = r0.rawQuery(r11, r9)     // Catch:{ SQLiteException -> 0x0115, all -> 0x0113 }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x0111 }
            if (r0 != 0) goto L_0x010c
        L_0x0108:
            r11.close()     // Catch:{ all -> 0x0536 }
            goto L_0x0129
        L_0x010c:
            long r7 = r11.getLong(r3)     // Catch:{ SQLiteException -> 0x0111 }
            goto L_0x0108
        L_0x0111:
            r0 = move-exception
            goto L_0x0117
        L_0x0113:
            r0 = move-exception
            goto L_0x012e
        L_0x0115:
            r0 = move-exception
            r11 = r9
        L_0x0117:
            com.google.android.gms.measurement.internal.u4 r10 = r10.f40059a     // Catch:{ all -> 0x012c }
            com.google.android.gms.measurement.internal.q3 r10 = r10.d()     // Catch:{ all -> 0x012c }
            com.google.android.gms.measurement.internal.o3 r10 = r10.r()     // Catch:{ all -> 0x012c }
            java.lang.String r12 = "Error querying raw events"
            r10.b(r12, r0)     // Catch:{ all -> 0x012c }
            if (r11 == 0) goto L_0x0129
            goto L_0x0108
        L_0x0129:
            r1.f40090z = r7     // Catch:{ all -> 0x0536 }
            goto L_0x0134
        L_0x012c:
            r0 = move-exception
            r9 = r11
        L_0x012e:
            if (r9 == 0) goto L_0x0133
            r9.close()     // Catch:{ all -> 0x0536 }
        L_0x0133:
            throw r0     // Catch:{ all -> 0x0536 }
        L_0x0134:
            com.google.android.gms.measurement.internal.g r0 = r22.U()     // Catch:{ all -> 0x0536 }
            com.google.android.gms.measurement.internal.f3 r7 = com.google.android.gms.measurement.internal.g3.f39821i     // Catch:{ all -> 0x0536 }
            int r0 = r0.o(r6, r7)     // Catch:{ all -> 0x0536 }
            com.google.android.gms.measurement.internal.g r7 = r22.U()     // Catch:{ all -> 0x0536 }
            com.google.android.gms.measurement.internal.f3 r8 = com.google.android.gms.measurement.internal.g3.f39823j     // Catch:{ all -> 0x0536 }
            int r7 = r7.o(r6, r8)     // Catch:{ all -> 0x0536 }
            int r7 = java.lang.Math.max(r3, r7)     // Catch:{ all -> 0x0536 }
            com.google.android.gms.measurement.internal.k r8 = r1.f40067c     // Catch:{ all -> 0x0536 }
            R(r8)     // Catch:{ all -> 0x0536 }
            r8.h()     // Catch:{ all -> 0x0536 }
            r8.i()     // Catch:{ all -> 0x0536 }
            if (r0 <= 0) goto L_0x015b
            r10 = r2
            goto L_0x015c
        L_0x015b:
            r10 = r3
        L_0x015c:
            com.google.android.gms.common.internal.p.a(r10)     // Catch:{ all -> 0x0536 }
            if (r7 <= 0) goto L_0x0163
            r10 = r2
            goto L_0x0164
        L_0x0163:
            r10 = r3
        L_0x0164:
            com.google.android.gms.common.internal.p.a(r10)     // Catch:{ all -> 0x0536 }
            com.google.android.gms.common.internal.p.g(r6)     // Catch:{ all -> 0x0536 }
            android.database.sqlite.SQLiteDatabase r11 = r8.P()     // Catch:{ SQLiteException -> 0x0277, all -> 0x0273 }
            java.lang.String r12 = "queue"
            java.lang.String r13 = "rowid"
            java.lang.String r14 = "data"
            java.lang.String r15 = "retry_count"
            java.lang.String[] r13 = new java.lang.String[]{r13, r14, r15}     // Catch:{ SQLiteException -> 0x0277, all -> 0x0273 }
            java.lang.String r14 = "app_id=?"
            java.lang.String[] r15 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x0277, all -> 0x0273 }
            r15[r3] = r6     // Catch:{ SQLiteException -> 0x0277, all -> 0x0273 }
            r16 = 0
            r17 = 0
            java.lang.String r18 = "rowid"
            java.lang.String r19 = java.lang.String.valueOf(r0)     // Catch:{ SQLiteException -> 0x0277, all -> 0x0273 }
            android.database.Cursor r11 = r11.query(r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ SQLiteException -> 0x0277, all -> 0x0273 }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x026f }
            if (r0 != 0) goto L_0x019f
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ SQLiteException -> 0x026f }
            r11.close()     // Catch:{ all -> 0x0536 }
            r20 = r4
            goto L_0x0297
        L_0x019f:
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x026f }
            r12.<init>()     // Catch:{ SQLiteException -> 0x026f }
            r13 = r3
        L_0x01a5:
            long r14 = r11.getLong(r3)     // Catch:{ SQLiteException -> 0x026f }
            byte[] r0 = r11.getBlob(r2)     // Catch:{ IOException -> 0x0242 }
            com.google.android.gms.measurement.internal.n9 r9 = r8.f39651b     // Catch:{ IOException -> 0x0242 }
            com.google.android.gms.measurement.internal.p9 r9 = r9.f40071g     // Catch:{ IOException -> 0x0242 }
            R(r9)     // Catch:{ IOException -> 0x0242 }
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x022d }
            r2.<init>(r0)     // Catch:{ IOException -> 0x022d }
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x022d }
            r0.<init>(r2)     // Catch:{ IOException -> 0x022d }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x022d }
            r3.<init>()     // Catch:{ IOException -> 0x022d }
            r10 = 1024(0x400, float:1.435E-42)
            byte[] r10 = new byte[r10]     // Catch:{ IOException -> 0x022d }
            r20 = r4
        L_0x01c9:
            int r4 = r0.read(r10)     // Catch:{ IOException -> 0x022b }
            if (r4 > 0) goto L_0x0226
            r0.close()     // Catch:{ IOException -> 0x022b }
            r2.close()     // Catch:{ IOException -> 0x022b }
            byte[] r0 = r3.toByteArray()     // Catch:{ IOException -> 0x022b }
            boolean r2 = r12.isEmpty()     // Catch:{ SQLiteException -> 0x026d }
            if (r2 != 0) goto L_0x01e5
            int r2 = r0.length     // Catch:{ SQLiteException -> 0x026d }
            int r2 = r2 + r13
            if (r2 <= r7) goto L_0x01e5
            goto L_0x0268
        L_0x01e5:
            com.google.android.gms.internal.measurement.zzgc r2 = com.google.android.gms.internal.measurement.zzgd.zzu()     // Catch:{ IOException -> 0x0211 }
            com.google.android.gms.internal.measurement.zzmh r2 = com.google.android.gms.measurement.internal.p9.E(r2, r0)     // Catch:{ IOException -> 0x0211 }
            com.google.android.gms.internal.measurement.zzgc r2 = (com.google.android.gms.internal.measurement.zzgc) r2     // Catch:{ IOException -> 0x0211 }
            r3 = 2
            boolean r4 = r11.isNull(r3)     // Catch:{ SQLiteException -> 0x026d }
            if (r4 != 0) goto L_0x01fd
            int r4 = r11.getInt(r3)     // Catch:{ SQLiteException -> 0x026d }
            r2.zzaf(r4)     // Catch:{ SQLiteException -> 0x026d }
        L_0x01fd:
            int r0 = r0.length     // Catch:{ SQLiteException -> 0x026d }
            int r13 = r13 + r0
            com.google.android.gms.internal.measurement.zzlb r0 = r2.zzaD()     // Catch:{ SQLiteException -> 0x026d }
            com.google.android.gms.internal.measurement.zzgd r0 = (com.google.android.gms.internal.measurement.zzgd) r0     // Catch:{ SQLiteException -> 0x026d }
            java.lang.Long r2 = java.lang.Long.valueOf(r14)     // Catch:{ SQLiteException -> 0x026d }
            android.util.Pair r0 = android.util.Pair.create(r0, r2)     // Catch:{ SQLiteException -> 0x026d }
            r12.add(r0)     // Catch:{ SQLiteException -> 0x026d }
            goto L_0x0258
        L_0x0211:
            r0 = move-exception
            com.google.android.gms.measurement.internal.u4 r2 = r8.f40059a     // Catch:{ SQLiteException -> 0x026d }
            com.google.android.gms.measurement.internal.q3 r2 = r2.d()     // Catch:{ SQLiteException -> 0x026d }
            com.google.android.gms.measurement.internal.o3 r2 = r2.r()     // Catch:{ SQLiteException -> 0x026d }
            java.lang.String r3 = "Failed to merge queued bundle. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.q3.z(r6)     // Catch:{ SQLiteException -> 0x026d }
            r2.c(r3, r4, r0)     // Catch:{ SQLiteException -> 0x026d }
            goto L_0x0258
        L_0x0226:
            r5 = 0
            r3.write(r10, r5, r4)     // Catch:{ IOException -> 0x022b }
            goto L_0x01c9
        L_0x022b:
            r0 = move-exception
            goto L_0x0230
        L_0x022d:
            r0 = move-exception
            r20 = r4
        L_0x0230:
            com.google.android.gms.measurement.internal.u4 r2 = r9.f40059a     // Catch:{ IOException -> 0x0240 }
            com.google.android.gms.measurement.internal.q3 r2 = r2.d()     // Catch:{ IOException -> 0x0240 }
            com.google.android.gms.measurement.internal.o3 r2 = r2.r()     // Catch:{ IOException -> 0x0240 }
            java.lang.String r3 = "Failed to ungzip content"
            r2.b(r3, r0)     // Catch:{ IOException -> 0x0240 }
            throw r0     // Catch:{ IOException -> 0x0240 }
        L_0x0240:
            r0 = move-exception
            goto L_0x0245
        L_0x0242:
            r0 = move-exception
            r20 = r4
        L_0x0245:
            com.google.android.gms.measurement.internal.u4 r2 = r8.f40059a     // Catch:{ SQLiteException -> 0x026d }
            com.google.android.gms.measurement.internal.q3 r2 = r2.d()     // Catch:{ SQLiteException -> 0x026d }
            com.google.android.gms.measurement.internal.o3 r2 = r2.r()     // Catch:{ SQLiteException -> 0x026d }
            java.lang.String r3 = "Failed to unzip queued bundle. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.q3.z(r6)     // Catch:{ SQLiteException -> 0x026d }
            r2.c(r3, r4, r0)     // Catch:{ SQLiteException -> 0x026d }
        L_0x0258:
            boolean r0 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x026d }
            if (r0 == 0) goto L_0x0268
            if (r13 <= r7) goto L_0x0261
            goto L_0x0268
        L_0x0261:
            r4 = r20
            r2 = 1
            r3 = 0
            r9 = 0
            goto L_0x01a5
        L_0x0268:
            r11.close()     // Catch:{ all -> 0x0533 }
            r0 = r12
            goto L_0x0297
        L_0x026d:
            r0 = move-exception
            goto L_0x027b
        L_0x026f:
            r0 = move-exception
            r20 = r4
            goto L_0x027b
        L_0x0273:
            r0 = move-exception
            r9 = 0
            goto L_0x04a5
        L_0x0277:
            r0 = move-exception
            r20 = r4
            r11 = 0
        L_0x027b:
            com.google.android.gms.measurement.internal.u4 r2 = r8.f40059a     // Catch:{ all -> 0x04a3 }
            com.google.android.gms.measurement.internal.q3 r2 = r2.d()     // Catch:{ all -> 0x04a3 }
            com.google.android.gms.measurement.internal.o3 r2 = r2.r()     // Catch:{ all -> 0x04a3 }
            java.lang.String r3 = "Error querying bundles. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.q3.z(r6)     // Catch:{ all -> 0x04a3 }
            r2.c(r3, r4, r0)     // Catch:{ all -> 0x04a3 }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x04a3 }
            if (r11 == 0) goto L_0x0297
            r11.close()     // Catch:{ all -> 0x0533 }
        L_0x0297:
            boolean r2 = r0.isEmpty()     // Catch:{ all -> 0x0533 }
            if (r2 != 0) goto L_0x0526
            we.o r2 = r1.c0(r6)     // Catch:{ all -> 0x0533 }
            com.google.android.gms.measurement.internal.zzha r3 = com.google.android.gms.measurement.internal.zzha.AD_STORAGE     // Catch:{ all -> 0x0533 }
            boolean r2 = r2.j(r3)     // Catch:{ all -> 0x0533 }
            if (r2 == 0) goto L_0x0302
            java.util.Iterator r2 = r0.iterator()     // Catch:{ all -> 0x0533 }
        L_0x02ad:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0533 }
            if (r3 == 0) goto L_0x02cc
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0533 }
            android.util.Pair r3 = (android.util.Pair) r3     // Catch:{ all -> 0x0533 }
            java.lang.Object r3 = r3.first     // Catch:{ all -> 0x0533 }
            com.google.android.gms.internal.measurement.zzgd r3 = (com.google.android.gms.internal.measurement.zzgd) r3     // Catch:{ all -> 0x0533 }
            java.lang.String r4 = r3.zzK()     // Catch:{ all -> 0x0533 }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0533 }
            if (r4 != 0) goto L_0x02ad
            java.lang.String r2 = r3.zzK()     // Catch:{ all -> 0x0533 }
            goto L_0x02cd
        L_0x02cc:
            r2 = 0
        L_0x02cd:
            if (r2 == 0) goto L_0x0302
            r3 = 0
        L_0x02d0:
            int r4 = r0.size()     // Catch:{ all -> 0x0533 }
            if (r3 >= r4) goto L_0x0302
            java.lang.Object r4 = r0.get(r3)     // Catch:{ all -> 0x0533 }
            android.util.Pair r4 = (android.util.Pair) r4     // Catch:{ all -> 0x0533 }
            java.lang.Object r4 = r4.first     // Catch:{ all -> 0x0533 }
            com.google.android.gms.internal.measurement.zzgd r4 = (com.google.android.gms.internal.measurement.zzgd) r4     // Catch:{ all -> 0x0533 }
            java.lang.String r5 = r4.zzK()     // Catch:{ all -> 0x0533 }
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0533 }
            if (r5 == 0) goto L_0x02eb
            goto L_0x02ff
        L_0x02eb:
            java.lang.String r4 = r4.zzK()     // Catch:{ all -> 0x0533 }
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0533 }
            if (r4 != 0) goto L_0x02ff
            r4 = 0
            java.util.List r0 = r0.subList(r4, r3)     // Catch:{ all -> 0x02fb }
            goto L_0x0302
        L_0x02fb:
            r0 = move-exception
            r2 = r4
            goto L_0x0538
        L_0x02ff:
            int r3 = r3 + 1
            goto L_0x02d0
        L_0x0302:
            com.google.android.gms.internal.measurement.zzga r2 = com.google.android.gms.internal.measurement.zzgb.zza()     // Catch:{ all -> 0x0533 }
            int r3 = r0.size()     // Catch:{ all -> 0x0533 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0533 }
            int r5 = r0.size()     // Catch:{ all -> 0x0533 }
            r4.<init>(r5)     // Catch:{ all -> 0x0533 }
            com.google.android.gms.measurement.internal.g r5 = r22.U()     // Catch:{ all -> 0x0533 }
            boolean r5 = r5.C(r6)     // Catch:{ all -> 0x0533 }
            if (r5 == 0) goto L_0x032b
            we.o r5 = r1.c0(r6)     // Catch:{ all -> 0x0533 }
            com.google.android.gms.measurement.internal.zzha r7 = com.google.android.gms.measurement.internal.zzha.AD_STORAGE     // Catch:{ all -> 0x0533 }
            boolean r5 = r5.j(r7)     // Catch:{ all -> 0x0533 }
            if (r5 == 0) goto L_0x032b
            r5 = 1
            goto L_0x032c
        L_0x032b:
            r5 = 0
        L_0x032c:
            we.o r7 = r1.c0(r6)     // Catch:{ all -> 0x0533 }
            com.google.android.gms.measurement.internal.zzha r8 = com.google.android.gms.measurement.internal.zzha.AD_STORAGE     // Catch:{ all -> 0x0533 }
            boolean r7 = r7.j(r8)     // Catch:{ all -> 0x0533 }
            we.o r8 = r1.c0(r6)     // Catch:{ all -> 0x0533 }
            com.google.android.gms.measurement.internal.zzha r9 = com.google.android.gms.measurement.internal.zzha.ANALYTICS_STORAGE     // Catch:{ all -> 0x0533 }
            boolean r8 = r8.j(r9)     // Catch:{ all -> 0x0533 }
            com.google.android.gms.internal.measurement.zzqu.zzc()     // Catch:{ all -> 0x0533 }
            com.google.android.gms.measurement.internal.g r9 = r22.U()     // Catch:{ all -> 0x0533 }
            com.google.android.gms.measurement.internal.f3 r10 = com.google.android.gms.measurement.internal.g3.f39838q0     // Catch:{ all -> 0x0533 }
            boolean r9 = r9.B(r6, r10)     // Catch:{ all -> 0x0533 }
            r10 = 0
        L_0x034e:
            if (r10 >= r3) goto L_0x03d0
            java.lang.Object r11 = r0.get(r10)     // Catch:{ all -> 0x0533 }
            android.util.Pair r11 = (android.util.Pair) r11     // Catch:{ all -> 0x0533 }
            java.lang.Object r11 = r11.first     // Catch:{ all -> 0x0533 }
            com.google.android.gms.internal.measurement.zzgd r11 = (com.google.android.gms.internal.measurement.zzgd) r11     // Catch:{ all -> 0x0533 }
            com.google.android.gms.internal.measurement.zzkx r11 = r11.zzbB()     // Catch:{ all -> 0x0533 }
            com.google.android.gms.internal.measurement.zzgc r11 = (com.google.android.gms.internal.measurement.zzgc) r11     // Catch:{ all -> 0x0533 }
            java.lang.Object r12 = r0.get(r10)     // Catch:{ all -> 0x0533 }
            android.util.Pair r12 = (android.util.Pair) r12     // Catch:{ all -> 0x0533 }
            java.lang.Object r12 = r12.second     // Catch:{ all -> 0x0533 }
            java.lang.Long r12 = (java.lang.Long) r12     // Catch:{ all -> 0x0533 }
            r4.add(r12)     // Catch:{ all -> 0x0533 }
            com.google.android.gms.measurement.internal.g r12 = r22.U()     // Catch:{ all -> 0x0533 }
            r12.q()     // Catch:{ all -> 0x0533 }
            r12 = 79000(0x13498, double:3.9031E-319)
            r11.zzam(r12)     // Catch:{ all -> 0x0533 }
            r12 = r20
            r11.zzal(r12)     // Catch:{ all -> 0x0533 }
            com.google.android.gms.measurement.internal.u4 r14 = r1.f40076l     // Catch:{ all -> 0x0533 }
            r14.b()     // Catch:{ all -> 0x0533 }
            r14 = 0
            r11.zzag(r14)     // Catch:{ all -> 0x03cc }
            if (r5 != 0) goto L_0x038d
            r11.zzq()     // Catch:{ all -> 0x0533 }
        L_0x038d:
            if (r7 != 0) goto L_0x0395
            r11.zzx()     // Catch:{ all -> 0x0533 }
            r11.zzt()     // Catch:{ all -> 0x0533 }
        L_0x0395:
            if (r8 != 0) goto L_0x039a
            r11.zzn()     // Catch:{ all -> 0x0533 }
        L_0x039a:
            r1.h(r6, r11)     // Catch:{ all -> 0x0533 }
            if (r9 != 0) goto L_0x03a2
            r11.zzy()     // Catch:{ all -> 0x0533 }
        L_0x03a2:
            com.google.android.gms.measurement.internal.g r14 = r22.U()     // Catch:{ all -> 0x0533 }
            com.google.android.gms.measurement.internal.f3 r15 = com.google.android.gms.measurement.internal.g3.X     // Catch:{ all -> 0x0533 }
            boolean r14 = r14.B(r6, r15)     // Catch:{ all -> 0x0533 }
            if (r14 == 0) goto L_0x03c4
            com.google.android.gms.internal.measurement.zzlb r14 = r11.zzaD()     // Catch:{ all -> 0x0533 }
            com.google.android.gms.internal.measurement.zzgd r14 = (com.google.android.gms.internal.measurement.zzgd) r14     // Catch:{ all -> 0x0533 }
            byte[] r14 = r14.zzbx()     // Catch:{ all -> 0x0533 }
            com.google.android.gms.measurement.internal.p9 r15 = r1.f40071g     // Catch:{ all -> 0x0533 }
            R(r15)     // Catch:{ all -> 0x0533 }
            long r14 = r15.z(r14)     // Catch:{ all -> 0x0533 }
            r11.zzJ(r14)     // Catch:{ all -> 0x0533 }
        L_0x03c4:
            r2.zza(r11)     // Catch:{ all -> 0x0533 }
            int r10 = r10 + 1
            r20 = r12
            goto L_0x034e
        L_0x03cc:
            r0 = move-exception
            r2 = r14
            goto L_0x0538
        L_0x03d0:
            r12 = r20
            com.google.android.gms.measurement.internal.q3 r0 = r22.d()     // Catch:{ all -> 0x0533 }
            java.lang.String r0 = r0.D()     // Catch:{ all -> 0x0533 }
            r5 = 2
            boolean r0 = android.util.Log.isLoggable(r0, r5)     // Catch:{ all -> 0x0533 }
            if (r0 == 0) goto L_0x03f1
            com.google.android.gms.measurement.internal.p9 r0 = r1.f40071g     // Catch:{ all -> 0x0533 }
            R(r0)     // Catch:{ all -> 0x0533 }
            com.google.android.gms.internal.measurement.zzlb r5 = r2.zzaD()     // Catch:{ all -> 0x0533 }
            com.google.android.gms.internal.measurement.zzgb r5 = (com.google.android.gms.internal.measurement.zzgb) r5     // Catch:{ all -> 0x0533 }
            java.lang.String r9 = r0.F(r5)     // Catch:{ all -> 0x0533 }
            goto L_0x03f2
        L_0x03f1:
            r9 = 0
        L_0x03f2:
            com.google.android.gms.measurement.internal.p9 r0 = r1.f40071g     // Catch:{ all -> 0x0533 }
            R(r0)     // Catch:{ all -> 0x0533 }
            com.google.android.gms.internal.measurement.zzlb r0 = r2.zzaD()     // Catch:{ all -> 0x0533 }
            com.google.android.gms.internal.measurement.zzgb r0 = (com.google.android.gms.internal.measurement.zzgb) r0     // Catch:{ all -> 0x0533 }
            byte[] r14 = r0.zzbx()     // Catch:{ all -> 0x0533 }
            com.google.android.gms.measurement.internal.d9 r0 = r1.f40074j     // Catch:{ all -> 0x0533 }
            com.google.android.gms.measurement.internal.c9 r0 = r0.i(r6)     // Catch:{ all -> 0x0533 }
            boolean r5 = r4.isEmpty()     // Catch:{ MalformedURLException -> 0x048c }
            r7 = 1
            r5 = r5 ^ r7
            com.google.android.gms.common.internal.p.a(r5)     // Catch:{ MalformedURLException -> 0x048c }
            java.util.List r5 = r1.f40088x     // Catch:{ MalformedURLException -> 0x048c }
            if (r5 == 0) goto L_0x0422
            com.google.android.gms.measurement.internal.q3 r4 = r22.d()     // Catch:{ MalformedURLException -> 0x048c }
            com.google.android.gms.measurement.internal.o3 r4 = r4.r()     // Catch:{ MalformedURLException -> 0x048c }
            java.lang.String r5 = "Set uploading progress before finishing the previous upload"
            r4.a(r5)     // Catch:{ MalformedURLException -> 0x048c }
            goto L_0x0429
        L_0x0422:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ MalformedURLException -> 0x048c }
            r5.<init>(r4)     // Catch:{ MalformedURLException -> 0x048c }
            r1.f40088x = r5     // Catch:{ MalformedURLException -> 0x048c }
        L_0x0429:
            com.google.android.gms.measurement.internal.j8 r4 = r1.f40073i     // Catch:{ MalformedURLException -> 0x048c }
            com.google.android.gms.measurement.internal.b4 r4 = r4.f39967h     // Catch:{ MalformedURLException -> 0x048c }
            r4.b(r12)     // Catch:{ MalformedURLException -> 0x048c }
            java.lang.String r4 = "?"
            if (r3 <= 0) goto L_0x043d
            r3 = 0
            com.google.android.gms.internal.measurement.zzgd r2 = r2.zzb(r3)     // Catch:{  }
            java.lang.String r4 = r2.zzy()     // Catch:{ MalformedURLException -> 0x048c }
        L_0x043d:
            com.google.android.gms.measurement.internal.q3 r2 = r22.d()     // Catch:{ MalformedURLException -> 0x048c }
            com.google.android.gms.measurement.internal.o3 r2 = r2.v()     // Catch:{ MalformedURLException -> 0x048c }
            java.lang.String r3 = "Uploading data. app, uncompressed size, data"
            int r5 = r14.length     // Catch:{ MalformedURLException -> 0x048c }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ MalformedURLException -> 0x048c }
            r2.d(r3, r4, r5, r9)     // Catch:{ MalformedURLException -> 0x048c }
            r2 = 1
            r1.f40084t = r2     // Catch:{ MalformedURLException -> 0x048c }
            com.google.android.gms.measurement.internal.v3 r11 = r1.f40066b     // Catch:{ MalformedURLException -> 0x048c }
            R(r11)     // Catch:{ MalformedURLException -> 0x048c }
            java.net.URL r13 = new java.net.URL     // Catch:{ MalformedURLException -> 0x048c }
            java.lang.String r2 = r0.a()     // Catch:{ MalformedURLException -> 0x048c }
            r13.<init>(r2)     // Catch:{ MalformedURLException -> 0x048c }
            java.util.Map r15 = r0.b()     // Catch:{ MalformedURLException -> 0x048c }
            com.google.android.gms.measurement.internal.f9 r2 = new com.google.android.gms.measurement.internal.f9     // Catch:{ MalformedURLException -> 0x048c }
            r2.<init>(r1, r6)     // Catch:{ MalformedURLException -> 0x048c }
            r11.h()     // Catch:{ MalformedURLException -> 0x048c }
            r11.i()     // Catch:{ MalformedURLException -> 0x048c }
            com.google.android.gms.common.internal.p.k(r13)     // Catch:{ MalformedURLException -> 0x048c }
            com.google.android.gms.common.internal.p.k(r14)     // Catch:{ MalformedURLException -> 0x048c }
            com.google.android.gms.common.internal.p.k(r2)     // Catch:{ MalformedURLException -> 0x048c }
            com.google.android.gms.measurement.internal.u4 r3 = r11.f40059a     // Catch:{ MalformedURLException -> 0x048c }
            com.google.android.gms.measurement.internal.s4 r3 = r3.f()     // Catch:{ MalformedURLException -> 0x048c }
            com.google.android.gms.measurement.internal.u3 r4 = new com.google.android.gms.measurement.internal.u3     // Catch:{ MalformedURLException -> 0x048c }
            r10 = r4
            r12 = r6
            r16 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16)     // Catch:{ MalformedURLException -> 0x048c }
            r3.y(r4)     // Catch:{ MalformedURLException -> 0x048c }
            goto L_0x0526
        L_0x048c:
            com.google.android.gms.measurement.internal.q3 r2 = r22.d()     // Catch:{ all -> 0x0533 }
            com.google.android.gms.measurement.internal.o3 r2 = r2.r()     // Catch:{ all -> 0x0533 }
            java.lang.String r3 = "Failed to parse upload URL. Not uploading. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.q3.z(r6)     // Catch:{ all -> 0x0533 }
            java.lang.String r0 = r0.a()     // Catch:{ all -> 0x0533 }
            r2.c(r3, r4, r0)     // Catch:{ all -> 0x0533 }
            goto L_0x0526
        L_0x04a3:
            r0 = move-exception
            r9 = r11
        L_0x04a5:
            if (r9 == 0) goto L_0x04aa
            r9.close()     // Catch:{ all -> 0x0533 }
        L_0x04aa:
            throw r0     // Catch:{ all -> 0x0533 }
        L_0x04ab:
            r12 = r4
            r1.f40090z = r7     // Catch:{ all -> 0x0533 }
            com.google.android.gms.measurement.internal.k r2 = r1.f40067c     // Catch:{ all -> 0x0533 }
            R(r2)     // Catch:{ all -> 0x0533 }
            r22.U()     // Catch:{ all -> 0x0533 }
            long r3 = com.google.android.gms.measurement.internal.g.I()     // Catch:{ all -> 0x0533 }
            long r4 = r12 - r3
            r2.h()     // Catch:{ all -> 0x0533 }
            r2.i()     // Catch:{ all -> 0x0533 }
            android.database.sqlite.SQLiteDatabase r0 = r2.P()     // Catch:{ SQLiteException -> 0x04fd, all -> 0x04fa }
            java.lang.String r3 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r6 = 1
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x04fd, all -> 0x04fa }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ SQLiteException -> 0x04fd, all -> 0x04fa }
            r5 = 0
            r6[r5] = r4     // Catch:{ SQLiteException -> 0x04fd, all -> 0x04fa }
            android.database.Cursor r3 = r0.rawQuery(r3, r6)     // Catch:{ SQLiteException -> 0x04fd, all -> 0x04fa }
            boolean r0 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x04f8 }
            if (r0 != 0) goto L_0x04ef
            com.google.android.gms.measurement.internal.u4 r0 = r2.f40059a     // Catch:{ SQLiteException -> 0x04f8 }
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()     // Catch:{ SQLiteException -> 0x04f8 }
            com.google.android.gms.measurement.internal.o3 r0 = r0.v()     // Catch:{ SQLiteException -> 0x04f8 }
            java.lang.String r4 = "No expired configs for apps with pending events"
            r0.a(r4)     // Catch:{ SQLiteException -> 0x04f8 }
        L_0x04eb:
            r3.close()     // Catch:{ all -> 0x0533 }
            goto L_0x0511
        L_0x04ef:
            r4 = 0
            java.lang.String r9 = r3.getString(r4)     // Catch:{ SQLiteException -> 0x04f8 }
            r3.close()     // Catch:{ all -> 0x0533 }
            goto L_0x0512
        L_0x04f8:
            r0 = move-exception
            goto L_0x04ff
        L_0x04fa:
            r0 = move-exception
            r9 = 0
            goto L_0x052d
        L_0x04fd:
            r0 = move-exception
            r3 = 0
        L_0x04ff:
            com.google.android.gms.measurement.internal.u4 r2 = r2.f40059a     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.q3 r2 = r2.d()     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.o3 r2 = r2.r()     // Catch:{ all -> 0x052b }
            java.lang.String r4 = "Error selecting expired configs"
            r2.b(r4, r0)     // Catch:{ all -> 0x052b }
            if (r3 == 0) goto L_0x0511
            goto L_0x04eb
        L_0x0511:
            r9 = 0
        L_0x0512:
            boolean r0 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0533 }
            if (r0 != 0) goto L_0x0526
            com.google.android.gms.measurement.internal.k r0 = r1.f40067c     // Catch:{ all -> 0x0533 }
            R(r0)     // Catch:{ all -> 0x0533 }
            com.google.android.gms.measurement.internal.q5 r0 = r0.R(r9)     // Catch:{ all -> 0x0533 }
            if (r0 == 0) goto L_0x0526
            r1.i(r0)     // Catch:{ all -> 0x0533 }
        L_0x0526:
            r2 = 0
            r1.f40085u = r2
            goto L_0x0030
        L_0x052b:
            r0 = move-exception
            r9 = r3
        L_0x052d:
            if (r9 == 0) goto L_0x0532
            r9.close()     // Catch:{ all -> 0x0533 }
        L_0x0532:
            throw r0     // Catch:{ all -> 0x0533 }
        L_0x0533:
            r0 = move-exception
            r2 = 0
            goto L_0x0538
        L_0x0536:
            r0 = move-exception
            r2 = r3
        L_0x0538:
            r1.f40085u = r2
            r22.K()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.n9.C():void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x07d1, code lost:
        if (r14.isEmpty() != false) goto L_0x07d3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x033f A[Catch:{ NumberFormatException -> 0x07bb, all -> 0x0b51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0382 A[Catch:{ NumberFormatException -> 0x07bb, all -> 0x0b51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0385 A[Catch:{ NumberFormatException -> 0x07bb, all -> 0x0b51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x03e4 A[Catch:{ NumberFormatException -> 0x07bb, all -> 0x0b51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0412  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0573 A[Catch:{ NumberFormatException -> 0x07bb, all -> 0x0b51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x05b3 A[Catch:{ NumberFormatException -> 0x07bb, all -> 0x0b51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x062c A[Catch:{ NumberFormatException -> 0x07bb, all -> 0x0b51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0677 A[Catch:{ NumberFormatException -> 0x07bb, all -> 0x0b51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x0684 A[Catch:{ NumberFormatException -> 0x07bb, all -> 0x0b51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0691 A[Catch:{ NumberFormatException -> 0x07bb, all -> 0x0b51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x06c9 A[Catch:{ NumberFormatException -> 0x07bb, all -> 0x0b51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x06da A[Catch:{ NumberFormatException -> 0x07bb, all -> 0x0b51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x071d A[Catch:{ NumberFormatException -> 0x07bb, all -> 0x0b51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x0744 A[Catch:{ NumberFormatException -> 0x07bb, all -> 0x0b51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x0749 A[Catch:{ NumberFormatException -> 0x07bb, all -> 0x0b51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x074f A[Catch:{ NumberFormatException -> 0x07bb, all -> 0x0b51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x07d6 A[Catch:{ NumberFormatException -> 0x07bb, all -> 0x0b51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x081c A[Catch:{ NumberFormatException -> 0x07bb, all -> 0x0b51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x086b A[Catch:{ NumberFormatException -> 0x07bb, all -> 0x0b51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x0878 A[Catch:{ NumberFormatException -> 0x07bb, all -> 0x0b51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x0891 A[Catch:{ NumberFormatException -> 0x07bb, all -> 0x0b51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x091d A[Catch:{ NumberFormatException -> 0x07bb, all -> 0x0b51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:280:0x093d A[Catch:{ NumberFormatException -> 0x07bb, all -> 0x0b51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x0a0b A[Catch:{ NumberFormatException -> 0x07bb, all -> 0x0b51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x0aba A[Catch:{ SQLiteException -> 0x0ad5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x0ad0  */
    /* JADX WARNING: Removed duplicated region for block: B:355:0x0a1d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01ce A[Catch:{ NumberFormatException -> 0x07bb, all -> 0x0b51 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01e7 A[SYNTHETIC, Splitter:B:55:0x01e7] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x024b A[SYNTHETIC, Splitter:B:69:0x024b] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x025b A[Catch:{ NumberFormatException -> 0x07bb, all -> 0x0b51 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void D(com.google.android.gms.measurement.internal.zzau r36, com.google.android.gms.measurement.internal.zzq r37) {
        /*
            r35 = this;
            r1 = r35
            r2 = r36
            r3 = r37
            java.lang.String r4 = "metadata_fingerprint"
            java.lang.String r5 = "app_id"
            java.lang.String r6 = "raw_events"
            java.lang.String r7 = "_sno"
            com.google.android.gms.common.internal.p.k(r37)
            java.lang.String r8 = r3.f40506a
            com.google.android.gms.common.internal.p.g(r8)
            long r8 = java.lang.System.nanoTime()
            com.google.android.gms.measurement.internal.s4 r10 = r35.f()
            r10.h()
            r35.g()
            java.lang.String r10 = r3.f40506a
            com.google.android.gms.measurement.internal.p9 r11 = r1.f40071g
            R(r11)
            boolean r11 = com.google.android.gms.measurement.internal.p9.n(r36, r37)
            if (r11 != 0) goto L_0x0032
            return
        L_0x0032:
            boolean r11 = r3.f40513h
            if (r11 == 0) goto L_0x0b5c
            com.google.android.gms.measurement.internal.o4 r11 = r1.f40065a
            R(r11)
            java.lang.String r12 = r2.f40491a
            boolean r11 = r11.F(r10, r12)
            java.lang.String r15 = "_err"
            r14 = 0
            if (r11 == 0) goto L_0x00df
            com.google.android.gms.measurement.internal.q3 r3 = r35.d()
            com.google.android.gms.measurement.internal.o3 r3 = r3.w()
            java.lang.Object r4 = com.google.android.gms.measurement.internal.q3.z(r10)
            com.google.android.gms.measurement.internal.u4 r5 = r1.f40076l
            com.google.android.gms.measurement.internal.l3 r5 = r5.D()
            java.lang.String r6 = r2.f40491a
            java.lang.String r5 = r5.d(r6)
            java.lang.String r6 = "Dropping blocked event. appId"
            r3.c(r6, r4, r5)
            com.google.android.gms.measurement.internal.o4 r3 = r1.f40065a
            R(r3)
            boolean r3 = r3.D(r10)
            if (r3 != 0) goto L_0x0097
            com.google.android.gms.measurement.internal.o4 r3 = r1.f40065a
            R(r3)
            boolean r3 = r3.G(r10)
            if (r3 == 0) goto L_0x007a
            goto L_0x0097
        L_0x007a:
            java.lang.String r3 = r2.f40491a
            boolean r3 = r15.equals(r3)
            if (r3 != 0) goto L_0x00de
            com.google.android.gms.measurement.internal.t9 r11 = r35.h0()
            com.google.android.gms.measurement.internal.s9 r12 = r1.E
            java.lang.String r2 = r2.f40491a
            r14 = 11
            r17 = 0
            java.lang.String r15 = "_ev"
            r13 = r10
            r16 = r2
            r11.C(r12, r13, r14, r15, r16, r17)
            return
        L_0x0097:
            com.google.android.gms.measurement.internal.k r2 = r1.f40067c
            R(r2)
            com.google.android.gms.measurement.internal.q5 r2 = r2.R(r10)
            if (r2 == 0) goto L_0x00de
            long r3 = r2.b0()
            long r5 = r2.S()
            long r3 = java.lang.Math.max(r3, r5)
            me.f r5 = r35.a()
            long r5 = r5.currentTimeMillis()
            long r5 = r5 - r3
            long r3 = java.lang.Math.abs(r5)
            r35.U()
            com.google.android.gms.measurement.internal.f3 r5 = com.google.android.gms.measurement.internal.g3.B
            java.lang.Object r5 = r5.a(r14)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x00de
            com.google.android.gms.measurement.internal.q3 r3 = r35.d()
            com.google.android.gms.measurement.internal.o3 r3 = r3.q()
            java.lang.String r4 = "Fetching config for blocked app"
            r3.a(r4)
            r1.i(r2)
        L_0x00de:
            return
        L_0x00df:
            com.google.android.gms.measurement.internal.r3 r2 = com.google.android.gms.measurement.internal.r3.b(r36)
            com.google.android.gms.measurement.internal.t9 r11 = r35.h0()
            com.google.android.gms.measurement.internal.g r12 = r35.U()
            int r12 = r12.n(r10)
            r11.B(r2, r12)
            com.google.android.gms.internal.measurement.zzpq.zzc()
            com.google.android.gms.measurement.internal.g r11 = r35.U()
            com.google.android.gms.measurement.internal.f3 r12 = com.google.android.gms.measurement.internal.g3.C0
            boolean r11 = r11.B(r14, r12)
            if (r11 == 0) goto L_0x0110
            com.google.android.gms.measurement.internal.g r11 = r35.U()
            com.google.android.gms.measurement.internal.f3 r12 = com.google.android.gms.measurement.internal.g3.S
            r13 = 10
            r14 = 35
            int r11 = r11.p(r10, r12, r13, r14)
            goto L_0x0111
        L_0x0110:
            r11 = 0
        L_0x0111:
            java.util.TreeSet r12 = new java.util.TreeSet
            android.os.Bundle r13 = r2.f40216d
            java.util.Set r13 = r13.keySet()
            r12.<init>(r13)
            java.util.Iterator r12 = r12.iterator()
        L_0x0120:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x015c
            java.lang.Object r13 = r12.next()
            java.lang.String r13 = (java.lang.String) r13
            java.lang.String r14 = "items"
            boolean r14 = r14.equals(r13)
            if (r14 == 0) goto L_0x0120
            com.google.android.gms.measurement.internal.t9 r14 = r35.h0()
            r17 = r12
            android.os.Bundle r12 = r2.f40216d
            android.os.Parcelable[] r12 = r12.getParcelableArray(r13)
            com.google.android.gms.internal.measurement.zzpq.zzc()
            com.google.android.gms.measurement.internal.g r13 = r35.U()
            r18 = r15
            com.google.android.gms.measurement.internal.f3 r15 = com.google.android.gms.measurement.internal.g3.C0
            r28 = r8
            r8 = 0
            boolean r9 = r13.B(r8, r15)
            r14.A(r12, r11, r9)
            r12 = r17
            r15 = r18
            r8 = r28
            goto L_0x0120
        L_0x015c:
            r28 = r8
            r18 = r15
            com.google.android.gms.measurement.internal.zzau r2 = r2.a()
            com.google.android.gms.measurement.internal.q3 r8 = r35.d()
            java.lang.String r8 = r8.D()
            r9 = 2
            boolean r8 = android.util.Log.isLoggable(r8, r9)
            if (r8 == 0) goto L_0x018a
            com.google.android.gms.measurement.internal.q3 r8 = r35.d()
            com.google.android.gms.measurement.internal.o3 r8 = r8.v()
            com.google.android.gms.measurement.internal.u4 r11 = r1.f40076l
            com.google.android.gms.measurement.internal.l3 r11 = r11.D()
            java.lang.String r11 = r11.c(r2)
            java.lang.String r12 = "Logging event"
            r8.b(r12, r11)
        L_0x018a:
            com.google.android.gms.internal.measurement.zzpn.zzc()
            com.google.android.gms.measurement.internal.g r8 = r35.U()
            com.google.android.gms.measurement.internal.f3 r11 = com.google.android.gms.measurement.internal.g3.f39856z0
            r14 = 0
            r8.B(r14, r11)
            com.google.android.gms.measurement.internal.k r8 = r1.f40067c
            R(r8)
            r8.e0()
            r1.S(r3)     // Catch:{ all -> 0x0b51 }
            java.lang.String r8 = "ecommerce_purchase"
            java.lang.String r11 = r2.f40491a     // Catch:{ all -> 0x0b51 }
            boolean r8 = r8.equals(r11)     // Catch:{ all -> 0x0b51 }
            java.lang.String r11 = "refund"
            if (r8 != 0) goto L_0x01c3
            java.lang.String r8 = "purchase"
            java.lang.String r12 = r2.f40491a     // Catch:{ all -> 0x0b51 }
            boolean r8 = r8.equals(r12)     // Catch:{ all -> 0x0b51 }
            if (r8 != 0) goto L_0x01c3
            java.lang.String r8 = r2.f40491a     // Catch:{ all -> 0x0b51 }
            boolean r8 = r11.equals(r8)     // Catch:{ all -> 0x0b51 }
            if (r8 == 0) goto L_0x01c1
            goto L_0x01c3
        L_0x01c1:
            r8 = 0
            goto L_0x01c4
        L_0x01c3:
            r8 = 1
        L_0x01c4:
            java.lang.String r12 = "_iap"
            java.lang.String r13 = r2.f40491a     // Catch:{ all -> 0x0b51 }
            boolean r12 = r12.equals(r13)     // Catch:{ all -> 0x0b51 }
            if (r12 != 0) goto L_0x01db
            if (r8 == 0) goto L_0x01d2
            r8 = 1
            goto L_0x01db
        L_0x01d2:
            r32 = r4
            r33 = r5
            r4 = r18
            r5 = 1
            goto L_0x036f
        L_0x01db:
            com.google.android.gms.measurement.internal.zzas r12 = r2.f40492b     // Catch:{ all -> 0x0b51 }
            java.lang.String r13 = "currency"
            java.lang.String r12 = r12.m0(r13)     // Catch:{ all -> 0x0b51 }
            java.lang.String r13 = "value"
            if (r8 == 0) goto L_0x024b
            com.google.android.gms.measurement.internal.zzas r8 = r2.f40492b     // Catch:{ all -> 0x0b51 }
            java.lang.Double r8 = r8.c0(r13)     // Catch:{ all -> 0x0b51 }
            double r16 = r8.doubleValue()     // Catch:{ all -> 0x0b51 }
            r19 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r16 = r16 * r19
            r21 = 0
            int r8 = (r16 > r21 ? 1 : (r16 == r21 ? 0 : -1))
            if (r8 != 0) goto L_0x020b
            com.google.android.gms.measurement.internal.zzas r8 = r2.f40492b     // Catch:{ all -> 0x0b51 }
            java.lang.Long r8 = r8.f0(r13)     // Catch:{ all -> 0x0b51 }
            long r14 = r8.longValue()     // Catch:{ all -> 0x0b51 }
            double r13 = (double) r14     // Catch:{ all -> 0x0b51 }
            double r16 = r13 * r19
        L_0x020b:
            r13 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r8 = (r16 > r13 ? 1 : (r16 == r13 ? 0 : -1))
            if (r8 > 0) goto L_0x0225
            r13 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r8 = (r16 > r13 ? 1 : (r16 == r13 ? 0 : -1))
            if (r8 < 0) goto L_0x0225
            long r13 = java.lang.Math.round(r16)     // Catch:{ all -> 0x0b51 }
            java.lang.String r8 = r2.f40491a     // Catch:{ all -> 0x0b51 }
            boolean r8 = r11.equals(r8)     // Catch:{ all -> 0x0b51 }
            if (r8 == 0) goto L_0x0255
            long r13 = -r13
            goto L_0x0255
        L_0x0225:
            com.google.android.gms.measurement.internal.q3 r2 = r35.d()     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.o3 r2 = r2.w()     // Catch:{ all -> 0x0b51 }
            java.lang.String r3 = "Data lost. Currency value is too big. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.q3.z(r10)     // Catch:{ all -> 0x0b51 }
            java.lang.Double r5 = java.lang.Double.valueOf(r16)     // Catch:{ all -> 0x0b51 }
            r2.c(r3, r4, r5)     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.k r2 = r1.f40067c     // Catch:{ all -> 0x0b51 }
            R(r2)     // Catch:{ all -> 0x0b51 }
            r2.o()     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.k r2 = r1.f40067c
            R(r2)
            r2.f0()
            return
        L_0x024b:
            com.google.android.gms.measurement.internal.zzas r8 = r2.f40492b     // Catch:{ all -> 0x0b51 }
            java.lang.Long r8 = r8.f0(r13)     // Catch:{ all -> 0x0b51 }
            long r13 = r8.longValue()     // Catch:{ all -> 0x0b51 }
        L_0x0255:
            boolean r8 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0b51 }
            if (r8 != 0) goto L_0x01d2
            java.util.Locale r8 = java.util.Locale.US     // Catch:{ all -> 0x0b51 }
            java.lang.String r8 = r12.toUpperCase(r8)     // Catch:{ all -> 0x0b51 }
            java.lang.String r11 = "[A-Z]{3}"
            boolean r11 = r8.matches(r11)     // Catch:{ all -> 0x0b51 }
            if (r11 == 0) goto L_0x01d2
            java.lang.String r11 = "_ltv_"
            java.lang.String r8 = r11.concat(r8)     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.k r11 = r1.f40067c     // Catch:{ all -> 0x0b51 }
            R(r11)     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.r9 r11 = r11.X(r10, r8)     // Catch:{ all -> 0x0b51 }
            if (r11 == 0) goto L_0x02b3
            java.lang.Object r11 = r11.f40235e     // Catch:{ all -> 0x0b51 }
            boolean r12 = r11 instanceof java.lang.Long     // Catch:{ all -> 0x0b51 }
            if (r12 != 0) goto L_0x0281
            goto L_0x02b3
        L_0x0281:
            java.lang.Long r11 = (java.lang.Long) r11     // Catch:{ all -> 0x0b51 }
            long r11 = r11.longValue()     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.r9 r19 = new com.google.android.gms.measurement.internal.r9     // Catch:{ all -> 0x0b51 }
            java.lang.String r15 = r2.f40493c     // Catch:{ all -> 0x0b51 }
            me.f r16 = r35.a()     // Catch:{ all -> 0x0b51 }
            long r16 = r16.currentTimeMillis()     // Catch:{ all -> 0x0b51 }
            long r11 = r11 + r13
            java.lang.Long r20 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0b51 }
            r11 = r19
            r12 = r10
            r14 = 0
            r13 = r15
            r9 = r14
            r15 = 0
            r14 = r8
            r8 = r18
            r15 = r16
            r17 = r20
            r11.<init>(r12, r13, r14, r15, r17)     // Catch:{ all -> 0x0b51 }
            r32 = r4
            r33 = r5
            r4 = r8
            r8 = r19
            r5 = 1
            goto L_0x0334
        L_0x02b3:
            r15 = r18
            r9 = 0
            com.google.android.gms.measurement.internal.k r11 = r1.f40067c     // Catch:{ all -> 0x0b51 }
            R(r11)     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.g r12 = r35.U()     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.f3 r9 = com.google.android.gms.measurement.internal.g3.G     // Catch:{ all -> 0x0b51 }
            int r9 = r12.o(r10, r9)     // Catch:{ all -> 0x0b51 }
            int r9 = r9 + -1
            com.google.android.gms.common.internal.p.g(r10)     // Catch:{ all -> 0x0b51 }
            r11.h()     // Catch:{ all -> 0x0b51 }
            r11.i()     // Catch:{ all -> 0x0b51 }
            android.database.sqlite.SQLiteDatabase r12 = r11.P()     // Catch:{ SQLiteException -> 0x02fc }
            r18 = r15
            java.lang.String r15 = "delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);"
            r32 = r4
            r4 = 3
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x02f4 }
            r16 = 0
            r4[r16] = r10     // Catch:{ SQLiteException -> 0x02f4 }
            r33 = r5
            r5 = 1
            r4[r5] = r10     // Catch:{ SQLiteException -> 0x02f2 }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ SQLiteException -> 0x02f2 }
            r16 = 2
            r4[r16] = r9     // Catch:{ SQLiteException -> 0x02f2 }
            r12.execSQL(r15, r4)     // Catch:{ SQLiteException -> 0x02f2 }
            goto L_0x0318
        L_0x02f2:
            r0 = move-exception
            goto L_0x0304
        L_0x02f4:
            r0 = move-exception
            goto L_0x02f9
        L_0x02f6:
            r0 = move-exception
            r32 = r4
        L_0x02f9:
            r33 = r5
            goto L_0x0303
        L_0x02fc:
            r0 = move-exception
            r32 = r4
            r33 = r5
            r18 = r15
        L_0x0303:
            r5 = 1
        L_0x0304:
            r4 = r0
            com.google.android.gms.measurement.internal.u4 r9 = r11.f40059a     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.q3 r9 = r9.d()     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.o3 r9 = r9.r()     // Catch:{ all -> 0x0b51 }
            java.lang.String r11 = "Error pruning currencies. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.q3.z(r10)     // Catch:{ all -> 0x0b51 }
            r9.c(r11, r12, r4)     // Catch:{ all -> 0x0b51 }
        L_0x0318:
            com.google.android.gms.measurement.internal.r9 r19 = new com.google.android.gms.measurement.internal.r9     // Catch:{ all -> 0x0b51 }
            java.lang.String r4 = r2.f40493c     // Catch:{ all -> 0x0b51 }
            me.f r9 = r35.a()     // Catch:{ all -> 0x0b51 }
            long r15 = r9.currentTimeMillis()     // Catch:{ all -> 0x0b51 }
            java.lang.Long r17 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x0b51 }
            r11 = r19
            r12 = r10
            r13 = r4
            r14 = r8
            r4 = r18
            r11.<init>(r12, r13, r14, r15, r17)     // Catch:{ all -> 0x0b51 }
            r8 = r19
        L_0x0334:
            com.google.android.gms.measurement.internal.k r9 = r1.f40067c     // Catch:{ all -> 0x0b51 }
            R(r9)     // Catch:{ all -> 0x0b51 }
            boolean r9 = r9.x(r8)     // Catch:{ all -> 0x0b51 }
            if (r9 != 0) goto L_0x036f
            com.google.android.gms.measurement.internal.q3 r9 = r35.d()     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.o3 r9 = r9.r()     // Catch:{ all -> 0x0b51 }
            java.lang.String r11 = "Too many unique user properties are set. Ignoring user property. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.q3.z(r10)     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.u4 r13 = r1.f40076l     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.l3 r13 = r13.D()     // Catch:{ all -> 0x0b51 }
            java.lang.String r14 = r8.f40233c     // Catch:{ all -> 0x0b51 }
            java.lang.String r13 = r13.f(r14)     // Catch:{ all -> 0x0b51 }
            java.lang.Object r8 = r8.f40235e     // Catch:{ all -> 0x0b51 }
            r9.d(r11, r12, r13, r8)     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.t9 r11 = r35.h0()     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.s9 r12 = r1.E     // Catch:{ all -> 0x0b51 }
            r14 = 9
            r15 = 0
            r16 = 0
            r17 = 0
            r13 = r10
            r11.C(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0b51 }
        L_0x036f:
            java.lang.String r8 = r2.f40491a     // Catch:{ all -> 0x0b51 }
            boolean r8 = com.google.android.gms.measurement.internal.t9.Z(r8)     // Catch:{ all -> 0x0b51 }
            java.lang.String r9 = r2.f40491a     // Catch:{ all -> 0x0b51 }
            boolean r4 = r4.equals(r9)     // Catch:{ all -> 0x0b51 }
            r35.h0()     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.zzas r9 = r2.f40492b     // Catch:{ all -> 0x0b51 }
            if (r9 != 0) goto L_0x0385
            r12 = 0
            goto L_0x03a4
        L_0x0385:
            com.google.android.gms.measurement.internal.r r11 = new com.google.android.gms.measurement.internal.r     // Catch:{ all -> 0x0b51 }
            r11.<init>(r9)     // Catch:{ all -> 0x0b51 }
            r12 = 0
        L_0x038c:
            boolean r16 = r11.hasNext()     // Catch:{ all -> 0x0b51 }
            if (r16 == 0) goto L_0x03a4
            java.lang.String r14 = r11.next()     // Catch:{ all -> 0x0b51 }
            java.lang.Object r14 = r9.i0(r14)     // Catch:{ all -> 0x0b51 }
            boolean r15 = r14 instanceof android.os.Parcelable[]     // Catch:{ all -> 0x0b51 }
            if (r15 == 0) goto L_0x038c
            android.os.Parcelable[] r14 = (android.os.Parcelable[]) r14     // Catch:{ all -> 0x0b51 }
            int r14 = r14.length     // Catch:{ all -> 0x0b51 }
            long r14 = (long) r14     // Catch:{ all -> 0x0b51 }
            long r12 = r12 + r14
            goto L_0x038c
        L_0x03a4:
            com.google.android.gms.measurement.internal.k r11 = r1.f40067c     // Catch:{ all -> 0x0b51 }
            R(r11)     // Catch:{ all -> 0x0b51 }
            long r14 = r35.F()     // Catch:{ all -> 0x0b51 }
            r22 = 1
            long r18 = r12 + r22
            r9 = 1
            r20 = 0
            r21 = 0
            r12 = r14
            r30 = r6
            r5 = 0
            r14 = r10
            r15 = r18
            r17 = r9
            r18 = r8
            r19 = r20
            r20 = r4
            com.google.android.gms.measurement.internal.i r9 = r11.U(r12, r14, r15, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x0b51 }
            long r11 = r9.f39909b     // Catch:{ all -> 0x0b51 }
            r35.U()     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.f3 r13 = com.google.android.gms.measurement.internal.g3.f39829m     // Catch:{ all -> 0x0b51 }
            r15 = 0
            java.lang.Object r13 = r13.a(r15)     // Catch:{ all -> 0x0b51 }
            java.lang.Integer r13 = (java.lang.Integer) r13     // Catch:{ all -> 0x0b51 }
            int r13 = r13.intValue()     // Catch:{ all -> 0x0b51 }
            long r13 = (long) r13     // Catch:{ all -> 0x0b51 }
            long r11 = r11 - r13
            int r13 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            r16 = 1000(0x3e8, double:4.94E-321)
            if (r13 <= 0) goto L_0x0412
            long r11 = r11 % r16
            int r2 = (r11 > r22 ? 1 : (r11 == r22 ? 0 : -1))
            if (r2 != 0) goto L_0x0401
            com.google.android.gms.measurement.internal.q3 r2 = r35.d()     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.o3 r2 = r2.r()     // Catch:{ all -> 0x0b51 }
            java.lang.String r3 = "Data loss. Too many events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.q3.z(r10)     // Catch:{ all -> 0x0b51 }
            long r5 = r9.f39909b     // Catch:{ all -> 0x0b51 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0b51 }
            r2.c(r3, r4, r5)     // Catch:{ all -> 0x0b51 }
        L_0x0401:
            com.google.android.gms.measurement.internal.k r2 = r1.f40067c     // Catch:{ all -> 0x0b51 }
            R(r2)     // Catch:{ all -> 0x0b51 }
            r2.o()     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.k r2 = r1.f40067c
            R(r2)
            r2.f0()
            return
        L_0x0412:
            if (r8 == 0) goto L_0x046d
            long r11 = r9.f39908a     // Catch:{ all -> 0x0b51 }
            r35.U()     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.f3 r13 = com.google.android.gms.measurement.internal.g3.f39833o     // Catch:{ all -> 0x0b51 }
            java.lang.Object r13 = r13.a(r15)     // Catch:{ all -> 0x0b51 }
            java.lang.Integer r13 = (java.lang.Integer) r13     // Catch:{ all -> 0x0b51 }
            int r13 = r13.intValue()     // Catch:{ all -> 0x0b51 }
            long r13 = (long) r13     // Catch:{ all -> 0x0b51 }
            long r11 = r11 - r13
            int r13 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r13 <= 0) goto L_0x046d
            long r11 = r11 % r16
            int r3 = (r11 > r22 ? 1 : (r11 == r22 ? 0 : -1))
            if (r3 != 0) goto L_0x0448
            com.google.android.gms.measurement.internal.q3 r3 = r35.d()     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.o3 r3 = r3.r()     // Catch:{ all -> 0x0b51 }
            java.lang.String r4 = "Data loss. Too many public events logged. appId, count"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.q3.z(r10)     // Catch:{ all -> 0x0b51 }
            long r6 = r9.f39908a     // Catch:{ all -> 0x0b51 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0b51 }
            r3.c(r4, r5, r6)     // Catch:{ all -> 0x0b51 }
        L_0x0448:
            com.google.android.gms.measurement.internal.t9 r11 = r35.h0()     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.s9 r12 = r1.E     // Catch:{ all -> 0x0b51 }
            r14 = 16
            java.lang.String r15 = "_ev"
            java.lang.String r2 = r2.f40491a     // Catch:{ all -> 0x0b51 }
            r17 = 0
            r13 = r10
            r16 = r2
            r11.C(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.k r2 = r1.f40067c     // Catch:{ all -> 0x0b51 }
            R(r2)     // Catch:{ all -> 0x0b51 }
            r2.o()     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.k r2 = r1.f40067c
            R(r2)
            r2.f0()
            return
        L_0x046d:
            r11 = 1000000(0xf4240, float:1.401298E-39)
            if (r4 == 0) goto L_0x04bb
            long r12 = r9.f39911d     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.g r4 = r35.U()     // Catch:{ all -> 0x0b51 }
            java.lang.String r14 = r3.f40506a     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.f3 r15 = com.google.android.gms.measurement.internal.g3.f39831n     // Catch:{ all -> 0x0b51 }
            int r4 = r4.o(r14, r15)     // Catch:{ all -> 0x0b51 }
            int r4 = java.lang.Math.min(r11, r4)     // Catch:{ all -> 0x0b51 }
            r14 = 0
            int r4 = java.lang.Math.max(r14, r4)     // Catch:{ all -> 0x0b51 }
            long r14 = (long) r4     // Catch:{ all -> 0x0b51 }
            long r12 = r12 - r14
            int r4 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x04bb
            int r2 = (r12 > r22 ? 1 : (r12 == r22 ? 0 : -1))
            if (r2 != 0) goto L_0x04aa
            com.google.android.gms.measurement.internal.q3 r2 = r35.d()     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.o3 r2 = r2.r()     // Catch:{ all -> 0x0b51 }
            java.lang.String r3 = "Too many error events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.q3.z(r10)     // Catch:{ all -> 0x0b51 }
            long r5 = r9.f39911d     // Catch:{ all -> 0x0b51 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0b51 }
            r2.c(r3, r4, r5)     // Catch:{ all -> 0x0b51 }
        L_0x04aa:
            com.google.android.gms.measurement.internal.k r2 = r1.f40067c     // Catch:{ all -> 0x0b51 }
            R(r2)     // Catch:{ all -> 0x0b51 }
            r2.o()     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.k r2 = r1.f40067c
            R(r2)
            r2.f0()
            return
        L_0x04bb:
            com.google.android.gms.measurement.internal.zzas r4 = r2.f40492b     // Catch:{ all -> 0x0b51 }
            android.os.Bundle r4 = r4.Y()     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.t9 r9 = r35.h0()     // Catch:{ all -> 0x0b51 }
            java.lang.String r12 = "_o"
            java.lang.String r13 = r2.f40493c     // Catch:{ all -> 0x0b51 }
            r9.D(r4, r12, r13)     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.t9 r9 = r35.h0()     // Catch:{ all -> 0x0b51 }
            boolean r9 = r9.U(r10)     // Catch:{ all -> 0x0b51 }
            java.lang.String r15 = "_r"
            if (r9 == 0) goto L_0x04ec
            com.google.android.gms.measurement.internal.t9 r9 = r35.h0()     // Catch:{ all -> 0x0b51 }
            java.lang.String r12 = "_dbg"
            java.lang.Long r13 = java.lang.Long.valueOf(r22)     // Catch:{ all -> 0x0b51 }
            r9.D(r4, r12, r13)     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.t9 r9 = r35.h0()     // Catch:{ all -> 0x0b51 }
            r9.D(r4, r15, r13)     // Catch:{ all -> 0x0b51 }
        L_0x04ec:
            java.lang.String r9 = "_s"
            java.lang.String r12 = r2.f40491a     // Catch:{ all -> 0x0b51 }
            boolean r9 = r9.equals(r12)     // Catch:{ all -> 0x0b51 }
            if (r9 == 0) goto L_0x0512
            com.google.android.gms.measurement.internal.k r9 = r1.f40067c     // Catch:{ all -> 0x0b51 }
            R(r9)     // Catch:{ all -> 0x0b51 }
            java.lang.String r12 = r3.f40506a     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.r9 r9 = r9.X(r12, r7)     // Catch:{ all -> 0x0b51 }
            if (r9 == 0) goto L_0x0512
            java.lang.Object r12 = r9.f40235e     // Catch:{ all -> 0x0b51 }
            boolean r12 = r12 instanceof java.lang.Long     // Catch:{ all -> 0x0b51 }
            if (r12 == 0) goto L_0x0512
            com.google.android.gms.measurement.internal.t9 r12 = r35.h0()     // Catch:{ all -> 0x0b51 }
            java.lang.Object r9 = r9.f40235e     // Catch:{ all -> 0x0b51 }
            r12.D(r4, r7, r9)     // Catch:{ all -> 0x0b51 }
        L_0x0512:
            com.google.android.gms.measurement.internal.k r7 = r1.f40067c     // Catch:{ all -> 0x0b51 }
            R(r7)     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.common.internal.p.g(r10)     // Catch:{ all -> 0x0b51 }
            r7.h()     // Catch:{ all -> 0x0b51 }
            r7.i()     // Catch:{ all -> 0x0b51 }
            android.database.sqlite.SQLiteDatabase r9 = r7.P()     // Catch:{ SQLiteException -> 0x0556 }
            com.google.android.gms.measurement.internal.u4 r12 = r7.f40059a     // Catch:{ SQLiteException -> 0x0556 }
            com.google.android.gms.measurement.internal.g r12 = r12.z()     // Catch:{ SQLiteException -> 0x0556 }
            com.google.android.gms.measurement.internal.f3 r13 = com.google.android.gms.measurement.internal.g3.f39839r     // Catch:{ SQLiteException -> 0x0556 }
            int r12 = r12.o(r10, r13)     // Catch:{ SQLiteException -> 0x0556 }
            int r11 = java.lang.Math.min(r11, r12)     // Catch:{ SQLiteException -> 0x0556 }
            r14 = 0
            int r11 = java.lang.Math.max(r14, r11)     // Catch:{ SQLiteException -> 0x0552 }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ SQLiteException -> 0x0552 }
            java.lang.String r12 = "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)"
            r13 = 2
            java.lang.String[] r13 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x0552 }
            r13[r14] = r10     // Catch:{ SQLiteException -> 0x0552 }
            r17 = 1
            r13[r17] = r11     // Catch:{ SQLiteException -> 0x0552 }
            r11 = r30
            int r7 = r9.delete(r11, r12, r13)     // Catch:{ SQLiteException -> 0x0550 }
            long r12 = (long) r7
            goto L_0x056f
        L_0x0550:
            r0 = move-exception
            goto L_0x055a
        L_0x0552:
            r0 = move-exception
            r11 = r30
            goto L_0x055a
        L_0x0556:
            r0 = move-exception
            r11 = r30
            r14 = 0
        L_0x055a:
            r9 = r0
            com.google.android.gms.measurement.internal.u4 r7 = r7.f40059a     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.q3 r7 = r7.d()     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.o3 r7 = r7.r()     // Catch:{ all -> 0x0b51 }
            java.lang.String r12 = "Error deleting over the limit events. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.q3.z(r10)     // Catch:{ all -> 0x0b51 }
            r7.c(r12, r13, r9)     // Catch:{ all -> 0x0b51 }
            r12 = r5
        L_0x056f:
            int r7 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0588
            com.google.android.gms.measurement.internal.q3 r7 = r35.d()     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.o3 r7 = r7.w()     // Catch:{ all -> 0x0b51 }
            java.lang.String r9 = "Data lost. Too many events stored on disk, deleted. appId"
            java.lang.Object r14 = com.google.android.gms.measurement.internal.q3.z(r10)     // Catch:{ all -> 0x0b51 }
            java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x0b51 }
            r7.c(r9, r14, r12)     // Catch:{ all -> 0x0b51 }
        L_0x0588:
            com.google.android.gms.measurement.internal.p r7 = new com.google.android.gms.measurement.internal.p     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.u4 r12 = r1.f40076l     // Catch:{ all -> 0x0b51 }
            java.lang.String r13 = r2.f40493c     // Catch:{ all -> 0x0b51 }
            java.lang.String r9 = r2.f40491a     // Catch:{ all -> 0x0b51 }
            long r5 = r2.f40494d     // Catch:{ all -> 0x0b51 }
            r18 = 0
            r2 = r11
            r11 = r7
            r31 = 0
            r14 = r10
            r36 = r2
            r34 = r15
            r2 = 0
            r15 = r9
            r16 = r5
            r20 = r4
            r11.<init>((com.google.android.gms.measurement.internal.u4) r12, (java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15, (long) r16, (long) r18, (android.os.Bundle) r20)     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.k r4 = r1.f40067c     // Catch:{ all -> 0x0b51 }
            R(r4)     // Catch:{ all -> 0x0b51 }
            java.lang.String r5 = r7.f40123b     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.q r4 = r4.V(r10, r5)     // Catch:{ all -> 0x0b51 }
            if (r4 != 0) goto L_0x062c
            com.google.android.gms.measurement.internal.k r4 = r1.f40067c     // Catch:{ all -> 0x0b51 }
            R(r4)     // Catch:{ all -> 0x0b51 }
            long r4 = r4.O(r10)     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.g r6 = r35.U()     // Catch:{ all -> 0x0b51 }
            int r6 = r6.l(r10)     // Catch:{ all -> 0x0b51 }
            long r11 = (long) r6     // Catch:{ all -> 0x0b51 }
            int r4 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r4 < 0) goto L_0x060e
            if (r8 == 0) goto L_0x060e
            com.google.android.gms.measurement.internal.q3 r2 = r35.d()     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.o3 r2 = r2.r()     // Catch:{ all -> 0x0b51 }
            java.lang.String r3 = "Too many event names used, ignoring event. appId, name, supported count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.q3.z(r10)     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.u4 r5 = r1.f40076l     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.l3 r5 = r5.D()     // Catch:{ all -> 0x0b51 }
            java.lang.String r6 = r7.f40123b     // Catch:{ all -> 0x0b51 }
            java.lang.String r5 = r5.d(r6)     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.g r6 = r35.U()     // Catch:{ all -> 0x0b51 }
            int r6 = r6.l(r10)     // Catch:{ all -> 0x0b51 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0b51 }
            r2.d(r3, r4, r5, r6)     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.t9 r11 = r35.h0()     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.s9 r12 = r1.E     // Catch:{ all -> 0x0b51 }
            r14 = 8
            r15 = 0
            r16 = 0
            r17 = 0
            r13 = r10
            r11.C(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.k r2 = r1.f40067c
            R(r2)
            r2.f0()
            return
        L_0x060e:
            com.google.android.gms.measurement.internal.q r4 = new com.google.android.gms.measurement.internal.q     // Catch:{ all -> 0x0b51 }
            java.lang.String r13 = r7.f40123b     // Catch:{ all -> 0x0b51 }
            long r5 = r7.f40125d     // Catch:{ all -> 0x0b51 }
            r14 = 0
            r16 = 0
            r18 = 0
            r22 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r11 = r4
            r12 = r10
            r20 = r5
            r11.<init>(r12, r13, r14, r16, r18, r20, r22, r24, r25, r26, r27)     // Catch:{ all -> 0x0b51 }
            goto L_0x063a
        L_0x062c:
            com.google.android.gms.measurement.internal.u4 r5 = r1.f40076l     // Catch:{ all -> 0x0b51 }
            long r8 = r4.f40150f     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.p r7 = r7.a(r5, r8)     // Catch:{ all -> 0x0b51 }
            long r5 = r7.f40125d     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.q r4 = r4.c(r5)     // Catch:{ all -> 0x0b51 }
        L_0x063a:
            com.google.android.gms.measurement.internal.k r5 = r1.f40067c     // Catch:{ all -> 0x0b51 }
            R(r5)     // Catch:{ all -> 0x0b51 }
            r5.q(r4)     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.s4 r4 = r35.f()     // Catch:{ all -> 0x0b51 }
            r4.h()     // Catch:{ all -> 0x0b51 }
            r35.g()     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.common.internal.p.k(r7)     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.common.internal.p.k(r37)     // Catch:{ all -> 0x0b51 }
            java.lang.String r4 = r7.f40122a     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.common.internal.p.g(r4)     // Catch:{ all -> 0x0b51 }
            java.lang.String r4 = r7.f40122a     // Catch:{ all -> 0x0b51 }
            java.lang.String r5 = r3.f40506a     // Catch:{ all -> 0x0b51 }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.common.internal.p.a(r4)     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.internal.measurement.zzgc r4 = com.google.android.gms.internal.measurement.zzgd.zzu()     // Catch:{ all -> 0x0b51 }
            r5 = 1
            r4.zzad(r5)     // Catch:{ all -> 0x0b51 }
            java.lang.String r6 = "android"
            r4.zzZ(r6)     // Catch:{ all -> 0x0b51 }
            java.lang.String r6 = r3.f40506a     // Catch:{ all -> 0x0b51 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0b51 }
            if (r6 != 0) goto L_0x067c
            java.lang.String r6 = r3.f40506a     // Catch:{ all -> 0x0b51 }
            r4.zzD(r6)     // Catch:{ all -> 0x0b51 }
        L_0x067c:
            java.lang.String r6 = r3.f40509d     // Catch:{ all -> 0x0b51 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0b51 }
            if (r6 != 0) goto L_0x0689
            java.lang.String r6 = r3.f40509d     // Catch:{ all -> 0x0b51 }
            r4.zzF(r6)     // Catch:{ all -> 0x0b51 }
        L_0x0689:
            java.lang.String r6 = r3.f40508c     // Catch:{ all -> 0x0b51 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0b51 }
            if (r6 != 0) goto L_0x0696
            java.lang.String r6 = r3.f40508c     // Catch:{ all -> 0x0b51 }
            r4.zzG(r6)     // Catch:{ all -> 0x0b51 }
        L_0x0696:
            com.google.android.gms.internal.measurement.zzqu.zzc()     // Catch:{ all -> 0x0b51 }
            java.lang.String r6 = r3.E     // Catch:{ all -> 0x0b51 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0b51 }
            if (r6 != 0) goto L_0x06c0
            com.google.android.gms.measurement.internal.g r6 = r35.U()     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.f3 r8 = com.google.android.gms.measurement.internal.g3.f39834o0     // Catch:{ all -> 0x0b51 }
            boolean r6 = r6.B(r2, r8)     // Catch:{ all -> 0x0b51 }
            if (r6 != 0) goto L_0x06bb
            com.google.android.gms.measurement.internal.g r6 = r35.U()     // Catch:{ all -> 0x0b51 }
            java.lang.String r8 = r3.f40506a     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.f3 r9 = com.google.android.gms.measurement.internal.g3.f39838q0     // Catch:{ all -> 0x0b51 }
            boolean r6 = r6.B(r8, r9)     // Catch:{ all -> 0x0b51 }
            if (r6 == 0) goto L_0x06c0
        L_0x06bb:
            java.lang.String r6 = r3.E     // Catch:{ all -> 0x0b51 }
            r4.zzah(r6)     // Catch:{ all -> 0x0b51 }
        L_0x06c0:
            long r8 = r3.f40515k     // Catch:{ all -> 0x0b51 }
            r10 = -2147483648(0xffffffff80000000, double:NaN)
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x06cd
            int r6 = (int) r8     // Catch:{ all -> 0x0b51 }
            r4.zzH(r6)     // Catch:{ all -> 0x0b51 }
        L_0x06cd:
            long r8 = r3.f40510e     // Catch:{ all -> 0x0b51 }
            r4.zzV(r8)     // Catch:{ all -> 0x0b51 }
            java.lang.String r6 = r3.f40507b     // Catch:{ all -> 0x0b51 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0b51 }
            if (r6 != 0) goto L_0x06df
            java.lang.String r6 = r3.f40507b     // Catch:{ all -> 0x0b51 }
            r4.zzU(r6)     // Catch:{ all -> 0x0b51 }
        L_0x06df:
            java.lang.String r6 = r3.f40506a     // Catch:{ all -> 0x0b51 }
            java.lang.Object r6 = com.google.android.gms.common.internal.p.k(r6)     // Catch:{ all -> 0x0b51 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0b51 }
            we.o r6 = r1.c0(r6)     // Catch:{ all -> 0x0b51 }
            java.lang.String r8 = r3.C     // Catch:{ all -> 0x0b51 }
            r9 = 100
            we.o r8 = we.o.c(r8, r9)     // Catch:{ all -> 0x0b51 }
            we.o r6 = r6.d(r8)     // Catch:{ all -> 0x0b51 }
            java.lang.String r6 = r6.i()     // Catch:{ all -> 0x0b51 }
            r4.zzL(r6)     // Catch:{ all -> 0x0b51 }
            java.lang.String r6 = r4.zzar()     // Catch:{ all -> 0x0b51 }
            boolean r6 = r6.isEmpty()     // Catch:{ all -> 0x0b51 }
            if (r6 == 0) goto L_0x0715
            java.lang.String r6 = r3.f40522w     // Catch:{ all -> 0x0b51 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0b51 }
            if (r6 != 0) goto L_0x0715
            java.lang.String r6 = r3.f40522w     // Catch:{ all -> 0x0b51 }
            r4.zzC(r6)     // Catch:{ all -> 0x0b51 }
        L_0x0715:
            long r10 = r3.f40511f     // Catch:{ all -> 0x0b51 }
            r12 = 0
            int r6 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r6 == 0) goto L_0x0720
            r4.zzM(r10)     // Catch:{ all -> 0x0b51 }
        L_0x0720:
            long r10 = r3.f40524y     // Catch:{ all -> 0x0b51 }
            r4.zzP(r10)     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.p9 r6 = r1.f40071g     // Catch:{ all -> 0x0b51 }
            R(r6)     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.n9 r8 = r6.f39651b     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.u4 r8 = r8.f40076l     // Catch:{ all -> 0x0b51 }
            android.content.Context r8 = r8.c()     // Catch:{ all -> 0x0b51 }
            android.content.ContentResolver r8 = r8.getContentResolver()     // Catch:{ all -> 0x0b51 }
            java.lang.String r10 = "com.google.android.gms.measurement"
            android.net.Uri r10 = com.google.android.gms.internal.measurement.zzhq.zza(r10)     // Catch:{ all -> 0x0b51 }
            we.a r11 = we.a.f42117a     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.internal.measurement.zzhf r8 = com.google.android.gms.internal.measurement.zzhf.zza(r8, r10, r11)     // Catch:{ all -> 0x0b51 }
            if (r8 != 0) goto L_0x0749
            java.util.Map r8 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0b51 }
            goto L_0x074d
        L_0x0749:
            java.util.Map r8 = r8.zzc()     // Catch:{ all -> 0x0b51 }
        L_0x074d:
            if (r8 == 0) goto L_0x07d3
            boolean r10 = r8.isEmpty()     // Catch:{ all -> 0x0b51 }
            if (r10 == 0) goto L_0x0757
            goto L_0x07d3
        L_0x0757:
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x0b51 }
            r14.<init>()     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.f3 r10 = com.google.android.gms.measurement.internal.g3.R     // Catch:{ all -> 0x0b51 }
            java.lang.Object r10 = r10.a(r2)     // Catch:{ all -> 0x0b51 }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ all -> 0x0b51 }
            int r10 = r10.intValue()     // Catch:{ all -> 0x0b51 }
            java.util.Set r8 = r8.entrySet()     // Catch:{ all -> 0x0b51 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x0b51 }
        L_0x0770:
            boolean r11 = r8.hasNext()     // Catch:{ all -> 0x0b51 }
            if (r11 == 0) goto L_0x07cd
            java.lang.Object r11 = r8.next()     // Catch:{ all -> 0x0b51 }
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11     // Catch:{ all -> 0x0b51 }
            java.lang.Object r12 = r11.getKey()     // Catch:{ all -> 0x0b51 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0b51 }
            java.lang.String r13 = "measurement.id."
            boolean r12 = r12.startsWith(r13)     // Catch:{ all -> 0x0b51 }
            if (r12 == 0) goto L_0x0770
            java.lang.Object r11 = r11.getValue()     // Catch:{ NumberFormatException -> 0x07bb }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ NumberFormatException -> 0x07bb }
            int r11 = java.lang.Integer.parseInt(r11)     // Catch:{ NumberFormatException -> 0x07bb }
            if (r11 == 0) goto L_0x0770
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ NumberFormatException -> 0x07bb }
            r14.add(r11)     // Catch:{ NumberFormatException -> 0x07bb }
            int r11 = r14.size()     // Catch:{ NumberFormatException -> 0x07bb }
            if (r11 < r10) goto L_0x0770
            com.google.android.gms.measurement.internal.u4 r11 = r6.f40059a     // Catch:{ NumberFormatException -> 0x07bb }
            com.google.android.gms.measurement.internal.q3 r11 = r11.d()     // Catch:{ NumberFormatException -> 0x07bb }
            com.google.android.gms.measurement.internal.o3 r11 = r11.w()     // Catch:{ NumberFormatException -> 0x07bb }
            java.lang.String r12 = "Too many experiment IDs. Number of IDs"
            int r13 = r14.size()     // Catch:{ NumberFormatException -> 0x07bb }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ NumberFormatException -> 0x07bb }
            r11.b(r12, r13)     // Catch:{ NumberFormatException -> 0x07bb }
            goto L_0x07cd
        L_0x07bb:
            r0 = move-exception
            r11 = r0
            com.google.android.gms.measurement.internal.u4 r12 = r6.f40059a     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.q3 r12 = r12.d()     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.o3 r12 = r12.w()     // Catch:{ all -> 0x0b51 }
            java.lang.String r13 = "Experiment ID NumberFormatException"
            r12.b(r13, r11)     // Catch:{ all -> 0x0b51 }
            goto L_0x0770
        L_0x07cd:
            boolean r6 = r14.isEmpty()     // Catch:{ all -> 0x0b51 }
            if (r6 == 0) goto L_0x07d4
        L_0x07d3:
            r14 = r2
        L_0x07d4:
            if (r14 == 0) goto L_0x07d9
            r4.zzh(r14)     // Catch:{ all -> 0x0b51 }
        L_0x07d9:
            java.lang.String r6 = r3.f40506a     // Catch:{ all -> 0x0b51 }
            java.lang.Object r6 = com.google.android.gms.common.internal.p.k(r6)     // Catch:{ all -> 0x0b51 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0b51 }
            we.o r6 = r1.c0(r6)     // Catch:{ all -> 0x0b51 }
            java.lang.String r8 = r3.C     // Catch:{ all -> 0x0b51 }
            we.o r8 = we.o.c(r8, r9)     // Catch:{ all -> 0x0b51 }
            we.o r6 = r6.d(r8)     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.zzha r8 = com.google.android.gms.measurement.internal.zzha.AD_STORAGE     // Catch:{ all -> 0x0b51 }
            boolean r9 = r6.j(r8)     // Catch:{ all -> 0x0b51 }
            if (r9 == 0) goto L_0x0825
            boolean r9 = r3.f40520q     // Catch:{ all -> 0x0b51 }
            if (r9 == 0) goto L_0x0825
            com.google.android.gms.measurement.internal.j8 r9 = r1.f40073i     // Catch:{ all -> 0x0b51 }
            java.lang.String r10 = r3.f40506a     // Catch:{ all -> 0x0b51 }
            android.util.Pair r9 = r9.n(r10, r6)     // Catch:{ all -> 0x0b51 }
            java.lang.Object r10 = r9.first     // Catch:{ all -> 0x0b51 }
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ all -> 0x0b51 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0b51 }
            if (r10 != 0) goto L_0x0825
            boolean r10 = r3.f40520q     // Catch:{ all -> 0x0b51 }
            if (r10 == 0) goto L_0x0825
            java.lang.Object r10 = r9.first     // Catch:{ all -> 0x0b51 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0b51 }
            r4.zzae(r10)     // Catch:{ all -> 0x0b51 }
            java.lang.Object r9 = r9.second     // Catch:{ all -> 0x0b51 }
            if (r9 == 0) goto L_0x0825
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x0b51 }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0b51 }
            r4.zzX(r9)     // Catch:{ all -> 0x0b51 }
        L_0x0825:
            com.google.android.gms.measurement.internal.u4 r9 = r1.f40076l     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.o r9 = r9.A()     // Catch:{ all -> 0x0b51 }
            r9.k()     // Catch:{ all -> 0x0b51 }
            java.lang.String r9 = android.os.Build.MODEL     // Catch:{ all -> 0x0b51 }
            r4.zzN(r9)     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.u4 r9 = r1.f40076l     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.o r9 = r9.A()     // Catch:{ all -> 0x0b51 }
            r9.k()     // Catch:{ all -> 0x0b51 }
            java.lang.String r9 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x0b51 }
            r4.zzY(r9)     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.u4 r9 = r1.f40076l     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.o r9 = r9.A()     // Catch:{ all -> 0x0b51 }
            long r9 = r9.p()     // Catch:{ all -> 0x0b51 }
            int r9 = (int) r9     // Catch:{ all -> 0x0b51 }
            r4.zzak(r9)     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.u4 r9 = r1.f40076l     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.o r9 = r9.A()     // Catch:{ all -> 0x0b51 }
            java.lang.String r9 = r9.q()     // Catch:{ all -> 0x0b51 }
            r4.zzao(r9)     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.internal.measurement.zzpz.zzc()     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.g r9 = r35.U()     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.f3 r10 = com.google.android.gms.measurement.internal.g3.G0     // Catch:{ all -> 0x0b51 }
            boolean r9 = r9.B(r2, r10)     // Catch:{ all -> 0x0b51 }
            if (r9 == 0) goto L_0x0870
            long r9 = r3.G     // Catch:{ all -> 0x0b51 }
            r4.zzaj(r9)     // Catch:{ all -> 0x0b51 }
        L_0x0870:
            com.google.android.gms.measurement.internal.u4 r9 = r1.f40076l     // Catch:{ all -> 0x0b51 }
            boolean r9 = r9.o()     // Catch:{ all -> 0x0b51 }
            if (r9 == 0) goto L_0x0884
            r4.zzaq()     // Catch:{ all -> 0x0b51 }
            boolean r9 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0b51 }
            if (r9 != 0) goto L_0x0884
            r4.zzO(r2)     // Catch:{ all -> 0x0b51 }
        L_0x0884:
            com.google.android.gms.measurement.internal.k r9 = r1.f40067c     // Catch:{ all -> 0x0b51 }
            R(r9)     // Catch:{ all -> 0x0b51 }
            java.lang.String r10 = r3.f40506a     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.q5 r9 = r9.R(r10)     // Catch:{ all -> 0x0b51 }
            if (r9 != 0) goto L_0x08f4
            com.google.android.gms.measurement.internal.q5 r9 = new com.google.android.gms.measurement.internal.q5     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.u4 r10 = r1.f40076l     // Catch:{ all -> 0x0b51 }
            java.lang.String r11 = r3.f40506a     // Catch:{ all -> 0x0b51 }
            r9.<init>(r10, r11)     // Catch:{ all -> 0x0b51 }
            java.lang.String r10 = r1.i0(r6)     // Catch:{ all -> 0x0b51 }
            r9.j(r10)     // Catch:{ all -> 0x0b51 }
            java.lang.String r10 = r3.f40516l     // Catch:{ all -> 0x0b51 }
            r9.x(r10)     // Catch:{ all -> 0x0b51 }
            java.lang.String r10 = r3.f40507b     // Catch:{ all -> 0x0b51 }
            r9.y(r10)     // Catch:{ all -> 0x0b51 }
            boolean r8 = r6.j(r8)     // Catch:{ all -> 0x0b51 }
            if (r8 == 0) goto L_0x08be
            com.google.android.gms.measurement.internal.j8 r8 = r1.f40073i     // Catch:{ all -> 0x0b51 }
            java.lang.String r10 = r3.f40506a     // Catch:{ all -> 0x0b51 }
            boolean r11 = r3.f40520q     // Catch:{ all -> 0x0b51 }
            java.lang.String r8 = r8.o(r10, r11)     // Catch:{ all -> 0x0b51 }
            r9.H(r8)     // Catch:{ all -> 0x0b51 }
        L_0x08be:
            r10 = 0
            r9.D(r10)     // Catch:{ all -> 0x0b51 }
            r9.E(r10)     // Catch:{ all -> 0x0b51 }
            r9.C(r10)     // Catch:{ all -> 0x0b51 }
            java.lang.String r8 = r3.f40508c     // Catch:{ all -> 0x0b51 }
            r9.l(r8)     // Catch:{ all -> 0x0b51 }
            long r10 = r3.f40515k     // Catch:{ all -> 0x0b51 }
            r9.m(r10)     // Catch:{ all -> 0x0b51 }
            java.lang.String r8 = r3.f40509d     // Catch:{ all -> 0x0b51 }
            r9.k(r8)     // Catch:{ all -> 0x0b51 }
            long r10 = r3.f40510e     // Catch:{ all -> 0x0b51 }
            r9.z(r10)     // Catch:{ all -> 0x0b51 }
            long r10 = r3.f40511f     // Catch:{ all -> 0x0b51 }
            r9.u(r10)     // Catch:{ all -> 0x0b51 }
            boolean r8 = r3.f40513h     // Catch:{ all -> 0x0b51 }
            r9.F(r8)     // Catch:{ all -> 0x0b51 }
            long r10 = r3.f40524y     // Catch:{ all -> 0x0b51 }
            r9.v(r10)     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.k r8 = r1.f40067c     // Catch:{ all -> 0x0b51 }
            R(r8)     // Catch:{ all -> 0x0b51 }
            r8.p(r9)     // Catch:{ all -> 0x0b51 }
        L_0x08f4:
            com.google.android.gms.measurement.internal.zzha r8 = com.google.android.gms.measurement.internal.zzha.ANALYTICS_STORAGE     // Catch:{ all -> 0x0b51 }
            boolean r6 = r6.j(r8)     // Catch:{ all -> 0x0b51 }
            if (r6 == 0) goto L_0x0913
            java.lang.String r6 = r9.m0()     // Catch:{ all -> 0x0b51 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0b51 }
            if (r6 != 0) goto L_0x0913
            java.lang.String r6 = r9.m0()     // Catch:{ all -> 0x0b51 }
            java.lang.Object r6 = com.google.android.gms.common.internal.p.k(r6)     // Catch:{ all -> 0x0b51 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0b51 }
            r4.zzE(r6)     // Catch:{ all -> 0x0b51 }
        L_0x0913:
            java.lang.String r6 = r9.p0()     // Catch:{ all -> 0x0b51 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0b51 }
            if (r6 != 0) goto L_0x092a
            java.lang.String r6 = r9.p0()     // Catch:{ all -> 0x0b51 }
            java.lang.Object r6 = com.google.android.gms.common.internal.p.k(r6)     // Catch:{ all -> 0x0b51 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0b51 }
            r4.zzT(r6)     // Catch:{ all -> 0x0b51 }
        L_0x092a:
            com.google.android.gms.measurement.internal.k r6 = r1.f40067c     // Catch:{ all -> 0x0b51 }
            R(r6)     // Catch:{ all -> 0x0b51 }
            java.lang.String r8 = r3.f40506a     // Catch:{ all -> 0x0b51 }
            java.util.List r6 = r6.c0(r8)     // Catch:{ all -> 0x0b51 }
            r13 = r31
        L_0x0937:
            int r8 = r6.size()     // Catch:{ all -> 0x0b51 }
            if (r13 >= r8) goto L_0x09a9
            com.google.android.gms.internal.measurement.zzgl r8 = com.google.android.gms.internal.measurement.zzgm.zzd()     // Catch:{ all -> 0x0b51 }
            java.lang.Object r10 = r6.get(r13)     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.r9 r10 = (com.google.android.gms.measurement.internal.r9) r10     // Catch:{ all -> 0x0b51 }
            java.lang.String r10 = r10.f40233c     // Catch:{ all -> 0x0b51 }
            r8.zzf(r10)     // Catch:{ all -> 0x0b51 }
            java.lang.Object r10 = r6.get(r13)     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.r9 r10 = (com.google.android.gms.measurement.internal.r9) r10     // Catch:{ all -> 0x0b51 }
            long r10 = r10.f40234d     // Catch:{ all -> 0x0b51 }
            r8.zzg(r10)     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.p9 r10 = r1.f40071g     // Catch:{ all -> 0x0b51 }
            R(r10)     // Catch:{ all -> 0x0b51 }
            java.lang.Object r11 = r6.get(r13)     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.r9 r11 = (com.google.android.gms.measurement.internal.r9) r11     // Catch:{ all -> 0x0b51 }
            java.lang.Object r11 = r11.f40235e     // Catch:{ all -> 0x0b51 }
            r10.M(r8, r11)     // Catch:{ all -> 0x0b51 }
            r4.zzl(r8)     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.g r8 = r35.U()     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.f3 r10 = com.google.android.gms.measurement.internal.g3.J0     // Catch:{ all -> 0x0b51 }
            boolean r8 = r8.B(r2, r10)     // Catch:{ all -> 0x0b51 }
            if (r8 == 0) goto L_0x09a6
            java.lang.String r8 = "_sid"
            java.lang.Object r10 = r6.get(r13)     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.r9 r10 = (com.google.android.gms.measurement.internal.r9) r10     // Catch:{ all -> 0x0b51 }
            java.lang.String r10 = r10.f40233c     // Catch:{ all -> 0x0b51 }
            boolean r8 = r8.equals(r10)     // Catch:{ all -> 0x0b51 }
            if (r8 == 0) goto L_0x09a6
            long r10 = r9.g0()     // Catch:{ all -> 0x0b51 }
            r14 = 0
            int r8 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r8 == 0) goto L_0x09a6
            com.google.android.gms.measurement.internal.p9 r8 = r1.f40071g     // Catch:{ all -> 0x0b51 }
            R(r8)     // Catch:{ all -> 0x0b51 }
            java.lang.String r10 = r3.E     // Catch:{ all -> 0x0b51 }
            long r10 = r8.y(r10)     // Catch:{ all -> 0x0b51 }
            long r14 = r9.g0()     // Catch:{ all -> 0x0b51 }
            int r8 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r8 == 0) goto L_0x09a6
            r4.zzy()     // Catch:{ all -> 0x0b51 }
        L_0x09a6:
            int r13 = r13 + 1
            goto L_0x0937
        L_0x09a9:
            com.google.android.gms.measurement.internal.k r3 = r1.f40067c     // Catch:{ IOException -> 0x0b07 }
            R(r3)     // Catch:{ IOException -> 0x0b07 }
            com.google.android.gms.internal.measurement.zzlb r6 = r4.zzaD()     // Catch:{ IOException -> 0x0b07 }
            com.google.android.gms.internal.measurement.zzgd r6 = (com.google.android.gms.internal.measurement.zzgd) r6     // Catch:{ IOException -> 0x0b07 }
            r3.h()     // Catch:{ IOException -> 0x0b07 }
            r3.i()     // Catch:{ IOException -> 0x0b07 }
            com.google.android.gms.common.internal.p.k(r6)     // Catch:{ IOException -> 0x0b07 }
            java.lang.String r8 = r6.zzy()     // Catch:{ IOException -> 0x0b07 }
            com.google.android.gms.common.internal.p.g(r8)     // Catch:{ IOException -> 0x0b07 }
            byte[] r8 = r6.zzbx()     // Catch:{ IOException -> 0x0b07 }
            com.google.android.gms.measurement.internal.n9 r9 = r3.f39651b     // Catch:{ IOException -> 0x0b07 }
            com.google.android.gms.measurement.internal.p9 r9 = r9.f40071g     // Catch:{ IOException -> 0x0b07 }
            R(r9)     // Catch:{ IOException -> 0x0b07 }
            long r9 = r9.z(r8)     // Catch:{ IOException -> 0x0b07 }
            android.content.ContentValues r11 = new android.content.ContentValues     // Catch:{ IOException -> 0x0b07 }
            r11.<init>()     // Catch:{ IOException -> 0x0b07 }
            java.lang.String r12 = r6.zzy()     // Catch:{ IOException -> 0x0b07 }
            r13 = r33
            r11.put(r13, r12)     // Catch:{ IOException -> 0x0b07 }
            java.lang.Long r12 = java.lang.Long.valueOf(r9)     // Catch:{ IOException -> 0x0b07 }
            r14 = r32
            r11.put(r14, r12)     // Catch:{ IOException -> 0x0b07 }
            java.lang.String r12 = "metadata"
            r11.put(r12, r8)     // Catch:{ IOException -> 0x0b07 }
            android.database.sqlite.SQLiteDatabase r8 = r3.P()     // Catch:{ SQLiteException -> 0x0aed }
            java.lang.String r12 = "raw_events_metadata"
            r15 = 4
            r8.insertWithOnConflict(r12, r2, r11, r15)     // Catch:{ SQLiteException -> 0x0aed }
            com.google.android.gms.measurement.internal.k r3 = r1.f40067c     // Catch:{ all -> 0x0b51 }
            R(r3)     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.zzas r4 = r7.f40127f     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.r r6 = new com.google.android.gms.measurement.internal.r     // Catch:{ all -> 0x0b51 }
            r6.<init>(r4)     // Catch:{ all -> 0x0b51 }
        L_0x0a05:
            boolean r4 = r6.hasNext()     // Catch:{ all -> 0x0b51 }
            if (r4 == 0) goto L_0x0a1d
            java.lang.String r4 = r6.next()     // Catch:{ all -> 0x0b51 }
            r8 = r34
            boolean r4 = r8.equals(r4)     // Catch:{ all -> 0x0b51 }
            if (r4 == 0) goto L_0x0a1a
            r31 = r5
            goto L_0x0a5c
        L_0x0a1a:
            r34 = r8
            goto L_0x0a05
        L_0x0a1d:
            com.google.android.gms.measurement.internal.o4 r4 = r1.f40065a     // Catch:{ all -> 0x0b51 }
            R(r4)     // Catch:{ all -> 0x0b51 }
            java.lang.String r6 = r7.f40122a     // Catch:{ all -> 0x0b51 }
            java.lang.String r8 = r7.f40123b     // Catch:{ all -> 0x0b51 }
            boolean r4 = r4.E(r6, r8)     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.k r15 = r1.f40067c     // Catch:{ all -> 0x0b51 }
            R(r15)     // Catch:{ all -> 0x0b51 }
            long r16 = r35.F()     // Catch:{ all -> 0x0b51 }
            java.lang.String r6 = r7.f40122a     // Catch:{ all -> 0x0b51 }
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r18 = r6
            com.google.android.gms.measurement.internal.i r6 = r15.T(r16, r18, r19, r20, r21, r22, r23)     // Catch:{ all -> 0x0b51 }
            if (r4 == 0) goto L_0x0a5c
            long r11 = r6.f39912e     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.g r4 = r35.U()     // Catch:{ all -> 0x0b51 }
            java.lang.String r6 = r7.f40122a     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.f3 r8 = com.google.android.gms.measurement.internal.g3.f39837q     // Catch:{ all -> 0x0b51 }
            int r4 = r4.o(r6, r8)     // Catch:{ all -> 0x0b51 }
            long r5 = (long) r4     // Catch:{ all -> 0x0b51 }
            int r4 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r4 >= 0) goto L_0x0a5c
            r31 = 1
        L_0x0a5c:
            r3.h()     // Catch:{ all -> 0x0b51 }
            r3.i()     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.common.internal.p.k(r7)     // Catch:{ all -> 0x0b51 }
            java.lang.String r4 = r7.f40122a     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.common.internal.p.g(r4)     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.n9 r4 = r3.f39651b     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.p9 r4 = r4.f40071g     // Catch:{ all -> 0x0b51 }
            R(r4)     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.internal.measurement.zzft r4 = r4.D(r7)     // Catch:{ all -> 0x0b51 }
            byte[] r4 = r4.zzbx()     // Catch:{ all -> 0x0b51 }
            android.content.ContentValues r5 = new android.content.ContentValues     // Catch:{ all -> 0x0b51 }
            r5.<init>()     // Catch:{ all -> 0x0b51 }
            java.lang.String r6 = r7.f40122a     // Catch:{ all -> 0x0b51 }
            r5.put(r13, r6)     // Catch:{ all -> 0x0b51 }
            java.lang.String r6 = "name"
            java.lang.String r8 = r7.f40123b     // Catch:{ all -> 0x0b51 }
            r5.put(r6, r8)     // Catch:{ all -> 0x0b51 }
            java.lang.String r6 = "timestamp"
            long r11 = r7.f40125d     // Catch:{ all -> 0x0b51 }
            java.lang.Long r8 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0b51 }
            r5.put(r6, r8)     // Catch:{ all -> 0x0b51 }
            java.lang.Long r6 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x0b51 }
            r5.put(r14, r6)     // Catch:{ all -> 0x0b51 }
            java.lang.String r6 = "data"
            r5.put(r6, r4)     // Catch:{ all -> 0x0b51 }
            java.lang.String r4 = "realtime"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r31)     // Catch:{ all -> 0x0b51 }
            r5.put(r4, r6)     // Catch:{ all -> 0x0b51 }
            android.database.sqlite.SQLiteDatabase r4 = r3.P()     // Catch:{ SQLiteException -> 0x0ad5 }
            r6 = r36
            long r4 = r4.insert(r6, r2, r5)     // Catch:{ SQLiteException -> 0x0ad5 }
            r8 = -1
            int r2 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r2 != 0) goto L_0x0ad0
            com.google.android.gms.measurement.internal.u4 r2 = r3.f40059a     // Catch:{ SQLiteException -> 0x0ad5 }
            com.google.android.gms.measurement.internal.q3 r2 = r2.d()     // Catch:{ SQLiteException -> 0x0ad5 }
            com.google.android.gms.measurement.internal.o3 r2 = r2.r()     // Catch:{ SQLiteException -> 0x0ad5 }
            java.lang.String r4 = "Failed to insert raw event (got -1). appId"
            java.lang.String r5 = r7.f40122a     // Catch:{ SQLiteException -> 0x0ad5 }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.q3.z(r5)     // Catch:{ SQLiteException -> 0x0ad5 }
            r2.b(r4, r5)     // Catch:{ SQLiteException -> 0x0ad5 }
            goto L_0x0b1e
        L_0x0ad0:
            r4 = 0
            r1.f40079o = r4     // Catch:{ all -> 0x0b51 }
            goto L_0x0b1e
        L_0x0ad5:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.u4 r3 = r3.f40059a     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.q3 r3 = r3.d()     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.o3 r3 = r3.r()     // Catch:{ all -> 0x0b51 }
            java.lang.String r4 = "Error storing raw event. appId"
            java.lang.String r5 = r7.f40122a     // Catch:{ all -> 0x0b51 }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.q3.z(r5)     // Catch:{ all -> 0x0b51 }
            r3.c(r4, r5, r2)     // Catch:{ all -> 0x0b51 }
            goto L_0x0b1e
        L_0x0aed:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.u4 r3 = r3.f40059a     // Catch:{ IOException -> 0x0b07 }
            com.google.android.gms.measurement.internal.q3 r3 = r3.d()     // Catch:{ IOException -> 0x0b07 }
            com.google.android.gms.measurement.internal.o3 r3 = r3.r()     // Catch:{ IOException -> 0x0b07 }
            java.lang.String r5 = "Error storing raw event metadata. appId"
            java.lang.String r6 = r6.zzy()     // Catch:{ IOException -> 0x0b07 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.q3.z(r6)     // Catch:{ IOException -> 0x0b07 }
            r3.c(r5, r6, r2)     // Catch:{ IOException -> 0x0b07 }
            throw r2     // Catch:{ IOException -> 0x0b07 }
        L_0x0b07:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.q3 r3 = r35.d()     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.o3 r3 = r3.r()     // Catch:{ all -> 0x0b51 }
            java.lang.String r5 = "Data loss. Failed to insert raw event metadata. appId"
            java.lang.String r4 = r4.zzaq()     // Catch:{ all -> 0x0b51 }
            java.lang.Object r4 = com.google.android.gms.measurement.internal.q3.z(r4)     // Catch:{ all -> 0x0b51 }
            r3.c(r5, r4, r2)     // Catch:{ all -> 0x0b51 }
        L_0x0b1e:
            com.google.android.gms.measurement.internal.k r2 = r1.f40067c     // Catch:{ all -> 0x0b51 }
            R(r2)     // Catch:{ all -> 0x0b51 }
            r2.o()     // Catch:{ all -> 0x0b51 }
            com.google.android.gms.measurement.internal.k r2 = r1.f40067c
            R(r2)
            r2.f0()
            r35.M()
            com.google.android.gms.measurement.internal.q3 r2 = r35.d()
            com.google.android.gms.measurement.internal.o3 r2 = r2.v()
            long r3 = java.lang.System.nanoTime()
            long r3 = r3 - r28
            r5 = 500000(0x7a120, double:2.47033E-318)
            long r3 = r3 + r5
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = r3 / r5
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r4 = "Background event processing time, ms"
            r2.b(r4, r3)
            return
        L_0x0b51:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.k r3 = r1.f40067c
            R(r3)
            r3.f0()
            throw r2
        L_0x0b5c:
            r1.S(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.n9.D(com.google.android.gms.measurement.internal.zzau, com.google.android.gms.measurement.internal.zzq):void");
    }

    /* access modifiers changed from: package-private */
    public final boolean E() {
        f().h();
        FileLock fileLock = this.f40086v;
        if (fileLock == null || !fileLock.isValid()) {
            this.f40067c.f40059a.z();
            try {
                FileChannel channel = new RandomAccessFile(new File(this.f40076l.c().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
                this.f40087w = channel;
                FileLock tryLock = channel.tryLock();
                this.f40086v = tryLock;
                if (tryLock != null) {
                    d().v().a("Storage concurrent access okay");
                    return true;
                }
                d().r().a("Storage concurrent data access panic");
                return false;
            } catch (FileNotFoundException e10) {
                d().r().b("Failed to acquire storage lock", e10);
                return false;
            } catch (IOException e11) {
                d().r().b("Failed to access storage lock file", e11);
                return false;
            } catch (OverlappingFileLockException e12) {
                d().w().b("Storage lock already acquired", e12);
                return false;
            }
        } else {
            d().v().a("Storage concurrent access okay");
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final long F() {
        long currentTimeMillis = a().currentTimeMillis();
        j8 j8Var = this.f40073i;
        j8Var.i();
        j8Var.h();
        long a10 = j8Var.f39968i.a();
        if (a10 == 0) {
            a10 = ((long) j8Var.f40059a.N().u().nextInt(86400000)) + 1;
            j8Var.f39968i.b(a10);
        }
        return ((((currentTimeMillis + a10) / 1000) / 60) / 60) / 24;
    }

    /* access modifiers changed from: package-private */
    public final q5 S(zzq zzq) {
        String str;
        f().h();
        g();
        p.k(zzq);
        p.g(zzq.f40506a);
        if (!zzq.D.isEmpty()) {
            this.B.put(zzq.f40506a, new m9(this, zzq.D));
        }
        k kVar = this.f40067c;
        R(kVar);
        q5 R = kVar.R(zzq.f40506a);
        o d10 = c0(zzq.f40506a).d(o.c(zzq.C, 100));
        zzha zzha = zzha.AD_STORAGE;
        if (d10.j(zzha)) {
            str = this.f40073i.o(zzq.f40506a, zzq.f40520q);
        } else {
            str = "";
        }
        if (R == null) {
            R = new q5(this.f40076l, zzq.f40506a);
            if (d10.j(zzha.ANALYTICS_STORAGE)) {
                R.j(i0(d10));
            }
            if (d10.j(zzha)) {
                R.H(str);
            }
        } else if (d10.j(zzha) && str != null && !str.equals(R.c())) {
            R.H(str);
            if (zzq.f40520q && !"00000000-0000-0000-0000-000000000000".equals(this.f40073i.n(zzq.f40506a, d10).first)) {
                R.j(i0(d10));
                k kVar2 = this.f40067c;
                R(kVar2);
                if (kVar2.X(zzq.f40506a, "_id") != null) {
                    k kVar3 = this.f40067c;
                    R(kVar3);
                    if (kVar3.X(zzq.f40506a, "_lair") == null) {
                        r9 r9Var = new r9(zzq.f40506a, "auto", "_lair", a().currentTimeMillis(), 1L);
                        k kVar4 = this.f40067c;
                        R(kVar4);
                        kVar4.x(r9Var);
                    }
                }
            }
        } else if (TextUtils.isEmpty(R.m0()) && d10.j(zzha.ANALYTICS_STORAGE)) {
            R.j(i0(d10));
        }
        R.y(zzq.f40507b);
        R.h(zzq.f40522w);
        if (!TextUtils.isEmpty(zzq.f40516l)) {
            R.x(zzq.f40516l);
        }
        long j10 = zzq.f40510e;
        if (j10 != 0) {
            R.z(j10);
        }
        if (!TextUtils.isEmpty(zzq.f40508c)) {
            R.l(zzq.f40508c);
        }
        R.m(zzq.f40515k);
        String str2 = zzq.f40509d;
        if (str2 != null) {
            R.k(str2);
        }
        R.u(zzq.f40511f);
        R.F(zzq.f40513h);
        if (!TextUtils.isEmpty(zzq.f40512g)) {
            R.B(zzq.f40512g);
        }
        R.i(zzq.f40520q);
        R.G(zzq.f40523x);
        R.v(zzq.f40524y);
        zzqu.zzc();
        if (U().B((String) null, g3.f39834o0) || U().B(zzq.f40506a, g3.f39838q0)) {
            R.J(zzq.E);
        }
        zzop.zzc();
        if (U().B((String) null, g3.f39832n0)) {
            R.I(zzq.f40525z);
        } else {
            zzop.zzc();
            if (U().B((String) null, g3.f39830m0)) {
                R.I((List) null);
            }
        }
        zzrd.zzc();
        if (U().B((String) null, g3.f39842s0)) {
            R.L(zzq.F);
        }
        zzpz.zzc();
        if (U().B((String) null, g3.G0)) {
            R.M(zzq.G);
        }
        if (R.P()) {
            k kVar5 = this.f40067c;
            R(kVar5);
            kVar5.p(R);
        }
        return R;
    }

    public final b T() {
        b bVar = this.f40070f;
        R(bVar);
        return bVar;
    }

    public final g U() {
        return ((u4) p.k(this.f40076l)).z();
    }

    public final k V() {
        k kVar = this.f40067c;
        R(kVar);
        return kVar;
    }

    public final l3 W() {
        return this.f40076l.D();
    }

    public final v3 X() {
        v3 v3Var = this.f40066b;
        R(v3Var);
        return v3Var;
    }

    public final y3 Y() {
        y3 y3Var = this.f40068d;
        if (y3Var != null) {
            return y3Var;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final o4 Z() {
        o4 o4Var = this.f40065a;
        R(o4Var);
        return o4Var;
    }

    public final f a() {
        return ((u4) p.k(this.f40076l)).a();
    }

    public final c b() {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public final u4 b0() {
        return this.f40076l;
    }

    public final Context c() {
        return this.f40076l.c();
    }

    /* access modifiers changed from: package-private */
    public final o c0(String str) {
        String str2;
        o oVar = o.f42122c;
        f().h();
        g();
        o oVar2 = (o) this.A.get(str);
        if (oVar2 != null) {
            return oVar2;
        }
        k kVar = this.f40067c;
        R(kVar);
        p.k(str);
        kVar.h();
        kVar.i();
        Cursor cursor = null;
        try {
            Cursor rawQuery = kVar.P().rawQuery("select consent_state from consent_settings where app_id=? limit 1;", new String[]{str});
            if (rawQuery.moveToFirst()) {
                str2 = rawQuery.getString(0);
                rawQuery.close();
            } else {
                rawQuery.close();
                str2 = "G1";
            }
            o c10 = o.c(str2, 100);
            A(str, c10);
            return c10;
        } catch (SQLiteException e10) {
            kVar.f40059a.d().r().c("Database error", "select consent_state from consent_settings where app_id=? limit 1;", e10);
            throw e10;
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    public final q3 d() {
        return ((u4) p.k(this.f40076l)).d();
    }

    public final y6 d0() {
        y6 y6Var = this.f40072h;
        R(y6Var);
        return y6Var;
    }

    /* access modifiers changed from: package-private */
    public final void e() {
        f().h();
        g();
        if (!this.f40078n) {
            this.f40078n = true;
            if (E()) {
                FileChannel fileChannel = this.f40087w;
                f().h();
                int i10 = 0;
                if (fileChannel == null || !fileChannel.isOpen()) {
                    d().r().a("Bad channel to read from");
                } else {
                    ByteBuffer allocate = ByteBuffer.allocate(4);
                    try {
                        fileChannel.position(0);
                        int read = fileChannel.read(allocate);
                        if (read == 4) {
                            allocate.flip();
                            i10 = allocate.getInt();
                        } else if (read != -1) {
                            d().w().b("Unexpected data length. Bytes read", Integer.valueOf(read));
                        }
                    } catch (IOException e10) {
                        d().r().b("Failed to read from channel", e10);
                    }
                }
                int p10 = this.f40076l.B().p();
                f().h();
                if (i10 > p10) {
                    d().r().c("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i10), Integer.valueOf(p10));
                } else if (i10 < p10) {
                    FileChannel fileChannel2 = this.f40087w;
                    f().h();
                    if (fileChannel2 == null || !fileChannel2.isOpen()) {
                        d().r().a("Bad channel to read from");
                    } else {
                        ByteBuffer allocate2 = ByteBuffer.allocate(4);
                        allocate2.putInt(p10);
                        allocate2.flip();
                        try {
                            fileChannel2.truncate(0);
                            fileChannel2.write(allocate2);
                            fileChannel2.force(true);
                            if (fileChannel2.size() != 4) {
                                d().r().b("Error writing to channel. Bytes written", Long.valueOf(fileChannel2.size()));
                            }
                            d().v().c("Storage version upgraded. Previous, current version", Integer.valueOf(i10), Integer.valueOf(p10));
                            return;
                        } catch (IOException e11) {
                            d().r().b("Failed to write to channel", e11);
                        }
                    }
                    d().r().c("Storage version upgrade failed. Previous, current version", Integer.valueOf(i10), Integer.valueOf(p10));
                }
            }
        }
    }

    public final j8 e0() {
        return this.f40073i;
    }

    public final s4 f() {
        return ((u4) p.k(this.f40076l)).f();
    }

    /* access modifiers changed from: package-private */
    public final void g() {
        if (!this.f40077m) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    public final p9 g0() {
        p9 p9Var = this.f40071g;
        R(p9Var);
        return p9Var;
    }

    /* access modifiers changed from: package-private */
    public final void h(String str, zzgc zzgc) {
        int x10;
        int indexOf;
        o4 o4Var = this.f40065a;
        R(o4Var);
        Set y10 = o4Var.y(str);
        if (y10 != null) {
            zzgc.zzi(y10);
        }
        o4 o4Var2 = this.f40065a;
        R(o4Var2);
        if (o4Var2.J(str)) {
            zzgc.zzp();
        }
        o4 o4Var3 = this.f40065a;
        R(o4Var3);
        if (o4Var3.M(str)) {
            if (U().B(str, g3.f39844t0)) {
                String zzas = zzgc.zzas();
                if (!TextUtils.isEmpty(zzas) && (indexOf = zzas.indexOf(".")) != -1) {
                    zzgc.zzY(zzas.substring(0, indexOf));
                }
            } else {
                zzgc.zzu();
            }
        }
        o4 o4Var4 = this.f40065a;
        R(o4Var4);
        if (o4Var4.N(str) && (x10 = p9.x(zzgc, "_id")) != -1) {
            zzgc.zzB(x10);
        }
        o4 o4Var5 = this.f40065a;
        R(o4Var5);
        if (o4Var5.L(str)) {
            zzgc.zzq();
        }
        o4 o4Var6 = this.f40065a;
        R(o4Var6);
        if (o4Var6.I(str)) {
            zzgc.zzn();
            m9 m9Var = (m9) this.B.get(str);
            if (m9Var == null || m9Var.f40043b + U().r(str, g3.V) < a().b()) {
                m9Var = new m9(this);
                this.B.put(str, m9Var);
            }
            zzgc.zzR(m9Var.f40042a);
        }
        o4 o4Var7 = this.f40065a;
        R(o4Var7);
        if (o4Var7.K(str)) {
            zzgc.zzy();
        }
    }

    public final t9 h0() {
        return ((u4) p.k(this.f40076l)).N();
    }

    /* access modifiers changed from: package-private */
    public final void i(q5 q5Var) {
        f().h();
        if (!TextUtils.isEmpty(q5Var.a()) || !TextUtils.isEmpty(q5Var.j0())) {
            d9 d9Var = this.f40074j;
            Uri.Builder builder = new Uri.Builder();
            String a10 = q5Var.a();
            if (TextUtils.isEmpty(a10)) {
                a10 = q5Var.j0();
            }
            a aVar = null;
            Uri.Builder appendQueryParameter = builder.scheme((String) g3.f39817g.a((Object) null)).encodedAuthority((String) g3.f39819h.a((Object) null)).path("config/app/".concat(String.valueOf(a10))).appendQueryParameter("platform", "android");
            d9Var.f40059a.z().q();
            appendQueryParameter.appendQueryParameter("gmp_version", String.valueOf(79000)).appendQueryParameter("runtime_version", "0");
            String uri = builder.build().toString();
            try {
                String str = (String) p.k(q5Var.l0());
                URL url = new URL(uri);
                d().v().b("Fetching remote configuration", str);
                o4 o4Var = this.f40065a;
                R(o4Var);
                zzff t10 = o4Var.t(str);
                o4 o4Var2 = this.f40065a;
                R(o4Var2);
                String v10 = o4Var2.v(str);
                if (t10 != null) {
                    if (!TextUtils.isEmpty(v10)) {
                        a aVar2 = new a();
                        aVar2.put("If-Modified-Since", v10);
                        aVar = aVar2;
                    }
                    o4 o4Var3 = this.f40065a;
                    R(o4Var3);
                    String u10 = o4Var3.u(str);
                    if (!TextUtils.isEmpty(u10)) {
                        if (aVar == null) {
                            aVar = new a();
                        }
                        aVar.put("If-None-Match", u10);
                    }
                }
                this.f40083s = true;
                v3 v3Var = this.f40066b;
                R(v3Var);
                g9 g9Var = new g9(this);
                v3Var.h();
                v3Var.i();
                p.k(url);
                p.k(g9Var);
                v3Var.f40059a.f().y(new u3(v3Var, str, url, (byte[]) null, aVar, g9Var));
            } catch (MalformedURLException unused) {
                d().r().c("Failed to parse config URL. Not fetching. appId", q3.z(q5Var.l0()), uri);
            }
        } else {
            n((String) p.k(q5Var.l0()), 204, (Throwable) null, (byte[]) null, (Map) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final String i0(o oVar) {
        if (!oVar.j(zzha.ANALYTICS_STORAGE)) {
            return null;
        }
        byte[] bArr = new byte[16];
        h0().u().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    /* access modifiers changed from: package-private */
    public final void j(zzau zzau, zzq zzq) {
        zzau zzau2;
        List<zzac> list;
        List<zzac> list2;
        List<zzac> list3;
        String str;
        zzq zzq2 = zzq;
        p.k(zzq);
        p.g(zzq2.f40506a);
        f().h();
        g();
        String str2 = zzq2.f40506a;
        long j10 = zzau.f40494d;
        r3 b10 = r3.b(zzau);
        f().h();
        z6 z6Var = null;
        if (!(this.C == null || (str = this.D) == null || !str.equals(str2))) {
            z6Var = this.C;
        }
        t9.y(z6Var, b10.f40216d, false);
        zzau a10 = b10.a();
        R(this.f40071g);
        if (p9.n(a10, zzq2)) {
            if (!zzq2.f40513h) {
                S(zzq2);
                return;
            }
            List list4 = zzq2.f40525z;
            if (list4 == null) {
                zzau2 = a10;
            } else if (list4.contains(a10.f40491a)) {
                Bundle Y = a10.f40492b.Y();
                Y.putLong("ga_safelisted", 1);
                zzau2 = new zzau(a10.f40491a, new zzas(Y), a10.f40493c, a10.f40494d);
            } else {
                d().q().d("Dropping non-safelisted event. appId, event name, origin", str2, a10.f40491a, a10.f40493c);
                return;
            }
            k kVar = this.f40067c;
            R(kVar);
            kVar.e0();
            try {
                k kVar2 = this.f40067c;
                R(kVar2);
                p.g(str2);
                kVar2.h();
                kVar2.i();
                int i10 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
                if (i10 < 0) {
                    kVar2.f40059a.d().w().c("Invalid time querying timed out conditional properties", q3.z(str2), Long.valueOf(j10));
                    list = Collections.emptyList();
                } else {
                    list = kVar2.b0("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j10)});
                }
                for (zzac zzac : list) {
                    if (zzac != null) {
                        d().v().d("User property timed out", zzac.f40479a, this.f40076l.D().f(zzac.f40481c.f40500b), zzac.f40481c.S());
                        zzau zzau3 = zzac.f40485g;
                        if (zzau3 != null) {
                            D(new zzau(zzau3, j10), zzq2);
                        }
                        k kVar3 = this.f40067c;
                        R(kVar3);
                        kVar3.J(str2, zzac.f40481c.f40500b);
                    }
                }
                k kVar4 = this.f40067c;
                R(kVar4);
                p.g(str2);
                kVar4.h();
                kVar4.i();
                if (i10 < 0) {
                    kVar4.f40059a.d().w().c("Invalid time querying expired conditional properties", q3.z(str2), Long.valueOf(j10));
                    list2 = Collections.emptyList();
                } else {
                    list2 = kVar4.b0("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j10)});
                }
                ArrayList<zzau> arrayList = new ArrayList<>(list2.size());
                for (zzac zzac2 : list2) {
                    if (zzac2 != null) {
                        d().v().d("User property expired", zzac2.f40479a, this.f40076l.D().f(zzac2.f40481c.f40500b), zzac2.f40481c.S());
                        k kVar5 = this.f40067c;
                        R(kVar5);
                        kVar5.m(str2, zzac2.f40481c.f40500b);
                        zzau zzau4 = zzac2.f40489l;
                        if (zzau4 != null) {
                            arrayList.add(zzau4);
                        }
                        k kVar6 = this.f40067c;
                        R(kVar6);
                        kVar6.J(str2, zzac2.f40481c.f40500b);
                    }
                }
                for (zzau zzau5 : arrayList) {
                    D(new zzau(zzau5, j10), zzq2);
                }
                k kVar7 = this.f40067c;
                R(kVar7);
                String str3 = zzau2.f40491a;
                p.g(str2);
                p.g(str3);
                kVar7.h();
                kVar7.i();
                if (i10 < 0) {
                    kVar7.f40059a.d().w().d("Invalid time querying triggered conditional properties", q3.z(str2), kVar7.f40059a.D().d(str3), Long.valueOf(j10));
                    list3 = Collections.emptyList();
                } else {
                    list3 = kVar7.b0("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str3, String.valueOf(j10)});
                }
                ArrayList<zzau> arrayList2 = new ArrayList<>(list3.size());
                for (zzac zzac3 : list3) {
                    if (zzac3 != null) {
                        zzlk zzlk = zzac3.f40481c;
                        r9 r9Var = new r9((String) p.k(zzac3.f40479a), zzac3.f40480b, zzlk.f40500b, j10, p.k(zzlk.S()));
                        k kVar8 = this.f40067c;
                        R(kVar8);
                        if (kVar8.x(r9Var)) {
                            d().v().d("User property triggered", zzac3.f40479a, this.f40076l.D().f(r9Var.f40233c), r9Var.f40235e);
                        } else {
                            d().r().d("Too many active user properties, ignoring", q3.z(zzac3.f40479a), this.f40076l.D().f(r9Var.f40233c), r9Var.f40235e);
                        }
                        zzau zzau6 = zzac3.f40487j;
                        if (zzau6 != null) {
                            arrayList2.add(zzau6);
                        }
                        zzac3.f40481c = new zzlk(r9Var);
                        zzac3.f40483e = true;
                        k kVar9 = this.f40067c;
                        R(kVar9);
                        kVar9.w(zzac3);
                    }
                }
                D(zzau2, zzq2);
                for (zzau zzau7 : arrayList2) {
                    D(new zzau(zzau7, j10), zzq2);
                }
                k kVar10 = this.f40067c;
                R(kVar10);
                kVar10.o();
            } finally {
                k kVar11 = this.f40067c;
                R(kVar11);
                kVar11.f0();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final String j0(zzq zzq) {
        try {
            return (String) f().s(new i9(this, zzq)).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e10) {
            d().r().c("Failed to get app instance id. appId", q3.z(zzq.f40506a), e10);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void k(zzau zzau, String str) {
        zzau zzau2 = zzau;
        String str2 = str;
        k kVar = this.f40067c;
        R(kVar);
        q5 R = kVar.R(str2);
        if (R == null || TextUtils.isEmpty(R.o0())) {
            d().q().b("No app data available; dropping event", str2);
            return;
        }
        Boolean J = J(R);
        if (J == null) {
            if (!"_ui".equals(zzau2.f40491a)) {
                d().w().b("Could not find package. appId", q3.z(str));
            }
        } else if (!J.booleanValue()) {
            d().r().b("App version does not match; dropping event. appId", q3.z(str));
            return;
        }
        String a10 = R.a();
        String o02 = R.o0();
        long R2 = R.R();
        String n02 = R.n0();
        long c02 = R.c0();
        long Z = R.Z();
        zzq zzq = r2;
        boolean O = R.O();
        q5 q5Var = R;
        String p02 = q5Var.p0();
        q5Var.A();
        zzq zzq2 = new zzq(str, a10, o02, R2, n02, c02, Z, (String) null, O, false, p02, 0, 0, 0, q5Var.N(), false, q5Var.j0(), q5Var.i0(), q5Var.a0(), q5Var.e(), (String) null, c0(str2).i(), "", (String) null, q5Var.Q(), q5Var.h0());
        l(zzau2, zzq);
    }

    /* access modifiers changed from: package-private */
    public final void l(zzau zzau, zzq zzq) {
        p.g(zzq.f40506a);
        r3 b10 = r3.b(zzau);
        t9 h02 = h0();
        Bundle bundle = b10.f40216d;
        k kVar = this.f40067c;
        R(kVar);
        h02.z(bundle, kVar.Q(zzq.f40506a));
        h0().B(b10, U().n(zzq.f40506a));
        zzau a10 = b10.a();
        if (Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(a10.f40491a) && "referrer API v2".equals(a10.f40492b.m0("_cis"))) {
            String m02 = a10.f40492b.m0("gclid");
            if (!TextUtils.isEmpty(m02)) {
                B(new zzlk("_lgclid", a10.f40494d, m02, "auto"), zzq);
            }
        }
        j(a10, zzq);
    }

    /* access modifiers changed from: package-private */
    public final void l0(Runnable runnable) {
        f().h();
        if (this.f40080p == null) {
            this.f40080p = new ArrayList();
        }
        this.f40080p.add(runnable);
    }

    /* access modifiers changed from: package-private */
    public final void m() {
        this.f40082r++;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0049 A[Catch:{ all -> 0x0176, all -> 0x0180 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005c A[Catch:{ all -> 0x0176, all -> 0x0180 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0129 A[Catch:{ all -> 0x0176, all -> 0x0180 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0137 A[Catch:{ all -> 0x0176, all -> 0x0180 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0159 A[Catch:{ all -> 0x0176, all -> 0x0180 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x015d A[Catch:{ all -> 0x0176, all -> 0x0180 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n(java.lang.String r8, int r9, java.lang.Throwable r10, byte[] r11, java.util.Map r12) {
        /*
            r7 = this;
            com.google.android.gms.measurement.internal.s4 r0 = r7.f()
            r0.h()
            r7.g()
            com.google.android.gms.common.internal.p.g(r8)
            r0 = 0
            if (r11 != 0) goto L_0x0012
            byte[] r11 = new byte[r0]     // Catch:{ all -> 0x0180 }
        L_0x0012:
            com.google.android.gms.measurement.internal.q3 r1 = r7.d()     // Catch:{ all -> 0x0180 }
            com.google.android.gms.measurement.internal.o3 r1 = r1.v()     // Catch:{ all -> 0x0180 }
            java.lang.String r2 = "onConfigFetched. Response size"
            int r3 = r11.length     // Catch:{ all -> 0x0180 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0180 }
            r1.b(r2, r3)     // Catch:{ all -> 0x0180 }
            com.google.android.gms.measurement.internal.k r1 = r7.f40067c     // Catch:{ all -> 0x0180 }
            R(r1)     // Catch:{ all -> 0x0180 }
            r1.e0()     // Catch:{ all -> 0x0180 }
            com.google.android.gms.measurement.internal.k r1 = r7.f40067c     // Catch:{ all -> 0x0176 }
            R(r1)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.q5 r1 = r1.R(r8)     // Catch:{ all -> 0x0176 }
            r2 = 200(0xc8, float:2.8E-43)
            r4 = 304(0x130, float:4.26E-43)
            if (r9 == r2) goto L_0x0042
            r2 = 204(0xcc, float:2.86E-43)
            if (r9 == r2) goto L_0x0042
            if (r9 != r4) goto L_0x0046
            r9 = r4
        L_0x0042:
            if (r10 != 0) goto L_0x0046
            r2 = 1
            goto L_0x0047
        L_0x0046:
            r2 = r0
        L_0x0047:
            if (r1 != 0) goto L_0x005c
            com.google.android.gms.measurement.internal.q3 r9 = r7.d()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.o3 r9 = r9.w()     // Catch:{ all -> 0x0176 }
            java.lang.String r10 = "App does not exist in onConfigFetched. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.q3.z(r8)     // Catch:{ all -> 0x0176 }
            r9.b(r10, r8)     // Catch:{ all -> 0x0176 }
            goto L_0x0160
        L_0x005c:
            r5 = 404(0x194, float:5.66E-43)
            if (r2 != 0) goto L_0x00ba
            if (r9 != r5) goto L_0x0063
            goto L_0x00ba
        L_0x0063:
            me.f r11 = r7.a()     // Catch:{ all -> 0x0176 }
            long r11 = r11.currentTimeMillis()     // Catch:{ all -> 0x0176 }
            r1.w(r11)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.k r11 = r7.f40067c     // Catch:{ all -> 0x0176 }
            R(r11)     // Catch:{ all -> 0x0176 }
            r11.p(r1)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.q3 r11 = r7.d()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.o3 r11 = r11.v()     // Catch:{ all -> 0x0176 }
            java.lang.String r12 = "Fetching config failed. code, error"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0176 }
            r11.c(r12, r1, r10)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.o4 r10 = r7.f40065a     // Catch:{ all -> 0x0176 }
            R(r10)     // Catch:{ all -> 0x0176 }
            r10.z(r8)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.j8 r8 = r7.f40073i     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.b4 r8 = r8.f39967h     // Catch:{ all -> 0x0176 }
            me.f r10 = r7.a()     // Catch:{ all -> 0x0176 }
            long r10 = r10.currentTimeMillis()     // Catch:{ all -> 0x0176 }
            r8.b(r10)     // Catch:{ all -> 0x0176 }
            r8 = 503(0x1f7, float:7.05E-43)
            if (r9 == r8) goto L_0x00a6
            r8 = 429(0x1ad, float:6.01E-43)
            if (r9 != r8) goto L_0x00b5
        L_0x00a6:
            com.google.android.gms.measurement.internal.j8 r8 = r7.f40073i     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.b4 r8 = r8.f39965f     // Catch:{ all -> 0x0176 }
            me.f r9 = r7.a()     // Catch:{ all -> 0x0176 }
            long r9 = r9.currentTimeMillis()     // Catch:{ all -> 0x0176 }
            r8.b(r9)     // Catch:{ all -> 0x0176 }
        L_0x00b5:
            r7.M()     // Catch:{ all -> 0x0176 }
            goto L_0x0160
        L_0x00ba:
            r10 = 0
            if (r12 == 0) goto L_0x00c6
            java.lang.String r2 = "Last-Modified"
            java.lang.Object r2 = r12.get(r2)     // Catch:{ all -> 0x0176 }
            java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x0176 }
            goto L_0x00c7
        L_0x00c6:
            r2 = r10
        L_0x00c7:
            if (r2 == 0) goto L_0x00d6
            boolean r6 = r2.isEmpty()     // Catch:{ all -> 0x0176 }
            if (r6 != 0) goto L_0x00d6
            java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x0176 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0176 }
            goto L_0x00d7
        L_0x00d6:
            r2 = r10
        L_0x00d7:
            if (r12 == 0) goto L_0x00e2
            java.lang.String r6 = "ETag"
            java.lang.Object r12 = r12.get(r6)     // Catch:{ all -> 0x0176 }
            java.util.List r12 = (java.util.List) r12     // Catch:{ all -> 0x0176 }
            goto L_0x00e3
        L_0x00e2:
            r12 = r10
        L_0x00e3:
            if (r12 == 0) goto L_0x00f2
            boolean r6 = r12.isEmpty()     // Catch:{ all -> 0x0176 }
            if (r6 != 0) goto L_0x00f2
            java.lang.Object r12 = r12.get(r0)     // Catch:{ all -> 0x0176 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0176 }
            goto L_0x00f3
        L_0x00f2:
            r12 = r10
        L_0x00f3:
            if (r9 == r5) goto L_0x0101
            if (r9 != r4) goto L_0x00f8
            goto L_0x0101
        L_0x00f8:
            com.google.android.gms.measurement.internal.o4 r10 = r7.f40065a     // Catch:{ all -> 0x0176 }
            R(r10)     // Catch:{ all -> 0x0176 }
            r10.H(r8, r11, r2, r12)     // Catch:{ all -> 0x0176 }
            goto L_0x0114
        L_0x0101:
            com.google.android.gms.measurement.internal.o4 r11 = r7.f40065a     // Catch:{ all -> 0x0176 }
            R(r11)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.internal.measurement.zzff r11 = r11.t(r8)     // Catch:{ all -> 0x0176 }
            if (r11 != 0) goto L_0x0114
            com.google.android.gms.measurement.internal.o4 r11 = r7.f40065a     // Catch:{ all -> 0x0176 }
            R(r11)     // Catch:{ all -> 0x0176 }
            r11.H(r8, r10, r10, r10)     // Catch:{ all -> 0x0176 }
        L_0x0114:
            me.f r10 = r7.a()     // Catch:{ all -> 0x0176 }
            long r10 = r10.currentTimeMillis()     // Catch:{ all -> 0x0176 }
            r1.n(r10)     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.k r10 = r7.f40067c     // Catch:{ all -> 0x0176 }
            R(r10)     // Catch:{ all -> 0x0176 }
            r10.p(r1)     // Catch:{ all -> 0x0176 }
            if (r9 != r5) goto L_0x0137
            com.google.android.gms.measurement.internal.q3 r9 = r7.d()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.o3 r9 = r9.x()     // Catch:{ all -> 0x0176 }
            java.lang.String r10 = "Config not found. Using empty config. appId"
            r9.b(r10, r8)     // Catch:{ all -> 0x0176 }
            goto L_0x0148
        L_0x0137:
            com.google.android.gms.measurement.internal.q3 r8 = r7.d()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.o3 r8 = r8.v()     // Catch:{ all -> 0x0176 }
            java.lang.String r10 = "Successfully fetched config. Got network response. code, size"
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0176 }
            r8.c(r10, r9, r3)     // Catch:{ all -> 0x0176 }
        L_0x0148:
            com.google.android.gms.measurement.internal.v3 r8 = r7.f40066b     // Catch:{ all -> 0x0176 }
            R(r8)     // Catch:{ all -> 0x0176 }
            boolean r8 = r8.m()     // Catch:{ all -> 0x0176 }
            if (r8 == 0) goto L_0x015d
            boolean r8 = r7.O()     // Catch:{ all -> 0x0176 }
            if (r8 == 0) goto L_0x015d
            r7.C()     // Catch:{ all -> 0x0176 }
            goto L_0x0160
        L_0x015d:
            r7.M()     // Catch:{ all -> 0x0176 }
        L_0x0160:
            com.google.android.gms.measurement.internal.k r8 = r7.f40067c     // Catch:{ all -> 0x0176 }
            R(r8)     // Catch:{ all -> 0x0176 }
            r8.o()     // Catch:{ all -> 0x0176 }
            com.google.android.gms.measurement.internal.k r8 = r7.f40067c     // Catch:{ all -> 0x0180 }
            R(r8)     // Catch:{ all -> 0x0180 }
            r8.f0()     // Catch:{ all -> 0x0180 }
            r7.f40083s = r0
            r7.K()
            return
        L_0x0176:
            r8 = move-exception
            com.google.android.gms.measurement.internal.k r9 = r7.f40067c     // Catch:{ all -> 0x0180 }
            R(r9)     // Catch:{ all -> 0x0180 }
            r9.f0()     // Catch:{ all -> 0x0180 }
            throw r8     // Catch:{ all -> 0x0180 }
        L_0x0180:
            r8 = move-exception
            r7.f40083s = r0
            r7.K()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.n9.n(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    /* access modifiers changed from: package-private */
    public final void o(boolean z10) {
        M();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public final void p(int i10, Throwable th2, byte[] bArr, String str) {
        k kVar;
        f().h();
        g();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th3) {
                this.f40084t = false;
                K();
                throw th3;
            }
        }
        List<Long> list = (List) p.k(this.f40088x);
        this.f40088x = null;
        if (i10 != 200) {
            if (i10 == 204) {
                i10 = 204;
            }
            d().v().c("Network upload failed. Will retry later. code, error", Integer.valueOf(i10), th2);
            this.f40073i.f39967h.b(a().currentTimeMillis());
            if (i10 == 503 || i10 == 429) {
                this.f40073i.f39965f.b(a().currentTimeMillis());
            }
            k kVar2 = this.f40067c;
            R(kVar2);
            kVar2.g0(list);
            M();
            this.f40084t = false;
            K();
        }
        if (th2 == null) {
            try {
                this.f40073i.f39966g.b(a().currentTimeMillis());
                this.f40073i.f39967h.b(0);
                M();
                d().v().c("Successful upload. Got network response. code, size", Integer.valueOf(i10), Integer.valueOf(bArr.length));
                k kVar3 = this.f40067c;
                R(kVar3);
                kVar3.e0();
                try {
                    for (Long l10 : list) {
                        try {
                            kVar = this.f40067c;
                            R(kVar);
                            long longValue = l10.longValue();
                            kVar.h();
                            kVar.i();
                            if (kVar.P().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e10) {
                            kVar.f40059a.d().r().b("Failed to delete a bundle in a queue table", e10);
                            throw e10;
                        } catch (SQLiteException e11) {
                            List list2 = this.f40089y;
                            if (list2 == null || !list2.contains(l10)) {
                                throw e11;
                            }
                        }
                    }
                    k kVar4 = this.f40067c;
                    R(kVar4);
                    kVar4.o();
                    k kVar5 = this.f40067c;
                    R(kVar5);
                    kVar5.f0();
                    this.f40089y = null;
                    v3 v3Var = this.f40066b;
                    R(v3Var);
                    if (!v3Var.m() || !O()) {
                        this.f40090z = -1;
                        M();
                    } else {
                        C();
                    }
                    this.f40079o = 0;
                } catch (Throwable th4) {
                    k kVar6 = this.f40067c;
                    R(kVar6);
                    kVar6.f0();
                    throw th4;
                }
            } catch (SQLiteException e12) {
                d().r().b("Database error while trying to delete uploaded bundles", e12);
                this.f40079o = a().b();
                d().v().b("Disable upload, time", Long.valueOf(this.f40079o));
            }
            this.f40084t = false;
            K();
        }
        d().v().c("Network upload failed. Will retry later. code, error", Integer.valueOf(i10), th2);
        this.f40073i.f39967h.b(a().currentTimeMillis());
        this.f40073i.f39965f.b(a().currentTimeMillis());
        k kVar22 = this.f40067c;
        R(kVar22);
        kVar22.g0(list);
        M();
        this.f40084t = false;
        K();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x03d7 A[Catch:{ RuntimeException -> 0x035f, all -> 0x056f }] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0403 A[Catch:{ RuntimeException -> 0x035f, all -> 0x056f }] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0418 A[SYNTHETIC, Splitter:B:137:0x0418] */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x04ba A[Catch:{ RuntimeException -> 0x035f, all -> 0x056f }] */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x04da A[Catch:{ RuntimeException -> 0x035f, all -> 0x056f }] */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x053f A[Catch:{ RuntimeException -> 0x035f, all -> 0x056f }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0126 A[Catch:{ RuntimeException -> 0x035f, all -> 0x056f }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01ef A[Catch:{ RuntimeException -> 0x035f, all -> 0x056f }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01f5 A[Catch:{ RuntimeException -> 0x035f, all -> 0x056f }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x024e A[Catch:{ RuntimeException -> 0x035f, all -> 0x056f }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x025d A[Catch:{ RuntimeException -> 0x035f, all -> 0x056f }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x026d A[Catch:{ RuntimeException -> 0x035f, all -> 0x056f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void q(com.google.android.gms.measurement.internal.zzq r24) {
        /*
            r23 = this;
            r1 = r23
            r2 = r24
            java.lang.String r3 = "_sysu"
            java.lang.String r4 = "_sys"
            java.lang.String r5 = "com.android.vending"
            java.lang.String r6 = "_pfo"
            java.lang.String r0 = "_npa"
            java.lang.String r7 = "_uwa"
            java.lang.String r8 = "app_id=?"
            com.google.android.gms.measurement.internal.s4 r9 = r23.f()
            r9.h()
            r23.g()
            com.google.android.gms.common.internal.p.k(r24)
            java.lang.String r9 = r2.f40506a
            com.google.android.gms.common.internal.p.g(r9)
            boolean r9 = Q(r24)
            if (r9 == 0) goto L_0x0579
            com.google.android.gms.measurement.internal.k r9 = r1.f40067c
            R(r9)
            java.lang.String r10 = r2.f40506a
            com.google.android.gms.measurement.internal.q5 r9 = r9.R(r10)
            r10 = 0
            if (r9 == 0) goto L_0x0060
            java.lang.String r12 = r9.a()
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 == 0) goto L_0x0060
            java.lang.String r12 = r2.f40507b
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L_0x0060
            r9.n(r10)
            com.google.android.gms.measurement.internal.k r12 = r1.f40067c
            R(r12)
            r12.p(r9)
            com.google.android.gms.measurement.internal.o4 r9 = r1.f40065a
            R(r9)
            java.lang.String r12 = r2.f40506a
            r9.A(r12)
        L_0x0060:
            boolean r9 = r2.f40513h
            if (r9 != 0) goto L_0x0068
            r23.S(r24)
            return
        L_0x0068:
            long r12 = r2.f40518n
            int r9 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r9 != 0) goto L_0x0076
            me.f r9 = r23.a()
            long r12 = r9.currentTimeMillis()
        L_0x0076:
            com.google.android.gms.measurement.internal.u4 r9 = r1.f40076l
            com.google.android.gms.measurement.internal.o r9 = r9.A()
            r9.r()
            int r9 = r2.f40519p
            r15 = 1
            if (r9 == 0) goto L_0x009e
            if (r9 == r15) goto L_0x009e
            com.google.android.gms.measurement.internal.q3 r16 = r23.d()
            com.google.android.gms.measurement.internal.o3 r14 = r16.w()
            java.lang.String r10 = r2.f40506a
            java.lang.Object r10 = com.google.android.gms.measurement.internal.q3.z(r10)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r11 = "Incorrect app type, assuming installed app. appId, appType"
            r14.c(r11, r10, r9)
            r9 = 0
        L_0x009e:
            com.google.android.gms.measurement.internal.k r10 = r1.f40067c
            R(r10)
            r10.e0()
            com.google.android.gms.measurement.internal.k r10 = r1.f40067c     // Catch:{ all -> 0x056f }
            R(r10)     // Catch:{ all -> 0x056f }
            java.lang.String r11 = r2.f40506a     // Catch:{ all -> 0x056f }
            com.google.android.gms.measurement.internal.r9 r10 = r10.X(r11, r0)     // Catch:{ all -> 0x056f }
            r11 = r3
            r20 = r4
            if (r10 == 0) goto L_0x00c3
            java.lang.String r14 = "auto"
            java.lang.String r3 = r10.f40232b     // Catch:{ all -> 0x056f }
            boolean r3 = r14.equals(r3)     // Catch:{ all -> 0x056f }
            if (r3 == 0) goto L_0x00c1
            goto L_0x00c3
        L_0x00c1:
            r4 = r15
            goto L_0x00fd
        L_0x00c3:
            java.lang.Boolean r3 = r2.f40523x     // Catch:{ all -> 0x056f }
            if (r3 == 0) goto L_0x00f7
            com.google.android.gms.measurement.internal.zzlk r0 = new com.google.android.gms.measurement.internal.zzlk     // Catch:{ all -> 0x056f }
            java.lang.String r3 = "_npa"
            java.lang.Boolean r4 = r2.f40523x     // Catch:{ all -> 0x056f }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x056f }
            if (r15 == r4) goto L_0x00d6
            r18 = 0
            goto L_0x00d8
        L_0x00d6:
            r18 = 1
        L_0x00d8:
            java.lang.Long r18 = java.lang.Long.valueOf(r18)     // Catch:{ all -> 0x056f }
            java.lang.String r19 = "auto"
            r4 = 0
            r14 = r0
            r4 = r15
            r15 = r3
            r16 = r12
            r14.<init>(r15, r16, r18, r19)     // Catch:{ all -> 0x056f }
            if (r10 == 0) goto L_0x00f3
            java.lang.Object r3 = r10.f40235e     // Catch:{ all -> 0x056f }
            java.lang.Long r10 = r0.f40502d     // Catch:{ all -> 0x056f }
            boolean r3 = r3.equals(r10)     // Catch:{ all -> 0x056f }
            if (r3 != 0) goto L_0x00fd
        L_0x00f3:
            r1.B(r0, r2)     // Catch:{ all -> 0x056f }
            goto L_0x00fd
        L_0x00f7:
            r4 = r15
            if (r10 == 0) goto L_0x00fd
            r1.u(r0, r2)     // Catch:{ all -> 0x056f }
        L_0x00fd:
            com.google.android.gms.measurement.internal.k r0 = r1.f40067c     // Catch:{ all -> 0x056f }
            R(r0)     // Catch:{ all -> 0x056f }
            java.lang.String r3 = r2.f40506a     // Catch:{ all -> 0x056f }
            java.lang.Object r3 = com.google.android.gms.common.internal.p.k(r3)     // Catch:{ all -> 0x056f }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x056f }
            com.google.android.gms.measurement.internal.q5 r0 = r0.R(r3)     // Catch:{ all -> 0x056f }
            if (r0 == 0) goto L_0x01ef
            com.google.android.gms.measurement.internal.t9 r10 = r23.h0()     // Catch:{ all -> 0x056f }
            java.lang.String r14 = r2.f40507b     // Catch:{ all -> 0x056f }
            java.lang.String r15 = r0.a()     // Catch:{ all -> 0x056f }
            java.lang.String r3 = r2.f40522w     // Catch:{ all -> 0x056f }
            java.lang.String r4 = r0.j0()     // Catch:{ all -> 0x056f }
            boolean r3 = r10.d0(r14, r15, r3, r4)     // Catch:{ all -> 0x056f }
            if (r3 == 0) goto L_0x01ef
            com.google.android.gms.measurement.internal.q3 r3 = r23.d()     // Catch:{ all -> 0x056f }
            com.google.android.gms.measurement.internal.o3 r3 = r3.w()     // Catch:{ all -> 0x056f }
            java.lang.String r4 = "New GMP App Id passed in. Removing cached database data. appId"
            java.lang.String r10 = r0.l0()     // Catch:{ all -> 0x056f }
            java.lang.Object r10 = com.google.android.gms.measurement.internal.q3.z(r10)     // Catch:{ all -> 0x056f }
            r3.b(r4, r10)     // Catch:{ all -> 0x056f }
            com.google.android.gms.measurement.internal.k r3 = r1.f40067c     // Catch:{ all -> 0x056f }
            R(r3)     // Catch:{ all -> 0x056f }
            java.lang.String r4 = r0.l0()     // Catch:{ all -> 0x056f }
            r3.i()     // Catch:{ all -> 0x056f }
            r3.h()     // Catch:{ all -> 0x056f }
            com.google.android.gms.common.internal.p.g(r4)     // Catch:{ all -> 0x056f }
            android.database.sqlite.SQLiteDatabase r0 = r3.P()     // Catch:{ SQLiteException -> 0x01d5 }
            r10 = 1
            java.lang.String[] r14 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x01d5 }
            r10 = 0
            r14[r10] = r4     // Catch:{ SQLiteException -> 0x01d5 }
            java.lang.String r10 = "events"
            int r10 = r0.delete(r10, r8, r14)     // Catch:{ SQLiteException -> 0x01d5 }
            java.lang.String r15 = "user_attributes"
            int r15 = r0.delete(r15, r8, r14)     // Catch:{ SQLiteException -> 0x01d5 }
            int r10 = r10 + r15
            java.lang.String r15 = "conditional_properties"
            int r15 = r0.delete(r15, r8, r14)     // Catch:{ SQLiteException -> 0x01d5 }
            int r10 = r10 + r15
            java.lang.String r15 = "apps"
            int r15 = r0.delete(r15, r8, r14)     // Catch:{ SQLiteException -> 0x01d5 }
            int r10 = r10 + r15
            java.lang.String r15 = "raw_events"
            int r15 = r0.delete(r15, r8, r14)     // Catch:{ SQLiteException -> 0x01d5 }
            int r10 = r10 + r15
            java.lang.String r15 = "raw_events_metadata"
            int r15 = r0.delete(r15, r8, r14)     // Catch:{ SQLiteException -> 0x01d5 }
            int r10 = r10 + r15
            java.lang.String r15 = "event_filters"
            int r15 = r0.delete(r15, r8, r14)     // Catch:{ SQLiteException -> 0x01d5 }
            int r10 = r10 + r15
            java.lang.String r15 = "property_filters"
            int r15 = r0.delete(r15, r8, r14)     // Catch:{ SQLiteException -> 0x01d5 }
            int r10 = r10 + r15
            java.lang.String r15 = "audience_filter_values"
            int r15 = r0.delete(r15, r8, r14)     // Catch:{ SQLiteException -> 0x01d5 }
            int r10 = r10 + r15
            java.lang.String r15 = "consent_settings"
            int r15 = r0.delete(r15, r8, r14)     // Catch:{ SQLiteException -> 0x01d5 }
            int r10 = r10 + r15
            com.google.android.gms.internal.measurement.zzpk.zzc()     // Catch:{ SQLiteException -> 0x01d5 }
            com.google.android.gms.measurement.internal.u4 r15 = r3.f40059a     // Catch:{ SQLiteException -> 0x01d5 }
            com.google.android.gms.measurement.internal.g r15 = r15.z()     // Catch:{ SQLiteException -> 0x01d5 }
            r21 = r11
            com.google.android.gms.measurement.internal.f3 r11 = com.google.android.gms.measurement.internal.g3.f39848v0     // Catch:{ SQLiteException -> 0x01d1 }
            r22 = r6
            r6 = 0
            boolean r11 = r15.B(r6, r11)     // Catch:{ SQLiteException -> 0x01cf }
            if (r11 == 0) goto L_0x01b9
            java.lang.String r6 = "default_event_params"
            int r0 = r0.delete(r6, r8, r14)     // Catch:{ SQLiteException -> 0x01cf }
            int r10 = r10 + r0
        L_0x01b9:
            if (r10 <= 0) goto L_0x01ed
            com.google.android.gms.measurement.internal.u4 r0 = r3.f40059a     // Catch:{ SQLiteException -> 0x01cf }
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()     // Catch:{ SQLiteException -> 0x01cf }
            com.google.android.gms.measurement.internal.o3 r0 = r0.v()     // Catch:{ SQLiteException -> 0x01cf }
            java.lang.String r6 = "Deleted application data. app, records"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r10)     // Catch:{ SQLiteException -> 0x01cf }
            r0.c(r6, r4, r8)     // Catch:{ SQLiteException -> 0x01cf }
            goto L_0x01ed
        L_0x01cf:
            r0 = move-exception
            goto L_0x01da
        L_0x01d1:
            r0 = move-exception
            r22 = r6
            goto L_0x01da
        L_0x01d5:
            r0 = move-exception
            r22 = r6
            r21 = r11
        L_0x01da:
            com.google.android.gms.measurement.internal.u4 r3 = r3.f40059a     // Catch:{ all -> 0x056f }
            com.google.android.gms.measurement.internal.q3 r3 = r3.d()     // Catch:{ all -> 0x056f }
            com.google.android.gms.measurement.internal.o3 r3 = r3.r()     // Catch:{ all -> 0x056f }
            java.lang.String r6 = "Error deleting application data. appId, error"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.q3.z(r4)     // Catch:{ all -> 0x056f }
            r3.c(r6, r4, r0)     // Catch:{ all -> 0x056f }
        L_0x01ed:
            r0 = 0
            goto L_0x01f3
        L_0x01ef:
            r22 = r6
            r21 = r11
        L_0x01f3:
            if (r0 == 0) goto L_0x0249
            long r3 = r0.R()     // Catch:{ all -> 0x056f }
            r10 = -2147483648(0xffffffff80000000, double:NaN)
            int r3 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r3 == 0) goto L_0x020c
            long r3 = r0.R()     // Catch:{ all -> 0x056f }
            long r14 = r2.f40515k     // Catch:{ all -> 0x056f }
            int r3 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r3 == 0) goto L_0x020c
            r15 = 1
            goto L_0x020d
        L_0x020c:
            r15 = 0
        L_0x020d:
            java.lang.String r3 = r0.o0()     // Catch:{ all -> 0x056f }
            long r16 = r0.R()     // Catch:{ all -> 0x056f }
            int r0 = (r16 > r10 ? 1 : (r16 == r10 ? 0 : -1))
            if (r0 != 0) goto L_0x0225
            if (r3 == 0) goto L_0x0225
            java.lang.String r0 = r2.f40508c     // Catch:{ all -> 0x056f }
            boolean r0 = r3.equals(r0)     // Catch:{ all -> 0x056f }
            if (r0 != 0) goto L_0x0225
            r0 = 1
            goto L_0x0226
        L_0x0225:
            r0 = 0
        L_0x0226:
            r0 = r0 | r15
            if (r0 == 0) goto L_0x0249
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x056f }
            r0.<init>()     // Catch:{ all -> 0x056f }
            java.lang.String r4 = "_pv"
            r0.putString(r4, r3)     // Catch:{ all -> 0x056f }
            com.google.android.gms.measurement.internal.zzau r3 = new com.google.android.gms.measurement.internal.zzau     // Catch:{ all -> 0x056f }
            java.lang.String r15 = "_au"
            com.google.android.gms.measurement.internal.zzas r4 = new com.google.android.gms.measurement.internal.zzas     // Catch:{ all -> 0x056f }
            r4.<init>(r0)     // Catch:{ all -> 0x056f }
            java.lang.String r17 = "auto"
            r14 = r3
            r16 = r4
            r18 = r12
            r14.<init>(r15, r16, r17, r18)     // Catch:{ all -> 0x056f }
            r1.j(r3, r2)     // Catch:{ all -> 0x056f }
        L_0x0249:
            r23.S(r24)     // Catch:{ all -> 0x056f }
            if (r9 != 0) goto L_0x025d
            com.google.android.gms.measurement.internal.k r0 = r1.f40067c     // Catch:{ all -> 0x056f }
            R(r0)     // Catch:{ all -> 0x056f }
            java.lang.String r3 = r2.f40506a     // Catch:{ all -> 0x056f }
            java.lang.String r4 = "_f"
            com.google.android.gms.measurement.internal.q r0 = r0.V(r3, r4)     // Catch:{ all -> 0x056f }
            r15 = 0
            goto L_0x026b
        L_0x025d:
            com.google.android.gms.measurement.internal.k r0 = r1.f40067c     // Catch:{ all -> 0x056f }
            R(r0)     // Catch:{ all -> 0x056f }
            java.lang.String r3 = r2.f40506a     // Catch:{ all -> 0x056f }
            java.lang.String r4 = "_v"
            com.google.android.gms.measurement.internal.q r0 = r0.V(r3, r4)     // Catch:{ all -> 0x056f }
            r15 = 1
        L_0x026b:
            if (r0 != 0) goto L_0x053f
            r3 = 3600000(0x36ee80, double:1.7786363E-317)
            long r8 = r12 / r3
            r10 = 1
            long r8 = r8 + r10
            long r8 = r8 * r3
            java.lang.String r3 = "_dac"
            java.lang.String r4 = "_et"
            java.lang.String r6 = "_r"
            java.lang.String r10 = "_c"
            if (r15 != 0) goto L_0x04f4
            com.google.android.gms.measurement.internal.zzlk r0 = new com.google.android.gms.measurement.internal.zzlk     // Catch:{ all -> 0x056f }
            java.lang.String r15 = "_fot"
            java.lang.Long r18 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x056f }
            java.lang.String r19 = "auto"
            r14 = r0
            r16 = r12
            r14.<init>(r15, r16, r18, r19)     // Catch:{ all -> 0x056f }
            r1.B(r0, r2)     // Catch:{ all -> 0x056f }
            com.google.android.gms.measurement.internal.s4 r0 = r23.f()     // Catch:{ all -> 0x056f }
            r0.h()     // Catch:{ all -> 0x056f }
            com.google.android.gms.measurement.internal.h4 r0 = r1.f40075k     // Catch:{ all -> 0x056f }
            java.lang.Object r0 = com.google.android.gms.common.internal.p.k(r0)     // Catch:{ all -> 0x056f }
            r8 = r0
            com.google.android.gms.measurement.internal.h4 r8 = (com.google.android.gms.measurement.internal.h4) r8     // Catch:{ all -> 0x056f }
            java.lang.String r0 = r2.f40506a     // Catch:{ all -> 0x056f }
            if (r0 == 0) goto L_0x0394
            boolean r9 = r0.isEmpty()     // Catch:{ all -> 0x056f }
            if (r9 == 0) goto L_0x02af
            goto L_0x0394
        L_0x02af:
            com.google.android.gms.measurement.internal.u4 r9 = r8.f39891a     // Catch:{ all -> 0x056f }
            com.google.android.gms.measurement.internal.s4 r9 = r9.f()     // Catch:{ all -> 0x056f }
            r9.h()     // Catch:{ all -> 0x056f }
            boolean r9 = r8.a()     // Catch:{ all -> 0x056f }
            if (r9 != 0) goto L_0x02cf
            com.google.android.gms.measurement.internal.u4 r0 = r8.f39891a     // Catch:{ all -> 0x056f }
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()     // Catch:{ all -> 0x056f }
            com.google.android.gms.measurement.internal.o3 r0 = r0.u()     // Catch:{ all -> 0x056f }
            java.lang.String r5 = "Install Referrer Reporter is not available"
            r0.a(r5)     // Catch:{ all -> 0x056f }
            goto L_0x03a3
        L_0x02cf:
            com.google.android.gms.measurement.internal.g4 r9 = new com.google.android.gms.measurement.internal.g4     // Catch:{ all -> 0x056f }
            r9.<init>(r8, r0)     // Catch:{ all -> 0x056f }
            com.google.android.gms.measurement.internal.u4 r0 = r8.f39891a     // Catch:{ all -> 0x056f }
            com.google.android.gms.measurement.internal.s4 r0 = r0.f()     // Catch:{ all -> 0x056f }
            r0.h()     // Catch:{ all -> 0x056f }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x056f }
            java.lang.String r11 = "com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE"
            r0.<init>(r11)     // Catch:{ all -> 0x056f }
            android.content.ComponentName r11 = new android.content.ComponentName     // Catch:{ all -> 0x056f }
            java.lang.String r14 = "com.google.android.finsky.externalreferrer.GetInstallReferrerService"
            r11.<init>(r5, r14)     // Catch:{ all -> 0x056f }
            r0.setComponent(r11)     // Catch:{ all -> 0x056f }
            com.google.android.gms.measurement.internal.u4 r11 = r8.f39891a     // Catch:{ all -> 0x056f }
            android.content.Context r11 = r11.c()     // Catch:{ all -> 0x056f }
            android.content.pm.PackageManager r11 = r11.getPackageManager()     // Catch:{ all -> 0x056f }
            if (r11 != 0) goto L_0x030b
            com.google.android.gms.measurement.internal.u4 r0 = r8.f39891a     // Catch:{ all -> 0x056f }
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()     // Catch:{ all -> 0x056f }
            com.google.android.gms.measurement.internal.o3 r0 = r0.y()     // Catch:{ all -> 0x056f }
            java.lang.String r5 = "Failed to obtain Package Manager to verify binding conditions for Install Referrer"
            r0.a(r5)     // Catch:{ all -> 0x056f }
            goto L_0x03a3
        L_0x030b:
            r14 = 0
            java.util.List r11 = r11.queryIntentServices(r0, r14)     // Catch:{ all -> 0x056f }
            if (r11 == 0) goto L_0x0384
            boolean r15 = r11.isEmpty()     // Catch:{ all -> 0x056f }
            if (r15 != 0) goto L_0x0384
            java.lang.Object r11 = r11.get(r14)     // Catch:{ all -> 0x056f }
            android.content.pm.ResolveInfo r11 = (android.content.pm.ResolveInfo) r11     // Catch:{ all -> 0x056f }
            android.content.pm.ServiceInfo r11 = r11.serviceInfo     // Catch:{ all -> 0x056f }
            if (r11 == 0) goto L_0x03a3
            java.lang.String r14 = r11.packageName     // Catch:{ all -> 0x056f }
            java.lang.String r11 = r11.name     // Catch:{ all -> 0x056f }
            if (r11 == 0) goto L_0x0374
            boolean r5 = r5.equals(r14)     // Catch:{ all -> 0x056f }
            if (r5 == 0) goto L_0x0374
            boolean r5 = r8.a()     // Catch:{ all -> 0x056f }
            if (r5 == 0) goto L_0x0374
            android.content.Intent r5 = new android.content.Intent     // Catch:{ all -> 0x056f }
            r5.<init>(r0)     // Catch:{ all -> 0x056f }
            le.b r0 = le.b.b()     // Catch:{ RuntimeException -> 0x035f }
            com.google.android.gms.measurement.internal.u4 r11 = r8.f39891a     // Catch:{ RuntimeException -> 0x035f }
            android.content.Context r11 = r11.c()     // Catch:{ RuntimeException -> 0x035f }
            r14 = 1
            boolean r0 = r0.a(r11, r5, r9, r14)     // Catch:{ RuntimeException -> 0x035f }
            com.google.android.gms.measurement.internal.u4 r5 = r8.f39891a     // Catch:{ RuntimeException -> 0x035f }
            com.google.android.gms.measurement.internal.q3 r5 = r5.d()     // Catch:{ RuntimeException -> 0x035f }
            com.google.android.gms.measurement.internal.o3 r5 = r5.v()     // Catch:{ RuntimeException -> 0x035f }
            java.lang.String r9 = "Install Referrer Service is"
            if (r0 == 0) goto L_0x0359
            java.lang.String r0 = "available"
            goto L_0x035b
        L_0x0359:
            java.lang.String r0 = "not available"
        L_0x035b:
            r5.b(r9, r0)     // Catch:{ RuntimeException -> 0x035f }
            goto L_0x03a3
        L_0x035f:
            r0 = move-exception
            com.google.android.gms.measurement.internal.u4 r5 = r8.f39891a     // Catch:{ all -> 0x056f }
            com.google.android.gms.measurement.internal.q3 r5 = r5.d()     // Catch:{ all -> 0x056f }
            com.google.android.gms.measurement.internal.o3 r5 = r5.r()     // Catch:{ all -> 0x056f }
            java.lang.String r8 = "Exception occurred while binding to Install Referrer Service"
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x056f }
            r5.b(r8, r0)     // Catch:{ all -> 0x056f }
            goto L_0x03a3
        L_0x0374:
            com.google.android.gms.measurement.internal.u4 r0 = r8.f39891a     // Catch:{ all -> 0x056f }
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()     // Catch:{ all -> 0x056f }
            com.google.android.gms.measurement.internal.o3 r0 = r0.w()     // Catch:{ all -> 0x056f }
            java.lang.String r5 = "Play Store version 8.3.73 or higher required for Install Referrer"
            r0.a(r5)     // Catch:{ all -> 0x056f }
            goto L_0x03a3
        L_0x0384:
            com.google.android.gms.measurement.internal.u4 r0 = r8.f39891a     // Catch:{ all -> 0x056f }
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()     // Catch:{ all -> 0x056f }
            com.google.android.gms.measurement.internal.o3 r0 = r0.u()     // Catch:{ all -> 0x056f }
            java.lang.String r5 = "Play Service for fetching Install Referrer is unavailable on device"
            r0.a(r5)     // Catch:{ all -> 0x056f }
            goto L_0x03a3
        L_0x0394:
            com.google.android.gms.measurement.internal.u4 r0 = r8.f39891a     // Catch:{ all -> 0x056f }
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()     // Catch:{ all -> 0x056f }
            com.google.android.gms.measurement.internal.o3 r0 = r0.y()     // Catch:{ all -> 0x056f }
            java.lang.String r5 = "Install Referrer Reporter was called with invalid app package name"
            r0.a(r5)     // Catch:{ all -> 0x056f }
        L_0x03a3:
            com.google.android.gms.measurement.internal.s4 r0 = r23.f()     // Catch:{ all -> 0x056f }
            r0.h()     // Catch:{ all -> 0x056f }
            r23.g()     // Catch:{ all -> 0x056f }
            android.os.Bundle r5 = new android.os.Bundle     // Catch:{ all -> 0x056f }
            r5.<init>()     // Catch:{ all -> 0x056f }
            r8 = 1
            r5.putLong(r10, r8)     // Catch:{ all -> 0x056f }
            r5.putLong(r6, r8)     // Catch:{ all -> 0x056f }
            r8 = 0
            r5.putLong(r7, r8)     // Catch:{ all -> 0x056f }
            r6 = r22
            r5.putLong(r6, r8)     // Catch:{ all -> 0x056f }
            r10 = r20
            r5.putLong(r10, r8)     // Catch:{ all -> 0x056f }
            r11 = r21
            r5.putLong(r11, r8)     // Catch:{ all -> 0x056f }
            r8 = 1
            r5.putLong(r4, r8)     // Catch:{ all -> 0x056f }
            boolean r0 = r2.f40521t     // Catch:{ all -> 0x056f }
            if (r0 == 0) goto L_0x03da
            r5.putLong(r3, r8)     // Catch:{ all -> 0x056f }
        L_0x03da:
            java.lang.String r0 = r2.f40506a     // Catch:{ all -> 0x056f }
            java.lang.Object r0 = com.google.android.gms.common.internal.p.k(r0)     // Catch:{ all -> 0x056f }
            r3 = r0
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x056f }
            com.google.android.gms.measurement.internal.k r0 = r1.f40067c     // Catch:{ all -> 0x056f }
            R(r0)     // Catch:{ all -> 0x056f }
            com.google.android.gms.common.internal.p.g(r3)     // Catch:{ all -> 0x056f }
            r0.h()     // Catch:{ all -> 0x056f }
            r0.i()     // Catch:{ all -> 0x056f }
            java.lang.String r4 = "first_open_count"
            long r8 = r0.L(r3, r4)     // Catch:{ all -> 0x056f }
            com.google.android.gms.measurement.internal.u4 r0 = r1.f40076l     // Catch:{ all -> 0x056f }
            android.content.Context r0 = r0.c()     // Catch:{ all -> 0x056f }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ all -> 0x056f }
            if (r0 != 0) goto L_0x0418
            com.google.android.gms.measurement.internal.q3 r0 = r23.d()     // Catch:{ all -> 0x056f }
            com.google.android.gms.measurement.internal.o3 r0 = r0.r()     // Catch:{ all -> 0x056f }
            java.lang.String r4 = "PackageManager is null, first open report might be inaccurate. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.q3.z(r3)     // Catch:{ all -> 0x056f }
            r0.b(r4, r3)     // Catch:{ all -> 0x056f }
        L_0x0414:
            r3 = 0
            goto L_0x04d6
        L_0x0418:
            com.google.android.gms.measurement.internal.u4 r0 = r1.f40076l     // Catch:{ NameNotFoundException -> 0x0428 }
            android.content.Context r0 = r0.c()     // Catch:{ NameNotFoundException -> 0x0428 }
            oe.c r0 = oe.d.a(r0)     // Catch:{ NameNotFoundException -> 0x0428 }
            r4 = 0
            android.content.pm.PackageInfo r0 = r0.e(r3, r4)     // Catch:{ NameNotFoundException -> 0x0428 }
            goto L_0x043b
        L_0x0428:
            r0 = move-exception
            com.google.android.gms.measurement.internal.q3 r4 = r23.d()     // Catch:{ all -> 0x056f }
            com.google.android.gms.measurement.internal.o3 r4 = r4.r()     // Catch:{ all -> 0x056f }
            java.lang.String r14 = "Package info is null, first open report might be inaccurate. appId"
            java.lang.Object r15 = com.google.android.gms.measurement.internal.q3.z(r3)     // Catch:{ all -> 0x056f }
            r4.c(r14, r15, r0)     // Catch:{ all -> 0x056f }
            r0 = 0
        L_0x043b:
            if (r0 == 0) goto L_0x0490
            long r14 = r0.firstInstallTime     // Catch:{ all -> 0x056f }
            r16 = 0
            int r4 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r4 == 0) goto L_0x0490
            r20 = r10
            r21 = r11
            long r10 = r0.lastUpdateTime     // Catch:{ all -> 0x056f }
            int r0 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1))
            if (r0 == 0) goto L_0x0471
            com.google.android.gms.measurement.internal.g r0 = r23.U()     // Catch:{ all -> 0x056f }
            com.google.android.gms.measurement.internal.f3 r4 = com.google.android.gms.measurement.internal.g3.f39816f0     // Catch:{ all -> 0x056f }
            r10 = 0
            boolean r0 = r0.B(r10, r4)     // Catch:{ all -> 0x056f }
            if (r0 == 0) goto L_0x046b
            r14 = 0
            int r0 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r0 != 0) goto L_0x0469
            r14 = 1
            r5.putLong(r7, r14)     // Catch:{ all -> 0x056f }
            r8 = 0
        L_0x0469:
            r15 = 0
            goto L_0x0473
        L_0x046b:
            r14 = 1
            r5.putLong(r7, r14)     // Catch:{ all -> 0x056f }
            goto L_0x0469
        L_0x0471:
            r10 = 0
            r15 = 1
        L_0x0473:
            com.google.android.gms.measurement.internal.zzlk r0 = new com.google.android.gms.measurement.internal.zzlk     // Catch:{ all -> 0x056f }
            java.lang.String r4 = "_fi"
            r7 = 1
            if (r7 == r15) goto L_0x047d
            r14 = 0
            goto L_0x047f
        L_0x047d:
            r14 = 1
        L_0x047f:
            java.lang.Long r18 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x056f }
            java.lang.String r19 = "auto"
            r14 = r0
            r15 = r4
            r16 = r12
            r14.<init>(r15, r16, r18, r19)     // Catch:{ all -> 0x056f }
            r1.B(r0, r2)     // Catch:{ all -> 0x056f }
            goto L_0x0495
        L_0x0490:
            r20 = r10
            r21 = r11
            r10 = 0
        L_0x0495:
            com.google.android.gms.measurement.internal.u4 r0 = r1.f40076l     // Catch:{ NameNotFoundException -> 0x04a5 }
            android.content.Context r0 = r0.c()     // Catch:{ NameNotFoundException -> 0x04a5 }
            oe.c r0 = oe.d.a(r0)     // Catch:{ NameNotFoundException -> 0x04a5 }
            r4 = 0
            android.content.pm.ApplicationInfo r3 = r0.c(r3, r4)     // Catch:{ NameNotFoundException -> 0x04a5 }
            goto L_0x04b8
        L_0x04a5:
            r0 = move-exception
            com.google.android.gms.measurement.internal.q3 r4 = r23.d()     // Catch:{ all -> 0x056f }
            com.google.android.gms.measurement.internal.o3 r4 = r4.r()     // Catch:{ all -> 0x056f }
            java.lang.String r7 = "Application info is null, first open report might be inaccurate. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.q3.z(r3)     // Catch:{ all -> 0x056f }
            r4.c(r7, r3, r0)     // Catch:{ all -> 0x056f }
            r3 = r10
        L_0x04b8:
            if (r3 == 0) goto L_0x0414
            int r0 = r3.flags     // Catch:{ all -> 0x056f }
            r4 = 1
            r0 = r0 & r4
            if (r0 == 0) goto L_0x04c7
            r4 = r20
            r10 = 1
            r5.putLong(r4, r10)     // Catch:{ all -> 0x056f }
        L_0x04c7:
            int r0 = r3.flags     // Catch:{ all -> 0x056f }
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0414
            r3 = r21
            r10 = 1
            r5.putLong(r3, r10)     // Catch:{ all -> 0x056f }
            goto L_0x0414
        L_0x04d6:
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x04dd
            r5.putLong(r6, r8)     // Catch:{ all -> 0x056f }
        L_0x04dd:
            com.google.android.gms.measurement.internal.zzau r0 = new com.google.android.gms.measurement.internal.zzau     // Catch:{ all -> 0x056f }
            java.lang.String r15 = "_f"
            com.google.android.gms.measurement.internal.zzas r3 = new com.google.android.gms.measurement.internal.zzas     // Catch:{ all -> 0x056f }
            r3.<init>(r5)     // Catch:{ all -> 0x056f }
            java.lang.String r17 = "auto"
            r14 = r0
            r16 = r3
            r18 = r12
            r14.<init>(r15, r16, r17, r18)     // Catch:{ all -> 0x056f }
            r1.l(r0, r2)     // Catch:{ all -> 0x056f }
            goto L_0x055e
        L_0x04f4:
            com.google.android.gms.measurement.internal.zzlk r0 = new com.google.android.gms.measurement.internal.zzlk     // Catch:{ all -> 0x056f }
            java.lang.String r15 = "_fvt"
            java.lang.Long r18 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x056f }
            java.lang.String r19 = "auto"
            r14 = r0
            r16 = r12
            r14.<init>(r15, r16, r18, r19)     // Catch:{ all -> 0x056f }
            r1.B(r0, r2)     // Catch:{ all -> 0x056f }
            com.google.android.gms.measurement.internal.s4 r0 = r23.f()     // Catch:{ all -> 0x056f }
            r0.h()     // Catch:{ all -> 0x056f }
            r23.g()     // Catch:{ all -> 0x056f }
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x056f }
            r0.<init>()     // Catch:{ all -> 0x056f }
            r7 = 1
            r0.putLong(r10, r7)     // Catch:{ all -> 0x056f }
            r0.putLong(r6, r7)     // Catch:{ all -> 0x056f }
            r0.putLong(r4, r7)     // Catch:{ all -> 0x056f }
            boolean r4 = r2.f40521t     // Catch:{ all -> 0x056f }
            if (r4 == 0) goto L_0x0528
            r0.putLong(r3, r7)     // Catch:{ all -> 0x056f }
        L_0x0528:
            com.google.android.gms.measurement.internal.zzau r3 = new com.google.android.gms.measurement.internal.zzau     // Catch:{ all -> 0x056f }
            java.lang.String r15 = "_v"
            com.google.android.gms.measurement.internal.zzas r4 = new com.google.android.gms.measurement.internal.zzas     // Catch:{ all -> 0x056f }
            r4.<init>(r0)     // Catch:{ all -> 0x056f }
            java.lang.String r17 = "auto"
            r14 = r3
            r16 = r4
            r18 = r12
            r14.<init>(r15, r16, r17, r18)     // Catch:{ all -> 0x056f }
            r1.l(r3, r2)     // Catch:{ all -> 0x056f }
            goto L_0x055e
        L_0x053f:
            boolean r0 = r2.f40514j     // Catch:{ all -> 0x056f }
            if (r0 == 0) goto L_0x055e
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x056f }
            r0.<init>()     // Catch:{ all -> 0x056f }
            com.google.android.gms.measurement.internal.zzau r3 = new com.google.android.gms.measurement.internal.zzau     // Catch:{ all -> 0x056f }
            java.lang.String r15 = "_cd"
            com.google.android.gms.measurement.internal.zzas r4 = new com.google.android.gms.measurement.internal.zzas     // Catch:{ all -> 0x056f }
            r4.<init>(r0)     // Catch:{ all -> 0x056f }
            java.lang.String r17 = "auto"
            r14 = r3
            r16 = r4
            r18 = r12
            r14.<init>(r15, r16, r17, r18)     // Catch:{ all -> 0x056f }
            r1.l(r3, r2)     // Catch:{ all -> 0x056f }
        L_0x055e:
            com.google.android.gms.measurement.internal.k r0 = r1.f40067c     // Catch:{ all -> 0x056f }
            R(r0)     // Catch:{ all -> 0x056f }
            r0.o()     // Catch:{ all -> 0x056f }
            com.google.android.gms.measurement.internal.k r0 = r1.f40067c
            R(r0)
            r0.f0()
            return
        L_0x056f:
            r0 = move-exception
            com.google.android.gms.measurement.internal.k r2 = r1.f40067c
            R(r2)
            r2.f0()
            throw r0
        L_0x0579:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.n9.q(com.google.android.gms.measurement.internal.zzq):void");
    }

    /* access modifiers changed from: package-private */
    public final void r() {
        this.f40081q++;
    }

    /* access modifiers changed from: package-private */
    public final void s(zzac zzac) {
        zzq I = I((String) p.k(zzac.f40479a));
        if (I != null) {
            t(zzac, I);
        }
    }

    /* access modifiers changed from: package-private */
    public final void t(zzac zzac, zzq zzq) {
        Bundle bundle;
        p.k(zzac);
        p.g(zzac.f40479a);
        p.k(zzac.f40481c);
        p.g(zzac.f40481c.f40500b);
        f().h();
        g();
        if (Q(zzq)) {
            if (zzq.f40513h) {
                k kVar = this.f40067c;
                R(kVar);
                kVar.e0();
                try {
                    S(zzq);
                    String str = (String) p.k(zzac.f40479a);
                    k kVar2 = this.f40067c;
                    R(kVar2);
                    zzac S = kVar2.S(str, zzac.f40481c.f40500b);
                    if (S != null) {
                        d().q().c("Removing conditional user property", zzac.f40479a, this.f40076l.D().f(zzac.f40481c.f40500b));
                        k kVar3 = this.f40067c;
                        R(kVar3);
                        kVar3.J(str, zzac.f40481c.f40500b);
                        if (S.f40483e) {
                            k kVar4 = this.f40067c;
                            R(kVar4);
                            kVar4.m(str, zzac.f40481c.f40500b);
                        }
                        zzau zzau = zzac.f40489l;
                        if (zzau != null) {
                            zzas zzas = zzau.f40492b;
                            if (zzas != null) {
                                bundle = zzas.Y();
                            } else {
                                bundle = null;
                            }
                            D((zzau) p.k(h0().y0(str, ((zzau) p.k(zzac.f40489l)).f40491a, bundle, S.f40480b, zzac.f40489l.f40494d, true, true)), zzq);
                        }
                    } else {
                        d().w().c("Conditional user property doesn't exist", q3.z(zzac.f40479a), this.f40076l.D().f(zzac.f40481c.f40500b));
                    }
                    k kVar5 = this.f40067c;
                    R(kVar5);
                    kVar5.o();
                } finally {
                    k kVar6 = this.f40067c;
                    R(kVar6);
                    kVar6.f0();
                }
            } else {
                S(zzq);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void u(String str, zzq zzq) {
        long j10;
        f().h();
        g();
        if (Q(zzq)) {
            if (!zzq.f40513h) {
                S(zzq);
            } else if (!"_npa".equals(str) || zzq.f40523x == null) {
                d().q().b("Removing user property", this.f40076l.D().f(str));
                k kVar = this.f40067c;
                R(kVar);
                kVar.e0();
                try {
                    S(zzq);
                    if ("_id".equals(str)) {
                        k kVar2 = this.f40067c;
                        R(kVar2);
                        kVar2.m((String) p.k(zzq.f40506a), "_lair");
                    }
                    k kVar3 = this.f40067c;
                    R(kVar3);
                    kVar3.m((String) p.k(zzq.f40506a), str);
                    k kVar4 = this.f40067c;
                    R(kVar4);
                    kVar4.o();
                    d().q().b("User property removed", this.f40076l.D().f(str));
                } finally {
                    k kVar5 = this.f40067c;
                    R(kVar5);
                    kVar5.f0();
                }
            } else {
                d().q().a("Falling back to manifest metadata value for ad personalization");
                long currentTimeMillis = a().currentTimeMillis();
                if (true != zzq.f40523x.booleanValue()) {
                    j10 = 0;
                } else {
                    j10 = 1;
                }
                B(new zzlk("_npa", currentTimeMillis, Long.valueOf(j10), "auto"), zzq);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void v(zzq zzq) {
        if (this.f40088x != null) {
            ArrayList arrayList = new ArrayList();
            this.f40089y = arrayList;
            arrayList.addAll(this.f40088x);
        }
        k kVar = this.f40067c;
        R(kVar);
        String str = (String) p.k(zzq.f40506a);
        p.g(str);
        kVar.h();
        kVar.i();
        try {
            SQLiteDatabase P = kVar.P();
            String[] strArr = {str};
            int delete = P.delete("apps", "app_id=?", strArr) + P.delete(Constants.Params.API_EVENTS_STATE, "app_id=?", strArr) + P.delete(DataplanFilterImpl.USER_ATTRIBUTES_KEY, "app_id=?", strArr) + P.delete("conditional_properties", "app_id=?", strArr) + P.delete("raw_events", "app_id=?", strArr) + P.delete("raw_events_metadata", "app_id=?", strArr) + P.delete("queue", "app_id=?", strArr) + P.delete("audience_filter_values", "app_id=?", strArr) + P.delete("main_event_params", "app_id=?", strArr) + P.delete("default_event_params", "app_id=?", strArr);
            if (delete > 0) {
                kVar.f40059a.d().v().c("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e10) {
            kVar.f40059a.d().r().c("Error resetting analytics data. appId, error", q3.z(str), e10);
        }
        if (zzq.f40513h) {
            q(zzq);
        }
    }

    public final void w(String str, z6 z6Var) {
        f().h();
        String str2 = this.D;
        if (str2 == null || str2.equals(str) || z6Var != null) {
            this.D = str;
            this.C = z6Var;
        }
    }

    /* access modifiers changed from: protected */
    public final void x() {
        f().h();
        k kVar = this.f40067c;
        R(kVar);
        kVar.h0();
        if (this.f40073i.f39966g.a() == 0) {
            this.f40073i.f39966g.b(a().currentTimeMillis());
        }
        M();
    }

    /* access modifiers changed from: package-private */
    public final void y(zzac zzac) {
        zzq I = I((String) p.k(zzac.f40479a));
        if (I != null) {
            z(zzac, I);
        }
    }

    /* access modifiers changed from: package-private */
    public final void z(zzac zzac, zzq zzq) {
        p.k(zzac);
        p.g(zzac.f40479a);
        p.k(zzac.f40480b);
        p.k(zzac.f40481c);
        p.g(zzac.f40481c.f40500b);
        f().h();
        g();
        if (Q(zzq)) {
            if (!zzq.f40513h) {
                S(zzq);
                return;
            }
            zzac zzac2 = new zzac(zzac);
            boolean z10 = false;
            zzac2.f40483e = false;
            k kVar = this.f40067c;
            R(kVar);
            kVar.e0();
            try {
                k kVar2 = this.f40067c;
                R(kVar2);
                zzac S = kVar2.S((String) p.k(zzac2.f40479a), zzac2.f40481c.f40500b);
                if (S != null && !S.f40480b.equals(zzac2.f40480b)) {
                    d().w().d("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.f40076l.D().f(zzac2.f40481c.f40500b), zzac2.f40480b, S.f40480b);
                }
                if (S != null && S.f40483e) {
                    zzac2.f40480b = S.f40480b;
                    zzac2.f40482d = S.f40482d;
                    zzac2.f40486h = S.f40486h;
                    zzac2.f40484f = S.f40484f;
                    zzac2.f40487j = S.f40487j;
                    zzac2.f40483e = true;
                    zzlk zzlk = zzac2.f40481c;
                    zzac2.f40481c = new zzlk(zzlk.f40500b, S.f40481c.f40501c, zzlk.S(), S.f40481c.f40504f);
                } else if (TextUtils.isEmpty(zzac2.f40484f)) {
                    zzlk zzlk2 = zzac2.f40481c;
                    zzac2.f40481c = new zzlk(zzlk2.f40500b, zzac2.f40482d, zzlk2.S(), zzac2.f40481c.f40504f);
                    zzac2.f40483e = true;
                    z10 = true;
                }
                if (zzac2.f40483e) {
                    zzlk zzlk3 = zzac2.f40481c;
                    r9 r9Var = new r9((String) p.k(zzac2.f40479a), zzac2.f40480b, zzlk3.f40500b, zzlk3.f40501c, p.k(zzlk3.S()));
                    k kVar3 = this.f40067c;
                    R(kVar3);
                    if (kVar3.x(r9Var)) {
                        d().q().d("User property updated immediately", zzac2.f40479a, this.f40076l.D().f(r9Var.f40233c), r9Var.f40235e);
                    } else {
                        d().r().d("(2)Too many active user properties, ignoring", q3.z(zzac2.f40479a), this.f40076l.D().f(r9Var.f40233c), r9Var.f40235e);
                    }
                    if (z10 && zzac2.f40487j != null) {
                        D(new zzau(zzac2.f40487j, zzac2.f40482d), zzq);
                    }
                }
                k kVar4 = this.f40067c;
                R(kVar4);
                if (kVar4.w(zzac2)) {
                    d().q().d("Conditional property added", zzac2.f40479a, this.f40076l.D().f(zzac2.f40481c.f40500b), zzac2.f40481c.S());
                } else {
                    d().r().d("Too many conditional properties, ignoring", q3.z(zzac2.f40479a), this.f40076l.D().f(zzac2.f40481c.f40500b), zzac2.f40481c.S());
                }
                k kVar5 = this.f40067c;
                R(kVar5);
                kVar5.o();
            } finally {
                k kVar6 = this.f40067c;
                R(kVar6);
                kVar6.f0();
            }
        }
    }
}
