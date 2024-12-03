package org.jivesoftware.smackx.pubsub;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smackx.pubsub.form.FilledConfigureForm;

public class ConfigurationEvent extends NodeExtension implements EmbeddedPacketExtension {
    private final FilledConfigureForm form;

    public ConfigurationEvent(String str) {
        this(str, (FilledConfigureForm) null);
    }

    public FilledConfigureForm getConfiguration() {
        return this.form;
    }

    public List<ExtensionElement> getExtensions() {
        if (getConfiguration() == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(new ExtensionElement[]{getConfiguration().getDataForm()});
    }

    public ConfigurationEvent(String str, FilledConfigureForm filledConfigureForm) {
        super(PubSubElementType.CONFIGURATION, str);
        this.form = filledConfigureForm;
    }
}
