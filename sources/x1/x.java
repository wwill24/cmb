package x1;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import androidx.annotation.NonNull;

class x implements y {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroupOverlay f18508a;

    x(@NonNull ViewGroup viewGroup) {
        this.f18508a = viewGroup.getOverlay();
    }

    public void a(@NonNull Drawable drawable) {
        this.f18508a.add(drawable);
    }

    public void b(@NonNull Drawable drawable) {
        this.f18508a.remove(drawable);
    }

    public void c(@NonNull View view) {
        this.f18508a.add(view);
    }

    public void d(@NonNull View view) {
        this.f18508a.remove(view);
    }
}
