package com.withpersona.sdk2.camera;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.Image;
import androidx.camera.core.o1;
import kotlin.jvm.internal.j;

public final class ImageToAnalyzeKt {
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0055, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        kotlin.io.b.a(r1, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0059, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final android.graphics.Bitmap a(java.nio.ByteBuffer r8, com.withpersona.sdk2.camera.q r9) {
        /*
            r8.rewind()
            int r0 = r8.limit()
            byte[] r2 = new byte[r0]
            r7 = 0
            r8.get(r2, r7, r0)
            r8 = 0
            android.graphics.YuvImage r0 = new android.graphics.YuvImage     // Catch:{ Exception -> 0x005a }
            r3 = 17
            int r4 = r9.c()     // Catch:{ Exception -> 0x005a }
            int r5 = r9.a()     // Catch:{ Exception -> 0x005a }
            r6 = 0
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x005a }
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x005a }
            r1.<init>()     // Catch:{ Exception -> 0x005a }
            android.graphics.Rect r2 = new android.graphics.Rect     // Catch:{ all -> 0x0053 }
            int r3 = r9.c()     // Catch:{ all -> 0x0053 }
            int r4 = r9.a()     // Catch:{ all -> 0x0053 }
            r2.<init>(r7, r7, r3, r4)     // Catch:{ all -> 0x0053 }
            r3 = 80
            r0.compressToJpeg(r2, r3, r1)     // Catch:{ all -> 0x0053 }
            byte[] r0 = r1.toByteArray()     // Catch:{ all -> 0x0053 }
            int r2 = r1.size()     // Catch:{ all -> 0x0053 }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeByteArray(r0, r7, r2)     // Catch:{ all -> 0x0053 }
            kotlin.io.b.a(r1, r8)     // Catch:{ Exception -> 0x005a }
            java.lang.String r1 = "bitmap"
            kotlin.jvm.internal.j.f(r0, r1)     // Catch:{ Exception -> 0x005a }
            int r9 = r9.b()     // Catch:{ Exception -> 0x005a }
            android.graphics.Bitmap r8 = b(r0, r9)     // Catch:{ Exception -> 0x005a }
            return r8
        L_0x0053:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x0055 }
        L_0x0055:
            r0 = move-exception
            kotlin.io.b.a(r1, r9)     // Catch:{ Exception -> 0x005a }
            throw r0     // Catch:{ Exception -> 0x005a }
        L_0x005a:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.camera.ImageToAnalyzeKt.a(java.nio.ByteBuffer, com.withpersona.sdk2.camera.q):android.graphics.Bitmap");
    }

    private static final Bitmap b(Bitmap bitmap, int i10) {
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i10);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (!j.b(createBitmap, bitmap)) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static final Bitmap c(Image image, int i10) {
        j.g(image, "<this>");
        q qVar = new q(image.getWidth(), image.getHeight(), i10);
        f fVar = f.f14346a;
        Image.Plane[] planes = image.getPlanes();
        if (planes == null) {
            return null;
        }
        return a(fVar.c(planes, image.getWidth(), image.getHeight()), qVar);
    }

    public static final s d(Image image, int i10) {
        j.g(image, "<this>");
        return new ImageToAnalyzeKt$toImageToAnalyze$1(image, i10);
    }

    @SuppressLint({"UnsafeOptInUsageError"})
    public static final s e(o1 o1Var) {
        j.g(o1Var, "<this>");
        try {
            Image t10 = o1Var.t();
            if (t10 == null) {
                return null;
            }
            return d(t10, o1Var.z1().a());
        } catch (IllegalStateException | NullPointerException unused) {
            return null;
        }
    }
}
