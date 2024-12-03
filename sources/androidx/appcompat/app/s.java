package androidx.appcompat.app;

class s {

    /* renamed from: d  reason: collision with root package name */
    private static s f602d;

    /* renamed from: a  reason: collision with root package name */
    public long f603a;

    /* renamed from: b  reason: collision with root package name */
    public long f604b;

    /* renamed from: c  reason: collision with root package name */
    public int f605c;

    s() {
    }

    static s b() {
        if (f602d == null) {
            f602d = new s();
        }
        return f602d;
    }

    public void a(long j10, double d10, double d11) {
        float f10 = ((float) (j10 - 946728000000L)) / 8.64E7f;
        float f11 = (0.01720197f * f10) + 6.24006f;
        double d12 = (double) f11;
        double sin = (Math.sin(d12) * 0.03341960161924362d) + d12 + (Math.sin((double) (2.0f * f11)) * 3.4906598739326E-4d) + (Math.sin((double) (f11 * 3.0f)) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double d13 = (-d11) / 360.0d;
        double round = ((double) (((float) Math.round(((double) (f10 - 9.0E-4f)) - d13)) + 9.0E-4f)) + d13 + (Math.sin(d12) * 0.0053d) + (Math.sin(2.0d * sin) * -0.0069d);
        double asin = Math.asin(Math.sin(sin) * Math.sin(0.4092797040939331d));
        double d14 = 0.01745329238474369d * d10;
        double sin2 = (Math.sin(-0.10471975803375244d) - (Math.sin(d14) * Math.sin(asin))) / (Math.cos(d14) * Math.cos(asin));
        if (sin2 >= 1.0d) {
            this.f605c = 1;
            this.f603a = -1;
            this.f604b = -1;
        } else if (sin2 <= -1.0d) {
            this.f605c = 0;
            this.f603a = -1;
            this.f604b = -1;
        } else {
            double acos = (double) ((float) (Math.acos(sin2) / 6.283185307179586d));
            this.f603a = Math.round((round + acos) * 8.64E7d) + 946728000000L;
            long round2 = Math.round((round - acos) * 8.64E7d) + 946728000000L;
            this.f604b = round2;
            if (round2 >= j10 || this.f603a <= j10) {
                this.f605c = 1;
            } else {
                this.f605c = 0;
            }
        }
    }
}
