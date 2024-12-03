package cf;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;
import androidx.annotation.NonNull;

public class f extends Property<ImageView, Matrix> {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f18986a = new Matrix();

    public f() {
        super(Matrix.class, "imageMatrixProperty");
    }

    @NonNull
    /* renamed from: a */
    public Matrix get(@NonNull ImageView imageView) {
        this.f18986a.set(imageView.getImageMatrix());
        return this.f18986a;
    }

    /* renamed from: b */
    public void set(@NonNull ImageView imageView, @NonNull Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }
}
