package com.withpersona.sdk2.inquiry.steps.ui.styling;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.ViewGroup;
import android.widget.EditText;
import cj.e;
import com.google.android.material.textfield.TextInputLayout;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import ti.b;

public final class c {
    private static final void a(TextInputLayout textInputLayout, int i10) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        GradientDrawable gradientDrawable = new GradientDrawable();
        int i11 = 0;
        gradientDrawable.setShape(0);
        gradientDrawable.setStroke(i10, textInputLayout.getBoxStrokeColor());
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable});
        int i12 = -i10;
        ViewGroup.LayoutParams layoutParams = textInputLayout.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            i11 = marginLayoutParams.bottomMargin;
        }
        layerDrawable.setLayerInset(0, i12, i12, i12, i11);
        textInputLayout.setBackground(layerDrawable);
    }

    public static final void b(TextInputLayout textInputLayout, UiComponent.InputSelectComponentStyle inputSelectComponentStyle) {
        double d10;
        double d11;
        TextInputLayout textInputLayout2 = textInputLayout;
        j.g(textInputLayout2, "<this>");
        j.g(inputSelectComponentStyle, "styles");
        String V1 = inputSelectComponentStyle.V1();
        if (V1 != null) {
            textInputLayout2.setBoxBackgroundColor(Color.parseColor(V1));
        }
        String d12 = inputSelectComponentStyle.d();
        if (d12 != null) {
            textInputLayout2.setBoxStrokeColorStateList(new ColorStateList(new int[][]{new int[]{16842914}, new int[]{16842908}, new int[]{-16842908}, new int[]{16843623}, new int[]{16842910}, new int[]{-16842910}}, new int[]{Color.parseColor(d12), Color.parseColor(d12), Color.parseColor(d12), Color.parseColor(d12), Color.parseColor(d12), Color.parseColor(d12)}));
        }
        Double z10 = inputSelectComponentStyle.z();
        if (z10 != null) {
            double doubleValue = z10.doubleValue();
            textInputLayout2.setBoxStrokeWidth((int) Math.ceil(b.a(doubleValue)));
            textInputLayout2.setBoxStrokeWidthFocused((int) Math.ceil(b.a(doubleValue)));
        }
        if (textInputLayout.getBoxStrokeWidth() == 0) {
            Double h10 = inputSelectComponentStyle.h();
            if (h10 != null) {
                d10 = h10.doubleValue();
            } else {
                d10 = 0.0d;
            }
            if (d10 > 0.0d) {
                Double h11 = inputSelectComponentStyle.h();
                if (h11 != null) {
                    d11 = b.a(h11.doubleValue());
                } else {
                    d11 = 0.0d;
                }
                a(textInputLayout2, (int) Math.ceil(d11));
            }
        }
        String i10 = inputSelectComponentStyle.i();
        if (i10 != null) {
            textInputLayout2.setEndIconTintList(new ColorStateList(new int[][]{new int[]{16842914}, new int[]{16842908}, new int[]{-16842908}, new int[]{16843623}, new int[]{16842910}, new int[]{-16842910}}, new int[]{Color.parseColor(i10), Color.parseColor(i10), Color.parseColor(i10), Color.parseColor(i10), Color.parseColor(i10), Color.parseColor(i10)}));
        }
        Double f10 = inputSelectComponentStyle.f();
        if (f10 != null) {
            double doubleValue2 = f10.doubleValue();
            textInputLayout2.Y((float) b.a(doubleValue2), (float) b.a(doubleValue2), (float) b.a(doubleValue2), (float) b.a(doubleValue2));
        }
        StyleElements.DPSizeSet o10 = inputSelectComponentStyle.o();
        if (o10 != null) {
            e.c(textInputLayout2, o10);
        }
        EditText editText = textInputLayout.getEditText();
        if (editText != null) {
            m.e(editText, inputSelectComponentStyle.w());
        }
        EditText editText2 = textInputLayout.getEditText();
        if (editText2 != null) {
            e.c(editText2, new StyleElements.DPSizeSet(new StyleElements.DPSize(Double.valueOf(0.0d)), new StyleElements.DPSize(Double.valueOf(0.0d)), new StyleElements.DPSize(Double.valueOf(0.0d)), new StyleElements.DPSize(Double.valueOf(0.0d))));
        }
    }
}
