package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.h0;
import androidx.core.view.k2;
import androidx.core.view.n0;
import bf.f;
import bf.k;
import bf.l;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.m;

public class CollapsingToolbarLayout extends FrameLayout {
    private static final int M = k.Widget_Design_CollapsingToolbar;
    private final TimeInterpolator B;
    private final TimeInterpolator C;
    private int D;
    private AppBarLayout.g E;
    int F;
    private int G;
    k2 H;
    private int I;
    private boolean J;
    private int K;
    private boolean L;

    /* renamed from: a  reason: collision with root package name */
    private boolean f19059a;

    /* renamed from: b  reason: collision with root package name */
    private int f19060b;

    /* renamed from: c  reason: collision with root package name */
    private ViewGroup f19061c;

    /* renamed from: d  reason: collision with root package name */
    private View f19062d;

    /* renamed from: e  reason: collision with root package name */
    private View f19063e;

    /* renamed from: f  reason: collision with root package name */
    private int f19064f;

    /* renamed from: g  reason: collision with root package name */
    private int f19065g;

    /* renamed from: h  reason: collision with root package name */
    private int f19066h;

    /* renamed from: j  reason: collision with root package name */
    private int f19067j;

    /* renamed from: k  reason: collision with root package name */
    private final Rect f19068k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    final com.google.android.material.internal.b f19069l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    final kf.a f19070m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f19071n;

    /* renamed from: p  reason: collision with root package name */
    private boolean f19072p;

    /* renamed from: q  reason: collision with root package name */
    private Drawable f19073q;

    /* renamed from: t  reason: collision with root package name */
    Drawable f19074t;

    /* renamed from: w  reason: collision with root package name */
    private int f19075w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f19076x;

    /* renamed from: y  reason: collision with root package name */
    private ValueAnimator f19077y;

    /* renamed from: z  reason: collision with root package name */
    private long f19078z;

    class a implements h0 {
        a() {
        }

        public k2 a(View view, @NonNull k2 k2Var) {
            return CollapsingToolbarLayout.this.o(k2Var);
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            CollapsingToolbarLayout.this.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    private class d implements AppBarLayout.g {
        d() {
        }

        public void a(AppBarLayout appBarLayout, int i10) {
            int i11;
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.F = i10;
            k2 k2Var = collapsingToolbarLayout.H;
            if (k2Var != null) {
                i11 = k2Var.k();
            } else {
                i11 = 0;
            }
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i12);
                c cVar = (c) childAt.getLayoutParams();
                h k10 = CollapsingToolbarLayout.k(childAt);
                int i13 = cVar.f19081a;
                if (i13 == 1) {
                    k10.f(v0.a.b(-i10, 0, CollapsingToolbarLayout.this.i(childAt)));
                } else if (i13 == 2) {
                    k10.f(Math.round(((float) (-i10)) * cVar.f19082b));
                }
            }
            CollapsingToolbarLayout.this.v();
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout2.f19074t != null && i11 > 0) {
                n0.j0(collapsingToolbarLayout2);
            }
            int height = CollapsingToolbarLayout.this.getHeight();
            int C = (height - n0.C(CollapsingToolbarLayout.this)) - i11;
            float f10 = (float) C;
            CollapsingToolbarLayout.this.f19069l.A0(Math.min(1.0f, ((float) (height - CollapsingToolbarLayout.this.getScrimVisibleHeightTrigger())) / f10));
            CollapsingToolbarLayout collapsingToolbarLayout3 = CollapsingToolbarLayout.this;
            collapsingToolbarLayout3.f19069l.n0(collapsingToolbarLayout3.F + C);
            CollapsingToolbarLayout.this.f19069l.y0(((float) Math.abs(i10)) / f10);
        }
    }

    public interface e extends m {
    }

    public CollapsingToolbarLayout(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, bf.b.collapsingToolbarLayoutStyle);
    }

    private void a(int i10) {
        TimeInterpolator timeInterpolator;
        d();
        ValueAnimator valueAnimator = this.f19077y;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.f19077y = valueAnimator2;
            if (i10 > this.f19075w) {
                timeInterpolator = this.B;
            } else {
                timeInterpolator = this.C;
            }
            valueAnimator2.setInterpolator(timeInterpolator);
            this.f19077y.addUpdateListener(new b());
        } else if (valueAnimator.isRunning()) {
            this.f19077y.cancel();
        }
        this.f19077y.setDuration(this.f19078z);
        this.f19077y.setIntValues(new int[]{this.f19075w, i10});
        this.f19077y.start();
    }

    private TextUtils.TruncateAt b(int i10) {
        if (i10 == 0) {
            return TextUtils.TruncateAt.START;
        }
        if (i10 == 1) {
            return TextUtils.TruncateAt.MIDDLE;
        }
        if (i10 != 3) {
            return TextUtils.TruncateAt.END;
        }
        return TextUtils.TruncateAt.MARQUEE;
    }

    private void c(AppBarLayout appBarLayout) {
        if (l()) {
            appBarLayout.setLiftOnScroll(false);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.view.ViewGroup} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d() {
        /*
            r6 = this;
            boolean r0 = r6.f19059a
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            r6.f19061c = r0
            r6.f19062d = r0
            int r1 = r6.f19060b
            r2 = -1
            if (r1 == r2) goto L_0x001f
            android.view.View r1 = r6.findViewById(r1)
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            r6.f19061c = r1
            if (r1 == 0) goto L_0x001f
            android.view.View r1 = r6.e(r1)
            r6.f19062d = r1
        L_0x001f:
            android.view.ViewGroup r1 = r6.f19061c
            r2 = 0
            if (r1 != 0) goto L_0x003e
            int r1 = r6.getChildCount()
            r3 = r2
        L_0x0029:
            if (r3 >= r1) goto L_0x003c
            android.view.View r4 = r6.getChildAt(r3)
            boolean r5 = m(r4)
            if (r5 == 0) goto L_0x0039
            r0 = r4
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            goto L_0x003c
        L_0x0039:
            int r3 = r3 + 1
            goto L_0x0029
        L_0x003c:
            r6.f19061c = r0
        L_0x003e:
            r6.u()
            r6.f19059a = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.CollapsingToolbarLayout.d():void");
    }

    @NonNull
    private View e(@NonNull View view) {
        ViewParent parent = view.getParent();
        while (parent != this && parent != null) {
            if (parent instanceof View) {
                view = (View) parent;
            }
            parent = parent.getParent();
        }
        return view;
    }

    private static int h(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getMeasuredHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return view.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private static CharSequence j(View view) {
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getTitle();
        }
        if (view instanceof android.widget.Toolbar) {
            return ((android.widget.Toolbar) view).getTitle();
        }
        return null;
    }

    @NonNull
    static h k(@NonNull View view) {
        int i10 = f.view_offset_helper;
        h hVar = (h) view.getTag(i10);
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h(view);
        view.setTag(i10, hVar2);
        return hVar2;
    }

    private boolean l() {
        return this.G == 1;
    }

    private static boolean m(View view) {
        return (view instanceof Toolbar) || (view instanceof android.widget.Toolbar);
    }

    private boolean n(View view) {
        View view2 = this.f19062d;
        if (view2 == null || view2 == this) {
            if (view == this.f19061c) {
                return true;
            }
        } else if (view == view2) {
            return true;
        }
        return false;
    }

    private void q(boolean z10) {
        int i10;
        int i11;
        int i12;
        int i13;
        View view = this.f19062d;
        if (view == null) {
            view = this.f19061c;
        }
        int i14 = i(view);
        com.google.android.material.internal.d.a(this, this.f19063e, this.f19068k);
        ViewGroup viewGroup = this.f19061c;
        int i15 = 0;
        if (viewGroup instanceof Toolbar) {
            Toolbar toolbar = (Toolbar) viewGroup;
            i15 = toolbar.getTitleMarginStart();
            i11 = toolbar.getTitleMarginEnd();
            i10 = toolbar.getTitleMarginTop();
            i12 = toolbar.getTitleMarginBottom();
        } else if (viewGroup instanceof android.widget.Toolbar) {
            android.widget.Toolbar toolbar2 = (android.widget.Toolbar) viewGroup;
            i15 = toolbar2.getTitleMarginStart();
            i11 = toolbar2.getTitleMarginEnd();
            i10 = toolbar2.getTitleMarginTop();
            i12 = toolbar2.getTitleMarginBottom();
        } else {
            i12 = 0;
            i11 = 0;
            i10 = 0;
        }
        com.google.android.material.internal.b bVar = this.f19069l;
        Rect rect = this.f19068k;
        int i16 = rect.left;
        if (z10) {
            i13 = i11;
        } else {
            i13 = i15;
        }
        int i17 = i16 + i13;
        int i18 = rect.top + i14 + i10;
        int i19 = rect.right;
        if (!z10) {
            i15 = i11;
        }
        bVar.e0(i17, i18, i19 - i15, (rect.bottom + i14) - i12);
    }

    private void r() {
        setContentDescription(getTitle());
    }

    private void s(@NonNull Drawable drawable, int i10, int i11) {
        t(drawable, this.f19061c, i10, i11);
    }

    private void t(@NonNull Drawable drawable, View view, int i10, int i11) {
        if (l() && view != null && this.f19071n) {
            i11 = view.getBottom();
        }
        drawable.setBounds(0, 0, i10, i11);
    }

    private void u() {
        View view;
        if (!this.f19071n && (view = this.f19063e) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f19063e);
            }
        }
        if (this.f19071n && this.f19061c != null) {
            if (this.f19063e == null) {
                this.f19063e = new View(getContext());
            }
            if (this.f19063e.getParent() == null) {
                this.f19061c.addView(this.f19063e, -1, -1);
            }
        }
    }

    private void w(int i10, int i11, int i12, int i13, boolean z10) {
        View view;
        boolean z11;
        int i14;
        int i15;
        if (this.f19071n && (view = this.f19063e) != null) {
            boolean z12 = false;
            if (!n0.V(view) || this.f19063e.getVisibility() != 0) {
                z11 = false;
            } else {
                z11 = true;
            }
            this.f19072p = z11;
            if (z11 || z10) {
                if (n0.B(this) == 1) {
                    z12 = true;
                }
                q(z12);
                com.google.android.material.internal.b bVar = this.f19069l;
                if (z12) {
                    i14 = this.f19066h;
                } else {
                    i14 = this.f19064f;
                }
                int i16 = this.f19068k.top + this.f19065g;
                int i17 = i12 - i10;
                if (z12) {
                    i15 = this.f19064f;
                } else {
                    i15 = this.f19066h;
                }
                bVar.o0(i14, i16, i17 - i15, (i13 - i11) - this.f19067j);
                this.f19069l.b0(z10);
            }
        }
    }

    private void x() {
        if (this.f19061c != null && this.f19071n && TextUtils.isEmpty(this.f19069l.O())) {
            setTitle(j(this.f19061c));
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    public void draw(@NonNull Canvas canvas) {
        int i10;
        Drawable drawable;
        super.draw(canvas);
        d();
        if (this.f19061c == null && (drawable = this.f19073q) != null && this.f19075w > 0) {
            drawable.mutate().setAlpha(this.f19075w);
            this.f19073q.draw(canvas);
        }
        if (this.f19071n && this.f19072p) {
            if (this.f19061c == null || this.f19073q == null || this.f19075w <= 0 || !l() || this.f19069l.F() >= this.f19069l.G()) {
                this.f19069l.l(canvas);
            } else {
                int save = canvas.save();
                canvas.clipRect(this.f19073q.getBounds(), Region.Op.DIFFERENCE);
                this.f19069l.l(canvas);
                canvas.restoreToCount(save);
            }
        }
        if (this.f19074t != null && this.f19075w > 0) {
            k2 k2Var = this.H;
            if (k2Var != null) {
                i10 = k2Var.k();
            } else {
                i10 = 0;
            }
            if (i10 > 0) {
                this.f19074t.setBounds(0, -this.F, getWidth(), i10 - this.F);
                this.f19074t.mutate().setAlpha(this.f19075w);
                this.f19074t.draw(canvas);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j10) {
        boolean z10;
        if (this.f19073q == null || this.f19075w <= 0 || !n(view)) {
            z10 = false;
        } else {
            t(this.f19073q, view, getWidth(), getHeight());
            this.f19073q.mutate().setAlpha(this.f19075w);
            this.f19073q.draw(canvas);
            z10 = true;
        }
        if (super.drawChild(canvas, view, j10) || z10) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f19074t;
        boolean z10 = false;
        if (drawable != null && drawable.isStateful()) {
            z10 = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f19073q;
        if (drawable2 != null && drawable2.isStateful()) {
            z10 |= drawable2.setState(drawableState);
        }
        com.google.android.material.internal.b bVar = this.f19069l;
        if (bVar != null) {
            z10 |= bVar.I0(drawableState);
        }
        if (z10) {
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public c generateDefaultLayoutParams() {
        return new c(-1, -1);
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new c(layoutParams);
    }

    public int getCollapsedTitleGravity() {
        return this.f19069l.q();
    }

    public float getCollapsedTitleTextSize() {
        return this.f19069l.u();
    }

    @NonNull
    public Typeface getCollapsedTitleTypeface() {
        return this.f19069l.v();
    }

    public Drawable getContentScrim() {
        return this.f19073q;
    }

    public int getExpandedTitleGravity() {
        return this.f19069l.B();
    }

    public int getExpandedTitleMarginBottom() {
        return this.f19067j;
    }

    public int getExpandedTitleMarginEnd() {
        return this.f19066h;
    }

    public int getExpandedTitleMarginStart() {
        return this.f19064f;
    }

    public int getExpandedTitleMarginTop() {
        return this.f19065g;
    }

    public float getExpandedTitleTextSize() {
        return this.f19069l.D();
    }

    @NonNull
    public Typeface getExpandedTitleTypeface() {
        return this.f19069l.E();
    }

    public int getHyphenationFrequency() {
        return this.f19069l.H();
    }

    public int getLineCount() {
        return this.f19069l.I();
    }

    public float getLineSpacingAdd() {
        return this.f19069l.J();
    }

    public float getLineSpacingMultiplier() {
        return this.f19069l.K();
    }

    public int getMaxLines() {
        return this.f19069l.L();
    }

    /* access modifiers changed from: package-private */
    public int getScrimAlpha() {
        return this.f19075w;
    }

    public long getScrimAnimationDuration() {
        return this.f19078z;
    }

    public int getScrimVisibleHeightTrigger() {
        int i10;
        int i11 = this.D;
        if (i11 >= 0) {
            return i11 + this.I + this.K;
        }
        k2 k2Var = this.H;
        if (k2Var != null) {
            i10 = k2Var.k();
        } else {
            i10 = 0;
        }
        int C2 = n0.C(this);
        if (C2 > 0) {
            return Math.min((C2 * 2) + i10, getHeight());
        }
        return getHeight() / 3;
    }

    public Drawable getStatusBarScrim() {
        return this.f19074t;
    }

    public CharSequence getTitle() {
        if (this.f19071n) {
            return this.f19069l.O();
        }
        return null;
    }

    public int getTitleCollapseMode() {
        return this.G;
    }

    public TimeInterpolator getTitlePositionInterpolator() {
        return this.f19069l.N();
    }

    @NonNull
    public TextUtils.TruncateAt getTitleTextEllipsize() {
        return this.f19069l.R();
    }

    /* access modifiers changed from: package-private */
    public final int i(@NonNull View view) {
        return ((getHeight() - k(view).b()) - view.getHeight()) - ((c) view.getLayoutParams()).bottomMargin;
    }

    /* access modifiers changed from: package-private */
    public k2 o(@NonNull k2 k2Var) {
        k2 k2Var2;
        if (n0.y(this)) {
            k2Var2 = k2Var;
        } else {
            k2Var2 = null;
        }
        if (!androidx.core.util.c.a(this.H, k2Var2)) {
            this.H = k2Var2;
            requestLayout();
        }
        return k2Var.c();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            c(appBarLayout);
            n0.B0(this, n0.y(appBarLayout));
            if (this.E == null) {
                this.E = new d();
            }
            appBarLayout.d(this.E);
            n0.p0(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f19069l.Y(configuration);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.g gVar = this.E;
        if (gVar != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).v(gVar);
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        k2 k2Var = this.H;
        if (k2Var != null) {
            int k10 = k2Var.k();
            int childCount = getChildCount();
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt = getChildAt(i14);
                if (!n0.y(childAt) && childAt.getTop() < k10) {
                    n0.d0(childAt, k10);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i15 = 0; i15 < childCount2; i15++) {
            k(getChildAt(i15)).d();
        }
        w(i10, i11, i12, i13, false);
        x();
        v();
        int childCount3 = getChildCount();
        for (int i16 = 0; i16 < childCount3; i16++) {
            k(getChildAt(i16)).a();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        int i12;
        d();
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i11);
        k2 k2Var = this.H;
        if (k2Var != null) {
            i12 = k2Var.k();
        } else {
            i12 = 0;
        }
        if ((mode == 0 || this.J) && i12 > 0) {
            this.I = i12;
            super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + i12, 1073741824));
        }
        if (this.L && this.f19069l.L() > 1) {
            x();
            w(0, 0, getMeasuredWidth(), getMeasuredHeight(), true);
            int z10 = this.f19069l.z();
            if (z10 > 1) {
                this.K = Math.round(this.f19069l.A()) * (z10 - 1);
                super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + this.K, 1073741824));
            }
        }
        ViewGroup viewGroup = this.f19061c;
        if (viewGroup != null) {
            View view = this.f19062d;
            if (view == null || view == this) {
                setMinimumHeight(h(viewGroup));
            } else {
                setMinimumHeight(h(view));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        Drawable drawable = this.f19073q;
        if (drawable != null) {
            s(drawable, i10, i11);
        }
    }

    public void p(boolean z10, boolean z11) {
        if (this.f19076x != z10) {
            int i10 = 255;
            if (z11) {
                if (!z10) {
                    i10 = 0;
                }
                a(i10);
            } else {
                if (!z10) {
                    i10 = 0;
                }
                setScrimAlpha(i10);
            }
            this.f19076x = z10;
        }
    }

    public void setCollapsedTitleGravity(int i10) {
        this.f19069l.j0(i10);
    }

    public void setCollapsedTitleTextAppearance(int i10) {
        this.f19069l.g0(i10);
    }

    public void setCollapsedTitleTextColor(int i10) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i10));
    }

    public void setCollapsedTitleTextSize(float f10) {
        this.f19069l.k0(f10);
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.f19069l.l0(typeface);
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = this.f19073q;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f19073q = drawable3;
            if (drawable3 != null) {
                s(drawable3, getWidth(), getHeight());
                this.f19073q.setCallback(this);
                this.f19073q.setAlpha(this.f19075w);
            }
            n0.j0(this);
        }
    }

    public void setContentScrimColor(int i10) {
        setContentScrim(new ColorDrawable(i10));
    }

    public void setContentScrimResource(int i10) {
        setContentScrim(androidx.core.content.a.getDrawable(getContext(), i10));
    }

    public void setExpandedTitleColor(int i10) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i10));
    }

    public void setExpandedTitleGravity(int i10) {
        this.f19069l.u0(i10);
    }

    public void setExpandedTitleMarginBottom(int i10) {
        this.f19067j = i10;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i10) {
        this.f19066h = i10;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i10) {
        this.f19064f = i10;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i10) {
        this.f19065g = i10;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(int i10) {
        this.f19069l.r0(i10);
    }

    public void setExpandedTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.f19069l.t0(colorStateList);
    }

    public void setExpandedTitleTextSize(float f10) {
        this.f19069l.v0(f10);
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.f19069l.w0(typeface);
    }

    public void setExtraMultilineHeightEnabled(boolean z10) {
        this.L = z10;
    }

    public void setForceApplySystemWindowInsetTop(boolean z10) {
        this.J = z10;
    }

    public void setHyphenationFrequency(int i10) {
        this.f19069l.B0(i10);
    }

    public void setLineSpacingAdd(float f10) {
        this.f19069l.D0(f10);
    }

    public void setLineSpacingMultiplier(float f10) {
        this.f19069l.E0(f10);
    }

    public void setMaxLines(int i10) {
        this.f19069l.F0(i10);
    }

    public void setRtlTextDirectionHeuristicsEnabled(boolean z10) {
        this.f19069l.H0(z10);
    }

    /* access modifiers changed from: package-private */
    public void setScrimAlpha(int i10) {
        ViewGroup viewGroup;
        if (i10 != this.f19075w) {
            if (!(this.f19073q == null || (viewGroup = this.f19061c) == null)) {
                n0.j0(viewGroup);
            }
            this.f19075w = i10;
            n0.j0(this);
        }
    }

    public void setScrimAnimationDuration(long j10) {
        this.f19078z = j10;
    }

    public void setScrimVisibleHeightTrigger(int i10) {
        if (this.D != i10) {
            this.D = i10;
            v();
        }
    }

    public void setScrimsShown(boolean z10) {
        p(z10, n0.W(this) && !isInEditMode());
    }

    public void setStaticLayoutBuilderConfigurer(e eVar) {
        this.f19069l.J0(eVar);
    }

    public void setStatusBarScrim(Drawable drawable) {
        boolean z10;
        Drawable drawable2 = this.f19074t;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f19074t = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f19074t.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.m(this.f19074t, n0.B(this));
                Drawable drawable4 = this.f19074t;
                if (getVisibility() == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                drawable4.setVisible(z10, false);
                this.f19074t.setCallback(this);
                this.f19074t.setAlpha(this.f19075w);
            }
            n0.j0(this);
        }
    }

    public void setStatusBarScrimColor(int i10) {
        setStatusBarScrim(new ColorDrawable(i10));
    }

    public void setStatusBarScrimResource(int i10) {
        setStatusBarScrim(androidx.core.content.a.getDrawable(getContext(), i10));
    }

    public void setTitle(CharSequence charSequence) {
        this.f19069l.K0(charSequence);
        r();
    }

    public void setTitleCollapseMode(int i10) {
        this.G = i10;
        boolean l10 = l();
        this.f19069l.z0(l10);
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            c((AppBarLayout) parent);
        }
        if (l10 && this.f19073q == null) {
            setContentScrimColor(this.f19070m.d(getResources().getDimension(bf.d.design_appbar_elevation)));
        }
    }

    public void setTitleEllipsize(@NonNull TextUtils.TruncateAt truncateAt) {
        this.f19069l.M0(truncateAt);
    }

    public void setTitleEnabled(boolean z10) {
        if (z10 != this.f19071n) {
            this.f19071n = z10;
            r();
            u();
            requestLayout();
        }
    }

    public void setTitlePositionInterpolator(TimeInterpolator timeInterpolator) {
        this.f19069l.G0(timeInterpolator);
    }

    public void setVisibility(int i10) {
        boolean z10;
        super.setVisibility(i10);
        if (i10 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Drawable drawable = this.f19074t;
        if (!(drawable == null || drawable.isVisible() == z10)) {
            this.f19074t.setVisible(z10, false);
        }
        Drawable drawable2 = this.f19073q;
        if (drawable2 != null && drawable2.isVisible() != z10) {
            this.f19073q.setVisible(z10, false);
        }
    }

    /* access modifiers changed from: package-private */
    public final void v() {
        boolean z10;
        if (this.f19073q != null || this.f19074t != null) {
            if (getHeight() + this.F < getScrimVisibleHeightTrigger()) {
                z10 = true;
            } else {
                z10 = false;
            }
            setScrimsShown(z10);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(@NonNull Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f19073q || drawable == this.f19074t;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CollapsingToolbarLayout(@androidx.annotation.NonNull android.content.Context r11, android.util.AttributeSet r12, int r13) {
        /*
            r10 = this;
            int r4 = M
            android.content.Context r11 = wf.a.c(r11, r12, r13, r4)
            r10.<init>(r11, r12, r13)
            r11 = 1
            r10.f19059a = r11
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r10.f19068k = r0
            r6 = -1
            r10.D = r6
            r7 = 0
            r10.I = r7
            r10.K = r7
            android.content.Context r8 = r10.getContext()
            com.google.android.material.internal.b r9 = new com.google.android.material.internal.b
            r9.<init>(r10)
            r10.f19069l = r9
            android.animation.TimeInterpolator r0 = cf.a.f18981e
            r9.L0(r0)
            r9.H0(r7)
            kf.a r0 = new kf.a
            r0.<init>(r8)
            r10.f19070m = r0
            int[] r2 = bf.l.CollapsingToolbarLayout
            int[] r5 = new int[r7]
            r0 = r8
            r1 = r12
            r3 = r13
            android.content.res.TypedArray r12 = com.google.android.material.internal.p.i(r0, r1, r2, r3, r4, r5)
            int r13 = bf.l.CollapsingToolbarLayout_expandedTitleGravity
            r0 = 8388691(0x800053, float:1.175506E-38)
            int r13 = r12.getInt(r13, r0)
            r9.u0(r13)
            int r13 = bf.l.CollapsingToolbarLayout_collapsedTitleGravity
            r0 = 8388627(0x800013, float:1.175497E-38)
            int r13 = r12.getInt(r13, r0)
            r9.j0(r13)
            int r13 = bf.l.CollapsingToolbarLayout_expandedTitleMargin
            int r13 = r12.getDimensionPixelSize(r13, r7)
            r10.f19067j = r13
            r10.f19066h = r13
            r10.f19065g = r13
            r10.f19064f = r13
            int r13 = bf.l.CollapsingToolbarLayout_expandedTitleMarginStart
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L_0x0074
            int r13 = r12.getDimensionPixelSize(r13, r7)
            r10.f19064f = r13
        L_0x0074:
            int r13 = bf.l.CollapsingToolbarLayout_expandedTitleMarginEnd
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L_0x0082
            int r13 = r12.getDimensionPixelSize(r13, r7)
            r10.f19066h = r13
        L_0x0082:
            int r13 = bf.l.CollapsingToolbarLayout_expandedTitleMarginTop
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L_0x0090
            int r13 = r12.getDimensionPixelSize(r13, r7)
            r10.f19065g = r13
        L_0x0090:
            int r13 = bf.l.CollapsingToolbarLayout_expandedTitleMarginBottom
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L_0x009e
            int r13 = r12.getDimensionPixelSize(r13, r7)
            r10.f19067j = r13
        L_0x009e:
            int r13 = bf.l.CollapsingToolbarLayout_titleEnabled
            boolean r13 = r12.getBoolean(r13, r11)
            r10.f19071n = r13
            int r13 = bf.l.CollapsingToolbarLayout_title
            java.lang.CharSequence r13 = r12.getText(r13)
            r10.setTitle(r13)
            int r13 = bf.k.TextAppearance_Design_CollapsingToolbar_Expanded
            r9.r0(r13)
            int r13 = d.i.TextAppearance_AppCompat_Widget_ActionBar_Title
            r9.g0(r13)
            int r13 = bf.l.CollapsingToolbarLayout_expandedTitleTextAppearance
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L_0x00c8
            int r13 = r12.getResourceId(r13, r7)
            r9.r0(r13)
        L_0x00c8:
            int r13 = bf.l.CollapsingToolbarLayout_collapsedTitleTextAppearance
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L_0x00d7
            int r13 = r12.getResourceId(r13, r7)
            r9.g0(r13)
        L_0x00d7:
            int r13 = bf.l.CollapsingToolbarLayout_titleTextEllipsize
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L_0x00ea
            int r13 = r12.getInt(r13, r6)
            android.text.TextUtils$TruncateAt r13 = r10.b(r13)
            r10.setTitleEllipsize(r13)
        L_0x00ea:
            int r13 = bf.l.CollapsingToolbarLayout_expandedTitleTextColor
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L_0x00f9
            android.content.res.ColorStateList r13 = qf.c.a(r8, r12, r13)
            r9.t0(r13)
        L_0x00f9:
            int r13 = bf.l.CollapsingToolbarLayout_collapsedTitleTextColor
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L_0x0108
            android.content.res.ColorStateList r13 = qf.c.a(r8, r12, r13)
            r9.i0(r13)
        L_0x0108:
            int r13 = bf.l.CollapsingToolbarLayout_scrimVisibleHeightTrigger
            int r13 = r12.getDimensionPixelSize(r13, r6)
            r10.D = r13
            int r13 = bf.l.CollapsingToolbarLayout_maxLines
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L_0x011f
            int r11 = r12.getInt(r13, r11)
            r9.F0(r11)
        L_0x011f:
            int r11 = bf.l.CollapsingToolbarLayout_titlePositionInterpolator
            boolean r13 = r12.hasValue(r11)
            if (r13 == 0) goto L_0x0132
            int r11 = r12.getResourceId(r11, r7)
            android.view.animation.Interpolator r11 = android.view.animation.AnimationUtils.loadInterpolator(r8, r11)
            r9.G0(r11)
        L_0x0132:
            int r11 = bf.l.CollapsingToolbarLayout_scrimAnimationDuration
            r13 = 600(0x258, float:8.41E-43)
            int r11 = r12.getInt(r11, r13)
            long r0 = (long) r11
            r10.f19078z = r0
            int r11 = bf.b.motionEasingStandardInterpolator
            android.animation.TimeInterpolator r13 = cf.a.f18979c
            android.animation.TimeInterpolator r13 = of.a.g(r8, r11, r13)
            r10.B = r13
            android.animation.TimeInterpolator r13 = cf.a.f18980d
            android.animation.TimeInterpolator r11 = of.a.g(r8, r11, r13)
            r10.C = r11
            int r11 = bf.l.CollapsingToolbarLayout_contentScrim
            android.graphics.drawable.Drawable r11 = r12.getDrawable(r11)
            r10.setContentScrim(r11)
            int r11 = bf.l.CollapsingToolbarLayout_statusBarScrim
            android.graphics.drawable.Drawable r11 = r12.getDrawable(r11)
            r10.setStatusBarScrim(r11)
            int r11 = bf.l.CollapsingToolbarLayout_titleCollapseMode
            int r11 = r12.getInt(r11, r7)
            r10.setTitleCollapseMode(r11)
            int r11 = bf.l.CollapsingToolbarLayout_toolbarId
            int r11 = r12.getResourceId(r11, r6)
            r10.f19060b = r11
            int r11 = bf.l.CollapsingToolbarLayout_forceApplySystemWindowInsetTop
            boolean r11 = r12.getBoolean(r11, r7)
            r10.J = r11
            int r11 = bf.l.CollapsingToolbarLayout_extraMultilineHeightEnabled
            boolean r11 = r12.getBoolean(r11, r7)
            r10.L = r11
            r12.recycle()
            r10.setWillNotDraw(r7)
            com.google.android.material.appbar.CollapsingToolbarLayout$a r11 = new com.google.android.material.appbar.CollapsingToolbarLayout$a
            r11.<init>()
            androidx.core.view.n0.H0(r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.CollapsingToolbarLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setCollapsedTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.f19069l.i0(colorStateList);
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    public static class c extends FrameLayout.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        int f19081a = 0;

        /* renamed from: b  reason: collision with root package name */
        float f19082b = 0.5f;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.CollapsingToolbarLayout_Layout);
            this.f19081a = obtainStyledAttributes.getInt(l.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            a(obtainStyledAttributes.getFloat(l.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            obtainStyledAttributes.recycle();
        }

        public void a(float f10) {
            this.f19082b = f10;
        }

        public c(int i10, int i11) {
            super(i10, i11);
        }

        public c(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
