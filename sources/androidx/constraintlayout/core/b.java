package androidx.constraintlayout.core;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.d;
import java.util.ArrayList;

public class b implements d.a {

    /* renamed from: a  reason: collision with root package name */
    SolverVariable f3673a = null;

    /* renamed from: b  reason: collision with root package name */
    float f3674b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    boolean f3675c = false;

    /* renamed from: d  reason: collision with root package name */
    ArrayList<SolverVariable> f3676d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public a f3677e;

    /* renamed from: f  reason: collision with root package name */
    boolean f3678f = false;

    public interface a {
        boolean a(SolverVariable solverVariable);

        SolverVariable b(int i10);

        void c(SolverVariable solverVariable, float f10, boolean z10);

        void clear();

        float d(SolverVariable solverVariable, boolean z10);

        int e();

        float f(b bVar, boolean z10);

        void g(SolverVariable solverVariable, float f10);

        float h(int i10);

        float i(SolverVariable solverVariable);

        void invert();

        void j(float f10);
    }

    public b() {
    }

    private boolean u(SolverVariable solverVariable, d dVar) {
        return solverVariable.f3650n <= 1;
    }

    private SolverVariable w(boolean[] zArr, SolverVariable solverVariable) {
        SolverVariable.Type type;
        int e10 = this.f3677e.e();
        SolverVariable solverVariable2 = null;
        float f10 = 0.0f;
        for (int i10 = 0; i10 < e10; i10++) {
            float h10 = this.f3677e.h(i10);
            if (h10 < 0.0f) {
                SolverVariable b10 = this.f3677e.b(i10);
                if ((zArr == null || !zArr[b10.f3640c]) && b10 != solverVariable && (((type = b10.f3647k) == SolverVariable.Type.SLACK || type == SolverVariable.Type.ERROR) && h10 < f10)) {
                    f10 = h10;
                    solverVariable2 = b10;
                }
            }
        }
        return solverVariable2;
    }

    public void A(d dVar, SolverVariable solverVariable, boolean z10) {
        if (solverVariable != null && solverVariable.f3644g) {
            this.f3674b += solverVariable.f3643f * this.f3677e.i(solverVariable);
            this.f3677e.d(solverVariable, z10);
            if (z10) {
                solverVariable.d(this);
            }
            if (d.f3685t && this.f3677e.e() == 0) {
                this.f3678f = true;
                dVar.f3691a = true;
            }
        }
    }

    public void B(d dVar, b bVar, boolean z10) {
        this.f3674b += bVar.f3674b * this.f3677e.f(bVar, z10);
        if (z10) {
            bVar.f3673a.d(this);
        }
        if (d.f3685t && this.f3673a != null && this.f3677e.e() == 0) {
            this.f3678f = true;
            dVar.f3691a = true;
        }
    }

    public void C(d dVar, SolverVariable solverVariable, boolean z10) {
        if (solverVariable != null && solverVariable.f3651p) {
            float i10 = this.f3677e.i(solverVariable);
            this.f3674b += solverVariable.f3653t * i10;
            this.f3677e.d(solverVariable, z10);
            if (z10) {
                solverVariable.d(this);
            }
            this.f3677e.c(dVar.f3704n.f3682d[solverVariable.f3652q], i10, z10);
            if (d.f3685t && this.f3677e.e() == 0) {
                this.f3678f = true;
                dVar.f3691a = true;
            }
        }
    }

    public void D(d dVar) {
        if (dVar.f3697g.length != 0) {
            boolean z10 = false;
            while (!z10) {
                int e10 = this.f3677e.e();
                for (int i10 = 0; i10 < e10; i10++) {
                    SolverVariable b10 = this.f3677e.b(i10);
                    if (b10.f3641d != -1 || b10.f3644g || b10.f3651p) {
                        this.f3676d.add(b10);
                    }
                }
                int size = this.f3676d.size();
                if (size > 0) {
                    for (int i11 = 0; i11 < size; i11++) {
                        SolverVariable solverVariable = this.f3676d.get(i11);
                        if (solverVariable.f3644g) {
                            A(dVar, solverVariable, true);
                        } else if (solverVariable.f3651p) {
                            C(dVar, solverVariable, true);
                        } else {
                            B(dVar, dVar.f3697g[solverVariable.f3641d], true);
                        }
                    }
                    this.f3676d.clear();
                } else {
                    z10 = true;
                }
            }
            if (d.f3685t && this.f3673a != null && this.f3677e.e() == 0) {
                this.f3678f = true;
                dVar.f3691a = true;
            }
        }
    }

    public void a(d.a aVar) {
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            this.f3673a = null;
            this.f3677e.clear();
            for (int i10 = 0; i10 < bVar.f3677e.e(); i10++) {
                this.f3677e.c(bVar.f3677e.b(i10), bVar.f3677e.h(i10), true);
            }
        }
    }

    public SolverVariable b(d dVar, boolean[] zArr) {
        return w(zArr, (SolverVariable) null);
    }

    public void c(SolverVariable solverVariable) {
        int i10 = solverVariable.f3642e;
        float f10 = 1.0f;
        if (i10 != 1) {
            if (i10 == 2) {
                f10 = 1000.0f;
            } else if (i10 == 3) {
                f10 = 1000000.0f;
            } else if (i10 == 4) {
                f10 = 1.0E9f;
            } else if (i10 == 5) {
                f10 = 1.0E12f;
            }
        }
        this.f3677e.g(solverVariable, f10);
    }

    public void clear() {
        this.f3677e.clear();
        this.f3673a = null;
        this.f3674b = 0.0f;
    }

    public b d(d dVar, int i10) {
        this.f3677e.g(dVar.o(i10, "ep"), 1.0f);
        this.f3677e.g(dVar.o(i10, "em"), -1.0f);
        return this;
    }

    /* access modifiers changed from: package-private */
    public b e(SolverVariable solverVariable, int i10) {
        this.f3677e.g(solverVariable, (float) i10);
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean f(d dVar) {
        boolean z10;
        SolverVariable g10 = g(dVar);
        if (g10 == null) {
            z10 = true;
        } else {
            x(g10);
            z10 = false;
        }
        if (this.f3677e.e() == 0) {
            this.f3678f = true;
        }
        return z10;
    }

    /* access modifiers changed from: package-private */
    public SolverVariable g(d dVar) {
        boolean u10;
        boolean u11;
        int e10 = this.f3677e.e();
        SolverVariable solverVariable = null;
        boolean z10 = false;
        boolean z11 = false;
        float f10 = 0.0f;
        float f11 = 0.0f;
        SolverVariable solverVariable2 = null;
        for (int i10 = 0; i10 < e10; i10++) {
            float h10 = this.f3677e.h(i10);
            SolverVariable b10 = this.f3677e.b(i10);
            if (b10.f3647k == SolverVariable.Type.UNRESTRICTED) {
                if (solverVariable == null) {
                    u11 = u(b10, dVar);
                } else if (f10 > h10) {
                    u11 = u(b10, dVar);
                } else if (!z10 && u(b10, dVar)) {
                    f10 = h10;
                    solverVariable = b10;
                    z10 = true;
                }
                z10 = u11;
                f10 = h10;
                solverVariable = b10;
            } else if (solverVariable == null && h10 < 0.0f) {
                if (solverVariable2 == null) {
                    u10 = u(b10, dVar);
                } else if (f11 > h10) {
                    u10 = u(b10, dVar);
                } else if (!z11 && u(b10, dVar)) {
                    f11 = h10;
                    solverVariable2 = b10;
                    z11 = true;
                }
                z11 = u10;
                f11 = h10;
                solverVariable2 = b10;
            }
        }
        if (solverVariable != null) {
            return solverVariable;
        }
        return solverVariable2;
    }

    public SolverVariable getKey() {
        return this.f3673a;
    }

    /* access modifiers changed from: package-private */
    public b h(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, float f10, SolverVariable solverVariable3, SolverVariable solverVariable4, int i11) {
        if (solverVariable2 == solverVariable3) {
            this.f3677e.g(solverVariable, 1.0f);
            this.f3677e.g(solverVariable4, 1.0f);
            this.f3677e.g(solverVariable2, -2.0f);
            return this;
        }
        if (f10 == 0.5f) {
            this.f3677e.g(solverVariable, 1.0f);
            this.f3677e.g(solverVariable2, -1.0f);
            this.f3677e.g(solverVariable3, -1.0f);
            this.f3677e.g(solverVariable4, 1.0f);
            if (i10 > 0 || i11 > 0) {
                this.f3674b = (float) ((-i10) + i11);
            }
        } else if (f10 <= 0.0f) {
            this.f3677e.g(solverVariable, -1.0f);
            this.f3677e.g(solverVariable2, 1.0f);
            this.f3674b = (float) i10;
        } else if (f10 >= 1.0f) {
            this.f3677e.g(solverVariable4, -1.0f);
            this.f3677e.g(solverVariable3, 1.0f);
            this.f3674b = (float) (-i11);
        } else {
            float f11 = 1.0f - f10;
            this.f3677e.g(solverVariable, f11 * 1.0f);
            this.f3677e.g(solverVariable2, f11 * -1.0f);
            this.f3677e.g(solverVariable3, -1.0f * f10);
            this.f3677e.g(solverVariable4, 1.0f * f10);
            if (i10 > 0 || i11 > 0) {
                this.f3674b = (((float) (-i10)) * f11) + (((float) i11) * f10);
            }
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public b i(SolverVariable solverVariable, int i10) {
        this.f3673a = solverVariable;
        float f10 = (float) i10;
        solverVariable.f3643f = f10;
        this.f3674b = f10;
        this.f3678f = true;
        return this;
    }

    public boolean isEmpty() {
        return this.f3673a == null && this.f3674b == 0.0f && this.f3677e.e() == 0;
    }

    /* access modifiers changed from: package-private */
    public b j(SolverVariable solverVariable, SolverVariable solverVariable2, float f10) {
        this.f3677e.g(solverVariable, -1.0f);
        this.f3677e.g(solverVariable2, f10);
        return this;
    }

    public b k(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f10) {
        this.f3677e.g(solverVariable, -1.0f);
        this.f3677e.g(solverVariable2, 1.0f);
        this.f3677e.g(solverVariable3, f10);
        this.f3677e.g(solverVariable4, -f10);
        return this;
    }

    public b l(float f10, float f11, float f12, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
        this.f3674b = 0.0f;
        if (f11 == 0.0f || f10 == f12) {
            this.f3677e.g(solverVariable, 1.0f);
            this.f3677e.g(solverVariable2, -1.0f);
            this.f3677e.g(solverVariable4, 1.0f);
            this.f3677e.g(solverVariable3, -1.0f);
        } else if (f10 == 0.0f) {
            this.f3677e.g(solverVariable, 1.0f);
            this.f3677e.g(solverVariable2, -1.0f);
        } else if (f12 == 0.0f) {
            this.f3677e.g(solverVariable3, 1.0f);
            this.f3677e.g(solverVariable4, -1.0f);
        } else {
            float f13 = (f10 / f11) / (f12 / f11);
            this.f3677e.g(solverVariable, 1.0f);
            this.f3677e.g(solverVariable2, -1.0f);
            this.f3677e.g(solverVariable4, f13);
            this.f3677e.g(solverVariable3, -f13);
        }
        return this;
    }

    public b m(SolverVariable solverVariable, int i10) {
        if (i10 < 0) {
            this.f3674b = (float) (i10 * -1);
            this.f3677e.g(solverVariable, 1.0f);
        } else {
            this.f3674b = (float) i10;
            this.f3677e.g(solverVariable, -1.0f);
        }
        return this;
    }

    public b n(SolverVariable solverVariable, SolverVariable solverVariable2, int i10) {
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            this.f3674b = (float) i10;
        }
        if (!z10) {
            this.f3677e.g(solverVariable, -1.0f);
            this.f3677e.g(solverVariable2, 1.0f);
        } else {
            this.f3677e.g(solverVariable, 1.0f);
            this.f3677e.g(solverVariable2, -1.0f);
        }
        return this;
    }

    public b o(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i10) {
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            this.f3674b = (float) i10;
        }
        if (!z10) {
            this.f3677e.g(solverVariable, -1.0f);
            this.f3677e.g(solverVariable2, 1.0f);
            this.f3677e.g(solverVariable3, 1.0f);
        } else {
            this.f3677e.g(solverVariable, 1.0f);
            this.f3677e.g(solverVariable2, -1.0f);
            this.f3677e.g(solverVariable3, -1.0f);
        }
        return this;
    }

    public b p(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i10) {
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            this.f3674b = (float) i10;
        }
        if (!z10) {
            this.f3677e.g(solverVariable, -1.0f);
            this.f3677e.g(solverVariable2, 1.0f);
            this.f3677e.g(solverVariable3, -1.0f);
        } else {
            this.f3677e.g(solverVariable, 1.0f);
            this.f3677e.g(solverVariable2, -1.0f);
            this.f3677e.g(solverVariable3, 1.0f);
        }
        return this;
    }

    public b q(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f10) {
        this.f3677e.g(solverVariable3, 0.5f);
        this.f3677e.g(solverVariable4, 0.5f);
        this.f3677e.g(solverVariable, -0.5f);
        this.f3677e.g(solverVariable2, -0.5f);
        this.f3674b = -f10;
        return this;
    }

    /* access modifiers changed from: package-private */
    public void r() {
        float f10 = this.f3674b;
        if (f10 < 0.0f) {
            this.f3674b = f10 * -1.0f;
            this.f3677e.invert();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean s() {
        SolverVariable solverVariable = this.f3673a;
        return solverVariable != null && (solverVariable.f3647k == SolverVariable.Type.UNRESTRICTED || this.f3674b >= 0.0f);
    }

    /* access modifiers changed from: package-private */
    public boolean t(SolverVariable solverVariable) {
        return this.f3677e.a(solverVariable);
    }

    public String toString() {
        return z();
    }

    public SolverVariable v(SolverVariable solverVariable) {
        return w((boolean[]) null, solverVariable);
    }

    /* access modifiers changed from: package-private */
    public void x(SolverVariable solverVariable) {
        SolverVariable solverVariable2 = this.f3673a;
        if (solverVariable2 != null) {
            this.f3677e.g(solverVariable2, -1.0f);
            this.f3673a.f3641d = -1;
            this.f3673a = null;
        }
        float d10 = this.f3677e.d(solverVariable, true) * -1.0f;
        this.f3673a = solverVariable;
        if (d10 != 1.0f) {
            this.f3674b /= d10;
            this.f3677e.j(d10);
        }
    }

    public void y() {
        this.f3673a = null;
        this.f3677e.clear();
        this.f3674b = 0.0f;
        this.f3678f = false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String z() {
        /*
            r10 = this;
            androidx.constraintlayout.core.SolverVariable r0 = r10.f3673a
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0018
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            java.lang.String r1 = "0"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            goto L_0x0029
        L_0x0018:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            androidx.constraintlayout.core.SolverVariable r1 = r10.f3673a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L_0x0029:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " = "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            float r1 = r10.f3674b
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0056
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            float r0 = r10.f3674b
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = r4
            goto L_0x0057
        L_0x0056:
            r1 = r3
        L_0x0057:
            androidx.constraintlayout.core.b$a r5 = r10.f3677e
            int r5 = r5.e()
        L_0x005d:
            if (r3 >= r5) goto L_0x00eb
            androidx.constraintlayout.core.b$a r6 = r10.f3677e
            androidx.constraintlayout.core.SolverVariable r6 = r6.b(r3)
            if (r6 != 0) goto L_0x0069
            goto L_0x00e7
        L_0x0069:
            androidx.constraintlayout.core.b$a r7 = r10.f3677e
            float r7 = r7.h(r3)
            int r8 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r8 != 0) goto L_0x0075
            goto L_0x00e7
        L_0x0075:
            java.lang.String r6 = r6.toString()
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L_0x0093
            int r1 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x00b9
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "- "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L_0x00b8
        L_0x0093:
            if (r8 <= 0) goto L_0x00a7
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " + "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L_0x00b9
        L_0x00a7:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " - "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x00b8:
            float r7 = r7 * r9
        L_0x00b9:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x00cf
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
            goto L_0x00e6
        L_0x00cf:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
        L_0x00e6:
            r1 = r4
        L_0x00e7:
            int r3 = r3 + 1
            goto L_0x005d
        L_0x00eb:
            if (r1 != 0) goto L_0x00fe
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "0.0"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x00fe:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.b.z():java.lang.String");
    }

    public b(c cVar) {
        this.f3677e = new a(this, cVar);
    }
}
