package org.jivesoftware.smack.util.rce;

import java.net.InetAddress;
import java.util.Collection;
import java.util.Collections;

public interface SingleAddressRemoteConnectionEndpoint extends RemoteConnectionEndpoint {
    InetAddress getInetAddress();

    Collection<? extends InetAddress> getInetAddresses() {
        return Collections.singletonList(getInetAddress());
    }
}
