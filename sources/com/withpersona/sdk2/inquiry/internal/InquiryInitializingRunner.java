package com.withpersona.sdk2.inquiry.internal;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.a;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.h0;
import com.squareup.workflow1.ui.LayoutRunnerViewFactory;
import com.squareup.workflow1.ui.f;
import com.squareup.workflow1.ui.p;
import com.squareup.workflow1.ui.r;
import com.withpersona.sdk2.inquiry.internal.InquiryWorkflow;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyle;
import d3.b;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;
import ti.n;
import w2.d;
import wk.c;

public final class InquiryInitializingRunner implements f<InquiryWorkflow.b.a> {

    /* renamed from: f  reason: collision with root package name */
    public static final Companion f26148f = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final View f26149b;

    /* renamed from: c  reason: collision with root package name */
    private final LottieAnimationView f26150c;

    /* renamed from: d  reason: collision with root package name */
    private final Integer f26151d;

    /* renamed from: e  reason: collision with root package name */
    private Integer f26152e;

    public static final class Companion implements r<InquiryWorkflow.b.a> {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ r<InquiryWorkflow.b.a> f26153a;

        private Companion() {
            f.a aVar = f.f23238a;
            this.f26153a = new LayoutRunnerViewFactory(l.b(InquiryWorkflow.b.a.class), p.pi2_inquiry_initializing, AnonymousClass1.f26154a);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: b */
        public View a(InquiryWorkflow.b.a aVar, p pVar, Context context, ViewGroup viewGroup) {
            j.g(aVar, "initialRendering");
            j.g(pVar, "initialViewEnvironment");
            j.g(context, "contextForNewView");
            return this.f26153a.a(aVar, pVar, context, viewGroup);
        }

        public c<? super InquiryWorkflow.b.a> getType() {
            return this.f26153a.getType();
        }
    }

    public InquiryInitializingRunner(View view) {
        j.g(view, "view");
        this.f26149b = view;
        View findViewById = view.findViewById(o.animationview_inquiry_initializingspinner);
        j.f(findViewById, "view.findViewById(R.id.a…uiry_initializingspinner)");
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById;
        this.f26150c = lottieAnimationView;
        Context context = view.getContext();
        j.f(context, "view.context");
        Integer f10 = n.f(context, n.personaInquiryLoadingLottieRaw, (TypedValue) null, false, 6, (Object) null);
        this.f26151d = f10;
        if (f10 != null) {
            j(f10.intValue());
            lottieAnimationView.A();
            return;
        }
        lottieAnimationView.l(new d("**"), h0.f8566b, new i(this));
        lottieAnimationView.l(new d("**"), h0.f8565a, new j(this));
    }

    /* access modifiers changed from: private */
    public static final Integer f(InquiryInitializingRunner inquiryInitializingRunner, b bVar) {
        j.g(inquiryInitializingRunner, "this$0");
        Context context = inquiryInitializingRunner.f26149b.getContext();
        j.f(context, "view.context");
        return Integer.valueOf(i(inquiryInitializingRunner, context, n.colorPrimaryVariant, (TypedValue) null, false, 6, (Object) null));
    }

    /* access modifiers changed from: private */
    public static final Integer g(InquiryInitializingRunner inquiryInitializingRunner, b bVar) {
        j.g(inquiryInitializingRunner, "this$0");
        Context context = inquiryInitializingRunner.f26149b.getContext();
        j.f(context, "view.context");
        return Integer.valueOf(i(inquiryInitializingRunner, context, n.colorPrimary, (TypedValue) null, false, 6, (Object) null));
    }

    private final int h(Context context, int i10, TypedValue typedValue, boolean z10) {
        context.getTheme().resolveAttribute(i10, typedValue, z10);
        return typedValue.data;
    }

    static /* synthetic */ int i(InquiryInitializingRunner inquiryInitializingRunner, Context context, int i10, TypedValue typedValue, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            typedValue = new TypedValue();
        }
        if ((i11 & 4) != 0) {
            z10 = true;
        }
        return inquiryInitializingRunner.h(context, i10, typedValue, z10);
    }

    private final void j(int i10) {
        Integer num = this.f26152e;
        if (num == null || num.intValue() != i10) {
            this.f26152e = Integer.valueOf(i10);
            this.f26150c.m();
            this.f26150c.setMinFrame(0);
            this.f26150c.setAnimation(i10);
        }
    }

    /* access modifiers changed from: private */
    public static final Integer l(String str, b bVar) {
        j.g(str, "$fillColor");
        return Integer.valueOf(Color.parseColor(str));
    }

    /* access modifiers changed from: private */
    public static final Integer m(String str, b bVar) {
        j.g(str, "$strokeColor");
        return Integer.valueOf(Color.parseColor(str));
    }

    /* renamed from: k */
    public void a(InquiryWorkflow.b.a aVar, p pVar) {
        j.g(aVar, "rendering");
        j.g(pVar, "viewEnvironment");
        if (aVar.c() && this.f26151d == null) {
            j(q.pi2_initial_load_animation);
            this.f26150c.setScaleX(0.5f);
            this.f26150c.setScaleY(0.5f);
        }
        if (aVar.c()) {
            Context context = this.f26149b.getContext();
            j.f(context, "view.context");
            Integer f10 = n.f(context, n.personaInitialLoadingBackgroundDrawable, (TypedValue) null, false, 6, (Object) null);
            if (f10 != null) {
                this.f26149b.setBackground(a.getDrawable(this.f26149b.getContext(), f10.intValue()));
            }
        }
        StepStyle b10 = aVar.b();
        if (b10 != null) {
            String V1 = b10.V1();
            if (V1 != null) {
                this.f26149b.setBackgroundColor(Color.parseColor(V1));
                Context context2 = this.f26149b.getContext();
                j.f(context2, "view.context");
                ti.a.f(context2, Color.parseColor(V1));
            }
            Context context3 = this.f26149b.getContext();
            j.f(context3, "view.context");
            Drawable r12 = b10.r1(context3);
            if (r12 != null) {
                this.f26149b.setBackground(r12);
            }
            if (this.f26151d == null) {
                String A0 = b10.A0();
                if (A0 != null) {
                    this.f26150c.l(new d("**"), h0.f8565a, new k(A0));
                }
                String C = b10.C();
                if (C != null) {
                    this.f26150c.l(new d("**"), h0.f8566b, new l(C));
                }
            }
        }
        com.squareup.workflow1.ui.b.c(this.f26149b, new InquiryInitializingRunner$showRendering$3(aVar));
    }
}
