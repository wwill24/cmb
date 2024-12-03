package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.d;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.c;
import androidx.constraintlayout.core.widgets.analyzer.j;
import androidx.constraintlayout.core.widgets.analyzer.l;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.api.a;
import com.mparticle.kits.AppsFlyerKit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class ConstraintWidget {
    public static float K0 = 0.5f;
    public int A = 0;
    int A0;
    public float B = 1.0f;
    boolean B0;
    public int C = 0;
    boolean C0;
    public int D = 0;
    public float[] D0;
    public float E = 1.0f;
    protected ConstraintWidget[] E0;
    int F = -1;
    protected ConstraintWidget[] F0;
    float G = 1.0f;
    ConstraintWidget G0;
    private int[] H = {a.e.API_PRIORITY_OTHER, a.e.API_PRIORITY_OTHER};
    ConstraintWidget H0;
    private float I = 0.0f;
    public int I0;
    private boolean J = false;
    public int J0;
    private boolean K;
    private boolean L = false;
    private int M = 0;
    private int N = 0;
    public ConstraintAnchor O = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
    public ConstraintAnchor P = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
    public ConstraintAnchor Q = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
    public ConstraintAnchor R = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
    public ConstraintAnchor S = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
    ConstraintAnchor T = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
    ConstraintAnchor U = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
    public ConstraintAnchor V;
    public ConstraintAnchor[] W;
    protected ArrayList<ConstraintAnchor> X;
    private boolean[] Y;
    public DimensionBehaviour[] Z;

    /* renamed from: a  reason: collision with root package name */
    public boolean f3755a = false;

    /* renamed from: a0  reason: collision with root package name */
    public ConstraintWidget f3756a0;

    /* renamed from: b  reason: collision with root package name */
    public WidgetRun[] f3757b = new WidgetRun[2];

    /* renamed from: b0  reason: collision with root package name */
    int f3758b0;

    /* renamed from: c  reason: collision with root package name */
    public c f3759c;

    /* renamed from: c0  reason: collision with root package name */
    int f3760c0;

    /* renamed from: d  reason: collision with root package name */
    public c f3761d;

    /* renamed from: d0  reason: collision with root package name */
    public float f3762d0;

    /* renamed from: e  reason: collision with root package name */
    public j f3763e = null;

    /* renamed from: e0  reason: collision with root package name */
    protected int f3764e0;

    /* renamed from: f  reason: collision with root package name */
    public l f3765f = null;

    /* renamed from: f0  reason: collision with root package name */
    protected int f3766f0;

    /* renamed from: g  reason: collision with root package name */
    public boolean[] f3767g = {true, true};

    /* renamed from: g0  reason: collision with root package name */
    protected int f3768g0;

    /* renamed from: h  reason: collision with root package name */
    boolean f3769h = false;

    /* renamed from: h0  reason: collision with root package name */
    int f3770h0;

    /* renamed from: i  reason: collision with root package name */
    private boolean f3771i = true;

    /* renamed from: i0  reason: collision with root package name */
    int f3772i0;

    /* renamed from: j  reason: collision with root package name */
    private boolean f3773j = false;

    /* renamed from: j0  reason: collision with root package name */
    protected int f3774j0;

    /* renamed from: k  reason: collision with root package name */
    private boolean f3775k = true;

    /* renamed from: k0  reason: collision with root package name */
    protected int f3776k0;

    /* renamed from: l  reason: collision with root package name */
    private int f3777l = -1;

    /* renamed from: l0  reason: collision with root package name */
    int f3778l0;

    /* renamed from: m  reason: collision with root package name */
    private int f3779m = -1;

    /* renamed from: m0  reason: collision with root package name */
    protected int f3780m0;

    /* renamed from: n  reason: collision with root package name */
    public o0.a f3781n = new o0.a(this);

    /* renamed from: n0  reason: collision with root package name */
    protected int f3782n0;

    /* renamed from: o  reason: collision with root package name */
    public String f3783o;

    /* renamed from: o0  reason: collision with root package name */
    float f3784o0;

    /* renamed from: p  reason: collision with root package name */
    private boolean f3785p = false;

    /* renamed from: p0  reason: collision with root package name */
    float f3786p0;

    /* renamed from: q  reason: collision with root package name */
    private boolean f3787q = false;

    /* renamed from: q0  reason: collision with root package name */
    private Object f3788q0;

    /* renamed from: r  reason: collision with root package name */
    private boolean f3789r = false;

    /* renamed from: r0  reason: collision with root package name */
    private int f3790r0;

    /* renamed from: s  reason: collision with root package name */
    private boolean f3791s = false;

    /* renamed from: s0  reason: collision with root package name */
    private int f3792s0;

    /* renamed from: t  reason: collision with root package name */
    public int f3793t = -1;

    /* renamed from: t0  reason: collision with root package name */
    private boolean f3794t0;

    /* renamed from: u  reason: collision with root package name */
    public int f3795u = -1;

    /* renamed from: u0  reason: collision with root package name */
    private String f3796u0;

    /* renamed from: v  reason: collision with root package name */
    private int f3797v = 0;

    /* renamed from: v0  reason: collision with root package name */
    private String f3798v0;

    /* renamed from: w  reason: collision with root package name */
    public int f3799w = 0;

    /* renamed from: w0  reason: collision with root package name */
    boolean f3800w0;

    /* renamed from: x  reason: collision with root package name */
    public int f3801x = 0;

    /* renamed from: x0  reason: collision with root package name */
    boolean f3802x0;

    /* renamed from: y  reason: collision with root package name */
    public int[] f3803y = new int[2];

    /* renamed from: y0  reason: collision with root package name */
    boolean f3804y0;

    /* renamed from: z  reason: collision with root package name */
    public int f3805z = 0;

    /* renamed from: z0  reason: collision with root package name */
    int f3806z0;

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3812a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f3813b;

        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(31:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0083 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x008f */
        static {
            /*
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3813b = r0
                r1 = 1
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f3813b     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f3813b     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f3813b     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type[] r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f3812a = r4
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = f3812a     // Catch:{ NoSuchFieldError -> 0x004e }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = f3812a     // Catch:{ NoSuchFieldError -> 0x0058 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = f3812a     // Catch:{ NoSuchFieldError -> 0x0062 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = f3812a     // Catch:{ NoSuchFieldError -> 0x006d }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BASELINE     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r0 = f3812a     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f3812a     // Catch:{ NoSuchFieldError -> 0x0083 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER_X     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                int[] r0 = f3812a     // Catch:{ NoSuchFieldError -> 0x008f }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER_Y     // Catch:{ NoSuchFieldError -> 0x008f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008f }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008f }
            L_0x008f:
                int[] r0 = f3812a     // Catch:{ NoSuchFieldError -> 0x009b }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.NONE     // Catch:{ NoSuchFieldError -> 0x009b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009b }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009b }
            L_0x009b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.a.<clinit>():void");
        }
    }

    public ConstraintWidget() {
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.V = constraintAnchor;
        this.W = new ConstraintAnchor[]{this.O, this.Q, this.P, this.R, this.S, constraintAnchor};
        this.X = new ArrayList<>();
        this.Y = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.Z = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.f3756a0 = null;
        this.f3758b0 = 0;
        this.f3760c0 = 0;
        this.f3762d0 = 0.0f;
        this.f3764e0 = -1;
        this.f3766f0 = 0;
        this.f3768g0 = 0;
        this.f3770h0 = 0;
        this.f3772i0 = 0;
        this.f3774j0 = 0;
        this.f3776k0 = 0;
        this.f3778l0 = 0;
        float f10 = K0;
        this.f3784o0 = f10;
        this.f3786p0 = f10;
        this.f3790r0 = 0;
        this.f3792s0 = 0;
        this.f3794t0 = false;
        this.f3796u0 = null;
        this.f3798v0 = null;
        this.f3804y0 = false;
        this.f3806z0 = 0;
        this.A0 = 0;
        this.D0 = new float[]{-1.0f, -1.0f};
        this.E0 = new ConstraintWidget[]{null, null};
        this.F0 = new ConstraintWidget[]{null, null};
        this.G0 = null;
        this.H0 = null;
        this.I0 = -1;
        this.J0 = -1;
        d();
    }

    private void P(StringBuilder sb2, String str, int i10, int i11, int i12, int i13, int i14, int i15, float f10, float f11) {
        sb2.append(str);
        sb2.append(" :  {\n");
        y0(sb2, "      size", i10, 0);
        y0(sb2, "      min", i11, 0);
        y0(sb2, "      max", i12, a.e.API_PRIORITY_OTHER);
        y0(sb2, "      matchMin", i14, 0);
        y0(sb2, "      matchDef", i15, 0);
        x0(sb2, "      matchPercent", f10, 1.0f);
        sb2.append("    },\n");
    }

    private void Q(StringBuilder sb2, String str, ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.f3740f != null) {
            sb2.append("    ");
            sb2.append(str);
            sb2.append(" : [ '");
            sb2.append(constraintAnchor.f3740f);
            sb2.append("'");
            if (!(constraintAnchor.f3742h == Integer.MIN_VALUE && constraintAnchor.f3741g == 0)) {
                sb2.append(AppsFlyerKit.COMMA);
                sb2.append(constraintAnchor.f3741g);
                if (constraintAnchor.f3742h != Integer.MIN_VALUE) {
                    sb2.append(AppsFlyerKit.COMMA);
                    sb2.append(constraintAnchor.f3742h);
                    sb2.append(AppsFlyerKit.COMMA);
                }
            }
            sb2.append(" ] ,\n");
        }
    }

    private void d() {
        this.X.add(this.O);
        this.X.add(this.P);
        this.X.add(this.Q);
        this.X.add(this.R);
        this.X.add(this.T);
        this.X.add(this.U);
        this.X.add(this.V);
        this.X.add(this.S);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
        r5 = r0[r5 + 1];
        r0 = r5.f3740f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean f0(int r5) {
        /*
            r4 = this;
            int r5 = r5 * 2
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r4.W
            r1 = r0[r5]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r1.f3740f
            r3 = 1
            if (r2 == 0) goto L_0x001b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.f3740f
            if (r2 == r1) goto L_0x001b
            int r5 = r5 + r3
            r5 = r0[r5]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r5.f3740f
            if (r0 == 0) goto L_0x001b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.f3740f
            if (r0 != r5) goto L_0x001b
            goto L_0x001c
        L_0x001b:
            r3 = 0
        L_0x001c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.f0(int):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:260:0x049c, code lost:
        if ((r4 instanceof androidx.constraintlayout.core.widgets.a) != false) goto L_0x04a1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01e8 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x0340  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x0344  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x0422  */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x0469  */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x0487 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x0488  */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x04e2  */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x052d  */
    /* JADX WARNING: Removed duplicated region for block: B:323:0x054b  */
    /* JADX WARNING: Removed duplicated region for block: B:324:0x0550  */
    /* JADX WARNING: Removed duplicated region for block: B:328:0x055b A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:347:0x0592 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:375:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:379:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void i(androidx.constraintlayout.core.d r38, boolean r39, boolean r40, boolean r41, boolean r42, androidx.constraintlayout.core.SolverVariable r43, androidx.constraintlayout.core.SolverVariable r44, androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour r45, boolean r46, androidx.constraintlayout.core.widgets.ConstraintAnchor r47, androidx.constraintlayout.core.widgets.ConstraintAnchor r48, int r49, int r50, int r51, int r52, float r53, boolean r54, boolean r55, boolean r56, boolean r57, boolean r58, int r59, int r60, int r61, int r62, float r63, boolean r64) {
        /*
            r37 = this;
            r0 = r37
            r10 = r38
            r11 = r43
            r12 = r44
            r13 = r47
            r14 = r48
            r15 = r51
            r1 = r52
            r2 = r60
            r3 = r61
            r4 = r62
            androidx.constraintlayout.core.SolverVariable r9 = r10.q(r13)
            androidx.constraintlayout.core.SolverVariable r8 = r10.q(r14)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r47.j()
            androidx.constraintlayout.core.SolverVariable r7 = r10.q(r5)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r48.j()
            androidx.constraintlayout.core.SolverVariable r6 = r10.q(r5)
            androidx.constraintlayout.core.d.w()
            boolean r16 = r47.o()
            boolean r17 = r48.o()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r0.V
            boolean r18 = r5.o()
            if (r17 == 0) goto L_0x0044
            int r5 = r16 + 1
            goto L_0x0046
        L_0x0044:
            r5 = r16
        L_0x0046:
            if (r18 == 0) goto L_0x004a
            int r5 = r5 + 1
        L_0x004a:
            if (r54 == 0) goto L_0x004f
            r19 = 3
            goto L_0x0051
        L_0x004f:
            r19 = r59
        L_0x0051:
            int[] r20 = androidx.constraintlayout.core.widgets.ConstraintWidget.a.f3813b
            int r21 = r45.ordinal()
            r12 = r20[r21]
            r2 = 1
            if (r12 == r2) goto L_0x0065
            r2 = 2
            if (r12 == r2) goto L_0x0065
            r2 = 3
            if (r12 == r2) goto L_0x0065
            r2 = 4
            if (r12 == r2) goto L_0x006a
        L_0x0065:
            r12 = r19
        L_0x0067:
            r19 = 0
            goto L_0x0070
        L_0x006a:
            r12 = r19
            if (r12 == r2) goto L_0x0067
            r19 = 1
        L_0x0070:
            int r2 = r0.f3777l
            r14 = -1
            if (r2 == r14) goto L_0x007d
            if (r39 == 0) goto L_0x007d
            r0.f3777l = r14
            r50 = r2
            r19 = 0
        L_0x007d:
            int r2 = r0.f3779m
            if (r2 == r14) goto L_0x0088
            if (r39 != 0) goto L_0x0088
            r0.f3779m = r14
            r19 = 0
            goto L_0x008a
        L_0x0088:
            r2 = r50
        L_0x008a:
            int r14 = r0.f3792s0
            r50 = r2
            r2 = 8
            if (r14 != r2) goto L_0x0096
            r14 = 0
            r19 = 0
            goto L_0x0098
        L_0x0096:
            r14 = r50
        L_0x0098:
            if (r64 == 0) goto L_0x00bb
            if (r16 != 0) goto L_0x00a6
            if (r17 != 0) goto L_0x00a6
            if (r18 != 0) goto L_0x00a6
            r2 = r49
            r10.f(r9, r2)
            goto L_0x00b6
        L_0x00a6:
            if (r16 == 0) goto L_0x00b6
            if (r17 != 0) goto L_0x00b6
            int r2 = r47.f()
            r24 = r6
            r6 = 8
            r10.e(r9, r7, r2, r6)
            goto L_0x00be
        L_0x00b6:
            r24 = r6
            r6 = 8
            goto L_0x00be
        L_0x00bb:
            r24 = r6
            r6 = r2
        L_0x00be:
            if (r19 != 0) goto L_0x00e8
            if (r46 == 0) goto L_0x00d7
            r2 = 3
            r6 = 0
            r10.e(r8, r9, r6, r2)
            r2 = 8
            if (r15 <= 0) goto L_0x00ce
            r10.h(r8, r9, r15, r2)
        L_0x00ce:
            r6 = 2147483647(0x7fffffff, float:NaN)
            if (r1 >= r6) goto L_0x00db
            r10.j(r8, r9, r1, r2)
            goto L_0x00db
        L_0x00d7:
            r2 = r6
            r10.e(r8, r9, r14, r2)
        L_0x00db:
            r1 = r5
            r2 = r7
            r14 = r8
            r25 = r19
            r15 = r24
            r19 = r42
        L_0x00e4:
            r24 = r3
            goto L_0x01e6
        L_0x00e8:
            r1 = 2
            if (r5 == r1) goto L_0x010b
            if (r54 != 0) goto L_0x010b
            r1 = 1
            if (r12 == r1) goto L_0x00f2
            if (r12 != 0) goto L_0x010b
        L_0x00f2:
            int r1 = java.lang.Math.max(r3, r14)
            if (r4 <= 0) goto L_0x00fc
            int r1 = java.lang.Math.min(r4, r1)
        L_0x00fc:
            r2 = 8
            r10.e(r8, r9, r1, r2)
            r19 = r42
            r1 = r5
            r2 = r7
            r14 = r8
            r15 = r24
            r25 = 0
            goto L_0x00e4
        L_0x010b:
            r1 = -2
            if (r3 != r1) goto L_0x0110
            r2 = r14
            goto L_0x0111
        L_0x0110:
            r2 = r3
        L_0x0111:
            if (r4 != r1) goto L_0x0115
            r1 = r14
            goto L_0x0116
        L_0x0115:
            r1 = r4
        L_0x0116:
            if (r14 <= 0) goto L_0x011c
            r3 = 1
            if (r12 == r3) goto L_0x011c
            r14 = 0
        L_0x011c:
            if (r2 <= 0) goto L_0x0127
            r3 = 8
            r10.h(r8, r9, r2, r3)
            int r14 = java.lang.Math.max(r14, r2)
        L_0x0127:
            if (r1 <= 0) goto L_0x0140
            if (r40 == 0) goto L_0x0130
            r3 = 1
            if (r12 != r3) goto L_0x0130
            r3 = 0
            goto L_0x0131
        L_0x0130:
            r3 = 1
        L_0x0131:
            if (r3 == 0) goto L_0x0139
            r3 = 8
            r10.j(r8, r9, r1, r3)
            goto L_0x013b
        L_0x0139:
            r3 = 8
        L_0x013b:
            int r14 = java.lang.Math.min(r14, r1)
            goto L_0x0142
        L_0x0140:
            r3 = 8
        L_0x0142:
            r4 = 1
            if (r12 != r4) goto L_0x016a
            if (r40 == 0) goto L_0x014b
            r10.e(r8, r9, r14, r3)
            goto L_0x015c
        L_0x014b:
            if (r56 == 0) goto L_0x0155
            r4 = 5
            r10.e(r8, r9, r14, r4)
            r10.j(r8, r9, r14, r3)
            goto L_0x015c
        L_0x0155:
            r4 = 5
            r10.e(r8, r9, r14, r4)
            r10.j(r8, r9, r14, r3)
        L_0x015c:
            r4 = r1
            r1 = r5
            r14 = r8
            r25 = r19
            r15 = r24
            r19 = r42
            r24 = r2
            r2 = r7
            goto L_0x01e6
        L_0x016a:
            r3 = 2
            if (r12 != r3) goto L_0x01d5
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = r47.k()
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            if (r3 == r4) goto L_0x0197
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = r47.k()
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            if (r3 != r6) goto L_0x017e
            goto L_0x0197
        L_0x017e:
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f3756a0
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.o(r4)
            androidx.constraintlayout.core.SolverVariable r3 = r10.q(r3)
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r0.f3756a0
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.o(r6)
            androidx.constraintlayout.core.SolverVariable r4 = r10.q(r4)
            goto L_0x01ad
        L_0x0197:
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f3756a0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.o(r4)
            androidx.constraintlayout.core.SolverVariable r3 = r10.q(r3)
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r0.f3756a0
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.o(r6)
            androidx.constraintlayout.core.SolverVariable r4 = r10.q(r4)
        L_0x01ad:
            r14 = r3
            r6 = r4
            androidx.constraintlayout.core.b r3 = r38.r()
            r4 = r8
            r46 = r1
            r1 = r5
            r5 = r9
            r15 = r24
            r52 = r2
            r2 = r7
            r7 = r14
            r14 = r8
            r8 = r63
            androidx.constraintlayout.core.b r3 = r3.k(r4, r5, r6, r7, r8)
            r10.d(r3)
            if (r40 == 0) goto L_0x01cc
            r19 = 0
        L_0x01cc:
            r4 = r46
            r24 = r52
            r25 = r19
            r19 = r42
            goto L_0x01e6
        L_0x01d5:
            r46 = r1
            r52 = r2
            r1 = r5
            r2 = r7
            r14 = r8
            r15 = r24
            r4 = r46
            r24 = r52
            r25 = r19
            r19 = 1
        L_0x01e6:
            if (r64 == 0) goto L_0x0587
            if (r56 == 0) goto L_0x01ec
            goto L_0x0587
        L_0x01ec:
            if (r16 != 0) goto L_0x01f7
            if (r17 != 0) goto L_0x01f7
            if (r18 != 0) goto L_0x01f7
        L_0x01f2:
            r2 = r15
            r1 = 5
            r3 = 0
            goto L_0x0557
        L_0x01f7:
            if (r16 == 0) goto L_0x0210
            if (r17 != 0) goto L_0x0210
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r13.f3740f
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r1.f3738d
            if (r40 == 0) goto L_0x0208
            boolean r1 = r1 instanceof androidx.constraintlayout.core.widgets.a
            if (r1 == 0) goto L_0x0208
            r2 = 8
            goto L_0x0209
        L_0x0208:
            r2 = 5
        L_0x0209:
            r20 = r40
            r1 = r2
        L_0x020c:
            r2 = r15
        L_0x020d:
            r3 = 0
            goto L_0x0559
        L_0x0210:
            if (r16 != 0) goto L_0x0240
            if (r17 == 0) goto L_0x0240
            int r1 = r48.f()
            int r1 = -r1
            r2 = 8
            r10.e(r14, r15, r1, r2)
            if (r40 == 0) goto L_0x01f2
            boolean r1 = r0.f3773j
            if (r1 == 0) goto L_0x0238
            boolean r1 = r9.f3644g
            if (r1 == 0) goto L_0x0238
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f3756a0
            if (r1 == 0) goto L_0x0238
            androidx.constraintlayout.core.widgets.d r1 = (androidx.constraintlayout.core.widgets.d) r1
            if (r39 == 0) goto L_0x0234
            r1.z1(r13)
            goto L_0x01f2
        L_0x0234:
            r1.E1(r13)
            goto L_0x01f2
        L_0x0238:
            r1 = 5
            r3 = 0
            r10.h(r9, r11, r3, r1)
            r2 = r15
            goto L_0x0557
        L_0x0240:
            r3 = 0
            if (r16 == 0) goto L_0x0555
            if (r17 == 0) goto L_0x0555
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r13.f3740f
            androidx.constraintlayout.core.widgets.ConstraintWidget r8 = r1.f3738d
            r6 = r48
            r7 = r3
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r6.f3740f
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r1.f3738d
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r37.K()
            r16 = 6
            if (r25 == 0) goto L_0x03bf
            if (r12 != 0) goto L_0x02c0
            if (r4 != 0) goto L_0x0284
            if (r24 != 0) goto L_0x0284
            boolean r1 = r2.f3644g
            if (r1 == 0) goto L_0x0278
            boolean r1 = r15.f3644g
            if (r1 == 0) goto L_0x0278
            int r1 = r47.f()
            r4 = 8
            r10.e(r9, r2, r1, r4)
            int r1 = r48.f()
            int r1 = -r1
            r10.e(r14, r15, r1, r4)
            return
        L_0x0278:
            r4 = 8
            r1 = r4
            r17 = r1
            r18 = r7
            r23 = r18
            r21 = 1
            goto L_0x028f
        L_0x0284:
            r4 = 8
            r21 = r7
            r1 = 5
            r17 = 5
            r18 = 1
            r23 = 1
        L_0x028f:
            boolean r4 = r8 instanceof androidx.constraintlayout.core.widgets.a
            if (r4 != 0) goto L_0x02aa
            boolean r4 = r5 instanceof androidx.constraintlayout.core.widgets.a
            if (r4 == 0) goto L_0x0298
            goto L_0x02aa
        L_0x0298:
            r4 = r44
            r20 = r16
            r22 = r17
            r27 = r18
            r28 = r21
            r26 = r23
            r7 = 1
            r17 = 8
            r18 = 5
            goto L_0x02bb
        L_0x02aa:
            r4 = r44
            r20 = r16
            r27 = r18
            r28 = r21
            r26 = r23
            r7 = 1
            r17 = 8
            r18 = 5
            r22 = 4
        L_0x02bb:
            r23 = r1
            r1 = 3
            goto L_0x0413
        L_0x02c0:
            r1 = 2
            r17 = 8
            if (r12 != r1) goto L_0x02ea
            boolean r1 = r8 instanceof androidx.constraintlayout.core.widgets.a
            if (r1 != 0) goto L_0x02db
            boolean r1 = r5 instanceof androidx.constraintlayout.core.widgets.a
            if (r1 == 0) goto L_0x02ce
            goto L_0x02db
        L_0x02ce:
            r4 = r44
            r28 = r7
            r20 = r16
            r1 = 3
            r7 = 1
            r18 = 5
            r22 = 5
            goto L_0x02e7
        L_0x02db:
            r4 = r44
            r28 = r7
            r20 = r16
            r1 = 3
            r7 = 1
            r18 = 5
            r22 = 4
        L_0x02e7:
            r23 = 5
            goto L_0x02fb
        L_0x02ea:
            r1 = 1
            if (r12 != r1) goto L_0x0301
            r4 = r44
            r28 = r7
            r20 = r16
            r23 = r17
            r1 = 3
            r7 = 1
            r18 = 5
            r22 = 4
        L_0x02fb:
            r26 = 1
            r27 = 1
            goto L_0x0413
        L_0x0301:
            r1 = 3
            if (r12 != r1) goto L_0x03af
            int r1 = r0.F
            r7 = -1
            if (r1 != r7) goto L_0x032f
            if (r57 == 0) goto L_0x031b
            r4 = r44
            r23 = r17
            r1 = 3
            r7 = 1
            r18 = 5
            if (r40 == 0) goto L_0x0318
            r20 = 5
            goto L_0x0325
        L_0x0318:
            r20 = 4
            goto L_0x0325
        L_0x031b:
            r4 = r44
            r20 = r17
            r23 = r20
            r1 = 3
            r7 = 1
            r18 = 5
        L_0x0325:
            r22 = 5
            r26 = 1
            r27 = 1
            r28 = 1
            goto L_0x0413
        L_0x032f:
            if (r54 == 0) goto L_0x0359
            r1 = r60
            r7 = 2
            if (r1 == r7) goto L_0x033c
            r7 = 1
            if (r1 != r7) goto L_0x033a
            goto L_0x033d
        L_0x033a:
            r1 = 0
            goto L_0x033e
        L_0x033c:
            r7 = 1
        L_0x033d:
            r1 = r7
        L_0x033e:
            if (r1 != 0) goto L_0x0344
            r1 = r17
            r4 = 5
            goto L_0x0346
        L_0x0344:
            r1 = 5
            r4 = 4
        L_0x0346:
            r23 = r1
            r22 = r4
            r26 = r7
            r27 = r26
            r28 = r27
            r20 = r16
            r1 = 3
            r18 = 5
            r4 = r44
            goto L_0x0413
        L_0x0359:
            r7 = 1
            if (r4 <= 0) goto L_0x036c
            r4 = r44
            r26 = r7
            r27 = r26
            r28 = r27
            r20 = r16
            r1 = 3
            r18 = 5
            r22 = 5
            goto L_0x03ab
        L_0x036c:
            if (r4 != 0) goto L_0x039c
            if (r24 != 0) goto L_0x039c
            if (r57 != 0) goto L_0x0382
            r4 = r44
            r26 = r7
            r27 = r26
            r28 = r27
            r20 = r16
            r22 = r17
            r1 = 3
            r18 = 5
            goto L_0x03ab
        L_0x0382:
            if (r8 == r3) goto L_0x0388
            if (r5 == r3) goto L_0x0388
            r1 = 4
            goto L_0x0389
        L_0x0388:
            r1 = 5
        L_0x0389:
            r4 = r44
            r23 = r1
            r26 = r7
            r27 = r26
            r28 = r27
            r20 = r16
            r1 = 3
            r18 = 5
            r22 = 4
            goto L_0x0413
        L_0x039c:
            r4 = r44
            r26 = r7
            r27 = r26
            r28 = r27
            r20 = r16
            r1 = 3
            r18 = 5
            r22 = 4
        L_0x03ab:
            r23 = 5
            goto L_0x0413
        L_0x03af:
            r7 = 1
            r4 = r44
            r20 = r16
            r18 = 5
            r22 = 4
            r23 = 5
            r26 = 0
            r27 = 0
            goto L_0x0411
        L_0x03bf:
            r7 = 1
            r17 = 8
            boolean r1 = r2.f3644g
            if (r1 == 0) goto L_0x0402
            boolean r1 = r15.f3644g
            if (r1 == 0) goto L_0x0402
            int r1 = r47.f()
            int r3 = r48.f()
            r4 = 8
            r54 = r38
            r55 = r9
            r56 = r2
            r57 = r1
            r58 = r53
            r59 = r15
            r60 = r14
            r61 = r3
            r62 = r4
            r54.c(r55, r56, r57, r58, r59, r60, r61, r62)
            if (r40 == 0) goto L_0x0401
            if (r19 == 0) goto L_0x0401
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r6.f3740f
            if (r1 == 0) goto L_0x03f8
            int r1 = r48.f()
            r4 = r44
            goto L_0x03fb
        L_0x03f8:
            r4 = r44
            r1 = 0
        L_0x03fb:
            if (r15 == r4) goto L_0x0401
            r2 = 5
            r10.h(r4, r14, r1, r2)
        L_0x0401:
            return
        L_0x0402:
            r4 = r44
            r1 = 3
            r18 = 5
            r26 = r7
            r27 = r26
            r20 = r16
            r23 = r18
            r22 = 4
        L_0x0411:
            r28 = 0
        L_0x0413:
            if (r26 == 0) goto L_0x041e
            if (r2 != r15) goto L_0x041e
            if (r8 == r3) goto L_0x041e
            r26 = 0
            r29 = 0
            goto L_0x0420
        L_0x041e:
            r29 = r7
        L_0x0420:
            if (r27 == 0) goto L_0x0469
            if (r25 != 0) goto L_0x0435
            if (r55 != 0) goto L_0x0435
            if (r57 != 0) goto L_0x0435
            if (r2 != r11) goto L_0x0435
            if (r15 != r4) goto L_0x0435
            r23 = r17
            r27 = r23
            r20 = 0
            r29 = 0
            goto L_0x0439
        L_0x0435:
            r27 = r20
            r20 = r40
        L_0x0439:
            int r30 = r47.f()
            int r31 = r48.f()
            r13 = r1
            r1 = r38
            r42 = r2
            r13 = r17
            r17 = 4
            r36 = r18
            r18 = r7
            r7 = r36
            r2 = r9
            r32 = r3
            r3 = r42
            r4 = r30
            r33 = r5
            r5 = r53
            r6 = r15
            r7 = r14
            r34 = r8
            r8 = r31
            r35 = r9
            r9 = r27
            r1.c(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x047b
        L_0x0469:
            r42 = r2
            r32 = r3
            r33 = r5
            r18 = r7
            r34 = r8
            r35 = r9
            r13 = r17
            r17 = 4
            r20 = r40
        L_0x047b:
            r2 = r29
            int r1 = r0.f3792s0
            if (r1 != r13) goto L_0x0488
            boolean r1 = r48.m()
            if (r1 != 0) goto L_0x0488
            return
        L_0x0488:
            r1 = r42
            if (r26 == 0) goto L_0x04be
            if (r20 == 0) goto L_0x04a4
            if (r1 == r15) goto L_0x04a4
            if (r25 != 0) goto L_0x04a4
            r3 = r34
            boolean r4 = r3 instanceof androidx.constraintlayout.core.widgets.a
            if (r4 != 0) goto L_0x049f
            r4 = r33
            boolean r5 = r4 instanceof androidx.constraintlayout.core.widgets.a
            if (r5 == 0) goto L_0x04a8
            goto L_0x04a1
        L_0x049f:
            r4 = r33
        L_0x04a1:
            r5 = r16
            goto L_0x04aa
        L_0x04a4:
            r4 = r33
            r3 = r34
        L_0x04a8:
            r5 = r23
        L_0x04aa:
            int r6 = r47.f()
            r8 = r35
            r10.h(r8, r1, r6, r5)
            int r6 = r48.f()
            int r6 = -r6
            r10.j(r14, r15, r6, r5)
            r23 = r5
            goto L_0x04c4
        L_0x04be:
            r4 = r33
            r3 = r34
            r8 = r35
        L_0x04c4:
            if (r20 == 0) goto L_0x04da
            if (r58 == 0) goto L_0x04da
            boolean r5 = r3 instanceof androidx.constraintlayout.core.widgets.a
            if (r5 != 0) goto L_0x04da
            boolean r5 = r4 instanceof androidx.constraintlayout.core.widgets.a
            if (r5 != 0) goto L_0x04da
            r5 = r32
            if (r4 == r5) goto L_0x04dc
            r6 = r16
            r7 = r6
            r2 = r18
            goto L_0x04e0
        L_0x04da:
            r5 = r32
        L_0x04dc:
            r6 = r22
            r7 = r23
        L_0x04e0:
            if (r2 == 0) goto L_0x052b
            if (r28 == 0) goto L_0x050b
            if (r57 == 0) goto L_0x04e8
            if (r41 == 0) goto L_0x050b
        L_0x04e8:
            if (r3 == r5) goto L_0x04ef
            if (r4 != r5) goto L_0x04ed
            goto L_0x04ef
        L_0x04ed:
            r2 = r6
            goto L_0x04f1
        L_0x04ef:
            r2 = r16
        L_0x04f1:
            boolean r9 = r3 instanceof androidx.constraintlayout.core.widgets.f
            if (r9 != 0) goto L_0x04f9
            boolean r9 = r4 instanceof androidx.constraintlayout.core.widgets.f
            if (r9 == 0) goto L_0x04fa
        L_0x04f9:
            r2 = 5
        L_0x04fa:
            boolean r9 = r3 instanceof androidx.constraintlayout.core.widgets.a
            if (r9 != 0) goto L_0x0502
            boolean r9 = r4 instanceof androidx.constraintlayout.core.widgets.a
            if (r9 == 0) goto L_0x0503
        L_0x0502:
            r2 = 5
        L_0x0503:
            if (r57 == 0) goto L_0x0506
            r2 = 5
        L_0x0506:
            int r2 = java.lang.Math.max(r2, r6)
            goto L_0x050c
        L_0x050b:
            r2 = r6
        L_0x050c:
            if (r20 == 0) goto L_0x051c
            int r2 = java.lang.Math.min(r7, r2)
            if (r54 == 0) goto L_0x051c
            if (r57 != 0) goto L_0x051c
            if (r3 == r5) goto L_0x051a
            if (r4 != r5) goto L_0x051c
        L_0x051a:
            r2 = r17
        L_0x051c:
            int r3 = r47.f()
            r10.e(r8, r1, r3, r2)
            int r3 = r48.f()
            int r3 = -r3
            r10.e(r14, r15, r3, r2)
        L_0x052b:
            if (r20 == 0) goto L_0x053c
            if (r11 != r1) goto L_0x0534
            int r2 = r47.f()
            goto L_0x0535
        L_0x0534:
            r2 = 0
        L_0x0535:
            if (r1 == r11) goto L_0x053c
            r1 = 5
            r10.h(r8, r11, r2, r1)
            goto L_0x053d
        L_0x053c:
            r1 = 5
        L_0x053d:
            if (r20 == 0) goto L_0x020c
            if (r25 == 0) goto L_0x020c
            r2 = r15
            if (r51 != 0) goto L_0x020d
            if (r24 != 0) goto L_0x020d
            if (r25 == 0) goto L_0x0550
            r3 = 3
            if (r12 != r3) goto L_0x0550
            r3 = 0
            r10.h(r14, r8, r3, r13)
            goto L_0x0559
        L_0x0550:
            r3 = 0
            r10.h(r14, r8, r3, r1)
            goto L_0x0559
        L_0x0555:
            r2 = r15
            r1 = 5
        L_0x0557:
            r20 = r40
        L_0x0559:
            if (r20 == 0) goto L_0x0586
            if (r19 == 0) goto L_0x0586
            r4 = r48
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r4.f3740f
            if (r5 == 0) goto L_0x0567
            int r3 = r48.f()
        L_0x0567:
            r5 = r44
            if (r2 == r5) goto L_0x0586
            boolean r2 = r0.f3773j
            if (r2 == 0) goto L_0x0583
            boolean r2 = r14.f3644g
            if (r2 == 0) goto L_0x0583
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r0.f3756a0
            if (r2 == 0) goto L_0x0583
            androidx.constraintlayout.core.widgets.d r2 = (androidx.constraintlayout.core.widgets.d) r2
            if (r39 == 0) goto L_0x057f
            r2.y1(r4)
            goto L_0x0582
        L_0x057f:
            r2.D1(r4)
        L_0x0582:
            return
        L_0x0583:
            r10.h(r5, r14, r3, r1)
        L_0x0586:
            return
        L_0x0587:
            r5 = r44
            r8 = r9
            r3 = 0
            r7 = 2
            r13 = 8
            r18 = 1
            if (r1 >= r7) goto L_0x05cc
            if (r40 == 0) goto L_0x05cc
            if (r19 == 0) goto L_0x05cc
            r10.h(r8, r11, r3, r13)
            if (r39 != 0) goto L_0x05a4
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.S
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.f3740f
            if (r1 != 0) goto L_0x05a2
            goto L_0x05a4
        L_0x05a2:
            r2 = r3
            goto L_0x05a6
        L_0x05a4:
            r2 = r18
        L_0x05a6:
            if (r39 != 0) goto L_0x05c7
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.S
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.f3740f
            if (r1 == 0) goto L_0x05c7
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r1.f3738d
            float r2 = r1.f3762d0
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x05c6
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r1.Z
            r2 = r1[r3]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r2 != r4) goto L_0x05c6
            r1 = r1[r18]
            if (r1 != r4) goto L_0x05c6
            r2 = r18
            goto L_0x05c7
        L_0x05c6:
            r2 = r3
        L_0x05c7:
            if (r2 == 0) goto L_0x05cc
            r10.h(r5, r14, r3, r13)
        L_0x05cc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.i(androidx.constraintlayout.core.d, boolean, boolean, boolean, boolean, androidx.constraintlayout.core.SolverVariable, androidx.constraintlayout.core.SolverVariable, androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour, boolean, androidx.constraintlayout.core.widgets.ConstraintAnchor, androidx.constraintlayout.core.widgets.ConstraintAnchor, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    private void x0(StringBuilder sb2, String str, float f10, float f11) {
        if (f10 != f11) {
            sb2.append(str);
            sb2.append(" :   ");
            sb2.append(f10);
            sb2.append(",\n");
        }
    }

    private void y0(StringBuilder sb2, String str, int i10, int i11) {
        if (i10 != i11) {
            sb2.append(str);
            sb2.append(" :   ");
            sb2.append(i10);
            sb2.append(",\n");
        }
    }

    private void z0(StringBuilder sb2, String str, float f10, int i10) {
        if (f10 != 0.0f) {
            sb2.append(str);
            sb2.append(" :  [");
            sb2.append(f10);
            sb2.append(AppsFlyerKit.COMMA);
            sb2.append(i10);
            sb2.append("");
            sb2.append("],\n");
        }
    }

    public DimensionBehaviour A() {
        return this.Z[0];
    }

    public void A0(int i10) {
        boolean z10;
        this.f3778l0 = i10;
        if (i10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.J = z10;
    }

    public int B() {
        ConstraintAnchor constraintAnchor = this.O;
        int i10 = 0;
        if (constraintAnchor != null) {
            i10 = 0 + constraintAnchor.f3741g;
        }
        ConstraintAnchor constraintAnchor2 = this.Q;
        if (constraintAnchor2 != null) {
            return i10 + constraintAnchor2.f3741g;
        }
        return i10;
    }

    public void B0(Object obj) {
        this.f3788q0 = obj;
    }

    public int C() {
        return this.M;
    }

    public void C0(String str) {
        this.f3796u0 = str;
    }

    public int D() {
        return this.N;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void D0(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x008e
            int r1 = r9.length()
            if (r1 != 0) goto L_0x000b
            goto L_0x008e
        L_0x000b:
            r1 = -1
            int r2 = r9.length()
            r3 = 44
            int r3 = r9.indexOf(r3)
            r4 = 0
            r5 = 1
            if (r3 <= 0) goto L_0x0037
            int r6 = r2 + -1
            if (r3 >= r6) goto L_0x0037
            java.lang.String r6 = r9.substring(r4, r3)
            java.lang.String r7 = "W"
            boolean r7 = r6.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x002c
            r1 = r4
            goto L_0x0035
        L_0x002c:
            java.lang.String r4 = "H"
            boolean r4 = r6.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x0035
            r1 = r5
        L_0x0035:
            int r4 = r3 + 1
        L_0x0037:
            r3 = 58
            int r3 = r9.indexOf(r3)
            if (r3 < 0) goto L_0x0075
            int r2 = r2 - r5
            if (r3 >= r2) goto L_0x0075
            java.lang.String r2 = r9.substring(r4, r3)
            int r3 = r3 + r5
            java.lang.String r9 = r9.substring(r3)
            int r3 = r2.length()
            if (r3 <= 0) goto L_0x0084
            int r3 = r9.length()
            if (r3 <= 0) goto L_0x0084
            float r2 = java.lang.Float.parseFloat(r2)     // Catch:{ NumberFormatException -> 0x0084 }
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0084 }
            int r3 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x0084
            int r3 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x0084
            if (r1 != r5) goto L_0x006f
            float r9 = r9 / r2
            float r9 = java.lang.Math.abs(r9)     // Catch:{ NumberFormatException -> 0x0084 }
            goto L_0x0085
        L_0x006f:
            float r2 = r2 / r9
            float r9 = java.lang.Math.abs(r2)     // Catch:{ NumberFormatException -> 0x0084 }
            goto L_0x0085
        L_0x0075:
            java.lang.String r9 = r9.substring(r4)
            int r2 = r9.length()
            if (r2 <= 0) goto L_0x0084
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0084 }
            goto L_0x0085
        L_0x0084:
            r9 = r0
        L_0x0085:
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x008d
            r8.f3762d0 = r9
            r8.f3764e0 = r1
        L_0x008d:
            return
        L_0x008e:
            r8.f3762d0 = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.D0(java.lang.String):void");
    }

    public int E(int i10) {
        if (i10 == 0) {
            return W();
        }
        if (i10 == 1) {
            return x();
        }
        return 0;
    }

    public void E0(int i10) {
        if (this.J) {
            int i11 = i10 - this.f3778l0;
            int i12 = this.f3760c0 + i11;
            this.f3768g0 = i11;
            this.P.t(i11);
            this.R.t(i12);
            this.S.t(i10);
            this.f3787q = true;
        }
    }

    public int F() {
        return this.H[1];
    }

    public void F0(int i10, int i11) {
        if (!this.f3785p) {
            this.O.t(i10);
            this.Q.t(i11);
            this.f3766f0 = i10;
            this.f3758b0 = i11 - i10;
            this.f3785p = true;
        }
    }

    public int G() {
        return this.H[0];
    }

    public void G0(int i10) {
        this.O.t(i10);
        this.f3766f0 = i10;
    }

    public int H() {
        return this.f3782n0;
    }

    public void H0(int i10) {
        this.P.t(i10);
        this.f3768g0 = i10;
    }

    public int I() {
        return this.f3780m0;
    }

    public void I0(int i10, int i11) {
        if (!this.f3787q) {
            this.P.t(i10);
            this.R.t(i11);
            this.f3768g0 = i10;
            this.f3760c0 = i11 - i10;
            if (this.J) {
                this.S.t(i10 + this.f3778l0);
            }
            this.f3787q = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        r3 = r2.R;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.constraintlayout.core.widgets.ConstraintWidget J(int r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x000f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r2.Q
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r3.f3740f
            if (r0 == 0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.f3740f
            if (r1 != r3) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f3738d
            return r3
        L_0x000f:
            r0 = 1
            if (r3 != r0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r2.R
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r3.f3740f
            if (r0 == 0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.f3740f
            if (r1 != r3) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f3738d
            return r3
        L_0x001f:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.J(int):androidx.constraintlayout.core.widgets.ConstraintWidget");
    }

    public void J0(int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16 = i12 - i10;
        int i17 = i13 - i11;
        this.f3766f0 = i10;
        this.f3768g0 = i11;
        if (this.f3792s0 == 8) {
            this.f3758b0 = 0;
            this.f3760c0 = 0;
            return;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.Z;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.FIXED;
        if (dimensionBehaviour == dimensionBehaviour2 && i16 < (i15 = this.f3758b0)) {
            i16 = i15;
        }
        if (dimensionBehaviourArr[1] == dimensionBehaviour2 && i17 < (i14 = this.f3760c0)) {
            i17 = i14;
        }
        this.f3758b0 = i16;
        this.f3760c0 = i17;
        int i18 = this.f3782n0;
        if (i17 < i18) {
            this.f3760c0 = i18;
        }
        int i19 = this.f3780m0;
        if (i16 < i19) {
            this.f3758b0 = i19;
        }
        int i20 = this.A;
        if (i20 > 0 && dimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.f3758b0 = Math.min(this.f3758b0, i20);
        }
        int i21 = this.D;
        if (i21 > 0 && this.Z[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.f3760c0 = Math.min(this.f3760c0, i21);
        }
        int i22 = this.f3758b0;
        if (i16 != i22) {
            this.f3777l = i22;
        }
        int i23 = this.f3760c0;
        if (i17 != i23) {
            this.f3779m = i23;
        }
    }

    public ConstraintWidget K() {
        return this.f3756a0;
    }

    public void K0(boolean z10) {
        this.J = z10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        r3 = r2.P;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.constraintlayout.core.widgets.ConstraintWidget L(int r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x000f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r2.O
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r3.f3740f
            if (r0 == 0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.f3740f
            if (r1 != r3) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f3738d
            return r3
        L_0x000f:
            r0 = 1
            if (r3 != r0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r2.P
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r3.f3740f
            if (r0 == 0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.f3740f
            if (r1 != r3) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f3738d
            return r3
        L_0x001f:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.L(int):androidx.constraintlayout.core.widgets.ConstraintWidget");
    }

    public void L0(int i10) {
        this.f3760c0 = i10;
        int i11 = this.f3782n0;
        if (i10 < i11) {
            this.f3760c0 = i11;
        }
    }

    public int M() {
        return X() + this.f3758b0;
    }

    public void M0(float f10) {
        this.f3784o0 = f10;
    }

    public WidgetRun N(int i10) {
        if (i10 == 0) {
            return this.f3763e;
        }
        if (i10 == 1) {
            return this.f3765f;
        }
        return null;
    }

    public void N0(int i10) {
        this.f3806z0 = i10;
    }

    public void O(StringBuilder sb2) {
        sb2.append("  " + this.f3783o + ":{\n");
        StringBuilder sb3 = new StringBuilder();
        sb3.append("    actualWidth:");
        sb3.append(this.f3758b0);
        sb2.append(sb3.toString());
        sb2.append("\n");
        sb2.append("    actualHeight:" + this.f3760c0);
        sb2.append("\n");
        sb2.append("    actualLeft:" + this.f3766f0);
        sb2.append("\n");
        sb2.append("    actualTop:" + this.f3768g0);
        sb2.append("\n");
        Q(sb2, ViewHierarchyConstants.DIMENSION_LEFT_KEY, this.O);
        Q(sb2, ViewHierarchyConstants.DIMENSION_TOP_KEY, this.P);
        Q(sb2, "right", this.Q);
        Q(sb2, "bottom", this.R);
        Q(sb2, "baseline", this.S);
        Q(sb2, "centerX", this.T);
        Q(sb2, "centerY", this.U);
        P(sb2, "    width", this.f3758b0, this.f3780m0, this.H[0], this.f3777l, this.f3805z, this.f3799w, this.B, this.D0[0]);
        P(sb2, "    height", this.f3760c0, this.f3782n0, this.H[1], this.f3779m, this.C, this.f3801x, this.E, this.D0[1]);
        z0(sb2, "    dimensionRatio", this.f3762d0, this.f3764e0);
        x0(sb2, "    horizontalBias", this.f3784o0, K0);
        x0(sb2, "    verticalBias", this.f3786p0, K0);
        y0(sb2, "    horizontalChainStyle", this.f3806z0, 0);
        y0(sb2, "    verticalChainStyle", this.A0, 0);
        sb2.append("  }");
    }

    public void O0(int i10, int i11) {
        this.f3766f0 = i10;
        int i12 = i11 - i10;
        this.f3758b0 = i12;
        int i13 = this.f3780m0;
        if (i12 < i13) {
            this.f3758b0 = i13;
        }
    }

    public void P0(DimensionBehaviour dimensionBehaviour) {
        this.Z[0] = dimensionBehaviour;
    }

    public void Q0(int i10, int i11, int i12, float f10) {
        this.f3799w = i10;
        this.f3805z = i11;
        if (i12 == Integer.MAX_VALUE) {
            i12 = 0;
        }
        this.A = i12;
        this.B = f10;
        if (f10 > 0.0f && f10 < 1.0f && i10 == 0) {
            this.f3799w = 2;
        }
    }

    public float R() {
        return this.f3786p0;
    }

    public void R0(float f10) {
        this.D0[0] = f10;
    }

    public int S() {
        return this.A0;
    }

    /* access modifiers changed from: protected */
    public void S0(int i10, boolean z10) {
        this.Y[i10] = z10;
    }

    public DimensionBehaviour T() {
        return this.Z[1];
    }

    public void T0(boolean z10) {
        this.K = z10;
    }

    public int U() {
        int i10 = 0;
        if (this.O != null) {
            i10 = 0 + this.P.f3741g;
        }
        if (this.Q != null) {
            return i10 + this.R.f3741g;
        }
        return i10;
    }

    public void U0(boolean z10) {
        this.L = z10;
    }

    public int V() {
        return this.f3792s0;
    }

    public void V0(int i10, int i11) {
        this.M = i10;
        this.N = i11;
        Y0(false);
    }

    public int W() {
        if (this.f3792s0 == 8) {
            return 0;
        }
        return this.f3758b0;
    }

    public void W0(int i10) {
        this.H[1] = i10;
    }

    public int X() {
        ConstraintWidget constraintWidget = this.f3756a0;
        if (constraintWidget == null || !(constraintWidget instanceof d)) {
            return this.f3766f0;
        }
        return ((d) constraintWidget).S0 + this.f3766f0;
    }

    public void X0(int i10) {
        this.H[0] = i10;
    }

    public int Y() {
        ConstraintWidget constraintWidget = this.f3756a0;
        if (constraintWidget == null || !(constraintWidget instanceof d)) {
            return this.f3768g0;
        }
        return ((d) constraintWidget).T0 + this.f3768g0;
    }

    public void Y0(boolean z10) {
        this.f3771i = z10;
    }

    public boolean Z() {
        return this.J;
    }

    public void Z0(int i10) {
        if (i10 < 0) {
            this.f3782n0 = 0;
        } else {
            this.f3782n0 = i10;
        }
    }

    public boolean a0(int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        if (i10 == 0) {
            if (this.O.f3740f != null) {
                i14 = 1;
            } else {
                i14 = 0;
            }
            if (this.Q.f3740f != null) {
                i15 = 1;
            } else {
                i15 = 0;
            }
            if (i14 + i15 < 2) {
                return true;
            }
            return false;
        }
        if (this.P.f3740f != null) {
            i11 = 1;
        } else {
            i11 = 0;
        }
        if (this.R.f3740f != null) {
            i12 = 1;
        } else {
            i12 = 0;
        }
        int i16 = i11 + i12;
        if (this.S.f3740f != null) {
            i13 = 1;
        } else {
            i13 = 0;
        }
        if (i16 + i13 < 2) {
            return true;
        }
        return false;
    }

    public void a1(int i10) {
        if (i10 < 0) {
            this.f3780m0 = 0;
        } else {
            this.f3780m0 = i10;
        }
    }

    public boolean b0() {
        int size = this.X.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.X.get(i10).m()) {
                return true;
            }
        }
        return false;
    }

    public void b1(int i10, int i11) {
        this.f3766f0 = i10;
        this.f3768g0 = i11;
    }

    public boolean c0() {
        return (this.f3777l == -1 && this.f3779m == -1) ? false : true;
    }

    public void c1(ConstraintWidget constraintWidget) {
        this.f3756a0 = constraintWidget;
    }

    public boolean d0(int i10, int i11) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i10 == 0) {
            ConstraintAnchor constraintAnchor3 = this.O.f3740f;
            if (constraintAnchor3 != null && constraintAnchor3.n() && (constraintAnchor2 = this.Q.f3740f) != null && constraintAnchor2.n()) {
                if ((this.Q.f3740f.e() - this.Q.f()) - (this.O.f3740f.e() + this.O.f()) >= i11) {
                    return true;
                }
                return false;
            }
        } else {
            ConstraintAnchor constraintAnchor4 = this.P.f3740f;
            if (constraintAnchor4 != null && constraintAnchor4.n() && (constraintAnchor = this.R.f3740f) != null && constraintAnchor.n()) {
                if ((this.R.f3740f.e() - this.R.f()) - (this.P.f3740f.e() + this.P.f()) >= i11) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public void d1(float f10) {
        this.f3786p0 = f10;
    }

    public void e(d dVar, d dVar2, HashSet<ConstraintWidget> hashSet, int i10, boolean z10) {
        if (z10) {
            if (hashSet.contains(this)) {
                g.a(dVar, dVar2, this);
                hashSet.remove(this);
                g(dVar2, dVar.T1(64));
            } else {
                return;
            }
        }
        if (i10 == 0) {
            HashSet<ConstraintAnchor> d10 = this.O.d();
            if (d10 != null) {
                Iterator<ConstraintAnchor> it = d10.iterator();
                while (it.hasNext()) {
                    it.next().f3738d.e(dVar, dVar2, hashSet, i10, true);
                }
            }
            HashSet<ConstraintAnchor> d11 = this.Q.d();
            if (d11 != null) {
                Iterator<ConstraintAnchor> it2 = d11.iterator();
                while (it2.hasNext()) {
                    it2.next().f3738d.e(dVar, dVar2, hashSet, i10, true);
                }
                return;
            }
            return;
        }
        HashSet<ConstraintAnchor> d12 = this.P.d();
        if (d12 != null) {
            Iterator<ConstraintAnchor> it3 = d12.iterator();
            while (it3.hasNext()) {
                it3.next().f3738d.e(dVar, dVar2, hashSet, i10, true);
            }
        }
        HashSet<ConstraintAnchor> d13 = this.R.d();
        if (d13 != null) {
            Iterator<ConstraintAnchor> it4 = d13.iterator();
            while (it4.hasNext()) {
                it4.next().f3738d.e(dVar, dVar2, hashSet, i10, true);
            }
        }
        HashSet<ConstraintAnchor> d14 = this.S.d();
        if (d14 != null) {
            Iterator<ConstraintAnchor> it5 = d14.iterator();
            while (it5.hasNext()) {
                it5.next().f3738d.e(dVar, dVar2, hashSet, i10, true);
            }
        }
    }

    public void e0(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i10, int i11) {
        o(type).b(constraintWidget.o(type2), i10, i11, true);
    }

    public void e1(int i10) {
        this.A0 = i10;
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return (this instanceof h) || (this instanceof f);
    }

    public void f1(int i10, int i11) {
        this.f3768g0 = i10;
        int i12 = i11 - i10;
        this.f3760c0 = i12;
        int i13 = this.f3782n0;
        if (i12 < i13) {
            this.f3760c0 = i13;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: int} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x02b4  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x02be  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x02c3  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x02dc  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x02de  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x02e1  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x02e4  */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x0316  */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x0360  */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x0423  */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x0487  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x049b  */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x049d  */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x04a4  */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x053b  */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x053e  */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x057e  */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x0584  */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x05af  */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x05b9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(androidx.constraintlayout.core.d r54, boolean r55) {
        /*
            r53 = this;
            r15 = r53
            r14 = r54
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.O
            androidx.constraintlayout.core.SolverVariable r13 = r14.q(r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.Q
            androidx.constraintlayout.core.SolverVariable r12 = r14.q(r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.P
            androidx.constraintlayout.core.SolverVariable r11 = r14.q(r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.R
            androidx.constraintlayout.core.SolverVariable r10 = r14.q(r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.S
            androidx.constraintlayout.core.SolverVariable r9 = r14.q(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.f3756a0
            r8 = 2
            r1 = 3
            r7 = 1
            r6 = 0
            if (r0 == 0) goto L_0x0055
            if (r0 == 0) goto L_0x0036
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r0.Z
            r2 = r2[r6]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r2 != r3) goto L_0x0036
            r2 = r7
            goto L_0x0037
        L_0x0036:
            r2 = r6
        L_0x0037:
            if (r0 == 0) goto L_0x0043
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r0.Z
            r0 = r0[r7]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r3) goto L_0x0043
            r0 = r7
            goto L_0x0044
        L_0x0043:
            r0 = r6
        L_0x0044:
            int r3 = r15.f3797v
            if (r3 == r7) goto L_0x0052
            if (r3 == r8) goto L_0x004f
            if (r3 == r1) goto L_0x0055
            r5 = r0
            r4 = r2
            goto L_0x0057
        L_0x004f:
            r5 = r0
            r4 = r6
            goto L_0x0057
        L_0x0052:
            r4 = r2
            r5 = r6
            goto L_0x0057
        L_0x0055:
            r4 = r6
            r5 = r4
        L_0x0057:
            int r0 = r15.f3792s0
            r3 = 8
            if (r0 != r3) goto L_0x0072
            boolean r0 = r15.f3794t0
            if (r0 != 0) goto L_0x0072
            boolean r0 = r53.b0()
            if (r0 != 0) goto L_0x0072
            boolean[] r0 = r15.Y
            boolean r2 = r0[r6]
            if (r2 != 0) goto L_0x0072
            boolean r0 = r0[r7]
            if (r0 != 0) goto L_0x0072
            return
        L_0x0072:
            boolean r0 = r15.f3785p
            r2 = 5
            if (r0 != 0) goto L_0x007b
            boolean r8 = r15.f3787q
            if (r8 == 0) goto L_0x00f8
        L_0x007b:
            if (r0 == 0) goto L_0x00aa
            int r0 = r15.f3766f0
            r14.f(r13, r0)
            int r0 = r15.f3766f0
            int r8 = r15.f3758b0
            int r0 = r0 + r8
            r14.f(r12, r0)
            if (r4 == 0) goto L_0x00aa
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.f3756a0
            if (r0 == 0) goto L_0x00aa
            boolean r8 = r15.f3775k
            if (r8 == 0) goto L_0x00a1
            androidx.constraintlayout.core.widgets.d r0 = (androidx.constraintlayout.core.widgets.d) r0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r15.O
            r0.z1(r8)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r15.Q
            r0.y1(r8)
            goto L_0x00aa
        L_0x00a1:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.Q
            androidx.constraintlayout.core.SolverVariable r0 = r14.q(r0)
            r14.h(r0, r12, r6, r2)
        L_0x00aa:
            boolean r0 = r15.f3787q
            if (r0 == 0) goto L_0x00eb
            int r0 = r15.f3768g0
            r14.f(r11, r0)
            int r0 = r15.f3768g0
            int r8 = r15.f3760c0
            int r0 = r0 + r8
            r14.f(r10, r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.S
            boolean r0 = r0.m()
            if (r0 == 0) goto L_0x00cb
            int r0 = r15.f3768g0
            int r8 = r15.f3778l0
            int r0 = r0 + r8
            r14.f(r9, r0)
        L_0x00cb:
            if (r5 == 0) goto L_0x00eb
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.f3756a0
            if (r0 == 0) goto L_0x00eb
            boolean r8 = r15.f3775k
            if (r8 == 0) goto L_0x00e2
            androidx.constraintlayout.core.widgets.d r0 = (androidx.constraintlayout.core.widgets.d) r0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r15.P
            r0.E1(r8)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r15.R
            r0.D1(r8)
            goto L_0x00eb
        L_0x00e2:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.R
            androidx.constraintlayout.core.SolverVariable r0 = r14.q(r0)
            r14.h(r0, r10, r6, r2)
        L_0x00eb:
            boolean r0 = r15.f3785p
            if (r0 == 0) goto L_0x00f8
            boolean r0 = r15.f3787q
            if (r0 == 0) goto L_0x00f8
            r15.f3785p = r6
            r15.f3787q = r6
            return
        L_0x00f8:
            boolean r0 = androidx.constraintlayout.core.d.f3683r
            if (r55 == 0) goto L_0x0180
            androidx.constraintlayout.core.widgets.analyzer.j r0 = r15.f3763e
            if (r0 == 0) goto L_0x0180
            androidx.constraintlayout.core.widgets.analyzer.l r8 = r15.f3765f
            if (r8 == 0) goto L_0x0180
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r0.f3842h
            boolean r1 = r2.f3823j
            if (r1 == 0) goto L_0x0180
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.f3843i
            boolean r0 = r0.f3823j
            if (r0 == 0) goto L_0x0180
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f3842h
            boolean r0 = r0.f3823j
            if (r0 == 0) goto L_0x0180
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f3843i
            boolean r0 = r0.f3823j
            if (r0 == 0) goto L_0x0180
            int r0 = r2.f3820g
            r14.f(r13, r0)
            androidx.constraintlayout.core.widgets.analyzer.j r0 = r15.f3763e
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.f3843i
            int r0 = r0.f3820g
            r14.f(r12, r0)
            androidx.constraintlayout.core.widgets.analyzer.l r0 = r15.f3765f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.f3842h
            int r0 = r0.f3820g
            r14.f(r11, r0)
            androidx.constraintlayout.core.widgets.analyzer.l r0 = r15.f3765f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.f3843i
            int r0 = r0.f3820g
            r14.f(r10, r0)
            androidx.constraintlayout.core.widgets.analyzer.l r0 = r15.f3765f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.f3892k
            int r0 = r0.f3820g
            r14.f(r9, r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.f3756a0
            if (r0 == 0) goto L_0x017b
            if (r4 == 0) goto L_0x0162
            boolean[] r0 = r15.f3767g
            boolean r0 = r0[r6]
            if (r0 == 0) goto L_0x0162
            boolean r0 = r53.i0()
            if (r0 != 0) goto L_0x0162
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.f3756a0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.Q
            androidx.constraintlayout.core.SolverVariable r0 = r14.q(r0)
            r14.h(r0, r12, r6, r3)
        L_0x0162:
            if (r5 == 0) goto L_0x017b
            boolean[] r0 = r15.f3767g
            boolean r0 = r0[r7]
            if (r0 == 0) goto L_0x017b
            boolean r0 = r53.k0()
            if (r0 != 0) goto L_0x017b
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.f3756a0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.R
            androidx.constraintlayout.core.SolverVariable r0 = r14.q(r0)
            r14.h(r0, r10, r6, r3)
        L_0x017b:
            r15.f3785p = r6
            r15.f3787q = r6
            return
        L_0x0180:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.f3756a0
            if (r0 == 0) goto L_0x01f1
            boolean r0 = r15.f0(r6)
            if (r0 == 0) goto L_0x0193
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.f3756a0
            androidx.constraintlayout.core.widgets.d r0 = (androidx.constraintlayout.core.widgets.d) r0
            r0.v1(r15, r6)
            r0 = r7
            goto L_0x0197
        L_0x0193:
            boolean r0 = r53.i0()
        L_0x0197:
            boolean r1 = r15.f0(r7)
            if (r1 == 0) goto L_0x01a6
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r15.f3756a0
            androidx.constraintlayout.core.widgets.d r1 = (androidx.constraintlayout.core.widgets.d) r1
            r1.v1(r15, r7)
            r1 = r7
            goto L_0x01aa
        L_0x01a6:
            boolean r1 = r53.k0()
        L_0x01aa:
            if (r0 != 0) goto L_0x01c9
            if (r4 == 0) goto L_0x01c9
            int r2 = r15.f3792s0
            if (r2 == r3) goto L_0x01c9
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r15.O
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.f3740f
            if (r2 != 0) goto L_0x01c9
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r15.Q
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.f3740f
            if (r2 != 0) goto L_0x01c9
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r15.f3756a0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.Q
            androidx.constraintlayout.core.SolverVariable r2 = r14.q(r2)
            r14.h(r2, r12, r6, r7)
        L_0x01c9:
            if (r1 != 0) goto L_0x01ec
            if (r5 == 0) goto L_0x01ec
            int r2 = r15.f3792s0
            if (r2 == r3) goto L_0x01ec
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r15.P
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.f3740f
            if (r2 != 0) goto L_0x01ec
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r15.R
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.f3740f
            if (r2 != 0) goto L_0x01ec
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r15.S
            if (r2 != 0) goto L_0x01ec
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r15.f3756a0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.R
            androidx.constraintlayout.core.SolverVariable r2 = r14.q(r2)
            r14.h(r2, r10, r6, r7)
        L_0x01ec:
            r29 = r0
            r28 = r1
            goto L_0x01f5
        L_0x01f1:
            r28 = r6
            r29 = r28
        L_0x01f5:
            int r0 = r15.f3758b0
            int r1 = r15.f3780m0
            if (r0 >= r1) goto L_0x01fc
            goto L_0x01fd
        L_0x01fc:
            r1 = r0
        L_0x01fd:
            int r2 = r15.f3760c0
            int r8 = r15.f3782n0
            if (r2 >= r8) goto L_0x0204
            goto L_0x0205
        L_0x0204:
            r8 = r2
        L_0x0205:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r15.Z
            r7 = r3[r6]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r22 = r1
            if (r7 == r6) goto L_0x0211
            r1 = 1
            goto L_0x0212
        L_0x0211:
            r1 = 0
        L_0x0212:
            r20 = 1
            r3 = r3[r20]
            r23 = r8
            r27 = r9
            if (r3 == r6) goto L_0x021e
            r8 = 1
            goto L_0x021f
        L_0x021e:
            r8 = 0
        L_0x021f:
            int r9 = r15.f3764e0
            r15.F = r9
            r30 = r10
            float r10 = r15.f3762d0
            r15.G = r10
            r31 = r11
            int r11 = r15.f3799w
            r32 = r12
            int r12 = r15.f3801x
            r24 = 0
            int r24 = (r10 > r24 ? 1 : (r10 == r24 ? 0 : -1))
            r25 = 4
            r33 = r13
            if (r24 <= 0) goto L_0x029f
            int r13 = r15.f3792s0
            r14 = 8
            if (r13 == r14) goto L_0x029f
            if (r7 != r6) goto L_0x0246
            if (r11 != 0) goto L_0x0246
            r11 = 3
        L_0x0246:
            if (r3 != r6) goto L_0x024b
            if (r12 != 0) goto L_0x024b
            r12 = 3
        L_0x024b:
            if (r7 != r6) goto L_0x0258
            if (r3 != r6) goto L_0x0258
            r13 = 3
            if (r11 != r13) goto L_0x0259
            if (r12 != r13) goto L_0x0259
            r15.o1(r4, r5, r1, r8)
            goto L_0x0295
        L_0x0258:
            r13 = 3
        L_0x0259:
            if (r7 != r6) goto L_0x0271
            if (r11 != r13) goto L_0x0271
            r1 = 0
            r15.F = r1
            float r0 = (float) r2
            float r10 = r10 * r0
            int r1 = (int) r10
            if (r3 == r6) goto L_0x026c
            r35 = r12
            r34 = r23
            r36 = r25
            goto L_0x02a7
        L_0x026c:
            r36 = r11
            r35 = r12
            goto L_0x029b
        L_0x0271:
            if (r3 != r6) goto L_0x0295
            if (r12 != r13) goto L_0x0295
            r1 = 1
            r15.F = r1
            r1 = -1
            if (r9 != r1) goto L_0x0280
            r1 = 1065353216(0x3f800000, float:1.0)
            float r1 = r1 / r10
            r15.G = r1
        L_0x0280:
            float r1 = r15.G
            float r0 = (float) r0
            float r1 = r1 * r0
            int r8 = (int) r1
            r34 = r8
            r36 = r11
            if (r7 == r6) goto L_0x0290
            r1 = r22
            r35 = r25
            goto L_0x02a7
        L_0x0290:
            r35 = r12
            r1 = r22
            goto L_0x029d
        L_0x0295:
            r36 = r11
            r35 = r12
            r1 = r22
        L_0x029b:
            r34 = r23
        L_0x029d:
            r14 = 1
            goto L_0x02a8
        L_0x029f:
            r36 = r11
            r35 = r12
            r1 = r22
            r34 = r23
        L_0x02a7:
            r14 = 0
        L_0x02a8:
            int[] r0 = r15.f3803y
            r2 = 0
            r0[r2] = r36
            r2 = 1
            r0[r2] = r35
            r15.f3769h = r14
            if (r14 == 0) goto L_0x02be
            int r0 = r15.F
            r2 = -1
            if (r0 == 0) goto L_0x02bb
            if (r0 != r2) goto L_0x02bf
        L_0x02bb:
            r18 = 1
            goto L_0x02c1
        L_0x02be:
            r2 = -1
        L_0x02bf:
            r18 = 0
        L_0x02c1:
            if (r14 == 0) goto L_0x02cd
            int r0 = r15.F
            r3 = 1
            if (r0 == r3) goto L_0x02ca
            if (r0 != r2) goto L_0x02cd
        L_0x02ca:
            r37 = 1
            goto L_0x02cf
        L_0x02cd:
            r37 = 0
        L_0x02cf:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.Z
            r2 = 0
            r0 = r0[r2]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r13) goto L_0x02de
            boolean r0 = r15 instanceof androidx.constraintlayout.core.widgets.d
            if (r0 == 0) goto L_0x02de
            r9 = 1
            goto L_0x02df
        L_0x02de:
            r9 = 0
        L_0x02df:
            if (r9 == 0) goto L_0x02e4
            r22 = 0
            goto L_0x02e6
        L_0x02e4:
            r22 = r1
        L_0x02e6:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.V
            boolean r0 = r0.o()
            r1 = 1
            r38 = r0 ^ 1
            boolean[] r0 = r15.Y
            r2 = 0
            boolean r23 = r0[r2]
            boolean r39 = r0[r1]
            int r0 = r15.f3793t
            r40 = 0
            r8 = 2
            if (r0 == r8) goto L_0x040d
            boolean r0 = r15.f3785p
            if (r0 != 0) goto L_0x040d
            if (r55 == 0) goto L_0x0364
            androidx.constraintlayout.core.widgets.analyzer.j r0 = r15.f3763e
            if (r0 == 0) goto L_0x0364
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r0.f3842h
            boolean r2 = r1.f3823j
            if (r2 == 0) goto L_0x0364
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.f3843i
            boolean r0 = r0.f3823j
            if (r0 != 0) goto L_0x0314
            goto L_0x0364
        L_0x0314:
            if (r55 == 0) goto L_0x0360
            int r0 = r1.f3820g
            r12 = r54
            r11 = r33
            r12.f(r11, r0)
            androidx.constraintlayout.core.widgets.analyzer.j r0 = r15.f3763e
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.f3843i
            int r0 = r0.f3820g
            r10 = r32
            r12.f(r10, r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.f3756a0
            if (r0 == 0) goto L_0x034a
            if (r4 == 0) goto L_0x034a
            boolean[] r0 = r15.f3767g
            r1 = 0
            boolean r0 = r0[r1]
            if (r0 == 0) goto L_0x034a
            boolean r0 = r53.i0()
            if (r0 != 0) goto L_0x034a
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.f3756a0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.Q
            androidx.constraintlayout.core.SolverVariable r0 = r12.q(r0)
            r3 = 8
            r12.h(r0, r10, r1, r3)
        L_0x034a:
            r43 = r4
            r47 = r5
            r48 = r6
            r52 = r13
            r32 = r14
            r49 = r27
            r50 = r30
            r51 = r31
            r30 = r10
            r31 = r11
            goto L_0x0421
        L_0x0360:
            r12 = r54
            goto L_0x040d
        L_0x0364:
            r12 = r54
            r10 = r32
            r11 = r33
            r3 = 8
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.f3756a0
            if (r0 == 0) goto L_0x0378
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.Q
            androidx.constraintlayout.core.SolverVariable r0 = r12.q(r0)
            r7 = r0
            goto L_0x037a
        L_0x0378:
            r7 = r40
        L_0x037a:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.f3756a0
            if (r0 == 0) goto L_0x0387
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.O
            androidx.constraintlayout.core.SolverVariable r0 = r12.q(r0)
            r16 = r0
            goto L_0x0389
        L_0x0387:
            r16 = r40
        L_0x0389:
            boolean[] r0 = r15.f3767g
            r19 = 0
            boolean r21 = r0[r19]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.Z
            r32 = r0[r19]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r15.O
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r15.Q
            r41 = r2
            int r2 = r15.f3766f0
            r42 = r2
            int r2 = r15.f3780m0
            int[] r3 = r15.H
            r44 = r3[r19]
            float r3 = r15.f3784o0
            r20 = 1
            r0 = r0[r20]
            if (r0 != r6) goto L_0x03ae
            r45 = r20
            goto L_0x03b0
        L_0x03ae:
            r45 = r19
        L_0x03b0:
            int r0 = r15.f3805z
            r24 = r0
            int r0 = r15.A
            r25 = r0
            float r0 = r15.B
            r26 = r0
            r0 = r53
            r46 = r1
            r1 = r54
            r17 = r41
            r33 = r42
            r41 = r2
            r2 = 1
            r42 = r3
            r3 = r4
            r43 = r4
            r4 = r5
            r47 = r5
            r5 = r21
            r48 = r6
            r6 = r16
            r8 = r32
            r49 = r27
            r16 = r10
            r50 = r30
            r10 = r46
            r19 = r11
            r51 = r31
            r11 = r17
            r30 = r16
            r12 = r33
            r52 = r13
            r31 = r19
            r13 = r22
            r32 = r14
            r14 = r41
            r15 = r44
            r16 = r42
            r17 = r18
            r18 = r45
            r19 = r29
            r20 = r28
            r21 = r23
            r22 = r36
            r23 = r35
            r27 = r38
            r0.i(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            goto L_0x0421
        L_0x040d:
            r43 = r4
            r47 = r5
            r48 = r6
            r52 = r13
            r49 = r27
            r50 = r30
            r51 = r31
            r30 = r32
            r31 = r33
            r32 = r14
        L_0x0421:
            if (r55 == 0) goto L_0x0487
            r15 = r53
            androidx.constraintlayout.core.widgets.analyzer.l r0 = r15.f3765f
            if (r0 == 0) goto L_0x047a
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r0.f3842h
            boolean r2 = r1.f3823j
            if (r2 == 0) goto L_0x047a
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.f3843i
            boolean r0 = r0.f3823j
            if (r0 == 0) goto L_0x047a
            int r0 = r1.f3820g
            r14 = r54
            r13 = r51
            r14.f(r13, r0)
            androidx.constraintlayout.core.widgets.analyzer.l r0 = r15.f3765f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.f3843i
            int r0 = r0.f3820g
            r12 = r50
            r14.f(r12, r0)
            androidx.constraintlayout.core.widgets.analyzer.l r0 = r15.f3765f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.f3892k
            int r0 = r0.f3820g
            r1 = r49
            r14.f(r1, r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.f3756a0
            if (r0 == 0) goto L_0x0474
            if (r28 != 0) goto L_0x0474
            if (r47 == 0) goto L_0x0474
            boolean[] r2 = r15.f3767g
            r11 = 1
            boolean r2 = r2[r11]
            if (r2 == 0) goto L_0x0470
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.R
            androidx.constraintlayout.core.SolverVariable r0 = r14.q(r0)
            r2 = 8
            r10 = 0
            r14.h(r0, r12, r10, r2)
            goto L_0x0478
        L_0x0470:
            r2 = 8
            r10 = 0
            goto L_0x0478
        L_0x0474:
            r2 = 8
            r10 = 0
            r11 = 1
        L_0x0478:
            r7 = r10
            goto L_0x0496
        L_0x047a:
            r14 = r54
            r1 = r49
            r12 = r50
            r13 = r51
            r2 = 8
            r10 = 0
            r11 = 1
            goto L_0x0495
        L_0x0487:
            r2 = 8
            r10 = 0
            r11 = 1
            r15 = r53
            r14 = r54
            r1 = r49
            r12 = r50
            r13 = r51
        L_0x0495:
            r7 = r11
        L_0x0496:
            int r0 = r15.f3795u
            r3 = 2
            if (r0 != r3) goto L_0x049d
            r6 = r10
            goto L_0x049e
        L_0x049d:
            r6 = r7
        L_0x049e:
            if (r6 == 0) goto L_0x057e
            boolean r0 = r15.f3787q
            if (r0 != 0) goto L_0x057e
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.Z
            r0 = r0[r11]
            r3 = r52
            if (r0 != r3) goto L_0x04b2
            boolean r0 = r15 instanceof androidx.constraintlayout.core.widgets.d
            if (r0 == 0) goto L_0x04b2
            r9 = r11
            goto L_0x04b3
        L_0x04b2:
            r9 = r10
        L_0x04b3:
            if (r9 == 0) goto L_0x04b7
            r34 = r10
        L_0x04b7:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.f3756a0
            if (r0 == 0) goto L_0x04c3
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.R
            androidx.constraintlayout.core.SolverVariable r0 = r14.q(r0)
            r7 = r0
            goto L_0x04c5
        L_0x04c3:
            r7 = r40
        L_0x04c5:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.f3756a0
            if (r0 == 0) goto L_0x04d1
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.P
            androidx.constraintlayout.core.SolverVariable r0 = r14.q(r0)
            r6 = r0
            goto L_0x04d3
        L_0x04d1:
            r6 = r40
        L_0x04d3:
            int r0 = r15.f3778l0
            if (r0 > 0) goto L_0x04db
            int r0 = r15.f3792s0
            if (r0 != r2) goto L_0x051b
        L_0x04db:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.S
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r0.f3740f
            if (r3 == 0) goto L_0x0508
            int r0 = r53.p()
            r14.e(r1, r13, r0, r2)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.S
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.f3740f
            androidx.constraintlayout.core.SolverVariable r0 = r14.q(r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r15.S
            int r3 = r3.f()
            r14.e(r1, r0, r3, r2)
            if (r47 == 0) goto L_0x0505
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.R
            androidx.constraintlayout.core.SolverVariable r0 = r14.q(r0)
            r1 = 5
            r14.h(r7, r0, r10, r1)
        L_0x0505:
            r27 = r10
            goto L_0x051d
        L_0x0508:
            int r3 = r15.f3792s0
            if (r3 != r2) goto L_0x0514
            int r0 = r0.f()
            r14.e(r1, r13, r0, r2)
            goto L_0x051b
        L_0x0514:
            int r0 = r53.p()
            r14.e(r1, r13, r0, r2)
        L_0x051b:
            r27 = r38
        L_0x051d:
            boolean[] r0 = r15.f3767g
            boolean r5 = r0[r11]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.Z
            r8 = r0[r11]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r15.P
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r15.R
            int r1 = r15.f3768g0
            int r2 = r15.f3782n0
            int[] r10 = r15.H
            r16 = r10[r11]
            float r10 = r15.f3786p0
            r17 = 0
            r0 = r0[r17]
            r11 = r48
            if (r0 != r11) goto L_0x053e
            r18 = 1
            goto L_0x0540
        L_0x053e:
            r18 = r17
        L_0x0540:
            int r0 = r15.C
            r24 = r0
            int r0 = r15.D
            r25 = r0
            float r0 = r15.E
            r26 = r0
            r0 = r53
            r19 = r1
            r1 = r54
            r20 = r2
            r2 = 0
            r11 = r3
            r3 = r47
            r21 = r4
            r4 = r43
            r17 = r10
            r10 = r21
            r33 = r12
            r12 = r19
            r38 = r13
            r13 = r34
            r14 = r20
            r15 = r16
            r16 = r17
            r17 = r37
            r19 = r28
            r20 = r29
            r21 = r39
            r22 = r35
            r23 = r36
            r0.i(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            goto L_0x0582
        L_0x057e:
            r33 = r12
            r38 = r13
        L_0x0582:
            if (r32 == 0) goto L_0x05af
            r6 = 8
            r7 = r53
            int r0 = r7.F
            r1 = 1
            if (r0 != r1) goto L_0x059d
            float r5 = r7.G
            r0 = r54
            r1 = r33
            r2 = r38
            r3 = r30
            r4 = r31
            r0.k(r1, r2, r3, r4, r5, r6)
            goto L_0x05b1
        L_0x059d:
            float r5 = r7.G
            r6 = 8
            r0 = r54
            r1 = r30
            r2 = r31
            r3 = r33
            r4 = r38
            r0.k(r1, r2, r3, r4, r5, r6)
            goto L_0x05b1
        L_0x05af:
            r7 = r53
        L_0x05b1:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r7.V
            boolean r0 = r0.o()
            if (r0 == 0) goto L_0x05d9
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r7.V
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.j()
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r0.h()
            float r1 = r7.I
            r2 = 1119092736(0x42b40000, float:90.0)
            float r1 = r1 + r2
            double r1 = (double) r1
            double r1 = java.lang.Math.toRadians(r1)
            float r1 = (float) r1
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r7.V
            int r2 = r2.f()
            r3 = r54
            r3.b(r7, r0, r1, r2)
        L_0x05d9:
            r0 = 0
            r7.f3785p = r0
            r7.f3787q = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.g(androidx.constraintlayout.core.d, boolean):void");
    }

    public boolean g0() {
        return this.f3789r;
    }

    public void g1(DimensionBehaviour dimensionBehaviour) {
        this.Z[1] = dimensionBehaviour;
    }

    public boolean h() {
        return this.f3792s0 != 8;
    }

    public boolean h0(int i10) {
        return this.Y[i10];
    }

    public void h1(int i10, int i11, int i12, float f10) {
        this.f3801x = i10;
        this.C = i11;
        if (i12 == Integer.MAX_VALUE) {
            i12 = 0;
        }
        this.D = i12;
        this.E = f10;
        if (f10 > 0.0f && f10 < 1.0f && i10 == 0) {
            this.f3801x = 2;
        }
    }

    public boolean i0() {
        ConstraintAnchor constraintAnchor = this.O;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f3740f;
        if (constraintAnchor2 != null && constraintAnchor2.f3740f == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.Q;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f3740f;
        return constraintAnchor4 != null && constraintAnchor4.f3740f == constraintAnchor3;
    }

    public void i1(float f10) {
        this.D0[1] = f10;
    }

    public void j(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i10) {
        ConstraintAnchor.Type type3;
        ConstraintAnchor.Type type4;
        boolean z10;
        ConstraintAnchor.Type type5 = ConstraintAnchor.Type.CENTER;
        if (type != type5) {
            ConstraintAnchor.Type type6 = ConstraintAnchor.Type.CENTER_X;
            if (type == type6 && (type2 == (type4 = ConstraintAnchor.Type.LEFT) || type2 == ConstraintAnchor.Type.RIGHT)) {
                ConstraintAnchor o10 = o(type4);
                ConstraintAnchor o11 = constraintWidget.o(type2);
                ConstraintAnchor o12 = o(ConstraintAnchor.Type.RIGHT);
                o10.a(o11, 0);
                o12.a(o11, 0);
                o(type6).a(o11, 0);
                return;
            }
            ConstraintAnchor.Type type7 = ConstraintAnchor.Type.CENTER_Y;
            if (type == type7 && (type2 == (type3 = ConstraintAnchor.Type.TOP) || type2 == ConstraintAnchor.Type.BOTTOM)) {
                ConstraintAnchor o13 = constraintWidget.o(type2);
                o(type3).a(o13, 0);
                o(ConstraintAnchor.Type.BOTTOM).a(o13, 0);
                o(type7).a(o13, 0);
            } else if (type == type6 && type2 == type6) {
                ConstraintAnchor.Type type8 = ConstraintAnchor.Type.LEFT;
                o(type8).a(constraintWidget.o(type8), 0);
                ConstraintAnchor.Type type9 = ConstraintAnchor.Type.RIGHT;
                o(type9).a(constraintWidget.o(type9), 0);
                o(type6).a(constraintWidget.o(type2), 0);
            } else if (type == type7 && type2 == type7) {
                ConstraintAnchor.Type type10 = ConstraintAnchor.Type.TOP;
                o(type10).a(constraintWidget.o(type10), 0);
                ConstraintAnchor.Type type11 = ConstraintAnchor.Type.BOTTOM;
                o(type11).a(constraintWidget.o(type11), 0);
                o(type7).a(constraintWidget.o(type2), 0);
            } else {
                ConstraintAnchor o14 = o(type);
                ConstraintAnchor o15 = constraintWidget.o(type2);
                if (o14.p(o15)) {
                    ConstraintAnchor.Type type12 = ConstraintAnchor.Type.BASELINE;
                    if (type == type12) {
                        ConstraintAnchor o16 = o(ConstraintAnchor.Type.TOP);
                        ConstraintAnchor o17 = o(ConstraintAnchor.Type.BOTTOM);
                        if (o16 != null) {
                            o16.q();
                        }
                        if (o17 != null) {
                            o17.q();
                        }
                    } else if (type == ConstraintAnchor.Type.TOP || type == ConstraintAnchor.Type.BOTTOM) {
                        ConstraintAnchor o18 = o(type12);
                        if (o18 != null) {
                            o18.q();
                        }
                        ConstraintAnchor o19 = o(type5);
                        if (o19.j() != o15) {
                            o19.q();
                        }
                        ConstraintAnchor g10 = o(type).g();
                        ConstraintAnchor o20 = o(type7);
                        if (o20.o()) {
                            g10.q();
                            o20.q();
                        }
                    } else if (type == ConstraintAnchor.Type.LEFT || type == ConstraintAnchor.Type.RIGHT) {
                        ConstraintAnchor o21 = o(type5);
                        if (o21.j() != o15) {
                            o21.q();
                        }
                        ConstraintAnchor g11 = o(type).g();
                        ConstraintAnchor o22 = o(type6);
                        if (o22.o()) {
                            g11.q();
                            o22.q();
                        }
                    }
                    o14.a(o15, i10);
                }
            }
        } else if (type2 == type5) {
            ConstraintAnchor.Type type13 = ConstraintAnchor.Type.LEFT;
            ConstraintAnchor o23 = o(type13);
            ConstraintAnchor.Type type14 = ConstraintAnchor.Type.RIGHT;
            ConstraintAnchor o24 = o(type14);
            ConstraintAnchor.Type type15 = ConstraintAnchor.Type.TOP;
            ConstraintAnchor o25 = o(type15);
            ConstraintAnchor.Type type16 = ConstraintAnchor.Type.BOTTOM;
            ConstraintAnchor o26 = o(type16);
            boolean z11 = true;
            if ((o23 == null || !o23.o()) && (o24 == null || !o24.o())) {
                j(type13, constraintWidget, type13, 0);
                j(type14, constraintWidget, type14, 0);
                z10 = true;
            } else {
                z10 = false;
            }
            if ((o25 == null || !o25.o()) && (o26 == null || !o26.o())) {
                j(type15, constraintWidget, type15, 0);
                j(type16, constraintWidget, type16, 0);
            } else {
                z11 = false;
            }
            if (z10 && z11) {
                o(type5).a(constraintWidget.o(type5), 0);
            } else if (z10) {
                ConstraintAnchor.Type type17 = ConstraintAnchor.Type.CENTER_X;
                o(type17).a(constraintWidget.o(type17), 0);
            } else if (z11) {
                ConstraintAnchor.Type type18 = ConstraintAnchor.Type.CENTER_Y;
                o(type18).a(constraintWidget.o(type18), 0);
            }
        } else {
            ConstraintAnchor.Type type19 = ConstraintAnchor.Type.LEFT;
            if (type2 == type19 || type2 == ConstraintAnchor.Type.RIGHT) {
                j(type19, constraintWidget, type2, 0);
                j(ConstraintAnchor.Type.RIGHT, constraintWidget, type2, 0);
                o(type5).a(constraintWidget.o(type2), 0);
                return;
            }
            ConstraintAnchor.Type type20 = ConstraintAnchor.Type.TOP;
            if (type2 == type20 || type2 == ConstraintAnchor.Type.BOTTOM) {
                j(type20, constraintWidget, type2, 0);
                j(ConstraintAnchor.Type.BOTTOM, constraintWidget, type2, 0);
                o(type5).a(constraintWidget.o(type2), 0);
            }
        }
    }

    public boolean j0() {
        return this.K;
    }

    public void j1(int i10) {
        this.f3792s0 = i10;
    }

    public void k(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i10) {
        if (constraintAnchor.h() == this) {
            j(constraintAnchor.k(), constraintAnchor2.h(), constraintAnchor2.k(), i10);
        }
    }

    public boolean k0() {
        ConstraintAnchor constraintAnchor = this.P;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f3740f;
        if (constraintAnchor2 != null && constraintAnchor2.f3740f == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.R;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f3740f;
        return constraintAnchor4 != null && constraintAnchor4.f3740f == constraintAnchor3;
    }

    public void k1(int i10) {
        this.f3758b0 = i10;
        int i11 = this.f3780m0;
        if (i10 < i11) {
            this.f3758b0 = i11;
        }
    }

    public void l(ConstraintWidget constraintWidget, float f10, int i10) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.CENTER;
        e0(type, constraintWidget, type, i10, 0);
        this.I = f10;
    }

    public boolean l0() {
        return this.L;
    }

    public void l1(int i10) {
        if (i10 >= 0 && i10 <= 3) {
            this.f3797v = i10;
        }
    }

    public void m(d dVar) {
        dVar.q(this.O);
        dVar.q(this.P);
        dVar.q(this.Q);
        dVar.q(this.R);
        if (this.f3778l0 > 0) {
            dVar.q(this.S);
        }
    }

    public boolean m0() {
        return this.f3771i && this.f3792s0 != 8;
    }

    public void m1(int i10) {
        this.f3766f0 = i10;
    }

    public void n() {
        if (this.f3763e == null) {
            this.f3763e = new j(this);
        }
        if (this.f3765f == null) {
            this.f3765f = new l(this);
        }
    }

    public boolean n0() {
        return this.f3785p || (this.O.n() && this.Q.n());
    }

    public void n1(int i10) {
        this.f3768g0 = i10;
    }

    public ConstraintAnchor o(ConstraintAnchor.Type type) {
        switch (a.f3812a[type.ordinal()]) {
            case 1:
                return this.O;
            case 2:
                return this.P;
            case 3:
                return this.Q;
            case 4:
                return this.R;
            case 5:
                return this.S;
            case 6:
                return this.V;
            case 7:
                return this.T;
            case 8:
                return this.U;
            case 9:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public boolean o0() {
        return this.f3787q || (this.P.n() && this.R.n());
    }

    public void o1(boolean z10, boolean z11, boolean z12, boolean z13) {
        if (this.F == -1) {
            if (z12 && !z13) {
                this.F = 0;
            } else if (!z12 && z13) {
                this.F = 1;
                if (this.f3764e0 == -1) {
                    this.G = 1.0f / this.G;
                }
            }
        }
        if (this.F == 0 && (!this.P.o() || !this.R.o())) {
            this.F = 1;
        } else if (this.F == 1 && (!this.O.o() || !this.Q.o())) {
            this.F = 0;
        }
        if (this.F == -1 && (!this.P.o() || !this.R.o() || !this.O.o() || !this.Q.o())) {
            if (this.P.o() && this.R.o()) {
                this.F = 0;
            } else if (this.O.o() && this.Q.o()) {
                this.G = 1.0f / this.G;
                this.F = 1;
            }
        }
        if (this.F == -1) {
            int i10 = this.f3805z;
            if (i10 > 0 && this.C == 0) {
                this.F = 0;
            } else if (i10 == 0 && this.C > 0) {
                this.G = 1.0f / this.G;
                this.F = 1;
            }
        }
    }

    public int p() {
        return this.f3778l0;
    }

    public boolean p0() {
        return this.f3791s;
    }

    public void p1(boolean z10, boolean z11) {
        int i10;
        int i11;
        boolean k10 = z10 & this.f3763e.k();
        boolean k11 = z11 & this.f3765f.k();
        j jVar = this.f3763e;
        int i12 = jVar.f3842h.f3820g;
        l lVar = this.f3765f;
        int i13 = lVar.f3842h.f3820g;
        int i14 = jVar.f3843i.f3820g;
        int i15 = lVar.f3843i.f3820g;
        int i16 = i15 - i13;
        if (i14 - i12 < 0 || i16 < 0 || i12 == Integer.MIN_VALUE || i12 == Integer.MAX_VALUE || i13 == Integer.MIN_VALUE || i13 == Integer.MAX_VALUE || i14 == Integer.MIN_VALUE || i14 == Integer.MAX_VALUE || i15 == Integer.MIN_VALUE || i15 == Integer.MAX_VALUE) {
            i14 = 0;
            i12 = 0;
            i15 = 0;
            i13 = 0;
        }
        int i17 = i14 - i12;
        int i18 = i15 - i13;
        if (k10) {
            this.f3766f0 = i12;
        }
        if (k11) {
            this.f3768g0 = i13;
        }
        if (this.f3792s0 == 8) {
            this.f3758b0 = 0;
            this.f3760c0 = 0;
            return;
        }
        if (k10) {
            if (this.Z[0] == DimensionBehaviour.FIXED && i17 < (i11 = this.f3758b0)) {
                i17 = i11;
            }
            this.f3758b0 = i17;
            int i19 = this.f3780m0;
            if (i17 < i19) {
                this.f3758b0 = i19;
            }
        }
        if (k11) {
            if (this.Z[1] == DimensionBehaviour.FIXED && i18 < (i10 = this.f3760c0)) {
                i18 = i10;
            }
            this.f3760c0 = i18;
            int i20 = this.f3782n0;
            if (i18 < i20) {
                this.f3760c0 = i20;
            }
        }
    }

    public float q(int i10) {
        if (i10 == 0) {
            return this.f3784o0;
        }
        if (i10 == 1) {
            return this.f3786p0;
        }
        return -1.0f;
    }

    public void q0() {
        this.f3789r = true;
    }

    public void q1(d dVar, boolean z10) {
        l lVar;
        j jVar;
        int x10 = dVar.x(this.O);
        int x11 = dVar.x(this.P);
        int x12 = dVar.x(this.Q);
        int x13 = dVar.x(this.R);
        if (z10 && (jVar = this.f3763e) != null) {
            DependencyNode dependencyNode = jVar.f3842h;
            if (dependencyNode.f3823j) {
                DependencyNode dependencyNode2 = jVar.f3843i;
                if (dependencyNode2.f3823j) {
                    x10 = dependencyNode.f3820g;
                    x12 = dependencyNode2.f3820g;
                }
            }
        }
        if (z10 && (lVar = this.f3765f) != null) {
            DependencyNode dependencyNode3 = lVar.f3842h;
            if (dependencyNode3.f3823j) {
                DependencyNode dependencyNode4 = lVar.f3843i;
                if (dependencyNode4.f3823j) {
                    x11 = dependencyNode3.f3820g;
                    x13 = dependencyNode4.f3820g;
                }
            }
        }
        int i10 = x13 - x11;
        if (x12 - x10 < 0 || i10 < 0 || x10 == Integer.MIN_VALUE || x10 == Integer.MAX_VALUE || x11 == Integer.MIN_VALUE || x11 == Integer.MAX_VALUE || x12 == Integer.MIN_VALUE || x12 == Integer.MAX_VALUE || x13 == Integer.MIN_VALUE || x13 == Integer.MAX_VALUE) {
            x13 = 0;
            x10 = 0;
            x11 = 0;
            x12 = 0;
        }
        J0(x10, x11, x12, x13);
    }

    public int r() {
        return Y() + this.f3760c0;
    }

    public void r0() {
        this.f3791s = true;
    }

    public Object s() {
        return this.f3788q0;
    }

    public boolean s0() {
        DimensionBehaviour[] dimensionBehaviourArr = this.Z;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT;
        return dimensionBehaviour == dimensionBehaviour2 && dimensionBehaviourArr[1] == dimensionBehaviour2;
    }

    public String t() {
        return this.f3796u0;
    }

    public void t0() {
        this.O.q();
        this.P.q();
        this.Q.q();
        this.R.q();
        this.S.q();
        this.T.q();
        this.U.q();
        this.V.q();
        this.f3756a0 = null;
        this.I = 0.0f;
        this.f3758b0 = 0;
        this.f3760c0 = 0;
        this.f3762d0 = 0.0f;
        this.f3764e0 = -1;
        this.f3766f0 = 0;
        this.f3768g0 = 0;
        this.f3774j0 = 0;
        this.f3776k0 = 0;
        this.f3778l0 = 0;
        this.f3780m0 = 0;
        this.f3782n0 = 0;
        float f10 = K0;
        this.f3784o0 = f10;
        this.f3786p0 = f10;
        DimensionBehaviour[] dimensionBehaviourArr = this.Z;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.f3788q0 = null;
        this.f3790r0 = 0;
        this.f3792s0 = 0;
        this.f3798v0 = null;
        this.f3800w0 = false;
        this.f3802x0 = false;
        this.f3806z0 = 0;
        this.A0 = 0;
        this.B0 = false;
        this.C0 = false;
        float[] fArr = this.D0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f3793t = -1;
        this.f3795u = -1;
        int[] iArr = this.H;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f3799w = 0;
        this.f3801x = 0;
        this.B = 1.0f;
        this.E = 1.0f;
        this.A = a.e.API_PRIORITY_OTHER;
        this.D = a.e.API_PRIORITY_OTHER;
        this.f3805z = 0;
        this.C = 0;
        this.f3769h = false;
        this.F = -1;
        this.G = 1.0f;
        this.f3804y0 = false;
        boolean[] zArr = this.f3767g;
        zArr[0] = true;
        zArr[1] = true;
        this.L = false;
        boolean[] zArr2 = this.Y;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f3771i = true;
        int[] iArr2 = this.f3803y;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.f3777l = -1;
        this.f3779m = -1;
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        String str2 = "";
        if (this.f3798v0 != null) {
            str = "type: " + this.f3798v0 + " ";
        } else {
            str = str2;
        }
        sb2.append(str);
        if (this.f3796u0 != null) {
            str2 = "id: " + this.f3796u0 + " ";
        }
        sb2.append(str2);
        sb2.append("(");
        sb2.append(this.f3766f0);
        sb2.append(", ");
        sb2.append(this.f3768g0);
        sb2.append(") - (");
        sb2.append(this.f3758b0);
        sb2.append(" x ");
        sb2.append(this.f3760c0);
        sb2.append(")");
        return sb2.toString();
    }

    public DimensionBehaviour u(int i10) {
        if (i10 == 0) {
            return A();
        }
        if (i10 == 1) {
            return T();
        }
        return null;
    }

    public void u0() {
        ConstraintWidget K2 = K();
        if (K2 == null || !(K2 instanceof d) || !((d) K()).L1()) {
            int size = this.X.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.X.get(i10).q();
            }
        }
    }

    public float v() {
        return this.f3762d0;
    }

    public void v0() {
        this.f3785p = false;
        this.f3787q = false;
        this.f3789r = false;
        this.f3791s = false;
        int size = this.X.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.X.get(i10).r();
        }
    }

    public int w() {
        return this.f3764e0;
    }

    public void w0(androidx.constraintlayout.core.c cVar) {
        this.O.s(cVar);
        this.P.s(cVar);
        this.Q.s(cVar);
        this.R.s(cVar);
        this.S.s(cVar);
        this.V.s(cVar);
        this.T.s(cVar);
        this.U.s(cVar);
    }

    public int x() {
        if (this.f3792s0 == 8) {
            return 0;
        }
        return this.f3760c0;
    }

    public float y() {
        return this.f3784o0;
    }

    public int z() {
        return this.f3806z0;
    }
}
