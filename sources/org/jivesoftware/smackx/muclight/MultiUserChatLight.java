package org.jivesoftware.smackx.muclight;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaCollector;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.chat.Chat;
import org.jivesoftware.smack.chat.ChatManager;
import org.jivesoftware.smack.chat.ChatMessageListener;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.FromMatchesFilter;
import org.jivesoftware.smack.filter.MessageTypeFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.muclight.element.MUCLightAffiliationsIQ;
import org.jivesoftware.smackx.muclight.element.MUCLightChangeAffiliationsIQ;
import org.jivesoftware.smackx.muclight.element.MUCLightConfigurationIQ;
import org.jivesoftware.smackx.muclight.element.MUCLightCreateIQ;
import org.jivesoftware.smackx.muclight.element.MUCLightDestroyIQ;
import org.jivesoftware.smackx.muclight.element.MUCLightGetAffiliationsIQ;
import org.jivesoftware.smackx.muclight.element.MUCLightGetConfigsIQ;
import org.jivesoftware.smackx.muclight.element.MUCLightGetInfoIQ;
import org.jivesoftware.smackx.muclight.element.MUCLightInfoIQ;
import org.jivesoftware.smackx.muclight.element.MUCLightSetConfigsIQ;
import org.jxmpp.jid.EntityJid;
import org.jxmpp.jid.Jid;

public class MultiUserChatLight {
    public static final String AFFILIATIONS = "#affiliations";
    public static final String BLOCKING = "#blocking";
    public static final String CONFIGURATION = "#configuration";
    public static final String CREATE = "#create";
    public static final String DESTROY = "#destroy";
    public static final String INFO = "#info";
    public static final String NAMESPACE = "urn:xmpp:muclight:0";
    private final XMPPConnection connection;
    private final StanzaFilter fromRoomFilter;
    private final StanzaFilter fromRoomGroupChatFilter;
    private StanzaCollector messageCollector;
    private final StanzaListener messageListener;
    /* access modifiers changed from: private */
    public final Set<MessageListener> messageListeners = new CopyOnWriteArraySet();
    private final EntityJid room;

    MultiUserChatLight(XMPPConnection xMPPConnection, EntityJid entityJid) {
        this.connection = xMPPConnection;
        this.room = entityJid;
        FromMatchesFilter create = FromMatchesFilter.create(entityJid);
        this.fromRoomFilter = create;
        AndFilter andFilter = new AndFilter(create, MessageTypeFilter.GROUPCHAT);
        this.fromRoomGroupChatFilter = andFilter;
        AnonymousClass1 r52 = new StanzaListener() {
            public void processStanza(Stanza stanza) throws SmackException.NotConnectedException {
                Message message = (Message) stanza;
                for (MessageListener processMessage : MultiUserChatLight.this.messageListeners) {
                    processMessage.processMessage(message);
                }
            }
        };
        this.messageListener = r52;
        xMPPConnection.addSyncStanzaListener(r52, andFilter);
    }

    private void removeConnectionCallbacks() {
        this.connection.removeSyncStanzaListener(this.messageListener);
        StanzaCollector stanzaCollector = this.messageCollector;
        if (stanzaCollector != null) {
            stanzaCollector.cancel();
            this.messageCollector = null;
        }
    }

    public boolean addMessageListener(MessageListener messageListener2) {
        return this.messageListeners.add(messageListener2);
    }

    public MessageBuilder buildMessage() {
        return (MessageBuilder) this.connection.getStanzaFactory().buildMessageStanza().ofType(Message.Type.groupchat).to((Jid) this.room);
    }

    public void changeAffiliations(HashMap<Jid, MUCLightAffiliation> hashMap) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        this.connection.createStanzaCollectorAndSend(new MUCLightChangeAffiliationsIQ(this.room, hashMap)).nextResultOrThrow();
    }

    public void changeRoomName(String str) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        this.connection.createStanzaCollectorAndSend(new MUCLightSetConfigsIQ(this.room, str, (HashMap<String, String>) null)).nextResultOrThrow();
    }

    public void changeSubject(String str) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        this.connection.createStanzaCollectorAndSend(new MUCLightSetConfigsIQ(this.room, (String) null, str, (HashMap<String, String>) null)).nextResultOrThrow();
    }

    public void create(String str, String str2, HashMap<String, String> hashMap, List<Jid> list) throws Exception {
        MUCLightCreateIQ mUCLightCreateIQ = new MUCLightCreateIQ(this.room, str, list);
        this.messageCollector = this.connection.createStanzaCollector(this.fromRoomGroupChatFilter);
        try {
            this.connection.createStanzaCollectorAndSend(mUCLightCreateIQ).nextResultOrThrow();
        } catch (InterruptedException | SmackException.NoResponseException | SmackException.NotConnectedException | XMPPException.XMPPErrorException e10) {
            removeConnectionCallbacks();
            throw e10;
        }
    }

    @Deprecated
    public Message createMessage() {
        return ((MessageBuilder) this.connection.getStanzaFactory().buildMessageStanza().ofType(Message.Type.groupchat).to((Jid) this.room)).build();
    }

    @Deprecated
    public Chat createPrivateChat(EntityJid entityJid, ChatMessageListener chatMessageListener) {
        return ChatManager.getInstanceFor(this.connection).createChat(entityJid, chatMessageListener);
    }

    public void destroy() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        if (((IQ) this.connection.createStanzaCollectorAndSend(new MUCLightDestroyIQ(this.room)).nextResultOrThrow()).getType().equals(IQ.Type.result)) {
            removeConnectionCallbacks();
        }
    }

    public HashMap<Jid, MUCLightAffiliation> getAffiliations(String str) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return ((MUCLightAffiliationsIQ) ((IQ) this.connection.createStanzaCollectorAndSend(new MUCLightGetAffiliationsIQ(this.room, str)).nextResultOrThrow())).getAffiliations();
    }

    public MUCLightRoomConfiguration getConfiguration(String str) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return ((MUCLightConfigurationIQ) ((IQ) this.connection.createStanzaCollectorAndSend(new MUCLightGetConfigsIQ(this.room, str)).nextResultOrThrow())).getConfiguration();
    }

    public MUCLightRoomInfo getFullInfo(String str) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        MUCLightInfoIQ mUCLightInfoIQ = (MUCLightInfoIQ) ((IQ) this.connection.createStanzaCollectorAndSend(new MUCLightGetInfoIQ(this.room, str)).nextResultOrThrow());
        return new MUCLightRoomInfo(mUCLightInfoIQ.getVersion(), this.room, mUCLightInfoIQ.getConfiguration(), mUCLightInfoIQ.getOccupants());
    }

    public EntityJid getRoom() {
        return this.room;
    }

    public void leave() throws SmackException.NotConnectedException, InterruptedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        HashMap hashMap = new HashMap();
        hashMap.put(this.connection.getUser(), MUCLightAffiliation.none);
        if (((IQ) this.connection.createStanzaCollectorAndSend(new MUCLightChangeAffiliationsIQ(this.room, hashMap)).nextResultOrThrow()).getType().equals(IQ.Type.result)) {
            removeConnectionCallbacks();
        }
    }

    public Message nextMessage() throws InterruptedException {
        return (Message) this.messageCollector.nextResult();
    }

    public Message pollMessage() {
        return (Message) this.messageCollector.pollResult();
    }

    public boolean removeMessageListener(MessageListener messageListener2) {
        return this.messageListeners.remove(messageListener2);
    }

    public void sendMessage(String str) throws SmackException.NotConnectedException, InterruptedException {
        MessageBuilder buildMessage = buildMessage();
        buildMessage.setBody(str);
        this.connection.sendStanza(buildMessage.build());
    }

    public void setRoomConfigs(HashMap<String, String> hashMap) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        setRoomConfigs((String) null, hashMap);
    }

    public String toString() {
        return "MUC Light: " + this.room + "(" + this.connection.getUser() + ")";
    }

    public Message nextMessage(long j10) throws InterruptedException {
        return (Message) this.messageCollector.nextResult(j10);
    }

    public void setRoomConfigs(String str, HashMap<String, String> hashMap) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        this.connection.createStanzaCollectorAndSend(new MUCLightSetConfigsIQ(this.room, str, hashMap)).nextResultOrThrow();
    }

    @Deprecated
    public void sendMessage(Message message) throws SmackException.NotConnectedException, InterruptedException {
        sendMessage(message.asBuilder());
    }

    public HashMap<Jid, MUCLightAffiliation> getAffiliations() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return getAffiliations((String) null);
    }

    public MUCLightRoomConfiguration getConfiguration() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return getConfiguration((String) null);
    }

    public void sendMessage(MessageBuilder messageBuilder) throws SmackException.NotConnectedException, InterruptedException {
        this.connection.sendStanza(((MessageBuilder) messageBuilder.to((Jid) this.room)).ofType(Message.Type.groupchat).build());
    }

    public void create(String str, List<Jid> list) throws Exception {
        create(str, (String) null, (HashMap<String, String>) null, list);
    }

    public MUCLightRoomInfo getFullInfo() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return getFullInfo((String) null);
    }
}
