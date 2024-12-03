package org.jivesoftware.smackx.filetransfer;

import java.io.InputStream;
import java.io.OutputStream;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.EventManger;
import org.jivesoftware.smackx.si.packet.StreamInitiation;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.ListSingleFormField;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.jid.Jid;

public abstract class StreamNegotiator extends Manager {
    protected static final EventManger<String, IQ, SmackException.NotConnectedException> initationSetEvents = new EventManger<>();

    protected StreamNegotiator(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
    }

    protected static StreamInitiation createInitiationAccept(StreamInitiation streamInitiation, String str) {
        StreamInitiation streamInitiation2 = new StreamInitiation();
        streamInitiation2.setTo(streamInitiation.getFrom());
        streamInitiation2.setFrom(streamInitiation.getTo());
        streamInitiation2.setType(IQ.Type.result);
        streamInitiation2.setStanzaId(streamInitiation.getStanzaId());
        DataForm.Builder builder = DataForm.builder();
        ListSingleFormField.Builder listSingleBuilder = FormField.listSingleBuilder("stream-method");
        listSingleBuilder.setValue((CharSequence) str);
        builder.addField(listSingleBuilder.build());
        streamInitiation2.setFeatureNegotiationForm(builder.build());
        return streamInitiation2;
    }

    public static void signal(String str, IQ iq) {
        initationSetEvents.signalEvent(str, iq);
    }

    public abstract InputStream createIncomingStream(StreamInitiation streamInitiation) throws XMPPException.XMPPErrorException, InterruptedException, SmackException;

    public abstract OutputStream createOutgoingStream(String str, Jid jid, Jid jid2) throws SmackException, XMPPException, InterruptedException;

    public abstract String getNamespace();

    /* access modifiers changed from: protected */
    public final IQ initiateIncomingStream(final XMPPConnection xMPPConnection, StreamInitiation streamInitiation) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException {
        final StreamInitiation createInitiationAccept = createInitiationAccept(streamInitiation, getNamespace());
        newStreamInitiation(streamInitiation.getFrom(), streamInitiation.getSessionID());
        try {
            IQ performActionAndWaitForEvent = initationSetEvents.performActionAndWaitForEvent(streamInitiation.getFrom().toString() + 9 + streamInitiation.getSessionID(), xMPPConnection.getReplyTimeout(), new EventManger.Callback<SmackException.NotConnectedException>() {
                public void action() throws SmackException.NotConnectedException {
                    try {
                        xMPPConnection.sendStanza(createInitiationAccept);
                    } catch (InterruptedException unused) {
                    }
                }
            });
            if (performActionAndWaitForEvent != null) {
                XMPPException.XMPPErrorException.ifHasErrorThenThrow(performActionAndWaitForEvent);
                return performActionAndWaitForEvent;
            }
            throw SmackException.NoResponseException.newWith(xMPPConnection, "stream initiation");
        } catch (InterruptedException e10) {
            throw new IllegalStateException(e10);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract InputStream negotiateIncomingStream(Stanza stanza) throws XMPPException.XMPPErrorException, InterruptedException, SmackException;

    /* access modifiers changed from: protected */
    public abstract void newStreamInitiation(Jid jid, String str);
}
