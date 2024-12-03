package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import p0.c;

public class d extends c {
    b M0 = new b(this);
    public androidx.constraintlayout.core.widgets.analyzer.d N0 = new androidx.constraintlayout.core.widgets.analyzer.d(this);
    private int O0;
    protected b.C0027b P0 = null;
    private boolean Q0 = false;
    protected androidx.constraintlayout.core.d R0 = new androidx.constraintlayout.core.d();
    int S0;
    int T0;
    int U0;
    int V0;
    public int W0 = 0;
    public int X0 = 0;
    c[] Y0 = new c[4];
    c[] Z0 = new c[4];

    /* renamed from: a1  reason: collision with root package name */
    public boolean f3932a1 = false;

    /* renamed from: b1  reason: collision with root package name */
    public boolean f3933b1 = false;

    /* renamed from: c1  reason: collision with root package name */
    public boolean f3934c1 = false;

    /* renamed from: d1  reason: collision with root package name */
    public int f3935d1 = 0;

    /* renamed from: e1  reason: collision with root package name */
    public int f3936e1 = 0;

    /* renamed from: f1  reason: collision with root package name */
    private int f3937f1 = 257;

    /* renamed from: g1  reason: collision with root package name */
    public boolean f3938g1 = false;

    /* renamed from: h1  reason: collision with root package name */
    private boolean f3939h1 = false;

    /* renamed from: i1  reason: collision with root package name */
    private boolean f3940i1 = false;

    /* renamed from: j1  reason: collision with root package name */
    int f3941j1 = 0;

    /* renamed from: k1  reason: collision with root package name */
    private WeakReference<ConstraintAnchor> f3942k1 = null;

    /* renamed from: l1  reason: collision with root package name */
    private WeakReference<ConstraintAnchor> f3943l1 = null;

    /* renamed from: m1  reason: collision with root package name */
    private WeakReference<ConstraintAnchor> f3944m1 = null;

    /* renamed from: n1  reason: collision with root package name */
    private WeakReference<ConstraintAnchor> f3945n1 = null;

    /* renamed from: o1  reason: collision with root package name */
    HashSet<ConstraintWidget> f3946o1 = new HashSet<>();

    /* renamed from: p1  reason: collision with root package name */
    public b.a f3947p1 = new b.a();

    private void A1(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        this.R0.h(solverVariable, this.R0.q(constraintAnchor), 0, 5);
    }

    private void B1(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        this.R0.h(this.R0.q(constraintAnchor), solverVariable, 0, 5);
    }

    private void C1(ConstraintWidget constraintWidget) {
        int i10 = this.X0 + 1;
        c[] cVarArr = this.Y0;
        if (i10 >= cVarArr.length) {
            this.Y0 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.Y0[this.X0] = new c(constraintWidget, 1, P1());
        this.X0++;
    }

    public static boolean S1(int i10, ConstraintWidget constraintWidget, b.C0027b bVar, b.a aVar, int i11) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        int i12;
        int i13;
        if (bVar == null) {
            return false;
        }
        if (constraintWidget.V() == 8 || (constraintWidget instanceof f) || (constraintWidget instanceof a)) {
            aVar.f3861e = 0;
            aVar.f3862f = 0;
            return false;
        }
        aVar.f3857a = constraintWidget.A();
        aVar.f3858b = constraintWidget.T();
        aVar.f3859c = constraintWidget.W();
        aVar.f3860d = constraintWidget.x();
        aVar.f3865i = false;
        aVar.f3866j = i11;
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
        if (z10 && constraintWidget.a0(0) && constraintWidget.f3799w == 0 && !z12) {
            aVar.f3857a = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (z11 && constraintWidget.f3801x == 0) {
                aVar.f3857a = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            z10 = false;
        }
        if (z11 && constraintWidget.a0(1) && constraintWidget.f3801x == 0 && !z13) {
            aVar.f3858b = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (z10 && constraintWidget.f3799w == 0) {
                aVar.f3858b = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            z11 = false;
        }
        if (constraintWidget.n0()) {
            aVar.f3857a = ConstraintWidget.DimensionBehaviour.FIXED;
            z10 = false;
        }
        if (constraintWidget.o0()) {
            aVar.f3858b = ConstraintWidget.DimensionBehaviour.FIXED;
            z11 = false;
        }
        if (z12) {
            if (constraintWidget.f3803y[0] == 4) {
                aVar.f3857a = ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (!z11) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = aVar.f3858b;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                if (dimensionBehaviour3 == dimensionBehaviour4) {
                    i13 = aVar.f3860d;
                } else {
                    aVar.f3857a = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    bVar.b(constraintWidget, aVar);
                    i13 = aVar.f3862f;
                }
                aVar.f3857a = dimensionBehaviour4;
                aVar.f3859c = (int) (constraintWidget.v() * ((float) i13));
            }
        }
        if (z13) {
            if (constraintWidget.f3803y[1] == 4) {
                aVar.f3858b = ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (!z10) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = aVar.f3857a;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.FIXED;
                if (dimensionBehaviour5 == dimensionBehaviour6) {
                    i12 = aVar.f3859c;
                } else {
                    aVar.f3858b = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    bVar.b(constraintWidget, aVar);
                    i12 = aVar.f3861e;
                }
                aVar.f3858b = dimensionBehaviour6;
                if (constraintWidget.w() == -1) {
                    aVar.f3860d = (int) (((float) i12) / constraintWidget.v());
                } else {
                    aVar.f3860d = (int) (constraintWidget.v() * ((float) i12));
                }
            }
        }
        bVar.b(constraintWidget, aVar);
        constraintWidget.k1(aVar.f3861e);
        constraintWidget.L0(aVar.f3862f);
        constraintWidget.K0(aVar.f3864h);
        constraintWidget.A0(aVar.f3863g);
        aVar.f3866j = b.a.f3854k;
        return aVar.f3865i;
    }

    private void U1() {
        this.W0 = 0;
        this.X0 = 0;
    }

    private void x1(ConstraintWidget constraintWidget) {
        int i10 = this.W0 + 1;
        c[] cVarArr = this.Z0;
        if (i10 >= cVarArr.length) {
            this.Z0 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.Z0[this.W0] = new c(constraintWidget, 0, P1());
        this.W0++;
    }

    /* access modifiers changed from: package-private */
    public void D1(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.f3944m1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > this.f3944m1.get().e()) {
            this.f3944m1 = new WeakReference<>(constraintAnchor);
        }
    }

    /* access modifiers changed from: package-private */
    public void E1(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.f3942k1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > this.f3942k1.get().e()) {
            this.f3942k1 = new WeakReference<>(constraintAnchor);
        }
    }

    public boolean F1(boolean z10) {
        return this.N0.f(z10);
    }

    public boolean G1(boolean z10) {
        return this.N0.g(z10);
    }

    public boolean H1(boolean z10, int i10) {
        return this.N0.h(z10, i10);
    }

    public b.C0027b I1() {
        return this.P0;
    }

    public int J1() {
        return this.f3937f1;
    }

    public androidx.constraintlayout.core.d K1() {
        return this.R0;
    }

    public boolean L1() {
        return false;
    }

    public void M1() {
        this.N0.j();
    }

    public void N1() {
        this.N0.k();
    }

    public void O(StringBuilder sb2) {
        sb2.append(this.f3783o + ":{\n");
        sb2.append("  actualWidth:" + this.f3758b0);
        sb2.append("\n");
        sb2.append("  actualHeight:" + this.f3760c0);
        sb2.append("\n");
        Iterator<ConstraintWidget> it = r1().iterator();
        while (it.hasNext()) {
            it.next().O(sb2);
            sb2.append(",\n");
        }
        sb2.append("}");
    }

    public boolean O1() {
        return this.f3940i1;
    }

    public boolean P1() {
        return this.Q0;
    }

    public boolean Q1() {
        return this.f3939h1;
    }

    public long R1(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        int i19 = i17;
        this.S0 = i19;
        int i20 = i18;
        this.T0 = i20;
        return this.M0.d(this, i10, i19, i20, i11, i12, i13, i14, i15, i16);
    }

    public boolean T1(int i10) {
        return (this.f3937f1 & i10) == i10;
    }

    public void V1(b.C0027b bVar) {
        this.P0 = bVar;
        this.N0.n(bVar);
    }

    public void W1(int i10) {
        this.f3937f1 = i10;
        androidx.constraintlayout.core.d.f3683r = T1(512);
    }

    public void X1(int i10) {
        this.O0 = i10;
    }

    public void Y1(boolean z10) {
        this.Q0 = z10;
    }

    public boolean Z1(androidx.constraintlayout.core.d dVar, boolean[] zArr) {
        zArr[2] = false;
        boolean T1 = T1(64);
        q1(dVar, T1);
        int size = this.L0.size();
        boolean z10 = false;
        for (int i10 = 0; i10 < size; i10++) {
            ConstraintWidget constraintWidget = this.L0.get(i10);
            constraintWidget.q1(dVar, T1);
            if (constraintWidget.c0()) {
                z10 = true;
            }
        }
        return z10;
    }

    public void a2() {
        this.M0.e(this);
    }

    public void p1(boolean z10, boolean z11) {
        super.p1(z10, z11);
        int size = this.L0.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.L0.get(i10).p1(z10, z11);
        }
    }

    /* JADX WARNING: type inference failed for: r6v1, types: [boolean] */
    /* JADX WARNING: type inference failed for: r6v3 */
    /* JADX WARNING: type inference failed for: r6v4 */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0310  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0312  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void s1() {
        /*
            r18 = this;
            r1 = r18
            r2 = 0
            r1.f3766f0 = r2
            r1.f3768g0 = r2
            r1.f3939h1 = r2
            r1.f3940i1 = r2
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r0 = r1.L0
            int r3 = r0.size()
            int r0 = r18.W()
            int r0 = java.lang.Math.max(r2, r0)
            int r4 = r18.x()
            int r4 = java.lang.Math.max(r2, r4)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r1.Z
            r6 = 1
            r7 = r5[r6]
            r5 = r5[r2]
            int r8 = r1.O0
            if (r8 != 0) goto L_0x0088
            int r8 = r1.f3937f1
            boolean r8 = androidx.constraintlayout.core.widgets.g.b(r8, r6)
            if (r8 == 0) goto L_0x0088
            androidx.constraintlayout.core.widgets.analyzer.b$b r8 = r18.I1()
            androidx.constraintlayout.core.widgets.analyzer.f.h(r1, r8)
            r8 = r2
        L_0x003c:
            if (r8 >= r3) goto L_0x0088
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r9 = r1.L0
            java.lang.Object r9 = r9.get(r8)
            androidx.constraintlayout.core.widgets.ConstraintWidget r9 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r9
            boolean r10 = r9.m0()
            if (r10 == 0) goto L_0x0085
            boolean r10 = r9 instanceof androidx.constraintlayout.core.widgets.f
            if (r10 != 0) goto L_0x0085
            boolean r10 = r9 instanceof androidx.constraintlayout.core.widgets.a
            if (r10 != 0) goto L_0x0085
            boolean r10 = r9 instanceof androidx.constraintlayout.core.widgets.h
            if (r10 != 0) goto L_0x0085
            boolean r10 = r9.l0()
            if (r10 != 0) goto L_0x0085
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r10 = r9.u(r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = r9.u(r6)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r10 != r12) goto L_0x0076
            int r10 = r9.f3799w
            if (r10 == r6) goto L_0x0076
            if (r11 != r12) goto L_0x0076
            int r10 = r9.f3801x
            if (r10 == r6) goto L_0x0076
            r10 = r6
            goto L_0x0077
        L_0x0076:
            r10 = r2
        L_0x0077:
            if (r10 != 0) goto L_0x0085
            androidx.constraintlayout.core.widgets.analyzer.b$a r10 = new androidx.constraintlayout.core.widgets.analyzer.b$a
            r10.<init>()
            androidx.constraintlayout.core.widgets.analyzer.b$b r11 = r1.P0
            int r12 = androidx.constraintlayout.core.widgets.analyzer.b.a.f3854k
            S1(r2, r9, r11, r10, r12)
        L_0x0085:
            int r8 = r8 + 1
            goto L_0x003c
        L_0x0088:
            r8 = 2
            if (r3 <= r8) goto L_0x00d1
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r5 == r9) goto L_0x0091
            if (r7 != r9) goto L_0x00d1
        L_0x0091:
            int r10 = r1.f3937f1
            r11 = 1024(0x400, float:1.435E-42)
            boolean r10 = androidx.constraintlayout.core.widgets.g.b(r10, r11)
            if (r10 == 0) goto L_0x00d1
            androidx.constraintlayout.core.widgets.analyzer.b$b r10 = r18.I1()
            boolean r10 = androidx.constraintlayout.core.widgets.analyzer.g.c(r1, r10)
            if (r10 == 0) goto L_0x00d1
            if (r5 != r9) goto L_0x00b9
            int r10 = r18.W()
            if (r0 >= r10) goto L_0x00b5
            if (r0 <= 0) goto L_0x00b5
            r1.k1(r0)
            r1.f3939h1 = r6
            goto L_0x00b9
        L_0x00b5:
            int r0 = r18.W()
        L_0x00b9:
            if (r7 != r9) goto L_0x00cd
            int r9 = r18.x()
            if (r4 >= r9) goto L_0x00c9
            if (r4 <= 0) goto L_0x00c9
            r1.L0(r4)
            r1.f3940i1 = r6
            goto L_0x00cd
        L_0x00c9:
            int r4 = r18.x()
        L_0x00cd:
            r9 = r4
            r4 = r0
            r0 = r6
            goto L_0x00d4
        L_0x00d1:
            r9 = r4
            r4 = r0
            r0 = r2
        L_0x00d4:
            r10 = 64
            boolean r11 = r1.T1(r10)
            if (r11 != 0) goto L_0x00e7
            r11 = 128(0x80, float:1.794E-43)
            boolean r11 = r1.T1(r11)
            if (r11 == 0) goto L_0x00e5
            goto L_0x00e7
        L_0x00e5:
            r11 = r2
            goto L_0x00e8
        L_0x00e7:
            r11 = r6
        L_0x00e8:
            androidx.constraintlayout.core.d r12 = r1.R0
            r12.f3698h = r2
            r12.f3699i = r2
            int r13 = r1.f3937f1
            if (r13 == 0) goto L_0x00f6
            if (r11 == 0) goto L_0x00f6
            r12.f3699i = r6
        L_0x00f6:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r11 = r1.L0
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = r18.A()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r12 == r13) goto L_0x0109
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = r18.T()
            if (r12 != r13) goto L_0x0107
            goto L_0x0109
        L_0x0107:
            r12 = r2
            goto L_0x010a
        L_0x0109:
            r12 = r6
        L_0x010a:
            r18.U1()
            r13 = r2
        L_0x010e:
            if (r13 >= r3) goto L_0x0124
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r14 = r1.L0
            java.lang.Object r14 = r14.get(r13)
            androidx.constraintlayout.core.widgets.ConstraintWidget r14 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r14
            boolean r15 = r14 instanceof p0.c
            if (r15 == 0) goto L_0x0121
            p0.c r14 = (p0.c) r14
            r14.s1()
        L_0x0121:
            int r13 = r13 + 1
            goto L_0x010e
        L_0x0124:
            boolean r10 = r1.T1(r10)
            r13 = r0
            r0 = r2
            r14 = r6
        L_0x012b:
            if (r14 == 0) goto L_0x0319
            int r15 = r0 + 1
            androidx.constraintlayout.core.d r0 = r1.R0     // Catch:{ Exception -> 0x01dc }
            r0.D()     // Catch:{ Exception -> 0x01dc }
            r18.U1()     // Catch:{ Exception -> 0x01dc }
            androidx.constraintlayout.core.d r0 = r1.R0     // Catch:{ Exception -> 0x01dc }
            r1.m(r0)     // Catch:{ Exception -> 0x01dc }
            r0 = r2
        L_0x013d:
            if (r0 >= r3) goto L_0x0151
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r6 = r1.L0     // Catch:{ Exception -> 0x01dc }
            java.lang.Object r6 = r6.get(r0)     // Catch:{ Exception -> 0x01dc }
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r6     // Catch:{ Exception -> 0x01dc }
            androidx.constraintlayout.core.d r2 = r1.R0     // Catch:{ Exception -> 0x01dc }
            r6.m(r2)     // Catch:{ Exception -> 0x01dc }
            int r0 = r0 + 1
            r2 = 0
            r6 = 1
            goto L_0x013d
        L_0x0151:
            androidx.constraintlayout.core.d r0 = r1.R0     // Catch:{ Exception -> 0x01dc }
            boolean r14 = r1.w1(r0)     // Catch:{ Exception -> 0x01dc }
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.f3942k1     // Catch:{ Exception -> 0x01dc }
            r2 = 0
            if (r0 == 0) goto L_0x0177
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x01dc }
            if (r0 == 0) goto L_0x0177
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.f3942k1     // Catch:{ Exception -> 0x01dc }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x01dc }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r0     // Catch:{ Exception -> 0x01dc }
            androidx.constraintlayout.core.d r6 = r1.R0     // Catch:{ Exception -> 0x01dc }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r1.P     // Catch:{ Exception -> 0x01dc }
            androidx.constraintlayout.core.SolverVariable r6 = r6.q(r8)     // Catch:{ Exception -> 0x01dc }
            r1.B1(r0, r6)     // Catch:{ Exception -> 0x01dc }
            r1.f3942k1 = r2     // Catch:{ Exception -> 0x01dc }
        L_0x0177:
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.f3944m1     // Catch:{ Exception -> 0x01dc }
            if (r0 == 0) goto L_0x0196
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x01dc }
            if (r0 == 0) goto L_0x0196
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.f3944m1     // Catch:{ Exception -> 0x01dc }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x01dc }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r0     // Catch:{ Exception -> 0x01dc }
            androidx.constraintlayout.core.d r6 = r1.R0     // Catch:{ Exception -> 0x01dc }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r1.R     // Catch:{ Exception -> 0x01dc }
            androidx.constraintlayout.core.SolverVariable r6 = r6.q(r8)     // Catch:{ Exception -> 0x01dc }
            r1.A1(r0, r6)     // Catch:{ Exception -> 0x01dc }
            r1.f3944m1 = r2     // Catch:{ Exception -> 0x01dc }
        L_0x0196:
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.f3943l1     // Catch:{ Exception -> 0x01dc }
            if (r0 == 0) goto L_0x01b5
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x01dc }
            if (r0 == 0) goto L_0x01b5
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.f3943l1     // Catch:{ Exception -> 0x01dc }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x01dc }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r0     // Catch:{ Exception -> 0x01dc }
            androidx.constraintlayout.core.d r6 = r1.R0     // Catch:{ Exception -> 0x01dc }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r1.O     // Catch:{ Exception -> 0x01dc }
            androidx.constraintlayout.core.SolverVariable r6 = r6.q(r8)     // Catch:{ Exception -> 0x01dc }
            r1.B1(r0, r6)     // Catch:{ Exception -> 0x01dc }
            r1.f3943l1 = r2     // Catch:{ Exception -> 0x01dc }
        L_0x01b5:
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.f3945n1     // Catch:{ Exception -> 0x01dc }
            if (r0 == 0) goto L_0x01d4
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x01dc }
            if (r0 == 0) goto L_0x01d4
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.f3945n1     // Catch:{ Exception -> 0x01dc }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x01dc }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r0     // Catch:{ Exception -> 0x01dc }
            androidx.constraintlayout.core.d r6 = r1.R0     // Catch:{ Exception -> 0x01dc }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r1.Q     // Catch:{ Exception -> 0x01dc }
            androidx.constraintlayout.core.SolverVariable r6 = r6.q(r8)     // Catch:{ Exception -> 0x01dc }
            r1.A1(r0, r6)     // Catch:{ Exception -> 0x01dc }
            r1.f3945n1 = r2     // Catch:{ Exception -> 0x01dc }
        L_0x01d4:
            if (r14 == 0) goto L_0x01f6
            androidx.constraintlayout.core.d r0 = r1.R0     // Catch:{ Exception -> 0x01dc }
            r0.z()     // Catch:{ Exception -> 0x01dc }
            goto L_0x01f6
        L_0x01dc:
            r0 = move-exception
            r0.printStackTrace()
            java.io.PrintStream r2 = java.lang.System.out
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = "EXCEPTION : "
            r6.append(r8)
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            r2.println(r0)
        L_0x01f6:
            if (r14 == 0) goto L_0x0201
            androidx.constraintlayout.core.d r0 = r1.R0
            boolean[] r2 = androidx.constraintlayout.core.widgets.g.f3992a
            boolean r0 = r1.Z1(r0, r2)
            goto L_0x021a
        L_0x0201:
            androidx.constraintlayout.core.d r0 = r1.R0
            r1.q1(r0, r10)
            r0 = 0
        L_0x0207:
            if (r0 >= r3) goto L_0x0219
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r2 = r1.L0
            java.lang.Object r2 = r2.get(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            androidx.constraintlayout.core.d r6 = r1.R0
            r2.q1(r6, r10)
            int r0 = r0 + 1
            goto L_0x0207
        L_0x0219:
            r0 = 0
        L_0x021a:
            r2 = 8
            if (r12 == 0) goto L_0x028b
            if (r15 >= r2) goto L_0x028b
            boolean[] r6 = androidx.constraintlayout.core.widgets.g.f3992a
            r8 = 2
            boolean r6 = r6[r8]
            if (r6 == 0) goto L_0x028b
            r6 = 0
            r8 = 0
            r14 = 0
        L_0x022a:
            if (r6 >= r3) goto L_0x0254
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r2 = r1.L0
            java.lang.Object r2 = r2.get(r6)
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            r16 = r0
            int r0 = r2.f3766f0
            int r17 = r2.W()
            int r0 = r0 + r17
            int r14 = java.lang.Math.max(r14, r0)
            int r0 = r2.f3768g0
            int r2 = r2.x()
            int r0 = r0 + r2
            int r8 = java.lang.Math.max(r8, r0)
            int r6 = r6 + 1
            r0 = r16
            r2 = 8
            goto L_0x022a
        L_0x0254:
            r16 = r0
            int r0 = r1.f3780m0
            int r0 = java.lang.Math.max(r0, r14)
            int r2 = r1.f3782n0
            int r2 = java.lang.Math.max(r2, r8)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r5 != r6) goto L_0x0277
            int r8 = r18.W()
            if (r8 >= r0) goto L_0x0277
            r1.k1(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.Z
            r8 = 0
            r0[r8] = r6
            r13 = 1
            r16 = 1
        L_0x0277:
            if (r7 != r6) goto L_0x028d
            int r0 = r18.x()
            if (r0 >= r2) goto L_0x028d
            r1.L0(r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.Z
            r2 = 1
            r0[r2] = r6
            r13 = 1
            r16 = 1
            goto L_0x028d
        L_0x028b:
            r16 = r0
        L_0x028d:
            int r0 = r1.f3780m0
            int r2 = r18.W()
            int r0 = java.lang.Math.max(r0, r2)
            int r2 = r18.W()
            if (r0 <= r2) goto L_0x02aa
            r1.k1(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.Z
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r6 = 0
            r0[r6] = r2
            r13 = 1
            r16 = 1
        L_0x02aa:
            int r0 = r1.f3782n0
            int r2 = r18.x()
            int r0 = java.lang.Math.max(r0, r2)
            int r2 = r18.x()
            if (r0 <= r2) goto L_0x02c8
            r1.L0(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.Z
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r6 = 1
            r0[r6] = r2
            r2 = r6
            r16 = r2
            goto L_0x02ca
        L_0x02c8:
            r6 = 1
            r2 = r13
        L_0x02ca:
            if (r2 != 0) goto L_0x0309
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.Z
            r8 = 0
            r0 = r0[r8]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r13) goto L_0x02eb
            if (r4 <= 0) goto L_0x02eb
            int r0 = r18.W()
            if (r0 <= r4) goto L_0x02eb
            r1.f3939h1 = r6
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.Z
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r0[r8] = r2
            r1.k1(r4)
            r2 = r6
            r16 = r2
        L_0x02eb:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.Z
            r0 = r0[r6]
            if (r0 != r13) goto L_0x0309
            if (r9 <= 0) goto L_0x0309
            int r0 = r18.x()
            if (r0 <= r9) goto L_0x0309
            r1.f3940i1 = r6
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.Z
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r0[r6] = r2
            r1.L0(r9)
            r0 = 8
            r2 = 1
            r13 = 1
            goto L_0x030e
        L_0x0309:
            r13 = r2
            r2 = r16
            r0 = 8
        L_0x030e:
            if (r15 <= r0) goto L_0x0312
            r14 = 0
            goto L_0x0313
        L_0x0312:
            r14 = r2
        L_0x0313:
            r0 = r15
            r2 = 0
            r6 = 1
            r8 = 2
            goto L_0x012b
        L_0x0319:
            r1.L0 = r11
            if (r13 == 0) goto L_0x0325
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r1.Z
            r2 = 0
            r0[r2] = r5
            r2 = 1
            r0[r2] = r7
        L_0x0325:
            androidx.constraintlayout.core.d r0 = r1.R0
            androidx.constraintlayout.core.c r0 = r0.v()
            r1.w0(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.d.s1():void");
    }

    public void t0() {
        this.R0.D();
        this.S0 = 0;
        this.U0 = 0;
        this.T0 = 0;
        this.V0 = 0;
        this.f3938g1 = false;
        super.t0();
    }

    /* access modifiers changed from: package-private */
    public void v1(ConstraintWidget constraintWidget, int i10) {
        if (i10 == 0) {
            x1(constraintWidget);
        } else if (i10 == 1) {
            C1(constraintWidget);
        }
    }

    public boolean w1(androidx.constraintlayout.core.d dVar) {
        int i10;
        boolean T1 = T1(64);
        g(dVar, T1);
        int size = this.L0.size();
        boolean z10 = false;
        for (int i11 = 0; i11 < size; i11++) {
            ConstraintWidget constraintWidget = this.L0.get(i11);
            constraintWidget.S0(0, false);
            constraintWidget.S0(1, false);
            if (constraintWidget instanceof a) {
                z10 = true;
            }
        }
        if (z10) {
            for (int i12 = 0; i12 < size; i12++) {
                ConstraintWidget constraintWidget2 = this.L0.get(i12);
                if (constraintWidget2 instanceof a) {
                    ((a) constraintWidget2).y1();
                }
            }
        }
        this.f3946o1.clear();
        for (int i13 = 0; i13 < size; i13++) {
            ConstraintWidget constraintWidget3 = this.L0.get(i13);
            if (constraintWidget3.f()) {
                if (constraintWidget3 instanceof h) {
                    this.f3946o1.add(constraintWidget3);
                } else {
                    constraintWidget3.g(dVar, T1);
                }
            }
        }
        while (this.f3946o1.size() > 0) {
            int size2 = this.f3946o1.size();
            Iterator<ConstraintWidget> it = this.f3946o1.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h hVar = (h) it.next();
                if (hVar.v1(this.f3946o1)) {
                    hVar.g(dVar, T1);
                    this.f3946o1.remove(hVar);
                    break;
                }
            }
            if (size2 == this.f3946o1.size()) {
                Iterator<ConstraintWidget> it2 = this.f3946o1.iterator();
                while (it2.hasNext()) {
                    it2.next().g(dVar, T1);
                }
                this.f3946o1.clear();
            }
        }
        if (androidx.constraintlayout.core.d.f3683r) {
            HashSet hashSet = new HashSet();
            for (int i14 = 0; i14 < size; i14++) {
                ConstraintWidget constraintWidget4 = this.L0.get(i14);
                if (!constraintWidget4.f()) {
                    hashSet.add(constraintWidget4);
                }
            }
            if (A() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                i10 = 0;
            } else {
                i10 = 1;
            }
            e(this, dVar, hashSet, i10, false);
            Iterator it3 = hashSet.iterator();
            while (it3.hasNext()) {
                ConstraintWidget constraintWidget5 = (ConstraintWidget) it3.next();
                g.a(this, dVar, constraintWidget5);
                constraintWidget5.g(dVar, T1);
            }
        } else {
            for (int i15 = 0; i15 < size; i15++) {
                ConstraintWidget constraintWidget6 = this.L0.get(i15);
                if (constraintWidget6 instanceof d) {
                    ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget6.Z;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        constraintWidget6.P0(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        constraintWidget6.g1(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    constraintWidget6.g(dVar, T1);
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        constraintWidget6.P0(dimensionBehaviour);
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        constraintWidget6.g1(dimensionBehaviour2);
                    }
                } else {
                    g.a(this, dVar, constraintWidget6);
                    if (!constraintWidget6.f()) {
                        constraintWidget6.g(dVar, T1);
                    }
                }
            }
        }
        if (this.W0 > 0) {
            b.b(this, dVar, (ArrayList<ConstraintWidget>) null, 0);
        }
        if (this.X0 > 0) {
            b.b(this, dVar, (ArrayList<ConstraintWidget>) null, 1);
        }
        return true;
    }

    public void y1(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.f3945n1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > this.f3945n1.get().e()) {
            this.f3945n1 = new WeakReference<>(constraintAnchor);
        }
    }

    public void z1(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.f3943l1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > this.f3943l1.get().e()) {
            this.f3943l1 = new WeakReference<>(constraintAnchor);
        }
    }
}
