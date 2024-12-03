package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.c;
import f4.f;
import f4.j;
import f4.k;
import i3.d;
import i3.e;
import j3.m;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import l3.c;
import s3.t;

public final class a {

    /* renamed from: f  reason: collision with root package name */
    public static final d<DecodeFormat> f9472f = d.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.f9227c);

    /* renamed from: g  reason: collision with root package name */
    public static final d<PreferredColorSpace> f9473g = d.f("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", PreferredColorSpace.SRGB);
    @Deprecated

    /* renamed from: h  reason: collision with root package name */
    public static final d<DownsampleStrategy> f9474h = DownsampleStrategy.f9461h;

    /* renamed from: i  reason: collision with root package name */
    public static final d<Boolean> f9475i;

    /* renamed from: j  reason: collision with root package name */
    public static final d<Boolean> f9476j;

    /* renamed from: k  reason: collision with root package name */
    private static final Set<String> f9477k = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"image/vnd.wap.wbmp", "image/x-ico"})));

    /* renamed from: l  reason: collision with root package name */
    private static final b f9478l = new C0113a();

    /* renamed from: m  reason: collision with root package name */
    private static final Set<ImageHeaderParser.ImageType> f9479m = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));

    /* renamed from: n  reason: collision with root package name */
    private static final Queue<BitmapFactory.Options> f9480n = k.e(0);

    /* renamed from: a  reason: collision with root package name */
    private final m3.d f9481a;

    /* renamed from: b  reason: collision with root package name */
    private final DisplayMetrics f9482b;

    /* renamed from: c  reason: collision with root package name */
    private final m3.b f9483c;

    /* renamed from: d  reason: collision with root package name */
    private final List<ImageHeaderParser> f9484d;

    /* renamed from: e  reason: collision with root package name */
    private final b f9485e = b.a();

    /* renamed from: com.bumptech.glide.load.resource.bitmap.a$a  reason: collision with other inner class name */
    class C0113a implements b {
        C0113a() {
        }

        public void a(m3.d dVar, Bitmap bitmap) {
        }

        public void b() {
        }
    }

    public interface b {
        void a(m3.d dVar, Bitmap bitmap) throws IOException;

        void b();
    }

    static {
        Boolean bool = Boolean.FALSE;
        f9475i = d.f("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        f9476j = d.f("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
    }

    public a(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, m3.d dVar, m3.b bVar) {
        this.f9484d = list;
        this.f9482b = (DisplayMetrics) j.d(displayMetrics);
        this.f9481a = (m3.d) j.d(dVar);
        this.f9483c = (m3.b) j.d(bVar);
    }

    private static int a(double d10) {
        int l10 = l(d10);
        int x10 = x(((double) l10) * d10);
        return x((d10 / ((double) (((float) x10) / ((float) l10)))) * ((double) x10));
    }

    private void b(c cVar, DecodeFormat decodeFormat, boolean z10, boolean z11, BitmapFactory.Options options, int i10, int i11) {
        Bitmap.Config config;
        if (!this.f9485e.e(i10, i11, options, z10, z11)) {
            if (decodeFormat != DecodeFormat.PREFER_ARGB_8888) {
                boolean z12 = false;
                try {
                    z12 = cVar.d().hasAlpha();
                } catch (IOException unused) {
                    if (Log.isLoggable("Downsampler", 3)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Cannot determine whether the image has alpha or not from header, format ");
                        sb2.append(decodeFormat);
                    }
                }
                if (z12) {
                    config = Bitmap.Config.ARGB_8888;
                } else {
                    config = Bitmap.Config.RGB_565;
                }
                options.inPreferredConfig = config;
                if (config == Bitmap.Config.RGB_565) {
                    options.inDither = true;
                    return;
                }
                return;
            }
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        }
    }

    private static void c(ImageHeaderParser.ImageType imageType, c cVar, b bVar, m3.d dVar, DownsampleStrategy downsampleStrategy, int i10, int i11, int i12, int i13, int i14, BitmapFactory.Options options) throws IOException {
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        ImageHeaderParser.ImageType imageType2 = imageType;
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        int i20 = i11;
        int i21 = i12;
        int i22 = i13;
        int i23 = i14;
        BitmapFactory.Options options2 = options;
        if (i20 > 0 && i21 > 0) {
            if (r(i10)) {
                i15 = i20;
                i16 = i21;
            } else {
                i16 = i20;
                i15 = i21;
            }
            float b10 = downsampleStrategy2.b(i16, i15, i22, i23);
            if (b10 > 0.0f) {
                DownsampleStrategy.SampleSizeRounding a10 = downsampleStrategy2.a(i16, i15, i22, i23);
                if (a10 != null) {
                    float f10 = (float) i16;
                    float f11 = (float) i15;
                    int x10 = i16 / x((double) (b10 * f10));
                    int x11 = i15 / x((double) (b10 * f11));
                    DownsampleStrategy.SampleSizeRounding sampleSizeRounding = DownsampleStrategy.SampleSizeRounding.MEMORY;
                    if (a10 == sampleSizeRounding) {
                        i17 = Math.max(x10, x11);
                    } else {
                        i17 = Math.min(x10, x11);
                    }
                    int max = Math.max(1, Integer.highestOneBit(i17));
                    if (a10 == sampleSizeRounding && ((float) max) < 1.0f / b10) {
                        max <<= 1;
                    }
                    options2.inSampleSize = max;
                    if (imageType2 == ImageHeaderParser.ImageType.JPEG) {
                        float min = (float) Math.min(max, 8);
                        i18 = (int) Math.ceil((double) (f10 / min));
                        i19 = (int) Math.ceil((double) (f11 / min));
                        int i24 = max / 8;
                        if (i24 > 0) {
                            i18 /= i24;
                            i19 /= i24;
                        }
                    } else if (imageType2 == ImageHeaderParser.ImageType.PNG || imageType2 == ImageHeaderParser.ImageType.PNG_A) {
                        float f12 = (float) max;
                        i18 = (int) Math.floor((double) (f10 / f12));
                        i19 = (int) Math.floor((double) (f11 / f12));
                    } else if (imageType2 == ImageHeaderParser.ImageType.WEBP || imageType2 == ImageHeaderParser.ImageType.WEBP_A) {
                        float f13 = (float) max;
                        i18 = Math.round(f10 / f13);
                        i19 = Math.round(f11 / f13);
                    } else if (i16 % max == 0 && i15 % max == 0) {
                        i18 = i16 / max;
                        i19 = i15 / max;
                    } else {
                        int[] m10 = m(cVar, options2, bVar, dVar);
                        i18 = m10[0];
                        i19 = m10[1];
                    }
                    double b11 = (double) downsampleStrategy2.b(i18, i19, i22, i23);
                    options2.inTargetDensity = a(b11);
                    options2.inDensity = l(b11);
                    if (s(options)) {
                        options2.inScaled = true;
                    } else {
                        options2.inTargetDensity = 0;
                        options2.inDensity = 0;
                    }
                    if (Log.isLoggable("Downsampler", 2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Calculate scaling, source: [");
                        sb2.append(i11);
                        sb2.append("x");
                        sb2.append(i12);
                        sb2.append("], degreesToRotate: ");
                        sb2.append(i10);
                        sb2.append(", target: [");
                        sb2.append(i22);
                        sb2.append("x");
                        sb2.append(i23);
                        sb2.append("], power of two scaled: [");
                        sb2.append(i18);
                        sb2.append("x");
                        sb2.append(i19);
                        sb2.append("], exact scale factor: ");
                        sb2.append(b10);
                        sb2.append(", power of 2 sample size: ");
                        sb2.append(max);
                        sb2.append(", adjusted scale factor: ");
                        sb2.append(b11);
                        sb2.append(", target density: ");
                        sb2.append(options2.inTargetDensity);
                        sb2.append(", density: ");
                        sb2.append(options2.inDensity);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Cannot round with null rounding");
            }
            int i25 = i21;
            int i26 = i20;
            throw new IllegalArgumentException("Cannot scale with factor: " + b10 + " from: " + downsampleStrategy2 + ", source: [" + i26 + "x" + i25 + "], target: [" + i22 + "x" + i23 + "]");
        } else if (Log.isLoggable("Downsampler", 3)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unable to determine dimensions for: ");
            sb3.append(imageType2);
            sb3.append(" with target [");
            sb3.append(i22);
            sb3.append("x");
            sb3.append(i23);
            sb3.append("]");
        }
    }

    private c<Bitmap> e(c cVar, int i10, int i11, e eVar, b bVar) throws IOException {
        boolean z10;
        e eVar2 = eVar;
        byte[] bArr = (byte[]) this.f9483c.c(65536, byte[].class);
        BitmapFactory.Options k10 = k();
        k10.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) eVar2.a(f9472f);
        PreferredColorSpace preferredColorSpace = (PreferredColorSpace) eVar2.a(f9473g);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) eVar2.a(DownsampleStrategy.f9461h);
        boolean booleanValue = ((Boolean) eVar2.a(f9475i)).booleanValue();
        d dVar = f9476j;
        if (eVar2.a(dVar) == null || !((Boolean) eVar2.a(dVar)).booleanValue()) {
            z10 = false;
        } else {
            z10 = true;
        }
        try {
            return s3.e.d(h(cVar, k10, downsampleStrategy, decodeFormat, preferredColorSpace, z10, i10, i11, booleanValue, bVar), this.f9481a);
        } finally {
            v(k10);
            this.f9483c.put(bArr);
        }
    }

    private Bitmap h(c cVar, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, PreferredColorSpace preferredColorSpace, boolean z10, int i10, int i11, boolean z11, b bVar) throws IOException {
        boolean z12;
        int i12;
        int i13;
        int i14;
        String str;
        int i15;
        ColorSpace.Named named;
        ColorSpace colorSpace;
        int i16;
        int i17;
        float f10;
        BitmapFactory.Options options2 = options;
        b bVar2 = bVar;
        long b10 = f.b();
        int[] m10 = m(cVar, options2, bVar2, this.f9481a);
        boolean z13 = false;
        int i18 = m10[0];
        int i19 = m10[1];
        String str2 = options2.outMimeType;
        if (i18 == -1 || i19 == -1) {
            z12 = false;
        } else {
            z12 = z10;
        }
        int c10 = cVar.c();
        int g10 = t.g(c10);
        boolean j10 = t.j(c10);
        int i20 = i10;
        if (i20 == Integer.MIN_VALUE) {
            i13 = i11;
            if (r(g10)) {
                i12 = i19;
            } else {
                i12 = i18;
            }
        } else {
            i13 = i11;
            i12 = i20;
        }
        if (i13 != Integer.MIN_VALUE) {
            i14 = i13;
        } else if (r(g10)) {
            i14 = i18;
        } else {
            i14 = i19;
        }
        ImageHeaderParser.ImageType d10 = cVar.d();
        ImageHeaderParser.ImageType imageType = d10;
        c(d10, cVar, bVar, this.f9481a, downsampleStrategy, g10, i18, i19, i12, i14, options);
        int i21 = c10;
        String str3 = str2;
        int i22 = i19;
        int i23 = i18;
        b bVar3 = bVar2;
        BitmapFactory.Options options3 = options2;
        b(cVar, decodeFormat, z12, j10, options, i12, i14);
        int i24 = Build.VERSION.SDK_INT;
        int i25 = options3.inSampleSize;
        if (z(imageType)) {
            if (i23 < 0 || i22 < 0 || !z11) {
                if (s(options)) {
                    f10 = ((float) options3.inTargetDensity) / ((float) options3.inDensity);
                } else {
                    f10 = 1.0f;
                }
                int i26 = options3.inSampleSize;
                float f11 = (float) i26;
                i17 = Math.round(((float) ((int) Math.ceil((double) (((float) i23) / f11)))) * f10);
                i16 = Math.round(((float) ((int) Math.ceil((double) (((float) i22) / f11)))) * f10);
                str = "Downsampler";
                if (Log.isLoggable(str, 2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Calculated target [");
                    sb2.append(i17);
                    sb2.append("x");
                    sb2.append(i16);
                    sb2.append("] for source [");
                    sb2.append(i23);
                    sb2.append("x");
                    sb2.append(i22);
                    sb2.append("], sampleSize: ");
                    sb2.append(i26);
                    sb2.append(", targetDensity: ");
                    sb2.append(options3.inTargetDensity);
                    sb2.append(", density: ");
                    sb2.append(options3.inDensity);
                    sb2.append(", density multiplier: ");
                    sb2.append(f10);
                }
            } else {
                str = "Downsampler";
                i17 = i12;
                i16 = i14;
            }
            if (i17 > 0 && i16 > 0) {
                y(options3, this.f9481a, i17, i16);
            }
        } else {
            str = "Downsampler";
        }
        if (i24 >= 28) {
            if (preferredColorSpace == PreferredColorSpace.DISPLAY_P3 && (colorSpace = options3.outColorSpace) != null && colorSpace.isWideGamut()) {
                z13 = true;
            }
            if (z13) {
                named = ColorSpace.Named.DISPLAY_P3;
            } else {
                named = ColorSpace.Named.SRGB;
            }
            options3.inPreferredColorSpace = ColorSpace.get(named);
        } else if (i24 >= 26) {
            options3.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        Bitmap i27 = i(cVar, options3, bVar3, this.f9481a);
        bVar3.a(this.f9481a, i27);
        if (Log.isLoggable(str, 2)) {
            i15 = i21;
            t(i23, i22, str3, options, i27, i10, i11, b10);
        } else {
            i15 = i21;
        }
        Bitmap bitmap = null;
        if (i27 != null) {
            i27.setDensity(this.f9482b.densityDpi);
            bitmap = t.k(this.f9481a, i27, i15);
            if (!i27.equals(bitmap)) {
                this.f9481a.c(i27);
            }
        }
        return bitmap;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0047 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap i(com.bumptech.glide.load.resource.bitmap.c r4, android.graphics.BitmapFactory.Options r5, com.bumptech.glide.load.resource.bitmap.a.b r6, m3.d r7) throws java.io.IOException {
        /*
            boolean r0 = r5.inJustDecodeBounds
            if (r0 != 0) goto L_0x000a
            r6.b()
            r4.b()
        L_0x000a:
            int r0 = r5.outWidth
            int r1 = r5.outHeight
            java.lang.String r2 = r5.outMimeType
            java.util.concurrent.locks.Lock r3 = s3.t.f()
            r3.lock()
            android.graphics.Bitmap r4 = r4.a(r5)     // Catch:{ IllegalArgumentException -> 0x0025 }
            java.util.concurrent.locks.Lock r5 = s3.t.f()
            r5.unlock()
            return r4
        L_0x0023:
            r4 = move-exception
            goto L_0x0049
        L_0x0025:
            r3 = move-exception
            java.io.IOException r0 = u(r3, r0, r1, r2, r5)     // Catch:{ all -> 0x0023 }
            java.lang.String r1 = "Downsampler"
            r2 = 3
            boolean r1 = android.util.Log.isLoggable(r1, r2)     // Catch:{ all -> 0x0023 }
            android.graphics.Bitmap r1 = r5.inBitmap     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x0048
            r7.c(r1)     // Catch:{ IOException -> 0x0047 }
            r1 = 0
            r5.inBitmap = r1     // Catch:{ IOException -> 0x0047 }
            android.graphics.Bitmap r4 = i(r4, r5, r6, r7)     // Catch:{ IOException -> 0x0047 }
            java.util.concurrent.locks.Lock r5 = s3.t.f()
            r5.unlock()
            return r4
        L_0x0047:
            throw r0     // Catch:{ all -> 0x0023 }
        L_0x0048:
            throw r0     // Catch:{ all -> 0x0023 }
        L_0x0049:
            java.util.concurrent.locks.Lock r5 = s3.t.f()
            r5.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.a.i(com.bumptech.glide.load.resource.bitmap.c, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.a$b, m3.d):android.graphics.Bitmap");
    }

    @TargetApi(19)
    private static String j(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    private static synchronized BitmapFactory.Options k() {
        BitmapFactory.Options poll;
        synchronized (a.class) {
            Queue<BitmapFactory.Options> queue = f9480n;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                w(poll);
            }
        }
        return poll;
    }

    private static int l(double d10) {
        if (d10 > 1.0d) {
            d10 = 1.0d / d10;
        }
        return (int) Math.round(d10 * 2.147483647E9d);
    }

    private static int[] m(c cVar, BitmapFactory.Options options, b bVar, m3.d dVar) throws IOException {
        options.inJustDecodeBounds = true;
        i(cVar, options, bVar, dVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static String n(BitmapFactory.Options options) {
        return j(options.inBitmap);
    }

    private static boolean r(int i10) {
        return i10 == 90 || i10 == 270;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r1.inDensity;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean s(android.graphics.BitmapFactory.Options r1) {
        /*
            int r0 = r1.inTargetDensity
            if (r0 <= 0) goto L_0x000c
            int r1 = r1.inDensity
            if (r1 <= 0) goto L_0x000c
            if (r0 == r1) goto L_0x000c
            r1 = 1
            goto L_0x000d
        L_0x000c:
            r1 = 0
        L_0x000d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.a.s(android.graphics.BitmapFactory$Options):boolean");
    }

    private static void t(int i10, int i11, String str, BitmapFactory.Options options, Bitmap bitmap, int i12, int i13, long j10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Decoded ");
        sb2.append(j(bitmap));
        sb2.append(" from [");
        sb2.append(i10);
        sb2.append("x");
        sb2.append(i11);
        sb2.append("] ");
        sb2.append(str);
        sb2.append(" with inBitmap ");
        sb2.append(n(options));
        sb2.append(" for [");
        sb2.append(i12);
        sb2.append("x");
        sb2.append(i13);
        sb2.append("], sample size: ");
        sb2.append(options.inSampleSize);
        sb2.append(", density: ");
        sb2.append(options.inDensity);
        sb2.append(", target density: ");
        sb2.append(options.inTargetDensity);
        sb2.append(", thread: ");
        sb2.append(Thread.currentThread().getName());
        sb2.append(", duration: ");
        sb2.append(f.a(j10));
    }

    private static IOException u(IllegalArgumentException illegalArgumentException, int i10, int i11, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i10 + ", outHeight: " + i11 + ", outMimeType: " + str + ", inBitmap: " + n(options), illegalArgumentException);
    }

    private static void v(BitmapFactory.Options options) {
        w(options);
        Queue<BitmapFactory.Options> queue = f9480n;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    private static void w(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    private static int x(double d10) {
        return (int) (d10 + 0.5d);
    }

    @TargetApi(26)
    private static void y(BitmapFactory.Options options, m3.d dVar, int i10, int i11) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig != Bitmap.Config.HARDWARE) {
            config = options.outConfig;
        } else {
            return;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = dVar.e(i10, i11, config);
    }

    private boolean z(ImageHeaderParser.ImageType imageType) {
        return true;
    }

    public c<Bitmap> d(ParcelFileDescriptor parcelFileDescriptor, int i10, int i11, e eVar) throws IOException {
        return e(new c.b(parcelFileDescriptor, this.f9484d, this.f9483c), i10, i11, eVar, f9478l);
    }

    public l3.c<Bitmap> f(InputStream inputStream, int i10, int i11, e eVar) throws IOException {
        return g(inputStream, i10, i11, eVar, f9478l);
    }

    public l3.c<Bitmap> g(InputStream inputStream, int i10, int i11, e eVar, b bVar) throws IOException {
        return e(new c.a(inputStream, this.f9484d, this.f9483c), i10, i11, eVar, bVar);
    }

    public boolean o(ParcelFileDescriptor parcelFileDescriptor) {
        return m.c();
    }

    public boolean p(InputStream inputStream) {
        return true;
    }

    public boolean q(ByteBuffer byteBuffer) {
        return true;
    }
}
