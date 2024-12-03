package p0;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.g;
import androidx.constraintlayout.core.widgets.analyzer.m;
import androidx.constraintlayout.core.widgets.d;
import java.util.ArrayList;
import java.util.Arrays;

public class b extends ConstraintWidget implements a {
    public ConstraintWidget[] L0 = new ConstraintWidget[4];
    public int M0 = 0;

    public void a(ConstraintWidget constraintWidget) {
        if (constraintWidget != this && constraintWidget != null) {
            int i10 = this.M0 + 1;
            ConstraintWidget[] constraintWidgetArr = this.L0;
            if (i10 > constraintWidgetArr.length) {
                this.L0 = (ConstraintWidget[]) Arrays.copyOf(constraintWidgetArr, constraintWidgetArr.length * 2);
            }
            ConstraintWidget[] constraintWidgetArr2 = this.L0;
            int i11 = this.M0;
            constraintWidgetArr2[i11] = constraintWidget;
            this.M0 = i11 + 1;
        }
    }

    public void b() {
        this.M0 = 0;
        Arrays.fill(this.L0, (Object) null);
    }

    public void c(d dVar) {
    }

    public void r1(ArrayList<m> arrayList, int i10, m mVar) {
        for (int i11 = 0; i11 < this.M0; i11++) {
            mVar.a(this.L0[i11]);
        }
        for (int i12 = 0; i12 < this.M0; i12++) {
            g.a(this.L0[i12], i10, arrayList, mVar);
        }
    }

    public int s1(int i10) {
        int i11;
        int i12;
        for (int i13 = 0; i13 < this.M0; i13++) {
            ConstraintWidget constraintWidget = this.L0[i13];
            if (i10 == 0 && (i12 = constraintWidget.I0) != -1) {
                return i12;
            }
            if (i10 == 1 && (i11 = constraintWidget.J0) != -1) {
                return i11;
            }
        }
        return -1;
    }
}
