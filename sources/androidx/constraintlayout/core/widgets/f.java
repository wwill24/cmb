package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.d;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

public class f extends ConstraintWidget {
    protected float L0 = -1.0f;
    protected int M0 = -1;
    protected int N0 = -1;
    protected boolean O0 = true;
    private ConstraintAnchor P0 = this.P;
    private int Q0;
    private int R0;
    private boolean S0;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3991a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type[] r0 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3991a = r0
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3991a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3991a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f3991a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f3991a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BASELINE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f3991a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f3991a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER_X     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f3991a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER_Y     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f3991a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.NONE     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.f.a.<clinit>():void");
        }
    }

    public f() {
        this.Q0 = 0;
        this.R0 = 0;
        this.X.clear();
        this.X.add(this.P0);
        int length = this.W.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.W[i10] = this.P0;
        }
    }

    public void A1(int i10) {
        if (this.Q0 != i10) {
            this.Q0 = i10;
            this.X.clear();
            if (this.Q0 == 1) {
                this.P0 = this.O;
            } else {
                this.P0 = this.P;
            }
            this.X.add(this.P0);
            int length = this.W.length;
            for (int i11 = 0; i11 < length; i11++) {
                this.W[i11] = this.P0;
            }
        }
    }

    public void g(d dVar, boolean z10) {
        boolean z11;
        d dVar2 = (d) K();
        if (dVar2 != null) {
            ConstraintAnchor o10 = dVar2.o(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor o11 = dVar2.o(ConstraintAnchor.Type.RIGHT);
            ConstraintWidget constraintWidget = this.f3756a0;
            boolean z12 = true;
            if (constraintWidget == null || constraintWidget.Z[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (this.Q0 == 0) {
                o10 = dVar2.o(ConstraintAnchor.Type.TOP);
                o11 = dVar2.o(ConstraintAnchor.Type.BOTTOM);
                ConstraintWidget constraintWidget2 = this.f3756a0;
                if (constraintWidget2 == null || constraintWidget2.Z[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    z12 = false;
                }
                z11 = z12;
            }
            if (this.S0 && this.P0.n()) {
                SolverVariable q10 = dVar.q(this.P0);
                dVar.f(q10, this.P0.e());
                if (this.M0 != -1) {
                    if (z11) {
                        dVar.h(dVar.q(o11), q10, 0, 5);
                    }
                } else if (this.N0 != -1 && z11) {
                    SolverVariable q11 = dVar.q(o11);
                    dVar.h(q10, dVar.q(o10), 0, 5);
                    dVar.h(q11, q10, 0, 5);
                }
                this.S0 = false;
            } else if (this.M0 != -1) {
                SolverVariable q12 = dVar.q(this.P0);
                dVar.e(q12, dVar.q(o10), this.M0, 8);
                if (z11) {
                    dVar.h(dVar.q(o11), q12, 0, 5);
                }
            } else if (this.N0 != -1) {
                SolverVariable q13 = dVar.q(this.P0);
                SolverVariable q14 = dVar.q(o11);
                dVar.e(q13, q14, -this.N0, 8);
                if (z11) {
                    dVar.h(q13, dVar.q(o10), 0, 5);
                    dVar.h(q14, q13, 0, 5);
                }
            } else if (this.L0 != -1.0f) {
                dVar.d(d.s(dVar, dVar.q(this.P0), dVar.q(o11), this.L0));
            }
        }
    }

    public boolean h() {
        return true;
    }

    public boolean n0() {
        return this.S0;
    }

    public ConstraintAnchor o(ConstraintAnchor.Type type) {
        int i10 = a.f3991a[type.ordinal()];
        if (i10 == 1 || i10 == 2) {
            if (this.Q0 == 1) {
                return this.P0;
            }
            return null;
        } else if ((i10 == 3 || i10 == 4) && this.Q0 == 0) {
            return this.P0;
        } else {
            return null;
        }
    }

    public boolean o0() {
        return this.S0;
    }

    public void q1(d dVar, boolean z10) {
        if (K() != null) {
            int x10 = dVar.x(this.P0);
            if (this.Q0 == 1) {
                m1(x10);
                n1(0);
                L0(K().x());
                k1(0);
                return;
            }
            m1(0);
            n1(x10);
            k1(K().W());
            L0(0);
        }
    }

    public ConstraintAnchor r1() {
        return this.P0;
    }

    public int s1() {
        return this.Q0;
    }

    public int t1() {
        return this.M0;
    }

    public int u1() {
        return this.N0;
    }

    public float v1() {
        return this.L0;
    }

    public void w1(int i10) {
        this.P0.t(i10);
        this.S0 = true;
    }

    public void x1(int i10) {
        if (i10 > -1) {
            this.L0 = -1.0f;
            this.M0 = i10;
            this.N0 = -1;
        }
    }

    public void y1(int i10) {
        if (i10 > -1) {
            this.L0 = -1.0f;
            this.M0 = -1;
            this.N0 = i10;
        }
    }

    public void z1(float f10) {
        if (f10 > -1.0f) {
            this.L0 = f10;
            this.M0 = -1;
            this.N0 = -1;
        }
    }
}
