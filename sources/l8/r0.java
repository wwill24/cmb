package l8;

import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jxmpp.jid.EntityBareJid;
import vj.j;

public final /* synthetic */ class r0 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h1 f16201a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Message f16202b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ EntityBareJid f16203c;

    public /* synthetic */ r0(h1 h1Var, Message message, EntityBareJid entityBareJid) {
        this.f16201a = h1Var;
        this.f16202b = message;
        this.f16203c = entityBareJid;
    }

    public final Object apply(Object obj) {
        return this.f16201a.j1(this.f16202b, this.f16203c, (XMPPTCPConnection) obj);
    }
}
