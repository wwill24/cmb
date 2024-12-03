package q8;

import com.mparticle.identity.IdentityApiResult;
import com.mparticle.identity.TaskSuccessListener;

public final /* synthetic */ class i implements TaskSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f17204a;

    public /* synthetic */ i(l lVar) {
        this.f17204a = lVar;
    }

    public final void onSuccess(IdentityApiResult identityApiResult) {
        this.f17204a.t(identityApiResult);
    }
}
