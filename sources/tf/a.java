package tf;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import java.util.Arrays;

public final class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private final float f24495a;

    public a(float f10) {
        this.f24495a = f10;
    }

    public float a(@NonNull RectF rectF) {
        return this.f24495a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        if (this.f24495a == ((a) obj).f24495a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f24495a)});
    }
}
