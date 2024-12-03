package cf;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import androidx.annotation.NonNull;

public class g implements TypeEvaluator<Matrix> {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f18987a = new float[9];

    /* renamed from: b  reason: collision with root package name */
    private final float[] f18988b = new float[9];

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f18989c = new Matrix();

    @NonNull
    public Matrix a(float f10, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
        matrix.getValues(this.f18987a);
        matrix2.getValues(this.f18988b);
        for (int i10 = 0; i10 < 9; i10++) {
            float[] fArr = this.f18988b;
            float f11 = fArr[i10];
            float f12 = this.f18987a[i10];
            fArr[i10] = f12 + ((f11 - f12) * f10);
        }
        this.f18989c.setValues(this.f18988b);
        return this.f18989c;
    }
}
