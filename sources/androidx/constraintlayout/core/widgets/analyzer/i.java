package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import q0.a;

class i extends WidgetRun {
    public i(ConstraintWidget constraintWidget) {
        super(constraintWidget);
    }

    private void q(DependencyNode dependencyNode) {
        this.f3842h.f3824k.add(dependencyNode);
        dependencyNode.f3825l.add(this.f3842h);
    }

    public void a(a aVar) {
        androidx.constraintlayout.core.widgets.a aVar2 = (androidx.constraintlayout.core.widgets.a) this.f3836b;
        int v12 = aVar2.v1();
        int i10 = 0;
        int i11 = -1;
        for (DependencyNode dependencyNode : this.f3842h.f3825l) {
            int i12 = dependencyNode.f3820g;
            if (i11 == -1 || i12 < i11) {
                i11 = i12;
            }
            if (i10 < i12) {
                i10 = i12;
            }
        }
        if (v12 == 0 || v12 == 2) {
            this.f3842h.d(i11 + aVar2.w1());
        } else {
            this.f3842h.d(i10 + aVar2.w1());
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        ConstraintWidget constraintWidget = this.f3836b;
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.a) {
            this.f3842h.f3815b = true;
            androidx.constraintlayout.core.widgets.a aVar = (androidx.constraintlayout.core.widgets.a) constraintWidget;
            int v12 = aVar.v1();
            boolean u12 = aVar.u1();
            int i10 = 0;
            if (v12 == 0) {
                this.f3842h.f3818e = DependencyNode.Type.LEFT;
                while (i10 < aVar.M0) {
                    ConstraintWidget constraintWidget2 = aVar.L0[i10];
                    if (u12 || constraintWidget2.V() != 8) {
                        DependencyNode dependencyNode = constraintWidget2.f3763e.f3842h;
                        dependencyNode.f3824k.add(this.f3842h);
                        this.f3842h.f3825l.add(dependencyNode);
                    }
                    i10++;
                }
                q(this.f3836b.f3763e.f3842h);
                q(this.f3836b.f3763e.f3843i);
            } else if (v12 == 1) {
                this.f3842h.f3818e = DependencyNode.Type.RIGHT;
                while (i10 < aVar.M0) {
                    ConstraintWidget constraintWidget3 = aVar.L0[i10];
                    if (u12 || constraintWidget3.V() != 8) {
                        DependencyNode dependencyNode2 = constraintWidget3.f3763e.f3843i;
                        dependencyNode2.f3824k.add(this.f3842h);
                        this.f3842h.f3825l.add(dependencyNode2);
                    }
                    i10++;
                }
                q(this.f3836b.f3763e.f3842h);
                q(this.f3836b.f3763e.f3843i);
            } else if (v12 == 2) {
                this.f3842h.f3818e = DependencyNode.Type.TOP;
                while (i10 < aVar.M0) {
                    ConstraintWidget constraintWidget4 = aVar.L0[i10];
                    if (u12 || constraintWidget4.V() != 8) {
                        DependencyNode dependencyNode3 = constraintWidget4.f3765f.f3842h;
                        dependencyNode3.f3824k.add(this.f3842h);
                        this.f3842h.f3825l.add(dependencyNode3);
                    }
                    i10++;
                }
                q(this.f3836b.f3765f.f3842h);
                q(this.f3836b.f3765f.f3843i);
            } else if (v12 == 3) {
                this.f3842h.f3818e = DependencyNode.Type.BOTTOM;
                while (i10 < aVar.M0) {
                    ConstraintWidget constraintWidget5 = aVar.L0[i10];
                    if (u12 || constraintWidget5.V() != 8) {
                        DependencyNode dependencyNode4 = constraintWidget5.f3765f.f3843i;
                        dependencyNode4.f3824k.add(this.f3842h);
                        this.f3842h.f3825l.add(dependencyNode4);
                    }
                    i10++;
                }
                q(this.f3836b.f3765f.f3842h);
                q(this.f3836b.f3765f.f3843i);
            }
        }
    }

    public void e() {
        ConstraintWidget constraintWidget = this.f3836b;
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.a) {
            int v12 = ((androidx.constraintlayout.core.widgets.a) constraintWidget).v1();
            if (v12 == 0 || v12 == 1) {
                this.f3836b.m1(this.f3842h.f3820g);
            } else {
                this.f3836b.n1(this.f3842h.f3820g);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f3837c = null;
        this.f3842h.c();
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        return false;
    }
}
