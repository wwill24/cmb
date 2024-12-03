package com.google.android.renderscript;

import android.graphics.Bitmap;
import kotlin.jvm.internal.j;
import yf.a;

public final class Toolkit {

    /* renamed from: a  reason: collision with root package name */
    public static final Toolkit f20544a;

    /* renamed from: b  reason: collision with root package name */
    private static long f20545b;

    static {
        Toolkit toolkit = new Toolkit();
        f20544a = toolkit;
        try {
            System.loadLibrary("renderscript-toolkit");
            f20545b = toolkit.createNative();
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    private Toolkit() {
    }

    public static /* synthetic */ Bitmap b(Toolkit toolkit, Bitmap bitmap, float[] fArr, Range2d range2d, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            range2d = null;
        }
        return toolkit.a(bitmap, fArr, range2d);
    }

    private final native long createNative();

    private final native void nativeConvolveBitmap(long j10, Bitmap bitmap, Bitmap bitmap2, float[] fArr, Range2d range2d);

    public final Bitmap a(Bitmap bitmap, float[] fArr, Range2d range2d) {
        j.g(bitmap, "inputBitmap");
        j.g(fArr, "coefficients");
        boolean z10 = false;
        a.c("convolve", bitmap, false, 4, (Object) null);
        if (fArr.length == 9 || fArr.length == 25) {
            z10 = true;
        }
        if (z10) {
            a.e("convolve", bitmap, range2d);
            Bitmap a10 = a.a(bitmap);
            long j10 = f20545b;
            j.f(a10, "outputBitmap");
            nativeConvolveBitmap(j10, bitmap, a10, fArr, range2d);
            return a10;
        }
        throw new IllegalArgumentException(("RenderScript Toolkit convolve. Only 3x3 or 5x5 convolutions are supported. " + fArr.length + " coefficients provided.").toString());
    }
}
