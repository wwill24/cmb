package org.minidns.dnsqueryresult;

import org.minidns.dnsmessage.DnsMessage;

public abstract class DnsQueryResult {

    /* renamed from: a  reason: collision with root package name */
    public final QueryMethod f33668a;

    /* renamed from: b  reason: collision with root package name */
    public final DnsMessage f33669b;

    /* renamed from: c  reason: collision with root package name */
    public final DnsMessage f33670c;

    public enum QueryMethod {
        udp,
        tcp,
        asyncUdp,
        asyncTcp,
        cachedDirect,
        cachedSynthesized,
        testWorld
    }

    protected DnsQueryResult(QueryMethod queryMethod, DnsMessage dnsMessage, DnsMessage dnsMessage2) {
        this.f33668a = queryMethod;
        this.f33669b = dnsMessage;
        this.f33670c = dnsMessage2;
    }

    public String toString() {
        return this.f33670c.toString();
    }
}
