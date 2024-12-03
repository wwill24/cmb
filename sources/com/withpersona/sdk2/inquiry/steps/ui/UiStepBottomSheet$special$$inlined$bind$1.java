package com.withpersona.sdk2.inquiry.steps.ui;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.ui.b;
import com.squareup.workflow1.ui.f;
import com.squareup.workflow1.ui.p;
import com.withpersona.sdk2.inquiry.steps.ui.UiStepBottomSheet;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$UiStepStyle;
import com.withpersona.sdk2.inquiry.steps.ui.styling.BottomSheetStylingKt;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

public final class UiStepBottomSheet$special$$inlined$bind$1 extends Lambda implements Function1<vi.a, f<UiStepBottomSheet>> {
    final /* synthetic */ UiStepBottomSheet this$0;

    public static final class a<RenderingT> implements f {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ z1.a f27549b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ UiStepBottomSheet f27550c;

        public a(z1.a aVar, UiStepBottomSheet uiStepBottomSheet) {
            this.f27549b = aVar;
            this.f27550c = uiStepBottomSheet;
        }

        public final void a(RenderingT renderingt, p pVar) {
            String str;
            int i10;
            View d10;
            View d11;
            j.g(renderingt, "rendering");
            j.g(pVar, "viewEnvironment");
            UiStepBottomSheet uiStepBottomSheet = (UiStepBottomSheet) renderingt;
            vi.a aVar = (vi.a) this.f27549b;
            StepStyles$UiStepStyle b10 = this.f27550c.f27544a.b();
            if (b10 != null) {
                str = b10.V1();
            } else {
                str = null;
            }
            if (str != null) {
                i10 = Color.parseColor(this.f27550c.f27544a.b().V1());
            } else {
                i10 = -1;
            }
            ViewGroup.LayoutParams layoutParams = aVar.f33896b.getLayoutParams();
            j.e(layoutParams, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
            CoordinatorLayout.c f10 = ((CoordinatorLayout.f) layoutParams).f();
            j.e(f10, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetBehavior<*>");
            BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) f10;
            bottomSheetBehavior.Y(new UiStepBottomSheet.a(uiStepBottomSheet, aVar, i10));
            aVar.getRoot().addOnAttachStateChangeListener(new UiStepBottomSheet.b(bottomSheetBehavior));
            Context context = aVar.getRoot().getContext();
            m mVar = m.f27597a;
            j.f(context, IdentityHttpResponse.CONTEXT);
            j g10 = mVar.g(context, this.f27550c.f27544a, false);
            aVar.f33897c.addView(g10.a());
            Map<String, a> a10 = g10.c().a();
            for (Pair pair : this.f27550c.f27545b) {
                Function0 function0 = (Function0) pair.d();
                a aVar2 = a10.get((String) pair.c());
                if (!(aVar2 == null || (d11 = aVar2.d()) == null)) {
                    d11.setOnClickListener(new UiStepBottomSheet.c(function0));
                }
            }
            a aVar3 = a10.get(this.f27550c.f27547d);
            if (!(aVar3 == null || (d10 = aVar3.d()) == null)) {
                d10.setOnClickListener(new UiStepBottomSheet.d(bottomSheetBehavior));
            }
            ConstraintLayout constraintLayout = aVar.f33896b;
            j.f(constraintLayout, "bottomSheet");
            b.c(constraintLayout, new UiStepBottomSheet$viewFactory$2$5(bottomSheetBehavior));
            aVar.f33899e.setOnClickListener(new UiStepBottomSheet.e(bottomSheetBehavior));
            ConstraintLayout constraintLayout2 = aVar.f33896b;
            j.f(constraintLayout2, "bottomSheet");
            StepStyles$UiStepStyle b11 = this.f27550c.f27544a.b();
            FrameLayout frameLayout = aVar.f33897c;
            j.f(frameLayout, "contentContainer");
            BottomSheetStylingKt.a(constraintLayout2, b11, frameLayout);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UiStepBottomSheet$special$$inlined$bind$1(UiStepBottomSheet uiStepBottomSheet) {
        super(1);
        this.this$0 = uiStepBottomSheet;
    }

    /* renamed from: a */
    public final f<UiStepBottomSheet> invoke(vi.a aVar) {
        j.g(aVar, "binding");
        return new a(aVar, this.this$0);
    }
}
