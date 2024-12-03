package org.jivesoftware.smackx.iot.provisioning.element;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.SimpleIQ;

public class ClearCache extends SimpleIQ {
    public static final String ELEMENT = "clearCache";
    public static final String NAMESPACE = "urn:xmpp:iot:provisioning";

    public ClearCache() {
        super(ELEMENT, "urn:xmpp:iot:provisioning");
        setType(IQ.Type.get);
    }
}
