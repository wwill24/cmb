package org.jivesoftware.smackx.iot.data.element;

import org.jivesoftware.smack.packet.ExtensionElement;

public abstract class IoTDataExtensionElement implements ExtensionElement {
    public final String getNamespace() {
        return "urn:xmpp:iot:sensordata";
    }
}
