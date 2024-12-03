package v8;

import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.models.NetworkProfile;
import java.util.List;
import vj.j;

public final /* synthetic */ class h implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProfileManager f18140a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NetworkProfile f18141b;

    public /* synthetic */ h(ProfileManager profileManager, NetworkProfile networkProfile) {
        this.f18140a = profileManager;
        this.f18141b = networkProfile;
    }

    public final Object apply(Object obj) {
        return this.f18140a.i0(this.f18141b, (List) obj);
    }
}
