package org.jivesoftware.smackx.ox.callback.backup;

import en.a;
import java.util.Set;

public interface SecretKeyBackupSelectionCallback {
    Set<a> selectKeysToBackup(Set<a> set);
}
