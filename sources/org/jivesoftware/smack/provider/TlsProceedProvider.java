package org.jivesoftware.smack.provider;

import org.jivesoftware.smack.packet.TlsFailure;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.xml.XmlPullParser;

public final class TlsProceedProvider extends NonzaProvider<TlsFailure> {
    public static final TlsProceedProvider INSTANCE = new TlsProceedProvider();

    private TlsProceedProvider() {
    }

    public TlsFailure parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) {
        return TlsFailure.INSTANCE;
    }
}
