package org.jivesoftware.smackx.ox_im;

import cn.k;
import hm.a;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import org.bouncycastle.openpgp.PGPException;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.chat2.ChatManager;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.eme.element.ExplicitMessageEncryptionElement;
import org.jivesoftware.smackx.hints.element.StoreHint;
import org.jivesoftware.smackx.ox.OpenPgpContact;
import org.jivesoftware.smackx.ox.OpenPgpManager;
import org.jivesoftware.smackx.ox.OpenPgpMessage;
import org.jivesoftware.smackx.ox.crypto.OpenPgpElementAndMetadata;
import org.jivesoftware.smackx.ox.element.OpenPgpElement;
import org.jivesoftware.smackx.ox.element.SigncryptElement;
import org.jxmpp.jid.BareJid;
import org.jxmpp.jid.Jid;

public final class OXInstantMessagingManager extends Manager {
    private static final Map<XMPPConnection, OXInstantMessagingManager> INSTANCES = new WeakHashMap();
    public static final String NAMESPACE_0 = "urn:xmpp:openpgp:im:0";
    private final OpenPgpManager openPgpManager;
    private final Set<OxMessageListener> oxMessageListeners = new HashSet();

    private OXInstantMessagingManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        OpenPgpManager instanceFor = OpenPgpManager.getInstanceFor(xMPPConnection);
        this.openPgpManager = instanceFor;
        instanceFor.registerSigncryptReceivedListener(new a(this));
        announceSupportForOxInstantMessaging();
    }

    public static synchronized OXInstantMessagingManager getInstanceFor(XMPPConnection xMPPConnection) {
        OXInstantMessagingManager oXInstantMessagingManager;
        synchronized (OXInstantMessagingManager.class) {
            Map<XMPPConnection, OXInstantMessagingManager> map = INSTANCES;
            oXInstantMessagingManager = map.get(xMPPConnection);
            if (oXInstantMessagingManager == null) {
                oXInstantMessagingManager = new OXInstantMessagingManager(xMPPConnection);
                map.put(xMPPConnection, oXInstantMessagingManager);
            }
        }
        return oXInstantMessagingManager;
    }

    private static void setOXBodyHint(MessageBuilder messageBuilder) {
        messageBuilder.setBody("This message is encrypted using XEP-0374: OpenPGP for XMPP: Instant Messaging.");
    }

    /* access modifiers changed from: private */
    public void signcryptElementReceivedListener(OpenPgpContact openPgpContact, Message message, SigncryptElement signcryptElement, k kVar) {
        for (OxMessageListener newIncomingOxMessage : this.oxMessageListeners) {
            newIncomingOxMessage.newIncomingOxMessage(openPgpContact, message, signcryptElement, kVar);
        }
    }

    public k addOxMessage(MessageBuilder messageBuilder, OpenPgpContact openPgpContact, List<ExtensionElement> list) throws SmackException.NotLoggedInException, PGPException, IOException {
        return addOxMessage(messageBuilder, (Set<OpenPgpContact>) Collections.singleton(openPgpContact), list);
    }

    public boolean addOxMessageListener(OxMessageListener oxMessageListener) {
        return this.oxMessageListeners.add(oxMessageListener);
    }

    public void announceSupportForOxInstantMessaging() {
        ServiceDiscoveryManager.getInstanceFor(connection()).addFeature(NAMESPACE_0);
    }

    public boolean contactSupportsOxInstantMessaging(BareJid bareJid) throws XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException, SmackException.NoResponseException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).supportsFeature(bareJid, NAMESPACE_0);
    }

    public OpenPgpMessage decryptAndVerify(OpenPgpElement openPgpElement, OpenPgpContact openPgpContact) throws SmackException.NotLoggedInException, PGPException, IOException, XmlPullParserException {
        OpenPgpMessage decryptOpenPgpElement = this.openPgpManager.decryptOpenPgpElement(openPgpElement, openPgpContact);
        if (decryptOpenPgpElement.getState() == OpenPgpMessage.State.signcrypt) {
            return decryptOpenPgpElement;
        }
        throw new IllegalArgumentException("Decrypted message does appear to not be an OX message. (State: " + decryptOpenPgpElement.getState() + ")");
    }

    public boolean removeOxMessageListener(OxMessageListener oxMessageListener) {
        return this.oxMessageListeners.remove(oxMessageListener);
    }

    public k sendOxMessage(OpenPgpContact openPgpContact, CharSequence charSequence) throws InterruptedException, IOException, SmackException.NotConnectedException, SmackException.NotLoggedInException, PGPException {
        MessageBuilder messageBuilder = (MessageBuilder) connection().getStanzaFactory().buildMessageStanza().to((Jid) openPgpContact.getJid());
        k addOxMessage = addOxMessage(messageBuilder, openPgpContact, (List<ExtensionElement>) Collections.singletonList(new Message.Body((String) null, charSequence.toString())));
        ChatManager.getInstanceFor(connection()).chatWith(openPgpContact.getJid().h1()).send(messageBuilder.build());
        return addOxMessage;
    }

    public OpenPgpElementAndMetadata signAndEncrypt(Set<OpenPgpContact> set, List<ExtensionElement> list) throws SmackException.NotLoggedInException, IOException, PGPException {
        HashSet hashSet = new HashSet();
        for (OpenPgpContact jid : set) {
            hashSet.add(jid.getJid());
        }
        hashSet.add(this.openPgpManager.getOpenPgpSelf().getJid());
        return this.openPgpManager.getOpenPgpProvider().signAndEncrypt(new SigncryptElement(hashSet, list), this.openPgpManager.getOpenPgpSelf(), set);
    }

    public k addOxMessage(MessageBuilder messageBuilder, Set<OpenPgpContact> set, List<ExtensionElement> list) throws SmackException.NotLoggedInException, IOException, PGPException {
        OpenPgpElementAndMetadata signAndEncrypt = signAndEncrypt(set, list);
        messageBuilder.addExtension(signAndEncrypt.getElement());
        ExplicitMessageEncryptionElement.set(messageBuilder, ExplicitMessageEncryptionElement.ExplicitMessageEncryptionProtocol.openpgpV0);
        StoreHint.set(messageBuilder);
        setOXBodyHint(messageBuilder);
        return signAndEncrypt.getMetadata();
    }

    public boolean contactSupportsOxInstantMessaging(OpenPgpContact openPgpContact) throws XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException, SmackException.NoResponseException {
        return contactSupportsOxInstantMessaging(openPgpContact.getJid());
    }
}
