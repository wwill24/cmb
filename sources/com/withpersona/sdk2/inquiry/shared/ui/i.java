package com.withpersona.sdk2.inquiry.shared.ui;

import d3.b;
import d3.c;

public final class i extends c<Integer> {

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ ThemeableLottieAnimationView f27537d;

    i(ThemeableLottieAnimationView themeableLottieAnimationView) {
        this.f27537d = themeableLottieAnimationView;
    }

    /* renamed from: d */
    public Integer a(b<Integer> bVar) {
        Integer num = (Integer) this.f27537d.f27523w.get(bVar != null ? bVar.g() : null);
        if (num != null) {
            return num;
        }
        if (bVar != null) {
            return bVar.b();
        }
        return null;
    }
}
