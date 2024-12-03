package com.withpersona.sdk2.inquiry.governmentid.capture_tips;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView;
import com.withpersona.sdk2.inquiry.shared.ui.k;
import com.withpersona.sdk2.inquiry.steps.ui.components.TextsKt;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.ButtonSubmitComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$GovernmentIdStepPrimaryButtonComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$GovernmentIdStepStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$GovernmentIdStepTextBasedComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$GovernmentIdStepTitleComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$StepSubmitButtonComponentStyleContainer;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$StepTextBasedComponentStyleContainer;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.TextBasedComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.styling.BottomSheetStylingKt;
import com.withpersona.sdk2.inquiry.steps.ui.styling.ButtonStylingKt;
import com.withpersona.sdk2.inquiry.steps.ui.styling.ImageStylingKt;
import com.withpersona.sdk2.inquiry.steps.ui.styling.m;
import gk.f;
import ki.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

public final class CaptureTipsBottomSheetController {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final ViewGroup f25752a;

    /* renamed from: b  reason: collision with root package name */
    private final f f25753b = b.b(new CaptureTipsBottomSheetController$binding$2(this));

    /* renamed from: c  reason: collision with root package name */
    private boolean f25754c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Function1<? super Integer, Unit> f25755d;

    public static final class a extends BottomSheetBehavior.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CaptureTipsBottomSheetController f25756a;

        a(CaptureTipsBottomSheetController captureTipsBottomSheetController) {
            this.f25756a = captureTipsBottomSheetController;
        }

        public void b(View view, float f10) {
            j.g(view, "bottomSheet");
            if (f10 <= 0.0f) {
                this.f25756a.g().f31947g.setVisibility(8);
                return;
            }
            this.f25756a.g().f31947g.setVisibility(0);
            this.f25756a.g().f31947g.setAlpha(f10);
        }

        public void c(View view, int i10) {
            j.g(view, "bottomSheet");
            Function1 e10 = this.f25756a.f25755d;
            if (e10 != null) {
                e10.invoke(Integer.valueOf(i10));
            }
        }
    }

    public CaptureTipsBottomSheetController(ViewGroup viewGroup) {
        j.g(viewGroup, "contentView");
        this.f25752a = viewGroup;
    }

    /* access modifiers changed from: private */
    public final b g() {
        return (b) this.f25753b.getValue();
    }

    private final void h() {
        if (!this.f25754c) {
            this.f25754c = true;
            BottomSheetBehavior k02 = BottomSheetBehavior.k0(g().f31942b);
            j.f(k02, "from(binding.bottomSheet)");
            k02.S0(true);
            k02.Y(new a(this));
            g().f31947g.setOnClickListener(new b(k02));
            g().f31943c.setOnClickListener(new c(k02));
        }
    }

    /* access modifiers changed from: private */
    public static final void i(BottomSheetBehavior bottomSheetBehavior, View view) {
        j.g(bottomSheetBehavior, "$behavior");
        bottomSheetBehavior.Q0(4);
    }

    /* access modifiers changed from: private */
    public static final void j(BottomSheetBehavior bottomSheetBehavior, View view) {
        j.g(bottomSheetBehavior, "$behavior");
        bottomSheetBehavior.Q0(4);
    }

    /* access modifiers changed from: private */
    public static final void l(CaptureTipsBottomSheetController captureTipsBottomSheetController, BottomSheetBehavior bottomSheetBehavior) {
        j.g(captureTipsBottomSheetController, "this$0");
        j.g(bottomSheetBehavior, "$behavior");
        FrameLayout b10 = captureTipsBottomSheetController.g().getRoot();
        j.f(b10, "binding.root");
        k.b(b10, new CaptureTipsBottomSheetController$show$5$1(bottomSheetBehavior));
    }

    public final void k(StepStyles$GovernmentIdStepStyle stepStyles$GovernmentIdStepStyle, d dVar) {
        String str;
        StyleElements.DPSizeSet T1;
        Double a10;
        StepStyles$GovernmentIdStepPrimaryButtonComponentStyle h10;
        StepStyles$StepSubmitButtonComponentStyleContainer a11;
        ButtonSubmitComponentStyle a12;
        StepStyles$GovernmentIdStepTextBasedComponentStyle O;
        StepStyles$StepTextBasedComponentStyleContainer a13;
        TextBasedComponentStyle a14;
        StepStyles$GovernmentIdStepTitleComponentStyle P;
        StepStyles$StepTextBasedComponentStyleContainer a15;
        TextBasedComponentStyle a16;
        j.g(dVar, "viewModel");
        h();
        TextView textView = g().f31949j;
        j.f(textView, "binding.title");
        TextsKt.c(textView, dVar.e());
        TextView textView2 = g().f31946f;
        j.f(textView2, "binding.prompt");
        TextsKt.c(textView2, dVar.c());
        TextView textView3 = g().f31948h;
        j.f(textView3, "binding.tips");
        TextsKt.c(textView3, dVar.d());
        g().f31943c.setText(dVar.a());
        BottomSheetBehavior k02 = BottomSheetBehavior.k0(g().f31942b);
        j.f(k02, "from(binding.bottomSheet)");
        if (!(stepStyles$GovernmentIdStepStyle == null || (P = stepStyles$GovernmentIdStepStyle.P()) == null || (a15 = P.a()) == null || (a16 = a15.a()) == null)) {
            TextView textView4 = g().f31949j;
            j.f(textView4, "binding.title");
            m.e(textView4, a16);
        }
        if (!(stepStyles$GovernmentIdStepStyle == null || (O = stepStyles$GovernmentIdStepStyle.O()) == null || (a13 = O.a()) == null || (a14 = a13.a()) == null)) {
            TextView textView5 = g().f31946f;
            j.f(textView5, "binding.prompt");
            m.e(textView5, a14);
            TextView textView6 = g().f31948h;
            j.f(textView6, "binding.tips");
            m.e(textView6, a14);
        }
        if (!(stepStyles$GovernmentIdStepStyle == null || (h10 = stepStyles$GovernmentIdStepStyle.h()) == null || (a11 = h10.a()) == null || (a12 = a11.a()) == null)) {
            Button button = g().f31943c;
            j.f(button, "binding.button");
            ButtonStylingKt.c(button, a12, false, false, 6, (Object) null);
        }
        LinearLayout linearLayout = g().f31942b;
        j.f(linearLayout, "binding.bottomSheet");
        String str2 = null;
        BottomSheetStylingKt.b(linearLayout, stepStyles$GovernmentIdStepStyle, (View) null, 2, (Object) null);
        if (!(stepStyles$GovernmentIdStepStyle == null || (T1 = stepStyles$GovernmentIdStepStyle.T1()) == null)) {
            Button button2 = g().f31943c;
            j.f(button2, "binding.button");
            ViewGroup.LayoutParams layoutParams = button2.getLayoutParams();
            if (layoutParams != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                StyleElements.DPSize e10 = T1.e();
                if (!(e10 == null || (a10 = e10.a()) == null)) {
                    marginLayoutParams.topMargin = (int) ti.b.a(a10.doubleValue());
                }
                button2.setLayoutParams(marginLayoutParams);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
        }
        ThemeableLottieAnimationView themeableLottieAnimationView = g().f31945e;
        j.f(themeableLottieAnimationView, "binding.illustration");
        if (stepStyles$GovernmentIdStepStyle != null) {
            str = stepStyles$GovernmentIdStepStyle.C();
        } else {
            str = null;
        }
        if (stepStyles$GovernmentIdStepStyle != null) {
            str2 = stepStyles$GovernmentIdStepStyle.A0();
        }
        ImageStylingKt.e(themeableLottieAnimationView, str, str2, (String) null, new String[]{"#8652FF"}, new String[]{"#8652FF"}, new String[]{"#8652FF"});
        g().getRoot().post(new a(this, k02));
    }
}
