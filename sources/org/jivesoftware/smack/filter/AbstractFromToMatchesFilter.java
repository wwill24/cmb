package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.packet.Stanza;
import org.jxmpp.jid.Jid;

public abstract class AbstractFromToMatchesFilter implements StanzaFilter {
    private final Jid address;
    private final boolean ignoreResourcepart;

    protected AbstractFromToMatchesFilter(Jid jid, boolean z10) {
        if (jid == null || !z10) {
            this.address = jid;
        } else {
            this.address = jid.i1();
        }
        this.ignoreResourcepart = z10;
    }

    public final boolean accept(Stanza stanza) {
        Jid addressToCompare = getAddressToCompare(stanza);
        if (addressToCompare != null) {
            if (this.ignoreResourcepart) {
                addressToCompare = addressToCompare.i1();
            }
            return addressToCompare.Y(this.address);
        } else if (this.address == null) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public abstract Jid getAddressToCompare(Stanza stanza);

    public final String toString() {
        String str;
        if (this.ignoreResourcepart) {
            str = "ignoreResourcepart";
        } else {
            str = "full";
        }
        return getClass().getSimpleName() + " (" + str + "): " + this.address;
    }
}
