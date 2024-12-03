package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.d;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

public class g {

    /* renamed from: a  reason: collision with root package name */
    static boolean[] f3992a = new boolean[3];

    static void a(d dVar, d dVar2, ConstraintWidget constraintWidget) {
        constraintWidget.f3793t = -1;
        constraintWidget.f3795u = -1;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = dVar.Z[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviour != dimensionBehaviour2 && constraintWidget.Z[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i10 = constraintWidget.O.f3741g;
            int W = dVar.W() - constraintWidget.Q.f3741g;
            ConstraintAnchor constraintAnchor = constraintWidget.O;
            constraintAnchor.f3743i = dVar2.q(constraintAnchor);
            ConstraintAnchor constraintAnchor2 = constraintWidget.Q;
            constraintAnchor2.f3743i = dVar2.q(constraintAnchor2);
            dVar2.f(constraintWidget.O.f3743i, i10);
            dVar2.f(constraintWidget.Q.f3743i, W);
            constraintWidget.f3793t = 2;
            constraintWidget.O0(i10, W);
        }
        if (dVar.Z[1] != dimensionBehaviour2 && constraintWidget.Z[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i11 = constraintWidget.P.f3741g;
            int x10 = dVar.x() - constraintWidget.R.f3741g;
            ConstraintAnchor constraintAnchor3 = constraintWidget.P;
            constraintAnchor3.f3743i = dVar2.q(constraintAnchor3);
            ConstraintAnchor constraintAnchor4 = constraintWidget.R;
            constraintAnchor4.f3743i = dVar2.q(constraintAnchor4);
            dVar2.f(constraintWidget.P.f3743i, i11);
            dVar2.f(constraintWidget.R.f3743i, x10);
            if (constraintWidget.f3778l0 > 0 || constraintWidget.V() == 8) {
                ConstraintAnchor constraintAnchor5 = constraintWidget.S;
                constraintAnchor5.f3743i = dVar2.q(constraintAnchor5);
                dVar2.f(constraintWidget.S.f3743i, constraintWidget.f3778l0 + i11);
            }
            constraintWidget.f3795u = 2;
            constraintWidget.f1(i11, x10);
        }
    }

    public static final boolean b(int i10, int i11) {
        return (i10 & i11) == i11;
    }
}
