package org.minidns.dnslabel;

import java.util.Locale;
import xm.c;

public abstract class j extends h {
    static {
        Class<j> cls = j.class;
    }

    protected j(String str) {
        super(str);
    }

    protected static c i(String str) {
        if (str.equals(c.b(str))) {
            return new b(str);
        }
        return new a(str);
    }

    static boolean o(String str) {
        return str.substring(0, 2).toLowerCase(Locale.US).equals("xn");
    }
}
