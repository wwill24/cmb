package l8;

import com.coffeemeetsbagel.feature.profile.ProfileManager;
import fj.d;
import fk.a;

public final class f implements d<e> {

    /* renamed from: a  reason: collision with root package name */
    private final a<ProfileManager> f16082a;

    public f(a<ProfileManager> aVar) {
        this.f16082a = aVar;
    }

    public static f a(a<ProfileManager> aVar) {
        return new f(aVar);
    }

    public static e c(ProfileManager profileManager) {
        return new e(profileManager);
    }

    /* renamed from: b */
    public e get() {
        return c(this.f16082a.get());
    }
}
