package com.withpersona.sdk2.inquiry.governmentid;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i;
import com.squareup.workflow1.ui.ViewBindingViewFactory;
import com.squareup.workflow1.ui.f;
import com.squareup.workflow1.ui.p;
import com.squareup.workflow1.ui.r;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import com.withpersona.sdk2.inquiry.shared.ui.NavigationUiState;
import com.withpersona.sdk2.inquiry.shared.ui.k;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$GovernmentIdStepStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.TextBasedComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.styling.m;
import ki.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;
import ti.a;
import ti.b;
import ti.n;
import ti.o;
import wk.c;

public final class GovernmentIdInstructionsRunner implements f<GovernmentIdWorkflow.Screen.InstructionsScreen> {

    /* renamed from: f  reason: collision with root package name */
    public static final Companion f25359f = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final d f25360b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f25361c;

    /* renamed from: d  reason: collision with root package name */
    private final i f25362d;

    /* renamed from: e  reason: collision with root package name */
    private final RecyclerView f25363e;

    public static final class Companion implements r<GovernmentIdWorkflow.Screen.InstructionsScreen> {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ r<GovernmentIdWorkflow.Screen.InstructionsScreen> f25364a;

        private Companion() {
            f.a aVar = f.f23238a;
            this.f25364a = new ViewBindingViewFactory(l.b(GovernmentIdWorkflow.Screen.InstructionsScreen.class), AnonymousClass1.f25365a, AnonymousClass2.f25366a);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: b */
        public View a(GovernmentIdWorkflow.Screen.InstructionsScreen instructionsScreen, p pVar, Context context, ViewGroup viewGroup) {
            j.g(instructionsScreen, "initialRendering");
            j.g(pVar, "initialViewEnvironment");
            j.g(context, "contextForNewView");
            return this.f25364a.a(instructionsScreen, pVar, context, viewGroup);
        }

        public c<? super GovernmentIdWorkflow.Screen.InstructionsScreen> getType() {
            return this.f25364a.getType();
        }
    }

    public GovernmentIdInstructionsRunner(d dVar) {
        j.g(dVar, "binding");
        this.f25360b = dVar;
        Context context = dVar.getRoot().getContext();
        j.f(context, "binding.root.context");
        boolean b10 = n.b(context, h0.personaHideSeparators, (TypedValue) null, false, 6, (Object) null);
        this.f25361c = b10;
        i iVar = new i(dVar.getRoot().getContext(), 1);
        this.f25362d = iVar;
        RecyclerView recyclerView = dVar.f31964e;
        recyclerView.setLayoutManager(new LinearLayoutManager(dVar.getRoot().getContext()));
        if (!b10) {
            recyclerView.h(iVar);
        }
        j.f(recyclerView, "binding.recyclerviewGove…Decoration)\n      }\n    }");
        this.f25363e = recyclerView;
    }

    private final void c(StepStyles$GovernmentIdStepStyle stepStyles$GovernmentIdStepStyle) {
        String V1 = stepStyles$GovernmentIdStepStyle.V1();
        if (V1 != null) {
            this.f25360b.getRoot().setBackgroundColor(Color.parseColor(V1));
            Context context = this.f25360b.getRoot().getContext();
            j.f(context, "binding.root.context");
            a.f(context, Color.parseColor(V1));
        }
        Context context2 = this.f25360b.getRoot().getContext();
        j.f(context2, "binding.root.context");
        Drawable r12 = stepStyles$GovernmentIdStepStyle.r1(context2);
        if (r12 != null) {
            this.f25360b.getRoot().setBackground(r12);
        }
        String G = stepStyles$GovernmentIdStepStyle.G();
        if (G != null) {
            this.f25360b.f31963d.setControlsColor(Color.parseColor(G));
        }
        TextBasedComponentStyle e12 = stepStyles$GovernmentIdStepStyle.e1();
        if (e12 != null) {
            TextView textView = this.f25360b.f31967h;
            j.f(textView, "binding.textviewGovernmentidInstructionsTitle");
            m.e(textView, e12);
        }
        TextBasedComponentStyle H1 = stepStyles$GovernmentIdStepStyle.H1();
        if (H1 != null) {
            TextView textView2 = this.f25360b.f31965f;
            j.f(textView2, "binding.textviewGovernmentidInstructionsBody");
            m.e(textView2, H1);
            TextView textView3 = this.f25360b.f31968j;
            j.f(textView3, "binding.textviewGovernmentidInstructionslistheader");
            m.e(textView3, H1);
        }
        TextBasedComponentStyle n10 = stepStyles$GovernmentIdStepStyle.n();
        if (n10 != null) {
            TextView textView4 = this.f25360b.f31966g;
            j.f(textView4, "binding.textviewGovernmentidInstructionsDisclaimer");
            m.e(textView4, n10);
        }
        String B = stepStyles$GovernmentIdStepStyle.B();
        if (B != null) {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{Color.parseColor(B), Color.parseColor(B)});
            gradientDrawable.setSize((int) Math.ceil(b.a(1.0d)), (int) Math.ceil(b.a(1.0d)));
            this.f25362d.o(gradientDrawable);
            this.f25360b.f31962c.setBackgroundColor(Color.parseColor(B));
        }
        Double w10 = stepStyles$GovernmentIdStepStyle.w();
        if (w10 != null) {
            double doubleValue = w10.doubleValue();
            GradientDrawable gradientDrawable2 = (GradientDrawable) this.f25362d.n();
            if (gradientDrawable2 != null) {
                gradientDrawable2.setSize((int) Math.ceil(b.a(doubleValue)), (int) Math.ceil(b.a(doubleValue)));
            }
            View view = this.f25360b.f31962c;
            j.f(view, "binding.listDivider");
            k.b(view, new GovernmentIdInstructionsRunner$applyStyles$8$1(this, doubleValue));
        }
    }

    /* renamed from: d */
    public void a(GovernmentIdWorkflow.Screen.InstructionsScreen instructionsScreen, p pVar) {
        j.g(instructionsScreen, "rendering");
        j.g(pVar, "viewEnvironment");
        Context context = this.f25360b.getRoot().getContext();
        j.f(context, "binding.root.context");
        Integer f10 = n.f(context, h0.personaGovIdSelectHeaderImage, (TypedValue) null, false, 6, (Object) null);
        int i10 = 0;
        if (f10 != null) {
            this.f25360b.f31961b.setImageResource(f10.intValue());
            this.f25360b.f31961b.setVisibility(0);
            TextView textView = this.f25360b.f31967h;
            j.f(textView, "binding.textviewGovernmentidInstructionsTitle");
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            if (layoutParams != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = 0;
                textView.setLayoutParams(marginLayoutParams);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
        }
        this.f25360b.f31967h.setText(instructionsScreen.m());
        TextView textView2 = this.f25360b.f31965f;
        j.f(textView2, "binding.textviewGovernmentidInstructionsBody");
        q.b(textView2, instructionsScreen.j());
        TextView textView3 = this.f25360b.f31968j;
        j.f(textView3, "binding.textviewGovernmentidInstructionslistheader");
        q.b(textView3, instructionsScreen.d());
        TextView textView4 = this.f25360b.f31966g;
        j.f(textView4, "binding.textviewGovernmentidInstructionsDisclaimer");
        q.b(textView4, instructionsScreen.e());
        if (!r.w(instructionsScreen.e())) {
            this.f25360b.f31963d.setAccessibilityTraversalAfter(l0.textview_governmentid_instructions_disclaimer);
        }
        View view = this.f25360b.f31962c;
        if (this.f25361c) {
            i10 = 8;
        }
        view.setVisibility(i10);
        this.f25363e.setAdapter(new t(instructionsScreen.f(), instructionsScreen.l(), new GovernmentIdInstructionsRunner$showRendering$2(instructionsScreen)));
        this.f25360b.f31963d.setState(new NavigationUiState(instructionsScreen.a(), new GovernmentIdInstructionsRunner$showRendering$3(instructionsScreen), instructionsScreen.c(), new GovernmentIdInstructionsRunner$showRendering$4(instructionsScreen)));
        CoordinatorLayout b10 = this.f25360b.getRoot();
        j.f(b10, "binding.root");
        o.b(b10, instructionsScreen.getError(), instructionsScreen.i(), (View) null, 0, 0, 56, (Object) null);
        StepStyles$GovernmentIdStepStyle l10 = instructionsScreen.l();
        if (l10 != null) {
            c(l10);
        }
    }
}
