package com.withpersona.sdk2.inquiry.modal;

import android.graphics.Color;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.squareup.workflow1.ui.b;
import com.squareup.workflow1.ui.f;
import com.squareup.workflow1.ui.p;
import com.withpersona.sdk2.inquiry.modal.CancelScreen;
import com.withpersona.sdk2.inquiry.shared.ui.k;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyle;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

public final class CancelScreen$special$$inlined$bind$1 extends Lambda implements Function1<oi.a, f<CancelScreen>> {
    final /* synthetic */ CancelScreen this$0;

    public static final class a<RenderingT> implements f {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ z1.a f26983b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CancelScreen f26984c;

        public a(z1.a aVar, CancelScreen cancelScreen) {
            this.f26983b = aVar;
            this.f26984c = cancelScreen;
        }

        public final void a(RenderingT renderingt, p pVar) {
            String str;
            int i10;
            boolean z10;
            CharSequence charSequence;
            boolean z11;
            CharSequence charSequence2;
            boolean z12;
            CharSequence charSequence3;
            CharSequence charSequence4;
            j.g(renderingt, "rendering");
            j.g(pVar, "viewEnvironment");
            CancelScreen cancelScreen = (CancelScreen) renderingt;
            oi.a aVar = (oi.a) this.f26983b;
            StepStyle h10 = this.f26984c.f26975a;
            if (h10 != null) {
                str = h10.V1();
            } else {
                str = null;
            }
            if (str != null) {
                i10 = Color.parseColor(this.f26984c.f26975a.V1());
            } else {
                i10 = -1;
            }
            BottomSheetBehavior k02 = BottomSheetBehavior.k0(aVar.f32812b);
            j.f(k02, "from(bottomSheet)");
            k02.Y(new CancelScreen.a(cancelScreen, aVar, i10));
            aVar.getRoot().addOnAttachStateChangeListener(new CancelScreen.b(k02));
            aVar.f32813c.setOnClickListener(new CancelScreen.c(cancelScreen));
            aVar.f32817g.setOnClickListener(new CancelScreen.d(k02));
            aVar.f32818h.setOnClickListener(new CancelScreen.e(k02));
            ConstraintLayout constraintLayout = aVar.f32812b;
            j.f(constraintLayout, "bottomSheet");
            b.c(constraintLayout, new CancelScreen$viewFactory$2$6(k02));
            TextView textView = aVar.f32816f;
            String i11 = this.f26984c.f26978d;
            boolean z13 = false;
            if (i11 == null || i11.length() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                charSequence = aVar.f32816f.getText();
            } else {
                charSequence = this.f26984c.f26978d;
            }
            textView.setText(charSequence);
            TextView textView2 = aVar.f32815e;
            String d10 = this.f26984c.f26979e;
            if (d10 == null || d10.length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                charSequence2 = aVar.f32815e.getText();
            } else {
                charSequence2 = this.f26984c.f26979e;
            }
            textView2.setText(charSequence2);
            Button button = aVar.f32813c;
            String c10 = this.f26984c.f26981g;
            if (c10 == null || c10.length() == 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                charSequence3 = aVar.f32813c.getText();
            } else {
                charSequence3 = this.f26984c.f26981g;
            }
            button.setText(charSequence3);
            Button button2 = aVar.f32817g;
            String g10 = this.f26984c.f26980f;
            if (g10 == null || g10.length() == 0) {
                z13 = true;
            }
            if (z13) {
                charSequence4 = aVar.f32817g.getText();
            } else {
                charSequence4 = this.f26984c.f26980f;
            }
            button2.setText(charSequence4);
            Button button3 = aVar.f32813c;
            j.f(button3, "closeButton");
            k.b(button3, new CancelScreen$viewFactory$2$7(aVar, this.f26984c));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CancelScreen$special$$inlined$bind$1(CancelScreen cancelScreen) {
        super(1);
        this.this$0 = cancelScreen;
    }

    /* renamed from: a */
    public final f<CancelScreen> invoke(oi.a aVar) {
        j.g(aVar, "binding");
        return new a(aVar, this.this$0);
    }
}
