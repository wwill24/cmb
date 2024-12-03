package androidx.camera.core.impl;

final class c extends m {

    /* renamed from: b  reason: collision with root package name */
    private final int f2469b;

    /* renamed from: c  reason: collision with root package name */
    private final int f2470c;

    /* renamed from: d  reason: collision with root package name */
    private final int f2471d;

    /* renamed from: e  reason: collision with root package name */
    private final int f2472e;

    /* renamed from: f  reason: collision with root package name */
    private final int f2473f;

    /* renamed from: g  reason: collision with root package name */
    private final int f2474g;

    /* renamed from: h  reason: collision with root package name */
    private final int f2475h;

    /* renamed from: i  reason: collision with root package name */
    private final int f2476i;

    /* renamed from: j  reason: collision with root package name */
    private final int f2477j;

    /* renamed from: k  reason: collision with root package name */
    private final int f2478k;

    /* renamed from: l  reason: collision with root package name */
    private final int f2479l;

    /* renamed from: m  reason: collision with root package name */
    private final int f2480m;

    c(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21) {
        this.f2469b = i10;
        this.f2470c = i11;
        this.f2471d = i12;
        this.f2472e = i13;
        this.f2473f = i14;
        this.f2474g = i15;
        this.f2475h = i16;
        this.f2476i = i17;
        this.f2477j = i18;
        this.f2478k = i19;
        this.f2479l = i20;
        this.f2480m = i21;
    }

    public int b() {
        return this.f2478k;
    }

    public int c() {
        return this.f2480m;
    }

    public int d() {
        return this.f2477j;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        if (this.f2469b == mVar.g() && this.f2470c == mVar.i() && this.f2471d == mVar.h() && this.f2472e == mVar.l() && this.f2473f == mVar.k() && this.f2474g == mVar.o() && this.f2475h == mVar.p() && this.f2476i == mVar.n() && this.f2477j == mVar.d() && this.f2478k == mVar.b() && this.f2479l == mVar.f() && this.f2480m == mVar.c()) {
            return true;
        }
        return false;
    }

    public int f() {
        return this.f2479l;
    }

    public int g() {
        return this.f2469b;
    }

    public int h() {
        return this.f2471d;
    }

    public int hashCode() {
        return ((((((((((((((((((((((this.f2469b ^ 1000003) * 1000003) ^ this.f2470c) * 1000003) ^ this.f2471d) * 1000003) ^ this.f2472e) * 1000003) ^ this.f2473f) * 1000003) ^ this.f2474g) * 1000003) ^ this.f2475h) * 1000003) ^ this.f2476i) * 1000003) ^ this.f2477j) * 1000003) ^ this.f2478k) * 1000003) ^ this.f2479l) * 1000003) ^ this.f2480m;
    }

    public int i() {
        return this.f2470c;
    }

    public int k() {
        return this.f2473f;
    }

    public int l() {
        return this.f2472e;
    }

    public int n() {
        return this.f2476i;
    }

    public int o() {
        return this.f2474g;
    }

    public int p() {
        return this.f2475h;
    }

    public String toString() {
        return "CamcorderProfileProxy{duration=" + this.f2469b + ", quality=" + this.f2470c + ", fileFormat=" + this.f2471d + ", videoCodec=" + this.f2472e + ", videoBitRate=" + this.f2473f + ", videoFrameRate=" + this.f2474g + ", videoFrameWidth=" + this.f2475h + ", videoFrameHeight=" + this.f2476i + ", audioCodec=" + this.f2477j + ", audioBitRate=" + this.f2478k + ", audioSampleRate=" + this.f2479l + ", audioChannels=" + this.f2480m + "}";
    }
}
