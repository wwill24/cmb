package g0;

import android.util.Range;
import android.util.Rational;
import androidx.annotation.NonNull;
import androidx.camera.core.v1;
import androidx.camera.video.a;
import androidx.camera.video.internal.AudioSource;
import androidx.core.util.i;
import java.util.ArrayList;
import java.util.Collections;

public final class b {
    /* access modifiers changed from: private */
    public static /* synthetic */ int b(int i10, Integer num, Integer num2) {
        float signum;
        int abs = Math.abs(num.intValue() - i10) - Math.abs(num2.intValue() - i10);
        if (abs == 0) {
            signum = Math.signum((float) (num.intValue() - num2.intValue()));
        } else {
            signum = Math.signum((float) abs);
        }
        return (int) signum;
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [androidx.core.util.i] */
    /* JADX WARNING: type inference failed for: r8v1, types: [g0.d] */
    /* JADX WARNING: type inference failed for: r1v1, types: [g0.c] */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.camera.video.internal.encoder.a c(@androidx.annotation.NonNull g0.h r14, @androidx.annotation.NonNull androidx.camera.core.impl.Timebase r15, @androidx.annotation.NonNull androidx.camera.video.internal.AudioSource.f r16, @androidx.annotation.NonNull androidx.camera.video.a r17) {
        /*
            androidx.camera.core.impl.m r0 = r14.b()
            if (r0 == 0) goto L_0x001e
            g0.c r0 = new g0.c
            java.lang.String r2 = r14.c()
            int r3 = r14.d()
            androidx.camera.core.impl.m r7 = r14.b()
            r1 = r0
            r4 = r15
            r5 = r17
            r6 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7)
            goto L_0x0031
        L_0x001e:
            g0.d r0 = new g0.d
            java.lang.String r9 = r14.c()
            int r10 = r14.d()
            r8 = r0
            r11 = r15
            r12 = r17
            r13 = r16
            r8.<init>(r9, r10, r11, r12, r13)
        L_0x0031:
            java.lang.Object r0 = r0.get()
            androidx.camera.video.internal.encoder.a r0 = (androidx.camera.video.internal.encoder.a) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: g0.b.c(g0.h, androidx.camera.core.impl.Timebase, androidx.camera.video.internal.AudioSource$f, androidx.camera.video.a):androidx.camera.video.internal.encoder.a");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00c5  */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static g0.h d(@androidx.annotation.NonNull androidx.camera.video.n r9, androidx.camera.core.impl.m r10) {
        /*
            int r0 = r9.c()
            java.lang.String r0 = androidx.camera.video.n.e(r0)
            int r1 = r9.c()
            int r1 = androidx.camera.video.n.f(r1)
            r2 = 1
            if (r10 == 0) goto L_0x00ba
            java.lang.String r3 = r10.e()
            int r4 = r10.j()
            java.lang.String r5 = ")]"
            java.lang.String r6 = "AudioConfigUtil"
            java.lang.String r7 = "(profile: "
            if (r3 != 0) goto L_0x0042
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r2 = "CamcorderProfile contains undefined AUDIO mime type so cannot be used. May rely on fallback defaults to derive settings [chosen mime type: "
            r9.append(r2)
            r9.append(r0)
            r9.append(r7)
            r9.append(r1)
            r9.append(r5)
            java.lang.String r9 = r9.toString()
            androidx.camera.core.v1.a(r6, r9)
            goto L_0x00ba
        L_0x0042:
            int r9 = r9.c()
            r8 = -1
            if (r9 != r8) goto L_0x0069
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "MediaSpec contains OUTPUT_FORMAT_AUTO. Using CamcorderProfile to derive AUDIO settings [mime type: "
            r9.append(r0)
            r9.append(r3)
            r9.append(r7)
            r9.append(r4)
            r9.append(r5)
            java.lang.String r9 = r9.toString()
            androidx.camera.core.v1.a(r6, r9)
        L_0x0066:
            r0 = r3
            r1 = r4
            goto L_0x00bb
        L_0x0069:
            boolean r9 = java.util.Objects.equals(r0, r3)
            if (r9 == 0) goto L_0x008f
            if (r1 != r4) goto L_0x008f
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "MediaSpec audio mime/profile matches CamcorderProfile. Using CamcorderProfile to derive AUDIO settings [mime type: "
            r9.append(r0)
            r9.append(r3)
            r9.append(r7)
            r9.append(r4)
            r9.append(r5)
            java.lang.String r9 = r9.toString()
            androidx.camera.core.v1.a(r6, r9)
            goto L_0x0066
        L_0x008f:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r2 = "MediaSpec audio mime or profile does not match CamcorderProfile, so CamcorderProfile settings cannot be used. May rely on fallback defaults to derive AUDIO settings [CamcorderProfile mime type: "
            r9.append(r2)
            r9.append(r3)
            r9.append(r7)
            r9.append(r4)
            java.lang.String r2 = "), chosen mime type: "
            r9.append(r2)
            r9.append(r0)
            r9.append(r7)
            r9.append(r1)
            r9.append(r5)
            java.lang.String r9 = r9.toString()
            androidx.camera.core.v1.a(r6, r9)
        L_0x00ba:
            r2 = 0
        L_0x00bb:
            g0.h$a r9 = g0.h.a(r0)
            g0.h$a r9 = r9.c(r1)
            if (r2 == 0) goto L_0x00c8
            r9.b(r10)
        L_0x00c8:
            g0.h r9 = r9.a()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: g0.b.d(androidx.camera.video.n, androidx.camera.core.impl.m):g0.h");
    }

    static int e(@NonNull a aVar) {
        int e10 = aVar.e();
        if (e10 == -1) {
            v1.a("AudioConfigUtil", "Using default AUDIO source: " + 5);
            return 5;
        }
        v1.a("AudioConfigUtil", "Using provided AUDIO source: " + e10);
        return e10;
    }

    static int f(@NonNull a aVar) {
        int f10 = aVar.f();
        if (f10 == -1) {
            v1.a("AudioConfigUtil", "Using default AUDIO source format: " + 2);
            return 2;
        }
        v1.a("AudioConfigUtil", "Using provided AUDIO source format: " + f10);
        return f10;
    }

    @NonNull
    public static AudioSource.f g(@NonNull h hVar, @NonNull a aVar) {
        i iVar;
        if (hVar.b() != null) {
            iVar = new e(aVar, hVar.b());
        } else {
            iVar = new f(aVar);
        }
        return (AudioSource.f) iVar.get();
    }

    static int h(int i10, int i11, int i12, int i13, int i14, Range<Integer> range) {
        String str;
        int doubleValue = (int) (((double) i10) * new Rational(i11, i12).doubleValue() * new Rational(i13, i14).doubleValue());
        if (v1.f("AudioConfigUtil")) {
            str = String.format("Base Bitrate(%dbps) * Channel Count Ratio(%d / %d) * Sample Rate Ratio(%d / %d) = %d", new Object[]{Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(doubleValue)});
        } else {
            str = "";
        }
        if (!a.f3075a.equals(range)) {
            doubleValue = range.clamp(Integer.valueOf(doubleValue)).intValue();
            if (v1.f("AudioConfigUtil")) {
                str = str + String.format("\nClamped to range %s -> %dbps", new Object[]{range, Integer.valueOf(doubleValue)});
            }
        }
        v1.a("AudioConfigUtil", str);
        return doubleValue;
    }

    static int i(@NonNull Range<Integer> range, int i10, int i11, int i12) {
        ArrayList arrayList = null;
        int i13 = 0;
        int i14 = i12;
        while (true) {
            if (!range.contains(Integer.valueOf(i14))) {
                v1.a("AudioConfigUtil", "Sample rate " + i14 + "Hz is not in target range " + range);
            } else if (AudioSource.o(i14, i10, i11)) {
                return i14;
            } else {
                v1.a("AudioConfigUtil", "Sample rate " + i14 + "Hz is not supported by audio source with channel count " + i10 + " and source format " + i11);
            }
            if (arrayList == null) {
                v1.a("AudioConfigUtil", "Trying common sample rates in proximity order to target " + i12 + "Hz");
                arrayList = new ArrayList(AudioSource.f3152q);
                Collections.sort(arrayList, new a(i12));
            }
            if (i13 < arrayList.size()) {
                int i15 = i13 + 1;
                i14 = ((Integer) arrayList.get(i13)).intValue();
                i13 = i15;
            } else {
                v1.a("AudioConfigUtil", "No sample rate found in target range or supported by audio source. Falling back to default sample rate of 44100Hz");
                return 44100;
            }
        }
    }
}
