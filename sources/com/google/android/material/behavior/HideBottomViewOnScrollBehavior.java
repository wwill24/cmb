package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.Iterator;
import java.util.LinkedHashSet;
import net.bytebuddy.jar.asm.Opcodes;

public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: j  reason: collision with root package name */
    private static final int f19168j = bf.b.motionDurationLong2;

    /* renamed from: k  reason: collision with root package name */
    private static final int f19169k = bf.b.motionDurationMedium4;

    /* renamed from: l  reason: collision with root package name */
    private static final int f19170l = bf.b.motionEasingEmphasizedInterpolator;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashSet<b> f19171a = new LinkedHashSet<>();

    /* renamed from: b  reason: collision with root package name */
    private int f19172b;

    /* renamed from: c  reason: collision with root package name */
    private int f19173c;

    /* renamed from: d  reason: collision with root package name */
    private TimeInterpolator f19174d;

    /* renamed from: e  reason: collision with root package name */
    private TimeInterpolator f19175e;

    /* renamed from: f  reason: collision with root package name */
    private int f19176f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f19177g = 2;

    /* renamed from: h  reason: collision with root package name */
    private int f19178h = 0;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public ViewPropertyAnimator f19179i;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        public void onAnimationEnd(Animator animator) {
            ViewPropertyAnimator unused = HideBottomViewOnScrollBehavior.this.f19179i = null;
        }
    }

    public interface b {
        void a(@NonNull View view, int i10);
    }

    public HideBottomViewOnScrollBehavior() {
    }

    private void F(@NonNull V v10, int i10, long j10, TimeInterpolator timeInterpolator) {
        this.f19179i = v10.animate().translationY((float) i10).setInterpolator(timeInterpolator).setDuration(j10).setListener(new a());
    }

    private void N(@NonNull V v10, int i10) {
        this.f19177g = i10;
        Iterator<b> it = this.f19171a.iterator();
        while (it.hasNext()) {
            it.next().a(v10, this.f19177g);
        }
    }

    public boolean A(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, @NonNull View view2, int i10, int i11) {
        return i10 == 2;
    }

    public boolean G() {
        return this.f19177g == 1;
    }

    public boolean H() {
        return this.f19177g == 2;
    }

    public void I(@NonNull V v10, int i10) {
        this.f19178h = i10;
        if (this.f19177g == 1) {
            v10.setTranslationY((float) (this.f19176f + i10));
        }
    }

    public void J(@NonNull V v10) {
        K(v10, true);
    }

    public void K(@NonNull V v10, boolean z10) {
        if (!G()) {
            ViewPropertyAnimator viewPropertyAnimator = this.f19179i;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                v10.clearAnimation();
            }
            N(v10, 1);
            int i10 = this.f19176f + this.f19178h;
            if (z10) {
                F(v10, i10, (long) this.f19173c, this.f19175e);
                return;
            }
            v10.setTranslationY((float) i10);
        }
    }

    public void L(@NonNull V v10) {
        M(v10, true);
    }

    public void M(@NonNull V v10, boolean z10) {
        if (!H()) {
            ViewPropertyAnimator viewPropertyAnimator = this.f19179i;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                v10.clearAnimation();
            }
            N(v10, 2);
            if (z10) {
                F(v10, 0, (long) this.f19172b, this.f19174d);
                return;
            }
            v10.setTranslationY((float) 0);
        }
    }

    public boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v10, int i10) {
        this.f19176f = v10.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v10.getLayoutParams()).bottomMargin;
        this.f19172b = of.a.f(v10.getContext(), f19168j, 225);
        this.f19173c = of.a.f(v10.getContext(), f19169k, Opcodes.DRETURN);
        Context context = v10.getContext();
        int i11 = f19170l;
        this.f19174d = of.a.g(context, i11, cf.a.f18980d);
        this.f19175e = of.a.g(v10.getContext(), i11, cf.a.f18979c);
        return super.l(coordinatorLayout, v10, i10);
    }

    public void t(CoordinatorLayout coordinatorLayout, @NonNull V v10, @NonNull View view, int i10, int i11, int i12, int i13, int i14, @NonNull int[] iArr) {
        if (i11 > 0) {
            J(v10);
        } else if (i11 < 0) {
            L(v10);
        }
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
