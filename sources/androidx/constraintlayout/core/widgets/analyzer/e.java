package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import q0.a;

class e extends DependencyNode {

    /* renamed from: m  reason: collision with root package name */
    public int f3878m;

    public e(WidgetRun widgetRun) {
        super(widgetRun);
        if (widgetRun instanceof j) {
            this.f3818e = DependencyNode.Type.HORIZONTAL_DIMENSION;
        } else {
            this.f3818e = DependencyNode.Type.VERTICAL_DIMENSION;
        }
    }

    public void d(int i10) {
        if (!this.f3823j) {
            this.f3823j = true;
            this.f3820g = i10;
            for (a next : this.f3824k) {
                next.a(next);
            }
        }
    }
}
