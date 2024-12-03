package org.jivesoftware.smackx.iot;

import java.util.logging.Logger;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.iot.provisioning.IoTProvisioningManager;
import org.jxmpp.jid.Jid;

public abstract class IoTManager extends Manager {
    /* access modifiers changed from: private */
    public static final Logger LOGGER = Logger.getLogger(IoTManager.class.getName());
    private static boolean autoEnable;
    private boolean allowNonFriends;
    private final IoTProvisioningManager ioTProvisioningManager;

    protected abstract class IoTIqRequestHandler extends AbstractIqRequestHandler {
        protected IoTIqRequestHandler(String str, String str2, IQ.Type type, IQRequestHandler.Mode mode) {
            super(str, str2, type, mode);
        }

        public final IQ handleIQRequest(IQ iq) {
            if (IoTManager.this.isAllowed(iq.getFrom())) {
                return handleIoTIqRequest(iq);
            }
            Logger access$000 = IoTManager.LOGGER;
            access$000.warning("Ignoring IQ request " + iq);
            return null;
        }

        /* access modifiers changed from: protected */
        public abstract IQ handleIoTIqRequest(IQ iq);
    }

    protected IoTManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.ioTProvisioningManager = IoTProvisioningManager.getInstanceFor(xMPPConnection);
    }

    public static boolean isAutoEnableActive() {
        return autoEnable;
    }

    public static void setAutoEnableIoTManagers(boolean z10) {
        autoEnable = z10;
    }

    /* access modifiers changed from: protected */
    public boolean isAllowed(Jid jid) {
        if (this.allowNonFriends) {
            return true;
        }
        return this.ioTProvisioningManager.isMyFriend(jid);
    }

    public void setAllowNonFriends(boolean z10) {
        this.allowNonFriends = z10;
    }
}
