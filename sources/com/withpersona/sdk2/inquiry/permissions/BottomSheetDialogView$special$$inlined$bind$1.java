package com.withpersona.sdk2.inquiry.permissions;

import android.content.Context;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import androidx.appcompat.app.c;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.squareup.workflow1.ui.f;
import com.squareup.workflow1.ui.p;
import com.withpersona.sdk2.inquiry.permissions.BottomSheetDialogView;
import com.withpersona.sdk2.inquiry.shared.ui.k;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import pi.b;

public final class BottomSheetDialogView$special$$inlined$bind$1 extends Lambda implements Function1<b, f<BottomSheetDialogView>> {
    final /* synthetic */ BottomSheetDialogView this$0;

    public static final class a<RenderingT> implements f {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ z1.a f27085b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ BottomSheetDialogView f27086c;

        public a(z1.a aVar, BottomSheetDialogView bottomSheetDialogView) {
            this.f27085b = aVar;
            this.f27086c = bottomSheetDialogView;
        }

        public final void a(RenderingT renderingt, p pVar) {
            Integer num;
            boolean z10;
            Window window;
            j.g(renderingt, "rendering");
            j.g(pVar, "viewEnvironment");
            BottomSheetDialogView bottomSheetDialogView = (BottomSheetDialogView) renderingt;
            b bVar = (b) this.f27085b;
            Context context = bVar.getRoot().getContext();
            j.f(context, "root.context");
            c a10 = ti.a.a(context);
            if (a10 == null || (window = a10.getWindow()) == null) {
                num = null;
            } else {
                num = Integer.valueOf(window.getStatusBarColor());
            }
            ViewGroup.LayoutParams layoutParams = bVar.f33757b.getLayoutParams();
            j.e(layoutParams, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
            CoordinatorLayout.c f10 = ((CoordinatorLayout.f) layoutParams).f();
            j.e(f10, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetBehavior<*>");
            BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) f10;
            bottomSheetBehavior.Y(new BottomSheetDialogView.a(bottomSheetDialogView, bVar, num));
            bVar.getRoot().addOnAttachStateChangeListener(new BottomSheetDialogView.b(bottomSheetBehavior));
            if (this.f27086c.f27077a.length() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                bVar.f33763h.setText(this.f27086c.f27077a);
            } else {
                bVar.f33763h.setVisibility(8);
            }
            bVar.f33759d.setText(this.f27086c.f27078b);
            bVar.f33761f.setText(bottomSheetDialogView.f27079c);
            bVar.f33761f.setOnClickListener(new BottomSheetDialogView.c(bottomSheetDialogView));
            bVar.f33760e.setText(bottomSheetDialogView.f27082f);
            bVar.f33760e.setOnClickListener(new BottomSheetDialogView.d(bottomSheetDialogView));
            ConstraintLayout constraintLayout = bVar.f33757b;
            j.f(constraintLayout, "bottomSheet");
            com.squareup.workflow1.ui.b.c(constraintLayout, new BottomSheetDialogView$viewFactory$2$5(bottomSheetDialogView));
            bVar.f33757b.setOnClickListener(BottomSheetDialogView.e.f27094a);
            bVar.f33762g.setOnClickListener(new BottomSheetDialogView.f(bottomSheetBehavior));
            Button button = bVar.f33760e;
            j.f(button, "negativeButton");
            k.b(button, new BottomSheetDialogView$viewFactory$2$8(bVar, this.f27086c));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomSheetDialogView$special$$inlined$bind$1(BottomSheetDialogView bottomSheetDialogView) {
        super(1);
        this.this$0 = bottomSheetDialogView;
    }

    /* renamed from: a */
    public final f<BottomSheetDialogView> invoke(b bVar) {
        j.g(bVar, "binding");
        return new a(bVar, this.this$0);
    }
}
