package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

public abstract class WidgetRun implements q0.a {

    /* renamed from: a  reason: collision with root package name */
    public int f3835a;

    /* renamed from: b  reason: collision with root package name */
    ConstraintWidget f3836b;

    /* renamed from: c  reason: collision with root package name */
    k f3837c;

    /* renamed from: d  reason: collision with root package name */
    protected ConstraintWidget.DimensionBehaviour f3838d;

    /* renamed from: e  reason: collision with root package name */
    e f3839e = new e(this);

    /* renamed from: f  reason: collision with root package name */
    public int f3840f = 0;

    /* renamed from: g  reason: collision with root package name */
    boolean f3841g = false;

    /* renamed from: h  reason: collision with root package name */
    public DependencyNode f3842h = new DependencyNode(this);

    /* renamed from: i  reason: collision with root package name */
    public DependencyNode f3843i = new DependencyNode(this);

    /* renamed from: j  reason: collision with root package name */
    protected RunType f3844j = RunType.NONE;

    enum RunType {
        NONE,
        START,
        END,
        CENTER
    }

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3850a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type[] r0 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3850a = r0
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3850a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3850a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f3850a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BASELINE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f3850a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.WidgetRun.a.<clinit>():void");
        }
    }

    public WidgetRun(ConstraintWidget constraintWidget) {
        this.f3836b = constraintWidget;
    }

    private void l(int i10, int i11) {
        WidgetRun widgetRun;
        float f10;
        int i12;
        int i13 = this.f3835a;
        if (i13 == 0) {
            this.f3839e.d(g(i11, i10));
        } else if (i13 == 1) {
            this.f3839e.d(Math.min(g(this.f3839e.f3878m, i10), i11));
        } else if (i13 == 2) {
            ConstraintWidget K = this.f3836b.K();
            if (K != null) {
                if (i10 == 0) {
                    widgetRun = K.f3763e;
                } else {
                    widgetRun = K.f3765f;
                }
                e eVar = widgetRun.f3839e;
                if (eVar.f3823j) {
                    ConstraintWidget constraintWidget = this.f3836b;
                    if (i10 == 0) {
                        f10 = constraintWidget.B;
                    } else {
                        f10 = constraintWidget.E;
                    }
                    this.f3839e.d(g((int) ((((float) eVar.f3820g) * f10) + 0.5f), i10));
                }
            }
        } else if (i13 == 3) {
            ConstraintWidget constraintWidget2 = this.f3836b;
            WidgetRun widgetRun2 = constraintWidget2.f3763e;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = widgetRun2.f3838d;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (dimensionBehaviour == dimensionBehaviour2 && widgetRun2.f3835a == 3) {
                l lVar = constraintWidget2.f3765f;
                if (lVar.f3838d == dimensionBehaviour2 && lVar.f3835a == 3) {
                    return;
                }
            }
            if (i10 == 0) {
                widgetRun2 = constraintWidget2.f3765f;
            }
            if (widgetRun2.f3839e.f3823j) {
                float v10 = constraintWidget2.v();
                if (i10 == 1) {
                    i12 = (int) ((((float) widgetRun2.f3839e.f3820g) / v10) + 0.5f);
                } else {
                    i12 = (int) ((v10 * ((float) widgetRun2.f3839e.f3820g)) + 0.5f);
                }
                this.f3839e.d(i12);
            }
        }
    }

    public void a(q0.a aVar) {
    }

    /* access modifiers changed from: protected */
    public final void b(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i10) {
        dependencyNode.f3825l.add(dependencyNode2);
        dependencyNode.f3819f = i10;
        dependencyNode2.f3824k.add(dependencyNode);
    }

    /* access modifiers changed from: protected */
    public final void c(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i10, e eVar) {
        dependencyNode.f3825l.add(dependencyNode2);
        dependencyNode.f3825l.add(this.f3839e);
        dependencyNode.f3821h = i10;
        dependencyNode.f3822i = eVar;
        dependencyNode2.f3824k.add(dependencyNode);
        eVar.f3824k.add(dependencyNode);
    }

    /* access modifiers changed from: package-private */
    public abstract void d();

    /* access modifiers changed from: package-private */
    public abstract void e();

    /* access modifiers changed from: package-private */
    public abstract void f();

    /* access modifiers changed from: protected */
    public final int g(int i10, int i11) {
        int i12;
        if (i11 == 0) {
            ConstraintWidget constraintWidget = this.f3836b;
            int i13 = constraintWidget.A;
            i12 = Math.max(constraintWidget.f3805z, i10);
            if (i13 > 0) {
                i12 = Math.min(i13, i10);
            }
            if (i12 == i10) {
                return i10;
            }
        } else {
            ConstraintWidget constraintWidget2 = this.f3836b;
            int i14 = constraintWidget2.D;
            int max = Math.max(constraintWidget2.C, i10);
            if (i14 > 0) {
                max = Math.min(i14, i10);
            }
            if (i12 == i10) {
                return i10;
            }
        }
        return i12;
    }

    /* access modifiers changed from: protected */
    public final DependencyNode h(ConstraintAnchor constraintAnchor) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f3740f;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.f3738d;
        int i10 = a.f3850a[constraintAnchor2.f3739e.ordinal()];
        if (i10 == 1) {
            return constraintWidget.f3763e.f3842h;
        }
        if (i10 == 2) {
            return constraintWidget.f3763e.f3843i;
        }
        if (i10 == 3) {
            return constraintWidget.f3765f.f3842h;
        }
        if (i10 == 4) {
            return constraintWidget.f3765f.f3892k;
        }
        if (i10 != 5) {
            return null;
        }
        return constraintWidget.f3765f.f3843i;
    }

    /* access modifiers changed from: protected */
    public final DependencyNode i(ConstraintAnchor constraintAnchor, int i10) {
        WidgetRun widgetRun;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f3740f;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.f3738d;
        if (i10 == 0) {
            widgetRun = constraintWidget.f3763e;
        } else {
            widgetRun = constraintWidget.f3765f;
        }
        int i11 = a.f3850a[constraintAnchor2.f3739e.ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    if (i11 != 5) {
                        return null;
                    }
                }
            }
            return widgetRun.f3843i;
        }
        return widgetRun.f3842h;
    }

    public long j() {
        e eVar = this.f3839e;
        if (eVar.f3823j) {
            return (long) eVar.f3820g;
        }
        return 0;
    }

    public boolean k() {
        return this.f3841g;
    }

    /* access modifiers changed from: package-private */
    public abstract boolean m();

    /* access modifiers changed from: protected */
    public void n(q0.a aVar, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i10) {
        float f10;
        DependencyNode h10 = h(constraintAnchor);
        DependencyNode h11 = h(constraintAnchor2);
        if (h10.f3823j && h11.f3823j) {
            int f11 = h10.f3820g + constraintAnchor.f();
            int f12 = h11.f3820g - constraintAnchor2.f();
            int i11 = f12 - f11;
            if (!this.f3839e.f3823j && this.f3838d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                l(i10, i11);
            }
            e eVar = this.f3839e;
            if (eVar.f3823j) {
                if (eVar.f3820g == i11) {
                    this.f3842h.d(f11);
                    this.f3843i.d(f12);
                    return;
                }
                ConstraintWidget constraintWidget = this.f3836b;
                if (i10 == 0) {
                    f10 = constraintWidget.y();
                } else {
                    f10 = constraintWidget.R();
                }
                if (h10 == h11) {
                    f11 = h10.f3820g;
                    f12 = h11.f3820g;
                    f10 = 0.5f;
                }
                this.f3842h.d((int) (((float) f11) + 0.5f + (((float) ((f12 - f11) - this.f3839e.f3820g)) * f10)));
                this.f3843i.d(this.f3842h.f3820g + this.f3839e.f3820g);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void o(q0.a aVar) {
    }

    /* access modifiers changed from: protected */
    public void p(q0.a aVar) {
    }
}
