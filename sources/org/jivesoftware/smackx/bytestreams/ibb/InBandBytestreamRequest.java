package org.jivesoftware.smackx.bytestreams.ibb;

import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.bytestreams.BytestreamRequest;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Open;
import org.jxmpp.jid.Jid;

public class InBandBytestreamRequest implements BytestreamRequest {
    private final Open byteStreamRequest;
    private final InBandBytestreamManager manager;

    protected InBandBytestreamRequest(InBandBytestreamManager inBandBytestreamManager, Open open) {
        this.manager = inBandBytestreamManager;
        this.byteStreamRequest = open;
    }

    public Jid getFrom() {
        return this.byteStreamRequest.getFrom();
    }

    public String getSessionID() {
        return this.byteStreamRequest.getSessionID();
    }

    public void reject() throws SmackException.NotConnectedException, InterruptedException {
        this.manager.replyRejectPacket(this.byteStreamRequest);
    }

    public InBandBytestreamSession accept() throws SmackException.NotConnectedException, InterruptedException {
        XMPPConnection connection = this.manager.getConnection();
        Open open = this.byteStreamRequest;
        InBandBytestreamSession inBandBytestreamSession = new InBandBytestreamSession(connection, open, open.getFrom());
        this.manager.getSessions().put(this.byteStreamRequest.getSessionID(), inBandBytestreamSession);
        connection.sendStanza(IQ.createResultIQ(this.byteStreamRequest));
        return inBandBytestreamSession;
    }
}
