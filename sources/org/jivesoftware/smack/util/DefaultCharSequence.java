package org.jivesoftware.smack.util;

public interface DefaultCharSequence extends CharSequence {
    char charAt(int i10) {
        return toString().charAt(i10);
    }

    int length() {
        return toString().length();
    }

    CharSequence subSequence(int i10, int i11) {
        return toString().subSequence(i10, i11);
    }
}
