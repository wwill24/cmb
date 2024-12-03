package org.jivesoftware.smackx.muc.filter;

import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.muc.packet.MUCUser;

public class MUCUserStatusCodeFilter implements StanzaFilter {
    public static final MUCUserStatusCodeFilter STATUS_110_PRESENCE_TO_SELF = new MUCUserStatusCodeFilter(MUCUser.Status.PRESENCE_TO_SELF_110);
    private final MUCUser.Status status;

    public MUCUserStatusCodeFilter(MUCUser.Status status2) {
        this.status = status2;
    }

    public boolean accept(Stanza stanza) {
        MUCUser from = MUCUser.from(stanza);
        if (from == null) {
            return false;
        }
        return from.getStatus().contains(this.status);
    }

    public String toString() {
        return getClass().getSimpleName() + ": status=" + this.status;
    }

    public MUCUserStatusCodeFilter(int i10) {
        this(MUCUser.Status.create(Integer.valueOf(i10)));
    }
}
