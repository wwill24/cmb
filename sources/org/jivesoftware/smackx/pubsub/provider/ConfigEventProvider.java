package org.jivesoftware.smackx.pubsub.provider;

import java.util.List;
import java.util.Map;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.provider.EmbeddedExtensionProvider;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jivesoftware.smackx.pubsub.ConfigurationEvent;
import org.jivesoftware.smackx.pubsub.form.FilledConfigureForm;
import org.jivesoftware.smackx.xdata.packet.DataForm;

public class ConfigEventProvider extends EmbeddedExtensionProvider<ConfigurationEvent> {
    /* access modifiers changed from: protected */
    public ConfigurationEvent createReturnExtension(String str, String str2, Map<String, String> map, List<? extends ExtensionElement> list) {
        if (list.size() == 0) {
            return new ConfigurationEvent(map.get(NodeElement.ELEMENT));
        }
        return new ConfigurationEvent(map.get(NodeElement.ELEMENT), new FilledConfigureForm((DataForm) list.iterator().next()));
    }
}
