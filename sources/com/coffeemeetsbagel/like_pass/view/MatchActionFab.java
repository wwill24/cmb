package com.coffeemeetsbagel.like_pass.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import j5.x;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import q5.q;

public class MatchActionFab extends FloatingActionButton implements c {
    /* access modifiers changed from: private */
    public boolean B = false;
    /* access modifiers changed from: private */
    public boolean C = false;
    /* access modifiers changed from: private */
    public AnimatorSet D;

    /* renamed from: y  reason: collision with root package name */
    private final io.reactivex.subjects.a<x> f14079y = io.reactivex.subjects.a.C0();
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public boolean f14080z = true;

    class a extends q {
        a() {
        }

        public void onAnimationEnd(Animator animator) {
            MatchActionFab.this.C = false;
            MatchActionFab.this.f14080z = false;
            MatchActionFab.this.D = null;
            MatchActionFab.this.setVisibility(0);
        }
    }

    class b extends q {
        b() {
        }

        public void onAnimationEnd(Animator animator) {
            MatchActionFab.this.B = false;
            MatchActionFab.this.f14080z = true;
            MatchActionFab.this.D = null;
            MatchActionFab.this.setVisibility(8);
        }
    }

    public MatchActionFab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private List<Animator> B(float f10, float f11) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this, "scaleX", new float[]{f10, f11}));
        arrayList.add(ObjectAnimator.ofFloat(this, "scaleY", new float[]{f10, f11}));
        return arrayList;
    }

    private void C(List<Animator> list, Animator.AnimatorListener animatorListener) {
        AnimatorSet animatorSet = this.D;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.D = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.D = animatorSet2;
        animatorSet2.playTogether(list);
        this.D.addListener(animatorListener);
        this.D.setDuration(200);
        this.D.start();
    }

    public qj.q<x> A() {
        return this.f14079y.p0(1000, TimeUnit.MILLISECONDS).P();
    }

    public void a() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("show - isHidden? ");
        sb2.append(this.f14080z);
        sb2.append(" - isShowAnimationInProgress? ");
        sb2.append(this.C);
        if (this.f14080z && !this.C) {
            this.C = true;
            C(B(0.0f, 1.0f), new a());
        }
    }

    public void c() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("hide - isHidden? ");
        sb2.append(this.f14080z);
        sb2.append(" - isShowAnimationInProgress? ");
        sb2.append(this.C);
        if (!this.B) {
            this.B = true;
            C(B(1.0f, 0.0f), new b());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return true;
        }
        performClick();
        return true;
    }

    public boolean performClick() {
        this.f14079y.d(x.a());
        return super.performClick();
    }

    public MatchActionFab(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
