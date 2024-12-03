package org.minidns.dnsqueryresult;

import java.net.InetAddress;
import org.minidns.dnsmessage.DnsMessage;
import org.minidns.dnsqueryresult.DnsQueryResult;

public class b extends DnsQueryResult {

    /* renamed from: d  reason: collision with root package name */
    public final InetAddress f33680d;

    /* renamed from: e  reason: collision with root package name */
    public final int f33681e;

    public b(InetAddress inetAddress, int i10, DnsQueryResult.QueryMethod queryMethod, DnsMessage dnsMessage, DnsMessage dnsMessage2) {
        super(queryMethod, dnsMessage, dnsMessage2);
        this.f33680d = inetAddress;
        this.f33681e = i10;
    }
}
