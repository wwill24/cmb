package com.coffeemeetsbagel.preferences;

import j5.x;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.j;
import lc.v;
import na.b;
import qj.q;

public final class k implements g, b {

    /* renamed from: a  reason: collision with root package name */
    private final com.jakewharton.rxrelay2.b<Map<String, String>> f35803a;

    /* renamed from: b  reason: collision with root package name */
    private final com.jakewharton.rxrelay2.b<x> f35804b;

    /* renamed from: c  reason: collision with root package name */
    private final com.jakewharton.rxrelay2.b<x> f35805c;

    /* renamed from: d  reason: collision with root package name */
    private final com.jakewharton.rxrelay2.b<String> f35806d;

    public k() {
        com.jakewharton.rxrelay2.b<Map<String, String>> C0 = com.jakewharton.rxrelay2.b.C0();
        j.f(C0, "create()");
        this.f35803a = C0;
        com.jakewharton.rxrelay2.b<x> C02 = com.jakewharton.rxrelay2.b.C0();
        j.f(C02, "create()");
        this.f35804b = C02;
        com.jakewharton.rxrelay2.b<x> C03 = com.jakewharton.rxrelay2.b.C0();
        j.f(C03, "create()");
        this.f35805c = C03;
        com.jakewharton.rxrelay2.b<String> C04 = com.jakewharton.rxrelay2.b.C0();
        j.f(C04, "create()");
        this.f35806d = C04;
    }

    public q<x> a() {
        return v.b(this.f35804b);
    }

    public q<Map<String, String>> b() {
        return v.b(this.f35803a);
    }

    public void c() {
        this.f35806d.accept("");
    }

    public void d() {
        v.a(this.f35804b);
    }

    public void e(Map<String, String> map) {
        com.jakewharton.rxrelay2.b<Map<String, String>> bVar = this.f35803a;
        if (map == null) {
            map = new HashMap<>();
        }
        bVar.accept(map);
    }

    public q<String> j() {
        return v.b(this.f35806d);
    }

    public void onError(String str) {
        j.g(str, "message");
        this.f35806d.accept(str);
    }
}
