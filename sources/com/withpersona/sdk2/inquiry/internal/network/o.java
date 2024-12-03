package com.withpersona.sdk2.inquiry.internal.network;

import com.squareup.workflow1.ui.r;
import com.squareup.workflow1.ui.s;
import fj.d;
import fj.g;
import fk.a;
import java.util.Set;

public final class o implements d<s> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Set<r<?>>> f26917a;

    public o(a<Set<r<?>>> aVar) {
        this.f26917a = aVar;
    }

    public static o a(a<Set<r<?>>> aVar) {
        return new o(aVar);
    }

    public static s c(Set<r<?>> set) {
        return (s) g.e(c.k(set));
    }

    /* renamed from: b */
    public s get() {
        return c(this.f26917a.get());
    }
}
