package vm;

import java.util.Collections;
import java.util.Set;
import org.minidns.MiniDnsException;
import org.minidns.dnsmessage.DnsMessage;
import org.minidns.dnsmessage.a;
import org.minidns.dnsqueryresult.DnsQueryResult;
import org.minidns.dnssec.DnssecResultNotAuthenticException;
import org.minidns.hla.ResolutionUnsuccessfulException;
import org.minidns.record.h;

public class c<D extends h> {

    /* renamed from: a  reason: collision with root package name */
    protected final a f33944a;

    /* renamed from: b  reason: collision with root package name */
    private final DnsMessage.RESPONSE_CODE f33945b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<D> f33946c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f33947d;

    /* renamed from: e  reason: collision with root package name */
    protected final Set<org.minidns.dnssec.c> f33948e;

    /* renamed from: f  reason: collision with root package name */
    protected final DnsMessage f33949f;

    /* renamed from: g  reason: collision with root package name */
    protected final DnsQueryResult f33950g;

    /* renamed from: h  reason: collision with root package name */
    private ResolutionUnsuccessfulException f33951h;

    /* renamed from: i  reason: collision with root package name */
    private DnssecResultNotAuthenticException f33952i;

    c(a aVar, DnsQueryResult dnsQueryResult, Set<org.minidns.dnssec.c> set) throws MiniDnsException.NullResultException {
        if (dnsQueryResult != null) {
            this.f33950g = dnsQueryResult;
            DnsMessage dnsMessage = dnsQueryResult.f33670c;
            this.f33944a = aVar;
            this.f33945b = dnsMessage.f33584c;
            this.f33949f = dnsMessage;
            Set k10 = dnsMessage.k(aVar);
            if (k10 == null) {
                this.f33946c = Collections.emptySet();
            } else {
                this.f33946c = Collections.unmodifiableSet(k10);
            }
            if (set == null) {
                this.f33948e = null;
                this.f33947d = false;
                return;
            }
            Set<org.minidns.dnssec.c> unmodifiableSet = Collections.unmodifiableSet(set);
            this.f33948e = unmodifiableSet;
            this.f33947d = unmodifiableSet.isEmpty();
            return;
        }
        throw new MiniDnsException.NullResultException(aVar.a().s());
    }

    public Set<D> a() {
        h();
        return this.f33946c;
    }

    public DnssecResultNotAuthenticException b() {
        if (!i() || this.f33947d) {
            return null;
        }
        if (this.f33952i == null) {
            this.f33952i = DnssecResultNotAuthenticException.a(f());
        }
        return this.f33952i;
    }

    public a c() {
        return this.f33944a;
    }

    public ResolutionUnsuccessfulException d() {
        if (i()) {
            return null;
        }
        if (this.f33951h == null) {
            this.f33951h = new ResolutionUnsuccessfulException(this.f33944a, this.f33945b);
        }
        return this.f33951h;
    }

    public DnsMessage.RESPONSE_CODE e() {
        return this.f33945b;
    }

    public Set<org.minidns.dnssec.c> f() {
        h();
        return this.f33948e;
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        Set<org.minidns.dnssec.c> set = this.f33948e;
        return set != null && !set.isEmpty();
    }

    /* access modifiers changed from: protected */
    public void h() {
        ResolutionUnsuccessfulException d10 = d();
        if (d10 != null) {
            throw new IllegalStateException("Can not perform operation because the DNS resolution was unsuccessful", d10);
        }
    }

    public boolean i() {
        return this.f33945b == DnsMessage.RESPONSE_CODE.NO_ERROR;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getName());
        sb2.append(10);
        sb2.append("Question: ");
        sb2.append(this.f33944a);
        sb2.append(10);
        sb2.append("Response Code: ");
        sb2.append(this.f33945b);
        sb2.append(10);
        if (this.f33945b == DnsMessage.RESPONSE_CODE.NO_ERROR) {
            if (this.f33947d) {
                sb2.append("Results verified via DNSSEC\n");
            }
            if (g()) {
                sb2.append(this.f33948e);
                sb2.append(10);
            }
            sb2.append(this.f33949f.f33593l);
        }
        return sb2.toString();
    }
}
