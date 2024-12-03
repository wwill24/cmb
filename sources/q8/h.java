package q8;

import com.mparticle.identity.IdentityHttpResponse;
import com.mparticle.identity.TaskFailureListener;

public final /* synthetic */ class h implements TaskFailureListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f17202a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f17203b;

    public /* synthetic */ h(l lVar, String str) {
        this.f17202a = lVar;
        this.f17203b = str;
    }

    public final void onFailure(IdentityHttpResponse identityHttpResponse) {
        this.f17202a.s(this.f17203b, identityHttpResponse);
    }
}
