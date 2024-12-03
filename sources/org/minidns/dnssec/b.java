package org.minidns.dnssec;

import java.util.Collections;
import java.util.Set;
import org.minidns.dnsmessage.DnsMessage;
import org.minidns.dnsqueryresult.DnsQueryResult;
import org.minidns.record.Record;
import org.minidns.record.q;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public final DnsMessage f33691a;

    /* renamed from: b  reason: collision with root package name */
    public final DnsQueryResult f33692b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<Record<q>> f33693c;

    /* renamed from: d  reason: collision with root package name */
    private final Set<c> f33694d;

    b(DnsMessage dnsMessage, DnsQueryResult dnsQueryResult, Set<Record<q>> set, Set<c> set2) {
        this.f33691a = dnsMessage;
        this.f33692b = dnsQueryResult;
        this.f33693c = Collections.unmodifiableSet(set);
        if (set2 == null) {
            this.f33694d = Collections.emptySet();
        } else {
            this.f33694d = Collections.unmodifiableSet(set2);
        }
    }

    public Set<c> a() {
        return this.f33694d;
    }

    public boolean b() {
        return this.f33694d.isEmpty();
    }
}
