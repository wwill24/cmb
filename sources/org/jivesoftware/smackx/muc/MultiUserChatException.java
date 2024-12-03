package org.jivesoftware.smackx.muc;

import org.jivesoftware.smack.SmackException;
import org.jxmpp.jid.DomainBareJid;

public abstract class MultiUserChatException extends SmackException {
    private static final long serialVersionUID = 1;

    public static class MissingMucCreationAcknowledgeException extends MultiUserChatException {
        private static final long serialVersionUID = 1;
    }

    public static class MucAlreadyJoinedException extends MultiUserChatException {
        private static final long serialVersionUID = 1;
    }

    public static class MucConfigurationNotSupportedException extends MultiUserChatException {
        private static final long serialVersionUID = 1;

        public MucConfigurationNotSupportedException(String str) {
            super("The MUC configuration '" + str + "' is not supported by the MUC service");
        }
    }

    public static class MucNotJoinedException extends MultiUserChatException {
        private static final long serialVersionUID = 1;

        public MucNotJoinedException(MultiUserChat multiUserChat) {
            super("Client not currently joined " + multiUserChat.getRoom());
        }
    }

    public static class NotAMucServiceException extends MultiUserChatException {
        private static final long serialVersionUID = 1;

        NotAMucServiceException(DomainBareJid domainBareJid) {
            super("Can't perform operation because " + domainBareJid + " does not provide a MUC (XEP-45) service.");
        }

        NotAMucServiceException(MultiUserChat multiUserChat) {
            super("Can not join '" + multiUserChat.getRoom() + "', because '" + multiUserChat.getRoom().R0() + "' does not provide a MUC (XEP-45) service.");
        }
    }

    protected MultiUserChatException() {
    }

    protected MultiUserChatException(String str) {
        super(str);
    }
}
