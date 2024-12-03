package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

public final class e2 {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<View> f4815a;

    /* renamed from: b  reason: collision with root package name */
    Runnable f4816b = null;

    /* renamed from: c  reason: collision with root package name */
    Runnable f4817c = null;

    /* renamed from: d  reason: collision with root package name */
    int f4818d = -1;

    class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f2 f4819a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f4820b;

        a(f2 f2Var, View view) {
            this.f4819a = f2Var;
            this.f4820b = view;
        }

        public void onAnimationCancel(Animator animator) {
            this.f4819a.a(this.f4820b);
        }

        public void onAnimationEnd(Animator animator) {
            this.f4819a.b(this.f4820b);
        }

        public void onAnimationStart(Animator animator) {
            this.f4819a.c(this.f4820b);
        }
    }

    static class b {
        static ViewPropertyAnimator a(ViewPropertyAnimator viewPropertyAnimator, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
            return viewPropertyAnimator.setUpdateListener(animatorUpdateListener);
        }
    }

    e2(View view) {
        this.f4815a = new WeakReference<>(view);
    }

    private void i(View view, f2 f2Var) {
        if (f2Var != null) {
            view.animate().setListener(new a(f2Var, view));
        } else {
            view.animate().setListener((Animator.AnimatorListener) null);
        }
    }

    @NonNull
    public e2 b(float f10) {
        View view = this.f4815a.get();
        if (view != null) {
            view.animate().alpha(f10);
        }
        return this;
    }

    public void c() {
        View view = this.f4815a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long d() {
        View view = this.f4815a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0;
    }

    @NonNull
    public e2 f(long j10) {
        View view = this.f4815a.get();
        if (view != null) {
            view.animate().setDuration(j10);
        }
        return this;
    }

    @NonNull
    public e2 g(Interpolator interpolator) {
        View view = this.f4815a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    @NonNull
    public e2 h(f2 f2Var) {
        View view = this.f4815a.get();
        if (view != null) {
            i(view, f2Var);
        }
        return this;
    }

    @NonNull
    public e2 j(long j10) {
        View view = this.f4815a.get();
        if (view != null) {
            view.animate().setStartDelay(j10);
        }
        return this;
    }

    @NonNull
    public e2 k(h2 h2Var) {
        View view = this.f4815a.get();
        if (view != null) {
            d2 d2Var = null;
            if (h2Var != null) {
                d2Var = new d2(h2Var, view);
            }
            b.a(view.animate(), d2Var);
        }
        return this;
    }

    public void l() {
        View view = this.f4815a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    @NonNull
    public e2 m(float f10) {
        View view = this.f4815a.get();
        if (view != null) {
            view.animate().translationY(f10);
        }
        return this;
    }
}
