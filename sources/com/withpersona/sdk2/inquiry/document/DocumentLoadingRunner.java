package com.withpersona.sdk2.inquiry.document;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.ui.ViewBindingViewFactory;
import com.squareup.workflow1.ui.b;
import com.squareup.workflow1.ui.f;
import com.squareup.workflow1.ui.p;
import com.squareup.workflow1.ui.r;
import com.withpersona.sdk2.inquiry.document.DocumentWorkflow;
import com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$DocumentStepStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.TextBasedComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.styling.m;
import ii.a;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;
import ti.n;
import wk.c;

public final class DocumentLoadingRunner implements f<DocumentWorkflow.d.a> {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f24987c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final a f24988b;

    public static final class Companion implements r<DocumentWorkflow.d.a> {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ r<DocumentWorkflow.d.a> f24989a;

        private Companion() {
            f.a aVar = f.f23238a;
            this.f24989a = new ViewBindingViewFactory(l.b(DocumentWorkflow.d.a.class), AnonymousClass1.f24990a, AnonymousClass2.f24991a);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: b */
        public View a(DocumentWorkflow.d.a aVar, p pVar, Context context, ViewGroup viewGroup) {
            j.g(aVar, "initialRendering");
            j.g(pVar, "initialViewEnvironment");
            j.g(context, "contextForNewView");
            return this.f24989a.a(aVar, pVar, context, viewGroup);
        }

        public c<? super DocumentWorkflow.d.a> getType() {
            return this.f24989a.getType();
        }
    }

    public DocumentLoadingRunner(a aVar) {
        j.g(aVar, "binding");
        this.f24988b = aVar;
        Context context = aVar.getRoot().getContext();
        j.f(context, IdentityHttpResponse.CONTEXT);
        Integer f10 = n.f(context, i.personaInquiryLoadingLottieRaw, (TypedValue) null, false, 6, (Object) null);
        if (f10 != null) {
            aVar.f29948c.setAnimation(f10.intValue());
            aVar.f29948c.A();
            return;
        }
        ThemeableLottieAnimationView themeableLottieAnimationView = aVar.f29948c;
        int parseColor = Color.parseColor("#4600EB");
        Context context2 = aVar.getRoot().getContext();
        j.f(context2, "binding.root.context");
        themeableLottieAnimationView.I(parseColor, d(this, context2, i.colorPrimary, (TypedValue) null, false, 6, (Object) null));
    }

    private final void b(StepStyles$DocumentStepStyle stepStyles$DocumentStepStyle) {
        String C;
        String A0;
        TextBasedComponentStyle w12;
        TextBasedComponentStyle v10;
        String V1;
        if (!(stepStyles$DocumentStepStyle == null || (V1 = stepStyles$DocumentStepStyle.V1()) == null)) {
            this.f24988b.getRoot().setBackgroundColor(Color.parseColor(V1));
            Context context = this.f24988b.getRoot().getContext();
            j.f(context, "binding.root.context");
            ti.a.f(context, Color.parseColor(V1));
        }
        if (stepStyles$DocumentStepStyle != null) {
            Context context2 = this.f24988b.getRoot().getContext();
            j.f(context2, "binding.root.context");
            Drawable r12 = stepStyles$DocumentStepStyle.r1(context2);
            if (r12 != null) {
                this.f24988b.getRoot().setBackground(r12);
            }
        }
        if (!(stepStyles$DocumentStepStyle == null || (v10 = stepStyles$DocumentStepStyle.v()) == null)) {
            TextView textView = this.f24988b.f29949d;
            j.f(textView, "binding.title");
            m.e(textView, v10);
        }
        if (!(stepStyles$DocumentStepStyle == null || (w12 = stepStyles$DocumentStepStyle.w1()) == null)) {
            TextView textView2 = this.f24988b.f29947b;
            j.f(textView2, "binding.body");
            m.e(textView2, w12);
        }
        if (!(stepStyles$DocumentStepStyle == null || (A0 = stepStyles$DocumentStepStyle.A0()) == null)) {
            this.f24988b.f29948c.I(Color.parseColor("#4600EB"), Color.parseColor(A0));
        }
        if (stepStyles$DocumentStepStyle != null && (C = stepStyles$DocumentStepStyle.C()) != null) {
            this.f24988b.f29948c.I(Color.parseColor("#180052"), Color.parseColor(C));
            this.f24988b.f29948c.I(Color.parseColor("#190052"), Color.parseColor(C));
        }
    }

    private final int c(Context context, int i10, TypedValue typedValue, boolean z10) {
        context.getTheme().resolveAttribute(i10, typedValue, z10);
        return typedValue.data;
    }

    static /* synthetic */ int d(DocumentLoadingRunner documentLoadingRunner, Context context, int i10, TypedValue typedValue, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            typedValue = new TypedValue();
        }
        if ((i11 & 4) != 0) {
            z10 = true;
        }
        return documentLoadingRunner.c(context, i10, typedValue, z10);
    }

    /* renamed from: e */
    public void a(DocumentWorkflow.d.a aVar, p pVar) {
        j.g(aVar, "rendering");
        j.g(pVar, "viewEnvironment");
        a aVar2 = this.f24988b;
        if (aVar.d() == null) {
            aVar2.f29949d.setVisibility(8);
        } else {
            aVar2.f29949d.setText(aVar.d());
        }
        if (aVar.b() == null) {
            aVar2.f29947b.setVisibility(8);
        } else {
            aVar2.f29947b.setText(aVar.b());
        }
        ConstraintLayout b10 = aVar2.getRoot();
        j.f(b10, "root");
        b.c(b10, new DocumentLoadingRunner$showRendering$1$1(aVar));
        if (aVar.c() != null) {
            b(aVar.c());
        }
    }
}
