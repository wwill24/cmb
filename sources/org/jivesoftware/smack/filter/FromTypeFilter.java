package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.filter.AbstractJidTypeFilter;
import org.jivesoftware.smack.packet.Stanza;
import org.jxmpp.jid.Jid;

public final class FromTypeFilter extends AbstractExactJidTypeFilter {
    public static final FromTypeFilter DOMAIN_BARE_JID = new FromTypeFilter(AbstractJidTypeFilter.JidType.domainBare);
    public static final FromTypeFilter DOMAIN_FULL_JID = new FromTypeFilter(AbstractJidTypeFilter.JidType.domainFull);
    public static final FromTypeFilter ENTITY_BARE_JID = new FromTypeFilter(AbstractJidTypeFilter.JidType.entityBare);
    public static final FromTypeFilter ENTITY_FULL_JID = new FromTypeFilter(AbstractJidTypeFilter.JidType.entityFull);
    public static final FromTypeFilter FROM_ANY_JID = new FromTypeFilter(AbstractJidTypeFilter.JidType.any);

    private FromTypeFilter(AbstractJidTypeFilter.JidType jidType) {
        super(jidType);
    }

    /* access modifiers changed from: protected */
    public Jid getJidToInspect(Stanza stanza) {
        return stanza.getFrom();
    }
}
