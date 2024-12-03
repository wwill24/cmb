package l8;

import com.uber.autodispose.p;
import d7.l;
import fa.a;
import java.util.Objects;
import lc.t;
import n8.s;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.chatstates.packet.ChatStateExtension;
import qj.q;

public class r1 implements StanzaListener {

    /* renamed from: a  reason: collision with root package name */
    private final s f16204a;

    /* renamed from: b  reason: collision with root package name */
    private final l f16205b;

    r1(s sVar, l lVar) {
        this.f16204a = sVar;
        this.f16205b = lVar;
    }

    private void c(Message message) {
        this.f16204a.s(t.j(message.getFrom())).accept(((ChatStateExtension) message.getExtension("http://jabber.org/protocol/chatstates")).getChatState());
    }

    private void d(Message message) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\ttype: ");
        sb2.append(message.getType());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("\tbody: ");
        sb3.append(message.getBody());
        StringBuilder sb4 = new StringBuilder();
        sb4.append("\tfrom: ");
        sb4.append(message.getFrom());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\txml: ");
        sb5.append(message.toXML(""));
        if (message.getType().equals(Message.Type.error)) {
            a.i(new Throwable("Error message from mongoose " + message.getBody()));
            return;
        }
        if (t.r(message)) {
            g(message);
        }
        if (message.hasExtension("http://jabber.org/protocol/chatstates")) {
            c(message);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void f(Message message, Boolean bool) throws Exception {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Persisted valid message: ");
        sb2.append(message);
        sb2.append(" with result: ");
        sb2.append(bool);
    }

    private void g(Message message) {
        q B = q.V(x1.c(message)).B(new o1());
        s sVar = this.f16204a;
        Objects.requireNonNull(sVar);
        ((p) B.W(new p1(sVar)).m0(dk.a.c()).g(com.uber.autodispose.a.a(this.f16205b))).c(new q1(message));
    }

    public void processStanza(Stanza stanza) {
        if (stanza instanceof Message) {
            d((Message) stanza);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Non message stanza ");
        sb2.append(stanza.toXML(""));
    }
}
