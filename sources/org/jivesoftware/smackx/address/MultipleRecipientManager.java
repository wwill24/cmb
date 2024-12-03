package org.jivesoftware.smackx.address;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.StanzaBuilder;
import org.jivesoftware.smack.packet.StanzaFactory;
import org.jivesoftware.smack.packet.StanzaView;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jxmpp.jid.DomainBareJid;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.Jid;

public class MultipleRecipientManager {
    public static MultipleRecipientInfo getMultipleRecipientInfo(Stanza stanza) {
        MultipleAddresses multipleAddresses = (MultipleAddresses) stanza.getExtension(MultipleAddresses.class);
        if (multipleAddresses == null) {
            return null;
        }
        return new MultipleRecipientInfo(multipleAddresses);
    }

    private static DomainBareJid getMultipleRecipientServiceAddress(XMPPConnection xMPPConnection) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return ServiceDiscoveryManager.getInstanceFor(xMPPConnection).findService(MultipleAddresses.NAMESPACE, true);
    }

    public static void reply(XMPPConnection xMPPConnection, Message message, Message message2) throws XMPPException.XMPPErrorException, InterruptedException, SmackException.NotConnectedException, SmackException.NoResponseException, SmackException.FeatureNotSupportedException {
        MultipleRecipientInfo multipleRecipientInfo = getMultipleRecipientInfo(message);
        if (multipleRecipientInfo == null) {
            throw new IllegalArgumentException("Original message does not contain multiple recipient info");
        } else if (multipleRecipientInfo.shouldNotReply()) {
            throw new IllegalArgumentException("Original message should not be replied");
        } else if (multipleRecipientInfo.getReplyRoom() == null) {
            if (message.getThread() != null) {
                message2.asBuilder().setThread(message.getThread()).build();
            }
            MultipleAddresses.Address replyAddress = multipleRecipientInfo.getReplyAddress();
            if (replyAddress == null || replyAddress.getJid() == null) {
                ArrayList arrayList = new ArrayList(multipleRecipientInfo.getTOAddresses().size());
                ArrayList arrayList2 = new ArrayList(multipleRecipientInfo.getCCAddresses().size());
                for (MultipleAddresses.Address jid : multipleRecipientInfo.getTOAddresses()) {
                    arrayList.add(jid.getJid());
                }
                for (MultipleAddresses.Address jid2 : multipleRecipientInfo.getCCAddresses()) {
                    arrayList2.add(jid2.getJid());
                }
                if (!arrayList.contains(message.getFrom()) && !arrayList2.contains(message.getFrom())) {
                    arrayList.add(message.getFrom());
                }
                EntityFullJid user = xMPPConnection.getUser();
                if (!arrayList.remove(user) && !arrayList2.remove(user)) {
                    EntityBareJid E0 = user.E0();
                    arrayList.remove(E0);
                    arrayList2.remove(E0);
                }
                send(xMPPConnection, message2, arrayList, arrayList2, (Collection<? extends Jid>) null, (Jid) null, (Jid) null, false);
                return;
            }
            message2.setTo(replyAddress.getJid());
            xMPPConnection.sendStanza(message2);
        } else {
            throw new IllegalArgumentException("Reply should be sent through a room");
        }
    }

    public static void send(XMPPConnection xMPPConnection, Stanza stanza, Collection<? extends Jid> collection, Collection<? extends Jid> collection2, Collection<? extends Jid> collection3) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.FeatureNotSupportedException, SmackException.NotConnectedException, InterruptedException {
        send(xMPPConnection, stanza, collection, collection2, collection3, (Jid) null, (Jid) null, false);
    }

    private static void sendThroughService(XMPPConnection xMPPConnection, Stanza stanza, Collection<? extends Jid> collection, Collection<? extends Jid> collection2, Collection<? extends Jid> collection3, Jid jid, Jid jid2, boolean z10, DomainBareJid domainBareJid) throws SmackException.NotConnectedException, InterruptedException {
        Stanza stanza2 = stanza;
        MultipleAddresses multipleAddresses = new MultipleAddresses();
        if (collection != null) {
            for (Jid addAddress : collection) {
                MultipleAddresses multipleAddresses2 = multipleAddresses;
                multipleAddresses2.addAddress(MultipleAddresses.Type.to, addAddress, (String) null, (String) null, false, (String) null);
            }
        }
        if (collection2 != null) {
            for (Jid addAddress2 : collection2) {
                MultipleAddresses multipleAddresses3 = multipleAddresses;
                multipleAddresses3.addAddress(MultipleAddresses.Type.to, addAddress2, (String) null, (String) null, false, (String) null);
            }
        }
        if (collection3 != null) {
            for (Jid addAddress3 : collection3) {
                MultipleAddresses multipleAddresses4 = multipleAddresses;
                multipleAddresses4.addAddress(MultipleAddresses.Type.bcc, addAddress3, (String) null, (String) null, false, (String) null);
            }
        }
        if (z10) {
            multipleAddresses.setNoReply();
        } else {
            if (jid != null) {
                multipleAddresses.addAddress(MultipleAddresses.Type.replyto, jid, (String) null, (String) null, false, (String) null);
            }
            if (jid2 != null) {
                multipleAddresses.addAddress(MultipleAddresses.Type.replyroom, jid2, (String) null, (String) null, false, (String) null);
            }
        }
        stanza.setTo(domainBareJid);
        stanza.addExtension(multipleAddresses);
        xMPPConnection.sendStanza(stanza);
    }

    private static void sendToIndividualRecipients(XMPPConnection xMPPConnection, StanzaView stanzaView, Collection<? extends Jid> collection, Collection<? extends Jid> collection2, Collection<? extends Jid> collection3) throws SmackException.NotConnectedException, InterruptedException {
        StanzaBuilder stanzaBuilder;
        StanzaFactory stanzaFactory = xMPPConnection.getStanzaFactory();
        if (stanzaView instanceof Message) {
            stanzaBuilder = stanzaFactory.buildMessageStanzaFrom((Message) stanzaView);
        } else if (stanzaView instanceof Presence) {
            stanzaBuilder = stanzaFactory.buildPresenceStanzaFrom((Presence) stanzaView);
        } else if (stanzaView instanceof IQ) {
            throw new IllegalArgumentException("IQ stanzas have no supported fallback in case no XEP-0033 service is available");
        } else {
            throw new AssertionError();
        }
        if (collection == null) {
            collection = Collections.emptyList();
        }
        if (collection2 == null) {
            collection2 = Collections.emptyList();
        }
        if (collection3 == null) {
            collection3 = Collections.emptyList();
        }
        int size = collection.size() + collection2.size() + collection3.size();
        ArrayList<Jid> arrayList = new ArrayList<>(size);
        arrayList.addAll(collection);
        arrayList.addAll(collection2);
        arrayList.addAll(collection3);
        ArrayList<Stanza> arrayList2 = new ArrayList<>(size);
        for (Jid jid : arrayList) {
            arrayList2.add(stanzaBuilder.to(jid).build());
        }
        for (Stanza sendStanza : arrayList2) {
            xMPPConnection.sendStanza(sendStanza);
        }
    }

    public static void send(XMPPConnection xMPPConnection, Stanza stanza, Collection<? extends Jid> collection, Collection<? extends Jid> collection2, Collection<? extends Jid> collection3, Jid jid, Jid jid2, boolean z10) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.FeatureNotSupportedException, SmackException.NotConnectedException, InterruptedException {
        if (collection == null || collection.size() != 1 || ((collection2 != null && !collection2.isEmpty()) || ((collection3 != null && !collection3.isEmpty()) || z10 || !StringUtils.isNullOrEmpty((CharSequence) jid) || !StringUtils.isNullOrEmpty((CharSequence) jid2)))) {
            Stanza stanza2 = stanza;
            DomainBareJid multipleRecipientServiceAddress = getMultipleRecipientServiceAddress(xMPPConnection);
            if (multipleRecipientServiceAddress != null) {
                sendThroughService(xMPPConnection, stanza, collection, collection2, collection3, jid, jid2, z10, multipleRecipientServiceAddress);
            } else if (!z10 && jid == null && jid2 == null) {
                sendToIndividualRecipients(xMPPConnection, stanza, collection, collection2, collection3);
            } else {
                throw new SmackException.FeatureNotSupportedException("Extended Stanza Addressing");
            }
        } else {
            Stanza stanza3 = stanza;
            stanza.setTo((Jid) collection.iterator().next());
            xMPPConnection.sendStanza(stanza);
        }
    }
}
