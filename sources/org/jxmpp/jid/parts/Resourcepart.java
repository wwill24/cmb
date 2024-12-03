package org.jxmpp.jid.parts;

import org.jxmpp.a;
import org.jxmpp.stringprep.XmppStringprepException;

public class Resourcepart extends Part {

    /* renamed from: a  reason: collision with root package name */
    public static final Resourcepart f24273a = new Resourcepart("");
    private static final long serialVersionUID = 1;

    private Resourcepart(String str) {
        super(str);
    }

    public static Resourcepart b(String str) throws XmppStringprepException {
        return c(str, a.b());
    }

    public static Resourcepart c(String str, a aVar) throws XmppStringprepException {
        String c10 = jm.a.c(str, aVar);
        Part.a(c10);
        return new Resourcepart(c10);
    }
}
