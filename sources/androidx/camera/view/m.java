package androidx.camera.view;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.a2;
import androidx.camera.core.impl.utils.p;

class m extends a2 {

    /* renamed from: d  reason: collision with root package name */
    static final PointF f3500d = new PointF(2.0f, 2.0f);
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final f f3501b;

    /* renamed from: c  reason: collision with root package name */
    private Matrix f3502c;

    m(@NonNull f fVar) {
        this.f3501b = fVar;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public PointF a(float f10, float f11) {
        float[] fArr = {f10, f11};
        synchronized (this) {
            Matrix matrix = this.f3502c;
            if (matrix == null) {
                PointF pointF = f3500d;
                return pointF;
            }
            matrix.mapPoints(fArr);
            return new PointF(fArr[0], fArr[1]);
        }
    }

    /* access modifiers changed from: package-private */
    public void e(@NonNull Size size, int i10) {
        p.a();
        synchronized (this) {
            if (size.getWidth() != 0) {
                if (size.getHeight() != 0) {
                    this.f3502c = this.f3501b.c(size, i10);
                    return;
                }
            }
            this.f3502c = null;
        }
    }
}
