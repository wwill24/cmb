package org.jivesoftware.smackx.bytestreams.socks5;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import org.jivesoftware.smackx.bytestreams.BytestreamSession;

public class Socks5BytestreamSession implements BytestreamSession {
    private final boolean isDirect;
    private final Socket socket;

    public Socks5BytestreamSession(Socket socket2, boolean z10) {
        this.socket = socket2;
        this.isDirect = z10;
    }

    public void close() throws IOException {
        this.socket.close();
    }

    public InputStream getInputStream() throws IOException {
        return this.socket.getInputStream();
    }

    public OutputStream getOutputStream() throws IOException {
        return this.socket.getOutputStream();
    }

    public int getReadTimeout() throws IOException {
        try {
            return this.socket.getSoTimeout();
        } catch (SocketException unused) {
            throw new IOException("Error on underlying Socket");
        }
    }

    public boolean isDirect() {
        return this.isDirect;
    }

    public boolean isMediated() {
        return !this.isDirect;
    }

    public void setReadTimeout(int i10) throws IOException {
        try {
            this.socket.setSoTimeout(i10);
        } catch (SocketException unused) {
            throw new IOException("Error on underlying Socket");
        }
    }
}
