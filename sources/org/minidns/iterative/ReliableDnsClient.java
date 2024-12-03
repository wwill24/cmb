package org.minidns.iterative;

import org.minidns.AbstractDnsClient;
import org.minidns.dnsmessage.DnsMessage;
import org.minidns.dnsqueryresult.DnsQueryResult;

public class ReliableDnsClient extends AbstractDnsClient {

    /* renamed from: j  reason: collision with root package name */
    private final a f33736j;

    /* renamed from: k  reason: collision with root package name */
    private final org.minidns.a f33737k;

    /* renamed from: l  reason: collision with root package name */
    private Mode f33738l;

    public enum Mode {
        recursiveWithIterativeFallback,
        recursiveOnly,
        iterativeOnly
    }

    class a extends a {
        a(nm.a aVar) {
            super(aVar);
        }

        /* access modifiers changed from: protected */
        public boolean k(org.minidns.dnsmessage.a aVar, DnsQueryResult dnsQueryResult) {
            boolean k10 = super.k(aVar, dnsQueryResult);
            if (!ReliableDnsClient.this.k(aVar, dnsQueryResult) || !k10) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: protected */
        public DnsMessage.b l(DnsMessage.b bVar) {
            return ReliableDnsClient.this.l(super.l(bVar));
        }
    }

    class b extends org.minidns.a {
        b(nm.a aVar) {
            super(aVar);
        }

        /* access modifiers changed from: protected */
        public boolean k(org.minidns.dnsmessage.a aVar, DnsQueryResult dnsQueryResult) {
            boolean k10 = super.k(aVar, dnsQueryResult);
            if (!ReliableDnsClient.this.k(aVar, dnsQueryResult) || !k10) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: protected */
        public DnsMessage.b l(DnsMessage.b bVar) {
            return ReliableDnsClient.this.l(super.l(bVar));
        }
    }

    public ReliableDnsClient(nm.a aVar) {
        super(aVar);
        this.f33738l = Mode.recursiveWithIterativeFallback;
        this.f33736j = new a(aVar);
        this.f33737k = new b(aVar);
    }

    /* access modifiers changed from: protected */
    public boolean k(org.minidns.dnsmessage.a aVar, DnsQueryResult dnsQueryResult) {
        return q(dnsQueryResult.f33670c) == null;
    }

    /* access modifiers changed from: protected */
    public DnsMessage.b l(DnsMessage.b bVar) {
        return bVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: org.minidns.dnsqueryresult.DnsQueryResult} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v7, types: [java.lang.String] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0031 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0032  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.minidns.dnsqueryresult.DnsQueryResult m(org.minidns.dnsmessage.DnsMessage.b r9) throws java.io.IOException {
        /*
            r8 = this;
            java.util.LinkedList r0 = new java.util.LinkedList
            r0.<init>()
            org.minidns.iterative.ReliableDnsClient$Mode r1 = r8.f33738l
            org.minidns.iterative.ReliableDnsClient$Mode r2 = org.minidns.iterative.ReliableDnsClient.Mode.iterativeOnly
            r3 = 0
            if (r1 == r2) goto L_0x002a
            org.minidns.a r1 = r8.f33737k     // Catch:{ IOException -> 0x0021 }
            org.minidns.dnsqueryresult.DnsQueryResult r1 = r1.m(r9)     // Catch:{ IOException -> 0x0021 }
            if (r1 == 0) goto L_0x0026
            org.minidns.dnsmessage.DnsMessage r2 = r1.f33670c     // Catch:{ IOException -> 0x001f }
            java.lang.String r2 = r8.q(r2)     // Catch:{ IOException -> 0x001f }
            if (r2 != 0) goto L_0x001d
            return r1
        L_0x001d:
            r3 = r2
            goto L_0x0026
        L_0x001f:
            r2 = move-exception
            goto L_0x0023
        L_0x0021:
            r2 = move-exception
            r1 = r3
        L_0x0023:
            r0.add(r2)
        L_0x0026:
            r7 = r3
            r3 = r1
            r1 = r7
            goto L_0x002b
        L_0x002a:
            r1 = r3
        L_0x002b:
            org.minidns.iterative.ReliableDnsClient$Mode r2 = r8.f33738l
            org.minidns.iterative.ReliableDnsClient$Mode r4 = org.minidns.iterative.ReliableDnsClient.Mode.recursiveOnly
            if (r2 != r4) goto L_0x0032
            return r3
        L_0x0032:
            java.util.logging.Level r2 = java.util.logging.Level.FINE
            java.util.logging.Logger r4 = org.minidns.AbstractDnsClient.f33516h
            boolean r5 = r4.isLoggable(r2)
            if (r5 == 0) goto L_0x0098
            org.minidns.iterative.ReliableDnsClient$Mode r5 = r8.f33738l
            org.minidns.iterative.ReliableDnsClient$Mode r6 = org.minidns.iterative.ReliableDnsClient.Mode.iterativeOnly
            if (r5 == r6) goto L_0x0098
            java.lang.String r5 = "Resolution fall back to iterative mode because: "
            boolean r6 = r0.isEmpty()
            if (r6 != 0) goto L_0x005f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r5)
            r5 = 0
            java.lang.Object r5 = r0.get(r5)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            goto L_0x008c
        L_0x005f:
            if (r3 != 0) goto L_0x0073
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r5)
            java.lang.String r5 = " DnsClient did not return a response"
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            goto L_0x008c
        L_0x0073:
            if (r1 == 0) goto L_0x0090
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r5)
            r6.append(r1)
            java.lang.String r1 = ". Response:\n"
            r6.append(r1)
            r6.append(r3)
            java.lang.String r1 = r6.toString()
        L_0x008c:
            r4.log(r2, r1)
            goto L_0x0098
        L_0x0090:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            java.lang.String r0 = "This should never been reached"
            r9.<init>(r0)
            throw r9
        L_0x0098:
            org.minidns.iterative.a r1 = r8.f33736j     // Catch:{ IOException -> 0x009f }
            org.minidns.dnsqueryresult.DnsQueryResult r3 = r1.m(r9)     // Catch:{ IOException -> 0x009f }
            goto L_0x00a3
        L_0x009f:
            r9 = move-exception
            r0.add(r9)
        L_0x00a3:
            if (r3 != 0) goto L_0x00a8
            org.minidns.util.MultipleIoException.b(r0)
        L_0x00a8:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.minidns.iterative.ReliableDnsClient.m(org.minidns.dnsmessage.DnsMessage$b):org.minidns.dnsqueryresult.DnsQueryResult");
    }

    /* access modifiers changed from: protected */
    public String q(DnsMessage dnsMessage) {
        return null;
    }

    public void r(Mode mode) {
        if (mode != null) {
            this.f33738l = mode;
            return;
        }
        throw new IllegalArgumentException("Mode must not be null.");
    }

    public ReliableDnsClient() {
        this(AbstractDnsClient.f33515g);
    }
}
