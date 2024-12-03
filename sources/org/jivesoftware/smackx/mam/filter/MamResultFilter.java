package org.jivesoftware.smackx.mam.filter;

import org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.mam.element.MamElements;
import org.jivesoftware.smackx.mam.element.MamQueryIQ;

public class MamResultFilter extends FlexibleStanzaTypeFilter<Message> {
    private final String queryId;

    public MamResultFilter(MamQueryIQ mamQueryIQ) {
        super(Message.class);
        this.queryId = mamQueryIQ.getQueryId();
    }

    /* access modifiers changed from: protected */
    public boolean acceptSpecific(Message message) {
        MamElements.MamResultExtension from = MamElements.MamResultExtension.from(message);
        if (from == null) {
            return false;
        }
        String queryId2 = from.getQueryId();
        String str = this.queryId;
        if ((str != null || queryId2 != null) && (str == null || !str.equals(queryId2))) {
            return false;
        }
        return true;
    }
}
