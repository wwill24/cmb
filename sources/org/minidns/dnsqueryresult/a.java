package org.minidns.dnsqueryresult;

import org.minidns.dnsmessage.DnsMessage;
import org.minidns.dnsqueryresult.DnsQueryResult;

public abstract class a extends DnsQueryResult {

    /* renamed from: d  reason: collision with root package name */
    protected final DnsQueryResult f33679d;

    protected a(DnsMessage dnsMessage, DnsQueryResult dnsQueryResult) {
        super(DnsQueryResult.QueryMethod.cachedDirect, dnsMessage, dnsQueryResult.f33670c);
        this.f33679d = dnsQueryResult;
    }
}
