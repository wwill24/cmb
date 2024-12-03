package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.packet.Stanza;
import org.jxmpp.jid.Jid;

public abstract class AbstractJidTypeFilter implements StanzaFilter {
    protected final JidType jidType;

    protected enum JidType {
        entityFull,
        entityBare,
        domainFull,
        domainBare,
        any
    }

    protected AbstractJidTypeFilter(JidType jidType2) {
        this.jidType = jidType2;
    }

    /* access modifiers changed from: protected */
    public abstract Jid getJidToInspect(Stanza stanza);
}
