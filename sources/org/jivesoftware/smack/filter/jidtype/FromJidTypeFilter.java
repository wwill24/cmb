package org.jivesoftware.smack.filter.jidtype;

import org.jivesoftware.smack.filter.jidtype.AbstractJidTypeFilter;
import org.jivesoftware.smack.packet.Stanza;
import org.jxmpp.jid.Jid;

public class FromJidTypeFilter extends AbstractJidTypeFilter {
    public static final FromJidTypeFilter ENTITY_BARE_JID = new FromJidTypeFilter(AbstractJidTypeFilter.JidType.EntityBareJid);

    public FromJidTypeFilter(AbstractJidTypeFilter.JidType jidType) {
        super(jidType);
    }

    /* access modifiers changed from: protected */
    public Jid getJidToMatchFrom(Stanza stanza) {
        return stanza.getFrom();
    }
}
