package org.jivesoftware.smackx.bytestreams.socks5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.util.Async;
import org.jivesoftware.smack.util.CloseableUtil;
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream;

public class Socks5Client {
    /* access modifiers changed from: private */
    public static final Logger LOGGER = Logger.getLogger(Socks5Client.class.getName());
    protected String digest;
    protected Bytestream.StreamHost streamHost;

    public Socks5Client(Bytestream.StreamHost streamHost2, String str) {
        this.streamHost = streamHost2;
        this.digest = str;
    }

    private byte[] createSocks5ConnectRequest() {
        byte[] bytes = this.digest.getBytes(StandardCharsets.UTF_8);
        int length = bytes.length + 7;
        byte[] bArr = new byte[length];
        bArr[0] = 5;
        bArr[1] = 1;
        bArr[2] = 0;
        bArr[3] = 3;
        bArr[4] = (byte) bytes.length;
        System.arraycopy(bytes, 0, bArr, 5, bytes.length);
        bArr[length - 2] = 0;
        bArr[length - 1] = 0;
        return bArr;
    }

    /* access modifiers changed from: protected */
    public void establish(Socket socket) throws IOException, SmackException.SmackMessageException {
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        dataOutputStream.write(new byte[]{5, 1, 0});
        dataOutputStream.flush();
        byte[] bArr = new byte[2];
        dataInputStream.readFully(bArr);
        if (bArr[0] == 5 && bArr[1] == 0) {
            byte[] createSocks5ConnectRequest = createSocks5ConnectRequest();
            dataOutputStream.write(createSocks5ConnectRequest);
            dataOutputStream.flush();
            byte[] receiveSocks5Message = Socks5Utils.receiveSocks5Message(dataInputStream);
            createSocks5ConnectRequest[1] = 0;
            if (!Arrays.equals(createSocks5ConnectRequest, receiveSocks5Message)) {
                throw new SmackException.SmackMessageException("Connection request does not equal connection response. Response: " + Arrays.toString(receiveSocks5Message) + ". Request: " + Arrays.toString(createSocks5ConnectRequest));
            }
            return;
        }
        throw new SmackException.SmackMessageException("Remote SOCKS5 server responded with unexpected version: " + bArr[0] + ' ' + bArr[1] + ". Should be 0x05 0x00.");
    }

    public Socket getSocket(int i10) throws IOException, InterruptedException, TimeoutException, XMPPException, SmackException.SmackMessageException, SmackException.NotConnectedException, SmackException.NoResponseException {
        FutureTask futureTask = new FutureTask(new Callable<Socket>() {
            public Socket call() throws IOException, SmackException.SmackMessageException {
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress(Socks5Client.this.streamHost.getAddress().asInetAddress(), Socks5Client.this.streamHost.getPort()));
                try {
                    Socks5Client.this.establish(socket);
                    return socket;
                } catch (SmackException.SmackMessageException e10) {
                    if (!socket.isClosed()) {
                        CloseableUtil.maybeClose(socket, Socks5Client.LOGGER);
                    }
                    throw e10;
                }
            }
        });
        Async.go(futureTask, "SOCKS5 client connecting to " + this.streamHost);
        try {
            return (Socket) futureTask.get((long) i10, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e10) {
            throw new IOException("ExecutionException while SOCKS5 client attempting to connect to " + this.streamHost, e10);
        }
    }
}
