package com.withpersona.sdk2.inquiry.modal;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.squareup.workflow1.ui.ViewBindingViewFactory;
import com.squareup.workflow1.ui.f;
import com.squareup.workflow1.ui.r;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.ButtonCancelComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.ButtonSubmitComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.TextBasedComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.styling.BottomSheetStylingKt;
import com.withpersona.sdk2.inquiry.steps.ui.styling.ButtonStylingKt;
import com.withpersona.sdk2.inquiry.steps.ui.styling.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;

public final class CancelScreen implements com.squareup.workflow1.ui.a<CancelScreen> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final StepStyle f26975a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Function0<Unit> f26976b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Function0<Unit> f26977c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final String f26978d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final String f26979e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final String f26980f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final String f26981g;

    /* renamed from: h  reason: collision with root package name */
    private final r<CancelScreen> f26982h = new ViewBindingViewFactory(l.b(CancelScreen.class), CancelScreen$viewFactory$1.f26993a, new CancelScreen$special$$inlined$bind$1(this));

    public static final class a extends BottomSheetBehavior.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CancelScreen f26985a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ oi.a f26986b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f26987c;

        a(CancelScreen cancelScreen, oi.a aVar, int i10) {
            this.f26985a = cancelScreen;
            this.f26986b = aVar;
            this.f26987c = i10;
        }

        public void b(View view, float f10) {
            j.g(view, "bottomSheet");
            if (f10 <= 0.0f) {
                this.f26985a.f26977c.invoke();
                this.f26986b.f32818h.setVisibility(8);
                Context context = this.f26986b.getRoot().getContext();
                j.f(context, "root.context");
                ti.a.f(context, this.f26987c);
                return;
            }
            this.f26986b.f32818h.setVisibility(0);
            this.f26986b.f32818h.setAlpha(f10);
            int color = androidx.core.content.a.getColor(this.f26986b.getRoot().getContext(), com.withpersona.sdk2.inquiry.steps.ui.d.blackScreenStatusBarColor);
            Context context2 = this.f26986b.getRoot().getContext();
            j.f(context2, "root.context");
            ti.a.f(context2, color);
        }

        public void c(View view, int i10) {
            j.g(view, "bottomSheet");
        }
    }

    public static final class b implements View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior<ConstraintLayout> f26988a;

        static final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ BottomSheetBehavior<ConstraintLayout> f26989a;

            a(BottomSheetBehavior<ConstraintLayout> bottomSheetBehavior) {
                this.f26989a = bottomSheetBehavior;
            }

            public final void run() {
                this.f26989a.Q0(3);
            }
        }

        b(BottomSheetBehavior<ConstraintLayout> bottomSheetBehavior) {
            this.f26988a = bottomSheetBehavior;
        }

        public void onViewAttachedToWindow(View view) {
            j.g(view, "view");
            view.post(new a(this.f26988a));
        }

        public void onViewDetachedFromWindow(View view) {
            j.g(view, "view");
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CancelScreen f26990a;

        c(CancelScreen cancelScreen) {
            this.f26990a = cancelScreen;
        }

        public final void onClick(View view) {
            this.f26990a.f26976b.invoke();
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior<ConstraintLayout> f26991a;

        d(BottomSheetBehavior<ConstraintLayout> bottomSheetBehavior) {
            this.f26991a = bottomSheetBehavior;
        }

        public final void onClick(View view) {
            this.f26991a.Q0(4);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior<ConstraintLayout> f26992a;

        e(BottomSheetBehavior<ConstraintLayout> bottomSheetBehavior) {
            this.f26992a = bottomSheetBehavior;
        }

        public final void onClick(View view) {
            this.f26992a.Q0(4);
        }
    }

    public CancelScreen(StepStyle stepStyle, Function0<Unit> function0, Function0<Unit> function02, String str, String str2, String str3, String str4) {
        j.g(function0, "onExit");
        j.g(function02, "onContinue");
        this.f26975a = stepStyle;
        this.f26976b = function0;
        this.f26977c = function02;
        this.f26978d = str;
        this.f26979e = str2;
        this.f26980f = str3;
        this.f26981g = str4;
        f.a aVar = f.f23238a;
    }

    /* access modifiers changed from: private */
    public final void j(StepStyle stepStyle, oi.a aVar, boolean z10) {
        ButtonCancelComponentStyle v02;
        ButtonSubmitComponentStyle X1;
        TextBasedComponentStyle H1;
        TextBasedComponentStyle e12;
        StepStyle stepStyle2 = stepStyle;
        oi.a aVar2 = aVar;
        ConstraintLayout constraintLayout = aVar2.f32812b;
        j.f(constraintLayout, "binding.bottomSheet");
        BottomSheetStylingKt.b(constraintLayout, stepStyle2, (View) null, 2, (Object) null);
        if (!(stepStyle2 == null || (e12 = stepStyle.e1()) == null)) {
            TextView textView = aVar2.f32816f;
            j.f(textView, "binding.hintTitle");
            m.e(textView, e12);
        }
        if (!(stepStyle2 == null || (H1 = stepStyle.H1()) == null)) {
            TextView textView2 = aVar2.f32815e;
            j.f(textView2, "binding.hintMessage");
            m.e(textView2, H1);
        }
        if (!(stepStyle2 == null || (X1 = stepStyle.X1()) == null)) {
            Button button = aVar2.f32813c;
            j.f(button, "binding.closeButton");
            ButtonStylingKt.c(button, X1, false, !z10, 2, (Object) null);
        }
        if (stepStyle2 != null && (v02 = stepStyle.v0()) != null) {
            Button button2 = aVar2.f32817g;
            j.f(button2, "binding.retryButton");
            ButtonStylingKt.c(button2, v02, false, !z10, 2, (Object) null);
        }
    }

    public r<CancelScreen> a() {
        return this.f26982h;
    }
}
