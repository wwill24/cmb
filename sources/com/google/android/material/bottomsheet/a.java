package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.i;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.accessibility.k;
import androidx.core.view.h0;
import androidx.core.view.i2;
import androidx.core.view.k2;
import androidx.core.view.n0;
import bf.h;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import tf.g;

public class a extends i {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public BottomSheetBehavior<FrameLayout> f19304f;

    /* renamed from: g  reason: collision with root package name */
    private FrameLayout f19305g;

    /* renamed from: h  reason: collision with root package name */
    private CoordinatorLayout f19306h;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public FrameLayout f19307j;

    /* renamed from: k  reason: collision with root package name */
    boolean f19308k;

    /* renamed from: l  reason: collision with root package name */
    boolean f19309l = true;

    /* renamed from: m  reason: collision with root package name */
    private boolean f19310m = true;

    /* renamed from: n  reason: collision with root package name */
    private boolean f19311n;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public f f19312p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f19313q;
    @NonNull

    /* renamed from: t  reason: collision with root package name */
    private BottomSheetBehavior.f f19314t = new e();

    /* renamed from: com.google.android.material.bottomsheet.a$a  reason: collision with other inner class name */
    class C0232a implements h0 {
        C0232a() {
        }

        public k2 a(View view, k2 k2Var) {
            if (a.this.f19312p != null) {
                a.this.f19304f.y0(a.this.f19312p);
            }
            if (k2Var != null) {
                a aVar = a.this;
                f unused = aVar.f19312p = new f(aVar.f19307j, k2Var, (C0232a) null);
                a.this.f19312p.e(a.this.getWindow());
                a.this.f19304f.Y(a.this.f19312p);
            }
            return k2Var;
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            a aVar = a.this;
            if (aVar.f19309l && aVar.isShowing() && a.this.q()) {
                a.this.cancel();
            }
        }
    }

    class c extends androidx.core.view.a {
        c() {
        }

        public void g(View view, @NonNull k kVar) {
            super.g(view, kVar);
            if (a.this.f19309l) {
                kVar.a(1048576);
                kVar.f0(true);
                return;
            }
            kVar.f0(false);
        }

        public boolean j(View view, int i10, Bundle bundle) {
            if (i10 == 1048576) {
                a aVar = a.this;
                if (aVar.f19309l) {
                    aVar.cancel();
                    return true;
                }
            }
            return super.j(view, i10, bundle);
        }
    }

    class d implements View.OnTouchListener {
        d() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    class e extends BottomSheetBehavior.f {
        e() {
        }

        public void b(@NonNull View view, float f10) {
        }

        public void c(@NonNull View view, int i10) {
            if (i10 == 5) {
                a.this.cancel();
            }
        }
    }

    private static class f extends BottomSheetBehavior.f {

        /* renamed from: a  reason: collision with root package name */
        private final Boolean f19320a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private final k2 f19321b;

        /* renamed from: c  reason: collision with root package name */
        private Window f19322c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f19323d;

        /* synthetic */ f(View view, k2 k2Var, C0232a aVar) {
            this(view, k2Var);
        }

        private void d(View view) {
            boolean z10;
            if (view.getTop() < this.f19321b.k()) {
                Window window = this.f19322c;
                if (window != null) {
                    Boolean bool = this.f19320a;
                    if (bool == null) {
                        z10 = this.f19323d;
                    } else {
                        z10 = bool.booleanValue();
                    }
                    com.google.android.material.internal.e.f(window, z10);
                }
                view.setPadding(view.getPaddingLeft(), this.f19321b.k() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
            } else if (view.getTop() != 0) {
                Window window2 = this.f19322c;
                if (window2 != null) {
                    com.google.android.material.internal.e.f(window2, this.f19323d);
                }
                view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
            }
        }

        /* access modifiers changed from: package-private */
        public void a(@NonNull View view) {
            d(view);
        }

        public void b(@NonNull View view, float f10) {
            d(view);
        }

        public void c(@NonNull View view, int i10) {
            d(view);
        }

        /* access modifiers changed from: package-private */
        public void e(Window window) {
            if (this.f19322c != window) {
                this.f19322c = window;
                if (window != null) {
                    this.f19323d = i2.a(window, window.getDecorView()).b();
                }
            }
        }

        private f(@NonNull View view, @NonNull k2 k2Var) {
            ColorStateList colorStateList;
            this.f19321b = k2Var;
            g n02 = BottomSheetBehavior.k0(view).n0();
            if (n02 != null) {
                colorStateList = n02.x();
            } else {
                colorStateList = n0.s(view);
            }
            if (colorStateList != null) {
                this.f19320a = Boolean.valueOf(hf.a.g(colorStateList.getDefaultColor()));
            } else if (view.getBackground() instanceof ColorDrawable) {
                this.f19320a = Boolean.valueOf(hf.a.g(((ColorDrawable) view.getBackground()).getColor()));
            } else {
                this.f19320a = null;
            }
        }
    }

    public a(@NonNull Context context, int i10) {
        super(context, f(context, i10));
        h(1);
        this.f19313q = getContext().getTheme().obtainStyledAttributes(new int[]{bf.b.enableEdgeToEdge}).getBoolean(0, false);
    }

    private static int f(@NonNull Context context, int i10) {
        if (i10 != 0) {
            return i10;
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(bf.b.bottomSheetDialogTheme, typedValue, true)) {
            return typedValue.resourceId;
        }
        return bf.k.Theme_Design_Light_BottomSheetDialog;
    }

    private FrameLayout m() {
        if (this.f19305g == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), h.design_bottom_sheet_dialog, (ViewGroup) null);
            this.f19305g = frameLayout;
            this.f19306h = (CoordinatorLayout) frameLayout.findViewById(bf.f.coordinator);
            FrameLayout frameLayout2 = (FrameLayout) this.f19305g.findViewById(bf.f.design_bottom_sheet);
            this.f19307j = frameLayout2;
            BottomSheetBehavior<FrameLayout> k02 = BottomSheetBehavior.k0(frameLayout2);
            this.f19304f = k02;
            k02.Y(this.f19314t);
            this.f19304f.I0(this.f19309l);
        }
        return this.f19305g;
    }

    private View r(int i10, View view, ViewGroup.LayoutParams layoutParams) {
        m();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f19305g.findViewById(bf.f.coordinator);
        if (i10 != 0 && view == null) {
            view = getLayoutInflater().inflate(i10, coordinatorLayout, false);
        }
        if (this.f19313q) {
            n0.H0(this.f19307j, new C0232a());
        }
        this.f19307j.removeAllViews();
        if (layoutParams == null) {
            this.f19307j.addView(view);
        } else {
            this.f19307j.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(bf.f.touch_outside).setOnClickListener(new b());
        n0.s0(this.f19307j, new c());
        this.f19307j.setOnTouchListener(new d());
        return this.f19305g;
    }

    public void cancel() {
        BottomSheetBehavior<FrameLayout> n10 = n();
        if (!this.f19308k || n10.p0() == 5) {
            super.cancel();
        } else {
            n10.Q0(5);
        }
    }

    @NonNull
    public BottomSheetBehavior<FrameLayout> n() {
        if (this.f19304f == null) {
            m();
        }
        return this.f19304f;
    }

    public boolean o() {
        return this.f19308k;
    }

    public void onAttachedToWindow() {
        boolean z10;
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null) {
            if (!this.f19313q || Color.alpha(window.getNavigationBarColor()) >= 255) {
                z10 = false;
            } else {
                z10 = true;
            }
            FrameLayout frameLayout = this.f19305g;
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(!z10);
            }
            CoordinatorLayout coordinatorLayout = this.f19306h;
            if (coordinatorLayout != null) {
                coordinatorLayout.setFitsSystemWindows(!z10);
            }
            i2.b(window, !z10);
            f fVar = this.f19312p;
            if (fVar != null) {
                fVar.e(window);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setStatusBarColor(0);
            window.addFlags(Integer.MIN_VALUE);
            window.setLayout(-1, -1);
        }
    }

    public void onDetachedFromWindow() {
        f fVar = this.f19312p;
        if (fVar != null) {
            fVar.e((Window) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f19304f;
        if (bottomSheetBehavior != null && bottomSheetBehavior.p0() == 5) {
            this.f19304f.Q0(4);
        }
    }

    /* access modifiers changed from: package-private */
    public void p() {
        this.f19304f.y0(this.f19314t);
    }

    /* access modifiers changed from: package-private */
    public boolean q() {
        if (!this.f19311n) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{16843611});
            this.f19310m = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
            this.f19311n = true;
        }
        return this.f19310m;
    }

    public void setCancelable(boolean z10) {
        super.setCancelable(z10);
        if (this.f19309l != z10) {
            this.f19309l = z10;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f19304f;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.I0(z10);
            }
        }
    }

    public void setCanceledOnTouchOutside(boolean z10) {
        super.setCanceledOnTouchOutside(z10);
        if (z10 && !this.f19309l) {
            this.f19309l = true;
        }
        this.f19310m = z10;
        this.f19311n = true;
    }

    public void setContentView(int i10) {
        super.setContentView(r(i10, (View) null, (ViewGroup.LayoutParams) null));
    }

    public void setContentView(View view) {
        super.setContentView(r(0, view, (ViewGroup.LayoutParams) null));
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(r(0, view, layoutParams));
    }
}
