package org.apache.commons.digester.xmlrules;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.commons.digester.Digester;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class DigesterLoader {
    public static Digester createDigester(InputSource inputSource) {
        FromXmlRuleSet fromXmlRuleSet = new FromXmlRuleSet(inputSource);
        Digester digester = new Digester();
        digester.addRuleSet(fromXmlRuleSet);
        return digester;
    }

    public static Object load(URL url, ClassLoader classLoader, URL url2) throws IOException, SAXException, DigesterLoadingException {
        return load(url, classLoader, url2.openStream());
    }

    public static Object load(URL url, ClassLoader classLoader, InputStream inputStream) throws IOException, SAXException, DigesterLoadingException {
        Digester createDigester = createDigester(url);
        createDigester.setClassLoader(classLoader);
        try {
            return createDigester.parse(inputStream);
        } catch (XmlLoadException e10) {
            throw new DigesterLoadingException(e10.getMessage(), e10);
        }
    }

    public static Digester createDigester(InputSource inputSource, Digester digester) {
        FromXmlRuleSet fromXmlRuleSet = new FromXmlRuleSet(inputSource, digester);
        Digester digester2 = new Digester();
        digester2.addRuleSet(fromXmlRuleSet);
        return digester2;
    }

    public static Object load(URL url, ClassLoader classLoader, Reader reader) throws IOException, SAXException, DigesterLoadingException {
        Digester createDigester = createDigester(url);
        createDigester.setClassLoader(classLoader);
        try {
            return createDigester.parse(reader);
        } catch (XmlLoadException e10) {
            throw new DigesterLoadingException(e10.getMessage(), e10);
        }
    }

    public static Digester createDigester(URL url) {
        FromXmlRuleSet fromXmlRuleSet = new FromXmlRuleSet(url);
        Digester digester = new Digester();
        digester.addRuleSet(fromXmlRuleSet);
        return digester;
    }

    public static Digester createDigester(URL url, Digester digester) {
        FromXmlRuleSet fromXmlRuleSet = new FromXmlRuleSet(url, digester);
        Digester digester2 = new Digester();
        digester2.addRuleSet(fromXmlRuleSet);
        return digester2;
    }

    public static Object load(URL url, ClassLoader classLoader, URL url2, Object obj) throws IOException, SAXException, DigesterLoadingException {
        return load(url, classLoader, url2.openStream(), obj);
    }

    public static Object load(URL url, ClassLoader classLoader, InputStream inputStream, Object obj) throws IOException, SAXException, DigesterLoadingException {
        Digester createDigester = createDigester(url);
        createDigester.setClassLoader(classLoader);
        createDigester.push(obj);
        try {
            return createDigester.parse(inputStream);
        } catch (XmlLoadException e10) {
            throw new DigesterLoadingException(e10.getMessage(), e10);
        }
    }

    public static Object load(URL url, ClassLoader classLoader, Reader reader, Object obj) throws IOException, SAXException, DigesterLoadingException {
        Digester createDigester = createDigester(url);
        createDigester.setClassLoader(classLoader);
        createDigester.push(obj);
        try {
            return createDigester.parse(reader);
        } catch (XmlLoadException e10) {
            throw new DigesterLoadingException(e10.getMessage(), e10);
        }
    }
}
