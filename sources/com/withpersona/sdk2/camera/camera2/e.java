package com.withpersona.sdk2.camera.camera2;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Range;
import java.util.NoSuchElementException;
import kotlin.collections.b0;
import kotlin.jvm.internal.j;
import kotlin.ranges.IntRange;

public final class e {

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f14332a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.withpersona.sdk2.camera.camera2.CameraDirection[] r0 = com.withpersona.sdk2.camera.camera2.CameraDirection.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.withpersona.sdk2.camera.camera2.CameraDirection r1 = com.withpersona.sdk2.camera.camera2.CameraDirection.FRONT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.withpersona.sdk2.camera.camera2.CameraDirection r1 = com.withpersona.sdk2.camera.camera2.CameraDirection.BACK     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f14332a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.camera.camera2.e.a.<clinit>():void");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.withpersona.sdk2.camera.camera2.f} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.withpersona.sdk2.camera.camera2.f a(android.content.Context r25, com.withpersona.sdk2.camera.camera2.CameraDirection r26) {
        /*
            r0 = r25
            java.lang.String r1 = "context"
            kotlin.jvm.internal.j.g(r0, r1)
            java.lang.String r1 = "cameraDirection"
            r2 = r26
            kotlin.jvm.internal.j.g(r2, r1)
            java.lang.String r1 = "camera"
            java.lang.Object r0 = r0.getSystemService(r1)
            java.lang.String r1 = "null cannot be cast to non-null type android.hardware.camera2.CameraManager"
            kotlin.jvm.internal.j.e(r0, r1)
            android.hardware.camera2.CameraManager r0 = (android.hardware.camera2.CameraManager) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.String[] r3 = r0.getCameraIdList()
            java.lang.String r4 = "cameraManager.cameraIdList"
            kotlin.jvm.internal.j.f(r3, r4)
            int r4 = r3.length
            r5 = 0
            r6 = r5
        L_0x002c:
            r7 = 1
            if (r6 >= r4) goto L_0x011f
            r15 = r3[r6]
            android.hardware.camera2.CameraCharacteristics r8 = r0.getCameraCharacteristics(r15)
            java.lang.String r9 = "cameraManager.getCameraCharacteristics(id)"
            kotlin.jvm.internal.j.f(r8, r9)
            android.hardware.camera2.CameraCharacteristics$Key r9 = android.hardware.camera2.CameraCharacteristics.LENS_FACING
            java.lang.Object r9 = r8.get(r9)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int[] r10 = com.withpersona.sdk2.camera.camera2.e.a.f14332a
            int r11 = r26.ordinal()
            r10 = r10[r11]
            if (r10 == r7) goto L_0x005a
            r11 = 2
            if (r10 == r11) goto L_0x0050
            goto L_0x0064
        L_0x0050:
            if (r9 != 0) goto L_0x0053
            goto L_0x0059
        L_0x0053:
            int r9 = r9.intValue()
            if (r9 == r7) goto L_0x0064
        L_0x0059:
            goto L_0x006e
        L_0x005a:
            if (r9 != 0) goto L_0x005d
            goto L_0x0063
        L_0x005d:
            int r7 = r9.intValue()
            if (r7 == 0) goto L_0x0064
        L_0x0063:
            goto L_0x006e
        L_0x0064:
            android.hardware.camera2.CameraCharacteristics$Key r7 = android.hardware.camera2.CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES
            java.lang.Object r7 = r8.get(r7)
            int[] r7 = (int[]) r7
            if (r7 != 0) goto L_0x0074
        L_0x006e:
            r17 = r0
            r18 = r3
            goto L_0x0114
        L_0x0074:
            java.lang.String r9 = "characteristics.get(Came…)\n      ?: return@forEach"
            kotlin.jvm.internal.j.f(r7, r9)
            android.hardware.camera2.CameraCharacteristics$Key r10 = android.hardware.camera2.CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP
            java.lang.Object r10 = r8.get(r10)
            r14 = r10
            android.hardware.camera2.params.StreamConfigurationMap r14 = (android.hardware.camera2.params.StreamConfigurationMap) r14
            if (r14 != 0) goto L_0x0085
            goto L_0x006e
        L_0x0085:
            kotlin.jvm.internal.j.f(r14, r9)
            boolean r7 = kotlin.collections.l.t(r7, r5)
            if (r7 != 0) goto L_0x008f
            goto L_0x006e
        L_0x008f:
            java.lang.Class<android.media.MediaRecorder> r7 = android.media.MediaRecorder.class
            r9 = 30
            android.util.Range r16 = b(r8, r9)
            android.util.Size[] r13 = r14.getOutputSizes(r7)
            java.lang.String r8 = "cameraConfig.getOutputSizes(targetClass)"
            kotlin.jvm.internal.j.f(r13, r8)
            int r11 = r13.length
            r12 = r5
        L_0x00a2:
            if (r12 >= r11) goto L_0x006e
            r10 = r13[r12]
            long r8 = r14.getOutputMinFrameDuration(r7, r10)
            double r8 = (double) r8
            r17 = 4741671816366391296(0x41cdcd6500000000, double:1.0E9)
            double r8 = r8 / r17
            r17 = 0
            int r19 = (r8 > r17 ? 1 : (r8 == r17 ? 0 : -1))
            if (r19 <= 0) goto L_0x00bc
            r17 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r17 = r17 / r8
        L_0x00bc:
            r8 = r17
            com.withpersona.sdk2.camera.camera2.f r5 = new com.withpersona.sdk2.camera.camera2.f
            r17 = r0
            java.lang.String r0 = "id"
            kotlin.jvm.internal.j.f(r15, r0)
            java.lang.String r0 = "size"
            kotlin.jvm.internal.j.f(r10, r0)
            if (r16 != 0) goto L_0x00df
            android.util.Range r0 = new android.util.Range
            int r2 = (int) r8
            r18 = r3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.<init>(r3, r2)
            goto L_0x00e3
        L_0x00df:
            r18 = r3
            r0 = r16
        L_0x00e3:
            com.withpersona.sdk2.camera.camera2.g r2 = new com.withpersona.sdk2.camera.camera2.g
            r20 = 0
            r22 = 0
            r23 = 3
            r24 = 0
            r19 = r2
            r19.<init>(r20, r22, r23, r24)
            r19 = r8
            r8 = r5
            r9 = r15
            r3 = r11
            r21 = r12
            r11 = r19
            r19 = r13
            r13 = r0
            r0 = r14
            r14 = r2
            r8.<init>(r9, r10, r11, r13, r14)
            r1.add(r5)
            int r12 = r21 + 1
            r2 = r26
            r14 = r0
            r11 = r3
            r0 = r17
            r3 = r18
            r13 = r19
            r5 = 0
            goto L_0x00a2
        L_0x0114:
            int r6 = r6 + 1
            r2 = r26
            r0 = r17
            r3 = r18
            r5 = 0
            goto L_0x002c
        L_0x011f:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r1 = r1.iterator()
        L_0x0128:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0154
            java.lang.Object r2 = r1.next()
            r3 = r2
            com.withpersona.sdk2.camera.camera2.f r3 = (com.withpersona.sdk2.camera.camera2.f) r3
            android.util.Size r4 = r3.c()
            int r4 = r4.getWidth()
            r5 = 2000(0x7d0, float:2.803E-42)
            if (r4 >= r5) goto L_0x014d
            android.util.Size r3 = r3.c()
            int r3 = r3.getHeight()
            if (r3 >= r5) goto L_0x014d
            r3 = r7
            goto L_0x014e
        L_0x014d:
            r3 = 0
        L_0x014e:
            if (r3 == 0) goto L_0x0128
            r0.add(r2)
            goto L_0x0128
        L_0x0154:
            java.util.Iterator r0 = r0.iterator()
            boolean r1 = r0.hasNext()
            if (r1 != 0) goto L_0x0160
            r0 = 0
            goto L_0x01a3
        L_0x0160:
            java.lang.Object r1 = r0.next()
            boolean r2 = r0.hasNext()
            if (r2 != 0) goto L_0x016c
        L_0x016a:
            r0 = r1
            goto L_0x01a3
        L_0x016c:
            r2 = r1
            com.withpersona.sdk2.camera.camera2.f r2 = (com.withpersona.sdk2.camera.camera2.f) r2
            android.util.Size r3 = r2.c()
            int r3 = r3.getWidth()
            android.util.Size r2 = r2.c()
            int r2 = r2.getHeight()
            int r3 = r3 * r2
        L_0x0180:
            java.lang.Object r2 = r0.next()
            r4 = r2
            com.withpersona.sdk2.camera.camera2.f r4 = (com.withpersona.sdk2.camera.camera2.f) r4
            android.util.Size r5 = r4.c()
            int r5 = r5.getWidth()
            android.util.Size r4 = r4.c()
            int r4 = r4.getHeight()
            int r5 = r5 * r4
            if (r3 >= r5) goto L_0x019c
            r1 = r2
            r3 = r5
        L_0x019c:
            boolean r2 = r0.hasNext()
            if (r2 != 0) goto L_0x0180
            goto L_0x016a
        L_0x01a3:
            com.withpersona.sdk2.camera.camera2.f r0 = (com.withpersona.sdk2.camera.camera2.f) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.camera.camera2.e.a(android.content.Context, com.withpersona.sdk2.camera.camera2.CameraDirection):com.withpersona.sdk2.camera.camera2.f");
    }

    private static final Range<Integer> b(CameraCharacteristics cameraCharacteristics, int i10) {
        boolean z10;
        boolean z11;
        Range<Integer>[] rangeArr = (Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        Range<Integer> range = null;
        if (rangeArr == null) {
            return null;
        }
        if (rangeArr.length == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return null;
        }
        for (Range<Integer> range2 : rangeArr) {
            Integer upper = range2.getUpper();
            j.f(upper, "range.upper");
            int intValue = upper.intValue();
            if (intValue >= i10) {
                if (range != null) {
                    Integer upper2 = range.getUpper();
                    j.f(upper2, "result.upper");
                    if (intValue >= upper2.intValue()) {
                    }
                }
                range = range2;
            }
        }
        if (range != null) {
            return range;
        }
        if (rangeArr.length == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            Range<Integer> range3 = rangeArr[0];
            int C = l.C(rangeArr);
            if (C != 0) {
                Integer upper3 = range3.getUpper();
                b0 g10 = new IntRange(1, C).iterator();
                while (g10.hasNext()) {
                    Range<Integer> range4 = rangeArr[g10.nextInt()];
                    Integer upper4 = range4.getUpper();
                    if (upper3.compareTo(upper4) < 0) {
                        range3 = range4;
                        upper3 = upper4;
                    }
                }
            }
            return range3;
        }
        throw new NoSuchElementException();
    }
}
