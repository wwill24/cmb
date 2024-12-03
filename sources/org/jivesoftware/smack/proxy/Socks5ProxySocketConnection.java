package org.jivesoftware.smack.proxy;

public class Socks5ProxySocketConnection implements ProxySocketConnection {
    private final ProxyInfo proxy;

    Socks5ProxySocketConnection(ProxyInfo proxyInfo) {
        this.proxy = proxyInfo;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0083, code lost:
        if (r2[1] == 0) goto L_0x0088;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x010a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect(java.net.Socket r10, java.lang.String r11, int r12, int r13) throws java.io.IOException {
        /*
            r9 = this;
            org.jivesoftware.smack.proxy.ProxyInfo r0 = r9.proxy
            java.lang.String r0 = r0.getProxyAddress()
            org.jivesoftware.smack.proxy.ProxyInfo r1 = r9.proxy
            int r1 = r1.getProxyPort()
            org.jivesoftware.smack.proxy.ProxyInfo r2 = r9.proxy
            java.lang.String r2 = r2.getProxyUsername()
            org.jivesoftware.smack.proxy.ProxyInfo r3 = r9.proxy
            java.lang.String r3 = r3.getProxyPassword()
            java.net.InetSocketAddress r4 = new java.net.InetSocketAddress
            r4.<init>(r0, r1)
            r10.connect(r4, r13)
            java.io.InputStream r13 = r10.getInputStream()
            java.io.DataInputStream r0 = new java.io.DataInputStream
            r0.<init>(r13)
            java.io.OutputStream r10 = r10.getOutputStream()
            java.io.ByteArrayOutputStream r13 = new java.io.ByteArrayOutputStream
            r13.<init>()
            r1 = 5
            r13.write(r1)
            r4 = 2
            r13.write(r4)
            r5 = 0
            r13.write(r5)
            r13.write(r4)
            org.jivesoftware.smack.util.OutputStreamUtil.writeResetAndFlush(r13, r10)
            byte[] r6 = new byte[r4]
            r0.readFully(r6)
            r7 = 1
            byte r6 = r6[r7]
            r6 = r6 & 255(0xff, float:3.57E-43)
            if (r6 == 0) goto L_0x0088
            if (r6 == r4) goto L_0x0053
            goto L_0x0086
        L_0x0053:
            if (r2 == 0) goto L_0x0086
            if (r3 != 0) goto L_0x0058
            goto L_0x0086
        L_0x0058:
            r13.write(r7)
            java.nio.charset.Charset r6 = java.nio.charset.StandardCharsets.UTF_8
            byte[] r2 = r2.getBytes(r6)
            int r6 = r2.length
            java.lang.String r8 = "Username to long"
            org.jivesoftware.smack.util.OutputStreamUtil.writeByteSafe(r13, r6, r8)
            r13.write(r2)
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.UTF_8
            byte[] r2 = r3.getBytes(r2)
            int r3 = r2.length
            java.lang.String r6 = "Password to long"
            org.jivesoftware.smack.util.OutputStreamUtil.writeByteSafe(r13, r3, r6)
            r13.write(r2)
            org.jivesoftware.smack.util.OutputStreamUtil.writeResetAndFlush(r13, r10)
            byte[] r2 = new byte[r4]
            r0.readFully(r2)
            byte r2 = r2[r7]
            if (r2 != 0) goto L_0x0086
            goto L_0x0088
        L_0x0086:
            r2 = r5
            goto L_0x0089
        L_0x0088:
            r2 = r7
        L_0x0089:
            if (r2 == 0) goto L_0x010a
            r13.write(r1)
            r13.write(r7)
            r13.write(r5)
            java.nio.charset.Charset r1 = java.nio.charset.StandardCharsets.UTF_8
            byte[] r11 = r11.getBytes(r1)
            int r1 = r11.length
            r2 = 3
            r13.write(r2)
            java.lang.String r3 = "Hostname too long"
            org.jivesoftware.smack.util.OutputStreamUtil.writeByteSafe(r13, r1, r3)
            r13.write(r11)
            int r11 = r12 >>> 8
            r13.write(r11)
            r11 = r12 & 255(0xff, float:3.57E-43)
            r13.write(r11)
            org.jivesoftware.smack.util.OutputStreamUtil.writeResetAndFlush(r13, r10)
            r10 = 4
            byte[] r11 = new byte[r10]
            r0.readFully(r11)
            byte r12 = r11[r7]
            if (r12 != 0) goto L_0x00ef
            byte r11 = r11[r2]
            r11 = r11 & 255(0xff, float:3.57E-43)
            if (r11 == r7) goto L_0x00e8
            if (r11 == r2) goto L_0x00e2
            if (r11 != r10) goto L_0x00cb
            r10 = 16
            goto L_0x00e8
        L_0x00cb:
            java.io.IOException r10 = new java.io.IOException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "Unknown ATYP value: "
            r12.append(r13)
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            r10.<init>(r11)
            throw r10
        L_0x00e2:
            byte r10 = r0.readByte()
            r10 = r10 & 255(0xff, float:3.57E-43)
        L_0x00e8:
            int r10 = r10 + r4
            byte[] r10 = new byte[r10]
            r0.readFully(r10)
            return
        L_0x00ef:
            org.jivesoftware.smack.proxy.ProxyException r10 = new org.jivesoftware.smack.proxy.ProxyException
            org.jivesoftware.smack.proxy.ProxyInfo$ProxyType r12 = org.jivesoftware.smack.proxy.ProxyInfo.ProxyType.SOCKS5
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r0 = "server returns "
            r13.append(r0)
            byte r11 = r11[r7]
            r13.append(r11)
            java.lang.String r11 = r13.toString()
            r10.<init>(r12, r11)
            throw r10
        L_0x010a:
            org.jivesoftware.smack.proxy.ProxyException r10 = new org.jivesoftware.smack.proxy.ProxyException
            org.jivesoftware.smack.proxy.ProxyInfo$ProxyType r11 = org.jivesoftware.smack.proxy.ProxyInfo.ProxyType.SOCKS5
            java.lang.String r12 = "fail in SOCKS5 proxy"
            r10.<init>(r11, r12)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.proxy.Socks5ProxySocketConnection.connect(java.net.Socket, java.lang.String, int, int):void");
    }
}
