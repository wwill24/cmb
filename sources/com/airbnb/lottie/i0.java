package com.airbnb.lottie;

import java.util.Arrays;

public final class i0<V> {

    /* renamed from: a  reason: collision with root package name */
    private final V f8594a;

    /* renamed from: b  reason: collision with root package name */
    private final Throwable f8595b;

    public i0(V v10) {
        this.f8594a = v10;
        this.f8595b = null;
    }

    public Throwable a() {
        return this.f8595b;
    }

    public V b() {
        return this.f8594a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i0)) {
            return false;
        }
        i0 i0Var = (i0) obj;
        if (b() != null && b().equals(i0Var.b())) {
            return true;
        }
        if (a() == null || i0Var.a() == null) {
            return false;
        }
        return a().toString().equals(a().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{b(), a()});
    }

    public i0(Throwable th2) {
        this.f8595b = th2;
        this.f8594a = null;
    }
}
