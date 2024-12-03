package com.leanplum.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Base64;
import com.leanplum.internal.HybiParser;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URI;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import org.apache.http.Header;
import org.apache.http.StatusLine;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.BasicNameValuePair;
import org.jivesoftware.smack.util.TLSUtils;

class WebSocketClient {
    private static final String TAG = "WebSocketClient";
    private static TrustManager[] sTrustManagers;
    /* access modifiers changed from: private */
    public List<BasicNameValuePair> mExtraHeaders;
    private Handler mHandler;
    /* access modifiers changed from: private */
    public HandlerThread mHandlerThread;
    /* access modifiers changed from: private */
    public volatile Listener mListener;
    /* access modifiers changed from: private */
    public HybiParser mParser;
    /* access modifiers changed from: private */
    public final Object mSendLock = new Object();
    /* access modifiers changed from: private */
    public Socket mSocket;
    private Thread mThread;
    /* access modifiers changed from: private */
    public URI mURI;

    private static final class DummyListener implements Listener {
        private DummyListener() {
        }

        public void onConnect() {
        }

        public void onDisconnect(int i10, String str) {
        }

        public void onError(Exception exc) {
        }

        public void onMessage(String str) {
        }

        public void onMessage(byte[] bArr) {
        }
    }

    interface Listener {
        void onConnect();

        void onDisconnect(int i10, String str);

        void onError(Exception exc);

        void onMessage(String str);

        void onMessage(byte[] bArr);
    }

    public WebSocketClient(URI uri, Listener listener, List<BasicNameValuePair> list) {
        this.mURI = uri;
        this.mListener = listener;
        this.mExtraHeaders = list;
        this.mParser = new HybiParser(this);
        HandlerThread handlerThread = new HandlerThread("websocket-thread");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
    }

    /* access modifiers changed from: private */
    public String createSecret() {
        byte[] bArr = new byte[16];
        for (int i10 = 0; i10 < 16; i10++) {
            bArr[i10] = (byte) ((int) (Math.random() * 256.0d));
        }
        return Base64.encodeToString(bArr, 0).trim();
    }

    /* access modifiers changed from: private */
    public SSLSocketFactory getSSLSocketFactory() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext instance = SSLContext.getInstance(TLSUtils.TLS);
        instance.init((KeyManager[]) null, sTrustManagers, (SecureRandom) null);
        return instance.getSocketFactory();
    }

    /* access modifiers changed from: private */
    public Header parseHeader(String str) {
        return BasicLineParser.parseHeader(str, new BasicLineParser());
    }

    /* access modifiers changed from: private */
    public StatusLine parseStatusLine(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return BasicLineParser.parseStatusLine(str, new BasicLineParser());
    }

    /* access modifiers changed from: private */
    public String readLine(HybiParser.HappyDataInputStream happyDataInputStream) throws IOException {
        int read = happyDataInputStream.read();
        if (read == -1) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder("");
        while (read != 10) {
            if (read != 13) {
                sb2.append((char) read);
            }
            read = happyDataInputStream.read();
            if (read == -1) {
                return null;
            }
        }
        return sb2.toString();
    }

    public static void setTrustManagers(TrustManager[] trustManagerArr) {
        sTrustManagers = trustManagerArr;
    }

    public void connect() {
        Thread thread = this.mThread;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new Runnable() {
                /* JADX WARNING: Code restructure failed: missing block: B:55:0x0208, code lost:
                    r0 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:56:0x0209, code lost:
                    com.leanplum.internal.Log.exception(r0);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:57:0x020c, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:58:0x020d, code lost:
                    r0 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:59:0x020e, code lost:
                    com.leanplum.internal.WebSocketClient.access$800(r10.this$0).onError(r0);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
                    return;
                 */
                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Removed duplicated region for block: B:58:0x020d A[ExcHandler: Exception (r0v12 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:23:0x00a5] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r10 = this;
                        java.lang.String r0 = "\r\n"
                        r1 = 1
                        r2 = 0
                        com.leanplum.internal.WebSocketClient r3 = com.leanplum.internal.WebSocketClient.this     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.net.URI r3 = r3.mURI     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        int r3 = r3.getPort()     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        r4 = -1
                        if (r3 == r4) goto L_0x001c
                        com.leanplum.internal.WebSocketClient r3 = com.leanplum.internal.WebSocketClient.this     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.net.URI r3 = r3.mURI     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        int r3 = r3.getPort()     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        goto L_0x0029
                    L_0x001c:
                        com.leanplum.internal.WebSocketClient r3 = com.leanplum.internal.WebSocketClient.this     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        boolean r3 = r3.isSecure()     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        if (r3 == 0) goto L_0x0027
                        r3 = 443(0x1bb, float:6.21E-43)
                        goto L_0x0029
                    L_0x0027:
                        r3 = 80
                    L_0x0029:
                        com.leanplum.internal.WebSocketClient r4 = com.leanplum.internal.WebSocketClient.this     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.net.URI r4 = r4.mURI     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.lang.String r4 = r4.getPath()     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        if (r4 == 0) goto L_0x003c
                        java.lang.String r4 = "/"
                        goto L_0x0046
                    L_0x003c:
                        com.leanplum.internal.WebSocketClient r4 = com.leanplum.internal.WebSocketClient.this     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.net.URI r4 = r4.mURI     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.lang.String r4 = r4.getPath()     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                    L_0x0046:
                        com.leanplum.internal.WebSocketClient r5 = com.leanplum.internal.WebSocketClient.this     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.net.URI r5 = r5.mURI     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.lang.String r5 = r5.getQuery()     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        if (r5 != 0) goto L_0x0074
                        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        r5.<init>()     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        r5.append(r4)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.lang.String r4 = "?"
                        r5.append(r4)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        com.leanplum.internal.WebSocketClient r4 = com.leanplum.internal.WebSocketClient.this     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.net.URI r4 = r4.mURI     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.lang.String r4 = r4.getQuery()     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        r5.append(r4)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.lang.String r4 = r5.toString()     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                    L_0x0074:
                        r5 = 0
                        java.net.URI r6 = new java.net.URI     // Catch:{ URISyntaxException -> 0x00a1 }
                        com.leanplum.internal.WebSocketClient r7 = com.leanplum.internal.WebSocketClient.this     // Catch:{ URISyntaxException -> 0x00a1 }
                        java.net.URI r7 = r7.mURI     // Catch:{ URISyntaxException -> 0x00a1 }
                        java.lang.String r7 = r7.getScheme()     // Catch:{ URISyntaxException -> 0x00a1 }
                        java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ URISyntaxException -> 0x00a1 }
                        r8.<init>()     // Catch:{ URISyntaxException -> 0x00a1 }
                        java.lang.String r9 = "//"
                        r8.append(r9)     // Catch:{ URISyntaxException -> 0x00a1 }
                        com.leanplum.internal.WebSocketClient r9 = com.leanplum.internal.WebSocketClient.this     // Catch:{ URISyntaxException -> 0x00a1 }
                        java.net.URI r9 = r9.mURI     // Catch:{ URISyntaxException -> 0x00a1 }
                        java.lang.String r9 = r9.getHost()     // Catch:{ URISyntaxException -> 0x00a1 }
                        r8.append(r9)     // Catch:{ URISyntaxException -> 0x00a1 }
                        java.lang.String r8 = r8.toString()     // Catch:{ URISyntaxException -> 0x00a1 }
                        r6.<init>(r7, r8, r5)     // Catch:{ URISyntaxException -> 0x00a1 }
                        r5 = r6
                        goto L_0x00a5
                    L_0x00a1:
                        r6 = move-exception
                        com.leanplum.internal.Log.exception(r6)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                    L_0x00a5:
                        com.leanplum.internal.WebSocketClient r6 = com.leanplum.internal.WebSocketClient.this     // Catch:{ GeneralSecurityException -> 0x0208 }
                        boolean r6 = r6.isSecure()     // Catch:{ GeneralSecurityException -> 0x0208 }
                        if (r6 == 0) goto L_0x00b4
                        com.leanplum.internal.WebSocketClient r6 = com.leanplum.internal.WebSocketClient.this     // Catch:{ GeneralSecurityException -> 0x0208 }
                        javax.net.ssl.SSLSocketFactory r6 = r6.getSSLSocketFactory()     // Catch:{ GeneralSecurityException -> 0x0208 }
                        goto L_0x00b8
                    L_0x00b4:
                        javax.net.SocketFactory r6 = javax.net.SocketFactory.getDefault()     // Catch:{ GeneralSecurityException -> 0x0208 }
                    L_0x00b8:
                        com.leanplum.internal.WebSocketClient r7 = com.leanplum.internal.WebSocketClient.this     // Catch:{ IOException -> 0x00ca, Exception -> 0x020d }
                        java.net.URI r8 = r7.mURI     // Catch:{ IOException -> 0x00ca, Exception -> 0x020d }
                        java.lang.String r8 = r8.getHost()     // Catch:{ IOException -> 0x00ca, Exception -> 0x020d }
                        java.net.Socket r3 = r6.createSocket(r8, r3)     // Catch:{ IOException -> 0x00ca, Exception -> 0x020d }
                        java.net.Socket unused = r7.mSocket = r3     // Catch:{ IOException -> 0x00ca, Exception -> 0x020d }
                        goto L_0x00ce
                    L_0x00ca:
                        r3 = move-exception
                        com.leanplum.internal.Log.exception(r3)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                    L_0x00ce:
                        java.io.PrintWriter r3 = new java.io.PrintWriter     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        com.leanplum.internal.WebSocketClient r6 = com.leanplum.internal.WebSocketClient.this     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.net.Socket r6 = r6.mSocket     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.io.OutputStream r6 = r6.getOutputStream()     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        r3.<init>(r6)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        r6.<init>()     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.lang.String r7 = "GET "
                        r6.append(r7)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        r6.append(r4)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.lang.String r4 = " HTTP/1.1\r\n"
                        r6.append(r4)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.lang.String r4 = r6.toString()     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        r3.print(r4)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.lang.String r4 = "Upgrade: websocket\r\n"
                        r3.print(r4)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.lang.String r4 = "Connection: Upgrade\r\n"
                        r3.print(r4)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        r4.<init>()     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.lang.String r6 = "Host: "
                        r4.append(r6)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        com.leanplum.internal.WebSocketClient r6 = com.leanplum.internal.WebSocketClient.this     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.net.URI r6 = r6.mURI     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.lang.String r6 = r6.getHost()     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        r4.append(r6)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        r4.append(r0)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.lang.String r4 = r4.toString()     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        r3.print(r4)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        r4.<init>()     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.lang.String r6 = "Origin: "
                        r4.append(r6)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        if (r5 == 0) goto L_0x0132
                        java.lang.String r5 = r5.toString()     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        goto L_0x0134
                    L_0x0132:
                        java.lang.String r5 = "unknown"
                    L_0x0134:
                        r4.append(r5)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        r4.append(r0)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.lang.String r4 = r4.toString()     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        r3.print(r4)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        r4.<init>()     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.lang.String r5 = "Sec-WebSocket-Key: "
                        r4.append(r5)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        com.leanplum.internal.WebSocketClient r5 = com.leanplum.internal.WebSocketClient.this     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.lang.String r5 = r5.createSecret()     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        r4.append(r5)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        r4.append(r0)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.lang.String r4 = r4.toString()     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        r3.print(r4)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.lang.String r4 = "Sec-WebSocket-Version: 13\r\n"
                        r3.print(r4)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        com.leanplum.internal.WebSocketClient r4 = com.leanplum.internal.WebSocketClient.this     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.util.List r4 = r4.mExtraHeaders     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        if (r4 == 0) goto L_0x019a
                        com.leanplum.internal.WebSocketClient r4 = com.leanplum.internal.WebSocketClient.this     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.util.List r4 = r4.mExtraHeaders     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.util.Iterator r4 = r4.iterator()     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                    L_0x0175:
                        boolean r5 = r4.hasNext()     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        if (r5 == 0) goto L_0x019a
                        java.lang.Object r5 = r4.next()     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        org.apache.http.NameValuePair r5 = (org.apache.http.NameValuePair) r5     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.lang.String r6 = "%s: %s\r\n"
                        r7 = 2
                        java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.lang.String r8 = r5.getName()     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        r7[r2] = r8     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.lang.String r5 = r5.getValue()     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        r7[r1] = r5     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.lang.String r5 = java.lang.String.format(r6, r7)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        r3.print(r5)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        goto L_0x0175
                    L_0x019a:
                        r3.print(r0)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        r3.flush()     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        com.leanplum.internal.HybiParser$HappyDataInputStream r0 = new com.leanplum.internal.HybiParser$HappyDataInputStream     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        com.leanplum.internal.WebSocketClient r3 = com.leanplum.internal.WebSocketClient.this     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.net.Socket r3 = r3.mSocket     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.io.InputStream r3 = r3.getInputStream()     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        r0.<init>(r3)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        com.leanplum.internal.WebSocketClient r3 = com.leanplum.internal.WebSocketClient.this     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.lang.String r4 = r3.readLine(r0)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        org.apache.http.StatusLine r3 = r3.parseStatusLine(r4)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        if (r3 == 0) goto L_0x0200
                        int r4 = r3.getStatusCode()     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        r5 = 101(0x65, float:1.42E-43)
                        if (r4 != r5) goto L_0x01f2
                    L_0x01c3:
                        com.leanplum.internal.WebSocketClient r3 = com.leanplum.internal.WebSocketClient.this     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.lang.String r3 = r3.readLine(r0)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        if (r4 != 0) goto L_0x01df
                        com.leanplum.internal.WebSocketClient r4 = com.leanplum.internal.WebSocketClient.this     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        org.apache.http.Header r3 = r4.parseHeader(r3)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.lang.String r3 = r3.getName()     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.lang.String r4 = "Sec-WebSocket-Accept"
                        r3.equals(r4)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        goto L_0x01c3
                    L_0x01df:
                        com.leanplum.internal.WebSocketClient r3 = com.leanplum.internal.WebSocketClient.this     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        com.leanplum.internal.WebSocketClient$Listener r3 = r3.mListener     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        r3.onConnect()     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        com.leanplum.internal.WebSocketClient r3 = com.leanplum.internal.WebSocketClient.this     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        com.leanplum.internal.HybiParser r3 = r3.mParser     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        r3.start(r0)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        goto L_0x0256
                    L_0x01f2:
                        org.apache.http.client.HttpResponseException r0 = new org.apache.http.client.HttpResponseException     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        int r4 = r3.getStatusCode()     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.lang.String r3 = r3.getReasonPhrase()     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        r0.<init>(r4, r3)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        throw r0     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                    L_0x0200:
                        org.apache.http.HttpException r0 = new org.apache.http.HttpException     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        java.lang.String r3 = "Received no reply from server."
                        r0.<init>(r3)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        throw r0     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                    L_0x0208:
                        r0 = move-exception
                        com.leanplum.internal.Log.exception(r0)     // Catch:{ EOFException -> 0x0241, SSLException -> 0x022b, SocketException -> 0x0218, Exception -> 0x020d }
                        return
                    L_0x020d:
                        r0 = move-exception
                        com.leanplum.internal.WebSocketClient r1 = com.leanplum.internal.WebSocketClient.this
                        com.leanplum.internal.WebSocketClient$Listener r1 = r1.mListener
                        r1.onError(r0)
                        goto L_0x0256
                    L_0x0218:
                        java.lang.Object[] r0 = new java.lang.Object[r2]
                        java.lang.String r1 = "WebSocketClient - Socket closed"
                        com.leanplum.internal.Log.d(r1, r0)
                        com.leanplum.internal.WebSocketClient r0 = com.leanplum.internal.WebSocketClient.this
                        com.leanplum.internal.WebSocketClient$Listener r0 = r0.mListener
                        java.lang.String r1 = "Socket"
                        r0.onDisconnect(r2, r1)
                        goto L_0x0256
                    L_0x022b:
                        r0 = move-exception
                        java.lang.Object[] r1 = new java.lang.Object[r1]
                        r1[r2] = r0
                        java.lang.String r0 = "Websocket SSL error!"
                        com.leanplum.internal.Log.d(r0, r1)
                        com.leanplum.internal.WebSocketClient r0 = com.leanplum.internal.WebSocketClient.this
                        com.leanplum.internal.WebSocketClient$Listener r0 = r0.mListener
                        java.lang.String r1 = "SSL"
                        r0.onDisconnect(r2, r1)
                        goto L_0x0256
                    L_0x0241:
                        r0 = move-exception
                        java.lang.Object[] r1 = new java.lang.Object[r1]
                        r1[r2] = r0
                        java.lang.String r0 = "WebSocket EOF!"
                        com.leanplum.internal.Log.d(r0, r1)
                        com.leanplum.internal.WebSocketClient r0 = com.leanplum.internal.WebSocketClient.this
                        com.leanplum.internal.WebSocketClient$Listener r0 = r0.mListener
                        java.lang.String r1 = "EOF"
                        r0.onDisconnect(r2, r1)
                    L_0x0256:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.leanplum.internal.WebSocketClient.AnonymousClass1.run():void");
                }
            });
            this.mThread = thread2;
            thread2.start();
        }
    }

    public void disconnect() {
        Log.d("WebSocketClient.disconnect()", new Object[0]);
        this.mListener = new DummyListener();
        if (this.mSocket != null) {
            this.mHandler.post(new Runnable() {
                public void run() {
                    try {
                        if (WebSocketClient.this.mSocket != null) {
                            WebSocketClient.this.mSocket.close();
                            Socket unused = WebSocketClient.this.mSocket = null;
                        }
                        WebSocketClient.this.mHandlerThread.quit();
                    } catch (IOException e10) {
                        Log.d("Error while disconnecting", e10);
                        WebSocketClient.this.mListener.onError(e10);
                    }
                }
            });
        }
    }

    public Listener getListener() {
        return this.mListener;
    }

    public boolean isSecure() {
        return this.mURI.getScheme().equals("https");
    }

    public void send(String str) {
        sendFrame(this.mParser.frame(str));
    }

    /* access modifiers changed from: package-private */
    public void sendFrame(final byte[] bArr) {
        this.mHandler.post(new Runnable() {
            public void run() {
                try {
                    synchronized (WebSocketClient.this.mSendLock) {
                        if (WebSocketClient.this.mSocket != null) {
                            OutputStream outputStream = WebSocketClient.this.mSocket.getOutputStream();
                            outputStream.write(bArr);
                            outputStream.flush();
                        }
                    }
                } catch (IOException e10) {
                    WebSocketClient.this.mListener.onError(e10);
                }
            }
        });
    }

    public void send(byte[] bArr) {
        sendFrame(this.mParser.frame(bArr));
    }
}
