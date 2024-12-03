package org.minidns.dnslabel;

public final class d extends e {
    protected d(String str) {
        super(str);
    }

    protected static boolean j(String str) {
        if (str.isEmpty()) {
            return false;
        }
        if (str.charAt(0) == '-' || str.charAt(str.length() - 1) == '-') {
            return true;
        }
        return false;
    }
}
