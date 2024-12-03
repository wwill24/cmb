package org.apache.commons.digester;

import java.util.Properties;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.apache.commons.digester.parser.GenericParser;
import org.apache.commons.digester.parser.XercesParser;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

public class ParserFeatureSetterFactory {
    private static boolean isXercesUsed;

    static {
        try {
            if (SAXParserFactory.newInstance().getClass().getName().startsWith("org.apache.xerces")) {
                isXercesUsed = true;
            }
        } catch (Exception unused) {
            isXercesUsed = false;
        }
    }

    public static SAXParser newSAXParser(Properties properties) throws ParserConfigurationException, SAXException, SAXNotRecognizedException, SAXNotSupportedException {
        if (isXercesUsed) {
            return XercesParser.newSAXParser(properties);
        }
        return GenericParser.newSAXParser(properties);
    }
}
