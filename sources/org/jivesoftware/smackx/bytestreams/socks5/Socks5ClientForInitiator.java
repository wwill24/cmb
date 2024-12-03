package org.jivesoftware.smackx.bytestreams.socks5;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.concurrent.TimeoutException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream;
import org.jxmpp.jid.Jid;

public class Socks5ClientForInitiator extends Socks5Client {
    private WeakReference<XMPPConnection> connection;
    private String sessionID;
    private final Jid target;

    public Socks5ClientForInitiator(Bytestream.StreamHost streamHost, String str, XMPPConnection xMPPConnection, String str2, Jid jid) {
        super(streamHost, str);
        this.connection = new WeakReference<>(xMPPConnection);
        this.sessionID = str2;
        this.target = jid;
    }

    private void activate() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        this.connection.get().createStanzaCollectorAndSend(createStreamHostActivation()).nextResultOrThrow();
    }

    private Bytestream createStreamHostActivation() {
        Bytestream bytestream = new Bytestream(this.sessionID);
        bytestream.setMode((Bytestream.Mode) null);
        bytestream.setType(IQ.Type.set);
        bytestream.setTo(this.streamHost.getJID());
        bytestream.setToActivate(this.target);
        return bytestream;
    }

    public Socket getSocket(int i10) throws IOException, InterruptedException, TimeoutException, XMPPException, SmackException.SmackMessageException, SmackException.NotConnectedException, SmackException.NoResponseException {
        Socket socket;
        if (this.streamHost.getJID().Y(this.connection.get().getUser())) {
            socket = Socks5Proxy.getSocketForDigest(this.digest);
            if (socket == null) {
                throw new SmackException.SmackMessageException("target is not connected to SOCKS5 proxy");
            }
        } else {
            socket = super.getSocket(i10);
            try {
                activate();
            } catch (XMPPException e10) {
                socket.close();
                throw e10;
            } catch (SmackException.NoResponseException e11) {
                socket.close();
                throw e11;
            }
        }
        return socket;
    }
}
