package androidx.core.content.res;

import androidx.annotation.NonNull;

final class n {

    /* renamed from: k  reason: collision with root package name */
    static final n f4575k = k(b.f4541c, (float) ((((double) b.h(50.0f)) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);

    /* renamed from: a  reason: collision with root package name */
    private final float f4576a;

    /* renamed from: b  reason: collision with root package name */
    private final float f4577b;

    /* renamed from: c  reason: collision with root package name */
    private final float f4578c;

    /* renamed from: d  reason: collision with root package name */
    private final float f4579d;

    /* renamed from: e  reason: collision with root package name */
    private final float f4580e;

    /* renamed from: f  reason: collision with root package name */
    private final float f4581f;

    /* renamed from: g  reason: collision with root package name */
    private final float[] f4582g;

    /* renamed from: h  reason: collision with root package name */
    private final float f4583h;

    /* renamed from: i  reason: collision with root package name */
    private final float f4584i;

    /* renamed from: j  reason: collision with root package name */
    private final float f4585j;

    private n(float f10, float f11, float f12, float f13, float f14, float f15, float[] fArr, float f16, float f17, float f18) {
        this.f4581f = f10;
        this.f4576a = f11;
        this.f4577b = f12;
        this.f4578c = f13;
        this.f4579d = f14;
        this.f4580e = f15;
        this.f4582g = fArr;
        this.f4583h = f16;
        this.f4584i = f17;
        this.f4585j = f18;
    }

    @NonNull
    static n k(@NonNull float[] fArr, float f10, float f11, float f12, boolean z10) {
        float f13;
        float f14;
        float f15 = f10;
        float[][] fArr2 = b.f4539a;
        float f16 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f17 = fArr[1];
        float f18 = fArr[2];
        float f19 = (fArr3[0] * f16) + (fArr3[1] * f17) + (fArr3[2] * f18);
        float[] fArr4 = fArr2[1];
        float f20 = (fArr4[0] * f16) + (fArr4[1] * f17) + (fArr4[2] * f18);
        float[] fArr5 = fArr2[2];
        float f21 = (f16 * fArr5[0]) + (f17 * fArr5[1]) + (f18 * fArr5[2]);
        float f22 = (f12 / 10.0f) + 0.8f;
        if (((double) f22) >= 0.9d) {
            f13 = b.d(0.59f, 0.69f, (f22 - 0.9f) * 10.0f);
        } else {
            f13 = b.d(0.525f, 0.59f, (f22 - 0.8f) * 10.0f);
        }
        float f23 = f13;
        if (z10) {
            f14 = 1.0f;
        } else {
            f14 = (1.0f - (((float) Math.exp((double) (((-f15) - 42.0f) / 92.0f))) * 0.2777778f)) * f22;
        }
        double d10 = (double) f14;
        if (d10 > 1.0d) {
            f14 = 1.0f;
        } else if (d10 < 0.0d) {
            f14 = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f19) * f14) + 1.0f) - f14, (((100.0f / f20) * f14) + 1.0f) - f14, (((100.0f / f21) * f14) + 1.0f) - f14};
        float f24 = 1.0f / ((5.0f * f15) + 1.0f);
        float f25 = f24 * f24 * f24 * f24;
        float f26 = 1.0f - f25;
        float cbrt = (f25 * f15) + (0.1f * f26 * f26 * ((float) Math.cbrt(((double) f15) * 5.0d)));
        float h10 = b.h(f11) / fArr[1];
        double d11 = (double) h10;
        float sqrt = ((float) Math.sqrt(d11)) + 1.48f;
        float pow = 0.725f / ((float) Math.pow(d11, 0.2d));
        float pow2 = (float) Math.pow(((double) ((fArr6[2] * cbrt) * f21)) / 100.0d, 0.42d);
        float[] fArr7 = {(float) Math.pow(((double) ((fArr6[0] * cbrt) * f19)) / 100.0d, 0.42d), (float) Math.pow(((double) ((fArr6[1] * cbrt) * f20)) / 100.0d, 0.42d), pow2};
        float f27 = fArr7[0];
        float f28 = (f27 * 400.0f) / (f27 + 27.13f);
        float f29 = fArr7[1];
        return new n(h10, ((f28 * 2.0f) + ((f29 * 400.0f) / (f29 + 27.13f)) + (((400.0f * pow2) / (pow2 + 27.13f)) * 0.05f)) * pow, pow, pow, f23, f22, fArr6, cbrt, (float) Math.pow((double) cbrt, 0.25d), sqrt);
    }

    /* access modifiers changed from: package-private */
    public float a() {
        return this.f4576a;
    }

    /* access modifiers changed from: package-private */
    public float b() {
        return this.f4579d;
    }

    /* access modifiers changed from: package-private */
    public float c() {
        return this.f4583h;
    }

    /* access modifiers changed from: package-private */
    public float d() {
        return this.f4584i;
    }

    /* access modifiers changed from: package-private */
    public float e() {
        return this.f4581f;
    }

    /* access modifiers changed from: package-private */
    public float f() {
        return this.f4577b;
    }

    /* access modifiers changed from: package-private */
    public float g() {
        return this.f4580e;
    }

    /* access modifiers changed from: package-private */
    public float h() {
        return this.f4578c;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public float[] i() {
        return this.f4582g;
    }

    /* access modifiers changed from: package-private */
    public float j() {
        return this.f4585j;
    }
}
