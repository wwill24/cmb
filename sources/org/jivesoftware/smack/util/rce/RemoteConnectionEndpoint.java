package org.jivesoftware.smack.util.rce;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Collection;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smack.datatypes.UInt16;

public interface RemoteConnectionEndpoint {

    public static class InetSocketAddressCoupling<RCE extends RemoteConnectionEndpoint> {
        private final RCE connectionEndpoint;
        private final InetSocketAddress inetSocketAddress;

        public InetSocketAddressCoupling(RCE rce, InetAddress inetAddress) {
            this.connectionEndpoint = rce;
            this.inetSocketAddress = new InetSocketAddress(inetAddress, rce.getPort().intValue());
        }

        public InetSocketAddress getInetSocketAddress() {
            return this.inetSocketAddress;
        }

        public RCE getRemoteConnectionEndpoint() {
            return this.connectionEndpoint;
        }

        public String toString() {
            return this.connectionEndpoint.getDescription() + " (" + this.inetSocketAddress + PropertyUtils.MAPPED_DELIM2;
        }
    }

    String getDescription();

    CharSequence getHost();

    Collection<? extends InetAddress> getInetAddresses();

    UInt16 getPort();
}
