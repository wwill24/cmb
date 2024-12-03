package com.withpersona.sdk2.inquiry.steps.ui.styling;

import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.EditText;
import cj.e;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputLayout;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.j;
import ti.b;

public final class TextInputLayoutStylingKt {
    /* access modifiers changed from: private */
    public static final void h(TextInputLayout textInputLayout, boolean z10, int i10, int i11, int i12) {
        if (z10) {
            textInputLayout.setBoxBackgroundColor(i11);
        } else if (textInputLayout.isEnabled()) {
            textInputLayout.setBoxBackgroundColor(i10);
        } else {
            textInputLayout.setBoxBackgroundColor(i12);
        }
    }

    private static final void i(TextInputLayout textInputLayout, int i10) {
        Drawable drawable;
        if (Build.VERSION.SDK_INT >= 29) {
            EditText editText = textInputLayout.getEditText();
            if (editText != null) {
                drawable = editText.getTextCursorDrawable();
            } else {
                drawable = null;
            }
            if (drawable != null) {
                drawable.setColorFilter(new BlendModeColorFilter(i10, BlendMode.SRC_ATOP));
            }
        }
    }

    public static final void j(TextInputLayout textInputLayout, UiComponent.InputTextBasedComponentStyle inputTextBasedComponentStyle) {
        MaterialAutoCompleteTextView materialAutoCompleteTextView;
        String x10;
        Double f02;
        EditText editText;
        EditText editText2;
        Typeface typeface;
        float f10;
        TextInputLayout textInputLayout2 = textInputLayout;
        j.g(textInputLayout2, "<this>");
        j.g(inputTextBasedComponentStyle, "styles");
        String d10 = inputTextBasedComponentStyle.d();
        if (d10 != null) {
            int parseColor = Color.parseColor(d10);
            String z10 = inputTextBasedComponentStyle.z();
            if (z10 == null) {
                z10 = d10;
            }
            int parseColor2 = Color.parseColor(z10);
            String n10 = inputTextBasedComponentStyle.n();
            if (n10 == null) {
                n10 = d10;
            }
            textInputLayout2.setBoxStrokeColorStateList(new ColorStateList(new int[][]{new int[]{16842914}, new int[]{16842908}, new int[]{-16842910}}, new int[]{parseColor, parseColor2, Color.parseColor(n10)}));
            String r10 = inputTextBasedComponentStyle.r();
            if (r10 != null) {
                d10 = r10;
            }
            int parseColor3 = Color.parseColor(d10);
            textInputLayout2.setBoxStrokeErrorColor(new ColorStateList(new int[][]{new int[]{16842914}, new int[]{16842908}, new int[]{-16842910}}, new int[]{parseColor3, parseColor3, parseColor3}));
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        String c10 = inputTextBasedComponentStyle.c();
        if (c10 != null) {
            int parseColor4 = Color.parseColor(c10);
            String x11 = inputTextBasedComponentStyle.x();
            if (x11 == null) {
                x11 = c10;
            }
            int parseColor5 = Color.parseColor(x11);
            String m10 = inputTextBasedComponentStyle.m();
            if (m10 == null) {
                m10 = c10;
            }
            int parseColor6 = Color.parseColor(m10);
            String p10 = inputTextBasedComponentStyle.p();
            if (p10 != null) {
                c10 = p10;
            }
            int parseColor7 = Color.parseColor(c10);
            textInputLayout2.setBoxBackgroundMode(2);
            h(textInputLayout2, textInputLayout.hasFocus(), parseColor4, parseColor5, parseColor6);
            ref$ObjectRef.element = new TextInputLayoutStylingKt$style$2$1(textInputLayout2, parseColor4, parseColor5, parseColor6);
            f fVar = r0;
            f fVar2 = new f(textInputLayout, parseColor7, parseColor4, parseColor5, parseColor6);
            textInputLayout2.addOnLayoutChangeListener(fVar);
        }
        Double l10 = inputTextBasedComponentStyle.l();
        if (l10 != null) {
            double doubleValue = l10.doubleValue();
            textInputLayout2.setBoxStrokeWidth((int) Math.ceil(b.a(doubleValue)));
            textInputLayout2.setBoxStrokeWidthFocused((int) Math.ceil(b.a(doubleValue)));
        }
        Double j10 = inputTextBasedComponentStyle.j();
        if (j10 != null) {
            double doubleValue2 = j10.doubleValue();
            textInputLayout2.Y((float) b.a(doubleValue2), (float) b.a(doubleValue2), (float) b.a(doubleValue2), (float) b.a(doubleValue2));
        }
        Double c02 = inputTextBasedComponentStyle.c0();
        if (c02 != null) {
            double doubleValue3 = c02.doubleValue();
            EditText editText3 = textInputLayout.getEditText();
            if (editText3 != null) {
                editText3.setTextSize((float) doubleValue3);
            }
        }
        Double e02 = inputTextBasedComponentStyle.e0();
        if (e02 != null) {
            double doubleValue4 = e02.doubleValue();
            EditText editText4 = textInputLayout.getEditText();
            if (editText4 != null) {
                f10 = editText4.getTextSize();
            } else {
                f10 = 12.0f;
            }
            double d11 = doubleValue4 / ((double) f10);
            EditText editText5 = textInputLayout.getEditText();
            if (editText5 != null) {
                editText5.setLetterSpacing((float) d11);
            }
        }
        String e10 = inputTextBasedComponentStyle.e();
        if (e10 != null) {
            EditText editText6 = textInputLayout.getEditText();
            if (editText6 != null) {
                j.f(editText6, "editText");
                m.d(editText6, e10);
            }
            EditText editText7 = textInputLayout.getEditText();
            if (editText7 != null) {
                typeface = editText7.getTypeface();
            } else {
                typeface = null;
            }
            textInputLayout2.setTypeface(typeface);
        }
        String b02 = inputTextBasedComponentStyle.b0();
        if (!(b02 == null || (editText2 = textInputLayout.getEditText()) == null)) {
            j.f(editText2, "editText");
            m.d(editText2, b02);
        }
        StyleElements.FontWeight d02 = inputTextBasedComponentStyle.d0();
        if (!(d02 == null || Build.VERSION.SDK_INT < 29 || (editText = textInputLayout.getEditText()) == null)) {
            j.f(editText, "editText");
            m.b(editText, d02);
        }
        if (Build.VERSION.SDK_INT >= 28 && (f02 = inputTextBasedComponentStyle.f0()) != null) {
            double doubleValue5 = f02.doubleValue();
            EditText editText8 = textInputLayout.getEditText();
            if (editText8 != null) {
                editText8.setLineHeight((int) b.a(doubleValue5));
            }
        }
        String X = inputTextBasedComponentStyle.X();
        if (X != null) {
            int parseColor8 = Color.parseColor(X);
            String a02 = inputTextBasedComponentStyle.a0();
            if (a02 == null) {
                a02 = X;
            }
            int parseColor9 = Color.parseColor(a02);
            String Y = inputTextBasedComponentStyle.Y();
            if (Y == null) {
                Y = X;
            }
            int parseColor10 = Color.parseColor(Y);
            String Z = inputTextBasedComponentStyle.Z();
            if (Z != null) {
                X = Z;
            }
            int parseColor11 = Color.parseColor(X);
            ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{16842914}, new int[]{16842908}, new int[]{-16842910}, new int[]{-16842914}}, new int[]{parseColor8, parseColor9, parseColor10, parseColor8});
            EditText editText9 = textInputLayout.getEditText();
            if (editText9 != null) {
                editText9.setTextColor(colorStateList);
            }
            i(textInputLayout2, parseColor9);
            textInputLayout2.addOnLayoutChangeListener(new g(textInputLayout2, parseColor11, colorStateList, parseColor9));
        }
        String q10 = inputTextBasedComponentStyle.q();
        if (q10 != null) {
            String t10 = inputTextBasedComponentStyle.t();
            if (t10 == null) {
                t10 = q10;
            }
            int parseColor12 = Color.parseColor(t10);
            String u10 = inputTextBasedComponentStyle.u();
            if (u10 == null) {
                u10 = q10;
            }
            int parseColor13 = Color.parseColor(u10);
            String s10 = inputTextBasedComponentStyle.s();
            if (s10 != null) {
                q10 = s10;
            }
            textInputLayout2.setErrorTextColor(new ColorStateList(new int[][]{new int[]{16842914}, new int[]{16842908}, new int[]{-16842910}, new int[]{-16842914}}, new int[]{parseColor12, parseColor13, Color.parseColor(q10), parseColor12}));
        }
        String H = inputTextBasedComponentStyle.H();
        if (H != null) {
            int parseColor14 = Color.parseColor(H);
            String L = inputTextBasedComponentStyle.L();
            if (L == null) {
                L = H;
            }
            int parseColor15 = Color.parseColor(L);
            String I = inputTextBasedComponentStyle.I();
            if (I == null) {
                I = H;
            }
            int parseColor16 = Color.parseColor(I);
            String K = inputTextBasedComponentStyle.K();
            if (K != null) {
                H = K;
            }
            int parseColor17 = Color.parseColor(H);
            ColorStateList colorStateList2 = new ColorStateList(new int[][]{new int[]{16842914}, new int[]{16842908}, new int[]{-16842910}, new int[]{-16842914}}, new int[]{parseColor14, parseColor15, parseColor16, parseColor14});
            ColorStateList colorStateList3 = new ColorStateList(new int[][]{new int[]{16842914}, new int[]{16842908}, new int[]{-16842910}, new int[]{-16842914}}, new int[]{parseColor17, parseColor17, parseColor17, parseColor17});
            textInputLayout2.setDefaultHintTextColor(colorStateList2);
            textInputLayout2.addOnLayoutChangeListener(new h(textInputLayout2, colorStateList3, colorStateList2));
            EditText editText10 = textInputLayout.getEditText();
            if (editText10 instanceof MaterialAutoCompleteTextView) {
                materialAutoCompleteTextView = (MaterialAutoCompleteTextView) editText10;
            } else {
                materialAutoCompleteTextView = null;
            }
            if (!(materialAutoCompleteTextView == null || (x10 = inputTextBasedComponentStyle.x()) == null)) {
                materialAutoCompleteTextView.setDropDownBackgroundDrawable(new ColorDrawable(Color.parseColor(x10)));
            }
            StyleElements.DPSizeSet G = inputTextBasedComponentStyle.G();
            if (G != null) {
                e.c(textInputLayout2, G);
            }
        }
        String R = inputTextBasedComponentStyle.R();
        if (R != null) {
            String T = inputTextBasedComponentStyle.T();
            if (T == null) {
                T = R;
            }
            int parseColor18 = Color.parseColor(T);
            String S = inputTextBasedComponentStyle.S();
            if (S != null) {
                R = S;
            }
            int parseColor19 = Color.parseColor(R);
            ColorStateList colorStateList4 = new ColorStateList(new int[][]{new int[]{16842914}, new int[]{16842908}, new int[]{-16842910}, new int[]{-16842914}}, new int[]{parseColor18, parseColor18, parseColor18, parseColor18});
            ColorStateList colorStateList5 = new ColorStateList(new int[][]{new int[]{16842914}, new int[]{16842908}, new int[]{-16842910}, new int[]{-16842914}}, new int[]{parseColor19, parseColor19, parseColor19, parseColor19});
            textInputLayout2.setPlaceholderTextColor(colorStateList4);
            textInputLayout2.addOnLayoutChangeListener(new i(textInputLayout2, colorStateList5, colorStateList4));
        }
        EditText editText11 = textInputLayout.getEditText();
        if (editText11 != null) {
            editText11.setOnFocusChangeListener(new j(textInputLayout2, ref$ObjectRef));
        }
        String g10 = inputTextBasedComponentStyle.g();
        if (g10 != null) {
            int parseColor20 = Color.parseColor(g10);
            String A = inputTextBasedComponentStyle.A();
            if (A == null) {
                A = g10;
            }
            int parseColor21 = Color.parseColor(A);
            String o10 = inputTextBasedComponentStyle.o();
            if (o10 != null) {
                g10 = o10;
            }
            textInputLayout2.setEndIconTintList(new ColorStateList(new int[][]{new int[]{16842914}, new int[]{16842908}, new int[]{-16842910}, new int[]{-16842914}}, new int[]{parseColor20, parseColor21, Color.parseColor(g10), parseColor20}));
        }
    }

    /* access modifiers changed from: private */
    public static final void k(TextInputLayout textInputLayout, int i10, ColorStateList colorStateList, int i11, View view, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
        j.g(textInputLayout, "$this_style");
        j.g(colorStateList, "$colorState");
        CharSequence error = textInputLayout.getError();
        boolean z10 = true;
        if (error == null || !t.a1(error)) {
            z10 = false;
        }
        if (z10) {
            EditText editText = textInputLayout.getEditText();
            if (editText != null) {
                editText.setTextColor(i10);
            }
            i(textInputLayout, i10);
            return;
        }
        EditText editText2 = textInputLayout.getEditText();
        if (editText2 != null) {
            editText2.setTextColor(colorStateList);
        }
        i(textInputLayout, i11);
    }

    /* access modifiers changed from: private */
    public static final void l(TextInputLayout textInputLayout, ColorStateList colorStateList, ColorStateList colorStateList2, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        j.g(textInputLayout, "$this_style");
        j.g(colorStateList, "$errorColorState");
        j.g(colorStateList2, "$colorState");
        CharSequence error = textInputLayout.getError();
        boolean z10 = true;
        if (error == null || !t.a1(error)) {
            z10 = false;
        }
        if (z10) {
            textInputLayout.setDefaultHintTextColor(colorStateList);
        } else {
            textInputLayout.setDefaultHintTextColor(colorStateList2);
        }
    }

    /* access modifiers changed from: private */
    public static final void m(TextInputLayout textInputLayout, int i10, int i11, int i12, int i13, View view, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21) {
        j.g(textInputLayout, "$this_style");
        CharSequence error = textInputLayout.getError();
        boolean z10 = true;
        if (error == null || !t.a1(error)) {
            z10 = false;
        }
        if (z10) {
            textInputLayout.setBoxBackgroundColor(i10);
        } else {
            h(textInputLayout, textInputLayout.hasFocus(), i11, i12, i13);
        }
    }

    /* access modifiers changed from: private */
    public static final void n(TextInputLayout textInputLayout, ColorStateList colorStateList, ColorStateList colorStateList2, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        j.g(textInputLayout, "$this_style");
        j.g(colorStateList, "$errorColorState");
        j.g(colorStateList2, "$colorState");
        CharSequence error = textInputLayout.getError();
        boolean z10 = true;
        if (error == null || !t.a1(error)) {
            z10 = false;
        }
        if (z10) {
            textInputLayout.setPlaceholderTextColor(colorStateList);
        } else {
            textInputLayout.setPlaceholderTextColor(colorStateList2);
        }
    }

    /* access modifiers changed from: private */
    public static final void o(TextInputLayout textInputLayout, Ref$ObjectRef ref$ObjectRef, View view, boolean z10) {
        j.g(textInputLayout, "$this_style");
        j.g(ref$ObjectRef, "$onFocusBackgroundChange");
        textInputLayout.post(new k(ref$ObjectRef, z10));
    }

    /* access modifiers changed from: private */
    public static final void p(Ref$ObjectRef ref$ObjectRef, boolean z10) {
        j.g(ref$ObjectRef, "$onFocusBackgroundChange");
        Function1 function1 = (Function1) ref$ObjectRef.element;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z10));
        }
    }
}
