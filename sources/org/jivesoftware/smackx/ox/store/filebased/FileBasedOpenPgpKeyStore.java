package org.jivesoftware.smackx.ox.store.filebased;

import en.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection;
import org.jivesoftware.smack.util.CloseableUtil;
import org.jivesoftware.smack.util.FileUtils;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smackx.ox.store.abstr.AbstractOpenPgpKeyStore;
import org.jxmpp.jid.BareJid;

public class FileBasedOpenPgpKeyStore extends AbstractOpenPgpKeyStore {
    private static final String FETCH_DATES = "fetchDates.list";
    private static final String PUB_RING = "pubring.pkr";
    private static final String SEC_RING = "secring.skr";
    private final File basePath;

    public FileBasedOpenPgpKeyStore(File file) {
        this.basePath = (File) Objects.requireNonNull(file);
    }

    private File getFetchDatesPath(BareJid bareJid) {
        return new File(FileBasedOpenPgpStore.getContactsPath(this.basePath, bareJid), FETCH_DATES);
    }

    private File getPublicKeyRingPath(BareJid bareJid) {
        return new File(FileBasedOpenPgpStore.getContactsPath(this.basePath, bareJid), PUB_RING);
    }

    private File getSecretKeyRingPath(BareJid bareJid) {
        return new File(FileBasedOpenPgpStore.getContactsPath(this.basePath, bareJid), SEC_RING);
    }

    /* access modifiers changed from: protected */
    public Map<a, Date> readKeyFetchDates(BareJid bareJid) throws IOException {
        return FileBasedOpenPgpMetadataStore.readFingerprintsAndDates(getFetchDatesPath(bareJid));
    }

    public PGPPublicKeyRingCollection readPublicKeysOf(BareJid bareJid) throws IOException, PGPException {
        File publicKeyRingPath = getPublicKeyRingPath(bareJid);
        if (!publicKeyRingPath.exists()) {
            return null;
        }
        FileInputStream prepareFileInputStream = FileUtils.prepareFileInputStream(publicKeyRingPath);
        PGPPublicKeyRingCollection a10 = an.a.f().a(prepareFileInputStream);
        prepareFileInputStream.close();
        return a10;
    }

    public PGPSecretKeyRingCollection readSecretKeysOf(BareJid bareJid) throws IOException, PGPException {
        File secretKeyRingPath = getSecretKeyRingPath(bareJid);
        if (!secretKeyRingPath.exists()) {
            return null;
        }
        FileInputStream prepareFileInputStream = FileUtils.prepareFileInputStream(secretKeyRingPath);
        PGPSecretKeyRingCollection g10 = an.a.f().g(prepareFileInputStream);
        prepareFileInputStream.close();
        return g10;
    }

    /* access modifiers changed from: protected */
    public void writeKeyFetchDates(BareJid bareJid, Map<a, Date> map) throws IOException {
        FileBasedOpenPgpMetadataStore.writeFingerprintsAndDates(map, getFetchDatesPath(bareJid));
    }

    public void writePublicKeysOf(BareJid bareJid, PGPPublicKeyRingCollection pGPPublicKeyRingCollection) throws IOException {
        File publicKeyRingPath = getPublicKeyRingPath(bareJid);
        if (pGPPublicKeyRingCollection == null) {
            FileUtils.maybeDeleteFileOrThrow(publicKeyRingPath);
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = FileUtils.prepareFileOutputStream(publicKeyRingPath);
            pGPPublicKeyRingCollection.encode(fileOutputStream);
        } finally {
            CloseableUtil.maybeClose(fileOutputStream, AbstractOpenPgpKeyStore.LOGGER);
        }
    }

    public void writeSecretKeysOf(BareJid bareJid, PGPSecretKeyRingCollection pGPSecretKeyRingCollection) throws IOException {
        File secretKeyRingPath = getSecretKeyRingPath(bareJid);
        if (pGPSecretKeyRingCollection == null) {
            FileUtils.maybeDeleteFileOrThrow(secretKeyRingPath);
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = FileUtils.prepareFileOutputStream(secretKeyRingPath);
            pGPSecretKeyRingCollection.encode(fileOutputStream);
        } finally {
            CloseableUtil.maybeClose(fileOutputStream, AbstractOpenPgpKeyStore.LOGGER);
        }
    }
}
