package wi;

import android.graphics.BitmapFactory;
import androidx.exifinterface.media.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class b implements a {
    private final int b(BitmapFactory.Options options, int i10, int i11) {
        int i12 = options.outHeight;
        int i13 = options.outWidth;
        if (i12 > i11 || i13 > i10) {
            return Math.min(c.b(((float) i12) / ((float) i11)), c.b(((float) i13) / ((float) i10)));
        }
        return 1;
    }

    private final Map<String, String> c(File file) {
        Throwable th2;
        try {
            List m10 = q.m("DateTime", "DateTimeDigitized", "ExposureTime", "Flash", "FocalLength", "GPSAltitude", "GPSAltitudeRef", "GPSDateStamp", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "GPSProcessingMethod", "GPSTimeStamp", "Make", "Model", "Orientation", "SubSecTime", "WhiteBalance");
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                a aVar = new a((InputStream) fileInputStream);
                LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(r.t(m10, 10)), 16));
                for (Object next : m10) {
                    linkedHashMap.put(next, aVar.g((String) next));
                }
                kotlin.io.b.a(fileInputStream, (Throwable) null);
                return linkedHashMap;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                kotlin.io.b.a(fileInputStream, th2);
                throw th4;
            }
        } catch (IOException unused) {
            return h0.i();
        }
    }

    private final void d(File file, Map<String, String> map) {
        try {
            a aVar = new a(file.getAbsolutePath());
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                if (str2 != null) {
                    aVar.d0(str, str2);
                }
            }
            aVar.Y();
        } catch (IOException unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003f, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        kotlin.io.b.a(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0043, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.io.File r7) {
        /*
            r6 = this;
            java.lang.String r0 = "file"
            kotlin.jvm.internal.j.g(r7, r0)
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options
            r0.<init>()
            r1 = 1
            r0.inJustDecodeBounds = r1
            java.lang.String r1 = r7.getAbsolutePath()
            android.graphics.BitmapFactory.decodeFile(r1, r0)
            java.util.Map r1 = r6.c(r7)
            java.lang.String r2 = r7.getAbsolutePath()     // Catch:{ IllegalArgumentException -> 0x004c }
            android.graphics.BitmapFactory$Options r3 = new android.graphics.BitmapFactory$Options     // Catch:{ IllegalArgumentException -> 0x004c }
            r3.<init>()     // Catch:{ IllegalArgumentException -> 0x004c }
            r4 = 2000(0x7d0, float:2.803E-42)
            int r0 = r6.b(r0, r4, r4)     // Catch:{ IllegalArgumentException -> 0x004c }
            r3.inSampleSize = r0     // Catch:{ IllegalArgumentException -> 0x004c }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeFile(r2, r3)     // Catch:{ IllegalArgumentException -> 0x004c }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IllegalArgumentException -> 0x004c }
            r2.<init>(r7)     // Catch:{ IllegalArgumentException -> 0x004c }
            r3 = 0
            if (r0 == 0) goto L_0x0044
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ all -> 0x003d }
            r5 = 80
            r0.compress(r4, r5, r2)     // Catch:{ all -> 0x003d }
            goto L_0x0044
        L_0x003d:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x003f }
        L_0x003f:
            r3 = move-exception
            kotlin.io.b.a(r2, r0)     // Catch:{ IllegalArgumentException -> 0x004c }
            throw r3     // Catch:{ IllegalArgumentException -> 0x004c }
        L_0x0044:
            kotlin.io.b.a(r2, r3)     // Catch:{ IllegalArgumentException -> 0x004c }
            if (r0 == 0) goto L_0x004c
            r0.recycle()     // Catch:{ IllegalArgumentException -> 0x004c }
        L_0x004c:
            r6.d(r7, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: wi.b.a(java.io.File):void");
    }
}
