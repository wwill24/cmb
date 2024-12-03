package org.minidns;

import java.io.IOException;
import java.net.InetAddress;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.minidns.cache.LruCache;
import org.minidns.dnsmessage.DnsMessage;
import org.minidns.dnsname.DnsName;
import org.minidns.dnsqueryresult.DnsQueryResult;
import org.minidns.record.Record;
import org.minidns.record.h;
import org.minidns.record.k;
import org.minidns.source.a;

public abstract class AbstractDnsClient {

    /* renamed from: g  reason: collision with root package name */
    protected static final LruCache f33515g = new LruCache();

    /* renamed from: h  reason: collision with root package name */
    protected static final Logger f33516h = Logger.getLogger(AbstractDnsClient.class.getName());

    /* renamed from: i  reason: collision with root package name */
    protected static IpVersionSetting f33517i = IpVersionSetting.v4v6;

    /* renamed from: a  reason: collision with root package name */
    private final a.C0502a f33518a;

    /* renamed from: b  reason: collision with root package name */
    protected final Random f33519b;

    /* renamed from: c  reason: collision with root package name */
    protected final Random f33520c;

    /* renamed from: d  reason: collision with root package name */
    protected final nm.a f33521d;

    /* renamed from: e  reason: collision with root package name */
    protected org.minidns.source.a f33522e;

    /* renamed from: f  reason: collision with root package name */
    protected IpVersionSetting f33523f;

    public enum IpVersionSetting {
        v4only(true, false),
        v6only(false, true),
        v4v6(true, true),
        v6v4(true, true);
        

        /* renamed from: v4  reason: collision with root package name */
        public final boolean f33529v4;

        /* renamed from: v6  reason: collision with root package name */
        public final boolean f33530v6;

        private IpVersionSetting(boolean z10, boolean z11) {
            this.f33529v4 = z10;
            this.f33530v6 = z11;
        }
    }

    class a implements a.C0502a {
        a() {
        }

        public void a(DnsMessage dnsMessage, DnsQueryResult dnsQueryResult) {
            org.minidns.dnsmessage.a q10 = dnsMessage.q();
            AbstractDnsClient abstractDnsClient = AbstractDnsClient.this;
            if (abstractDnsClient.f33521d != null && abstractDnsClient.k(q10, dnsQueryResult)) {
                AbstractDnsClient.this.f33521d.d(dnsMessage.c(), dnsQueryResult);
            }
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33532a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.minidns.record.Record$TYPE[] r0 = org.minidns.record.Record.TYPE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f33532a = r0
                org.minidns.record.Record$TYPE r1 = org.minidns.record.Record.TYPE.A     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f33532a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.minidns.record.Record$TYPE r1 = org.minidns.record.Record.TYPE.AAAA     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.minidns.AbstractDnsClient.b.<clinit>():void");
        }
    }

    protected AbstractDnsClient(nm.a aVar) {
        SecureRandom secureRandom;
        this.f33518a = new a();
        this.f33520c = new Random();
        this.f33522e = new org.minidns.source.b();
        this.f33523f = f33517i;
        try {
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException unused) {
            secureRandom = new SecureRandom();
        }
        this.f33519b = secureRandom;
        this.f33521d = aVar;
    }

    private <D extends h> Set<D> b(DnsName dnsName, Record.TYPE type) {
        Collection collection;
        Set<k> g10 = g(dnsName);
        if (g10.isEmpty()) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(g10.size() * 3);
        for (k next : g10) {
            int i10 = b.f33532a[type.ordinal()];
            if (i10 == 1) {
                collection = c(next.f42186c);
            } else if (i10 == 2) {
                collection = e(next.f42186c);
            } else {
                throw new AssertionError();
            }
            hashSet.addAll(collection);
        }
        return hashSet;
    }

    private <D extends h> Set<D> h(DnsName dnsName, Record.TYPE type) {
        if (this.f33521d == null) {
            return Collections.emptySet();
        }
        org.minidns.dnsmessage.a aVar = new org.minidns.dnsmessage.a(dnsName, type);
        org.minidns.dnsqueryresult.a a10 = this.f33521d.a(j(aVar));
        if (a10 == null) {
            return Collections.emptySet();
        }
        return a10.f33670c.k(aVar);
    }

    /* access modifiers changed from: package-private */
    public final DnsMessage.b a(org.minidns.dnsmessage.a aVar) {
        DnsMessage.b d10 = DnsMessage.d();
        d10.A(aVar);
        d10.y(this.f33519b.nextInt());
        return l(d10);
    }

    public Set<org.minidns.record.a> c(DnsName dnsName) {
        return h(dnsName, Record.TYPE.A);
    }

    public Set<org.minidns.record.a> d(DnsName dnsName) {
        return b(dnsName, Record.TYPE.A);
    }

    public Set<org.minidns.record.b> e(DnsName dnsName) {
        return h(dnsName, Record.TYPE.AAAA);
    }

    public Set<org.minidns.record.b> f(DnsName dnsName) {
        return b(dnsName, Record.TYPE.AAAA);
    }

    public Set<k> g(DnsName dnsName) {
        return h(dnsName, Record.TYPE.NS);
    }

    public IpVersionSetting i() {
        return this.f33523f;
    }

    /* access modifiers changed from: protected */
    public DnsMessage j(org.minidns.dnsmessage.a aVar) {
        return a(aVar).s();
    }

    /* access modifiers changed from: protected */
    public boolean k(org.minidns.dnsmessage.a aVar, DnsQueryResult dnsQueryResult) {
        for (Record<? extends h> f10 : dnsQueryResult.f33670c.f33593l) {
            if (f10.f(aVar)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract DnsMessage.b l(DnsMessage.b bVar);

    /* access modifiers changed from: protected */
    public abstract DnsQueryResult m(DnsMessage.b bVar) throws IOException;

    public final DnsQueryResult n(DnsMessage dnsMessage, InetAddress inetAddress) throws IOException {
        return o(dnsMessage, inetAddress, 53);
    }

    public final DnsQueryResult o(DnsMessage dnsMessage, InetAddress inetAddress, int i10) throws IOException {
        org.minidns.dnsqueryresult.a aVar;
        nm.a aVar2 = this.f33521d;
        if (aVar2 == null) {
            aVar = null;
        } else {
            aVar = aVar2.a(dnsMessage);
        }
        if (aVar != null) {
            return aVar;
        }
        org.minidns.dnsmessage.a q10 = dnsMessage.q();
        Level level = Level.FINE;
        Logger logger = f33516h;
        logger.log(level, "Asking {0} on {1} for {2} with:\n{3}", new Object[]{inetAddress, Integer.valueOf(i10), q10, dnsMessage});
        try {
            DnsQueryResult a10 = this.f33522e.a(dnsMessage, inetAddress, i10);
            logger.log(level, "Response from {0} on {1} for {2}:\n{3}", new Object[]{inetAddress, Integer.valueOf(i10), q10, a10});
            this.f33518a.a(dnsMessage, a10);
            return a10;
        } catch (IOException e10) {
            f33516h.log(level, "IOException {0} on {1} while resolving {2}: {3}", new Object[]{inetAddress, Integer.valueOf(i10), q10, e10});
            throw e10;
        }
    }

    public DnsQueryResult p(org.minidns.dnsmessage.a aVar) throws IOException {
        return m(a(aVar));
    }

    protected AbstractDnsClient() {
        this(f33515g);
    }
}
