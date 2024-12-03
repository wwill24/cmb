package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.a;
import androidx.core.widget.d;

class g {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CompoundButton f1273a;

    /* renamed from: b  reason: collision with root package name */
    private ColorStateList f1274b = null;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuff.Mode f1275c = null;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1276d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1277e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1278f;

    g(@NonNull CompoundButton compoundButton) {
        this.f1273a = compoundButton;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        Drawable a10 = d.a(this.f1273a);
        if (a10 == null) {
            return;
        }
        if (this.f1276d || this.f1277e) {
            Drawable mutate = a.r(a10).mutate();
            if (this.f1276d) {
                a.o(mutate, this.f1274b);
            }
            if (this.f1277e) {
                a.p(mutate, this.f1275c);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.f1273a.getDrawableState());
            }
            this.f1273a.setButtonDrawable(mutate);
        }
    }

    /* access modifiers changed from: package-private */
    public int b(int i10) {
        return i10;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList c() {
        return this.f1274b;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        return this.f1275c;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d A[SYNTHETIC, Splitter:B:12:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0060 A[Catch:{ all -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0071 A[Catch:{ all -> 0x0084 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(android.util.AttributeSet r10, int r11) {
        /*
            r9 = this;
            android.widget.CompoundButton r0 = r9.f1273a
            android.content.Context r0 = r0.getContext()
            int[] r3 = d.j.CompoundButton
            r8 = 0
            androidx.appcompat.widget.h1 r0 = androidx.appcompat.widget.h1.v(r0, r10, r3, r11, r8)
            android.widget.CompoundButton r1 = r9.f1273a
            android.content.Context r2 = r1.getContext()
            android.content.res.TypedArray r5 = r0.r()
            r7 = 0
            r4 = r10
            r6 = r11
            androidx.core.view.n0.q0(r1, r2, r3, r4, r5, r6, r7)
            int r10 = d.j.CompoundButton_buttonCompat     // Catch:{ all -> 0x0084 }
            boolean r11 = r0.s(r10)     // Catch:{ all -> 0x0084 }
            if (r11 == 0) goto L_0x003a
            int r10 = r0.n(r10, r8)     // Catch:{ all -> 0x0084 }
            if (r10 == 0) goto L_0x003a
            android.widget.CompoundButton r11 = r9.f1273a     // Catch:{ NotFoundException -> 0x003a }
            android.content.Context r1 = r11.getContext()     // Catch:{ NotFoundException -> 0x003a }
            android.graphics.drawable.Drawable r10 = e.a.b(r1, r10)     // Catch:{ NotFoundException -> 0x003a }
            r11.setButtonDrawable(r10)     // Catch:{ NotFoundException -> 0x003a }
            r10 = 1
            goto L_0x003b
        L_0x003a:
            r10 = r8
        L_0x003b:
            if (r10 != 0) goto L_0x0058
            int r10 = d.j.CompoundButton_android_button     // Catch:{ all -> 0x0084 }
            boolean r11 = r0.s(r10)     // Catch:{ all -> 0x0084 }
            if (r11 == 0) goto L_0x0058
            int r10 = r0.n(r10, r8)     // Catch:{ all -> 0x0084 }
            if (r10 == 0) goto L_0x0058
            android.widget.CompoundButton r11 = r9.f1273a     // Catch:{ all -> 0x0084 }
            android.content.Context r1 = r11.getContext()     // Catch:{ all -> 0x0084 }
            android.graphics.drawable.Drawable r10 = e.a.b(r1, r10)     // Catch:{ all -> 0x0084 }
            r11.setButtonDrawable(r10)     // Catch:{ all -> 0x0084 }
        L_0x0058:
            int r10 = d.j.CompoundButton_buttonTint     // Catch:{ all -> 0x0084 }
            boolean r11 = r0.s(r10)     // Catch:{ all -> 0x0084 }
            if (r11 == 0) goto L_0x0069
            android.widget.CompoundButton r11 = r9.f1273a     // Catch:{ all -> 0x0084 }
            android.content.res.ColorStateList r10 = r0.c(r10)     // Catch:{ all -> 0x0084 }
            androidx.core.widget.d.d(r11, r10)     // Catch:{ all -> 0x0084 }
        L_0x0069:
            int r10 = d.j.CompoundButton_buttonTintMode     // Catch:{ all -> 0x0084 }
            boolean r11 = r0.s(r10)     // Catch:{ all -> 0x0084 }
            if (r11 == 0) goto L_0x0080
            android.widget.CompoundButton r11 = r9.f1273a     // Catch:{ all -> 0x0084 }
            r1 = -1
            int r10 = r0.k(r10, r1)     // Catch:{ all -> 0x0084 }
            r1 = 0
            android.graphics.PorterDuff$Mode r10 = androidx.appcompat.widget.k0.e(r10, r1)     // Catch:{ all -> 0x0084 }
            androidx.core.widget.d.e(r11, r10)     // Catch:{ all -> 0x0084 }
        L_0x0080:
            r0.w()
            return
        L_0x0084:
            r10 = move-exception
            r0.w()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.g.e(android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: package-private */
    public void f() {
        if (this.f1278f) {
            this.f1278f = false;
            return;
        }
        this.f1278f = true;
        a();
    }

    /* access modifiers changed from: package-private */
    public void g(ColorStateList colorStateList) {
        this.f1274b = colorStateList;
        this.f1276d = true;
        a();
    }

    /* access modifiers changed from: package-private */
    public void h(PorterDuff.Mode mode) {
        this.f1275c = mode;
        this.f1277e = true;
        a();
    }
}
