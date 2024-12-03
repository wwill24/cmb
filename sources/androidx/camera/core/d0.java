package androidx.camera.core;

import android.view.Display;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.x;

public final class d0 extends a2 {

    /* renamed from: b  reason: collision with root package name */
    private final float f2211b;

    /* renamed from: c  reason: collision with root package name */
    private final float f2212c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final Display f2213d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final q f2214e;

    public d0(@NonNull Display display, @NonNull q qVar, float f10, float f11) {
        this.f2211b = f10;
        this.f2212c = f11;
        this.f2213d = display;
        this.f2214e = qVar;
    }

    private Integer e() {
        q qVar = this.f2214e;
        if (qVar instanceof x) {
            return ((x) qVar).c();
        }
        return null;
    }

    private int f(boolean z10) {
        try {
            int i10 = this.f2214e.i(this.f2213d.getRotation());
            if (z10) {
                return (360 - i10) % 360;
            }
            return i10;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0038  */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.PointF a(float r9, float r10) {
        /*
            r8 = this;
            float r0 = r8.f2211b
            float r1 = r8.f2212c
            java.lang.Integer r2 = r8.e()
            if (r2 == 0) goto L_0x0012
            int r2 = r2.intValue()
            if (r2 != 0) goto L_0x0012
            r2 = 1
            goto L_0x0013
        L_0x0012:
            r2 = 0
        L_0x0013:
            int r3 = r8.f(r2)
            r4 = 270(0x10e, float:3.78E-43)
            r5 = 90
            if (r3 == r5) goto L_0x0026
            if (r3 != r4) goto L_0x0020
            goto L_0x0026
        L_0x0020:
            r6 = r10
            r10 = r9
            r9 = r6
            r7 = r1
            r1 = r0
            r0 = r7
        L_0x0026:
            if (r3 == r5) goto L_0x0034
            r5 = 180(0xb4, float:2.52E-43)
            if (r3 == r5) goto L_0x0032
            if (r3 == r4) goto L_0x002f
            goto L_0x0036
        L_0x002f:
            float r10 = r1 - r10
            goto L_0x0036
        L_0x0032:
            float r10 = r1 - r10
        L_0x0034:
            float r9 = r0 - r9
        L_0x0036:
            if (r2 == 0) goto L_0x003a
            float r10 = r1 - r10
        L_0x003a:
            float r10 = r10 / r1
            float r9 = r9 / r0
            android.graphics.PointF r0 = new android.graphics.PointF
            r0.<init>(r10, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.d0.a(float, float):android.graphics.PointF");
    }
}
