package org.jivesoftware.smack.proxy;

import java.net.InetSocketAddress;
import java.net.Proxy;

public class ProxyInfo {
    private String proxyAddress;
    private String proxyPassword;
    private int proxyPort;
    private final ProxySocketConnection proxySocketConnection;
    private ProxyType proxyType;
    private String proxyUsername;

    /* renamed from: org.jivesoftware.smack.proxy.ProxyInfo$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$proxy$ProxyInfo$ProxyType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                org.jivesoftware.smack.proxy.ProxyInfo$ProxyType[] r0 = org.jivesoftware.smack.proxy.ProxyInfo.ProxyType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smack$proxy$ProxyInfo$ProxyType = r0
                org.jivesoftware.smack.proxy.ProxyInfo$ProxyType r1 = org.jivesoftware.smack.proxy.ProxyInfo.ProxyType.HTTP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$proxy$ProxyInfo$ProxyType     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smack.proxy.ProxyInfo$ProxyType r1 = org.jivesoftware.smack.proxy.ProxyInfo.ProxyType.SOCKS4     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$proxy$ProxyInfo$ProxyType     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.jivesoftware.smack.proxy.ProxyInfo$ProxyType r1 = org.jivesoftware.smack.proxy.ProxyInfo.ProxyType.SOCKS5     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.proxy.ProxyInfo.AnonymousClass1.<clinit>():void");
        }
    }

    public enum ProxyType {
        HTTP,
        SOCKS4,
        SOCKS5
    }

    public ProxyInfo(ProxyType proxyType2, String str, int i10, String str2, String str3) {
        this.proxyType = proxyType2;
        this.proxyAddress = str;
        this.proxyPort = i10;
        this.proxyUsername = str2;
        this.proxyPassword = str3;
        this.proxySocketConnection = ProxySocketConnection.forProxyType(proxyType2).apply(this);
    }

    public static ProxyInfo forHttpProxy(String str, int i10, String str2, String str3) {
        return new ProxyInfo(ProxyType.HTTP, str, i10, str2, str3);
    }

    public static ProxyInfo forSocks4Proxy(String str, int i10, String str2, String str3) {
        return new ProxyInfo(ProxyType.SOCKS4, str, i10, str2, str3);
    }

    public static ProxyInfo forSocks5Proxy(String str, int i10, String str2, String str3) {
        return new ProxyInfo(ProxyType.SOCKS5, str, i10, str2, str3);
    }

    public Proxy.Type getJavaProxyType() {
        int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$proxy$ProxyInfo$ProxyType[this.proxyType.ordinal()];
        if (i10 == 1) {
            return Proxy.Type.HTTP;
        }
        if (i10 == 2 || i10 == 3) {
            return Proxy.Type.SOCKS;
        }
        throw new AssertionError("Invalid proxy type: " + this.proxyType);
    }

    public String getProxyAddress() {
        return this.proxyAddress;
    }

    public String getProxyPassword() {
        return this.proxyPassword;
    }

    public int getProxyPort() {
        return this.proxyPort;
    }

    public ProxySocketConnection getProxySocketConnection() {
        return this.proxySocketConnection;
    }

    public ProxyType getProxyType() {
        return this.proxyType;
    }

    public String getProxyUsername() {
        return this.proxyUsername;
    }

    public Proxy toJavaProxy() {
        return new Proxy(getJavaProxyType(), new InetSocketAddress(this.proxyAddress, this.proxyPort));
    }
}
