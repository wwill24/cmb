package org.minidns;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.minidns.AbstractDnsClient;
import org.minidns.MiniDnsException;
import org.minidns.dnsmessage.DnsMessage;
import org.minidns.dnsqueryresult.DnsQueryResult;
import org.minidns.util.MultipleIoException;
import tm.b;
import tm.c;
import tm.d;
import tm.e;

public class a extends AbstractDnsClient {

    /* renamed from: n  reason: collision with root package name */
    static final List<d> f33533n = new CopyOnWriteArrayList();

    /* renamed from: o  reason: collision with root package name */
    static final Set<Inet4Address> f33534o;

    /* renamed from: p  reason: collision with root package name */
    static final Set<Inet6Address> f33535p = new CopyOnWriteArraySet();

    /* renamed from: q  reason: collision with root package name */
    private static final Set<String> f33536q = Collections.newSetFromMap(new ConcurrentHashMap(4));

    /* renamed from: j  reason: collision with root package name */
    private final Set<InetAddress> f33537j = Collections.newSetFromMap(new ConcurrentHashMap(4));

    /* renamed from: k  reason: collision with root package name */
    private boolean f33538k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f33539l = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f33540m = true;

    /* renamed from: org.minidns.a$a  reason: collision with other inner class name */
    static /* synthetic */ class C0388a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33541a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f33542b;

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
                org.minidns.dnsmessage.DnsMessage$RESPONSE_CODE[] r0 = org.minidns.dnsmessage.DnsMessage.RESPONSE_CODE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f33542b = r0
                r1 = 1
                org.minidns.dnsmessage.DnsMessage$RESPONSE_CODE r2 = org.minidns.dnsmessage.DnsMessage.RESPONSE_CODE.NO_ERROR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f33542b     // Catch:{ NoSuchFieldError -> 0x001d }
                org.minidns.dnsmessage.DnsMessage$RESPONSE_CODE r3 = org.minidns.dnsmessage.DnsMessage.RESPONSE_CODE.NX_DOMAIN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                org.minidns.AbstractDnsClient$IpVersionSetting[] r2 = org.minidns.AbstractDnsClient.IpVersionSetting.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f33541a = r2
                org.minidns.AbstractDnsClient$IpVersionSetting r3 = org.minidns.AbstractDnsClient.IpVersionSetting.v4v6     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = f33541a     // Catch:{ NoSuchFieldError -> 0x0038 }
                org.minidns.AbstractDnsClient$IpVersionSetting r2 = org.minidns.AbstractDnsClient.IpVersionSetting.v6v4     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                int[] r0 = f33541a     // Catch:{ NoSuchFieldError -> 0x0043 }
                org.minidns.AbstractDnsClient$IpVersionSetting r1 = org.minidns.AbstractDnsClient.IpVersionSetting.v4only     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f33541a     // Catch:{ NoSuchFieldError -> 0x004e }
                org.minidns.AbstractDnsClient$IpVersionSetting r1 = org.minidns.AbstractDnsClient.IpVersionSetting.v6only     // Catch:{ NoSuchFieldError -> 0x004e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.minidns.a.C0388a.<clinit>():void");
        }
    }

    static {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        f33534o = copyOnWriteArraySet;
        q(b.f33878d);
        q(c.f33879d);
        q(e.f33880d);
        try {
            copyOnWriteArraySet.add(zm.e.a("8.8.8.8"));
        } catch (IllegalArgumentException e10) {
            AbstractDnsClient.f33516h.log(Level.WARNING, "Could not add static IPv4 DNS Server", e10);
        }
        try {
            f33535p.add(zm.e.b("[2001:4860:4860::8888]"));
        } catch (IllegalArgumentException e11) {
            AbstractDnsClient.f33516h.log(Level.WARNING, "Could not add static IPv6 DNS Server", e11);
        }
    }

    public a(nm.a aVar) {
        super(aVar);
    }

    public static void q(d dVar) {
        if (!dVar.isAvailable()) {
            Logger logger = AbstractDnsClient.f33516h;
            logger.fine("Not adding " + dVar.getName() + " as it is not available.");
            return;
        }
        List<d> list = f33533n;
        synchronized (list) {
            ArrayList arrayList = new ArrayList(list.size() + 1);
            arrayList.addAll(list);
            arrayList.add(dVar);
            Collections.sort(arrayList);
            list.clear();
            list.addAll(arrayList);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        r4 = r2.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0030, code lost:
        if (r4.hasNext() == false) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        r5 = r4.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003e, code lost:
        if (zm.e.c(r5) != false) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        org.minidns.AbstractDnsClient.f33516h.warning("The DNS server lookup mechanism '" + r3.getName() + "' returned an invalid non-IP address result: '" + r5 + "'");
        r4.remove();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006d, code lost:
        if (f33536q.contains(r5) == false) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006f, code lost:
        org.minidns.AbstractDnsClient.f33516h.fine("The DNS server lookup mechanism '" + r3.getName() + "' returned a blacklisted result: '" + r5 + "'");
        r4.remove();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x009a, code lost:
        if (r2.isEmpty() != false) goto L_0x009d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<java.lang.String> r() {
        /*
            java.util.List<tm.d> r0 = f33533n
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L_0x0007:
            r2 = r1
        L_0x0008:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x00bc
            java.lang.Object r3 = r0.next()
            tm.d r3 = (tm.d) r3
            java.util.List r2 = r3.L()     // Catch:{ SecurityException -> 0x0019 }
            goto L_0x0023
        L_0x0019:
            r4 = move-exception
            java.util.logging.Logger r5 = org.minidns.AbstractDnsClient.f33516h
            java.util.logging.Level r6 = java.util.logging.Level.WARNING
            java.lang.String r7 = "Could not lookup DNS server"
            r5.log(r6, r7, r4)
        L_0x0023:
            if (r2 != 0) goto L_0x0026
            goto L_0x0008
        L_0x0026:
            java.util.Iterator r4 = r2.iterator()
        L_0x002a:
            boolean r5 = r4.hasNext()
            java.lang.String r6 = "The DNS server lookup mechanism '"
            if (r5 == 0) goto L_0x0096
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            boolean r7 = zm.e.c(r5)
            java.lang.String r8 = "'"
            if (r7 != 0) goto L_0x0067
            java.util.logging.Logger r7 = org.minidns.AbstractDnsClient.f33516h
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r6)
            java.lang.String r6 = r3.getName()
            r9.append(r6)
            java.lang.String r6 = "' returned an invalid non-IP address result: '"
            r9.append(r6)
            r9.append(r5)
            r9.append(r8)
            java.lang.String r5 = r9.toString()
            r7.warning(r5)
            r4.remove()
            goto L_0x002a
        L_0x0067:
            java.util.Set<java.lang.String> r7 = f33536q
            boolean r7 = r7.contains(r5)
            if (r7 == 0) goto L_0x002a
            java.util.logging.Logger r7 = org.minidns.AbstractDnsClient.f33516h
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r6)
            java.lang.String r6 = r3.getName()
            r9.append(r6)
            java.lang.String r6 = "' returned a blacklisted result: '"
            r9.append(r6)
            r9.append(r5)
            r9.append(r8)
            java.lang.String r5 = r9.toString()
            r7.fine(r5)
            r4.remove()
            goto L_0x002a
        L_0x0096:
            boolean r4 = r2.isEmpty()
            if (r4 != 0) goto L_0x009d
            goto L_0x00bc
        L_0x009d:
            java.util.logging.Logger r2 = org.minidns.AbstractDnsClient.f33516h
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r6)
            java.lang.String r3 = r3.getName()
            r4.append(r3)
            java.lang.String r3 = "' returned not a single valid IP address after sanitazion"
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            r2.warning(r3)
            goto L_0x0007
        L_0x00bc:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.minidns.a.r():java.util.List");
    }

    public static List<InetAddress> s() {
        ArrayList arrayList;
        List<String> r10 = r();
        if (r10 == null) {
            return new ArrayList();
        }
        AbstractDnsClient.IpVersionSetting ipVersionSetting = AbstractDnsClient.f33517i;
        ArrayList arrayList2 = null;
        if (ipVersionSetting.f33529v4) {
            arrayList = new ArrayList(r10.size());
        } else {
            arrayList = null;
        }
        if (ipVersionSetting.f33530v6) {
            arrayList2 = new ArrayList(r10.size());
        }
        int i10 = 0;
        for (String next : r10) {
            try {
                InetAddress byName = InetAddress.getByName(next);
                if (byName instanceof Inet4Address) {
                    if (ipVersionSetting.f33529v4) {
                        arrayList.add((Inet4Address) byName);
                    }
                } else if (!(byName instanceof Inet6Address)) {
                    throw new AssertionError("The address '" + byName + "' is neither of type Inet(4|6)Address");
                } else if (ipVersionSetting.f33530v6) {
                    arrayList2.add((Inet6Address) byName);
                }
                i10++;
            } catch (UnknownHostException e10) {
                AbstractDnsClient.f33516h.log(Level.SEVERE, "Could not transform '" + next + "' to InetAddress", e10);
            }
        }
        ArrayList arrayList3 = new ArrayList(i10);
        int i11 = C0388a.f33541a[ipVersionSetting.ordinal()];
        if (i11 == 1) {
            arrayList3.addAll(arrayList);
            arrayList3.addAll(arrayList2);
        } else if (i11 == 2) {
            arrayList3.addAll(arrayList2);
            arrayList3.addAll(arrayList);
        } else if (i11 == 3) {
            arrayList3.addAll(arrayList);
        } else if (i11 == 4) {
            arrayList3.addAll(arrayList2);
        }
        return arrayList3;
    }

    private List<InetAddress> v() {
        InetAddress inetAddress;
        List<InetAddress> s10 = s();
        if (this.f33540m) {
            InetAddress inetAddress2 = null;
            int i10 = C0388a.f33541a[this.f33523f.ordinal()];
            if (i10 == 1) {
                inetAddress = u();
                inetAddress2 = t();
            } else if (i10 == 2) {
                inetAddress = t();
                inetAddress2 = u();
            } else if (i10 == 3) {
                inetAddress = u();
            } else if (i10 == 4) {
                inetAddress = t();
            } else {
                throw new AssertionError("Unknown ipVersionSetting: " + this.f33523f);
            }
            s10.add(inetAddress);
            if (inetAddress2 != null) {
                s10.add(inetAddress2);
            }
        }
        return s10;
    }

    /* access modifiers changed from: protected */
    public DnsMessage.b l(DnsMessage.b bVar) {
        bVar.B(true);
        bVar.t().i(this.f33522e.b()).h(this.f33538k);
        return bVar;
    }

    public DnsQueryResult m(DnsMessage.b bVar) throws IOException {
        org.minidns.dnsqueryresult.a aVar;
        int i10;
        DnsMessage s10 = l(bVar).s();
        nm.a aVar2 = this.f33521d;
        if (aVar2 == null) {
            aVar = null;
        } else {
            aVar = aVar2.a(s10);
        }
        if (aVar != null) {
            return aVar;
        }
        List<InetAddress> v10 = v();
        ArrayList arrayList = new ArrayList(v10.size());
        for (InetAddress next : v10) {
            if (this.f33537j.contains(next)) {
                AbstractDnsClient.f33516h.finer("Skipping " + next + " because it was marked as \"recursion not available\"");
            } else {
                try {
                    DnsQueryResult n10 = n(s10, next);
                    DnsMessage dnsMessage = n10.f33670c;
                    if (!dnsMessage.f33589h) {
                        if (this.f33537j.add(next)) {
                            AbstractDnsClient.f33516h.warning("The DNS server " + next + " returned a response without the \"recursion available\" (RA) flag set. This likely indicates a misconfiguration because the server is not suitable for DNS resolution");
                        }
                    } else if (this.f33539l || (i10 = C0388a.f33542b[dnsMessage.f33584c.ordinal()]) == 1 || i10 == 2) {
                        return n10;
                    } else {
                        String str = "Response from " + next + " asked for " + s10.q() + " with error code: " + dnsMessage.f33584c + '.';
                        Logger logger = AbstractDnsClient.f33516h;
                        if (!logger.isLoggable(Level.FINE)) {
                            str = str + "\n" + dnsMessage;
                        }
                        logger.warning(str);
                        arrayList.add(new MiniDnsException.ErrorResponseException(s10, n10));
                    }
                } catch (IOException e10) {
                    arrayList.add(e10);
                }
            }
        }
        MultipleIoException.b(arrayList);
        throw new MiniDnsException.NoQueryPossibleException(s10);
    }

    public InetAddress t() {
        return (InetAddress) zm.c.a(f33535p, this.f33520c);
    }

    public InetAddress u() {
        return (InetAddress) zm.c.a(f33534o, this.f33520c);
    }
}
