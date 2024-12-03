package org.jxmpp.jid.parts;

import org.jxmpp.a;
import org.jxmpp.stringprep.XmppStringprepException;

public class Domainpart extends Part {
    private static final long serialVersionUID = 1;

    private Domainpart(String str) {
        super(str);
    }

    public static Domainpart b(String str, a aVar) throws XmppStringprepException {
        if (str != null) {
            if (str.length() > 0 && str.charAt(str.length() - 1) == '.') {
                str = str.substring(0, str.length() - 1);
            }
            String a10 = jm.a.a(str, aVar);
            Part.a(a10);
            return new Domainpart(a10);
        }
        throw new XmppStringprepException(str, "Input 'domain' must not be null");
    }
}
