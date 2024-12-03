package com.withpersona.sdk2.inquiry.governmentid;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.a;
import coil.ImageLoader;
import coil.request.g;
import com.airbnb.lottie.h;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.ui.ViewBindingViewFactory;
import com.squareup.workflow1.ui.f;
import com.squareup.workflow1.ui.p;
import com.squareup.workflow1.ui.r;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import com.withpersona.sdk2.inquiry.shared.ui.NavigationUiState;
import com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView;
import com.withpersona.sdk2.inquiry.shared.ui.k;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.ButtonCancelComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.ButtonSubmitComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$GovernmentIdStepStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$GovernmentIdStepTextBasedComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$StepTextBasedComponentStyleContainer;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.TextBasedComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.styling.ButtonStylingKt;
import com.withpersona.sdk2.inquiry.steps.ui.styling.m;
import java.io.File;
import ki.e;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;
import ti.b;
import ti.n;
import ti.o;

public final class GovernmentIdReviewRunner implements f<GovernmentIdWorkflow.Screen.a> {

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f25376d = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final e f25377b;

    /* renamed from: c  reason: collision with root package name */
    private final c f25378c = new c();

    public static final class Companion implements r<GovernmentIdWorkflow.Screen.a> {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ r<GovernmentIdWorkflow.Screen.a> f25379a;

        private Companion() {
            f.a aVar = f.f23238a;
            this.f25379a = new ViewBindingViewFactory(l.b(GovernmentIdWorkflow.Screen.a.class), AnonymousClass1.f25380a, AnonymousClass2.f25381a);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: b */
        public View a(GovernmentIdWorkflow.Screen.a aVar, p pVar, Context context, ViewGroup viewGroup) {
            j.g(aVar, "initialRendering");
            j.g(pVar, "initialViewEnvironment");
            j.g(context, "contextForNewView");
            return this.f25379a.a(aVar, pVar, context, viewGroup);
        }

        public wk.c<? super GovernmentIdWorkflow.Screen.a> getType() {
            return this.f25379a.getType();
        }
    }

    public GovernmentIdReviewRunner(e eVar) {
        j.g(eVar, "binding");
        this.f25377b = eVar;
        ThemeableLottieAnimationView themeableLottieAnimationView = eVar.f31982p;
        int parseColor = Color.parseColor("#43957D");
        Context context = eVar.getRoot().getContext();
        j.f(context, "binding.root.context");
        themeableLottieAnimationView.I(parseColor, n.d(context, h0.colorPrimary, (TypedValue) null, false, 6, (Object) null));
    }

    private final Unit h(StepStyles$GovernmentIdStepStyle stepStyles$GovernmentIdStepStyle) {
        int i10;
        float f10;
        int i11;
        StepStyles$StepTextBasedComponentStyleContainer a10;
        TextBasedComponentStyle a11;
        String c10;
        e eVar = this.f25377b;
        TextBasedComponentStyle s10 = stepStyles$GovernmentIdStepStyle.s();
        if (s10 != null) {
            TextView textView = this.f25377b.f31983q;
            j.f(textView, "binding.overlayText");
            m.e(textView, s10);
        }
        String x10 = stepStyles$GovernmentIdStepStyle.x();
        if (x10 != null) {
            i10 = Color.parseColor(x10);
        } else {
            i10 = -1;
        }
        StepStyles$GovernmentIdStepTextBasedComponentStyle O = stepStyles$GovernmentIdStepStyle.O();
        if (!(O == null || (a10 = O.a()) == null || (a11 = a10.a()) == null || (c10 = a11.c()) == null)) {
            TextView textView2 = this.f25377b.f31973e;
            j.f(textView2, "binding.disclaimer");
            m.d(textView2, c10);
        }
        Double z10 = stepStyles$GovernmentIdStepStyle.z();
        if (z10 != null) {
            f10 = (float) b.a(z10.doubleValue());
        } else {
            f10 = 0.0f;
        }
        Double A = stepStyles$GovernmentIdStepStyle.A();
        if (A != null) {
            i11 = (int) Math.ceil(b.a(A.doubleValue()));
        } else {
            i11 = 0;
        }
        eVar.f31986x.setRadius(((float) i11) + f10);
        View view = eVar.f31979l;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(f10);
        gradientDrawable.setStroke(i11, i10);
        view.setBackground(gradientDrawable);
        ConstraintLayout constraintLayout = eVar.f31981n;
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        int a12 = i11 + ((int) b.a(12.0d));
        gradientDrawable2.setStroke(a12, 0);
        gradientDrawable2.setColor(-1);
        float f11 = f10 - ((float) (a12 / 2));
        gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, f11, f11, f11, f11});
        constraintLayout.setBackground(gradientDrawable2);
        ButtonSubmitComponentStyle M = stepStyles$GovernmentIdStepStyle.M();
        if (M != null) {
            Button button = eVar.f31970b;
            j.f(button, "acceptButton");
            ButtonStylingKt.c(button, M, false, false, 6, (Object) null);
        }
        ButtonCancelComponentStyle K = stepStyles$GovernmentIdStepStyle.K();
        if (K != null) {
            Button button2 = eVar.f31984t;
            j.f(button2, "retryButton");
            ButtonStylingKt.c(button2, K, false, false, 6, (Object) null);
        }
        String k10 = stepStyles$GovernmentIdStepStyle.k();
        if (k10 != null) {
            this.f25377b.f31982p.I(Color.parseColor("#000000"), Color.parseColor(k10));
        }
        String j10 = stepStyles$GovernmentIdStepStyle.j();
        if (j10 == null) {
            return null;
        }
        this.f25377b.f31982p.I(Color.parseColor("#43957D"), Color.parseColor(j10));
        return Unit.f32013a;
    }

    /* access modifiers changed from: private */
    public final void i() {
        e eVar = this.f25377b;
        if (eVar.f31970b.getTop() < eVar.f31975g.getBottom() + eVar.getRoot().getContext().getResources().getDimensionPixelOffset(j0.pi2_governmentid_buttons_min_margin)) {
            this.f25378c.e(eVar.getRoot().getContext(), m0.pi2_governmentid_review_low_space);
            x1.p.a(this.f25377b.getRoot(), new x1.b());
            this.f25378c.c(this.f25377b.f31972d);
        }
    }

    /* access modifiers changed from: private */
    public static final void k(e eVar) {
        j.g(eVar, "$this_with");
        ObjectAnimator duration = ObjectAnimator.ofFloat(eVar.f31976h, "alpha", new float[]{0.9f, 0.0f}).setDuration(500);
        duration.setInterpolator(new LinearInterpolator());
        duration.start();
        eVar.getRoot().setHapticFeedbackEnabled(true);
        eVar.getRoot().performHapticFeedback(1, 2);
    }

    /* access modifiers changed from: private */
    public static final void l(e eVar, h hVar) {
        j.g(eVar, "$this_with");
        eVar.f31982p.setProgress(1.0f);
    }

    /* access modifiers changed from: private */
    public static final void m(GovernmentIdWorkflow.Screen.a aVar, View view) {
        j.g(aVar, "$rendering");
        aVar.a().invoke();
    }

    /* access modifiers changed from: private */
    public static final void n(GovernmentIdWorkflow.Screen.a aVar, View view) {
        j.g(aVar, "$rendering");
        aVar.m().invoke();
    }

    /* renamed from: j */
    public void a(GovernmentIdWorkflow.Screen.a aVar, p pVar) {
        int i10;
        j.g(aVar, "rendering");
        j.g(pVar, "viewEnvironment");
        e eVar = this.f25377b;
        if (!eVar.f31971c.isChecked()) {
            eVar.f31971c.setChecked(true);
            eVar.getRoot().post(new w(eVar));
        } else {
            eVar.f31982p.j(new x(eVar));
        }
        ImageView imageView = eVar.f31985w;
        j.f(imageView, "reviewImage");
        File file = new File(aVar.i());
        ImageLoader h10 = aVar.h();
        g.a p10 = new g.a(imageView.getContext()).d(file).p(imageView);
        p10.m(2000, 2000);
        h10.a(p10.a());
        eVar.f31983q.setText(aVar.j());
        ImageView imageView2 = eVar.f31974f;
        int i11 = 8;
        if (r.w(aVar.g())) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        imageView2.setVisibility(i10);
        TextView textView = eVar.f31973e;
        if (!r.w(aVar.g())) {
            i11 = 0;
        }
        textView.setVisibility(i11);
        eVar.f31973e.setText(aVar.g());
        eVar.f31970b.setText(aVar.c());
        eVar.f31984t.setText(aVar.n());
        Context context = eVar.getRoot().getContext();
        View view = eVar.f31979l;
        j.f(context, IdentityHttpResponse.CONTEXT);
        view.setBackground(e0.a(context, h0.personaIdFrameReviewStyle));
        if (n.b(context, h0.personaIdFrameCenterText, (TypedValue) null, false, 6, (Object) null)) {
            eVar.f31983q.setGravity(17);
            TextView textView2 = eVar.f31983q;
            j.f(textView2, "overlayText");
            ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
            if (layoutParams != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMarginStart(0);
                textView2.setLayoutParams(marginLayoutParams);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
        }
        Integer f10 = n.f(context, h0.personaLockImage, (TypedValue) null, false, 6, (Object) null);
        if (f10 != null) {
            eVar.f31974f.setImageResource(f10.intValue());
        }
        f0 b10 = e0.b(context, aVar.l());
        eVar.f31982p.setAnimation(b10.b());
        eVar.f31980m.setImageResource(b10.a());
        eVar.f31978k.setState(new NavigationUiState(aVar.d(), new GovernmentIdReviewRunner$showRendering$1$5(aVar), aVar.e(), new GovernmentIdReviewRunner$showRendering$1$6(aVar)));
        eVar.f31970b.setOnClickListener(new y(aVar));
        eVar.f31984t.setOnClickListener(new z(aVar));
        StepStyles$GovernmentIdStepStyle o10 = aVar.o();
        if (o10 != null) {
            h(o10);
            int color = a.getColor(this.f25377b.getRoot().getContext(), i0.blackScreenStatusBarColor);
            Context context2 = this.f25377b.getRoot().getContext();
            j.f(context2, "binding.root.context");
            ti.a.f(context2, color);
        }
        Button button = eVar.f31970b;
        j.f(button, "acceptButton");
        k.b(button, new GovernmentIdReviewRunner$showRendering$1$10(eVar, this));
        CoordinatorLayout b11 = this.f25377b.getRoot();
        j.f(b11, "binding.root");
        o.b(b11, aVar.getError(), aVar.k(), (View) null, 0, 0, 56, (Object) null);
    }
}
