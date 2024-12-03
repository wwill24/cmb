package org.jivesoftware.smackx.json.provider;

import org.jivesoftware.smackx.json.packet.JsonPacketExtension;

public class JsonExtensionProvider extends AbstractJsonExtensionProvider<JsonPacketExtension> {
    public JsonPacketExtension from(String str) {
        return new JsonPacketExtension(str);
    }
}
