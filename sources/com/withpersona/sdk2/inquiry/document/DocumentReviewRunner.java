package com.withpersona.sdk2.inquiry.document;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.workflow1.ui.ViewBindingViewFactory;
import com.squareup.workflow1.ui.f;
import com.squareup.workflow1.ui.p;
import com.squareup.workflow1.ui.r;
import com.withpersona.sdk2.inquiry.document.DocumentWorkflow;
import com.withpersona.sdk2.inquiry.shared.ui.NavigationUiState;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.ButtonSubmitComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$DocumentStepStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.TextBasedComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.styling.ButtonStylingKt;
import com.withpersona.sdk2.inquiry.steps.ui.styling.m;
import ii.c;
import ij.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;
import ti.a;
import ti.o;

public final class DocumentReviewRunner implements f<DocumentWorkflow.d.b> {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f24994c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final c f24995b;

    public static final class Companion implements r<DocumentWorkflow.d.b> {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ r<DocumentWorkflow.d.b> f24996a;

        private Companion() {
            f.a aVar = f.f23238a;
            this.f24996a = new ViewBindingViewFactory(l.b(DocumentWorkflow.d.b.class), AnonymousClass1.f24997a, AnonymousClass2.f24998a);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: b */
        public View a(DocumentWorkflow.d.b bVar, p pVar, Context context, ViewGroup viewGroup) {
            j.g(bVar, "initialRendering");
            j.g(pVar, "initialViewEnvironment");
            j.g(context, "contextForNewView");
            return this.f24996a.a(bVar, pVar, context, viewGroup);
        }

        public wk.c<? super DocumentWorkflow.d.b> getType() {
            return this.f24996a.getType();
        }
    }

    public DocumentReviewRunner(c cVar) {
        j.g(cVar, "binding");
        this.f24995b = cVar;
    }

    private final void c(StepStyles$DocumentStepStyle stepStyles$DocumentStepStyle) {
        ButtonSubmitComponentStyle X1;
        TextBasedComponentStyle j10;
        TextBasedComponentStyle H1;
        TextBasedComponentStyle e12;
        String m10;
        String V1;
        if (!(stepStyles$DocumentStepStyle == null || (V1 = stepStyles$DocumentStepStyle.V1()) == null)) {
            this.f24995b.getRoot().setBackgroundColor(Color.parseColor(V1));
            Context context = this.f24995b.getRoot().getContext();
            j.f(context, "binding.root.context");
            a.f(context, Color.parseColor(V1));
        }
        if (stepStyles$DocumentStepStyle != null) {
            Context context2 = this.f24995b.getRoot().getContext();
            j.f(context2, "binding.root.context");
            Drawable r12 = stepStyles$DocumentStepStyle.r1(context2);
            if (r12 != null) {
                this.f24995b.getRoot().setBackground(r12);
            }
        }
        if (!(stepStyles$DocumentStepStyle == null || (m10 = stepStyles$DocumentStepStyle.m()) == null)) {
            this.f24995b.f29958f.setControlsColor(Color.parseColor(m10));
        }
        if (!(stepStyles$DocumentStepStyle == null || (e12 = stepStyles$DocumentStepStyle.e1()) == null)) {
            TextView textView = this.f24995b.f29962k;
            j.f(textView, "binding.title");
            m.e(textView, e12);
        }
        if (!(stepStyles$DocumentStepStyle == null || (H1 = stepStyles$DocumentStepStyle.H1()) == null)) {
            TextView textView2 = this.f24995b.f29954b;
            j.f(textView2, "binding.body");
            m.e(textView2, H1);
        }
        if (!(stepStyles$DocumentStepStyle == null || (j10 = stepStyles$DocumentStepStyle.j()) == null)) {
            TextView textView3 = this.f24995b.f29956d;
            j.f(textView3, "binding.disclaimer");
            m.e(textView3, j10);
        }
        if (stepStyles$DocumentStepStyle != null && (X1 = stepStyles$DocumentStepStyle.X1()) != null) {
            Button button = this.f24995b.f29961j;
            j.f(button, "binding.submitButton");
            ButtonStylingKt.c(button, X1, false, false, 6, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void e(DocumentWorkflow.d.b bVar, View view) {
        j.g(bVar, "$rendering");
        bVar.m().invoke();
    }

    /* renamed from: d */
    public void a(DocumentWorkflow.d.b bVar, p pVar) {
        g gVar;
        boolean z10;
        j.g(bVar, "rendering");
        j.g(pVar, "viewEnvironment");
        c cVar = this.f24995b;
        cVar.f29962k.setText(bVar.s());
        String o10 = bVar.o();
        if (o10 != null) {
            e.b(this.f24995b.getRoot().getContext()).c(cVar.f29954b, o10);
        }
        cVar.f29956d.setText(bVar.e());
        if (cVar.f29959g.getAdapter() == null) {
            Context context = this.f24995b.getRoot().getContext();
            j.f(context, "binding.root.context");
            gVar = new g(context, bVar.h(), bVar.n(), bVar.p());
            cVar.f29959g.setAdapter(gVar);
        } else {
            RecyclerView.Adapter adapter = cVar.f29959g.getAdapter();
            j.e(adapter, "null cannot be cast to non-null type com.withpersona.sdk2.inquiry.document.DocumentTileAdapter");
            gVar = (g) adapter;
        }
        if (bVar.d() || !bVar.a()) {
            z10 = false;
        } else {
            z10 = true;
        }
        gVar.O(z10, bVar.f());
        gVar.N(new DocumentReviewRunner$showRendering$1$2(bVar));
        cVar.f29961j.setText(bVar.r());
        cVar.f29961j.setEnabled(bVar.q());
        cVar.f29961j.setOnClickListener(new d(bVar));
        cVar.f29958f.setState(new NavigationUiState(bVar.b(), new DocumentReviewRunner$showRendering$1$4(bVar), bVar.c(), new DocumentReviewRunner$showRendering$1$5(bVar)));
        CoordinatorLayout b10 = this.f24995b.getRoot();
        j.f(b10, "binding.root");
        o.a(b10, bVar.g(), bVar.k(), this.f24995b.f29961j, 4, 10000);
        c(bVar.p());
    }
}
