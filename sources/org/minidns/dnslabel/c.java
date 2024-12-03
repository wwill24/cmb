package org.minidns.dnslabel;

public abstract class c extends DnsLabel {
    static {
        Class<c> cls = c.class;
    }

    protected c(String str) {
        super(str);
    }

    protected static c i(String str) {
        if (!h.k(str)) {
            return new f(str);
        }
        if (j.o(str)) {
            return j.i(str);
        }
        return new h(str);
    }

    public static boolean j(String str) {
        if (str.isEmpty() || d.j(str)) {
            return false;
        }
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && ((charAt < '0' || charAt > '9') && charAt != '-'))) {
                return false;
            }
        }
        return true;
    }
}
