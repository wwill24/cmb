package io.sentry.android.core.internal.util;

import android.view.FrameMetrics;
import android.view.Window;
import io.sentry.android.core.i0;

public final /* synthetic */ class o implements Window.OnFrameMetricsAvailableListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f31040a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i0 f31041b;

    public /* synthetic */ o(p pVar, i0 i0Var) {
        this.f31040a = pVar;
        this.f31041b = i0Var;
    }

    public final void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i10) {
        this.f31040a.h(this.f31041b, window, frameMetrics, i10);
    }
}
