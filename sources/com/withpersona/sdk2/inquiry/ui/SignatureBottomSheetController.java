package com.withpersona.sdk2.inquiry.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.withpersona.sdk2.inquiry.shared.ui.k;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.ButtonCancelComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.ButtonSubmitComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$UiStepStyle;
import com.withpersona.sdk2.inquiry.steps.ui.styling.BottomSheetStylingKt;
import com.withpersona.sdk2.inquiry.steps.ui.styling.ButtonStylingKt;
import com.withpersona.sdk2.inquiry.steps.ui.styling.m;
import ej.c;
import gk.f;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import ti.b;

public final class SignatureBottomSheetController {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final ViewGroup f29303a;

    /* renamed from: b  reason: collision with root package name */
    private final f<c> f29304b = b.b(new SignatureBottomSheetController$lazyBinding$1(this));

    /* renamed from: c  reason: collision with root package name */
    private boolean f29305c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Function2<? super Boolean, ? super Bitmap, Unit> f29306d;

    public static final class a extends BottomSheetBehavior.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SignatureBottomSheetController f29307a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior<ConstraintLayout> f29308b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f29309c;

        a(SignatureBottomSheetController signatureBottomSheetController, BottomSheetBehavior<ConstraintLayout> bottomSheetBehavior, int i10) {
            this.f29307a = signatureBottomSheetController;
            this.f29308b = bottomSheetBehavior;
            this.f29309c = i10;
        }

        public void b(View view, float f10) {
            j.g(view, "bottomSheet");
            if (f10 <= 0.0f) {
                this.f29307a.l().f29605f.setVisibility(8);
                Context context = this.f29307a.l().getRoot().getContext();
                j.f(context, "binding.root.context");
                ti.a.f(context, this.f29309c);
                return;
            }
            this.f29307a.l().f29605f.setVisibility(0);
            this.f29307a.l().f29605f.setAlpha(f10);
            int color = androidx.core.content.a.getColor(this.f29307a.l().getRoot().getContext(), g.blackScreenStatusBarColor);
            Context context2 = this.f29307a.l().getRoot().getContext();
            j.f(context2, "binding.root.context");
            ti.a.f(context2, color);
        }

        public void c(View view, int i10) {
            j.g(view, "bottomSheet");
            if (i10 == 1) {
                this.f29308b.Q0(3);
            } else if (i10 == 4) {
                Function2 h10 = this.f29307a.f29306d;
                if (h10 != null) {
                    h10.invoke(Boolean.TRUE, null);
                }
                this.f29307a.f29306d = null;
                this.f29307a.l().f29606g.j();
            }
        }
    }

    public SignatureBottomSheetController(ViewGroup viewGroup) {
        j.g(viewGroup, "contentView");
        this.f29303a = viewGroup;
    }

    /* access modifiers changed from: private */
    public final void j(UiComponent.ESignatureComponentStyle eSignatureComponentStyle) {
        TextView textView = l().f29608j;
        j.f(textView, "binding.signatureLabel");
        m.e(textView, eSignatureComponentStyle.m().M());
        TextView textView2 = l().f29607h;
        j.f(textView2, "binding.signatureDescription");
        m.e(textView2, eSignatureComponentStyle.m().U());
        String c10 = eSignatureComponentStyle.m().c();
        if (c10 != null) {
            l().f29606g.setCardBackgroundColor(Color.parseColor(c10));
        }
        Double j10 = eSignatureComponentStyle.m().j();
        if (j10 != null) {
            l().f29606g.setRadius((float) Math.ceil(b.a(j10.doubleValue())));
        }
        Double l10 = eSignatureComponentStyle.m().l();
        if (l10 != null) {
            l().f29606g.setStrokeWidth((int) Math.ceil(b.a(l10.doubleValue())));
        }
        String d10 = eSignatureComponentStyle.m().d();
        if (d10 != null) {
            l().f29606g.setStrokeColor(Color.parseColor(d10));
        }
        ButtonSubmitComponentStyle u10 = eSignatureComponentStyle.u();
        if (u10 != null) {
            Button button = l().f29604e;
            j.f(button, "binding.saveButton");
            ButtonStylingKt.c(button, u10, false, false, 6, (Object) null);
        }
        ButtonCancelComponentStyle h10 = eSignatureComponentStyle.h();
        if (h10 != null) {
            Button button2 = l().f29601b;
            j.f(button2, "binding.clearButton");
            ButtonStylingKt.c(button2, h10, false, false, 6, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final c l() {
        return this.f29304b.getValue();
    }

    private final void m(StepStyles$UiStepStyle stepStyles$UiStepStyle) {
        String str;
        int i10;
        if (!this.f29305c) {
            this.f29305c = true;
            if (stepStyles$UiStepStyle != null) {
                str = stepStyles$UiStepStyle.V1();
            } else {
                str = null;
            }
            if (str != null) {
                i10 = Color.parseColor(stepStyles$UiStepStyle.V1());
            } else {
                i10 = -1;
            }
            BottomSheetBehavior k02 = BottomSheetBehavior.k0(l().f29609k);
            j.f(k02, "from(binding.signatureSheet)");
            k02.S0(true);
            k02.Y(new a(this, k02, i10));
            l().f29602c.setOnClickListener(new k(k02));
            l().f29605f.setOnClickListener(new l(k02));
            l().f29601b.setOnClickListener(new m(this));
            l().f29604e.setOnClickListener(new n(this, k02));
            ConstraintLayout constraintLayout = l().f29609k;
            j.f(constraintLayout, "binding.signatureSheet");
            BottomSheetStylingKt.b(constraintLayout, stepStyles$UiStepStyle, (View) null, 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void n(BottomSheetBehavior bottomSheetBehavior, View view) {
        j.g(bottomSheetBehavior, "$behavior");
        bottomSheetBehavior.Q0(4);
    }

    /* access modifiers changed from: private */
    public static final void o(BottomSheetBehavior bottomSheetBehavior, View view) {
        j.g(bottomSheetBehavior, "$behavior");
        bottomSheetBehavior.Q0(4);
    }

    /* access modifiers changed from: private */
    public static final void p(SignatureBottomSheetController signatureBottomSheetController, View view) {
        j.g(signatureBottomSheetController, "this$0");
        signatureBottomSheetController.l().f29606g.j();
    }

    /* access modifiers changed from: private */
    public static final void q(SignatureBottomSheetController signatureBottomSheetController, BottomSheetBehavior bottomSheetBehavior, View view) {
        j.g(signatureBottomSheetController, "this$0");
        j.g(bottomSheetBehavior, "$behavior");
        Function2<? super Boolean, ? super Bitmap, Unit> function2 = signatureBottomSheetController.f29306d;
        if (function2 != null) {
            function2.invoke(Boolean.FALSE, signatureBottomSheetController.l().f29606g.m());
        }
        signatureBottomSheetController.f29306d = null;
        bottomSheetBehavior.Q0(4);
    }

    public final boolean k() {
        if (!this.f29304b.isInitialized()) {
            return false;
        }
        BottomSheetBehavior k02 = BottomSheetBehavior.k0(l().f29609k);
        j.f(k02, "from(binding.signatureSheet)");
        if (k02.p0() == 4) {
            return false;
        }
        k02.Q0(4);
        return true;
    }

    public final void r(UiComponent.ESignature eSignature, StepStyles$UiStepStyle stepStyles$UiStepStyle, Function2<? super Boolean, ? super Bitmap, Unit> function2) {
        String str;
        String str2;
        j.g(eSignature, "component");
        j.g(function2, "onComplete");
        m(stepStyles$UiStepStyle);
        this.f29306d = function2;
        l().f29606g.j();
        TextView textView = l().f29608j;
        UiComponent.ESignature.Attributes E = eSignature.z();
        if (E != null) {
            str = E.h();
        } else {
            str = null;
        }
        textView.setText(str);
        TextView textView2 = l().f29607h;
        UiComponent.ESignature.Attributes E2 = eSignature.z();
        if (E2 == null || (str2 = E2.i()) == null) {
            str2 = "";
        }
        textView2.setText(str2);
        FrameLayout b10 = l().getRoot();
        j.f(b10, "binding.root");
        k.b(b10, new SignatureBottomSheetController$show$1(this, eSignature));
    }
}
