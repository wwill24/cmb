package androidx.constraintlayout.core;

import androidx.constraintlayout.core.b;
import java.util.Arrays;
import java.util.Comparator;

public class g extends b {

    /* renamed from: g  reason: collision with root package name */
    private int f3711g = 128;

    /* renamed from: h  reason: collision with root package name */
    private SolverVariable[] f3712h = new SolverVariable[128];

    /* renamed from: i  reason: collision with root package name */
    private SolverVariable[] f3713i = new SolverVariable[128];

    /* renamed from: j  reason: collision with root package name */
    private int f3714j = 0;

    /* renamed from: k  reason: collision with root package name */
    b f3715k = new b(this);

    /* renamed from: l  reason: collision with root package name */
    c f3716l;

    class a implements Comparator<SolverVariable> {
        a() {
        }

        /* renamed from: a */
        public int compare(SolverVariable solverVariable, SolverVariable solverVariable2) {
            return solverVariable.f3640c - solverVariable2.f3640c;
        }
    }

    class b {

        /* renamed from: a  reason: collision with root package name */
        SolverVariable f3718a;

        /* renamed from: b  reason: collision with root package name */
        g f3719b;

        public b(g gVar) {
            this.f3719b = gVar;
        }

        public boolean a(SolverVariable solverVariable, float f10) {
            boolean z10 = true;
            if (this.f3718a.f3638a) {
                for (int i10 = 0; i10 < 9; i10++) {
                    float[] fArr = this.f3718a.f3646j;
                    float f11 = fArr[i10] + (solverVariable.f3646j[i10] * f10);
                    fArr[i10] = f11;
                    if (Math.abs(f11) < 1.0E-4f) {
                        this.f3718a.f3646j[i10] = 0.0f;
                    } else {
                        z10 = false;
                    }
                }
                if (z10) {
                    g.this.G(this.f3718a);
                }
                return false;
            }
            for (int i11 = 0; i11 < 9; i11++) {
                float f12 = solverVariable.f3646j[i11];
                if (f12 != 0.0f) {
                    float f13 = f12 * f10;
                    if (Math.abs(f13) < 1.0E-4f) {
                        f13 = 0.0f;
                    }
                    this.f3718a.f3646j[i11] = f13;
                } else {
                    this.f3718a.f3646j[i11] = 0.0f;
                }
            }
            return true;
        }

        public void b(SolverVariable solverVariable) {
            this.f3718a = solverVariable;
        }

        public final boolean c() {
            for (int i10 = 8; i10 >= 0; i10--) {
                float f10 = this.f3718a.f3646j[i10];
                if (f10 > 0.0f) {
                    return false;
                }
                if (f10 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean d(SolverVariable solverVariable) {
            int i10 = 8;
            while (true) {
                if (i10 < 0) {
                    break;
                }
                float f10 = solverVariable.f3646j[i10];
                float f11 = this.f3718a.f3646j[i10];
                if (f11 == f10) {
                    i10--;
                } else if (f11 < f10) {
                    return true;
                }
            }
            return false;
        }

        public void e() {
            Arrays.fill(this.f3718a.f3646j, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.f3718a != null) {
                for (int i10 = 0; i10 < 9; i10++) {
                    str = str + this.f3718a.f3646j[i10] + " ";
                }
            }
            return str + "] " + this.f3718a;
        }
    }

    public g(c cVar) {
        super(cVar);
        this.f3716l = cVar;
    }

    private final void F(SolverVariable solverVariable) {
        int i10;
        int i11 = this.f3714j + 1;
        SolverVariable[] solverVariableArr = this.f3712h;
        if (i11 > solverVariableArr.length) {
            SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            this.f3712h = solverVariableArr2;
            this.f3713i = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.f3712h;
        int i12 = this.f3714j;
        solverVariableArr3[i12] = solverVariable;
        int i13 = i12 + 1;
        this.f3714j = i13;
        if (i13 > 1 && solverVariableArr3[i13 - 1].f3640c > solverVariable.f3640c) {
            int i14 = 0;
            while (true) {
                i10 = this.f3714j;
                if (i14 >= i10) {
                    break;
                }
                this.f3713i[i14] = this.f3712h[i14];
                i14++;
            }
            Arrays.sort(this.f3713i, 0, i10, new a());
            for (int i15 = 0; i15 < this.f3714j; i15++) {
                this.f3712h[i15] = this.f3713i[i15];
            }
        }
        solverVariable.f3638a = true;
        solverVariable.a(this);
    }

    /* access modifiers changed from: private */
    public final void G(SolverVariable solverVariable) {
        int i10 = 0;
        while (i10 < this.f3714j) {
            if (this.f3712h[i10] == solverVariable) {
                while (true) {
                    int i11 = this.f3714j;
                    if (i10 < i11 - 1) {
                        SolverVariable[] solverVariableArr = this.f3712h;
                        int i12 = i10 + 1;
                        solverVariableArr[i10] = solverVariableArr[i12];
                        i10 = i12;
                    } else {
                        this.f3714j = i11 - 1;
                        solverVariable.f3638a = false;
                        return;
                    }
                }
            } else {
                i10++;
            }
        }
    }

    public void B(d dVar, b bVar, boolean z10) {
        SolverVariable solverVariable = bVar.f3673a;
        if (solverVariable != null) {
            b.a aVar = bVar.f3677e;
            int e10 = aVar.e();
            for (int i10 = 0; i10 < e10; i10++) {
                SolverVariable b10 = aVar.b(i10);
                float h10 = aVar.h(i10);
                this.f3715k.b(b10);
                if (this.f3715k.a(solverVariable, h10)) {
                    F(b10);
                }
                this.f3674b += bVar.f3674b * h10;
            }
            G(solverVariable);
        }
    }

    public SolverVariable b(d dVar, boolean[] zArr) {
        int i10 = -1;
        for (int i11 = 0; i11 < this.f3714j; i11++) {
            SolverVariable solverVariable = this.f3712h[i11];
            if (!zArr[solverVariable.f3640c]) {
                this.f3715k.b(solverVariable);
                if (i10 == -1) {
                    if (!this.f3715k.c()) {
                    }
                } else if (!this.f3715k.d(this.f3712h[i10])) {
                }
                i10 = i11;
            }
        }
        if (i10 == -1) {
            return null;
        }
        return this.f3712h[i10];
    }

    public void c(SolverVariable solverVariable) {
        this.f3715k.b(solverVariable);
        this.f3715k.e();
        solverVariable.f3646j[solverVariable.f3642e] = 1.0f;
        F(solverVariable);
    }

    public void clear() {
        this.f3714j = 0;
        this.f3674b = 0.0f;
    }

    public boolean isEmpty() {
        return this.f3714j == 0;
    }

    public String toString() {
        String str = "" + " goal -> (" + this.f3674b + ") : ";
        for (int i10 = 0; i10 < this.f3714j; i10++) {
            this.f3715k.b(this.f3712h[i10]);
            str = str + this.f3715k + " ";
        }
        return str;
    }
}
