package io.sentry.android.core.internal.util;

import android.view.View;
import android.view.ViewTreeObserver;

public final /* synthetic */ class g implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f31025a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f31026b;

    public /* synthetic */ g(h hVar, View view) {
        this.f31025a = hVar;
        this.f31026b = view;
    }

    public final void onGlobalLayout() {
        this.f31025a.d(this.f31026b);
    }
}
