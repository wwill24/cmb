package com.withpersona.sdk2.inquiry.selfie;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.h0;
import com.squareup.workflow1.ui.ViewBindingViewFactory;
import com.squareup.workflow1.ui.f;
import com.squareup.workflow1.ui.p;
import com.squareup.workflow1.ui.r;
import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import com.withpersona.sdk2.inquiry.shared.ui.k;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.TextBasedComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.styling.m;
import d3.b;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;
import si.d;
import ti.a;
import ti.n;
import wk.c;

public final class SelfieSubmittingRunner implements f<SelfieWorkflow.Screen.b> {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f27269c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final d f27270b;

    public static final class Companion implements r<SelfieWorkflow.Screen.b> {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ r<SelfieWorkflow.Screen.b> f27271a;

        private Companion() {
            f.a aVar = f.f23238a;
            this.f27271a = new ViewBindingViewFactory(l.b(SelfieWorkflow.Screen.b.class), AnonymousClass1.f27272a, AnonymousClass2.f27273a);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: b */
        public View a(SelfieWorkflow.Screen.b bVar, p pVar, Context context, ViewGroup viewGroup) {
            j.g(bVar, "initialRendering");
            j.g(pVar, "initialViewEnvironment");
            j.g(context, "contextForNewView");
            return this.f27271a.a(bVar, pVar, context, viewGroup);
        }

        public c<? super SelfieWorkflow.Screen.b> getType() {
            return this.f27271a.getType();
        }
    }

    public SelfieSubmittingRunner(d dVar) {
        j.g(dVar, "binding");
        this.f27270b = dVar;
        Context context = dVar.getRoot().getContext();
        j.f(context, "root.context");
        Integer f10 = n.f(context, f.personaInquiryLoadingLottieRaw, (TypedValue) null, false, 6, (Object) null);
        if (f10 != null) {
            dVar.f33837b.setAnimation(f10.intValue());
            dVar.f33837b.z();
            return;
        }
        dVar.f33837b.l(new w2.d("scanner", "**"), h0.f8565a, new u(this));
    }

    private final void c(StepStyle stepStyle) {
        String V1 = stepStyle.V1();
        if (V1 != null) {
            this.f27270b.getRoot().setBackgroundColor(Color.parseColor(V1));
            Context context = this.f27270b.getRoot().getContext();
            j.f(context, "binding.root.context");
            a.f(context, Color.parseColor(V1));
        }
        Context context2 = this.f27270b.getRoot().getContext();
        j.f(context2, "binding.root.context");
        Drawable r12 = stepStyle.r1(context2);
        if (r12 != null) {
            this.f27270b.getRoot().setBackground(r12);
        }
        TextBasedComponentStyle v10 = stepStyle.v();
        if (v10 != null) {
            TextView textView = this.f27270b.f33839d;
            j.f(textView, "binding.textviewSelfieSubmittingTitle");
            m.e(textView, v10);
        }
        TextBasedComponentStyle w12 = stepStyle.w1();
        if (w12 != null) {
            TextView textView2 = this.f27270b.f33838c;
            j.f(textView2, "binding.textviewSelfieSubmittingBody");
            m.e(textView2, w12);
        }
        String A0 = stepStyle.A0();
        if (A0 != null) {
            this.f27270b.f33837b.I(Color.parseColor("#AA85FF"), Color.parseColor(A0));
            this.f27270b.f33837b.I(Color.parseColor("#4600EB"), Color.parseColor(A0));
        }
        String C = stepStyle.C();
        if (C != null) {
            this.f27270b.f33837b.I(Color.parseColor("#190052"), Color.parseColor(C));
        }
        String V12 = stepStyle.V1();
        if (V12 != null) {
            this.f27270b.f33837b.I(Color.parseColor("#FFFFFF"), Color.parseColor(V12));
            this.f27270b.f33837b.I(Color.parseColor("#F1EBFF"), Color.parseColor(V12));
        }
    }

    /* access modifiers changed from: private */
    public static final Integer d(SelfieSubmittingRunner selfieSubmittingRunner, b bVar) {
        j.g(selfieSubmittingRunner, "this$0");
        Context context = selfieSubmittingRunner.f27270b.getRoot().getContext();
        j.f(context, "binding.root.context");
        return Integer.valueOf(n.d(context, f.colorPrimary, (TypedValue) null, false, 6, (Object) null));
    }

    /* renamed from: e */
    public void a(SelfieWorkflow.Screen.b bVar, p pVar) {
        j.g(bVar, "rendering");
        j.g(pVar, "viewEnvironment");
        d dVar = this.f27270b;
        TextView textView = dVar.f33839d;
        j.f(textView, "textviewSelfieSubmittingTitle");
        k.d(textView);
        dVar.f33839d.setText(bVar.d());
        dVar.f33838c.setText(bVar.a());
        StepStyle c10 = bVar.c();
        if (c10 != null) {
            c(c10);
        }
        ConstraintLayout b10 = dVar.getRoot();
        j.f(b10, "root");
        com.squareup.workflow1.ui.b.c(b10, new SelfieSubmittingRunner$showRendering$1$2(bVar));
    }
}
