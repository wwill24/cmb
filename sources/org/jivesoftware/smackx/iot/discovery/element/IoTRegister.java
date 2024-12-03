package org.jivesoftware.smackx.iot.discovery.element;

import java.util.Collection;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.iot.element.NodeInfo;

public class IoTRegister extends IQ {
    public static final String ELEMENT = "register";
    public static final String NAMESPACE = "urn:xmpp:iot:discovery";
    private final NodeInfo nodeInfo;
    private final boolean selfOwned;
    private final Collection<Tag> tags;

    public IoTRegister(Collection<Tag> collection, NodeInfo nodeInfo2, boolean z10) {
        super("register", "urn:xmpp:iot:discovery");
        if (!collection.isEmpty()) {
            this.tags = collection;
            this.nodeInfo = nodeInfo2;
            this.selfOwned = z10;
            return;
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        this.nodeInfo.appendTo(iQChildElementXmlStringBuilder);
        iQChildElementXmlStringBuilder.optBooleanAttribute("selfOwned", this.selfOwned);
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.append((Collection<? extends Element>) this.tags);
        return iQChildElementXmlStringBuilder;
    }
}
