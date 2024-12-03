package org.jivesoftware.smackx.caps;

import org.jivesoftware.smack.filter.PresenceTypeFilter;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.util.Predicate;

public final /* synthetic */ class b implements Predicate {
    public final boolean test(Object obj) {
        return PresenceTypeFilter.AVAILABLE.accept((Presence) obj);
    }
}
