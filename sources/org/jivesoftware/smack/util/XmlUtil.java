package org.jivesoftware.smack.util;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XmlUtil {
    private static final Logger LOGGER = Logger.getLogger(XmlUtil.class.getName());
    private static final TransformerFactory transformerFactory;

    static {
        TransformerFactory newInstance = TransformerFactory.newInstance();
        transformerFactory = newInstance;
        try {
            newInstance.setAttribute("indent-number", 2);
        } catch (IllegalArgumentException e10) {
            LOGGER.log(Level.INFO, "XML TransformerFactory does not support indent-number attribute", e10);
        }
    }

    public static boolean isClarkNotation(String str) {
        if (!str.isEmpty() && str.charAt(0) == '{') {
            return true;
        }
        return false;
    }

    public static String prettyFormatXml(CharSequence charSequence) {
        String charSequence2 = charSequence.toString();
        StreamSource streamSource = new StreamSource(new StringReader(charSequence2));
        StringWriter stringWriter = new StringWriter();
        StreamResult streamResult = new StreamResult(stringWriter);
        try {
            Transformer newTransformer = transformerFactory.newTransformer();
            newTransformer.setOutputProperty("omit-xml-declaration", "yes");
            newTransformer.setOutputProperty("indent", "yes");
            newTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            newTransformer.transform(streamSource, streamResult);
            return stringWriter.toString();
        } catch (IllegalArgumentException | TransformerException e10) {
            LOGGER.log(Level.SEVERE, "Transformer error", e10);
            return charSequence2;
        }
    }
}
