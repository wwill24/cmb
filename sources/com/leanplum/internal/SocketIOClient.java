package com.leanplum.internal;

import android.os.Looper;
import com.facebook.internal.security.CertificateUtil;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.leanplum.Leanplum;
import com.leanplum.internal.WebSocketClient;
import com.mparticle.kits.AppsFlyerKit;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.a;
import org.json.b;

class SocketIOClient {
    /* access modifiers changed from: private */
    public WebSocketClient mClient;
    /* access modifiers changed from: private */
    public Handler mHandler;
    /* access modifiers changed from: private */
    public int mHeartbeat;
    /* access modifiers changed from: private */
    public android.os.Handler mSendHandler;
    /* access modifiers changed from: private */
    public Looper mSendLooper;
    /* access modifiers changed from: private */
    public String mSession;
    /* access modifiers changed from: private */
    public String mURL;

    interface Handler {
        void on(String str, a aVar);

        void onConnect();

        void onDisconnect(int i10, String str);

        void onError(Exception exc);
    }

    public SocketIOClient(URI uri, Handler handler) {
        this.mURL = uri.toString().replaceAll("/$", "") + "/socket.io/1/";
        this.mHandler = handler;
    }

    /* access modifiers changed from: private */
    public void cleanup() {
        WebSocketClient webSocketClient = this.mClient;
        if (webSocketClient != null) {
            webSocketClient.disconnect();
            this.mClient = null;
        }
        Looper looper = this.mSendLooper;
        if (looper != null) {
            looper.quit();
        }
        this.mSendLooper = null;
        this.mSendHandler = null;
    }

    /* access modifiers changed from: private */
    public void connectSession() throws URISyntaxException {
        WebSocketClient webSocketClient = new WebSocketClient(new URI(this.mURL + "websocket/" + this.mSession), new WebSocketClient.Listener() {
            public void onConnect() {
                SocketIOClient.this.mSendHandler.postDelayed(new Runnable() {
                    public void run() {
                        SocketIOClient.this.mSendHandler.postDelayed(this, (long) SocketIOClient.this.mHeartbeat);
                        SocketIOClient.this.mClient.send("2:::");
                    }
                }, (long) SocketIOClient.this.mHeartbeat);
                SocketIOClient.this.mHandler.onConnect();
            }

            public void onDisconnect(int i10, String str) {
                SocketIOClient.this.cleanup();
                SocketIOClient.this.mHandler.onDisconnect(i10, str);
            }

            public void onError(Exception exc) {
                SocketIOClient.this.cleanup();
                SocketIOClient.this.mHandler.onError(exc);
            }

            public void onMessage(byte[] bArr) {
                SocketIOClient.this.cleanup();
                SocketIOClient.this.mHandler.onError(new Exception("Unexpected binary data"));
            }

            /* JADX WARNING: Can't wrap try/catch for region: R(2:11|12) */
            /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
                r1 = new org.json.a();
             */
            /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0032 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onMessage(java.lang.String r5) {
                /*
                    r4 = this;
                    java.lang.String r0 = ":"
                    r1 = 4
                    java.lang.String[] r0 = r5.split(r0, r1)     // Catch:{ Exception -> 0x0075 }
                    r1 = 0
                    r1 = r0[r1]     // Catch:{ Exception -> 0x0075 }
                    int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ Exception -> 0x0075 }
                    switch(r1) {
                        case 1: goto L_0x006b;
                        case 2: goto L_0x005f;
                        case 3: goto L_0x0057;
                        case 4: goto L_0x0057;
                        case 5: goto L_0x001a;
                        case 6: goto L_0x007e;
                        case 7: goto L_0x0014;
                        case 8: goto L_0x007e;
                        default: goto L_0x0011;
                    }     // Catch:{ Exception -> 0x0075 }
                L_0x0011:
                    java.lang.Exception r5 = new java.lang.Exception     // Catch:{ Exception -> 0x0075 }
                    goto L_0x006f
                L_0x0014:
                    java.lang.Exception r0 = new java.lang.Exception     // Catch:{ Exception -> 0x0075 }
                    r0.<init>(r5)     // Catch:{ Exception -> 0x0075 }
                    throw r0     // Catch:{ Exception -> 0x0075 }
                L_0x001a:
                    r5 = 1
                    r5 = r0[r5]     // Catch:{ Exception -> 0x0075 }
                    r1 = 3
                    r0 = r0[r1]     // Catch:{ Exception -> 0x0075 }
                    org.json.b r1 = new org.json.b     // Catch:{ Exception -> 0x0075 }
                    r1.<init>((java.lang.String) r0)     // Catch:{ Exception -> 0x0075 }
                    java.lang.String r0 = "name"
                    java.lang.String r0 = r1.getString(r0)     // Catch:{ Exception -> 0x0075 }
                    java.lang.String r2 = "args"
                    org.json.a r1 = r1.getJSONArray(r2)     // Catch:{ JSONException -> 0x0032 }
                    goto L_0x0037
                L_0x0032:
                    org.json.a r1 = new org.json.a     // Catch:{ Exception -> 0x0075 }
                    r1.<init>()     // Catch:{ Exception -> 0x0075 }
                L_0x0037:
                    java.lang.String r2 = ""
                    boolean r2 = r2.equals(r5)     // Catch:{ Exception -> 0x0075 }
                    if (r2 != 0) goto L_0x004d
                    com.leanplum.internal.SocketIOClient r2 = com.leanplum.internal.SocketIOClient.this     // Catch:{ Exception -> 0x0075 }
                    android.os.Handler r2 = r2.mSendHandler     // Catch:{ Exception -> 0x0075 }
                    com.leanplum.internal.SocketIOClient$2$1 r3 = new com.leanplum.internal.SocketIOClient$2$1     // Catch:{ Exception -> 0x0075 }
                    r3.<init>(r5)     // Catch:{ Exception -> 0x0075 }
                    r2.post(r3)     // Catch:{ Exception -> 0x0075 }
                L_0x004d:
                    com.leanplum.internal.SocketIOClient r5 = com.leanplum.internal.SocketIOClient.this     // Catch:{ Exception -> 0x0075 }
                    com.leanplum.internal.SocketIOClient$Handler r5 = r5.mHandler     // Catch:{ Exception -> 0x0075 }
                    r5.on(r0, r1)     // Catch:{ Exception -> 0x0075 }
                    goto L_0x007e
                L_0x0057:
                    java.lang.Exception r5 = new java.lang.Exception     // Catch:{ Exception -> 0x0075 }
                    java.lang.String r0 = "message type not supported"
                    r5.<init>(r0)     // Catch:{ Exception -> 0x0075 }
                    throw r5     // Catch:{ Exception -> 0x0075 }
                L_0x005f:
                    com.leanplum.internal.SocketIOClient r5 = com.leanplum.internal.SocketIOClient.this     // Catch:{ Exception -> 0x0075 }
                    com.leanplum.internal.WebSocketClient r5 = r5.mClient     // Catch:{ Exception -> 0x0075 }
                    java.lang.String r0 = "2::"
                    r5.send((java.lang.String) r0)     // Catch:{ Exception -> 0x0075 }
                    goto L_0x007e
                L_0x006b:
                    r4.onConnect()     // Catch:{ Exception -> 0x0075 }
                    goto L_0x007e
                L_0x006f:
                    java.lang.String r0 = "unknown code"
                    r5.<init>(r0)     // Catch:{ Exception -> 0x0075 }
                    throw r5     // Catch:{ Exception -> 0x0075 }
                L_0x0075:
                    r5 = move-exception
                    com.leanplum.internal.SocketIOClient r0 = com.leanplum.internal.SocketIOClient.this
                    r0.cleanup()
                    r4.onError(r5)
                L_0x007e:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.leanplum.internal.SocketIOClient.AnonymousClass2.onMessage(java.lang.String):void");
            }
        }, (List<BasicNameValuePair>) null);
        this.mClient = webSocketClient;
        webSocketClient.connect();
    }

    /* access modifiers changed from: private */
    public static String downloadUriAsString(String str) throws IOException {
        StringBuilder sb2 = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new URL(str).openStream()));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb2.append(readLine);
            } else {
                bufferedReader.close();
                return sb2.toString();
            }
        }
    }

    private static String readToEnd(InputStream inputStream) throws IOException {
        return new String(readToEndAsArray(inputStream));
    }

    private static byte[] readToEndAsArray(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = dataInputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private static String userAgentString() {
        String str;
        if (Leanplum.getContext() != null) {
            str = Util.getApplicationName(Leanplum.getContext()) + RemoteSettings.FORWARD_SLASH_STRING + Util.getVersionName();
        } else {
            str = "websocket";
        }
        return str + "(" + APIConfig.getInstance().appId() + "; " + Constants.CLIENT + "; " + Constants.LEANPLUM_VERSION + RemoteSettings.FORWARD_SLASH_STRING + "s" + ")";
    }

    public void connect() {
        if (this.mClient == null) {
            new Thread() {
                public void run() {
                    try {
                        String[] split = SocketIOClient.downloadUriAsString(SocketIOClient.this.mURL).split(CertificateUtil.DELIMITER);
                        String unused = SocketIOClient.this.mSession = split[0];
                        String str = split[1];
                        if (!"".equals(str)) {
                            int unused2 = SocketIOClient.this.mHeartbeat = (Integer.parseInt(str) / 2) * 1000;
                        }
                        if (new HashSet(Arrays.asList(split[3].split(AppsFlyerKit.COMMA))).contains("websocket")) {
                            Looper.prepare();
                            Looper unused3 = SocketIOClient.this.mSendLooper = Looper.myLooper();
                            android.os.Handler unused4 = SocketIOClient.this.mSendHandler = new android.os.Handler();
                            SocketIOClient.this.connectSession();
                            Looper.loop();
                            return;
                        }
                        throw new Exception("websocket not supported");
                    } catch (Exception e10) {
                        SocketIOClient.this.mHandler.onError(e10);
                    }
                }
            }.start();
        }
    }

    public void disconnect() throws IOException {
        Log.d("SocketIOClient.disconnect()", new Object[0]);
        cleanup();
    }

    public void emit(String str, a aVar) throws JSONException {
        final b bVar = new b();
        bVar.put("name", (Object) str);
        bVar.put("args", (Object) aVar);
        this.mSendHandler.post(new Runnable() {
            public void run() {
                SocketIOClient.this.mClient.send(String.format("5:::%s", new Object[]{bVar.toString()}));
            }
        });
    }
}
