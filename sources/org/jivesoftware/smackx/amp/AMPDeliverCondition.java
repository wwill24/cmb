package org.jivesoftware.smackx.amp;

import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.amp.packet.AMPExtension;

public class AMPDeliverCondition implements AMPExtension.Condition {
    public static final String NAME = "deliver";
    private final Value value;

    public enum Value {
        direct,
        forward,
        gateway,
        none,
        stored
    }

    public AMPDeliverCondition(Value value2) {
        if (value2 != null) {
            this.value = value2;
            return;
        }
        throw new NullPointerException("Can't create AMPDeliverCondition with null value");
    }

    public static boolean isSupported(XMPPConnection xMPPConnection) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        return AMPManager.isConditionSupported(xMPPConnection, NAME);
    }

    public String getName() {
        return NAME;
    }

    public String getValue() {
        return this.value.toString();
    }
}
