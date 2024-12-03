package l8;

import org.jivesoftware.smack.chat2.ChatManager;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jxmpp.jid.EntityBareJid;
import vj.f;

public final /* synthetic */ class j2 implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EntityBareJid f16133a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Message f16134b;

    public /* synthetic */ j2(EntityBareJid entityBareJid, Message message) {
        this.f16133a = entityBareJid;
        this.f16134b = message;
    }

    public final void accept(Object obj) {
        ChatManager.getInstanceFor((XMPPTCPConnection) obj).chatWith(this.f16133a).send(this.f16134b);
    }
}
