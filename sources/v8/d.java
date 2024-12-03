package v8;

import android.os.Bundle;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import vj.f;

public final /* synthetic */ class d implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProfileManager f18136a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Bundle f18137b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a f18138c;

    public /* synthetic */ d(ProfileManager profileManager, Bundle bundle, a aVar) {
        this.f18136a = profileManager;
        this.f18137b = bundle;
        this.f18138c = aVar;
    }

    public final void accept(Object obj) {
        this.f18136a.e0(this.f18137b, this.f18138c, (Throwable) obj);
    }
}
