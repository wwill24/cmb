package r;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.r1;
import androidx.camera.core.v1;
import java.util.List;
import q.d0;
import q.j;
import q.z;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f17218a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f17219b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f17220c;

    public h(@NonNull r1 r1Var, @NonNull r1 r1Var2) {
        this.f17218a = r1Var2.a(d0.class);
        this.f17219b = r1Var.a(z.class);
        this.f17220c = r1Var.a(j.class);
    }

    public void a(List<DeferrableSurface> list) {
        if (b() && list != null) {
            for (DeferrableSurface c10 : list) {
                c10.c();
            }
            v1.a("ForceCloseDeferrableSurface", "deferrableSurface closed");
        }
    }

    public boolean b() {
        return this.f17218a || this.f17219b || this.f17220c;
    }
}
