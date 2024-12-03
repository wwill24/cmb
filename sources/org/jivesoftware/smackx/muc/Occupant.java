package org.jivesoftware.smackx.muc;

import java.util.logging.Logger;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smackx.muc.packet.MUCItem;
import org.jivesoftware.smackx.muc.packet.MUCUser;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.parts.Resourcepart;

public class Occupant {
    private static final Logger LOGGER = Logger.getLogger(Occupant.class.getName());
    private final MUCAffiliation affiliation;
    private final Jid jid;
    private final Resourcepart nick;
    private final MUCRole role;

    Occupant(MUCItem mUCItem) {
        this.jid = mUCItem.getJid();
        this.affiliation = mUCItem.getAffiliation();
        this.role = mUCItem.getRole();
        this.nick = mUCItem.getNick();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Occupant)) {
            return false;
        }
        return this.jid.Y(((Occupant) obj).jid);
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

    public int hashCode() {
        int i10;
        int hashCode = ((this.affiliation.hashCode() * 17) + this.role.hashCode()) * 17;
        Jid jid2 = this.jid;
        int i11 = 0;
        if (jid2 != null) {
            i10 = jid2.hashCode();
        } else {
            i10 = 0;
        }
        int i12 = (hashCode + i10) * 17;
        Resourcepart resourcepart = this.nick;
        if (resourcepart != null) {
            i11 = resourcepart.hashCode();
        }
        return i12 + i11;
    }

    Occupant(Presence presence) {
        MUCItem item = ((MUCUser) presence.getExtensionElement("x", MUCUser.NAMESPACE)).getItem();
        this.jid = item.getJid();
        this.affiliation = item.getAffiliation();
        this.role = item.getRole();
        EntityFullJid m12 = presence.getFrom().m1();
        if (m12 == null) {
            Logger logger = LOGGER;
            logger.warning("Occupant presence without resource: " + presence.getFrom());
            this.nick = null;
            return;
        }
        this.nick = m12.q0();
    }
}
