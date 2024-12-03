package org.jivesoftware.smackx.muc;

import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.muc.packet.MUCUser;
import org.jxmpp.jid.EntityBareJid;

public interface InvitationRejectionListener {
    void invitationDeclined(EntityBareJid entityBareJid, String str, Message message, MUCUser.Decline decline);
}
