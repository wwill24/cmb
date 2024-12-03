package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.b;
import java.util.HashSet;
import p0.b;

public class h extends b {
    private int N0 = 0;
    private int O0 = 0;
    private int P0 = 0;
    private int Q0 = 0;
    private int R0 = 0;
    private int S0 = 0;
    private int T0 = 0;
    private int U0 = 0;
    private boolean V0 = false;
    private int W0 = 0;
    private int X0 = 0;
    protected b.a Y0 = new b.a();
    b.C0027b Z0 = null;

    public int A1() {
        return this.U0;
    }

    public int B1() {
        return this.N0;
    }

    public void C1(int i10, int i11, int i12, int i13) {
    }

    /* access modifiers changed from: protected */
    public void D1(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i10, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i11) {
        while (this.Z0 == null && K() != null) {
            this.Z0 = ((d) K()).I1();
        }
        b.a aVar = this.Y0;
        aVar.f3857a = dimensionBehaviour;
        aVar.f3858b = dimensionBehaviour2;
        aVar.f3859c = i10;
        aVar.f3860d = i11;
        this.Z0.b(constraintWidget, aVar);
        constraintWidget.k1(this.Y0.f3861e);
        constraintWidget.L0(this.Y0.f3862f);
        constraintWidget.K0(this.Y0.f3864h);
        constraintWidget.A0(this.Y0.f3863g);
    }

    /* access modifiers changed from: protected */
    public boolean E1() {
        b.C0027b bVar;
        ConstraintWidget constraintWidget = this.f3756a0;
        if (constraintWidget != null) {
            bVar = ((d) constraintWidget).I1();
        } else {
            bVar = null;
        }
        if (bVar == null) {
            return false;
        }
        int i10 = 0;
        while (true) {
            boolean z10 = true;
            if (i10 >= this.M0) {
                return true;
            }
            ConstraintWidget constraintWidget2 = this.L0[i10];
            if (constraintWidget2 != null && !(constraintWidget2 instanceof f)) {
                ConstraintWidget.DimensionBehaviour u10 = constraintWidget2.u(0);
                ConstraintWidget.DimensionBehaviour u11 = constraintWidget2.u(1);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (u10 != dimensionBehaviour || constraintWidget2.f3799w == 1 || u11 != dimensionBehaviour || constraintWidget2.f3801x == 1) {
                    z10 = false;
                }
                if (!z10) {
                    if (u10 == dimensionBehaviour) {
                        u10 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    if (u11 == dimensionBehaviour) {
                        u11 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    b.a aVar = this.Y0;
                    aVar.f3857a = u10;
                    aVar.f3858b = u11;
                    aVar.f3859c = constraintWidget2.W();
                    this.Y0.f3860d = constraintWidget2.x();
                    bVar.b(constraintWidget2, this.Y0);
                    constraintWidget2.k1(this.Y0.f3861e);
                    constraintWidget2.L0(this.Y0.f3862f);
                    constraintWidget2.A0(this.Y0.f3863g);
                }
            }
            i10++;
        }
    }

    public boolean F1() {
        return this.V0;
    }

    /* access modifiers changed from: protected */
    public void G1(boolean z10) {
        this.V0 = z10;
    }

    public void H1(int i10, int i11) {
        this.W0 = i10;
        this.X0 = i11;
    }

    public void I1(int i10) {
        this.P0 = i10;
        this.N0 = i10;
        this.Q0 = i10;
        this.O0 = i10;
        this.R0 = i10;
        this.S0 = i10;
    }

    public void J1(int i10) {
        this.O0 = i10;
    }

    public void K1(int i10) {
        this.S0 = i10;
    }

    public void L1(int i10) {
        this.P0 = i10;
        this.T0 = i10;
    }

    public void M1(int i10) {
        this.Q0 = i10;
        this.U0 = i10;
    }

    public void N1(int i10) {
        this.R0 = i10;
        this.T0 = i10;
        this.U0 = i10;
    }

    public void O1(int i10) {
        this.N0 = i10;
    }

    public void c(d dVar) {
        u1();
    }

    public void t1(boolean z10) {
        int i10 = this.R0;
        if (i10 <= 0 && this.S0 <= 0) {
            return;
        }
        if (z10) {
            this.T0 = this.S0;
            this.U0 = i10;
            return;
        }
        this.T0 = i10;
        this.U0 = this.S0;
    }

    public void u1() {
        for (int i10 = 0; i10 < this.M0; i10++) {
            ConstraintWidget constraintWidget = this.L0[i10];
            if (constraintWidget != null) {
                constraintWidget.U0(true);
            }
        }
    }

    public boolean v1(HashSet<ConstraintWidget> hashSet) {
        for (int i10 = 0; i10 < this.M0; i10++) {
            if (hashSet.contains(this.L0[i10])) {
                return true;
            }
        }
        return false;
    }

    public int w1() {
        return this.X0;
    }

    public int x1() {
        return this.W0;
    }

    public int y1() {
        return this.O0;
    }

    public int z1() {
        return this.T0;
    }
}
