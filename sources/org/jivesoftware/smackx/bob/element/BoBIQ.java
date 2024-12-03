package org.jivesoftware.smackx.bob.element;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.bob.BoBData;
import org.jivesoftware.smackx.bob.ContentId;

public class BoBIQ extends IQ {
    public static final String ELEMENT = "data";
    public static final String NAMESPACE = "urn:xmpp:bob";
    private final BoBData bobData;
    private final ContentId cid;

    public BoBIQ(ContentId contentId, BoBData boBData) {
        super("data", "urn:xmpp:bob");
        this.cid = contentId;
        this.bobData = boBData;
    }

    public BoBData getBoBData() {
        return this.bobData;
    }

    @Deprecated
    public ContentId getBoBHash() {
        return this.cid;
    }

    public ContentId getContentId() {
        return this.cid;
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.attribute("cid", this.cid.getCid());
        BoBData boBData = this.bobData;
        if (boBData != null) {
            iQChildElementXmlStringBuilder.optIntAttribute("max_age", boBData.getMaxAge());
            iQChildElementXmlStringBuilder.attribute("type", this.bobData.getType());
            iQChildElementXmlStringBuilder.rightAngleBracket();
            iQChildElementXmlStringBuilder.escape(this.bobData.getContentBase64Encoded());
        } else {
            iQChildElementXmlStringBuilder.setEmptyElement();
        }
        return iQChildElementXmlStringBuilder;
    }

    public BoBIQ(ContentId contentId) {
        this(contentId, (BoBData) null);
    }
}
