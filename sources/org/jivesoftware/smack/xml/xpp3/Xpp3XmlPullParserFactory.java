package org.jivesoftware.smack.xml.xpp3;

import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.xml.XmlPullParserFactory;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class Xpp3XmlPullParserFactory implements XmlPullParserFactory {
    public static final String FEATURE_XML_ROUNDTRIP = "http://xmlpull.org/v1/doc/features.html#xml-roundtrip";
    private static final Logger LOGGER = Logger.getLogger(Xpp3XmlPullParserFactory.class.getName());
    public static final boolean XML_PULL_PARSER_SUPPORTS_ROUNDTRIP;
    private static final org.xmlpull.v1.XmlPullParserFactory XPP3_XML_PULL_PARSER_FACTORY;

    static {
        try {
            org.xmlpull.v1.XmlPullParserFactory newInstance = org.xmlpull.v1.XmlPullParserFactory.newInstance();
            XPP3_XML_PULL_PARSER_FACTORY = newInstance;
            boolean z10 = true;
            try {
                newInstance.newPullParser().setFeature(FEATURE_XML_ROUNDTRIP, true);
            } catch (XmlPullParserException e10) {
                LOGGER.log(Level.FINEST, "XmlPullParser does not support XML_ROUNDTRIP", e10);
                z10 = false;
            }
            XML_PULL_PARSER_SUPPORTS_ROUNDTRIP = z10;
        } catch (XmlPullParserException e11) {
            throw new AssertionError(e11);
        }
    }

    public Xpp3XmlPullParser newXmlPullParser(Reader reader) throws org.jivesoftware.smack.xml.XmlPullParserException {
        try {
            XmlPullParser newPullParser = XPP3_XML_PULL_PARSER_FACTORY.newPullParser();
            newPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, true);
            newPullParser.setInput(reader);
            if (XML_PULL_PARSER_SUPPORTS_ROUNDTRIP) {
                try {
                    newPullParser.setFeature(FEATURE_XML_ROUNDTRIP, true);
                } catch (XmlPullParserException e10) {
                    LOGGER.log(Level.SEVERE, "XmlPullParser does not support XML_ROUNDTRIP, although it was first determined to be supported", e10);
                }
            }
            return new Xpp3XmlPullParser(newPullParser);
        } catch (XmlPullParserException e11) {
            throw new org.jivesoftware.smack.xml.XmlPullParserException((Exception) e11);
        }
    }
}
