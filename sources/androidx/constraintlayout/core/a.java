package androidx.constraintlayout.core;

import androidx.constraintlayout.core.b;
import java.util.Arrays;

public class a implements b.a {

    /* renamed from: l  reason: collision with root package name */
    private static float f3661l = 0.001f;

    /* renamed from: a  reason: collision with root package name */
    int f3662a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final b f3663b;

    /* renamed from: c  reason: collision with root package name */
    protected final c f3664c;

    /* renamed from: d  reason: collision with root package name */
    private int f3665d = 8;

    /* renamed from: e  reason: collision with root package name */
    private SolverVariable f3666e = null;

    /* renamed from: f  reason: collision with root package name */
    private int[] f3667f = new int[8];

    /* renamed from: g  reason: collision with root package name */
    private int[] f3668g = new int[8];

    /* renamed from: h  reason: collision with root package name */
    private float[] f3669h = new float[8];

    /* renamed from: i  reason: collision with root package name */
    private int f3670i = -1;

    /* renamed from: j  reason: collision with root package name */
    private int f3671j = -1;

    /* renamed from: k  reason: collision with root package name */
    private boolean f3672k = false;

    a(b bVar, c cVar) {
        this.f3663b = bVar;
        this.f3664c = cVar;
    }

    public boolean a(SolverVariable solverVariable) {
        int i10 = this.f3670i;
        if (i10 == -1) {
            return false;
        }
        int i11 = 0;
        while (i10 != -1 && i11 < this.f3662a) {
            if (this.f3667f[i10] == solverVariable.f3640c) {
                return true;
            }
            i10 = this.f3668g[i10];
            i11++;
        }
        return false;
    }

    public SolverVariable b(int i10) {
        int i11 = this.f3670i;
        int i12 = 0;
        while (i11 != -1 && i12 < this.f3662a) {
            if (i12 == i10) {
                return this.f3664c.f3682d[this.f3667f[i11]];
            }
            i11 = this.f3668g[i11];
            i12++;
        }
        return null;
    }

    public void c(SolverVariable solverVariable, float f10, boolean z10) {
        float f11 = f3661l;
        if (f10 <= (-f11) || f10 >= f11) {
            int i10 = this.f3670i;
            if (i10 == -1) {
                this.f3670i = 0;
                this.f3669h[0] = f10;
                this.f3667f[0] = solverVariable.f3640c;
                this.f3668g[0] = -1;
                solverVariable.f3650n++;
                solverVariable.a(this.f3663b);
                this.f3662a++;
                if (!this.f3672k) {
                    int i11 = this.f3671j + 1;
                    this.f3671j = i11;
                    int[] iArr = this.f3667f;
                    if (i11 >= iArr.length) {
                        this.f3672k = true;
                        this.f3671j = iArr.length - 1;
                        return;
                    }
                    return;
                }
                return;
            }
            int i12 = 0;
            int i13 = -1;
            while (i10 != -1 && i12 < this.f3662a) {
                int i14 = this.f3667f[i10];
                int i15 = solverVariable.f3640c;
                if (i14 == i15) {
                    float[] fArr = this.f3669h;
                    float f12 = fArr[i10] + f10;
                    float f13 = f3661l;
                    if (f12 > (-f13) && f12 < f13) {
                        f12 = 0.0f;
                    }
                    fArr[i10] = f12;
                    if (f12 == 0.0f) {
                        if (i10 == this.f3670i) {
                            this.f3670i = this.f3668g[i10];
                        } else {
                            int[] iArr2 = this.f3668g;
                            iArr2[i13] = iArr2[i10];
                        }
                        if (z10) {
                            solverVariable.d(this.f3663b);
                        }
                        if (this.f3672k) {
                            this.f3671j = i10;
                        }
                        solverVariable.f3650n--;
                        this.f3662a--;
                        return;
                    }
                    return;
                }
                if (i14 < i15) {
                    i13 = i10;
                }
                i10 = this.f3668g[i10];
                i12++;
            }
            int i16 = this.f3671j;
            int i17 = i16 + 1;
            if (this.f3672k) {
                int[] iArr3 = this.f3667f;
                if (iArr3[i16] != -1) {
                    i16 = iArr3.length;
                }
            } else {
                i16 = i17;
            }
            int[] iArr4 = this.f3667f;
            if (i16 >= iArr4.length && this.f3662a < iArr4.length) {
                int i18 = 0;
                while (true) {
                    int[] iArr5 = this.f3667f;
                    if (i18 >= iArr5.length) {
                        break;
                    } else if (iArr5[i18] == -1) {
                        i16 = i18;
                        break;
                    } else {
                        i18++;
                    }
                }
            }
            int[] iArr6 = this.f3667f;
            if (i16 >= iArr6.length) {
                i16 = iArr6.length;
                int i19 = this.f3665d * 2;
                this.f3665d = i19;
                this.f3672k = false;
                this.f3671j = i16 - 1;
                this.f3669h = Arrays.copyOf(this.f3669h, i19);
                this.f3667f = Arrays.copyOf(this.f3667f, this.f3665d);
                this.f3668g = Arrays.copyOf(this.f3668g, this.f3665d);
            }
            this.f3667f[i16] = solverVariable.f3640c;
            this.f3669h[i16] = f10;
            if (i13 != -1) {
                int[] iArr7 = this.f3668g;
                iArr7[i16] = iArr7[i13];
                iArr7[i13] = i16;
            } else {
                this.f3668g[i16] = this.f3670i;
                this.f3670i = i16;
            }
            solverVariable.f3650n++;
            solverVariable.a(this.f3663b);
            this.f3662a++;
            if (!this.f3672k) {
                this.f3671j++;
            }
            int i20 = this.f3671j;
            int[] iArr8 = this.f3667f;
            if (i20 >= iArr8.length) {
                this.f3672k = true;
                this.f3671j = iArr8.length - 1;
            }
        }
    }

    public final void clear() {
        int i10 = this.f3670i;
        int i11 = 0;
        while (i10 != -1 && i11 < this.f3662a) {
            SolverVariable solverVariable = this.f3664c.f3682d[this.f3667f[i10]];
            if (solverVariable != null) {
                solverVariable.d(this.f3663b);
            }
            i10 = this.f3668g[i10];
            i11++;
        }
        this.f3670i = -1;
        this.f3671j = -1;
        this.f3672k = false;
        this.f3662a = 0;
    }

    public final float d(SolverVariable solverVariable, boolean z10) {
        if (this.f3666e == solverVariable) {
            this.f3666e = null;
        }
        int i10 = this.f3670i;
        if (i10 == -1) {
            return 0.0f;
        }
        int i11 = 0;
        int i12 = -1;
        while (i10 != -1 && i11 < this.f3662a) {
            if (this.f3667f[i10] == solverVariable.f3640c) {
                if (i10 == this.f3670i) {
                    this.f3670i = this.f3668g[i10];
                } else {
                    int[] iArr = this.f3668g;
                    iArr[i12] = iArr[i10];
                }
                if (z10) {
                    solverVariable.d(this.f3663b);
                }
                solverVariable.f3650n--;
                this.f3662a--;
                this.f3667f[i10] = -1;
                if (this.f3672k) {
                    this.f3671j = i10;
                }
                return this.f3669h[i10];
            }
            i11++;
            i12 = i10;
            i10 = this.f3668g[i10];
        }
        return 0.0f;
    }

    public int e() {
        return this.f3662a;
    }

    public float f(b bVar, boolean z10) {
        float i10 = i(bVar.f3673a);
        d(bVar.f3673a, z10);
        b.a aVar = bVar.f3677e;
        int e10 = aVar.e();
        for (int i11 = 0; i11 < e10; i11++) {
            SolverVariable b10 = aVar.b(i11);
            c(b10, aVar.i(b10) * i10, z10);
        }
        return i10;
    }

    public final void g(SolverVariable solverVariable, float f10) {
        if (f10 == 0.0f) {
            d(solverVariable, true);
            return;
        }
        int i10 = this.f3670i;
        if (i10 == -1) {
            this.f3670i = 0;
            this.f3669h[0] = f10;
            this.f3667f[0] = solverVariable.f3640c;
            this.f3668g[0] = -1;
            solverVariable.f3650n++;
            solverVariable.a(this.f3663b);
            this.f3662a++;
            if (!this.f3672k) {
                int i11 = this.f3671j + 1;
                this.f3671j = i11;
                int[] iArr = this.f3667f;
                if (i11 >= iArr.length) {
                    this.f3672k = true;
                    this.f3671j = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i12 = 0;
        int i13 = -1;
        while (i10 != -1 && i12 < this.f3662a) {
            int i14 = this.f3667f[i10];
            int i15 = solverVariable.f3640c;
            if (i14 == i15) {
                this.f3669h[i10] = f10;
                return;
            }
            if (i14 < i15) {
                i13 = i10;
            }
            i10 = this.f3668g[i10];
            i12++;
        }
        int i16 = this.f3671j;
        int i17 = i16 + 1;
        if (this.f3672k) {
            int[] iArr2 = this.f3667f;
            if (iArr2[i16] != -1) {
                i16 = iArr2.length;
            }
        } else {
            i16 = i17;
        }
        int[] iArr3 = this.f3667f;
        if (i16 >= iArr3.length && this.f3662a < iArr3.length) {
            int i18 = 0;
            while (true) {
                int[] iArr4 = this.f3667f;
                if (i18 >= iArr4.length) {
                    break;
                } else if (iArr4[i18] == -1) {
                    i16 = i18;
                    break;
                } else {
                    i18++;
                }
            }
        }
        int[] iArr5 = this.f3667f;
        if (i16 >= iArr5.length) {
            i16 = iArr5.length;
            int i19 = this.f3665d * 2;
            this.f3665d = i19;
            this.f3672k = false;
            this.f3671j = i16 - 1;
            this.f3669h = Arrays.copyOf(this.f3669h, i19);
            this.f3667f = Arrays.copyOf(this.f3667f, this.f3665d);
            this.f3668g = Arrays.copyOf(this.f3668g, this.f3665d);
        }
        this.f3667f[i16] = solverVariable.f3640c;
        this.f3669h[i16] = f10;
        if (i13 != -1) {
            int[] iArr6 = this.f3668g;
            iArr6[i16] = iArr6[i13];
            iArr6[i13] = i16;
        } else {
            this.f3668g[i16] = this.f3670i;
            this.f3670i = i16;
        }
        solverVariable.f3650n++;
        solverVariable.a(this.f3663b);
        int i20 = this.f3662a + 1;
        this.f3662a = i20;
        if (!this.f3672k) {
            this.f3671j++;
        }
        int[] iArr7 = this.f3667f;
        if (i20 >= iArr7.length) {
            this.f3672k = true;
        }
        if (this.f3671j >= iArr7.length) {
            this.f3672k = true;
            this.f3671j = iArr7.length - 1;
        }
    }

    public float h(int i10) {
        int i11 = this.f3670i;
        int i12 = 0;
        while (i11 != -1 && i12 < this.f3662a) {
            if (i12 == i10) {
                return this.f3669h[i11];
            }
            i11 = this.f3668g[i11];
            i12++;
        }
        return 0.0f;
    }

    public final float i(SolverVariable solverVariable) {
        int i10 = this.f3670i;
        int i11 = 0;
        while (i10 != -1 && i11 < this.f3662a) {
            if (this.f3667f[i10] == solverVariable.f3640c) {
                return this.f3669h[i10];
            }
            i10 = this.f3668g[i10];
            i11++;
        }
        return 0.0f;
    }

    public void invert() {
        int i10 = this.f3670i;
        int i11 = 0;
        while (i10 != -1 && i11 < this.f3662a) {
            float[] fArr = this.f3669h;
            fArr[i10] = fArr[i10] * -1.0f;
            i10 = this.f3668g[i10];
            i11++;
        }
    }

    public void j(float f10) {
        int i10 = this.f3670i;
        int i11 = 0;
        while (i10 != -1 && i11 < this.f3662a) {
            float[] fArr = this.f3669h;
            fArr[i10] = fArr[i10] / f10;
            i10 = this.f3668g[i10];
            i11++;
        }
    }

    public String toString() {
        int i10 = this.f3670i;
        String str = "";
        int i11 = 0;
        while (i10 != -1 && i11 < this.f3662a) {
            str = ((str + " -> ") + this.f3669h[i10] + " : ") + this.f3664c.f3682d[this.f3667f[i10]];
            i10 = this.f3668g[i10];
            i11++;
        }
        return str;
    }
}
