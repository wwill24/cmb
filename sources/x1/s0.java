package x1;

import android.view.View;
import android.view.WindowId;
import androidx.annotation.NonNull;

class s0 implements t0 {

    /* renamed from: a  reason: collision with root package name */
    private final WindowId f18488a;

    s0(@NonNull View view) {
        this.f18488a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof s0) && ((s0) obj).f18488a.equals(this.f18488a);
    }

    public int hashCode() {
        return this.f18488a.hashCode();
    }
}
