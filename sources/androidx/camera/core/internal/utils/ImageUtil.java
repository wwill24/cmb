package androidx.camera.core.internal.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.YuvImage;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.o1;
import androidx.camera.core.v1;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ImageUtil {

    public static final class CodecFailedException extends Exception {
        private FailureType mFailureType;

        public enum FailureType {
            ENCODE_FAILED,
            DECODE_FAILED,
            UNKNOWN
        }

        CodecFailedException(@NonNull String str, @NonNull FailureType failureType) {
            super(str);
            this.mFailureType = failureType;
        }

        @NonNull
        public FailureType a() {
            return this.mFailureType;
        }
    }

    public static Rect a(@NonNull Size size, @NonNull Rational rational) {
        int i10;
        if (!f(rational)) {
            v1.l("ImageUtil", "Invalid view ratio.");
            return null;
        }
        int width = size.getWidth();
        int height = size.getHeight();
        float f10 = (float) width;
        float f11 = (float) height;
        int numerator = rational.getNumerator();
        int denominator = rational.getDenominator();
        int i11 = 0;
        if (rational.floatValue() > f10 / f11) {
            int round = Math.round((f10 / ((float) numerator)) * ((float) denominator));
            int i12 = round;
            i10 = (height - round) / 2;
            height = i12;
        } else {
            int round2 = Math.round((f11 / ((float) denominator)) * ((float) numerator));
            int i13 = (width - round2) / 2;
            width = round2;
            i10 = 0;
            i11 = i13;
        }
        return new Rect(i11, i10, width + i11, height + i10);
    }

    @NonNull
    public static Rect b(@NonNull Rect rect, int i10, @NonNull Size size, int i11) {
        Matrix matrix = new Matrix();
        matrix.setRotate((float) (i11 - i10));
        float[] o10 = o(size);
        matrix.mapPoints(o10);
        matrix.postTranslate(-k(o10[0], o10[2], o10[4], o10[6]), -k(o10[1], o10[3], o10[5], o10[7]));
        matrix.invert(matrix);
        RectF rectF = new RectF();
        matrix.mapRect(rectF, new RectF(rect));
        rectF.sort();
        Rect rect2 = new Rect();
        rectF.round(rect2);
        return rect2;
    }

    @NonNull
    private static byte[] c(@NonNull byte[] bArr, @NonNull Rect rect, int i10) throws CodecFailedException {
        try {
            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, false);
            Bitmap decodeRegion = newInstance.decodeRegion(rect, new BitmapFactory.Options());
            newInstance.recycle();
            if (decodeRegion != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                if (decodeRegion.compress(Bitmap.CompressFormat.JPEG, i10, byteArrayOutputStream)) {
                    decodeRegion.recycle();
                    return byteArrayOutputStream.toByteArray();
                }
                throw new CodecFailedException("Encode bitmap failed.", CodecFailedException.FailureType.ENCODE_FAILED);
            }
            throw new CodecFailedException("Decode byte array failed.", CodecFailedException.FailureType.DECODE_FAILED);
        } catch (IllegalArgumentException e10) {
            throw new CodecFailedException("Decode byte array failed with illegal argument." + e10, CodecFailedException.FailureType.DECODE_FAILED);
        } catch (IOException unused) {
            throw new CodecFailedException("Decode byte array failed.", CodecFailedException.FailureType.DECODE_FAILED);
        }
    }

    @NonNull
    public static Rational d(int i10, @NonNull Rational rational) {
        if (i10 == 90 || i10 == 270) {
            return e(rational);
        }
        return new Rational(rational.getNumerator(), rational.getDenominator());
    }

    private static Rational e(Rational rational) {
        if (rational == null) {
            return rational;
        }
        return new Rational(rational.getDenominator(), rational.getNumerator());
    }

    public static boolean f(Rational rational) {
        return rational != null && rational.floatValue() > 0.0f && !rational.isNaN();
    }

    public static boolean g(@NonNull Size size, Rational rational) {
        if (rational == null || rational.floatValue() <= 0.0f || !h(size, rational) || rational.isNaN()) {
            return false;
        }
        return true;
    }

    private static boolean h(@NonNull Size size, @NonNull Rational rational) {
        int width = size.getWidth();
        int height = size.getHeight();
        float numerator = (float) rational.getNumerator();
        float denominator = (float) rational.getDenominator();
        if (height == Math.round((((float) width) / numerator) * denominator) && width == Math.round((((float) height) / denominator) * numerator)) {
            return false;
        }
        return true;
    }

    @NonNull
    public static byte[] i(@NonNull o1 o1Var) {
        if (o1Var.getFormat() == 256) {
            ByteBuffer d10 = o1Var.M0()[0].d();
            byte[] bArr = new byte[d10.capacity()];
            d10.rewind();
            d10.get(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("Incorrect image format of the input image proxy: " + o1Var.getFormat());
    }

    @NonNull
    public static byte[] j(@NonNull o1 o1Var, @NonNull Rect rect, int i10) throws CodecFailedException {
        if (o1Var.getFormat() == 256) {
            return c(i(o1Var), rect, i10);
        }
        throw new IllegalArgumentException("Incorrect image format of the input image proxy: " + o1Var.getFormat());
    }

    public static float k(float f10, float f11, float f12, float f13) {
        return Math.min(Math.min(f10, f11), Math.min(f12, f13));
    }

    private static byte[] l(@NonNull byte[] bArr, int i10, int i11, Rect rect, int i12) throws CodecFailedException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        YuvImage yuvImage = new YuvImage(bArr, 17, i10, i11, (int[]) null);
        if (rect == null) {
            rect = new Rect(0, 0, i10, i11);
        }
        if (yuvImage.compressToJpeg(rect, i12, byteArrayOutputStream)) {
            return byteArrayOutputStream.toByteArray();
        }
        throw new CodecFailedException("YuvImage failed to encode jpeg.", CodecFailedException.FailureType.ENCODE_FAILED);
    }

    public static boolean m(int i10, int i11, int i12, int i13) {
        return (i10 == i12 && i11 == i13) ? false : true;
    }

    public static boolean n(@NonNull o1 o1Var) {
        return m(o1Var.getWidth(), o1Var.getHeight(), o1Var.X0().width(), o1Var.X0().height());
    }

    @NonNull
    public static float[] o(@NonNull Size size) {
        return new float[]{0.0f, 0.0f, (float) size.getWidth(), 0.0f, (float) size.getWidth(), (float) size.getHeight(), 0.0f, (float) size.getHeight()};
    }

    @NonNull
    public static byte[] p(@NonNull o1 o1Var, Rect rect, int i10) throws CodecFailedException {
        if (o1Var.getFormat() == 35) {
            return l(q(o1Var), o1Var.getWidth(), o1Var.getHeight(), rect, i10);
        }
        throw new IllegalArgumentException("Incorrect image format of the input image proxy: " + o1Var.getFormat());
    }

    @NonNull
    public static byte[] q(@NonNull o1 o1Var) {
        o1.a aVar = o1Var.M0()[0];
        o1.a aVar2 = o1Var.M0()[1];
        o1.a aVar3 = o1Var.M0()[2];
        ByteBuffer d10 = aVar.d();
        ByteBuffer d11 = aVar2.d();
        ByteBuffer d12 = aVar3.d();
        d10.rewind();
        d11.rewind();
        d12.rewind();
        int remaining = d10.remaining();
        byte[] bArr = new byte[(((o1Var.getWidth() * o1Var.getHeight()) / 2) + remaining)];
        int i10 = 0;
        for (int i11 = 0; i11 < o1Var.getHeight(); i11++) {
            d10.get(bArr, i10, o1Var.getWidth());
            i10 += o1Var.getWidth();
            d10.position(Math.min(remaining, (d10.position() - o1Var.getWidth()) + aVar.e()));
        }
        int height = o1Var.getHeight() / 2;
        int width = o1Var.getWidth() / 2;
        int e10 = aVar3.e();
        int e11 = aVar2.e();
        int f10 = aVar3.f();
        int f11 = aVar2.f();
        byte[] bArr2 = new byte[e10];
        byte[] bArr3 = new byte[e11];
        for (int i12 = 0; i12 < height; i12++) {
            d12.get(bArr2, 0, Math.min(e10, d12.remaining()));
            d11.get(bArr3, 0, Math.min(e11, d11.remaining()));
            int i13 = 0;
            int i14 = 0;
            for (int i15 = 0; i15 < width; i15++) {
                int i16 = i10 + 1;
                bArr[i10] = bArr2[i13];
                i10 = i16 + 1;
                bArr[i16] = bArr3[i14];
                i13 += f10;
                i14 += f11;
            }
        }
        return bArr;
    }
}
