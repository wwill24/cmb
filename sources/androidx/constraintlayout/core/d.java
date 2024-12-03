package androidx.constraintlayout.core;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.Arrays;
import java.util.HashMap;

public class d {

    /* renamed from: r  reason: collision with root package name */
    public static boolean f3683r = false;

    /* renamed from: s  reason: collision with root package name */
    public static boolean f3684s = true;

    /* renamed from: t  reason: collision with root package name */
    public static boolean f3685t = true;

    /* renamed from: u  reason: collision with root package name */
    public static boolean f3686u = true;

    /* renamed from: v  reason: collision with root package name */
    public static boolean f3687v = false;

    /* renamed from: w  reason: collision with root package name */
    private static int f3688w = 1000;

    /* renamed from: x  reason: collision with root package name */
    public static long f3689x;

    /* renamed from: y  reason: collision with root package name */
    public static long f3690y;

    /* renamed from: a  reason: collision with root package name */
    public boolean f3691a;

    /* renamed from: b  reason: collision with root package name */
    int f3692b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap<String, SolverVariable> f3693c;

    /* renamed from: d  reason: collision with root package name */
    private a f3694d;

    /* renamed from: e  reason: collision with root package name */
    private int f3695e;

    /* renamed from: f  reason: collision with root package name */
    private int f3696f;

    /* renamed from: g  reason: collision with root package name */
    b[] f3697g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3698h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3699i;

    /* renamed from: j  reason: collision with root package name */
    private boolean[] f3700j;

    /* renamed from: k  reason: collision with root package name */
    int f3701k;

    /* renamed from: l  reason: collision with root package name */
    int f3702l;

    /* renamed from: m  reason: collision with root package name */
    private int f3703m;

    /* renamed from: n  reason: collision with root package name */
    final c f3704n;

    /* renamed from: o  reason: collision with root package name */
    private SolverVariable[] f3705o;

    /* renamed from: p  reason: collision with root package name */
    private int f3706p;

    /* renamed from: q  reason: collision with root package name */
    private a f3707q;

    interface a {
        void a(a aVar);

        SolverVariable b(d dVar, boolean[] zArr);

        void c(SolverVariable solverVariable);

        void clear();

        SolverVariable getKey();

        boolean isEmpty();
    }

    class b extends b {
        public b(c cVar) {
            this.f3677e = new h(this, cVar);
        }
    }

    public d() {
        this.f3691a = false;
        this.f3692b = 0;
        this.f3693c = null;
        this.f3695e = 32;
        this.f3696f = 32;
        this.f3697g = null;
        this.f3698h = false;
        this.f3699i = false;
        this.f3700j = new boolean[32];
        this.f3701k = 1;
        this.f3702l = 0;
        this.f3703m = 32;
        this.f3705o = new SolverVariable[f3688w];
        this.f3706p = 0;
        this.f3697g = new b[32];
        C();
        c cVar = new c();
        this.f3704n = cVar;
        this.f3694d = new g(cVar);
        if (f3687v) {
            this.f3707q = new b(cVar);
        } else {
            this.f3707q = new b(cVar);
        }
    }

    private final int B(a aVar, boolean z10) {
        for (int i10 = 0; i10 < this.f3701k; i10++) {
            this.f3700j[i10] = false;
        }
        boolean z11 = false;
        int i11 = 0;
        while (!z11) {
            i11++;
            if (i11 >= this.f3701k * 2) {
                return i11;
            }
            if (aVar.getKey() != null) {
                this.f3700j[aVar.getKey().f3640c] = true;
            }
            SolverVariable b10 = aVar.b(this, this.f3700j);
            if (b10 != null) {
                boolean[] zArr = this.f3700j;
                int i12 = b10.f3640c;
                if (zArr[i12]) {
                    return i11;
                }
                zArr[i12] = true;
            }
            if (b10 != null) {
                float f10 = Float.MAX_VALUE;
                int i13 = -1;
                for (int i14 = 0; i14 < this.f3702l; i14++) {
                    b bVar = this.f3697g[i14];
                    if (bVar.f3673a.f3647k != SolverVariable.Type.UNRESTRICTED && !bVar.f3678f && bVar.t(b10)) {
                        float i15 = bVar.f3677e.i(b10);
                        if (i15 < 0.0f) {
                            float f11 = (-bVar.f3674b) / i15;
                            if (f11 < f10) {
                                i13 = i14;
                                f10 = f11;
                            }
                        }
                    }
                }
                if (i13 > -1) {
                    b bVar2 = this.f3697g[i13];
                    bVar2.f3673a.f3641d = -1;
                    bVar2.x(b10);
                    SolverVariable solverVariable = bVar2.f3673a;
                    solverVariable.f3641d = i13;
                    solverVariable.j(this, bVar2);
                }
            } else {
                z11 = true;
            }
        }
        return i11;
    }

    private void C() {
        int i10 = 0;
        if (f3687v) {
            while (i10 < this.f3702l) {
                b bVar = this.f3697g[i10];
                if (bVar != null) {
                    this.f3704n.f3679a.a(bVar);
                }
                this.f3697g[i10] = null;
                i10++;
            }
            return;
        }
        while (i10 < this.f3702l) {
            b bVar2 = this.f3697g[i10];
            if (bVar2 != null) {
                this.f3704n.f3680b.a(bVar2);
            }
            this.f3697g[i10] = null;
            i10++;
        }
    }

    private SolverVariable a(SolverVariable.Type type, String str) {
        SolverVariable acquire = this.f3704n.f3681c.acquire();
        if (acquire == null) {
            acquire = new SolverVariable(type, str);
            acquire.i(type, str);
        } else {
            acquire.e();
            acquire.i(type, str);
        }
        int i10 = this.f3706p;
        int i11 = f3688w;
        if (i10 >= i11) {
            int i12 = i11 * 2;
            f3688w = i12;
            this.f3705o = (SolverVariable[]) Arrays.copyOf(this.f3705o, i12);
        }
        SolverVariable[] solverVariableArr = this.f3705o;
        int i13 = this.f3706p;
        this.f3706p = i13 + 1;
        solverVariableArr[i13] = acquire;
        return acquire;
    }

    private final void l(b bVar) {
        int i10;
        if (!f3685t || !bVar.f3678f) {
            b[] bVarArr = this.f3697g;
            int i11 = this.f3702l;
            bVarArr[i11] = bVar;
            SolverVariable solverVariable = bVar.f3673a;
            solverVariable.f3641d = i11;
            this.f3702l = i11 + 1;
            solverVariable.j(this, bVar);
        } else {
            bVar.f3673a.h(this, bVar.f3674b);
        }
        if (f3685t && this.f3691a) {
            int i12 = 0;
            while (i12 < this.f3702l) {
                if (this.f3697g[i12] == null) {
                    System.out.println("WTF");
                }
                b bVar2 = this.f3697g[i12];
                if (bVar2 != null && bVar2.f3678f) {
                    bVar2.f3673a.h(this, bVar2.f3674b);
                    if (f3687v) {
                        this.f3704n.f3679a.a(bVar2);
                    } else {
                        this.f3704n.f3680b.a(bVar2);
                    }
                    this.f3697g[i12] = null;
                    int i13 = i12 + 1;
                    int i14 = i13;
                    while (true) {
                        i10 = this.f3702l;
                        if (i13 >= i10) {
                            break;
                        }
                        b[] bVarArr2 = this.f3697g;
                        int i15 = i13 - 1;
                        b bVar3 = bVarArr2[i13];
                        bVarArr2[i15] = bVar3;
                        SolverVariable solverVariable2 = bVar3.f3673a;
                        if (solverVariable2.f3641d == i13) {
                            solverVariable2.f3641d = i15;
                        }
                        i14 = i13;
                        i13++;
                    }
                    if (i14 < i10) {
                        this.f3697g[i14] = null;
                    }
                    this.f3702l = i10 - 1;
                    i12--;
                }
                i12++;
            }
            this.f3691a = false;
        }
    }

    private void n() {
        for (int i10 = 0; i10 < this.f3702l; i10++) {
            b bVar = this.f3697g[i10];
            bVar.f3673a.f3643f = bVar.f3674b;
        }
    }

    public static b s(d dVar, SolverVariable solverVariable, SolverVariable solverVariable2, float f10) {
        return dVar.r().j(solverVariable, solverVariable2, f10);
    }

    private int u(a aVar) throws Exception {
        boolean z10;
        int i10 = 0;
        while (true) {
            if (i10 >= this.f3702l) {
                z10 = false;
                break;
            }
            b bVar = this.f3697g[i10];
            if (bVar.f3673a.f3647k != SolverVariable.Type.UNRESTRICTED && bVar.f3674b < 0.0f) {
                z10 = true;
                break;
            }
            i10++;
        }
        if (!z10) {
            return 0;
        }
        boolean z11 = false;
        int i11 = 0;
        while (!z11) {
            i11++;
            float f10 = Float.MAX_VALUE;
            int i12 = -1;
            int i13 = -1;
            int i14 = 0;
            for (int i15 = 0; i15 < this.f3702l; i15++) {
                b bVar2 = this.f3697g[i15];
                if (bVar2.f3673a.f3647k != SolverVariable.Type.UNRESTRICTED && !bVar2.f3678f && bVar2.f3674b < 0.0f) {
                    int i16 = 9;
                    if (f3686u) {
                        int e10 = bVar2.f3677e.e();
                        int i17 = 0;
                        while (i17 < e10) {
                            SolverVariable b10 = bVar2.f3677e.b(i17);
                            float i18 = bVar2.f3677e.i(b10);
                            if (i18 > 0.0f) {
                                int i19 = 0;
                                while (i19 < i16) {
                                    float f11 = b10.f3645h[i19] / i18;
                                    if ((f11 < f10 && i19 == i14) || i19 > i14) {
                                        i13 = b10.f3640c;
                                        i14 = i19;
                                        i12 = i15;
                                        f10 = f11;
                                    }
                                    i19++;
                                    i16 = 9;
                                }
                            }
                            i17++;
                            i16 = 9;
                        }
                    } else {
                        for (int i20 = 1; i20 < this.f3701k; i20++) {
                            SolverVariable solverVariable = this.f3704n.f3682d[i20];
                            float i21 = bVar2.f3677e.i(solverVariable);
                            if (i21 > 0.0f) {
                                for (int i22 = 0; i22 < 9; i22++) {
                                    float f12 = solverVariable.f3645h[i22] / i21;
                                    if ((f12 < f10 && i22 == i14) || i22 > i14) {
                                        i13 = i20;
                                        i12 = i15;
                                        i14 = i22;
                                        f10 = f12;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (i12 != -1) {
                b bVar3 = this.f3697g[i12];
                bVar3.f3673a.f3641d = -1;
                bVar3.x(this.f3704n.f3682d[i13]);
                SolverVariable solverVariable2 = bVar3.f3673a;
                solverVariable2.f3641d = i12;
                solverVariable2.j(this, bVar3);
            } else {
                z11 = true;
            }
            if (i11 > this.f3701k / 2) {
                z11 = true;
            }
        }
        return i11;
    }

    public static m0.a w() {
        return null;
    }

    private void y() {
        int i10 = this.f3695e * 2;
        this.f3695e = i10;
        this.f3697g = (b[]) Arrays.copyOf(this.f3697g, i10);
        c cVar = this.f3704n;
        cVar.f3682d = (SolverVariable[]) Arrays.copyOf(cVar.f3682d, this.f3695e);
        int i11 = this.f3695e;
        this.f3700j = new boolean[i11];
        this.f3696f = i11;
        this.f3703m = i11;
    }

    /* access modifiers changed from: package-private */
    public void A(a aVar) throws Exception {
        u(aVar);
        B(aVar, false);
        n();
    }

    public void D() {
        c cVar;
        int i10 = 0;
        while (true) {
            cVar = this.f3704n;
            SolverVariable[] solverVariableArr = cVar.f3682d;
            if (i10 >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i10];
            if (solverVariable != null) {
                solverVariable.e();
            }
            i10++;
        }
        cVar.f3681c.b(this.f3705o, this.f3706p);
        this.f3706p = 0;
        Arrays.fill(this.f3704n.f3682d, (Object) null);
        HashMap<String, SolverVariable> hashMap = this.f3693c;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f3692b = 0;
        this.f3694d.clear();
        this.f3701k = 1;
        for (int i11 = 0; i11 < this.f3702l; i11++) {
            b bVar = this.f3697g[i11];
            if (bVar != null) {
                bVar.f3675c = false;
            }
        }
        C();
        this.f3702l = 0;
        if (f3687v) {
            this.f3707q = new b(this.f3704n);
        } else {
            this.f3707q = new b(this.f3704n);
        }
    }

    public void b(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f10, int i10) {
        ConstraintWidget constraintWidget3 = constraintWidget;
        ConstraintWidget constraintWidget4 = constraintWidget2;
        ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
        SolverVariable q10 = q(constraintWidget3.o(type));
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
        SolverVariable q11 = q(constraintWidget3.o(type2));
        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.RIGHT;
        SolverVariable q12 = q(constraintWidget3.o(type3));
        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
        SolverVariable q13 = q(constraintWidget3.o(type4));
        SolverVariable q14 = q(constraintWidget4.o(type));
        SolverVariable q15 = q(constraintWidget4.o(type2));
        SolverVariable q16 = q(constraintWidget4.o(type3));
        SolverVariable q17 = q(constraintWidget4.o(type4));
        b r10 = r();
        double d10 = (double) f10;
        SolverVariable solverVariable = q16;
        double d11 = (double) i10;
        r10.q(q11, q13, q15, q17, (float) (Math.sin(d10) * d11));
        d(r10);
        b r11 = r();
        r11.q(q10, q12, q14, solverVariable, (float) (Math.cos(d10) * d11));
        d(r11);
    }

    public void c(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, float f10, SolverVariable solverVariable3, SolverVariable solverVariable4, int i11, int i12) {
        int i13 = i12;
        b r10 = r();
        r10.h(solverVariable, solverVariable2, i10, f10, solverVariable3, solverVariable4, i11);
        if (i13 != 8) {
            r10.d(this, i13);
        }
        d(r10);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0082 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0083  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(androidx.constraintlayout.core.b r6) {
        /*
            r5 = this;
            if (r6 != 0) goto L_0x0003
            return
        L_0x0003:
            int r0 = r5.f3702l
            r1 = 1
            int r0 = r0 + r1
            int r2 = r5.f3703m
            if (r0 >= r2) goto L_0x0012
            int r0 = r5.f3701k
            int r0 = r0 + r1
            int r2 = r5.f3696f
            if (r0 < r2) goto L_0x0015
        L_0x0012:
            r5.y()
        L_0x0015:
            r0 = 0
            boolean r2 = r6.f3678f
            if (r2 != 0) goto L_0x0084
            r6.D(r5)
            boolean r2 = r6.isEmpty()
            if (r2 == 0) goto L_0x0024
            return
        L_0x0024:
            r6.r()
            boolean r2 = r6.f(r5)
            if (r2 == 0) goto L_0x007b
            androidx.constraintlayout.core.SolverVariable r2 = r5.p()
            r6.f3673a = r2
            int r3 = r5.f3702l
            r5.l(r6)
            int r4 = r5.f3702l
            int r3 = r3 + r1
            if (r4 != r3) goto L_0x007b
            androidx.constraintlayout.core.d$a r0 = r5.f3707q
            r0.a(r6)
            androidx.constraintlayout.core.d$a r0 = r5.f3707q
            r5.B(r0, r1)
            int r0 = r2.f3641d
            r3 = -1
            if (r0 != r3) goto L_0x007c
            androidx.constraintlayout.core.SolverVariable r0 = r6.f3673a
            if (r0 != r2) goto L_0x0059
            androidx.constraintlayout.core.SolverVariable r0 = r6.v(r2)
            if (r0 == 0) goto L_0x0059
            r6.x(r0)
        L_0x0059:
            boolean r0 = r6.f3678f
            if (r0 != 0) goto L_0x0062
            androidx.constraintlayout.core.SolverVariable r0 = r6.f3673a
            r0.j(r5, r6)
        L_0x0062:
            boolean r0 = f3687v
            if (r0 == 0) goto L_0x006e
            androidx.constraintlayout.core.c r0 = r5.f3704n
            androidx.constraintlayout.core.e<androidx.constraintlayout.core.b> r0 = r0.f3679a
            r0.a(r6)
            goto L_0x0075
        L_0x006e:
            androidx.constraintlayout.core.c r0 = r5.f3704n
            androidx.constraintlayout.core.e<androidx.constraintlayout.core.b> r0 = r0.f3680b
            r0.a(r6)
        L_0x0075:
            int r0 = r5.f3702l
            int r0 = r0 - r1
            r5.f3702l = r0
            goto L_0x007c
        L_0x007b:
            r1 = r0
        L_0x007c:
            boolean r0 = r6.s()
            if (r0 != 0) goto L_0x0083
            return
        L_0x0083:
            r0 = r1
        L_0x0084:
            if (r0 != 0) goto L_0x0089
            r5.l(r6)
        L_0x0089:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.d.d(androidx.constraintlayout.core.b):void");
    }

    public b e(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, int i11) {
        if (!f3684s || i11 != 8 || !solverVariable2.f3644g || solverVariable.f3641d != -1) {
            b r10 = r();
            r10.n(solverVariable, solverVariable2, i10);
            if (i11 != 8) {
                r10.d(this, i11);
            }
            d(r10);
            return r10;
        }
        solverVariable.h(this, solverVariable2.f3643f + ((float) i10));
        return null;
    }

    public void f(SolverVariable solverVariable, int i10) {
        if (!f3684s || solverVariable.f3641d != -1) {
            int i11 = solverVariable.f3641d;
            if (i11 != -1) {
                b bVar = this.f3697g[i11];
                if (bVar.f3678f) {
                    bVar.f3674b = (float) i10;
                } else if (bVar.f3677e.e() == 0) {
                    bVar.f3678f = true;
                    bVar.f3674b = (float) i10;
                } else {
                    b r10 = r();
                    r10.m(solverVariable, i10);
                    d(r10);
                }
            } else {
                b r11 = r();
                r11.i(solverVariable, i10);
                d(r11);
            }
        } else {
            float f10 = (float) i10;
            solverVariable.h(this, f10);
            for (int i12 = 0; i12 < this.f3692b + 1; i12++) {
                SolverVariable solverVariable2 = this.f3704n.f3682d[i12];
                if (solverVariable2 != null && solverVariable2.f3651p && solverVariable2.f3652q == solverVariable.f3640c) {
                    solverVariable2.h(this, solverVariable2.f3653t + f10);
                }
            }
        }
    }

    public void g(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, boolean z10) {
        b r10 = r();
        SolverVariable t10 = t();
        t10.f3642e = 0;
        r10.o(solverVariable, solverVariable2, t10, i10);
        d(r10);
    }

    public void h(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, int i11) {
        b r10 = r();
        SolverVariable t10 = t();
        t10.f3642e = 0;
        r10.o(solverVariable, solverVariable2, t10, i10);
        if (i11 != 8) {
            m(r10, (int) (r10.f3677e.i(t10) * -1.0f), i11);
        }
        d(r10);
    }

    public void i(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, boolean z10) {
        b r10 = r();
        SolverVariable t10 = t();
        t10.f3642e = 0;
        r10.p(solverVariable, solverVariable2, t10, i10);
        d(r10);
    }

    public void j(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, int i11) {
        b r10 = r();
        SolverVariable t10 = t();
        t10.f3642e = 0;
        r10.p(solverVariable, solverVariable2, t10, i10);
        if (i11 != 8) {
            m(r10, (int) (r10.f3677e.i(t10) * -1.0f), i11);
        }
        d(r10);
    }

    public void k(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f10, int i10) {
        b r10 = r();
        r10.k(solverVariable, solverVariable2, solverVariable3, solverVariable4, f10);
        if (i10 != 8) {
            r10.d(this, i10);
        }
        d(r10);
    }

    /* access modifiers changed from: package-private */
    public void m(b bVar, int i10, int i11) {
        bVar.e(o(i11, (String) null), i10);
    }

    public SolverVariable o(int i10, String str) {
        if (this.f3701k + 1 >= this.f3696f) {
            y();
        }
        SolverVariable a10 = a(SolverVariable.Type.ERROR, str);
        int i11 = this.f3692b + 1;
        this.f3692b = i11;
        this.f3701k++;
        a10.f3640c = i11;
        a10.f3642e = i10;
        this.f3704n.f3682d[i11] = a10;
        this.f3694d.c(a10);
        return a10;
    }

    public SolverVariable p() {
        if (this.f3701k + 1 >= this.f3696f) {
            y();
        }
        SolverVariable a10 = a(SolverVariable.Type.SLACK, (String) null);
        int i10 = this.f3692b + 1;
        this.f3692b = i10;
        this.f3701k++;
        a10.f3640c = i10;
        this.f3704n.f3682d[i10] = a10;
        return a10;
    }

    public SolverVariable q(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.f3701k + 1 >= this.f3696f) {
            y();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.i();
            if (solverVariable == null) {
                constraintAnchor.s(this.f3704n);
                solverVariable = constraintAnchor.i();
            }
            int i10 = solverVariable.f3640c;
            if (i10 == -1 || i10 > this.f3692b || this.f3704n.f3682d[i10] == null) {
                if (i10 != -1) {
                    solverVariable.e();
                }
                int i11 = this.f3692b + 1;
                this.f3692b = i11;
                this.f3701k++;
                solverVariable.f3640c = i11;
                solverVariable.f3647k = SolverVariable.Type.UNRESTRICTED;
                this.f3704n.f3682d[i11] = solverVariable;
            }
        }
        return solverVariable;
    }

    public b r() {
        b bVar;
        if (f3687v) {
            bVar = this.f3704n.f3679a.acquire();
            if (bVar == null) {
                bVar = new b(this.f3704n);
                f3690y++;
            } else {
                bVar.y();
            }
        } else {
            bVar = this.f3704n.f3680b.acquire();
            if (bVar == null) {
                bVar = new b(this.f3704n);
                f3689x++;
            } else {
                bVar.y();
            }
        }
        SolverVariable.c();
        return bVar;
    }

    public SolverVariable t() {
        if (this.f3701k + 1 >= this.f3696f) {
            y();
        }
        SolverVariable a10 = a(SolverVariable.Type.SLACK, (String) null);
        int i10 = this.f3692b + 1;
        this.f3692b = i10;
        this.f3701k++;
        a10.f3640c = i10;
        this.f3704n.f3682d[i10] = a10;
        return a10;
    }

    public c v() {
        return this.f3704n;
    }

    public int x(Object obj) {
        SolverVariable i10 = ((ConstraintAnchor) obj).i();
        if (i10 != null) {
            return (int) (i10.f3643f + 0.5f);
        }
        return 0;
    }

    public void z() throws Exception {
        if (this.f3694d.isEmpty()) {
            n();
        } else if (this.f3698h || this.f3699i) {
            boolean z10 = false;
            int i10 = 0;
            while (true) {
                if (i10 >= this.f3702l) {
                    z10 = true;
                    break;
                } else if (!this.f3697g[i10].f3678f) {
                    break;
                } else {
                    i10++;
                }
            }
            if (!z10) {
                A(this.f3694d);
            } else {
                n();
            }
        } else {
            A(this.f3694d);
        }
    }
}
