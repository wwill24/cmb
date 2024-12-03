package org.jivesoftware.smackx.message_correct.element;

import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;

public class MessageCorrectExtension implements ExtensionElement {
    public static final String ELEMENT = "replace";
    public static final String ID_TAG = "id";
    public static final String NAMESPACE = "urn:xmpp:message-correct:0";
    public static final QName QNAME = new QName(NAMESPACE, ELEMENT);
    private final String idInitialMessage;

    public MessageCorrectExtension(String str) {
        this.idInitialMessage = (String) StringUtils.requireNotNullNorEmpty(str, "idInitialMessage must not be null");
    }

    public static MessageCorrectExtension from(Message message) {
        return (MessageCorrectExtension) message.getExtension(MessageCorrectExtension.class);
    }

    public String getElementName() {
        return ELEMENT;
    }

    public String getIdInitialMessage() {
        return this.idInitialMessage;
    }

    public String getNamespace() {
        return NAMESPACE;
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.attribute("id", getIdInitialMessage());
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }
}
