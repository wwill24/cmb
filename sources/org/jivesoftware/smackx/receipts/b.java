package org.jivesoftware.smackx.receipts;

import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.util.Predicate;

public final /* synthetic */ class b implements Predicate {
    public final boolean test(Object obj) {
        return DeliveryReceiptManager.MESSAGES_TO_REQUEST_RECEIPTS_FOR.accept((Message) obj);
    }
}
