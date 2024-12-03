package com.withpersona.sdk2.inquiry.steps.ui.styling;

import androidx.constraintlayout.widget.ConstraintLayout;
import cj.e;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import ti.b;

public final class d {

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29244a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.withpersona.sdk2.inquiry.steps.ui.styling.StackState[] r0 = com.withpersona.sdk2.inquiry.steps.ui.styling.StackState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.withpersona.sdk2.inquiry.steps.ui.styling.StackState r1 = com.withpersona.sdk2.inquiry.steps.ui.styling.StackState.BASE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.withpersona.sdk2.inquiry.steps.ui.styling.StackState r1 = com.withpersona.sdk2.inquiry.steps.ui.styling.StackState.ACTIVE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.withpersona.sdk2.inquiry.steps.ui.styling.StackState r1 = com.withpersona.sdk2.inquiry.steps.ui.styling.StackState.DISABLED     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f29244a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.styling.d.a.<clinit>():void");
        }
    }

    public static final void a(ConstraintLayout constraintLayout, UiComponent.ClickableStackComponentStyle clickableStackComponentStyle) {
        j.g(constraintLayout, "<this>");
        if (clickableStackComponentStyle != null) {
            e(constraintLayout, clickableStackComponentStyle);
            constraintLayout.setBackground(g(clickableStackComponentStyle, StackState.ACTIVE));
        }
    }

    public static final void b(ConstraintLayout constraintLayout, UiComponent.ClickableStackComponentStyle clickableStackComponentStyle) {
        j.g(constraintLayout, "<this>");
        j.g(clickableStackComponentStyle, "styles");
        e(constraintLayout, clickableStackComponentStyle);
        constraintLayout.setBackground(g(clickableStackComponentStyle, StackState.BASE));
    }

    public static final void c(ConstraintLayout constraintLayout, UiComponent.HorizontalStackComponentStyle horizontalStackComponentStyle) {
        j.g(constraintLayout, "<this>");
        j.g(horizontalStackComponentStyle, "styles");
        f(constraintLayout, horizontalStackComponentStyle);
        constraintLayout.setBackground(h(horizontalStackComponentStyle));
    }

    public static final void d(ConstraintLayout constraintLayout, UiComponent.ClickableStackComponentStyle clickableStackComponentStyle) {
        j.g(constraintLayout, "<this>");
        if (clickableStackComponentStyle != null) {
            e(constraintLayout, clickableStackComponentStyle);
            constraintLayout.setBackground(g(clickableStackComponentStyle, StackState.DISABLED));
        }
    }

    private static final void e(ConstraintLayout constraintLayout, UiComponent.ClickableStackComponentStyle clickableStackComponentStyle) {
        int i10;
        int i11;
        int i12;
        int i13;
        Double a10;
        Double a11;
        Double a12;
        Double a13;
        StyleElements.DPSizeSet x10 = clickableStackComponentStyle.x();
        if (x10 != null) {
            e.c(constraintLayout, x10);
        }
        StyleElements.DPSizeSet A = clickableStackComponentStyle.A();
        if (A != null) {
            StyleElements.DPSize c10 = A.c();
            if (c10 == null || (a13 = c10.a()) == null) {
                i10 = constraintLayout.getPaddingLeft();
            } else {
                i10 = (int) b.a(a13.doubleValue());
            }
            StyleElements.DPSize e10 = A.e();
            if (e10 == null || (a12 = e10.a()) == null) {
                i11 = constraintLayout.getPaddingTop();
            } else {
                i11 = (int) b.a(a12.doubleValue());
            }
            StyleElements.DPSize d10 = A.d();
            if (d10 == null || (a11 = d10.a()) == null) {
                i12 = constraintLayout.getPaddingRight();
            } else {
                i12 = (int) b.a(a11.doubleValue());
            }
            StyleElements.DPSize a14 = A.a();
            if (a14 == null || (a10 = a14.a()) == null) {
                i13 = constraintLayout.getPaddingBottom();
            } else {
                i13 = (int) b.a(a10.doubleValue());
            }
            constraintLayout.setPadding(i10, i11, i12, i13);
        }
    }

    private static final void f(ConstraintLayout constraintLayout, UiComponent.HorizontalStackComponentStyle horizontalStackComponentStyle) {
        int i10;
        int i11;
        int i12;
        int i13;
        Double a10;
        Double a11;
        Double a12;
        Double a13;
        StyleElements.DPSizeSet s10 = horizontalStackComponentStyle.s();
        if (s10 != null) {
            e.c(constraintLayout, s10);
        }
        StyleElements.DPSizeSet u10 = horizontalStackComponentStyle.u();
        if (u10 != null) {
            StyleElements.DPSize c10 = u10.c();
            if (c10 == null || (a13 = c10.a()) == null) {
                i10 = constraintLayout.getPaddingLeft();
            } else {
                i10 = (int) b.a(a13.doubleValue());
            }
            StyleElements.DPSize e10 = u10.e();
            if (e10 == null || (a12 = e10.a()) == null) {
                i11 = constraintLayout.getPaddingTop();
            } else {
                i11 = (int) b.a(a12.doubleValue());
            }
            StyleElements.DPSize d10 = u10.d();
            if (d10 == null || (a11 = d10.a()) == null) {
                i12 = constraintLayout.getPaddingRight();
            } else {
                i12 = (int) b.a(a11.doubleValue());
            }
            StyleElements.DPSize a14 = u10.a();
            if (a14 == null || (a10 = a14.a()) == null) {
                i13 = constraintLayout.getPaddingBottom();
            } else {
                i13 = (int) b.a(a10.doubleValue());
            }
            constraintLayout.setPadding(i10, i11, i12, i13);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01dc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final android.graphics.drawable.LayerDrawable g(com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.ClickableStackComponentStyle r14, com.withpersona.sdk2.inquiry.steps.ui.styling.StackState r15) {
        /*
            android.graphics.drawable.GradientDrawable r0 = new android.graphics.drawable.GradientDrawable
            r0.<init>()
            r1 = 0
            r0.setShape(r1)
            r2 = 4
            java.lang.Double[] r3 = new java.lang.Double[r2]
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSizeSet r4 = r14.o()
            r5 = 0
            if (r4 == 0) goto L_0x0025
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSize r4 = r4.e()
            if (r4 == 0) goto L_0x0025
            java.lang.Double r4 = r4.a()
            if (r4 == 0) goto L_0x0025
            double r7 = r4.doubleValue()
            goto L_0x0026
        L_0x0025:
            r7 = r5
        L_0x0026:
            java.lang.Double r4 = java.lang.Double.valueOf(r7)
            r3[r1] = r4
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSizeSet r4 = r14.o()
            if (r4 == 0) goto L_0x0043
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSize r4 = r4.a()
            if (r4 == 0) goto L_0x0043
            java.lang.Double r4 = r4.a()
            if (r4 == 0) goto L_0x0043
            double r7 = r4.doubleValue()
            goto L_0x0044
        L_0x0043:
            r7 = r5
        L_0x0044:
            java.lang.Double r4 = java.lang.Double.valueOf(r7)
            r7 = 1
            r3[r7] = r4
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSizeSet r4 = r14.o()
            if (r4 == 0) goto L_0x0062
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSize r4 = r4.c()
            if (r4 == 0) goto L_0x0062
            java.lang.Double r4 = r4.a()
            if (r4 == 0) goto L_0x0062
            double r8 = r4.doubleValue()
            goto L_0x0063
        L_0x0062:
            r8 = r5
        L_0x0063:
            java.lang.Double r4 = java.lang.Double.valueOf(r8)
            r8 = 2
            r3[r8] = r4
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSizeSet r4 = r14.o()
            if (r4 == 0) goto L_0x0080
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSize r4 = r4.d()
            if (r4 == 0) goto L_0x0080
            java.lang.Double r4 = r4.a()
            if (r4 == 0) goto L_0x0080
            double r5 = r4.doubleValue()
        L_0x0080:
            java.lang.Double r4 = java.lang.Double.valueOf(r5)
            r5 = 3
            r3[r5] = r4
            java.util.List r3 = kotlin.collections.q.m(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r6 = 10
            int r6 = kotlin.collections.r.t(r3, r6)
            r4.<init>(r6)
            java.util.Iterator r3 = r3.iterator()
        L_0x009a:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x00bb
            java.lang.Object r6 = r3.next()
            java.lang.Number r6 = (java.lang.Number) r6
            double r9 = r6.doubleValue()
            double r9 = ti.b.a(r9)
            double r9 = java.lang.Math.ceil(r9)
            int r6 = (int) r9
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r4.add(r6)
            goto L_0x009a
        L_0x00bb:
            java.lang.Comparable r3 = kotlin.collections.CollectionsKt___CollectionsKt.b0(r4)
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            int[] r4 = com.withpersona.sdk2.inquiry.steps.ui.styling.d.a.f29244a
            int r6 = r15.ordinal()
            r6 = r4[r6]
            if (r6 == r7) goto L_0x00ea
            if (r6 == r8) goto L_0x00df
            if (r6 == r5) goto L_0x00d4
            goto L_0x00f5
        L_0x00d4:
            java.lang.String r6 = r14.s()
            if (r6 == 0) goto L_0x00f5
            int r6 = android.graphics.Color.parseColor(r6)
            goto L_0x00f6
        L_0x00df:
            java.lang.String r6 = r14.c()
            if (r6 == 0) goto L_0x00f5
            int r6 = android.graphics.Color.parseColor(r6)
            goto L_0x00f6
        L_0x00ea:
            java.lang.String r6 = r14.j()
            if (r6 == 0) goto L_0x00f5
            int r6 = android.graphics.Color.parseColor(r6)
            goto L_0x00f6
        L_0x00f5:
            r6 = r1
        L_0x00f6:
            r0.setStroke(r3, r6)
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSize r6 = r14.m()
            if (r6 == 0) goto L_0x0133
            java.lang.Double r6 = r6.a()
            if (r6 == 0) goto L_0x0133
            double r9 = r6.doubleValue()
            double r9 = ti.b.a(r9)
            float r6 = (float) r9
            android.graphics.drawable.Drawable r9 = r0.mutate()
            java.lang.String r10 = "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable"
            kotlin.jvm.internal.j.e(r9, r10)
            android.graphics.drawable.GradientDrawable r9 = (android.graphics.drawable.GradientDrawable) r9
            r10 = 8
            float[] r10 = new float[r10]
            r10[r1] = r6
            r10[r7] = r6
            r10[r8] = r6
            r10[r5] = r6
            r10[r2] = r6
            r2 = 5
            r10[r2] = r6
            r2 = 6
            r10[r2] = r6
            r2 = 7
            r10[r2] = r6
            r9.setCornerRadii(r10)
        L_0x0133:
            int r15 = r15.ordinal()
            r15 = r4[r15]
            if (r15 == r7) goto L_0x014f
            if (r15 == r8) goto L_0x014a
            if (r15 != r5) goto L_0x0144
            java.lang.String r15 = r14.r()
            goto L_0x0153
        L_0x0144:
            kotlin.NoWhenBranchMatchedException r14 = new kotlin.NoWhenBranchMatchedException
            r14.<init>()
            throw r14
        L_0x014a:
            java.lang.String r15 = r14.a()
            goto L_0x0153
        L_0x014f:
            java.lang.String r15 = r14.i()
        L_0x0153:
            if (r15 == 0) goto L_0x016b
            android.content.res.ColorStateList r2 = new android.content.res.ColorStateList
            int[][] r4 = new int[r7][]
            int[] r5 = new int[r1]
            r4[r1] = r5
            int[] r5 = new int[r7]
            int r15 = android.graphics.Color.parseColor(r15)
            r5[r1] = r15
            r2.<init>(r4, r5)
            r0.setColor(r2)
        L_0x016b:
            android.graphics.drawable.LayerDrawable r15 = new android.graphics.drawable.LayerDrawable
            android.graphics.drawable.Drawable[] r2 = new android.graphics.drawable.Drawable[r7]
            r2[r1] = r0
            r15.<init>(r2)
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSizeSet r0 = r14.o()
            if (r0 == 0) goto L_0x0196
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSize r0 = r0.e()
            if (r0 == 0) goto L_0x0196
            java.lang.Double r0 = r0.a()
            if (r0 == 0) goto L_0x0196
            double r0 = r0.doubleValue()
            double r0 = ti.b.a(r0)
            double r0 = java.lang.Math.ceil(r0)
            int r0 = (int) r0
            int r0 = r3 - r0
            goto L_0x0197
        L_0x0196:
            r0 = r3
        L_0x0197:
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSizeSet r1 = r14.o()
            if (r1 == 0) goto L_0x01b9
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSize r1 = r1.a()
            if (r1 == 0) goto L_0x01b9
            java.lang.Double r1 = r1.a()
            if (r1 == 0) goto L_0x01b9
            double r1 = r1.doubleValue()
            double r1 = ti.b.a(r1)
            double r1 = java.lang.Math.ceil(r1)
            int r1 = (int) r1
            int r1 = r3 - r1
            goto L_0x01ba
        L_0x01b9:
            r1 = r3
        L_0x01ba:
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSizeSet r2 = r14.o()
            if (r2 == 0) goto L_0x01dc
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSize r2 = r2.c()
            if (r2 == 0) goto L_0x01dc
            java.lang.Double r2 = r2.a()
            if (r2 == 0) goto L_0x01dc
            double r4 = r2.doubleValue()
            double r4 = ti.b.a(r4)
            double r4 = java.lang.Math.ceil(r4)
            int r2 = (int) r4
            int r2 = r3 - r2
            goto L_0x01dd
        L_0x01dc:
            r2 = r3
        L_0x01dd:
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSizeSet r14 = r14.o()
            if (r14 == 0) goto L_0x01fd
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSize r14 = r14.d()
            if (r14 == 0) goto L_0x01fd
            java.lang.Double r14 = r14.a()
            if (r14 == 0) goto L_0x01fd
            double r4 = r14.doubleValue()
            double r4 = ti.b.a(r4)
            double r4 = java.lang.Math.ceil(r4)
            int r14 = (int) r4
            int r3 = r3 - r14
        L_0x01fd:
            r9 = 0
            int r10 = -r2
            int r11 = -r0
            int r12 = -r3
            int r13 = -r1
            r8 = r15
            r8.setLayerInset(r9, r10, r11, r12, r13)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.styling.d.g(com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$ClickableStackComponentStyle, com.withpersona.sdk2.inquiry.steps.ui.styling.StackState):android.graphics.drawable.LayerDrawable");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: java.lang.Number} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final android.graphics.drawable.LayerDrawable h(com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.HorizontalStackComponentStyle r15) {
        /*
            android.graphics.drawable.GradientDrawable r0 = new android.graphics.drawable.GradientDrawable
            r0.<init>()
            r1 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            r0.setShape(r1)
            r3 = 4
            java.lang.Object[] r4 = new java.lang.Object[r3]
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSizeSet r5 = r15.m()
            if (r5 == 0) goto L_0x0022
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSize r5 = r5.e()
            if (r5 == 0) goto L_0x0022
            java.lang.Double r5 = r5.a()
            if (r5 != 0) goto L_0x0023
        L_0x0022:
            r5 = r2
        L_0x0023:
            r4[r1] = r5
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSizeSet r5 = r15.m()
            if (r5 == 0) goto L_0x0037
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSize r5 = r5.a()
            if (r5 == 0) goto L_0x0037
            java.lang.Double r5 = r5.a()
            if (r5 != 0) goto L_0x0038
        L_0x0037:
            r5 = r2
        L_0x0038:
            r6 = 1
            r4[r6] = r5
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSizeSet r5 = r15.m()
            if (r5 == 0) goto L_0x004d
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSize r5 = r5.c()
            if (r5 == 0) goto L_0x004d
            java.lang.Double r5 = r5.a()
            if (r5 != 0) goto L_0x004e
        L_0x004d:
            r5 = r2
        L_0x004e:
            r7 = 2
            r4[r7] = r5
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSizeSet r5 = r15.m()
            if (r5 == 0) goto L_0x0063
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSize r5 = r5.d()
            if (r5 == 0) goto L_0x0063
            java.lang.Double r5 = r5.a()
            if (r5 != 0) goto L_0x0064
        L_0x0063:
            r5 = r2
        L_0x0064:
            r8 = 3
            r4[r8] = r5
            java.util.List r4 = kotlin.collections.q.m(r4)
            java.util.Iterator r4 = r4.iterator()
            boolean r5 = r4.hasNext()
            if (r5 != 0) goto L_0x0077
            r4 = 0
            goto L_0x00b4
        L_0x0077:
            java.lang.Object r5 = r4.next()
            boolean r9 = r4.hasNext()
            if (r9 != 0) goto L_0x0083
        L_0x0081:
            r4 = r5
            goto L_0x00b4
        L_0x0083:
            r9 = r5
            java.lang.Number r9 = (java.lang.Number) r9
            double r9 = r9.doubleValue()
            double r9 = ti.b.a(r9)
            double r9 = java.lang.Math.ceil(r9)
        L_0x0092:
            java.lang.Object r11 = r4.next()
            r12 = r11
            java.lang.Number r12 = (java.lang.Number) r12
            double r12 = r12.doubleValue()
            double r12 = ti.b.a(r12)
            double r12 = java.lang.Math.ceil(r12)
            int r14 = java.lang.Double.compare(r9, r12)
            if (r14 >= 0) goto L_0x00ad
            r5 = r11
            r9 = r12
        L_0x00ad:
            boolean r11 = r4.hasNext()
            if (r11 != 0) goto L_0x0092
            goto L_0x0081
        L_0x00b4:
            if (r4 != 0) goto L_0x00b7
            goto L_0x00b8
        L_0x00b7:
            r2 = r4
        L_0x00b8:
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.String r4 = r15.h()
            if (r4 == 0) goto L_0x00c9
            int r4 = android.graphics.Color.parseColor(r4)
            goto L_0x00ca
        L_0x00c9:
            r4 = r1
        L_0x00ca:
            r0.setStroke(r2, r4)
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSize r4 = r15.k()
            if (r4 == 0) goto L_0x0107
            java.lang.Double r4 = r4.a()
            if (r4 == 0) goto L_0x0107
            double r4 = r4.doubleValue()
            double r4 = ti.b.a(r4)
            float r4 = (float) r4
            android.graphics.drawable.Drawable r5 = r0.mutate()
            java.lang.String r9 = "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable"
            kotlin.jvm.internal.j.e(r5, r9)
            android.graphics.drawable.GradientDrawable r5 = (android.graphics.drawable.GradientDrawable) r5
            r9 = 8
            float[] r9 = new float[r9]
            r9[r1] = r4
            r9[r6] = r4
            r9[r7] = r4
            r9[r8] = r4
            r9[r3] = r4
            r3 = 5
            r9[r3] = r4
            r3 = 6
            r9[r3] = r4
            r3 = 7
            r9[r3] = r4
            r5.setCornerRadii(r9)
        L_0x0107:
            java.lang.String r3 = r15.g()
            if (r3 == 0) goto L_0x0123
            android.content.res.ColorStateList r4 = new android.content.res.ColorStateList
            int[][] r5 = new int[r6][]
            int[] r7 = new int[r1]
            r5[r1] = r7
            int[] r7 = new int[r6]
            int r3 = android.graphics.Color.parseColor(r3)
            r7[r1] = r3
            r4.<init>(r5, r7)
            r0.setColor(r4)
        L_0x0123:
            android.graphics.drawable.LayerDrawable r3 = new android.graphics.drawable.LayerDrawable
            android.graphics.drawable.Drawable[] r4 = new android.graphics.drawable.Drawable[r6]
            r4[r1] = r0
            r3.<init>(r4)
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSizeSet r0 = r15.m()
            if (r0 == 0) goto L_0x014e
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSize r0 = r0.e()
            if (r0 == 0) goto L_0x014e
            java.lang.Double r0 = r0.a()
            if (r0 == 0) goto L_0x014e
            double r0 = r0.doubleValue()
            double r0 = ti.b.a(r0)
            double r0 = java.lang.Math.ceil(r0)
            int r0 = (int) r0
            int r0 = r2 - r0
            goto L_0x014f
        L_0x014e:
            r0 = r2
        L_0x014f:
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSizeSet r1 = r15.m()
            if (r1 == 0) goto L_0x0171
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSize r1 = r1.a()
            if (r1 == 0) goto L_0x0171
            java.lang.Double r1 = r1.a()
            if (r1 == 0) goto L_0x0171
            double r4 = r1.doubleValue()
            double r4 = ti.b.a(r4)
            double r4 = java.lang.Math.ceil(r4)
            int r1 = (int) r4
            int r1 = r2 - r1
            goto L_0x0172
        L_0x0171:
            r1 = r2
        L_0x0172:
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSizeSet r4 = r15.m()
            if (r4 == 0) goto L_0x0194
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSize r4 = r4.c()
            if (r4 == 0) goto L_0x0194
            java.lang.Double r4 = r4.a()
            if (r4 == 0) goto L_0x0194
            double r4 = r4.doubleValue()
            double r4 = ti.b.a(r4)
            double r4 = java.lang.Math.ceil(r4)
            int r4 = (int) r4
            int r4 = r2 - r4
            goto L_0x0195
        L_0x0194:
            r4 = r2
        L_0x0195:
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSizeSet r15 = r15.m()
            if (r15 == 0) goto L_0x01b5
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSize r15 = r15.d()
            if (r15 == 0) goto L_0x01b5
            java.lang.Double r15 = r15.a()
            if (r15 == 0) goto L_0x01b5
            double r5 = r15.doubleValue()
            double r5 = ti.b.a(r5)
            double r5 = java.lang.Math.ceil(r5)
            int r15 = (int) r5
            int r2 = r2 - r15
        L_0x01b5:
            r9 = 0
            int r10 = -r4
            int r11 = -r0
            int r12 = -r2
            int r13 = -r1
            r8 = r3
            r8.setLayerInset(r9, r10, r11, r12, r13)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.styling.d.h(com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$HorizontalStackComponentStyle):android.graphics.drawable.LayerDrawable");
    }
}
