package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.view.b;
import d.j;

public abstract class a {

    public interface b {
        void onMenuVisibilityChanged(boolean z10);
    }

    @Deprecated
    public static abstract class c {
        public abstract CharSequence a();

        public abstract View b();

        public abstract Drawable c();

        public abstract CharSequence d();

        public abstract void e();
    }

    public abstract void A(CharSequence charSequence);

    public abstract void B(CharSequence charSequence);

    public androidx.appcompat.view.b C(b.a aVar) {
        return null;
    }

    public boolean g() {
        return false;
    }

    public abstract boolean h();

    public abstract void i(boolean z10);

    public abstract int j();

    public abstract Context k();

    public abstract void l();

    public boolean m() {
        return false;
    }

    public void n(Configuration configuration) {
    }

    /* access modifiers changed from: package-private */
    public void o() {
    }

    public abstract boolean p(int i10, KeyEvent keyEvent);

    public boolean q(KeyEvent keyEvent) {
        return false;
    }

    public boolean r() {
        return false;
    }

    public abstract void s(View view);

    public abstract void t(boolean z10);

    public abstract void u(boolean z10);

    public abstract void v(int i10);

    public abstract void w(boolean z10);

    public abstract void x(boolean z10);

    public abstract void y(Drawable drawable);

    public abstract void z(boolean z10);

    /* renamed from: androidx.appcompat.app.a$a  reason: collision with other inner class name */
    public static class C0012a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f538a = 8388627;

        public C0012a(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ActionBarLayout);
            this.f538a = obtainStyledAttributes.getInt(j.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public C0012a(int i10, int i11) {
            super(i10, i11);
        }

        public C0012a(C0012a aVar) {
            super(aVar);
            this.f538a = aVar.f538a;
        }

        public C0012a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
