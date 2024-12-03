package io.sentry;

import io.sentry.vendor.gson.stream.b;
import java.io.IOException;
import java.io.Writer;

public final class a1 extends b {

    /* renamed from: m  reason: collision with root package name */
    private final z0 f30816m;

    public a1(Writer writer, int i10) {
        super(writer);
        this.f30816m = new z0(i10);
    }

    public a1 N(String str) throws IOException {
        super.k(str);
        return this;
    }

    public a1 O(h0 h0Var, Object obj) throws IOException {
        this.f30816m.a(this, h0Var, obj);
        return this;
    }
}
