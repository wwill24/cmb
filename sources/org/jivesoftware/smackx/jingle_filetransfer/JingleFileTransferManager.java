package org.jivesoftware.smackx.jingle_filetransfer;

import java.util.WeakHashMap;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.XMPPConnection;

public final class JingleFileTransferManager extends Manager {
    private static final WeakHashMap<XMPPConnection, JingleFileTransferManager> INSTANCES = new WeakHashMap<>();

    private JingleFileTransferManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
    }

    public static synchronized JingleFileTransferManager getInstanceFor(XMPPConnection xMPPConnection) {
        JingleFileTransferManager jingleFileTransferManager;
        synchronized (JingleFileTransferManager.class) {
            WeakHashMap<XMPPConnection, JingleFileTransferManager> weakHashMap = INSTANCES;
            jingleFileTransferManager = weakHashMap.get(xMPPConnection);
            if (jingleFileTransferManager == null) {
                jingleFileTransferManager = new JingleFileTransferManager(xMPPConnection);
                weakHashMap.put(xMPPConnection, jingleFileTransferManager);
            }
        }
        return jingleFileTransferManager;
    }
}
