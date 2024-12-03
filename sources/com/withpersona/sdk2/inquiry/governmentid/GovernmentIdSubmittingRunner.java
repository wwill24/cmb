package com.withpersona.sdk2.inquiry.governmentid;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.h0;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.ui.ViewBindingViewFactory;
import com.squareup.workflow1.ui.f;
import com.squareup.workflow1.ui.p;
import com.squareup.workflow1.ui.r;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView;
import com.withpersona.sdk2.inquiry.shared.ui.k;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.TextBasedComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.styling.m;
import d3.b;
import ki.g;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;
import ti.a;
import ti.n;
import w2.d;
import wk.c;

public final class GovernmentIdSubmittingRunner implements f<GovernmentIdWorkflow.Screen.b> {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f25501c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final g f25502b;

    public static final class Companion implements r<GovernmentIdWorkflow.Screen.b> {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ r<GovernmentIdWorkflow.Screen.b> f25503a;

        private Companion() {
            f.a aVar = f.f23238a;
            this.f25503a = new ViewBindingViewFactory(l.b(GovernmentIdWorkflow.Screen.b.class), AnonymousClass1.f25504a, AnonymousClass2.f25505a);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: b */
        public View a(GovernmentIdWorkflow.Screen.b bVar, p pVar, Context context, ViewGroup viewGroup) {
            j.g(bVar, "initialRendering");
            j.g(pVar, "initialViewEnvironment");
            j.g(context, "contextForNewView");
            return this.f25503a.a(bVar, pVar, context, viewGroup);
        }

        public c<? super GovernmentIdWorkflow.Screen.b> getType() {
            return this.f25503a.getType();
        }
    }

    public GovernmentIdSubmittingRunner(g gVar) {
        j.g(gVar, "binding");
        this.f25502b = gVar;
        Context context = gVar.getRoot().getContext();
        ThemeableLottieAnimationView themeableLottieAnimationView = gVar.f31998b;
        j.f(themeableLottieAnimationView, "binding.animationviewGovernmentidPending");
        j.f(context, IdentityHttpResponse.CONTEXT);
        Integer f10 = n.f(context, h0.personaInquiryLoadingLottieRaw, (TypedValue) null, false, 6, (Object) null);
        if (f10 != null) {
            themeableLottieAnimationView.setAnimation(f10.intValue());
            themeableLottieAnimationView.A();
            return;
        }
        themeableLottieAnimationView.l(new d("scanner", "**"), h0.f8565a, new b0(this, context));
    }

    /* access modifiers changed from: private */
    public static final Integer c(GovernmentIdSubmittingRunner governmentIdSubmittingRunner, Context context, b bVar) {
        j.g(governmentIdSubmittingRunner, "this$0");
        j.f(context, IdentityHttpResponse.CONTEXT);
        return Integer.valueOf(f(governmentIdSubmittingRunner, context, h0.colorPrimary, (TypedValue) null, false, 6, (Object) null));
    }

    private final void d(StepStyle stepStyle) {
        String V1 = stepStyle.V1();
        if (V1 != null) {
            this.f25502b.getRoot().setBackgroundColor(Color.parseColor(V1));
            Context context = this.f25502b.getRoot().getContext();
            j.f(context, "binding.root.context");
            a.f(context, Color.parseColor(V1));
        }
        Context context2 = this.f25502b.getRoot().getContext();
        j.f(context2, "binding.root.context");
        Drawable r12 = stepStyle.r1(context2);
        if (r12 != null) {
            this.f25502b.getRoot().setBackground(r12);
        }
        TextBasedComponentStyle v10 = stepStyle.v();
        if (v10 != null) {
            TextView textView = this.f25502b.f32000d;
            j.f(textView, "binding.textviewGovernmentidPendingTitle");
            m.e(textView, v10);
        }
        TextBasedComponentStyle w12 = stepStyle.w1();
        if (w12 != null) {
            TextView textView2 = this.f25502b.f31999c;
            j.f(textView2, "binding.textviewGovernmentidPendingBody");
            m.e(textView2, w12);
        }
        String A0 = stepStyle.A0();
        if (A0 != null) {
            this.f25502b.f31998b.I(Color.parseColor("#AA85FF"), Color.parseColor(A0));
            this.f25502b.f31998b.I(Color.parseColor("#4600EB"), Color.parseColor(A0));
        }
        String C = stepStyle.C();
        if (C != null) {
            this.f25502b.f31998b.I(Color.parseColor("#190052"), Color.parseColor(C));
        }
        String V12 = stepStyle.V1();
        if (V12 != null) {
            this.f25502b.f31998b.I(Color.parseColor("#FFFFFF"), Color.parseColor(V12));
            this.f25502b.f31998b.I(Color.parseColor("#F1EBFF"), Color.parseColor(V12));
        }
    }

    private final int e(Context context, int i10, TypedValue typedValue, boolean z10) {
        context.getTheme().resolveAttribute(i10, typedValue, z10);
        return typedValue.data;
    }

    static /* synthetic */ int f(GovernmentIdSubmittingRunner governmentIdSubmittingRunner, Context context, int i10, TypedValue typedValue, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            typedValue = new TypedValue();
        }
        if ((i11 & 4) != 0) {
            z10 = true;
        }
        return governmentIdSubmittingRunner.e(context, i10, typedValue, z10);
    }

    /* renamed from: g */
    public void a(GovernmentIdWorkflow.Screen.b bVar, p pVar) {
        j.g(bVar, "rendering");
        j.g(pVar, "viewEnvironment");
        TextView textView = this.f25502b.f32000d;
        j.f(textView, "binding.textviewGovernmentidPendingTitle");
        k.d(textView);
        this.f25502b.f32000d.setText(bVar.e());
        this.f25502b.f31999c.setText(bVar.a());
        StepStyle d10 = bVar.d();
        if (d10 != null) {
            d(d10);
        }
        ConstraintLayout b10 = this.f25502b.getRoot();
        j.f(b10, "binding.root");
        com.squareup.workflow1.ui.b.c(b10, new GovernmentIdSubmittingRunner$showRendering$2(bVar));
    }
}
