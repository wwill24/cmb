package org.jivesoftware.smack.util;

import org.jivesoftware.smack.packet.StanzaBuilder;
import org.jivesoftware.smack.util.PacketParserUtils;

public final /* synthetic */ class l implements PacketParserUtils.StanzaBuilderSupplier {
    public final StanzaBuilder get(String str) {
        return StanzaBuilder.buildPresence(str);
    }
}
