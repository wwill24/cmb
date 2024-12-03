package org.jivesoftware.smack.compress.provider;

import org.jivesoftware.smack.compress.packet.Compressed;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.NonzaProvider;
import org.jivesoftware.smack.xml.XmlPullParser;

public final class CompressedProvider extends NonzaProvider<Compressed> {
    public static final CompressedProvider INSTANCE = new CompressedProvider();

    private CompressedProvider() {
    }

    public Compressed parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) {
        return Compressed.INSTANCE;
    }
}
