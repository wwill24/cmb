package io.sentry;

import java.util.ArrayList;
import java.util.List;

final class g4<T> {

    /* renamed from: a  reason: collision with root package name */
    private final List<T> f31255a;

    g4(List<T> list) {
        this.f31255a = new ArrayList(list == null ? new ArrayList<>(0) : list);
    }

    public List<T> a() {
        return this.f31255a;
    }
}
