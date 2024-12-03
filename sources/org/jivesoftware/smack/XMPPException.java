package org.jivesoftware.smack;

import org.jivesoftware.smack.packet.Nonza;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.packet.StreamError;
import org.jxmpp.jid.Jid;

public abstract class XMPPException extends Exception {
    private static final long serialVersionUID = 6881651633890968625L;

    public static class FailedNonzaException extends XMPPException {
        private static final long serialVersionUID = 1;
        private final StanzaError.Condition condition;
        private final Nonza nonza;

        public FailedNonzaException(Nonza nonza2) {
            this(nonza2, (StanzaError.Condition) null);
        }

        public StanzaError.Condition getCondition() {
            return this.condition;
        }

        public Nonza getNonza() {
            return this.nonza;
        }

        public FailedNonzaException(Nonza nonza2, StanzaError.Condition condition2) {
            this.condition = condition2;
            this.nonza = nonza2;
        }
    }

    public static class StreamErrorException extends XMPPException {
        private static final long serialVersionUID = 3400556867134848886L;
        private final StreamError streamError;

        public StreamErrorException(StreamError streamError2) {
            super(streamError2.getCondition().toString() + " You can read more about the meaning of this stream error at http://xmpp.org/rfcs/rfc6120.html#streams-error-conditions\n" + streamError2.toString());
            this.streamError = streamError2;
        }

        public StreamError getStreamError() {
            return this.streamError;
        }
    }

    public static class XMPPErrorException extends XMPPException {
        private static final long serialVersionUID = 212790389529249604L;
        private final StanzaError error;
        private final Stanza request;
        private final Stanza stanza;

        public XMPPErrorException(Stanza stanza2, StanzaError stanzaError) {
            this(stanza2, stanzaError, (Stanza) null);
        }

        public static void ifHasErrorThenThrow(Stanza stanza2) throws XMPPErrorException {
            ifHasErrorThenThrow(stanza2, (Stanza) null);
        }

        public String getMessage() {
            Jid from;
            StringBuilder sb2 = new StringBuilder();
            Stanza stanza2 = this.stanza;
            if (!(stanza2 == null || (from = stanza2.getFrom()) == null)) {
                sb2.append("XMPP error reply received from " + from + ": ");
            }
            sb2.append(this.error);
            if (this.request != null) {
                sb2.append(" as result of the following request: ");
                sb2.append(this.request);
            }
            return sb2.toString();
        }

        public Stanza getRequest() {
            return this.request;
        }

        public Stanza getStanza() {
            return this.stanza;
        }

        public StanzaError getStanzaError() {
            return this.error;
        }

        public XMPPErrorException(Stanza stanza2, StanzaError stanzaError, Stanza stanza3) {
            this.error = stanzaError;
            this.stanza = stanza2;
            this.request = stanza3;
        }

        public static void ifHasErrorThenThrow(Stanza stanza2, Stanza stanza3) throws XMPPErrorException {
            StanzaError error2 = stanza2.getError();
            if (error2 != null) {
                throw new XMPPErrorException(stanza2, error2, stanza3);
            }
        }
    }

    protected XMPPException() {
    }

    protected XMPPException(String str) {
        super(str);
    }

    protected XMPPException(String str, Throwable th2) {
        super(str, th2);
    }
}
