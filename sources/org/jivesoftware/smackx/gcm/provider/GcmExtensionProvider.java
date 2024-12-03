package org.jivesoftware.smackx.gcm.provider;

import org.jivesoftware.smackx.gcm.packet.GcmPacketExtension;
import org.jivesoftware.smackx.json.provider.AbstractJsonExtensionProvider;

public class GcmExtensionProvider extends AbstractJsonExtensionProvider<GcmPacketExtension> {
    public GcmPacketExtension from(String str) {
        return new GcmPacketExtension(str);
    }
}
