package i0;

import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.v1;
import androidx.camera.video.internal.encoder.i1;
import androidx.core.util.h;

public class c implements i1 {

    /* renamed from: a  reason: collision with root package name */
    private final i1 f15443a;

    /* renamed from: b  reason: collision with root package name */
    private final Range<Integer> f15444b;

    /* renamed from: c  reason: collision with root package name */
    private final Range<Integer> f15445c;

    c(@NonNull i1 i1Var) {
        this.f15443a = i1Var;
        int c10 = i1Var.c();
        this.f15444b = Range.create(Integer.valueOf(c10), Integer.valueOf(((int) Math.ceil(4096.0d / ((double) c10))) * c10));
        int b10 = i1Var.b();
        this.f15445c = Range.create(Integer.valueOf(b10), Integer.valueOf(((int) Math.ceil(2160.0d / ((double) b10))) * b10));
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.camera.video.internal.encoder.i1 g(@androidx.annotation.NonNull androidx.camera.video.internal.encoder.i1 r3, @androidx.annotation.NonNull android.util.Size r4) {
        /*
            java.lang.Class<f0.j> r0 = f0.j.class
            androidx.camera.core.impl.q1 r0 = f0.e.a(r0)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x000c
        L_0x000a:
            r1 = r2
            goto L_0x0030
        L_0x000c:
            boolean r0 = h(r3, r4)
            if (r0 != 0) goto L_0x0030
            r0 = 3
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r1] = r4
            android.util.Range r4 = r3.e()
            r0[r2] = r4
            r4 = 2
            android.util.Range r1 = r3.f()
            r0[r4] = r1
            java.lang.String r4 = "Detected that the device does not support a size %s that should be valid in widths/heights = %s/%s"
            java.lang.String r4 = java.lang.String.format(r4, r0)
            java.lang.String r0 = "VideoEncoderInfoWrapper"
            androidx.camera.core.v1.l(r0, r4)
            goto L_0x000a
        L_0x0030:
            if (r1 == 0) goto L_0x0038
            i0.c r4 = new i0.c
            r4.<init>(r3)
            r3 = r4
        L_0x0038:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: i0.c.g(androidx.camera.video.internal.encoder.i1, android.util.Size):androidx.camera.video.internal.encoder.i1");
    }

    private static boolean h(@NonNull i1 i1Var, @NonNull Size size) {
        if (i1Var.e().contains(Integer.valueOf(size.getWidth())) && i1Var.f().contains(Integer.valueOf(size.getHeight()))) {
            try {
                if (!i1Var.d(size.getWidth()).contains(Integer.valueOf(size.getHeight())) || !i1Var.a(size.getHeight()).contains(Integer.valueOf(size.getWidth()))) {
                    return false;
                }
                return true;
            } catch (IllegalArgumentException e10) {
                v1.m("VideoEncoderInfoWrapper", "size is not supported", e10);
            }
        }
        return false;
    }

    @NonNull
    public Range<Integer> a(int i10) {
        boolean contains = this.f15445c.contains(Integer.valueOf(i10));
        h.b(contains, "Not supported height: " + i10 + " in " + this.f15445c);
        return this.f15444b;
    }

    public int b() {
        return this.f15443a.b();
    }

    public int c() {
        return this.f15443a.c();
    }

    @NonNull
    public Range<Integer> d(int i10) {
        boolean contains = this.f15444b.contains(Integer.valueOf(i10));
        h.b(contains, "Not supported width: " + i10 + " in " + this.f15444b);
        return this.f15445c;
    }

    @NonNull
    public Range<Integer> e() {
        return this.f15444b;
    }

    @NonNull
    public Range<Integer> f() {
        return this.f15445c;
    }
}
