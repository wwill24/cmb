package org.jivesoftware.smack.proxy;

import java.io.IOException;
import java.net.Socket;
import org.jivesoftware.smack.proxy.ProxyInfo;
import org.jivesoftware.smack.util.Function;

public interface ProxySocketConnection {

    /* renamed from: org.jivesoftware.smack.proxy.ProxySocketConnection$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.proxy.ProxySocketConnection.AnonymousClass1.<clinit>():void");
        }
    }

    static Function<ProxySocketConnection, ProxyInfo> forProxyType(ProxyInfo.ProxyType proxyType) {
        int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$proxy$ProxyInfo$ProxyType[proxyType.ordinal()];
        if (i10 == 1) {
            return new a();
        }
        if (i10 == 2) {
            return new b();
        }
        if (i10 == 3) {
            return new c();
        }
        throw new AssertionError("Unknown proxy type: " + proxyType);
    }

    void connect(Socket socket, String str, int i10, int i11) throws IOException;
}
