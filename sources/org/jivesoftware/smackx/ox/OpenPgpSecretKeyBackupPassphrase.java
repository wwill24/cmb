package org.jivesoftware.smackx.ox;

import java.util.regex.Pattern;

public class OpenPgpSecretKeyBackupPassphrase implements CharSequence {
    private static final Pattern PASSPHRASE_PATTERN = Pattern.compile("^([123456789ABCDEFGHIJKLMNPQRSTUVWXYZ]{4}-){5}[123456789ABCDEFGHIJKLMNPQRSTUVWXYZ]{4}$");
    private final String passphrase;

    public OpenPgpSecretKeyBackupPassphrase(String str) {
        if (PASSPHRASE_PATTERN.matcher(str).matches()) {
            this.passphrase = str;
            return;
        }
        throw new IllegalArgumentException("Passphrase must be 24 upper case letters and numbers from the english alphabet without 'O' and '0', divided into blocks of 4 and separated with dashes ('-').");
    }

    public char charAt(int i10) {
        return this.passphrase.charAt(i10);
    }

    public int length() {
        return this.passphrase.length();
    }

    public CharSequence subSequence(int i10, int i11) {
        return this.passphrase.subSequence(i10, i11);
    }

    public String toString() {
        return this.passphrase;
    }
}
