package org.jivesoftware.smackx.iot.discovery.element;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.IQ;

public class IoTMine extends IQ {
    public static final String ELEMENT = "mine";
    public static final String NAMESPACE = "urn:xmpp:iot:discovery";
    private final List<Tag> metaTags;
    private final boolean publicThing;

    public IoTMine(Collection<Tag> collection, boolean z10) {
        this((List<Tag>) new ArrayList(collection), z10);
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.optBooleanAttributeDefaultTrue("public", this.publicThing);
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.append((Collection<? extends Element>) this.metaTags);
        return iQChildElementXmlStringBuilder;
    }

    public IoTMine(List<Tag> list, boolean z10) {
        super(ELEMENT, "urn:xmpp:iot:discovery");
        this.metaTags = list;
        this.publicThing = z10;
    }
}
