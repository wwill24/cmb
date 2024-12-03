package org.jivesoftware.smackx.pubsub;

import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jxmpp.jid.BareJid;

public abstract class PubSubException extends SmackException {
    private static final long serialVersionUID = 1;
    private final String nodeId;

    public static class NotALeafNodeException extends PubSubException {
        private static final long serialVersionUID = 1;
        private final BareJid pubSubService;

        NotALeafNodeException(String str, BareJid bareJid) {
            super(str);
            this.pubSubService = bareJid;
        }

        public BareJid getPubSubService() {
            return this.pubSubService;
        }
    }

    public static class NotAPubSubNodeException extends PubSubException {
        private static final long serialVersionUID = 1;
        private final DiscoverInfo discoverInfo;

        NotAPubSubNodeException(String str, DiscoverInfo discoverInfo2) {
            super(str);
            this.discoverInfo = discoverInfo2;
        }

        public DiscoverInfo getDiscoverInfo() {
            return this.discoverInfo;
        }
    }

    protected PubSubException(String str) {
        this.nodeId = str;
    }

    public String getNodeId() {
        return this.nodeId;
    }
}
