package org.jivesoftware.smackx.hints.element;

import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.XmlEnvironment;

public final class NoStoreHint extends MessageProcessingHint {
    public static final String ELEMENT = "no-store";
    public static final NoStoreHint INSTANCE = new NoStoreHint();

    private NoStoreHint() {
    }

    public static NoStoreHint from(Message message) {
        return (NoStoreHint) message.getExtensionElement(ELEMENT, MessageProcessingHint.NAMESPACE);
    }

    public static boolean hasHint(Message message) {
        return from(message) != null;
    }

    public static void set(Message message) {
        message.overrideExtension(INSTANCE);
    }

    public String getElementName() {
        return ELEMENT;
    }

    public MessageProcessingHintType getHintType() {
        return MessageProcessingHintType.no_store;
    }

    public String toXML(XmlEnvironment xmlEnvironment) {
        return "<no-store xmlns='urn:xmpp:hints'/>";
    }
}
