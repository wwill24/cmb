package com.google.firebase.perf.util;

import android.view.View;
import android.view.ViewTreeObserver;

public final /* synthetic */ class a implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirstDrawDoneListener f21183a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f21184b;

    public /* synthetic */ a(FirstDrawDoneListener firstDrawDoneListener, View view) {
        this.f21183a = firstDrawDoneListener;
        this.f21184b = view;
    }

    public final void onGlobalLayout() {
        this.f21183a.lambda$onDraw$0(this.f21184b);
    }
}
