package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.filter.AbstractJidTypeFilter;
import org.jivesoftware.smack.packet.Stanza;
import org.jxmpp.jid.Jid;

public final class ToTypeFilter extends AbstractExactJidTypeFilter {
    public static final ToTypeFilter DOMAIN_BARE_JID = new ToTypeFilter(AbstractJidTypeFilter.JidType.domainBare);
    public static final ToTypeFilter DOMAIN_FULL_JID = new ToTypeFilter(AbstractJidTypeFilter.JidType.domainFull);
    public static final ToTypeFilter ENTITY_BARE_JID;
    public static final ToTypeFilter ENTITY_FULL_JID;
    public static final StanzaFilter ENTITY_FULL_OR_BARE_JID;
    public static final ToTypeFilter TO_ANY_JID = new ToTypeFilter(AbstractJidTypeFilter.JidType.any);

    static {
        ToTypeFilter toTypeFilter = new ToTypeFilter(AbstractJidTypeFilter.JidType.entityFull);
        ENTITY_FULL_JID = toTypeFilter;
        ToTypeFilter toTypeFilter2 = new ToTypeFilter(AbstractJidTypeFilter.JidType.entityBare);
        ENTITY_BARE_JID = toTypeFilter2;
        ENTITY_FULL_OR_BARE_JID = new OrFilter(toTypeFilter, toTypeFilter2);
    }

    private ToTypeFilter(AbstractJidTypeFilter.JidType jidType) {
        super(jidType);
    }

    /* access modifiers changed from: protected */
    public Jid getJidToInspect(Stanza stanza) {
        return stanza.getTo();
    }
}
