package q8;

import com.mparticle.identity.IdentityApiResult;
import com.mparticle.identity.TaskSuccessListener;

public final /* synthetic */ class e implements TaskSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f17198a;

    public /* synthetic */ e(l lVar) {
        this.f17198a = lVar;
    }

    public final void onSuccess(IdentityApiResult identityApiResult) {
        this.f17198a.x(identityApiResult);
    }
}
