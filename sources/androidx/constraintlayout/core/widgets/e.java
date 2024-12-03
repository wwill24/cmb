package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.d;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

public class e extends h {
    /* access modifiers changed from: private */

    /* renamed from: a1  reason: collision with root package name */
    public int f3948a1 = -1;
    /* access modifiers changed from: private */

    /* renamed from: b1  reason: collision with root package name */
    public int f3949b1 = -1;
    /* access modifiers changed from: private */

    /* renamed from: c1  reason: collision with root package name */
    public int f3950c1 = -1;
    /* access modifiers changed from: private */

    /* renamed from: d1  reason: collision with root package name */
    public int f3951d1 = -1;
    /* access modifiers changed from: private */

    /* renamed from: e1  reason: collision with root package name */
    public int f3952e1 = -1;
    /* access modifiers changed from: private */

    /* renamed from: f1  reason: collision with root package name */
    public int f3953f1 = -1;
    /* access modifiers changed from: private */

    /* renamed from: g1  reason: collision with root package name */
    public float f3954g1 = 0.5f;
    /* access modifiers changed from: private */

    /* renamed from: h1  reason: collision with root package name */
    public float f3955h1 = 0.5f;
    /* access modifiers changed from: private */

    /* renamed from: i1  reason: collision with root package name */
    public float f3956i1 = 0.5f;
    /* access modifiers changed from: private */

    /* renamed from: j1  reason: collision with root package name */
    public float f3957j1 = 0.5f;
    /* access modifiers changed from: private */

    /* renamed from: k1  reason: collision with root package name */
    public float f3958k1 = 0.5f;
    /* access modifiers changed from: private */

    /* renamed from: l1  reason: collision with root package name */
    public float f3959l1 = 0.5f;
    /* access modifiers changed from: private */

    /* renamed from: m1  reason: collision with root package name */
    public int f3960m1 = 0;
    /* access modifiers changed from: private */

    /* renamed from: n1  reason: collision with root package name */
    public int f3961n1 = 0;
    /* access modifiers changed from: private */

    /* renamed from: o1  reason: collision with root package name */
    public int f3962o1 = 2;
    /* access modifiers changed from: private */

    /* renamed from: p1  reason: collision with root package name */
    public int f3963p1 = 2;

    /* renamed from: q1  reason: collision with root package name */
    private int f3964q1 = 0;

    /* renamed from: r1  reason: collision with root package name */
    private int f3965r1 = -1;

    /* renamed from: s1  reason: collision with root package name */
    private int f3966s1 = 0;

    /* renamed from: t1  reason: collision with root package name */
    private ArrayList<a> f3967t1 = new ArrayList<>();

    /* renamed from: u1  reason: collision with root package name */
    private ConstraintWidget[] f3968u1 = null;

    /* renamed from: v1  reason: collision with root package name */
    private ConstraintWidget[] f3969v1 = null;

    /* renamed from: w1  reason: collision with root package name */
    private int[] f3970w1 = null;
    /* access modifiers changed from: private */

    /* renamed from: x1  reason: collision with root package name */
    public ConstraintWidget[] f3971x1;
    /* access modifiers changed from: private */

    /* renamed from: y1  reason: collision with root package name */
    public int f3972y1 = 0;

    private class a {

        /* renamed from: a  reason: collision with root package name */
        private int f3973a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public ConstraintWidget f3974b = null;

        /* renamed from: c  reason: collision with root package name */
        int f3975c = 0;

        /* renamed from: d  reason: collision with root package name */
        private ConstraintAnchor f3976d;

        /* renamed from: e  reason: collision with root package name */
        private ConstraintAnchor f3977e;

        /* renamed from: f  reason: collision with root package name */
        private ConstraintAnchor f3978f;

        /* renamed from: g  reason: collision with root package name */
        private ConstraintAnchor f3979g;

        /* renamed from: h  reason: collision with root package name */
        private int f3980h = 0;

        /* renamed from: i  reason: collision with root package name */
        private int f3981i = 0;

        /* renamed from: j  reason: collision with root package name */
        private int f3982j = 0;

        /* renamed from: k  reason: collision with root package name */
        private int f3983k = 0;

        /* renamed from: l  reason: collision with root package name */
        private int f3984l = 0;

        /* renamed from: m  reason: collision with root package name */
        private int f3985m = 0;

        /* renamed from: n  reason: collision with root package name */
        private int f3986n = 0;

        /* renamed from: o  reason: collision with root package name */
        private int f3987o = 0;

        /* renamed from: p  reason: collision with root package name */
        private int f3988p = 0;

        /* renamed from: q  reason: collision with root package name */
        private int f3989q = 0;

        public a(int i10, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i11) {
            this.f3973a = i10;
            this.f3976d = constraintAnchor;
            this.f3977e = constraintAnchor2;
            this.f3978f = constraintAnchor3;
            this.f3979g = constraintAnchor4;
            this.f3980h = e.this.z1();
            this.f3981i = e.this.B1();
            this.f3982j = e.this.A1();
            this.f3983k = e.this.y1();
            this.f3989q = i11;
        }

        private void h() {
            this.f3984l = 0;
            this.f3985m = 0;
            this.f3974b = null;
            this.f3975c = 0;
            int i10 = this.f3987o;
            int i11 = 0;
            while (i11 < i10 && this.f3986n + i11 < e.this.f3972y1) {
                ConstraintWidget constraintWidget = e.this.f3971x1[this.f3986n + i11];
                if (this.f3973a == 0) {
                    int W = constraintWidget.W();
                    int P1 = e.this.f3960m1;
                    if (constraintWidget.V() == 8) {
                        P1 = 0;
                    }
                    this.f3984l += W + P1;
                    int c22 = e.this.k2(constraintWidget, this.f3989q);
                    if (this.f3974b == null || this.f3975c < c22) {
                        this.f3974b = constraintWidget;
                        this.f3975c = c22;
                        this.f3985m = c22;
                    }
                } else {
                    int b22 = e.this.l2(constraintWidget, this.f3989q);
                    int c23 = e.this.k2(constraintWidget, this.f3989q);
                    int Q1 = e.this.f3961n1;
                    if (constraintWidget.V() == 8) {
                        Q1 = 0;
                    }
                    this.f3985m += c23 + Q1;
                    if (this.f3974b == null || this.f3975c < b22) {
                        this.f3974b = constraintWidget;
                        this.f3975c = b22;
                        this.f3984l = b22;
                    }
                }
                i11++;
            }
        }

        public void b(ConstraintWidget constraintWidget) {
            int i10 = 0;
            if (this.f3973a == 0) {
                int b22 = e.this.l2(constraintWidget, this.f3989q);
                if (constraintWidget.A() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.f3988p++;
                    b22 = 0;
                }
                int P1 = e.this.f3960m1;
                if (constraintWidget.V() != 8) {
                    i10 = P1;
                }
                this.f3984l += b22 + i10;
                int c22 = e.this.k2(constraintWidget, this.f3989q);
                if (this.f3974b == null || this.f3975c < c22) {
                    this.f3974b = constraintWidget;
                    this.f3975c = c22;
                    this.f3985m = c22;
                }
            } else {
                int b23 = e.this.l2(constraintWidget, this.f3989q);
                int c23 = e.this.k2(constraintWidget, this.f3989q);
                if (constraintWidget.T() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.f3988p++;
                    c23 = 0;
                }
                int Q1 = e.this.f3961n1;
                if (constraintWidget.V() != 8) {
                    i10 = Q1;
                }
                this.f3985m += c23 + i10;
                if (this.f3974b == null || this.f3975c < b23) {
                    this.f3974b = constraintWidget;
                    this.f3975c = b23;
                    this.f3984l = b23;
                }
            }
            this.f3987o++;
        }

        public void c() {
            this.f3975c = 0;
            this.f3974b = null;
            this.f3984l = 0;
            this.f3985m = 0;
            this.f3986n = 0;
            this.f3987o = 0;
            this.f3988p = 0;
        }

        /* JADX WARNING: Removed duplicated region for block: B:57:0x00e1  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void d(boolean r17, int r18, boolean r19) {
            /*
                r16 = this;
                r0 = r16
                int r1 = r0.f3987o
                r2 = 0
                r3 = r2
            L_0x0006:
                if (r3 >= r1) goto L_0x0027
                int r4 = r0.f3986n
                int r4 = r4 + r3
                androidx.constraintlayout.core.widgets.e r5 = androidx.constraintlayout.core.widgets.e.this
                int r5 = r5.f3972y1
                if (r4 < r5) goto L_0x0014
                goto L_0x0027
            L_0x0014:
                androidx.constraintlayout.core.widgets.e r4 = androidx.constraintlayout.core.widgets.e.this
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r4 = r4.f3971x1
                int r5 = r0.f3986n
                int r5 = r5 + r3
                r4 = r4[r5]
                if (r4 == 0) goto L_0x0024
                r4.u0()
            L_0x0024:
                int r3 = r3 + 1
                goto L_0x0006
            L_0x0027:
                if (r1 == 0) goto L_0x0384
                androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f3974b
                if (r3 != 0) goto L_0x002f
                goto L_0x0384
            L_0x002f:
                if (r19 == 0) goto L_0x0035
                if (r18 != 0) goto L_0x0035
                r4 = 1
                goto L_0x0036
            L_0x0035:
                r4 = r2
            L_0x0036:
                r5 = -1
                r6 = r2
                r7 = r5
                r8 = r7
            L_0x003a:
                if (r6 >= r1) goto L_0x0069
                if (r17 == 0) goto L_0x0042
                int r9 = r1 + -1
                int r9 = r9 - r6
                goto L_0x0043
            L_0x0042:
                r9 = r6
            L_0x0043:
                int r10 = r0.f3986n
                int r10 = r10 + r9
                androidx.constraintlayout.core.widgets.e r11 = androidx.constraintlayout.core.widgets.e.this
                int r11 = r11.f3972y1
                if (r10 < r11) goto L_0x004f
                goto L_0x0069
            L_0x004f:
                androidx.constraintlayout.core.widgets.e r10 = androidx.constraintlayout.core.widgets.e.this
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r10 = r10.f3971x1
                int r11 = r0.f3986n
                int r11 = r11 + r9
                r9 = r10[r11]
                if (r9 == 0) goto L_0x0066
                int r9 = r9.V()
                if (r9 != 0) goto L_0x0066
                if (r7 != r5) goto L_0x0065
                r7 = r6
            L_0x0065:
                r8 = r6
            L_0x0066:
                int r6 = r6 + 1
                goto L_0x003a
            L_0x0069:
                r6 = 0
                int r9 = r0.f3973a
                if (r9 != 0) goto L_0x020e
                androidx.constraintlayout.core.widgets.ConstraintWidget r9 = r0.f3974b
                androidx.constraintlayout.core.widgets.e r10 = androidx.constraintlayout.core.widgets.e.this
                int r10 = r10.f3949b1
                r9.e1(r10)
                int r10 = r0.f3981i
                if (r18 <= 0) goto L_0x0084
                androidx.constraintlayout.core.widgets.e r11 = androidx.constraintlayout.core.widgets.e.this
                int r11 = r11.f3961n1
                int r10 = r10 + r11
            L_0x0084:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r9.P
                androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r0.f3977e
                r11.a(r12, r10)
                if (r19 == 0) goto L_0x0096
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r9.R
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.f3979g
                int r12 = r0.f3983k
                r10.a(r11, r12)
            L_0x0096:
                if (r18 <= 0) goto L_0x00a3
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r0.f3977e
                androidx.constraintlayout.core.widgets.ConstraintWidget r10 = r10.f3738d
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r10.R
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r9.P
                r10.a(r11, r2)
            L_0x00a3:
                androidx.constraintlayout.core.widgets.e r10 = androidx.constraintlayout.core.widgets.e.this
                int r10 = r10.f3963p1
                r11 = 3
                if (r10 != r11) goto L_0x00dd
                boolean r10 = r9.Z()
                if (r10 != 0) goto L_0x00dd
                r10 = r2
            L_0x00b3:
                if (r10 >= r1) goto L_0x00dd
                if (r17 == 0) goto L_0x00bb
                int r12 = r1 + -1
                int r12 = r12 - r10
                goto L_0x00bc
            L_0x00bb:
                r12 = r10
            L_0x00bc:
                int r13 = r0.f3986n
                int r13 = r13 + r12
                androidx.constraintlayout.core.widgets.e r14 = androidx.constraintlayout.core.widgets.e.this
                int r14 = r14.f3972y1
                if (r13 < r14) goto L_0x00c8
                goto L_0x00dd
            L_0x00c8:
                androidx.constraintlayout.core.widgets.e r13 = androidx.constraintlayout.core.widgets.e.this
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r13 = r13.f3971x1
                int r14 = r0.f3986n
                int r14 = r14 + r12
                r12 = r13[r14]
                boolean r13 = r12.Z()
                if (r13 == 0) goto L_0x00da
                goto L_0x00de
            L_0x00da:
                int r10 = r10 + 1
                goto L_0x00b3
            L_0x00dd:
                r12 = r9
            L_0x00de:
                r10 = r2
            L_0x00df:
                if (r10 >= r1) goto L_0x0384
                if (r17 == 0) goto L_0x00e7
                int r13 = r1 + -1
                int r13 = r13 - r10
                goto L_0x00e8
            L_0x00e7:
                r13 = r10
            L_0x00e8:
                int r14 = r0.f3986n
                int r14 = r14 + r13
                androidx.constraintlayout.core.widgets.e r15 = androidx.constraintlayout.core.widgets.e.this
                int r15 = r15.f3972y1
                if (r14 < r15) goto L_0x00f5
                goto L_0x0384
            L_0x00f5:
                androidx.constraintlayout.core.widgets.e r14 = androidx.constraintlayout.core.widgets.e.this
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r14 = r14.f3971x1
                int r15 = r0.f3986n
                int r15 = r15 + r13
                r14 = r14[r15]
                if (r14 != 0) goto L_0x0106
                r14 = r6
                r6 = r11
                goto L_0x0208
            L_0x0106:
                if (r10 != 0) goto L_0x0111
                androidx.constraintlayout.core.widgets.ConstraintAnchor r15 = r14.O
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.f3976d
                int r3 = r0.f3980h
                r14.k(r15, r11, r3)
            L_0x0111:
                if (r13 != 0) goto L_0x016f
                androidx.constraintlayout.core.widgets.e r3 = androidx.constraintlayout.core.widgets.e.this
                int r3 = r3.f3948a1
                r11 = 1065353216(0x3f800000, float:1.0)
                androidx.constraintlayout.core.widgets.e r13 = androidx.constraintlayout.core.widgets.e.this
                float r13 = r13.f3954g1
                if (r17 == 0) goto L_0x0125
                float r13 = r11 - r13
            L_0x0125:
                int r15 = r0.f3986n
                if (r15 != 0) goto L_0x0149
                androidx.constraintlayout.core.widgets.e r15 = androidx.constraintlayout.core.widgets.e.this
                int r15 = r15.f3950c1
                if (r15 == r5) goto L_0x0149
                androidx.constraintlayout.core.widgets.e r3 = androidx.constraintlayout.core.widgets.e.this
                int r3 = r3.f3950c1
                if (r17 == 0) goto L_0x0141
                androidx.constraintlayout.core.widgets.e r13 = androidx.constraintlayout.core.widgets.e.this
                float r13 = r13.f3956i1
            L_0x013f:
                float r11 = r11 - r13
                goto L_0x0147
            L_0x0141:
                androidx.constraintlayout.core.widgets.e r11 = androidx.constraintlayout.core.widgets.e.this
                float r11 = r11.f3956i1
            L_0x0147:
                r13 = r11
                goto L_0x0169
            L_0x0149:
                if (r19 == 0) goto L_0x0169
                androidx.constraintlayout.core.widgets.e r15 = androidx.constraintlayout.core.widgets.e.this
                int r15 = r15.f3952e1
                if (r15 == r5) goto L_0x0169
                androidx.constraintlayout.core.widgets.e r3 = androidx.constraintlayout.core.widgets.e.this
                int r3 = r3.f3952e1
                if (r17 == 0) goto L_0x0162
                androidx.constraintlayout.core.widgets.e r13 = androidx.constraintlayout.core.widgets.e.this
                float r13 = r13.f3958k1
                goto L_0x013f
            L_0x0162:
                androidx.constraintlayout.core.widgets.e r11 = androidx.constraintlayout.core.widgets.e.this
                float r11 = r11.f3958k1
                goto L_0x0147
            L_0x0169:
                r14.N0(r3)
                r14.M0(r13)
            L_0x016f:
                int r3 = r1 + -1
                if (r10 != r3) goto L_0x017c
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.Q
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.f3978f
                int r13 = r0.f3982j
                r14.k(r3, r11, r13)
            L_0x017c:
                if (r6 == 0) goto L_0x01a7
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.O
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r6.Q
                androidx.constraintlayout.core.widgets.e r13 = androidx.constraintlayout.core.widgets.e.this
                int r13 = r13.f3960m1
                r3.a(r11, r13)
                if (r10 != r7) goto L_0x0194
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.O
                int r11 = r0.f3980h
                r3.u(r11)
            L_0x0194:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r6.Q
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r14.O
                r3.a(r11, r2)
                r3 = 1
                int r11 = r8 + 1
                if (r10 != r11) goto L_0x01a7
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r6.Q
                int r6 = r0.f3982j
                r3.u(r6)
            L_0x01a7:
                if (r14 == r9) goto L_0x0207
                androidx.constraintlayout.core.widgets.e r3 = androidx.constraintlayout.core.widgets.e.this
                int r3 = r3.f3963p1
                r6 = 3
                if (r3 != r6) goto L_0x01c8
                boolean r3 = r12.Z()
                if (r3 == 0) goto L_0x01c8
                if (r14 == r12) goto L_0x01c8
                boolean r3 = r14.Z()
                if (r3 == 0) goto L_0x01c8
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.S
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r12.S
                r3.a(r11, r2)
                goto L_0x0208
            L_0x01c8:
                androidx.constraintlayout.core.widgets.e r3 = androidx.constraintlayout.core.widgets.e.this
                int r3 = r3.f3963p1
                if (r3 == 0) goto L_0x01ff
                r11 = 1
                if (r3 == r11) goto L_0x01f7
                if (r4 == 0) goto L_0x01e8
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.P
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.f3977e
                int r13 = r0.f3981i
                r3.a(r11, r13)
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.R
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.f3979g
                int r13 = r0.f3983k
                r3.a(r11, r13)
                goto L_0x0208
            L_0x01e8:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.P
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r9.P
                r3.a(r11, r2)
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.R
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r9.R
                r3.a(r11, r2)
                goto L_0x0208
            L_0x01f7:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.R
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r9.R
                r3.a(r11, r2)
                goto L_0x0208
            L_0x01ff:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r14.P
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r9.P
                r3.a(r11, r2)
                goto L_0x0208
            L_0x0207:
                r6 = 3
            L_0x0208:
                int r10 = r10 + 1
                r11 = r6
                r6 = r14
                goto L_0x00df
            L_0x020e:
                androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f3974b
                androidx.constraintlayout.core.widgets.e r9 = androidx.constraintlayout.core.widgets.e.this
                int r9 = r9.f3948a1
                r3.N0(r9)
                int r9 = r0.f3980h
                if (r18 <= 0) goto L_0x0224
                androidx.constraintlayout.core.widgets.e r10 = androidx.constraintlayout.core.widgets.e.this
                int r10 = r10.f3960m1
                int r9 = r9 + r10
            L_0x0224:
                if (r17 == 0) goto L_0x0246
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r3.Q
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.f3978f
                r10.a(r11, r9)
                if (r19 == 0) goto L_0x0238
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r3.O
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r0.f3976d
                int r11 = r0.f3982j
                r9.a(r10, r11)
            L_0x0238:
                if (r18 <= 0) goto L_0x0265
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r0.f3978f
                androidx.constraintlayout.core.widgets.ConstraintWidget r9 = r9.f3738d
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r9.O
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r3.Q
                r9.a(r10, r2)
                goto L_0x0265
            L_0x0246:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r3.O
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.f3976d
                r10.a(r11, r9)
                if (r19 == 0) goto L_0x0258
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r3.Q
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r0.f3978f
                int r11 = r0.f3982j
                r9.a(r10, r11)
            L_0x0258:
                if (r18 <= 0) goto L_0x0265
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r0.f3976d
                androidx.constraintlayout.core.widgets.ConstraintWidget r9 = r9.f3738d
                androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r9.Q
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r3.O
                r9.a(r10, r2)
            L_0x0265:
                r9 = r2
            L_0x0266:
                if (r9 >= r1) goto L_0x0384
                int r10 = r0.f3986n
                int r10 = r10 + r9
                androidx.constraintlayout.core.widgets.e r11 = androidx.constraintlayout.core.widgets.e.this
                int r11 = r11.f3972y1
                if (r10 < r11) goto L_0x0275
                goto L_0x0384
            L_0x0275:
                androidx.constraintlayout.core.widgets.e r10 = androidx.constraintlayout.core.widgets.e.this
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r10 = r10.f3971x1
                int r11 = r0.f3986n
                int r11 = r11 + r9
                r10 = r10[r11]
                if (r10 != 0) goto L_0x0285
                r12 = 1
                goto L_0x0380
            L_0x0285:
                if (r9 != 0) goto L_0x02d1
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r10.P
                androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r0.f3977e
                int r13 = r0.f3981i
                r10.k(r11, r12, r13)
                androidx.constraintlayout.core.widgets.e r11 = androidx.constraintlayout.core.widgets.e.this
                int r11 = r11.f3949b1
                androidx.constraintlayout.core.widgets.e r12 = androidx.constraintlayout.core.widgets.e.this
                float r12 = r12.f3955h1
                int r13 = r0.f3986n
                if (r13 != 0) goto L_0x02b5
                androidx.constraintlayout.core.widgets.e r13 = androidx.constraintlayout.core.widgets.e.this
                int r13 = r13.f3951d1
                if (r13 == r5) goto L_0x02b5
                androidx.constraintlayout.core.widgets.e r11 = androidx.constraintlayout.core.widgets.e.this
                int r11 = r11.f3951d1
                androidx.constraintlayout.core.widgets.e r12 = androidx.constraintlayout.core.widgets.e.this
                float r12 = r12.f3957j1
                goto L_0x02cb
            L_0x02b5:
                if (r19 == 0) goto L_0x02cb
                androidx.constraintlayout.core.widgets.e r13 = androidx.constraintlayout.core.widgets.e.this
                int r13 = r13.f3953f1
                if (r13 == r5) goto L_0x02cb
                androidx.constraintlayout.core.widgets.e r11 = androidx.constraintlayout.core.widgets.e.this
                int r11 = r11.f3953f1
                androidx.constraintlayout.core.widgets.e r12 = androidx.constraintlayout.core.widgets.e.this
                float r12 = r12.f3959l1
            L_0x02cb:
                r10.e1(r11)
                r10.d1(r12)
            L_0x02d1:
                int r11 = r1 + -1
                if (r9 != r11) goto L_0x02de
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r10.R
                androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r0.f3979g
                int r13 = r0.f3983k
                r10.k(r11, r12, r13)
            L_0x02de:
                if (r6 == 0) goto L_0x0309
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r10.P
                androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r6.R
                androidx.constraintlayout.core.widgets.e r13 = androidx.constraintlayout.core.widgets.e.this
                int r13 = r13.f3961n1
                r11.a(r12, r13)
                if (r9 != r7) goto L_0x02f6
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r10.P
                int r12 = r0.f3981i
                r11.u(r12)
            L_0x02f6:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r6.R
                androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r10.P
                r11.a(r12, r2)
                r11 = 1
                int r12 = r8 + 1
                if (r9 != r12) goto L_0x0309
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r6.R
                int r11 = r0.f3983k
                r6.u(r11)
            L_0x0309:
                if (r10 == r3) goto L_0x037e
                r6 = 2
                if (r17 == 0) goto L_0x033b
                androidx.constraintlayout.core.widgets.e r11 = androidx.constraintlayout.core.widgets.e.this
                int r11 = r11.f3962o1
                if (r11 == 0) goto L_0x0333
                r12 = 1
                if (r11 == r12) goto L_0x032b
                if (r11 == r6) goto L_0x031c
                goto L_0x037e
            L_0x031c:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r10.O
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.O
                r6.a(r11, r2)
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r10.Q
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.Q
                r6.a(r11, r2)
                goto L_0x037e
            L_0x032b:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r10.O
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.O
                r6.a(r11, r2)
                goto L_0x037e
            L_0x0333:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r10.Q
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.Q
                r6.a(r11, r2)
                goto L_0x037e
            L_0x033b:
                androidx.constraintlayout.core.widgets.e r11 = androidx.constraintlayout.core.widgets.e.this
                int r11 = r11.f3962o1
                if (r11 == 0) goto L_0x0375
                r12 = 1
                if (r11 == r12) goto L_0x036d
                if (r11 == r6) goto L_0x0349
                goto L_0x037f
            L_0x0349:
                if (r4 == 0) goto L_0x035e
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r10.O
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.f3976d
                int r13 = r0.f3980h
                r6.a(r11, r13)
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r10.Q
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r0.f3978f
                int r13 = r0.f3982j
                r6.a(r11, r13)
                goto L_0x037f
            L_0x035e:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r10.O
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.O
                r6.a(r11, r2)
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r10.Q
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.Q
                r6.a(r11, r2)
                goto L_0x037f
            L_0x036d:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r10.Q
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.Q
                r6.a(r11, r2)
                goto L_0x037f
            L_0x0375:
                r12 = 1
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r10.O
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r3.O
                r6.a(r11, r2)
                goto L_0x037f
            L_0x037e:
                r12 = 1
            L_0x037f:
                r6 = r10
            L_0x0380:
                int r9 = r9 + 1
                goto L_0x0266
            L_0x0384:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.e.a.d(boolean, int, boolean):void");
        }

        public int e() {
            if (this.f3973a == 1) {
                return this.f3985m - e.this.f3961n1;
            }
            return this.f3985m;
        }

        public int f() {
            if (this.f3973a == 0) {
                return this.f3984l - e.this.f3960m1;
            }
            return this.f3984l;
        }

        public void g(int i10) {
            int i11 = this.f3988p;
            if (i11 != 0) {
                int i12 = this.f3987o;
                int i13 = i10 / i11;
                int i14 = 0;
                while (i14 < i12 && this.f3986n + i14 < e.this.f3972y1) {
                    ConstraintWidget constraintWidget = e.this.f3971x1[this.f3986n + i14];
                    if (this.f3973a == 0) {
                        if (constraintWidget != null && constraintWidget.A() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.f3799w == 0) {
                            e.this.D1(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i13, constraintWidget.T(), constraintWidget.x());
                        }
                    } else if (constraintWidget != null && constraintWidget.T() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.f3801x == 0) {
                        e.this.D1(constraintWidget, constraintWidget.A(), constraintWidget.W(), ConstraintWidget.DimensionBehaviour.FIXED, i13);
                    }
                    i14++;
                }
                h();
            }
        }

        public void i(int i10) {
            this.f3986n = i10;
        }

        public void j(int i10, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i11, int i12, int i13, int i14, int i15) {
            this.f3973a = i10;
            this.f3976d = constraintAnchor;
            this.f3977e = constraintAnchor2;
            this.f3978f = constraintAnchor3;
            this.f3979g = constraintAnchor4;
            this.f3980h = i11;
            this.f3981i = i12;
            this.f3982j = i13;
            this.f3983k = i14;
            this.f3989q = i15;
        }
    }

    private void j2(boolean z10) {
        ConstraintWidget constraintWidget;
        float f10;
        int i10;
        if (this.f3970w1 != null && this.f3969v1 != null && this.f3968u1 != null) {
            for (int i11 = 0; i11 < this.f3972y1; i11++) {
                this.f3971x1[i11].u0();
            }
            int[] iArr = this.f3970w1;
            int i12 = iArr[0];
            int i13 = iArr[1];
            ConstraintWidget constraintWidget2 = null;
            float f11 = this.f3954g1;
            int i14 = 0;
            while (i14 < i12) {
                if (z10) {
                    i10 = (i12 - i14) - 1;
                    f10 = 1.0f - this.f3954g1;
                } else {
                    f10 = f11;
                    i10 = i14;
                }
                ConstraintWidget constraintWidget3 = this.f3969v1[i10];
                if (!(constraintWidget3 == null || constraintWidget3.V() == 8)) {
                    if (i14 == 0) {
                        constraintWidget3.k(constraintWidget3.O, this.O, z1());
                        constraintWidget3.N0(this.f3948a1);
                        constraintWidget3.M0(f10);
                    }
                    if (i14 == i12 - 1) {
                        constraintWidget3.k(constraintWidget3.Q, this.Q, A1());
                    }
                    if (i14 > 0 && constraintWidget2 != null) {
                        constraintWidget3.k(constraintWidget3.O, constraintWidget2.Q, this.f3960m1);
                        constraintWidget2.k(constraintWidget2.Q, constraintWidget3.O, 0);
                    }
                    constraintWidget2 = constraintWidget3;
                }
                i14++;
                f11 = f10;
            }
            for (int i15 = 0; i15 < i13; i15++) {
                ConstraintWidget constraintWidget4 = this.f3968u1[i15];
                if (!(constraintWidget4 == null || constraintWidget4.V() == 8)) {
                    if (i15 == 0) {
                        constraintWidget4.k(constraintWidget4.P, this.P, B1());
                        constraintWidget4.e1(this.f3949b1);
                        constraintWidget4.d1(this.f3955h1);
                    }
                    if (i15 == i13 - 1) {
                        constraintWidget4.k(constraintWidget4.R, this.R, y1());
                    }
                    if (i15 > 0 && constraintWidget2 != null) {
                        constraintWidget4.k(constraintWidget4.P, constraintWidget2.R, this.f3961n1);
                        constraintWidget2.k(constraintWidget2.R, constraintWidget4.P, 0);
                    }
                    constraintWidget2 = constraintWidget4;
                }
            }
            for (int i16 = 0; i16 < i12; i16++) {
                for (int i17 = 0; i17 < i13; i17++) {
                    int i18 = (i17 * i12) + i16;
                    if (this.f3966s1 == 1) {
                        i18 = (i16 * i13) + i17;
                    }
                    ConstraintWidget[] constraintWidgetArr = this.f3971x1;
                    if (!(i18 >= constraintWidgetArr.length || (constraintWidget = constraintWidgetArr[i18]) == null || constraintWidget.V() == 8)) {
                        ConstraintWidget constraintWidget5 = this.f3969v1[i16];
                        ConstraintWidget constraintWidget6 = this.f3968u1[i17];
                        if (constraintWidget != constraintWidget5) {
                            constraintWidget.k(constraintWidget.O, constraintWidget5.O, 0);
                            constraintWidget.k(constraintWidget.Q, constraintWidget5.Q, 0);
                        }
                        if (constraintWidget != constraintWidget6) {
                            constraintWidget.k(constraintWidget.P, constraintWidget6.P, 0);
                            constraintWidget.k(constraintWidget.R, constraintWidget6.R, 0);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final int k2(ConstraintWidget constraintWidget, int i10) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.T() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i11 = constraintWidget.f3801x;
            if (i11 == 0) {
                return 0;
            }
            if (i11 == 2) {
                int i12 = (int) (constraintWidget.E * ((float) i10));
                if (i12 != constraintWidget.x()) {
                    constraintWidget.Y0(true);
                    D1(constraintWidget, constraintWidget.A(), constraintWidget.W(), ConstraintWidget.DimensionBehaviour.FIXED, i12);
                }
                return i12;
            } else if (i11 == 1) {
                return constraintWidget.x();
            } else {
                if (i11 == 3) {
                    return (int) ((((float) constraintWidget.W()) * constraintWidget.f3762d0) + 0.5f);
                }
            }
        }
        return constraintWidget.x();
    }

    /* access modifiers changed from: private */
    public final int l2(ConstraintWidget constraintWidget, int i10) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.A() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i11 = constraintWidget.f3799w;
            if (i11 == 0) {
                return 0;
            }
            if (i11 == 2) {
                int i12 = (int) (constraintWidget.B * ((float) i10));
                if (i12 != constraintWidget.W()) {
                    constraintWidget.Y0(true);
                    D1(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i12, constraintWidget.T(), constraintWidget.x());
                }
                return i12;
            } else if (i11 == 1) {
                return constraintWidget.W();
            } else {
                if (i11 == 3) {
                    return (int) ((((float) constraintWidget.x()) * constraintWidget.f3762d0) + 0.5f);
                }
            }
        }
        return constraintWidget.W();
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x011d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x005e  */
    private void m2(androidx.constraintlayout.core.widgets.ConstraintWidget[] r11, int r12, int r13, int r14, int[] r15) {
        /*
            r10 = this;
            r0 = 0
            if (r13 != 0) goto L_0x0026
            int r1 = r10.f3965r1
            if (r1 > 0) goto L_0x0023
            r1 = r0
            r2 = r1
            r3 = r2
        L_0x000a:
            if (r2 >= r12) goto L_0x0023
            if (r2 <= 0) goto L_0x0011
            int r4 = r10.f3960m1
            int r3 = r3 + r4
        L_0x0011:
            r4 = r11[r2]
            if (r4 != 0) goto L_0x0016
            goto L_0x0020
        L_0x0016:
            int r4 = r10.l2(r4, r14)
            int r3 = r3 + r4
            if (r3 <= r14) goto L_0x001e
            goto L_0x0023
        L_0x001e:
            int r1 = r1 + 1
        L_0x0020:
            int r2 = r2 + 1
            goto L_0x000a
        L_0x0023:
            r2 = r1
            r1 = r0
            goto L_0x0047
        L_0x0026:
            int r1 = r10.f3965r1
            if (r1 > 0) goto L_0x0046
            r1 = r0
            r2 = r1
            r3 = r2
        L_0x002d:
            if (r2 >= r12) goto L_0x0046
            if (r2 <= 0) goto L_0x0034
            int r4 = r10.f3961n1
            int r3 = r3 + r4
        L_0x0034:
            r4 = r11[r2]
            if (r4 != 0) goto L_0x0039
            goto L_0x0043
        L_0x0039:
            int r4 = r10.k2(r4, r14)
            int r3 = r3 + r4
            if (r3 <= r14) goto L_0x0041
            goto L_0x0046
        L_0x0041:
            int r1 = r1 + 1
        L_0x0043:
            int r2 = r2 + 1
            goto L_0x002d
        L_0x0046:
            r2 = r0
        L_0x0047:
            int[] r3 = r10.f3970w1
            if (r3 != 0) goto L_0x0050
            r3 = 2
            int[] r3 = new int[r3]
            r10.f3970w1 = r3
        L_0x0050:
            r3 = 1
            if (r1 != 0) goto L_0x0055
            if (r13 == r3) goto L_0x0059
        L_0x0055:
            if (r2 != 0) goto L_0x005b
            if (r13 != 0) goto L_0x005b
        L_0x0059:
            r4 = r3
            goto L_0x005c
        L_0x005b:
            r4 = r0
        L_0x005c:
            if (r4 != 0) goto L_0x011d
            if (r13 != 0) goto L_0x006a
            float r1 = (float) r12
            float r5 = (float) r2
            float r1 = r1 / r5
            double r5 = (double) r1
            double r5 = java.lang.Math.ceil(r5)
            int r1 = (int) r5
            goto L_0x0073
        L_0x006a:
            float r2 = (float) r12
            float r5 = (float) r1
            float r2 = r2 / r5
            double r5 = (double) r2
            double r5 = java.lang.Math.ceil(r5)
            int r2 = (int) r5
        L_0x0073:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r5 = r10.f3969v1
            r6 = 0
            if (r5 == 0) goto L_0x0080
            int r7 = r5.length
            if (r7 >= r2) goto L_0x007c
            goto L_0x0080
        L_0x007c:
            java.util.Arrays.fill(r5, r6)
            goto L_0x0084
        L_0x0080:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r5 = new androidx.constraintlayout.core.widgets.ConstraintWidget[r2]
            r10.f3969v1 = r5
        L_0x0084:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r5 = r10.f3968u1
            if (r5 == 0) goto L_0x0090
            int r7 = r5.length
            if (r7 >= r1) goto L_0x008c
            goto L_0x0090
        L_0x008c:
            java.util.Arrays.fill(r5, r6)
            goto L_0x0094
        L_0x0090:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r5 = new androidx.constraintlayout.core.widgets.ConstraintWidget[r1]
            r10.f3968u1 = r5
        L_0x0094:
            r5 = r0
        L_0x0095:
            if (r5 >= r2) goto L_0x00d9
            r6 = r0
        L_0x0098:
            if (r6 >= r1) goto L_0x00d6
            int r7 = r6 * r2
            int r7 = r7 + r5
            if (r13 != r3) goto L_0x00a2
            int r7 = r5 * r1
            int r7 = r7 + r6
        L_0x00a2:
            int r8 = r11.length
            if (r7 < r8) goto L_0x00a6
            goto L_0x00d3
        L_0x00a6:
            r7 = r11[r7]
            if (r7 != 0) goto L_0x00ab
            goto L_0x00d3
        L_0x00ab:
            int r8 = r10.l2(r7, r14)
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r9 = r10.f3969v1
            r9 = r9[r5]
            if (r9 == 0) goto L_0x00bb
            int r9 = r9.W()
            if (r9 >= r8) goto L_0x00bf
        L_0x00bb:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r8 = r10.f3969v1
            r8[r5] = r7
        L_0x00bf:
            int r8 = r10.k2(r7, r14)
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r9 = r10.f3968u1
            r9 = r9[r6]
            if (r9 == 0) goto L_0x00cf
            int r9 = r9.x()
            if (r9 >= r8) goto L_0x00d3
        L_0x00cf:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r8 = r10.f3968u1
            r8[r6] = r7
        L_0x00d3:
            int r6 = r6 + 1
            goto L_0x0098
        L_0x00d6:
            int r5 = r5 + 1
            goto L_0x0095
        L_0x00d9:
            r5 = r0
            r6 = r5
        L_0x00db:
            if (r5 >= r2) goto L_0x00f0
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r7 = r10.f3969v1
            r7 = r7[r5]
            if (r7 == 0) goto L_0x00ed
            if (r5 <= 0) goto L_0x00e8
            int r8 = r10.f3960m1
            int r6 = r6 + r8
        L_0x00e8:
            int r7 = r10.l2(r7, r14)
            int r6 = r6 + r7
        L_0x00ed:
            int r5 = r5 + 1
            goto L_0x00db
        L_0x00f0:
            r5 = r0
            r7 = r5
        L_0x00f2:
            if (r5 >= r1) goto L_0x0107
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r8 = r10.f3968u1
            r8 = r8[r5]
            if (r8 == 0) goto L_0x0104
            if (r5 <= 0) goto L_0x00ff
            int r9 = r10.f3961n1
            int r7 = r7 + r9
        L_0x00ff:
            int r8 = r10.k2(r8, r14)
            int r7 = r7 + r8
        L_0x0104:
            int r5 = r5 + 1
            goto L_0x00f2
        L_0x0107:
            r15[r0] = r6
            r15[r3] = r7
            if (r13 != 0) goto L_0x0115
            if (r6 <= r14) goto L_0x0059
            if (r2 <= r3) goto L_0x0059
            int r2 = r2 + -1
            goto L_0x005c
        L_0x0115:
            if (r7 <= r14) goto L_0x0059
            if (r1 <= r3) goto L_0x0059
            int r1 = r1 + -1
            goto L_0x005c
        L_0x011d:
            int[] r11 = r10.f3970w1
            r11[r0] = r2
            r11[r3] = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.e.m2(androidx.constraintlayout.core.widgets.ConstraintWidget[], int, int, int, int[]):void");
    }

    private void n2(ConstraintWidget[] constraintWidgetArr, int i10, int i11, int i12, int[] iArr) {
        int i13;
        ConstraintAnchor constraintAnchor;
        int i14;
        int i15;
        int i16;
        ConstraintAnchor constraintAnchor2;
        int i17;
        int i18;
        int i19 = i10;
        int i20 = i12;
        if (i19 != 0) {
            this.f3967t1.clear();
            a aVar = new a(i11, this.O, this.P, this.Q, this.R, i12);
            this.f3967t1.add(aVar);
            if (i11 == 0) {
                i13 = 0;
                int i21 = 0;
                int i22 = 0;
                while (i22 < i19) {
                    ConstraintWidget constraintWidget = constraintWidgetArr[i22];
                    int l22 = l2(constraintWidget, i20);
                    if (constraintWidget.A() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        i13++;
                    }
                    int i23 = i13;
                    boolean z10 = (i21 == i20 || (this.f3960m1 + i21) + l22 > i20) && aVar.f3974b != null;
                    if (!z10 && i22 > 0 && (i18 = this.f3965r1) > 0 && i22 % i18 == 0) {
                        z10 = true;
                    }
                    if (z10) {
                        aVar = new a(i11, this.O, this.P, this.Q, this.R, i12);
                        aVar.i(i22);
                        this.f3967t1.add(aVar);
                    } else if (i22 > 0) {
                        i21 += this.f3960m1 + l22;
                        aVar.b(constraintWidget);
                        i22++;
                        i13 = i23;
                    }
                    i21 = l22;
                    aVar.b(constraintWidget);
                    i22++;
                    i13 = i23;
                }
            } else {
                int i24 = 0;
                int i25 = 0;
                int i26 = 0;
                while (i26 < i19) {
                    ConstraintWidget constraintWidget2 = constraintWidgetArr[i26];
                    int k22 = k2(constraintWidget2, i20);
                    if (constraintWidget2.T() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        i13++;
                    }
                    int i27 = i13;
                    boolean z11 = (i25 == i20 || (this.f3961n1 + i25) + k22 > i20) && aVar.f3974b != null;
                    if (!z11 && i26 > 0 && (i17 = this.f3965r1) > 0 && i26 % i17 == 0) {
                        z11 = true;
                    }
                    if (z11) {
                        aVar = new a(i11, this.O, this.P, this.Q, this.R, i12);
                        aVar.i(i26);
                        this.f3967t1.add(aVar);
                    } else if (i26 > 0) {
                        i25 += this.f3961n1 + k22;
                        aVar.b(constraintWidget2);
                        i26++;
                        i24 = i27;
                    }
                    i25 = k22;
                    aVar.b(constraintWidget2);
                    i26++;
                    i24 = i27;
                }
            }
            int size = this.f3967t1.size();
            ConstraintAnchor constraintAnchor3 = this.O;
            ConstraintAnchor constraintAnchor4 = this.P;
            ConstraintAnchor constraintAnchor5 = this.Q;
            ConstraintAnchor constraintAnchor6 = this.R;
            int z12 = z1();
            int B1 = B1();
            int A1 = A1();
            int y12 = y1();
            ConstraintWidget.DimensionBehaviour A = A();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean z13 = A == dimensionBehaviour || T() == dimensionBehaviour;
            if (i13 > 0 && z13) {
                for (int i28 = 0; i28 < size; i28++) {
                    a aVar2 = this.f3967t1.get(i28);
                    if (i11 == 0) {
                        aVar2.g(i20 - aVar2.f());
                    } else {
                        aVar2.g(i20 - aVar2.e());
                    }
                }
            }
            int i29 = B1;
            int i30 = A1;
            int i31 = 0;
            int i32 = 0;
            int i33 = 0;
            int i34 = z12;
            ConstraintAnchor constraintAnchor7 = constraintAnchor4;
            ConstraintAnchor constraintAnchor8 = constraintAnchor3;
            int i35 = y12;
            while (i33 < size) {
                a aVar3 = this.f3967t1.get(i33);
                if (i11 == 0) {
                    if (i33 < size - 1) {
                        constraintAnchor2 = this.f3967t1.get(i33 + 1).f3974b.P;
                        i16 = 0;
                    } else {
                        constraintAnchor2 = this.R;
                        i16 = y1();
                    }
                    ConstraintAnchor constraintAnchor9 = aVar3.f3974b.R;
                    ConstraintAnchor constraintAnchor10 = constraintAnchor8;
                    ConstraintAnchor constraintAnchor11 = constraintAnchor8;
                    int i36 = i31;
                    ConstraintAnchor constraintAnchor12 = constraintAnchor7;
                    int i37 = i32;
                    ConstraintAnchor constraintAnchor13 = constraintAnchor5;
                    ConstraintAnchor constraintAnchor14 = constraintAnchor5;
                    i14 = i33;
                    aVar3.j(i11, constraintAnchor10, constraintAnchor12, constraintAnchor13, constraintAnchor2, i34, i29, i30, i16, i12);
                    int max = Math.max(i37, aVar3.f());
                    i31 = i36 + aVar3.e();
                    if (i14 > 0) {
                        i31 += this.f3961n1;
                    }
                    constraintAnchor8 = constraintAnchor11;
                    i32 = max;
                    i29 = 0;
                    constraintAnchor7 = constraintAnchor9;
                    constraintAnchor = constraintAnchor14;
                    int i38 = i16;
                    constraintAnchor6 = constraintAnchor2;
                    i35 = i38;
                } else {
                    ConstraintAnchor constraintAnchor15 = constraintAnchor8;
                    int i39 = i31;
                    int i40 = i32;
                    i14 = i33;
                    if (i14 < size - 1) {
                        constraintAnchor = this.f3967t1.get(i14 + 1).f3974b.O;
                        i15 = 0;
                    } else {
                        constraintAnchor = this.Q;
                        i15 = A1();
                    }
                    ConstraintAnchor constraintAnchor16 = aVar3.f3974b.Q;
                    aVar3.j(i11, constraintAnchor15, constraintAnchor7, constraintAnchor, constraintAnchor6, i34, i29, i15, i35, i12);
                    i32 = i40 + aVar3.f();
                    int max2 = Math.max(i39, aVar3.e());
                    if (i14 > 0) {
                        i32 += this.f3960m1;
                    }
                    i31 = max2;
                    i34 = 0;
                    i30 = i15;
                    constraintAnchor8 = constraintAnchor16;
                }
                i33 = i14 + 1;
                int i41 = i12;
                constraintAnchor5 = constraintAnchor;
            }
            iArr[0] = i32;
            iArr[1] = i31;
        }
    }

    private void o2(ConstraintWidget[] constraintWidgetArr, int i10, int i11, int i12, int[] iArr) {
        int i13;
        ConstraintAnchor constraintAnchor;
        int i14;
        int i15;
        int i16;
        ConstraintAnchor constraintAnchor2;
        int i17;
        int i18;
        int i19 = i10;
        int i20 = i12;
        if (i19 != 0) {
            this.f3967t1.clear();
            a aVar = new a(i11, this.O, this.P, this.Q, this.R, i12);
            this.f3967t1.add(aVar);
            if (i11 == 0) {
                int i21 = 0;
                i13 = 0;
                int i22 = 0;
                int i23 = 0;
                while (i23 < i19) {
                    int i24 = i21 + 1;
                    ConstraintWidget constraintWidget = constraintWidgetArr[i23];
                    int l22 = l2(constraintWidget, i20);
                    if (constraintWidget.A() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        i13++;
                    }
                    int i25 = i13;
                    boolean z10 = (i22 == i20 || (this.f3960m1 + i22) + l22 > i20) && aVar.f3974b != null;
                    if (!z10 && i23 > 0 && (i18 = this.f3965r1) > 0 && i24 > i18) {
                        z10 = true;
                    }
                    if (z10) {
                        aVar = new a(i11, this.O, this.P, this.Q, this.R, i12);
                        aVar.i(i23);
                        this.f3967t1.add(aVar);
                        i21 = i24;
                        i22 = l22;
                    } else {
                        i22 = i23 > 0 ? i22 + this.f3960m1 + l22 : l22;
                        i21 = 0;
                    }
                    aVar.b(constraintWidget);
                    i23++;
                    i13 = i25;
                }
            } else {
                int i26 = 0;
                int i27 = 0;
                int i28 = 0;
                while (i28 < i19) {
                    ConstraintWidget constraintWidget2 = constraintWidgetArr[i28];
                    int k22 = k2(constraintWidget2, i20);
                    if (constraintWidget2.T() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        i13++;
                    }
                    int i29 = i13;
                    boolean z11 = (i26 == i20 || (this.f3961n1 + i26) + k22 > i20) && aVar.f3974b != null;
                    if (!z11 && i28 > 0 && (i17 = this.f3965r1) > 0 && i17 < 0) {
                        z11 = true;
                    }
                    if (z11) {
                        aVar = new a(i11, this.O, this.P, this.Q, this.R, i12);
                        aVar.i(i28);
                        this.f3967t1.add(aVar);
                    } else if (i28 > 0) {
                        i26 += this.f3961n1 + k22;
                        aVar.b(constraintWidget2);
                        i28++;
                        i27 = i29;
                    }
                    i26 = k22;
                    aVar.b(constraintWidget2);
                    i28++;
                    i27 = i29;
                }
            }
            int size = this.f3967t1.size();
            ConstraintAnchor constraintAnchor3 = this.O;
            ConstraintAnchor constraintAnchor4 = this.P;
            ConstraintAnchor constraintAnchor5 = this.Q;
            ConstraintAnchor constraintAnchor6 = this.R;
            int z12 = z1();
            int B1 = B1();
            int A1 = A1();
            int y12 = y1();
            ConstraintWidget.DimensionBehaviour A = A();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean z13 = A == dimensionBehaviour || T() == dimensionBehaviour;
            if (i13 > 0 && z13) {
                for (int i30 = 0; i30 < size; i30++) {
                    a aVar2 = this.f3967t1.get(i30);
                    if (i11 == 0) {
                        aVar2.g(i20 - aVar2.f());
                    } else {
                        aVar2.g(i20 - aVar2.e());
                    }
                }
            }
            int i31 = B1;
            int i32 = A1;
            int i33 = 0;
            int i34 = 0;
            int i35 = 0;
            int i36 = z12;
            ConstraintAnchor constraintAnchor7 = constraintAnchor4;
            ConstraintAnchor constraintAnchor8 = constraintAnchor3;
            int i37 = y12;
            while (i35 < size) {
                a aVar3 = this.f3967t1.get(i35);
                if (i11 == 0) {
                    if (i35 < size - 1) {
                        constraintAnchor2 = this.f3967t1.get(i35 + 1).f3974b.P;
                        i16 = 0;
                    } else {
                        constraintAnchor2 = this.R;
                        i16 = y1();
                    }
                    ConstraintAnchor constraintAnchor9 = aVar3.f3974b.R;
                    ConstraintAnchor constraintAnchor10 = constraintAnchor8;
                    ConstraintAnchor constraintAnchor11 = constraintAnchor8;
                    int i38 = i33;
                    ConstraintAnchor constraintAnchor12 = constraintAnchor7;
                    int i39 = i34;
                    ConstraintAnchor constraintAnchor13 = constraintAnchor5;
                    ConstraintAnchor constraintAnchor14 = constraintAnchor5;
                    i14 = i35;
                    aVar3.j(i11, constraintAnchor10, constraintAnchor12, constraintAnchor13, constraintAnchor2, i36, i31, i32, i16, i12);
                    int max = Math.max(i39, aVar3.f());
                    i33 = i38 + aVar3.e();
                    if (i14 > 0) {
                        i33 += this.f3961n1;
                    }
                    constraintAnchor8 = constraintAnchor11;
                    i34 = max;
                    i31 = 0;
                    constraintAnchor7 = constraintAnchor9;
                    constraintAnchor = constraintAnchor14;
                    int i40 = i16;
                    constraintAnchor6 = constraintAnchor2;
                    i37 = i40;
                } else {
                    ConstraintAnchor constraintAnchor15 = constraintAnchor8;
                    int i41 = i33;
                    int i42 = i34;
                    i14 = i35;
                    if (i14 < size - 1) {
                        constraintAnchor = this.f3967t1.get(i14 + 1).f3974b.O;
                        i15 = 0;
                    } else {
                        constraintAnchor = this.Q;
                        i15 = A1();
                    }
                    ConstraintAnchor constraintAnchor16 = aVar3.f3974b.Q;
                    aVar3.j(i11, constraintAnchor15, constraintAnchor7, constraintAnchor, constraintAnchor6, i36, i31, i15, i37, i12);
                    i34 = i42 + aVar3.f();
                    int max2 = Math.max(i41, aVar3.e());
                    if (i14 > 0) {
                        i34 += this.f3960m1;
                    }
                    i33 = max2;
                    i36 = 0;
                    i32 = i15;
                    constraintAnchor8 = constraintAnchor16;
                }
                i35 = i14 + 1;
                int i43 = i12;
                constraintAnchor5 = constraintAnchor;
            }
            iArr[0] = i34;
            iArr[1] = i33;
        }
    }

    private void p2(ConstraintWidget[] constraintWidgetArr, int i10, int i11, int i12, int[] iArr) {
        a aVar;
        int i13 = i10;
        if (i13 != 0) {
            if (this.f3967t1.size() == 0) {
                aVar = new a(i11, this.O, this.P, this.Q, this.R, i12);
                this.f3967t1.add(aVar);
            } else {
                a aVar2 = this.f3967t1.get(0);
                aVar2.c();
                aVar = aVar2;
                aVar.j(i11, this.O, this.P, this.Q, this.R, z1(), B1(), A1(), y1(), i12);
            }
            for (int i14 = 0; i14 < i13; i14++) {
                aVar.b(constraintWidgetArr[i14]);
            }
            iArr[0] = aVar.f();
            iArr[1] = aVar.e();
        }
    }

    public void A2(float f10) {
        this.f3959l1 = f10;
    }

    public void B2(int i10) {
        this.f3953f1 = i10;
    }

    /* JADX WARNING: type inference failed for: r11v2 */
    /* JADX WARNING: type inference failed for: r11v3 */
    /* JADX WARNING: type inference failed for: r11v6 */
    /* JADX WARNING: type inference failed for: r11v7 */
    /* JADX WARNING: type inference failed for: r11v8 */
    /* JADX WARNING: type inference failed for: r11v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void C1(int r19, int r20, int r21, int r22) {
        /*
            r18 = this;
            r6 = r18
            r7 = r19
            r8 = r20
            r9 = r21
            r10 = r22
            int r0 = r6.M0
            r11 = 0
            if (r0 <= 0) goto L_0x001c
            boolean r0 = r18.E1()
            if (r0 != 0) goto L_0x001c
            r6.H1(r11, r11)
            r6.G1(r11)
            return
        L_0x001c:
            int r12 = r18.z1()
            int r13 = r18.A1()
            int r14 = r18.B1()
            int r15 = r18.y1()
            r0 = 2
            int[] r5 = new int[r0]
            int r1 = r8 - r12
            int r1 = r1 - r13
            int r2 = r6.f3966s1
            r4 = 1
            if (r2 != r4) goto L_0x003a
            int r1 = r10 - r14
            int r1 = r1 - r15
        L_0x003a:
            r16 = r1
            r1 = -1
            if (r2 != 0) goto L_0x004c
            int r2 = r6.f3948a1
            if (r2 != r1) goto L_0x0045
            r6.f3948a1 = r11
        L_0x0045:
            int r2 = r6.f3949b1
            if (r2 != r1) goto L_0x0058
            r6.f3949b1 = r11
            goto L_0x0058
        L_0x004c:
            int r2 = r6.f3948a1
            if (r2 != r1) goto L_0x0052
            r6.f3948a1 = r11
        L_0x0052:
            int r2 = r6.f3949b1
            if (r2 != r1) goto L_0x0058
            r6.f3949b1 = r11
        L_0x0058:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r1 = r6.L0
            r2 = r11
            r3 = r2
        L_0x005c:
            int r11 = r6.M0
            r0 = 8
            if (r2 >= r11) goto L_0x0072
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r11 = r6.L0
            r11 = r11[r2]
            int r11 = r11.V()
            if (r11 != r0) goto L_0x006e
            int r3 = r3 + 1
        L_0x006e:
            int r2 = r2 + 1
            r0 = 2
            goto L_0x005c
        L_0x0072:
            if (r3 <= 0) goto L_0x0091
            int r11 = r11 - r3
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r1 = new androidx.constraintlayout.core.widgets.ConstraintWidget[r11]
            r2 = 0
            r3 = 0
        L_0x0079:
            int r11 = r6.M0
            if (r2 >= r11) goto L_0x008f
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r11 = r6.L0
            r11 = r11[r2]
            int r4 = r11.V()
            if (r4 == r0) goto L_0x008b
            r1[r3] = r11
            int r3 = r3 + 1
        L_0x008b:
            int r2 = r2 + 1
            r4 = 1
            goto L_0x0079
        L_0x008f:
            r2 = r3
            goto L_0x0092
        L_0x0091:
            r2 = r11
        L_0x0092:
            r6.f3971x1 = r1
            r6.f3972y1 = r2
            int r0 = r6.f3964q1
            if (r0 == 0) goto L_0x00cf
            r4 = 1
            if (r0 == r4) goto L_0x00c2
            r3 = 2
            if (r0 == r3) goto L_0x00b5
            r3 = 3
            if (r0 == r3) goto L_0x00a8
            r11 = r4
            r17 = r5
        L_0x00a6:
            r0 = 0
            goto L_0x00dc
        L_0x00a8:
            int r3 = r6.f3966s1
            r0 = r18
            r11 = r4
            r4 = r16
            r17 = r5
            r0.o2(r1, r2, r3, r4, r5)
            goto L_0x00a6
        L_0x00b5:
            r11 = r4
            r17 = r5
            int r3 = r6.f3966s1
            r0 = r18
            r4 = r16
            r0.m2(r1, r2, r3, r4, r5)
            goto L_0x00a6
        L_0x00c2:
            r11 = r4
            r17 = r5
            int r3 = r6.f3966s1
            r0 = r18
            r4 = r16
            r0.n2(r1, r2, r3, r4, r5)
            goto L_0x00a6
        L_0x00cf:
            r17 = r5
            r11 = 1
            int r3 = r6.f3966s1
            r0 = r18
            r4 = r16
            r0.p2(r1, r2, r3, r4, r5)
            goto L_0x00a6
        L_0x00dc:
            r1 = r17[r0]
            int r1 = r1 + r12
            int r1 = r1 + r13
            r2 = r17[r11]
            int r2 = r2 + r14
            int r2 = r2 + r15
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = 1073741824(0x40000000, float:2.0)
            if (r7 != r4) goto L_0x00ec
            r1 = r8
            goto L_0x00f7
        L_0x00ec:
            if (r7 != r3) goto L_0x00f3
            int r1 = java.lang.Math.min(r1, r8)
            goto L_0x00f7
        L_0x00f3:
            if (r7 != 0) goto L_0x00f6
            goto L_0x00f7
        L_0x00f6:
            r1 = r0
        L_0x00f7:
            if (r9 != r4) goto L_0x00fb
            r2 = r10
            goto L_0x0106
        L_0x00fb:
            if (r9 != r3) goto L_0x0102
            int r2 = java.lang.Math.min(r2, r10)
            goto L_0x0106
        L_0x0102:
            if (r9 != 0) goto L_0x0105
            goto L_0x0106
        L_0x0105:
            r2 = r0
        L_0x0106:
            r6.H1(r1, r2)
            r6.k1(r1)
            r6.L0(r2)
            int r1 = r6.M0
            if (r1 <= 0) goto L_0x0114
            goto L_0x0115
        L_0x0114:
            r11 = r0
        L_0x0115:
            r6.G1(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.e.C1(int, int, int, int):void");
    }

    public void C2(int i10) {
        this.f3965r1 = i10;
    }

    public void D2(int i10) {
        this.f3966s1 = i10;
    }

    public void E2(int i10) {
        this.f3963p1 = i10;
    }

    public void F2(float f10) {
        this.f3955h1 = f10;
    }

    public void G2(int i10) {
        this.f3961n1 = i10;
    }

    public void H2(int i10) {
        this.f3949b1 = i10;
    }

    public void I2(int i10) {
        this.f3964q1 = i10;
    }

    public void g(d dVar, boolean z10) {
        boolean z11;
        boolean z12;
        boolean z13;
        super.g(dVar, z10);
        if (K() == null || !((d) K()).P1()) {
            z11 = false;
        } else {
            z11 = true;
        }
        int i10 = this.f3964q1;
        if (i10 != 0) {
            if (i10 == 1) {
                int size = this.f3967t1.size();
                for (int i11 = 0; i11 < size; i11++) {
                    a aVar = this.f3967t1.get(i11);
                    if (i11 == size - 1) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    aVar.d(z11, i11, z12);
                }
            } else if (i10 == 2) {
                j2(z11);
            } else if (i10 == 3) {
                int size2 = this.f3967t1.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    a aVar2 = this.f3967t1.get(i12);
                    if (i12 == size2 - 1) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    aVar2.d(z11, i12, z13);
                }
            }
        } else if (this.f3967t1.size() > 0) {
            this.f3967t1.get(0).d(z11, 0, true);
        }
        G1(false);
    }

    public void q2(float f10) {
        this.f3956i1 = f10;
    }

    public void r2(int i10) {
        this.f3950c1 = i10;
    }

    public void s2(float f10) {
        this.f3957j1 = f10;
    }

    public void t2(int i10) {
        this.f3951d1 = i10;
    }

    public void u2(int i10) {
        this.f3962o1 = i10;
    }

    public void v2(float f10) {
        this.f3954g1 = f10;
    }

    public void w2(int i10) {
        this.f3960m1 = i10;
    }

    public void x2(int i10) {
        this.f3948a1 = i10;
    }

    public void y2(float f10) {
        this.f3958k1 = f10;
    }

    public void z2(int i10) {
        this.f3952e1 = i10;
    }
}
