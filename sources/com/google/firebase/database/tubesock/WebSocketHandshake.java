package com.google.firebase.database.tubesock;

import android.util.Base64;
import com.coffeemeetsbagel.models.ModelDeeplinkData;
import com.facebook.internal.security.CertificateUtil;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import net.bytebuddy.description.type.TypeDescription;

class WebSocketHandshake {
    private static final String WEBSOCKET_VERSION = "13";
    private Map<String, String> extraHeaders;
    private String nonce = null;
    private String protocol;
    private URI url;

    public WebSocketHandshake(URI uri, String str, Map<String, String> map) {
        this.url = uri;
        this.protocol = str;
        this.extraHeaders = map;
        this.nonce = createNonce();
    }

    private String createNonce() {
        byte[] bArr = new byte[16];
        for (int i10 = 0; i10 < 16; i10++) {
            bArr[i10] = (byte) rand(0, 255);
        }
        return Base64.encodeToString(bArr, 2);
    }

    private String generateHeader(LinkedHashMap<String, String> linkedHashMap) {
        String str = new String();
        for (String next : linkedHashMap.keySet()) {
            str = str + next + ": " + linkedHashMap.get(next) + "\r\n";
        }
        return str;
    }

    private int rand(int i10, int i11) {
        return (int) ((Math.random() * ((double) i11)) + ((double) i10));
    }

    public byte[] getHandshake() {
        String str;
        String path = this.url.getPath();
        String query = this.url.getQuery();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(path);
        if (query == null) {
            str = "";
        } else {
            str = TypeDescription.Generic.OfWildcardType.SYMBOL + query;
        }
        sb2.append(str);
        String sb3 = sb2.toString();
        String host = this.url.getHost();
        if (this.url.getPort() != -1) {
            host = host + CertificateUtil.DELIMITER + this.url.getPort();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("Host", host);
        linkedHashMap.put("Upgrade", "websocket");
        linkedHashMap.put("Connection", "Upgrade");
        linkedHashMap.put("Sec-WebSocket-Version", WEBSOCKET_VERSION);
        linkedHashMap.put("Sec-WebSocket-Key", this.nonce);
        String str2 = this.protocol;
        if (str2 != null) {
            linkedHashMap.put("Sec-WebSocket-Protocol", str2);
        }
        Map<String, String> map = this.extraHeaders;
        if (map != null) {
            for (String next : map.keySet()) {
                if (!linkedHashMap.containsKey(next)) {
                    linkedHashMap.put(next, this.extraHeaders.get(next));
                }
            }
        }
        byte[] bytes = ((("GET " + sb3 + " HTTP/1.1\r\n") + generateHeader(linkedHashMap)) + "\r\n").getBytes(Charset.defaultCharset());
        byte[] bArr = new byte[bytes.length];
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        return bArr;
    }

    public void verifyServerHandshakeHeaders(HashMap<String, String> hashMap) {
        if (!"websocket".equals(hashMap.get("upgrade"))) {
            throw new WebSocketException("connection failed: missing header field in server handshake: Upgrade");
        } else if (!"upgrade".equals(hashMap.get(ModelDeeplinkData.VALUE_PAGE_CONNECTION))) {
            throw new WebSocketException("connection failed: missing header field in server handshake: Connection");
        }
    }

    public void verifyServerStatusLine(String str) {
        int parseInt = Integer.parseInt(str.substring(9, 12));
        if (parseInt == 407) {
            throw new WebSocketException("connection failed: proxy authentication not supported");
        } else if (parseInt == 404) {
            throw new WebSocketException("connection failed: 404 not found");
        } else if (parseInt != 101) {
            throw new WebSocketException("connection failed: unknown status code " + parseInt);
        }
    }
}
