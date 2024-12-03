package io.sentry.android.core.internal.util;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import io.sentry.android.core.i0;
import java.util.concurrent.atomic.AtomicReference;

@SuppressLint({"ObsoleteSdkInt"})
public class h implements ViewTreeObserver.OnDrawListener {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f31027a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    private final AtomicReference<View> f31028b;

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f31029c;

    class a implements View.OnAttachStateChangeListener {
        a() {
        }

        public void onViewAttachedToWindow(View view) {
            view.getViewTreeObserver().addOnDrawListener(h.this);
            view.removeOnAttachStateChangeListener(this);
        }

        public void onViewDetachedFromWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
        }
    }

    private h(View view, Runnable runnable) {
        this.f31028b = new AtomicReference<>(view);
        this.f31029c = runnable;
    }

    private static boolean b(View view, i0 i0Var) {
        return view.getViewTreeObserver().isAlive() && c(view, i0Var);
    }

    @SuppressLint({"NewApi"})
    private static boolean c(View view, i0 i0Var) {
        if (i0Var.d() >= 19) {
            return view.isAttachedToWindow();
        }
        if (view.getWindowToken() != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        view.getViewTreeObserver().removeOnDrawListener(this);
    }

    public static void e(View view, Runnable runnable, i0 i0Var) {
        h hVar = new h(view, runnable);
        if (i0Var.d() >= 26 || b(view, i0Var)) {
            view.getViewTreeObserver().addOnDrawListener(hVar);
        } else {
            view.addOnAttachStateChangeListener(new a());
        }
    }

    public void onDraw() {
        View andSet = this.f31028b.getAndSet((Object) null);
        if (andSet != null) {
            andSet.getViewTreeObserver().addOnGlobalLayoutListener(new g(this, andSet));
            this.f31027a.postAtFrontOfQueue(this.f31029c);
        }
    }
}
