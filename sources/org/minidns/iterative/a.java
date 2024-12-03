package org.minidns.iterative;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import org.minidns.AbstractDnsClient;
import org.minidns.dnsmessage.DnsMessage;
import org.minidns.dnsname.DnsName;
import org.minidns.dnsqueryresult.DnsQueryResult;
import org.minidns.iterative.IterativeClientException;
import org.minidns.record.Record;
import org.minidns.record.h;
import org.minidns.record.k;
import org.minidns.util.MultipleIoException;

public class a extends AbstractDnsClient {

    /* renamed from: j  reason: collision with root package name */
    int f33745j = 128;

    /* renamed from: org.minidns.iterative.a$a  reason: collision with other inner class name */
    static /* synthetic */ class C0393a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33746a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f33747b;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|5|6|7|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0038 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0043 */
        static {
            /*
                org.minidns.record.Record$TYPE[] r0 = org.minidns.record.Record.TYPE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f33747b = r0
                r1 = 1
                org.minidns.record.Record$TYPE r2 = org.minidns.record.Record.TYPE.A     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f33747b     // Catch:{ NoSuchFieldError -> 0x001d }
                org.minidns.record.Record$TYPE r3 = org.minidns.record.Record.TYPE.AAAA     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                org.minidns.AbstractDnsClient$IpVersionSetting[] r2 = org.minidns.AbstractDnsClient.IpVersionSetting.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f33746a = r2
                org.minidns.AbstractDnsClient$IpVersionSetting r3 = org.minidns.AbstractDnsClient.IpVersionSetting.v4only     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = f33746a     // Catch:{ NoSuchFieldError -> 0x0038 }
                org.minidns.AbstractDnsClient$IpVersionSetting r2 = org.minidns.AbstractDnsClient.IpVersionSetting.v6only     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                int[] r0 = f33746a     // Catch:{ NoSuchFieldError -> 0x0043 }
                org.minidns.AbstractDnsClient$IpVersionSetting r1 = org.minidns.AbstractDnsClient.IpVersionSetting.v4v6     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f33746a     // Catch:{ NoSuchFieldError -> 0x004e }
                org.minidns.AbstractDnsClient$IpVersionSetting r1 = org.minidns.AbstractDnsClient.IpVersionSetting.v6v4     // Catch:{ NoSuchFieldError -> 0x004e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.minidns.iterative.a.C0393a.<clinit>():void");
        }
    }

    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        final List<InetAddress> f33748a;

        /* renamed from: org.minidns.iterative.a$b$a  reason: collision with other inner class name */
        private static final class C0394a {

            /* renamed from: a  reason: collision with root package name */
            private final Random f33749a;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public final List<InetAddress> f33750b;
            /* access modifiers changed from: private */

            /* renamed from: c  reason: collision with root package name */
            public final List<InetAddress> f33751c;

            /* synthetic */ C0394a(Random random, C0393a aVar) {
                this(random);
            }

            public b c() {
                return new b(this.f33750b, this.f33751c, this.f33749a, (C0393a) null);
            }

            private C0394a(Random random) {
                this.f33750b = new ArrayList(8);
                this.f33751c = new ArrayList(8);
                this.f33749a = random;
            }
        }

        /* synthetic */ b(List list, List list2, Random random, C0393a aVar) {
            this(list, list2, random);
        }

        private b(List<InetAddress> list, List<InetAddress> list2, Random random) {
            int i10;
            int[] iArr = C0393a.f33746a;
            int i11 = iArr[AbstractDnsClient.f33517i.ordinal()];
            if (i11 == 1) {
                i10 = list.size();
            } else if (i11 != 2) {
                i10 = list.size() + list2.size();
            } else {
                i10 = list2.size();
            }
            if (i10 == 0) {
                this.f33748a = Collections.emptyList();
                return;
            }
            if (AbstractDnsClient.f33517i.f33529v4) {
                Collections.shuffle(list, random);
            }
            if (AbstractDnsClient.f33517i.f33530v6) {
                Collections.shuffle(list2, random);
            }
            ArrayList arrayList = new ArrayList(i10);
            int i12 = iArr[AbstractDnsClient.f33517i.ordinal()];
            if (i12 == 1) {
                arrayList.addAll(list);
            } else if (i12 == 2) {
                arrayList.addAll(list2);
            } else if (i12 == 3) {
                arrayList.addAll(list);
                arrayList.addAll(list2);
            } else if (i12 == 4) {
                arrayList.addAll(list2);
                arrayList.addAll(list);
            }
            this.f33748a = Collections.unmodifiableList(arrayList);
        }
    }

    public a(nm.a aVar) {
        super(aVar);
    }

    private DnsQueryResult A(b bVar, DnsMessage dnsMessage, InetAddress inetAddress, DnsName dnsName) throws IOException {
        Record.TYPE type;
        bVar.b(inetAddress, dnsMessage);
        DnsQueryResult n10 = n(dnsMessage, inetAddress);
        DnsMessage dnsMessage2 = n10.f33670c;
        if (dnsMessage2.f33586e) {
            return n10;
        }
        nm.a aVar = this.f33521d;
        if (aVar != null) {
            aVar.c(dnsMessage, n10, dnsName);
        }
        List<Record<? extends h>> g10 = dnsMessage2.g();
        LinkedList linkedList = new LinkedList();
        Iterator<Record<? extends h>> it = g10.iterator();
        while (it.hasNext()) {
            Record<E> e10 = it.next().e(k.class);
            if (e10 == null) {
                it.remove();
            } else {
                Iterator<InetAddress> it2 = C(dnsMessage2, ((k) e10.f41575f).f42186c).f33748a.iterator();
                while (it2.hasNext()) {
                    try {
                        return A(bVar, dnsMessage, it2.next(), e10.f41570a);
                    } catch (IOException e11) {
                        q(e11);
                        AbstractDnsClient.f33516h.log(Level.FINER, "Exception while recursing", e11);
                        bVar.a();
                        linkedList.add(e11);
                        if (!it2.hasNext()) {
                            it.remove();
                        }
                    }
                }
                continue;
            }
        }
        for (Record next : g10) {
            org.minidns.dnsmessage.a q10 = dnsMessage.q();
            DnsName dnsName2 = ((k) next.f41575f).f42186c;
            if (!q10.f33653a.equals(dnsName2) || !((type = q10.f33654b) == Record.TYPE.A || type == Record.TYPE.AAAA)) {
                b bVar2 = null;
                try {
                    bVar2 = B(bVar, dnsName2);
                } catch (IOException e12) {
                    bVar.a();
                    linkedList.add(e12);
                }
                if (bVar2 == null) {
                    continue;
                } else {
                    for (InetAddress A : bVar2.f33748a) {
                        try {
                            return A(bVar, dnsMessage, A, next.f41570a);
                        } catch (IOException e13) {
                            bVar.a();
                            linkedList.add(e13);
                        }
                    }
                    continue;
                }
            }
        }
        MultipleIoException.b(linkedList);
        throw new IterativeClientException.NotAuthoritativeNorGlueRrFound(dnsMessage, n10, dnsName);
    }

    private b B(b bVar, DnsName dnsName) throws IOException {
        DnsMessage dnsMessage;
        b.C0394a y10 = y();
        DnsMessage dnsMessage2 = null;
        if (this.f33523f.f33529v4) {
            org.minidns.dnsmessage.a aVar = new org.minidns.dnsmessage.a(dnsName, Record.TYPE.A);
            DnsQueryResult z10 = z(bVar, j(aVar));
            if (z10 != null) {
                dnsMessage = z10.f33670c;
            } else {
                dnsMessage = null;
            }
            if (dnsMessage != null) {
                for (Record next : dnsMessage.f33593l) {
                    if (next.f(aVar)) {
                        y10.f33750b.add(w(dnsName.ace, (org.minidns.record.a) next.f41575f));
                    } else if (next.f41571b == Record.TYPE.CNAME && next.f41570a.equals(dnsName)) {
                        return B(bVar, ((ym.b) next.f41575f).f42186c);
                    }
                }
            }
        }
        if (this.f33523f.f33530v6) {
            org.minidns.dnsmessage.a aVar2 = new org.minidns.dnsmessage.a(dnsName, Record.TYPE.AAAA);
            DnsQueryResult z11 = z(bVar, j(aVar2));
            if (z11 != null) {
                dnsMessage2 = z11.f33670c;
            }
            if (dnsMessage2 != null) {
                for (Record next2 : dnsMessage2.f33593l) {
                    if (next2.f(aVar2)) {
                        y10.f33751c.add(x(dnsName.ace, (org.minidns.record.b) next2.f41575f));
                    } else if (next2.f41571b == Record.TYPE.CNAME && next2.f41570a.equals(dnsName)) {
                        return B(bVar, ((ym.b) next2.f41575f).f42186c);
                    }
                }
            }
        }
        return y10.c();
    }

    private b C(DnsMessage dnsMessage, DnsName dnsName) {
        b.C0394a y10 = y();
        for (Record next : dnsMessage.f33595n) {
            if (next.f41570a.equals(dnsName)) {
                int i10 = C0393a.f33747b[next.f41571b.ordinal()];
                if (i10 == 1) {
                    y10.f33750b.add(w(dnsName.ace, (org.minidns.record.a) next.f41575f));
                } else if (i10 == 2) {
                    y10.f33751c.add(x(dnsName.ace, (org.minidns.record.b) next.f41575f));
                }
            }
        }
        return y10.c();
    }

    protected static void q(IOException iOException) throws IOException {
        if (iOException instanceof IterativeClientException.LoopDetected) {
            throw iOException;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0028, code lost:
        if (r0[1] != null) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002a, code lost:
        r0[1] = r1.j();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.net.InetAddress[] v(java.util.Collection<? extends ym.a<? extends java.net.InetAddress>> r5, java.util.Collection<? extends ym.a<? extends java.net.InetAddress>> r6) {
        /*
            r0 = 2
            java.net.InetAddress[] r0 = new java.net.InetAddress[r0]
            java.util.Iterator r5 = r5.iterator()
        L_0x0007:
            boolean r1 = r5.hasNext()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0030
            java.lang.Object r1 = r5.next()
            ym.a r1 = (ym.a) r1
            r4 = r0[r3]
            if (r4 != 0) goto L_0x0026
            java.net.InetAddress r4 = r1.j()
            r0[r3] = r4
            boolean r4 = r6.isEmpty()
            if (r4 == 0) goto L_0x0026
            goto L_0x0007
        L_0x0026:
            r5 = r0[r2]
            if (r5 != 0) goto L_0x0030
            java.net.InetAddress r5 = r1.j()
            r0[r2] = r5
        L_0x0030:
            java.util.Iterator r5 = r6.iterator()
        L_0x0034:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0055
            java.lang.Object r6 = r5.next()
            ym.a r6 = (ym.a) r6
            r1 = r0[r3]
            if (r1 != 0) goto L_0x004b
            java.net.InetAddress r6 = r6.j()
            r0[r3] = r6
            goto L_0x0034
        L_0x004b:
            r5 = r0[r2]
            if (r5 != 0) goto L_0x0055
            java.net.InetAddress r5 = r6.j()
            r0[r2] = r5
        L_0x0055:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.minidns.iterative.a.v(java.util.Collection, java.util.Collection):java.net.InetAddress[]");
    }

    private static InetAddress w(String str, org.minidns.record.a aVar) {
        try {
            return InetAddress.getByAddress(str, aVar.k());
        } catch (UnknownHostException e10) {
            throw new RuntimeException(e10);
        }
    }

    private static InetAddress x(String str, org.minidns.record.b bVar) {
        try {
            return InetAddress.getByAddress(str, bVar.k());
        } catch (UnknownHostException e10) {
            throw new RuntimeException(e10);
        }
    }

    private b.C0394a y() {
        return new b.C0394a(this.f33520c, (C0393a) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x008f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.minidns.dnsqueryresult.DnsQueryResult z(org.minidns.iterative.b r11, org.minidns.dnsmessage.DnsMessage r12) throws java.io.IOException {
        /*
            r10 = this;
            org.minidns.dnsmessage.a r0 = r12.q()
            org.minidns.dnsname.DnsName r0 = r0.f33653a
            org.minidns.dnsname.DnsName r0 = r0.p()
            int[] r1 = org.minidns.iterative.a.C0393a.f33746a
            org.minidns.AbstractDnsClient$IpVersionSetting r2 = r10.f33523f
            int r2 = r2.ordinal()
            r1 = r1[r2]
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 0
            r6 = 1
            if (r1 == r6) goto L_0x006d
            if (r1 == r4) goto L_0x004a
            r7 = 0
            if (r1 == r3) goto L_0x0039
            if (r1 != r2) goto L_0x0033
            java.util.Set r1 = r10.f(r0)
            java.util.Set r8 = r10.d(r0)
            java.net.InetAddress[] r1 = v(r1, r8)
            r7 = r1[r7]
            r1 = r1[r6]
            goto L_0x008d
        L_0x0033:
            java.lang.AssertionError r11 = new java.lang.AssertionError
            r11.<init>()
            throw r11
        L_0x0039:
            java.util.Set r1 = r10.d(r0)
            java.util.Set r8 = r10.f(r0)
            java.net.InetAddress[] r1 = v(r1, r8)
            r7 = r1[r7]
            r1 = r1[r6]
            goto L_0x008d
        L_0x004a:
            java.util.Set r1 = r10.f(r0)
            java.util.Iterator r1 = r1.iterator()
            r7 = r5
        L_0x0053:
            boolean r8 = r1.hasNext()
            if (r8 == 0) goto L_0x006b
            java.lang.Object r8 = r1.next()
            org.minidns.record.b r8 = (org.minidns.record.b) r8
            if (r7 != 0) goto L_0x0066
            java.net.InetAddress r7 = r8.j()
            goto L_0x0053
        L_0x0066:
            java.net.InetAddress r1 = r8.j()
            goto L_0x008d
        L_0x006b:
            r1 = r5
            goto L_0x008d
        L_0x006d:
            java.util.Set r1 = r10.d(r0)
            java.util.Iterator r1 = r1.iterator()
            r7 = r5
        L_0x0076:
            boolean r8 = r1.hasNext()
            if (r8 == 0) goto L_0x006b
            java.lang.Object r8 = r1.next()
            org.minidns.record.a r8 = (org.minidns.record.a) r8
            if (r7 != 0) goto L_0x0089
            java.net.InetAddress r7 = r8.j()
            goto L_0x0076
        L_0x0089:
            java.net.InetAddress r1 = r8.j()
        L_0x008d:
            if (r7 != 0) goto L_0x00cb
            org.minidns.dnsname.DnsName r0 = org.minidns.dnsname.DnsName.f33658g
            int[] r8 = org.minidns.iterative.a.C0393a.f33746a
            org.minidns.AbstractDnsClient$IpVersionSetting r9 = r10.f33523f
            int r9 = r9.ordinal()
            r8 = r8[r9]
            if (r8 == r6) goto L_0x00c5
            if (r8 == r4) goto L_0x00be
            if (r8 == r3) goto L_0x00b1
            if (r8 == r2) goto L_0x00a4
            goto L_0x00cb
        L_0x00a4:
            java.util.Random r1 = r10.f33520c
            java.net.Inet6Address r7 = om.a.b(r1)
            java.util.Random r1 = r10.f33520c
            java.net.Inet4Address r1 = om.a.a(r1)
            goto L_0x00cb
        L_0x00b1:
            java.util.Random r1 = r10.f33520c
            java.net.Inet4Address r7 = om.a.a(r1)
            java.util.Random r1 = r10.f33520c
            java.net.Inet6Address r1 = om.a.b(r1)
            goto L_0x00cb
        L_0x00be:
            java.util.Random r2 = r10.f33520c
            java.net.Inet6Address r7 = om.a.b(r2)
            goto L_0x00cb
        L_0x00c5:
            java.util.Random r2 = r10.f33520c
            java.net.Inet4Address r7 = om.a.a(r2)
        L_0x00cb:
            java.util.LinkedList r2 = new java.util.LinkedList
            r2.<init>()
            org.minidns.dnsqueryresult.DnsQueryResult r11 = r10.A(r11, r12, r7, r0)     // Catch:{ IOException -> 0x00d5 }
            return r11
        L_0x00d5:
            r3 = move-exception
            q(r3)
            r2.add(r3)
            if (r1 == 0) goto L_0x00e7
            org.minidns.dnsqueryresult.DnsQueryResult r11 = r10.A(r11, r12, r1, r0)     // Catch:{ IOException -> 0x00e3 }
            return r11
        L_0x00e3:
            r11 = move-exception
            r2.add(r11)
        L_0x00e7:
            org.minidns.util.MultipleIoException.b(r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.minidns.iterative.a.z(org.minidns.iterative.b, org.minidns.dnsmessage.DnsMessage):org.minidns.dnsqueryresult.DnsQueryResult");
    }

    /* access modifiers changed from: protected */
    public boolean k(org.minidns.dnsmessage.a aVar, DnsQueryResult dnsQueryResult) {
        return dnsQueryResult.f33670c.f33586e;
    }

    /* access modifiers changed from: protected */
    public DnsMessage.b l(DnsMessage.b bVar) {
        bVar.B(false);
        bVar.t().i(this.f33522e.b());
        return bVar;
    }

    /* access modifiers changed from: protected */
    public DnsQueryResult m(DnsMessage.b bVar) throws IOException {
        return z(new b(this), bVar.s());
    }
}
