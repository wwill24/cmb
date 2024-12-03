package org.jivesoftware.smack.tcp.rce;

import java.net.InetAddress;
import java.util.List;
import org.minidns.record.s;

public class SrvXmppsRemoteConnectionEndpoint extends SrvRemoteConnectionEndpoint {
    protected SrvXmppsRemoteConnectionEndpoint(s sVar, List<? extends InetAddress> list) {
        super(sVar, list);
    }

    public String getDescription() {
        return "XEP-0368 SRV Endpoint + ['xmpps', " + this.srv + "]";
    }
}
