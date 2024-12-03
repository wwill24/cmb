package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.d;
import java.util.ArrayList;
import q0.a;

class k {

    /* renamed from: h  reason: collision with root package name */
    public static int f3884h;

    /* renamed from: a  reason: collision with root package name */
    public int f3885a = 0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3886b = false;

    /* renamed from: c  reason: collision with root package name */
    WidgetRun f3887c = null;

    /* renamed from: d  reason: collision with root package name */
    WidgetRun f3888d = null;

    /* renamed from: e  reason: collision with root package name */
    ArrayList<WidgetRun> f3889e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    int f3890f;

    /* renamed from: g  reason: collision with root package name */
    int f3891g;

    public k(WidgetRun widgetRun, int i10) {
        int i11 = f3884h;
        this.f3890f = i11;
        f3884h = i11 + 1;
        this.f3887c = widgetRun;
        this.f3888d = widgetRun;
        this.f3891g = i10;
    }

    private long c(DependencyNode dependencyNode, long j10) {
        WidgetRun widgetRun = dependencyNode.f3817d;
        if (widgetRun instanceof i) {
            return j10;
        }
        int size = dependencyNode.f3824k.size();
        long j11 = j10;
        for (int i10 = 0; i10 < size; i10++) {
            a aVar = dependencyNode.f3824k.get(i10);
            if (aVar instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) aVar;
                if (dependencyNode2.f3817d != widgetRun) {
                    j11 = Math.min(j11, c(dependencyNode2, ((long) dependencyNode2.f3819f) + j10));
                }
            }
        }
        if (dependencyNode != widgetRun.f3843i) {
            return j11;
        }
        long j12 = j10 - widgetRun.j();
        return Math.min(Math.min(j11, c(widgetRun.f3842h, j12)), j12 - ((long) widgetRun.f3842h.f3819f));
    }

    private long d(DependencyNode dependencyNode, long j10) {
        WidgetRun widgetRun = dependencyNode.f3817d;
        if (widgetRun instanceof i) {
            return j10;
        }
        int size = dependencyNode.f3824k.size();
        long j11 = j10;
        for (int i10 = 0; i10 < size; i10++) {
            a aVar = dependencyNode.f3824k.get(i10);
            if (aVar instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) aVar;
                if (dependencyNode2.f3817d != widgetRun) {
                    j11 = Math.max(j11, d(dependencyNode2, ((long) dependencyNode2.f3819f) + j10));
                }
            }
        }
        if (dependencyNode != widgetRun.f3842h) {
            return j11;
        }
        long j12 = j10 + widgetRun.j();
        return Math.max(Math.max(j11, d(widgetRun.f3843i, j12)), j12 - ((long) widgetRun.f3843i.f3819f));
    }

    public void a(WidgetRun widgetRun) {
        this.f3889e.add(widgetRun);
        this.f3888d = widgetRun;
    }

    public long b(d dVar, int i10) {
        WidgetRun widgetRun;
        WidgetRun widgetRun2;
        int i11;
        long j10;
        WidgetRun widgetRun3 = this.f3887c;
        long j11 = 0;
        if (widgetRun3 instanceof c) {
            if (((c) widgetRun3).f3840f != i10) {
                return 0;
            }
        } else if (i10 == 0) {
            if (!(widgetRun3 instanceof j)) {
                return 0;
            }
        } else if (!(widgetRun3 instanceof l)) {
            return 0;
        }
        if (i10 == 0) {
            widgetRun = dVar.f3763e;
        } else {
            widgetRun = dVar.f3765f;
        }
        DependencyNode dependencyNode = widgetRun.f3842h;
        if (i10 == 0) {
            widgetRun2 = dVar.f3763e;
        } else {
            widgetRun2 = dVar.f3765f;
        }
        DependencyNode dependencyNode2 = widgetRun2.f3843i;
        boolean contains = widgetRun3.f3842h.f3825l.contains(dependencyNode);
        boolean contains2 = this.f3887c.f3843i.f3825l.contains(dependencyNode2);
        long j12 = this.f3887c.j();
        if (contains && contains2) {
            long d10 = d(this.f3887c.f3842h, 0);
            long c10 = c(this.f3887c.f3843i, 0);
            long j13 = d10 - j12;
            WidgetRun widgetRun4 = this.f3887c;
            int i12 = widgetRun4.f3843i.f3819f;
            if (j13 >= ((long) (-i12))) {
                j13 += (long) i12;
            }
            int i13 = widgetRun4.f3842h.f3819f;
            long j14 = ((-c10) - j12) - ((long) i13);
            if (j14 >= ((long) i13)) {
                j14 -= (long) i13;
            }
            float q10 = widgetRun4.f3836b.q(i10);
            if (q10 > 0.0f) {
                j11 = (long) ((((float) j14) / q10) + (((float) j13) / (1.0f - q10)));
            }
            float f10 = (float) j11;
            long j15 = ((long) ((f10 * q10) + 0.5f)) + j12 + ((long) ((f10 * (1.0f - q10)) + 0.5f));
            WidgetRun widgetRun5 = this.f3887c;
            j10 = ((long) widgetRun5.f3842h.f3819f) + j15;
            i11 = widgetRun5.f3843i.f3819f;
        } else if (contains) {
            DependencyNode dependencyNode3 = this.f3887c.f3842h;
            return Math.max(d(dependencyNode3, (long) dependencyNode3.f3819f), ((long) this.f3887c.f3842h.f3819f) + j12);
        } else if (contains2) {
            DependencyNode dependencyNode4 = this.f3887c.f3843i;
            return Math.max(-c(dependencyNode4, (long) dependencyNode4.f3819f), ((long) (-this.f3887c.f3843i.f3819f)) + j12);
        } else {
            WidgetRun widgetRun6 = this.f3887c;
            j10 = ((long) widgetRun6.f3842h.f3819f) + widgetRun6.j();
            i11 = this.f3887c.f3843i.f3819f;
        }
        return j10 - ((long) i11);
    }
}
