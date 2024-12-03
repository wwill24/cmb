package org.jivesoftware.smackx.fallback_indication;

import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.jivesoftware.smack.AsyncButOrdered;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.StanzaExtensionFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.StanzaTypeFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.fallback_indication.element.FallbackIndicationElement;
import org.jxmpp.jid.BareJid;
import org.jxmpp.jid.EntityBareJid;

public final class FallbackIndicationManager extends Manager {
    private static final Map<XMPPConnection, FallbackIndicationManager> INSTANCES = new WeakHashMap();
    private final AsyncButOrdered<BareJid> asyncButOrdered = new AsyncButOrdered<>();
    private final StanzaFilter fallbackIndicationElementFilter;
    private final Set<FallbackIndicationListener> listeners = new CopyOnWriteArraySet();

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() {
            public void connectionCreated(XMPPConnection xMPPConnection) {
                FallbackIndicationManager.getInstanceFor(xMPPConnection);
            }
        });
    }

    private FallbackIndicationManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        AndFilter andFilter = new AndFilter(StanzaTypeFilter.MESSAGE, new StanzaExtensionFilter(FallbackIndicationElement.ELEMENT, FallbackIndicationElement.NAMESPACE));
        this.fallbackIndicationElementFilter = andFilter;
        xMPPConnection.addAsyncStanzaListener(new a(this), andFilter);
        ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature(FallbackIndicationElement.NAMESPACE);
    }

    public static MessageBuilder addFallbackIndication(MessageBuilder messageBuilder) {
        return (MessageBuilder) messageBuilder.addExtension(new FallbackIndicationElement());
    }

    public static MessageBuilder addFallbackIndicationWithBody(MessageBuilder messageBuilder, String str) {
        return addFallbackIndication(messageBuilder).setBody(str);
    }

    /* access modifiers changed from: private */
    public void fallbackIndicationElementListener(Stanza stanza) {
        Message message = (Message) stanza;
        this.asyncButOrdered.performAsyncButOrdered(message.getFrom().i1(), new b(this, message, FallbackIndicationElement.fromMessage(message), message.getBody()));
    }

    public static synchronized FallbackIndicationManager getInstanceFor(XMPPConnection xMPPConnection) {
        FallbackIndicationManager fallbackIndicationManager;
        synchronized (FallbackIndicationManager.class) {
            Map<XMPPConnection, FallbackIndicationManager> map = INSTANCES;
            fallbackIndicationManager = map.get(xMPPConnection);
            if (fallbackIndicationManager == null) {
                fallbackIndicationManager = new FallbackIndicationManager(xMPPConnection);
                map.put(xMPPConnection, fallbackIndicationManager);
            }
        }
        return fallbackIndicationManager;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$fallbackIndicationElementListener$0(Message message, FallbackIndicationElement fallbackIndicationElement, String str) {
        for (FallbackIndicationListener onFallbackIndicationReceived : this.listeners) {
            onFallbackIndicationReceived.onFallbackIndicationReceived(message, fallbackIndicationElement, str);
        }
    }

    public synchronized void addFallbackIndicationListener(FallbackIndicationListener fallbackIndicationListener) {
        this.listeners.add(fallbackIndicationListener);
    }

    public synchronized void removeFallbackIndicationListener(FallbackIndicationListener fallbackIndicationListener) {
        this.listeners.remove(fallbackIndicationListener);
    }

    public boolean serverSupportsFallbackIndications() throws XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException, SmackException.NoResponseException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).serverSupportsFeature(FallbackIndicationElement.NAMESPACE);
    }

    public boolean userSupportsFallbackIndications(EntityBareJid entityBareJid) throws XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException, SmackException.NoResponseException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).supportsFeature(entityBareJid, FallbackIndicationElement.NAMESPACE);
    }
}
