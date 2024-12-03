package org.jivesoftware.smackx.pubsub.provider;

import java.util.List;
import java.util.Map;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.provider.EmbeddedExtensionProvider;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jivesoftware.smackx.pubsub.ItemsExtension;

public class ItemsProvider extends EmbeddedExtensionProvider<ItemsExtension> {
    /* access modifiers changed from: protected */
    public ItemsExtension createReturnExtension(String str, String str2, Map<String, String> map, List<? extends ExtensionElement> list) {
        return new ItemsExtension(ItemsExtension.ItemsElementType.items, map.get(NodeElement.ELEMENT), (List<? extends NamedElement>) list);
    }
}
