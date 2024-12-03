package org.jivesoftware.smackx.chat_markers;

import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.util.Consumer;
import org.jivesoftware.smackx.chat_markers.element.ChatMarkersElements;

public final /* synthetic */ class a implements Consumer {
    public final void accept(Object obj) {
        ((MessageBuilder) obj).addExtension(ChatMarkersElements.MarkableExtension.INSTANCE);
    }
}
