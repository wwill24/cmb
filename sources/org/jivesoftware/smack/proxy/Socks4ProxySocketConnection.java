package org.jivesoftware.smack.proxy;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import org.jivesoftware.smack.proxy.ProxyInfo;
import org.jivesoftware.smack.util.OutputStreamUtil;

public class Socks4ProxySocketConnection implements ProxySocketConnection {
    private final ProxyInfo proxy;

    Socks4ProxySocketConnection(ProxyInfo proxyInfo) {
        this.proxy = proxyInfo;
    }

    public void connect(Socket socket, String str, int i10, int i11) throws IOException {
        String proxyAddress = this.proxy.getProxyAddress();
        int proxyPort = this.proxy.getProxyPort();
        String proxyUsername = this.proxy.getProxyUsername();
        socket.connect(new InetSocketAddress(proxyAddress, proxyPort), i11);
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        OutputStream outputStream = socket.getOutputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(4);
        byteArrayOutputStream.write(1);
        byteArrayOutputStream.write(i10 >>> 8);
        byteArrayOutputStream.write(i10 & 255);
        byteArrayOutputStream.write(InetAddress.getByName(proxyAddress).getAddress());
        if (proxyUsername != null) {
            byteArrayOutputStream.write(proxyUsername.getBytes(StandardCharsets.UTF_8));
        }
        byteArrayOutputStream.write(0);
        OutputStreamUtil.writeResetAndFlush(byteArrayOutputStream, outputStream);
        byte[] bArr = new byte[6];
        dataInputStream.readFully(bArr);
        if (bArr[0] != 0) {
            ProxyInfo.ProxyType proxyType = ProxyInfo.ProxyType.SOCKS4;
            throw new ProxyException(proxyType, "server returns VN " + bArr[0]);
        } else if (bArr[1] == 90) {
            dataInputStream.readFully(new byte[2]);
        } else {
            throw new ProxyException(ProxyInfo.ProxyType.SOCKS4, "ProxySOCKS4: server returns CD " + bArr[1]);
        }
    }
}
