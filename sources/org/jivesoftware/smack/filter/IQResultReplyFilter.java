package org.jivesoftware.smack.filter;

import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Stanza;

public class IQResultReplyFilter extends IQReplyFilter {
    public IQResultReplyFilter(IQ iq, XMPPConnection xMPPConnection) {
        super(iq, xMPPConnection);
    }

    public boolean accept(Stanza stanza) {
        if (!super.accept(stanza)) {
            return false;
        }
        return IQTypeFilter.RESULT.accept(stanza);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append(" (" + super.toString() + PropertyUtils.MAPPED_DELIM2);
        return sb2.toString();
    }
}
