package org.jivesoftware.smackx.receipts;

import java.io.IOException;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;

public class DeliveryReceiptRequest implements ExtensionElement {
    public static final String ELEMENT = "request";
    public static final String NAMESPACE = "urn:xmpp:receipts";
    public static final QName QNAME = new QName("urn:xmpp:receipts", "request");

    public static class Provider extends ExtensionElementProvider<DeliveryReceiptRequest> {
        public DeliveryReceiptRequest parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
            return new DeliveryReceiptRequest();
        }
    }

    public static String addTo(Message message) {
        message.throwIfNoStanzaId();
        message.addExtension(new DeliveryReceiptRequest());
        return message.getStanzaId();
    }

    public static DeliveryReceiptRequest from(Stanza stanza) {
        return (DeliveryReceiptRequest) stanza.getExtension(DeliveryReceiptRequest.class);
    }

    @Deprecated
    public static DeliveryReceiptRequest getFrom(Stanza stanza) {
        return from(stanza);
    }

    public String getElementName() {
        return "request";
    }

    public String getNamespace() {
        return "urn:xmpp:receipts";
    }

    public String toXML(XmlEnvironment xmlEnvironment) {
        return "<request xmlns='urn:xmpp:receipts'/>";
    }

    public static void addTo(MessageBuilder messageBuilder) {
        messageBuilder.throwIfNoStanzaId();
        messageBuilder.overrideExtension(new DeliveryReceiptRequest());
    }
}
