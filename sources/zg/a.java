package zg;

import ah.c;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.Image;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.mlkit_vision_common.zzms;
import com.google.android.gms.internal.mlkit_vision_common.zzmu;
import com.google.mlkit.common.sdkinternal.h;
import java.nio.ByteBuffer;

public class a implements h {

    /* renamed from: a  reason: collision with root package name */
    private volatile Bitmap f24792a;

    /* renamed from: b  reason: collision with root package name */
    private volatile ByteBuffer f24793b;

    /* renamed from: c  reason: collision with root package name */
    private volatile b f24794c;

    /* renamed from: d  reason: collision with root package name */
    private final int f24795d;

    /* renamed from: e  reason: collision with root package name */
    private final int f24796e;

    /* renamed from: f  reason: collision with root package name */
    private final int f24797f;

    /* renamed from: g  reason: collision with root package name */
    private final int f24798g;

    /* renamed from: h  reason: collision with root package name */
    private final Matrix f24799h;

    private a(@NonNull Bitmap bitmap, int i10) {
        this.f24792a = (Bitmap) p.k(bitmap);
        this.f24795d = bitmap.getWidth();
        this.f24796e = bitmap.getHeight();
        m(i10);
        this.f24797f = i10;
        this.f24798g = -1;
        this.f24799h = null;
    }

    @NonNull
    public static a a(@NonNull Bitmap bitmap, int i10) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        a aVar = new a(bitmap, i10);
        o(-1, 1, elapsedRealtime, bitmap.getHeight(), bitmap.getWidth(), bitmap.getAllocationByteCount(), i10);
        return aVar;
    }

    @NonNull
    public static a b(@NonNull ByteBuffer byteBuffer, int i10, int i11, int i12, int i13) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        a aVar = new a(byteBuffer, i10, i11, i12, i13);
        o(i13, 3, elapsedRealtime, i11, i10, byteBuffer.limit(), i12);
        return aVar;
    }

    @NonNull
    public static a c(@NonNull Image image, int i10) {
        return n(image, i10, (Matrix) null);
    }

    private static int m(int i10) {
        boolean z10 = true;
        if (!(i10 == 0 || i10 == 90 || i10 == 180)) {
            if (i10 == 270) {
                i10 = 270;
            } else {
                z10 = false;
            }
        }
        p.b(z10, "Invalid rotation. Only 0, 90, 180, 270 are supported currently.");
        return i10;
    }

    private static a n(@NonNull Image image, int i10, Matrix matrix) {
        a aVar;
        int limit;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        p.l(image, "Please provide a valid image");
        m(i10);
        boolean z10 = true;
        if (!(image.getFormat() == 256 || image.getFormat() == 35)) {
            z10 = false;
        }
        p.b(z10, "Only JPEG and YUV_420_888 are supported now");
        Image.Plane[] planes = image.getPlanes();
        if (image.getFormat() == 256) {
            limit = image.getPlanes()[0].getBuffer().limit();
            aVar = new a(c.f().c(image, i10), 0);
        } else {
            for (Image.Plane plane : planes) {
                if (plane.getBuffer() != null) {
                    plane.getBuffer().rewind();
                }
            }
            aVar = new a(image, image.getWidth(), image.getHeight(), i10, matrix);
            limit = (image.getPlanes()[0].getBuffer().limit() * 3) / 2;
        }
        int i11 = limit;
        a aVar2 = aVar;
        o(image.getFormat(), 5, elapsedRealtime, image.getHeight(), image.getWidth(), i11, i10);
        return aVar2;
    }

    private static void o(int i10, int i11, long j10, int i12, int i13, int i14, int i15) {
        zzmu.zza(zzms.zzb("vision-common"), i10, i11, j10, i12, i13, i14, i15);
    }

    public Bitmap d() {
        return this.f24792a;
    }

    public ByteBuffer e() {
        return this.f24793b;
    }

    public Matrix f() {
        return this.f24799h;
    }

    public int g() {
        return this.f24798g;
    }

    public int h() {
        return this.f24796e;
    }

    public Image i() {
        if (this.f24794c == null) {
            return null;
        }
        return this.f24794c.a();
    }

    public Image.Plane[] j() {
        if (this.f24794c == null) {
            return null;
        }
        return this.f24794c.b();
    }

    public int k() {
        return this.f24797f;
    }

    public int l() {
        return this.f24795d;
    }

    private a(@NonNull Image image, int i10, int i11, int i12, Matrix matrix) {
        p.k(image);
        this.f24794c = new b(image);
        this.f24795d = i10;
        this.f24796e = i11;
        m(i12);
        this.f24797f = i12;
        this.f24798g = 35;
        this.f24799h = matrix;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private a(@androidx.annotation.NonNull java.nio.ByteBuffer r5, int r6, int r7, int r8, int r9) {
        /*
            r4 = this;
            r4.<init>()
            r0 = 0
            r1 = 17
            r2 = 1
            r3 = 842094169(0x32315659, float:1.0322389E-8)
            if (r9 == r3) goto L_0x0012
            if (r9 != r1) goto L_0x0010
            r9 = r1
            goto L_0x0012
        L_0x0010:
            r1 = r0
            goto L_0x0013
        L_0x0012:
            r1 = r2
        L_0x0013:
            com.google.android.gms.common.internal.p.a(r1)
            java.lang.Object r1 = com.google.android.gms.common.internal.p.k(r5)
            java.nio.ByteBuffer r1 = (java.nio.ByteBuffer) r1
            r4.f24793b = r1
            int r1 = r5.limit()
            int r3 = r6 * r7
            if (r1 <= r3) goto L_0x0027
            r0 = r2
        L_0x0027:
            java.lang.String r1 = "Image dimension, ByteBuffer size and format don't match. Please check if the ByteBuffer is in the decalred format."
            com.google.android.gms.common.internal.p.b(r0, r1)
            r5.rewind()
            r4.f24795d = r6
            r4.f24796e = r7
            m(r8)
            r4.f24797f = r8
            r4.f24798g = r9
            r5 = 0
            r4.f24799h = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zg.a.<init>(java.nio.ByteBuffer, int, int, int, int):void");
    }
}
