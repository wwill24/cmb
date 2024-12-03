package q8;

import com.mparticle.TypedUserAttributeListener;
import com.mparticle.identity.MParticleUser;
import java.util.Map;

public final /* synthetic */ class c implements TypedUserAttributeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f17193a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f17194b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MParticleUser f17195c;

    public /* synthetic */ c(String str, Object obj, MParticleUser mParticleUser) {
        this.f17193a = str;
        this.f17194b = obj;
        this.f17195c = mParticleUser;
    }

    public final void onUserAttributesReceived(Map map, Map map2, long j10) {
        l.z(this.f17193a, this.f17194b, this.f17195c, map, map2, j10);
    }
}
