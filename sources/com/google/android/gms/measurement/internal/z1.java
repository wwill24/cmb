package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.collection.a;
import com.google.android.gms.common.internal.p;
import java.util.Map;

public final class z1 extends a3 {

    /* renamed from: b  reason: collision with root package name */
    private final Map f40441b = new a();

    /* renamed from: c  reason: collision with root package name */
    private final Map f40442c = new a();

    /* renamed from: d  reason: collision with root package name */
    private long f40443d;

    public z1(u4 u4Var) {
        super(u4Var);
    }

    static /* synthetic */ void i(z1 z1Var, String str, long j10) {
        z1Var.h();
        p.g(str);
        if (z1Var.f40442c.isEmpty()) {
            z1Var.f40443d = j10;
        }
        Integer num = (Integer) z1Var.f40442c.get(str);
        if (num != null) {
            z1Var.f40442c.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (z1Var.f40442c.size() >= 100) {
            z1Var.f40059a.d().w().a("Too many ads visible");
        } else {
            z1Var.f40442c.put(str, 1);
            z1Var.f40441b.put(str, Long.valueOf(j10));
        }
    }

    static /* synthetic */ void j(z1 z1Var, String str, long j10) {
        z1Var.h();
        p.g(str);
        Integer num = (Integer) z1Var.f40442c.get(str);
        if (num != null) {
            z6 s10 = z1Var.f40059a.K().s(false);
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                z1Var.f40442c.remove(str);
                Long l10 = (Long) z1Var.f40441b.get(str);
                if (l10 == null) {
                    z1Var.f40059a.d().r().a("First ad unit exposure time was never set");
                } else {
                    z1Var.f40441b.remove(str);
                    z1Var.p(str, j10 - l10.longValue(), s10);
                }
                if (z1Var.f40442c.isEmpty()) {
                    long j11 = z1Var.f40443d;
                    if (j11 == 0) {
                        z1Var.f40059a.d().r().a("First ad exposure time was never set");
                        return;
                    }
                    z1Var.o(j10 - j11, s10);
                    z1Var.f40443d = 0;
                    return;
                }
                return;
            }
            z1Var.f40442c.put(str, Integer.valueOf(intValue));
            return;
        }
        z1Var.f40059a.d().r().b("Call to endAdUnitExposure for unknown ad unit id", str);
    }

    private final void o(long j10, z6 z6Var) {
        if (z6Var == null) {
            this.f40059a.d().v().a("Not logging ad exposure. No active activity");
        } else if (j10 < 1000) {
            this.f40059a.d().v().b("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j10));
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j10);
            t9.y(z6Var, bundle, true);
            this.f40059a.I().u("am", "_xa", bundle);
        }
    }

    private final void p(String str, long j10, z6 z6Var) {
        if (z6Var == null) {
            this.f40059a.d().v().a("Not logging ad unit exposure. No active activity");
        } else if (j10 < 1000) {
            this.f40059a.d().v().b("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j10));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j10);
            t9.y(z6Var, bundle, true);
            this.f40059a.I().u("am", "_xu", bundle);
        }
    }

    /* access modifiers changed from: private */
    public final void q(long j10) {
        for (String put : this.f40441b.keySet()) {
            this.f40441b.put(put, Long.valueOf(j10));
        }
        if (!this.f40441b.isEmpty()) {
            this.f40443d = j10;
        }
    }

    public final void l(String str, long j10) {
        if (str == null || str.length() == 0) {
            this.f40059a.d().r().a("Ad unit id must be a non-empty string");
        } else {
            this.f40059a.f().z(new a(this, str, j10));
        }
    }

    public final void m(String str, long j10) {
        if (str == null || str.length() == 0) {
            this.f40059a.d().r().a("Ad unit id must be a non-empty string");
        } else {
            this.f40059a.f().z(new x(this, str, j10));
        }
    }

    public final void n(long j10) {
        z6 s10 = this.f40059a.K().s(false);
        for (String str : this.f40441b.keySet()) {
            p(str, j10 - ((Long) this.f40441b.get(str)).longValue(), s10);
        }
        if (!this.f40441b.isEmpty()) {
            o(j10 - this.f40443d, s10);
        }
        q(j10);
    }
}
