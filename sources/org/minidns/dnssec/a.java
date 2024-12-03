package org.minidns.dnssec;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;
import org.minidns.AbstractDnsClient;
import org.minidns.dnsmessage.DnsMessage;
import org.minidns.dnsname.DnsName;
import org.minidns.dnsqueryresult.DnsQueryResult;
import org.minidns.dnssec.DnssecValidationFailedException;
import org.minidns.dnssec.c;
import org.minidns.iterative.ReliableDnsClient;
import org.minidns.record.NSEC3;
import org.minidns.record.Record;
import org.minidns.record.d;
import org.minidns.record.f;
import org.minidns.record.g;
import org.minidns.record.h;
import org.minidns.record.i;
import org.minidns.record.m;
import org.minidns.record.q;

public class a extends ReliableDnsClient {

    /* renamed from: p  reason: collision with root package name */
    private static final BigInteger f33682p = new BigInteger("1628686155461064465348252249725010996177649738666492500572664444461532807739744536029771810659241049343994038053541290419968870563183856865780916376571550372513476957870843322273120879361960335192976656756972171258658400305760429696147778001233984421619267530978084631948434496468785021389956803104620471232008587410372348519229650742022804219634190734272506220018657920136902014393834092648785514548876370028925405557661759399901378816916683122474038734912535425670533237815676134840739565610963796427401855723026687073600445461090736240030247906095053875491225879656640052743394090544036297390104110989318819106653199917493");

    /* renamed from: q  reason: collision with root package name */
    private static final DnsName f33683q = DnsName.c("dlv.isc.org");

    /* renamed from: m  reason: collision with root package name */
    private final Map<DnsName, byte[]> f33684m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f33685n;

    /* renamed from: o  reason: collision with root package name */
    private DnsName f33686o;

    /* renamed from: org.minidns.dnssec.a$a  reason: collision with other inner class name */
    static /* synthetic */ class C0390a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33687a;

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
                f33687a = r0
                org.minidns.record.Record$TYPE r1 = org.minidns.record.Record.TYPE.NSEC     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f33687a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.minidns.record.Record$TYPE r1 = org.minidns.record.Record.TYPE.NSEC3     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.minidns.dnssec.a.C0390a.<clinit>():void");
        }
    }

    public a() {
        this(AbstractDnsClient.f33515g);
    }

    private Set<c> A(DnsMessage dnsMessage) throws IOException {
        DnsName dnsName;
        c cVar;
        HashSet hashSet = new HashSet();
        boolean z10 = false;
        org.minidns.dnsmessage.a aVar = dnsMessage.f33592k.get(0);
        List<Record<? extends h>> list = dnsMessage.f33594m;
        Iterator<Record<? extends h>> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                dnsName = null;
                break;
            }
            Record next = it.next();
            if (next.f41571b == Record.TYPE.SOA) {
                dnsName = next.f41570a;
                break;
            }
        }
        if (dnsName != null) {
            boolean z11 = false;
            for (Record next2 : list) {
                int i10 = C0390a.f33687a[next2.f41571b.ordinal()];
                if (i10 == 1) {
                    cVar = d.h(next2.a(m.class), aVar);
                } else if (i10 == 2) {
                    cVar = d.i(dnsName, next2.a(NSEC3.class), aVar);
                }
                if (cVar != null) {
                    hashSet.add(cVar);
                } else {
                    z11 = true;
                }
                z10 = true;
            }
            if (!z10 || z11) {
                List<Record<? extends h>> g10 = dnsMessage.g();
                b C = C(aVar, list, g10);
                if (!z11 || !C.f33690c.isEmpty()) {
                    hashSet.addAll(C.f33690c);
                } else {
                    hashSet.clear();
                }
                if (g10.isEmpty() || g10.size() == list.size()) {
                    return hashSet;
                }
                throw new DnssecValidationFailedException(aVar, "Only some resource records from the authority section are signed!");
            }
            throw new DnssecValidationFailedException(aVar, "Invalid NSEC!");
        }
        throw new DnssecValidationFailedException.AuthorityDoesNotContainSoa(dnsMessage);
    }

    private Set<c> B(Record<f> record) throws IOException {
        DnsName dnsName;
        f fVar = (f) record.f41575f;
        HashSet hashSet = new HashSet();
        Set<c> hashSet2 = new HashSet<>();
        if (this.f33684m.containsKey(record.f41570a)) {
            if (fVar.o(this.f33684m.get(record.f41570a))) {
                return hashSet;
            }
            hashSet.add(new c.C0391c(record));
            return hashSet;
        } else if (record.f41570a.s()) {
            hashSet.add(new c.f());
            return hashSet;
        } else {
            i iVar = null;
            b v10 = v(record.f41570a, Record.TYPE.DS);
            hashSet.addAll(v10.a());
            Iterator<Record<D>> it = v10.f33692b.f33670c.h(g.class).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                g gVar = (g) it.next().f41575f;
                if (fVar.l() == gVar.f41663c) {
                    hashSet2 = v10.a();
                    iVar = gVar;
                    break;
                }
            }
            if (iVar == null) {
                Logger logger = AbstractDnsClient.f33516h;
                logger.fine("There is no DS record for " + record.f41570a + ", server gives empty result");
            }
            if (iVar == null && (dnsName = this.f33686o) != null && !dnsName.r(record.f41570a)) {
                b v11 = v(DnsName.h(record.f41570a, this.f33686o), Record.TYPE.DLV);
                hashSet.addAll(v11.a());
                Iterator<Record<D>> it2 = v11.f33692b.f33670c.h(d.class).iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Record next = it2.next();
                    if (((f) record.f41575f).l() == ((d) next.f41575f).f41663c) {
                        Logger logger2 = AbstractDnsClient.f33516h;
                        logger2.fine("Found DLV for " + record.f41570a + ", awesome.");
                        iVar = (i) next.f41575f;
                        hashSet2 = v11.a();
                        break;
                    }
                }
            }
            if (iVar != null) {
                c g10 = d.g(record, iVar);
                if (g10 == null) {
                    return hashSet2;
                }
                hashSet.add(g10);
                return hashSet;
            } else if (!hashSet.isEmpty()) {
                return hashSet;
            } else {
                hashSet.add(new c.i(record.f41570a));
                return hashSet;
            }
        }
    }

    private b C(org.minidns.dnsmessage.a aVar, Collection<Record<? extends h>> collection, List<Record<? extends h>> list) throws IOException {
        Date date = new Date();
        LinkedList linkedList = new LinkedList();
        b bVar = new b((C0390a) null);
        ArrayList<Record> arrayList = new ArrayList<>(list.size());
        for (Record<? extends h> e10 : list) {
            Record<E> e11 = e10.e(q.class);
            if (e11 != null) {
                q qVar = (q) e11.f41575f;
                if (qVar.f41693h.compareTo(date) < 0 || qVar.f41694j.compareTo(date) > 0) {
                    linkedList.add(qVar);
                } else {
                    arrayList.add(e11);
                }
            }
        }
        if (arrayList.isEmpty()) {
            if (!linkedList.isEmpty()) {
                bVar.f33690c.add(new c.e(aVar, linkedList));
            } else {
                bVar.f33690c.add(new c.h(aVar));
            }
            return bVar;
        }
        for (Record record : arrayList) {
            q qVar2 = (q) record.f41575f;
            ArrayList arrayList2 = new ArrayList(collection.size());
            for (Record next : collection) {
                if (next.f41571b == qVar2.f41688c && next.f41570a.equals(record.f41570a)) {
                    arrayList2.add(next);
                }
            }
            bVar.f33690c.addAll(D(aVar, qVar2, arrayList2));
            if (aVar.f33653a.equals(qVar2.f41696l) && qVar2.f41688c == Record.TYPE.DNSKEY) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    it.remove();
                    if (((f) ((Record) it.next()).e(f.class).f41575f).l() == qVar2.f41695k) {
                        bVar.f33689b = true;
                    }
                }
                bVar.f33688a = true;
            }
            if (!t(record.f41570a.ace, qVar2.f41696l.ace)) {
                Logger logger = AbstractDnsClient.f33516h;
                logger.finer("Records at " + record.f41570a + " are cross-signed with a key from " + qVar2.f41696l);
            } else {
                list.removeAll(arrayList2);
            }
            list.remove(record);
        }
        return bVar;
    }

    private Set<c> D(org.minidns.dnsmessage.a aVar, q qVar, List<Record<? extends h>> list) throws IOException {
        Class<f> cls = f.class;
        HashSet hashSet = new HashSet();
        Record.TYPE type = qVar.f41688c;
        Record.TYPE type2 = Record.TYPE.DNSKEY;
        f fVar = null;
        if (type == type2) {
            Iterator<Record<E>> it = Record.b(cls, list).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Record next = it.next();
                if (((f) next.f41575f).l() == qVar.f41695k) {
                    fVar = (f) next.f41575f;
                    break;
                }
            }
        } else if (aVar.f33654b != Record.TYPE.DS || !qVar.f41696l.equals(aVar.f33653a)) {
            b v10 = v(qVar.f41696l, type2);
            hashSet.addAll(v10.a());
            Iterator<Record<D>> it2 = v10.f33692b.f33670c.h(cls).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Record next2 = it2.next();
                if (((f) next2.f41575f).l() == qVar.f41695k) {
                    fVar = (f) next2.f41575f;
                    break;
                }
            }
        } else {
            hashSet.add(new c.i(aVar.f33653a));
            return hashSet;
        }
        if (fVar != null) {
            c f10 = d.f(list, qVar, fVar);
            if (f10 != null) {
                hashSet.add(f10);
            }
            return hashSet;
        }
        throw new DnssecValidationFailedException(aVar, list.size() + " " + qVar.f41688c + " record(s) are signed using an unknown key.");
    }

    private static boolean t(String str, String str2) {
        if (str.equals(str2) || str2.isEmpty()) {
            return true;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        if (split2.length > split.length) {
            return false;
        }
        for (int i10 = 1; i10 <= split2.length; i10++) {
            if (!split2[split2.length - i10].equals(split[split.length - i10])) {
                return false;
            }
        }
        return true;
    }

    private b u(DnsQueryResult dnsQueryResult) throws IOException {
        Class<q> cls = q.class;
        if (dnsQueryResult == null) {
            return null;
        }
        DnsMessage dnsMessage = dnsQueryResult.f33670c;
        DnsMessage.b a10 = dnsMessage.a();
        Set<c> y10 = y(dnsMessage);
        a10.w(y10.isEmpty());
        List<Record<? extends h>> list = dnsMessage.f33593l;
        List<Record<? extends h>> list2 = dnsMessage.f33594m;
        List<Record<? extends h>> list3 = dnsMessage.f33595n;
        HashSet hashSet = new HashSet();
        Record.c(hashSet, cls, list);
        Record.c(hashSet, cls, list2);
        Record.c(hashSet, cls, list3);
        if (this.f33685n) {
            a10.v(x(list));
            a10.z(x(list2));
            a10.u(x(list3));
        }
        return new b(a10.s(), dnsQueryResult, hashSet, y10);
    }

    private static List<Record<? extends h>> x(List<Record<? extends h>> list) {
        if (list.isEmpty()) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (Record next : list) {
            if (next.f41571b != Record.TYPE.RRSIG) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private Set<c> y(DnsMessage dnsMessage) throws IOException {
        if (!dnsMessage.f33593l.isEmpty()) {
            return z(dnsMessage);
        }
        return A(dnsMessage);
    }

    private Set<c> z(DnsMessage dnsMessage) throws IOException {
        boolean z10 = false;
        org.minidns.dnsmessage.a aVar = dnsMessage.f33592k.get(0);
        List<Record<? extends h>> list = dnsMessage.f33593l;
        List<Record<? extends h>> f10 = dnsMessage.f();
        b C = C(aVar, list, f10);
        Set<c> set = C.f33690c;
        if (!set.isEmpty()) {
            return set;
        }
        HashSet hashSet = new HashSet();
        Iterator<Record<? extends h>> it = f10.iterator();
        while (it.hasNext()) {
            Record<E> e10 = it.next().e(f.class);
            if (e10 != null) {
                Set<c> B = B(e10);
                if (B.isEmpty()) {
                    z10 = true;
                } else {
                    hashSet.addAll(B);
                }
                if (!C.f33689b) {
                    AbstractDnsClient.f33516h.finer("SEP key is not self-signed.");
                }
                it.remove();
            }
        }
        if (C.f33689b && !z10) {
            set.addAll(hashSet);
        }
        if (C.f33688a && !C.f33689b) {
            set.add(new c.g(aVar.f33653a));
        }
        if (!f10.isEmpty()) {
            if (f10.size() == list.size()) {
                set.add(new c.h(aVar));
            } else {
                throw new DnssecValidationFailedException(aVar, "Only some records are signed!");
            }
        }
        return set;
    }

    /* access modifiers changed from: protected */
    public DnsMessage.b l(DnsMessage.b bVar) {
        bVar.t().i(this.f33522e.b()).g();
        bVar.x(true);
        return super.l(bVar);
    }

    public DnsQueryResult p(org.minidns.dnsmessage.a aVar) throws IOException {
        b w10 = w(aVar);
        if (w10.b()) {
            return w10.f33692b;
        }
        throw new IOException();
    }

    /* access modifiers changed from: protected */
    public String q(DnsMessage dnsMessage) {
        if (!dnsMessage.r()) {
            return "DNSSEC OK (DO) flag not set in response";
        }
        if (!dnsMessage.f33591j) {
            return "CHECKING DISABLED (CD) flag not set in response";
        }
        return super.q(dnsMessage);
    }

    public void s(DnsName dnsName, byte[] bArr) {
        this.f33684m.put(dnsName, bArr);
    }

    public b v(CharSequence charSequence, Record.TYPE type) throws IOException {
        return w(new org.minidns.dnsmessage.a(charSequence, type, Record.CLASS.IN));
    }

    public b w(org.minidns.dnsmessage.a aVar) throws IOException {
        return u(super.p(aVar));
    }

    public a(nm.a aVar) {
        super(aVar);
        this.f33684m = new ConcurrentHashMap();
        this.f33685n = true;
        s(DnsName.f33658g, f33682p.toByteArray());
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        boolean f33688a;

        /* renamed from: b  reason: collision with root package name */
        boolean f33689b;

        /* renamed from: c  reason: collision with root package name */
        Set<c> f33690c;

        private b() {
            this.f33688a = false;
            this.f33689b = false;
            this.f33690c = new HashSet();
        }

        /* synthetic */ b(C0390a aVar) {
            this();
        }
    }
}
