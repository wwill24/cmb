package org.jivesoftware.smackx.httpfileupload.element;

import java.net.URL;
import java.util.Map;
import org.jivesoftware.smack.packet.IQ;

public class Slot_V0_2 extends Slot {
    public static final String NAMESPACE = "urn:xmpp:http:upload";

    public Slot_V0_2(URL url, URL url2) {
        super(url, url2, (Map<String, String>) null, "urn:xmpp:http:upload");
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.element("put", this.putUrl.toString());
        iQChildElementXmlStringBuilder.element("get", this.getUrl.toString());
        return iQChildElementXmlStringBuilder;
    }
}
