package com.google.android.material.internal;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.core.view.h0;
import androidx.core.view.k2;
import androidx.core.view.n0;
import androidx.core.view.s2;

public class r {

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f19896a;

        a(View view) {
            this.f19896a = view;
        }

        public void run() {
            ((InputMethodManager) this.f19896a.getContext().getSystemService("input_method")).showSoftInput(this.f19896a, 1);
        }
    }

    class b implements h0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f19897a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e f19898b;

        b(d dVar, e eVar) {
            this.f19897a = dVar;
            this.f19898b = eVar;
        }

        public k2 a(View view, k2 k2Var) {
            return this.f19897a.a(view, k2Var, new e(this.f19898b));
        }
    }

    class c implements View.OnAttachStateChangeListener {
        c() {
        }

        public void onViewAttachedToWindow(@NonNull View view) {
            view.removeOnAttachStateChangeListener(this);
            n0.p0(view);
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    public interface d {
        k2 a(View view, k2 k2Var, e eVar);
    }

    public static void a(View view, @NonNull ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (view != null) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    public static void b(@NonNull View view, @NonNull d dVar) {
        n0.H0(view, new b(dVar, new e(n0.G(view), view.getPaddingTop(), n0.F(view), view.getPaddingBottom())));
        m(view);
    }

    public static float c(@NonNull Context context, int i10) {
        return TypedValue.applyDimension(1, (float) i10, context.getResources().getDisplayMetrics());
    }

    public static Integer d(@NonNull View view) {
        if (view.getBackground() instanceof ColorDrawable) {
            return Integer.valueOf(((ColorDrawable) view.getBackground()).getColor());
        }
        return null;
    }

    private static InputMethodManager e(@NonNull View view) {
        return (InputMethodManager) androidx.core.content.a.getSystemService(view.getContext(), InputMethodManager.class);
    }

    public static float f(@NonNull View view) {
        float f10 = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            f10 += n0.w((View) parent);
        }
        return f10;
    }

    public static void g(@NonNull View view) {
        h(view, true);
    }

    public static void h(@NonNull View view, boolean z10) {
        s2 N;
        if (!z10 || (N = n0.N(view)) == null) {
            InputMethodManager e10 = e(view);
            if (e10 != null) {
                e10.hideSoftInputFromWindow(view.getWindowToken(), 0);
                return;
            }
            return;
        }
        N.a(k2.m.a());
    }

    public static boolean i(View view) {
        return n0.B(view) == 1;
    }

    public static PorterDuff.Mode j(int i10, PorterDuff.Mode mode) {
        if (i10 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i10 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i10 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i10) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static void k(View view, @NonNull ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (view != null) {
            l(view.getViewTreeObserver(), onGlobalLayoutListener);
        }
    }

    public static void l(@NonNull ViewTreeObserver viewTreeObserver, @NonNull ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public static void m(@NonNull View view) {
        if (n0.V(view)) {
            n0.p0(view);
        } else {
            view.addOnAttachStateChangeListener(new c());
        }
    }

    public static void n(@NonNull View view) {
        view.requestFocus();
        view.post(new a(view));
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public int f19899a;

        /* renamed from: b  reason: collision with root package name */
        public int f19900b;

        /* renamed from: c  reason: collision with root package name */
        public int f19901c;

        /* renamed from: d  reason: collision with root package name */
        public int f19902d;

        public e(int i10, int i11, int i12, int i13) {
            this.f19899a = i10;
            this.f19900b = i11;
            this.f19901c = i12;
            this.f19902d = i13;
        }

        public e(@NonNull e eVar) {
            this.f19899a = eVar.f19899a;
            this.f19900b = eVar.f19900b;
            this.f19901c = eVar.f19901c;
            this.f19902d = eVar.f19902d;
        }
    }
}
