package org.jivesoftware.smackx.pubsub.provider;

import java.util.List;
import java.util.Map;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.provider.EmbeddedExtensionProvider;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jivesoftware.smackx.pubsub.FormNode;
import org.jivesoftware.smackx.pubsub.FormNodeType;
import org.jivesoftware.smackx.xdata.packet.DataForm;

public class FormNodeProvider extends EmbeddedExtensionProvider<FormNode> {
    /* access modifiers changed from: protected */
    public FormNode createReturnExtension(String str, String str2, Map<String, String> map, List<? extends ExtensionElement> list) {
        return new FormNode(FormNodeType.valueOfFromElementName(str, str2), map.get(NodeElement.ELEMENT), !list.isEmpty() ? (DataForm) list.get(0) : null);
    }
}
