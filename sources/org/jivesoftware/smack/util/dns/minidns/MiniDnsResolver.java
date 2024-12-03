package org.jivesoftware.smack.util.dns.minidns;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.initializer.SmackInitializer;
import org.jivesoftware.smack.util.DNSUtil;
import org.jivesoftware.smack.util.dns.DNSResolver;
import org.jivesoftware.smack.util.rce.RemoteConnectionEndpointLookupFailure;
import org.minidns.dnsname.DnsName;
import org.minidns.dnssec.DnssecResultNotAuthenticException;
import org.minidns.hla.ResolutionUnsuccessfulException;
import org.minidns.record.s;
import vm.a;
import vm.b;
import vm.c;
import vm.d;

public class MiniDnsResolver extends DNSResolver implements SmackInitializer {
    private static final b DNSSEC_RESOLVER = a.f33938f;
    private static final MiniDnsResolver INSTANCE = new MiniDnsResolver();
    private static final b NON_DNSSEC_RESOLVER = b.f33942b;

    /* renamed from: org.jivesoftware.smack.util.dns.minidns.MiniDnsResolver$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$ConnectionConfiguration$DnssecMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                org.jivesoftware.smack.ConnectionConfiguration$DnssecMode[] r0 = org.jivesoftware.smack.ConnectionConfiguration.DnssecMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smack$ConnectionConfiguration$DnssecMode = r0
                org.jivesoftware.smack.ConnectionConfiguration$DnssecMode r1 = org.jivesoftware.smack.ConnectionConfiguration.DnssecMode.needsDnssec     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$ConnectionConfiguration$DnssecMode     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smack.ConnectionConfiguration$DnssecMode r1 = org.jivesoftware.smack.ConnectionConfiguration.DnssecMode.needsDnssecAndDane     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$ConnectionConfiguration$DnssecMode     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.jivesoftware.smack.ConnectionConfiguration$DnssecMode r1 = org.jivesoftware.smack.ConnectionConfiguration.DnssecMode.disabled     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.util.dns.minidns.MiniDnsResolver.AnonymousClass1.<clinit>():void");
        }
    }

    public MiniDnsResolver() {
        super(true);
    }

    private static ResolutionUnsuccessfulException getExceptionFrom(c<?> cVar) {
        return new ResolutionUnsuccessfulException(cVar.c(), cVar.e());
    }

    public static DNSResolver getInstance() {
        return INSTANCE;
    }

    private static b getResolver(ConnectionConfiguration.DnssecMode dnssecMode) {
        if (dnssecMode == ConnectionConfiguration.DnssecMode.disabled) {
            return NON_DNSSEC_RESOLVER;
        }
        return DNSSEC_RESOLVER;
    }

    public static void setup() {
        DNSUtil.setDNSResolver(getInstance());
    }

    private static boolean shouldAbortIfNotAuthentic(DnsName dnsName, ConnectionConfiguration.DnssecMode dnssecMode, c<?> cVar, List<RemoteConnectionEndpointLookupFailure> list) {
        int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$ConnectionConfiguration$DnssecMode[dnssecMode.ordinal()];
        if (i10 == 1 || i10 == 2) {
            DnssecResultNotAuthenticException b10 = cVar.b();
            if (b10 == null) {
                return false;
            }
            list.add(new RemoteConnectionEndpointLookupFailure.DnsLookupFailure(dnsName, b10));
            return true;
        } else if (i10 == 3) {
            return false;
        } else {
            throw new IllegalStateException("Unknown DnssecMode: " + dnssecMode);
        }
    }

    public List<Exception> initialize() {
        setup();
        MiniDnsDane.setup();
        return null;
    }

    /* access modifiers changed from: protected */
    public List<InetAddress> lookupHostAddress0(DnsName dnsName, List<RemoteConnectionEndpointLookupFailure> list, ConnectionConfiguration.DnssecMode dnssecMode) {
        Set<D> set;
        Set<D> set2;
        b resolver = getResolver(dnssecMode);
        try {
            c<D> c10 = resolver.c(dnsName, org.minidns.record.a.class);
            c<D> c11 = resolver.c(dnsName, org.minidns.record.b.class);
            if (!c10.i() && !c11.i()) {
                list.add(new RemoteConnectionEndpointLookupFailure.DnsLookupFailure(dnsName, getExceptionFrom(c10)));
                list.add(new RemoteConnectionEndpointLookupFailure.DnsLookupFailure(dnsName, getExceptionFrom(c11)));
                return null;
            } else if (shouldAbortIfNotAuthentic(dnsName, dnssecMode, c10, list) || shouldAbortIfNotAuthentic(dnsName, dnssecMode, c11, list)) {
                return null;
            } else {
                if (c10.i()) {
                    set = c10.a();
                } else {
                    set = Collections.emptySet();
                }
                if (c11.i()) {
                    set2 = c11.a();
                } else {
                    set2 = Collections.emptySet();
                }
                ArrayList arrayList = new ArrayList(set.size() + set2.size());
                for (D k10 : set) {
                    try {
                        arrayList.add(InetAddress.getByAddress(k10.k()));
                    } catch (UnknownHostException unused) {
                    }
                }
                for (D k11 : set2) {
                    try {
                        arrayList.add(InetAddress.getByAddress(dnsName.ace, k11.k()));
                    } catch (UnknownHostException unused2) {
                    }
                }
                return arrayList;
            }
        } catch (IOException e10) {
            list.add(new RemoteConnectionEndpointLookupFailure.DnsLookupFailure(dnsName, e10));
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public Set<s> lookupSrvRecords0(DnsName dnsName, List<RemoteConnectionEndpointLookupFailure> list, ConnectionConfiguration.DnssecMode dnssecMode) {
        try {
            d d10 = getResolver(dnssecMode).d(dnsName);
            ResolutionUnsuccessfulException d11 = d10.d();
            if (d11 != null) {
                list.add(new RemoteConnectionEndpointLookupFailure.DnsLookupFailure(dnsName, d11));
                return null;
            } else if (shouldAbortIfNotAuthentic(dnsName, dnssecMode, d10, list)) {
                return null;
            } else {
                return d10.a();
            }
        } catch (IOException e10) {
            list.add(new RemoteConnectionEndpointLookupFailure.DnsLookupFailure(dnsName, e10));
            return null;
        }
    }
}
