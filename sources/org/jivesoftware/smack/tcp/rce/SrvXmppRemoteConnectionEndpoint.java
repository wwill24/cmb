package org.jivesoftware.smack.tcp.rce;

import java.net.InetAddress;
import java.util.List;
import org.minidns.record.s;

public final class SrvXmppRemoteConnectionEndpoint extends SrvRemoteConnectionEndpoint implements Rfc6120TcpRemoteConnectionEndpoint {
    protected SrvXmppRemoteConnectionEndpoint(s sVar, List<? extends InetAddress> list) {
        super(sVar, list);
    }

    public String getDescription() {
        return "RFC 6120 SRV Endpoint + ['xmpp', " + this.srv + "]";
    }
}
