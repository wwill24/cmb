package coil.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import coil.ImageLoader;
import coil.decode.e;
import coil.decode.k;
import coil.fetch.l;
import coil.request.k;
import coil.size.Scale;
import coil.size.g;
import com.google.android.gms.common.api.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.sync.e;
import kotlinx.coroutines.sync.f;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;

@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00042\u00020\u0001:\u0003\n\u0010\bB+\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u0014\u0010\b\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0014\u0010\t\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0013\u0010\n\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0017\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcoil/decode/BitmapFactoryDecoder;", "Lcoil/decode/e;", "Landroid/graphics/BitmapFactory$Options;", "Lcoil/decode/c;", "e", "Lcoil/decode/f;", "exifData", "", "c", "d", "a", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lcoil/decode/k;", "Lcoil/decode/k;", "source", "Lcoil/request/k;", "b", "Lcoil/request/k;", "options", "Lkotlinx/coroutines/sync/e;", "Lkotlinx/coroutines/sync/e;", "parallelismLock", "Lcoil/decode/ExifOrientationPolicy;", "Lcoil/decode/ExifOrientationPolicy;", "exifOrientationPolicy", "<init>", "(Lcoil/decode/k;Lcoil/request/k;Lkotlinx/coroutines/sync/e;Lcoil/decode/ExifOrientationPolicy;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class BitmapFactoryDecoder implements e {

    /* renamed from: e  reason: collision with root package name */
    public static final a f8066e = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final k f8067a;

    /* renamed from: b  reason: collision with root package name */
    private final k f8068b;

    /* renamed from: c  reason: collision with root package name */
    private final e f8069c;

    /* renamed from: d  reason: collision with root package name */
    private final ExifOrientationPolicy f8070d;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcoil/decode/BitmapFactoryDecoder$a;", "", "", "DEFAULT_MAX_PARALLELISM", "I", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R4\u0010\r\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\u000e\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b8\u0006@BX\u000e¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f¨\u0006\u0012"}, d2 = {"Lcoil/decode/BitmapFactoryDecoder$b;", "Lokio/ForwardingSource;", "Lokio/Buffer;", "sink", "", "byteCount", "N1", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<set-?>", "b", "Ljava/lang/Exception;", "()Ljava/lang/Exception;", "exception", "Lokio/Source;", "delegate", "<init>", "(Lokio/Source;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    private static final class b extends ForwardingSource {

        /* renamed from: b  reason: collision with root package name */
        private Exception f8071b;

        public b(Source source) {
            super(source);
        }

        public long N1(Buffer buffer, long j10) {
            try {
                return super.N1(buffer, j10);
            } catch (Exception e10) {
                this.f8071b = e10;
                throw e10;
            }
        }

        public final Exception b() {
            return this.f8071b;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0010¢\u0006\u0004\b\u0018\u0010\u0019J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcoil/decode/BitmapFactoryDecoder$c;", "Lcoil/decode/e$a;", "Lcoil/fetch/l;", "result", "Lcoil/request/k;", "options", "Lcoil/ImageLoader;", "imageLoader", "Lcoil/decode/e;", "a", "", "other", "", "equals", "", "hashCode", "Lcoil/decode/ExifOrientationPolicy;", "Lcoil/decode/ExifOrientationPolicy;", "exifOrientationPolicy", "Lkotlinx/coroutines/sync/e;", "b", "Lkotlinx/coroutines/sync/e;", "parallelismLock", "maxParallelism", "<init>", "(ILcoil/decode/ExifOrientationPolicy;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class c implements e.a {

        /* renamed from: a  reason: collision with root package name */
        private final ExifOrientationPolicy f8072a;

        /* renamed from: b  reason: collision with root package name */
        private final kotlinx.coroutines.sync.e f8073b;

        public c(int i10, ExifOrientationPolicy exifOrientationPolicy) {
            this.f8072a = exifOrientationPolicy;
            this.f8073b = f.b(i10, 0, 2, (Object) null);
        }

        public e a(l lVar, k kVar, ImageLoader imageLoader) {
            return new BitmapFactoryDecoder(lVar.c(), kVar, this.f8073b, this.f8072a);
        }

        public boolean equals(Object obj) {
            return obj instanceof c;
        }

        public int hashCode() {
            return c.class.hashCode();
        }
    }

    public BitmapFactoryDecoder(k kVar, k kVar2, kotlinx.coroutines.sync.e eVar, ExifOrientationPolicy exifOrientationPolicy) {
        this.f8067a = kVar;
        this.f8068b = kVar2;
        this.f8069c = eVar;
        this.f8070d = exifOrientationPolicy;
    }

    private final void c(BitmapFactory.Options options, f fVar) {
        Bitmap.Config f10 = this.f8068b.f();
        if (fVar.b() || i.a(fVar)) {
            f10 = coil.util.a.e(f10);
        }
        if (this.f8068b.d() && f10 == Bitmap.Config.ARGB_8888 && j.b(options.outMimeType, "image/jpeg")) {
            f10 = Bitmap.Config.RGB_565;
        }
        if (Build.VERSION.SDK_INT >= 26 && options.outConfig == Bitmap.Config.RGBA_F16 && f10 != Bitmap.Config.HARDWARE) {
            f10 = Bitmap.Config.RGBA_F16;
        }
        options.inPreferredConfig = f10;
    }

    private final void d(BitmapFactory.Options options, f fVar) {
        int i10;
        int i11;
        int i12;
        int i13;
        BitmapFactory.Options options2 = options;
        k.a a10 = this.f8067a.a();
        if (!(a10 instanceof m) || !coil.size.b.b(this.f8068b.o())) {
            boolean z10 = false;
            if (options2.outWidth <= 0 || options2.outHeight <= 0) {
                options2.inSampleSize = 1;
                options2.inScaled = false;
                return;
            }
            if (i.b(fVar)) {
                i10 = options2.outHeight;
            } else {
                i10 = options2.outWidth;
            }
            if (i.b(fVar)) {
                i11 = options2.outWidth;
            } else {
                i11 = options2.outHeight;
            }
            g o10 = this.f8068b.o();
            Scale n10 = this.f8068b.n();
            if (coil.size.b.b(o10)) {
                i12 = i10;
            } else {
                i12 = coil.util.j.A(o10.d(), n10);
            }
            g o11 = this.f8068b.o();
            Scale n11 = this.f8068b.n();
            if (coil.size.b.b(o11)) {
                i13 = i11;
            } else {
                i13 = coil.util.j.A(o11.c(), n11);
            }
            int a11 = d.a(i10, i11, i12, i13, this.f8068b.n());
            options2.inSampleSize = a11;
            double b10 = d.b(((double) i10) / ((double) a11), ((double) i11) / ((double) a11), (double) i12, (double) i13, this.f8068b.n());
            if (this.f8068b.c()) {
                b10 = j.e(b10, 1.0d);
            }
            if (b10 == 1.0d) {
                z10 = true;
            }
            boolean z11 = !z10;
            options2.inScaled = z11;
            if (!z11) {
                return;
            }
            if (b10 > 1.0d) {
                options2.inDensity = c.a(((double) a.e.API_PRIORITY_OTHER) / b10);
                options2.inTargetDensity = a.e.API_PRIORITY_OTHER;
                return;
            }
            options2.inDensity = a.e.API_PRIORITY_OTHER;
            options2.inTargetDensity = c.a(((double) a.e.API_PRIORITY_OTHER) * b10);
            return;
        }
        options2.inSampleSize = 1;
        options2.inScaled = true;
        options2.inDensity = ((m) a10).a();
        options2.inTargetDensity = this.f8068b.g().getResources().getDisplayMetrics().densityDpi;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b5, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b6, code lost:
        kotlin.io.b.a(r1, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b9, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final coil.decode.c e(android.graphics.BitmapFactory.Options r10) {
        /*
            r9 = this;
            coil.decode.BitmapFactoryDecoder$b r0 = new coil.decode.BitmapFactoryDecoder$b
            coil.decode.k r1 = r9.f8067a
            okio.BufferedSource r1 = r1.b()
            r0.<init>(r1)
            okio.BufferedSource r1 = okio.Okio.c(r0)
            r2 = 1
            r10.inJustDecodeBounds = r2
            okio.BufferedSource r3 = r1.peek()
            java.io.InputStream r3 = r3.Z1()
            r4 = 0
            android.graphics.BitmapFactory.decodeStream(r3, r4, r10)
            java.lang.Exception r3 = r0.b()
            if (r3 != 0) goto L_0x00bb
            r3 = 0
            r10.inJustDecodeBounds = r3
            coil.decode.h r5 = coil.decode.h.f8100a
            java.lang.String r6 = r10.outMimeType
            coil.decode.ExifOrientationPolicy r7 = r9.f8070d
            coil.decode.f r6 = r5.a(r6, r1, r7)
            java.lang.Exception r7 = r0.b()
            if (r7 != 0) goto L_0x00ba
            r10.inMutable = r3
            int r7 = android.os.Build.VERSION.SDK_INT
            r8 = 26
            if (r7 < r8) goto L_0x004f
            coil.request.k r7 = r9.f8068b
            android.graphics.ColorSpace r7 = r7.e()
            if (r7 == 0) goto L_0x004f
            coil.request.k r7 = r9.f8068b
            android.graphics.ColorSpace r7 = r7.e()
            r10.inPreferredColorSpace = r7
        L_0x004f:
            coil.request.k r7 = r9.f8068b
            boolean r7 = r7.m()
            r10.inPremultiplied = r7
            r9.c(r10, r6)
            r9.d(r10, r6)
            java.io.InputStream r7 = r1.Z1()     // Catch:{ all -> 0x00b3 }
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeStream(r7, r4, r10)     // Catch:{ all -> 0x00b3 }
            kotlin.io.b.a(r1, r4)
            java.lang.Exception r0 = r0.b()
            if (r0 != 0) goto L_0x00b2
            if (r7 == 0) goto L_0x00a6
            coil.request.k r0 = r9.f8068b
            android.content.Context r0 = r0.g()
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            int r0 = r0.densityDpi
            r7.setDensity(r0)
            android.graphics.Bitmap r0 = r5.b(r7, r6)
            coil.decode.c r1 = new coil.decode.c
            coil.request.k r4 = r9.f8068b
            android.content.Context r4 = r4.g()
            android.content.res.Resources r4 = r4.getResources()
            android.graphics.drawable.BitmapDrawable r5 = new android.graphics.drawable.BitmapDrawable
            r5.<init>(r4, r0)
            int r0 = r10.inSampleSize
            if (r0 > r2) goto L_0x00a2
            boolean r10 = r10.inScaled
            if (r10 == 0) goto L_0x00a1
            goto L_0x00a2
        L_0x00a1:
            r2 = r3
        L_0x00a2:
            r1.<init>(r5, r2)
            return r1
        L_0x00a6:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "BitmapFactory returned a null bitmap. Often this means BitmapFactory could not decode the image data read from the input source (e.g. network, disk, or memory) as it's not encoded as a valid image format."
            java.lang.String r0 = r0.toString()
            r10.<init>(r0)
            throw r10
        L_0x00b2:
            throw r0
        L_0x00b3:
            r10 = move-exception
            throw r10     // Catch:{ all -> 0x00b5 }
        L_0x00b5:
            r0 = move-exception
            kotlin.io.b.a(r1, r10)
            throw r0
        L_0x00ba:
            throw r7
        L_0x00bb:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.decode.BitmapFactoryDecoder.e(android.graphics.BitmapFactory$Options):coil.decode.c");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(kotlin.coroutines.c<? super coil.decode.c> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof coil.decode.BitmapFactoryDecoder$decode$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            coil.decode.BitmapFactoryDecoder$decode$1 r0 = (coil.decode.BitmapFactoryDecoder$decode$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            coil.decode.BitmapFactoryDecoder$decode$1 r0 = new coil.decode.BitmapFactoryDecoder$decode$1
            r0.<init>(r7, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0047
            if (r2 == r4) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.sync.e r0 = (kotlinx.coroutines.sync.e) r0
            gk.g.b(r8)     // Catch:{ all -> 0x0030 }
            goto L_0x0070
        L_0x0030:
            r8 = move-exception
            goto L_0x007a
        L_0x0032:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x003a:
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.sync.e r2 = (kotlinx.coroutines.sync.e) r2
            java.lang.Object r5 = r0.L$0
            coil.decode.BitmapFactoryDecoder r5 = (coil.decode.BitmapFactoryDecoder) r5
            gk.g.b(r8)
            r8 = r2
            goto L_0x005a
        L_0x0047:
            gk.g.b(r8)
            kotlinx.coroutines.sync.e r8 = r7.f8069c
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r2 = r8.a(r0)
            if (r2 != r1) goto L_0x0059
            return r1
        L_0x0059:
            r5 = r7
        L_0x005a:
            coil.decode.BitmapFactoryDecoder$decode$2$1 r2 = new coil.decode.BitmapFactoryDecoder$decode$2$1     // Catch:{ all -> 0x0076 }
            r2.<init>(r5)     // Catch:{ all -> 0x0076 }
            r0.L$0 = r8     // Catch:{ all -> 0x0076 }
            r5 = 0
            r0.L$1 = r5     // Catch:{ all -> 0x0076 }
            r0.label = r3     // Catch:{ all -> 0x0076 }
            java.lang.Object r0 = kotlinx.coroutines.InterruptibleKt.c(r5, r2, r0, r4, r5)     // Catch:{ all -> 0x0076 }
            if (r0 != r1) goto L_0x006d
            return r1
        L_0x006d:
            r6 = r0
            r0 = r8
            r8 = r6
        L_0x0070:
            coil.decode.c r8 = (coil.decode.c) r8     // Catch:{ all -> 0x0030 }
            r0.release()
            return r8
        L_0x0076:
            r0 = move-exception
            r6 = r0
            r0 = r8
            r8 = r6
        L_0x007a:
            r0.release()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.decode.BitmapFactoryDecoder.a(kotlin.coroutines.c):java.lang.Object");
    }
}
