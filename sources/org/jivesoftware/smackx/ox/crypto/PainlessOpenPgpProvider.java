package org.jivesoftware.smackx.ox.crypto;

import an.a;
import cn.f;
import cn.i;
import cn.k;
import dn.g;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.util.io.Streams;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.stringencoder.Base64;
import org.jivesoftware.smackx.ox.OpenPgpContact;
import org.jivesoftware.smackx.ox.OpenPgpMessage;
import org.jivesoftware.smackx.ox.OpenPgpSelf;
import org.jivesoftware.smackx.ox.element.CryptElement;
import org.jivesoftware.smackx.ox.element.OpenPgpElement;
import org.jivesoftware.smackx.ox.element.SignElement;
import org.jivesoftware.smackx.ox.element.SigncryptElement;
import org.jivesoftware.smackx.ox.store.definition.OpenPgpStore;

public class PainlessOpenPgpProvider implements OpenPgpProvider {
    /* access modifiers changed from: private */
    public static final Logger LOGGER = Logger.getLogger(PainlessOpenPgpProvider.class.getName());
    private final OpenPgpStore store;

    public PainlessOpenPgpProvider(OpenPgpStore openPgpStore) {
        this.store = (OpenPgpStore) Objects.requireNonNull(openPgpStore);
    }

    public OpenPgpMessage decryptAndOrVerify(final XMPPConnection xMPPConnection, OpenPgpElement openPgpElement, OpenPgpSelf openPgpSelf, final OpenPgpContact openPgpContact) throws IOException, PGPException {
        OpenPgpMessage.State state;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream inputStream = openPgpElement.toInputStream();
        PGPPublicKeyRingCollection announcedPublicKeys = openPgpContact.getAnnouncedPublicKeys();
        if (announcedPublicKeys == null) {
            Logger logger = LOGGER;
            Level level = Level.INFO;
            logger.log(level, "Received a message from " + openPgpContact.getJid() + " but we have no keys yet. Try fetching them.");
            try {
                openPgpContact.updateKeys(xMPPConnection);
                announcedPublicKeys = openPgpContact.getAnnouncedPublicKeys();
            } catch (Exception e10) {
                Logger logger2 = LOGGER;
                Level level2 = Level.SEVERE;
                logger2.log(level2, "Fetching keys of " + openPgpContact.getJid() + " failed. Abort decryption and discard message.", e10);
                throw new PGPException("Abort decryption due to lack of keys.", e10);
            }
        }
        f build = a.a().k(inputStream).a(getStore().getKeyRingProtector(), openPgpSelf.getSecretKeys()).a(announcedPublicKeys).a(new i() {
            public PGPPublicKey onMissingPublicKeyEncountered(Long l10) {
                try {
                    openPgpContact.updateKeys(xMPPConnection);
                    return openPgpContact.getAnyPublicKeys().getPublicKey(l10.longValue());
                } catch (Exception e10) {
                    Logger access$000 = PainlessOpenPgpProvider.LOGGER;
                    Level level = Level.WARNING;
                    access$000.log(level, "Cannot fetch missing key " + l10, e10);
                    return null;
                }
            }
        }).build();
        Streams.pipeAll(build, byteArrayOutputStream);
        inputStream.close();
        build.close();
        byteArrayOutputStream.close();
        k a10 = build.a();
        if (a10.e()) {
            if (a10.d()) {
                state = OpenPgpMessage.State.signcrypt;
            } else {
                state = OpenPgpMessage.State.sign;
            }
        } else if (a10.d()) {
            state = OpenPgpMessage.State.crypt;
        } else {
            throw new PGPException("Received message appears to be neither encrypted, nor signed.");
        }
        return new OpenPgpMessage(byteArrayOutputStream.toByteArray(), state, a10);
    }

    public OpenPgpElementAndMetadata encrypt(CryptElement cryptElement, OpenPgpSelf openPgpSelf, Collection<OpenPgpContact> collection) throws IOException, PGPException {
        InputStream inputStream = cryptElement.toInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ArrayList arrayList = new ArrayList();
        for (OpenPgpContact next : collection) {
            PGPPublicKeyRingCollection trustedAnnouncedKeys = next.getTrustedAnnouncedKeys();
            if (trustedAnnouncedKeys != null) {
                arrayList.add(trustedAnnouncedKeys);
            } else {
                Logger logger = LOGGER;
                Level level = Level.WARNING;
                logger.log(level, "There are no suitable keys for contact " + next.getJid().toString());
            }
        }
        g a10 = a.b().p(byteArrayOutputStream).a((PGPPublicKeyRingCollection[]) arrayList.toArray(new PGPPublicKeyRingCollection[0])).a(openPgpSelf.getTrustedAnnouncedKeys()).b().a().a();
        Streams.pipeAll(inputStream, a10);
        inputStream.close();
        a10.flush();
        a10.close();
        byteArrayOutputStream.close();
        return new OpenPgpElementAndMetadata(new OpenPgpElement(Base64.encodeToString(byteArrayOutputStream.toByteArray())), a10.a());
    }

    public OpenPgpStore getStore() {
        return this.store;
    }

    public OpenPgpElementAndMetadata sign(SignElement signElement, OpenPgpSelf openPgpSelf) throws IOException, PGPException {
        InputStream inputStream = signElement.toInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        g a10 = a.b().p(byteArrayOutputStream).b().b(getStore().getKeyRingProtector(), openPgpSelf.getSigningKeyRing()).a();
        Streams.pipeAll(inputStream, a10);
        inputStream.close();
        a10.flush();
        a10.close();
        byteArrayOutputStream.close();
        return new OpenPgpElementAndMetadata(new OpenPgpElement(Base64.encodeToString(byteArrayOutputStream.toByteArray())), a10.a());
    }

    public OpenPgpElementAndMetadata signAndEncrypt(SigncryptElement signcryptElement, OpenPgpSelf openPgpSelf, Collection<OpenPgpContact> collection) throws IOException, PGPException {
        InputStream inputStream = signcryptElement.toInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ArrayList arrayList = new ArrayList();
        for (OpenPgpContact next : collection) {
            PGPPublicKeyRingCollection trustedAnnouncedKeys = next.getTrustedAnnouncedKeys();
            if (trustedAnnouncedKeys != null) {
                arrayList.add(trustedAnnouncedKeys);
            } else {
                Logger logger = LOGGER;
                Level level = Level.WARNING;
                logger.log(level, "There are no suitable keys for contact " + next.getJid().toString());
            }
        }
        g a10 = a.b().p(byteArrayOutputStream).a((PGPPublicKeyRingCollection[]) arrayList.toArray(new PGPPublicKeyRingCollection[0])).a(openPgpSelf.getTrustedAnnouncedKeys()).b().b(getStore().getKeyRingProtector(), openPgpSelf.getSigningKeyRing()).a();
        Streams.pipeAll(inputStream, a10);
        inputStream.close();
        a10.flush();
        a10.close();
        byteArrayOutputStream.close();
        return new OpenPgpElementAndMetadata(new OpenPgpElement(Base64.encodeToString(byteArrayOutputStream.toByteArray())), a10.a());
    }
}
