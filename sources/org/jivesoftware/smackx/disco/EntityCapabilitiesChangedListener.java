package org.jivesoftware.smackx.disco;

import org.jivesoftware.smackx.disco.packet.DiscoverInfo;

public interface EntityCapabilitiesChangedListener {
    void onEntityCapabilitiesChanged(DiscoverInfo discoverInfo);
}
