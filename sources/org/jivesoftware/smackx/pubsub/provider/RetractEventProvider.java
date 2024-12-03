package org.jivesoftware.smackx.pubsub.provider;

import java.util.List;
import java.util.Map;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.provider.EmbeddedExtensionProvider;
import org.jivesoftware.smackx.pubsub.RetractItem;

public class RetractEventProvider extends EmbeddedExtensionProvider<RetractItem> {
    /* access modifiers changed from: protected */
    public RetractItem createReturnExtension(String str, String str2, Map<String, String> map, List<? extends ExtensionElement> list) {
        return new RetractItem(map.get("id"));
    }
}
