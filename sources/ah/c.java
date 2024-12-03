package ah;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.Image;
import android.os.Build;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.mlkit.common.MlKitException;
import java.nio.ByteBuffer;
import zg.a;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final c f18847a = new c();

    private c() {
    }

    @NonNull
    public static ByteBuffer a(@NonNull ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return byteBuffer;
        }
        byteBuffer.rewind();
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        return ByteBuffer.wrap(bArr);
    }

    @NonNull
    public static c f() {
        return f18847a;
    }

    @NonNull
    public static Bitmap i(@NonNull ByteBuffer byteBuffer, int i10, int i11, int i12) throws MlKitException {
        byte[] l10 = l(j(byteBuffer, true).array(), i10, i11);
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(l10, 0, l10.length);
        return k(decodeByteArray, i12, decodeByteArray.getWidth(), decodeByteArray.getHeight());
    }

    @NonNull
    public static ByteBuffer j(@NonNull ByteBuffer byteBuffer, boolean z10) {
        ByteBuffer byteBuffer2;
        int i10;
        byteBuffer.rewind();
        int limit = byteBuffer.limit();
        int i11 = limit / 6;
        if (z10) {
            byteBuffer2 = ByteBuffer.allocate(limit);
        } else {
            byteBuffer2 = ByteBuffer.allocateDirect(limit);
        }
        int i12 = 0;
        while (true) {
            i10 = i11 * 4;
            if (i12 >= i10) {
                break;
            }
            byteBuffer2.put(i12, byteBuffer.get(i12));
            i12++;
        }
        for (int i13 = 0; i13 < i11 + i11; i13++) {
            byteBuffer2.put(i10 + i13, byteBuffer.get(((i13 % 2) * i11) + i10 + (i13 / 2)));
        }
        return byteBuffer2;
    }

    @NonNull
    public static Bitmap k(@NonNull Bitmap bitmap, int i10, int i11, int i12) {
        if (i10 == 0) {
            return Bitmap.createBitmap(bitmap, 0, 0, i11, i12);
        }
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i10);
        return Bitmap.createBitmap(bitmap, 0, 0, i11, i12, matrix, true);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:16|17) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        throw r8;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0040 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] l(@androidx.annotation.NonNull byte[] r7, int r8, int r9) throws com.google.mlkit.common.MlKitException {
        /*
            android.graphics.YuvImage r6 = new android.graphics.YuvImage
            r2 = 17
            r5 = 0
            r0 = r6
            r1 = r7
            r3 = r8
            r4 = r9
            r0.<init>(r1, r2, r3, r4, r5)
            java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0041 }
            r7.<init>()     // Catch:{ IOException -> 0x0041 }
            r0 = 0
            android.graphics.Rect r1 = new android.graphics.Rect     // Catch:{ all -> 0x0024 }
            r1.<init>(r0, r0, r8, r9)     // Catch:{ all -> 0x0024 }
            r8 = 100
            r6.compressToJpeg(r1, r8, r7)     // Catch:{ all -> 0x0024 }
            byte[] r8 = r7.toByteArray()     // Catch:{ all -> 0x0024 }
            r7.close()     // Catch:{ IOException -> 0x0041 }
            return r8
        L_0x0024:
            r8 = move-exception
            r7.close()     // Catch:{ all -> 0x0029 }
            goto L_0x0040
        L_0x0029:
            r7 = move-exception
            java.lang.Class<java.lang.Throwable> r9 = java.lang.Throwable.class
            java.lang.String r1 = "addSuppressed"
            r2 = 1
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0040 }
            java.lang.Class<java.lang.Throwable> r4 = java.lang.Throwable.class
            r3[r0] = r4     // Catch:{ Exception -> 0x0040 }
            java.lang.reflect.Method r9 = r9.getDeclaredMethod(r1, r3)     // Catch:{ Exception -> 0x0040 }
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0040 }
            r1[r0] = r7     // Catch:{ Exception -> 0x0040 }
            r9.invoke(r8, r1)     // Catch:{ Exception -> 0x0040 }
        L_0x0040:
            throw r8     // Catch:{ IOException -> 0x0041 }
        L_0x0041:
            r7 = move-exception
            com.google.mlkit.common.MlKitException r8 = new com.google.mlkit.common.MlKitException
            r9 = 13
            java.lang.String r0 = "Image conversion error from NV21 format"
            r8.<init>(r0, r9, r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ah.c.l(byte[], int, int):byte[]");
    }

    private static final void m(Image.Plane plane, int i10, int i11, byte[] bArr, int i12, int i13) {
        ByteBuffer buffer = plane.getBuffer();
        buffer.rewind();
        int limit = ((buffer.limit() + plane.getRowStride()) - 1) / plane.getRowStride();
        if (limit != 0) {
            int i14 = i10 / (i11 / limit);
            int i15 = 0;
            for (int i16 = 0; i16 < limit; i16++) {
                int i17 = i15;
                for (int i18 = 0; i18 < i14; i18++) {
                    bArr[i12] = buffer.get(i17);
                    i12 += i13;
                    i17 += plane.getPixelStride();
                }
                i15 += plane.getRowStride();
            }
        }
    }

    @NonNull
    public byte[] b(@NonNull ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            return byteBuffer.array();
        }
        byteBuffer.rewind();
        int limit = byteBuffer.limit();
        byte[] bArr = new byte[limit];
        byteBuffer.get(bArr, 0, limit);
        return bArr;
    }

    @NonNull
    public Bitmap c(@NonNull Image image, int i10) {
        boolean z10;
        if (image.getFormat() == 256) {
            z10 = true;
        } else {
            z10 = false;
        }
        p.b(z10, "Only JPEG is supported now");
        Image.Plane[] planes = image.getPlanes();
        if (planes == null || planes.length != 1) {
            throw new IllegalArgumentException("Unexpected image format, JPEG should have exactly 1 image plane");
        }
        ByteBuffer buffer = planes[0].getBuffer();
        buffer.rewind();
        int remaining = buffer.remaining();
        byte[] bArr = new byte[remaining];
        buffer.get(bArr);
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, remaining);
        return k(decodeByteArray, i10, decodeByteArray.getWidth(), decodeByteArray.getHeight());
    }

    @NonNull
    public ByteBuffer d(@NonNull a aVar, boolean z10) throws MlKitException {
        ByteBuffer byteBuffer;
        boolean z11 = z10;
        int g10 = aVar.g();
        if (g10 == -1) {
            Bitmap bitmap = (Bitmap) p.k(aVar.d());
            if (Build.VERSION.SDK_INT >= 26 && bitmap.getConfig() == Bitmap.Config.HARDWARE) {
                bitmap = bitmap.copy(Bitmap.Config.ARGB_8888, bitmap.isMutable());
            }
            Bitmap bitmap2 = bitmap;
            int width = bitmap2.getWidth();
            int height = bitmap2.getHeight();
            int i10 = width * height;
            int[] iArr = new int[i10];
            bitmap2.getPixels(iArr, 0, width, 0, 0, width, height);
            int ceil = (int) Math.ceil(((double) height) / 2.0d);
            int ceil2 = ((ceil + ceil) * ((int) Math.ceil(((double) width) / 2.0d))) + i10;
            if (z11) {
                byteBuffer = ByteBuffer.allocate(ceil2);
            } else {
                byteBuffer = ByteBuffer.allocateDirect(ceil2);
            }
            int i11 = 0;
            int i12 = 0;
            for (int i13 = 0; i13 < height; i13++) {
                int i14 = 0;
                while (i14 < width) {
                    int i15 = iArr[i12];
                    int i16 = i15 >> 16;
                    int i17 = i15 >> 8;
                    int i18 = i15 & 255;
                    int i19 = i11 + 1;
                    int i20 = i16 & 255;
                    int i21 = i17 & 255;
                    byteBuffer.put(i11, (byte) Math.min(255, (((((i20 * 66) + (i21 * 129)) + (i18 * 25)) + 128) >> 8) + 16));
                    if (i13 % 2 == 0 && i12 % 2 == 0) {
                        int i22 = i20 * 112;
                        int i23 = i10 + 1;
                        byteBuffer.put(i10, (byte) Math.min(255, ((((i22 - (i21 * 94)) - (i18 * 18)) + 128) >> 8) + 128));
                        i10 = i23 + 1;
                        byteBuffer.put(i23, (byte) Math.min(255, (((((i20 * -38) - (i21 * 74)) + (i18 * 112)) + 128) >> 8) + 128));
                    }
                    i12++;
                    i14++;
                    i11 = i19;
                }
            }
            return byteBuffer;
        } else if (g10 == 17) {
            if (z11) {
                return a((ByteBuffer) p.k(aVar.e()));
            }
            return (ByteBuffer) p.k(aVar.e());
        } else if (g10 == 35) {
            return h((Image.Plane[]) p.k(aVar.j()), aVar.l(), aVar.h());
        } else if (g10 == 842094169) {
            return j((ByteBuffer) p.k(aVar.e()), z11);
        } else {
            throw new MlKitException("Unsupported image format", 13);
        }
    }

    @NonNull
    public Bitmap e(@NonNull a aVar) throws MlKitException {
        int g10 = aVar.g();
        if (g10 == -1) {
            return k((Bitmap) p.k(aVar.d()), aVar.k(), aVar.l(), aVar.h());
        }
        if (g10 == 17) {
            return g((ByteBuffer) p.k(aVar.e()), aVar.l(), aVar.h(), aVar.k());
        }
        if (g10 == 35) {
            return g(h((Image.Plane[]) p.k(aVar.j()), aVar.l(), aVar.h()), aVar.l(), aVar.h(), aVar.k());
        }
        if (g10 == 842094169) {
            return i((ByteBuffer) p.k(aVar.e()), aVar.l(), aVar.h(), aVar.k());
        }
        throw new MlKitException("Unsupported image format", 13);
    }

    @NonNull
    public Bitmap g(@NonNull ByteBuffer byteBuffer, int i10, int i11, int i12) throws MlKitException {
        byte[] l10 = l(b(byteBuffer), i10, i11);
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(l10, 0, l10.length);
        return k(decodeByteArray, i12, decodeByteArray.getWidth(), decodeByteArray.getHeight());
    }

    @NonNull
    public ByteBuffer h(@NonNull Image.Plane[] planeArr, int i10, int i11) {
        boolean z10;
        int i12 = i10 * i11;
        int i13 = i12 / 4;
        byte[] bArr = new byte[(i13 + i13 + i12)];
        ByteBuffer buffer = planeArr[1].getBuffer();
        ByteBuffer buffer2 = planeArr[2].getBuffer();
        int position = buffer2.position();
        int limit = buffer.limit();
        buffer2.position(position + 1);
        buffer.limit(limit - 1);
        int i14 = (i12 + i12) / 4;
        if (buffer2.remaining() == i14 - 2 && buffer2.compareTo(buffer) == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        buffer2.position(position);
        buffer.limit(limit);
        if (z10) {
            planeArr[0].getBuffer().get(bArr, 0, i12);
            ByteBuffer buffer3 = planeArr[1].getBuffer();
            planeArr[2].getBuffer().get(bArr, i12, 1);
            buffer3.get(bArr, i12 + 1, i14 - 1);
        } else {
            int i15 = i10;
            int i16 = i11;
            byte[] bArr2 = bArr;
            m(planeArr[0], i15, i16, bArr2, 0, 1);
            m(planeArr[1], i15, i16, bArr2, i12 + 1, 2);
            m(planeArr[2], i10, i11, bArr, i12, 2);
        }
        return ByteBuffer.wrap(bArr);
    }
}
