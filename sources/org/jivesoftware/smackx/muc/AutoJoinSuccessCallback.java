package org.jivesoftware.smackx.muc;

import org.jxmpp.jid.parts.Resourcepart;

public interface AutoJoinSuccessCallback {
    void autoJoinSuccess(MultiUserChat multiUserChat, Resourcepart resourcepart);
}
