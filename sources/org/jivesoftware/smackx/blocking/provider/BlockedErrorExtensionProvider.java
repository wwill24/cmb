package org.jivesoftware.smackx.blocking.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.blocking.element.BlockedErrorExtension;

public class BlockedErrorExtensionProvider extends ExtensionElementProvider<BlockedErrorExtension> {
    public BlockedErrorExtension parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) {
        return new BlockedErrorExtension();
    }
}
