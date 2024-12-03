package l8;

import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import vj.f;

public final /* synthetic */ class h2 implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Stanza f16119a;

    public /* synthetic */ h2(Stanza stanza) {
        this.f16119a = stanza;
    }

    public final void accept(Object obj) {
        ((XMPPTCPConnection) obj).sendStanza(this.f16119a);
    }
}
