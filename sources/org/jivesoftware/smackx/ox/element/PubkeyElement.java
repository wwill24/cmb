package org.jivesoftware.smackx.ox.element;

import java.util.Date;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smack.util.stringencoder.Base64;

public class PubkeyElement implements ExtensionElement {
    public static final String ATTR_DATE = "date";
    public static final String ELEMENT = "pubkey";
    public static final String NAMESPACE = "urn:xmpp:openpgp:0";
    private final PubkeyDataElement dataElement;
    private final Date date;

    public static class PubkeyDataElement implements ExtensionElement {
        public static final String ELEMENT = "data";
        private final String b64Data;
        private transient byte[] pubKeyBytesCache;

        public PubkeyDataElement(String str) {
            this.b64Data = (String) Objects.requireNonNull(str);
        }

        public String getB64Data() {
            return this.b64Data;
        }

        public String getElementName() {
            return "data";
        }

        public String getNamespace() {
            return "urn:xmpp:openpgp:0";
        }

        public byte[] getPubKeyBytes() {
            if (this.pubKeyBytesCache == null) {
                this.pubKeyBytesCache = Base64.decode(this.b64Data);
            }
            return (byte[]) this.pubKeyBytesCache.clone();
        }

        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            return new XmlStringBuilder(this, xmlEnvironment).rightAngleBracket().append((CharSequence) this.b64Data).closeElement((NamedElement) this);
        }
    }

    public PubkeyElement(PubkeyDataElement pubkeyDataElement, Date date2) {
        this.dataElement = (PubkeyDataElement) Objects.requireNonNull(pubkeyDataElement);
        this.date = date2;
    }

    public PubkeyDataElement getDataElement() {
        return this.dataElement;
    }

    public Date getDate() {
        return this.date;
    }

    public String getElementName() {
        return ELEMENT;
    }

    public String getNamespace() {
        return "urn:xmpp:openpgp:0";
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        return new XmlStringBuilder((ExtensionElement) this).optAttribute("date", this.date).rightAngleBracket().append((Element) getDataElement()).closeElement((NamedElement) this);
    }
}
