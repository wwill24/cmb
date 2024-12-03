package l8;

import io.reactivex.subjects.SingleSubject;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import vj.b;

public final /* synthetic */ class n2 implements b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o2 f16169a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SingleSubject f16170b;

    public /* synthetic */ n2(o2 o2Var, SingleSubject singleSubject) {
        this.f16169a = o2Var;
        this.f16170b = singleSubject;
    }

    public final void accept(Object obj, Object obj2) {
        this.f16169a.H(this.f16170b, (XMPPTCPConnection) obj, (Throwable) obj2);
    }
}
