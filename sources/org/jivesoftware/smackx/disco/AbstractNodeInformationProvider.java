package org.jivesoftware.smackx.disco;

import java.util.List;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

public abstract class AbstractNodeInformationProvider implements NodeInformationProvider {
    public List<String> getNodeFeatures() {
        return null;
    }

    public List<DiscoverInfo.Identity> getNodeIdentities() {
        return null;
    }

    public List<DiscoverItems.Item> getNodeItems() {
        return null;
    }

    public List<? extends ExtensionElement> getNodePacketExtensions() {
        return null;
    }
}
