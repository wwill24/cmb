package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.d;
import androidx.constraintlayout.core.widgets.f;
import androidx.constraintlayout.core.widgets.g;
import androidx.constraintlayout.core.widgets.h;
import java.util.ArrayList;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<ConstraintWidget> f3851a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private a f3852b = new a();

    /* renamed from: c  reason: collision with root package name */
    private d f3853c;

    public static class a {

        /* renamed from: k  reason: collision with root package name */
        public static int f3854k = 0;

        /* renamed from: l  reason: collision with root package name */
        public static int f3855l = 1;

        /* renamed from: m  reason: collision with root package name */
        public static int f3856m = 2;

        /* renamed from: a  reason: collision with root package name */
        public ConstraintWidget.DimensionBehaviour f3857a;

        /* renamed from: b  reason: collision with root package name */
        public ConstraintWidget.DimensionBehaviour f3858b;

        /* renamed from: c  reason: collision with root package name */
        public int f3859c;

        /* renamed from: d  reason: collision with root package name */
        public int f3860d;

        /* renamed from: e  reason: collision with root package name */
        public int f3861e;

        /* renamed from: f  reason: collision with root package name */
        public int f3862f;

        /* renamed from: g  reason: collision with root package name */
        public int f3863g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f3864h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f3865i;

        /* renamed from: j  reason: collision with root package name */
        public int f3866j;
    }

    /* renamed from: androidx.constraintlayout.core.widgets.analyzer.b$b  reason: collision with other inner class name */
    public interface C0027b {
        void a();

        void b(ConstraintWidget constraintWidget, a aVar);
    }

    public b(d dVar) {
        this.f3853c = dVar;
    }

    private boolean a(C0027b bVar, ConstraintWidget constraintWidget, int i10) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        this.f3852b.f3857a = constraintWidget.A();
        this.f3852b.f3858b = constraintWidget.T();
        this.f3852b.f3859c = constraintWidget.W();
        this.f3852b.f3860d = constraintWidget.x();
        a aVar = this.f3852b;
        aVar.f3865i = false;
        aVar.f3866j = i10;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = aVar.f3857a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (dimensionBehaviour == dimensionBehaviour2) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (aVar.f3858b == dimensionBehaviour2) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z10 || constraintWidget.f3762d0 <= 0.0f) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (!z11 || constraintWidget.f3762d0 <= 0.0f) {
            z13 = false;
        } else {
            z13 = true;
        }
        if (z12 && constraintWidget.f3803y[0] == 4) {
            aVar.f3857a = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (z13 && constraintWidget.f3803y[1] == 4) {
            aVar.f3858b = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        bVar.b(constraintWidget, aVar);
        constraintWidget.k1(this.f3852b.f3861e);
        constraintWidget.L0(this.f3852b.f3862f);
        constraintWidget.K0(this.f3852b.f3864h);
        constraintWidget.A0(this.f3852b.f3863g);
        a aVar2 = this.f3852b;
        aVar2.f3866j = a.f3854k;
        return aVar2.f3865i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x008d, code lost:
        if (r8 != r9) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0094, code lost:
        if (r5.f3762d0 <= 0.0f) goto L_0x0097;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(androidx.constraintlayout.core.widgets.d r13) {
        /*
            r12 = this;
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r0 = r13.L0
            int r0 = r0.size()
            r1 = 64
            boolean r1 = r13.T1(r1)
            androidx.constraintlayout.core.widgets.analyzer.b$b r2 = r13.I1()
            r3 = 0
            r4 = r3
        L_0x0012:
            if (r4 >= r0) goto L_0x00a4
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r5 = r13.L0
            java.lang.Object r5 = r5.get(r4)
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r5
            boolean r6 = r5 instanceof androidx.constraintlayout.core.widgets.f
            if (r6 == 0) goto L_0x0022
            goto L_0x00a0
        L_0x0022:
            boolean r6 = r5 instanceof androidx.constraintlayout.core.widgets.a
            if (r6 == 0) goto L_0x0028
            goto L_0x00a0
        L_0x0028:
            boolean r6 = r5.l0()
            if (r6 == 0) goto L_0x0030
            goto L_0x00a0
        L_0x0030:
            if (r1 == 0) goto L_0x0047
            androidx.constraintlayout.core.widgets.analyzer.j r6 = r5.f3763e
            if (r6 == 0) goto L_0x0047
            androidx.constraintlayout.core.widgets.analyzer.l r7 = r5.f3765f
            if (r7 == 0) goto L_0x0047
            androidx.constraintlayout.core.widgets.analyzer.e r6 = r6.f3839e
            boolean r6 = r6.f3823j
            if (r6 == 0) goto L_0x0047
            androidx.constraintlayout.core.widgets.analyzer.e r6 = r7.f3839e
            boolean r6 = r6.f3823j
            if (r6 == 0) goto L_0x0047
            goto L_0x00a0
        L_0x0047:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = r5.u(r3)
            r7 = 1
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = r5.u(r7)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r6 != r9) goto L_0x0060
            int r10 = r5.f3799w
            if (r10 == r7) goto L_0x0060
            if (r8 != r9) goto L_0x0060
            int r10 = r5.f3801x
            if (r10 == r7) goto L_0x0060
            r10 = r7
            goto L_0x0061
        L_0x0060:
            r10 = r3
        L_0x0061:
            if (r10 != 0) goto L_0x0097
            boolean r11 = r13.T1(r7)
            if (r11 == 0) goto L_0x0097
            boolean r11 = r5 instanceof androidx.constraintlayout.core.widgets.h
            if (r11 != 0) goto L_0x0097
            if (r6 != r9) goto L_0x007c
            int r11 = r5.f3799w
            if (r11 != 0) goto L_0x007c
            if (r8 == r9) goto L_0x007c
            boolean r11 = r5.i0()
            if (r11 != 0) goto L_0x007c
            r10 = r7
        L_0x007c:
            if (r8 != r9) goto L_0x008b
            int r11 = r5.f3801x
            if (r11 != 0) goto L_0x008b
            if (r6 == r9) goto L_0x008b
            boolean r11 = r5.i0()
            if (r11 != 0) goto L_0x008b
            r10 = r7
        L_0x008b:
            if (r6 == r9) goto L_0x008f
            if (r8 != r9) goto L_0x0097
        L_0x008f:
            float r6 = r5.f3762d0
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 <= 0) goto L_0x0097
            goto L_0x0098
        L_0x0097:
            r7 = r10
        L_0x0098:
            if (r7 == 0) goto L_0x009b
            goto L_0x00a0
        L_0x009b:
            int r6 = androidx.constraintlayout.core.widgets.analyzer.b.a.f3854k
            r12.a(r2, r5, r6)
        L_0x00a0:
            int r4 = r4 + 1
            goto L_0x0012
        L_0x00a4:
            r2.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.b.b(androidx.constraintlayout.core.widgets.d):void");
    }

    private void c(d dVar, String str, int i10, int i11, int i12) {
        int I = dVar.I();
        int H = dVar.H();
        dVar.a1(0);
        dVar.Z0(0);
        dVar.k1(i11);
        dVar.L0(i12);
        dVar.a1(I);
        dVar.Z0(H);
        this.f3853c.X1(i10);
        this.f3853c.s1();
    }

    public long d(d dVar, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        boolean z10;
        boolean z11;
        int i19;
        boolean z12;
        int i20;
        d dVar2;
        boolean z13;
        boolean z14;
        int i21;
        boolean z15;
        int i22;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z20;
        boolean z21;
        b bVar = this;
        d dVar3 = dVar;
        int i23 = i10;
        int i24 = i13;
        int i25 = i15;
        C0027b I1 = dVar.I1();
        int size = dVar3.L0.size();
        int W = dVar.W();
        int x10 = dVar.x();
        boolean b10 = g.b(i23, 128);
        if (b10 || g.b(i23, 64)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            int i26 = 0;
            while (true) {
                if (i26 >= size) {
                    break;
                }
                ConstraintWidget constraintWidget = dVar3.L0.get(i26);
                ConstraintWidget.DimensionBehaviour A = constraintWidget.A();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (A == dimensionBehaviour) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (constraintWidget.T() == dimensionBehaviour) {
                    z20 = true;
                } else {
                    z20 = false;
                }
                if (!z19 || !z20 || constraintWidget.v() <= 0.0f) {
                    z21 = false;
                } else {
                    z21 = true;
                }
                if ((!constraintWidget.i0() || !z21) && ((!constraintWidget.k0() || !z21) && !(constraintWidget instanceof h) && !constraintWidget.i0() && !constraintWidget.k0())) {
                    i26++;
                }
            }
            z10 = false;
        }
        if (z10) {
            boolean z22 = androidx.constraintlayout.core.d.f3683r;
        }
        if (!(i24 == 1073741824 && i25 == 1073741824) && !b10) {
            z11 = false;
        } else {
            z11 = true;
        }
        boolean z23 = z10 & z11;
        int i27 = 2;
        if (z23) {
            int min = Math.min(dVar.G(), i14);
            int min2 = Math.min(dVar.F(), i16);
            if (i24 == 1073741824 && dVar.W() != min) {
                dVar3.k1(min);
                dVar.M1();
            }
            if (i25 == 1073741824 && dVar.x() != min2) {
                dVar3.L0(min2);
                dVar.M1();
            }
            if (i24 == 1073741824 && i25 == 1073741824) {
                z12 = dVar3.F1(b10);
                i19 = 2;
            } else {
                boolean G1 = dVar3.G1(b10);
                if (i24 == 1073741824) {
                    G1 &= dVar3.H1(b10, 0);
                    i19 = 1;
                } else {
                    i19 = 0;
                }
                if (i25 == 1073741824) {
                    z12 = dVar3.H1(b10, 1) & G1;
                    i19++;
                } else {
                    z12 = G1;
                }
            }
            if (z12) {
                if (i24 == 1073741824) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (i25 == 1073741824) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                dVar3.p1(z17, z18);
            }
        } else {
            z12 = false;
            i19 = 0;
        }
        if (z12 && i19 == 2) {
            return 0;
        }
        int J1 = dVar.J1();
        if (size > 0) {
            b(dVar);
        }
        e(dVar);
        int size2 = bVar.f3851a.size();
        if (size > 0) {
            c(dVar, "First pass", 0, W, x10);
        }
        if (size2 > 0) {
            ConstraintWidget.DimensionBehaviour A2 = dVar.A();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (A2 == dimensionBehaviour2) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (dVar.T() == dimensionBehaviour2) {
                z14 = true;
            } else {
                z14 = false;
            }
            int max = Math.max(dVar.W(), bVar.f3853c.I());
            int max2 = Math.max(dVar.x(), bVar.f3853c.H());
            int i28 = 0;
            boolean z24 = false;
            while (i28 < size2) {
                ConstraintWidget constraintWidget2 = bVar.f3851a.get(i28);
                if (!(constraintWidget2 instanceof h)) {
                    i22 = J1;
                } else {
                    int W2 = constraintWidget2.W();
                    int x11 = constraintWidget2.x();
                    i22 = J1;
                    boolean a10 = bVar.a(I1, constraintWidget2, a.f3855l) | z24;
                    int W3 = constraintWidget2.W();
                    boolean z25 = a10;
                    int x12 = constraintWidget2.x();
                    if (W3 != W2) {
                        constraintWidget2.k1(W3);
                        if (z13 && constraintWidget2.M() > max) {
                            max = Math.max(max, constraintWidget2.M() + constraintWidget2.o(ConstraintAnchor.Type.RIGHT).f());
                        }
                        z16 = true;
                    } else {
                        z16 = z25;
                    }
                    if (x12 != x11) {
                        constraintWidget2.L0(x12);
                        if (z14 && constraintWidget2.r() > max2) {
                            max2 = Math.max(max2, constraintWidget2.r() + constraintWidget2.o(ConstraintAnchor.Type.BOTTOM).f());
                        }
                        z16 = true;
                    }
                    z24 = z16 | ((h) constraintWidget2).F1();
                }
                i28++;
                d dVar4 = dVar;
                J1 = i22;
                i27 = 2;
            }
            int i29 = J1;
            int i30 = i27;
            int i31 = 0;
            while (i31 < i30) {
                int i32 = 0;
                while (i32 < size2) {
                    ConstraintWidget constraintWidget3 = bVar.f3851a.get(i32);
                    if ((!(constraintWidget3 instanceof p0.a) || (constraintWidget3 instanceof h)) && !(constraintWidget3 instanceof f) && constraintWidget3.V() != 8 && ((!z23 || !constraintWidget3.f3763e.f3839e.f3823j || !constraintWidget3.f3765f.f3839e.f3823j) && !(constraintWidget3 instanceof h))) {
                        int W4 = constraintWidget3.W();
                        int x13 = constraintWidget3.x();
                        z15 = z23;
                        int p10 = constraintWidget3.p();
                        int i33 = a.f3855l;
                        i21 = size2;
                        if (i31 == 1) {
                            i33 = a.f3856m;
                        }
                        boolean a11 = bVar.a(I1, constraintWidget3, i33) | z24;
                        int W5 = constraintWidget3.W();
                        int x14 = constraintWidget3.x();
                        if (W5 != W4) {
                            constraintWidget3.k1(W5);
                            if (z13 && constraintWidget3.M() > max) {
                                max = Math.max(max, constraintWidget3.M() + constraintWidget3.o(ConstraintAnchor.Type.RIGHT).f());
                            }
                            a11 = true;
                        }
                        if (x14 != x13) {
                            constraintWidget3.L0(x14);
                            if (z14 && constraintWidget3.r() > max2) {
                                max2 = Math.max(max2, constraintWidget3.r() + constraintWidget3.o(ConstraintAnchor.Type.BOTTOM).f());
                            }
                            a11 = true;
                        }
                        if (!constraintWidget3.Z() || p10 == constraintWidget3.p()) {
                            z24 = a11;
                        } else {
                            z24 = true;
                        }
                    } else {
                        z15 = z23;
                        i21 = size2;
                    }
                    i32++;
                    bVar = this;
                    z23 = z15;
                    size2 = i21;
                }
                boolean z26 = z23;
                int i34 = size2;
                if (!z24) {
                    break;
                }
                i31++;
                c(dVar, "intermediate pass", i31, W, x10);
                bVar = this;
                z23 = z26;
                size2 = i34;
                i30 = 2;
                z24 = false;
            }
            dVar2 = dVar;
            i20 = i29;
        } else {
            dVar2 = dVar;
            i20 = J1;
        }
        dVar2.W1(i20);
        return 0;
    }

    public void e(d dVar) {
        this.f3851a.clear();
        int size = dVar.L0.size();
        for (int i10 = 0; i10 < size; i10++) {
            ConstraintWidget constraintWidget = dVar.L0.get(i10);
            ConstraintWidget.DimensionBehaviour A = constraintWidget.A();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (A == dimensionBehaviour || constraintWidget.T() == dimensionBehaviour) {
                this.f3851a.add(constraintWidget);
            }
        }
        dVar.M1();
    }
}
