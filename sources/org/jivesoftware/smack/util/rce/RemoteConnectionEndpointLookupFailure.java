package org.jivesoftware.smack.util.rce;

import org.jivesoftware.smack.util.ToStringUtil;
import org.minidns.dnsname.DnsName;

public abstract class RemoteConnectionEndpointLookupFailure {
    private final String description;
    private final Exception exception;
    private transient String toStringCache;

    public static class DnsLookupFailure extends RemoteConnectionEndpointLookupFailure {
        private final DnsName dnsName;

        public DnsLookupFailure(DnsName dnsName2, Exception exc) {
            super("DNS lookup exception for " + dnsName2, exc);
            this.dnsName = dnsName2;
        }

        public DnsName getDnsName() {
            return this.dnsName;
        }
    }

    public RemoteConnectionEndpointLookupFailure(String str, Exception exc) {
        this.description = str;
        this.exception = exc;
    }

    public final String getDescription() {
        return this.description;
    }

    public String getErrorMessage() {
        return this.description + " because: " + this.exception;
    }

    public final Exception getException() {
        return this.exception;
    }

    public String toString() {
        if (this.toStringCache == null) {
            this.toStringCache = ToStringUtil.builderFor(RemoteConnectionEndpointLookupFailure.class).addValue("description", this.description).addValue("exception", this.exception).build();
        }
        return this.toStringCache;
    }
}
