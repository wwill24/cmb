package com.withpersona.sdk2.inquiry.selfie.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.h;
import com.mparticle.identity.IdentityHttpResponse;
import com.withpersona.sdk2.inquiry.selfie.k;
import com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$SelfieStepStyle;
import gk.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import si.c;
import ti.n;

public final class SelfieOverlayView extends ConstraintLayout {
    /* access modifiers changed from: private */
    public final c F;
    private final f G;
    private final f H;
    private final int I;
    private final int J;
    private View K;
    private final List<Function0<Unit>> L;
    /* access modifiers changed from: private */
    public final List<Function0<Unit>> M;

    public enum ViewState {
        CLEAR,
        CENTER,
        CENTER_COMPLETE,
        LOOK_LEFT_HINT,
        LOOK_LEFT,
        LOOK_LEFT_COMPLETE,
        LOOK_RIGHT_HINT,
        LOOK_RIGHT,
        LOOK_RIGHT_COMPLETE,
        FINALIZING,
        COMPLETE_WITH_CAPTURE,
        COMPLETE
    }

    public static final class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SelfieOverlayView f27480a;

        a(SelfieOverlayView selfieOverlayView) {
            this.f27480a = selfieOverlayView;
        }

        public void onAnimationEnd(Animator animator) {
            j.g(animator, "animation");
            List<Function0> x02 = CollectionsKt___CollectionsKt.x0(this.f27480a.M);
            this.f27480a.M.clear();
            for (Function0 invoke : x02) {
                invoke.invoke();
            }
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f27481a;

        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|27) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.withpersona.sdk2.inquiry.selfie.view.SelfieOverlayView$ViewState[] r0 = com.withpersona.sdk2.inquiry.selfie.view.SelfieOverlayView.ViewState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.withpersona.sdk2.inquiry.selfie.view.SelfieOverlayView$ViewState r1 = com.withpersona.sdk2.inquiry.selfie.view.SelfieOverlayView.ViewState.CLEAR     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.withpersona.sdk2.inquiry.selfie.view.SelfieOverlayView$ViewState r1 = com.withpersona.sdk2.inquiry.selfie.view.SelfieOverlayView.ViewState.CENTER     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.withpersona.sdk2.inquiry.selfie.view.SelfieOverlayView$ViewState r1 = com.withpersona.sdk2.inquiry.selfie.view.SelfieOverlayView.ViewState.CENTER_COMPLETE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.withpersona.sdk2.inquiry.selfie.view.SelfieOverlayView$ViewState r1 = com.withpersona.sdk2.inquiry.selfie.view.SelfieOverlayView.ViewState.LOOK_LEFT_HINT     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.withpersona.sdk2.inquiry.selfie.view.SelfieOverlayView$ViewState r1 = com.withpersona.sdk2.inquiry.selfie.view.SelfieOverlayView.ViewState.LOOK_LEFT     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.withpersona.sdk2.inquiry.selfie.view.SelfieOverlayView$ViewState r1 = com.withpersona.sdk2.inquiry.selfie.view.SelfieOverlayView.ViewState.LOOK_LEFT_COMPLETE     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.withpersona.sdk2.inquiry.selfie.view.SelfieOverlayView$ViewState r1 = com.withpersona.sdk2.inquiry.selfie.view.SelfieOverlayView.ViewState.LOOK_RIGHT_HINT     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.withpersona.sdk2.inquiry.selfie.view.SelfieOverlayView$ViewState r1 = com.withpersona.sdk2.inquiry.selfie.view.SelfieOverlayView.ViewState.LOOK_RIGHT     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                com.withpersona.sdk2.inquiry.selfie.view.SelfieOverlayView$ViewState r1 = com.withpersona.sdk2.inquiry.selfie.view.SelfieOverlayView.ViewState.LOOK_RIGHT_COMPLETE     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                com.withpersona.sdk2.inquiry.selfie.view.SelfieOverlayView$ViewState r1 = com.withpersona.sdk2.inquiry.selfie.view.SelfieOverlayView.ViewState.FINALIZING     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                com.withpersona.sdk2.inquiry.selfie.view.SelfieOverlayView$ViewState r1 = com.withpersona.sdk2.inquiry.selfie.view.SelfieOverlayView.ViewState.COMPLETE_WITH_CAPTURE     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                com.withpersona.sdk2.inquiry.selfie.view.SelfieOverlayView$ViewState r1 = com.withpersona.sdk2.inquiry.selfie.view.SelfieOverlayView.ViewState.COMPLETE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                f27481a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.selfie.view.SelfieOverlayView.b.<clinit>():void");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SelfieOverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        j.g(context, IdentityHttpResponse.CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SelfieOverlayView(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    private final ViewPropertyAnimator J(View view, long j10) {
        ViewPropertyAnimator withEndAction = view.animate().alpha(0.0f).setDuration(j10).withEndAction(new f(view));
        j.f(withEndAction, "this.animate()\n      .al… = View.INVISIBLE\n      }");
        return withEndAction;
    }

    static /* synthetic */ ViewPropertyAnimator K(SelfieOverlayView selfieOverlayView, View view, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 200;
        }
        return selfieOverlayView.J(view, j10);
    }

    /* access modifiers changed from: private */
    public static final void L(View view) {
        j.g(view, "$this_animateHide");
        view.setVisibility(4);
    }

    private final ViewPropertyAnimator M(View view, long j10) {
        if (view.getVisibility() != 0) {
            view.setAlpha(0.0f);
            view.setVisibility(0);
        }
        ViewPropertyAnimator duration = view.animate().alpha(1.0f).setDuration(j10);
        j.f(duration, "animate()\n      .alpha(1…   .setDuration(duration)");
        return duration;
    }

    static /* synthetic */ ViewPropertyAnimator N(SelfieOverlayView selfieOverlayView, View view, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 200;
        }
        return selfieOverlayView.M(view, j10);
    }

    /* access modifiers changed from: private */
    public static final void R(SelfieOverlayView selfieOverlayView, h hVar) {
        j.g(selfieOverlayView, "this$0");
        List<Function0> x02 = CollectionsKt___CollectionsKt.x0(selfieOverlayView.L);
        selfieOverlayView.L.clear();
        for (Function0 invoke : x02) {
            invoke.invoke();
        }
    }

    private final void S(c cVar, Function0<Unit> function0) {
        View view = cVar.f33829b;
        j.f(view, "blindsView");
        M(view, 80).withEndAction(new e(this, cVar, function0));
    }

    /* access modifiers changed from: private */
    public static final void T(SelfieOverlayView selfieOverlayView, c cVar, Function0 function0) {
        j.g(selfieOverlayView, "this$0");
        j.g(cVar, "$this_playBlinkAnimation");
        View view = cVar.f33829b;
        j.f(view, "blindsView");
        selfieOverlayView.J(view, 80).withEndAction(new g(function0));
    }

    /* access modifiers changed from: private */
    public static final void U(Function0 function0) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    public static /* synthetic */ void W(SelfieOverlayView selfieOverlayView, ViewState viewState, Function0 function0, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            function0 = null;
        }
        selfieOverlayView.V(viewState, function0);
    }

    /* access modifiers changed from: private */
    public final void X(c cVar, int i10, Function0<Unit> function0) {
        this.L.add(new SelfieOverlayView$switchAnimation$1(cVar, this, function0));
        cVar.f33831d.setAnimation(i10);
    }

    private final void Y(ImageView imageView, Drawable drawable) {
        if (!j.b(imageView.getDrawable(), drawable)) {
            if (drawable == null) {
                K(this, imageView, 0, 1, (Object) null).withEndAction(new d(imageView));
                return;
            }
            imageView.setImageDrawable(drawable);
            imageView.setAlpha(0.0f);
            N(this, imageView, 0, 1, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void Z(ImageView imageView) {
        j.g(imageView, "$this_switchImageDrawable");
        imageView.setImageDrawable((Drawable) null);
    }

    private final boolean a0(Context context) {
        Integer f10 = n.f(context, com.withpersona.sdk2.inquiry.selfie.f.personaSelfieLookLeftDrawable, (TypedValue) null, false, 6, (Object) null);
        Integer f11 = n.f(context, com.withpersona.sdk2.inquiry.selfie.f.personaSelfieLookRightDrawable, (TypedValue) null, false, 6, (Object) null);
        if (f10 == null || f11 == null) {
            return true;
        }
        return false;
    }

    private final Drawable getDrawableLeft() {
        return (Drawable) this.G.getValue();
    }

    private final Drawable getDrawableRight() {
        return (Drawable) this.H.getValue();
    }

    public final void O(StepStyles$SelfieStepStyle stepStyles$SelfieStepStyle) {
        j.g(stepStyles$SelfieStepStyle, "styles");
        String p10 = stepStyles$SelfieStepStyle.p();
        if (p10 != null) {
            this.F.f33835h.setStrokeColor(Color.parseColor(p10));
        }
        Double q10 = stepStyles$SelfieStepStyle.q();
        if (q10 != null) {
            this.F.f33835h.setStrokeWidth((float) ti.b.a(q10.doubleValue()));
        }
        String u10 = stepStyles$SelfieStepStyle.u();
        if (u10 != null) {
            this.F.f33831d.I(Color.parseColor("#022050"), Color.parseColor(u10));
            this.F.f33831d.I(Color.parseColor("#280087"), Color.parseColor(u10));
        }
        String t10 = stepStyles$SelfieStepStyle.t();
        if (t10 != null) {
            this.F.f33831d.I(Color.parseColor("#AA85FF"), Color.parseColor(t10));
            this.F.f33831d.I(Color.parseColor("#8552FF"), Color.parseColor(t10));
        }
        String s10 = stepStyles$SelfieStepStyle.s();
        if (s10 != null) {
            this.F.f33831d.I(Color.parseColor("#DBCCFF"), Color.parseColor(s10));
        }
    }

    public final void P(Function0<Unit> function0) {
        j.g(function0, "onComplete");
        CircleMaskView circleMaskView = this.F.f33830c;
        j.f(circleMaskView, "binding.circleMask");
        CircleMaskView.e(circleMaskView, false, function0, 1, (Object) null);
    }

    public final boolean Q() {
        return this.F.f33830c.g();
    }

    public final void V(ViewState viewState, Function0<Unit> function0) {
        j.g(viewState, "viewState");
        Context context = getContext();
        j.f(context, IdentityHttpResponse.CONTEXT);
        boolean a02 = a0(context);
        c cVar = this.F;
        switch (b.f27481a[viewState.ordinal()]) {
            case 1:
                cVar.f33830c.h();
                cVar.f33835h.f(0.0f, function0);
                return;
            case 2:
                CircleMaskView circleMaskView = cVar.f33830c;
                j.f(circleMaskView, "circleMask");
                CircleMaskView.e(circleMaskView, false, (Function0) null, 3, (Object) null);
                cVar.f33835h.f(0.0f, function0);
                return;
            case 3:
                CircleMaskView circleMaskView2 = cVar.f33830c;
                j.f(circleMaskView2, "circleMask");
                CircleMaskView.e(circleMaskView2, false, (Function0) null, 3, (Object) null);
                ProgressArcView progressArcView = cVar.f33835h;
                j.f(progressArcView, "progressArc");
                ProgressArcView.g(progressArcView, 0.0f, (Function0) null, 2, (Object) null);
                S(this.F, function0);
                return;
            case 4:
                CircleMaskView circleMaskView3 = cVar.f33830c;
                j.f(circleMaskView3, "circleMask");
                CircleMaskView.e(circleMaskView3, false, (Function0) null, 3, (Object) null);
                ProgressArcView progressArcView2 = cVar.f33835h;
                j.f(progressArcView2, "progressArc");
                ProgressArcView.g(progressArcView2, 0.0f, (Function0) null, 2, (Object) null);
                if (a02) {
                    X(this.F, this.I, function0);
                    return;
                } else if (function0 != null) {
                    function0.invoke();
                    return;
                } else {
                    return;
                }
            case 5:
                CircleMaskView circleMaskView4 = cVar.f33830c;
                j.f(circleMaskView4, "circleMask");
                CircleMaskView.e(circleMaskView4, false, (Function0) null, 3, (Object) null);
                cVar.f33835h.f(0.0f, function0);
                if (!a02) {
                    cVar.f33834g.setVisibility(0);
                    ImageView imageView = cVar.f33832e;
                    j.f(imageView, "hintImage");
                    Y(imageView, getDrawableLeft());
                    return;
                }
                return;
            case 6:
                CircleMaskView circleMaskView5 = cVar.f33830c;
                j.f(circleMaskView5, "circleMask");
                CircleMaskView.e(circleMaskView5, false, (Function0) null, 3, (Object) null);
                ProgressArcView progressArcView3 = cVar.f33835h;
                j.f(progressArcView3, "progressArc");
                ProgressArcView.g(progressArcView3, 50.0f, (Function0) null, 2, (Object) null);
                S(this.F, function0);
                return;
            case 7:
                CircleMaskView circleMaskView6 = cVar.f33830c;
                j.f(circleMaskView6, "circleMask");
                CircleMaskView.e(circleMaskView6, false, (Function0) null, 3, (Object) null);
                ProgressArcView progressArcView4 = cVar.f33835h;
                j.f(progressArcView4, "progressArc");
                ProgressArcView.g(progressArcView4, 50.0f, (Function0) null, 2, (Object) null);
                if (a02) {
                    X(this.F, this.J, function0);
                    return;
                } else if (function0 != null) {
                    function0.invoke();
                    return;
                } else {
                    return;
                }
            case 8:
                CircleMaskView circleMaskView7 = cVar.f33830c;
                j.f(circleMaskView7, "circleMask");
                CircleMaskView.e(circleMaskView7, false, (Function0) null, 3, (Object) null);
                cVar.f33835h.f(50.0f, function0);
                if (!a02) {
                    cVar.f33834g.setVisibility(0);
                    ImageView imageView2 = cVar.f33832e;
                    j.f(imageView2, "hintImage");
                    Y(imageView2, getDrawableRight());
                    return;
                }
                return;
            case 9:
                CircleMaskView circleMaskView8 = cVar.f33830c;
                j.f(circleMaskView8, "circleMask");
                CircleMaskView.e(circleMaskView8, false, (Function0) null, 3, (Object) null);
                ProgressArcView progressArcView5 = cVar.f33835h;
                j.f(progressArcView5, "progressArc");
                ProgressArcView.g(progressArcView5, 100.0f, (Function0) null, 2, (Object) null);
                S(this.F, function0);
                return;
            case 10:
                CircleMaskView circleMaskView9 = cVar.f33830c;
                j.f(circleMaskView9, "circleMask");
                CircleMaskView.e(circleMaskView9, false, (Function0) null, 3, (Object) null);
                cVar.f33835h.e();
                return;
            case 11:
                CircleMaskView circleMaskView10 = cVar.f33830c;
                j.f(circleMaskView10, "circleMask");
                CircleMaskView.e(circleMaskView10, false, (Function0) null, 3, (Object) null);
                ProgressArcView progressArcView6 = cVar.f33835h;
                j.f(progressArcView6, "progressArc");
                ProgressArcView.g(progressArcView6, 100.0f, (Function0) null, 2, (Object) null);
                S(this.F, new SelfieOverlayView$setState$1$1(this, function0));
                return;
            case 12:
                CircleMaskView circleMaskView11 = cVar.f33830c;
                j.f(circleMaskView11, "circleMask");
                CircleMaskView.e(circleMaskView11, false, (Function0) null, 3, (Object) null);
                cVar.f33835h.f(100.0f, new SelfieOverlayView$setState$1$2(this, function0));
                return;
            default:
                return;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public final void setPreviewView(View view) {
        j.g(view, "previewView");
        this.K = view;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelfieOverlayView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        int i11;
        int i12;
        Context context2 = context;
        j.g(context2, IdentityHttpResponse.CONTEXT);
        c b10 = c.b(LayoutInflater.from(context), this);
        j.f(b10, "inflate(LayoutInflater.from(context), this)");
        this.F = b10;
        this.G = b.b(new SelfieOverlayView$drawableLeft$2(context2));
        this.H = b.b(new SelfieOverlayView$drawableRight$2(context2));
        int i13 = com.withpersona.sdk2.inquiry.selfie.f.personaSelfieLookLeftLottieRaw;
        Integer f10 = n.f(context, i13, (TypedValue) null, false, 6, (Object) null);
        if (f10 != null) {
            i11 = f10.intValue();
        } else {
            i11 = k.pi2_selfie_left_pose;
        }
        this.I = i11;
        Integer f11 = n.f(context, i13, (TypedValue) null, false, 6, (Object) null);
        if (f11 != null) {
            i12 = f11.intValue();
        } else {
            i12 = k.pi2_selfie_right_pose;
        }
        this.J = i12;
        this.L = new ArrayList();
        this.M = new ArrayList();
        ThemeableLottieAnimationView themeableLottieAnimationView = b10.f33831d;
        themeableLottieAnimationView.j(new c(this));
        themeableLottieAnimationView.i(new a(this));
        int parseColor = Color.parseColor("#022050");
        Context context3 = b10.getRoot().getContext();
        j.f(context3, "binding.root.context");
        int i14 = com.withpersona.sdk2.inquiry.selfie.f.colorPrimaryVariant;
        themeableLottieAnimationView.I(parseColor, n.d(context3, i14, (TypedValue) null, false, 6, (Object) null));
        int parseColor2 = Color.parseColor("#AA85FF");
        Context context4 = b10.getRoot().getContext();
        j.f(context4, "binding.root.context");
        int i15 = com.withpersona.sdk2.inquiry.selfie.f.colorSecondary;
        themeableLottieAnimationView.I(parseColor2, n.d(context4, i15, (TypedValue) null, false, 6, (Object) null));
        int parseColor3 = Color.parseColor("#280087");
        Context context5 = b10.getRoot().getContext();
        j.f(context5, "binding.root.context");
        themeableLottieAnimationView.I(parseColor3, n.d(context5, i14, (TypedValue) null, false, 6, (Object) null));
        int parseColor4 = Color.parseColor("#8552FF");
        Context context6 = b10.getRoot().getContext();
        j.f(context6, "binding.root.context");
        int i16 = i15;
        themeableLottieAnimationView.I(parseColor4, n.d(context6, i16, (TypedValue) null, false, 6, (Object) null));
        Context context7 = b10.getRoot().getContext();
        j.f(context7, "binding.root.context");
        int d10 = n.d(context7, i16, (TypedValue) null, false, 6, (Object) null);
        Context context8 = b10.getRoot().getContext();
        j.f(context8, "binding.root.context");
        themeableLottieAnimationView.I(Color.parseColor("#DBCCFF"), androidx.core.graphics.a.c(d10, n.d(context8, com.withpersona.sdk2.inquiry.selfie.f.colorSurface, (TypedValue) null, false, 6, (Object) null), 0.66f));
    }
}
