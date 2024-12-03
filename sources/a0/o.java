package a0;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.p;
import androidx.camera.core.impl.utils.i;
import androidx.camera.core.impl.utils.q;
import androidx.camera.core.o1;
import androidx.core.util.h;

public abstract class o<T> {
    @NonNull
    public static o<Bitmap> j(@NonNull Bitmap bitmap, @NonNull i iVar, @NonNull Rect rect, int i10, @NonNull Matrix matrix, @NonNull p pVar) {
        return new b(bitmap, iVar, 42, new Size(bitmap.getWidth(), bitmap.getHeight()), rect, i10, matrix, pVar);
    }

    @NonNull
    public static o<o1> k(@NonNull o1 o1Var, i iVar, @NonNull Rect rect, int i10, @NonNull Matrix matrix, @NonNull p pVar) {
        if (o1Var.getFormat() == 256) {
            h.h(iVar, "JPEG image must have Exif.");
        }
        return new b(o1Var, iVar, o1Var.getFormat(), new Size(o1Var.getWidth(), o1Var.getHeight()), rect, i10, matrix, pVar);
    }

    @NonNull
    public static o<byte[]> l(@NonNull byte[] bArr, @NonNull i iVar, int i10, @NonNull Size size, @NonNull Rect rect, int i11, @NonNull Matrix matrix, @NonNull p pVar) {
        return new b(bArr, iVar, i10, size, rect, i11, matrix, pVar);
    }

    @NonNull
    public abstract p a();

    @NonNull
    public abstract Rect b();

    @NonNull
    public abstract T c();

    public abstract i d();

    public abstract int e();

    public abstract int f();

    @NonNull
    public abstract Matrix g();

    @NonNull
    public abstract Size h();

    public boolean i() {
        return q.e(b(), h());
    }
}
