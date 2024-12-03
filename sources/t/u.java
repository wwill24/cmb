package t;

import a0.n;
import a0.o;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.impl.p;
import androidx.camera.core.impl.utils.i;
import androidx.camera.core.impl.utils.q;
import androidx.camera.core.o1;
import androidx.core.util.h;
import java.io.IOException;
import t.a0;
import v.c;

final class u implements n<a0.b, o<o1>> {
    u() {
    }

    @NonNull
    private static Matrix b(int i10, @NonNull Size size, int i11) {
        Size size2;
        int i12 = i10 - i11;
        if (q.f(q.q(i12))) {
            size2 = new Size(size.getHeight(), size.getWidth());
        } else {
            size2 = size;
        }
        return q.c(new RectF(0.0f, 0.0f, (float) size2.getWidth(), (float) size2.getHeight()), new RectF(0.0f, 0.0f, (float) size.getWidth(), (float) size.getHeight()), i12);
    }

    @NonNull
    private static Rect c(@NonNull Rect rect, @NonNull Matrix matrix) {
        RectF rectF = new RectF(rect);
        matrix.mapRect(rectF);
        Rect rect2 = new Rect();
        rectF.round(rect2);
        return rect2;
    }

    @NonNull
    private static Matrix d(@NonNull Matrix matrix, @NonNull Matrix matrix2) {
        Matrix matrix3 = new Matrix(matrix);
        matrix3.postConcat(matrix2);
        return matrix3;
    }

    private static boolean e(@NonNull i iVar, @NonNull o1 o1Var) {
        return iVar.u() == o1Var.getWidth() && iVar.p() == o1Var.getHeight();
    }

    @NonNull
    /* renamed from: a */
    public o<o1> apply(@NonNull a0.b bVar) throws ImageCaptureException {
        i iVar;
        Matrix matrix;
        int i10;
        o1 a10 = bVar.a();
        b0 b10 = bVar.b();
        if (a10.getFormat() == 256) {
            try {
                iVar = i.j(a10);
                a10.M0()[0].d().rewind();
            } catch (IOException e10) {
                throw new ImageCaptureException(1, "Failed to extract EXIF data.", e10);
            }
        } else {
            iVar = null;
        }
        p e11 = ((c) a10.z1()).e();
        Rect a11 = b10.a();
        Matrix e12 = b10.e();
        int d10 = b10.d();
        if (p.f17610g.b(a10)) {
            h.h(iVar, "The image must have JPEG exif.");
            h.j(e(iVar, a10), "Exif size does not match image size.");
            Matrix b11 = b(b10.d(), new Size(iVar.u(), iVar.p()), iVar.s());
            Rect c10 = c(b10.a(), b11);
            matrix = d(b10.e(), b11);
            Rect rect = c10;
            i10 = iVar.s();
            a11 = rect;
        } else {
            int i11 = d10;
            matrix = e12;
            i10 = i11;
        }
        return o.k(a10, iVar, a11, i10, matrix, e11);
    }
}
