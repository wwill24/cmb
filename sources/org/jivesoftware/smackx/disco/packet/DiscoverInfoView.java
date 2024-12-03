package org.jivesoftware.smackx.disco.packet;

import java.util.List;
import org.jivesoftware.smack.packet.IqView;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;

public interface DiscoverInfoView extends IqView {
    List<DiscoverInfo.Feature> getFeatures();

    List<DiscoverInfo.Identity> getIdentities();

    String getNode();
}
