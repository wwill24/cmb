package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;

public class l extends WidgetRun {

    /* renamed from: k  reason: collision with root package name */
    public DependencyNode f3892k;

    /* renamed from: l  reason: collision with root package name */
    e f3893l = null;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3894a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType[] r0 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3894a = r0
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.START     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3894a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.END     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3894a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.CENTER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.l.a.<clinit>():void");
        }
    }

    public l(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        DependencyNode dependencyNode = new DependencyNode(this);
        this.f3892k = dependencyNode;
        this.f3842h.f3818e = DependencyNode.Type.TOP;
        this.f3843i.f3818e = DependencyNode.Type.BOTTOM;
        dependencyNode.f3818e = DependencyNode.Type.BASELINE;
        this.f3840f = 1;
    }

    public void a(q0.a aVar) {
        int i10;
        float f10;
        float f11;
        float f12;
        int i11 = a.f3894a[this.f3844j.ordinal()];
        if (i11 == 1) {
            p(aVar);
        } else if (i11 == 2) {
            o(aVar);
        } else if (i11 == 3) {
            ConstraintWidget constraintWidget = this.f3836b;
            n(aVar, constraintWidget.P, constraintWidget.R, 1);
            return;
        }
        e eVar = this.f3839e;
        if (eVar.f3816c && !eVar.f3823j && this.f3838d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget2 = this.f3836b;
            int i12 = constraintWidget2.f3801x;
            if (i12 == 2) {
                ConstraintWidget K = constraintWidget2.K();
                if (K != null) {
                    e eVar2 = K.f3765f.f3839e;
                    if (eVar2.f3823j) {
                        this.f3839e.d((int) ((((float) eVar2.f3820g) * this.f3836b.E) + 0.5f));
                    }
                }
            } else if (i12 == 3 && constraintWidget2.f3763e.f3839e.f3823j) {
                int w10 = constraintWidget2.w();
                if (w10 == -1) {
                    ConstraintWidget constraintWidget3 = this.f3836b;
                    f12 = (float) constraintWidget3.f3763e.f3839e.f3820g;
                    f11 = constraintWidget3.v();
                } else if (w10 == 0) {
                    ConstraintWidget constraintWidget4 = this.f3836b;
                    f10 = ((float) constraintWidget4.f3763e.f3839e.f3820g) * constraintWidget4.v();
                    i10 = (int) (f10 + 0.5f);
                    this.f3839e.d(i10);
                } else if (w10 != 1) {
                    i10 = 0;
                    this.f3839e.d(i10);
                } else {
                    ConstraintWidget constraintWidget5 = this.f3836b;
                    f12 = (float) constraintWidget5.f3763e.f3839e.f3820g;
                    f11 = constraintWidget5.v();
                }
                f10 = f12 / f11;
                i10 = (int) (f10 + 0.5f);
                this.f3839e.d(i10);
            }
        }
        DependencyNode dependencyNode = this.f3842h;
        if (dependencyNode.f3816c) {
            DependencyNode dependencyNode2 = this.f3843i;
            if (dependencyNode2.f3816c) {
                if (!dependencyNode.f3823j || !dependencyNode2.f3823j || !this.f3839e.f3823j) {
                    if (!this.f3839e.f3823j && this.f3838d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        ConstraintWidget constraintWidget6 = this.f3836b;
                        if (constraintWidget6.f3799w == 0 && !constraintWidget6.k0()) {
                            int i13 = this.f3842h.f3825l.get(0).f3820g;
                            DependencyNode dependencyNode3 = this.f3842h;
                            int i14 = i13 + dependencyNode3.f3819f;
                            int i15 = this.f3843i.f3825l.get(0).f3820g + this.f3843i.f3819f;
                            dependencyNode3.d(i14);
                            this.f3843i.d(i15);
                            this.f3839e.d(i15 - i14);
                            return;
                        }
                    }
                    if (!this.f3839e.f3823j && this.f3838d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.f3835a == 1 && this.f3842h.f3825l.size() > 0 && this.f3843i.f3825l.size() > 0) {
                        int i16 = (this.f3843i.f3825l.get(0).f3820g + this.f3843i.f3819f) - (this.f3842h.f3825l.get(0).f3820g + this.f3842h.f3819f);
                        e eVar3 = this.f3839e;
                        int i17 = eVar3.f3878m;
                        if (i16 < i17) {
                            eVar3.d(i16);
                        } else {
                            eVar3.d(i17);
                        }
                    }
                    if (this.f3839e.f3823j && this.f3842h.f3825l.size() > 0 && this.f3843i.f3825l.size() > 0) {
                        DependencyNode dependencyNode4 = this.f3842h.f3825l.get(0);
                        DependencyNode dependencyNode5 = this.f3843i.f3825l.get(0);
                        int i18 = dependencyNode4.f3820g + this.f3842h.f3819f;
                        int i19 = dependencyNode5.f3820g + this.f3843i.f3819f;
                        float R = this.f3836b.R();
                        if (dependencyNode4 == dependencyNode5) {
                            i18 = dependencyNode4.f3820g;
                            i19 = dependencyNode5.f3820g;
                            R = 0.5f;
                        }
                        this.f3842h.d((int) (((float) i18) + 0.5f + (((float) ((i19 - i18) - this.f3839e.f3820g)) * R)));
                        this.f3843i.d(this.f3842h.f3820g + this.f3839e.f3820g);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        ConstraintWidget K;
        ConstraintWidget K2;
        ConstraintWidget constraintWidget = this.f3836b;
        if (constraintWidget.f3755a) {
            this.f3839e.d(constraintWidget.x());
        }
        if (!this.f3839e.f3823j) {
            this.f3838d = this.f3836b.T();
            if (this.f3836b.Z()) {
                this.f3893l = new a(this);
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.f3838d;
            if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (K2 = this.f3836b.K()) != null && K2.T() == ConstraintWidget.DimensionBehaviour.FIXED) {
                    int x10 = (K2.x() - this.f3836b.P.f()) - this.f3836b.R.f();
                    b(this.f3842h, K2.f3765f.f3842h, this.f3836b.P.f());
                    b(this.f3843i, K2.f3765f.f3843i, -this.f3836b.R.f());
                    this.f3839e.d(x10);
                    return;
                } else if (this.f3838d == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.f3839e.d(this.f3836b.x());
                }
            }
        } else if (this.f3838d == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (K = this.f3836b.K()) != null && K.T() == ConstraintWidget.DimensionBehaviour.FIXED) {
            b(this.f3842h, K.f3765f.f3842h, this.f3836b.P.f());
            b(this.f3843i, K.f3765f.f3843i, -this.f3836b.R.f());
            return;
        }
        e eVar = this.f3839e;
        boolean z10 = eVar.f3823j;
        if (z10) {
            ConstraintWidget constraintWidget2 = this.f3836b;
            if (constraintWidget2.f3755a) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.W;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[2];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.f3740f;
                if (constraintAnchor2 != null && constraintAnchorArr[3].f3740f != null) {
                    if (constraintWidget2.k0()) {
                        this.f3842h.f3819f = this.f3836b.W[2].f();
                        this.f3843i.f3819f = -this.f3836b.W[3].f();
                    } else {
                        DependencyNode h10 = h(this.f3836b.W[2]);
                        if (h10 != null) {
                            b(this.f3842h, h10, this.f3836b.W[2].f());
                        }
                        DependencyNode h11 = h(this.f3836b.W[3]);
                        if (h11 != null) {
                            b(this.f3843i, h11, -this.f3836b.W[3].f());
                        }
                        this.f3842h.f3815b = true;
                        this.f3843i.f3815b = true;
                    }
                    if (this.f3836b.Z()) {
                        b(this.f3892k, this.f3842h, this.f3836b.p());
                        return;
                    }
                    return;
                } else if (constraintAnchor2 != null) {
                    DependencyNode h12 = h(constraintAnchor);
                    if (h12 != null) {
                        b(this.f3842h, h12, this.f3836b.W[2].f());
                        b(this.f3843i, this.f3842h, this.f3839e.f3820g);
                        if (this.f3836b.Z()) {
                            b(this.f3892k, this.f3842h, this.f3836b.p());
                            return;
                        }
                        return;
                    }
                    return;
                } else {
                    ConstraintAnchor constraintAnchor3 = constraintAnchorArr[3];
                    if (constraintAnchor3.f3740f != null) {
                        DependencyNode h13 = h(constraintAnchor3);
                        if (h13 != null) {
                            b(this.f3843i, h13, -this.f3836b.W[3].f());
                            b(this.f3842h, this.f3843i, -this.f3839e.f3820g);
                        }
                        if (this.f3836b.Z()) {
                            b(this.f3892k, this.f3842h, this.f3836b.p());
                            return;
                        }
                        return;
                    }
                    ConstraintAnchor constraintAnchor4 = constraintAnchorArr[4];
                    if (constraintAnchor4.f3740f != null) {
                        DependencyNode h14 = h(constraintAnchor4);
                        if (h14 != null) {
                            b(this.f3892k, h14, 0);
                            b(this.f3842h, this.f3892k, -this.f3836b.p());
                            b(this.f3843i, this.f3842h, this.f3839e.f3820g);
                            return;
                        }
                        return;
                    } else if (!(constraintWidget2 instanceof p0.a) && constraintWidget2.K() != null && this.f3836b.o(ConstraintAnchor.Type.CENTER).f3740f == null) {
                        b(this.f3842h, this.f3836b.K().f3765f.f3842h, this.f3836b.Y());
                        b(this.f3843i, this.f3842h, this.f3839e.f3820g);
                        if (this.f3836b.Z()) {
                            b(this.f3892k, this.f3842h, this.f3836b.p());
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
            }
        }
        if (z10 || this.f3838d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            eVar.b(this);
        } else {
            ConstraintWidget constraintWidget3 = this.f3836b;
            int i10 = constraintWidget3.f3801x;
            if (i10 == 2) {
                ConstraintWidget K3 = constraintWidget3.K();
                if (K3 != null) {
                    e eVar2 = K3.f3765f.f3839e;
                    this.f3839e.f3825l.add(eVar2);
                    eVar2.f3824k.add(this.f3839e);
                    e eVar3 = this.f3839e;
                    eVar3.f3815b = true;
                    eVar3.f3824k.add(this.f3842h);
                    this.f3839e.f3824k.add(this.f3843i);
                }
            } else if (i10 == 3 && !constraintWidget3.k0()) {
                ConstraintWidget constraintWidget4 = this.f3836b;
                if (constraintWidget4.f3799w != 3) {
                    e eVar4 = constraintWidget4.f3763e.f3839e;
                    this.f3839e.f3825l.add(eVar4);
                    eVar4.f3824k.add(this.f3839e);
                    e eVar5 = this.f3839e;
                    eVar5.f3815b = true;
                    eVar5.f3824k.add(this.f3842h);
                    this.f3839e.f3824k.add(this.f3843i);
                }
            }
        }
        ConstraintWidget constraintWidget5 = this.f3836b;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget5.W;
        ConstraintAnchor constraintAnchor5 = constraintAnchorArr2[2];
        ConstraintAnchor constraintAnchor6 = constraintAnchor5.f3740f;
        if (constraintAnchor6 != null && constraintAnchorArr2[3].f3740f != null) {
            if (constraintWidget5.k0()) {
                this.f3842h.f3819f = this.f3836b.W[2].f();
                this.f3843i.f3819f = -this.f3836b.W[3].f();
            } else {
                DependencyNode h15 = h(this.f3836b.W[2]);
                DependencyNode h16 = h(this.f3836b.W[3]);
                if (h15 != null) {
                    h15.b(this);
                }
                if (h16 != null) {
                    h16.b(this);
                }
                this.f3844j = WidgetRun.RunType.CENTER;
            }
            if (this.f3836b.Z()) {
                c(this.f3892k, this.f3842h, 1, this.f3893l);
            }
        } else if (constraintAnchor6 != null) {
            DependencyNode h17 = h(constraintAnchor5);
            if (h17 != null) {
                b(this.f3842h, h17, this.f3836b.W[2].f());
                c(this.f3843i, this.f3842h, 1, this.f3839e);
                if (this.f3836b.Z()) {
                    c(this.f3892k, this.f3842h, 1, this.f3893l);
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.f3838d;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour2 == dimensionBehaviour3 && this.f3836b.v() > 0.0f) {
                    j jVar = this.f3836b.f3763e;
                    if (jVar.f3838d == dimensionBehaviour3) {
                        jVar.f3839e.f3824k.add(this.f3839e);
                        this.f3839e.f3825l.add(this.f3836b.f3763e.f3839e);
                        this.f3839e.f3814a = this;
                    }
                }
            }
        } else {
            ConstraintAnchor constraintAnchor7 = constraintAnchorArr2[3];
            if (constraintAnchor7.f3740f != null) {
                DependencyNode h18 = h(constraintAnchor7);
                if (h18 != null) {
                    b(this.f3843i, h18, -this.f3836b.W[3].f());
                    c(this.f3842h, this.f3843i, -1, this.f3839e);
                    if (this.f3836b.Z()) {
                        c(this.f3892k, this.f3842h, 1, this.f3893l);
                    }
                }
            } else {
                ConstraintAnchor constraintAnchor8 = constraintAnchorArr2[4];
                if (constraintAnchor8.f3740f != null) {
                    DependencyNode h19 = h(constraintAnchor8);
                    if (h19 != null) {
                        b(this.f3892k, h19, 0);
                        c(this.f3842h, this.f3892k, -1, this.f3893l);
                        c(this.f3843i, this.f3842h, 1, this.f3839e);
                    }
                } else if (!(constraintWidget5 instanceof p0.a) && constraintWidget5.K() != null) {
                    b(this.f3842h, this.f3836b.K().f3765f.f3842h, this.f3836b.Y());
                    c(this.f3843i, this.f3842h, 1, this.f3839e);
                    if (this.f3836b.Z()) {
                        c(this.f3892k, this.f3842h, 1, this.f3893l);
                    }
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = this.f3838d;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour4 == dimensionBehaviour5 && this.f3836b.v() > 0.0f) {
                        j jVar2 = this.f3836b.f3763e;
                        if (jVar2.f3838d == dimensionBehaviour5) {
                            jVar2.f3839e.f3824k.add(this.f3839e);
                            this.f3839e.f3825l.add(this.f3836b.f3763e.f3839e);
                            this.f3839e.f3814a = this;
                        }
                    }
                }
            }
        }
        if (this.f3839e.f3825l.size() == 0) {
            this.f3839e.f3816c = true;
        }
    }

    public void e() {
        DependencyNode dependencyNode = this.f3842h;
        if (dependencyNode.f3823j) {
            this.f3836b.n1(dependencyNode.f3820g);
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f3837c = null;
        this.f3842h.c();
        this.f3843i.c();
        this.f3892k.c();
        this.f3839e.c();
        this.f3841g = false;
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        if (this.f3838d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.f3836b.f3801x == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void q() {
        this.f3841g = false;
        this.f3842h.c();
        this.f3842h.f3823j = false;
        this.f3843i.c();
        this.f3843i.f3823j = false;
        this.f3892k.c();
        this.f3892k.f3823j = false;
        this.f3839e.f3823j = false;
    }

    public String toString() {
        return "VerticalRun " + this.f3836b.t();
    }
}
