package org.jivesoftware.smack.util.stringencoder;

import org.jxmpp.jid.BareJid;
import org.jxmpp.jid.impl.a;
import org.jxmpp.stringprep.XmppStringprepException;

public abstract class BareJidEncoder implements StringEncoder<BareJid> {

    @Deprecated
    public static class LegacyEncoder extends BareJidEncoder {
        public BareJid decode(String str) {
            try {
                return a.b(str);
            } catch (XmppStringprepException e10) {
                throw new IllegalArgumentException("BareJid cannot be decoded.", e10);
            }
        }

        public String encode(BareJid bareJid) {
            return bareJid.toString();
        }
    }

    public static class UrlSafeEncoder extends BareJidEncoder {
        public BareJid decode(String str) {
            try {
                return a.d(str);
            } catch (XmppStringprepException e10) {
                throw new IllegalArgumentException("BareJid cannot be decoded.", e10);
            }
        }

        public String encode(BareJid bareJid) {
            return bareJid.c0();
        }
    }
}
