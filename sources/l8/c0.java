package l8;

import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import vj.f;

public final /* synthetic */ class c0 implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h1 f16060a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Message f16061b;

    public /* synthetic */ c0(h1 h1Var, Message message) {
        this.f16060a = h1Var;
        this.f16061b = message;
    }

    public final void accept(Object obj) {
        this.f16060a.m1(this.f16061b, (XMPPTCPConnection) obj);
    }
}
