package org.jxmpp.stringprep;

import java.io.IOException;

public class XmppStringprepException extends IOException {
    private static final long serialVersionUID = -8491853210107124624L;
    private final String causingString;

    public static class MissingDomainpart extends XmppStringprepException {
        private static final long serialVersionUID = 1;

        private MissingDomainpart(String str) {
            super(str, "The provided string does not have a domainpart");
        }

        public static MissingDomainpart a(String str, String str2) {
            StringBuilder sb2 = new StringBuilder();
            if (str != null) {
                sb2.append(str);
                sb2.append('@');
            }
            if (str2 != null) {
                sb2.append('/');
                sb2.append(str2);
            }
            return new MissingDomainpart(sb2.toString());
        }
    }

    public XmppStringprepException(String str, Exception exc) {
        super("XmppStringprepException caused by '" + str + "': " + exc);
        initCause(exc);
        this.causingString = str;
    }

    public XmppStringprepException(String str, String str2) {
        super(str2);
        this.causingString = str;
    }
}
