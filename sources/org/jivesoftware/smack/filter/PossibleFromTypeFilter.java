package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.filter.AbstractJidTypeFilter;
import org.jivesoftware.smack.packet.Stanza;
import org.jxmpp.jid.Jid;

public final class PossibleFromTypeFilter extends AbstractPossibleJidTypeFilter {
    public static final PossibleFromTypeFilter DOMAIN_BARE_JID = new PossibleFromTypeFilter(AbstractJidTypeFilter.JidType.domainBare);
    public static final PossibleFromTypeFilter DOMAIN_FULL_JID = new PossibleFromTypeFilter(AbstractJidTypeFilter.JidType.domainFull);
    public static final PossibleFromTypeFilter ENTITY_BARE_JID = new PossibleFromTypeFilter(AbstractJidTypeFilter.JidType.entityBare);
    public static final PossibleFromTypeFilter ENTITY_FULL_JID = new PossibleFromTypeFilter(AbstractJidTypeFilter.JidType.entityFull);
    public static final PossibleFromTypeFilter FROM_ANY_JID = new PossibleFromTypeFilter(AbstractJidTypeFilter.JidType.any);

    private PossibleFromTypeFilter(AbstractJidTypeFilter.JidType jidType) {
        super(jidType);
    }

    /* access modifiers changed from: protected */
    public Jid getJidToInspect(Stanza stanza) {
        return stanza.getFrom();
    }
}
