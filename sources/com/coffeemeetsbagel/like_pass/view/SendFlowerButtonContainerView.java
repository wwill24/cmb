package com.coffeemeetsbagel.like_pass.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.mparticle.identity.IdentityHttpResponse;
import fa.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import q5.q;

public final class SendFlowerButtonContainerView extends LinearLayout implements c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public boolean f14090a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f14091b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f14092c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public AnimatorSet f14093d;

    /* renamed from: e  reason: collision with root package name */
    private final long f14094e;

    /* renamed from: f  reason: collision with root package name */
    private final float f14095f;

    /* renamed from: g  reason: collision with root package name */
    private final float f14096g;

    public static final class a extends q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SendFlowerButtonContainerView f14097a;

        a(SendFlowerButtonContainerView sendFlowerButtonContainerView) {
            this.f14097a = sendFlowerButtonContainerView;
        }

        public void onAnimationEnd(Animator animator) {
            j.g(animator, "animation");
            this.f14097a.f14091b = false;
            this.f14097a.f14090a = true;
            this.f14097a.f14093d = null;
            this.f14097a.setVisibility(8);
        }
    }

    public static final class b extends q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SendFlowerButtonContainerView f14098a;

        b(SendFlowerButtonContainerView sendFlowerButtonContainerView) {
            this.f14098a = sendFlowerButtonContainerView;
        }

        public void onAnimationEnd(Animator animator) {
            j.g(animator, "animation");
            this.f14098a.f14092c = false;
            this.f14098a.f14090a = false;
            this.f14098a.f14093d = null;
            this.f14098a.setVisibility(0);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SendFlowerButtonContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        j.g(context, IdentityHttpResponse.CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SendFlowerButtonContainerView(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    private final List<Animator> g(float f10, float f11) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "scaleX", new float[]{f10, f11});
        j.f(ofFloat, "ofFloat(this, ViewConsta…_X, startScale, endScale)");
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "scaleY", new float[]{f10, f11});
        j.f(ofFloat2, "ofFloat(this, ViewConsta…_Y, startScale, endScale)");
        arrayList.add(ofFloat2);
        return arrayList;
    }

    private final void h(List<? extends Animator> list, Animator.AnimatorListener animatorListener) {
        AnimatorSet animatorSet = this.f14093d;
        if (animatorSet != null) {
            j.d(animatorSet);
            animatorSet.cancel();
            this.f14093d = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f14093d = animatorSet2;
        j.d(animatorSet2);
        animatorSet2.playTogether(list);
        AnimatorSet animatorSet3 = this.f14093d;
        j.d(animatorSet3);
        animatorSet3.addListener(animatorListener);
        AnimatorSet animatorSet4 = this.f14093d;
        j.d(animatorSet4);
        animatorSet4.setDuration(this.f14094e);
        AnimatorSet animatorSet5 = this.f14093d;
        j.d(animatorSet5);
        animatorSet5.start();
    }

    public void a() {
        a.C0491a aVar = fa.a.f40771d;
        aVar.a("SuggestedActionButton", "show - isHidden? " + this.f14090a + " - isShowAnimationInProgress? " + this.f14092c);
        if (this.f14090a && !this.f14092c) {
            this.f14092c = true;
            List<Animator> g10 = g(this.f14095f, this.f14096g);
            if (g10 != null) {
                h(g10, new b(this));
            }
        }
    }

    public void c() {
        a.C0491a aVar = fa.a.f40771d;
        aVar.a("SuggestedActionButton", "hide - isHidden? " + this.f14090a + " - isShowAnimationInProgress? " + this.f14092c);
        if (!this.f14091b) {
            this.f14091b = true;
            List<Animator> g10 = g(this.f14096g, this.f14095f);
            if (g10 != null) {
                h(g10, new a(this));
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SendFlowerButtonContainerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        j.g(context, IdentityHttpResponse.CONTEXT);
        this.f14090a = true;
        this.f14094e = 200;
        this.f14096g = 1.0f;
    }
}
