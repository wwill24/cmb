package com.withpersona.sdk2.inquiry.internal.network;

import com.withpersona.sdk2.inquiry.network.JsonAdapterBinding;
import fj.d;
import fj.g;
import java.util.Set;

public final class h implements d<Set<JsonAdapterBinding<?>>> {

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final h f26908a = new h();
    }

    public static h a() {
        return a.f26908a;
    }

    public static Set<JsonAdapterBinding<?>> c() {
        return (Set) g.e(c.e());
    }

    /* renamed from: b */
    public Set<JsonAdapterBinding<?>> get() {
        return c();
    }
}
