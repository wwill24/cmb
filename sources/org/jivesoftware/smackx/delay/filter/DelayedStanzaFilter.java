package org.jivesoftware.smackx.delay.filter;

import org.jivesoftware.smack.filter.NotFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.delay.DelayInformationManager;

public final class DelayedStanzaFilter implements StanzaFilter {
    public static final StanzaFilter INSTANCE;
    public static final StanzaFilter NOT_DELAYED_STANZA;

    static {
        DelayedStanzaFilter delayedStanzaFilter = new DelayedStanzaFilter();
        INSTANCE = delayedStanzaFilter;
        NOT_DELAYED_STANZA = new NotFilter(delayedStanzaFilter);
    }

    private DelayedStanzaFilter() {
    }

    public boolean accept(Stanza stanza) {
        return DelayInformationManager.isDelayedStanza(stanza);
    }
}
