package l8;

import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smackx.mam.MamManager;
import vj.j;

public final /* synthetic */ class g0 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h1 f16085a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MamManager.MamQuery f16086b;

    public /* synthetic */ g0(h1 h1Var, MamManager.MamQuery mamQuery) {
        this.f16085a = h1Var;
        this.f16086b = mamQuery;
    }

    public final Object apply(Object obj) {
        return this.f16085a.J0(this.f16086b, (XMPPTCPConnection) obj);
    }
}
