package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.b;
import androidx.constraintlayout.core.widgets.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import q0.a;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private androidx.constraintlayout.core.widgets.d f3869a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3870b = true;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3871c = true;

    /* renamed from: d  reason: collision with root package name */
    private androidx.constraintlayout.core.widgets.d f3872d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<WidgetRun> f3873e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<k> f3874f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private b.C0027b f3875g = null;

    /* renamed from: h  reason: collision with root package name */
    private b.a f3876h = new b.a();

    /* renamed from: i  reason: collision with root package name */
    ArrayList<k> f3877i = new ArrayList<>();

    public d(androidx.constraintlayout.core.widgets.d dVar) {
        this.f3869a = dVar;
        this.f3872d = dVar;
    }

    private void a(DependencyNode dependencyNode, int i10, int i11, DependencyNode dependencyNode2, ArrayList<k> arrayList, k kVar) {
        WidgetRun widgetRun = dependencyNode.f3817d;
        if (widgetRun.f3837c == null) {
            androidx.constraintlayout.core.widgets.d dVar = this.f3869a;
            if (widgetRun != dVar.f3763e && widgetRun != dVar.f3765f) {
                if (kVar == null) {
                    kVar = new k(widgetRun, i11);
                    arrayList.add(kVar);
                }
                widgetRun.f3837c = kVar;
                kVar.a(widgetRun);
                for (a next : widgetRun.f3842h.f3824k) {
                    if (next instanceof DependencyNode) {
                        a((DependencyNode) next, i10, 0, dependencyNode2, arrayList, kVar);
                    }
                }
                for (a next2 : widgetRun.f3843i.f3824k) {
                    if (next2 instanceof DependencyNode) {
                        a((DependencyNode) next2, i10, 1, dependencyNode2, arrayList, kVar);
                    }
                }
                if (i10 == 1 && (widgetRun instanceof l)) {
                    for (a next3 : ((l) widgetRun).f3892k.f3824k) {
                        if (next3 instanceof DependencyNode) {
                            a((DependencyNode) next3, i10, 2, dependencyNode2, arrayList, kVar);
                        }
                    }
                }
                for (DependencyNode next4 : widgetRun.f3842h.f3825l) {
                    if (next4 == dependencyNode2) {
                        kVar.f3886b = true;
                    }
                    a(next4, i10, 0, dependencyNode2, arrayList, kVar);
                }
                for (DependencyNode next5 : widgetRun.f3843i.f3825l) {
                    if (next5 == dependencyNode2) {
                        kVar.f3886b = true;
                    }
                    a(next5, i10, 1, dependencyNode2, arrayList, kVar);
                }
                if (i10 == 1 && (widgetRun instanceof l)) {
                    for (DependencyNode a10 : ((l) widgetRun).f3892k.f3825l) {
                        a(a10, i10, 2, dependencyNode2, arrayList, kVar);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0280, code lost:
        r4 = r0.Z;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b(androidx.constraintlayout.core.widgets.d r17) {
        /*
            r16 = this;
            r0 = r17
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r1 = r0.L0
            java.util.Iterator r1 = r1.iterator()
        L_0x0008:
            boolean r2 = r1.hasNext()
            r3 = 0
            if (r2 == 0) goto L_0x0338
            java.lang.Object r2 = r1.next()
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r2.Z
            r5 = r4[r3]
            r10 = 1
            r4 = r4[r10]
            int r6 = r2.V()
            r7 = 8
            if (r6 != r7) goto L_0x0027
            r2.f3755a = r10
            goto L_0x0008
        L_0x0027:
            float r6 = r2.B
            r11 = 1065353216(0x3f800000, float:1.0)
            int r6 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            r7 = 2
            if (r6 >= 0) goto L_0x0036
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 != r6) goto L_0x0036
            r2.f3799w = r7
        L_0x0036:
            float r6 = r2.E
            int r6 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r6 >= 0) goto L_0x0042
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r4 != r6) goto L_0x0042
            r2.f3801x = r7
        L_0x0042:
            float r6 = r2.v()
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            r8 = 3
            if (r6 <= 0) goto L_0x0078
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 != r6) goto L_0x005b
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r4 == r9) goto L_0x0058
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r4 != r9) goto L_0x005b
        L_0x0058:
            r2.f3799w = r8
            goto L_0x0078
        L_0x005b:
            if (r4 != r6) goto L_0x0068
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r5 == r9) goto L_0x0065
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r5 != r9) goto L_0x0068
        L_0x0065:
            r2.f3801x = r8
            goto L_0x0078
        L_0x0068:
            if (r5 != r6) goto L_0x0078
            if (r4 != r6) goto L_0x0078
            int r6 = r2.f3799w
            if (r6 != 0) goto L_0x0072
            r2.f3799w = r8
        L_0x0072:
            int r6 = r2.f3801x
            if (r6 != 0) goto L_0x0078
            r2.f3801x = r8
        L_0x0078:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 != r6) goto L_0x008e
            int r9 = r2.f3799w
            if (r9 != r10) goto L_0x008e
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r2.O
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r9.f3740f
            if (r9 == 0) goto L_0x008c
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r2.Q
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r9.f3740f
            if (r9 != 0) goto L_0x008e
        L_0x008c:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
        L_0x008e:
            r9 = r5
            if (r4 != r6) goto L_0x00a3
            int r5 = r2.f3801x
            if (r5 != r10) goto L_0x00a3
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r2.P
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.f3740f
            if (r5 == 0) goto L_0x00a1
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r2.R
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.f3740f
            if (r5 != 0) goto L_0x00a3
        L_0x00a1:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
        L_0x00a3:
            r12 = r4
            androidx.constraintlayout.core.widgets.analyzer.j r4 = r2.f3763e
            r4.f3838d = r9
            int r5 = r2.f3799w
            r4.f3835a = r5
            androidx.constraintlayout.core.widgets.analyzer.l r4 = r2.f3765f
            r4.f3838d = r12
            int r13 = r2.f3801x
            r4.f3835a = r13
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r9 == r4) goto L_0x00c0
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r9 == r14) goto L_0x00c0
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r9 != r14) goto L_0x00cc
        L_0x00c0:
            if (r12 == r4) goto L_0x02e2
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r12 == r14) goto L_0x02e2
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r12 != r14) goto L_0x00cc
            goto L_0x02e2
        L_0x00cc:
            r14 = 1056964608(0x3f000000, float:0.5)
            if (r9 != r6) goto L_0x0199
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r15 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r12 == r15) goto L_0x00d8
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r12 != r11) goto L_0x0199
        L_0x00d8:
            if (r5 != r8) goto L_0x0113
            if (r12 != r15) goto L_0x00e6
            r7 = 0
            r9 = 0
            r4 = r16
            r5 = r2
            r6 = r15
            r8 = r15
            r4.l(r5, r6, r7, r8, r9)
        L_0x00e6:
            int r9 = r2.x()
            float r3 = (float) r9
            float r4 = r2.f3762d0
            float r3 = r3 * r4
            float r3 = r3 + r14
            int r7 = (int) r3
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r4 = r16
            r5 = r2
            r6 = r8
            r4.l(r5, r6, r7, r8, r9)
            androidx.constraintlayout.core.widgets.analyzer.j r3 = r2.f3763e
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f3839e
            int r4 = r2.W()
            r3.d(r4)
            androidx.constraintlayout.core.widgets.analyzer.l r3 = r2.f3765f
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f3839e
            int r4 = r2.x()
            r3.d(r4)
            r2.f3755a = r10
            goto L_0x0008
        L_0x0113:
            if (r5 != r10) goto L_0x012b
            r7 = 0
            r9 = 0
            r4 = r16
            r5 = r2
            r6 = r15
            r8 = r12
            r4.l(r5, r6, r7, r8, r9)
            androidx.constraintlayout.core.widgets.analyzer.j r3 = r2.f3763e
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f3839e
            int r2 = r2.W()
            r3.f3878m = r2
            goto L_0x0008
        L_0x012b:
            if (r5 != r7) goto L_0x0167
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r11 = r0.Z
            r11 = r11[r3]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r15 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r11 == r15) goto L_0x0137
            if (r11 != r4) goto L_0x0199
        L_0x0137:
            float r3 = r2.B
            int r4 = r17.W()
            float r4 = (float) r4
            float r3 = r3 * r4
            float r3 = r3 + r14
            int r7 = (int) r3
            int r9 = r2.x()
            r4 = r16
            r5 = r2
            r6 = r15
            r8 = r12
            r4.l(r5, r6, r7, r8, r9)
            androidx.constraintlayout.core.widgets.analyzer.j r3 = r2.f3763e
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f3839e
            int r4 = r2.W()
            r3.d(r4)
            androidx.constraintlayout.core.widgets.analyzer.l r3 = r2.f3765f
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f3839e
            int r4 = r2.x()
            r3.d(r4)
            r2.f3755a = r10
            goto L_0x0008
        L_0x0167:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r11 = r2.W
            r7 = r11[r3]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r7.f3740f
            if (r7 == 0) goto L_0x0175
            r7 = r11[r10]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r7.f3740f
            if (r7 != 0) goto L_0x0199
        L_0x0175:
            r7 = 0
            r9 = 0
            r4 = r16
            r5 = r2
            r6 = r15
            r8 = r12
            r4.l(r5, r6, r7, r8, r9)
            androidx.constraintlayout.core.widgets.analyzer.j r3 = r2.f3763e
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f3839e
            int r4 = r2.W()
            r3.d(r4)
            androidx.constraintlayout.core.widgets.analyzer.l r3 = r2.f3765f
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f3839e
            int r4 = r2.x()
            r3.d(r4)
            r2.f3755a = r10
            goto L_0x0008
        L_0x0199:
            if (r12 != r6) goto L_0x0272
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r9 == r11) goto L_0x01a3
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r9 != r7) goto L_0x0272
        L_0x01a3:
            if (r13 != r8) goto L_0x01e9
            if (r9 != r11) goto L_0x01b1
            r7 = 0
            r9 = 0
            r4 = r16
            r5 = r2
            r6 = r11
            r8 = r11
            r4.l(r5, r6, r7, r8, r9)
        L_0x01b1:
            int r7 = r2.W()
            float r3 = r2.f3762d0
            int r4 = r2.w()
            r5 = -1
            if (r4 != r5) goto L_0x01c2
            r4 = 1065353216(0x3f800000, float:1.0)
            float r3 = r4 / r3
        L_0x01c2:
            float r4 = (float) r7
            float r4 = r4 * r3
            float r4 = r4 + r14
            int r9 = (int) r4
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r4 = r16
            r5 = r2
            r6 = r8
            r4.l(r5, r6, r7, r8, r9)
            androidx.constraintlayout.core.widgets.analyzer.j r3 = r2.f3763e
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f3839e
            int r4 = r2.W()
            r3.d(r4)
            androidx.constraintlayout.core.widgets.analyzer.l r3 = r2.f3765f
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f3839e
            int r4 = r2.x()
            r3.d(r4)
            r2.f3755a = r10
            goto L_0x0008
        L_0x01e9:
            if (r13 != r10) goto L_0x0202
            r7 = 0
            r3 = 0
            r4 = r16
            r5 = r2
            r6 = r9
            r8 = r11
            r9 = r3
            r4.l(r5, r6, r7, r8, r9)
            androidx.constraintlayout.core.widgets.analyzer.l r3 = r2.f3765f
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f3839e
            int r2 = r2.x()
            r3.f3878m = r2
            goto L_0x0008
        L_0x0202:
            r7 = 2
            if (r13 != r7) goto L_0x023f
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r7 = r0.Z
            r7 = r7[r10]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r7 == r8) goto L_0x020f
            if (r7 != r4) goto L_0x0272
        L_0x020f:
            float r3 = r2.E
            int r7 = r2.W()
            int r4 = r17.x()
            float r4 = (float) r4
            float r3 = r3 * r4
            float r3 = r3 + r14
            int r3 = (int) r3
            r4 = r16
            r5 = r2
            r6 = r9
            r9 = r3
            r4.l(r5, r6, r7, r8, r9)
            androidx.constraintlayout.core.widgets.analyzer.j r3 = r2.f3763e
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f3839e
            int r4 = r2.W()
            r3.d(r4)
            androidx.constraintlayout.core.widgets.analyzer.l r3 = r2.f3765f
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f3839e
            int r4 = r2.x()
            r3.d(r4)
            r2.f3755a = r10
            goto L_0x0008
        L_0x023f:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r2.W
            r7 = 2
            r15 = r4[r7]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r15.f3740f
            if (r7 == 0) goto L_0x024e
            r4 = r4[r8]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.f3740f
            if (r4 != 0) goto L_0x0272
        L_0x024e:
            r7 = 0
            r9 = 0
            r4 = r16
            r5 = r2
            r6 = r11
            r8 = r12
            r4.l(r5, r6, r7, r8, r9)
            androidx.constraintlayout.core.widgets.analyzer.j r3 = r2.f3763e
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f3839e
            int r4 = r2.W()
            r3.d(r4)
            androidx.constraintlayout.core.widgets.analyzer.l r3 = r2.f3765f
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f3839e
            int r4 = r2.x()
            r3.d(r4)
            r2.f3755a = r10
            goto L_0x0008
        L_0x0272:
            if (r9 != r6) goto L_0x0008
            if (r12 != r6) goto L_0x0008
            if (r5 == r10) goto L_0x02c1
            if (r13 != r10) goto L_0x027b
            goto L_0x02c1
        L_0x027b:
            r4 = 2
            if (r13 != r4) goto L_0x0008
            if (r5 != r4) goto L_0x0008
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r0.Z
            r3 = r4[r3]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r3 != r8) goto L_0x0008
            r3 = r4[r10]
            if (r3 != r8) goto L_0x0008
            float r3 = r2.B
            float r4 = r2.E
            int r5 = r17.W()
            float r5 = (float) r5
            float r3 = r3 * r5
            float r3 = r3 + r14
            int r7 = (int) r3
            int r3 = r17.x()
            float r3 = (float) r3
            float r4 = r4 * r3
            float r4 = r4 + r14
            int r9 = (int) r4
            r4 = r16
            r5 = r2
            r6 = r8
            r4.l(r5, r6, r7, r8, r9)
            androidx.constraintlayout.core.widgets.analyzer.j r3 = r2.f3763e
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f3839e
            int r4 = r2.W()
            r3.d(r4)
            androidx.constraintlayout.core.widgets.analyzer.l r3 = r2.f3765f
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f3839e
            int r4 = r2.x()
            r3.d(r4)
            r2.f3755a = r10
            goto L_0x0008
        L_0x02c1:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r7 = 0
            r9 = 0
            r4 = r16
            r5 = r2
            r6 = r8
            r4.l(r5, r6, r7, r8, r9)
            androidx.constraintlayout.core.widgets.analyzer.j r3 = r2.f3763e
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f3839e
            int r4 = r2.W()
            r3.f3878m = r4
            androidx.constraintlayout.core.widgets.analyzer.l r3 = r2.f3765f
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f3839e
            int r2 = r2.x()
            r3.f3878m = r2
            goto L_0x0008
        L_0x02e2:
            int r3 = r2.W()
            if (r9 != r4) goto L_0x02fb
            int r3 = r17.W()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r2.O
            int r5 = r5.f3741g
            int r3 = r3 - r5
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r2.Q
            int r5 = r5.f3741g
            int r3 = r3 - r5
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r7 = r3
            r6 = r5
            goto L_0x02fd
        L_0x02fb:
            r7 = r3
            r6 = r9
        L_0x02fd:
            int r3 = r2.x()
            if (r12 != r4) goto L_0x0316
            int r3 = r17.x()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r2.P
            int r4 = r4.f3741g
            int r3 = r3 - r4
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r2.R
            int r4 = r4.f3741g
            int r3 = r3 - r4
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r9 = r3
            r8 = r4
            goto L_0x0318
        L_0x0316:
            r9 = r3
            r8 = r12
        L_0x0318:
            r4 = r16
            r5 = r2
            r4.l(r5, r6, r7, r8, r9)
            androidx.constraintlayout.core.widgets.analyzer.j r3 = r2.f3763e
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f3839e
            int r4 = r2.W()
            r3.d(r4)
            androidx.constraintlayout.core.widgets.analyzer.l r3 = r2.f3765f
            androidx.constraintlayout.core.widgets.analyzer.e r3 = r3.f3839e
            int r4 = r2.x()
            r3.d(r4)
            r2.f3755a = r10
            goto L_0x0008
        L_0x0338:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.d.b(androidx.constraintlayout.core.widgets.d):boolean");
    }

    private int e(androidx.constraintlayout.core.widgets.d dVar, int i10) {
        int size = this.f3877i.size();
        long j10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            j10 = Math.max(j10, this.f3877i.get(i11).b(dVar, i10));
        }
        return (int) j10;
    }

    private void i(WidgetRun widgetRun, int i10, ArrayList<k> arrayList) {
        for (a next : widgetRun.f3842h.f3824k) {
            if (next instanceof DependencyNode) {
                a((DependencyNode) next, i10, 0, widgetRun.f3843i, arrayList, (k) null);
            } else if (next instanceof WidgetRun) {
                a(((WidgetRun) next).f3842h, i10, 0, widgetRun.f3843i, arrayList, (k) null);
            }
        }
        for (a next2 : widgetRun.f3843i.f3824k) {
            if (next2 instanceof DependencyNode) {
                a((DependencyNode) next2, i10, 1, widgetRun.f3842h, arrayList, (k) null);
            } else if (next2 instanceof WidgetRun) {
                a(((WidgetRun) next2).f3843i, i10, 1, widgetRun.f3842h, arrayList, (k) null);
            }
        }
        if (i10 == 1) {
            for (a next3 : ((l) widgetRun).f3892k.f3824k) {
                if (next3 instanceof DependencyNode) {
                    a((DependencyNode) next3, i10, 2, (DependencyNode) null, arrayList, (k) null);
                }
            }
        }
    }

    private void l(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i10, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i11) {
        b.a aVar = this.f3876h;
        aVar.f3857a = dimensionBehaviour;
        aVar.f3858b = dimensionBehaviour2;
        aVar.f3859c = i10;
        aVar.f3860d = i11;
        this.f3875g.b(constraintWidget, aVar);
        constraintWidget.k1(this.f3876h.f3861e);
        constraintWidget.L0(this.f3876h.f3862f);
        constraintWidget.K0(this.f3876h.f3864h);
        constraintWidget.A0(this.f3876h.f3863g);
    }

    public void c() {
        d(this.f3873e);
        this.f3877i.clear();
        k.f3884h = 0;
        i(this.f3869a.f3763e, 0, this.f3877i);
        i(this.f3869a.f3765f, 1, this.f3877i);
        this.f3870b = false;
    }

    public void d(ArrayList<WidgetRun> arrayList) {
        arrayList.clear();
        this.f3872d.f3763e.f();
        this.f3872d.f3765f.f();
        arrayList.add(this.f3872d.f3763e);
        arrayList.add(this.f3872d.f3765f);
        Iterator<ConstraintWidget> it = this.f3872d.L0.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            if (next instanceof f) {
                arrayList.add(new h(next));
            } else {
                if (next.i0()) {
                    if (next.f3759c == null) {
                        next.f3759c = new c(next, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.f3759c);
                } else {
                    arrayList.add(next.f3763e);
                }
                if (next.k0()) {
                    if (next.f3761d == null) {
                        next.f3761d = new c(next, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.f3761d);
                } else {
                    arrayList.add(next.f3765f);
                }
                if (next instanceof p0.b) {
                    arrayList.add(new i(next));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<WidgetRun> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().f();
        }
        Iterator<WidgetRun> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            WidgetRun next2 = it3.next();
            if (next2.f3836b != this.f3872d) {
                next2.d();
            }
        }
    }

    public boolean f(boolean z10) {
        boolean z11;
        boolean z12 = true;
        boolean z13 = z10 & true;
        if (this.f3870b || this.f3871c) {
            Iterator<ConstraintWidget> it = this.f3869a.L0.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                next.n();
                next.f3755a = false;
                next.f3763e.r();
                next.f3765f.q();
            }
            this.f3869a.n();
            androidx.constraintlayout.core.widgets.d dVar = this.f3869a;
            dVar.f3755a = false;
            dVar.f3763e.r();
            this.f3869a.f3765f.q();
            this.f3871c = false;
        }
        if (b(this.f3872d)) {
            return false;
        }
        this.f3869a.m1(0);
        this.f3869a.n1(0);
        ConstraintWidget.DimensionBehaviour u10 = this.f3869a.u(0);
        ConstraintWidget.DimensionBehaviour u11 = this.f3869a.u(1);
        if (this.f3870b) {
            c();
        }
        int X = this.f3869a.X();
        int Y = this.f3869a.Y();
        this.f3869a.f3763e.f3842h.d(X);
        this.f3869a.f3765f.f3842h.d(Y);
        m();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (u10 == dimensionBehaviour || u11 == dimensionBehaviour) {
            if (z13) {
                Iterator<WidgetRun> it2 = this.f3873e.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (!it2.next().m()) {
                            z13 = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (z13 && u10 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.f3869a.P0(ConstraintWidget.DimensionBehaviour.FIXED);
                androidx.constraintlayout.core.widgets.d dVar2 = this.f3869a;
                dVar2.k1(e(dVar2, 0));
                androidx.constraintlayout.core.widgets.d dVar3 = this.f3869a;
                dVar3.f3763e.f3839e.d(dVar3.W());
            }
            if (z13 && u11 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.f3869a.g1(ConstraintWidget.DimensionBehaviour.FIXED);
                androidx.constraintlayout.core.widgets.d dVar4 = this.f3869a;
                dVar4.L0(e(dVar4, 1));
                androidx.constraintlayout.core.widgets.d dVar5 = this.f3869a;
                dVar5.f3765f.f3839e.d(dVar5.x());
            }
        }
        androidx.constraintlayout.core.widgets.d dVar6 = this.f3869a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dVar6.Z[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (dimensionBehaviour2 == dimensionBehaviour3 || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int W = dVar6.W() + X;
            this.f3869a.f3763e.f3843i.d(W);
            this.f3869a.f3763e.f3839e.d(W - X);
            m();
            androidx.constraintlayout.core.widgets.d dVar7 = this.f3869a;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = dVar7.Z[1];
            if (dimensionBehaviour4 == dimensionBehaviour3 || dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int x10 = dVar7.x() + Y;
                this.f3869a.f3765f.f3843i.d(x10);
                this.f3869a.f3765f.f3839e.d(x10 - Y);
            }
            m();
            z11 = true;
        } else {
            z11 = false;
        }
        Iterator<WidgetRun> it3 = this.f3873e.iterator();
        while (it3.hasNext()) {
            WidgetRun next2 = it3.next();
            if (next2.f3836b != this.f3869a || next2.f3841g) {
                next2.e();
            }
        }
        Iterator<WidgetRun> it4 = this.f3873e.iterator();
        while (true) {
            if (!it4.hasNext()) {
                break;
            }
            WidgetRun next3 = it4.next();
            if ((z11 || next3.f3836b != this.f3869a) && (!next3.f3842h.f3823j || ((!next3.f3843i.f3823j && !(next3 instanceof h)) || (!next3.f3839e.f3823j && !(next3 instanceof c) && !(next3 instanceof h))))) {
                z12 = false;
            }
        }
        z12 = false;
        this.f3869a.P0(u10);
        this.f3869a.g1(u11);
        return z12;
    }

    public boolean g(boolean z10) {
        if (this.f3870b) {
            Iterator<ConstraintWidget> it = this.f3869a.L0.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                next.n();
                next.f3755a = false;
                j jVar = next.f3763e;
                jVar.f3839e.f3823j = false;
                jVar.f3841g = false;
                jVar.r();
                l lVar = next.f3765f;
                lVar.f3839e.f3823j = false;
                lVar.f3841g = false;
                lVar.q();
            }
            this.f3869a.n();
            androidx.constraintlayout.core.widgets.d dVar = this.f3869a;
            dVar.f3755a = false;
            j jVar2 = dVar.f3763e;
            jVar2.f3839e.f3823j = false;
            jVar2.f3841g = false;
            jVar2.r();
            l lVar2 = this.f3869a.f3765f;
            lVar2.f3839e.f3823j = false;
            lVar2.f3841g = false;
            lVar2.q();
            c();
        }
        if (b(this.f3872d)) {
            return false;
        }
        this.f3869a.m1(0);
        this.f3869a.n1(0);
        this.f3869a.f3763e.f3842h.d(0);
        this.f3869a.f3765f.f3842h.d(0);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x013f A[EDGE_INSN: B:76:0x013f->B:62:0x013f ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean h(boolean r10, int r11) {
        /*
            r9 = this;
            r0 = 1
            r10 = r10 & r0
            androidx.constraintlayout.core.widgets.d r1 = r9.f3869a
            r2 = 0
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = r1.u(r2)
            androidx.constraintlayout.core.widgets.d r3 = r9.f3869a
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = r3.u(r0)
            androidx.constraintlayout.core.widgets.d r4 = r9.f3869a
            int r4 = r4.X()
            androidx.constraintlayout.core.widgets.d r5 = r9.f3869a
            int r5 = r5.Y()
            if (r10 == 0) goto L_0x0089
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r1 == r6) goto L_0x0023
            if (r3 != r6) goto L_0x0089
        L_0x0023:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r6 = r9.f3873e
            java.util.Iterator r6 = r6.iterator()
        L_0x0029:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0040
            java.lang.Object r7 = r6.next()
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r7 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r7
            int r8 = r7.f3840f
            if (r8 != r11) goto L_0x0029
            boolean r7 = r7.m()
            if (r7 != 0) goto L_0x0029
            r10 = r2
        L_0x0040:
            if (r11 != 0) goto L_0x0066
            if (r10 == 0) goto L_0x0089
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r1 != r10) goto L_0x0089
            androidx.constraintlayout.core.widgets.d r10 = r9.f3869a
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r10.P0(r6)
            androidx.constraintlayout.core.widgets.d r10 = r9.f3869a
            int r6 = r9.e(r10, r2)
            r10.k1(r6)
            androidx.constraintlayout.core.widgets.d r10 = r9.f3869a
            androidx.constraintlayout.core.widgets.analyzer.j r6 = r10.f3763e
            androidx.constraintlayout.core.widgets.analyzer.e r6 = r6.f3839e
            int r10 = r10.W()
            r6.d(r10)
            goto L_0x0089
        L_0x0066:
            if (r10 == 0) goto L_0x0089
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r3 != r10) goto L_0x0089
            androidx.constraintlayout.core.widgets.d r10 = r9.f3869a
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r10.g1(r6)
            androidx.constraintlayout.core.widgets.d r10 = r9.f3869a
            int r6 = r9.e(r10, r0)
            r10.L0(r6)
            androidx.constraintlayout.core.widgets.d r10 = r9.f3869a
            androidx.constraintlayout.core.widgets.analyzer.l r6 = r10.f3765f
            androidx.constraintlayout.core.widgets.analyzer.e r6 = r6.f3839e
            int r10 = r10.x()
            r6.d(r10)
        L_0x0089:
            if (r11 != 0) goto L_0x00b2
            androidx.constraintlayout.core.widgets.d r10 = r9.f3869a
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r10.Z
            r5 = r5[r2]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r5 == r6) goto L_0x0099
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r5 != r6) goto L_0x00c1
        L_0x0099:
            int r10 = r10.W()
            int r10 = r10 + r4
            androidx.constraintlayout.core.widgets.d r5 = r9.f3869a
            androidx.constraintlayout.core.widgets.analyzer.j r5 = r5.f3763e
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r5 = r5.f3843i
            r5.d(r10)
            androidx.constraintlayout.core.widgets.d r5 = r9.f3869a
            androidx.constraintlayout.core.widgets.analyzer.j r5 = r5.f3763e
            androidx.constraintlayout.core.widgets.analyzer.e r5 = r5.f3839e
            int r10 = r10 - r4
            r5.d(r10)
            goto L_0x00db
        L_0x00b2:
            androidx.constraintlayout.core.widgets.d r10 = r9.f3869a
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r10.Z
            r4 = r4[r0]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r4 == r6) goto L_0x00c3
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r4 != r6) goto L_0x00c1
            goto L_0x00c3
        L_0x00c1:
            r10 = r2
            goto L_0x00dc
        L_0x00c3:
            int r10 = r10.x()
            int r10 = r10 + r5
            androidx.constraintlayout.core.widgets.d r4 = r9.f3869a
            androidx.constraintlayout.core.widgets.analyzer.l r4 = r4.f3765f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r4 = r4.f3843i
            r4.d(r10)
            androidx.constraintlayout.core.widgets.d r4 = r9.f3869a
            androidx.constraintlayout.core.widgets.analyzer.l r4 = r4.f3765f
            androidx.constraintlayout.core.widgets.analyzer.e r4 = r4.f3839e
            int r10 = r10 - r5
            r4.d(r10)
        L_0x00db:
            r10 = r0
        L_0x00dc:
            r9.m()
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r4 = r9.f3873e
            java.util.Iterator r4 = r4.iterator()
        L_0x00e5:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0105
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r5 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r5
            int r6 = r5.f3840f
            if (r6 == r11) goto L_0x00f6
            goto L_0x00e5
        L_0x00f6:
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r5.f3836b
            androidx.constraintlayout.core.widgets.d r7 = r9.f3869a
            if (r6 != r7) goto L_0x0101
            boolean r6 = r5.f3841g
            if (r6 != 0) goto L_0x0101
            goto L_0x00e5
        L_0x0101:
            r5.e()
            goto L_0x00e5
        L_0x0105:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.analyzer.WidgetRun> r4 = r9.f3873e
            java.util.Iterator r4 = r4.iterator()
        L_0x010b:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x013f
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun r5 = (androidx.constraintlayout.core.widgets.analyzer.WidgetRun) r5
            int r6 = r5.f3840f
            if (r6 == r11) goto L_0x011c
            goto L_0x010b
        L_0x011c:
            if (r10 != 0) goto L_0x0125
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r5.f3836b
            androidx.constraintlayout.core.widgets.d r7 = r9.f3869a
            if (r6 != r7) goto L_0x0125
            goto L_0x010b
        L_0x0125:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r6 = r5.f3842h
            boolean r6 = r6.f3823j
            if (r6 != 0) goto L_0x012d
        L_0x012b:
            r0 = r2
            goto L_0x013f
        L_0x012d:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r6 = r5.f3843i
            boolean r6 = r6.f3823j
            if (r6 != 0) goto L_0x0134
            goto L_0x012b
        L_0x0134:
            boolean r6 = r5 instanceof androidx.constraintlayout.core.widgets.analyzer.c
            if (r6 != 0) goto L_0x010b
            androidx.constraintlayout.core.widgets.analyzer.e r5 = r5.f3839e
            boolean r5 = r5.f3823j
            if (r5 != 0) goto L_0x010b
            goto L_0x012b
        L_0x013f:
            androidx.constraintlayout.core.widgets.d r10 = r9.f3869a
            r10.P0(r1)
            androidx.constraintlayout.core.widgets.d r10 = r9.f3869a
            r10.g1(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.d.h(boolean, int):boolean");
    }

    public void j() {
        this.f3870b = true;
    }

    public void k() {
        this.f3871c = true;
    }

    public void m() {
        boolean z10;
        e eVar;
        Iterator<ConstraintWidget> it = this.f3869a.L0.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            if (!next.f3755a) {
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = next.Z;
                boolean z11 = false;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                int i10 = next.f3799w;
                int i11 = next.f3801x;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (dimensionBehaviour == dimensionBehaviour3 || (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i10 == 1)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (dimensionBehaviour2 == dimensionBehaviour3 || (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i11 == 1)) {
                    z11 = true;
                }
                e eVar2 = next.f3763e.f3839e;
                boolean z12 = eVar2.f3823j;
                e eVar3 = next.f3765f.f3839e;
                boolean z13 = eVar3.f3823j;
                if (z12 && z13) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                    l(next, dimensionBehaviour4, eVar2.f3820g, dimensionBehaviour4, eVar3.f3820g);
                    next.f3755a = true;
                } else if (z12 && z11) {
                    l(next, ConstraintWidget.DimensionBehaviour.FIXED, eVar2.f3820g, dimensionBehaviour3, eVar3.f3820g);
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        next.f3765f.f3839e.f3878m = next.x();
                    } else {
                        next.f3765f.f3839e.d(next.x());
                        next.f3755a = true;
                    }
                } else if (z13 && z10) {
                    l(next, dimensionBehaviour3, eVar2.f3820g, ConstraintWidget.DimensionBehaviour.FIXED, eVar3.f3820g);
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        next.f3763e.f3839e.f3878m = next.W();
                    } else {
                        next.f3763e.f3839e.d(next.W());
                        next.f3755a = true;
                    }
                }
                if (next.f3755a && (eVar = next.f3765f.f3893l) != null) {
                    eVar.d(next.p());
                }
            }
        }
    }

    public void n(b.C0027b bVar) {
        this.f3875g = bVar;
    }
}
