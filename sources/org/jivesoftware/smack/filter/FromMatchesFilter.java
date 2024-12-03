package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.packet.Stanza;
import org.jxmpp.jid.Jid;

public final class FromMatchesFilter extends AbstractFromToMatchesFilter {
    public static final FromMatchesFilter MATCH_NO_FROM_SET = create((Jid) null);

    public FromMatchesFilter(Jid jid, boolean z10) {
        super(jid, z10);
    }

    public static FromMatchesFilter create(Jid jid) {
        return new FromMatchesFilter(jid, jid != null ? jid.G1() : false);
    }

    public static FromMatchesFilter createBare(Jid jid) {
        return new FromMatchesFilter(jid, true);
    }

    public static FromMatchesFilter createFull(Jid jid) {
        return new FromMatchesFilter(jid, false);
    }

    /* access modifiers changed from: protected */
    public Jid getAddressToCompare(Stanza stanza) {
        return stanza.getFrom();
    }
}
