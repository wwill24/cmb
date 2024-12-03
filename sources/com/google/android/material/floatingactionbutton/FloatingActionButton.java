package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.h;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.n0;
import bf.k;
import bf.l;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.b;
import com.google.android.material.internal.s;
import com.google.android.material.stateful.ExtendableSavedState;
import java.util.List;
import tf.n;

public class FloatingActionButton extends s implements lf.a, n, CoordinatorLayout.b {

    /* renamed from: x  reason: collision with root package name */
    private static final int f19687x = k.Widget_Design_FloatingActionButton;

    /* renamed from: b  reason: collision with root package name */
    private ColorStateList f19688b;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuff.Mode f19689c;

    /* renamed from: d  reason: collision with root package name */
    private ColorStateList f19690d;

    /* renamed from: e  reason: collision with root package name */
    private PorterDuff.Mode f19691e;

    /* renamed from: f  reason: collision with root package name */
    private ColorStateList f19692f;

    /* renamed from: g  reason: collision with root package name */
    private int f19693g;

    /* renamed from: h  reason: collision with root package name */
    private int f19694h;

    /* renamed from: j  reason: collision with root package name */
    private int f19695j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public int f19696k;

    /* renamed from: l  reason: collision with root package name */
    private int f19697l;

    /* renamed from: m  reason: collision with root package name */
    boolean f19698m;

    /* renamed from: n  reason: collision with root package name */
    final Rect f19699n;

    /* renamed from: p  reason: collision with root package name */
    private final Rect f19700p;
    @NonNull

    /* renamed from: q  reason: collision with root package name */
    private final androidx.appcompat.widget.n f19701q;
    @NonNull

    /* renamed from: t  reason: collision with root package name */
    private final lf.b f19702t;

    /* renamed from: w  reason: collision with root package name */
    private b f19703w;

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public /* bridge */ /* synthetic */ boolean E(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull Rect rect) {
            return super.b(coordinatorLayout, floatingActionButton, rect);
        }

        public /* bridge */ /* synthetic */ boolean H(CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, View view) {
            return super.h(coordinatorLayout, floatingActionButton, view);
        }

        public /* bridge */ /* synthetic */ boolean I(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, int i10) {
            return super.l(coordinatorLayout, floatingActionButton, i10);
        }

        public /* bridge */ /* synthetic */ void g(@NonNull CoordinatorLayout.f fVar) {
            super.g(fVar);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    class a implements b.k {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f19707a;

        a(b bVar) {
            this.f19707a = bVar;
        }

        public void a() {
            this.f19707a.b(FloatingActionButton.this);
        }

        public void b() {
            this.f19707a.a(FloatingActionButton.this);
        }
    }

    public static abstract class b {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }

    private class c implements sf.b {
        c() {
        }

        public void a(int i10, int i11, int i12, int i13) {
            FloatingActionButton.this.f19699n.set(i10, i11, i12, i13);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i10 + floatingActionButton.f19696k, i11 + FloatingActionButton.this.f19696k, i12 + FloatingActionButton.this.f19696k, i13 + FloatingActionButton.this.f19696k);
        }

        public boolean b() {
            return FloatingActionButton.this.f19698m;
        }

        public void c(Drawable drawable) {
            if (drawable != null) {
                FloatingActionButton.super.setBackgroundDrawable(drawable);
            }
        }
    }

    class d<T extends FloatingActionButton> implements b.j {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final cf.k<T> f19710a;

        d(@NonNull cf.k<T> kVar) {
            this.f19710a = kVar;
        }

        public void a() {
            this.f19710a.b(FloatingActionButton.this);
        }

        public void b() {
            this.f19710a.a(FloatingActionButton.this);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof d) || !((d) obj).f19710a.equals(this.f19710a)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f19710a.hashCode();
        }
    }

    public FloatingActionButton(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, bf.b.floatingActionButtonStyle);
    }

    private b getImpl() {
        if (this.f19703w == null) {
            this.f19703w = j();
        }
        return this.f19703w;
    }

    @NonNull
    private b j() {
        return new c(this, new c());
    }

    private int m(int i10) {
        int i11 = this.f19695j;
        if (i11 != 0) {
            return i11;
        }
        Resources resources = getResources();
        if (i10 != -1) {
            if (i10 != 1) {
                return resources.getDimensionPixelSize(bf.d.design_fab_size_normal);
            }
            return resources.getDimensionPixelSize(bf.d.design_fab_size_mini);
        } else if (Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470) {
            return m(1);
        } else {
            return m(0);
        }
    }

    private void r(@NonNull Rect rect) {
        int i10 = rect.left;
        Rect rect2 = this.f19699n;
        rect.left = i10 + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    private void s() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            ColorStateList colorStateList = this.f19690d;
            if (colorStateList == null) {
                androidx.core.graphics.drawable.a.c(drawable);
                return;
            }
            int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
            PorterDuff.Mode mode = this.f19691e;
            if (mode == null) {
                mode = PorterDuff.Mode.SRC_IN;
            }
            drawable.mutate().setColorFilter(h.e(colorForState, mode));
        }
    }

    private b.k v(b bVar) {
        if (bVar == null) {
            return null;
        }
        return new a(bVar);
    }

    public boolean b() {
        return this.f19702t.c();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().D(getDrawableState());
    }

    public void g(@NonNull Animator.AnimatorListener animatorListener) {
        getImpl().e(animatorListener);
    }

    public ColorStateList getBackgroundTintList() {
        return this.f19688b;
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f19689c;
    }

    @NonNull
    public CoordinatorLayout.c<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().m();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().p();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().s();
    }

    public Drawable getContentBackground() {
        return getImpl().l();
    }

    public int getCustomSize() {
        return this.f19695j;
    }

    public int getExpandedComponentIdHint() {
        return this.f19702t.b();
    }

    public cf.h getHideMotionSpec() {
        return getImpl().o();
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f19692f;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.f19692f;
    }

    @NonNull
    public tf.k getShapeAppearanceModel() {
        return (tf.k) androidx.core.util.h.g(getImpl().t());
    }

    public cf.h getShowMotionSpec() {
        return getImpl().u();
    }

    public int getSize() {
        return this.f19694h;
    }

    /* access modifiers changed from: package-private */
    public int getSizeDimension() {
        return m(this.f19694h);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.f19690d;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f19691e;
    }

    public boolean getUseCompatPadding() {
        return this.f19698m;
    }

    public void h(@NonNull Animator.AnimatorListener animatorListener) {
        getImpl().f(animatorListener);
    }

    public void i(@NonNull cf.k<? extends FloatingActionButton> kVar) {
        getImpl().g(new d(kVar));
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().z();
    }

    @Deprecated
    public boolean k(@NonNull Rect rect) {
        if (!n0.W(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        r(rect);
        return true;
    }

    public void l(@NonNull Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        r(rect);
    }

    public void n(b bVar) {
        o(bVar, true);
    }

    /* access modifiers changed from: package-private */
    public void o(b bVar, boolean z10) {
        getImpl().v(v(bVar), z10);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().A();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().C();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        int sizeDimension = getSizeDimension();
        this.f19696k = (sizeDimension - this.f19697l) / 2;
        getImpl().e0();
        int min = Math.min(View.resolveSize(sizeDimension, i10), View.resolveSize(sizeDimension, i11));
        Rect rect = this.f19699n;
        setMeasuredDimension(rect.left + min + rect.right, min + rect.top + rect.bottom);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.a());
        this.f19702t.d((Bundle) androidx.core.util.h.g(extendableSavedState.f20145c.get("expandableWidgetHelper")));
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (onSaveInstanceState == null) {
            onSaveInstanceState = new Bundle();
        }
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(onSaveInstanceState);
        extendableSavedState.f20145c.put("expandableWidgetHelper", this.f19702t.e());
        return extendableSavedState;
    }

    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || !k(this.f19700p) || this.f19700p.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public boolean p() {
        return getImpl().x();
    }

    public boolean q() {
        return getImpl().y();
    }

    public void setBackgroundColor(int i10) {
    }

    public void setBackgroundDrawable(Drawable drawable) {
    }

    public void setBackgroundResource(int i10) {
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f19688b != colorStateList) {
            this.f19688b = colorStateList;
            getImpl().K(colorStateList);
        }
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f19689c != mode) {
            this.f19689c = mode;
            getImpl().L(mode);
        }
    }

    public void setCompatElevation(float f10) {
        getImpl().M(f10);
    }

    public void setCompatElevationResource(int i10) {
        setCompatElevation(getResources().getDimension(i10));
    }

    public void setCompatHoveredFocusedTranslationZ(float f10) {
        getImpl().P(f10);
    }

    public void setCompatHoveredFocusedTranslationZResource(int i10) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i10));
    }

    public void setCompatPressedTranslationZ(float f10) {
        getImpl().T(f10);
    }

    public void setCompatPressedTranslationZResource(int i10) {
        setCompatPressedTranslationZ(getResources().getDimension(i10));
    }

    public void setCustomSize(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        } else if (i10 != this.f19695j) {
            this.f19695j = i10;
            requestLayout();
        }
    }

    public void setElevation(float f10) {
        super.setElevation(f10);
        getImpl().f0(f10);
    }

    public void setEnsureMinTouchTargetSize(boolean z10) {
        if (z10 != getImpl().n()) {
            getImpl().N(z10);
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int i10) {
        this.f19702t.f(i10);
    }

    public void setHideMotionSpec(cf.h hVar) {
        getImpl().O(hVar);
    }

    public void setHideMotionSpecResource(int i10) {
        setHideMotionSpec(cf.h.c(getContext(), i10));
    }

    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            getImpl().d0();
            if (this.f19690d != null) {
                s();
            }
        }
    }

    public void setImageResource(int i10) {
        this.f19701q.i(i10);
        s();
    }

    public void setMaxImageSize(int i10) {
        this.f19697l = i10;
        getImpl().R(i10);
    }

    public void setRippleColor(int i10) {
        setRippleColor(ColorStateList.valueOf(i10));
    }

    public void setScaleX(float f10) {
        super.setScaleX(f10);
        getImpl().H();
    }

    public void setScaleY(float f10) {
        super.setScaleY(f10);
        getImpl().H();
    }

    public void setShadowPaddingEnabled(boolean z10) {
        getImpl().V(z10);
    }

    public void setShapeAppearanceModel(@NonNull tf.k kVar) {
        getImpl().W(kVar);
    }

    public void setShowMotionSpec(cf.h hVar) {
        getImpl().X(hVar);
    }

    public void setShowMotionSpecResource(int i10) {
        setShowMotionSpec(cf.h.c(getContext(), i10));
    }

    public void setSize(int i10) {
        this.f19695j = 0;
        if (i10 != this.f19694h) {
            this.f19694h = i10;
            requestLayout();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f19690d != colorStateList) {
            this.f19690d = colorStateList;
            s();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f19691e != mode) {
            this.f19691e = mode;
            s();
        }
    }

    public void setTranslationX(float f10) {
        super.setTranslationX(f10);
        getImpl().I();
    }

    public void setTranslationY(float f10) {
        super.setTranslationY(f10);
        getImpl().I();
    }

    public void setTranslationZ(float f10) {
        super.setTranslationZ(f10);
        getImpl().I();
    }

    public void setUseCompatPadding(boolean z10) {
        if (this.f19698m != z10) {
            this.f19698m = z10;
            getImpl().B();
        }
    }

    public void setVisibility(int i10) {
        super.setVisibility(i10);
    }

    public void t(b bVar) {
        u(bVar, true);
    }

    /* access modifiers changed from: package-private */
    public void u(b bVar, boolean z10) {
        getImpl().b0(v(bVar), z10);
    }

    protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.c<T> {

        /* renamed from: a  reason: collision with root package name */
        private Rect f19704a;

        /* renamed from: b  reason: collision with root package name */
        private b f19705b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f19706c;

        public BaseBehavior() {
            this.f19706c = true;
        }

        private static boolean F(@NonNull View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                return ((CoordinatorLayout.f) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private void G(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton) {
            int i10;
            Rect rect = floatingActionButton.f19699n;
            if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
                CoordinatorLayout.f fVar = (CoordinatorLayout.f) floatingActionButton.getLayoutParams();
                int i11 = 0;
                if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - fVar.rightMargin) {
                    i10 = rect.right;
                } else if (floatingActionButton.getLeft() <= fVar.leftMargin) {
                    i10 = -rect.left;
                } else {
                    i10 = 0;
                }
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - fVar.bottomMargin) {
                    i11 = rect.bottom;
                } else if (floatingActionButton.getTop() <= fVar.topMargin) {
                    i11 = -rect.top;
                }
                if (i11 != 0) {
                    n0.d0(floatingActionButton, i11);
                }
                if (i10 != 0) {
                    n0.c0(floatingActionButton, i10);
                }
            }
        }

        private boolean J(@NonNull View view, @NonNull FloatingActionButton floatingActionButton) {
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) floatingActionButton.getLayoutParams();
            if (this.f19706c && fVar.e() == view.getId() && floatingActionButton.getUserSetVisibility() == 0) {
                return true;
            }
            return false;
        }

        private boolean K(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull FloatingActionButton floatingActionButton) {
            if (!J(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f19704a == null) {
                this.f19704a = new Rect();
            }
            Rect rect = this.f19704a;
            com.google.android.material.internal.d.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.o(this.f19705b, false);
                return true;
            }
            floatingActionButton.u(this.f19705b, false);
            return true;
        }

        private boolean L(@NonNull View view, @NonNull FloatingActionButton floatingActionButton) {
            if (!J(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((CoordinatorLayout.f) floatingActionButton.getLayoutParams()).topMargin) {
                floatingActionButton.o(this.f19705b, false);
                return true;
            }
            floatingActionButton.u(this.f19705b, false);
            return true;
        }

        /* renamed from: E */
        public boolean b(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull Rect rect) {
            Rect rect2 = floatingActionButton.f19699n;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        /* renamed from: H */
        public boolean h(CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                K(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            } else if (!F(view)) {
                return false;
            } else {
                L(view, floatingActionButton);
                return false;
            }
        }

        /* renamed from: I */
        public boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, int i10) {
            List<View> r10 = coordinatorLayout.r(floatingActionButton);
            int size = r10.size();
            for (int i11 = 0; i11 < size; i11++) {
                View view = r10.get(i11);
                if (!(view instanceof AppBarLayout)) {
                    if (F(view) && L(view, floatingActionButton)) {
                        break;
                    }
                } else if (K(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.I(floatingActionButton, i10);
            G(coordinatorLayout, floatingActionButton);
            return true;
        }

        public void g(@NonNull CoordinatorLayout.f fVar) {
            if (fVar.f4369h == 0) {
                fVar.f4369h = 80;
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.FloatingActionButton_Behavior_Layout);
            this.f19706c = obtainStyledAttributes.getBoolean(l.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FloatingActionButton(@androidx.annotation.NonNull android.content.Context r11, android.util.AttributeSet r12, int r13) {
        /*
            r10 = this;
            int r6 = f19687x
            android.content.Context r11 = wf.a.c(r11, r12, r13, r6)
            r10.<init>(r11, r12, r13)
            android.graphics.Rect r11 = new android.graphics.Rect
            r11.<init>()
            r10.f19699n = r11
            android.graphics.Rect r11 = new android.graphics.Rect
            r11.<init>()
            r10.f19700p = r11
            android.content.Context r11 = r10.getContext()
            int[] r2 = bf.l.FloatingActionButton
            r7 = 0
            int[] r5 = new int[r7]
            r0 = r11
            r1 = r12
            r3 = r13
            r4 = r6
            android.content.res.TypedArray r0 = com.google.android.material.internal.p.i(r0, r1, r2, r3, r4, r5)
            int r1 = bf.l.FloatingActionButton_backgroundTint
            android.content.res.ColorStateList r1 = qf.c.a(r11, r0, r1)
            r10.f19688b = r1
            int r1 = bf.l.FloatingActionButton_backgroundTintMode
            r2 = -1
            int r1 = r0.getInt(r1, r2)
            r3 = 0
            android.graphics.PorterDuff$Mode r1 = com.google.android.material.internal.r.j(r1, r3)
            r10.f19689c = r1
            int r1 = bf.l.FloatingActionButton_rippleColor
            android.content.res.ColorStateList r1 = qf.c.a(r11, r0, r1)
            r10.f19692f = r1
            int r1 = bf.l.FloatingActionButton_fabSize
            int r1 = r0.getInt(r1, r2)
            r10.f19694h = r1
            int r1 = bf.l.FloatingActionButton_fabCustomSize
            int r1 = r0.getDimensionPixelSize(r1, r7)
            r10.f19695j = r1
            int r1 = bf.l.FloatingActionButton_borderWidth
            int r1 = r0.getDimensionPixelSize(r1, r7)
            r10.f19693g = r1
            int r1 = bf.l.FloatingActionButton_elevation
            r2 = 0
            float r1 = r0.getDimension(r1, r2)
            int r3 = bf.l.FloatingActionButton_hoveredFocusedTranslationZ
            float r3 = r0.getDimension(r3, r2)
            int r4 = bf.l.FloatingActionButton_pressedTranslationZ
            float r2 = r0.getDimension(r4, r2)
            int r4 = bf.l.FloatingActionButton_useCompatPadding
            boolean r4 = r0.getBoolean(r4, r7)
            r10.f19698m = r4
            android.content.res.Resources r4 = r10.getResources()
            int r5 = bf.d.mtrl_fab_min_touch_target
            int r4 = r4.getDimensionPixelSize(r5)
            int r5 = bf.l.FloatingActionButton_maxImageSize
            int r5 = r0.getDimensionPixelSize(r5, r7)
            r10.setMaxImageSize(r5)
            int r5 = bf.l.FloatingActionButton_showMotionSpec
            cf.h r5 = cf.h.b(r11, r0, r5)
            int r8 = bf.l.FloatingActionButton_hideMotionSpec
            cf.h r8 = cf.h.b(r11, r0, r8)
            tf.c r9 = tf.k.f24546m
            tf.k$b r11 = tf.k.g(r11, r12, r13, r6, r9)
            tf.k r11 = r11.m()
            int r6 = bf.l.FloatingActionButton_ensureMinTouchTargetSize
            boolean r6 = r0.getBoolean(r6, r7)
            int r7 = bf.l.FloatingActionButton_android_enabled
            r9 = 1
            boolean r7 = r0.getBoolean(r7, r9)
            r10.setEnabled(r7)
            r0.recycle()
            androidx.appcompat.widget.n r0 = new androidx.appcompat.widget.n
            r0.<init>(r10)
            r10.f19701q = r0
            r0.g(r12, r13)
            lf.b r12 = new lf.b
            r12.<init>(r10)
            r10.f19702t = r12
            com.google.android.material.floatingactionbutton.b r12 = r10.getImpl()
            r12.W(r11)
            com.google.android.material.floatingactionbutton.b r11 = r10.getImpl()
            android.content.res.ColorStateList r12 = r10.f19688b
            android.graphics.PorterDuff$Mode r13 = r10.f19689c
            android.content.res.ColorStateList r0 = r10.f19692f
            int r7 = r10.f19693g
            r11.w(r12, r13, r0, r7)
            com.google.android.material.floatingactionbutton.b r11 = r10.getImpl()
            r11.S(r4)
            com.google.android.material.floatingactionbutton.b r11 = r10.getImpl()
            r11.M(r1)
            com.google.android.material.floatingactionbutton.b r11 = r10.getImpl()
            r11.P(r3)
            com.google.android.material.floatingactionbutton.b r11 = r10.getImpl()
            r11.T(r2)
            com.google.android.material.floatingactionbutton.b r11 = r10.getImpl()
            r11.X(r5)
            com.google.android.material.floatingactionbutton.b r11 = r10.getImpl()
            r11.O(r8)
            com.google.android.material.floatingactionbutton.b r11 = r10.getImpl()
            r11.N(r6)
            android.widget.ImageView$ScaleType r11 = android.widget.ImageView.ScaleType.MATRIX
            r10.setScaleType(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.floatingactionbutton.FloatingActionButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.f19692f != colorStateList) {
            this.f19692f = colorStateList;
            getImpl().U(this.f19692f);
        }
    }
}
