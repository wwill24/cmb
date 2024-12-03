package androidx.constraintlayout.motion.widget;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import n0.a;
import r0.b;
import r0.c;
import r0.d;

public class g {

    /* renamed from: a  reason: collision with root package name */
    boolean f4046a;

    /* renamed from: b  reason: collision with root package name */
    private j f4047b;

    /* renamed from: c  reason: collision with root package name */
    private j f4048c;

    /* renamed from: d  reason: collision with root package name */
    private f f4049d;

    /* renamed from: e  reason: collision with root package name */
    private f f4050e;

    /* renamed from: f  reason: collision with root package name */
    private a[] f4051f;

    /* renamed from: g  reason: collision with root package name */
    private a f4052g;

    /* renamed from: h  reason: collision with root package name */
    float f4053h;

    /* renamed from: i  reason: collision with root package name */
    float f4054i;

    /* renamed from: j  reason: collision with root package name */
    private int[] f4055j;

    /* renamed from: k  reason: collision with root package name */
    private double[] f4056k;

    /* renamed from: l  reason: collision with root package name */
    private double[] f4057l;

    /* renamed from: m  reason: collision with root package name */
    private String[] f4058m;

    /* renamed from: n  reason: collision with root package name */
    private float[] f4059n;

    /* renamed from: o  reason: collision with root package name */
    private ArrayList<j> f4060o;

    /* renamed from: p  reason: collision with root package name */
    private HashMap<String, d> f4061p;

    /* renamed from: q  reason: collision with root package name */
    private HashMap<String, c> f4062q;

    /* renamed from: r  reason: collision with root package name */
    private HashMap<String, b> f4063r;

    /* renamed from: s  reason: collision with root package name */
    private e[] f4064s;

    /* renamed from: t  reason: collision with root package name */
    private int f4065t;

    /* renamed from: u  reason: collision with root package name */
    private View f4066u;

    /* renamed from: v  reason: collision with root package name */
    private int f4067v;

    /* renamed from: w  reason: collision with root package name */
    private float f4068w;

    /* renamed from: x  reason: collision with root package name */
    private Interpolator f4069x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f4070y;

    private float a(float f10, float[] fArr) {
        float f11 = 0.0f;
        float f12 = 1.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f13 = this.f4054i;
            if (((double) f13) != 1.0d) {
                float f14 = this.f4053h;
                if (f10 < f14) {
                    f10 = 0.0f;
                }
                if (f10 > f14 && ((double) f10) < 1.0d) {
                    f10 = Math.min((f10 - f14) * f13, 1.0f);
                }
            }
        }
        n0.b bVar = this.f4047b.f4076a;
        float f15 = Float.NaN;
        Iterator<j> it = this.f4060o.iterator();
        while (it.hasNext()) {
            j next = it.next();
            n0.b bVar2 = next.f4076a;
            if (bVar2 != null) {
                float f16 = next.f4078c;
                if (f16 < f10) {
                    bVar = bVar2;
                    f11 = f16;
                } else if (Float.isNaN(f15)) {
                    f15 = next.f4078c;
                }
            }
        }
        if (bVar != null) {
            if (!Float.isNaN(f15)) {
                f12 = f15;
            }
            float f17 = f12 - f11;
            double d10 = (double) ((f10 - f11) / f17);
            f10 = (((float) bVar.a(d10)) * f17) + f11;
            if (fArr != null) {
                fArr[0] = (float) bVar.b(d10);
            }
        }
        return f10;
    }

    public void b(double d10, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.f4051f[0].b(d10, dArr);
        this.f4051f[0].d(d10, dArr2);
        Arrays.fill(fArr2, 0.0f);
        this.f4047b.b(d10, this.f4055j, dArr, fArr, dArr2, fArr2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v59, resolved type: r0.d} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: r0.d$a} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean c(android.view.View r21, float r22, long r23, n0.c r25) {
        /*
            r20 = this;
            r0 = r20
            r11 = r21
            r1 = 0
            r2 = r22
            float r2 = r0.a(r2, r1)
            int r3 = r0.f4067v
            int r4 = androidx.constraintlayout.motion.widget.d.f4043a
            r13 = 1065353216(0x3f800000, float:1.0)
            if (r3 == r4) goto L_0x0042
            float r3 = (float) r3
            float r3 = r13 / r3
            float r4 = r2 / r3
            double r4 = (double) r4
            double r4 = java.lang.Math.floor(r4)
            float r4 = (float) r4
            float r4 = r4 * r3
            float r2 = r2 % r3
            float r2 = r2 / r3
            float r5 = r0.f4068w
            boolean r5 = java.lang.Float.isNaN(r5)
            if (r5 != 0) goto L_0x002d
            float r5 = r0.f4068w
            float r2 = r2 + r5
            float r2 = r2 % r13
        L_0x002d:
            android.view.animation.Interpolator r5 = r0.f4069x
            if (r5 == 0) goto L_0x0036
            float r2 = r5.getInterpolation(r2)
            goto L_0x0040
        L_0x0036:
            double r5 = (double) r2
            r7 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 <= 0) goto L_0x003f
            r2 = r13
            goto L_0x0040
        L_0x003f:
            r2 = 0
        L_0x0040:
            float r2 = r2 * r3
            float r2 = r2 + r4
        L_0x0042:
            r14 = r2
            java.util.HashMap<java.lang.String, r0.c> r2 = r0.f4062q
            if (r2 == 0) goto L_0x005f
            java.util.Collection r2 = r2.values()
            java.util.Iterator r2 = r2.iterator()
        L_0x004f:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x005f
            java.lang.Object r3 = r2.next()
            r0.c r3 = (r0.c) r3
            r3.b(r11, r14)
            goto L_0x004f
        L_0x005f:
            java.util.HashMap<java.lang.String, r0.d> r2 = r0.f4061p
            r15 = 0
            if (r2 == 0) goto L_0x0093
            java.util.Collection r2 = r2.values()
            java.util.Iterator r7 = r2.iterator()
            r8 = r1
            r9 = r15
        L_0x006e:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x008f
            java.lang.Object r1 = r7.next()
            r0.d r1 = (r0.d) r1
            boolean r2 = r1 instanceof r0.d.a
            if (r2 == 0) goto L_0x0082
            r8 = r1
            r0.d$a r8 = (r0.d.a) r8
            goto L_0x006e
        L_0x0082:
            r2 = r21
            r3 = r14
            r4 = r23
            r6 = r25
            boolean r1 = r1.b(r2, r3, r4, r6)
            r9 = r9 | r1
            goto L_0x006e
        L_0x008f:
            r16 = r9
            r9 = r8
            goto L_0x0096
        L_0x0093:
            r9 = r1
            r16 = r15
        L_0x0096:
            n0.a[] r1 = r0.f4051f
            r10 = 1
            if (r1 == 0) goto L_0x01f1
            r1 = r1[r15]
            double r7 = (double) r14
            double[] r2 = r0.f4056k
            r1.b(r7, r2)
            n0.a[] r1 = r0.f4051f
            r1 = r1[r15]
            double[] r2 = r0.f4057l
            r1.d(r7, r2)
            n0.a r1 = r0.f4052g
            if (r1 == 0) goto L_0x00bf
            double[] r2 = r0.f4056k
            int r3 = r2.length
            if (r3 <= 0) goto L_0x00bf
            r1.b(r7, r2)
            n0.a r1 = r0.f4052g
            double[] r2 = r0.f4057l
            r1.d(r7, r2)
        L_0x00bf:
            boolean r1 = r0.f4070y
            if (r1 != 0) goto L_0x00df
            androidx.constraintlayout.motion.widget.j r1 = r0.f4047b
            int[] r4 = r0.f4055j
            double[] r5 = r0.f4056k
            double[] r6 = r0.f4057l
            r17 = 0
            boolean r3 = r0.f4046a
            r2 = r14
            r18 = r3
            r3 = r21
            r12 = r7
            r7 = r17
            r8 = r18
            r1.c(r2, r3, r4, r5, r6, r7, r8)
            r0.f4046a = r15
            goto L_0x00e0
        L_0x00df:
            r12 = r7
        L_0x00e0:
            int r1 = r0.f4065t
            int r2 = androidx.constraintlayout.motion.widget.d.f4043a
            if (r1 == r2) goto L_0x0142
            android.view.View r1 = r0.f4066u
            if (r1 != 0) goto L_0x00f8
            android.view.ViewParent r1 = r21.getParent()
            android.view.View r1 = (android.view.View) r1
            int r2 = r0.f4065t
            android.view.View r1 = r1.findViewById(r2)
            r0.f4066u = r1
        L_0x00f8:
            android.view.View r1 = r0.f4066u
            if (r1 == 0) goto L_0x0142
            int r1 = r1.getTop()
            android.view.View r2 = r0.f4066u
            int r2 = r2.getBottom()
            int r1 = r1 + r2
            float r1 = (float) r1
            r2 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r2
            android.view.View r3 = r0.f4066u
            int r3 = r3.getLeft()
            android.view.View r4 = r0.f4066u
            int r4 = r4.getRight()
            int r3 = r3 + r4
            float r3 = (float) r3
            float r3 = r3 / r2
            int r2 = r21.getRight()
            int r4 = r21.getLeft()
            int r2 = r2 - r4
            if (r2 <= 0) goto L_0x0142
            int r2 = r21.getBottom()
            int r4 = r21.getTop()
            int r2 = r2 - r4
            if (r2 <= 0) goto L_0x0142
            int r2 = r21.getLeft()
            float r2 = (float) r2
            float r3 = r3 - r2
            int r2 = r21.getTop()
            float r2 = (float) r2
            float r1 = r1 - r2
            r11.setPivotX(r3)
            r11.setPivotY(r1)
        L_0x0142:
            java.util.HashMap<java.lang.String, r0.c> r1 = r0.f4062q
            if (r1 == 0) goto L_0x0170
            java.util.Collection r1 = r1.values()
            java.util.Iterator r8 = r1.iterator()
        L_0x014e:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x0170
            java.lang.Object r1 = r8.next()
            n0.e r1 = (n0.e) r1
            boolean r2 = r1 instanceof r0.c.a
            if (r2 == 0) goto L_0x014e
            double[] r2 = r0.f4057l
            int r3 = r2.length
            if (r3 <= r10) goto L_0x014e
            r0.c$a r1 = (r0.c.a) r1
            r4 = r2[r15]
            r6 = r2[r10]
            r2 = r21
            r3 = r14
            r1.c(r2, r3, r4, r6)
            goto L_0x014e
        L_0x0170:
            if (r9 == 0) goto L_0x018d
            double[] r1 = r0.f4057l
            r7 = r1[r15]
            r17 = r1[r10]
            r1 = r9
            r2 = r21
            r3 = r25
            r4 = r14
            r5 = r23
            r19 = r10
            r9 = r17
            boolean r1 = r1.c(r2, r3, r4, r5, r7, r9)
            r1 = r16 | r1
            r16 = r1
            goto L_0x018f
        L_0x018d:
            r19 = r10
        L_0x018f:
            r10 = r19
        L_0x0191:
            n0.a[] r1 = r0.f4051f
            int r2 = r1.length
            if (r10 >= r2) goto L_0x01b5
            r1 = r1[r10]
            float[] r2 = r0.f4059n
            r1.c(r12, r2)
            androidx.constraintlayout.motion.widget.j r1 = r0.f4047b
            java.util.LinkedHashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r1 = r1.f4090q
            java.lang.String[] r2 = r0.f4058m
            int r3 = r10 + -1
            r2 = r2[r3]
            java.lang.Object r1 = r1.get(r2)
            androidx.constraintlayout.widget.ConstraintAttribute r1 = (androidx.constraintlayout.widget.ConstraintAttribute) r1
            float[] r2 = r0.f4059n
            r0.a.b(r1, r11, r2)
            int r10 = r10 + 1
            goto L_0x0191
        L_0x01b5:
            androidx.constraintlayout.motion.widget.f r1 = r0.f4049d
            int r2 = r1.f4044a
            if (r2 != 0) goto L_0x01df
            r2 = 0
            int r2 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x01c6
            int r1 = r1.f4045b
            r11.setVisibility(r1)
            goto L_0x01df
        L_0x01c6:
            r2 = 1065353216(0x3f800000, float:1.0)
            int r2 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x01d4
            androidx.constraintlayout.motion.widget.f r1 = r0.f4050e
            int r1 = r1.f4045b
            r11.setVisibility(r1)
            goto L_0x01df
        L_0x01d4:
            androidx.constraintlayout.motion.widget.f r2 = r0.f4050e
            int r2 = r2.f4045b
            int r1 = r1.f4045b
            if (r2 == r1) goto L_0x01df
            r11.setVisibility(r15)
        L_0x01df:
            androidx.constraintlayout.motion.widget.e[] r1 = r0.f4064s
            if (r1 == 0) goto L_0x0241
            r1 = r15
        L_0x01e4:
            androidx.constraintlayout.motion.widget.e[] r2 = r0.f4064s
            int r3 = r2.length
            if (r1 >= r3) goto L_0x0241
            r2 = r2[r1]
            r2.a(r14, r11)
            int r1 = r1 + 1
            goto L_0x01e4
        L_0x01f1:
            r19 = r10
            androidx.constraintlayout.motion.widget.j r1 = r0.f4047b
            float r2 = r1.f4080e
            androidx.constraintlayout.motion.widget.j r3 = r0.f4048c
            float r4 = r3.f4080e
            float r4 = r4 - r2
            float r4 = r4 * r14
            float r2 = r2 + r4
            float r4 = r1.f4081f
            float r5 = r3.f4081f
            float r5 = r5 - r4
            float r5 = r5 * r14
            float r4 = r4 + r5
            float r5 = r1.f4082g
            float r6 = r3.f4082g
            float r7 = r6 - r5
            float r7 = r7 * r14
            float r7 = r7 + r5
            float r1 = r1.f4083h
            float r3 = r3.f4083h
            float r8 = r3 - r1
            float r8 = r8 * r14
            float r8 = r8 + r1
            r9 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 + r9
            int r10 = (int) r2
            float r4 = r4 + r9
            int r9 = (int) r4
            float r2 = r2 + r7
            int r2 = (int) r2
            float r4 = r4 + r8
            int r4 = (int) r4
            int r7 = r2 - r10
            int r8 = r4 - r9
            int r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r5 != 0) goto L_0x022f
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x022f
            boolean r1 = r0.f4046a
            if (r1 == 0) goto L_0x023e
        L_0x022f:
            r1 = 1073741824(0x40000000, float:2.0)
            int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r1)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r1)
            r11.measure(r3, r1)
            r0.f4046a = r15
        L_0x023e:
            r11.layout(r10, r9, r2, r4)
        L_0x0241:
            java.util.HashMap<java.lang.String, r0.b> r1 = r0.f4063r
            if (r1 == 0) goto L_0x0270
            java.util.Collection r1 = r1.values()
            java.util.Iterator r8 = r1.iterator()
        L_0x024d:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x0270
            java.lang.Object r1 = r8.next()
            r0.b r1 = (r0.b) r1
            boolean r2 = r1 instanceof r0.b.a
            if (r2 == 0) goto L_0x026c
            r0.b$a r1 = (r0.b.a) r1
            double[] r2 = r0.f4057l
            r4 = r2[r15]
            r6 = r2[r19]
            r2 = r21
            r3 = r14
            r1.c(r2, r3, r4, r6)
            goto L_0x024d
        L_0x026c:
            r1.b(r11, r14)
            goto L_0x024d
        L_0x0270:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.g.c(android.view.View, float, long, n0.c):boolean");
    }

    public String toString() {
        return " start: x: " + this.f4047b.f4080e + " y: " + this.f4047b.f4081f + " end: x: " + this.f4048c.f4080e + " y: " + this.f4048c.f4081f;
    }
}
