package q8;

import com.mparticle.identity.IdentityHttpResponse;
import com.mparticle.identity.TaskFailureListener;

public final /* synthetic */ class b implements TaskFailureListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f17192a;

    public /* synthetic */ b(l lVar) {
        this.f17192a = lVar;
    }

    public final void onFailure(IdentityHttpResponse identityHttpResponse) {
        this.f17192a.A(identityHttpResponse);
    }
}
