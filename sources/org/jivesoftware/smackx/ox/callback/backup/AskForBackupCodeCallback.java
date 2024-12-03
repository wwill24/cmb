package org.jivesoftware.smackx.ox.callback.backup;

import org.jivesoftware.smackx.ox.OpenPgpSecretKeyBackupPassphrase;

public interface AskForBackupCodeCallback {
    OpenPgpSecretKeyBackupPassphrase askForBackupCode();
}
