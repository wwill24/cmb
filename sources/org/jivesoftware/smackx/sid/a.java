package org.jivesoftware.smackx.sid;

import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.util.Consumer;
import org.jivesoftware.smackx.sid.element.OriginIdElement;

public final /* synthetic */ class a implements Consumer {
    public final void accept(Object obj) {
        OriginIdElement.addTo((MessageBuilder) obj);
    }
}
