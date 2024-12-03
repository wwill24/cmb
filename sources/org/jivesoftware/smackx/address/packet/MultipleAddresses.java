package org.jivesoftware.smackx.address.packet;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jxmpp.jid.Jid;

public class MultipleAddresses implements ExtensionElement {
    public static final String ELEMENT = "addresses";
    public static final String NAMESPACE = "http://jabber.org/protocol/address";
    public static final QName QNAME = new QName(NAMESPACE, ELEMENT);
    private final List<Address> addresses = new ArrayList();

    public static final class Address implements ExtensionElement {
        public static final String ELEMENT = "address";
        private boolean delivered;
        private String description;
        private Jid jid;
        private String node;
        private final Type type;
        private String uri;

        /* access modifiers changed from: private */
        public void setDelivered(boolean z10) {
            this.delivered = z10;
        }

        /* access modifiers changed from: private */
        public void setDescription(String str) {
            this.description = str;
        }

        /* access modifiers changed from: private */
        public void setJid(Jid jid2) {
            this.jid = jid2;
        }

        /* access modifiers changed from: private */
        public void setNode(String str) {
            this.node = str;
        }

        /* access modifiers changed from: private */
        public void setUri(String str) {
            this.uri = str;
        }

        public String getDescription() {
            return this.description;
        }

        public String getElementName() {
            return "address";
        }

        public Jid getJid() {
            return this.jid;
        }

        public String getNamespace() {
            return MultipleAddresses.NAMESPACE;
        }

        public String getNode() {
            return this.node;
        }

        public Type getType() {
            return this.type;
        }

        public String getUri() {
            return this.uri;
        }

        public boolean isDelivered() {
            return this.delivered;
        }

        private Address(Type type2) {
            this.type = type2;
        }

        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.attribute("type", (Enum<?>) this.type);
            xmlStringBuilder.optAttribute("jid", (CharSequence) this.jid);
            xmlStringBuilder.optAttribute(NodeElement.ELEMENT, this.node);
            xmlStringBuilder.optAttribute("desc", this.description);
            String str = this.description;
            if (str != null && str.trim().length() > 0) {
                xmlStringBuilder.append((CharSequence) " desc=\"");
                xmlStringBuilder.append((CharSequence) this.description).append('\"');
            }
            xmlStringBuilder.optBooleanAttribute("delivered", this.delivered);
            xmlStringBuilder.optAttribute("uri", this.uri);
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }
    }

    public enum Type {
        bcc,
        cc,
        noreply,
        replyroom,
        replyto,
        to,
        ofrom
    }

    public void addAddress(Type type, Jid jid, String str, String str2, boolean z10, String str3) {
        Address address = new Address(type);
        address.setJid(jid);
        address.setNode(str);
        address.setDescription(str2);
        address.setDelivered(z10);
        address.setUri(str3);
        this.addresses.add(address);
    }

    public List<Address> getAddressesOfType(Type type) {
        ArrayList arrayList = new ArrayList(this.addresses.size());
        for (Address next : this.addresses) {
            if (next.getType().equals(type)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public String getElementName() {
        return ELEMENT;
    }

    public String getNamespace() {
        return NAMESPACE;
    }

    public void setNoReply() {
        this.addresses.add(new Address(Type.noreply));
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.rightAngleBracket();
        for (Address xml : this.addresses) {
            xmlStringBuilder.append(xml.toXML());
        }
        xmlStringBuilder.closeElement((NamedElement) this);
        return xmlStringBuilder;
    }
}
