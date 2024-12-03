package com.bumptech.glide.load.resource.bitmap;

public abstract class DownsampleStrategy {

    /* renamed from: a  reason: collision with root package name */
    public static final DownsampleStrategy f9454a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final DownsampleStrategy f9455b = new b();

    /* renamed from: c  reason: collision with root package name */
    public static final DownsampleStrategy f9456c = new e();

    /* renamed from: d  reason: collision with root package name */
    public static final DownsampleStrategy f9457d = new c();

    /* renamed from: e  reason: collision with root package name */
    public static final DownsampleStrategy f9458e;

    /* renamed from: f  reason: collision with root package name */
    public static final DownsampleStrategy f9459f = new f();

    /* renamed from: g  reason: collision with root package name */
    public static final DownsampleStrategy f9460g;

    /* renamed from: h  reason: collision with root package name */
    public static final i3.d<DownsampleStrategy> f9461h;

    /* renamed from: i  reason: collision with root package name */
    static final boolean f9462i = true;

    public enum SampleSizeRounding {
        MEMORY,
        QUALITY
    }

    private static class a extends DownsampleStrategy {
        a() {
        }

        public SampleSizeRounding a(int i10, int i11, int i12, int i13) {
            return SampleSizeRounding.QUALITY;
        }

        public float b(int i10, int i11, int i12, int i13) {
            int min = Math.min(i11 / i13, i10 / i12);
            if (min == 0) {
                return 1.0f;
            }
            return 1.0f / ((float) Integer.highestOneBit(min));
        }
    }

    private static class b extends DownsampleStrategy {
        b() {
        }

        public SampleSizeRounding a(int i10, int i11, int i12, int i13) {
            return SampleSizeRounding.MEMORY;
        }

        public float b(int i10, int i11, int i12, int i13) {
            int ceil = (int) Math.ceil((double) Math.max(((float) i11) / ((float) i13), ((float) i10) / ((float) i12)));
            int i14 = 1;
            int max = Math.max(1, Integer.highestOneBit(ceil));
            if (max >= ceil) {
                i14 = 0;
            }
            return 1.0f / ((float) (max << i14));
        }
    }

    private static class c extends DownsampleStrategy {
        c() {
        }

        public SampleSizeRounding a(int i10, int i11, int i12, int i13) {
            if (b(i10, i11, i12, i13) == 1.0f) {
                return SampleSizeRounding.QUALITY;
            }
            return DownsampleStrategy.f9456c.a(i10, i11, i12, i13);
        }

        public float b(int i10, int i11, int i12, int i13) {
            return Math.min(1.0f, DownsampleStrategy.f9456c.b(i10, i11, i12, i13));
        }
    }

    private static class d extends DownsampleStrategy {
        d() {
        }

        public SampleSizeRounding a(int i10, int i11, int i12, int i13) {
            return SampleSizeRounding.QUALITY;
        }

        public float b(int i10, int i11, int i12, int i13) {
            return Math.max(((float) i12) / ((float) i10), ((float) i13) / ((float) i11));
        }
    }

    private static class e extends DownsampleStrategy {
        e() {
        }

        public SampleSizeRounding a(int i10, int i11, int i12, int i13) {
            if (DownsampleStrategy.f9462i) {
                return SampleSizeRounding.QUALITY;
            }
            return SampleSizeRounding.MEMORY;
        }

        public float b(int i10, int i11, int i12, int i13) {
            if (DownsampleStrategy.f9462i) {
                return Math.min(((float) i12) / ((float) i10), ((float) i13) / ((float) i11));
            }
            int max = Math.max(i11 / i13, i10 / i12);
            if (max == 0) {
                return 1.0f;
            }
            return 1.0f / ((float) Integer.highestOneBit(max));
        }
    }

    private static class f extends DownsampleStrategy {
        f() {
        }

        public SampleSizeRounding a(int i10, int i11, int i12, int i13) {
            return SampleSizeRounding.QUALITY;
        }

        public float b(int i10, int i11, int i12, int i13) {
            return 1.0f;
        }
    }

    static {
        d dVar = new d();
        f9458e = dVar;
        f9460g = dVar;
        f9461h = i3.d.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", dVar);
    }

    public abstract SampleSizeRounding a(int i10, int i11, int i12, int i13);

    public abstract float b(int i10, int i11, int i12, int i13);
}
