package vm;

import java.io.IOException;
import java.util.Set;
import org.minidns.AbstractDnsClient;
import org.minidns.dnslabel.DnsLabel;
import org.minidns.dnsmessage.a;
import org.minidns.dnsname.DnsName;
import org.minidns.dnssec.c;
import org.minidns.iterative.ReliableDnsClient;
import org.minidns.record.Record;
import org.minidns.record.h;
import org.minidns.record.s;

public class b {

    /* renamed from: b  reason: collision with root package name */
    public static final b f33942b = new b(new ReliableDnsClient());

    /* renamed from: a  reason: collision with root package name */
    private final AbstractDnsClient f33943a;

    public b(AbstractDnsClient abstractDnsClient) {
        this.f33943a = abstractDnsClient;
    }

    public final AbstractDnsClient a() {
        return this.f33943a;
    }

    public <D extends h> c<D> b(a aVar) throws IOException {
        return new c<>(aVar, this.f33943a.p(aVar), (Set<c>) null);
    }

    public final <D extends h> c<D> c(DnsName dnsName, Class<D> cls) throws IOException {
        return b(new a(dnsName, Record.TYPE.c(cls)));
    }

    public d d(DnsName dnsName) throws IOException {
        int l10 = dnsName.l();
        if (l10 >= 3) {
            DnsLabel k10 = dnsName.k(l10 - 1);
            int i10 = l10 - 2;
            return e(dnsName.B(i10), new wm.a(k10, dnsName.k(i10)));
        }
        throw new IllegalArgumentException();
    }

    public d e(DnsName dnsName, wm.a aVar) throws IOException {
        return new d(c(DnsName.d(aVar.f33961a, aVar.f33962b, dnsName), s.class), aVar, this);
    }
}
