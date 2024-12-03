package com.withpersona.sdk2.inquiry.shared.ui;

import kotlin.jvm.internal.j;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final Object f27533a;

    /* renamed from: b  reason: collision with root package name */
    private final ScreenTransition f27534b;

    public e(Object obj, ScreenTransition screenTransition) {
        j.g(obj, "screen");
        j.g(screenTransition, "transition");
        this.f27533a = obj;
        this.f27534b = screenTransition;
    }

    public final Object a() {
        return this.f27533a;
    }

    public final ScreenTransition b() {
        return this.f27534b;
    }
}
