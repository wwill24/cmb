package org.jivesoftware.smackx.iot.discovery.provider;

import java.io.IOException;
import java.util.ArrayList;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.iot.discovery.element.IoTRegister;
import org.jivesoftware.smackx.iot.discovery.element.Tag;
import org.jivesoftware.smackx.iot.element.NodeInfo;
import org.jivesoftware.smackx.iot.parser.NodeInfoParser;

public class IoTRegisterProvider extends IQProvider<IoTRegister> {
    public IoTRegister parse(XmlPullParser xmlPullParser, int i10, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        Tag.Type type;
        boolean booleanAttribute = ParserUtils.getBooleanAttribute(xmlPullParser, "selfOwned", false);
        NodeInfo parse = NodeInfoParser.parse(xmlPullParser);
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.getDepth() != i10) {
            if (xmlPullParser.next() == XmlPullParser.Event.START_ELEMENT) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("num")) {
                    type = Tag.Type.num;
                } else if (!name.equals("str")) {
                    type = null;
                } else {
                    type = Tag.Type.str;
                }
                if (type != null) {
                    arrayList.add(new Tag(xmlPullParser.getAttributeValue((String) null, "name"), type, xmlPullParser.getAttributeValue((String) null, "value")));
                }
            }
        }
        return new IoTRegister(arrayList, parse, booleanAttribute);
    }
}
