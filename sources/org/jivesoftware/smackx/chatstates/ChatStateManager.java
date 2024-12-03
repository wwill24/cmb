package org.jivesoftware.smackx.chatstates;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.AsyncButOrdered;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.chat2.Chat;
import org.jivesoftware.smack.chat2.ChatManager;
import org.jivesoftware.smack.chat2.OutgoingChatMessageListener;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.FromTypeFilter;
import org.jivesoftware.smack.filter.MessageTypeFilter;
import org.jivesoftware.smack.filter.StanzaExtensionFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.StanzaBuilder;
import org.jivesoftware.smackx.chatstates.packet.ChatStateExtension;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jxmpp.jid.EntityBareJid;

public final class ChatStateManager extends Manager {
    private static final StanzaFilter INCOMING_CHAT_STATE_FILTER;
    private static final StanzaFilter INCOMING_MESSAGE_FILTER;
    private static final Map<XMPPConnection, ChatStateManager> INSTANCES = new WeakHashMap();
    /* access modifiers changed from: private */
    public static final Logger LOGGER = Logger.getLogger(ChatStateManager.class.getName());
    public static final String NAMESPACE = "http://jabber.org/protocol/chatstates";
    /* access modifiers changed from: private */
    public final AsyncButOrdered<Chat> asyncButOrdered = new AsyncButOrdered<>();
    /* access modifiers changed from: private */
    public final Set<ChatStateListener> chatStateListeners = new HashSet();
    private final Map<Chat, ChatState> chatStates = new WeakHashMap();

    static {
        AndFilter andFilter = new AndFilter(MessageTypeFilter.NORMAL_OR_CHAT, FromTypeFilter.ENTITY_FULL_JID);
        INCOMING_MESSAGE_FILTER = andFilter;
        INCOMING_CHAT_STATE_FILTER = new AndFilter(andFilter, new StanzaExtensionFilter("http://jabber.org/protocol/chatstates"));
    }

    private ChatStateManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        ChatManager.getInstanceFor(xMPPConnection).addOutgoingListener(new OutgoingChatMessageListener() {
            public void newOutgoingMessage(EntityBareJid entityBareJid, MessageBuilder messageBuilder, Chat chat) {
                if (chat != null && !messageBuilder.hasExtension("http://jabber.org/protocol/chatstates")) {
                    ChatStateManager chatStateManager = ChatStateManager.this;
                    ChatState chatState = ChatState.active;
                    if (chatStateManager.updateChatState(chat, chatState)) {
                        messageBuilder.addExtension(new ChatStateExtension(chatState));
                    }
                }
            }
        });
        xMPPConnection.addSyncStanzaListener(new StanzaListener() {
            public void processStanza(Stanza stanza) {
                final ArrayList arrayList;
                final Message message = (Message) stanza;
                Chat chatWith = ChatManager.getInstanceFor(ChatStateManager.this.connection()).chatWith(message.getFrom().m1().E0());
                String elementName = message.getExtension("http://jabber.org/protocol/chatstates").getElementName();
                try {
                    final ChatState valueOf = ChatState.valueOf(elementName);
                    synchronized (ChatStateManager.this.chatStateListeners) {
                        arrayList = new ArrayList(ChatStateManager.this.chatStateListeners.size());
                        arrayList.addAll(ChatStateManager.this.chatStateListeners);
                    }
                    final Chat chat = chatWith;
                    ChatStateManager.this.asyncButOrdered.performAsyncButOrdered(chatWith, new Runnable() {
                        public void run() {
                            for (ChatStateListener stateChanged : arrayList) {
                                stateChanged.stateChanged(chat, valueOf, message);
                            }
                        }
                    });
                } catch (Exception e10) {
                    Logger access$200 = ChatStateManager.LOGGER;
                    Level level = Level.WARNING;
                    access$200.log(level, "Invalid chat state element name: " + elementName, e10);
                }
            }
        }, INCOMING_CHAT_STATE_FILTER);
        ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature("http://jabber.org/protocol/chatstates");
    }

    public static synchronized ChatStateManager getInstance(XMPPConnection xMPPConnection) {
        ChatStateManager chatStateManager;
        synchronized (ChatStateManager.class) {
            Map<XMPPConnection, ChatStateManager> map = INSTANCES;
            chatStateManager = map.get(xMPPConnection);
            if (chatStateManager == null) {
                chatStateManager = new ChatStateManager(xMPPConnection);
                map.put(xMPPConnection, chatStateManager);
            }
        }
        return chatStateManager;
    }

    /* access modifiers changed from: private */
    public synchronized boolean updateChatState(Chat chat, ChatState chatState) {
        if (this.chatStates.get(chat) == chatState) {
            return false;
        }
        this.chatStates.put(chat, chatState);
        return true;
    }

    public boolean addChatStateListener(ChatStateListener chatStateListener) {
        boolean add;
        synchronized (this.chatStateListeners) {
            add = this.chatStateListeners.add(chatStateListener);
        }
        return add;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ChatStateManager.class != obj.getClass()) {
            return false;
        }
        return connection().equals(((ChatStateManager) obj).connection());
    }

    public int hashCode() {
        return connection().hashCode();
    }

    public boolean removeChatStateListener(ChatStateListener chatStateListener) {
        boolean remove;
        synchronized (this.chatStateListeners) {
            remove = this.chatStateListeners.remove(chatStateListener);
        }
        return remove;
    }

    public void setCurrentState(ChatState chatState, Chat chat) throws SmackException.NotConnectedException, InterruptedException {
        if (chat == null || chatState == null) {
            throw new IllegalArgumentException("Arguments cannot be null.");
        } else if (updateChatState(chat, chatState)) {
            Message build = StanzaBuilder.buildMessage().build();
            build.addExtension(new ChatStateExtension(chatState));
            chat.send(build);
        }
    }
}
