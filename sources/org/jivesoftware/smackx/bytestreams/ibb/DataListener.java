package org.jivesoftware.smackx.bytestreams.ibb;

import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Data;

class DataListener extends AbstractIqRequestHandler {
    private final InBandBytestreamManager manager;

    DataListener(InBandBytestreamManager inBandBytestreamManager) {
        super("data", "http://jabber.org/protocol/ibb", IQ.Type.set, IQRequestHandler.Mode.async);
        this.manager = inBandBytestreamManager;
    }

    public IQ handleIQRequest(IQ iq) {
        Data data = (Data) iq;
        InBandBytestreamSession inBandBytestreamSession = this.manager.getSessions().get(data.getDataPacketExtension().getSessionID());
        if (inBandBytestreamSession == null) {
            try {
                this.manager.replyItemNotFoundPacket(data);
            } catch (InterruptedException | SmackException.NotConnectedException | SmackException.NotLoggedInException unused) {
            }
        } else {
            inBandBytestreamSession.processIQPacket(data);
        }
        return null;
    }
}
