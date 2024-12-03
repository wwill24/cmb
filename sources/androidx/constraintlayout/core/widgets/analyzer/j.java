package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;

public class j extends WidgetRun {

    /* renamed from: k  reason: collision with root package name */
    private static int[] f3882k = new int[2];

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3883a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType[] r0 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3883a = r0
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.START     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3883a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.END     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3883a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.CENTER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.j.a.<clinit>():void");
        }
    }

    public j(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.f3842h.f3818e = DependencyNode.Type.LEFT;
        this.f3843i.f3818e = DependencyNode.Type.RIGHT;
        this.f3840f = 0;
    }

    private void q(int[] iArr, int i10, int i11, int i12, int i13, float f10, int i14) {
        int i15 = i11 - i10;
        int i16 = i13 - i12;
        if (i14 == -1) {
            int i17 = (int) ((((float) i16) * f10) + 0.5f);
            int i18 = (int) ((((float) i15) / f10) + 0.5f);
            if (i17 <= i15) {
                iArr[0] = i17;
                iArr[1] = i16;
            } else if (i18 <= i16) {
                iArr[0] = i15;
                iArr[1] = i18;
            }
        } else if (i14 == 0) {
            iArr[0] = (int) ((((float) i16) * f10) + 0.5f);
            iArr[1] = i16;
        } else if (i14 == 1) {
            iArr[0] = i15;
            iArr[1] = (int) ((((float) i15) * f10) + 0.5f);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:104:0x02b9, code lost:
        if (r14 != 1) goto L_0x031e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(q0.a r17) {
        /*
            r16 = this;
            r8 = r16
            int[] r0 = androidx.constraintlayout.core.widgets.analyzer.j.a.f3883a
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = r8.f3844j
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 2
            r2 = 3
            r9 = 1
            r10 = 0
            if (r0 == r9) goto L_0x0029
            if (r0 == r1) goto L_0x0023
            if (r0 == r2) goto L_0x0017
            goto L_0x002e
        L_0x0017:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f3836b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.O
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.Q
            r3 = r17
            r8.n(r3, r1, r0, r10)
            return
        L_0x0023:
            r3 = r17
            r16.o(r17)
            goto L_0x002e
        L_0x0029:
            r3 = r17
            r16.p(r17)
        L_0x002e:
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r8.f3839e
            boolean r0 = r0.f3823j
            r11 = 1056964608(0x3f000000, float:0.5)
            if (r0 != 0) goto L_0x031e
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = r8.f3838d
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r3) goto L_0x031e
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f3836b
            int r3 = r0.f3799w
            if (r3 == r1) goto L_0x0301
            if (r3 == r2) goto L_0x0046
            goto L_0x031e
        L_0x0046:
            int r1 = r0.f3801x
            r3 = -1
            if (r1 == 0) goto L_0x008e
            if (r1 != r2) goto L_0x004e
            goto L_0x008e
        L_0x004e:
            int r0 = r0.w()
            if (r0 == r3) goto L_0x0077
            if (r0 == 0) goto L_0x0068
            if (r0 == r9) goto L_0x005a
            r0 = r10
            goto L_0x0087
        L_0x005a:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f3836b
            androidx.constraintlayout.core.widgets.analyzer.l r1 = r0.f3765f
            androidx.constraintlayout.core.widgets.analyzer.e r1 = r1.f3839e
            int r1 = r1.f3820g
            float r1 = (float) r1
            float r0 = r0.v()
            goto L_0x0084
        L_0x0068:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f3836b
            androidx.constraintlayout.core.widgets.analyzer.l r1 = r0.f3765f
            androidx.constraintlayout.core.widgets.analyzer.e r1 = r1.f3839e
            int r1 = r1.f3820g
            float r1 = (float) r1
            float r0 = r0.v()
            float r1 = r1 / r0
            goto L_0x0085
        L_0x0077:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f3836b
            androidx.constraintlayout.core.widgets.analyzer.l r1 = r0.f3765f
            androidx.constraintlayout.core.widgets.analyzer.e r1 = r1.f3839e
            int r1 = r1.f3820g
            float r1 = (float) r1
            float r0 = r0.v()
        L_0x0084:
            float r1 = r1 * r0
        L_0x0085:
            float r1 = r1 + r11
            int r0 = (int) r1
        L_0x0087:
            androidx.constraintlayout.core.widgets.analyzer.e r1 = r8.f3839e
            r1.d(r0)
            goto L_0x031e
        L_0x008e:
            androidx.constraintlayout.core.widgets.analyzer.l r1 = r0.f3765f
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r12 = r1.f3842h
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r13 = r1.f3843i
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.O
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.f3740f
            if (r1 == 0) goto L_0x009c
            r1 = r9
            goto L_0x009d
        L_0x009c:
            r1 = r10
        L_0x009d:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r0.P
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.f3740f
            if (r2 == 0) goto L_0x00a5
            r2 = r9
            goto L_0x00a6
        L_0x00a5:
            r2 = r10
        L_0x00a6:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r0.Q
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.f3740f
            if (r4 == 0) goto L_0x00ae
            r4 = r9
            goto L_0x00af
        L_0x00ae:
            r4 = r10
        L_0x00af:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r0.R
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.f3740f
            if (r5 == 0) goto L_0x00b7
            r5 = r9
            goto L_0x00b8
        L_0x00b7:
            r5 = r10
        L_0x00b8:
            int r14 = r0.w()
            if (r1 == 0) goto L_0x01ff
            if (r2 == 0) goto L_0x01ff
            if (r4 == 0) goto L_0x01ff
            if (r5 == 0) goto L_0x01ff
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f3836b
            float r15 = r0.v()
            boolean r0 = r12.f3823j
            if (r0 == 0) goto L_0x012d
            boolean r0 = r13.f3823j
            if (r0 == 0) goto L_0x012d
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f3842h
            boolean r1 = r0.f3816c
            if (r1 == 0) goto L_0x012c
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f3843i
            boolean r1 = r1.f3816c
            if (r1 != 0) goto L_0x00df
            goto L_0x012c
        L_0x00df:
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.f3825l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.f3820g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f3842h
            int r1 = r1.f3819f
            int r2 = r0 + r1
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f3843i
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.f3825l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.f3820g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f3843i
            int r1 = r1.f3819f
            int r3 = r0 - r1
            int r0 = r12.f3820g
            int r1 = r12.f3819f
            int r4 = r0 + r1
            int r0 = r13.f3820g
            int r1 = r13.f3819f
            int r5 = r0 - r1
            int[] r1 = f3882k
            r0 = r16
            r6 = r15
            r7 = r14
            r0.q(r1, r2, r3, r4, r5, r6, r7)
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r8.f3839e
            int[] r1 = f3882k
            r1 = r1[r10]
            r0.d(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f3836b
            androidx.constraintlayout.core.widgets.analyzer.l r0 = r0.f3765f
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r0.f3839e
            int[] r1 = f3882k
            r1 = r1[r9]
            r0.d(r1)
        L_0x012c:
            return
        L_0x012d:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f3842h
            boolean r1 = r0.f3823j
            if (r1 == 0) goto L_0x018a
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f3843i
            boolean r2 = r1.f3823j
            if (r2 == 0) goto L_0x018a
            boolean r2 = r12.f3816c
            if (r2 == 0) goto L_0x0189
            boolean r2 = r13.f3816c
            if (r2 != 0) goto L_0x0142
            goto L_0x0189
        L_0x0142:
            int r2 = r0.f3820g
            int r0 = r0.f3819f
            int r2 = r2 + r0
            int r0 = r1.f3820g
            int r1 = r1.f3819f
            int r3 = r0 - r1
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r12.f3825l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.f3820g
            int r1 = r12.f3819f
            int r4 = r0 + r1
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r13.f3825l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.f3820g
            int r1 = r13.f3819f
            int r5 = r0 - r1
            int[] r1 = f3882k
            r0 = r16
            r6 = r15
            r7 = r14
            r0.q(r1, r2, r3, r4, r5, r6, r7)
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r8.f3839e
            int[] r1 = f3882k
            r1 = r1[r10]
            r0.d(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f3836b
            androidx.constraintlayout.core.widgets.analyzer.l r0 = r0.f3765f
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r0.f3839e
            int[] r1 = f3882k
            r1 = r1[r9]
            r0.d(r1)
            goto L_0x018a
        L_0x0189:
            return
        L_0x018a:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f3842h
            boolean r1 = r0.f3816c
            if (r1 == 0) goto L_0x01fe
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f3843i
            boolean r1 = r1.f3816c
            if (r1 == 0) goto L_0x01fe
            boolean r1 = r12.f3816c
            if (r1 == 0) goto L_0x01fe
            boolean r1 = r13.f3816c
            if (r1 != 0) goto L_0x019f
            goto L_0x01fe
        L_0x019f:
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.f3825l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.f3820g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f3842h
            int r1 = r1.f3819f
            int r2 = r0 + r1
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f3843i
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.f3825l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.f3820g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f3843i
            int r1 = r1.f3819f
            int r3 = r0 - r1
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r12.f3825l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.f3820g
            int r1 = r12.f3819f
            int r4 = r0 + r1
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r13.f3825l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.f3820g
            int r1 = r13.f3819f
            int r5 = r0 - r1
            int[] r1 = f3882k
            r0 = r16
            r6 = r15
            r7 = r14
            r0.q(r1, r2, r3, r4, r5, r6, r7)
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r8.f3839e
            int[] r1 = f3882k
            r1 = r1[r10]
            r0.d(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f3836b
            androidx.constraintlayout.core.widgets.analyzer.l r0 = r0.f3765f
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r0.f3839e
            int[] r1 = f3882k
            r1 = r1[r9]
            r0.d(r1)
            goto L_0x031e
        L_0x01fe:
            return
        L_0x01ff:
            if (r1 == 0) goto L_0x0288
            if (r4 == 0) goto L_0x0288
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f3842h
            boolean r0 = r0.f3816c
            if (r0 == 0) goto L_0x0287
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f3843i
            boolean r0 = r0.f3816c
            if (r0 != 0) goto L_0x0211
            goto L_0x0287
        L_0x0211:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f3836b
            float r0 = r0.v()
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f3842h
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r1.f3825l
            java.lang.Object r1 = r1.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r1 = r1.f3820g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r8.f3842h
            int r2 = r2.f3819f
            int r1 = r1 + r2
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r8.f3843i
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r2 = r2.f3825l
            java.lang.Object r2 = r2.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r2
            int r2 = r2.f3820g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r4 = r8.f3843i
            int r4 = r4.f3819f
            int r2 = r2 - r4
            if (r14 == r3) goto L_0x0264
            if (r14 == 0) goto L_0x0264
            if (r14 == r9) goto L_0x0241
            goto L_0x031e
        L_0x0241:
            int r2 = r2 - r1
            int r1 = r8.g(r2, r10)
            float r2 = (float) r1
            float r2 = r2 / r0
            float r2 = r2 + r11
            int r2 = (int) r2
            int r3 = r8.g(r2, r9)
            if (r2 == r3) goto L_0x0254
            float r1 = (float) r3
            float r1 = r1 * r0
            float r1 = r1 + r11
            int r1 = (int) r1
        L_0x0254:
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r8.f3839e
            r0.d(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f3836b
            androidx.constraintlayout.core.widgets.analyzer.l r0 = r0.f3765f
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r0.f3839e
            r0.d(r3)
            goto L_0x031e
        L_0x0264:
            int r2 = r2 - r1
            int r1 = r8.g(r2, r10)
            float r2 = (float) r1
            float r2 = r2 * r0
            float r2 = r2 + r11
            int r2 = (int) r2
            int r3 = r8.g(r2, r9)
            if (r2 == r3) goto L_0x0277
            float r1 = (float) r3
            float r1 = r1 / r0
            float r1 = r1 + r11
            int r1 = (int) r1
        L_0x0277:
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r8.f3839e
            r0.d(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f3836b
            androidx.constraintlayout.core.widgets.analyzer.l r0 = r0.f3765f
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r0.f3839e
            r0.d(r3)
            goto L_0x031e
        L_0x0287:
            return
        L_0x0288:
            if (r2 == 0) goto L_0x031e
            if (r5 == 0) goto L_0x031e
            boolean r0 = r12.f3816c
            if (r0 == 0) goto L_0x0300
            boolean r0 = r13.f3816c
            if (r0 != 0) goto L_0x0295
            goto L_0x0300
        L_0x0295:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f3836b
            float r0 = r0.v()
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r12.f3825l
            java.lang.Object r1 = r1.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r1 = r1.f3820g
            int r2 = r12.f3819f
            int r1 = r1 + r2
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r2 = r13.f3825l
            java.lang.Object r2 = r2.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r2
            int r2 = r2.f3820g
            int r4 = r13.f3819f
            int r2 = r2 - r4
            if (r14 == r3) goto L_0x02de
            if (r14 == 0) goto L_0x02bc
            if (r14 == r9) goto L_0x02de
            goto L_0x031e
        L_0x02bc:
            int r2 = r2 - r1
            int r1 = r8.g(r2, r9)
            float r2 = (float) r1
            float r2 = r2 * r0
            float r2 = r2 + r11
            int r2 = (int) r2
            int r3 = r8.g(r2, r10)
            if (r2 == r3) goto L_0x02cf
            float r1 = (float) r3
            float r1 = r1 / r0
            float r1 = r1 + r11
            int r1 = (int) r1
        L_0x02cf:
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r8.f3839e
            r0.d(r3)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f3836b
            androidx.constraintlayout.core.widgets.analyzer.l r0 = r0.f3765f
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r0.f3839e
            r0.d(r1)
            goto L_0x031e
        L_0x02de:
            int r2 = r2 - r1
            int r1 = r8.g(r2, r9)
            float r2 = (float) r1
            float r2 = r2 / r0
            float r2 = r2 + r11
            int r2 = (int) r2
            int r3 = r8.g(r2, r10)
            if (r2 == r3) goto L_0x02f1
            float r1 = (float) r3
            float r1 = r1 * r0
            float r1 = r1 + r11
            int r1 = (int) r1
        L_0x02f1:
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r8.f3839e
            r0.d(r3)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f3836b
            androidx.constraintlayout.core.widgets.analyzer.l r0 = r0.f3765f
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r0.f3839e
            r0.d(r1)
            goto L_0x031e
        L_0x0300:
            return
        L_0x0301:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r0.K()
            if (r0 == 0) goto L_0x031e
            androidx.constraintlayout.core.widgets.analyzer.j r0 = r0.f3763e
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r0.f3839e
            boolean r1 = r0.f3823j
            if (r1 == 0) goto L_0x031e
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r8.f3836b
            float r1 = r1.B
            int r0 = r0.f3820g
            float r0 = (float) r0
            float r0 = r0 * r1
            float r0 = r0 + r11
            int r0 = (int) r0
            androidx.constraintlayout.core.widgets.analyzer.e r1 = r8.f3839e
            r1.d(r0)
        L_0x031e:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f3842h
            boolean r1 = r0.f3816c
            if (r1 == 0) goto L_0x043e
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f3843i
            boolean r2 = r1.f3816c
            if (r2 != 0) goto L_0x032c
            goto L_0x043e
        L_0x032c:
            boolean r0 = r0.f3823j
            if (r0 == 0) goto L_0x033b
            boolean r0 = r1.f3823j
            if (r0 == 0) goto L_0x033b
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r8.f3839e
            boolean r0 = r0.f3823j
            if (r0 == 0) goto L_0x033b
            return
        L_0x033b:
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r8.f3839e
            boolean r0 = r0.f3823j
            if (r0 != 0) goto L_0x0385
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = r8.f3838d
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r1) goto L_0x0385
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f3836b
            int r1 = r0.f3799w
            if (r1 != 0) goto L_0x0385
            boolean r0 = r0.i0()
            if (r0 != 0) goto L_0x0385
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f3842h
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.f3825l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f3843i
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r1.f3825l
            java.lang.Object r1 = r1.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r0 = r0.f3820g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r8.f3842h
            int r3 = r2.f3819f
            int r0 = r0 + r3
            int r1 = r1.f3820g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r8.f3843i
            int r3 = r3.f3819f
            int r1 = r1 + r3
            int r3 = r1 - r0
            r2.d(r0)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f3843i
            r0.d(r1)
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r8.f3839e
            r0.d(r3)
            return
        L_0x0385:
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r8.f3839e
            boolean r0 = r0.f3823j
            if (r0 != 0) goto L_0x03e9
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r0 = r8.f3838d
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r1) goto L_0x03e9
            int r0 = r8.f3835a
            if (r0 != r9) goto L_0x03e9
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f3842h
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.f3825l
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x03e9
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f3843i
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.f3825l
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x03e9
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f3842h
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.f3825l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f3843i
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r1.f3825l
            java.lang.Object r1 = r1.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r0 = r0.f3820g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r8.f3842h
            int r2 = r2.f3819f
            int r0 = r0 + r2
            int r1 = r1.f3820g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r8.f3843i
            int r2 = r2.f3819f
            int r1 = r1 + r2
            int r1 = r1 - r0
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r8.f3839e
            int r0 = r0.f3878m
            int r0 = java.lang.Math.min(r1, r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r8.f3836b
            int r2 = r1.A
            int r1 = r1.f3805z
            int r0 = java.lang.Math.max(r1, r0)
            if (r2 <= 0) goto L_0x03e4
            int r0 = java.lang.Math.min(r2, r0)
        L_0x03e4:
            androidx.constraintlayout.core.widgets.analyzer.e r1 = r8.f3839e
            r1.d(r0)
        L_0x03e9:
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r8.f3839e
            boolean r0 = r0.f3823j
            if (r0 != 0) goto L_0x03f0
            return
        L_0x03f0:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f3842h
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.f3825l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f3843i
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r1.f3825l
            java.lang.Object r1 = r1.get(r10)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r2 = r0.f3820g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r8.f3842h
            int r3 = r3.f3819f
            int r2 = r2 + r3
            int r3 = r1.f3820g
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r4 = r8.f3843i
            int r4 = r4.f3819f
            int r3 = r3 + r4
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r8.f3836b
            float r4 = r4.y()
            if (r0 != r1) goto L_0x041f
            int r2 = r0.f3820g
            int r3 = r1.f3820g
            r4 = r11
        L_0x041f:
            int r3 = r3 - r2
            androidx.constraintlayout.core.widgets.analyzer.e r0 = r8.f3839e
            int r0 = r0.f3820g
            int r3 = r3 - r0
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f3842h
            float r1 = (float) r2
            float r1 = r1 + r11
            float r2 = (float) r3
            float r2 = r2 * r4
            float r1 = r1 + r2
            int r1 = (int) r1
            r0.d(r1)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r8.f3843i
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r8.f3842h
            int r1 = r1.f3820g
            androidx.constraintlayout.core.widgets.analyzer.e r2 = r8.f3839e
            int r2 = r2.f3820g
            int r1 = r1 + r2
            r0.d(r1)
        L_0x043e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.j.a(q0.a):void");
    }

    /* access modifiers changed from: package-private */
    public void d() {
        ConstraintWidget K;
        ConstraintWidget K2;
        ConstraintWidget constraintWidget = this.f3836b;
        if (constraintWidget.f3755a) {
            this.f3839e.d(constraintWidget.W());
        }
        if (!this.f3839e.f3823j) {
            ConstraintWidget.DimensionBehaviour A = this.f3836b.A();
            this.f3838d = A;
            if (A != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                if (A == dimensionBehaviour && (K2 = this.f3836b.K()) != null && (K2.A() == ConstraintWidget.DimensionBehaviour.FIXED || K2.A() == dimensionBehaviour)) {
                    int W = (K2.W() - this.f3836b.O.f()) - this.f3836b.Q.f();
                    b(this.f3842h, K2.f3763e.f3842h, this.f3836b.O.f());
                    b(this.f3843i, K2.f3763e.f3843i, -this.f3836b.Q.f());
                    this.f3839e.d(W);
                    return;
                } else if (this.f3838d == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.f3839e.d(this.f3836b.W());
                }
            }
        } else {
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.f3838d;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            if (dimensionBehaviour2 == dimensionBehaviour3 && (K = this.f3836b.K()) != null && (K.A() == ConstraintWidget.DimensionBehaviour.FIXED || K.A() == dimensionBehaviour3)) {
                b(this.f3842h, K.f3763e.f3842h, this.f3836b.O.f());
                b(this.f3843i, K.f3763e.f3843i, -this.f3836b.Q.f());
                return;
            }
        }
        e eVar = this.f3839e;
        if (eVar.f3823j) {
            ConstraintWidget constraintWidget2 = this.f3836b;
            if (constraintWidget2.f3755a) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.W;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[0];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.f3740f;
                if (constraintAnchor2 == null || constraintAnchorArr[1].f3740f == null) {
                    if (constraintAnchor2 != null) {
                        DependencyNode h10 = h(constraintAnchor);
                        if (h10 != null) {
                            b(this.f3842h, h10, this.f3836b.W[0].f());
                            b(this.f3843i, this.f3842h, this.f3839e.f3820g);
                            return;
                        }
                        return;
                    }
                    ConstraintAnchor constraintAnchor3 = constraintAnchorArr[1];
                    if (constraintAnchor3.f3740f != null) {
                        DependencyNode h11 = h(constraintAnchor3);
                        if (h11 != null) {
                            b(this.f3843i, h11, -this.f3836b.W[1].f());
                            b(this.f3842h, this.f3843i, -this.f3839e.f3820g);
                            return;
                        }
                        return;
                    } else if (!(constraintWidget2 instanceof p0.a) && constraintWidget2.K() != null && this.f3836b.o(ConstraintAnchor.Type.CENTER).f3740f == null) {
                        b(this.f3842h, this.f3836b.K().f3763e.f3842h, this.f3836b.X());
                        b(this.f3843i, this.f3842h, this.f3839e.f3820g);
                        return;
                    } else {
                        return;
                    }
                } else if (constraintWidget2.i0()) {
                    this.f3842h.f3819f = this.f3836b.W[0].f();
                    this.f3843i.f3819f = -this.f3836b.W[1].f();
                    return;
                } else {
                    DependencyNode h12 = h(this.f3836b.W[0]);
                    if (h12 != null) {
                        b(this.f3842h, h12, this.f3836b.W[0].f());
                    }
                    DependencyNode h13 = h(this.f3836b.W[1]);
                    if (h13 != null) {
                        b(this.f3843i, h13, -this.f3836b.W[1].f());
                    }
                    this.f3842h.f3815b = true;
                    this.f3843i.f3815b = true;
                    return;
                }
            }
        }
        if (this.f3838d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget3 = this.f3836b;
            int i10 = constraintWidget3.f3799w;
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
            } else if (i10 == 3) {
                if (constraintWidget3.f3801x == 3) {
                    this.f3842h.f3814a = this;
                    this.f3843i.f3814a = this;
                    l lVar = constraintWidget3.f3765f;
                    lVar.f3842h.f3814a = this;
                    lVar.f3843i.f3814a = this;
                    eVar.f3814a = this;
                    if (constraintWidget3.k0()) {
                        this.f3839e.f3825l.add(this.f3836b.f3765f.f3839e);
                        this.f3836b.f3765f.f3839e.f3824k.add(this.f3839e);
                        l lVar2 = this.f3836b.f3765f;
                        lVar2.f3839e.f3814a = this;
                        this.f3839e.f3825l.add(lVar2.f3842h);
                        this.f3839e.f3825l.add(this.f3836b.f3765f.f3843i);
                        this.f3836b.f3765f.f3842h.f3824k.add(this.f3839e);
                        this.f3836b.f3765f.f3843i.f3824k.add(this.f3839e);
                    } else if (this.f3836b.i0()) {
                        this.f3836b.f3765f.f3839e.f3825l.add(this.f3839e);
                        this.f3839e.f3824k.add(this.f3836b.f3765f.f3839e);
                    } else {
                        this.f3836b.f3765f.f3839e.f3825l.add(this.f3839e);
                    }
                } else {
                    e eVar4 = constraintWidget3.f3765f.f3839e;
                    eVar.f3825l.add(eVar4);
                    eVar4.f3824k.add(this.f3839e);
                    this.f3836b.f3765f.f3842h.f3824k.add(this.f3839e);
                    this.f3836b.f3765f.f3843i.f3824k.add(this.f3839e);
                    e eVar5 = this.f3839e;
                    eVar5.f3815b = true;
                    eVar5.f3824k.add(this.f3842h);
                    this.f3839e.f3824k.add(this.f3843i);
                    this.f3842h.f3825l.add(this.f3839e);
                    this.f3843i.f3825l.add(this.f3839e);
                }
            }
        }
        ConstraintWidget constraintWidget4 = this.f3836b;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget4.W;
        ConstraintAnchor constraintAnchor4 = constraintAnchorArr2[0];
        ConstraintAnchor constraintAnchor5 = constraintAnchor4.f3740f;
        if (constraintAnchor5 == null || constraintAnchorArr2[1].f3740f == null) {
            if (constraintAnchor5 != null) {
                DependencyNode h14 = h(constraintAnchor4);
                if (h14 != null) {
                    b(this.f3842h, h14, this.f3836b.W[0].f());
                    c(this.f3843i, this.f3842h, 1, this.f3839e);
                    return;
                }
                return;
            }
            ConstraintAnchor constraintAnchor6 = constraintAnchorArr2[1];
            if (constraintAnchor6.f3740f != null) {
                DependencyNode h15 = h(constraintAnchor6);
                if (h15 != null) {
                    b(this.f3843i, h15, -this.f3836b.W[1].f());
                    c(this.f3842h, this.f3843i, -1, this.f3839e);
                }
            } else if (!(constraintWidget4 instanceof p0.a) && constraintWidget4.K() != null) {
                b(this.f3842h, this.f3836b.K().f3763e.f3842h, this.f3836b.X());
                c(this.f3843i, this.f3842h, 1, this.f3839e);
            }
        } else if (constraintWidget4.i0()) {
            this.f3842h.f3819f = this.f3836b.W[0].f();
            this.f3843i.f3819f = -this.f3836b.W[1].f();
        } else {
            DependencyNode h16 = h(this.f3836b.W[0]);
            DependencyNode h17 = h(this.f3836b.W[1]);
            if (h16 != null) {
                h16.b(this);
            }
            if (h17 != null) {
                h17.b(this);
            }
            this.f3844j = WidgetRun.RunType.CENTER;
        }
    }

    public void e() {
        DependencyNode dependencyNode = this.f3842h;
        if (dependencyNode.f3823j) {
            this.f3836b.m1(dependencyNode.f3820g);
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f3837c = null;
        this.f3842h.c();
        this.f3843i.c();
        this.f3839e.c();
        this.f3841g = false;
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        if (this.f3838d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.f3836b.f3799w == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void r() {
        this.f3841g = false;
        this.f3842h.c();
        this.f3842h.f3823j = false;
        this.f3843i.c();
        this.f3843i.f3823j = false;
        this.f3839e.f3823j = false;
    }

    public String toString() {
        return "HorizontalRun " + this.f3836b.t();
    }
}
