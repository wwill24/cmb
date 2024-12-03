package org.jivesoftware.smack.tcp.rce;

import com.facebook.internal.security.CertificateUtil;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.datatypes.UInt16;
import org.jivesoftware.smack.util.DNSUtil;
import org.jivesoftware.smack.util.dns.DNSResolver;
import org.jivesoftware.smack.util.rce.RemoteConnectionEndpoint;
import org.jivesoftware.smack.util.rce.RemoteConnectionEndpointLookupFailure;
import org.minidns.dnsname.DnsName;
import org.minidns.record.s;
import zm.g;

public class RemoteXmppTcpConnectionEndpoints {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Logger LOGGER = Logger.getLogger(RemoteXmppTcpConnectionEndpoints.class.getName());
    public static final String XMPP_CLIENT_DNS_SRV_PREFIX = "_xmpp-client._tcp";
    public static final String XMPP_SERVER_DNS_SRV_PREFIX = "_xmpp-server._tcp";

    /* renamed from: org.jivesoftware.smack.tcp.rce.RemoteXmppTcpConnectionEndpoints$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$tcp$rce$RemoteXmppTcpConnectionEndpoints$DomainType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.jivesoftware.smack.tcp.rce.RemoteXmppTcpConnectionEndpoints$DomainType[] r0 = org.jivesoftware.smack.tcp.rce.RemoteXmppTcpConnectionEndpoints.DomainType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smack$tcp$rce$RemoteXmppTcpConnectionEndpoints$DomainType = r0
                org.jivesoftware.smack.tcp.rce.RemoteXmppTcpConnectionEndpoints$DomainType r1 = org.jivesoftware.smack.tcp.rce.RemoteXmppTcpConnectionEndpoints.DomainType.client     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$tcp$rce$RemoteXmppTcpConnectionEndpoints$DomainType     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smack.tcp.rce.RemoteXmppTcpConnectionEndpoints$DomainType r1 = org.jivesoftware.smack.tcp.rce.RemoteXmppTcpConnectionEndpoints.DomainType.server     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.tcp.rce.RemoteXmppTcpConnectionEndpoints.AnonymousClass1.<clinit>():void");
        }
    }

    enum DomainType {
        server(RemoteXmppTcpConnectionEndpoints.XMPP_SERVER_DNS_SRV_PREFIX),
        client(RemoteXmppTcpConnectionEndpoints.XMPP_CLIENT_DNS_SRV_PREFIX);
        
        public final DnsName srvPrefix;

        private DomainType(String str) {
            this.srvPrefix = DnsName.c(str);
        }
    }

    public static final class Result<RCE extends RemoteConnectionEndpoint> {
        public final List<RCE> discoveredRemoteConnectionEndpoints;
        public final List<RemoteConnectionEndpointLookupFailure> lookupFailures;

        /* synthetic */ Result(List list, List list2, AnonymousClass1 r32) {
            this(list, list2);
        }

        private Result(List<RCE> list, List<RemoteConnectionEndpointLookupFailure> list2) {
            this.discoveredRemoteConnectionEndpoints = list;
            this.lookupFailures = list2;
        }
    }

    private static DNSResolver getDnsResolverOrThrow() {
        DNSResolver dNSResolver = DNSUtil.getDNSResolver();
        if (dNSResolver != null) {
            return dNSResolver;
        }
        throw new IllegalStateException("No DNS resolver configured in Smack");
    }

    public static Result<Rfc6120TcpRemoteConnectionEndpoint> lookup(ConnectionConfiguration connectionConfiguration) {
        List<Rfc6120TcpRemoteConnectionEndpoint> list;
        List list2;
        InetAddress hostAddress = connectionConfiguration.getHostAddress();
        DnsName host = connectionConfiguration.getHost();
        if (hostAddress != null) {
            list2 = Collections.emptyList();
            list = Collections.singletonList(IpTcpRemoteConnectionEndpoint.from(hostAddress.toString(), connectionConfiguration.getPort(), hostAddress));
        } else if (host != null) {
            ArrayList arrayList = new ArrayList(1);
            List<InetAddress> lookupHostAddress = DNSUtil.getDNSResolver().lookupHostAddress(host, arrayList, connectionConfiguration.getDnssecMode());
            if (lookupHostAddress != null) {
                ArrayList arrayList2 = new ArrayList(lookupHostAddress.size());
                UInt16 port = connectionConfiguration.getPort();
                for (InetAddress from : lookupHostAddress) {
                    arrayList2.add(IpTcpRemoteConnectionEndpoint.from(host, port, from));
                }
                list = arrayList2;
            } else {
                list = Collections.emptyList();
            }
            list2 = arrayList;
        } else {
            list2 = new ArrayList();
            DnsName xmppServiceDomainAsDnsNameIfPossible = connectionConfiguration.getXmppServiceDomainAsDnsNameIfPossible();
            if (xmppServiceDomainAsDnsNameIfPossible != null) {
                list = resolveXmppServiceDomain(xmppServiceDomainAsDnsNameIfPossible, list2, connectionConfiguration.getDnssecMode());
            } else {
                throw new IllegalStateException();
            }
        }
        return new Result<>(list, list2, (AnonymousClass1) null);
    }

    private static List<Rfc6120TcpRemoteConnectionEndpoint> resolveDomain(DnsName dnsName, DomainType domainType, List<RemoteConnectionEndpointLookupFailure> list, ConnectionConfiguration.DnssecMode dnssecMode, DNSResolver dNSResolver) {
        UInt16 uInt16;
        ArrayList arrayList = new ArrayList();
        DnsName h10 = DnsName.h(domainType.srvPrefix, dnsName);
        Collection<s> lookupSrvRecords = dNSResolver.lookupSrvRecords(h10, list, dnssecMode);
        if (lookupSrvRecords == null || lookupSrvRecords.isEmpty()) {
            LOGGER.info("Could not resolve DNS SRV resource records for " + h10 + ". Consider adding those.");
        } else {
            if (LOGGER.isLoggable(Level.FINE)) {
                String str = "Resolved SRV RR for " + h10 + CertificateUtil.DELIMITER;
                for (s sVar : lookupSrvRecords) {
                    str = str + " " + sVar;
                }
                LOGGER.fine(str);
            }
            for (s next : g.b(lookupSrvRecords)) {
                List<InetAddress> lookupHostAddress = dNSResolver.lookupHostAddress(next.f41709f, list, dnssecMode);
                if (lookupHostAddress != null) {
                    arrayList.add(new SrvXmppRemoteConnectionEndpoint(next, lookupHostAddress));
                }
            }
        }
        int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$tcp$rce$RemoteXmppTcpConnectionEndpoints$DomainType[domainType.ordinal()];
        if (i10 == 1) {
            uInt16 = UInt16.from(5222);
        } else if (i10 == 2) {
            uInt16 = UInt16.from(5269);
        } else {
            throw new AssertionError();
        }
        List<InetAddress> lookupHostAddress2 = dNSResolver.lookupHostAddress(dnsName, list, dnssecMode);
        if (lookupHostAddress2 != null) {
            for (InetAddress from : lookupHostAddress2) {
                arrayList.add(IpTcpRemoteConnectionEndpoint.from(dnsName, uInt16, from));
            }
        }
        return arrayList;
    }

    public static List<Rfc6120TcpRemoteConnectionEndpoint> resolveXmppServerDomain(DnsName dnsName, List<RemoteConnectionEndpointLookupFailure> list, ConnectionConfiguration.DnssecMode dnssecMode) {
        return resolveDomain(dnsName, DomainType.server, list, dnssecMode, getDnsResolverOrThrow());
    }

    public static List<Rfc6120TcpRemoteConnectionEndpoint> resolveXmppServiceDomain(DnsName dnsName, List<RemoteConnectionEndpointLookupFailure> list, ConnectionConfiguration.DnssecMode dnssecMode) {
        return resolveDomain(dnsName, DomainType.client, list, dnssecMode, getDnsResolverOrThrow());
    }
}
