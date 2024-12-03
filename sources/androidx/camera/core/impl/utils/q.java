package androidx.camera.core.impl.utils;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.core.util.h;
import java.util.Locale;

public class q {

    /* renamed from: a  reason: collision with root package name */
    public static final RectF f2688a = new RectF(-1.0f, -1.0f, 1.0f, 1.0f);

    @NonNull
    public static Matrix a(@NonNull Rect rect) {
        return b(new RectF(rect));
    }

    @NonNull
    public static Matrix b(@NonNull RectF rectF) {
        Matrix matrix = new Matrix();
        matrix.setRectToRect(f2688a, rectF, Matrix.ScaleToFit.FILL);
        return matrix;
    }

    @NonNull
    public static Matrix c(@NonNull RectF rectF, @NonNull RectF rectF2, int i10) {
        return d(rectF, rectF2, i10, false);
    }

    @NonNull
    public static Matrix d(@NonNull RectF rectF, @NonNull RectF rectF2, int i10, boolean z10) {
        Matrix matrix = new Matrix();
        matrix.setRectToRect(rectF, f2688a, Matrix.ScaleToFit.FILL);
        matrix.postRotate((float) i10);
        if (z10) {
            matrix.postScale(-1.0f, 1.0f);
        }
        matrix.postConcat(b(rectF2));
        return matrix;
    }

    public static boolean e(@NonNull Rect rect, @NonNull Size size) {
        if (rect.left == 0 && rect.top == 0 && rect.width() == size.getWidth() && rect.height() == size.getHeight()) {
            return false;
        }
        return true;
    }

    public static boolean f(int i10) {
        if (i10 == 90 || i10 == 270) {
            return true;
        }
        if (i10 == 0 || i10 == 180) {
            return false;
        }
        throw new IllegalArgumentException("Invalid rotation degrees: " + i10);
    }

    public static boolean g(@NonNull Size size, boolean z10, @NonNull Size size2, boolean z11) {
        float f10;
        float f11;
        float f12;
        float f13;
        if (z10) {
            f10 = ((float) size.getWidth()) / ((float) size.getHeight());
            f11 = f10;
        } else {
            f10 = (((float) size.getWidth()) + 1.0f) / (((float) size.getHeight()) - 1.0f);
            f11 = (((float) size.getWidth()) - 1.0f) / (((float) size.getHeight()) + 1.0f);
        }
        if (z11) {
            f12 = ((float) size2.getWidth()) / ((float) size2.getHeight());
            f13 = f12;
        } else {
            float width = (((float) size2.getWidth()) + 1.0f) / (((float) size2.getHeight()) - 1.0f);
            f12 = (((float) size2.getWidth()) - 1.0f) / (((float) size2.getHeight()) + 1.0f);
            f13 = width;
        }
        if (f10 < f12 || f13 < f11) {
            return false;
        }
        return true;
    }

    @NonNull
    public static Size h(@NonNull Rect rect) {
        return new Size(rect.width(), rect.height());
    }

    @NonNull
    public static String i(@NonNull Rect rect) {
        return String.format(Locale.US, "%s(%dx%d)", new Object[]{rect, Integer.valueOf(rect.width()), Integer.valueOf(rect.height())});
    }

    @NonNull
    public static Size j(@NonNull Size size) {
        return new Size(size.getHeight(), size.getWidth());
    }

    @NonNull
    public static Size k(@NonNull Size size, int i10) {
        boolean z10;
        if (i10 % 90 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        h.b(z10, "Invalid rotation degrees: " + i10);
        if (f(q(i10))) {
            return j(size);
        }
        return size;
    }

    @NonNull
    public static Rect l(@NonNull Size size) {
        return m(size, 0, 0);
    }

    @NonNull
    public static Rect m(@NonNull Size size, int i10, int i11) {
        return new Rect(i10, i11, size.getWidth() + i10, size.getHeight() + i11);
    }

    @NonNull
    public static RectF n(@NonNull Size size) {
        return o(size, 0, 0);
    }

    @NonNull
    public static RectF o(@NonNull Size size, int i10, int i11) {
        return new RectF((float) i10, (float) i11, (float) (i10 + size.getWidth()), (float) (i11 + size.getHeight()));
    }

    @NonNull
    public static Matrix p(@NonNull Matrix matrix, @NonNull Rect rect) {
        Matrix matrix2 = new Matrix(matrix);
        matrix2.postTranslate((float) (-rect.left), (float) (-rect.top));
        return matrix2;
    }

    public static int q(int i10) {
        return ((i10 % 360) + 360) % 360;
    }
}
