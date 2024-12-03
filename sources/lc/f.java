package lc;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.coffeemeetsbagel.util.RequestCode;
import fa.a;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class f {
    public static Bitmap a(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            httpURLConnection.setConnectTimeout(RequestCode.OVERFLOW_ACTIVITY);
            httpURLConnection.setReadTimeout(RequestCode.OVERFLOW_ACTIVITY);
            return BitmapFactory.decodeStream(httpURLConnection.getInputStream());
        } catch (IOException unused) {
            return null;
        }
    }

    public static Bitmap b(Bitmap bitmap) {
        int i10;
        try {
            if (bitmap.getHeight() > bitmap.getWidth()) {
                i10 = bitmap.getHeight() / 1080;
            } else {
                i10 = bitmap.getWidth() / 1080;
            }
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / i10, bitmap.getHeight() / i10, false);
            if (createScaledBitmap != bitmap) {
                h(bitmap);
            }
            return createScaledBitmap;
        } catch (Throwable th2) {
            if (bitmap != null) {
                h(bitmap);
            }
            throw th2;
        }
    }

    public static Bitmap c(Bitmap bitmap, int i10, int i11) {
        if (bitmap == null || i11 <= 0 || i10 <= 0) {
            return bitmap;
        }
        float width = ((float) bitmap.getWidth()) / ((float) bitmap.getHeight());
        float f10 = (float) i10;
        float f11 = (float) i11;
        if (f10 / f11 > 1.0f) {
            i10 = (int) (f11 * width);
        } else {
            i11 = (int) (f10 / width);
        }
        return Bitmap.createScaledBitmap(bitmap, i10, i11, true);
    }

    public static Bitmap d(Bitmap bitmap, int i10) {
        if (i10 == 90) {
            return g(bitmap, 90.0f);
        }
        if (i10 == 180) {
            return g(bitmap, 180.0f);
        }
        if (i10 == 270) {
            try {
                return g(bitmap, -90.0f);
            } catch (Exception | OutOfMemoryError e10) {
                a.i(e10);
            }
        }
        return bitmap;
    }

    public static Bitmap e(String str, Bitmap bitmap) {
        Bitmap bitmap2;
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                bitmap2 = g(bitmap, 180.0f);
            } else if (attributeInt == 6) {
                bitmap2 = g(bitmap, 90.0f);
            } else if (attributeInt != 8) {
                return bitmap;
            } else {
                bitmap2 = g(bitmap, 270.0f);
            }
            return bitmap2;
        } catch (Exception | OutOfMemoryError e10) {
            a.i(e10);
            return bitmap;
        }
    }

    public static void f(String str) {
        Bitmap bitmap;
        try {
            bitmap = BitmapFactory.decodeFile(str);
            try {
                e(str, bitmap);
                h(bitmap);
            } catch (Throwable th2) {
                th = th2;
                h(bitmap);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bitmap = null;
            h(bitmap);
            throw th;
        }
    }

    public static Bitmap g(Bitmap bitmap, float f10) throws Exception, OutOfMemoryError {
        Matrix matrix = new Matrix();
        matrix.postRotate(f10);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (createBitmap != bitmap) {
            h(bitmap);
        }
        return createBitmap;
    }

    public static void h(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x002e A[SYNTHETIC, Splitter:B:19:0x002e] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003e A[SYNTHETIC, Splitter:B:24:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String i(android.graphics.Bitmap r2, int r3, java.lang.String r4) {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0028 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0028 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0028 }
            r4.<init>(r1)     // Catch:{ Exception -> 0x0028 }
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
            r2.compress(r0, r3, r4)     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
            java.lang.String r2 = r1.getPath()     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
            r4.flush()     // Catch:{ IOException -> 0x001b }
            r4.close()     // Catch:{ IOException -> 0x001b }
            goto L_0x001f
        L_0x001b:
            r3 = move-exception
            fa.a.i(r3)
        L_0x001f:
            return r2
        L_0x0020:
            r2 = move-exception
            r0 = r4
            goto L_0x003c
        L_0x0023:
            r2 = move-exception
            r0 = r4
            goto L_0x0029
        L_0x0026:
            r2 = move-exception
            goto L_0x003c
        L_0x0028:
            r2 = move-exception
        L_0x0029:
            fa.a.i(r2)     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x0039
            r0.flush()     // Catch:{ IOException -> 0x0035 }
            r0.close()     // Catch:{ IOException -> 0x0035 }
            goto L_0x0039
        L_0x0035:
            r2 = move-exception
            fa.a.i(r2)
        L_0x0039:
            java.lang.String r2 = ""
            return r2
        L_0x003c:
            if (r0 == 0) goto L_0x0049
            r0.flush()     // Catch:{ IOException -> 0x0045 }
            r0.close()     // Catch:{ IOException -> 0x0045 }
            goto L_0x0049
        L_0x0045:
            r3 = move-exception
            fa.a.i(r3)
        L_0x0049:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: lc.f.i(android.graphics.Bitmap, int, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String j(java.lang.String r3, boolean r4, java.lang.String r5) {
        /*
            r0 = 0
            android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeFile(r3)     // Catch:{ Exception -> 0x0025, all -> 0x0023 }
            int r1 = r3.getHeight()     // Catch:{ Exception -> 0x0021 }
            r2 = 1080(0x438, float:1.513E-42)
            if (r1 <= r2) goto L_0x0012
            r1 = 0
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createScaledBitmap(r3, r2, r2, r1)     // Catch:{ Exception -> 0x0021 }
        L_0x0012:
            r1 = 80
            java.lang.String r5 = i(r3, r1, r5)     // Catch:{ Exception -> 0x0021 }
            if (r4 == 0) goto L_0x001d
            h(r3)
        L_0x001d:
            return r5
        L_0x001e:
            r5 = move-exception
            r0 = r3
            goto L_0x0030
        L_0x0021:
            r5 = move-exception
            goto L_0x0027
        L_0x0023:
            r5 = move-exception
            goto L_0x0030
        L_0x0025:
            r5 = move-exception
            r3 = r0
        L_0x0027:
            fa.a.i(r5)     // Catch:{ all -> 0x001e }
            if (r4 == 0) goto L_0x002f
            h(r3)
        L_0x002f:
            return r0
        L_0x0030:
            if (r4 == 0) goto L_0x0035
            h(r0)
        L_0x0035:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: lc.f.j(java.lang.String, boolean, java.lang.String):java.lang.String");
    }
}
