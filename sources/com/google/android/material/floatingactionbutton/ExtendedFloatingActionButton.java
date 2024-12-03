package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.n0;
import bf.k;
import bf.l;
import cf.h;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import java.util.List;

public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.b {
    private static final int P = k.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;
    static final Property<View, Float> Q;
    static final Property<View, Float> R;
    static final Property<View, Float> S;
    static final Property<View, Float> T;
    @NonNull
    private final d B;
    @NonNull
    private final d C;
    private final d D;
    private final d E;
    private final int F;
    private int G;
    private int H;
    @NonNull
    private final CoordinatorLayout.c<ExtendedFloatingActionButton> I;
    private boolean J;
    private boolean K;
    private boolean L;
    @NonNull
    protected ColorStateList M;
    private int N;
    private int O;

    /* renamed from: z  reason: collision with root package name */
    private int f19680z;

    class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private boolean f19684a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f19685b;

        a(d dVar, f fVar) {
            this.f19685b = dVar;
        }

        public void onAnimationCancel(Animator animator) {
            this.f19684a = true;
            this.f19685b.e();
        }

        public void onAnimationEnd(Animator animator) {
            this.f19685b.f();
            if (!this.f19684a) {
                this.f19685b.i((f) null);
            }
        }

        public void onAnimationStart(Animator animator) {
            this.f19685b.onAnimationStart(animator);
            this.f19684a = false;
        }
    }

    class b extends Property<View, Float> {
        b(Class cls, String str) {
            super(cls, str);
        }

        @NonNull
        /* renamed from: a */
        public Float get(@NonNull View view) {
            return Float.valueOf((float) view.getLayoutParams().width);
        }

        /* renamed from: b */
        public void set(@NonNull View view, @NonNull Float f10) {
            view.getLayoutParams().width = f10.intValue();
            view.requestLayout();
        }
    }

    class c extends Property<View, Float> {
        c(Class cls, String str) {
            super(cls, str);
        }

        @NonNull
        /* renamed from: a */
        public Float get(@NonNull View view) {
            return Float.valueOf((float) view.getLayoutParams().height);
        }

        /* renamed from: b */
        public void set(@NonNull View view, @NonNull Float f10) {
            view.getLayoutParams().height = f10.intValue();
            view.requestLayout();
        }
    }

    class d extends Property<View, Float> {
        d(Class cls, String str) {
            super(cls, str);
        }

        @NonNull
        /* renamed from: a */
        public Float get(@NonNull View view) {
            return Float.valueOf((float) n0.G(view));
        }

        /* renamed from: b */
        public void set(@NonNull View view, @NonNull Float f10) {
            n0.I0(view, f10.intValue(), view.getPaddingTop(), n0.F(view), view.getPaddingBottom());
        }
    }

    class e extends Property<View, Float> {
        e(Class cls, String str) {
            super(cls, str);
        }

        @NonNull
        /* renamed from: a */
        public Float get(@NonNull View view) {
            return Float.valueOf((float) n0.F(view));
        }

        /* renamed from: b */
        public void set(@NonNull View view, @NonNull Float f10) {
            n0.I0(view, n0.G(view), view.getPaddingTop(), f10.intValue(), view.getPaddingBottom());
        }
    }

    public static abstract class f {
    }

    static {
        Class<Float> cls = Float.class;
        Q = new b(cls, ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
        R = new c(cls, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
        S = new d(cls, "paddingStart");
        T = new e(cls, "paddingEnd");
    }

    private boolean k() {
        if (getVisibility() != 0) {
            if (this.f19680z == 2) {
                return true;
            }
            return false;
        } else if (this.f19680z != 1) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void l(int i10, f fVar) {
        d dVar;
        if (i10 == 0) {
            dVar = this.D;
        } else if (i10 == 1) {
            dVar = this.E;
        } else if (i10 == 2) {
            dVar = this.B;
        } else if (i10 == 3) {
            dVar = this.C;
        } else {
            throw new IllegalStateException("Unknown strategy type: " + i10);
        }
        if (!dVar.c()) {
            if (!n()) {
                dVar.a();
                dVar.i(fVar);
                return;
            }
            if (i10 == 2) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams != null) {
                    this.N = layoutParams.width;
                    this.O = layoutParams.height;
                } else {
                    this.N = getWidth();
                    this.O = getHeight();
                }
            }
            measure(0, 0);
            AnimatorSet g10 = dVar.g();
            g10.addListener(new a(dVar, fVar));
            for (Animator.AnimatorListener addListener : dVar.h()) {
                g10.addListener(addListener);
            }
            g10.start();
        }
    }

    private void m() {
        this.M = getTextColors();
    }

    private boolean n() {
        if ((n0.W(this) || (!k() && this.L)) && !isInEditMode()) {
            return true;
        }
        return false;
    }

    @NonNull
    public CoordinatorLayout.c<ExtendedFloatingActionButton> getBehavior() {
        return this.I;
    }

    /* access modifiers changed from: package-private */
    public int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    /* access modifiers changed from: package-private */
    public int getCollapsedSize() {
        int i10 = this.F;
        if (i10 < 0) {
            return (Math.min(n0.G(this), n0.F(this)) * 2) + getIconSize();
        }
        return i10;
    }

    public h getExtendMotionSpec() {
        return this.C.b();
    }

    public h getHideMotionSpec() {
        return this.E.b();
    }

    public h getShowMotionSpec() {
        return this.D.b();
    }

    public h getShrinkMotionSpec() {
        return this.B.b();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.J && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.J = false;
            this.B.a();
        }
    }

    public void setAnimateShowBeforeLayout(boolean z10) {
        this.L = z10;
    }

    public void setExtendMotionSpec(h hVar) {
        this.C.d(hVar);
    }

    public void setExtendMotionSpecResource(int i10) {
        setExtendMotionSpec(h.c(getContext(), i10));
    }

    public void setExtended(boolean z10) {
        d dVar;
        if (this.J != z10) {
            if (z10) {
                dVar = this.C;
            } else {
                dVar = this.B;
            }
            if (!dVar.c()) {
                dVar.a();
            }
        }
    }

    public void setHideMotionSpec(h hVar) {
        this.E.d(hVar);
    }

    public void setHideMotionSpecResource(int i10) {
        setHideMotionSpec(h.c(getContext(), i10));
    }

    public void setPadding(int i10, int i11, int i12, int i13) {
        super.setPadding(i10, i11, i12, i13);
        if (this.J && !this.K) {
            this.G = n0.G(this);
            this.H = n0.F(this);
        }
    }

    public void setPaddingRelative(int i10, int i11, int i12, int i13) {
        super.setPaddingRelative(i10, i11, i12, i13);
        if (this.J && !this.K) {
            this.G = i10;
            this.H = i12;
        }
    }

    public void setShowMotionSpec(h hVar) {
        this.D.d(hVar);
    }

    public void setShowMotionSpecResource(int i10) {
        setShowMotionSpec(h.c(getContext(), i10));
    }

    public void setShrinkMotionSpec(h hVar) {
        this.B.d(hVar);
    }

    public void setShrinkMotionSpecResource(int i10) {
        setShrinkMotionSpec(h.c(getContext(), i10));
    }

    public void setTextColor(int i10) {
        super.setTextColor(i10);
        m();
    }

    protected static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.c<T> {

        /* renamed from: a  reason: collision with root package name */
        private Rect f19681a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f19682b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f19683c;

        public ExtendedFloatingActionButtonBehavior() {
            this.f19682b = false;
            this.f19683c = true;
        }

        private static boolean G(@NonNull View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                return ((CoordinatorLayout.f) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean J(@NonNull View view, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams();
            if ((this.f19682b || this.f19683c) && fVar.e() == view.getId()) {
                return true;
            }
            return false;
        }

        private boolean L(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!J(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.f19681a == null) {
                this.f19681a = new Rect();
            }
            Rect rect = this.f19681a;
            com.google.android.material.internal.d.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                K(extendedFloatingActionButton);
                return true;
            }
            E(extendedFloatingActionButton);
            return true;
        }

        private boolean M(@NonNull View view, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!J(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams()).topMargin) {
                K(extendedFloatingActionButton);
                return true;
            }
            E(extendedFloatingActionButton);
            return true;
        }

        /* access modifiers changed from: protected */
        public void E(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            int i10;
            if (this.f19683c) {
                i10 = 3;
            } else {
                i10 = 0;
            }
            extendedFloatingActionButton.l(i10, (f) null);
        }

        /* renamed from: F */
        public boolean b(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, @NonNull Rect rect) {
            return super.b(coordinatorLayout, extendedFloatingActionButton, rect);
        }

        /* renamed from: H */
        public boolean h(CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                L(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            } else if (!G(view)) {
                return false;
            } else {
                M(view, extendedFloatingActionButton);
                return false;
            }
        }

        /* renamed from: I */
        public boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, int i10) {
            List<View> r10 = coordinatorLayout.r(extendedFloatingActionButton);
            int size = r10.size();
            for (int i11 = 0; i11 < size; i11++) {
                View view = r10.get(i11);
                if (!(view instanceof AppBarLayout)) {
                    if (G(view) && M(view, extendedFloatingActionButton)) {
                        break;
                    }
                } else if (L(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.I(extendedFloatingActionButton, i10);
            return true;
        }

        /* access modifiers changed from: protected */
        public void K(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            int i10;
            if (this.f19683c) {
                i10 = 2;
            } else {
                i10 = 1;
            }
            extendedFloatingActionButton.l(i10, (f) null);
        }

        public void g(@NonNull CoordinatorLayout.f fVar) {
            if (fVar.f4369h == 0) {
                fVar.f4369h = 80;
            }
        }

        public ExtendedFloatingActionButtonBehavior(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.ExtendedFloatingActionButton_Behavior_Layout);
            this.f19682b = obtainStyledAttributes.getBoolean(l.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.f19683c = obtainStyledAttributes.getBoolean(l.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            obtainStyledAttributes.recycle();
        }
    }

    public void setTextColor(@NonNull ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        m();
    }
}
