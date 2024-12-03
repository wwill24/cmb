package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.n0;
import d.j;

class d {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final View f1226a;

    /* renamed from: b  reason: collision with root package name */
    private final h f1227b;

    /* renamed from: c  reason: collision with root package name */
    private int f1228c = -1;

    /* renamed from: d  reason: collision with root package name */
    private f1 f1229d;

    /* renamed from: e  reason: collision with root package name */
    private f1 f1230e;

    /* renamed from: f  reason: collision with root package name */
    private f1 f1231f;

    d(@NonNull View view) {
        this.f1226a = view;
        this.f1227b = h.b();
    }

    private boolean a(@NonNull Drawable drawable) {
        if (this.f1231f == null) {
            this.f1231f = new f1();
        }
        f1 f1Var = this.f1231f;
        f1Var.a();
        ColorStateList s10 = n0.s(this.f1226a);
        if (s10 != null) {
            f1Var.f1272d = true;
            f1Var.f1269a = s10;
        }
        PorterDuff.Mode t10 = n0.t(this.f1226a);
        if (t10 != null) {
            f1Var.f1271c = true;
            f1Var.f1270b = t10;
        }
        if (!f1Var.f1272d && !f1Var.f1271c) {
            return false;
        }
        h.i(drawable, f1Var, this.f1226a.getDrawableState());
        return true;
    }

    private boolean k() {
        return this.f1229d != null;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        Drawable background = this.f1226a.getBackground();
        if (background == null) {
            return;
        }
        if (!k() || !a(background)) {
            f1 f1Var = this.f1230e;
            if (f1Var != null) {
                h.i(background, f1Var, this.f1226a.getDrawableState());
                return;
            }
            f1 f1Var2 = this.f1229d;
            if (f1Var2 != null) {
                h.i(background, f1Var2, this.f1226a.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ColorStateList c() {
        f1 f1Var = this.f1230e;
        if (f1Var != null) {
            return f1Var.f1269a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        f1 f1Var = this.f1230e;
        if (f1Var != null) {
            return f1Var.f1270b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void e(AttributeSet attributeSet, int i10) {
        Context context = this.f1226a.getContext();
        int[] iArr = j.ViewBackgroundHelper;
        h1 v10 = h1.v(context, attributeSet, iArr, i10, 0);
        View view = this.f1226a;
        n0.q0(view, view.getContext(), iArr, attributeSet, v10.r(), i10, 0);
        try {
            int i11 = j.ViewBackgroundHelper_android_background;
            if (v10.s(i11)) {
                this.f1228c = v10.n(i11, -1);
                ColorStateList f10 = this.f1227b.f(this.f1226a.getContext(), this.f1228c);
                if (f10 != null) {
                    h(f10);
                }
            }
            int i12 = j.ViewBackgroundHelper_backgroundTint;
            if (v10.s(i12)) {
                n0.x0(this.f1226a, v10.c(i12));
            }
            int i13 = j.ViewBackgroundHelper_backgroundTintMode;
            if (v10.s(i13)) {
                n0.y0(this.f1226a, k0.e(v10.k(i13, -1), (PorterDuff.Mode) null));
            }
        } finally {
            v10.w();
        }
    }

    /* access modifiers changed from: package-private */
    public void f(Drawable drawable) {
        this.f1228c = -1;
        h((ColorStateList) null);
        b();
    }

    /* access modifiers changed from: package-private */
    public void g(int i10) {
        ColorStateList colorStateList;
        this.f1228c = i10;
        h hVar = this.f1227b;
        if (hVar != null) {
            colorStateList = hVar.f(this.f1226a.getContext(), i10);
        } else {
            colorStateList = null;
        }
        h(colorStateList);
        b();
    }

    /* access modifiers changed from: package-private */
    public void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1229d == null) {
                this.f1229d = new f1();
            }
            f1 f1Var = this.f1229d;
            f1Var.f1269a = colorStateList;
            f1Var.f1272d = true;
        } else {
            this.f1229d = null;
        }
        b();
    }

    /* access modifiers changed from: package-private */
    public void i(ColorStateList colorStateList) {
        if (this.f1230e == null) {
            this.f1230e = new f1();
        }
        f1 f1Var = this.f1230e;
        f1Var.f1269a = colorStateList;
        f1Var.f1272d = true;
        b();
    }

    /* access modifiers changed from: package-private */
    public void j(PorterDuff.Mode mode) {
        if (this.f1230e == null) {
            this.f1230e = new f1();
        }
        f1 f1Var = this.f1230e;
        f1Var.f1270b = mode;
        f1Var.f1271c = true;
        b();
    }
}
