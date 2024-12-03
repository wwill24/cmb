package com.withpersona.sdk2.camera;

import java.util.List;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final List<Integer> f14340a = q.m(48000, 44100, 22050, 16000, 11025, 8000);

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0006 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0006 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.withpersona.sdk2.camera.c a() {
        /*
            java.util.List<java.lang.Integer> r0 = f14340a
            java.util.Iterator r0 = r0.iterator()
        L_0x0006:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L_0x005c
            java.lang.Object r1 = r0.next()
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            r9 = 16
            r10 = 2
            int r11 = android.media.AudioRecord.getMinBufferSize(r1, r9, r10)     // Catch:{ IllegalArgumentException -> 0x0059, SecurityException -> 0x0053, all -> 0x004c }
            r3 = -2
            if (r11 != r3) goto L_0x0022
            goto L_0x0006
        L_0x0022:
            android.media.AudioRecord r12 = new android.media.AudioRecord     // Catch:{ IllegalArgumentException -> 0x0059, SecurityException -> 0x0053, all -> 0x004c }
            r4 = 1
            r6 = 16
            r7 = 2
            r3 = r12
            r5 = r1
            r8 = r11
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ IllegalArgumentException -> 0x0059, SecurityException -> 0x0053, all -> 0x004c }
            int r2 = r12.getState()     // Catch:{ IllegalArgumentException -> 0x004a, SecurityException -> 0x0048, all -> 0x0045 }
            r3 = 1
            if (r2 != r3) goto L_0x0041
            r12.release()     // Catch:{ IllegalArgumentException -> 0x004a, SecurityException -> 0x0048, all -> 0x0045 }
            com.withpersona.sdk2.camera.c r2 = new com.withpersona.sdk2.camera.c     // Catch:{ IllegalArgumentException -> 0x004a, SecurityException -> 0x0048, all -> 0x0045 }
            r2.<init>(r1, r9, r10, r11)     // Catch:{ IllegalArgumentException -> 0x004a, SecurityException -> 0x0048, all -> 0x0045 }
            r12.release()
            return r2
        L_0x0041:
            r12.release()
            goto L_0x0006
        L_0x0045:
            r0 = move-exception
            r2 = r12
            goto L_0x004d
        L_0x0048:
            r2 = r12
            goto L_0x0053
        L_0x004a:
            r2 = r12
            goto L_0x0059
        L_0x004c:
            r0 = move-exception
        L_0x004d:
            if (r2 == 0) goto L_0x0052
            r2.release()
        L_0x0052:
            throw r0
        L_0x0053:
            if (r2 == 0) goto L_0x0006
        L_0x0055:
            r2.release()
            goto L_0x0006
        L_0x0059:
            if (r2 == 0) goto L_0x0006
            goto L_0x0055
        L_0x005c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.camera.d.a():com.withpersona.sdk2.camera.c");
    }
}
