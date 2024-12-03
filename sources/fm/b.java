package fm;

import org.jivesoftware.smack.packet.id.RandomStringStanzaIdSource;
import org.jivesoftware.smack.packet.id.StanzaIdSource;

public final /* synthetic */ class b implements StanzaIdSource {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RandomStringStanzaIdSource.Factory f23435a;

    public /* synthetic */ b(RandomStringStanzaIdSource.Factory factory) {
        this.f23435a = factory;
    }

    public final String getNewStanzaId() {
        return this.f23435a.lambda$constructStanzaIdSource$1();
    }
}
