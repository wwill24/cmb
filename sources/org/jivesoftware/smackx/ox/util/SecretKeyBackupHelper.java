package org.jivesoftware.smackx.ox.util;

import en.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Set;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.stringencoder.Base64;
import org.jivesoftware.smackx.ox.OpenPgpSecretKeyBackupPassphrase;
import org.jivesoftware.smackx.ox.crypto.OpenPgpProvider;
import org.jivesoftware.smackx.ox.element.SecretkeyElement;
import org.jivesoftware.smackx.ox.exception.InvalidBackupCodeException;
import org.jivesoftware.smackx.ox.exception.MissingOpenPgpKeyException;
import org.jxmpp.jid.BareJid;
import org.pgpainless.algorithm.SymmetricKeyAlgorithm;
import qn.c;

public class SecretKeyBackupHelper {
    public static SecretkeyElement createSecretkeyElement(OpenPgpProvider openPgpProvider, BareJid bareJid, Set<a> set, OpenPgpSecretKeyBackupPassphrase openPgpSecretKeyBackupPassphrase) throws PGPException, IOException, MissingOpenPgpKeyException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (a next : set) {
            PGPSecretKeyRing secretKeyRing = openPgpProvider.getStore().getSecretKeyRing(bareJid, next);
            if (secretKeyRing != null) {
                byteArrayOutputStream.write(secretKeyRing.getEncoded());
            } else {
                throw new MissingOpenPgpKeyException(bareJid, next);
            }
        }
        return createSecretkeyElement(byteArrayOutputStream.toByteArray(), openPgpSecretKeyBackupPassphrase);
    }

    public static OpenPgpSecretKeyBackupPassphrase generateBackupPassword() {
        return new OpenPgpSecretKeyBackupPassphrase(StringUtils.secureOfflineAttackSafeRandomString());
    }

    public static PGPSecretKeyRing restoreSecretKeyBackup(SecretkeyElement secretkeyElement, OpenPgpSecretKeyBackupPassphrase openPgpSecretKeyBackupPassphrase) throws InvalidBackupCodeException, IOException, PGPException {
        try {
            return an.a.f().f(an.a.c(Base64.decode(secretkeyElement.getB64Data()), new c(openPgpSecretKeyBackupPassphrase.toString().toCharArray())));
        } catch (IOException | PGPException e10) {
            throw new InvalidBackupCodeException("Could not decrypt secret key backup. Possibly wrong passphrase?", e10);
        }
    }

    public static SecretkeyElement createSecretkeyElement(byte[] bArr, OpenPgpSecretKeyBackupPassphrase openPgpSecretKeyBackupPassphrase) throws PGPException, IOException {
        return new SecretkeyElement(Base64.encode(an.a.d(bArr, new c(openPgpSecretKeyBackupPassphrase.toString().toCharArray()), SymmetricKeyAlgorithm.AES_256)));
    }
}
