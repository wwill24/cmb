package org.jivesoftware.smackx.disco;

import java.util.List;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

public interface NodeInformationProvider {
    List<String> getNodeFeatures();

    List<DiscoverInfo.Identity> getNodeIdentities();

    List<DiscoverItems.Item> getNodeItems();

    List<? extends ExtensionElement> getNodePacketExtensions();
}
