package org.jivesoftware.smackx.iot.provisioning.element;

import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jxmpp.jid.BareJid;

public class Unfriend implements ExtensionElement {
    public static final String ELEMENT = "UNFRIEND";
    public static final String NAMESPACE = "urn:xmpp:iot:provisioning";
    public static final QName QNAME = new QName("urn:xmpp:iot:provisioning", ELEMENT);
    private final BareJid jid;

    public Unfriend(BareJid bareJid) {
        this.jid = bareJid;
    }

    public static Unfriend from(Message message) {
        return (Unfriend) message.getExtension(Unfriend.class);
    }

    public String getElementName() {
        return ELEMENT;
    }

    public BareJid getJid() {
        return this.jid;
    }

    public String getNamespace() {
        return "urn:xmpp:iot:provisioning";
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.attribute("jid", (CharSequence) this.jid);
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }
}
