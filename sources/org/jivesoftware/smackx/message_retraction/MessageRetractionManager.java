package org.jivesoftware.smackx.message_retraction;

import java.util.Map;
import java.util.WeakHashMap;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.message_fastening.element.FasteningElement;
import org.jivesoftware.smackx.message_retraction.element.RetractElement;
import org.jivesoftware.smackx.sid.element.OriginIdElement;

public final class MessageRetractionManager extends Manager {
    /* access modifiers changed from: private */
    public static boolean ENABLED_BY_DEFAULT = false;
    private static final Map<XMPPConnection, MessageRetractionManager> INSTANCES = new WeakHashMap();

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() {
            public void connectionCreated(XMPPConnection xMPPConnection) {
                if (MessageRetractionManager.ENABLED_BY_DEFAULT) {
                    MessageRetractionManager.getInstanceFor(xMPPConnection).announceSupport();
                }
            }
        });
    }

    private MessageRetractionManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
    }

    public static void addRetractionElementToMessage(OriginIdElement originIdElement, MessageBuilder messageBuilder) {
        FasteningElement.builder().setOriginId(originIdElement).addWrappedPayload(new RetractElement()).build().applyTo(messageBuilder);
    }

    public static synchronized MessageRetractionManager getInstanceFor(XMPPConnection xMPPConnection) {
        MessageRetractionManager messageRetractionManager;
        synchronized (MessageRetractionManager.class) {
            Map<XMPPConnection, MessageRetractionManager> map = INSTANCES;
            messageRetractionManager = map.get(xMPPConnection);
            if (messageRetractionManager == null) {
                messageRetractionManager = new MessageRetractionManager(xMPPConnection);
                map.put(xMPPConnection, messageRetractionManager);
            }
        }
        return messageRetractionManager;
    }

    public static synchronized void setEnabledByDefault(boolean z10) {
        synchronized (MessageRetractionManager.class) {
            ENABLED_BY_DEFAULT = z10;
        }
    }

    public void announceSupport() {
        ServiceDiscoveryManager.getInstanceFor(connection()).addFeature(RetractElement.NAMESPACE);
    }

    public void retractMessage(OriginIdElement originIdElement) throws SmackException.NotConnectedException, InterruptedException {
        MessageBuilder buildMessageStanza = connection().getStanzaFactory().buildMessageStanza();
        addRetractionElementToMessage(originIdElement, buildMessageStanza);
        connection().sendStanza(buildMessageStanza.build());
    }

    public void stopAnnouncingSupport() {
        ServiceDiscoveryManager.getInstanceFor(connection()).removeFeature(RetractElement.NAMESPACE);
    }
}
