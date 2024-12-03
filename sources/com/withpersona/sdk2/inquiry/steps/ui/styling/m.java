package com.withpersona.sdk2.inquiry.steps.ui.styling;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.widget.TextView;
import androidx.core.widget.l;
import cj.e;
import com.google.firebase.perf.util.Constants;
import com.leanplum.messagetemplates.MessageTemplateConstants;
import com.mparticle.identity.IdentityHttpResponse;
import com.withpersona.sdk2.inquiry.steps.ui.components.n;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.TextBasedComponentStyle;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.j;
import ti.b;

public final class m {

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29264a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f29265b;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|(2:13|14)|15|17|18|19|20|(2:21|22)|23|25) */
        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|17|18|19|20|21|22|23|25) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x002b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0045 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004d */
        static {
            /*
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$FontWeight[] r0 = com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements.FontWeight.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$FontWeight r2 = com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements.FontWeight.LIGHT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$FontWeight r3 = com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements.FontWeight.NORMAL     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$FontWeight r4 = com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements.FontWeight.MEDIUM     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$FontWeight r4 = com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements.FontWeight.BOLD     // Catch:{ NoSuchFieldError -> 0x002b }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r5 = 4
                r0[r4] = r5     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$FontWeight r4 = com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements.FontWeight.HEAVY     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r5 = 5
                r0[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                f29264a = r0
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$PositionType[] r0 = com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements.PositionType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$PositionType r4 = com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements.PositionType.START     // Catch:{ NoSuchFieldError -> 0x0045 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0045 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0045 }
            L_0x0045:
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$PositionType r1 = com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements.PositionType.CENTER     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$PositionType r1 = com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements.PositionType.END     // Catch:{ NoSuchFieldError -> 0x0055 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0055 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0055 }
            L_0x0055:
                f29265b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.styling.m.a.<clinit>():void");
        }
    }

    private static final int a(StyleElements.FontWeight fontWeight) {
        int i10 = a.f29264a[fontWeight.ordinal()];
        if (i10 == 1) {
            return MessageTemplateConstants.Values.CENTER_POPUP_WIDTH;
        }
        if (i10 == 2) {
            return 400;
        }
        if (i10 == 3) {
            return 500;
        }
        if (i10 == 4) {
            return Constants.FROZEN_FRAME_TIME;
        }
        if (i10 == 5) {
            return 800;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final void b(TextView textView, StyleElements.FontWeight fontWeight) {
        j.g(textView, "<this>");
        j.g(fontWeight, "fontWeight");
        Typeface a10 = Typeface.create(textView.getTypeface(), a(fontWeight), false);
        j.f(a10, "create(typeface, weight, false)");
        textView.setTypeface(a10);
    }

    public static final void c(TextView textView, StyleElements.PositionType positionType) {
        j.g(textView, "<this>");
        j.g(positionType, "justification");
        int gravity = textView.getGravity() & 112;
        int i10 = a.f29265b[positionType.ordinal()];
        int i11 = 1;
        if (i10 == 1) {
            i11 = 8388611;
        } else if (i10 != 2) {
            if (i10 == 3) {
                i11 = 8388613;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        textView.setGravity(i11);
        textView.setGravity((textView.getGravity() & -113) | gravity);
    }

    public static final void d(TextView textView, String str) {
        j.g(textView, "<this>");
        j.g(str, "fontName");
        Context context = textView.getContext();
        j.f(context, IdentityHttpResponse.CONTEXT);
        Typeface a10 = n.a(context, str);
        if (a10 != null) {
            textView.setTypeface(a10);
        }
    }

    public static final void e(TextView textView, TextBasedComponentStyle textBasedComponentStyle) {
        j.g(textView, "<this>");
        j.g(textBasedComponentStyle, "styles");
        StyleElements.DPSizeSet o10 = textBasedComponentStyle.o();
        if (o10 != null) {
            e.c(textView, o10);
        }
        String s10 = textBasedComponentStyle.s();
        if (s10 != null) {
            textView.setTextColor(Color.parseColor(s10));
        }
        String r10 = textBasedComponentStyle.r();
        if (r10 != null) {
            textView.setLinkTextColor(Color.parseColor(r10));
        }
        Double e10 = textBasedComponentStyle.e();
        if (e10 != null) {
            double doubleValue = e10.doubleValue();
            textView.setTextSize((float) doubleValue);
            int i10 = 1;
            if (l.c(textView) == 1) {
                int a10 = l.a(textView);
                int b10 = l.b(textView);
                int d10 = (int) b.d(doubleValue);
                if (a10 <= 0) {
                    a10 = (int) b.d(12.0d);
                }
                if (b10 > 0) {
                    i10 = b10;
                }
                if (a10 > d10) {
                    a10 = d10;
                }
                l.k(textView, a10, d10, i10, 0);
            }
        }
        Double k10 = textBasedComponentStyle.k();
        if (k10 != null) {
            textView.setLetterSpacing((float) (k10.doubleValue() / ((double) textView.getTextSize())));
        }
        String c10 = textBasedComponentStyle.c();
        if (c10 != null) {
            d(textView, c10);
        }
        StyleElements.FontWeight g10 = textBasedComponentStyle.g();
        if (g10 != null && Build.VERSION.SDK_INT >= 29) {
            b(textView, g10);
        }
        StyleElements.PositionType h10 = textBasedComponentStyle.h();
        if (h10 != null) {
            c(textView, h10);
        }
        Double m10 = textBasedComponentStyle.m();
        if (m10 != null) {
            double doubleValue2 = m10.doubleValue();
            if (Build.VERSION.SDK_INT >= 28) {
                textView.setLineHeight((int) b.a(doubleValue2));
            }
        }
    }
}
