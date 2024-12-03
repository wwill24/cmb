package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.view.n0;
import androidx.core.widget.h;
import d.j;
import e.a;

public class n {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f1363a;

    /* renamed from: b  reason: collision with root package name */
    private f1 f1364b;

    /* renamed from: c  reason: collision with root package name */
    private f1 f1365c;

    /* renamed from: d  reason: collision with root package name */
    private f1 f1366d;

    /* renamed from: e  reason: collision with root package name */
    private int f1367e = 0;

    public n(@NonNull ImageView imageView) {
        this.f1363a = imageView;
    }

    private boolean a(@NonNull Drawable drawable) {
        if (this.f1366d == null) {
            this.f1366d = new f1();
        }
        f1 f1Var = this.f1366d;
        f1Var.a();
        ColorStateList a10 = h.a(this.f1363a);
        if (a10 != null) {
            f1Var.f1272d = true;
            f1Var.f1269a = a10;
        }
        PorterDuff.Mode b10 = h.b(this.f1363a);
        if (b10 != null) {
            f1Var.f1271c = true;
            f1Var.f1270b = b10;
        }
        if (!f1Var.f1272d && !f1Var.f1271c) {
            return false;
        }
        h.i(drawable, f1Var, this.f1363a.getDrawableState());
        return true;
    }

    private boolean l() {
        return this.f1364b != null;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (this.f1363a.getDrawable() != null) {
            this.f1363a.getDrawable().setLevel(this.f1367e);
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        Drawable drawable = this.f1363a.getDrawable();
        if (drawable != null) {
            k0.b(drawable);
        }
        if (drawable == null) {
            return;
        }
        if (!l() || !a(drawable)) {
            f1 f1Var = this.f1365c;
            if (f1Var != null) {
                h.i(drawable, f1Var, this.f1363a.getDrawableState());
                return;
            }
            f1 f1Var2 = this.f1364b;
            if (f1Var2 != null) {
                h.i(drawable, f1Var2, this.f1363a.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ColorStateList d() {
        f1 f1Var = this.f1365c;
        if (f1Var != null) {
            return f1Var.f1269a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode e() {
        f1 f1Var = this.f1365c;
        if (f1Var != null) {
            return f1Var.f1270b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        if (this.f1363a.getBackground() instanceof RippleDrawable) {
            return false;
        }
        return true;
    }

    public void g(AttributeSet attributeSet, int i10) {
        int n10;
        Context context = this.f1363a.getContext();
        int[] iArr = j.AppCompatImageView;
        h1 v10 = h1.v(context, attributeSet, iArr, i10, 0);
        ImageView imageView = this.f1363a;
        n0.q0(imageView, imageView.getContext(), iArr, attributeSet, v10.r(), i10, 0);
        try {
            Drawable drawable = this.f1363a.getDrawable();
            if (!(drawable != null || (n10 = v10.n(j.AppCompatImageView_srcCompat, -1)) == -1 || (drawable = a.b(this.f1363a.getContext(), n10)) == null)) {
                this.f1363a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                k0.b(drawable);
            }
            int i11 = j.AppCompatImageView_tint;
            if (v10.s(i11)) {
                h.c(this.f1363a, v10.c(i11));
            }
            int i12 = j.AppCompatImageView_tintMode;
            if (v10.s(i12)) {
                h.d(this.f1363a, k0.e(v10.k(i12, -1), (PorterDuff.Mode) null));
            }
        } finally {
            v10.w();
        }
    }

    /* access modifiers changed from: package-private */
    public void h(@NonNull Drawable drawable) {
        this.f1367e = drawable.getLevel();
    }

    public void i(int i10) {
        if (i10 != 0) {
            Drawable b10 = a.b(this.f1363a.getContext(), i10);
            if (b10 != null) {
                k0.b(b10);
            }
            this.f1363a.setImageDrawable(b10);
        } else {
            this.f1363a.setImageDrawable((Drawable) null);
        }
        c();
    }

    /* access modifiers changed from: package-private */
    public void j(ColorStateList colorStateList) {
        if (this.f1365c == null) {
            this.f1365c = new f1();
        }
        f1 f1Var = this.f1365c;
        f1Var.f1269a = colorStateList;
        f1Var.f1272d = true;
        c();
    }

    /* access modifiers changed from: package-private */
    public void k(PorterDuff.Mode mode) {
        if (this.f1365c == null) {
            this.f1365c = new f1();
        }
        f1 f1Var = this.f1365c;
        f1Var.f1270b = mode;
        f1Var.f1271c = true;
        c();
    }
}
