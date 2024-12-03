package org.jivesoftware.smackx.iot.provisioning.element;

import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jxmpp.jid.BareJid;

public class Friend implements ExtensionElement {
    public static final String ELEMENT = "friend";
    public static final String NAMESPACE = "urn:xmpp:iot:provisioning";
    public static final QName QNAME = new QName("urn:xmpp:iot:provisioning", ELEMENT);
    private final BareJid friend;

    public Friend(BareJid bareJid) {
        this.friend = (BareJid) Objects.requireNonNull(bareJid, "Friend must not be null");
    }

    public static Friend from(Message message) {
        return (Friend) message.getExtension(Friend.class);
    }

    public String getElementName() {
        return ELEMENT;
    }

    public BareJid getFriend() {
        return this.friend;
    }

    public String getNamespace() {
        return "urn:xmpp:iot:provisioning";
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.attribute("jid", (CharSequence) this.friend);
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }
}
