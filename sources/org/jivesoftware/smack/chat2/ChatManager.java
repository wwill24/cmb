package org.jivesoftware.smack.chat2;

import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.jivesoftware.smack.AsyncButOrdered;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.FromTypeFilter;
import org.jivesoftware.smack.filter.MessageTypeFilter;
import org.jivesoftware.smack.filter.MessageWithBodiesFilter;
import org.jivesoftware.smack.filter.OrFilter;
import org.jivesoftware.smack.filter.StanzaExtensionFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.ToTypeFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.packet.MessageView;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.roster.AbstractRosterListener;
import org.jivesoftware.smack.roster.Roster;
import org.jivesoftware.smackx.xhtmlim.packet.XHTMLExtension;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.Jid;

public final class ChatManager extends Manager {
    private static final StanzaFilter INCOMING_MESSAGE_FILTER;
    private static final Map<XMPPConnection, ChatManager> INSTANCES = new WeakHashMap();
    private static final StanzaFilter MESSAGE_FILTER;
    private static final StanzaFilter OUTGOING_MESSAGE_FILTER;
    /* access modifiers changed from: private */
    public final AsyncButOrdered<Chat> asyncButOrdered = new AsyncButOrdered<>();
    /* access modifiers changed from: private */
    public final Map<EntityBareJid, Chat> chats = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public final Set<IncomingChatMessageListener> incomingListeners = new CopyOnWriteArraySet();
    private final Set<OutgoingChatMessageListener> outgoingListeners = new CopyOnWriteArraySet();
    private boolean xhtmlIm;

    static {
        AndFilter andFilter = new AndFilter(MessageTypeFilter.NORMAL_OR_CHAT, new OrFilter(MessageWithBodiesFilter.INSTANCE, new StanzaExtensionFilter(XHTMLExtension.ELEMENT, XHTMLExtension.NAMESPACE)));
        MESSAGE_FILTER = andFilter;
        OUTGOING_MESSAGE_FILTER = new AndFilter(andFilter, ToTypeFilter.ENTITY_FULL_OR_BARE_JID);
        INCOMING_MESSAGE_FILTER = new AndFilter(andFilter, FromTypeFilter.ENTITY_FULL_JID);
    }

    private ChatManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        xMPPConnection.addSyncStanzaListener(new StanzaListener() {
            public void processStanza(Stanza stanza) {
                final Message message = (Message) stanza;
                if (ChatManager.this.shouldAcceptMessage(message)) {
                    EntityFullJid i02 = message.getFrom().i0();
                    final EntityBareJid E0 = i02.E0();
                    final Chat chatWith = ChatManager.this.chatWith(E0);
                    chatWith.lockedResource = i02;
                    ChatManager.this.asyncButOrdered.performAsyncButOrdered(chatWith, new Runnable() {
                        public void run() {
                            for (IncomingChatMessageListener newIncomingMessage : ChatManager.this.incomingListeners) {
                                newIncomingMessage.newIncomingMessage(E0, message, chatWith);
                            }
                        }
                    });
                }
            }
        }, INCOMING_MESSAGE_FILTER);
        xMPPConnection.addMessageInterceptor(new a(this), new b());
        Roster.getInstanceFor(xMPPConnection).addRosterListener(new AbstractRosterListener() {
            public void presenceChanged(Presence presence) {
                Chat chat;
                Jid from = presence.getFrom();
                EntityBareJid h12 = from.h1();
                if (h12 != null && (chat = (Chat) ChatManager.this.chats.get(h12)) != null && chat.lockedResource != null) {
                    if (!chat.lockedResource.Y(from.m1())) {
                        Presence presence2 = chat.lastPresenceOfLockedResource;
                        if (presence2 == null) {
                            chat.lastPresenceOfLockedResource = presence;
                        } else if (presence2.getMode() != presence.getMode() || chat.lastPresenceOfLockedResource.getType() != presence.getType()) {
                            chat.unlockResource();
                        }
                    }
                }
            }
        });
    }

    public static synchronized ChatManager getInstanceFor(XMPPConnection xMPPConnection) {
        ChatManager chatManager;
        synchronized (ChatManager.class) {
            Map<XMPPConnection, ChatManager> map = INSTANCES;
            chatManager = map.get(xMPPConnection);
            if (chatManager == null) {
                chatManager = new ChatManager(xMPPConnection);
                map.put(xMPPConnection, chatManager);
            }
        }
        return chatManager;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(MessageBuilder messageBuilder) {
        if (shouldAcceptMessage(messageBuilder)) {
            EntityBareJid S = messageBuilder.getTo().S();
            Chat chatWith = chatWith(S);
            for (OutgoingChatMessageListener newOutgoingMessage : this.outgoingListeners) {
                newOutgoingMessage.newOutgoingMessage(S, messageBuilder, chatWith);
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean shouldAcceptMessage(MessageView messageView) {
        if (messageView.hasExtension(Message.Body.QNAME)) {
            return true;
        }
        if (this.xhtmlIm && XHTMLExtension.from(messageView) != null) {
            return true;
        }
        return false;
    }

    public boolean addIncomingListener(IncomingChatMessageListener incomingChatMessageListener) {
        return this.incomingListeners.add(incomingChatMessageListener);
    }

    public boolean addOutgoingListener(OutgoingChatMessageListener outgoingChatMessageListener) {
        return this.outgoingListeners.add(outgoingChatMessageListener);
    }

    public Chat chatWith(EntityBareJid entityBareJid) {
        Chat chat = this.chats.get(entityBareJid);
        if (chat == null) {
            synchronized (this.chats) {
                Chat chat2 = this.chats.get(entityBareJid);
                if (chat2 != null) {
                    return chat2;
                }
                chat = new Chat(connection(), entityBareJid);
                this.chats.put(entityBareJid, chat);
            }
        }
        return chat;
    }

    public boolean removeIncomingListener(IncomingChatMessageListener incomingChatMessageListener) {
        return this.incomingListeners.remove(incomingChatMessageListener);
    }

    public boolean removeOutgoingListener(OutgoingChatMessageListener outgoingChatMessageListener) {
        return this.outgoingListeners.remove(outgoingChatMessageListener);
    }

    public void setXhmtlImEnabled(boolean z10) {
        this.xhtmlIm = z10;
    }
}
