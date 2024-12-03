package org.jivesoftware.smack.proxy;

import com.facebook.internal.security.CertificateUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jivesoftware.smack.proxy.ProxyInfo;
import org.jivesoftware.smack.util.stringencoder.Base64;

class HTTPProxySocketConnection implements ProxySocketConnection {
    private static final Pattern RESPONSE_PATTERN = Pattern.compile("HTTP/\\S+\\s(\\d+)\\s(.*)\\s*");
    private final ProxyInfo proxy;

    HTTPProxySocketConnection(ProxyInfo proxyInfo) {
        this.proxy = proxyInfo;
    }

    public void connect(Socket socket, String str, int i10, int i11) throws IOException {
        String str2;
        String proxyAddress = this.proxy.getProxyAddress();
        socket.connect(new InetSocketAddress(proxyAddress, this.proxy.getProxyPort()));
        String str3 = "CONNECT " + str + CertificateUtil.DELIMITER + i10;
        String proxyUsername = this.proxy.getProxyUsername();
        if (proxyUsername == null) {
            str2 = "";
        } else {
            String proxyPassword = this.proxy.getProxyPassword();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("\r\nProxy-Authorization: Basic ");
            sb2.append(Base64.encode(proxyUsername + CertificateUtil.DELIMITER + proxyPassword));
            str2 = sb2.toString();
        }
        socket.getOutputStream().write((str3 + " HTTP/1.1\r\nHost: " + str + CertificateUtil.DELIMITER + i10 + str2 + "\r\n\r\n").getBytes("UTF-8"));
        InputStream inputStream = socket.getInputStream();
        StringBuilder sb3 = new StringBuilder(100);
        int i12 = 0;
        do {
            int read = inputStream.read();
            if (read != -1) {
                char c10 = (char) read;
                sb3.append(c10);
                if (sb3.length() <= 1024) {
                    i12 = (((i12 == 0 || i12 == 2) && c10 == 13) || ((i12 == 1 || i12 == 3) && c10 == 10)) ? i12 + 1 : 0;
                } else {
                    throw new ProxyException(ProxyInfo.ProxyType.HTTP, "Received header of >1024 characters from " + proxyAddress + ", cancelling connection");
                }
            } else {
                throw new ProxyException(ProxyInfo.ProxyType.HTTP);
            }
        } while (i12 != 4);
        if (i12 == 4) {
            String readLine = new BufferedReader(new StringReader(sb3.toString())).readLine();
            if (readLine != null) {
                Matcher matcher = RESPONSE_PATTERN.matcher(readLine);
                if (matcher.matches()) {
                    int parseInt = Integer.parseInt(matcher.group(1));
                    if (parseInt != 200) {
                        throw new ProxyException(ProxyInfo.ProxyType.HTTP, "Error code in proxy response: " + parseInt);
                    }
                    return;
                }
                throw new ProxyException(ProxyInfo.ProxyType.HTTP, "Unexpected proxy response from " + proxyAddress + ": " + readLine);
            }
            throw new ProxyException(ProxyInfo.ProxyType.HTTP, "Empty proxy response from " + proxyAddress + ", cancelling");
        }
        throw new ProxyException(ProxyInfo.ProxyType.HTTP, "Never received blank line from " + proxyAddress + ", cancelling connection");
    }
}
