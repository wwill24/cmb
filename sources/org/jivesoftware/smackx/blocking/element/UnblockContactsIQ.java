package org.jivesoftware.smackx.blocking.element;

import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.packet.IQ;
import org.jxmpp.jid.Jid;

public class UnblockContactsIQ extends IQ {
    public static final String ELEMENT = "unblock";
    public static final String NAMESPACE = "urn:xmpp:blocking";
    private final List<Jid> jids;

    public UnblockContactsIQ(List<Jid> list) {
        super(ELEMENT, "urn:xmpp:blocking");
        setType(IQ.Type.set);
        if (list != null) {
            this.jids = Collections.unmodifiableList(list);
        } else {
            this.jids = null;
        }
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        if (this.jids == null) {
            iQChildElementXmlStringBuilder.setEmptyElement();
            return iQChildElementXmlStringBuilder;
        }
        iQChildElementXmlStringBuilder.rightAngleBracket();
        for (Jid attribute : this.jids) {
            iQChildElementXmlStringBuilder.halfOpenElement("item");
            iQChildElementXmlStringBuilder.attribute("jid", (CharSequence) attribute);
            iQChildElementXmlStringBuilder.closeEmptyElement();
        }
        return iQChildElementXmlStringBuilder;
    }

    public List<Jid> getJids() {
        return this.jids;
    }

    public UnblockContactsIQ() {
        this((List<Jid>) null);
    }
}
