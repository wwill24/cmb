package org.jivesoftware.smackx.sid;

import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.util.Predicate;

public final /* synthetic */ class b implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StanzaFilter f24229a;

    public /* synthetic */ b(StanzaFilter stanzaFilter) {
        this.f24229a = stanzaFilter;
    }

    public final boolean test(Object obj) {
        return this.f24229a.accept((Message) obj);
    }
}
