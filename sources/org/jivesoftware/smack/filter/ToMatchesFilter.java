package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.packet.Stanza;
import org.jxmpp.jid.Jid;

public final class ToMatchesFilter extends AbstractFromToMatchesFilter {
    public static final ToMatchesFilter MATCH_NO_TO_SET = create((Jid) null);

    public ToMatchesFilter(Jid jid, boolean z10) {
        super(jid, z10);
    }

    public static ToMatchesFilter create(Jid jid) {
        return new ToMatchesFilter(jid, jid != null ? jid.G1() : false);
    }

    public static ToMatchesFilter createBare(Jid jid) {
        return new ToMatchesFilter(jid, true);
    }

    public static ToMatchesFilter createFull(Jid jid) {
        return new ToMatchesFilter(jid, false);
    }

    /* access modifiers changed from: protected */
    public Jid getAddressToCompare(Stanza stanza) {
        return stanza.getTo();
    }
}
