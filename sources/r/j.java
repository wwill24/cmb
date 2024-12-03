package r;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.SurfaceConfig;
import q.l;
import q.o;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private final o f17221a;

    public j() {
        this((o) l.a(o.class));
    }

    @NonNull
    public Size a(@NonNull Size size) {
        Size b10;
        boolean z10;
        o oVar = this.f17221a;
        if (oVar == null || (b10 = oVar.b(SurfaceConfig.ConfigType.PRIV)) == null) {
            return size;
        }
        if (b10.getWidth() * b10.getHeight() > size.getWidth() * size.getHeight()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return b10;
        }
        return size;
    }

    j(o oVar) {
        this.f17221a = oVar;
    }
}
