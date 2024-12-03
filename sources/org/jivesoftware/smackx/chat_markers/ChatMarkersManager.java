package org.jivesoftware.smackx.chat_markers;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import org.jivesoftware.smack.AsyncButOrdered;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.chat2.Chat;
import org.jivesoftware.smack.chat2.ChatManager;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.MessageTypeFilter;
import org.jivesoftware.smack.filter.MessageWithBodiesFilter;
import org.jivesoftware.smack.filter.NotFilter;
import org.jivesoftware.smack.filter.PossibleFromTypeFilter;
import org.jivesoftware.smack.filter.StanzaExtensionFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.chat_markers.element.ChatMarkersElements;
import org.jivesoftware.smackx.chat_markers.filter.ChatMarkersFilter;
import org.jivesoftware.smackx.chat_markers.filter.EligibleForChatMarkerFilter;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;

public final class ChatMarkersManager extends Manager {
    private static final StanzaFilter INCOMING_MESSAGE_FILTER;
    private static final Map<XMPPConnection, ChatMarkersManager> INSTANCES = new WeakHashMap();
    private static final StanzaFilter OUTGOING_MESSAGE_FILTER;
    /* access modifiers changed from: private */
    public final AsyncButOrdered<Chat> asyncButOrdered = new AsyncButOrdered<>();
    /* access modifiers changed from: private */
    public final ChatManager chatManager;
    private boolean enabled;
    /* access modifiers changed from: private */
    public final Set<ChatMarkersListener> incomingListeners = new HashSet();
    private final ServiceDiscoveryManager serviceDiscoveryManager;

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() {
            public void connectionCreated(XMPPConnection xMPPConnection) {
                ChatMarkersManager.getInstanceFor(xMPPConnection);
            }
        });
        StanzaFilter stanzaFilter = MessageTypeFilter.NORMAL_OR_CHAT;
        EligibleForChatMarkerFilter eligibleForChatMarkerFilter = EligibleForChatMarkerFilter.INSTANCE;
        INCOMING_MESSAGE_FILTER = new AndFilter(stanzaFilter, new StanzaExtensionFilter((String) ChatMarkersElements.NAMESPACE), PossibleFromTypeFilter.ENTITY_BARE_JID, eligibleForChatMarkerFilter);
        OUTGOING_MESSAGE_FILTER = new AndFilter(stanzaFilter, MessageWithBodiesFilter.INSTANCE, new NotFilter(ChatMarkersFilter.INSTANCE), eligibleForChatMarkerFilter);
    }

    private ChatMarkersManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.chatManager = ChatManager.getInstanceFor(xMPPConnection);
        xMPPConnection.addMessageInterceptor(new a(), new b());
        xMPPConnection.addSyncStanzaListener(new StanzaListener() {
            public void processStanza(Stanza stanza) throws SmackException.NotConnectedException, InterruptedException, SmackException.NotLoggedInException {
                final Message message = (Message) stanza;
                final Chat chatWith = ChatMarkersManager.this.chatManager.chatWith(message.getFrom().S());
                ChatMarkersManager.this.asyncButOrdered.performAsyncButOrdered(chatWith, new Runnable() {
                    public void run() {
                        for (ChatMarkersListener chatMarkersListener : ChatMarkersManager.this.incomingListeners) {
                            if (ChatMarkersElements.MarkableExtension.from(message) != null) {
                                chatMarkersListener.newChatMarkerMessage(ChatMarkersState.markable, message, chatWith);
                            } else if (ChatMarkersElements.ReceivedExtension.from(message) != null) {
                                chatMarkersListener.newChatMarkerMessage(ChatMarkersState.received, message, chatWith);
                            } else if (ChatMarkersElements.DisplayedExtension.from(message) != null) {
                                chatMarkersListener.newChatMarkerMessage(ChatMarkersState.displayed, message, chatWith);
                            } else if (ChatMarkersElements.AcknowledgedExtension.from(message) != null) {
                                chatMarkersListener.newChatMarkerMessage(ChatMarkersState.acknowledged, message, chatWith);
                            }
                        }
                    }
                });
            }
        }, INCOMING_MESSAGE_FILTER);
        this.serviceDiscoveryManager = ServiceDiscoveryManager.getInstanceFor(xMPPConnection);
    }

    public static synchronized ChatMarkersManager getInstanceFor(XMPPConnection xMPPConnection) {
        ChatMarkersManager chatMarkersManager;
        synchronized (ChatMarkersManager.class) {
            Map<XMPPConnection, ChatMarkersManager> map = INSTANCES;
            chatMarkersManager = map.get(xMPPConnection);
            if (chatMarkersManager == null) {
                chatMarkersManager = new ChatMarkersManager(xMPPConnection);
                map.put(xMPPConnection, chatMarkersManager);
            }
        }
        return chatMarkersManager;
    }

    public synchronized boolean addIncomingChatMarkerMessageListener(ChatMarkersListener chatMarkersListener) {
        boolean add;
        add = this.incomingListeners.add(chatMarkersListener);
        if (!this.enabled) {
            this.serviceDiscoveryManager.addFeature(ChatMarkersElements.NAMESPACE);
            this.enabled = true;
        }
        return add;
    }

    public boolean isSupportedByServer() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).serverSupportsFeature(ChatMarkersElements.NAMESPACE);
    }

    public synchronized boolean removeIncomingChatMarkerMessageListener(ChatMarkersListener chatMarkersListener) {
        boolean remove;
        remove = this.incomingListeners.remove(chatMarkersListener);
        if (this.incomingListeners.isEmpty() && this.enabled) {
            this.serviceDiscoveryManager.removeFeature(ChatMarkersElements.NAMESPACE);
            this.enabled = false;
        }
        return remove;
    }
}
