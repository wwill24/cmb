package com.withpersona.sdk2.inquiry.selfie;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.squareup.workflow1.ui.ViewBindingViewFactory;
import com.squareup.workflow1.ui.f;
import com.squareup.workflow1.ui.p;
import com.squareup.workflow1.ui.r;
import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import com.withpersona.sdk2.inquiry.shared.ui.NavigationUiState;
import com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.ButtonSubmitComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$SelfieStepStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.TextBasedComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.styling.ButtonStylingKt;
import com.withpersona.sdk2.inquiry.steps.ui.styling.ImageStylingKt;
import com.withpersona.sdk2.inquiry.steps.ui.styling.m;
import ij.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;
import si.b;
import ti.a;
import ti.n;
import wk.c;

public final class SelfieInstructionsRunner implements f<SelfieWorkflow.Screen.a> {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f27230c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final b f27231b;

    public static final class Companion implements r<SelfieWorkflow.Screen.a> {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ r<SelfieWorkflow.Screen.a> f27232a;

        private Companion() {
            f.a aVar = f.f23238a;
            this.f27232a = new ViewBindingViewFactory(l.b(SelfieWorkflow.Screen.a.class), AnonymousClass1.f27233a, AnonymousClass2.f27234a);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: b */
        public View a(SelfieWorkflow.Screen.a aVar, p pVar, Context context, ViewGroup viewGroup) {
            j.g(aVar, "initialRendering");
            j.g(pVar, "initialViewEnvironment");
            j.g(context, "contextForNewView");
            return this.f27232a.a(aVar, pVar, context, viewGroup);
        }

        public c<? super SelfieWorkflow.Screen.a> getType() {
            return this.f27232a.getType();
        }
    }

    public SelfieInstructionsRunner(b bVar) {
        j.g(bVar, "binding");
        this.f27231b = bVar;
    }

    private final void c(StepStyles$SelfieStepStyle stepStyles$SelfieStepStyle) {
        TextBasedComponentStyle e12 = stepStyles$SelfieStepStyle.e1();
        if (e12 != null) {
            TextView textView = this.f27231b.f33827l;
            textView.setPadding(textView.getPaddingLeft(), 0, this.f27231b.f33827l.getPaddingRight(), 0);
            TextView textView2 = this.f27231b.f33827l;
            j.f(textView2, "binding.textviewSelfieStartTitle");
            m.e(textView2, e12);
        }
        TextBasedComponentStyle H1 = stepStyles$SelfieStepStyle.H1();
        if (H1 != null) {
            TextView textView3 = this.f27231b.f33826k;
            textView3.setPadding(textView3.getPaddingLeft(), 0, this.f27231b.f33826k.getPaddingRight(), 0);
            TextView textView4 = this.f27231b.f33826k;
            j.f(textView4, "binding.textviewSelfieStartBody");
            m.e(textView4, H1);
        }
        TextBasedComponentStyle j10 = stepStyles$SelfieStepStyle.j();
        if (j10 != null) {
            TextView textView5 = this.f27231b.f33825j;
            textView5.setPadding(textView5.getPaddingLeft(), 0, this.f27231b.f33825j.getPaddingRight(), 0);
            TextView textView6 = this.f27231b.f33825j;
            j.f(textView6, "binding.textviewSelfieDisclosure");
            m.e(textView6, j10);
        }
        String V1 = stepStyles$SelfieStepStyle.V1();
        if (V1 != null) {
            this.f27231b.getRoot().setBackgroundColor(Color.parseColor(V1));
            Context context = this.f27231b.getRoot().getContext();
            j.f(context, "binding.root.context");
            a.f(context, Color.parseColor(V1));
        }
        Context context2 = this.f27231b.getRoot().getContext();
        j.f(context2, "binding.root.context");
        Drawable r12 = stepStyles$SelfieStepStyle.r1(context2);
        if (r12 != null) {
            this.f27231b.getRoot().setBackground(r12);
        }
        String m10 = stepStyles$SelfieStepStyle.m();
        if (m10 != null) {
            this.f27231b.f33822f.setControlsColor(Color.parseColor(m10));
        }
        ButtonSubmitComponentStyle X1 = stepStyles$SelfieStepStyle.X1();
        if (X1 != null) {
            Button button = this.f27231b.f33824h;
            j.f(button, "binding.startButton");
            ButtonStylingKt.c(button, X1, false, false, 6, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void e(SelfieWorkflow.Screen.a aVar, View view) {
        j.g(aVar, "$rendering");
        aVar.f().invoke();
    }

    private final void f(StepStyles$SelfieStepStyle stepStyles$SelfieStepStyle) {
        if (stepStyles$SelfieStepStyle != null) {
            ThemeableLottieAnimationView themeableLottieAnimationView = this.f27231b.f33820d;
            j.f(themeableLottieAnimationView, "binding.instructionAnimation");
            ImageStylingKt.b(themeableLottieAnimationView, stepStyles$SelfieStepStyle.w(), new String[]{"#022050"}, new String[]{"#AA85FF"}, new String[]{"#DBCCFF"});
            return;
        }
        ThemeableLottieAnimationView themeableLottieAnimationView2 = this.f27231b.f33820d;
        int parseColor = Color.parseColor("#022050");
        Context context = this.f27231b.getRoot().getContext();
        j.f(context, "binding.root.context");
        themeableLottieAnimationView2.I(parseColor, n.d(context, f.colorPrimaryVariant, (TypedValue) null, false, 6, (Object) null));
        ThemeableLottieAnimationView themeableLottieAnimationView3 = this.f27231b.f33820d;
        int parseColor2 = Color.parseColor("#AA85FF");
        Context context2 = this.f27231b.getRoot().getContext();
        j.f(context2, "binding.root.context");
        int i10 = f.colorSecondary;
        themeableLottieAnimationView3.I(parseColor2, n.d(context2, i10, (TypedValue) null, false, 6, (Object) null));
        Context context3 = this.f27231b.getRoot().getContext();
        j.f(context3, "binding.root.context");
        int d10 = n.d(context3, i10, (TypedValue) null, false, 6, (Object) null);
        Context context4 = this.f27231b.getRoot().getContext();
        j.f(context4, "binding.root.context");
        this.f27231b.f33820d.I(Color.parseColor("#DBCCFF"), androidx.core.graphics.a.c(d10, n.d(context4, f.colorSurface, (TypedValue) null, false, 6, (Object) null), 0.66f));
    }

    /* renamed from: d */
    public void a(SelfieWorkflow.Screen.a aVar, p pVar) {
        j.g(aVar, "rendering");
        j.g(pVar, "viewEnvironment");
        b bVar = this.f27231b;
        Context context = bVar.getRoot().getContext();
        j.f(context, "binding.root.context");
        Integer f10 = n.f(context, f.personaStartSelfieHeaderImage, (TypedValue) null, false, 6, (Object) null);
        if (f10 != null) {
            this.f27231b.f33819c.setImageResource(f10.intValue());
            this.f27231b.f33819c.setVisibility(0);
        }
        bVar.f33827l.setText(aVar.j());
        bVar.f33826k.setText(aVar.g());
        e.b(bVar.f33825j.getContext()).c(bVar.f33825j, aVar.c());
        bVar.f33824h.setText(aVar.h());
        bVar.f33824h.setOnClickListener(new p(aVar));
        bVar.f33822f.setState(new NavigationUiState(aVar.a(), new SelfieInstructionsRunner$showRendering$1$2(aVar), aVar.b(), new SelfieInstructionsRunner$showRendering$1$3(aVar)));
        Context context2 = this.f27231b.getRoot().getContext();
        j.f(context2, "binding.root.context");
        Integer f11 = n.f(context2, f.personaInquirySelfieLottieRaw, (TypedValue) null, false, 6, (Object) null);
        if (f11 != null) {
            bVar.f33820d.setAnimation(f11.intValue());
            bVar.f33820d.A();
        } else {
            f(aVar.i());
        }
        if (aVar.i() != null) {
            c(aVar.i());
        }
    }
}
