package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.a;
import androidx.constraintlayout.core.widgets.analyzer.b;
import androidx.constraintlayout.core.widgets.d;
import java.util.ArrayList;
import java.util.Iterator;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static b.a f3879a = new b.a();

    /* renamed from: b  reason: collision with root package name */
    private static int f3880b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static int f3881c = 0;

    private static boolean a(int i10, ConstraintWidget constraintWidget) {
        d dVar;
        boolean z10;
        boolean z11;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        ConstraintWidget.DimensionBehaviour A = constraintWidget.A();
        ConstraintWidget.DimensionBehaviour T = constraintWidget.T();
        if (constraintWidget.K() != null) {
            dVar = (d) constraintWidget.K();
        } else {
            dVar = null;
        }
        if (dVar != null) {
            ConstraintWidget.DimensionBehaviour A2 = dVar.A();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (dVar != null) {
            ConstraintWidget.DimensionBehaviour T2 = dVar.T();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (A == dimensionBehaviour5 || constraintWidget.n0() || A == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || ((A == (dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && constraintWidget.f3799w == 0 && constraintWidget.f3762d0 == 0.0f && constraintWidget.a0(0)) || (A == dimensionBehaviour2 && constraintWidget.f3799w == 1 && constraintWidget.d0(0, constraintWidget.W())))) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (T == dimensionBehaviour5 || constraintWidget.o0() || T == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || ((T == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && constraintWidget.f3801x == 0 && constraintWidget.f3762d0 == 0.0f && constraintWidget.a0(1)) || (T == dimensionBehaviour && constraintWidget.f3801x == 1 && constraintWidget.d0(1, constraintWidget.x())))) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (constraintWidget.f3762d0 > 0.0f && (z10 || z11)) {
            return true;
        }
        if (!z10 || !z11) {
            return false;
        }
        return true;
    }

    private static void b(int i10, ConstraintWidget constraintWidget, b.C0027b bVar, boolean z10) {
        boolean z11;
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        boolean z12;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        ConstraintWidget constraintWidget2 = constraintWidget;
        b.C0027b bVar2 = bVar;
        boolean z13 = z10;
        if (!constraintWidget.g0()) {
            boolean z14 = true;
            f3880b++;
            if (!(constraintWidget2 instanceof d) && constraintWidget.m0()) {
                int i11 = i10 + 1;
                if (a(i11, constraintWidget2)) {
                    d.S1(i11, constraintWidget2, bVar2, new b.a(), b.a.f3854k);
                }
            }
            ConstraintAnchor o10 = constraintWidget2.o(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor o11 = constraintWidget2.o(ConstraintAnchor.Type.RIGHT);
            int e10 = o10.e();
            int e11 = o11.e();
            if (o10.d() != null && o10.n()) {
                Iterator<ConstraintAnchor> it = o10.d().iterator();
                while (it.hasNext()) {
                    ConstraintAnchor next = it.next();
                    ConstraintWidget constraintWidget3 = next.f3738d;
                    int i12 = i10 + 1;
                    boolean a10 = a(i12, constraintWidget3);
                    if (constraintWidget3.m0() && a10) {
                        d.S1(i12, constraintWidget3, bVar2, new b.a(), b.a.f3854k);
                    }
                    if ((next != constraintWidget3.O || (constraintAnchor4 = constraintWidget3.Q.f3740f) == null || !constraintAnchor4.n()) && (next != constraintWidget3.Q || (constraintAnchor3 = constraintWidget3.O.f3740f) == null || !constraintAnchor3.n())) {
                        z12 = false;
                    } else {
                        z12 = z14;
                    }
                    ConstraintWidget.DimensionBehaviour A = constraintWidget3.A();
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (A != dimensionBehaviour || a10) {
                        if (!constraintWidget3.m0()) {
                            ConstraintAnchor constraintAnchor5 = constraintWidget3.O;
                            if (next == constraintAnchor5 && constraintWidget3.Q.f3740f == null) {
                                int f10 = constraintAnchor5.f() + e10;
                                constraintWidget3.F0(f10, constraintWidget3.W() + f10);
                                b(i12, constraintWidget3, bVar2, z13);
                            } else {
                                ConstraintAnchor constraintAnchor6 = constraintWidget3.Q;
                                if (next == constraintAnchor6 && constraintAnchor5.f3740f == null) {
                                    int f11 = e10 - constraintAnchor6.f();
                                    constraintWidget3.F0(f11 - constraintWidget3.W(), f11);
                                    b(i12, constraintWidget3, bVar2, z13);
                                } else if (z12 && !constraintWidget3.i0()) {
                                    d(i12, bVar2, constraintWidget3, z13);
                                }
                            }
                        }
                    } else if (constraintWidget3.A() == dimensionBehaviour && constraintWidget3.A >= 0 && constraintWidget3.f3805z >= 0 && ((constraintWidget3.V() == 8 || (constraintWidget3.f3799w == 0 && constraintWidget3.v() == 0.0f)) && !constraintWidget3.i0() && !constraintWidget3.l0() && z12 && !constraintWidget3.i0())) {
                        e(i12, constraintWidget2, bVar2, constraintWidget3, z13);
                    }
                    z14 = true;
                }
            }
            if (!(constraintWidget2 instanceof androidx.constraintlayout.core.widgets.f)) {
                if (o11.d() != null && o11.n()) {
                    Iterator<ConstraintAnchor> it2 = o11.d().iterator();
                    while (it2.hasNext()) {
                        ConstraintAnchor next2 = it2.next();
                        ConstraintWidget constraintWidget4 = next2.f3738d;
                        int i13 = i10 + 1;
                        boolean a11 = a(i13, constraintWidget4);
                        if (constraintWidget4.m0() && a11) {
                            d.S1(i13, constraintWidget4, bVar2, new b.a(), b.a.f3854k);
                        }
                        if ((next2 != constraintWidget4.O || (constraintAnchor2 = constraintWidget4.Q.f3740f) == null || !constraintAnchor2.n()) && (next2 != constraintWidget4.Q || (constraintAnchor = constraintWidget4.O.f3740f) == null || !constraintAnchor.n())) {
                            z11 = false;
                        } else {
                            z11 = true;
                        }
                        ConstraintWidget.DimensionBehaviour A2 = constraintWidget4.A();
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (A2 != dimensionBehaviour2 || a11) {
                            if (!constraintWidget4.m0()) {
                                ConstraintAnchor constraintAnchor7 = constraintWidget4.O;
                                if (next2 == constraintAnchor7 && constraintWidget4.Q.f3740f == null) {
                                    int f12 = constraintAnchor7.f() + e11;
                                    constraintWidget4.F0(f12, constraintWidget4.W() + f12);
                                    b(i13, constraintWidget4, bVar2, z13);
                                } else {
                                    ConstraintAnchor constraintAnchor8 = constraintWidget4.Q;
                                    if (next2 == constraintAnchor8 && constraintAnchor7.f3740f == null) {
                                        int f13 = e11 - constraintAnchor8.f();
                                        constraintWidget4.F0(f13 - constraintWidget4.W(), f13);
                                        b(i13, constraintWidget4, bVar2, z13);
                                    } else if (z11 && !constraintWidget4.i0()) {
                                        d(i13, bVar2, constraintWidget4, z13);
                                    }
                                }
                            }
                        } else if (constraintWidget4.A() == dimensionBehaviour2 && constraintWidget4.A >= 0 && constraintWidget4.f3805z >= 0) {
                            if ((constraintWidget4.V() == 8 || (constraintWidget4.f3799w == 0 && constraintWidget4.v() == 0.0f)) && !constraintWidget4.i0() && !constraintWidget4.l0() && z11 && !constraintWidget4.i0()) {
                                e(i13, constraintWidget2, bVar2, constraintWidget4, z13);
                            }
                        }
                    }
                }
                constraintWidget.q0();
            }
        }
    }

    private static void c(int i10, a aVar, b.C0027b bVar, int i11, boolean z10) {
        if (!aVar.t1()) {
            return;
        }
        if (i11 == 0) {
            b(i10 + 1, aVar, bVar, z10);
        } else {
            i(i10 + 1, aVar, bVar);
        }
    }

    private static void d(int i10, b.C0027b bVar, ConstraintWidget constraintWidget, boolean z10) {
        float f10;
        float y10 = constraintWidget.y();
        int e10 = constraintWidget.O.f3740f.e();
        int e11 = constraintWidget.Q.f3740f.e();
        int f11 = constraintWidget.O.f() + e10;
        int f12 = e11 - constraintWidget.Q.f();
        if (e10 == e11) {
            y10 = 0.5f;
        } else {
            e10 = f11;
            e11 = f12;
        }
        int W = constraintWidget.W();
        int i11 = (e11 - e10) - W;
        if (e10 > e11) {
            i11 = (e10 - e11) - W;
        }
        if (i11 > 0) {
            f10 = (y10 * ((float) i11)) + 0.5f;
        } else {
            f10 = y10 * ((float) i11);
        }
        int i12 = ((int) f10) + e10;
        int i13 = i12 + W;
        if (e10 > e11) {
            i13 = i12 - W;
        }
        constraintWidget.F0(i12, i13);
        b(i10 + 1, constraintWidget, bVar, z10);
    }

    private static void e(int i10, ConstraintWidget constraintWidget, b.C0027b bVar, ConstraintWidget constraintWidget2, boolean z10) {
        int i11;
        float y10 = constraintWidget2.y();
        int e10 = constraintWidget2.O.f3740f.e() + constraintWidget2.O.f();
        int e11 = constraintWidget2.Q.f3740f.e() - constraintWidget2.Q.f();
        if (e11 >= e10) {
            int W = constraintWidget2.W();
            if (constraintWidget2.V() != 8) {
                int i12 = constraintWidget2.f3799w;
                if (i12 == 2) {
                    if (constraintWidget instanceof d) {
                        i11 = constraintWidget.W();
                    } else {
                        i11 = constraintWidget.K().W();
                    }
                    W = (int) (constraintWidget2.y() * 0.5f * ((float) i11));
                } else if (i12 == 0) {
                    W = e11 - e10;
                }
                W = Math.max(constraintWidget2.f3805z, W);
                int i13 = constraintWidget2.A;
                if (i13 > 0) {
                    W = Math.min(i13, W);
                }
            }
            int i14 = e10 + ((int) ((y10 * ((float) ((e11 - e10) - W))) + 0.5f));
            constraintWidget2.F0(i14, W + i14);
            b(i10 + 1, constraintWidget2, bVar, z10);
        }
    }

    private static void f(int i10, b.C0027b bVar, ConstraintWidget constraintWidget) {
        float f10;
        float R = constraintWidget.R();
        int e10 = constraintWidget.P.f3740f.e();
        int e11 = constraintWidget.R.f3740f.e();
        int f11 = constraintWidget.P.f() + e10;
        int f12 = e11 - constraintWidget.R.f();
        if (e10 == e11) {
            R = 0.5f;
        } else {
            e10 = f11;
            e11 = f12;
        }
        int x10 = constraintWidget.x();
        int i11 = (e11 - e10) - x10;
        if (e10 > e11) {
            i11 = (e10 - e11) - x10;
        }
        if (i11 > 0) {
            f10 = (R * ((float) i11)) + 0.5f;
        } else {
            f10 = R * ((float) i11);
        }
        int i12 = (int) f10;
        int i13 = e10 + i12;
        int i14 = i13 + x10;
        if (e10 > e11) {
            i13 = e10 - i12;
            i14 = i13 - x10;
        }
        constraintWidget.I0(i13, i14);
        i(i10 + 1, constraintWidget, bVar);
    }

    private static void g(int i10, ConstraintWidget constraintWidget, b.C0027b bVar, ConstraintWidget constraintWidget2) {
        int i11;
        float R = constraintWidget2.R();
        int e10 = constraintWidget2.P.f3740f.e() + constraintWidget2.P.f();
        int e11 = constraintWidget2.R.f3740f.e() - constraintWidget2.R.f();
        if (e11 >= e10) {
            int x10 = constraintWidget2.x();
            if (constraintWidget2.V() != 8) {
                int i12 = constraintWidget2.f3801x;
                if (i12 == 2) {
                    if (constraintWidget instanceof d) {
                        i11 = constraintWidget.x();
                    } else {
                        i11 = constraintWidget.K().x();
                    }
                    x10 = (int) (R * 0.5f * ((float) i11));
                } else if (i12 == 0) {
                    x10 = e11 - e10;
                }
                x10 = Math.max(constraintWidget2.C, x10);
                int i13 = constraintWidget2.D;
                if (i13 > 0) {
                    x10 = Math.min(i13, x10);
                }
            }
            int i14 = e10 + ((int) ((R * ((float) ((e11 - e10) - x10))) + 0.5f));
            constraintWidget2.I0(i14, x10 + i14);
            i(i10 + 1, constraintWidget2, bVar);
        }
    }

    public static void h(d dVar, b.C0027b bVar) {
        ConstraintWidget.DimensionBehaviour A = dVar.A();
        ConstraintWidget.DimensionBehaviour T = dVar.T();
        f3880b = 0;
        f3881c = 0;
        dVar.v0();
        ArrayList<ConstraintWidget> r12 = dVar.r1();
        int size = r12.size();
        for (int i10 = 0; i10 < size; i10++) {
            r12.get(i10).v0();
        }
        boolean P1 = dVar.P1();
        if (A == ConstraintWidget.DimensionBehaviour.FIXED) {
            dVar.F0(0, dVar.W());
        } else {
            dVar.G0(0);
        }
        boolean z10 = false;
        boolean z11 = false;
        for (int i11 = 0; i11 < size; i11++) {
            ConstraintWidget constraintWidget = r12.get(i11);
            if (constraintWidget instanceof androidx.constraintlayout.core.widgets.f) {
                androidx.constraintlayout.core.widgets.f fVar = (androidx.constraintlayout.core.widgets.f) constraintWidget;
                if (fVar.s1() == 1) {
                    if (fVar.t1() != -1) {
                        fVar.w1(fVar.t1());
                    } else if (fVar.u1() != -1 && dVar.n0()) {
                        fVar.w1(dVar.W() - fVar.u1());
                    } else if (dVar.n0()) {
                        fVar.w1((int) ((fVar.v1() * ((float) dVar.W())) + 0.5f));
                    }
                    z10 = true;
                }
            } else if ((constraintWidget instanceof a) && ((a) constraintWidget).x1() == 0) {
                z11 = true;
            }
        }
        if (z10) {
            for (int i12 = 0; i12 < size; i12++) {
                ConstraintWidget constraintWidget2 = r12.get(i12);
                if (constraintWidget2 instanceof androidx.constraintlayout.core.widgets.f) {
                    androidx.constraintlayout.core.widgets.f fVar2 = (androidx.constraintlayout.core.widgets.f) constraintWidget2;
                    if (fVar2.s1() == 1) {
                        b(0, fVar2, bVar, P1);
                    }
                }
            }
        }
        b(0, dVar, bVar, P1);
        if (z11) {
            for (int i13 = 0; i13 < size; i13++) {
                ConstraintWidget constraintWidget3 = r12.get(i13);
                if (constraintWidget3 instanceof a) {
                    a aVar = (a) constraintWidget3;
                    if (aVar.x1() == 0) {
                        c(0, aVar, bVar, 0, P1);
                    }
                }
            }
        }
        if (T == ConstraintWidget.DimensionBehaviour.FIXED) {
            dVar.I0(0, dVar.x());
        } else {
            dVar.H0(0);
        }
        boolean z12 = false;
        boolean z13 = false;
        for (int i14 = 0; i14 < size; i14++) {
            ConstraintWidget constraintWidget4 = r12.get(i14);
            if (constraintWidget4 instanceof androidx.constraintlayout.core.widgets.f) {
                androidx.constraintlayout.core.widgets.f fVar3 = (androidx.constraintlayout.core.widgets.f) constraintWidget4;
                if (fVar3.s1() == 0) {
                    if (fVar3.t1() != -1) {
                        fVar3.w1(fVar3.t1());
                    } else if (fVar3.u1() != -1 && dVar.o0()) {
                        fVar3.w1(dVar.x() - fVar3.u1());
                    } else if (dVar.o0()) {
                        fVar3.w1((int) ((fVar3.v1() * ((float) dVar.x())) + 0.5f));
                    }
                    z12 = true;
                }
            } else if ((constraintWidget4 instanceof a) && ((a) constraintWidget4).x1() == 1) {
                z13 = true;
            }
        }
        if (z12) {
            for (int i15 = 0; i15 < size; i15++) {
                ConstraintWidget constraintWidget5 = r12.get(i15);
                if (constraintWidget5 instanceof androidx.constraintlayout.core.widgets.f) {
                    androidx.constraintlayout.core.widgets.f fVar4 = (androidx.constraintlayout.core.widgets.f) constraintWidget5;
                    if (fVar4.s1() == 0) {
                        i(1, fVar4, bVar);
                    }
                }
            }
        }
        i(0, dVar, bVar);
        if (z13) {
            for (int i16 = 0; i16 < size; i16++) {
                ConstraintWidget constraintWidget6 = r12.get(i16);
                if (constraintWidget6 instanceof a) {
                    a aVar2 = (a) constraintWidget6;
                    if (aVar2.x1() == 1) {
                        c(0, aVar2, bVar, 1, P1);
                    }
                }
            }
        }
        for (int i17 = 0; i17 < size; i17++) {
            ConstraintWidget constraintWidget7 = r12.get(i17);
            if (constraintWidget7.m0() && a(0, constraintWidget7)) {
                d.S1(0, constraintWidget7, bVar, f3879a, b.a.f3854k);
                if (!(constraintWidget7 instanceof androidx.constraintlayout.core.widgets.f)) {
                    b(0, constraintWidget7, bVar, P1);
                    i(0, constraintWidget7, bVar);
                } else if (((androidx.constraintlayout.core.widgets.f) constraintWidget7).s1() == 0) {
                    i(0, constraintWidget7, bVar);
                } else {
                    b(0, constraintWidget7, bVar, P1);
                }
            }
        }
    }

    private static void i(int i10, ConstraintWidget constraintWidget, b.C0027b bVar) {
        boolean z10;
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        boolean z11;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        ConstraintWidget constraintWidget2 = constraintWidget;
        b.C0027b bVar2 = bVar;
        if (!constraintWidget.p0()) {
            f3881c++;
            if (!(constraintWidget2 instanceof d) && constraintWidget.m0()) {
                int i11 = i10 + 1;
                if (a(i11, constraintWidget2)) {
                    d.S1(i11, constraintWidget2, bVar2, new b.a(), b.a.f3854k);
                }
            }
            ConstraintAnchor o10 = constraintWidget2.o(ConstraintAnchor.Type.TOP);
            ConstraintAnchor o11 = constraintWidget2.o(ConstraintAnchor.Type.BOTTOM);
            int e10 = o10.e();
            int e11 = o11.e();
            if (o10.d() != null && o10.n()) {
                Iterator<ConstraintAnchor> it = o10.d().iterator();
                while (it.hasNext()) {
                    ConstraintAnchor next = it.next();
                    ConstraintWidget constraintWidget3 = next.f3738d;
                    int i12 = i10 + 1;
                    boolean a10 = a(i12, constraintWidget3);
                    if (constraintWidget3.m0() && a10) {
                        d.S1(i12, constraintWidget3, bVar2, new b.a(), b.a.f3854k);
                    }
                    if ((next != constraintWidget3.P || (constraintAnchor4 = constraintWidget3.R.f3740f) == null || !constraintAnchor4.n()) && (next != constraintWidget3.R || (constraintAnchor3 = constraintWidget3.P.f3740f) == null || !constraintAnchor3.n())) {
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                    ConstraintWidget.DimensionBehaviour T = constraintWidget3.T();
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (T != dimensionBehaviour || a10) {
                        if (!constraintWidget3.m0()) {
                            ConstraintAnchor constraintAnchor5 = constraintWidget3.P;
                            if (next == constraintAnchor5 && constraintWidget3.R.f3740f == null) {
                                int f10 = constraintAnchor5.f() + e10;
                                constraintWidget3.I0(f10, constraintWidget3.x() + f10);
                                i(i12, constraintWidget3, bVar2);
                            } else {
                                ConstraintAnchor constraintAnchor6 = constraintWidget3.R;
                                if (next == constraintAnchor6 && constraintAnchor5.f3740f == null) {
                                    int f11 = e10 - constraintAnchor6.f();
                                    constraintWidget3.I0(f11 - constraintWidget3.x(), f11);
                                    i(i12, constraintWidget3, bVar2);
                                } else if (z11 && !constraintWidget3.k0()) {
                                    f(i12, bVar2, constraintWidget3);
                                }
                            }
                        }
                    } else if (constraintWidget3.T() == dimensionBehaviour && constraintWidget3.D >= 0 && constraintWidget3.C >= 0) {
                        if ((constraintWidget3.V() == 8 || (constraintWidget3.f3801x == 0 && constraintWidget3.v() == 0.0f)) && !constraintWidget3.k0() && !constraintWidget3.l0() && z11 && !constraintWidget3.k0()) {
                            g(i12, constraintWidget2, bVar2, constraintWidget3);
                        }
                    }
                }
            }
            if (!(constraintWidget2 instanceof androidx.constraintlayout.core.widgets.f)) {
                if (o11.d() != null && o11.n()) {
                    Iterator<ConstraintAnchor> it2 = o11.d().iterator();
                    while (it2.hasNext()) {
                        ConstraintAnchor next2 = it2.next();
                        ConstraintWidget constraintWidget4 = next2.f3738d;
                        int i13 = i10 + 1;
                        boolean a11 = a(i13, constraintWidget4);
                        if (constraintWidget4.m0() && a11) {
                            d.S1(i13, constraintWidget4, bVar2, new b.a(), b.a.f3854k);
                        }
                        if ((next2 != constraintWidget4.P || (constraintAnchor2 = constraintWidget4.R.f3740f) == null || !constraintAnchor2.n()) && (next2 != constraintWidget4.R || (constraintAnchor = constraintWidget4.P.f3740f) == null || !constraintAnchor.n())) {
                            z10 = false;
                        } else {
                            z10 = true;
                        }
                        ConstraintWidget.DimensionBehaviour T2 = constraintWidget4.T();
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (T2 != dimensionBehaviour2 || a11) {
                            if (!constraintWidget4.m0()) {
                                ConstraintAnchor constraintAnchor7 = constraintWidget4.P;
                                if (next2 == constraintAnchor7 && constraintWidget4.R.f3740f == null) {
                                    int f12 = constraintAnchor7.f() + e11;
                                    constraintWidget4.I0(f12, constraintWidget4.x() + f12);
                                    i(i13, constraintWidget4, bVar2);
                                } else {
                                    ConstraintAnchor constraintAnchor8 = constraintWidget4.R;
                                    if (next2 == constraintAnchor8 && constraintAnchor7.f3740f == null) {
                                        int f13 = e11 - constraintAnchor8.f();
                                        constraintWidget4.I0(f13 - constraintWidget4.x(), f13);
                                        i(i13, constraintWidget4, bVar2);
                                    } else if (z10 && !constraintWidget4.k0()) {
                                        f(i13, bVar2, constraintWidget4);
                                    }
                                }
                            }
                        } else if (constraintWidget4.T() == dimensionBehaviour2 && constraintWidget4.D >= 0 && constraintWidget4.C >= 0) {
                            if ((constraintWidget4.V() == 8 || (constraintWidget4.f3801x == 0 && constraintWidget4.v() == 0.0f)) && !constraintWidget4.k0() && !constraintWidget4.l0() && z10 && !constraintWidget4.k0()) {
                                g(i13, constraintWidget2, bVar2, constraintWidget4);
                            }
                        }
                    }
                }
                ConstraintAnchor o12 = constraintWidget2.o(ConstraintAnchor.Type.BASELINE);
                if (o12.d() != null && o12.n()) {
                    int e12 = o12.e();
                    Iterator<ConstraintAnchor> it3 = o12.d().iterator();
                    while (it3.hasNext()) {
                        ConstraintAnchor next3 = it3.next();
                        ConstraintWidget constraintWidget5 = next3.f3738d;
                        int i14 = i10 + 1;
                        boolean a12 = a(i14, constraintWidget5);
                        if (constraintWidget5.m0() && a12) {
                            d.S1(i14, constraintWidget5, bVar2, new b.a(), b.a.f3854k);
                        }
                        if ((constraintWidget5.T() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || a12) && !constraintWidget5.m0() && next3 == constraintWidget5.S) {
                            constraintWidget5.E0(next3.f() + e12);
                            i(i14, constraintWidget5, bVar2);
                        }
                    }
                }
                constraintWidget.r0();
            }
        }
    }
}
