package com.withpersona.sdk2.inquiry.permissions;

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

public final class BottomSheetDialogView implements com.squareup.workflow1.ui.a<BottomSheetDialogView> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final String f27077a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f27078b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final String f27079c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final StepStyle f27080d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Function0<Unit> f27081e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final String f27082f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final Function0<Unit> f27083g;

    /* renamed from: h  reason: collision with root package name */
    private final r<BottomSheetDialogView> f27084h = new ViewBindingViewFactory(l.b(BottomSheetDialogView.class), BottomSheetDialogView$viewFactory$1.f27096a, new BottomSheetDialogView$special$$inlined$bind$1(this));

    public static final class a extends BottomSheetBehavior.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BottomSheetDialogView f27087a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ pi.b f27088b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Integer f27089c;

        a(BottomSheetDialogView bottomSheetDialogView, pi.b bVar, Integer num) {
            this.f27087a = bottomSheetDialogView;
            this.f27088b = bVar;
            this.f27089c = num;
        }

        public void b(View view, float f10) {
            int i10;
            j.g(view, "bottomSheet");
            if (f10 <= 0.0f) {
                this.f27087a.f27083g.invoke();
                this.f27088b.f33762g.setVisibility(8);
                Context context = this.f27088b.getRoot().getContext();
                j.f(context, "root.context");
                Integer num = this.f27089c;
                if (num != null) {
                    i10 = num.intValue();
                } else {
                    i10 = -1;
                }
                ti.a.f(context, i10);
                return;
            }
            this.f27088b.f33762g.setVisibility(0);
            this.f27088b.f33762g.setAlpha(f10);
            int color = androidx.core.content.a.getColor(this.f27088b.getRoot().getContext(), com.withpersona.sdk2.inquiry.steps.ui.d.blackScreenStatusBarColor);
            Context context2 = this.f27088b.getRoot().getContext();
            j.f(context2, "root.context");
            ti.a.f(context2, color);
        }

        public void c(View view, int i10) {
            j.g(view, "bottomSheet");
        }
    }

    public static final class b implements View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior<?> f27090a;

        static final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ BottomSheetBehavior<?> f27091a;

            a(BottomSheetBehavior<?> bottomSheetBehavior) {
                this.f27091a = bottomSheetBehavior;
            }

            public final void run() {
                this.f27091a.Q0(3);
            }
        }

        b(BottomSheetBehavior<?> bottomSheetBehavior) {
            this.f27090a = bottomSheetBehavior;
        }

        public void onViewAttachedToWindow(View view) {
            j.g(view, "view");
            view.post(new a(this.f27090a));
        }

        public void onViewDetachedFromWindow(View view) {
            j.g(view, "view");
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BottomSheetDialogView f27092a;

        c(BottomSheetDialogView bottomSheetDialogView) {
            this.f27092a = bottomSheetDialogView;
        }

        public final void onClick(View view) {
            this.f27092a.f27081e.invoke();
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BottomSheetDialogView f27093a;

        d(BottomSheetDialogView bottomSheetDialogView) {
            this.f27093a = bottomSheetDialogView;
        }

        public final void onClick(View view) {
            this.f27093a.f27083g.invoke();
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final e f27094a = new e();

        e() {
        }

        public final void onClick(View view) {
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior<?> f27095a;

        f(BottomSheetBehavior<?> bottomSheetBehavior) {
            this.f27095a = bottomSheetBehavior;
        }

        public final void onClick(View view) {
            this.f27095a.Q0(4);
        }
    }

    public BottomSheetDialogView(String str, String str2, String str3, StepStyle stepStyle, Function0<Unit> function0, String str4, Function0<Unit> function02) {
        j.g(str, "titleText");
        j.g(str2, "messageText");
        j.g(str3, "positiveButtonText");
        j.g(function0, "onPositiveButtonClick");
        j.g(str4, "negativeButtonText");
        j.g(function02, "onNegativeButtonClick");
        this.f27077a = str;
        this.f27078b = str2;
        this.f27079c = str3;
        this.f27080d = stepStyle;
        this.f27081e = function0;
        this.f27082f = str4;
        this.f27083g = function02;
        f.a aVar = com.squareup.workflow1.ui.f.f23238a;
    }

    /* access modifiers changed from: private */
    public final void j(StepStyle stepStyle, pi.b bVar, boolean z10) {
        ButtonCancelComponentStyle v02;
        ButtonSubmitComponentStyle X1;
        TextBasedComponentStyle H1;
        TextBasedComponentStyle e12;
        StepStyle stepStyle2 = stepStyle;
        pi.b bVar2 = bVar;
        ConstraintLayout constraintLayout = bVar2.f33757b;
        j.f(constraintLayout, "binding.bottomSheet");
        BottomSheetStylingKt.b(constraintLayout, stepStyle2, (View) null, 2, (Object) null);
        if (!(stepStyle2 == null || (e12 = stepStyle.e1()) == null)) {
            TextView textView = bVar2.f33763h;
            j.f(textView, "binding.title");
            m.e(textView, e12);
        }
        if (!(stepStyle2 == null || (H1 = stepStyle.H1()) == null)) {
            TextView textView2 = bVar2.f33759d;
            j.f(textView2, "binding.message");
            m.e(textView2, H1);
        }
        if (!(stepStyle2 == null || (X1 = stepStyle.X1()) == null)) {
            Button button = bVar2.f33761f;
            j.f(button, "binding.positiveButton");
            ButtonStylingKt.c(button, X1, false, !z10, 2, (Object) null);
        }
        if (stepStyle2 != null && (v02 = stepStyle.v0()) != null) {
            Button button2 = bVar2.f33760e;
            j.f(button2, "binding.negativeButton");
            ButtonStylingKt.c(button2, v02, false, !z10, 2, (Object) null);
        }
    }

    public r<BottomSheetDialogView> a() {
        return this.f27084h;
    }
}
