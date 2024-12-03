package org.jivesoftware.smackx.sid;

import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.MessageTypeFilter;
import org.jivesoftware.smack.filter.NotFilter;
import org.jivesoftware.smack.filter.StanzaExtensionFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.ToTypeFilter;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.muc.MultiUserChat;
import org.jivesoftware.smackx.muc.MultiUserChatManager;
import org.jivesoftware.smackx.sid.element.OriginIdElement;

public final class StableUniqueStanzaIdManager extends Manager {
    private static final StanzaFilter ADD_ORIGIN_ID_FILTER;
    private static final Map<XMPPConnection, StableUniqueStanzaIdManager> INSTANCES = new WeakHashMap();
    public static final String NAMESPACE = "urn:xmpp:sid:0";
    private static final StanzaFilter ORIGIN_ID_FILTER;
    private static final StanzaFilter OUTGOING_FILTER;
    /* access modifiers changed from: private */
    public static boolean enabledByDefault = false;

    static {
        AndFilter andFilter = new AndFilter(MessageTypeFilter.NORMAL_OR_CHAT_OR_HEADLINE, ToTypeFilter.ENTITY_FULL_OR_BARE_JID);
        OUTGOING_FILTER = andFilter;
        StanzaExtensionFilter stanzaExtensionFilter = new StanzaExtensionFilter(OriginIdElement.ELEMENT, "urn:xmpp:sid:0");
        ORIGIN_ID_FILTER = stanzaExtensionFilter;
        ADD_ORIGIN_ID_FILTER = new AndFilter(andFilter, new NotFilter(stanzaExtensionFilter));
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() {
            /* access modifiers changed from: private */
            public static /* synthetic */ void lambda$connectionCreated$0(MessageBuilder messageBuilder, MultiUserChat multiUserChat) {
                if (!multiUserChat.serviceSupportsStableIds()) {
                    OriginIdElement.addTo(messageBuilder);
                }
            }

            public void connectionCreated(XMPPConnection xMPPConnection) {
                if (StableUniqueStanzaIdManager.enabledByDefault) {
                    StableUniqueStanzaIdManager.getInstanceFor(xMPPConnection).enable();
                }
                MultiUserChatManager.addDefaultMessageInterceptor(new c());
            }
        });
    }

    private StableUniqueStanzaIdManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
    }

    public static synchronized StableUniqueStanzaIdManager getInstanceFor(XMPPConnection xMPPConnection) {
        StableUniqueStanzaIdManager stableUniqueStanzaIdManager;
        synchronized (StableUniqueStanzaIdManager.class) {
            Map<XMPPConnection, StableUniqueStanzaIdManager> map = INSTANCES;
            stableUniqueStanzaIdManager = map.get(xMPPConnection);
            if (stableUniqueStanzaIdManager == null) {
                stableUniqueStanzaIdManager = new StableUniqueStanzaIdManager(xMPPConnection);
                map.put(xMPPConnection, stableUniqueStanzaIdManager);
            }
        }
        return stableUniqueStanzaIdManager;
    }

    public static void setEnabledByDefault(boolean z10) {
        enabledByDefault = z10;
    }

    public synchronized void disable() {
        ServiceDiscoveryManager.getInstanceFor(connection()).removeFeature("urn:xmpp:sid:0");
        connection().removeMessageInterceptor(new a());
    }

    public synchronized void enable() {
        XMPPConnection connection = connection();
        a aVar = new a();
        StanzaFilter stanzaFilter = ADD_ORIGIN_ID_FILTER;
        Objects.requireNonNull(stanzaFilter);
        connection.addMessageInterceptor(aVar, new b(stanzaFilter));
        ServiceDiscoveryManager.getInstanceFor(connection()).addFeature("urn:xmpp:sid:0");
    }

    public synchronized boolean isEnabled() {
        return ServiceDiscoveryManager.getInstanceFor(connection()).includesFeature("urn:xmpp:sid:0");
    }
}
