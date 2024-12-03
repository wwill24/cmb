package org.jivesoftware.smack.chat;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Logger;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaCollector;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter;
import org.jivesoftware.smack.filter.FromMatchesFilter;
import org.jivesoftware.smack.filter.MessageTypeFilter;
import org.jivesoftware.smack.filter.OrFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.ThreadFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.StringUtils;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.EntityJid;
import org.jxmpp.jid.Jid;

@Deprecated
public final class ChatManager extends Manager {
    private static final Map<XMPPConnection, ChatManager> INSTANCES = new WeakHashMap();
    private static final Logger LOGGER = Logger.getLogger(ChatManager.class.getName());
    private static boolean defaultIsNormalInclude = true;
    private static MatchMode defaultMatchMode = MatchMode.BARE_JID;
    private final Map<EntityBareJid, Chat> baseJidChats = new ConcurrentHashMap();
    private final Set<ChatManagerListener> chatManagerListeners = new CopyOnWriteArraySet();
    private final Map<MessageListener, StanzaFilter> interceptors = new WeakHashMap();
    private final Map<Jid, Chat> jidChats = new ConcurrentHashMap();
    private MatchMode matchMode = defaultMatchMode;
    /* access modifiers changed from: private */
    public boolean normalIncluded = defaultIsNormalInclude;
    private final StanzaFilter packetFilter;
    private final Map<String, Chat> threadChats = new ConcurrentHashMap();

    public enum MatchMode {
        NONE,
        SUPPLIED_JID,
        BARE_JID
    }

    private ChatManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        OrFilter orFilter = new OrFilter(MessageTypeFilter.CHAT, new FlexibleStanzaTypeFilter<Message>() {
            /* access modifiers changed from: protected */
            public boolean acceptSpecific(Message message) {
                return ChatManager.this.normalIncluded && message.getType() == Message.Type.normal;
            }
        });
        this.packetFilter = orFilter;
        xMPPConnection.addSyncStanzaListener(new StanzaListener() {
            public void processStanza(Stanza stanza) {
                Chat chat;
                Message message = (Message) stanza;
                if (message.getThread() == null) {
                    chat = ChatManager.this.getUserChat(message.getFrom());
                } else {
                    chat = ChatManager.this.getThreadChat(message.getThread());
                }
                if (chat == null) {
                    chat = ChatManager.this.createChat(message);
                }
                if (chat != null) {
                    ChatManager.deliverMessage(chat, message);
                }
            }
        }, orFilter);
        INSTANCES.put(xMPPConnection, this);
    }

    /* access modifiers changed from: private */
    public static void deliverMessage(Chat chat, Message message) {
        chat.deliver(message);
    }

    public static synchronized ChatManager getInstanceFor(XMPPConnection xMPPConnection) {
        ChatManager chatManager;
        synchronized (ChatManager.class) {
            chatManager = INSTANCES.get(xMPPConnection);
            if (chatManager == null) {
                chatManager = new ChatManager(xMPPConnection);
            }
        }
        return chatManager;
    }

    /* access modifiers changed from: private */
    public Chat getUserChat(Jid jid) {
        EntityBareJid h12;
        if (this.matchMode == MatchMode.NONE || jid == null) {
            return null;
        }
        Chat chat = this.jidChats.get(jid);
        if (chat == null && this.matchMode == MatchMode.BARE_JID && (h12 = jid.h1()) != null) {
            return this.baseJidChats.get(h12);
        }
        return chat;
    }

    private static String nextID() {
        return StringUtils.secureUniqueRandomString();
    }

    public static void setDefaultIsNormalIncluded(boolean z10) {
        defaultIsNormalInclude = z10;
    }

    public static void setDefaultMatchMode(MatchMode matchMode2) {
        defaultMatchMode = matchMode2;
    }

    public void addChatListener(ChatManagerListener chatManagerListener) {
        this.chatManagerListeners.add(chatManagerListener);
    }

    public void addOutgoingMessageInterceptor(MessageListener messageListener) {
        addOutgoingMessageInterceptor(messageListener, (StanzaFilter) null);
    }

    /* access modifiers changed from: package-private */
    public void closeChat(Chat chat) {
        this.threadChats.remove(chat.getThreadID());
        EntityJid participant = chat.getParticipant();
        this.jidChats.remove(participant);
        this.baseJidChats.remove(participant.E0());
    }

    public Chat createChat(EntityJid entityJid) {
        return createChat(entityJid, (ChatMessageListener) null);
    }

    /* access modifiers changed from: package-private */
    public StanzaCollector createStanzaCollector(Chat chat) {
        return connection().createStanzaCollector((StanzaFilter) new AndFilter(new ThreadFilter(chat.getThreadID()), FromMatchesFilter.create(chat.getParticipant())));
    }

    public Set<ChatManagerListener> getChatListeners() {
        return Collections.unmodifiableSet(this.chatManagerListeners);
    }

    public MatchMode getMatchMode() {
        return this.matchMode;
    }

    public Chat getThreadChat(String str) {
        return this.threadChats.get(str);
    }

    public boolean isNormalIncluded() {
        return this.normalIncluded;
    }

    public void removeChatListener(ChatManagerListener chatManagerListener) {
        this.chatManagerListeners.remove(chatManagerListener);
    }

    /* access modifiers changed from: package-private */
    public void sendMessage(Chat chat, Message message) throws SmackException.NotConnectedException, InterruptedException {
        for (Map.Entry next : this.interceptors.entrySet()) {
            StanzaFilter stanzaFilter = (StanzaFilter) next.getValue();
            if (stanzaFilter != null && stanzaFilter.accept(message)) {
                ((MessageListener) next.getKey()).processMessage(message);
            }
        }
        connection().sendStanza(message);
    }

    public void setMatchMode(MatchMode matchMode2) {
        this.matchMode = matchMode2;
    }

    public void setNormalIncluded(boolean z10) {
        this.normalIncluded = z10;
    }

    public void addOutgoingMessageInterceptor(MessageListener messageListener, StanzaFilter stanzaFilter) {
        if (messageListener != null) {
            this.interceptors.put(messageListener, stanzaFilter);
        }
    }

    public Chat createChat(EntityJid entityJid, ChatMessageListener chatMessageListener) {
        return createChat(entityJid, (String) null, chatMessageListener);
    }

    public Chat createChat(EntityJid entityJid, String str, ChatMessageListener chatMessageListener) {
        if (str == null) {
            str = nextID();
        }
        if (this.threadChats.get(str) == null) {
            Chat createChat = createChat(entityJid, str, true);
            createChat.addMessageListener(chatMessageListener);
            return createChat;
        }
        throw new IllegalArgumentException("ThreadID is already used");
    }

    private Chat createChat(EntityJid entityJid, String str, boolean z10) {
        Chat chat = new Chat(this, entityJid, str);
        this.threadChats.put(str, chat);
        this.jidChats.put(entityJid, chat);
        this.baseJidChats.put(entityJid.E0(), chat);
        for (ChatManagerListener chatCreated : this.chatManagerListeners) {
            chatCreated.chatCreated(chat, z10);
        }
        return chat;
    }

    /* access modifiers changed from: private */
    public Chat createChat(Message message) {
        Jid from = message.getFrom();
        if (from == null) {
            return null;
        }
        EntityJid m02 = from.m0();
        if (m02 == null) {
            Logger logger = LOGGER;
            logger.warning("Message from JID without localpart: '" + message.toXML() + "'");
            return null;
        }
        String thread = message.getThread();
        if (thread == null) {
            thread = nextID();
        }
        return createChat(m02, thread, false);
    }
}
