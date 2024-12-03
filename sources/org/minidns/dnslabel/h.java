package org.minidns.dnslabel;

public class h extends c {
    static {
        Class<h> cls = h.class;
    }

    protected h(String str) {
        super(str);
    }

    public static boolean k(String str) {
        if (!c.j(str)) {
            return false;
        }
        return l(str);
    }

    static boolean l(String str) {
        if (str.length() >= 4 && str.charAt(2) == '-' && str.charAt(3) == '-') {
            return true;
        }
        return false;
    }
}
