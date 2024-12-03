package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;

public final class k0 implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private final View f4833a;

    /* renamed from: b  reason: collision with root package name */
    private ViewTreeObserver f4834b;

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f4835c;

    private k0(View view, Runnable runnable) {
        this.f4833a = view;
        this.f4834b = view.getViewTreeObserver();
        this.f4835c = runnable;
    }

    @NonNull
    public static k0 a(@NonNull View view, @NonNull Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        } else if (runnable != null) {
            k0 k0Var = new k0(view, runnable);
            view.getViewTreeObserver().addOnPreDrawListener(k0Var);
            view.addOnAttachStateChangeListener(k0Var);
            return k0Var;
        } else {
            throw new NullPointerException("runnable == null");
        }
    }

    public void b() {
        if (this.f4834b.isAlive()) {
            this.f4834b.removeOnPreDrawListener(this);
        } else {
            this.f4833a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f4833a.removeOnAttachStateChangeListener(this);
    }

    public boolean onPreDraw() {
        b();
        this.f4835c.run();
        return true;
    }

    public void onViewAttachedToWindow(@NonNull View view) {
        this.f4834b = view.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(@NonNull View view) {
        b();
    }
}
