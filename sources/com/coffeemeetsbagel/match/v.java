package com.coffeemeetsbagel.match;

import hb.c;
import java.util.HashSet;
import java.util.Set;
import nc.b;

public class v implements w {

    /* renamed from: a  reason: collision with root package name */
    private final c f34520a;

    /* renamed from: b  reason: collision with root package name */
    private final b f34521b;

    /* renamed from: c  reason: collision with root package name */
    private Set<String> f34522c;

    /* renamed from: d  reason: collision with root package name */
    private long f34523d;

    public v(c cVar, b bVar) {
        this.f34520a = cVar;
        this.f34521b = bVar;
        e();
    }

    private void c() {
        if (g() > this.f34523d) {
            d();
        }
    }

    private void d() {
        this.f34523d = f();
        this.f34522c = new HashSet();
        this.f34520a.b("KEY_ACTED_ON_BAGEL_CACHE_VALID_TILL", this.f34523d);
        this.f34520a.u("KEY_ACTED_ON_BAGEL_CACHE_CONTENTS", this.f34522c);
    }

    private void e() {
        long t10 = this.f34520a.t("KEY_ACTED_ON_BAGEL_CACHE_VALID_TILL");
        if (g() > t10) {
            d();
            return;
        }
        this.f34523d = t10;
        this.f34522c = this.f34520a.z("KEY_ACTED_ON_BAGEL_CACHE_CONTENTS");
    }

    private long f() {
        return this.f34521b.a();
    }

    private long g() {
        return this.f34521b.getCurrentTimeMillis();
    }

    public boolean a(String str) {
        c();
        return this.f34522c.contains(str);
    }

    public void b(String str) {
        c();
        this.f34522c.add(str);
        this.f34520a.u("KEY_ACTED_ON_BAGEL_CACHE_CONTENTS", this.f34522c);
    }

    public void remove(String str) {
        c();
        if (!this.f34522c.isEmpty() && this.f34522c.contains(str)) {
            this.f34522c.remove(str);
            this.f34520a.u("KEY_ACTED_ON_BAGEL_CACHE_CONTENTS", this.f34522c);
        }
    }
}
