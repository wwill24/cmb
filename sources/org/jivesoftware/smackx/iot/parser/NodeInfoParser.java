package org.jivesoftware.smackx.iot.parser;

import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.iot.element.NodeInfo;

public class NodeInfoParser {
    public static NodeInfo parse(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "nodeId");
        String attributeValue2 = xmlPullParser.getAttributeValue((String) null, "sourceId");
        String attributeValue3 = xmlPullParser.getAttributeValue((String) null, "cacheType");
        if (!StringUtils.isNullOrEmpty((CharSequence) attributeValue) || !StringUtils.isNullOrEmpty((CharSequence) attributeValue2) || !StringUtils.isNullOrEmpty((CharSequence) attributeValue3)) {
            return new NodeInfo(attributeValue, attributeValue2, attributeValue3);
        }
        return NodeInfo.EMPTY;
    }
}
