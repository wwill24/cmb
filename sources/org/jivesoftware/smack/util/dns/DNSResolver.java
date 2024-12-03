package org.jivesoftware.smack.util.dns;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.util.rce.RemoteConnectionEndpointLookupFailure;
import org.minidns.dnsname.DnsName;
import org.minidns.record.s;

public abstract class DNSResolver {
    protected static final Logger LOGGER = Logger.getLogger(DNSResolver.class.getName());
    private final boolean supportsDnssec;

    protected DNSResolver(boolean z10) {
        this.supportsDnssec = z10;
    }

    private void checkIfDnssecRequestedAndSupported(ConnectionConfiguration.DnssecMode dnssecMode) {
        if (dnssecMode != ConnectionConfiguration.DnssecMode.disabled && !this.supportsDnssec) {
            throw new UnsupportedOperationException("This resolver does not support DNSSEC");
        }
    }

    protected static boolean shouldContinue(CharSequence charSequence, CharSequence charSequence2, List<InetAddress> list) {
        if (list == null) {
            return true;
        }
        if (!list.isEmpty()) {
            return false;
        }
        Logger logger = LOGGER;
        Level level = Level.INFO;
        logger.log(level, "The DNS name " + charSequence + ", points to a hostname (" + charSequence2 + ") which has neither A or AAAA resource records. This is an indication of a broken DNS setup.");
        return true;
    }

    public final List<InetAddress> lookupHostAddress(DnsName dnsName, List<RemoteConnectionEndpointLookupFailure> list, ConnectionConfiguration.DnssecMode dnssecMode) {
        checkIfDnssecRequestedAndSupported(dnssecMode);
        return lookupHostAddress0(dnsName, list, dnssecMode);
    }

    /* access modifiers changed from: protected */
    public List<InetAddress> lookupHostAddress0(DnsName dnsName, List<RemoteConnectionEndpointLookupFailure> list, ConnectionConfiguration.DnssecMode dnssecMode) {
        if (dnssecMode == ConnectionConfiguration.DnssecMode.disabled) {
            try {
                return Arrays.asList(InetAddress.getAllByName(dnsName.toString()));
            } catch (UnknownHostException e10) {
                list.add(new RemoteConnectionEndpointLookupFailure.DnsLookupFailure(dnsName, e10));
                return null;
            }
        } else {
            throw new UnsupportedOperationException("This resolver does not support DNSSEC");
        }
    }

    public final Collection<s> lookupSrvRecords(DnsName dnsName, List<RemoteConnectionEndpointLookupFailure> list, ConnectionConfiguration.DnssecMode dnssecMode) {
        checkIfDnssecRequestedAndSupported(dnssecMode);
        return lookupSrvRecords0(dnsName, list, dnssecMode);
    }

    /* access modifiers changed from: protected */
    public abstract Collection<s> lookupSrvRecords0(DnsName dnsName, List<RemoteConnectionEndpointLookupFailure> list, ConnectionConfiguration.DnssecMode dnssecMode);
}
