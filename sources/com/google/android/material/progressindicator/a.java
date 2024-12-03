package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.core.view.n0;
import bf.k;
import bf.l;
import com.google.android.material.internal.p;
import com.google.android.material.progressindicator.b;
import java.util.Arrays;

public abstract class a<S extends b> extends ProgressBar {

    /* renamed from: q  reason: collision with root package name */
    static final int f19909q = k.Widget_MaterialComponents_ProgressIndicator;

    /* renamed from: a  reason: collision with root package name */
    S f19910a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f19911b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f19912c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f19913d;

    /* renamed from: e  reason: collision with root package name */
    private final int f19914e;

    /* renamed from: f  reason: collision with root package name */
    private final int f19915f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public long f19916g = -1;

    /* renamed from: h  reason: collision with root package name */
    pf.a f19917h;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public boolean f19918j = false;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public int f19919k = 4;

    /* renamed from: l  reason: collision with root package name */
    private final Runnable f19920l = new C0239a();

    /* renamed from: m  reason: collision with root package name */
    private final Runnable f19921m = new b();

    /* renamed from: n  reason: collision with root package name */
    private final androidx.vectordrawable.graphics.drawable.b f19922n = new c();

    /* renamed from: p  reason: collision with root package name */
    private final androidx.vectordrawable.graphics.drawable.b f19923p = new d();

    /* renamed from: com.google.android.material.progressindicator.a$a  reason: collision with other inner class name */
    class C0239a implements Runnable {
        C0239a() {
        }

        public void run() {
            a.this.k();
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            a.this.j();
            long unused = a.this.f19916g = -1;
        }
    }

    class c extends androidx.vectordrawable.graphics.drawable.b {
        c() {
        }

        public void b(Drawable drawable) {
            a.this.setIndeterminate(false);
            a aVar = a.this;
            aVar.o(aVar.f19911b, a.this.f19912c);
        }
    }

    class d extends androidx.vectordrawable.graphics.drawable.b {
        d() {
        }

        public void b(Drawable drawable) {
            super.b(drawable);
            if (!a.this.f19918j) {
                a aVar = a.this;
                aVar.setVisibility(aVar.f19919k);
            }
        }
    }

    protected a(@NonNull Context context, AttributeSet attributeSet, int i10, int i11) {
        super(wf.a.c(context, attributeSet, i10, f19909q), attributeSet, i10);
        Context context2 = getContext();
        this.f19910a = i(context2, attributeSet);
        TypedArray i12 = p.i(context2, attributeSet, l.BaseProgressIndicator, i10, i11, new int[0]);
        this.f19914e = i12.getInt(l.BaseProgressIndicator_showDelay, -1);
        this.f19915f = Math.min(i12.getInt(l.BaseProgressIndicator_minHideDelay, -1), 1000);
        i12.recycle();
        this.f19917h = new pf.a();
        this.f19913d = true;
    }

    private h<S> getCurrentDrawingDelegate() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            return getIndeterminateDrawable().v();
        } else if (getProgressDrawable() == null) {
            return null;
        } else {
            return getProgressDrawable().w();
        }
    }

    /* access modifiers changed from: private */
    public void j() {
        ((g) getCurrentDrawable()).q(false, false, true);
        if (m()) {
            setVisibility(4);
        }
    }

    /* access modifiers changed from: private */
    public void k() {
        if (this.f19915f > 0) {
            this.f19916g = SystemClock.uptimeMillis();
        }
        setVisibility(0);
    }

    private boolean m() {
        if ((getProgressDrawable() == null || !getProgressDrawable().isVisible()) && (getIndeterminateDrawable() == null || !getIndeterminateDrawable().isVisible())) {
            return true;
        }
        return false;
    }

    private void n() {
        if (!(getProgressDrawable() == null || getIndeterminateDrawable() == null)) {
            getIndeterminateDrawable().u().d(this.f19922n);
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().m(this.f19923p);
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().m(this.f19923p);
        }
    }

    private void p() {
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().s(this.f19923p);
            getIndeterminateDrawable().u().h();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().s(this.f19923p);
        }
    }

    public Drawable getCurrentDrawable() {
        return isIndeterminate() ? getIndeterminateDrawable() : getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.f19910a.f19933f;
    }

    @NonNull
    public int[] getIndicatorColor() {
        return this.f19910a.f19930c;
    }

    public int getShowAnimationBehavior() {
        return this.f19910a.f19932e;
    }

    public int getTrackColor() {
        return this.f19910a.f19931d;
    }

    public int getTrackCornerRadius() {
        return this.f19910a.f19929b;
    }

    public int getTrackThickness() {
        return this.f19910a.f19928a;
    }

    /* access modifiers changed from: protected */
    public void h(boolean z10) {
        if (this.f19913d) {
            ((g) getCurrentDrawable()).q(q(), false, z10);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract S i(@NonNull Context context, @NonNull AttributeSet attributeSet);

    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        View view = this;
        while (view.getVisibility() == 0) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                if (getWindowVisibility() == 0) {
                    return true;
                }
                return false;
            } else if (!(parent instanceof View)) {
                return true;
            } else {
                view = (View) parent;
            }
        }
        return false;
    }

    public void o(int i10, boolean z10) {
        if (!isIndeterminate()) {
            super.setProgress(i10);
            if (getProgressDrawable() != null && !z10) {
                getProgressDrawable().jumpToCurrentState();
            }
        } else if (getProgressDrawable() != null) {
            this.f19911b = i10;
            this.f19912c = z10;
            this.f19918j = true;
            if (!getIndeterminateDrawable().isVisible() || this.f19917h.a(getContext().getContentResolver()) == 0.0f) {
                this.f19922n.b(getIndeterminateDrawable());
            } else {
                getIndeterminateDrawable().u().f();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        n();
        if (q()) {
            k();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.f19921m);
        removeCallbacks(this.f19920l);
        ((g) getCurrentDrawable()).i();
        p();
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(@NonNull Canvas canvas) {
        int save = canvas.save();
        if (!(getPaddingLeft() == 0 && getPaddingTop() == 0)) {
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
        }
        if (!(getPaddingRight() == 0 && getPaddingBottom() == 0)) {
            canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
        }
        getCurrentDrawable().draw(canvas);
        canvas.restoreToCount(save);
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        h currentDrawingDelegate = getCurrentDrawingDelegate();
        if (currentDrawingDelegate != null) {
            if (currentDrawingDelegate.e() < 0) {
                i12 = View.getDefaultSize(getSuggestedMinimumWidth(), i10);
            } else {
                i12 = currentDrawingDelegate.e() + getPaddingLeft() + getPaddingRight();
            }
            if (currentDrawingDelegate.d() < 0) {
                i13 = View.getDefaultSize(getSuggestedMinimumHeight(), i11);
            } else {
                i13 = currentDrawingDelegate.d() + getPaddingTop() + getPaddingBottom();
            }
            setMeasuredDimension(i12, i13);
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(@NonNull View view, int i10) {
        boolean z10;
        super.onVisibilityChanged(view, i10);
        if (i10 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        h(z10);
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        h(false);
    }

    /* access modifiers changed from: package-private */
    public boolean q() {
        if (!n0.V(this) || getWindowVisibility() != 0 || !l()) {
            return false;
        }
        return true;
    }

    public void setAnimatorDurationScaleProvider(@NonNull pf.a aVar) {
        this.f19917h = aVar;
        if (getProgressDrawable() != null) {
            getProgressDrawable().f19964c = aVar;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().f19964c = aVar;
        }
    }

    public void setHideAnimationBehavior(int i10) {
        this.f19910a.f19933f = i10;
        invalidate();
    }

    public synchronized void setIndeterminate(boolean z10) {
        if (z10 != isIndeterminate()) {
            g gVar = (g) getCurrentDrawable();
            if (gVar != null) {
                gVar.i();
            }
            super.setIndeterminate(z10);
            g gVar2 = (g) getCurrentDrawable();
            if (gVar2 != null) {
                gVar2.q(q(), false, false);
            }
            if ((gVar2 instanceof j) && q()) {
                ((j) gVar2).u().g();
            }
            this.f19918j = false;
        }
    }

    public void setIndeterminateDrawable(Drawable drawable) {
        if (drawable == null) {
            super.setIndeterminateDrawable((Drawable) null);
        } else if (drawable instanceof j) {
            ((g) drawable).i();
            super.setIndeterminateDrawable(drawable);
        } else {
            throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
        }
    }

    public void setIndicatorColor(int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{hf.a.b(getContext(), bf.b.colorPrimary, -1)};
        }
        if (!Arrays.equals(getIndicatorColor(), iArr)) {
            this.f19910a.f19930c = iArr;
            getIndeterminateDrawable().u().c();
            invalidate();
        }
    }

    public synchronized void setProgress(int i10) {
        if (!isIndeterminate()) {
            o(i10, false);
        }
    }

    public void setProgressDrawable(Drawable drawable) {
        if (drawable == null) {
            super.setProgressDrawable((Drawable) null);
        } else if (drawable instanceof f) {
            f fVar = (f) drawable;
            fVar.i();
            super.setProgressDrawable(fVar);
            fVar.A(((float) getProgress()) / ((float) getMax()));
        } else {
            throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
        }
    }

    public void setShowAnimationBehavior(int i10) {
        this.f19910a.f19932e = i10;
        invalidate();
    }

    public void setTrackColor(int i10) {
        S s10 = this.f19910a;
        if (s10.f19931d != i10) {
            s10.f19931d = i10;
            invalidate();
        }
    }

    public void setTrackCornerRadius(int i10) {
        S s10 = this.f19910a;
        if (s10.f19929b != i10) {
            s10.f19929b = Math.min(i10, s10.f19928a / 2);
        }
    }

    public void setTrackThickness(int i10) {
        S s10 = this.f19910a;
        if (s10.f19928a != i10) {
            s10.f19928a = i10;
            requestLayout();
        }
    }

    public void setVisibilityAfterHide(int i10) {
        if (i10 == 0 || i10 == 4 || i10 == 8) {
            this.f19919k = i10;
            return;
        }
        throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
    }

    public j<S> getIndeterminateDrawable() {
        return (j) super.getIndeterminateDrawable();
    }

    public f<S> getProgressDrawable() {
        return (f) super.getProgressDrawable();
    }
}
