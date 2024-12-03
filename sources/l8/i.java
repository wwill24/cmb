package l8;

import l8.h;
import org.jivesoftware.smack.packet.Message;
import vj.f;

public final /* synthetic */ class i implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h.d f16120a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Message f16121b;

    public /* synthetic */ i(h.d dVar, Message message) {
        this.f16120a = dVar;
        this.f16121b = message;
    }

    public final void accept(Object obj) {
        h1.W0(this.f16120a, this.f16121b, (Integer) obj);
    }
}
