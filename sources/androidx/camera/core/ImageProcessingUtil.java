package androidx.camera.core;

import android.media.Image;
import android.media.ImageWriter;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.x0;
import androidx.core.util.h;
import java.nio.ByteBuffer;
import java.util.Locale;
import w.a;

public final class ImageProcessingUtil {

    /* renamed from: a  reason: collision with root package name */
    private static int f2081a;

    enum Result {
        UNKNOWN,
        SUCCESS,
        ERROR_CONVERSION
    }

    static {
        System.loadLibrary("image_processing_util_jni");
    }

    public static boolean c(@NonNull o1 o1Var) {
        if (!i(o1Var)) {
            v1.c("ImageProcessingUtil", "Unsupported format for YUV to RGB");
            return false;
        } else if (d(o1Var) != Result.ERROR_CONVERSION) {
            return true;
        } else {
            v1.c("ImageProcessingUtil", "One pixel shift for YUV failure");
            return false;
        }
    }

    @NonNull
    private static Result d(@NonNull o1 o1Var) {
        int width = o1Var.getWidth();
        int height = o1Var.getHeight();
        int e10 = o1Var.M0()[0].e();
        int e11 = o1Var.M0()[1].e();
        int e12 = o1Var.M0()[2].e();
        int f10 = o1Var.M0()[0].f();
        int f11 = o1Var.M0()[1].f();
        if (nativeShiftPixel(o1Var.M0()[0].d(), e10, o1Var.M0()[1].d(), e11, o1Var.M0()[2].d(), e12, f10, f11, width, height, f10, f11, f11) != 0) {
            return Result.ERROR_CONVERSION;
        }
        return Result.SUCCESS;
    }

    public static o1 e(@NonNull x0 x0Var, @NonNull byte[] bArr) {
        boolean z10;
        if (x0Var.c() == 256) {
            z10 = true;
        } else {
            z10 = false;
        }
        h.a(z10);
        h.g(bArr);
        Surface surface = x0Var.getSurface();
        h.g(surface);
        if (nativeWriteJpegToSurface(bArr, surface) != 0) {
            v1.c("ImageProcessingUtil", "Failed to enqueue JPEG image.");
            return null;
        }
        o1 b10 = x0Var.b();
        if (b10 == null) {
            v1.c("ImageProcessingUtil", "Failed to get acquire JPEG image.");
        }
        return b10;
    }

    public static o1 f(@NonNull o1 o1Var, @NonNull x0 x0Var, ByteBuffer byteBuffer, int i10, boolean z10) {
        if (!i(o1Var)) {
            v1.c("ImageProcessingUtil", "Unsupported format for YUV to RGB");
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!h(i10)) {
            v1.c("ImageProcessingUtil", "Unsupported rotation degrees for rotate RGB");
            return null;
        } else if (g(o1Var, x0Var.getSurface(), byteBuffer, i10, z10) == Result.ERROR_CONVERSION) {
            v1.c("ImageProcessingUtil", "YUV to RGB conversion failure");
            return null;
        } else {
            if (Log.isLoggable("MH", 3)) {
                v1.a("ImageProcessingUtil", String.format(Locale.US, "Image processing performance profiling, duration: [%d], image count: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(f2081a)}));
                f2081a++;
            }
            o1 b10 = x0Var.b();
            if (b10 == null) {
                v1.c("ImageProcessingUtil", "YUV to RGB acquireLatestImage failure");
                return null;
            }
            v2 v2Var = new v2(b10);
            v2Var.a(new m1(b10, o1Var));
            return v2Var;
        }
    }

    @NonNull
    private static Result g(@NonNull o1 o1Var, @NonNull Surface surface, ByteBuffer byteBuffer, int i10, boolean z10) {
        int i11;
        int i12;
        int i13;
        int width = o1Var.getWidth();
        int height = o1Var.getHeight();
        int e10 = o1Var.M0()[0].e();
        int e11 = o1Var.M0()[1].e();
        int e12 = o1Var.M0()[2].e();
        int f10 = o1Var.M0()[0].f();
        int f11 = o1Var.M0()[1].f();
        if (z10) {
            i11 = f10;
        } else {
            i11 = 0;
        }
        if (z10) {
            i12 = f11;
        } else {
            i12 = 0;
        }
        if (z10) {
            i13 = f11;
        } else {
            i13 = 0;
        }
        if (nativeConvertAndroid420ToABGR(o1Var.M0()[0].d(), e10, o1Var.M0()[1].d(), e11, o1Var.M0()[2].d(), e12, f10, f11, surface, byteBuffer, width, height, i11, i12, i13, i10) != 0) {
            return Result.ERROR_CONVERSION;
        }
        return Result.SUCCESS;
    }

    private static boolean h(int i10) {
        return i10 == 0 || i10 == 90 || i10 == 180 || i10 == 270;
    }

    private static boolean i(@NonNull o1 o1Var) {
        if (o1Var.getFormat() == 35 && o1Var.M0().length == 3) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void j(o1 o1Var, o1 o1Var2, o1 o1Var3) {
        if (o1Var != null && o1Var2 != null) {
            o1Var2.close();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void k(o1 o1Var, o1 o1Var2, o1 o1Var3) {
        if (o1Var != null && o1Var2 != null) {
            o1Var2.close();
        }
    }

    public static o1 l(@NonNull o1 o1Var, @NonNull x0 x0Var, @NonNull ImageWriter imageWriter, @NonNull ByteBuffer byteBuffer, @NonNull ByteBuffer byteBuffer2, @NonNull ByteBuffer byteBuffer3, int i10) {
        Result result;
        if (!i(o1Var)) {
            v1.c("ImageProcessingUtil", "Unsupported format for rotate YUV");
            return null;
        } else if (!h(i10)) {
            v1.c("ImageProcessingUtil", "Unsupported rotation degrees for rotate YUV");
            return null;
        } else {
            Result result2 = Result.ERROR_CONVERSION;
            if (i10 > 0) {
                result = m(o1Var, imageWriter, byteBuffer, byteBuffer2, byteBuffer3, i10);
            } else {
                result = result2;
            }
            if (result == result2) {
                v1.c("ImageProcessingUtil", "rotate YUV failure");
                return null;
            }
            o1 b10 = x0Var.b();
            if (b10 == null) {
                v1.c("ImageProcessingUtil", "YUV rotation acquireLatestImage failure");
                return null;
            }
            v2 v2Var = new v2(b10);
            v2Var.a(new n1(b10, o1Var));
            return v2Var;
        }
    }

    private static Result m(@NonNull o1 o1Var, @NonNull ImageWriter imageWriter, @NonNull ByteBuffer byteBuffer, @NonNull ByteBuffer byteBuffer2, @NonNull ByteBuffer byteBuffer3, int i10) {
        int width = o1Var.getWidth();
        int height = o1Var.getHeight();
        int e10 = o1Var.M0()[0].e();
        int e11 = o1Var.M0()[1].e();
        int e12 = o1Var.M0()[2].e();
        int f10 = o1Var.M0()[1].f();
        Image b10 = a.b(imageWriter);
        if (b10 == null) {
            return Result.ERROR_CONVERSION;
        }
        Image image = b10;
        Image image2 = image;
        if (nativeRotateYUV(o1Var.M0()[0].d(), e10, o1Var.M0()[1].d(), e11, o1Var.M0()[2].d(), e12, f10, b10.getPlanes()[0].getBuffer(), b10.getPlanes()[0].getRowStride(), b10.getPlanes()[0].getPixelStride(), b10.getPlanes()[1].getBuffer(), b10.getPlanes()[1].getRowStride(), b10.getPlanes()[1].getPixelStride(), b10.getPlanes()[2].getBuffer(), b10.getPlanes()[2].getRowStride(), image.getPlanes()[2].getPixelStride(), byteBuffer, byteBuffer2, byteBuffer3, width, height, i10) != 0) {
            return Result.ERROR_CONVERSION;
        }
        a.e(imageWriter, image2);
        return Result.SUCCESS;
    }

    private static native int nativeConvertAndroid420ToABGR(@NonNull ByteBuffer byteBuffer, int i10, @NonNull ByteBuffer byteBuffer2, int i11, @NonNull ByteBuffer byteBuffer3, int i12, int i13, int i14, @NonNull Surface surface, ByteBuffer byteBuffer4, int i15, int i16, int i17, int i18, int i19, int i20);

    private static native int nativeRotateYUV(@NonNull ByteBuffer byteBuffer, int i10, @NonNull ByteBuffer byteBuffer2, int i11, @NonNull ByteBuffer byteBuffer3, int i12, int i13, @NonNull ByteBuffer byteBuffer4, int i14, int i15, @NonNull ByteBuffer byteBuffer5, int i16, int i17, @NonNull ByteBuffer byteBuffer6, int i18, int i19, @NonNull ByteBuffer byteBuffer7, @NonNull ByteBuffer byteBuffer8, @NonNull ByteBuffer byteBuffer9, int i20, int i21, int i22);

    private static native int nativeShiftPixel(@NonNull ByteBuffer byteBuffer, int i10, @NonNull ByteBuffer byteBuffer2, int i11, @NonNull ByteBuffer byteBuffer3, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19);

    private static native int nativeWriteJpegToSurface(@NonNull byte[] bArr, @NonNull Surface surface);
}
