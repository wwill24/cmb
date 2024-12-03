package com.withpersona.sdk2.inquiry.selfie;

import com.withpersona.sdk2.camera.w;
import com.withpersona.sdk2.inquiry.selfie.Selfie;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.j;

public final class q {
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x005c, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0058, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0059, code lost:
        kotlin.io.b.a(r1, r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.withpersona.sdk2.inquiry.selfie.Selfie a(com.withpersona.sdk2.camera.w r4, android.content.Context r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.j.g(r4, r0)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.j.g(r5, r0)
            java.io.File r0 = new java.io.File
            java.io.File r5 = r5.getCacheDir()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "persona_selfie_"
            r1.append(r2)
            long r2 = java.lang.System.currentTimeMillis()
            r1.append(r2)
            java.lang.String r2 = ".jpg"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r5, r1)
            android.graphics.Bitmap r5 = r4.a()
            java.io.FileOutputStream r1 = new java.io.FileOutputStream
            r1.<init>(r0)
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ all -> 0x0056 }
            r3 = 80
            r5.compress(r2, r3, r1)     // Catch:{ all -> 0x0056 }
            r5 = 0
            kotlin.io.b.a(r1, r5)
            java.lang.String r5 = r0.getAbsolutePath()
            com.withpersona.sdk2.inquiry.selfie.Selfie$Direction r4 = b(r4)
            com.withpersona.sdk2.inquiry.selfie.Selfie$CaptureMethod r0 = com.withpersona.sdk2.inquiry.selfie.Selfie.CaptureMethod.AUTO
            com.withpersona.sdk2.inquiry.selfie.Selfie$SelfieImage r1 = new com.withpersona.sdk2.inquiry.selfie.Selfie$SelfieImage
            java.lang.String r2 = "absolutePath"
            kotlin.jvm.internal.j.f(r5, r2)
            r1.<init>(r5, r0, r4)
            return r1
        L_0x0056:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0058 }
        L_0x0058:
            r5 = move-exception
            kotlin.io.b.a(r1, r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.selfie.q.a(com.withpersona.sdk2.camera.w, android.content.Context):com.withpersona.sdk2.inquiry.selfie.Selfie");
    }

    public static final Selfie.Direction b(w wVar) {
        j.g(wVar, "<this>");
        if (wVar instanceof w.a) {
            return Selfie.Direction.CENTER;
        }
        if (wVar instanceof w.b) {
            return Selfie.Direction.LEFT;
        }
        if (wVar instanceof w.c) {
            return Selfie.Direction.RIGHT;
        }
        throw new NoWhenBranchMatchedException();
    }
}
