package com.clevertap.android.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import com.clevertap.android.sdk.validation.Validator;
import java.util.ArrayList;
import l4.b;

public class r extends e {

    /* renamed from: a  reason: collision with root package name */
    private long f10772a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f10773b;

    /* renamed from: c  reason: collision with root package name */
    private final j f10774c;

    /* renamed from: d  reason: collision with root package name */
    private final CleverTapInstanceConfig f10775d;

    /* renamed from: e  reason: collision with root package name */
    private final n f10776e;

    /* renamed from: f  reason: collision with root package name */
    private final Validator f10777f;

    public r(CleverTapInstanceConfig cleverTapInstanceConfig, j jVar, Validator validator, n nVar) {
        this.f10775d = cleverTapInstanceConfig;
        this.f10774c = jVar;
        this.f10777f = validator;
        this.f10776e = nVar;
    }

    private void b(Context context) {
        this.f10774c.O((int) (System.currentTimeMillis() / 1000));
        p n10 = this.f10775d.n();
        String e10 = this.f10775d.e();
        n10.t(e10, "Session created with ID: " + this.f10774c.k());
        SharedPreferences g10 = s.g(context);
        int d10 = s.d(context, this.f10775d, "lastSessionId", 0);
        int d11 = s.d(context, this.f10775d, "sexe", 0);
        if (d11 > 0) {
            this.f10774c.W(d11 - d10);
        }
        p n11 = this.f10775d.n();
        String e11 = this.f10775d.e();
        n11.t(e11, "Last session length: " + this.f10774c.o() + " seconds");
        if (d10 == 0) {
            this.f10774c.R(true);
        }
        s.l(g10.edit().putInt(s.s(this.f10775d, "lastSessionId"), this.f10774c.k()));
    }

    public void a() {
        if (this.f10772a > 0 && System.currentTimeMillis() - this.f10772a > 1200000) {
            this.f10775d.n().t(this.f10775d.e(), "Session Timed Out");
            c();
            j.N((Activity) null);
        }
    }

    public void c() {
        this.f10774c.O(0);
        this.f10774c.K(false);
        if (this.f10774c.C()) {
            this.f10774c.R(false);
        }
        this.f10775d.n().t(this.f10775d.e(), "Session destroyed; Session ID is now 0");
        this.f10774c.c();
        this.f10774c.b();
        this.f10774c.a();
        this.f10774c.d();
    }

    public void d(Context context) {
        if (!this.f10774c.v()) {
            this.f10774c.Q(true);
            Validator validator = this.f10777f;
            if (validator != null) {
                validator.l((ArrayList<String>) null);
            }
            b(context);
        }
    }

    public void e(long j10) {
        this.f10772a = j10;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        b r10 = this.f10776e.r("App Launched");
        if (r10 == null) {
            this.f10773b = -1;
        } else {
            this.f10773b = r10.c();
        }
    }
}
