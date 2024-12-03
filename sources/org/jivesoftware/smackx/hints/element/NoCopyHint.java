package org.jivesoftware.smackx.hints.element;

import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.XmlEnvironment;

public final class NoCopyHint extends MessageProcessingHint {
    public static final String ELEMENT = "no-copy";
    public static final NoCopyHint INSTANCE = new NoCopyHint();

    private NoCopyHint() {
    }

    public static NoCopyHint from(Message message) {
        return (NoCopyHint) message.getExtensionElement(ELEMENT, MessageProcessingHint.NAMESPACE);
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
        return MessageProcessingHintType.no_copy;
    }

    public String toXML(XmlEnvironment xmlEnvironment) {
        return "<no-copy xmlns='urn:xmpp:hints'/>";
    }
}
