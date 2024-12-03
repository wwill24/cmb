package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzfu;
import com.google.android.gms.internal.measurement.zzfv;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzfx;
import com.google.android.gms.internal.measurement.zzga;
import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzgd;
import com.google.android.gms.internal.measurement.zzge;
import com.google.android.gms.internal.measurement.zzgg;
import com.google.android.gms.internal.measurement.zzgl;
import com.google.android.gms.internal.measurement.zzgm;
import com.google.android.gms.internal.measurement.zzpz;
import com.google.android.gms.internal.measurement.zzqu;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import we.o;

final class h5 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzau f39892a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f39893b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ m5 f39894c;

    h5(m5 m5Var, zzau zzau, String str) {
        this.f39894c = m5Var;
        this.f39892a = zzau;
        this.f39893b = str;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        byte[] bArr;
        n9 n9Var;
        r9 r9Var;
        zzga zzga;
        zzgc zzgc;
        Bundle bundle;
        String str;
        q5 q5Var;
        long j10;
        String str2;
        q qVar;
        this.f39894c.f40032a.e();
        y6 d02 = this.f39894c.f40032a.d0();
        zzau zzau = this.f39892a;
        String str3 = this.f39893b;
        d02.h();
        u4.t();
        p.k(zzau);
        p.g(str3);
        if (!d02.f40059a.z().B(str3, g3.W)) {
            d02.f40059a.d().q().b("Generating ScionPayload disabled. packageName", str3);
            return new byte[0];
        } else if ("_iap".equals(zzau.f40491a) || "_iapx".equals(zzau.f40491a)) {
            zzga zza = zzgb.zza();
            d02.f39651b.V().e0();
            q5 R = d02.f39651b.V().R(str3);
            if (R == null) {
                d02.f40059a.d().q().b("Log and bundle not available. package_name", str3);
                bArr = new byte[0];
                n9Var = d02.f39651b;
            } else if (!R.O()) {
                d02.f40059a.d().q().b("Log and bundle disabled. package_name", str3);
                bArr = new byte[0];
                n9Var = d02.f39651b;
            } else {
                zzgc zzu = zzgd.zzu();
                zzu.zzad(1);
                zzu.zzZ("android");
                if (!TextUtils.isEmpty(R.l0())) {
                    zzu.zzD(R.l0());
                }
                if (!TextUtils.isEmpty(R.n0())) {
                    zzu.zzF((String) p.k(R.n0()));
                }
                if (!TextUtils.isEmpty(R.o0())) {
                    zzu.zzG((String) p.k(R.o0()));
                }
                if (R.R() != -2147483648L) {
                    zzu.zzH((int) R.R());
                }
                zzu.zzV(R.c0());
                zzu.zzP(R.a0());
                String a10 = R.a();
                String j02 = R.j0();
                if (!TextUtils.isEmpty(a10)) {
                    zzu.zzU(a10);
                } else if (!TextUtils.isEmpty(j02)) {
                    zzu.zzC(j02);
                }
                zzpz.zzc();
                if (d02.f40059a.z().B((String) null, g3.G0)) {
                    zzu.zzaj(R.h0());
                }
                o c02 = d02.f39651b.c0(str3);
                zzu.zzM(R.Z());
                if (d02.f40059a.o() && d02.f40059a.z().C(zzu.zzaq()) && c02.j(zzha.AD_STORAGE) && !TextUtils.isEmpty((CharSequence) null)) {
                    zzu.zzO((String) null);
                }
                zzu.zzL(c02.i());
                if (c02.j(zzha.AD_STORAGE) && R.N()) {
                    Pair n10 = d02.f39651b.e0().n(R.l0(), c02);
                    if (R.N() && !TextUtils.isEmpty((CharSequence) n10.first)) {
                        try {
                            zzu.zzae(y6.e((String) n10.first, Long.toString(zzau.f40494d)));
                            Object obj = n10.second;
                            if (obj != null) {
                                zzu.zzX(((Boolean) obj).booleanValue());
                            }
                        } catch (SecurityException e10) {
                            d02.f40059a.d().q().b("Resettable device id encryption failed", e10.getMessage());
                            bArr = new byte[0];
                            n9Var = d02.f39651b;
                        } catch (Throwable th2) {
                            d02.f39651b.V().f0();
                            throw th2;
                        }
                    }
                }
                d02.f40059a.A().k();
                zzu.zzN(Build.MODEL);
                d02.f40059a.A().k();
                zzu.zzY(Build.VERSION.RELEASE);
                zzu.zzak((int) d02.f40059a.A().p());
                zzu.zzao(d02.f40059a.A().q());
                try {
                    if (c02.j(zzha.ANALYTICS_STORAGE) && R.m0() != null) {
                        zzu.zzE(y6.e((String) p.k(R.m0()), Long.toString(zzau.f40494d)));
                    }
                    if (!TextUtils.isEmpty(R.p0())) {
                        zzu.zzT((String) p.k(R.p0()));
                    }
                    String l02 = R.l0();
                    List c03 = d02.f39651b.V().c0(l02);
                    Iterator it = c03.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            r9Var = null;
                            break;
                        }
                        r9Var = (r9) it.next();
                        if ("_lte".equals(r9Var.f40233c)) {
                            break;
                        }
                    }
                    if (r9Var == null || r9Var.f40235e == null) {
                        r9 r9Var2 = new r9(l02, "auto", "_lte", d02.f40059a.a().currentTimeMillis(), 0L);
                        c03.add(r9Var2);
                        d02.f39651b.V().x(r9Var2);
                    }
                    p9 g02 = d02.f39651b.g0();
                    g02.f40059a.d().v().a("Checking account type status for ad personalization signals");
                    if (g02.f40059a.A().s()) {
                        String l03 = R.l0();
                        p.k(l03);
                        if (R.N() && g02.f39651b.Z().B(l03)) {
                            g02.f40059a.d().q().a("Turning off ad personalization due to account type");
                            Iterator it2 = c03.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                } else if ("_npa".equals(((r9) it2.next()).f40233c)) {
                                    it2.remove();
                                    break;
                                }
                            }
                            c03.add(new r9(l03, "auto", "_npa", g02.f40059a.a().currentTimeMillis(), 1L));
                        }
                    }
                    zzgm[] zzgmArr = new zzgm[c03.size()];
                    for (int i10 = 0; i10 < c03.size(); i10++) {
                        zzgl zzd = zzgm.zzd();
                        zzd.zzf(((r9) c03.get(i10)).f40233c);
                        zzd.zzg(((r9) c03.get(i10)).f40234d);
                        d02.f39651b.g0().M(zzd, ((r9) c03.get(i10)).f40235e);
                        zzgmArr[i10] = (zzgm) zzd.zzaD();
                    }
                    zzu.zzj(Arrays.asList(zzgmArr));
                    r3 b10 = r3.b(zzau);
                    d02.f40059a.N().z(b10.f40216d, d02.f39651b.V().Q(str3));
                    d02.f40059a.N().B(b10, d02.f40059a.z().n(str3));
                    Bundle bundle2 = b10.f40216d;
                    bundle2.putLong("_c", 1);
                    d02.f40059a.d().q().a("Marking in-app purchase as real-time");
                    bundle2.putLong("_r", 1);
                    bundle2.putString("_o", zzau.f40493c);
                    if (d02.f40059a.N().U(zzu.zzaq())) {
                        d02.f40059a.N().D(bundle2, "_dbg", 1L);
                        d02.f40059a.N().D(bundle2, "_r", 1L);
                    }
                    q V = d02.f39651b.V().V(str3, zzau.f40491a);
                    if (V == null) {
                        zzgc = zzu;
                        q5Var = R;
                        zzga = zza;
                        str = str3;
                        bundle = bundle2;
                        str2 = null;
                        qVar = new q(str3, zzau.f40491a, 0, 0, 0, zzau.f40494d, 0, (Long) null, (Long) null, (Long) null, (Boolean) null);
                        j10 = 0;
                    } else {
                        q5Var = R;
                        zzga = zza;
                        str = str3;
                        bundle = bundle2;
                        zzgc = zzu;
                        str2 = null;
                        long j11 = V.f40150f;
                        qVar = V.c(zzau.f40494d);
                        j10 = j11;
                    }
                    d02.f39651b.V().q(qVar);
                    p pVar = new p(d02.f40059a, zzau.f40493c, str, zzau.f40491a, zzau.f40494d, j10, bundle);
                    zzfs zze = zzft.zze();
                    zze.zzm(pVar.f40125d);
                    zze.zzi(pVar.f40123b);
                    zze.zzl(pVar.f40126e);
                    r rVar = new r(pVar.f40127f);
                    while (rVar.hasNext()) {
                        String a11 = rVar.next();
                        zzfw zze2 = zzfx.zze();
                        zze2.zzj(a11);
                        Object i02 = pVar.f40127f.i0(a11);
                        if (i02 != null) {
                            d02.f39651b.g0().L(zze2, i02);
                            zze.zze(zze2);
                        }
                    }
                    zzgc zzgc2 = zzgc;
                    zzgc2.zzk(zze);
                    zzge zza2 = zzgg.zza();
                    zzfu zza3 = zzfv.zza();
                    zza3.zza(qVar.f40147c);
                    zza3.zzb(zzau.f40491a);
                    zza2.zza(zza3);
                    zzgc2.zzaa(zza2);
                    zzgc2.zzf(d02.f39651b.T().m(q5Var.l0(), Collections.emptyList(), zzgc2.zzau(), Long.valueOf(zze.zzc()), Long.valueOf(zze.zzc())));
                    if (zze.zzq()) {
                        zzgc2.zzai(zze.zzc());
                        zzgc2.zzQ(zze.zzc());
                    }
                    long d03 = q5Var.d0();
                    int i11 = (d03 > 0 ? 1 : (d03 == 0 ? 0 : -1));
                    if (i11 != 0) {
                        zzgc2.zzab(d03);
                    }
                    long f02 = q5Var.f0();
                    if (f02 != 0) {
                        zzgc2.zzac(f02);
                    } else if (i11 != 0) {
                        zzgc2.zzac(d03);
                    }
                    String d10 = q5Var.d();
                    zzqu.zzc();
                    String str4 = str;
                    if (d02.f40059a.z().B(str4, g3.f39838q0) && d10 != null) {
                        zzgc2.zzah(d10);
                    }
                    q5Var.g();
                    zzgc2.zzI((int) q5Var.e0());
                    d02.f40059a.z().q();
                    zzgc2.zzam(79000);
                    zzgc2.zzal(d02.f40059a.a().currentTimeMillis());
                    zzgc2.zzag(true);
                    if (d02.f40059a.z().B(str2, g3.f39846u0)) {
                        d02.f39651b.h(zzgc2.zzaq(), zzgc2);
                    }
                    zzga zzga2 = zzga;
                    zzga2.zza(zzgc2);
                    q5 q5Var2 = q5Var;
                    q5Var2.E(zzgc2.zzd());
                    q5Var2.C(zzgc2.zzc());
                    d02.f39651b.V().p(q5Var2);
                    d02.f39651b.V().o();
                    d02.f39651b.V().f0();
                    try {
                        return d02.f39651b.g0().Q(((zzgb) zzga2.zzaD()).zzbx());
                    } catch (IOException e11) {
                        d02.f40059a.d().r().c("Data loss. Failed to bundle and serialize. appId", q3.z(str4), e11);
                        return str2;
                    }
                } catch (SecurityException e12) {
                    d02.f40059a.d().q().b("app instance id encryption failed", e12.getMessage());
                    bArr = new byte[0];
                    n9Var = d02.f39651b;
                }
            }
            n9Var.V().f0();
            return bArr;
        } else {
            d02.f40059a.d().q().c("Generating a payload for this event is not available. package_name, event_name", str3, zzau.f40491a);
            return null;
        }
    }
}
