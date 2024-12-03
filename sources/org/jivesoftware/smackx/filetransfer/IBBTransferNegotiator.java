package org.jivesoftware.smackx.filetransfer;

import java.io.InputStream;
import java.io.OutputStream;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager;
import org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamRequest;
import org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamSession;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Open;
import org.jivesoftware.smackx.si.packet.StreamInitiation;
import org.jxmpp.jid.Jid;

public class IBBTransferNegotiator extends StreamNegotiator {
    private final InBandBytestreamManager manager;

    private static final class ByteStreamRequest extends InBandBytestreamRequest {
        private ByteStreamRequest(InBandBytestreamManager inBandBytestreamManager, Open open) {
            super(inBandBytestreamManager, open);
        }
    }

    protected IBBTransferNegotiator(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.manager = InBandBytestreamManager.getByteStreamManager(xMPPConnection);
    }

    public InputStream createIncomingStream(StreamInitiation streamInitiation) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        this.manager.ignoreBytestreamRequestOnce(streamInitiation.getSessionID());
        return negotiateIncomingStream(initiateIncomingStream(connection(), streamInitiation));
    }

    public OutputStream createOutgoingStream(String str, Jid jid, Jid jid2) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        InBandBytestreamSession establishSession = this.manager.establishSession(jid2, str);
        establishSession.setCloseBothStreamsEnabled(true);
        return establishSession.getOutputStream();
    }

    public String getNamespace() {
        return "http://jabber.org/protocol/ibb";
    }

    /* access modifiers changed from: package-private */
    public InputStream negotiateIncomingStream(Stanza stanza) throws SmackException.NotConnectedException, InterruptedException {
        InBandBytestreamSession accept = new ByteStreamRequest(this.manager, (Open) stanza).accept();
        accept.setCloseBothStreamsEnabled(true);
        return accept.getInputStream();
    }

    public void newStreamInitiation(Jid jid, String str) {
        this.manager.ignoreBytestreamRequestOnce(str);
    }
}
