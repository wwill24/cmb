package q8;

import com.mparticle.identity.IdentityApiResult;
import com.mparticle.identity.TaskSuccessListener;

public final /* synthetic */ class f implements TaskSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f17199a;

    public /* synthetic */ f(l lVar) {
        this.f17199a = lVar;
    }

    public final void onSuccess(IdentityApiResult identityApiResult) {
        this.f17199a.u(identityApiResult);
    }
}
