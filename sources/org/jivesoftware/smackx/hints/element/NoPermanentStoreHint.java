package org.jivesoftware.smackx.hints.element;

import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.XmlEnvironment;

public final class NoPermanentStoreHint extends MessageProcessingHint {
    public static final String ELEMENT = "no-permanent-store";
    public static final NoPermanentStoreHint INSTANCE = new NoPermanentStoreHint();

    private NoPermanentStoreHint() {
    }

    public static NoPermanentStoreHint from(Message message) {
        return (NoPermanentStoreHint) message.getExtensionElement(ELEMENT, MessageProcessingHint.NAMESPACE);
    }

    public static boolean hasHint(Message message) {
        return from(message) != null;
    }

    public static void set(Message message) {
        if (!StoreHint.hasHint(message)) {
            message.overrideExtension(INSTANCE);
        }
    }

    public static void setExplicitly(Message message) {
        message.addExtension(INSTANCE);
    }

    public String getElementName() {
        return ELEMENT;
    }

    public MessageProcessingHintType getHintType() {
        return MessageProcessingHintType.no_permanent_store;
    }

    public String toXML(XmlEnvironment xmlEnvironment) {
        return "<no-permanent-store xmlns='urn:xmpp:hints'/>";
    }
}
