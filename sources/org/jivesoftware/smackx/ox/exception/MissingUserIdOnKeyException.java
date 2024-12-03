package org.jivesoftware.smackx.ox.exception;

import en.a;
import org.jxmpp.jid.BareJid;

public class MissingUserIdOnKeyException extends Exception {
    private static final long serialVersionUID = 1;

    public MissingUserIdOnKeyException(BareJid bareJid, a aVar) {
        super("Key " + aVar.toString() + " does not have a user-id of \"xmpp:" + bareJid.toString() + "\".");
    }
}
