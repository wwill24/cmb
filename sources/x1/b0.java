package x1;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
import androidx.annotation.NonNull;

class b0 implements c0 {

    /* renamed from: a  reason: collision with root package name */
    private final ViewOverlay f18362a;

    b0(@NonNull View view) {
        this.f18362a = view.getOverlay();
    }

    public void a(@NonNull Drawable drawable) {
        this.f18362a.add(drawable);
    }

    public void b(@NonNull Drawable drawable) {
        this.f18362a.remove(drawable);
    }
}
