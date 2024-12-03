package l8;

import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import vj.f;

public final /* synthetic */ class y1 implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o2 f16237a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ XMPPTCPConnection f16238b;

    public /* synthetic */ y1(o2 o2Var, XMPPTCPConnection xMPPTCPConnection) {
        this.f16237a = o2Var;
        this.f16238b = xMPPTCPConnection;
    }

    public final void accept(Object obj) {
        this.f16237a.D(this.f16238b, (String) obj);
    }
}
