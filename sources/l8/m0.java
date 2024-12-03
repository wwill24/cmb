package l8;

import com.coffeemeetsbagel.models.RosterElement;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import vj.j;

public final /* synthetic */ class m0 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h1 f16157a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RosterElement f16158b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f16159c;

    public /* synthetic */ m0(h1 h1Var, RosterElement rosterElement, long j10) {
        this.f16157a = h1Var;
        this.f16158b = rosterElement;
        this.f16159c = j10;
    }

    public final Object apply(Object obj) {
        return this.f16157a.K0(this.f16158b, this.f16159c, (XMPPTCPConnection) obj);
    }
}
