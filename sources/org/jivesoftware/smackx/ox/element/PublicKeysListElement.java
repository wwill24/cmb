package org.jivesoftware.smackx.ox.element;

import en.a;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.XmlStringBuilder;

public final class PublicKeysListElement implements ExtensionElement {
    public static final String ELEMENT = "public-keys-list";
    public static final String NAMESPACE = "urn:xmpp:openpgp:0";
    private final Map<a, PubkeyMetadataElement> metadata;

    public static final class Builder {
        private final TreeMap<a, PubkeyMetadataElement> metadata;

        public Builder addMetadata(PubkeyMetadataElement pubkeyMetadataElement) {
            Objects.requireNonNull(pubkeyMetadataElement);
            this.metadata.put(pubkeyMetadataElement.getV4Fingerprint(), pubkeyMetadataElement);
            return this;
        }

        public PublicKeysListElement build() {
            return new PublicKeysListElement(this.metadata);
        }

        private Builder() {
            this.metadata = new TreeMap<>();
        }
    }

    public static class PubkeyMetadataElement implements ExtensionElement {
        public static final String ATTR_DATE = "date";
        public static final String ATTR_V4_FINGERPRINT = "v4-fingerprint";
        public static final String ELEMENT = "pubkey-metadata";
        private final Date date;
        private final a v4_fingerprint;

        public PubkeyMetadataElement(a aVar, Date date2) {
            this.v4_fingerprint = (a) Objects.requireNonNull(aVar);
            this.date = (Date) Objects.requireNonNull(date2);
            if (aVar.length() != 40) {
                throw new IllegalArgumentException("OpenPGP v4 fingerprint must be 40 characters long.");
            }
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof PubkeyMetadataElement)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            PubkeyMetadataElement pubkeyMetadataElement = (PubkeyMetadataElement) obj;
            if (!getV4Fingerprint().equals(pubkeyMetadataElement.getV4Fingerprint()) || !getDate().equals(pubkeyMetadataElement.getDate())) {
                return false;
            }
            return true;
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

        public a getV4Fingerprint() {
            return this.v4_fingerprint;
        }

        public int hashCode() {
            return getV4Fingerprint().hashCode() + (getDate().hashCode() * 3);
        }

        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            return new XmlStringBuilder((ExtensionElement) this).attribute(ATTR_V4_FINGERPRINT, (CharSequence) getV4Fingerprint()).attribute("date", this.date).closeEmptyElement();
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getElementName() {
        return ELEMENT;
    }

    public TreeMap<a, PubkeyMetadataElement> getMetadata() {
        return new TreeMap<>(this.metadata);
    }

    public String getNamespace() {
        return "urn:xmpp:openpgp:0";
    }

    private PublicKeysListElement(TreeMap<a, PubkeyMetadataElement> treeMap) {
        this.metadata = Collections.unmodifiableMap((Map) Objects.requireNonNull(treeMap));
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder rightAngleBracket = new XmlStringBuilder((ExtensionElement) this).rightAngleBracket();
        rightAngleBracket.append((Collection<? extends Element>) this.metadata.values());
        rightAngleBracket.closeElement((NamedElement) this);
        return rightAngleBracket;
    }
}
