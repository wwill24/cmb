package org.jivesoftware.smackx.mam.element;

import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.rsm.packet.RSMSet;

public class MamFinIQ extends IQ {
    public static final String ELEMENT = "fin";
    public static final String NAMESPACE = "urn:xmpp:mam:2";
    private final boolean complete;
    private final String queryId;
    private final RSMSet rsmSet;
    private final boolean stable;

    public MamFinIQ(String str, RSMSet rSMSet, boolean z10, boolean z11) {
        super(ELEMENT, "urn:xmpp:mam:2");
        if (rSMSet != null) {
            this.rsmSet = rSMSet;
            this.complete = z10;
            this.stable = z11;
            this.queryId = str;
            return;
        }
        throw new IllegalArgumentException("rsmSet must not be null");
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.optAttribute("queryid", this.queryId);
        iQChildElementXmlStringBuilder.optBooleanAttribute("complete", this.complete);
        iQChildElementXmlStringBuilder.optBooleanAttribute("stable", this.stable);
        if (this.rsmSet == null) {
            iQChildElementXmlStringBuilder.setEmptyElement();
        } else {
            iQChildElementXmlStringBuilder.rightAngleBracket();
            iQChildElementXmlStringBuilder.append((Element) this.rsmSet);
        }
        return iQChildElementXmlStringBuilder;
    }

    public final String getQueryId() {
        return this.queryId;
    }

    public RSMSet getRSMSet() {
        return this.rsmSet;
    }

    public boolean isComplete() {
        return this.complete;
    }

    public boolean isStable() {
        return this.stable;
    }
}
