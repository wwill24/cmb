package org.jivesoftware.smack.provider;

import org.jivesoftware.smack.packet.TlsProceed;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.xml.XmlPullParser;

public final class TlsFailureProvider extends NonzaProvider<TlsProceed> {
    public static final TlsFailureProvider INSTANCE = new TlsFailureProvider();

    private TlsFailureProvider() {
    }

    public TlsProceed parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) {
        return TlsProceed.INSTANCE;
    }
}
