package l8;

import io.reactivex.subjects.SingleSubject;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import vj.f;

public final /* synthetic */ class a2 implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o2 f16053a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f16054b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SingleSubject f16055c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ SingleSubject f16056d;

    public /* synthetic */ a2(o2 o2Var, long j10, SingleSubject singleSubject, SingleSubject singleSubject2) {
        this.f16053a = o2Var;
        this.f16054b = j10;
        this.f16055c = singleSubject;
        this.f16056d = singleSubject2;
    }

    public final void accept(Object obj) {
        this.f16053a.I(this.f16054b, this.f16055c, this.f16056d, (XMPPTCPConnection) obj);
    }
}
