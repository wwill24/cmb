package org.jivesoftware.smackx.jingle;

import org.jxmpp.jid.FullJid;

public class FullJidAndSessionId {
    private final FullJid fullJid;
    private final String sessionId;

    public FullJidAndSessionId(FullJid fullJid2, String str) {
        this.fullJid = fullJid2;
        this.sessionId = str;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FullJidAndSessionId)) {
            return false;
        }
        FullJidAndSessionId fullJidAndSessionId = (FullJidAndSessionId) obj;
        if (!this.fullJid.Y(fullJidAndSessionId.fullJid) || !this.sessionId.equals(fullJidAndSessionId.sessionId)) {
            return false;
        }
        return true;
    }

    public FullJid getFullJid() {
        return this.fullJid;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public int hashCode() {
        return (this.fullJid.hashCode() * 31 * 31) + this.sessionId.hashCode();
    }
}
