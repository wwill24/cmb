package com.withpersona.sdk2.inquiry.shared.ui;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.j;

public final class k {
    public static final void b(View view, Function0<Unit> function0) {
        j.g(view, "<this>");
        j.g(function0, "onPreDraw");
        b.f27527d.a(view, new j(function0));
    }

    /* access modifiers changed from: private */
    public static final void c(Function0 function0) {
        j.g(function0, "$tmp0");
        function0.invoke();
    }

    public static final void d(View view) {
        j.g(view, "<this>");
        view.sendAccessibilityEvent(32768);
    }
}
