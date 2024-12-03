package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.d;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import p0.b;

public class a extends b {
    private int N0 = 0;
    private boolean O0 = true;
    private int P0 = 0;
    boolean Q0 = false;

    public void A1(int i10) {
        this.N0 = i10;
    }

    public void B1(int i10) {
        this.P0 = i10;
    }

    public void g(d dVar, boolean z10) {
        ConstraintAnchor[] constraintAnchorArr;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        int i10;
        int i11;
        int i12;
        int i13;
        ConstraintAnchor[] constraintAnchorArr2 = this.W;
        constraintAnchorArr2[0] = this.O;
        constraintAnchorArr2[2] = this.P;
        constraintAnchorArr2[1] = this.Q;
        constraintAnchorArr2[3] = this.R;
        int i14 = 0;
        while (true) {
            constraintAnchorArr = this.W;
            if (i14 >= constraintAnchorArr.length) {
                break;
            }
            ConstraintAnchor constraintAnchor = constraintAnchorArr[i14];
            constraintAnchor.f3743i = dVar.q(constraintAnchor);
            i14++;
        }
        int i15 = this.N0;
        if (i15 >= 0 && i15 < 4) {
            ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i15];
            if (!this.Q0) {
                t1();
            }
            if (this.Q0) {
                this.Q0 = false;
                int i16 = this.N0;
                if (i16 == 0 || i16 == 1) {
                    dVar.f(this.O.f3743i, this.f3766f0);
                    dVar.f(this.Q.f3743i, this.f3766f0);
                } else if (i16 == 2 || i16 == 3) {
                    dVar.f(this.P.f3743i, this.f3768g0);
                    dVar.f(this.R.f3743i, this.f3768g0);
                }
            } else {
                int i17 = 0;
                while (true) {
                    if (i17 >= this.M0) {
                        z11 = false;
                        break;
                    }
                    ConstraintWidget constraintWidget = this.L0[i17];
                    if ((this.O0 || constraintWidget.h()) && ((((i12 = this.N0) == 0 || i12 == 1) && constraintWidget.A() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.O.f3740f != null && constraintWidget.Q.f3740f != null) || (((i13 = this.N0) == 2 || i13 == 3) && constraintWidget.T() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.P.f3740f != null && constraintWidget.R.f3740f != null))) {
                        z11 = true;
                    } else {
                        i17++;
                    }
                }
                z11 = true;
                if (this.O.l() || this.Q.l()) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (this.P.l() || this.R.l()) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (z11 || (((i11 = this.N0) != 0 || !z12) && ((i11 != 2 || !z13) && ((i11 != 1 || !z12) && (i11 != 3 || !z13))))) {
                    z14 = false;
                } else {
                    z14 = true;
                }
                int i18 = 5;
                if (!z14) {
                    i18 = 4;
                }
                for (int i19 = 0; i19 < this.M0; i19++) {
                    ConstraintWidget constraintWidget2 = this.L0[i19];
                    if (this.O0 || constraintWidget2.h()) {
                        SolverVariable q10 = dVar.q(constraintWidget2.W[this.N0]);
                        ConstraintAnchor[] constraintAnchorArr3 = constraintWidget2.W;
                        int i20 = this.N0;
                        ConstraintAnchor constraintAnchor3 = constraintAnchorArr3[i20];
                        constraintAnchor3.f3743i = q10;
                        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f3740f;
                        if (constraintAnchor4 == null || constraintAnchor4.f3738d != this) {
                            i10 = 0;
                        } else {
                            i10 = constraintAnchor3.f3741g + 0;
                        }
                        if (i20 == 0 || i20 == 2) {
                            dVar.i(constraintAnchor2.f3743i, q10, this.P0 - i10, z11);
                        } else {
                            dVar.g(constraintAnchor2.f3743i, q10, this.P0 + i10, z11);
                        }
                        dVar.e(constraintAnchor2.f3743i, q10, this.P0 + i10, i18);
                    }
                }
                int i21 = this.N0;
                if (i21 == 0) {
                    dVar.e(this.Q.f3743i, this.O.f3743i, 0, 8);
                    dVar.e(this.O.f3743i, this.f3756a0.Q.f3743i, 0, 4);
                    dVar.e(this.O.f3743i, this.f3756a0.O.f3743i, 0, 0);
                } else if (i21 == 1) {
                    dVar.e(this.O.f3743i, this.Q.f3743i, 0, 8);
                    dVar.e(this.O.f3743i, this.f3756a0.O.f3743i, 0, 4);
                    dVar.e(this.O.f3743i, this.f3756a0.Q.f3743i, 0, 0);
                } else if (i21 == 2) {
                    dVar.e(this.R.f3743i, this.P.f3743i, 0, 8);
                    dVar.e(this.P.f3743i, this.f3756a0.R.f3743i, 0, 4);
                    dVar.e(this.P.f3743i, this.f3756a0.P.f3743i, 0, 0);
                } else if (i21 == 3) {
                    dVar.e(this.P.f3743i, this.R.f3743i, 0, 8);
                    dVar.e(this.P.f3743i, this.f3756a0.P.f3743i, 0, 4);
                    dVar.e(this.P.f3743i, this.f3756a0.R.f3743i, 0, 0);
                }
            }
        }
    }

    public boolean h() {
        return true;
    }

    public boolean n0() {
        return this.Q0;
    }

    public boolean o0() {
        return this.Q0;
    }

    public boolean t1() {
        int i10;
        int i11;
        int i12;
        int i13 = 0;
        boolean z10 = true;
        while (true) {
            i10 = this.M0;
            if (i13 >= i10) {
                break;
            }
            ConstraintWidget constraintWidget = this.L0[i13];
            if ((this.O0 || constraintWidget.h()) && ((((i11 = this.N0) == 0 || i11 == 1) && !constraintWidget.n0()) || (((i12 = this.N0) == 2 || i12 == 3) && !constraintWidget.o0()))) {
                z10 = false;
            }
            i13++;
        }
        if (!z10 || i10 <= 0) {
            return false;
        }
        int i14 = 0;
        boolean z11 = false;
        for (int i15 = 0; i15 < this.M0; i15++) {
            ConstraintWidget constraintWidget2 = this.L0[i15];
            if (this.O0 || constraintWidget2.h()) {
                if (!z11) {
                    int i16 = this.N0;
                    if (i16 == 0) {
                        i14 = constraintWidget2.o(ConstraintAnchor.Type.LEFT).e();
                    } else if (i16 == 1) {
                        i14 = constraintWidget2.o(ConstraintAnchor.Type.RIGHT).e();
                    } else if (i16 == 2) {
                        i14 = constraintWidget2.o(ConstraintAnchor.Type.TOP).e();
                    } else if (i16 == 3) {
                        i14 = constraintWidget2.o(ConstraintAnchor.Type.BOTTOM).e();
                    }
                    z11 = true;
                }
                int i17 = this.N0;
                if (i17 == 0) {
                    i14 = Math.min(i14, constraintWidget2.o(ConstraintAnchor.Type.LEFT).e());
                } else if (i17 == 1) {
                    i14 = Math.max(i14, constraintWidget2.o(ConstraintAnchor.Type.RIGHT).e());
                } else if (i17 == 2) {
                    i14 = Math.min(i14, constraintWidget2.o(ConstraintAnchor.Type.TOP).e());
                } else if (i17 == 3) {
                    i14 = Math.max(i14, constraintWidget2.o(ConstraintAnchor.Type.BOTTOM).e());
                }
            }
        }
        int i18 = i14 + this.P0;
        int i19 = this.N0;
        if (i19 == 0 || i19 == 1) {
            F0(i18, i18);
        } else {
            I0(i18, i18);
        }
        this.Q0 = true;
        return true;
    }

    public String toString() {
        String str = "[Barrier] " + t() + " {";
        for (int i10 = 0; i10 < this.M0; i10++) {
            ConstraintWidget constraintWidget = this.L0[i10];
            if (i10 > 0) {
                str = str + ", ";
            }
            str = str + constraintWidget.t();
        }
        return str + "}";
    }

    public boolean u1() {
        return this.O0;
    }

    public int v1() {
        return this.N0;
    }

    public int w1() {
        return this.P0;
    }

    public int x1() {
        int i10 = this.N0;
        if (i10 == 0 || i10 == 1) {
            return 0;
        }
        return (i10 == 2 || i10 == 3) ? 1 : -1;
    }

    /* access modifiers changed from: protected */
    public void y1() {
        for (int i10 = 0; i10 < this.M0; i10++) {
            ConstraintWidget constraintWidget = this.L0[i10];
            if (this.O0 || constraintWidget.h()) {
                int i11 = this.N0;
                if (i11 == 0 || i11 == 1) {
                    constraintWidget.S0(0, true);
                } else if (i11 == 2 || i11 == 3) {
                    constraintWidget.S0(1, true);
                }
            }
        }
    }

    public void z1(boolean z10) {
        this.O0 = z10;
    }
}
