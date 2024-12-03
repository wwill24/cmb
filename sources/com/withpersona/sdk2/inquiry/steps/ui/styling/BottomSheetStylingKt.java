package com.withpersona.sdk2.inquiry.steps.ui.styling;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import com.mparticle.identity.IdentityHttpResponse;
import com.withpersona.sdk2.inquiry.steps.ui.c;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.Unit;
import kotlin.jvm.internal.j;
import kotlin.sequences.Sequence;
import ti.b;
import ti.n;

public final class BottomSheetStylingKt {
    public static final void a(ViewGroup viewGroup, StepStyle stepStyle, View view) {
        Unit unit;
        StyleElements.DPSizeSet T1;
        int i10;
        int i11;
        int i12;
        int i13;
        Double a10;
        Double a11;
        Double a12;
        Double a13;
        String V1;
        j.g(viewGroup, "<this>");
        j.g(view, "innerView");
        StyleElements.DPSize dPSize = null;
        if (stepStyle == null || (V1 = stepStyle.V1()) == null) {
            unit = null;
        } else {
            viewGroup.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(V1)));
            unit = Unit.f32013a;
        }
        if (unit == null) {
            Context context = viewGroup.getContext();
            j.f(context, "this.context");
            viewGroup.setBackgroundTintList(ColorStateList.valueOf(n.d(context, c.colorSurface, (TypedValue) null, false, 6, (Object) null)));
        }
        if (stepStyle != null) {
            Context context2 = viewGroup.getContext();
            j.f(context2, "this.context");
            Drawable r12 = stepStyle.r1(context2);
            if (r12 != null) {
                d(viewGroup, r12);
            }
        }
        if (!(stepStyle == null || (T1 = stepStyle.T1()) == null)) {
            StyleElements.DPSize c10 = T1.c();
            if (c10 == null || (a13 = c10.a()) == null) {
                i10 = viewGroup.getPaddingLeft();
            } else {
                i10 = (int) b.a(a13.doubleValue());
            }
            StyleElements.DPSize e10 = T1.e();
            if (e10 == null || (a12 = e10.a()) == null) {
                i11 = viewGroup.getPaddingTop();
            } else {
                i11 = (int) b.a(a12.doubleValue());
            }
            StyleElements.DPSize d10 = T1.d();
            if (d10 == null || (a11 = d10.a()) == null) {
                i12 = viewGroup.getPaddingRight();
            } else {
                i12 = (int) b.a(a11.doubleValue());
            }
            StyleElements.DPSize a14 = T1.a();
            if (a14 == null || (a10 = a14.a()) == null) {
                i13 = viewGroup.getPaddingBottom();
            } else {
                i13 = (int) b.a(a10.doubleValue());
            }
            view.setPadding(i10, i11, i12, i13);
        }
        if (stepStyle != null) {
            dPSize = stepStyle.N();
        }
        viewGroup.setBackground(c(dPSize));
    }

    public static /* synthetic */ void b(ViewGroup viewGroup, StepStyle stepStyle, View view, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            view = viewGroup;
        }
        a(viewGroup, stepStyle, view);
    }

    private static final GradientDrawable c(StyleElements.DPSize dPSize) {
        double d10;
        Double a10;
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (dPSize == null || (a10 = dPSize.a()) == null) {
            d10 = 12.0d;
        } else {
            d10 = a10.doubleValue();
        }
        float a11 = (float) b.a(d10);
        gradientDrawable.setCornerRadii(new float[]{a11, a11, a11, a11, 0.0f, 0.0f, 0.0f, 0.0f});
        return gradientDrawable;
    }

    private static final void d(ViewGroup viewGroup, Drawable drawable) {
        Sequence i10 = SequencesKt___SequencesKt.i(ViewGroupKt.a(viewGroup), BottomSheetStylingKt$styleModalBackgroundImage$backgroundViews$1.f29236a);
        if (SequencesKt___SequencesKt.f(i10)) {
            ((View) SequencesKt___SequencesKt.l(i10)).setBackground(drawable);
            return;
        }
        Context context = viewGroup.getContext();
        j.f(context, IdentityHttpResponse.CONTEXT);
        a aVar = new a(context);
        aVar.setBackground(drawable);
        viewGroup.addView(aVar, 0);
        ViewGroup.LayoutParams layoutParams = aVar.getLayoutParams();
        if (layoutParams != null) {
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            bVar.height = 0;
            bVar.f4174t = viewGroup.getId();
            bVar.f4178v = viewGroup.getId();
            bVar.f4152i = viewGroup.getId();
            bVar.f4158l = viewGroup.getId();
            aVar.setLayoutParams(bVar);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }
}
