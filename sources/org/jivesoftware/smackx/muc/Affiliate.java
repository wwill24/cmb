package org.jivesoftware.smackx.muc;

import org.jivesoftware.smackx.muc.packet.MUCItem;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.parts.Resourcepart;

public class Affiliate {
    private final MUCAffiliation affiliation;
    private final Jid jid;
    private final Resourcepart nick;
    private final MUCRole role;

    Affiliate(MUCItem mUCItem) {
        this.jid = mUCItem.getJid();
        this.affiliation = mUCItem.getAffiliation();
        this.role = mUCItem.getRole();
        this.nick = mUCItem.getNick();
    }

    public MUCAffiliation getAffiliation() {
        return this.affiliation;
    }

    public Jid getJid() {
        return this.jid;
    }

    public Resourcepart getNick() {
        return this.nick;
    }

    public MUCRole getRole() {
        return this.role;
    }
}
