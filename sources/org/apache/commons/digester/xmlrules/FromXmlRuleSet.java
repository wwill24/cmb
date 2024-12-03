package org.apache.commons.digester.xmlrules;

import java.net.URL;
import org.apache.commons.digester.Digester;
import org.apache.commons.digester.RuleSetBase;
import org.xml.sax.InputSource;

public class FromXmlRuleSet extends RuleSetBase {
    public static final String DIGESTER_DTD_PATH = "org/apache/commons/digester/xmlrules/digester-rules.dtd";
    private DigesterRuleParser parser;
    /* access modifiers changed from: private */
    public Digester rulesDigester;
    private XMLRulesLoader rulesLoader;

    private class InputSourceXMLRulesLoader extends XMLRulesLoader {
        private InputSource inputSource;
        private final /* synthetic */ FromXmlRuleSet this$0;

        public InputSourceXMLRulesLoader(FromXmlRuleSet fromXmlRuleSet, InputSource inputSource2) {
            super();
            this.this$0 = fromXmlRuleSet;
            this.inputSource = inputSource2;
        }

        public void loadRules() throws XmlLoadException {
            try {
                this.this$0.rulesDigester.parse(this.inputSource);
            } catch (Exception e10) {
                throw new XmlLoadException((Throwable) e10);
            }
        }
    }

    private class URLXMLRulesLoader extends XMLRulesLoader {
        private final /* synthetic */ FromXmlRuleSet this$0;
        private URL url;

        public URLXMLRulesLoader(FromXmlRuleSet fromXmlRuleSet, URL url2) {
            super();
            this.this$0 = fromXmlRuleSet;
            this.url = url2;
        }

        public void loadRules() throws XmlLoadException {
            try {
                this.this$0.rulesDigester.parse(this.url.openStream());
            } catch (Exception e10) {
                throw new XmlLoadException((Throwable) e10);
            }
        }
    }

    private static abstract class XMLRulesLoader {
        private XMLRulesLoader() {
        }

        public abstract void loadRules() throws XmlLoadException;
    }

    public FromXmlRuleSet(URL url) {
        this(url, new DigesterRuleParser(), new Digester());
    }

    private void init(XMLRulesLoader xMLRulesLoader, DigesterRuleParser digesterRuleParser, Digester digester) {
        this.rulesLoader = xMLRulesLoader;
        this.parser = digesterRuleParser;
        this.rulesDigester = digester;
    }

    public void addRuleInstances(Digester digester) throws XmlLoadException {
        addRuleInstances(digester, (String) null);
    }

    public FromXmlRuleSet(URL url, Digester digester) {
        this(url, new DigesterRuleParser(), digester);
    }

    public void addRuleInstances(Digester digester, String str) throws XmlLoadException {
        URL resource = getClass().getClassLoader().getResource(DIGESTER_DTD_PATH);
        if (resource != null) {
            this.parser.setDigesterRulesDTD(resource.toString());
            this.parser.setTarget(digester);
            this.parser.setBasePath(str);
            this.rulesDigester.addRuleSet(this.parser);
            this.rulesDigester.push(this.parser);
            this.rulesLoader.loadRules();
            return;
        }
        throw new XmlLoadException("Cannot find resource \"org/apache/commons/digester/xmlrules/digester-rules.dtd\"");
    }

    public FromXmlRuleSet(URL url, DigesterRuleParser digesterRuleParser) {
        this(url, digesterRuleParser, new Digester());
    }

    public FromXmlRuleSet(URL url, DigesterRuleParser digesterRuleParser, Digester digester) {
        init(new URLXMLRulesLoader(this, url), digesterRuleParser, digester);
    }

    public FromXmlRuleSet(InputSource inputSource) {
        this(inputSource, new DigesterRuleParser(), new Digester());
    }

    public FromXmlRuleSet(InputSource inputSource, Digester digester) {
        this(inputSource, new DigesterRuleParser(), digester);
    }

    public FromXmlRuleSet(InputSource inputSource, DigesterRuleParser digesterRuleParser) {
        this(inputSource, digesterRuleParser, new Digester());
    }

    public FromXmlRuleSet(InputSource inputSource, DigesterRuleParser digesterRuleParser, Digester digester) {
        init(new InputSourceXMLRulesLoader(this, inputSource), digesterRuleParser, digester);
    }
}
