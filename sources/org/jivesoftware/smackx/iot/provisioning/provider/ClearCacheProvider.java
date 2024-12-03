package org.jivesoftware.smackx.iot.provisioning.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.iot.provisioning.element.ClearCache;

public class ClearCacheProvider extends IQProvider<ClearCache> {
    public ClearCache parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) {
        return new ClearCache();
    }
}
