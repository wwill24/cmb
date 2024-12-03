package org.jivesoftware.smackx.fallback_indication;

import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.fallback_indication.element.FallbackIndicationElement;

public interface FallbackIndicationListener {
    void onFallbackIndicationReceived(Message message, FallbackIndicationElement fallbackIndicationElement, String str);
}
