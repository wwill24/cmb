package androidx.camera.camera2.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.d0;
import androidx.camera.core.impl.f2;
import androidx.camera.core.impl.i1;
import androidx.camera.core.impl.n1;
import androidx.camera.core.impl.v0;
import r.m;

public final class e1 implements UseCaseConfigFactory {

    /* renamed from: b  reason: collision with root package name */
    final v1 f1732b;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1733a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.camera.core.impl.UseCaseConfigFactory$CaptureType[] r0 = androidx.camera.core.impl.UseCaseConfigFactory.CaptureType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1733a = r0
                androidx.camera.core.impl.UseCaseConfigFactory$CaptureType r1 = androidx.camera.core.impl.UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f1733a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.core.impl.UseCaseConfigFactory$CaptureType r1 = androidx.camera.core.impl.UseCaseConfigFactory.CaptureType.PREVIEW     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f1733a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.camera.core.impl.UseCaseConfigFactory$CaptureType r1 = androidx.camera.core.impl.UseCaseConfigFactory.CaptureType.IMAGE_ANALYSIS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f1733a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.camera.core.impl.UseCaseConfigFactory$CaptureType r1 = androidx.camera.core.impl.UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.e1.a.<clinit>():void");
        }
    }

    public e1(@NonNull Context context) {
        this.f1732b = v1.b(context);
    }

    @NonNull
    public Config a(@NonNull UseCaseConfigFactory.CaptureType captureType, int i10) {
        Object obj;
        int i11;
        i1 O = i1.O();
        SessionConfig.b bVar = new SessionConfig.b();
        int[] iArr = a.f1733a;
        int i12 = iArr[captureType.ordinal()];
        int i13 = 5;
        if (i12 == 1) {
            if (i10 == 2) {
                i11 = 5;
            } else {
                i11 = 1;
            }
            bVar.t(i11);
        } else if (i12 == 2 || i12 == 3) {
            bVar.t(1);
        } else if (i12 == 4) {
            bVar.t(3);
        }
        UseCaseConfigFactory.CaptureType captureType2 = UseCaseConfigFactory.CaptureType.PREVIEW;
        if (captureType == captureType2) {
            m.a(bVar);
        }
        O.p(f2.f2524n, bVar.m());
        O.p(f2.f2526p, d1.f1714a);
        d0.a aVar = new d0.a();
        int i14 = iArr[captureType.ordinal()];
        if (i14 == 1) {
            if (i10 != 2) {
                i13 = 2;
            }
            aVar.q(i13);
        } else if (i14 == 2 || i14 == 3) {
            aVar.q(1);
        } else if (i14 == 4) {
            aVar.q(3);
        }
        O.p(f2.f2525o, aVar.h());
        Config.a<d0.b> aVar2 = f2.f2527q;
        if (captureType == UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE) {
            obj = i2.f1806c;
        } else {
            obj = k0.f1828a;
        }
        O.p(aVar2, obj);
        if (captureType == captureType2) {
            O.p(v0.f2694l, this.f1732b.d());
        }
        O.p(v0.f2690h, Integer.valueOf(this.f1732b.c().getRotation()));
        if (captureType == UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE) {
            O.p(f2.f2531u, Boolean.TRUE);
        }
        return n1.M(O);
    }
}
