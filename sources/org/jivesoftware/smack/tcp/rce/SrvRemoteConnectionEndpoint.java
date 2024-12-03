package org.jivesoftware.smack.tcp.rce;

import java.net.InetAddress;
import java.util.Collection;
import java.util.List;
import org.jivesoftware.smack.datatypes.UInt16;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.rce.RemoteConnectionEndpoint;
import org.minidns.record.s;

public abstract class SrvRemoteConnectionEndpoint implements RemoteConnectionEndpoint {
    private final List<? extends InetAddress> inetAddresses;
    protected final UInt16 port;
    protected final s srv;

    protected SrvRemoteConnectionEndpoint(s sVar, List<? extends InetAddress> list) {
        this.srv = sVar;
        this.port = UInt16.from(sVar.f41708e);
        this.inetAddresses = (List) Objects.requireNonNull(list);
    }

    public final CharSequence getHost() {
        return this.srv.f41709f;
    }

    public final Collection<? extends InetAddress> getInetAddresses() {
        return this.inetAddresses;
    }

    public final UInt16 getPort() {
        return this.port;
    }
}
