package g0;

import android.util.Range;
import android.util.Rational;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.m;
import androidx.camera.core.v1;
import androidx.camera.video.j0;
import androidx.camera.video.n;
import g0.h;
import java.util.Objects;

public final class i {
    static int a(@NonNull Range<Integer> range, int i10, Range<Integer> range2) {
        if (range2 != null) {
            try {
                range = range2.intersect(range);
            } catch (IllegalArgumentException unused) {
                if (range.getUpper().intValue() < range2.getLower().intValue()) {
                    return range2.getLower().intValue();
                }
                return range2.getUpper().intValue();
            }
        }
        return range.clamp(Integer.valueOf(i10)).intValue();
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [androidx.core.util.i] */
    /* JADX WARNING: type inference failed for: r7v2, types: [g0.k] */
    /* JADX WARNING: type inference failed for: r1v1, types: [g0.j] */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.camera.video.internal.encoder.h1 b(@androidx.annotation.NonNull g0.h r13, @androidx.annotation.NonNull androidx.camera.core.impl.Timebase r14, @androidx.annotation.NonNull androidx.camera.video.j0 r15, @androidx.annotation.NonNull android.util.Size r16, android.util.Range<java.lang.Integer> r17) {
        /*
            androidx.camera.core.impl.m r0 = r13.b()
            if (r0 == 0) goto L_0x001b
            g0.j r0 = new g0.j
            java.lang.String r2 = r13.c()
            androidx.camera.core.impl.m r6 = r13.b()
            r1 = r0
            r3 = r14
            r4 = r15
            r5 = r16
            r7 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7)
            goto L_0x002b
        L_0x001b:
            g0.k r0 = new g0.k
            java.lang.String r8 = r13.c()
            r7 = r0
            r9 = r14
            r10 = r15
            r11 = r16
            r12 = r17
            r7.<init>(r8, r9, r10, r11, r12)
        L_0x002b:
            java.lang.Object r0 = r0.get()
            androidx.camera.video.internal.encoder.h1 r0 = (androidx.camera.video.internal.encoder.h1) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: g0.i.b(g0.h, androidx.camera.core.impl.Timebase, androidx.camera.video.j0, android.util.Size, android.util.Range):androidx.camera.video.internal.encoder.h1");
    }

    @NonNull
    public static h c(@NonNull n nVar, m mVar) {
        String h10 = n.h(nVar.c());
        boolean z10 = false;
        if (mVar != null) {
            String m10 = mVar.m();
            if (m10 == null) {
                v1.a("VideoConfigUtil", "CamcorderProfile contains undefined VIDEO mime type so cannot be used. May rely on fallback defaults to derive settings [chosen mime type: " + h10 + "]");
            } else {
                if (nVar.c() == -1) {
                    v1.a("VideoConfigUtil", "MediaSpec contains OUTPUT_FORMAT_AUTO. Using CamcorderProfile to derive VIDEO settings [mime type: " + m10 + "]");
                } else if (Objects.equals(h10, m10)) {
                    v1.a("VideoConfigUtil", "MediaSpec video mime matches CamcorderProfile. Using CamcorderProfile to derive VIDEO settings [mime type: " + m10 + "]");
                } else {
                    v1.a("VideoConfigUtil", "MediaSpec video mime does not match CamcorderProfile, so CamcorderProfile settings cannot be used. May rely on fallback defaults to derive VIDEO settings [CamcorderProfile mime type: " + m10 + ", chosen mime type: " + h10 + "]");
                }
                h10 = m10;
                z10 = true;
            }
        } else {
            v1.a("VideoConfigUtil", "No CamcorderProfile present. May rely on fallback defaults to derive VIDEO settings [chosen mime type: " + h10 + "]");
        }
        h.a a10 = h.a(h10);
        if (z10) {
            a10.b(mVar);
        }
        return a10.a();
    }

    static int d(int i10, int i11, int i12, int i13, int i14, int i15, int i16, @NonNull Range<Integer> range) {
        String str;
        int doubleValue = (int) (((double) i10) * new Rational(i11, i12).doubleValue() * new Rational(i13, i14).doubleValue() * new Rational(i15, i16).doubleValue());
        if (v1.f("VideoConfigUtil")) {
            str = String.format("Base Bitrate(%dbps) * Frame Rate Ratio(%d / %d) * Width Ratio(%d / %d) * Height Ratio(%d / %d) = %d", new Object[]{Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i15), Integer.valueOf(i16), Integer.valueOf(doubleValue)});
        } else {
            str = "";
        }
        if (!j0.f3384b.equals(range)) {
            doubleValue = range.clamp(Integer.valueOf(doubleValue)).intValue();
            if (v1.f("VideoConfigUtil")) {
                str = str + String.format("\nClamped to range %s -> %dbps", new Object[]{range, Integer.valueOf(doubleValue)});
            }
        }
        v1.a("VideoConfigUtil", str);
        return doubleValue;
    }
}
