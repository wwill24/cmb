package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.packet.Stanza;

public class OrFilter extends AbstractListFilter {
    public OrFilter() {
    }

    public boolean accept(Stanza stanza) {
        for (StanzaFilter accept : this.filters) {
            if (accept.accept(stanza)) {
                return true;
            }
        }
        return false;
    }

    public OrFilter(StanzaFilter... stanzaFilterArr) {
        super(stanzaFilterArr);
    }
}
