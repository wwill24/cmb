package androidx.constraintlayout.core;

import androidx.constraintlayout.core.b;
import java.util.Arrays;

public class h implements b.a {

    /* renamed from: n  reason: collision with root package name */
    private static float f3721n = 0.001f;

    /* renamed from: a  reason: collision with root package name */
    private final int f3722a = -1;

    /* renamed from: b  reason: collision with root package name */
    private int f3723b = 16;

    /* renamed from: c  reason: collision with root package name */
    private int f3724c = 16;

    /* renamed from: d  reason: collision with root package name */
    int[] f3725d = new int[16];

    /* renamed from: e  reason: collision with root package name */
    int[] f3726e = new int[16];

    /* renamed from: f  reason: collision with root package name */
    int[] f3727f = new int[16];

    /* renamed from: g  reason: collision with root package name */
    float[] f3728g = new float[16];

    /* renamed from: h  reason: collision with root package name */
    int[] f3729h = new int[16];

    /* renamed from: i  reason: collision with root package name */
    int[] f3730i = new int[16];

    /* renamed from: j  reason: collision with root package name */
    int f3731j = 0;

    /* renamed from: k  reason: collision with root package name */
    int f3732k = -1;

    /* renamed from: l  reason: collision with root package name */
    private final b f3733l;

    /* renamed from: m  reason: collision with root package name */
    protected final c f3734m;

    h(b bVar, c cVar) {
        this.f3733l = bVar;
        this.f3734m = cVar;
        clear();
    }

    private void k(SolverVariable solverVariable, int i10) {
        int[] iArr;
        int i11 = solverVariable.f3640c % this.f3724c;
        int[] iArr2 = this.f3725d;
        int i12 = iArr2[i11];
        if (i12 == -1) {
            iArr2[i11] = i10;
        } else {
            while (true) {
                iArr = this.f3726e;
                int i13 = iArr[i12];
                if (i13 == -1) {
                    break;
                }
                i12 = i13;
            }
            iArr[i12] = i10;
        }
        this.f3726e[i10] = -1;
    }

    private void l(int i10, SolverVariable solverVariable, float f10) {
        this.f3727f[i10] = solverVariable.f3640c;
        this.f3728g[i10] = f10;
        this.f3729h[i10] = -1;
        this.f3730i[i10] = -1;
        solverVariable.a(this.f3733l);
        solverVariable.f3650n++;
        this.f3731j++;
    }

    private int m() {
        for (int i10 = 0; i10 < this.f3723b; i10++) {
            if (this.f3727f[i10] == -1) {
                return i10;
            }
        }
        return -1;
    }

    private void n() {
        int i10 = this.f3723b * 2;
        this.f3727f = Arrays.copyOf(this.f3727f, i10);
        this.f3728g = Arrays.copyOf(this.f3728g, i10);
        this.f3729h = Arrays.copyOf(this.f3729h, i10);
        this.f3730i = Arrays.copyOf(this.f3730i, i10);
        this.f3726e = Arrays.copyOf(this.f3726e, i10);
        for (int i11 = this.f3723b; i11 < i10; i11++) {
            this.f3727f[i11] = -1;
            this.f3726e[i11] = -1;
        }
        this.f3723b = i10;
    }

    private void p(int i10, SolverVariable solverVariable, float f10) {
        int m10 = m();
        l(m10, solverVariable, f10);
        if (i10 != -1) {
            this.f3729h[m10] = i10;
            int[] iArr = this.f3730i;
            iArr[m10] = iArr[i10];
            iArr[i10] = m10;
        } else {
            this.f3729h[m10] = -1;
            if (this.f3731j > 0) {
                this.f3730i[m10] = this.f3732k;
                this.f3732k = m10;
            } else {
                this.f3730i[m10] = -1;
            }
        }
        int i11 = this.f3730i[m10];
        if (i11 != -1) {
            this.f3729h[i11] = m10;
        }
        k(solverVariable, m10);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void q(androidx.constraintlayout.core.SolverVariable r6) {
        /*
            r5 = this;
            int r6 = r6.f3640c
            int r0 = r5.f3724c
            int r0 = r6 % r0
            int[] r1 = r5.f3725d
            r2 = r1[r0]
            r3 = -1
            if (r2 != r3) goto L_0x000e
            return
        L_0x000e:
            int[] r4 = r5.f3727f
            r4 = r4[r2]
            if (r4 != r6) goto L_0x001d
            int[] r6 = r5.f3726e
            r4 = r6[r2]
            r1[r0] = r4
            r6[r2] = r3
            goto L_0x0039
        L_0x001d:
            int[] r0 = r5.f3726e
            r1 = r0[r2]
            if (r1 == r3) goto L_0x002b
            int[] r4 = r5.f3727f
            r4 = r4[r1]
            if (r4 == r6) goto L_0x002b
            r2 = r1
            goto L_0x001d
        L_0x002b:
            if (r1 == r3) goto L_0x0039
            int[] r4 = r5.f3727f
            r4 = r4[r1]
            if (r4 != r6) goto L_0x0039
            r6 = r0[r1]
            r0[r2] = r6
            r0[r1] = r3
        L_0x0039:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.h.q(androidx.constraintlayout.core.SolverVariable):void");
    }

    public boolean a(SolverVariable solverVariable) {
        return o(solverVariable) != -1;
    }

    public SolverVariable b(int i10) {
        int i11 = this.f3731j;
        if (i11 == 0) {
            return null;
        }
        int i12 = this.f3732k;
        for (int i13 = 0; i13 < i11; i13++) {
            if (i13 == i10 && i12 != -1) {
                return this.f3734m.f3682d[this.f3727f[i12]];
            }
            i12 = this.f3730i[i12];
            if (i12 == -1) {
                break;
            }
        }
        return null;
    }

    public void c(SolverVariable solverVariable, float f10, boolean z10) {
        float f11 = f3721n;
        if (f10 <= (-f11) || f10 >= f11) {
            int o10 = o(solverVariable);
            if (o10 == -1) {
                g(solverVariable, f10);
                return;
            }
            float[] fArr = this.f3728g;
            float f12 = fArr[o10] + f10;
            fArr[o10] = f12;
            float f13 = f3721n;
            if (f12 > (-f13) && f12 < f13) {
                fArr[o10] = 0.0f;
                d(solverVariable, z10);
            }
        }
    }

    public void clear() {
        int i10 = this.f3731j;
        for (int i11 = 0; i11 < i10; i11++) {
            SolverVariable b10 = b(i11);
            if (b10 != null) {
                b10.d(this.f3733l);
            }
        }
        for (int i12 = 0; i12 < this.f3723b; i12++) {
            this.f3727f[i12] = -1;
            this.f3726e[i12] = -1;
        }
        for (int i13 = 0; i13 < this.f3724c; i13++) {
            this.f3725d[i13] = -1;
        }
        this.f3731j = 0;
        this.f3732k = -1;
    }

    public float d(SolverVariable solverVariable, boolean z10) {
        int o10 = o(solverVariable);
        if (o10 == -1) {
            return 0.0f;
        }
        q(solverVariable);
        float f10 = this.f3728g[o10];
        if (this.f3732k == o10) {
            this.f3732k = this.f3730i[o10];
        }
        this.f3727f[o10] = -1;
        int[] iArr = this.f3729h;
        int i10 = iArr[o10];
        if (i10 != -1) {
            int[] iArr2 = this.f3730i;
            iArr2[i10] = iArr2[o10];
        }
        int i11 = this.f3730i[o10];
        if (i11 != -1) {
            iArr[i11] = iArr[o10];
        }
        this.f3731j--;
        solverVariable.f3650n--;
        if (z10) {
            solverVariable.d(this.f3733l);
        }
        return f10;
    }

    public int e() {
        return this.f3731j;
    }

    public float f(b bVar, boolean z10) {
        float i10 = i(bVar.f3673a);
        d(bVar.f3673a, z10);
        h hVar = (h) bVar.f3677e;
        int e10 = hVar.e();
        int i11 = 0;
        int i12 = 0;
        while (i11 < e10) {
            int i13 = hVar.f3727f[i12];
            if (i13 != -1) {
                c(this.f3734m.f3682d[i13], hVar.f3728g[i12] * i10, z10);
                i11++;
            }
            i12++;
        }
        return i10;
    }

    public void g(SolverVariable solverVariable, float f10) {
        float f11 = f3721n;
        if (f10 <= (-f11) || f10 >= f11) {
            if (this.f3731j == 0) {
                l(0, solverVariable, f10);
                k(solverVariable, 0);
                this.f3732k = 0;
                return;
            }
            int o10 = o(solverVariable);
            if (o10 != -1) {
                this.f3728g[o10] = f10;
                return;
            }
            if (this.f3731j + 1 >= this.f3723b) {
                n();
            }
            int i10 = this.f3731j;
            int i11 = this.f3732k;
            int i12 = -1;
            for (int i13 = 0; i13 < i10; i13++) {
                int i14 = this.f3727f[i11];
                int i15 = solverVariable.f3640c;
                if (i14 == i15) {
                    this.f3728g[i11] = f10;
                    return;
                }
                if (i14 < i15) {
                    i12 = i11;
                }
                i11 = this.f3730i[i11];
                if (i11 == -1) {
                    break;
                }
            }
            p(i12, solverVariable, f10);
            return;
        }
        d(solverVariable, true);
    }

    public float h(int i10) {
        int i11 = this.f3731j;
        int i12 = this.f3732k;
        for (int i13 = 0; i13 < i11; i13++) {
            if (i13 == i10) {
                return this.f3728g[i12];
            }
            i12 = this.f3730i[i12];
            if (i12 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    public float i(SolverVariable solverVariable) {
        int o10 = o(solverVariable);
        if (o10 != -1) {
            return this.f3728g[o10];
        }
        return 0.0f;
    }

    public void invert() {
        int i10 = this.f3731j;
        int i11 = this.f3732k;
        int i12 = 0;
        while (i12 < i10) {
            float[] fArr = this.f3728g;
            fArr[i11] = fArr[i11] * -1.0f;
            i11 = this.f3730i[i11];
            if (i11 != -1) {
                i12++;
            } else {
                return;
            }
        }
    }

    public void j(float f10) {
        int i10 = this.f3731j;
        int i11 = this.f3732k;
        int i12 = 0;
        while (i12 < i10) {
            float[] fArr = this.f3728g;
            fArr[i11] = fArr[i11] / f10;
            i11 = this.f3730i[i11];
            if (i11 != -1) {
                i12++;
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0032 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int o(androidx.constraintlayout.core.SolverVariable r4) {
        /*
            r3 = this;
            int r0 = r3.f3731j
            r1 = -1
            if (r0 == 0) goto L_0x0033
            if (r4 != 0) goto L_0x0008
            goto L_0x0033
        L_0x0008:
            int r4 = r4.f3640c
            int r0 = r3.f3724c
            int r0 = r4 % r0
            int[] r2 = r3.f3725d
            r0 = r2[r0]
            if (r0 != r1) goto L_0x0015
            return r1
        L_0x0015:
            int[] r2 = r3.f3727f
            r2 = r2[r0]
            if (r2 != r4) goto L_0x001c
            return r0
        L_0x001c:
            int[] r2 = r3.f3726e
            r0 = r2[r0]
            if (r0 == r1) goto L_0x0029
            int[] r2 = r3.f3727f
            r2 = r2[r0]
            if (r2 == r4) goto L_0x0029
            goto L_0x001c
        L_0x0029:
            if (r0 != r1) goto L_0x002c
            return r1
        L_0x002c:
            int[] r2 = r3.f3727f
            r2 = r2[r0]
            if (r2 != r4) goto L_0x0033
            return r0
        L_0x0033:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.h.o(androidx.constraintlayout.core.SolverVariable):int");
    }

    public String toString() {
        String str;
        String str2;
        String str3 = hashCode() + " { ";
        int i10 = this.f3731j;
        for (int i11 = 0; i11 < i10; i11++) {
            SolverVariable b10 = b(i11);
            if (b10 != null) {
                String str4 = str3 + b10 + " = " + h(i11) + " ";
                int o10 = o(b10);
                String str5 = str4 + "[p: ";
                if (this.f3729h[o10] != -1) {
                    str = str5 + this.f3734m.f3682d[this.f3727f[this.f3729h[o10]]];
                } else {
                    str = str5 + "none";
                }
                String str6 = str + ", n: ";
                if (this.f3730i[o10] != -1) {
                    str2 = str6 + this.f3734m.f3682d[this.f3727f[this.f3730i[o10]]];
                } else {
                    str2 = str6 + "none";
                }
                str3 = str2 + "]";
            }
        }
        return str3 + " }";
    }
}
