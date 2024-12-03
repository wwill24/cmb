package org.jivesoftware.smackx.ox.exception;

import en.a;
import org.jxmpp.jid.BareJid;

public class MissingOpenPgpKeyException extends Exception {
    private static final long serialVersionUID = 1;
    private final a fingerprint;
    private final BareJid owner;

    public MissingOpenPgpKeyException(BareJid bareJid, a aVar) {
        super("Missing key " + aVar.toString() + " for owner " + bareJid + ".");
        this.owner = bareJid;
        this.fingerprint = aVar;
    }

    public a getFingerprint() {
        return this.fingerprint;
    }

    public BareJid getOwner() {
        return this.owner;
    }

    public MissingOpenPgpKeyException(BareJid bareJid, a aVar, Throwable th2) {
        super("Missing key " + aVar.toString() + " for owner " + bareJid + ".", th2);
        this.owner = bareJid;
        this.fingerprint = aVar;
    }
}
