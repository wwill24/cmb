package cj;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.common.api.a;
import com.google.android.material.textfield.TextInputLayout;
import com.mparticle.identity.IdentityHttpResponse;
import com.withpersona.sdk2.inquiry.steps.ui.components.n;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.TextBasedComponentStyle;
import kotlin.jvm.internal.j;
import ti.b;

public final class e {
    public static final void a(View view, StyleElements.Size size) {
        j.g(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            if (size instanceof StyleElements.DPSize) {
                Double a10 = ((StyleElements.DPSize) size).a();
                if (a10 != null) {
                    layoutParams.height = (int) b.a(a10.doubleValue());
                } else {
                    return;
                }
            } else if (size instanceof StyleElements.Size.PercentSize) {
                ViewParent parent = view.getParent();
                if (layoutParams instanceof ConstraintLayout.b) {
                    ((ConstraintLayout.b) layoutParams).W = (float) ((StyleElements.Size.PercentSize) size).a();
                } else if (parent instanceof View) {
                    layoutParams.height = (int) (((StyleElements.Size.PercentSize) size).a() * ((double) ((View) parent).getHeight()));
                }
            }
            view.setLayoutParams(layoutParams);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public static final void b(View view, StyleElements.Size size) {
        View view2;
        int i10;
        j.g(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                view2 = (View) parent;
            } else {
                view2 = null;
            }
            if (size instanceof StyleElements.DPSize) {
                Double a10 = ((StyleElements.DPSize) size).a();
                if (a10 != null) {
                    int a11 = (int) b.a(a10.doubleValue());
                    if (view2 != null) {
                        i10 = view2.getWidth();
                    } else {
                        i10 = a.e.API_PRIORITY_OTHER;
                    }
                    layoutParams.width = j.g(a11, i10);
                } else {
                    return;
                }
            } else if (size instanceof StyleElements.Size.PercentSize) {
                if (layoutParams instanceof ConstraintLayout.b) {
                    ((ConstraintLayout.b) layoutParams).V = (float) ((StyleElements.Size.PercentSize) size).a();
                } else if (view2 != null) {
                    layoutParams.width = (int) (((StyleElements.Size.PercentSize) size).a() * ((double) view2.getWidth()));
                }
            }
            view.setLayoutParams(layoutParams);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public static final void c(View view, StyleElements.DPSizeSet dPSizeSet) {
        int i10;
        int i11;
        int i12;
        int i13;
        Double a10;
        Double a11;
        Double a12;
        Double a13;
        j.g(view, "<this>");
        j.g(dPSizeSet, "margins");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                StyleElements.DPSize c10 = dPSizeSet.c();
                if (c10 == null || (a13 = c10.a()) == null) {
                    i10 = marginLayoutParams.leftMargin;
                } else {
                    i10 = (int) b.a(a13.doubleValue());
                }
                marginLayoutParams.leftMargin = i10;
                StyleElements.DPSize d10 = dPSizeSet.d();
                if (d10 == null || (a12 = d10.a()) == null) {
                    i11 = marginLayoutParams.rightMargin;
                } else {
                    i11 = (int) b.a(a12.doubleValue());
                }
                marginLayoutParams.rightMargin = i11;
                StyleElements.DPSize e10 = dPSizeSet.e();
                if (e10 == null || (a11 = e10.a()) == null) {
                    i12 = marginLayoutParams.topMargin;
                } else {
                    i12 = (int) b.a(a11.doubleValue());
                }
                marginLayoutParams.topMargin = i12;
                StyleElements.DPSize a14 = dPSizeSet.a();
                if (a14 == null || (a10 = a14.a()) == null) {
                    i13 = marginLayoutParams.bottomMargin;
                } else {
                    i13 = (int) b.a(a10.doubleValue());
                }
                marginLayoutParams.bottomMargin = i13;
            }
            view.setLayoutParams(layoutParams);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public static final void d(TextInputLayout textInputLayout, String str, TextBasedComponentStyle textBasedComponentStyle) {
        boolean z10;
        j.g(textInputLayout, "<this>");
        if (str == null || r.w(str)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            textInputLayout.setErrorEnabled(false);
            return;
        }
        textInputLayout.setError(str);
        if (textBasedComponentStyle != null) {
            SpannableString spannableString = new SpannableString(textInputLayout.getError());
            String c10 = textBasedComponentStyle.c();
            if (c10 != null) {
                Context context = textInputLayout.getContext();
                j.f(context, IdentityHttpResponse.CONTEXT);
                Typeface a10 = n.a(context, c10);
                if (a10 != null) {
                    spannableString.setSpan(new d(a10), 0, spannableString.length(), 33);
                }
            }
            Double e10 = textBasedComponentStyle.e();
            if (e10 != null) {
                spannableString.setSpan(new AbsoluteSizeSpan((int) b.a(e10.doubleValue())), 0, spannableString.length(), 33);
            }
            textInputLayout.setError(spannableString);
        }
    }

    public static final void e(View view, StyleElements.DPSizeSet dPSizeSet) {
        int i10;
        int i11;
        int i12;
        int i13;
        Double a10;
        Double a11;
        Double a12;
        Double a13;
        j.g(view, "<this>");
        j.g(dPSizeSet, "padding");
        StyleElements.DPSize c10 = dPSizeSet.c();
        if (c10 == null || (a13 = c10.a()) == null) {
            i10 = view.getPaddingLeft();
        } else {
            i10 = (int) b.a(a13.doubleValue());
        }
        StyleElements.DPSize e10 = dPSizeSet.e();
        if (e10 == null || (a12 = e10.a()) == null) {
            i11 = view.getPaddingTop();
        } else {
            i11 = (int) b.a(a12.doubleValue());
        }
        StyleElements.DPSize d10 = dPSizeSet.d();
        if (d10 == null || (a11 = d10.a()) == null) {
            i12 = view.getPaddingRight();
        } else {
            i12 = (int) b.a(a11.doubleValue());
        }
        StyleElements.DPSize a14 = dPSizeSet.a();
        if (a14 == null || (a10 = a14.a()) == null) {
            i13 = view.getPaddingBottom();
        } else {
            i13 = (int) b.a(a10.doubleValue());
        }
        view.setPadding(i10, i11, i12, i13);
    }
}
