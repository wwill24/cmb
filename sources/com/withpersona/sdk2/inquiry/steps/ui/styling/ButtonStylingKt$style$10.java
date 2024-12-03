package com.withpersona.sdk2.inquiry.steps.ui.styling;

import android.view.View;
import android.widget.Button;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class ButtonStylingKt$style$10 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $shouldStyleWidthAndHeight;
    final /* synthetic */ com.withpersona.sdk2.inquiry.steps.ui.network.styling.a $styles;
    final /* synthetic */ Button $this_style;
    final /* synthetic */ View $viewToLayout;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29237a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$PositionType[] r0 = com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements.PositionType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$PositionType r1 = com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements.PositionType.START     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$PositionType r1 = com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements.PositionType.CENTER     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$PositionType r1 = com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements.PositionType.END     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f29237a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.styling.ButtonStylingKt$style$10.a.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ButtonStylingKt$style$10(View view, com.withpersona.sdk2.inquiry.steps.ui.network.styling.a aVar, Button button, boolean z10) {
        super(0);
        this.$viewToLayout = view;
        this.$styles = aVar;
        this.$this_style = button;
        this.$shouldStyleWidthAndHeight = z10;
    }

    /* JADX WARNING: type inference failed for: r3v5, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke() {
        /*
            r8 = this;
            android.view.View r0 = r8.$viewToLayout
            int r0 = r0.getMeasuredWidth()
            android.view.View r1 = r8.$viewToLayout
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.a r2 = r8.$styles
            android.widget.Button r3 = r8.$this_style
            boolean r4 = r8.$shouldStyleWidthAndHeight
            android.view.ViewGroup$LayoutParams r5 = r1.getLayoutParams()
            if (r5 == 0) goto L_0x009c
            java.lang.Double r6 = r2.j()
            if (r6 == 0) goto L_0x002b
            double r6 = r6.doubleValue()
            if (r4 == 0) goto L_0x002b
            double r6 = ti.b.a(r6)
            int r6 = (int) r6
            int r0 = vk.j.g(r6, r0)
            r5.width = r0
        L_0x002b:
            java.lang.Double r0 = r2.e()
            if (r0 == 0) goto L_0x003e
            double r6 = r0.doubleValue()
            if (r4 == 0) goto L_0x003e
            double r6 = ti.b.a(r6)
            int r0 = (int) r6
            r5.height = r0
        L_0x003e:
            boolean r0 = r1 instanceof cj.b
            if (r0 == 0) goto L_0x006b
            int r0 = r5.height
            android.view.ViewGroup$LayoutParams r4 = r3.getLayoutParams()
            boolean r6 = r4 instanceof android.view.ViewGroup.MarginLayoutParams
            r7 = 0
            if (r6 == 0) goto L_0x0050
            android.view.ViewGroup$MarginLayoutParams r4 = (android.view.ViewGroup.MarginLayoutParams) r4
            goto L_0x0051
        L_0x0050:
            r4 = r7
        L_0x0051:
            r6 = 0
            if (r4 == 0) goto L_0x0057
            int r4 = r4.topMargin
            goto L_0x0058
        L_0x0057:
            r4 = r6
        L_0x0058:
            int r0 = r0 + r4
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            boolean r4 = r3 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r4 == 0) goto L_0x0064
            r7 = r3
            android.view.ViewGroup$MarginLayoutParams r7 = (android.view.ViewGroup.MarginLayoutParams) r7
        L_0x0064:
            if (r7 == 0) goto L_0x0068
            int r6 = r7.bottomMargin
        L_0x0068:
            int r0 = r0 + r6
            r5.height = r0
        L_0x006b:
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$PositionType r0 = r2.k()
            if (r0 == 0) goto L_0x0098
            boolean r2 = r5 instanceof androidx.constraintlayout.widget.ConstraintLayout.b
            if (r2 == 0) goto L_0x0098
            r2 = r5
            androidx.constraintlayout.widget.ConstraintLayout$b r2 = (androidx.constraintlayout.widget.ConstraintLayout.b) r2
            int[] r3 = com.withpersona.sdk2.inquiry.steps.ui.styling.ButtonStylingKt$style$10.a.f29237a
            int r0 = r0.ordinal()
            r0 = r3[r0]
            r3 = 1
            if (r0 == r3) goto L_0x0095
            r3 = 2
            if (r0 == r3) goto L_0x0092
            r3 = 3
            if (r0 != r3) goto L_0x008c
            r0 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0096
        L_0x008c:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x0092:
            r0 = 1056964608(0x3f000000, float:0.5)
            goto L_0x0096
        L_0x0095:
            r0 = 0
        L_0x0096:
            r2.G = r0
        L_0x0098:
            r1.setLayoutParams(r5)
            return
        L_0x009c:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.styling.ButtonStylingKt$style$10.invoke():void");
    }
}
