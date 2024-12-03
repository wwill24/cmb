package org.jivesoftware.smackx.filetransfer;

import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smackx.si.packet.StreamInitiation;
import org.jxmpp.jid.EntityFullJid;

public final class FileTransferManager extends Manager {
    private static final Map<XMPPConnection, FileTransferManager> INSTANCES = new WeakHashMap();
    private final FileTransferNegotiator fileTransferNegotiator;
    /* access modifiers changed from: private */
    public final List<FileTransferListener> listeners = new CopyOnWriteArrayList();

    private FileTransferManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.fileTransferNegotiator = FileTransferNegotiator.getInstanceFor(xMPPConnection);
        xMPPConnection.registerIQRequestHandler(new AbstractIqRequestHandler(StreamInitiation.ELEMENT, "http://jabber.org/protocol/si", IQ.Type.set, IQRequestHandler.Mode.async) {
            public IQ handleIQRequest(IQ iq) {
                FileTransferRequest fileTransferRequest = new FileTransferRequest(FileTransferManager.this, (StreamInitiation) iq);
                for (FileTransferListener fileTransferRequest2 : FileTransferManager.this.listeners) {
                    fileTransferRequest2.fileTransferRequest(fileTransferRequest);
                }
                return null;
            }
        });
    }

    public static synchronized FileTransferManager getInstanceFor(XMPPConnection xMPPConnection) {
        FileTransferManager fileTransferManager;
        synchronized (FileTransferManager.class) {
            Map<XMPPConnection, FileTransferManager> map = INSTANCES;
            fileTransferManager = map.get(xMPPConnection);
            if (fileTransferManager == null) {
                fileTransferManager = new FileTransferManager(xMPPConnection);
                map.put(xMPPConnection, fileTransferManager);
            }
        }
        return fileTransferManager;
    }

    public void addFileTransferListener(FileTransferListener fileTransferListener) {
        this.listeners.add(fileTransferListener);
    }

    /* access modifiers changed from: protected */
    public IncomingFileTransfer createIncomingFileTransfer(FileTransferRequest fileTransferRequest) {
        if (fileTransferRequest != null) {
            IncomingFileTransfer incomingFileTransfer = new IncomingFileTransfer(fileTransferRequest, this.fileTransferNegotiator);
            incomingFileTransfer.setFileInfo(fileTransferRequest.getFileName(), fileTransferRequest.getFileSize());
            return incomingFileTransfer;
        }
        throw new NullPointerException("ReceiveRequest cannot be null");
    }

    public OutgoingFileTransfer createOutgoingFileTransfer(EntityFullJid entityFullJid) {
        if (entityFullJid != null) {
            return new OutgoingFileTransfer(connection().getUser(), entityFullJid, FileTransferNegotiator.getNextStreamID(), this.fileTransferNegotiator);
        }
        throw new IllegalArgumentException("userID was null");
    }

    /* access modifiers changed from: protected */
    public void rejectIncomingFileTransfer(FileTransferRequest fileTransferRequest) throws SmackException.NotConnectedException, InterruptedException {
        connection().sendStanza(IQ.createErrorResponse((IQ) fileTransferRequest.getStreamInitiation(), StanzaError.getBuilder(StanzaError.Condition.forbidden).build()));
    }

    public void removeFileTransferListener(FileTransferListener fileTransferListener) {
        this.listeners.remove(fileTransferListener);
    }
}
