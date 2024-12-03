package com.coffeemeetsbagel.new_user_experience.match_prefs;

import com.jakewharton.rxrelay2.PublishRelay;
import j5.x;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.j;
import qj.q;

public final class g0 implements k, l {

    /* renamed from: a  reason: collision with root package name */
    private final PublishRelay<String> f35358a;

    /* renamed from: b  reason: collision with root package name */
    private final PublishRelay<String> f35359b;

    /* renamed from: c  reason: collision with root package name */
    private final PublishRelay<String> f35360c;

    /* renamed from: d  reason: collision with root package name */
    private final PublishRelay<x> f35361d;

    public g0() {
        PublishRelay<String> C0 = PublishRelay.C0();
        j.f(C0, "create()");
        this.f35358a = C0;
        PublishRelay<String> C02 = PublishRelay.C0();
        j.f(C02, "create()");
        this.f35359b = C02;
        PublishRelay<String> C03 = PublishRelay.C0();
        j.f(C03, "create()");
        this.f35360c = C03;
        PublishRelay<x> C04 = PublishRelay.C0();
        j.f(C04, "create()");
        this.f35361d = C04;
    }

    public q<String> a() {
        q<String> r02 = this.f35358a.r0(500, TimeUnit.MILLISECONDS);
        j.f(r02, "saveRelay.throttleLatest…L, TimeUnit.MILLISECONDS)");
        return r02;
    }

    public boolean b() {
        return this.f35358a.D0();
    }

    public q<String> c() {
        return this.f35359b;
    }

    public q<String> d() {
        return this.f35360c;
    }

    public q<x> e() {
        return this.f35361d;
    }

    public void f(String str) {
        j.g(str, "questionText");
        this.f35358a.accept(str);
    }

    public void g() {
        this.f35361d.accept(x.a());
    }

    public void onError(String str) {
        PublishRelay<String> publishRelay = this.f35360c;
        if (str == null) {
            str = "";
        }
        publishRelay.accept(str);
    }

    public void onSuccess(String str) {
        j.g(str, "question");
        this.f35359b.accept(str);
    }
}
