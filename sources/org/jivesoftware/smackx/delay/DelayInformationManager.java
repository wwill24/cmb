package org.jivesoftware.smackx.delay;

import java.util.Date;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.delay.packet.DelayInformation;

public class DelayInformationManager {
    public static final String LEGACY_DELAYED_DELIVERY_ELEMENT = "x";
    public static final String LEGACY_DELAYED_DELIVERY_NAMESPACE = "jabber:x:delay";
    public static final QName QNAME = new QName(LEGACY_DELAYED_DELIVERY_NAMESPACE, "x");

    public static DelayInformation getDelayInformation(Stanza stanza) {
        DelayInformation xep203DelayInformation = getXep203DelayInformation(stanza);
        if (xep203DelayInformation != null) {
            return xep203DelayInformation;
        }
        return getLegacyDelayInformation(stanza);
    }

    public static Date getDelayTimestamp(Stanza stanza) {
        DelayInformation delayInformation = getDelayInformation(stanza);
        if (delayInformation == null) {
            return null;
        }
        return delayInformation.getStamp();
    }

    public static DelayInformation getLegacyDelayInformation(Stanza stanza) {
        return (DelayInformation) stanza.getExtension(DelayInformation.class);
    }

    public static DelayInformation getXep203DelayInformation(Stanza stanza) {
        return DelayInformation.from(stanza);
    }

    public static boolean isDelayedStanza(Stanza stanza) {
        return getDelayInformation(stanza) != null;
    }
}
