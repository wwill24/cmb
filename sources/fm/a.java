package fm;

import org.jivesoftware.smack.packet.id.RandomStringStanzaIdSource;
import org.jivesoftware.smack.packet.id.StanzaIdSource;

public final /* synthetic */ class a implements StanzaIdSource {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RandomStringStanzaIdSource.Factory f23434a;

    public /* synthetic */ a(RandomStringStanzaIdSource.Factory factory) {
        this.f23434a = factory;
    }

    public final String getNewStanzaId() {
        return this.f23434a.lambda$constructStanzaIdSource$0();
    }
}
