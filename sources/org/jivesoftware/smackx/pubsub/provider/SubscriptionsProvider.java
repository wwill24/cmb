package org.jivesoftware.smackx.pubsub.provider;

import java.util.List;
import java.util.Map;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.provider.EmbeddedExtensionProvider;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jivesoftware.smackx.pubsub.SubscriptionsExtension;

public class SubscriptionsProvider extends EmbeddedExtensionProvider<SubscriptionsExtension> {
    /* access modifiers changed from: protected */
    public SubscriptionsExtension createReturnExtension(String str, String str2, Map<String, String> map, List<? extends ExtensionElement> list) {
        return new SubscriptionsExtension(SubscriptionsExtension.SubscriptionsNamespace.fromXmlns(str2), map.get(NodeElement.ELEMENT), list);
    }
}
