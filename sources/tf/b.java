package tf;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import java.util.Arrays;

public final class b implements c {

    /* renamed from: a  reason: collision with root package name */
    private final c f24496a;

    /* renamed from: b  reason: collision with root package name */
    private final float f24497b;

    public b(float f10, @NonNull c cVar) {
        while (cVar instanceof b) {
            cVar = ((b) cVar).f24496a;
            f10 += ((b) cVar).f24497b;
        }
        this.f24496a = cVar;
        this.f24497b = f10;
    }

    public float a(@NonNull RectF rectF) {
        return Math.max(0.0f, this.f24496a.a(rectF) + this.f24497b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!this.f24496a.equals(bVar.f24496a) || this.f24497b != bVar.f24497b) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f24496a, Float.valueOf(this.f24497b)});
    }
}
