package org.jivesoftware.smack.xml;

import java.io.Reader;
import java.util.Iterator;
import java.util.ServiceLoader;

public class SmackXmlParser {
    private static XmlPullParserFactory xmlPullParserFactory;
    private static final ServiceLoader<XmlPullParserFactory> xmlPullParserFactoryServiceLoader = ServiceLoader.load(XmlPullParserFactory.class);

    public static XmlPullParserFactory getXmlPullParserFactory() {
        XmlPullParserFactory xmlPullParserFactory2 = xmlPullParserFactory;
        if (xmlPullParserFactory2 != null) {
            return xmlPullParserFactory2;
        }
        Iterator<XmlPullParserFactory> it = xmlPullParserFactoryServiceLoader.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new IllegalStateException("No XmlPullParserFactory registered with Service Provider Interface (SPI). Is smack-xmlparser-xpp3 or smack-xmlparser-stax in classpath?");
    }

    public static XmlPullParser newXmlParser(Reader reader) throws XmlPullParserException {
        return getXmlPullParserFactory().newXmlPullParser(reader);
    }

    public static void setXmlPullParserFactory(XmlPullParserFactory xmlPullParserFactory2) {
        xmlPullParserFactory = xmlPullParserFactory2;
    }
}
