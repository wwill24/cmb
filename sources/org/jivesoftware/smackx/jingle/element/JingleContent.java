package org.jivesoftware.smackx.jingle.element;

import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.FullyQualifiedElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;

public final class JingleContent implements FullyQualifiedElement {
    public static final String CREATOR_ATTRIBUTE_NAME = "creator";
    public static final String DISPOSITION_ATTRIBUTE_NAME = "disposition";
    public static final String ELEMENT = "content";
    public static final String NAMESPACE = "urn:xmpp:jingle:1";
    public static final String NAME_ATTRIBUTE_NAME = "name";
    public static final String SENDERS_ATTRIBUTE_NAME = "senders";
    private final Creator creator;
    private final JingleContentDescription description;
    private final String disposition;
    private final String name;
    private final Senders senders;
    private final JingleContentTransport transport;

    public static final class Builder {
        private Creator creator;
        private JingleContentDescription description;
        private String disposition;
        private String name;
        private Senders senders;
        private JingleContentTransport transport;

        public JingleContent build() {
            return new JingleContent(this.creator, this.disposition, this.name, this.senders, this.description, this.transport);
        }

        public Builder setCreator(Creator creator2) {
            this.creator = creator2;
            return this;
        }

        public Builder setDescription(JingleContentDescription jingleContentDescription) {
            if (this.description == null) {
                this.description = jingleContentDescription;
                return this;
            }
            throw new IllegalStateException("Jingle content description already set");
        }

        public Builder setDisposition(String str) {
            this.disposition = str;
            return this;
        }

        public Builder setName(String str) {
            this.name = str;
            return this;
        }

        public Builder setSenders(Senders senders2) {
            this.senders = senders2;
            return this;
        }

        public Builder setTransport(JingleContentTransport jingleContentTransport) {
            this.transport = jingleContentTransport;
            return this;
        }

        private Builder() {
        }
    }

    public enum Creator {
        initiator,
        responder
    }

    public enum Senders {
        both,
        initiator,
        none,
        responder
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public Creator getCreator() {
        return this.creator;
    }

    public JingleContentDescription getDescription() {
        return this.description;
    }

    public String getDisposition() {
        return this.disposition;
    }

    public String getElementName() {
        return "content";
    }

    @Deprecated
    public JingleContentTransport getJingleTransport() {
        return getTransport();
    }

    public String getName() {
        return this.name;
    }

    public String getNamespace() {
        return "urn:xmpp:jingle:1";
    }

    public Senders getSenders() {
        return this.senders;
    }

    public JingleContentTransport getTransport() {
        return this.transport;
    }

    private JingleContent(Creator creator2, String str, String str2, Senders senders2, JingleContentDescription jingleContentDescription, JingleContentTransport jingleContentTransport) {
        this.creator = (Creator) Objects.requireNonNull(creator2, "Jingle content creator must not be null");
        this.disposition = str;
        this.name = (String) StringUtils.requireNotNullNorEmpty(str2, "Jingle content name must not be null nor empty");
        this.senders = senders2;
        this.description = jingleContentDescription;
        this.transport = jingleContentTransport;
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        xmlStringBuilder.attribute("creator", (Enum<?>) this.creator);
        xmlStringBuilder.optAttribute(DISPOSITION_ATTRIBUTE_NAME, this.disposition);
        xmlStringBuilder.attribute("name", this.name);
        xmlStringBuilder.optAttribute(SENDERS_ATTRIBUTE_NAME, (Enum<?>) this.senders);
        if (this.description == null && this.transport == null) {
            return xmlStringBuilder.closeEmptyElement();
        }
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.optAppend((Element) this.description);
        xmlStringBuilder.optElement(this.transport);
        xmlStringBuilder.closeElement((NamedElement) this);
        return xmlStringBuilder;
    }
}
