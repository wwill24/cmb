package coil.decode;

import android.graphics.Paint;
import androidx.exifinterface.media.a;
import java.io.InputStream;
import kotlin.Metadata;
import okio.BufferedSource;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\bR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcoil/decode/h;", "", "", "mimeType", "Lokio/BufferedSource;", "source", "Lcoil/decode/ExifOrientationPolicy;", "policy", "Lcoil/decode/f;", "a", "Landroid/graphics/Bitmap;", "inBitmap", "exifData", "b", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "PAINT", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final h f8100a = new h();

    /* renamed from: b  reason: collision with root package name */
    private static final Paint f8101b = new Paint(3);

    private h() {
    }

    public final f a(String str, BufferedSource bufferedSource, ExifOrientationPolicy exifOrientationPolicy) {
        if (!i.c(exifOrientationPolicy, str)) {
            return f.f8095d;
        }
        a aVar = new a((InputStream) new g(bufferedSource.peek().Z1()));
        return new f(aVar.D(), aVar.s());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0063, code lost:
        if (r5 == false) goto L_0x0065;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap b(android.graphics.Bitmap r8, coil.decode.f r9) {
        /*
            r7 = this;
            boolean r0 = r9.b()
            if (r0 != 0) goto L_0x000d
            boolean r0 = coil.decode.i.a(r9)
            if (r0 != 0) goto L_0x000d
            return r8
        L_0x000d:
            android.graphics.Matrix r0 = new android.graphics.Matrix
            r0.<init>()
            int r1 = r8.getWidth()
            float r1 = (float) r1
            r2 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r2
            int r3 = r8.getHeight()
            float r3 = (float) r3
            float r3 = r3 / r2
            boolean r2 = r9.b()
            if (r2 == 0) goto L_0x002d
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            r4 = 1065353216(0x3f800000, float:1.0)
            r0.postScale(r2, r4, r1, r3)
        L_0x002d:
            boolean r2 = coil.decode.i.a(r9)
            if (r2 == 0) goto L_0x003b
            int r2 = r9.a()
            float r2 = (float) r2
            r0.postRotate(r2, r1, r3)
        L_0x003b:
            android.graphics.RectF r1 = new android.graphics.RectF
            int r2 = r8.getWidth()
            float r2 = (float) r2
            int r3 = r8.getHeight()
            float r3 = (float) r3
            r4 = 0
            r1.<init>(r4, r4, r2, r3)
            r0.mapRect(r1)
            float r2 = r1.left
            int r3 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            r5 = 1
            r6 = 0
            if (r3 != 0) goto L_0x0058
            r3 = r5
            goto L_0x0059
        L_0x0058:
            r3 = r6
        L_0x0059:
            if (r3 == 0) goto L_0x0065
            float r3 = r1.top
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 != 0) goto L_0x0062
            goto L_0x0063
        L_0x0062:
            r5 = r6
        L_0x0063:
            if (r5 != 0) goto L_0x006c
        L_0x0065:
            float r2 = -r2
            float r1 = r1.top
            float r1 = -r1
            r0.postTranslate(r2, r1)
        L_0x006c:
            boolean r9 = coil.decode.i.b(r9)
            java.lang.String r1 = "createBitmap(width, height, config)"
            if (r9 == 0) goto L_0x0088
            int r9 = r8.getHeight()
            int r2 = r8.getWidth()
            android.graphics.Bitmap$Config r3 = coil.util.a.c(r8)
            android.graphics.Bitmap r9 = android.graphics.Bitmap.createBitmap(r9, r2, r3)
            kotlin.jvm.internal.j.f(r9, r1)
            goto L_0x009b
        L_0x0088:
            int r9 = r8.getWidth()
            int r2 = r8.getHeight()
            android.graphics.Bitmap$Config r3 = coil.util.a.c(r8)
            android.graphics.Bitmap r9 = android.graphics.Bitmap.createBitmap(r9, r2, r3)
            kotlin.jvm.internal.j.f(r9, r1)
        L_0x009b:
            android.graphics.Canvas r1 = new android.graphics.Canvas
            r1.<init>(r9)
            android.graphics.Paint r2 = f8101b
            r1.drawBitmap(r8, r0, r2)
            r8.recycle()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.decode.h.b(android.graphics.Bitmap, coil.decode.f):android.graphics.Bitmap");
    }
}
