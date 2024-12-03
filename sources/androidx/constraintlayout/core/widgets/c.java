package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

public class c {

    /* renamed from: a  reason: collision with root package name */
    protected ConstraintWidget f3910a;

    /* renamed from: b  reason: collision with root package name */
    protected ConstraintWidget f3911b;

    /* renamed from: c  reason: collision with root package name */
    protected ConstraintWidget f3912c;

    /* renamed from: d  reason: collision with root package name */
    protected ConstraintWidget f3913d;

    /* renamed from: e  reason: collision with root package name */
    protected ConstraintWidget f3914e;

    /* renamed from: f  reason: collision with root package name */
    protected ConstraintWidget f3915f;

    /* renamed from: g  reason: collision with root package name */
    protected ConstraintWidget f3916g;

    /* renamed from: h  reason: collision with root package name */
    protected ArrayList<ConstraintWidget> f3917h;

    /* renamed from: i  reason: collision with root package name */
    protected int f3918i;

    /* renamed from: j  reason: collision with root package name */
    protected int f3919j;

    /* renamed from: k  reason: collision with root package name */
    protected float f3920k = 0.0f;

    /* renamed from: l  reason: collision with root package name */
    int f3921l;

    /* renamed from: m  reason: collision with root package name */
    int f3922m;

    /* renamed from: n  reason: collision with root package name */
    int f3923n;

    /* renamed from: o  reason: collision with root package name */
    boolean f3924o;

    /* renamed from: p  reason: collision with root package name */
    private int f3925p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f3926q;

    /* renamed from: r  reason: collision with root package name */
    protected boolean f3927r;

    /* renamed from: s  reason: collision with root package name */
    protected boolean f3928s;

    /* renamed from: t  reason: collision with root package name */
    protected boolean f3929t;

    /* renamed from: u  reason: collision with root package name */
    protected boolean f3930u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f3931v;

    public c(ConstraintWidget constraintWidget, int i10, boolean z10) {
        this.f3910a = constraintWidget;
        this.f3925p = i10;
        this.f3926q = z10;
    }

    private void b() {
        int i10 = this.f3925p * 2;
        ConstraintWidget constraintWidget = this.f3910a;
        boolean z10 = true;
        this.f3924o = true;
        ConstraintWidget constraintWidget2 = constraintWidget;
        boolean z11 = false;
        while (!z11) {
            this.f3918i++;
            ConstraintWidget[] constraintWidgetArr = constraintWidget.F0;
            int i11 = this.f3925p;
            ConstraintWidget constraintWidget3 = null;
            constraintWidgetArr[i11] = null;
            constraintWidget.E0[i11] = null;
            if (constraintWidget.V() != 8) {
                this.f3921l++;
                ConstraintWidget.DimensionBehaviour u10 = constraintWidget.u(this.f3925p);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (u10 != dimensionBehaviour) {
                    this.f3922m += constraintWidget.E(this.f3925p);
                }
                int f10 = this.f3922m + constraintWidget.W[i10].f();
                this.f3922m = f10;
                int i12 = i10 + 1;
                this.f3922m = f10 + constraintWidget.W[i12].f();
                int f11 = this.f3923n + constraintWidget.W[i10].f();
                this.f3923n = f11;
                this.f3923n = f11 + constraintWidget.W[i12].f();
                if (this.f3911b == null) {
                    this.f3911b = constraintWidget;
                }
                this.f3913d = constraintWidget;
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.Z;
                int i13 = this.f3925p;
                if (dimensionBehaviourArr[i13] == dimensionBehaviour) {
                    int i14 = constraintWidget.f3803y[i13];
                    if (i14 == 0 || i14 == 3 || i14 == 2) {
                        this.f3919j++;
                        float f12 = constraintWidget.D0[i13];
                        if (f12 > 0.0f) {
                            this.f3920k += f12;
                        }
                        if (c(constraintWidget, i13)) {
                            if (f12 < 0.0f) {
                                this.f3927r = true;
                            } else {
                                this.f3928s = true;
                            }
                            if (this.f3917h == null) {
                                this.f3917h = new ArrayList<>();
                            }
                            this.f3917h.add(constraintWidget);
                        }
                        if (this.f3915f == null) {
                            this.f3915f = constraintWidget;
                        }
                        ConstraintWidget constraintWidget4 = this.f3916g;
                        if (constraintWidget4 != null) {
                            constraintWidget4.E0[this.f3925p] = constraintWidget;
                        }
                        this.f3916g = constraintWidget;
                    }
                    if (this.f3925p == 0) {
                        if (constraintWidget.f3799w != 0) {
                            this.f3924o = false;
                        } else if (!(constraintWidget.f3805z == 0 && constraintWidget.A == 0)) {
                            this.f3924o = false;
                        }
                    } else if (constraintWidget.f3801x != 0) {
                        this.f3924o = false;
                    } else if (!(constraintWidget.C == 0 && constraintWidget.D == 0)) {
                        this.f3924o = false;
                    }
                    if (constraintWidget.f3762d0 != 0.0f) {
                        this.f3924o = false;
                        this.f3930u = true;
                    }
                }
            }
            if (constraintWidget2 != constraintWidget) {
                constraintWidget2.F0[this.f3925p] = constraintWidget;
            }
            ConstraintAnchor constraintAnchor = constraintWidget.W[i10 + 1].f3740f;
            if (constraintAnchor != null) {
                ConstraintWidget constraintWidget5 = constraintAnchor.f3738d;
                ConstraintAnchor constraintAnchor2 = constraintWidget5.W[i10].f3740f;
                if (constraintAnchor2 != null && constraintAnchor2.f3738d == constraintWidget) {
                    constraintWidget3 = constraintWidget5;
                }
            }
            if (constraintWidget3 == null) {
                constraintWidget3 = constraintWidget;
                z11 = true;
            }
            constraintWidget2 = constraintWidget;
            constraintWidget = constraintWidget3;
        }
        ConstraintWidget constraintWidget6 = this.f3911b;
        if (constraintWidget6 != null) {
            this.f3922m -= constraintWidget6.W[i10].f();
        }
        ConstraintWidget constraintWidget7 = this.f3913d;
        if (constraintWidget7 != null) {
            this.f3922m -= constraintWidget7.W[i10 + 1].f();
        }
        this.f3912c = constraintWidget;
        if (this.f3925p != 0 || !this.f3926q) {
            this.f3914e = this.f3910a;
        } else {
            this.f3914e = constraintWidget;
        }
        if (!this.f3928s || !this.f3927r) {
            z10 = false;
        }
        this.f3929t = z10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        r2 = r2.f3803y[r3];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean c(androidx.constraintlayout.core.widgets.ConstraintWidget r2, int r3) {
        /*
            int r0 = r2.V()
            r1 = 8
            if (r0 == r1) goto L_0x001b
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r2.Z
            r0 = r0[r3]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r1) goto L_0x001b
            int[] r2 = r2.f3803y
            r2 = r2[r3]
            if (r2 == 0) goto L_0x0019
            r3 = 3
            if (r2 != r3) goto L_0x001b
        L_0x0019:
            r2 = 1
            goto L_0x001c
        L_0x001b:
            r2 = 0
        L_0x001c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.c.c(androidx.constraintlayout.core.widgets.ConstraintWidget, int):boolean");
    }

    public void a() {
        if (!this.f3931v) {
            b();
        }
        this.f3931v = true;
    }
}
