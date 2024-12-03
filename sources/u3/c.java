package u3;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;

final class c extends b<Drawable> {
    private c(Drawable drawable) {
        super(drawable);
    }

    static l3.c<Drawable> d(Drawable drawable) {
        if (drawable != null) {
            return new c(drawable);
        }
        return null;
    }

    public void a() {
    }

    @NonNull
    public Class<Drawable> b() {
        return this.f18013a.getClass();
    }

    public int getSize() {
        return Math.max(1, this.f18013a.getIntrinsicWidth() * this.f18013a.getIntrinsicHeight() * 4);
    }
}
