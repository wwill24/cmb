package q8;

import com.coffeemeetsbagel.models.NetworkProfile;
import com.mparticle.identity.IdentityHttpResponse;
import com.mparticle.identity.TaskFailureListener;

public final /* synthetic */ class d implements TaskFailureListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f17196a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NetworkProfile f17197b;

    public /* synthetic */ d(l lVar, NetworkProfile networkProfile) {
        this.f17196a = lVar;
        this.f17197b = networkProfile;
    }

    public final void onFailure(IdentityHttpResponse identityHttpResponse) {
        this.f17196a.w(this.f17197b, identityHttpResponse);
    }
}
