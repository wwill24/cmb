package org.jivesoftware.smack.filter;

import java.util.List;
import org.jivesoftware.smack.packet.Stanza;

public class AndFilter extends AbstractListFilter {
    public AndFilter() {
    }

    public boolean accept(Stanza stanza) {
        for (StanzaFilter accept : this.filters) {
            if (!accept.accept(stanza)) {
                return false;
            }
        }
        return true;
    }

    public AndFilter(StanzaFilter... stanzaFilterArr) {
        super(stanzaFilterArr);
    }

    public AndFilter(List<StanzaFilter> list) {
        super(list);
    }
}
