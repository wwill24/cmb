package org.apache.commons.digester.parser;

import java.util.Properties;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

public class XercesParser {
    protected static String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
    private static final String JAXP_SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";
    protected static String XERCES_DYNAMIC = "http://apache.org/xml/features/validation/dynamic";
    protected static String XERCES_SCHEMA = "http://apache.org/xml/features/validation/schema";
    protected static Log log = LogFactory.getLog("org.apache.commons.digester.Digester.sax");
    protected static float version;
    protected static String versionNumber = null;

    private static void configureOldXerces(SAXParser sAXParser, Properties properties) throws ParserConfigurationException, SAXNotSupportedException {
        String str = (String) properties.get("schemaLocation");
        String str2 = (String) properties.get("schemaLanguage");
        if (str != null) {
            try {
                sAXParser.setProperty(JAXP_SCHEMA_LANGUAGE, str2);
                sAXParser.setProperty(JAXP_SCHEMA_SOURCE, str);
            } catch (SAXNotRecognizedException e10) {
                Log log2 = log;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(sAXParser.getClass().getName());
                stringBuffer.append(": ");
                stringBuffer.append(e10.getMessage());
                stringBuffer.append(" not supported.");
                log2.info(stringBuffer.toString());
            }
        }
    }

    private static void configureXerces(SAXParserFactory sAXParserFactory) throws ParserConfigurationException, SAXNotRecognizedException, SAXNotSupportedException {
        sAXParserFactory.setFeature(XERCES_DYNAMIC, true);
        sAXParserFactory.setFeature(XERCES_SCHEMA, true);
    }

    private static String getXercesVersion() {
        try {
            String str = (String) Class.forName("org.apache.xerces.impl.Version").getMethod("getVersion", (Class[]) null).invoke((Object) null, (Object[]) null);
            return str.substring(8, str.lastIndexOf("."));
        } catch (Exception unused) {
            return "1.0";
        }
    }

    public static SAXParser newSAXParser(Properties properties) throws ParserConfigurationException, SAXException, SAXNotSupportedException {
        SAXParserFactory sAXParserFactory = (SAXParserFactory) properties.get("SAXParserFactory");
        if (versionNumber == null) {
            String xercesVersion = getXercesVersion();
            versionNumber = xercesVersion;
            version = new Float(xercesVersion).floatValue();
        }
        if (((double) version) > 2.1d) {
            configureXerces(sAXParserFactory);
            return sAXParserFactory.newSAXParser();
        }
        SAXParser newSAXParser = sAXParserFactory.newSAXParser();
        configureOldXerces(newSAXParser, properties);
        return newSAXParser;
    }
}
