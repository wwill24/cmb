package com.withpersona.sdk2.inquiry.launchers;

import androidx.activity.result.c;
import fj.d;
import fj.g;

public final class l implements d<c<String[]>> {

    /* renamed from: a  reason: collision with root package name */
    private final i f26957a;

    public l(i iVar) {
        this.f26957a = iVar;
    }

    public static l a(i iVar) {
        return new l(iVar);
    }

    public static c<String[]> c(i iVar) {
        return (c) g.e(iVar.a());
    }

    /* renamed from: b */
    public c<String[]> get() {
        return c(this.f26957a);
    }
}
