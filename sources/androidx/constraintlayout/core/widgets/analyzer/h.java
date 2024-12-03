package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.f;
import q0.a;

class h extends WidgetRun {
    public h(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        constraintWidget.f3763e.f();
        constraintWidget.f3765f.f();
        this.f3840f = ((f) constraintWidget).s1();
    }

    private void q(DependencyNode dependencyNode) {
        this.f3842h.f3824k.add(dependencyNode);
        dependencyNode.f3825l.add(this.f3842h);
    }

    public void a(a aVar) {
        DependencyNode dependencyNode = this.f3842h;
        if (dependencyNode.f3816c && !dependencyNode.f3823j) {
            this.f3842h.d((int) ((((float) dependencyNode.f3825l.get(0).f3820g) * ((f) this.f3836b).v1()) + 0.5f));
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        f fVar = (f) this.f3836b;
        int t12 = fVar.t1();
        int u12 = fVar.u1();
        fVar.v1();
        if (fVar.s1() == 1) {
            if (t12 != -1) {
                this.f3842h.f3825l.add(this.f3836b.f3756a0.f3763e.f3842h);
                this.f3836b.f3756a0.f3763e.f3842h.f3824k.add(this.f3842h);
                this.f3842h.f3819f = t12;
            } else if (u12 != -1) {
                this.f3842h.f3825l.add(this.f3836b.f3756a0.f3763e.f3843i);
                this.f3836b.f3756a0.f3763e.f3843i.f3824k.add(this.f3842h);
                this.f3842h.f3819f = -u12;
            } else {
                DependencyNode dependencyNode = this.f3842h;
                dependencyNode.f3815b = true;
                dependencyNode.f3825l.add(this.f3836b.f3756a0.f3763e.f3843i);
                this.f3836b.f3756a0.f3763e.f3843i.f3824k.add(this.f3842h);
            }
            q(this.f3836b.f3763e.f3842h);
            q(this.f3836b.f3763e.f3843i);
            return;
        }
        if (t12 != -1) {
            this.f3842h.f3825l.add(this.f3836b.f3756a0.f3765f.f3842h);
            this.f3836b.f3756a0.f3765f.f3842h.f3824k.add(this.f3842h);
            this.f3842h.f3819f = t12;
        } else if (u12 != -1) {
            this.f3842h.f3825l.add(this.f3836b.f3756a0.f3765f.f3843i);
            this.f3836b.f3756a0.f3765f.f3843i.f3824k.add(this.f3842h);
            this.f3842h.f3819f = -u12;
        } else {
            DependencyNode dependencyNode2 = this.f3842h;
            dependencyNode2.f3815b = true;
            dependencyNode2.f3825l.add(this.f3836b.f3756a0.f3765f.f3843i);
            this.f3836b.f3756a0.f3765f.f3843i.f3824k.add(this.f3842h);
        }
        q(this.f3836b.f3765f.f3842h);
        q(this.f3836b.f3765f.f3843i);
    }

    public void e() {
        if (((f) this.f3836b).s1() == 1) {
            this.f3836b.m1(this.f3842h.f3820g);
        } else {
            this.f3836b.n1(this.f3842h.f3820g);
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f3842h.c();
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        return false;
    }
}
