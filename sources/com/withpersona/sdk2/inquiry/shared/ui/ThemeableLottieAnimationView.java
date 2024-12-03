package com.withpersona.sdk2.inquiry.shared.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.h;
import com.airbnb.lottie.h0;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.c;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.x0;
import w2.d;

public final class ThemeableLottieAnimationView extends LottieAnimationView {
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public final Map<Integer, Integer> f27523w = new LinkedHashMap();

    /* renamed from: x  reason: collision with root package name */
    private final k0 f27524x = l0.a(x0.a());

    public ThemeableLottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j(new g(this));
    }

    /* access modifiers changed from: private */
    public static final void G(ThemeableLottieAnimationView themeableLottieAnimationView, h hVar) {
        j.g(themeableLottieAnimationView, "this$0");
        themeableLottieAnimationView.k(new d("**"), h0.f8565a, new h(themeableLottieAnimationView));
        themeableLottieAnimationView.k(new d("**"), h0.f8566b, new i(themeableLottieAnimationView));
    }

    public final void I(int i10, int i11) {
        this.f27523w.put(Integer.valueOf(i10), Integer.valueOf(i11));
    }

    public final s1 J(String str) {
        j.g(str, "url");
        return j.d(this.f27524x, x0.b(), (CoroutineStart) null, new ThemeableLottieAnimationView$loadFromUrl$1(str, this, (c<? super ThemeableLottieAnimationView$loadFromUrl$1>) null), 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l0.f(this.f27524x, (CancellationException) null, 1, (Object) null);
    }
}
