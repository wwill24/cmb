package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.d;
import java.util.ArrayList;
import java.util.Iterator;

public class c extends WidgetRun {

    /* renamed from: k  reason: collision with root package name */
    ArrayList<WidgetRun> f3867k = new ArrayList<>();

    /* renamed from: l  reason: collision with root package name */
    private int f3868l;

    public c(ConstraintWidget constraintWidget, int i10) {
        super(constraintWidget);
        this.f3840f = i10;
        q();
    }

    private void q() {
        ConstraintWidget constraintWidget;
        boolean z10;
        int i10;
        ConstraintWidget constraintWidget2 = this.f3836b;
        ConstraintWidget L = constraintWidget2.L(this.f3840f);
        while (true) {
            ConstraintWidget constraintWidget3 = L;
            constraintWidget = constraintWidget2;
            constraintWidget2 = constraintWidget3;
            if (constraintWidget2 == null) {
                break;
            }
            L = constraintWidget2.L(this.f3840f);
        }
        this.f3836b = constraintWidget;
        this.f3867k.add(constraintWidget.N(this.f3840f));
        ConstraintWidget J = constraintWidget.J(this.f3840f);
        while (J != null) {
            this.f3867k.add(J.N(this.f3840f));
            J = J.J(this.f3840f);
        }
        Iterator<WidgetRun> it = this.f3867k.iterator();
        while (it.hasNext()) {
            WidgetRun next = it.next();
            int i11 = this.f3840f;
            if (i11 == 0) {
                next.f3836b.f3759c = this;
            } else if (i11 == 1) {
                next.f3836b.f3761d = this;
            }
        }
        if (this.f3840f != 0 || !((d) this.f3836b.K()).P1()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10 && this.f3867k.size() > 1) {
            ArrayList<WidgetRun> arrayList = this.f3867k;
            this.f3836b = arrayList.get(arrayList.size() - 1).f3836b;
        }
        if (this.f3840f == 0) {
            i10 = this.f3836b.z();
        } else {
            i10 = this.f3836b.S();
        }
        this.f3868l = i10;
    }

    private ConstraintWidget r() {
        for (int i10 = 0; i10 < this.f3867k.size(); i10++) {
            WidgetRun widgetRun = this.f3867k.get(i10);
            if (widgetRun.f3836b.V() != 8) {
                return widgetRun.f3836b;
            }
        }
        return null;
    }

    private ConstraintWidget s() {
        for (int size = this.f3867k.size() - 1; size >= 0; size--) {
            WidgetRun widgetRun = this.f3867k.get(size);
            if (widgetRun.f3836b.V() != 8) {
                return widgetRun.f3836b;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00e9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(q0.a r27) {
        /*
            r26 = this;
            r0 = r26
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r0.f3842h
            boolean r1 = r1.f3823j
            if (r1 == 0) goto L_0x0427
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r0.f3843i
            boolean r1 = r1.f3823j
            if (r1 != 0) goto L_0x0010
            goto L_0x0427
        L_0x0010:
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f3836b
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r1.K()
            boolean r2 = r1 instanceof androidx.constraintlayout.core.widgets.d
            if (r2 == 0) goto L_0x0021
            androidx.constraintlayout.core.widgets.d r1 = (androidx.constraintlayout.core.widgets.d) r1
            boolean r1 = r1.P1()
            goto L_0x0022
        L_0x0021:
            r1 = 0
        L_0x0022:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r0.f3843i
            int r2 = r2.f3820g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r4 = r0.f3842h
            int r4 = r4.f3820g
            int r2 = r2 - r4
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r4 = r0.f3867k
            int r4 = r4.size()
            r5 = 0
        L_0x0032:
            r6 = -1
            r7 = 8
            if (r5 >= r4) goto L_0x004a
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r8 = r0.f3867k
            java.lang.Object r8 = r8.get(r5)
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r8 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r8
            androidx.constraintlayout.core.widgets.ConstraintWidget r8 = r8.f3836b
            int r8 = r8.V()
            if (r8 != r7) goto L_0x004b
            int r5 = r5 + 1
            goto L_0x0032
        L_0x004a:
            r5 = r6
        L_0x004b:
            int r8 = r4 + -1
            r9 = r8
        L_0x004e:
            if (r9 < 0) goto L_0x0064
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r10 = r0.f3867k
            java.lang.Object r10 = r10.get(r9)
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r10 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r10
            androidx.constraintlayout.core.widgets.ConstraintWidget r10 = r10.f3836b
            int r10 = r10.V()
            if (r10 != r7) goto L_0x0063
            int r9 = r9 + -1
            goto L_0x004e
        L_0x0063:
            r6 = r9
        L_0x0064:
            r9 = 0
        L_0x0065:
            r11 = 2
            if (r9 >= r11) goto L_0x0109
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
        L_0x006f:
            if (r13 >= r4) goto L_0x00fb
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r3 = r0.f3867k
            java.lang.Object r3 = r3.get(r13)
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r3 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r3
            androidx.constraintlayout.core.widgets.ConstraintWidget r11 = r3.f3836b
            int r11 = r11.V()
            if (r11 != r7) goto L_0x0083
            goto L_0x00f4
        L_0x0083:
            int r16 = r16 + 1
            if (r13 <= 0) goto L_0x008e
            if (r13 < r5) goto L_0x008e
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r11 = r3.f3842h
            int r11 = r11.f3819f
            int r14 = r14 + r11
        L_0x008e:
            androidx.constraintlayout.core.widgets.analyzer.e r11 = r3.f3839e
            int r7 = r11.f3820g
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r10 = r3.f3838d
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r10 == r12) goto L_0x009a
            r10 = 1
            goto L_0x009b
        L_0x009a:
            r10 = 0
        L_0x009b:
            if (r10 == 0) goto L_0x00bd
            int r11 = r0.f3840f
            if (r11 != 0) goto L_0x00ac
            androidx.constraintlayout.core.widgets.ConstraintWidget r12 = r3.f3836b
            androidx.constraintlayout.core.widgets.analyzer.j r12 = r12.f3763e
            androidx.constraintlayout.core.widgets.analyzer.e r12 = r12.f3839e
            boolean r12 = r12.f3823j
            if (r12 != 0) goto L_0x00ac
            return
        L_0x00ac:
            r12 = 1
            if (r11 != r12) goto L_0x00ba
            androidx.constraintlayout.core.widgets.ConstraintWidget r11 = r3.f3836b
            androidx.constraintlayout.core.widgets.analyzer.l r11 = r11.f3765f
            androidx.constraintlayout.core.widgets.analyzer.e r11 = r11.f3839e
            boolean r11 = r11.f3823j
            if (r11 != 0) goto L_0x00ba
            return
        L_0x00ba:
            r19 = r7
            goto L_0x00d3
        L_0x00bd:
            r19 = r7
            r12 = 1
            int r7 = r3.f3835a
            if (r7 != r12) goto L_0x00cb
            if (r9 != 0) goto L_0x00cb
            int r7 = r11.f3878m
            int r15 = r15 + 1
            goto L_0x00d1
        L_0x00cb:
            boolean r7 = r11.f3823j
            if (r7 == 0) goto L_0x00d3
            r7 = r19
        L_0x00d1:
            r10 = 1
            goto L_0x00d5
        L_0x00d3:
            r7 = r19
        L_0x00d5:
            if (r10 != 0) goto L_0x00e9
            int r15 = r15 + 1
            androidx.constraintlayout.core.widgets.ConstraintWidget r7 = r3.f3836b
            float[] r7 = r7.D0
            int r10 = r0.f3840f
            r7 = r7[r10]
            r10 = 0
            int r11 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r11 < 0) goto L_0x00ea
            float r17 = r17 + r7
            goto L_0x00ea
        L_0x00e9:
            int r14 = r14 + r7
        L_0x00ea:
            if (r13 >= r8) goto L_0x00f4
            if (r13 >= r6) goto L_0x00f4
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r3.f3843i
            int r3 = r3.f3819f
            int r3 = -r3
            int r14 = r14 + r3
        L_0x00f4:
            int r13 = r13 + 1
            r7 = 8
            r11 = 2
            goto L_0x006f
        L_0x00fb:
            if (r14 < r2) goto L_0x0106
            if (r15 != 0) goto L_0x0100
            goto L_0x0106
        L_0x0100:
            int r9 = r9 + 1
            r7 = 8
            goto L_0x0065
        L_0x0106:
            r3 = r16
            goto L_0x010e
        L_0x0109:
            r3 = 0
            r14 = 0
            r15 = 0
            r17 = 0
        L_0x010e:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r7 = r0.f3842h
            int r7 = r7.f3820g
            if (r1 == 0) goto L_0x0118
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r7 = r0.f3843i
            int r7 = r7.f3820g
        L_0x0118:
            r9 = 1056964608(0x3f000000, float:0.5)
            if (r14 <= r2) goto L_0x012f
            r10 = 1073741824(0x40000000, float:2.0)
            if (r1 == 0) goto L_0x0128
            int r11 = r14 - r2
            float r11 = (float) r11
            float r11 = r11 / r10
            float r11 = r11 + r9
            int r10 = (int) r11
            int r7 = r7 + r10
            goto L_0x012f
        L_0x0128:
            int r11 = r14 - r2
            float r11 = (float) r11
            float r11 = r11 / r10
            float r11 = r11 + r9
            int r10 = (int) r11
            int r7 = r7 - r10
        L_0x012f:
            if (r15 <= 0) goto L_0x0226
            int r10 = r2 - r14
            float r10 = (float) r10
            float r11 = (float) r15
            float r11 = r10 / r11
            float r11 = r11 + r9
            int r11 = (int) r11
            r12 = 0
            r13 = 0
        L_0x013b:
            if (r12 >= r4) goto L_0x01d8
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r9 = r0.f3867k
            java.lang.Object r9 = r9.get(r12)
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r9 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r9
            r19 = r11
            androidx.constraintlayout.core.widgets.ConstraintWidget r11 = r9.f3836b
            int r11 = r11.V()
            r20 = r14
            r14 = 8
            if (r11 != r14) goto L_0x0155
            goto L_0x01be
        L_0x0155:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = r9.f3838d
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r11 != r14) goto L_0x01be
            androidx.constraintlayout.core.widgets.analyzer.e r11 = r9.f3839e
            boolean r14 = r11.f3823j
            if (r14 != 0) goto L_0x01be
            r14 = 0
            int r18 = (r17 > r14 ? 1 : (r17 == r14 ? 0 : -1))
            if (r18 <= 0) goto L_0x0178
            androidx.constraintlayout.core.widgets.ConstraintWidget r14 = r9.f3836b
            float[] r14 = r14.D0
            r21 = r7
            int r7 = r0.f3840f
            r7 = r14[r7]
            float r7 = r7 * r10
            float r7 = r7 / r17
            r14 = 1056964608(0x3f000000, float:0.5)
            float r7 = r7 + r14
            int r7 = (int) r7
            goto L_0x017c
        L_0x0178:
            r21 = r7
            r7 = r19
        L_0x017c:
            int r14 = r0.f3840f
            if (r14 != 0) goto L_0x018b
            androidx.constraintlayout.core.widgets.ConstraintWidget r14 = r9.f3836b
            r22 = r10
            int r10 = r14.A
            int r14 = r14.f3805z
            r23 = r1
            goto L_0x019a
        L_0x018b:
            r22 = r10
            androidx.constraintlayout.core.widgets.ConstraintWidget r10 = r9.f3836b
            int r14 = r10.D
            int r10 = r10.C
            r23 = r1
            r25 = r14
            r14 = r10
            r10 = r25
        L_0x019a:
            int r1 = r9.f3835a
            r24 = r3
            r3 = 1
            if (r1 != r3) goto L_0x01a8
            int r1 = r11.f3878m
            int r1 = java.lang.Math.min(r7, r1)
            goto L_0x01a9
        L_0x01a8:
            r1 = r7
        L_0x01a9:
            int r1 = java.lang.Math.max(r14, r1)
            if (r10 <= 0) goto L_0x01b3
            int r1 = java.lang.Math.min(r10, r1)
        L_0x01b3:
            if (r1 == r7) goto L_0x01b8
            int r13 = r13 + 1
            r7 = r1
        L_0x01b8:
            androidx.constraintlayout.core.widgets.analyzer.e r1 = r9.f3839e
            r1.d(r7)
            goto L_0x01c6
        L_0x01be:
            r23 = r1
            r24 = r3
            r21 = r7
            r22 = r10
        L_0x01c6:
            int r12 = r12 + 1
            r11 = r19
            r14 = r20
            r7 = r21
            r10 = r22
            r1 = r23
            r3 = r24
            r9 = 1056964608(0x3f000000, float:0.5)
            goto L_0x013b
        L_0x01d8:
            r23 = r1
            r24 = r3
            r21 = r7
            r20 = r14
            if (r13 <= 0) goto L_0x0217
            int r15 = r15 - r13
            r1 = 0
            r3 = 0
        L_0x01e5:
            if (r1 >= r4) goto L_0x0215
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r7 = r0.f3867k
            java.lang.Object r7 = r7.get(r1)
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r7 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r7
            androidx.constraintlayout.core.widgets.ConstraintWidget r9 = r7.f3836b
            int r9 = r9.V()
            r10 = 8
            if (r9 != r10) goto L_0x01fa
            goto L_0x0212
        L_0x01fa:
            if (r1 <= 0) goto L_0x0203
            if (r1 < r5) goto L_0x0203
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r7.f3842h
            int r9 = r9.f3819f
            int r3 = r3 + r9
        L_0x0203:
            androidx.constraintlayout.core.widgets.analyzer.e r9 = r7.f3839e
            int r9 = r9.f3820g
            int r3 = r3 + r9
            if (r1 >= r8) goto L_0x0212
            if (r1 >= r6) goto L_0x0212
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r7 = r7.f3843i
            int r7 = r7.f3819f
            int r7 = -r7
            int r3 = r3 + r7
        L_0x0212:
            int r1 = r1 + 1
            goto L_0x01e5
        L_0x0215:
            r14 = r3
            goto L_0x0219
        L_0x0217:
            r14 = r20
        L_0x0219:
            int r1 = r0.f3868l
            r3 = 2
            if (r1 != r3) goto L_0x0224
            if (r13 != 0) goto L_0x0224
            r1 = 0
            r0.f3868l = r1
            goto L_0x0230
        L_0x0224:
            r1 = 0
            goto L_0x0230
        L_0x0226:
            r23 = r1
            r24 = r3
            r21 = r7
            r20 = r14
            r1 = 0
            r3 = 2
        L_0x0230:
            if (r14 <= r2) goto L_0x0234
            r0.f3868l = r3
        L_0x0234:
            if (r24 <= 0) goto L_0x023c
            if (r15 != 0) goto L_0x023c
            if (r5 != r6) goto L_0x023c
            r0.f3868l = r3
        L_0x023c:
            int r3 = r0.f3868l
            r7 = 1
            if (r3 != r7) goto L_0x02e0
            r9 = r24
            if (r9 <= r7) goto L_0x024a
            int r2 = r2 - r14
            int r3 = r9 + -1
            int r2 = r2 / r3
            goto L_0x0251
        L_0x024a:
            if (r9 != r7) goto L_0x0250
            int r2 = r2 - r14
            r3 = 2
            int r2 = r2 / r3
            goto L_0x0251
        L_0x0250:
            r2 = r1
        L_0x0251:
            if (r15 <= 0) goto L_0x0254
            r2 = r1
        L_0x0254:
            r3 = r1
            r7 = r21
        L_0x0257:
            if (r3 >= r4) goto L_0x0427
            if (r23 == 0) goto L_0x0260
            int r1 = r3 + 1
            int r1 = r4 - r1
            goto L_0x0261
        L_0x0260:
            r1 = r3
        L_0x0261:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r9 = r0.f3867k
            java.lang.Object r1 = r9.get(r1)
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r1 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r1
            androidx.constraintlayout.core.widgets.ConstraintWidget r9 = r1.f3836b
            int r9 = r9.V()
            r10 = 8
            if (r9 != r10) goto L_0x027e
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r1.f3842h
            r9.d(r7)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r1.f3843i
            r1.d(r7)
            goto L_0x02dc
        L_0x027e:
            if (r3 <= 0) goto L_0x0285
            if (r23 == 0) goto L_0x0284
            int r7 = r7 - r2
            goto L_0x0285
        L_0x0284:
            int r7 = r7 + r2
        L_0x0285:
            if (r3 <= 0) goto L_0x0296
            if (r3 < r5) goto L_0x0296
            if (r23 == 0) goto L_0x0291
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r1.f3842h
            int r9 = r9.f3819f
            int r7 = r7 - r9
            goto L_0x0296
        L_0x0291:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r1.f3842h
            int r9 = r9.f3819f
            int r7 = r7 + r9
        L_0x0296:
            if (r23 == 0) goto L_0x029e
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r1.f3843i
            r9.d(r7)
            goto L_0x02a3
        L_0x029e:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r1.f3842h
            r9.d(r7)
        L_0x02a3:
            androidx.constraintlayout.core.widgets.analyzer.e r9 = r1.f3839e
            int r10 = r9.f3820g
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = r1.f3838d
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r11 != r12) goto L_0x02b4
            int r11 = r1.f3835a
            r12 = 1
            if (r11 != r12) goto L_0x02b4
            int r10 = r9.f3878m
        L_0x02b4:
            if (r23 == 0) goto L_0x02b8
            int r7 = r7 - r10
            goto L_0x02b9
        L_0x02b8:
            int r7 = r7 + r10
        L_0x02b9:
            if (r23 == 0) goto L_0x02c1
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r1.f3842h
            r9.d(r7)
            goto L_0x02c6
        L_0x02c1:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r1.f3843i
            r9.d(r7)
        L_0x02c6:
            r9 = 1
            r1.f3841g = r9
            if (r3 >= r8) goto L_0x02dc
            if (r3 >= r6) goto L_0x02dc
            if (r23 == 0) goto L_0x02d6
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r1.f3843i
            int r1 = r1.f3819f
            int r1 = -r1
            int r7 = r7 - r1
            goto L_0x02dc
        L_0x02d6:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r1.f3843i
            int r1 = r1.f3819f
            int r1 = -r1
            int r7 = r7 + r1
        L_0x02dc:
            int r3 = r3 + 1
            goto L_0x0257
        L_0x02e0:
            r9 = r24
            if (r3 != 0) goto L_0x0377
            int r2 = r2 - r14
            r3 = 1
            int r7 = r9 + 1
            int r2 = r2 / r7
            if (r15 <= 0) goto L_0x02ec
            r2 = r1
        L_0x02ec:
            r3 = r1
            r7 = r21
        L_0x02ef:
            if (r3 >= r4) goto L_0x0427
            if (r23 == 0) goto L_0x02f8
            int r1 = r3 + 1
            int r1 = r4 - r1
            goto L_0x02f9
        L_0x02f8:
            r1 = r3
        L_0x02f9:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r9 = r0.f3867k
            java.lang.Object r1 = r9.get(r1)
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r1 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r1
            androidx.constraintlayout.core.widgets.ConstraintWidget r9 = r1.f3836b
            int r9 = r9.V()
            r10 = 8
            if (r9 != r10) goto L_0x0316
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r1.f3842h
            r9.d(r7)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r1.f3843i
            r1.d(r7)
            goto L_0x0373
        L_0x0316:
            if (r23 == 0) goto L_0x031a
            int r7 = r7 - r2
            goto L_0x031b
        L_0x031a:
            int r7 = r7 + r2
        L_0x031b:
            if (r3 <= 0) goto L_0x032c
            if (r3 < r5) goto L_0x032c
            if (r23 == 0) goto L_0x0327
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r1.f3842h
            int r9 = r9.f3819f
            int r7 = r7 - r9
            goto L_0x032c
        L_0x0327:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r1.f3842h
            int r9 = r9.f3819f
            int r7 = r7 + r9
        L_0x032c:
            if (r23 == 0) goto L_0x0334
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r1.f3843i
            r9.d(r7)
            goto L_0x0339
        L_0x0334:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r1.f3842h
            r9.d(r7)
        L_0x0339:
            androidx.constraintlayout.core.widgets.analyzer.e r9 = r1.f3839e
            int r10 = r9.f3820g
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = r1.f3838d
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r11 != r12) goto L_0x034e
            int r11 = r1.f3835a
            r12 = 1
            if (r11 != r12) goto L_0x034e
            int r9 = r9.f3878m
            int r10 = java.lang.Math.min(r10, r9)
        L_0x034e:
            if (r23 == 0) goto L_0x0352
            int r7 = r7 - r10
            goto L_0x0353
        L_0x0352:
            int r7 = r7 + r10
        L_0x0353:
            if (r23 == 0) goto L_0x035b
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r1.f3842h
            r9.d(r7)
            goto L_0x0360
        L_0x035b:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r9 = r1.f3843i
            r9.d(r7)
        L_0x0360:
            if (r3 >= r8) goto L_0x0373
            if (r3 >= r6) goto L_0x0373
            if (r23 == 0) goto L_0x036d
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r1.f3843i
            int r1 = r1.f3819f
            int r1 = -r1
            int r7 = r7 - r1
            goto L_0x0373
        L_0x036d:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r1.f3843i
            int r1 = r1.f3819f
            int r1 = -r1
            int r7 = r7 + r1
        L_0x0373:
            int r3 = r3 + 1
            goto L_0x02ef
        L_0x0377:
            r7 = 2
            if (r3 != r7) goto L_0x0427
            int r3 = r0.f3840f
            if (r3 != 0) goto L_0x0385
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f3836b
            float r3 = r3.y()
            goto L_0x038b
        L_0x0385:
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f3836b
            float r3 = r3.R()
        L_0x038b:
            if (r23 == 0) goto L_0x0391
            r7 = 1065353216(0x3f800000, float:1.0)
            float r3 = r7 - r3
        L_0x0391:
            int r2 = r2 - r14
            float r2 = (float) r2
            float r2 = r2 * r3
            r3 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 + r3
            int r2 = (int) r2
            if (r2 < 0) goto L_0x039c
            if (r15 <= 0) goto L_0x039d
        L_0x039c:
            r2 = r1
        L_0x039d:
            if (r23 == 0) goto L_0x03a2
            int r7 = r21 - r2
            goto L_0x03a4
        L_0x03a2:
            int r7 = r21 + r2
        L_0x03a4:
            r3 = r1
        L_0x03a5:
            if (r3 >= r4) goto L_0x0427
            if (r23 == 0) goto L_0x03ae
            int r1 = r3 + 1
            int r1 = r4 - r1
            goto L_0x03af
        L_0x03ae:
            r1 = r3
        L_0x03af:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r2 = r0.f3867k
            java.lang.Object r1 = r2.get(r1)
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r1 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r1
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r1.f3836b
            int r2 = r2.V()
            r9 = 8
            if (r2 != r9) goto L_0x03cd
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r1.f3842h
            r2.d(r7)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r1.f3843i
            r1.d(r7)
            r12 = 1
            goto L_0x0423
        L_0x03cd:
            if (r3 <= 0) goto L_0x03de
            if (r3 < r5) goto L_0x03de
            if (r23 == 0) goto L_0x03d9
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r1.f3842h
            int r2 = r2.f3819f
            int r7 = r7 - r2
            goto L_0x03de
        L_0x03d9:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r1.f3842h
            int r2 = r2.f3819f
            int r7 = r7 + r2
        L_0x03de:
            if (r23 == 0) goto L_0x03e6
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r1.f3843i
            r2.d(r7)
            goto L_0x03eb
        L_0x03e6:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r1.f3842h
            r2.d(r7)
        L_0x03eb:
            androidx.constraintlayout.core.widgets.analyzer.e r2 = r1.f3839e
            int r10 = r2.f3820g
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = r1.f3838d
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r11 != r12) goto L_0x03fd
            int r11 = r1.f3835a
            r12 = 1
            if (r11 != r12) goto L_0x03fe
            int r10 = r2.f3878m
            goto L_0x03fe
        L_0x03fd:
            r12 = 1
        L_0x03fe:
            if (r23 == 0) goto L_0x0402
            int r7 = r7 - r10
            goto L_0x0403
        L_0x0402:
            int r7 = r7 + r10
        L_0x0403:
            if (r23 == 0) goto L_0x040b
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r1.f3842h
            r2.d(r7)
            goto L_0x0410
        L_0x040b:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r1.f3843i
            r2.d(r7)
        L_0x0410:
            if (r3 >= r8) goto L_0x0423
            if (r3 >= r6) goto L_0x0423
            if (r23 == 0) goto L_0x041d
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r1.f3843i
            int r1 = r1.f3819f
            int r1 = -r1
            int r7 = r7 - r1
            goto L_0x0423
        L_0x041d:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r1.f3843i
            int r1 = r1.f3819f
            int r1 = -r1
            int r7 = r7 + r1
        L_0x0423:
            int r3 = r3 + 1
            goto L_0x03a5
        L_0x0427:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.c.a(q0.a):void");
    }

    /* access modifiers changed from: package-private */
    public void d() {
        Iterator<WidgetRun> it = this.f3867k.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
        int size = this.f3867k.size();
        if (size >= 1) {
            ConstraintWidget constraintWidget = this.f3867k.get(0).f3836b;
            ConstraintWidget constraintWidget2 = this.f3867k.get(size - 1).f3836b;
            if (this.f3840f == 0) {
                ConstraintAnchor constraintAnchor = constraintWidget.O;
                ConstraintAnchor constraintAnchor2 = constraintWidget2.Q;
                DependencyNode i10 = i(constraintAnchor, 0);
                int f10 = constraintAnchor.f();
                ConstraintWidget r10 = r();
                if (r10 != null) {
                    f10 = r10.O.f();
                }
                if (i10 != null) {
                    b(this.f3842h, i10, f10);
                }
                DependencyNode i11 = i(constraintAnchor2, 0);
                int f11 = constraintAnchor2.f();
                ConstraintWidget s10 = s();
                if (s10 != null) {
                    f11 = s10.Q.f();
                }
                if (i11 != null) {
                    b(this.f3843i, i11, -f11);
                }
            } else {
                ConstraintAnchor constraintAnchor3 = constraintWidget.P;
                ConstraintAnchor constraintAnchor4 = constraintWidget2.R;
                DependencyNode i12 = i(constraintAnchor3, 1);
                int f12 = constraintAnchor3.f();
                ConstraintWidget r11 = r();
                if (r11 != null) {
                    f12 = r11.P.f();
                }
                if (i12 != null) {
                    b(this.f3842h, i12, f12);
                }
                DependencyNode i13 = i(constraintAnchor4, 1);
                int f13 = constraintAnchor4.f();
                ConstraintWidget s11 = s();
                if (s11 != null) {
                    f13 = s11.R.f();
                }
                if (i13 != null) {
                    b(this.f3843i, i13, -f13);
                }
            }
            this.f3842h.f3814a = this;
            this.f3843i.f3814a = this;
        }
    }

    public void e() {
        for (int i10 = 0; i10 < this.f3867k.size(); i10++) {
            this.f3867k.get(i10).e();
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f3837c = null;
        Iterator<WidgetRun> it = this.f3867k.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
    }

    public long j() {
        int size = this.f3867k.size();
        long j10 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            WidgetRun widgetRun = this.f3867k.get(i10);
            j10 = j10 + ((long) widgetRun.f3842h.f3819f) + widgetRun.j() + ((long) widgetRun.f3843i.f3819f);
        }
        return j10;
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        int size = this.f3867k.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!this.f3867k.get(i10).m()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder("ChainRun ");
        if (this.f3840f == 0) {
            str = "horizontal : ";
        } else {
            str = "vertical : ";
        }
        sb2.append(str);
        Iterator<WidgetRun> it = this.f3867k.iterator();
        while (it.hasNext()) {
            sb2.append("<");
            sb2.append(it.next());
            sb2.append("> ");
        }
        return sb2.toString();
    }
}
