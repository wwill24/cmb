package org.jivesoftware.smack.roster.packet;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

public final class SubscriptionPreApproval implements ExtensionElement {
    public static final String ELEMENT = "sub";
    public static final SubscriptionPreApproval INSTANCE = new SubscriptionPreApproval();
    public static final String NAMESPACE = "urn:xmpp:features:pre-approval";

    private SubscriptionPreApproval() {
    }

    public String getElementName() {
        return "sub";
    }

    public String getNamespace() {
        return NAMESPACE;
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }
}
