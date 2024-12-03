package org.jivesoftware.smackx.bob.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.Pair;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.bob.BoBData;
import org.jivesoftware.smackx.bob.ContentId;
import org.jivesoftware.smackx.bob.element.BoBDataExtension;

public class BoBDataExtensionProvider extends ExtensionElementProvider<BoBDataExtension> {
    public BoBDataExtension parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        Pair<ContentId, BoBData> parseContentIdAndBobData = BoBProviderUtil.parseContentIdAndBobData(xmlPullParser, i10, xmlEnvironment);
        return new BoBDataExtension(parseContentIdAndBobData.getFirst(), parseContentIdAndBobData.getSecond());
    }
}
