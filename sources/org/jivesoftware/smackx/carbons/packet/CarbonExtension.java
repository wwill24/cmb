package org.jivesoftware.smackx.carbons.packet;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.forward.packet.Forwarded;

public class CarbonExtension implements ExtensionElement {
    public static final String NAMESPACE = "urn:xmpp:carbons:2";
    private final Direction dir;
    private final Forwarded<Message> fwd;

    public enum Direction {
        received,
        sent
    }

    public static final class Private implements ExtensionElement {
        public static final String ELEMENT = "private";
        public static final Private INSTANCE = new Private();

        private Private() {
        }

        public static void addTo(MessageBuilder messageBuilder) {
            messageBuilder.addExtension(INSTANCE);
        }

        public String getElementName() {
            return ELEMENT;
        }

        public String getNamespace() {
            return "urn:xmpp:carbons:2";
        }

        public String toXML(XmlEnvironment xmlEnvironment) {
            return "<private xmlns='urn:xmpp:carbons:2'/>";
        }

        @Deprecated
        public static void addTo(Message message) {
            message.addExtension(INSTANCE);
        }
    }

    public CarbonExtension(Direction direction, Forwarded<Message> forwarded) {
        this.dir = direction;
        this.fwd = forwarded;
    }

    public static CarbonExtension from(Message message) {
        CarbonExtension carbonExtension = (CarbonExtension) message.getExtensionElement(Direction.received.name(), "urn:xmpp:carbons:2");
        if (carbonExtension == null) {
            return (CarbonExtension) message.getExtensionElement(Direction.sent.name(), "urn:xmpp:carbons:2");
        }
        return carbonExtension;
    }

    @Deprecated
    public static CarbonExtension getFrom(Message message) {
        return from(message);
    }

    public Direction getDirection() {
        return this.dir;
    }

    public String getElementName() {
        return this.dir.name();
    }

    public Forwarded<Message> getForwarded() {
        return this.fwd;
    }

    public String getNamespace() {
        return "urn:xmpp:carbons:2";
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.append(this.fwd.toXML());
        xmlStringBuilder.closeElement((NamedElement) this);
        return xmlStringBuilder;
    }
}
