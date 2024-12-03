package n8;

import org.jivesoftware.smackx.chatstates.ChatState;
import vj.f;

public final /* synthetic */ class b implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f16646a;

    public /* synthetic */ b(String str) {
        this.f16646a = str;
    }

    public final void accept(Object obj) {
        s.E(this.f16646a, (ChatState) obj);
    }
}
