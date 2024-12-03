package tf;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import java.util.Arrays;

public final class i implements c {

    /* renamed from: a  reason: collision with root package name */
    private final float f24544a;

    public i(float f10) {
        this.f24544a = f10;
    }

    private static float b(@NonNull RectF rectF) {
        return Math.min(rectF.width(), rectF.height());
    }

    public float a(@NonNull RectF rectF) {
        return this.f24544a * b(rectF);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        if (this.f24544a == ((i) obj).f24544a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f24544a)});
    }
}
