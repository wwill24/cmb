package org.jivesoftware.smackx.bob.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.Pair;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.bob.BoBData;
import org.jivesoftware.smackx.bob.ContentId;

public class BoBProviderUtil {
    public static Pair<ContentId, BoBData> parseContentIdAndBobData(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws IOException, XmlPullParserException {
        BoBData boBData;
        ContentId fromCid = ContentId.fromCid(xmlPullParser.getAttributeValue("", "cid"));
        String attributeValue = xmlPullParser.getAttributeValue("", "type");
        Integer integerAttribute = ParserUtils.getIntegerAttribute(xmlPullParser, "max-age");
        String nextText = xmlPullParser.nextText();
        if (attributeValue != null) {
            boBData = new BoBData(attributeValue, nextText, integerAttribute);
        } else {
            boBData = null;
        }
        return Pair.create(fromCid, boBData);
    }
}
