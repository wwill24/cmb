package v;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.UseCase;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.core.util.h;
import java.util.HashMap;
import java.util.Map;

public class k {
    @NonNull
    public static Map<UseCase, Rect> a(@NonNull Rect rect, boolean z10, @NonNull Rational rational, int i10, int i11, int i12, @NonNull Map<UseCase, Size> map) {
        boolean z11;
        if (rect.width() <= 0 || rect.height() <= 0) {
            z11 = false;
        } else {
            z11 = true;
        }
        h.b(z11, "Cannot compute viewport crop rects zero sized sensor rect.");
        RectF rectF = new RectF(rect);
        HashMap hashMap = new HashMap();
        RectF rectF2 = new RectF(rect);
        for (Map.Entry next : map.entrySet()) {
            Matrix matrix = new Matrix();
            RectF rectF3 = new RectF(0.0f, 0.0f, (float) ((Size) next.getValue()).getWidth(), (float) ((Size) next.getValue()).getHeight());
            matrix.setRectToRect(rectF3, rectF, Matrix.ScaleToFit.CENTER);
            hashMap.put((UseCase) next.getKey(), matrix);
            RectF rectF4 = new RectF();
            matrix.mapRect(rectF4, rectF3);
            rectF2.intersect(rectF4);
        }
        RectF g10 = g(rectF2, ImageUtil.d(i10, rational), i11, z10, i12, i10);
        HashMap hashMap2 = new HashMap();
        RectF rectF5 = new RectF();
        Matrix matrix2 = new Matrix();
        for (Map.Entry entry : hashMap.entrySet()) {
            ((Matrix) entry.getValue()).invert(matrix2);
            matrix2.mapRect(rectF5, g10);
            Rect rect2 = new Rect();
            rectF5.round(rect2);
            hashMap2.put((UseCase) entry.getKey(), rect2);
        }
        return hashMap2;
    }

    private static RectF b(boolean z10, int i10, RectF rectF, RectF rectF2) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18 = true;
        if (i10 != 0 || z10) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (i10 != 90 || !z10) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (z11 || z12) {
            return rectF2;
        }
        if (i10 != 0 || !z10) {
            z13 = false;
        } else {
            z13 = true;
        }
        if (i10 != 270 || z10) {
            z14 = false;
        } else {
            z14 = true;
        }
        if (z13 || z14) {
            return c(rectF2, rectF.centerX());
        }
        if (i10 != 90 || z10) {
            z15 = false;
        } else {
            z15 = true;
        }
        if (i10 != 180 || !z10) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z15 || z16) {
            return d(rectF2, rectF.centerY());
        }
        if (i10 != 180 || z10) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (i10 != 270 || !z10) {
            z18 = false;
        }
        if (z17 || z18) {
            return c(d(rectF2, rectF.centerY()), rectF.centerX());
        }
        throw new IllegalArgumentException("Invalid argument: mirrored " + z10 + " rotation " + i10);
    }

    private static RectF c(RectF rectF, float f10) {
        return new RectF(e(rectF.right, f10), rectF.top, e(rectF.left, f10), rectF.bottom);
    }

    private static RectF d(RectF rectF, float f10) {
        return new RectF(rectF.left, f(rectF.bottom, f10), rectF.right, f(rectF.top, f10));
    }

    private static float e(float f10, float f11) {
        return (f11 + f11) - f10;
    }

    private static float f(float f10, float f11) {
        return (f11 + f11) - f10;
    }

    @SuppressLint({"SwitchIntDef"})
    @NonNull
    public static RectF g(@NonNull RectF rectF, @NonNull Rational rational, int i10, boolean z10, int i11, int i12) {
        if (i10 == 3) {
            return rectF;
        }
        Matrix matrix = new Matrix();
        RectF rectF2 = new RectF(0.0f, 0.0f, (float) rational.getNumerator(), (float) rational.getDenominator());
        if (i10 == 0) {
            matrix.setRectToRect(rectF2, rectF, Matrix.ScaleToFit.START);
        } else if (i10 == 1) {
            matrix.setRectToRect(rectF2, rectF, Matrix.ScaleToFit.CENTER);
        } else if (i10 == 2) {
            matrix.setRectToRect(rectF2, rectF, Matrix.ScaleToFit.END);
        } else {
            throw new IllegalStateException("Unexpected scale type: " + i10);
        }
        RectF rectF3 = new RectF();
        matrix.mapRect(rectF3, rectF2);
        return b(h(z10, i11), i12, rectF, rectF3);
    }

    private static boolean h(boolean z10, int i10) {
        boolean z11 = true;
        if (i10 != 1) {
            z11 = false;
        }
        return z10 ^ z11;
    }
}
