package l8;

import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jxmpp.jid.Jid;
import vj.j;

public final /* synthetic */ class a0 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Jid f16051a;

    public /* synthetic */ a0(Jid jid) {
        this.f16051a = jid;
    }

    public final Object apply(Object obj) {
        return h1.M0(this.f16051a, (XMPPTCPConnection) obj);
    }
}
