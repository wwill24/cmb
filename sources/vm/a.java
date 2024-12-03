package vm;

import java.io.IOException;
import org.minidns.MiniDnsException;
import org.minidns.cache.LruCache;
import org.minidns.dnssec.b;
import org.minidns.iterative.ReliableDnsClient;
import org.minidns.record.h;

public class a extends b {

    /* renamed from: f  reason: collision with root package name */
    public static final a f33938f = new a();

    /* renamed from: c  reason: collision with root package name */
    private final org.minidns.dnssec.a f33939c;

    /* renamed from: d  reason: collision with root package name */
    private final org.minidns.dnssec.a f33940d;

    /* renamed from: e  reason: collision with root package name */
    private final org.minidns.dnssec.a f33941e;

    /* renamed from: vm.a$a  reason: collision with other inner class name */
    class C0401a implements org.minidns.cache.a {
        C0401a() {
        }

        public nm.a a() {
            return new LruCache();
        }
    }

    public a() {
        this(new C0401a());
    }

    private static <D extends h> c<D> f(org.minidns.dnsmessage.a aVar, b bVar) throws MiniDnsException.NullResultException {
        return new c<>(aVar, bVar.f33692b, bVar.a());
    }

    public <D extends h> c<D> b(org.minidns.dnsmessage.a aVar) throws IOException {
        return f(aVar, this.f33939c.w(aVar));
    }

    public a(org.minidns.cache.a aVar) {
        this(new org.minidns.dnssec.a(aVar.a()), aVar);
    }

    private a(org.minidns.dnssec.a aVar, org.minidns.cache.a aVar2) {
        super(aVar);
        this.f33939c = aVar;
        org.minidns.dnssec.a aVar3 = new org.minidns.dnssec.a(aVar2.a());
        this.f33940d = aVar3;
        aVar3.r(ReliableDnsClient.Mode.iterativeOnly);
        org.minidns.dnssec.a aVar4 = new org.minidns.dnssec.a(aVar2.a());
        this.f33941e = aVar4;
        aVar4.r(ReliableDnsClient.Mode.recursiveOnly);
    }
}
