package androidx.core.content.res;

import androidx.annotation.NonNull;

class a {

    /* renamed from: a  reason: collision with root package name */
    private final float f4530a;

    /* renamed from: b  reason: collision with root package name */
    private final float f4531b;

    /* renamed from: c  reason: collision with root package name */
    private final float f4532c;

    /* renamed from: d  reason: collision with root package name */
    private final float f4533d;

    /* renamed from: e  reason: collision with root package name */
    private final float f4534e;

    /* renamed from: f  reason: collision with root package name */
    private final float f4535f;

    /* renamed from: g  reason: collision with root package name */
    private final float f4536g;

    /* renamed from: h  reason: collision with root package name */
    private final float f4537h;

    /* renamed from: i  reason: collision with root package name */
    private final float f4538i;

    a(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18) {
        this.f4530a = f10;
        this.f4531b = f11;
        this.f4532c = f12;
        this.f4533d = f13;
        this.f4534e = f14;
        this.f4535f = f15;
        this.f4536g = f16;
        this.f4537h = f17;
        this.f4538i = f18;
    }

    private static a b(float f10, float f11, float f12) {
        float f13 = 1000.0f;
        float f14 = 0.0f;
        a aVar = null;
        float f15 = 100.0f;
        float f16 = 1000.0f;
        while (Math.abs(f14 - f15) > 0.01f) {
            float f17 = ((f15 - f14) / 2.0f) + f14;
            int p10 = e(f17, f11, f10).p();
            float b10 = b.b(p10);
            float abs = Math.abs(f12 - b10);
            if (abs < 0.2f) {
                a c10 = c(p10);
                float a10 = c10.a(e(c10.k(), c10.i(), f10));
                if (a10 <= 1.0f) {
                    aVar = c10;
                    f13 = abs;
                    f16 = a10;
                }
            }
            if (f13 == 0.0f && f16 == 0.0f) {
                break;
            } else if (b10 < f12) {
                f14 = f17;
            } else {
                f15 = f17;
            }
        }
        return aVar;
    }

    @NonNull
    static a c(int i10) {
        return d(i10, n.f4575k);
    }

    @NonNull
    static a d(int i10, @NonNull n nVar) {
        float f10;
        float[] f11 = b.f(i10);
        float[][] fArr = b.f4539a;
        float f12 = f11[0];
        float[] fArr2 = fArr[0];
        float f13 = f11[1];
        float f14 = f11[2];
        float f15 = (fArr2[0] * f12) + (fArr2[1] * f13) + (fArr2[2] * f14);
        float[] fArr3 = fArr[1];
        float f16 = (fArr3[0] * f12) + (fArr3[1] * f13) + (fArr3[2] * f14);
        float[] fArr4 = fArr[2];
        float f17 = (f12 * fArr4[0]) + (f13 * fArr4[1]) + (f14 * fArr4[2]);
        float f18 = nVar.i()[0] * f15;
        float f19 = nVar.i()[1] * f16;
        float f20 = nVar.i()[2] * f17;
        float pow = (float) Math.pow(((double) (nVar.c() * Math.abs(f18))) / 100.0d, 0.42d);
        float pow2 = (float) Math.pow(((double) (nVar.c() * Math.abs(f19))) / 100.0d, 0.42d);
        float pow3 = (float) Math.pow(((double) (nVar.c() * Math.abs(f20))) / 100.0d, 0.42d);
        float signum = ((Math.signum(f18) * 400.0f) * pow) / (pow + 27.13f);
        float signum2 = ((Math.signum(f19) * 400.0f) * pow2) / (pow2 + 27.13f);
        float signum3 = ((Math.signum(f20) * 400.0f) * pow3) / (pow3 + 27.13f);
        double d10 = (double) signum3;
        float f21 = ((float) (((((double) signum) * 11.0d) + (((double) signum2) * -12.0d)) + d10)) / 11.0f;
        float f22 = ((float) (((double) (signum + signum2)) - (d10 * 2.0d))) / 9.0f;
        float f23 = signum2 * 20.0f;
        float f24 = (((signum * 20.0f) + f23) + (21.0f * signum3)) / 20.0f;
        float f25 = (((signum * 40.0f) + f23) + signum3) / 20.0f;
        float atan2 = (((float) Math.atan2((double) f22, (double) f21)) * 180.0f) / 3.1415927f;
        if (atan2 < 0.0f) {
            atan2 += 360.0f;
        } else if (atan2 >= 360.0f) {
            atan2 -= 360.0f;
        }
        float f26 = atan2;
        float f27 = (3.1415927f * f26) / 180.0f;
        float pow4 = ((float) Math.pow((double) ((f25 * nVar.f()) / nVar.a()), (double) (nVar.b() * nVar.j()))) * 100.0f;
        float d11 = nVar.d() * (4.0f / nVar.b()) * ((float) Math.sqrt((double) (pow4 / 100.0f))) * (nVar.a() + 4.0f);
        if (((double) f26) < 20.14d) {
            f10 = 360.0f + f26;
        } else {
            f10 = f26;
        }
        float pow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, (double) nVar.e()), 0.73d)) * ((float) Math.pow((double) ((((((((float) (Math.cos(((((double) f10) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * nVar.g()) * nVar.h()) * ((float) Math.sqrt((double) ((f21 * f21) + (f22 * f22))))) / (f24 + 0.305f)), 0.9d));
        float sqrt = pow5 * ((float) Math.sqrt(((double) pow4) / 100.0d));
        float d12 = sqrt * nVar.d();
        float sqrt2 = ((float) Math.sqrt((double) ((pow5 * nVar.b()) / (nVar.a() + 4.0f)))) * 50.0f;
        float f28 = (1.7f * pow4) / ((0.007f * pow4) + 1.0f);
        float log = ((float) Math.log((double) ((0.0228f * d12) + 1.0f))) * 43.85965f;
        double d13 = (double) f27;
        return new a(f26, sqrt, pow4, d11, d12, sqrt2, f28, log * ((float) Math.cos(d13)), log * ((float) Math.sin(d13)));
    }

    @NonNull
    private static a e(float f10, float f11, float f12) {
        return f(f10, f11, f12, n.f4575k);
    }

    @NonNull
    private static a f(float f10, float f11, float f12, n nVar) {
        float f13 = f10;
        double d10 = ((double) f13) / 100.0d;
        float b10 = (4.0f / nVar.b()) * ((float) Math.sqrt(d10)) * (nVar.a() + 4.0f) * nVar.d();
        float d11 = f11 * nVar.d();
        float sqrt = ((float) Math.sqrt((double) (((f11 / ((float) Math.sqrt(d10))) * nVar.b()) / (nVar.a() + 4.0f)))) * 50.0f;
        float f14 = (1.7f * f13) / ((0.007f * f13) + 1.0f);
        float log = ((float) Math.log((((double) d11) * 0.0228d) + 1.0d)) * 43.85965f;
        double d12 = (double) ((3.1415927f * f12) / 180.0f);
        return new a(f12, f11, f13, b10, d11, sqrt, f14, log * ((float) Math.cos(d12)), log * ((float) Math.sin(d12)));
    }

    static int m(float f10, float f11, float f12) {
        return n(f10, f11, f12, n.f4575k);
    }

    static int n(float f10, float f11, float f12, @NonNull n nVar) {
        float f13;
        if (((double) f11) < 1.0d || ((double) Math.round(f12)) <= 0.0d || ((double) Math.round(f12)) >= 100.0d) {
            return b.a(f12);
        }
        if (f10 < 0.0f) {
            f13 = 0.0f;
        } else {
            f13 = Math.min(360.0f, f10);
        }
        a aVar = null;
        boolean z10 = true;
        float f14 = 0.0f;
        float f15 = f11;
        while (Math.abs(f14 - f11) >= 0.4f) {
            a b10 = b(f13, f15, f12);
            if (z10) {
                if (b10 != null) {
                    return b10.o(nVar);
                }
                z10 = false;
            } else if (b10 == null) {
                f11 = f15;
            } else {
                f14 = f15;
                aVar = b10;
            }
            f15 = ((f11 - f14) / 2.0f) + f14;
        }
        if (aVar == null) {
            return b.a(f12);
        }
        return aVar.o(nVar);
    }

    /* access modifiers changed from: package-private */
    public float a(@NonNull a aVar) {
        float l10 = l() - aVar.l();
        float g10 = g() - aVar.g();
        float h10 = h() - aVar.h();
        return (float) (Math.pow(Math.sqrt((double) ((l10 * l10) + (g10 * g10) + (h10 * h10))), 0.63d) * 1.41d);
    }

    /* access modifiers changed from: package-private */
    public float g() {
        return this.f4537h;
    }

    /* access modifiers changed from: package-private */
    public float h() {
        return this.f4538i;
    }

    /* access modifiers changed from: package-private */
    public float i() {
        return this.f4531b;
    }

    /* access modifiers changed from: package-private */
    public float j() {
        return this.f4530a;
    }

    /* access modifiers changed from: package-private */
    public float k() {
        return this.f4532c;
    }

    /* access modifiers changed from: package-private */
    public float l() {
        return this.f4536g;
    }

    /* access modifiers changed from: package-private */
    public int o(@NonNull n nVar) {
        float f10;
        if (((double) i()) == 0.0d || ((double) k()) == 0.0d) {
            f10 = 0.0f;
        } else {
            f10 = i() / ((float) Math.sqrt(((double) k()) / 100.0d));
        }
        float pow = (float) Math.pow(((double) f10) / Math.pow(1.64d - Math.pow(0.29d, (double) nVar.e()), 0.73d), 1.1111111111111112d);
        double j10 = (double) ((j() * 3.1415927f) / 180.0f);
        float a10 = nVar.a() * ((float) Math.pow(((double) k()) / 100.0d, (1.0d / ((double) nVar.b())) / ((double) nVar.j())));
        float cos = ((float) (Math.cos(2.0d + j10) + 3.8d)) * 0.25f * 3846.1538f * nVar.g() * nVar.h();
        float f11 = a10 / nVar.f();
        float sin = (float) Math.sin(j10);
        float cos2 = (float) Math.cos(j10);
        float f12 = (((0.305f + f11) * 23.0f) * pow) / (((cos * 23.0f) + ((11.0f * pow) * cos2)) + ((pow * 108.0f) * sin));
        float f13 = cos2 * f12;
        float f14 = f12 * sin;
        float f15 = f11 * 460.0f;
        float f16 = (((451.0f * f13) + f15) + (288.0f * f14)) / 1403.0f;
        float f17 = ((f15 - (891.0f * f13)) - (261.0f * f14)) / 1403.0f;
        float f18 = ((f15 - (f13 * 220.0f)) - (f14 * 6300.0f)) / 1403.0f;
        float signum = Math.signum(f16) * (100.0f / nVar.c()) * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f16)) * 27.13d) / (400.0d - ((double) Math.abs(f16))))), 2.380952380952381d));
        float signum2 = Math.signum(f17) * (100.0f / nVar.c()) * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f17)) * 27.13d) / (400.0d - ((double) Math.abs(f17))))), 2.380952380952381d));
        float signum3 = Math.signum(f18) * (100.0f / nVar.c()) * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f18)) * 27.13d) / (400.0d - ((double) Math.abs(f18))))), 2.380952380952381d));
        float f19 = signum / nVar.i()[0];
        float f20 = signum2 / nVar.i()[1];
        float f21 = signum3 / nVar.i()[2];
        float[][] fArr = b.f4540b;
        float[] fArr2 = fArr[0];
        float f22 = (fArr2[0] * f19) + (fArr2[1] * f20) + (fArr2[2] * f21);
        float[] fArr3 = fArr[1];
        float[] fArr4 = fArr[2];
        return androidx.core.graphics.a.b((double) f22, (double) ((fArr3[0] * f19) + (fArr3[1] * f20) + (fArr3[2] * f21)), (double) ((f19 * fArr4[0]) + (f20 * fArr4[1]) + (f21 * fArr4[2])));
    }

    /* access modifiers changed from: package-private */
    public int p() {
        return o(n.f4575k);
    }
}
