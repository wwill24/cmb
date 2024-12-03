package org.jivesoftware.smackx.blocking.element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.jid.Jid;

public class BlockListIQ extends IQ {
    public static final String ELEMENT = "blocklist";
    public static final String NAMESPACE = "urn:xmpp:blocking";
    private final List<Jid> jids;

    public BlockListIQ(List<Jid> list) {
        super(ELEMENT, "urn:xmpp:blocking");
        if (list == null) {
            this.jids = Collections.emptyList();
        } else {
            this.jids = Collections.unmodifiableList(list);
        }
    }

    public List<Jid> getBlockedJids() {
        return this.jids;
    }

    public List<Jid> getBlockedJidsCopy() {
        return new ArrayList(getBlockedJids());
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        if (this.jids.isEmpty()) {
            iQChildElementXmlStringBuilder.setEmptyElement();
        } else {
            iQChildElementXmlStringBuilder.rightAngleBracket();
            for (Jid attribute : this.jids) {
                iQChildElementXmlStringBuilder.halfOpenElement("item");
                iQChildElementXmlStringBuilder.attribute("jid", (CharSequence) attribute);
                iQChildElementXmlStringBuilder.closeEmptyElement();
            }
        }
        return iQChildElementXmlStringBuilder;
    }

    public BlockListIQ() {
        this((List<Jid>) null);
    }
}
