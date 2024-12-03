package org.jivesoftware.smackx.receipts;

import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.EmbeddedExtensionProvider;
import org.jivesoftware.smack.util.XmlStringBuilder;

public class DeliveryReceipt implements ExtensionElement {
    public static final String ELEMENT = "received";
    public static final String NAMESPACE = "urn:xmpp:receipts";
    public static final QName QNAME = new QName("urn:xmpp:receipts", ELEMENT);

    /* renamed from: id  reason: collision with root package name */
    private final String f24227id;

    public static class Provider extends EmbeddedExtensionProvider<DeliveryReceipt> {
        /* access modifiers changed from: protected */
        public DeliveryReceipt createReturnExtension(String str, String str2, Map<String, String> map, List<? extends ExtensionElement> list) {
            return new DeliveryReceipt(map.get("id"));
        }
    }

    public DeliveryReceipt(String str) {
        this.f24227id = str;
    }

    public static DeliveryReceipt from(Message message) {
        return (DeliveryReceipt) message.getExtension(DeliveryReceipt.class);
    }

    @Deprecated
    public static DeliveryReceipt getFrom(Message message) {
        return from(message);
    }

    public String getElementName() {
        return ELEMENT;
    }

    public String getId() {
        return this.f24227id;
    }

    public String getNamespace() {
        return "urn:xmpp:receipts";
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.optAttribute("id", this.f24227id);
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }
}
