package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.n0;
import androidx.customview.view.AbsSavedState;
import bf.k;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.r;
import com.leanplum.messagetemplates.MessageTemplateConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tf.h;

public class BottomAppBar extends Toolbar implements CoordinatorLayout.b {
    private static final int B0 = k.Widget_MaterialComponents_BottomAppBar;
    private static final int C0 = bf.b.motionDurationLong2;
    private static final int D0 = bf.b.motionEasingEmphasizedInterpolator;
    @NonNull
    cf.k<FloatingActionButton> A0;

    /* renamed from: e0  reason: collision with root package name */
    private Integer f19199e0;

    /* renamed from: f0  reason: collision with root package name */
    private final tf.g f19200f0;
    /* access modifiers changed from: private */

    /* renamed from: g0  reason: collision with root package name */
    public Animator f19201g0;
    /* access modifiers changed from: private */

    /* renamed from: h0  reason: collision with root package name */
    public Animator f19202h0;

    /* renamed from: i0  reason: collision with root package name */
    private int f19203i0;

    /* renamed from: j0  reason: collision with root package name */
    private int f19204j0;
    /* access modifiers changed from: private */

    /* renamed from: k0  reason: collision with root package name */
    public int f19205k0;
    /* access modifiers changed from: private */

    /* renamed from: l0  reason: collision with root package name */
    public final int f19206l0;

    /* renamed from: m0  reason: collision with root package name */
    private int f19207m0;

    /* renamed from: n0  reason: collision with root package name */
    private int f19208n0;
    /* access modifiers changed from: private */

    /* renamed from: o0  reason: collision with root package name */
    public final boolean f19209o0;

    /* renamed from: p0  reason: collision with root package name */
    private boolean f19210p0;

    /* renamed from: q0  reason: collision with root package name */
    private int f19211q0;

    /* renamed from: r0  reason: collision with root package name */
    private ArrayList<g> f19212r0;
    /* access modifiers changed from: private */

    /* renamed from: s0  reason: collision with root package name */
    public int f19213s0;
    /* access modifiers changed from: private */

    /* renamed from: t0  reason: collision with root package name */
    public boolean f19214t0;

    /* renamed from: u0  reason: collision with root package name */
    private boolean f19215u0;

    /* renamed from: v0  reason: collision with root package name */
    private Behavior f19216v0;

    /* renamed from: w0  reason: collision with root package name */
    private int f19217w0;

    /* renamed from: x0  reason: collision with root package name */
    private int f19218x0;

    /* renamed from: y0  reason: collision with root package name */
    private int f19219y0;
    @NonNull

    /* renamed from: z0  reason: collision with root package name */
    AnimatorListenerAdapter f19220z0;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        int f19226c;

        /* renamed from: d  reason: collision with root package name */
        boolean f19227d;

        class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            @NonNull
            /* renamed from: b */
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @NonNull
            /* renamed from: c */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(@NonNull Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f19226c);
            parcel.writeInt(this.f19227d ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f19226c = parcel.readInt();
            this.f19227d = parcel.readInt() != 0;
        }
    }

    class a extends AnimatorListenerAdapter {
        a() {
        }

        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.t0();
            Animator unused = BottomAppBar.this.f19201g0 = null;
        }

        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.u0();
        }
    }

    class b extends FloatingActionButton.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19229a;

        class a extends FloatingActionButton.b {
            a() {
            }

            public void b(FloatingActionButton floatingActionButton) {
                BottomAppBar.this.t0();
            }
        }

        b(int i10) {
            this.f19229a = i10;
        }

        public void a(@NonNull FloatingActionButton floatingActionButton) {
            floatingActionButton.setTranslationX(BottomAppBar.this.y0(this.f19229a));
            floatingActionButton.t(new a());
        }
    }

    class c extends AnimatorListenerAdapter {
        c() {
        }

        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.t0();
            boolean unused = BottomAppBar.this.f19214t0 = false;
            Animator unused2 = BottomAppBar.this.f19202h0 = null;
        }

        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.u0();
        }
    }

    class d extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public boolean f19233a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ActionMenuView f19234b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f19235c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f19236d;

        d(ActionMenuView actionMenuView, int i10, boolean z10) {
            this.f19234b = actionMenuView;
            this.f19235c = i10;
            this.f19236d = z10;
        }

        public void onAnimationCancel(Animator animator) {
            this.f19233a = true;
        }

        public void onAnimationEnd(Animator animator) {
            boolean z10;
            if (!this.f19233a) {
                if (BottomAppBar.this.f19213s0 != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                BottomAppBar bottomAppBar = BottomAppBar.this;
                bottomAppBar.E0(bottomAppBar.f19213s0);
                BottomAppBar.this.K0(this.f19234b, this.f19235c, this.f19236d, z10);
            }
        }
    }

    class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ActionMenuView f19238a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f19239b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f19240c;

        e(ActionMenuView actionMenuView, int i10, boolean z10) {
            this.f19238a = actionMenuView;
            this.f19239b = i10;
            this.f19240c = z10;
        }

        public void run() {
            ActionMenuView actionMenuView = this.f19238a;
            actionMenuView.setTranslationX((float) BottomAppBar.this.x0(actionMenuView, this.f19239b, this.f19240c));
        }
    }

    class f extends AnimatorListenerAdapter {
        f() {
        }

        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.f19220z0.onAnimationStart(animator);
            FloatingActionButton d02 = BottomAppBar.this.v0();
            if (d02 != null) {
                d02.setTranslationX(BottomAppBar.this.getFabTranslationX());
            }
        }
    }

    interface g {
        void a(BottomAppBar bottomAppBar);

        void b(BottomAppBar bottomAppBar);
    }

    private void B0(int i10, boolean z10) {
        if (!n0.W(this)) {
            this.f19214t0 = false;
            E0(this.f19213s0);
            return;
        }
        Animator animator = this.f19202h0;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (!z0()) {
            i10 = 0;
            z10 = false;
        }
        s0(i10, z10, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.f19202h0 = animatorSet;
        animatorSet.addListener(new c());
        this.f19202h0.start();
    }

    private void C0(int i10) {
        if (this.f19203i0 != i10 && n0.W(this)) {
            Animator animator = this.f19201g0;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (this.f19204j0 == 1) {
                r0(i10, arrayList);
            } else {
                q0(i10, arrayList);
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            animatorSet.setInterpolator(of.a.g(getContext(), D0, cf.a.f18977a));
            this.f19201g0 = animatorSet;
            animatorSet.addListener(new a());
            this.f19201g0.start();
        }
    }

    private Drawable D0(Drawable drawable) {
        if (drawable == null || this.f19199e0 == null) {
            return drawable;
        }
        Drawable r10 = androidx.core.graphics.drawable.a.r(drawable.mutate());
        androidx.core.graphics.drawable.a.n(r10, this.f19199e0.intValue());
        return r10;
    }

    private void F0() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null && this.f19202h0 == null) {
            actionMenuView.setAlpha(1.0f);
            if (!z0()) {
                J0(actionMenuView, 0, false);
            } else {
                J0(actionMenuView, this.f19203i0, this.f19215u0);
            }
        }
    }

    /* access modifiers changed from: private */
    public void G0() {
        float f10;
        getTopEdgeTreatment().q(getFabTranslationX());
        tf.g gVar = this.f19200f0;
        if (!this.f19215u0 || !z0() || this.f19205k0 != 1) {
            f10 = 0.0f;
        } else {
            f10 = 1.0f;
        }
        gVar.c0(f10);
        View w02 = w0();
        if (w02 != null) {
            w02.setTranslationY(getFabTranslationY());
            w02.setTranslationX(getFabTranslationX());
        }
    }

    private void J0(@NonNull ActionMenuView actionMenuView, int i10, boolean z10) {
        K0(actionMenuView, i10, z10, false);
    }

    /* access modifiers changed from: private */
    public void K0(@NonNull ActionMenuView actionMenuView, int i10, boolean z10, boolean z11) {
        e eVar = new e(actionMenuView, i10, z10);
        if (z11) {
            actionMenuView.post(eVar);
        } else {
            eVar.run();
        }
    }

    /* access modifiers changed from: private */
    public static void L0(BottomAppBar bottomAppBar, View view) {
        CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
        fVar.f4365d = 17;
        int i10 = bottomAppBar.f19205k0;
        if (i10 == 1) {
            fVar.f4365d = 17 | 48;
        }
        if (i10 == 0) {
            fVar.f4365d |= 80;
        }
    }

    private ActionMenuView getActionMenuView() {
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public int getBottomInset() {
        return this.f19217w0;
    }

    private int getFabAlignmentAnimationDuration() {
        return of.a.f(getContext(), C0, MessageTemplateConstants.Values.CENTER_POPUP_WIDTH);
    }

    /* access modifiers changed from: private */
    public float getFabTranslationX() {
        return y0(this.f19203i0);
    }

    private float getFabTranslationY() {
        if (this.f19205k0 == 1) {
            return -getTopEdgeTreatment().c();
        }
        return 0.0f;
    }

    /* access modifiers changed from: private */
    public int getLeftInset() {
        return this.f19219y0;
    }

    /* access modifiers changed from: private */
    public int getRightInset() {
        return this.f19218x0;
    }

    @NonNull
    private b getTopEdgeTreatment() {
        return (b) this.f19200f0.E().p();
    }

    /* access modifiers changed from: private */
    public void o0(@NonNull FloatingActionButton floatingActionButton) {
        floatingActionButton.g(this.f19220z0);
        floatingActionButton.h(new f());
        floatingActionButton.i(this.A0);
    }

    private void p0() {
        Animator animator = this.f19202h0;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.f19201g0;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    private void r0(int i10, @NonNull List<Animator> list) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(v0(), "translationX", new float[]{y0(i10)});
        ofFloat.setDuration((long) getFabAlignmentAnimationDuration());
        list.add(ofFloat);
    }

    private void s0(int i10, boolean z10, @NonNull List<Animator> list) {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            float fabAlignmentAnimationDuration = (float) getFabAlignmentAnimationDuration();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", new float[]{1.0f});
            ofFloat.setDuration((long) (0.8f * fabAlignmentAnimationDuration));
            if (Math.abs(actionMenuView.getTranslationX() - ((float) x0(actionMenuView, i10, z10))) > 1.0f) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", new float[]{0.0f});
                ofFloat2.setDuration((long) (fabAlignmentAnimationDuration * 0.2f));
                ofFloat2.addListener(new d(actionMenuView, i10, z10));
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playSequentially(new Animator[]{ofFloat2, ofFloat});
                list.add(animatorSet);
            } else if (actionMenuView.getAlpha() < 1.0f) {
                list.add(ofFloat);
            }
        }
    }

    /* access modifiers changed from: private */
    public void t0() {
        ArrayList<g> arrayList;
        int i10 = this.f19211q0 - 1;
        this.f19211q0 = i10;
        if (i10 == 0 && (arrayList = this.f19212r0) != null) {
            Iterator<g> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
        }
    }

    /* access modifiers changed from: private */
    public void u0() {
        ArrayList<g> arrayList;
        int i10 = this.f19211q0;
        this.f19211q0 = i10 + 1;
        if (i10 == 0 && (arrayList = this.f19212r0) != null) {
            Iterator<g> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b(this);
            }
        }
    }

    /* access modifiers changed from: private */
    public FloatingActionButton v0() {
        View w02 = w0();
        if (w02 instanceof FloatingActionButton) {
            return (FloatingActionButton) w02;
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View w0() {
        /*
            r4 = this;
            android.view.ViewParent r0 = r4.getParent()
            boolean r0 = r0 instanceof androidx.coordinatorlayout.widget.CoordinatorLayout
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            android.view.ViewParent r0 = r4.getParent()
            androidx.coordinatorlayout.widget.CoordinatorLayout r0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) r0
            java.util.List r0 = r0.s(r4)
            java.util.Iterator r0 = r0.iterator()
        L_0x0018:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x002d
            java.lang.Object r2 = r0.next()
            android.view.View r2 = (android.view.View) r2
            boolean r3 = r2 instanceof com.google.android.material.floatingactionbutton.FloatingActionButton
            if (r3 != 0) goto L_0x002c
            boolean r3 = r2 instanceof com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
            if (r3 == 0) goto L_0x0018
        L_0x002c:
            return r2
        L_0x002d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomappbar.BottomAppBar.w0():android.view.View");
    }

    /* access modifiers changed from: private */
    public float y0(int i10) {
        int i11;
        int i12;
        boolean i13 = r.i(this);
        int i14 = 1;
        if (i10 != 1) {
            return 0.0f;
        }
        View w02 = w0();
        if (i13) {
            i11 = this.f19219y0;
        } else {
            i11 = this.f19218x0;
        }
        if (this.f19207m0 == -1 || w02 == null) {
            i12 = this.f19206l0;
        } else {
            i12 = (w02.getMeasuredWidth() / 2) + this.f19207m0;
        }
        int measuredWidth = (getMeasuredWidth() / 2) - (i11 + i12);
        if (i13) {
            i14 = -1;
        }
        return (float) (measuredWidth * i14);
    }

    private boolean z0() {
        FloatingActionButton v02 = v0();
        if (v02 == null || !v02.q()) {
            return false;
        }
        return true;
    }

    public void E0(int i10) {
        if (i10 != 0) {
            this.f19213s0 = 0;
            getMenu().clear();
            x(i10);
        }
    }

    public void H0(int i10, int i11) {
        this.f19213s0 = i11;
        this.f19214t0 = true;
        B0(i10, this.f19215u0);
        C0(i10);
        this.f19203i0 = i10;
    }

    /* access modifiers changed from: package-private */
    public boolean I0(int i10) {
        float f10 = (float) i10;
        if (f10 == getTopEdgeTreatment().i()) {
            return false;
        }
        getTopEdgeTreatment().p(f10);
        this.f19200f0.invalidateSelf();
        return true;
    }

    public ColorStateList getBackgroundTint() {
        return this.f19200f0.I();
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().c();
    }

    public int getFabAlignmentMode() {
        return this.f19203i0;
    }

    public int getFabAlignmentModeEndMargin() {
        return this.f19207m0;
    }

    public int getFabAnchorMode() {
        return this.f19205k0;
    }

    public int getFabAnimationMode() {
        return this.f19204j0;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().e();
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().h();
    }

    public boolean getHideOnScroll() {
        return this.f19210p0;
    }

    public int getMenuAlignmentMode() {
        return this.f19208n0;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.f(this, this.f19200f0);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            p0();
            G0();
            View w02 = w0();
            if (w02 != null && n0.W(w02)) {
                w02.post(new a(w02));
            }
        }
        F0();
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.f19203i0 = savedState.f19226c;
        this.f19215u0 = savedState.f19227d;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f19226c = this.f19203i0;
        savedState.f19227d = this.f19215u0;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void q0(int i10, List<Animator> list) {
        FloatingActionButton v02 = v0();
        if (v02 != null && !v02.p()) {
            u0();
            v02.n(new b(i10));
        }
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        androidx.core.graphics.drawable.a.o(this.f19200f0, colorStateList);
    }

    public void setCradleVerticalOffset(float f10) {
        if (f10 != getCradleVerticalOffset()) {
            getTopEdgeTreatment().j(f10);
            this.f19200f0.invalidateSelf();
            G0();
        }
    }

    public void setElevation(float f10) {
        this.f19200f0.a0(f10);
        getBehavior().I(this, this.f19200f0.D() - this.f19200f0.C());
    }

    public void setFabAlignmentMode(int i10) {
        H0(i10, 0);
    }

    public void setFabAlignmentModeEndMargin(int i10) {
        if (this.f19207m0 != i10) {
            this.f19207m0 = i10;
            G0();
        }
    }

    public void setFabAnchorMode(int i10) {
        this.f19205k0 = i10;
        G0();
        View w02 = w0();
        if (w02 != null) {
            L0(this, w02);
            w02.requestLayout();
            this.f19200f0.invalidateSelf();
        }
    }

    public void setFabAnimationMode(int i10) {
        this.f19204j0 = i10;
    }

    /* access modifiers changed from: package-private */
    public void setFabCornerSize(float f10) {
        if (f10 != getTopEdgeTreatment().d()) {
            getTopEdgeTreatment().k(f10);
            this.f19200f0.invalidateSelf();
        }
    }

    public void setFabCradleMargin(float f10) {
        if (f10 != getFabCradleMargin()) {
            getTopEdgeTreatment().l(f10);
            this.f19200f0.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(float f10) {
        if (f10 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().o(f10);
            this.f19200f0.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z10) {
        this.f19210p0 = z10;
    }

    public void setMenuAlignmentMode(int i10) {
        if (this.f19208n0 != i10) {
            this.f19208n0 = i10;
            ActionMenuView actionMenuView = getActionMenuView();
            if (actionMenuView != null) {
                J0(actionMenuView, this.f19203i0, z0());
            }
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(D0(drawable));
    }

    public void setNavigationIconTint(int i10) {
        this.f19199e0 = Integer.valueOf(i10);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
    }

    public void setTitle(CharSequence charSequence) {
    }

    /* access modifiers changed from: protected */
    public int x0(@NonNull ActionMenuView actionMenuView, int i10, boolean z10) {
        int i11;
        int i12;
        int i13;
        boolean z11;
        int i14 = 0;
        if (this.f19208n0 != 1 && (i10 != 1 || !z10)) {
            return 0;
        }
        boolean i15 = r.i(this);
        if (i15) {
            i11 = getMeasuredWidth();
        } else {
            i11 = 0;
        }
        for (int i16 = 0; i16 < getChildCount(); i16++) {
            View childAt = getChildAt(i16);
            if (!(childAt.getLayoutParams() instanceof Toolbar.g) || (((Toolbar.g) childAt.getLayoutParams()).f538a & 8388615) != 8388611) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                if (i15) {
                    i11 = Math.min(i11, childAt.getLeft());
                } else {
                    i11 = Math.max(i11, childAt.getRight());
                }
            }
        }
        if (i15) {
            i12 = actionMenuView.getRight();
        } else {
            i12 = actionMenuView.getLeft();
        }
        if (i15) {
            i13 = this.f19218x0;
        } else {
            i13 = -this.f19219y0;
        }
        if (getNavigationIcon() == null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(bf.d.m3_bottomappbar_horizontal_padding);
            if (i15) {
                i14 = dimensionPixelOffset;
            } else {
                i14 = -dimensionPixelOffset;
            }
        }
        return i11 - ((i12 + i13) + i14);
    }

    @NonNull
    public Behavior getBehavior() {
        if (this.f19216v0 == null) {
            this.f19216v0 = new Behavior();
        }
        return this.f19216v0;
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
        /* access modifiers changed from: private */
        @NonNull

        /* renamed from: m  reason: collision with root package name */
        public final Rect f19221m = new Rect();
        /* access modifiers changed from: private */

        /* renamed from: n  reason: collision with root package name */
        public WeakReference<BottomAppBar> f19222n;
        /* access modifiers changed from: private */

        /* renamed from: o  reason: collision with root package name */
        public int f19223o;

        /* renamed from: p  reason: collision with root package name */
        private final View.OnLayoutChangeListener f19224p = new a();

        class a implements View.OnLayoutChangeListener {
            a() {
            }

            public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                BottomAppBar bottomAppBar = (BottomAppBar) Behavior.this.f19222n.get();
                if (bottomAppBar == null || (!(view instanceof FloatingActionButton) && !(view instanceof ExtendedFloatingActionButton))) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                int height = view.getHeight();
                if (view instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                    floatingActionButton.l(Behavior.this.f19221m);
                    int height2 = Behavior.this.f19221m.height();
                    bottomAppBar.I0(height2);
                    bottomAppBar.setFabCornerSize(floatingActionButton.getShapeAppearanceModel().r().a(new RectF(Behavior.this.f19221m)));
                    height = height2;
                }
                CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
                if (Behavior.this.f19223o == 0) {
                    int measuredHeight = (view.getMeasuredHeight() - height) / 2;
                    if (bottomAppBar.f19205k0 == 1) {
                        fVar.bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(bf.d.mtrl_bottomappbar_fab_bottom_margin) - measuredHeight);
                    } else if (bottomAppBar.f19205k0 == 0) {
                        fVar.bottomMargin = ((bottomAppBar.getMeasuredHeight() + bottomAppBar.getBottomInset()) - view.getMeasuredHeight()) / 2;
                    }
                    fVar.leftMargin = bottomAppBar.getLeftInset();
                    fVar.rightMargin = bottomAppBar.getRightInset();
                    if (r.i(view)) {
                        fVar.leftMargin += bottomAppBar.f19206l0;
                    } else {
                        fVar.rightMargin += bottomAppBar.f19206l0;
                    }
                }
            }
        }

        public Behavior() {
        }

        /* renamed from: R */
        public boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomAppBar bottomAppBar, int i10) {
            this.f19222n = new WeakReference<>(bottomAppBar);
            View j02 = bottomAppBar.w0();
            if (j02 != null && !n0.W(j02)) {
                BottomAppBar.L0(bottomAppBar, j02);
                this.f19223o = ((CoordinatorLayout.f) j02.getLayoutParams()).bottomMargin;
                if (j02 instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) j02;
                    if (bottomAppBar.f19205k0 == 0 && bottomAppBar.f19209o0) {
                        n0.A0(floatingActionButton, 0.0f);
                        floatingActionButton.setCompatElevation(0.0f);
                    }
                    if (floatingActionButton.getShowMotionSpec() == null) {
                        floatingActionButton.setShowMotionSpecResource(bf.a.mtrl_fab_show_motion_spec);
                    }
                    if (floatingActionButton.getHideMotionSpec() == null) {
                        floatingActionButton.setHideMotionSpecResource(bf.a.mtrl_fab_hide_motion_spec);
                    }
                    bottomAppBar.o0(floatingActionButton);
                }
                j02.addOnLayoutChangeListener(this.f19224p);
                bottomAppBar.G0();
            }
            coordinatorLayout.I(bottomAppBar, i10);
            return super.l(coordinatorLayout, bottomAppBar, i10);
        }

        /* renamed from: S */
        public boolean A(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomAppBar bottomAppBar, @NonNull View view, @NonNull View view2, int i10, int i11) {
            if (!bottomAppBar.getHideOnScroll() || !super.A(coordinatorLayout, bottomAppBar, view, view2, i10, i11)) {
                return false;
            }
            return true;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }
}
