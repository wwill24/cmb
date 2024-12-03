package g6;

import com.coffeemeetsbagel.models.dto.Location;
import com.google.gson.d;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final d f15194a = new d();

    public static final class a extends qg.a<Location> {
        a() {
        }
    }

    public final String a(Location location) {
        if (location != null) {
            return this.f15194a.u(location);
        }
        return null;
    }

    public final Location b(String str) {
        boolean z10;
        if (str == null || str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return null;
        }
        return (Location) this.f15194a.l(str, new a().d());
    }
}
