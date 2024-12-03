package q8;

import com.mparticle.identity.IdentityApiRequest;
import com.mparticle.identity.IdentityStateListener;
import com.mparticle.identity.MParticleUser;

public final /* synthetic */ class j implements IdentityStateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IdentityApiRequest f17205a;

    public /* synthetic */ j(IdentityApiRequest identityApiRequest) {
        this.f17205a = identityApiRequest;
    }

    public final void onUserIdentified(MParticleUser mParticleUser, MParticleUser mParticleUser2) {
        l.y(this.f17205a, mParticleUser, mParticleUser2);
    }
}
