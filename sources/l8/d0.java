package l8;

import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jxmpp.jid.EntityBareJid;
import vj.j;

public final /* synthetic */ class d0 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h1 f16070a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Message f16071b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ EntityBareJid f16072c;

    public /* synthetic */ d0(h1 h1Var, Message message, EntityBareJid entityBareJid) {
        this.f16070a = h1Var;
        this.f16071b = message;
        this.f16072c = entityBareJid;
    }

    public final Object apply(Object obj) {
        return this.f16070a.n1(this.f16071b, this.f16072c, (XMPPTCPConnection) obj);
    }
}
