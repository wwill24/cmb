package l8;

import io.reactivex.subjects.SingleSubject;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import vj.b;

public final /* synthetic */ class c2 implements b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o2 f16062a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SingleSubject f16063b;

    public /* synthetic */ c2(o2 o2Var, SingleSubject singleSubject) {
        this.f16062a = o2Var;
        this.f16063b = singleSubject;
    }

    public final void accept(Object obj, Object obj2) {
        this.f16062a.J(this.f16063b, (XMPPTCPConnection) obj, (Throwable) obj2);
    }
}
