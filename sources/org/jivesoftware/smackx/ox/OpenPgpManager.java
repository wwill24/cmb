package org.jivesoftware.smackx.ox;

import en.a;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.chat2.Chat;
import org.jivesoftware.smack.chat2.ChatManager;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.util.Async;
import org.jivesoftware.smack.util.stringencoder.Base64;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.ox.callback.backup.AskForBackupCodeCallback;
import org.jivesoftware.smackx.ox.callback.backup.SecretKeyBackupSelectionCallback;
import org.jivesoftware.smackx.ox.crypto.OpenPgpProvider;
import org.jivesoftware.smackx.ox.element.OpenPgpElement;
import org.jivesoftware.smackx.ox.element.PubkeyElement;
import org.jivesoftware.smackx.ox.element.PublicKeysListElement;
import org.jivesoftware.smackx.ox.element.SecretkeyElement;
import org.jivesoftware.smackx.ox.exception.InvalidBackupCodeException;
import org.jivesoftware.smackx.ox.exception.MissingOpenPgpKeyException;
import org.jivesoftware.smackx.ox.exception.MissingUserIdOnKeyException;
import org.jivesoftware.smackx.ox.exception.NoBackupFoundException;
import org.jivesoftware.smackx.ox.listener.CryptElementReceivedListener;
import org.jivesoftware.smackx.ox.listener.SignElementReceivedListener;
import org.jivesoftware.smackx.ox.listener.SigncryptElementReceivedListener;
import org.jivesoftware.smackx.ox.store.definition.OpenPgpStore;
import org.jivesoftware.smackx.ox.store.definition.OpenPgpTrustStore;
import org.jivesoftware.smackx.ox.util.OpenPgpPubSubUtil;
import org.jivesoftware.smackx.ox.util.SecretKeyBackupHelper;
import org.jivesoftware.smackx.pep.PepEventListener;
import org.jivesoftware.smackx.pep.PepManager;
import org.jivesoftware.smackx.pubsub.PubSubException;
import org.jivesoftware.smackx.pubsub.PubSubFeature;
import org.jxmpp.jid.BareJid;
import org.jxmpp.jid.EntityBareJid;

public final class OpenPgpManager extends Manager {
    private static final Map<XMPPConnection, OpenPgpManager> INSTANCES = new WeakHashMap();
    /* access modifiers changed from: private */
    public static final Logger LOGGER = Logger.getLogger(OpenPgpManager.class.getName());
    /* access modifiers changed from: private */
    public final Set<CryptElementReceivedListener> cryptElementReceivedListeners = new HashSet();
    private final PepManager pepManager;
    private final PepEventListener<PublicKeysListElement> pepPublicKeyListElementListener = new a(this);
    private OpenPgpProvider provider;
    /* access modifiers changed from: private */
    public final Set<SignElementReceivedListener> signElementReceivedListeners = new HashSet();
    /* access modifiers changed from: private */
    public final Set<SigncryptElementReceivedListener> signcryptElementReceivedListeners = new HashSet();

    private OpenPgpManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        ChatManager.getInstanceFor(xMPPConnection).addIncomingListener(new b(this));
        this.pepManager = PepManager.getInstanceFor(xMPPConnection);
    }

    private PubkeyElement createPubkeyElement(BareJid bareJid, a aVar, Date date) throws MissingOpenPgpKeyException, IOException, PGPException {
        PGPPublicKeyRing publicKeyRing = this.provider.getStore().getPublicKeyRing(bareJid, aVar);
        if (publicKeyRing != null) {
            return createPubkeyElement(publicKeyRing.getEncoded(true), date);
        }
        throw new MissingOpenPgpKeyException(bareJid, aVar);
    }

    public static synchronized OpenPgpManager getInstanceFor(XMPPConnection xMPPConnection) {
        OpenPgpManager openPgpManager;
        synchronized (OpenPgpManager.class) {
            Map<XMPPConnection, OpenPgpManager> map = INSTANCES;
            openPgpManager = map.get(xMPPConnection);
            if (openPgpManager == null) {
                openPgpManager = new OpenPgpManager(xMPPConnection);
                map.put(xMPPConnection, openPgpManager);
            }
        }
        return openPgpManager;
    }

    private void importKeyRing(BareJid bareJid, fn.a aVar) throws IOException, PGPException {
        try {
            this.provider.getStore().importSecretKey(bareJid, aVar.b());
            this.provider.getStore().importPublicKey(bareJid, aVar.a());
        } catch (MissingUserIdOnKeyException e10) {
            throw new AssertionError(e10);
        }
    }

    /* access modifiers changed from: private */
    public void incomingChatMessageListener(final EntityBareJid entityBareJid, final Message message, Chat chat) {
        Async.go(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:22:0x0058  */
            /* JADX WARNING: Removed duplicated region for block: B:27:0x007c  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r8 = this;
                    org.jivesoftware.smack.packet.Message r0 = r2
                    java.lang.Class<org.jivesoftware.smackx.ox.element.OpenPgpElement> r1 = org.jivesoftware.smackx.ox.element.OpenPgpElement.class
                    org.jivesoftware.smack.packet.ExtensionElement r0 = r0.getExtension(r1)
                    org.jivesoftware.smackx.ox.element.OpenPgpElement r0 = (org.jivesoftware.smackx.ox.element.OpenPgpElement) r0
                    if (r0 != 0) goto L_0x000d
                    return
                L_0x000d:
                    org.jivesoftware.smackx.ox.OpenPgpManager r1 = org.jivesoftware.smackx.ox.OpenPgpManager.this
                    org.jxmpp.jid.EntityBareJid r2 = r1
                    org.jivesoftware.smackx.ox.OpenPgpContact r1 = r1.getOpenPgpContact(r2)
                    r2 = 0
                    org.jivesoftware.smackx.ox.OpenPgpManager r3 = org.jivesoftware.smackx.ox.OpenPgpManager.this     // Catch:{ PGPException -> 0x0047, XmlPullParserException -> 0x0039, IOException -> 0x0037, NotLoggedInException -> 0x0029 }
                    org.jivesoftware.smackx.ox.OpenPgpMessage r0 = r3.decryptOpenPgpElement(r0, r1)     // Catch:{ PGPException -> 0x0047, XmlPullParserException -> 0x0039, IOException -> 0x0037, NotLoggedInException -> 0x0029 }
                    org.jivesoftware.smackx.ox.element.OpenPgpContentElement r2 = r0.getOpenPgpContentElement()     // Catch:{ PGPException -> 0x0027, XmlPullParserException -> 0x0025, IOException -> 0x0023, NotLoggedInException -> 0x0021 }
                    goto L_0x0054
                L_0x0021:
                    r3 = move-exception
                    goto L_0x002b
                L_0x0023:
                    r3 = move-exception
                    goto L_0x003b
                L_0x0025:
                    r3 = move-exception
                    goto L_0x003b
                L_0x0027:
                    r3 = move-exception
                    goto L_0x0049
                L_0x0029:
                    r3 = move-exception
                    r0 = r2
                L_0x002b:
                    java.util.logging.Logger r4 = org.jivesoftware.smackx.ox.OpenPgpManager.LOGGER
                    java.util.logging.Level r5 = java.util.logging.Level.WARNING
                    java.lang.String r6 = "Cannot determine our JID, since we are not logged in."
                    r4.log(r5, r6, r3)
                    goto L_0x0054
                L_0x0037:
                    r3 = move-exception
                    goto L_0x003a
                L_0x0039:
                    r3 = move-exception
                L_0x003a:
                    r0 = r2
                L_0x003b:
                    java.util.logging.Logger r4 = org.jivesoftware.smackx.ox.OpenPgpManager.LOGGER
                    java.util.logging.Level r5 = java.util.logging.Level.WARNING
                    java.lang.String r6 = "Invalid XML content of incoming OpenPGP encrypted message"
                    r4.log(r5, r6, r3)
                    goto L_0x0054
                L_0x0047:
                    r3 = move-exception
                    r0 = r2
                L_0x0049:
                    java.util.logging.Logger r4 = org.jivesoftware.smackx.ox.OpenPgpManager.LOGGER
                    java.util.logging.Level r5 = java.util.logging.Level.WARNING
                    java.lang.String r6 = "Could not decrypt incoming OpenPGP encrypted message"
                    r4.log(r5, r6, r3)
                L_0x0054:
                    boolean r3 = r2 instanceof org.jivesoftware.smackx.ox.element.SigncryptElement
                    if (r3 == 0) goto L_0x007c
                    org.jivesoftware.smackx.ox.OpenPgpManager r3 = org.jivesoftware.smackx.ox.OpenPgpManager.this
                    java.util.Set r3 = r3.signcryptElementReceivedListeners
                    java.util.Iterator r3 = r3.iterator()
                L_0x0062:
                    boolean r4 = r3.hasNext()
                    if (r4 == 0) goto L_0x007b
                    java.lang.Object r4 = r3.next()
                    org.jivesoftware.smackx.ox.listener.SigncryptElementReceivedListener r4 = (org.jivesoftware.smackx.ox.listener.SigncryptElementReceivedListener) r4
                    org.jivesoftware.smack.packet.Message r5 = r2
                    r6 = r2
                    org.jivesoftware.smackx.ox.element.SigncryptElement r6 = (org.jivesoftware.smackx.ox.element.SigncryptElement) r6
                    cn.k r7 = r0.getMetadata()
                    r4.signcryptElementReceived(r1, r5, r6, r7)
                    goto L_0x0062
                L_0x007b:
                    return
                L_0x007c:
                    boolean r3 = r2 instanceof org.jivesoftware.smackx.ox.element.SignElement
                    if (r3 == 0) goto L_0x00a4
                    org.jivesoftware.smackx.ox.OpenPgpManager r3 = org.jivesoftware.smackx.ox.OpenPgpManager.this
                    java.util.Set r3 = r3.signElementReceivedListeners
                    java.util.Iterator r3 = r3.iterator()
                L_0x008a:
                    boolean r4 = r3.hasNext()
                    if (r4 == 0) goto L_0x00a3
                    java.lang.Object r4 = r3.next()
                    org.jivesoftware.smackx.ox.listener.SignElementReceivedListener r4 = (org.jivesoftware.smackx.ox.listener.SignElementReceivedListener) r4
                    org.jivesoftware.smack.packet.Message r5 = r2
                    r6 = r2
                    org.jivesoftware.smackx.ox.element.SignElement r6 = (org.jivesoftware.smackx.ox.element.SignElement) r6
                    cn.k r7 = r0.getMetadata()
                    r4.signElementReceived(r1, r5, r6, r7)
                    goto L_0x008a
                L_0x00a3:
                    return
                L_0x00a4:
                    boolean r3 = r2 instanceof org.jivesoftware.smackx.ox.element.CryptElement
                    if (r3 == 0) goto L_0x00cc
                    org.jivesoftware.smackx.ox.OpenPgpManager r3 = org.jivesoftware.smackx.ox.OpenPgpManager.this
                    java.util.Set r3 = r3.cryptElementReceivedListeners
                    java.util.Iterator r3 = r3.iterator()
                L_0x00b2:
                    boolean r4 = r3.hasNext()
                    if (r4 == 0) goto L_0x00cb
                    java.lang.Object r4 = r3.next()
                    org.jivesoftware.smackx.ox.listener.CryptElementReceivedListener r4 = (org.jivesoftware.smackx.ox.listener.CryptElementReceivedListener) r4
                    org.jivesoftware.smack.packet.Message r5 = r2
                    r6 = r2
                    org.jivesoftware.smackx.ox.element.CryptElement r6 = (org.jivesoftware.smackx.ox.element.CryptElement) r6
                    cn.k r7 = r0.getMetadata()
                    r4.cryptElementReceived(r1, r5, r6, r7)
                    goto L_0x00b2
                L_0x00cb:
                    return
                L_0x00cc:
                    java.lang.AssertionError r0 = new java.lang.AssertionError
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r3 = "Invalid element received: "
                    r1.append(r3)
                    java.lang.Class r2 = r2.getClass()
                    java.lang.String r2 = r2.getName()
                    r1.append(r2)
                    java.lang.String r1 = r1.toString()
                    r0.<init>(r1)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.ox.OpenPgpManager.AnonymousClass1.run():void");
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(EntityBareJid entityBareJid, PublicKeysListElement publicKeysListElement, String str, Message message) {
        processPublicKeysListElement(entityBareJid, publicKeysListElement);
    }

    private void processPublicKeysListElement(BareJid bareJid, PublicKeysListElement publicKeysListElement) {
        try {
            getOpenPgpContact(bareJid.h1()).updateKeys(connection(), publicKeysListElement);
        } catch (Exception e10) {
            LOGGER.log(Level.WARNING, "Could not update contacts keys", e10);
        }
    }

    public static boolean serverSupportsSecretKeyBackups(XMPPConnection xMPPConnection) throws XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException, SmackException.NoResponseException {
        return ServiceDiscoveryManager.getInstanceFor(xMPPConnection).serverSupportsFeature(PubSubFeature.access_whitelist.toString());
    }

    private void throwIfNoProviderSet() {
        if (this.provider == null) {
            throw new IllegalStateException("No OpenPgpProvider set!");
        }
    }

    private void throwIfNotAuthenticated() throws SmackException.NotLoggedInException {
        if (!connection().isAuthenticated()) {
            throw new SmackException.NotLoggedInException();
        }
    }

    public void announceSupportAndPublish() throws NoSuchAlgorithmException, NoSuchProviderException, InterruptedException, PubSubException.NotALeafNodeException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, SmackException.NoResponseException, IOException, InvalidAlgorithmParameterException, SmackException.NotLoggedInException, PGPException {
        throwIfNoProviderSet();
        throwIfNotAuthenticated();
        a ourFingerprint = getOurFingerprint();
        if (ourFingerprint == null) {
            ourFingerprint = generateAndImportKeyPair(getJidOrThrow());
        }
        try {
            OpenPgpPubSubUtil.publishPublicKey(this.pepManager, createPubkeyElement(getJidOrThrow(), ourFingerprint, new Date()), ourFingerprint);
            this.pepManager.addPepEventListener(OpenPgpPubSubUtil.PEP_NODE_PUBLIC_KEYS, PublicKeysListElement.class, this.pepPublicKeyListElementListener);
            ServiceDiscoveryManager.getInstanceFor(connection()).addFeature(OpenPgpPubSubUtil.PEP_NODE_PUBLIC_KEYS_NOTIFY);
        } catch (MissingOpenPgpKeyException unused) {
            throw new AssertionError("Cannot publish our public key, since it is missing (MUST NOT happen!)");
        }
    }

    public OpenPgpSecretKeyBackupPassphrase backupSecretKeyToServer(SecretKeyBackupSelectionCallback secretKeyBackupSelectionCallback) throws InterruptedException, PubSubException.NotALeafNodeException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, SmackException.NoResponseException, SmackException.NotLoggedInException, IOException, SmackException.FeatureNotSupportedException, PGPException, MissingOpenPgpKeyException {
        OpenPgpSecretKeyBackupPassphrase generateBackupPassword = SecretKeyBackupHelper.generateBackupPassword();
        backupSecretKeyToServer(secretKeyBackupSelectionCallback, generateBackupPassword);
        return generateBackupPassword;
    }

    public OpenPgpMessage decryptOpenPgpElement(OpenPgpElement openPgpElement, OpenPgpContact openPgpContact) throws SmackException.NotLoggedInException, IOException, PGPException {
        return this.provider.decryptAndOrVerify(getAuthenticatedConnectionOrThrow(), openPgpElement, getOpenPgpSelf(), openPgpContact);
    }

    public void deleteSecretKeyServerBackup() throws XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException, SmackException.NoResponseException, SmackException.NotLoggedInException {
        throwIfNotAuthenticated();
        OpenPgpPubSubUtil.deleteSecretKeyNode(this.pepManager);
    }

    public a generateAndImportKeyPair(BareJid bareJid) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchProviderException, PGPException, IOException {
        throwIfNoProviderSet();
        OpenPgpStore store = this.provider.getStore();
        fn.a generateKeyRing = generateKeyRing(bareJid);
        importKeyRing(bareJid, generateKeyRing);
        a aVar = new a(generateKeyRing.b());
        store.setTrust(bareJid, aVar, OpenPgpTrustStore.Trust.trusted);
        return aVar;
    }

    public fn.a generateKeyRing(BareJid bareJid) throws PGPException, NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        throwIfNoProviderSet();
        return this.provider.getStore().generateKeyRing(bareJid);
    }

    public BareJid getJidOrThrow() throws SmackException.NotLoggedInException {
        throwIfNotAuthenticated();
        return connection().getUser().S();
    }

    public OpenPgpContact getOpenPgpContact(EntityBareJid entityBareJid) {
        throwIfNoProviderSet();
        return this.provider.getStore().getOpenPgpContact(entityBareJid);
    }

    public OpenPgpProvider getOpenPgpProvider() {
        return this.provider;
    }

    public OpenPgpSelf getOpenPgpSelf() throws SmackException.NotLoggedInException {
        throwIfNoProviderSet();
        return new OpenPgpSelf(getJidOrThrow(), this.provider.getStore());
    }

    public a getOurFingerprint() throws SmackException.NotLoggedInException, IOException, PGPException {
        return getOpenPgpSelf().getSigningKeyFingerprint();
    }

    public boolean hasSecretKeysAvailable() throws SmackException.NotLoggedInException, PGPException, IOException {
        throwIfNoProviderSet();
        return getOpenPgpSelf().hasSecretKeyAvailable();
    }

    /* access modifiers changed from: package-private */
    public void registerCryptElementReceivedListener(CryptElementReceivedListener cryptElementReceivedListener) {
        this.cryptElementReceivedListeners.add(cryptElementReceivedListener);
    }

    /* access modifiers changed from: package-private */
    public void registerSignElementReceivedListener(SignElementReceivedListener signElementReceivedListener) {
        this.signElementReceivedListeners.add(signElementReceivedListener);
    }

    public void registerSigncryptReceivedListener(SigncryptElementReceivedListener signcryptElementReceivedListener) {
        this.signcryptElementReceivedListeners.add(signcryptElementReceivedListener);
    }

    public a restoreSecretKeyServerBackup(AskForBackupCodeCallback askForBackupCodeCallback) throws InterruptedException, PubSubException.NotALeafNodeException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, SmackException.NoResponseException, InvalidBackupCodeException, SmackException.NotLoggedInException, IOException, MissingUserIdOnKeyException, NoBackupFoundException, PGPException {
        throwIfNoProviderSet();
        throwIfNotAuthenticated();
        SecretkeyElement fetchSecretKey = OpenPgpPubSubUtil.fetchSecretKey(this.pepManager);
        if (fetchSecretKey != null) {
            PGPSecretKeyRing restoreSecretKeyBackup = SecretKeyBackupHelper.restoreSecretKeyBackup(fetchSecretKey, askForBackupCodeCallback.askForBackupCode());
            a aVar = new a(restoreSecretKeyBackup);
            this.provider.getStore().importSecretKey(getJidOrThrow(), restoreSecretKeyBackup);
            this.provider.getStore().importPublicKey(getJidOrThrow(), qn.a.c(restoreSecretKeyBackup));
            getOpenPgpSelf().trust(aVar);
            return new a(restoreSecretKeyBackup);
        }
        throw new NoBackupFoundException();
    }

    public void setOpenPgpProvider(OpenPgpProvider openPgpProvider) {
        this.provider = openPgpProvider;
    }

    public void stopMetadataListener() {
        this.pepManager.removePepEventListener(this.pepPublicKeyListElementListener);
    }

    /* access modifiers changed from: package-private */
    public void unregisterCryptElementReceivedListener(CryptElementReceivedListener cryptElementReceivedListener) {
        this.cryptElementReceivedListeners.remove(cryptElementReceivedListener);
    }

    /* access modifiers changed from: package-private */
    public void unregisterSignElementReceivedListener(SignElementReceivedListener signElementReceivedListener) {
        this.signElementReceivedListeners.remove(signElementReceivedListener);
    }

    /* access modifiers changed from: package-private */
    public void unregisterSigncryptElementReceivedListener(SigncryptElementReceivedListener signcryptElementReceivedListener) {
        this.signcryptElementReceivedListeners.remove(signcryptElementReceivedListener);
    }

    public void backupSecretKeyToServer(SecretKeyBackupSelectionCallback secretKeyBackupSelectionCallback, OpenPgpSecretKeyBackupPassphrase openPgpSecretKeyBackupPassphrase) throws InterruptedException, PubSubException.NotALeafNodeException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, SmackException.NoResponseException, SmackException.NotLoggedInException, IOException, SmackException.FeatureNotSupportedException, PGPException, MissingOpenPgpKeyException {
        throwIfNoProviderSet();
        throwIfNotAuthenticated();
        BareJid i12 = connection().getUser().i1();
        PGPSecretKeyRingCollection secretKeysOf = this.provider.getStore().getSecretKeysOf(i12);
        HashSet hashSet = new HashSet();
        Iterator it = secretKeysOf.iterator();
        while (it.hasNext()) {
            hashSet.add(new a((PGPSecretKeyRing) it.next()));
        }
        OpenPgpPubSubUtil.depositSecretKey(connection(), SecretKeyBackupHelper.createSecretkeyElement(this.provider, i12, secretKeyBackupSelectionCallback.selectKeysToBackup(hashSet), openPgpSecretKeyBackupPassphrase));
    }

    private static PubkeyElement createPubkeyElement(byte[] bArr, Date date) {
        return new PubkeyElement(new PubkeyElement.PubkeyDataElement(Base64.encodeToString(bArr)), date);
    }
}
