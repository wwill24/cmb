package p0;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

public class c extends ConstraintWidget {
    public ArrayList<ConstraintWidget> L0 = new ArrayList<>();

    public void a(ConstraintWidget constraintWidget) {
        this.L0.add(constraintWidget);
        if (constraintWidget.K() != null) {
            ((c) constraintWidget.K()).t1(constraintWidget);
        }
        constraintWidget.c1(this);
    }

    public ArrayList<ConstraintWidget> r1() {
        return this.L0;
    }

    public void s1() {
        ArrayList<ConstraintWidget> arrayList = this.L0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ConstraintWidget constraintWidget = this.L0.get(i10);
                if (constraintWidget instanceof c) {
                    ((c) constraintWidget).s1();
                }
            }
        }
    }

    public void t0() {
        this.L0.clear();
        super.t0();
    }

    public void t1(ConstraintWidget constraintWidget) {
        this.L0.remove(constraintWidget);
        constraintWidget.t0();
    }

    public void u1() {
        this.L0.clear();
    }

    public void w0(androidx.constraintlayout.core.c cVar) {
        super.w0(cVar);
        int size = this.L0.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.L0.get(i10).w0(cVar);
        }
    }
}
