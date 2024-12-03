package com.withpersona.sdk2.inquiry.steps.ui.styling;

import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ProgressBar;
import cj.e;
import com.withpersona.sdk2.inquiry.shared.ui.k;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.a;
import kotlin.jvm.internal.j;
import ti.b;

public final class ButtonStylingKt {
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0098  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final android.graphics.drawable.GradientDrawable a(com.withpersona.sdk2.inquiry.steps.ui.network.styling.a r7, boolean r8, boolean r9) {
        /*
            android.graphics.drawable.GradientDrawable r0 = new android.graphics.drawable.GradientDrawable
            r0.<init>()
            r1 = 0
            r0.setShape(r1)
            java.lang.Double r2 = r7.o()
            if (r2 == 0) goto L_0x0019
            double r2 = r2.doubleValue()
            double r2 = ti.b.a(r2)
            int r2 = (int) r2
            goto L_0x001a
        L_0x0019:
            r2 = r1
        L_0x001a:
            if (r9 == 0) goto L_0x0027
            java.lang.String r3 = r7.d()
            if (r3 == 0) goto L_0x003f
            int r3 = android.graphics.Color.parseColor(r3)
            goto L_0x0040
        L_0x0027:
            if (r8 != 0) goto L_0x0034
            java.lang.String r3 = r7.q()
            if (r3 == 0) goto L_0x003f
            int r3 = android.graphics.Color.parseColor(r3)
            goto L_0x0040
        L_0x0034:
            java.lang.String r3 = r7.t()
            if (r3 == 0) goto L_0x003f
            int r3 = android.graphics.Color.parseColor(r3)
            goto L_0x0040
        L_0x003f:
            r3 = r1
        L_0x0040:
            r0.setStroke(r2, r3)
            java.lang.Double r2 = r7.g()
            r3 = 1
            if (r2 == 0) goto L_0x007b
            double r4 = r2.doubleValue()
            double r4 = ti.b.a(r4)
            float r2 = (float) r4
            android.graphics.drawable.Drawable r4 = r0.mutate()
            java.lang.String r5 = "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable"
            kotlin.jvm.internal.j.e(r4, r5)
            android.graphics.drawable.GradientDrawable r4 = (android.graphics.drawable.GradientDrawable) r4
            r5 = 8
            float[] r5 = new float[r5]
            r5[r1] = r2
            r5[r3] = r2
            r6 = 2
            r5[r6] = r2
            r6 = 3
            r5[r6] = r2
            r6 = 4
            r5[r6] = r2
            r6 = 5
            r5[r6] = r2
            r6 = 6
            r5[r6] = r2
            r6 = 7
            r5[r6] = r2
            r4.setCornerRadii(r5)
        L_0x007b:
            if (r9 == 0) goto L_0x0098
            android.content.res.ColorStateList r8 = new android.content.res.ColorStateList
            int[][] r9 = new int[r3][]
            int[] r2 = new int[r1]
            r9[r1] = r2
            int[] r2 = new int[r3]
            java.lang.String r7 = r7.a()
            int r7 = android.graphics.Color.parseColor(r7)
            r2[r1] = r7
            r8.<init>(r9, r2)
            r0.setColor(r8)
            goto L_0x00d3
        L_0x0098:
            if (r8 != 0) goto L_0x00b7
            java.lang.String r7 = r7.m()
            if (r7 == 0) goto L_0x00d3
            android.content.res.ColorStateList r8 = new android.content.res.ColorStateList
            int[][] r9 = new int[r3][]
            int[] r2 = new int[r1]
            r9[r1] = r2
            int[] r2 = new int[r3]
            int r7 = android.graphics.Color.parseColor(r7)
            r2[r1] = r7
            r8.<init>(r9, r2)
            r0.setColor(r8)
            goto L_0x00d3
        L_0x00b7:
            java.lang.String r7 = r7.h()
            if (r7 == 0) goto L_0x00d3
            android.content.res.ColorStateList r8 = new android.content.res.ColorStateList
            int[][] r9 = new int[r3][]
            int[] r2 = new int[r1]
            r9[r1] = r2
            int[] r2 = new int[r3]
            int r7 = android.graphics.Color.parseColor(r7)
            r2[r1] = r7
            r8.<init>(r9, r2)
            r0.setColor(r8)
        L_0x00d3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.styling.ButtonStylingKt.a(com.withpersona.sdk2.inquiry.steps.ui.network.styling.a, boolean, boolean):android.graphics.drawable.GradientDrawable");
    }

    public static final void b(Button button, a aVar, boolean z10, boolean z11) {
        View view;
        int i10;
        int i11;
        int i12;
        int i13;
        Double a10;
        Double a11;
        Double a12;
        Double a13;
        j.g(button, "<this>");
        j.g(aVar, "styles");
        if (!button.isEnabled()) {
            String r10 = aVar.r();
            if (r10 != null) {
                button.setTextColor(Color.parseColor(r10));
            }
        } else {
            String p10 = aVar.p();
            if (p10 != null) {
                button.setTextColor(Color.parseColor(p10));
            }
        }
        Double s10 = aVar.s();
        if (s10 != null) {
            button.setTextSize((float) s10.doubleValue());
        }
        Double l10 = aVar.l();
        if (l10 != null) {
            button.setLetterSpacing((float) (l10.doubleValue() / ((double) button.getTextSize())));
        }
        String w10 = aVar.w();
        if (w10 != null) {
            m.d(button, w10);
        }
        StyleElements.FontWeight c10 = aVar.c();
        if (c10 != null && Build.VERSION.SDK_INT >= 29) {
            m.b(button, c10);
        }
        Double i14 = aVar.i();
        if (i14 != null) {
            double doubleValue = i14.doubleValue();
            if (Build.VERSION.SDK_INT >= 28) {
                button.setLineHeight((int) b.a(doubleValue));
            }
        }
        button.setBackground(a(aVar, button.isEnabled(), z10));
        button.setBackgroundTintList((ColorStateList) null);
        button.setElevation(0.0f);
        button.setStateListAnimator((StateListAnimator) null);
        button.setAllCaps(false);
        ViewParent parent = button.getParent();
        if (parent instanceof cj.b) {
            view = (View) parent;
        } else {
            view = button;
        }
        StyleElements.DPSizeSet f10 = aVar.f();
        if (f10 != null) {
            e.c(button, f10);
            if (view instanceof cj.b) {
                cj.b bVar = (cj.b) view;
                ProgressBar progressBar = bVar.getProgressBar();
                StyleElements.DPSize c11 = f10.c();
                if (c11 == null || (a13 = c11.a()) == null) {
                    i10 = bVar.getProgressBar().getPaddingLeft();
                } else {
                    i10 = (int) b.a(a13.doubleValue());
                }
                StyleElements.DPSize e10 = f10.e();
                if (e10 == null || (a12 = e10.a()) == null) {
                    i11 = bVar.getProgressBar().getPaddingTop();
                } else {
                    i11 = (int) b.a(a12.doubleValue());
                }
                StyleElements.DPSize d10 = f10.d();
                if (d10 == null || (a11 = d10.a()) == null) {
                    i12 = bVar.getProgressBar().getPaddingRight();
                } else {
                    i12 = (int) b.a(a11.doubleValue());
                }
                StyleElements.DPSize a14 = f10.a();
                if (a14 == null || (a10 = a14.a()) == null) {
                    i13 = bVar.getProgressBar().getPaddingBottom();
                } else {
                    i13 = (int) b.a(a10.doubleValue());
                }
                progressBar.setPadding(i10, i11, i12, i13);
            }
        }
        StyleElements.DPSizeSet u10 = aVar.u();
        if (u10 != null) {
            e.e(button, u10);
        }
        k.b(button, new ButtonStylingKt$style$10(view, aVar, button, z11));
    }

    public static /* synthetic */ void c(Button button, a aVar, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            z11 = true;
        }
        b(button, aVar, z10, z11);
    }
}
