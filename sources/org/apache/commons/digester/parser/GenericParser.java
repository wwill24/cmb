package org.apache.commons.digester.parser;

import java.util.Properties;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

public class GenericParser {
    protected static String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
    private static final String JAXP_SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";
    protected static Log log = LogFactory.getLog("org.apache.commons.digester.Digester.sax");

    public static SAXParser newSAXParser(Properties properties) throws ParserConfigurationException, SAXException, SAXNotRecognizedException {
        SAXParser newSAXParser = ((SAXParserFactory) properties.get("SAXParserFactory")).newSAXParser();
        String str = (String) properties.get("schemaLocation");
        String str2 = (String) properties.get("schemaLanguage");
        if (str != null) {
            try {
                newSAXParser.setProperty(JAXP_SCHEMA_LANGUAGE, str2);
                newSAXParser.setProperty(JAXP_SCHEMA_SOURCE, str);
            } catch (SAXNotRecognizedException e10) {
                Log log2 = log;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(newSAXParser.getClass().getName());
                stringBuffer.append(": ");
                stringBuffer.append(e10.getMessage());
                stringBuffer.append(" not supported.");
                log2.info(stringBuffer.toString());
            }
        }
        return newSAXParser;
    }
}
