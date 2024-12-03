package v8;

import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.models.responses.ResponseGeneric;
import vj.f;

public final /* synthetic */ class l implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProfileContract$Manager.a f18144a;

    public /* synthetic */ l(ProfileContract$Manager.a aVar) {
        this.f18144a = aVar;
    }

    public final void accept(Object obj) {
        ProfileManager.b0(this.f18144a, (ResponseGeneric) obj);
    }
}
