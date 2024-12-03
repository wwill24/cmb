package org.jivesoftware.smackx.receipts;

import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.util.Consumer;

public final /* synthetic */ class a implements Consumer {
    public final void accept(Object obj) {
        DeliveryReceiptRequest.addTo((MessageBuilder) obj);
    }
}
