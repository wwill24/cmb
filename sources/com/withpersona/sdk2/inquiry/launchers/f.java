package com.withpersona.sdk2.inquiry.launchers;

import androidx.activity.result.c;
import fj.d;
import fj.g;

public final class f implements d<c<String[]>> {

    /* renamed from: a  reason: collision with root package name */
    private final a f26953a;

    public f(a aVar) {
        this.f26953a = aVar;
    }

    public static f a(a aVar) {
        return new f(aVar);
    }

    public static c<String[]> c(a aVar) {
        return (c) g.e(aVar.a());
    }

    /* renamed from: b */
    public c<String[]> get() {
        return c(this.f26953a);
    }
}
