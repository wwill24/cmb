package org.minidns.source;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.minidns.dnsmessage.DnsMessage;
import org.minidns.dnsqueryresult.DnsQueryResult;
import org.minidns.source.AbstractDnsDataSource;
import org.minidns.util.MultipleIoException;

public class b extends AbstractDnsDataSource {

    /* renamed from: d  reason: collision with root package name */
    protected static final Logger f41723d = Logger.getLogger(b.class.getName());

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f41724a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                org.minidns.source.AbstractDnsDataSource$QueryMode[] r0 = org.minidns.source.AbstractDnsDataSource.QueryMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f41724a = r0
                org.minidns.source.AbstractDnsDataSource$QueryMode r1 = org.minidns.source.AbstractDnsDataSource.QueryMode.dontCare     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f41724a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.minidns.source.AbstractDnsDataSource$QueryMode r1 = org.minidns.source.AbstractDnsDataSource.QueryMode.udpTcp     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f41724a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.minidns.source.AbstractDnsDataSource$QueryMode r1 = org.minidns.source.AbstractDnsDataSource.QueryMode.tcp     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.minidns.source.b.a.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public DatagramSocket d() throws SocketException {
        return new DatagramSocket();
    }

    /* access modifiers changed from: protected */
    public Socket e() {
        return new Socket();
    }

    /* renamed from: f */
    public org.minidns.dnsqueryresult.b a(DnsMessage dnsMessage, InetAddress inetAddress, int i10) throws IOException {
        boolean z10;
        Object obj;
        AbstractDnsDataSource.QueryMode c10 = c();
        int i11 = a.f41724a[c10.ordinal()];
        if (i11 == 1 || i11 == 2) {
            z10 = true;
        } else if (i11 == 3) {
            z10 = false;
        } else {
            throw new IllegalStateException("Unsupported query mode: " + c10);
        }
        ArrayList arrayList = new ArrayList(2);
        DnsMessage dnsMessage2 = null;
        if (z10) {
            try {
                dnsMessage2 = h(dnsMessage, inetAddress, i10);
            } catch (IOException e10) {
                arrayList.add(e10);
            }
            DnsMessage dnsMessage3 = dnsMessage2;
            if (dnsMessage3 == null || dnsMessage3.f33587f) {
                Logger logger = f41723d;
                Level level = Level.FINE;
                Object[] objArr = new Object[1];
                if (dnsMessage3 != null) {
                    obj = "response is truncated";
                } else {
                    obj = arrayList.get(0);
                }
                objArr[0] = obj;
                logger.log(level, "Fallback to TCP because {0}", objArr);
                dnsMessage2 = dnsMessage3;
            } else {
                return new org.minidns.dnsqueryresult.b(inetAddress, i10, DnsQueryResult.QueryMethod.udp, dnsMessage, dnsMessage3);
            }
        }
        try {
            dnsMessage2 = g(dnsMessage, inetAddress, i10);
        } catch (IOException e11) {
            arrayList.add(e11);
            MultipleIoException.b(arrayList);
        }
        return new org.minidns.dnsqueryresult.b(inetAddress, i10, DnsQueryResult.QueryMethod.tcp, dnsMessage, dnsMessage2);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.minidns.dnsmessage.DnsMessage g(org.minidns.dnsmessage.DnsMessage r5, java.net.InetAddress r6, int r7) throws java.io.IOException {
        /*
            r4 = this;
            java.net.Socket r0 = r4.e()     // Catch:{ all -> 0x0053 }
            java.net.InetSocketAddress r1 = new java.net.InetSocketAddress     // Catch:{ all -> 0x0051 }
            r1.<init>(r6, r7)     // Catch:{ all -> 0x0051 }
            int r6 = r4.f41717b     // Catch:{ all -> 0x0051 }
            r0.connect(r1, r6)     // Catch:{ all -> 0x0051 }
            int r6 = r4.f41717b     // Catch:{ all -> 0x0051 }
            r0.setSoTimeout(r6)     // Catch:{ all -> 0x0051 }
            java.io.DataOutputStream r6 = new java.io.DataOutputStream     // Catch:{ all -> 0x0051 }
            java.io.OutputStream r7 = r0.getOutputStream()     // Catch:{ all -> 0x0051 }
            r6.<init>(r7)     // Catch:{ all -> 0x0051 }
            r5.t(r6)     // Catch:{ all -> 0x0051 }
            r6.flush()     // Catch:{ all -> 0x0051 }
            java.io.DataInputStream r6 = new java.io.DataInputStream     // Catch:{ all -> 0x0051 }
            java.io.InputStream r7 = r0.getInputStream()     // Catch:{ all -> 0x0051 }
            r6.<init>(r7)     // Catch:{ all -> 0x0051 }
            int r7 = r6.readUnsignedShort()     // Catch:{ all -> 0x0051 }
            byte[] r1 = new byte[r7]     // Catch:{ all -> 0x0051 }
            r2 = 0
        L_0x0032:
            if (r2 >= r7) goto L_0x003c
            int r3 = r7 - r2
            int r3 = r6.read(r1, r2, r3)     // Catch:{ all -> 0x0051 }
            int r2 = r2 + r3
            goto L_0x0032
        L_0x003c:
            org.minidns.dnsmessage.DnsMessage r6 = new org.minidns.dnsmessage.DnsMessage     // Catch:{ all -> 0x0051 }
            r6.<init>((byte[]) r1)     // Catch:{ all -> 0x0051 }
            int r7 = r6.f33582a     // Catch:{ all -> 0x0051 }
            int r1 = r5.f33582a     // Catch:{ all -> 0x0051 }
            if (r7 != r1) goto L_0x004b
            r0.close()
            return r6
        L_0x004b:
            org.minidns.MiniDnsException$IdMismatch r7 = new org.minidns.MiniDnsException$IdMismatch     // Catch:{ all -> 0x0051 }
            r7.<init>(r5, r6)     // Catch:{ all -> 0x0051 }
            throw r7     // Catch:{ all -> 0x0051 }
        L_0x0051:
            r5 = move-exception
            goto L_0x0055
        L_0x0053:
            r5 = move-exception
            r0 = 0
        L_0x0055:
            if (r0 == 0) goto L_0x005a
            r0.close()
        L_0x005a:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.minidns.source.b.g(org.minidns.dnsmessage.DnsMessage, java.net.InetAddress, int):org.minidns.dnsmessage.DnsMessage");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.minidns.dnsmessage.DnsMessage h(org.minidns.dnsmessage.DnsMessage r4, java.net.InetAddress r5, int r6) throws java.io.IOException {
        /*
            r3 = this;
            java.net.DatagramPacket r5 = r4.b(r5, r6)
            int r6 = r3.f41716a
            byte[] r0 = new byte[r6]
            java.net.DatagramSocket r1 = r3.d()     // Catch:{ all -> 0x0037 }
            int r2 = r3.f41717b     // Catch:{ all -> 0x0035 }
            r1.setSoTimeout(r2)     // Catch:{ all -> 0x0035 }
            r1.send(r5)     // Catch:{ all -> 0x0035 }
            java.net.DatagramPacket r5 = new java.net.DatagramPacket     // Catch:{ all -> 0x0035 }
            r5.<init>(r0, r6)     // Catch:{ all -> 0x0035 }
            r1.receive(r5)     // Catch:{ all -> 0x0035 }
            org.minidns.dnsmessage.DnsMessage r6 = new org.minidns.dnsmessage.DnsMessage     // Catch:{ all -> 0x0035 }
            byte[] r5 = r5.getData()     // Catch:{ all -> 0x0035 }
            r6.<init>((byte[]) r5)     // Catch:{ all -> 0x0035 }
            int r5 = r6.f33582a     // Catch:{ all -> 0x0035 }
            int r0 = r4.f33582a     // Catch:{ all -> 0x0035 }
            if (r5 != r0) goto L_0x002f
            r1.close()
            return r6
        L_0x002f:
            org.minidns.MiniDnsException$IdMismatch r5 = new org.minidns.MiniDnsException$IdMismatch     // Catch:{ all -> 0x0035 }
            r5.<init>(r4, r6)     // Catch:{ all -> 0x0035 }
            throw r5     // Catch:{ all -> 0x0035 }
        L_0x0035:
            r4 = move-exception
            goto L_0x0039
        L_0x0037:
            r4 = move-exception
            r1 = 0
        L_0x0039:
            if (r1 == 0) goto L_0x003e
            r1.close()
        L_0x003e:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.minidns.source.b.h(org.minidns.dnsmessage.DnsMessage, java.net.InetAddress, int):org.minidns.dnsmessage.DnsMessage");
    }
}
