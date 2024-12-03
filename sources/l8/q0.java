package l8;

import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import vj.f;

public final /* synthetic */ class q0 implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h1 f16195a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f16196b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Long f16197c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Message f16198d;

    public /* synthetic */ q0(h1 h1Var, String str, Long l10, Message message) {
        this.f16195a = h1Var;
        this.f16196b = str;
        this.f16197c = l10;
        this.f16198d = message;
    }

    public final void accept(Object obj) {
        this.f16195a.i1(this.f16196b, this.f16197c, this.f16198d, (XMPPTCPConnection) obj);
    }
}
