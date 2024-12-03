package org.jxmpp.jid.parts;

import org.jxmpp.a;
import org.jxmpp.stringprep.XmppStringprepException;

public class Localpart extends Part {
    private static final long serialVersionUID = 1;

    private Localpart(String str) {
        super(str);
    }

    public static Localpart b(String str, a aVar) throws XmppStringprepException {
        String b10 = jm.a.b(str, aVar);
        Part.a(b10);
        return new Localpart(b10);
    }
}
