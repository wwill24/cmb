package org.apache.commons.digester;

import com.mparticle.kits.AppsFlyerKit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.apache.commons.collections.ArrayStack;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class Digester extends DefaultHandler {
    protected static final String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
    protected String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
    protected StringBuffer bodyText = new StringBuffer();
    protected ArrayStack bodyTexts = new ArrayStack();
    protected ClassLoader classLoader = null;
    protected boolean configured = false;
    private ContentHandler customContentHandler = null;
    protected EntityResolver entityResolver;
    protected HashMap entityValidator = new HashMap();
    protected ErrorHandler errorHandler = null;
    protected SAXParserFactory factory = null;
    protected List inputSources = new ArrayList(5);
    protected Locator locator = null;
    protected Log log = LogFactory.getLog("org.apache.commons.digester.Digester");
    protected String match = "";
    protected ArrayStack matches = new ArrayStack(10);
    protected boolean namespaceAware = false;
    protected HashMap namespaces = new HashMap();
    protected ArrayStack params = new ArrayStack();
    protected SAXParser parser = null;
    protected String publicId = null;
    protected XMLReader reader = null;
    protected Object root = null;
    protected Rules rules = null;
    protected Log saxLog = LogFactory.getLog("org.apache.commons.digester.Digester.sax");
    protected String schemaLanguage = W3C_XML_SCHEMA;
    protected String schemaLocation = null;
    protected ArrayStack stack = new ArrayStack();
    private StackAction stackAction = null;
    private HashMap stacksByName = new HashMap();
    protected Substitutor substitutor;
    protected boolean useContextClassLoader = false;
    protected boolean validating = false;

    public Digester() {
    }

    public void addBeanPropertySetter(String str) {
        addRule(str, new BeanPropertySetterRule());
    }

    public void addCallMethod(String str, String str2) {
        addRule(str, new CallMethodRule(str2));
    }

    public void addCallParam(String str, int i10) {
        addRule(str, new CallParamRule(i10));
    }

    public void addCallParamPath(String str, int i10) {
        addRule(str, new PathCallParamRule(i10));
    }

    public void addFactoryCreate(String str, String str2) {
        addFactoryCreate(str, str2, false);
    }

    public void addObjectCreate(String str, String str2) {
        addRule(str, new ObjectCreateRule(str2));
    }

    public void addObjectParam(String str, int i10, Object obj) {
        addRule(str, new ObjectParamRule(i10, obj));
    }

    public void addRule(String str, Rule rule) {
        rule.setDigester(this);
        getRules().add(str, rule);
    }

    public void addRuleSet(RuleSet ruleSet) {
        String ruleNamespaceURI = getRuleNamespaceURI();
        String namespaceURI = ruleSet.getNamespaceURI();
        if (this.log.isDebugEnabled()) {
            if (namespaceURI == null) {
                this.log.debug("addRuleSet() with no namespace URI");
            } else {
                Log log2 = this.log;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("addRuleSet() with namespace URI ");
                stringBuffer.append(namespaceURI);
                log2.debug(stringBuffer.toString());
            }
        }
        setRuleNamespaceURI(namespaceURI);
        ruleSet.addRuleInstances(this);
        setRuleNamespaceURI(ruleNamespaceURI);
    }

    public void addSetNestedProperties(String str) {
        addRule(str, new SetNestedPropertiesRule());
    }

    public void addSetNext(String str, String str2) {
        addRule(str, new SetNextRule(str2));
    }

    public void addSetProperties(String str) {
        addRule(str, new SetPropertiesRule());
    }

    public void addSetProperty(String str, String str2, String str3) {
        addRule(str, new SetPropertyRule(str2, str3));
    }

    public void addSetRoot(String str, String str2) {
        addRule(str, new SetRootRule(str2));
    }

    public void addSetTop(String str, String str2) {
        addRule(str, new SetTopRule(str2));
    }

    public void characters(char[] cArr, int i10, int i11) throws SAXException {
        ContentHandler contentHandler = this.customContentHandler;
        if (contentHandler != null) {
            contentHandler.characters(cArr, i10, i11);
            return;
        }
        if (this.saxLog.isDebugEnabled()) {
            Log log2 = this.saxLog;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("characters(");
            stringBuffer.append(new String(cArr, i10, i11));
            stringBuffer.append(")");
            log2.debug(stringBuffer.toString());
        }
        this.bodyText.append(cArr, i10, i11);
    }

    /* access modifiers changed from: protected */
    public void cleanup() {
        for (InputSource byteStream : this.inputSources) {
            try {
                byteStream.getByteStream().close();
            } catch (IOException unused) {
            }
        }
        this.inputSources.clear();
    }

    public void clear() {
        this.match = "";
        this.bodyTexts.clear();
        this.params.clear();
        this.publicId = null;
        this.stack.clear();
        this.stacksByName.clear();
        this.customContentHandler = null;
    }

    /* access modifiers changed from: protected */
    public void configure() {
        if (!this.configured) {
            initialize();
            this.configured = true;
        }
    }

    public InputSource createInputSourceFromURL(URL url) throws MalformedURLException, IOException {
        URLConnection openConnection = url.openConnection();
        openConnection.setUseCaches(false);
        InputSource inputSource = new InputSource(openConnection.getInputStream());
        inputSource.setSystemId(url.toExternalForm());
        this.inputSources.add(inputSource);
        return inputSource;
    }

    public SAXException createSAXException(String str, Exception exc) {
        Throwable targetException;
        if (exc != null && (exc instanceof InvocationTargetException) && (targetException = ((InvocationTargetException) exc).getTargetException()) != null && (targetException instanceof Exception)) {
            exc = (Exception) targetException;
        }
        if (this.locator != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Error at line ");
            stringBuffer.append(this.locator.getLineNumber());
            stringBuffer.append(" char ");
            stringBuffer.append(this.locator.getColumnNumber());
            stringBuffer.append(": ");
            stringBuffer.append(str);
            String stringBuffer2 = stringBuffer.toString();
            if (exc != null) {
                return new SAXParseException(stringBuffer2, this.locator, exc);
            }
            return new SAXParseException(stringBuffer2, this.locator);
        }
        this.log.error("No Locator!");
        if (exc != null) {
            return new SAXException(str, exc);
        }
        return new SAXException(str);
    }

    public void endDocument() throws SAXException {
        if (this.saxLog.isDebugEnabled()) {
            if (getCount() > 1) {
                Log log2 = this.saxLog;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("endDocument():  ");
                stringBuffer.append(getCount());
                stringBuffer.append(" elements left");
                log2.debug(stringBuffer.toString());
            } else {
                this.saxLog.debug("endDocument()");
            }
        }
        for (Rule finish : getRules().rules()) {
            try {
                finish.finish();
            } catch (Exception e10) {
                this.log.error("Finish event threw exception", e10);
                throw createSAXException(e10);
            } catch (Error e11) {
                this.log.error("Finish event threw error", e11);
                throw e11;
            }
        }
        clear();
    }

    public void endElement(String str, String str2, String str3) throws SAXException {
        ContentHandler contentHandler = this.customContentHandler;
        if (contentHandler != null) {
            contentHandler.endElement(str, str2, str3);
            return;
        }
        boolean isDebugEnabled = this.log.isDebugEnabled();
        if (isDebugEnabled) {
            if (this.saxLog.isDebugEnabled()) {
                Log log2 = this.saxLog;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("endElement(");
                stringBuffer.append(str);
                stringBuffer.append(AppsFlyerKit.COMMA);
                stringBuffer.append(str2);
                stringBuffer.append(AppsFlyerKit.COMMA);
                stringBuffer.append(str3);
                stringBuffer.append(")");
                log2.debug(stringBuffer.toString());
            }
            Log log3 = this.log;
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("  match='");
            stringBuffer2.append(this.match);
            stringBuffer2.append("'");
            log3.debug(stringBuffer2.toString());
            Log log4 = this.log;
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("  bodyText='");
            stringBuffer3.append(this.bodyText);
            stringBuffer3.append("'");
            log4.debug(stringBuffer3.toString());
        }
        if (str2 == null || str2.length() < 1) {
            str2 = str3;
        }
        List list = (List) this.matches.pop();
        if (list != null && list.size() > 0) {
            String stringBuffer4 = this.bodyText.toString();
            Substitutor substitutor2 = getSubstitutor();
            if (substitutor2 != null) {
                stringBuffer4 = substitutor2.substitute(stringBuffer4);
            }
            int i10 = 0;
            while (i10 < list.size()) {
                try {
                    Rule rule = (Rule) list.get(i10);
                    if (isDebugEnabled) {
                        Log log5 = this.log;
                        StringBuffer stringBuffer5 = new StringBuffer();
                        stringBuffer5.append("  Fire body() for ");
                        stringBuffer5.append(rule);
                        log5.debug(stringBuffer5.toString());
                    }
                    rule.body(str, str2, stringBuffer4);
                    i10++;
                } catch (Exception e10) {
                    this.log.error("Body event threw exception", e10);
                    throw createSAXException(e10);
                } catch (Error e11) {
                    this.log.error("Body event threw error", e11);
                    throw e11;
                }
            }
        } else if (isDebugEnabled) {
            Log log6 = this.log;
            StringBuffer stringBuffer6 = new StringBuffer();
            stringBuffer6.append("  No rules found matching '");
            stringBuffer6.append(this.match);
            stringBuffer6.append("'.");
            log6.debug(stringBuffer6.toString());
        }
        this.bodyText = (StringBuffer) this.bodyTexts.pop();
        if (isDebugEnabled) {
            Log log7 = this.log;
            StringBuffer stringBuffer7 = new StringBuffer();
            stringBuffer7.append("  Popping body text '");
            stringBuffer7.append(this.bodyText.toString());
            stringBuffer7.append("'");
            log7.debug(stringBuffer7.toString());
        }
        if (list != null) {
            int i11 = 0;
            while (i11 < list.size()) {
                try {
                    Rule rule2 = (Rule) list.get((list.size() - i11) - 1);
                    if (isDebugEnabled) {
                        Log log8 = this.log;
                        StringBuffer stringBuffer8 = new StringBuffer();
                        stringBuffer8.append("  Fire end() for ");
                        stringBuffer8.append(rule2);
                        log8.debug(stringBuffer8.toString());
                    }
                    rule2.end(str, str2);
                    i11++;
                } catch (Exception e12) {
                    this.log.error("End event threw exception", e12);
                    throw createSAXException(e12);
                } catch (Error e13) {
                    this.log.error("End event threw error", e13);
                    throw e13;
                }
            }
        }
        int lastIndexOf = this.match.lastIndexOf(47);
        if (lastIndexOf >= 0) {
            this.match = this.match.substring(0, lastIndexOf);
        } else {
            this.match = "";
        }
    }

    public void endPrefixMapping(String str) throws SAXException {
        if (this.saxLog.isDebugEnabled()) {
            Log log2 = this.saxLog;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("endPrefixMapping(");
            stringBuffer.append(str);
            stringBuffer.append(")");
            log2.debug(stringBuffer.toString());
        }
        ArrayStack arrayStack = (ArrayStack) this.namespaces.get(str);
        if (arrayStack != null) {
            try {
                arrayStack.pop();
                if (arrayStack.empty()) {
                    this.namespaces.remove(str);
                }
            } catch (EmptyStackException unused) {
                throw createSAXException("endPrefixMapping popped too many times");
            }
        }
    }

    public void error(SAXParseException sAXParseException) throws SAXException {
        Log log2 = this.log;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Parse Error at line ");
        stringBuffer.append(sAXParseException.getLineNumber());
        stringBuffer.append(" column ");
        stringBuffer.append(sAXParseException.getColumnNumber());
        stringBuffer.append(": ");
        stringBuffer.append(sAXParseException.getMessage());
        log2.error(stringBuffer.toString(), sAXParseException);
        ErrorHandler errorHandler2 = this.errorHandler;
        if (errorHandler2 != null) {
            errorHandler2.error(sAXParseException);
        }
    }

    public void fatalError(SAXParseException sAXParseException) throws SAXException {
        Log log2 = this.log;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Parse Fatal Error at line ");
        stringBuffer.append(sAXParseException.getLineNumber());
        stringBuffer.append(" column ");
        stringBuffer.append(sAXParseException.getColumnNumber());
        stringBuffer.append(": ");
        stringBuffer.append(sAXParseException.getMessage());
        log2.error(stringBuffer.toString(), sAXParseException);
        ErrorHandler errorHandler2 = this.errorHandler;
        if (errorHandler2 != null) {
            errorHandler2.fatalError(sAXParseException);
        }
    }

    public String findNamespaceURI(String str) {
        ArrayStack arrayStack = (ArrayStack) this.namespaces.get(str);
        if (arrayStack == null) {
            return null;
        }
        try {
            return (String) arrayStack.peek();
        } catch (EmptyStackException unused) {
            return null;
        }
    }

    public ClassLoader getClassLoader() {
        ClassLoader contextClassLoader;
        ClassLoader classLoader2 = this.classLoader;
        if (classLoader2 != null) {
            return classLoader2;
        }
        if (!this.useContextClassLoader || (contextClassLoader = Thread.currentThread().getContextClassLoader()) == null) {
            return getClass().getClassLoader();
        }
        return contextClassLoader;
    }

    public int getCount() {
        return this.stack.size();
    }

    public String getCurrentElementName() {
        String str = this.match;
        int lastIndexOf = str.lastIndexOf(47);
        if (lastIndexOf >= 0) {
            return str.substring(lastIndexOf + 1);
        }
        return str;
    }

    public Map getCurrentNamespaces() {
        if (!this.namespaceAware) {
            this.log.warn("Digester is not namespace aware");
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : this.namespaces.entrySet()) {
            try {
                hashMap.put(entry.getKey(), ((ArrayStack) entry.getValue()).peek());
            } catch (RuntimeException e10) {
                this.log.error(e10.getMessage(), e10);
                throw e10;
            }
        }
        return hashMap;
    }

    public ContentHandler getCustomContentHandler() {
        return this.customContentHandler;
    }

    public int getDebug() {
        return 0;
    }

    public Locator getDocumentLocator() {
        return this.locator;
    }

    public EntityResolver getEntityResolver() {
        return this.entityResolver;
    }

    public ErrorHandler getErrorHandler() {
        return this.errorHandler;
    }

    public SAXParserFactory getFactory() {
        if (this.factory == null) {
            SAXParserFactory newInstance = SAXParserFactory.newInstance();
            this.factory = newInstance;
            newInstance.setNamespaceAware(this.namespaceAware);
            this.factory.setValidating(this.validating);
        }
        return this.factory;
    }

    public boolean getFeature(String str) throws ParserConfigurationException, SAXNotRecognizedException, SAXNotSupportedException {
        return getFactory().getFeature(str);
    }

    public Log getLogger() {
        return this.log;
    }

    public String getMatch() {
        return this.match;
    }

    public boolean getNamespaceAware() {
        return this.namespaceAware;
    }

    public SAXParser getParser() {
        SAXParser sAXParser = this.parser;
        if (sAXParser != null) {
            return sAXParser;
        }
        try {
            if (!this.validating || this.schemaLocation == null) {
                this.parser = getFactory().newSAXParser();
            } else {
                Properties properties = new Properties();
                properties.put("SAXParserFactory", getFactory());
                String str = this.schemaLocation;
                if (str != null) {
                    properties.put("schemaLocation", str);
                    properties.put("schemaLanguage", this.schemaLanguage);
                }
                this.parser = ParserFeatureSetterFactory.newSAXParser(properties);
            }
            return this.parser;
        } catch (Exception e10) {
            this.log.error("Digester.getParser: ", e10);
            return null;
        }
    }

    public Object getProperty(String str) throws SAXNotRecognizedException, SAXNotSupportedException {
        return getParser().getProperty(str);
    }

    public String getPublicId() {
        return this.publicId;
    }

    public XMLReader getReader() {
        try {
            return getXMLReader();
        } catch (SAXException e10) {
            this.log.error("Cannot get XMLReader", e10);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public Map getRegistrations() {
        return this.entityValidator;
    }

    public Object getRoot() {
        return this.root;
    }

    public String getRuleNamespaceURI() {
        return getRules().getNamespaceURI();
    }

    public Rules getRules() {
        if (this.rules == null) {
            RulesBase rulesBase = new RulesBase();
            this.rules = rulesBase;
            rulesBase.setDigester(this);
        }
        return this.rules;
    }

    public Log getSAXLogger() {
        return this.saxLog;
    }

    public String getSchema() {
        return this.schemaLocation;
    }

    public String getSchemaLanguage() {
        return this.schemaLanguage;
    }

    public StackAction getStackAction() {
        return this.stackAction;
    }

    public Substitutor getSubstitutor() {
        return this.substitutor;
    }

    public boolean getUseContextClassLoader() {
        return this.useContextClassLoader;
    }

    public boolean getValidating() {
        return this.validating;
    }

    public XMLReader getXMLReader() throws SAXException {
        if (this.reader == null) {
            this.reader = getParser().getXMLReader();
        }
        this.reader.setDTDHandler(this);
        this.reader.setContentHandler(this);
        EntityResolver entityResolver2 = this.entityResolver;
        if (entityResolver2 == null) {
            this.reader.setEntityResolver(this);
        } else {
            this.reader.setEntityResolver(entityResolver2);
        }
        this.reader.setErrorHandler(this);
        return this.reader;
    }

    public void ignorableWhitespace(char[] cArr, int i10, int i11) throws SAXException {
        if (this.saxLog.isDebugEnabled()) {
            Log log2 = this.saxLog;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("ignorableWhitespace(");
            stringBuffer.append(new String(cArr, i10, i11));
            stringBuffer.append(")");
            log2.debug(stringBuffer.toString());
        }
    }

    /* access modifiers changed from: protected */
    public void initialize() {
    }

    public boolean isEmpty(String str) {
        ArrayStack arrayStack = (ArrayStack) this.stacksByName.get(str);
        if (arrayStack != null) {
            return arrayStack.isEmpty();
        }
        return true;
    }

    public void log(String str) {
        this.log.info(str);
    }

    public void notationDecl(String str, String str2, String str3) {
        if (this.saxLog.isDebugEnabled()) {
            Log log2 = this.saxLog;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("notationDecl(");
            stringBuffer.append(str);
            stringBuffer.append(AppsFlyerKit.COMMA);
            stringBuffer.append(str2);
            stringBuffer.append(AppsFlyerKit.COMMA);
            stringBuffer.append(str3);
            stringBuffer.append(")");
            log2.debug(stringBuffer.toString());
        }
    }

    public Object parse(File file) throws IOException, SAXException {
        if (file != null) {
            configure();
            InputSource inputSource = new InputSource(new FileInputStream(file));
            inputSource.setSystemId(file.toURL().toString());
            getXMLReader().parse(inputSource);
            cleanup();
            return this.root;
        }
        throw new IllegalArgumentException("File to parse is null");
    }

    public Object peek() {
        try {
            return this.stack.peek();
        } catch (EmptyStackException unused) {
            this.log.warn("Empty stack (returning null)");
            return null;
        }
    }

    public Object peekParams() {
        try {
            return this.params.peek();
        } catch (EmptyStackException unused) {
            this.log.warn("Empty stack (returning null)");
            return null;
        }
    }

    public Object pop() {
        try {
            Object pop = this.stack.pop();
            StackAction stackAction2 = this.stackAction;
            return stackAction2 != null ? stackAction2.onPop(this, (String) null, pop) : pop;
        } catch (EmptyStackException unused) {
            this.log.warn("Empty stack (returning null)");
            return null;
        }
    }

    public Object popParams() {
        try {
            if (this.log.isTraceEnabled()) {
                this.log.trace("Popping params");
            }
            return this.params.pop();
        } catch (EmptyStackException unused) {
            this.log.warn("Empty stack (returning null)");
            return null;
        }
    }

    public void processingInstruction(String str, String str2) throws SAXException {
        ContentHandler contentHandler = this.customContentHandler;
        if (contentHandler != null) {
            contentHandler.processingInstruction(str, str2);
        } else if (this.saxLog.isDebugEnabled()) {
            Log log2 = this.saxLog;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("processingInstruction('");
            stringBuffer.append(str);
            stringBuffer.append("','");
            stringBuffer.append(str2);
            stringBuffer.append("')");
            log2.debug(stringBuffer.toString());
        }
    }

    public void push(Object obj) {
        StackAction stackAction2 = this.stackAction;
        if (stackAction2 != null) {
            obj = stackAction2.onPush(this, (String) null, obj);
        }
        if (this.stack.size() == 0) {
            this.root = obj;
        }
        this.stack.push(obj);
    }

    public void pushParams(Object obj) {
        if (this.log.isTraceEnabled()) {
            this.log.trace("Pushing params");
        }
        this.params.push(obj);
    }

    public void register(String str, URL url) {
        if (this.log.isDebugEnabled()) {
            Log log2 = this.log;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("register('");
            stringBuffer.append(str);
            stringBuffer.append("', '");
            stringBuffer.append(url);
            stringBuffer.append("'");
            log2.debug(stringBuffer.toString());
        }
        this.entityValidator.put(str, url);
    }

    public void resetRoot() {
        this.root = null;
    }

    public InputSource resolveEntity(String str, String str2) throws SAXException {
        URL url;
        if (this.saxLog.isDebugEnabled()) {
            Log log2 = this.saxLog;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("resolveEntity('");
            stringBuffer.append(str);
            stringBuffer.append("', '");
            stringBuffer.append(str2);
            stringBuffer.append("')");
            log2.debug(stringBuffer.toString());
        }
        if (str != null) {
            this.publicId = str;
        }
        if (str != null) {
            url = (URL) this.entityValidator.get(str);
        } else {
            url = null;
        }
        if (!(this.schemaLocation == null || url != null || str2 == null)) {
            url = (URL) this.entityValidator.get(str2);
        }
        if (url == null) {
            if (str2 == null) {
                if (this.log.isDebugEnabled()) {
                    this.log.debug(" Cannot resolve null entity, returning null InputSource");
                }
                return null;
            }
            if (this.log.isDebugEnabled()) {
                Log log3 = this.log;
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(" Trying to resolve using system ID '");
                stringBuffer2.append(str2);
                stringBuffer2.append("'");
                log3.debug(stringBuffer2.toString());
            }
            try {
                url = new URL(str2);
            } catch (MalformedURLException e10) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Malformed URL '");
                stringBuffer3.append(str2);
                stringBuffer3.append("' : ");
                stringBuffer3.append(e10.getMessage());
                throw new IllegalArgumentException(stringBuffer3.toString());
            }
        }
        if (this.log.isDebugEnabled()) {
            Log log4 = this.log;
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append(" Resolving to alternate DTD '");
            stringBuffer4.append(url);
            stringBuffer4.append("'");
            log4.debug(stringBuffer4.toString());
        }
        try {
            return createInputSourceFromURL(url);
        } catch (Exception e11) {
            throw createSAXException(e11);
        }
    }

    public void setClassLoader(ClassLoader classLoader2) {
        this.classLoader = classLoader2;
    }

    public void setCustomContentHandler(ContentHandler contentHandler) {
        this.customContentHandler = contentHandler;
    }

    public void setDebug(int i10) {
    }

    public void setDocumentLocator(Locator locator2) {
        if (this.saxLog.isDebugEnabled()) {
            Log log2 = this.saxLog;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("setDocumentLocator(");
            stringBuffer.append(locator2);
            stringBuffer.append(")");
            log2.debug(stringBuffer.toString());
        }
        this.locator = locator2;
    }

    public void setEntityResolver(EntityResolver entityResolver2) {
        this.entityResolver = entityResolver2;
    }

    public void setErrorHandler(ErrorHandler errorHandler2) {
        this.errorHandler = errorHandler2;
    }

    public void setFeature(String str, boolean z10) throws ParserConfigurationException, SAXNotRecognizedException, SAXNotSupportedException {
        getFactory().setFeature(str, z10);
    }

    public void setLogger(Log log2) {
        this.log = log2;
    }

    public void setNamespaceAware(boolean z10) {
        this.namespaceAware = z10;
    }

    public void setProperty(String str, Object obj) throws SAXNotRecognizedException, SAXNotSupportedException {
        getParser().setProperty(str, obj);
    }

    public void setPublicId(String str) {
        this.publicId = str;
    }

    public void setRuleNamespaceURI(String str) {
        getRules().setNamespaceURI(str);
    }

    public void setRules(Rules rules2) {
        this.rules = rules2;
        rules2.setDigester(this);
    }

    public void setSAXLogger(Log log2) {
        this.saxLog = log2;
    }

    public void setSchema(String str) {
        this.schemaLocation = str;
    }

    public void setSchemaLanguage(String str) {
        this.schemaLanguage = str;
    }

    public void setStackAction(StackAction stackAction2) {
        this.stackAction = stackAction2;
    }

    public void setSubstitutor(Substitutor substitutor2) {
        this.substitutor = substitutor2;
    }

    public void setUseContextClassLoader(boolean z10) {
        this.useContextClassLoader = z10;
    }

    public void setValidating(boolean z10) {
        this.validating = z10;
    }

    public void skippedEntity(String str) throws SAXException {
        if (this.saxLog.isDebugEnabled()) {
            Log log2 = this.saxLog;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("skippedEntity(");
            stringBuffer.append(str);
            stringBuffer.append(")");
            log2.debug(stringBuffer.toString());
        }
    }

    public void startDocument() throws SAXException {
        if (this.saxLog.isDebugEnabled()) {
            this.saxLog.debug("startDocument()");
        }
        configure();
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        boolean isDebugEnabled = this.log.isDebugEnabled();
        ContentHandler contentHandler = this.customContentHandler;
        if (contentHandler != null) {
            contentHandler.startElement(str, str2, str3, attributes);
            return;
        }
        if (this.saxLog.isDebugEnabled()) {
            Log log2 = this.saxLog;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("startElement(");
            stringBuffer.append(str);
            stringBuffer.append(AppsFlyerKit.COMMA);
            stringBuffer.append(str2);
            stringBuffer.append(AppsFlyerKit.COMMA);
            stringBuffer.append(str3);
            stringBuffer.append(")");
            log2.debug(stringBuffer.toString());
        }
        this.bodyTexts.push(this.bodyText);
        if (isDebugEnabled) {
            Log log3 = this.log;
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("  Pushing body text '");
            stringBuffer2.append(this.bodyText.toString());
            stringBuffer2.append("'");
            log3.debug(stringBuffer2.toString());
        }
        this.bodyText = new StringBuffer();
        if (str2 == null || str2.length() < 1) {
            str2 = str3;
        }
        StringBuffer stringBuffer3 = new StringBuffer(this.match);
        if (this.match.length() > 0) {
            stringBuffer3.append('/');
        }
        stringBuffer3.append(str2);
        this.match = stringBuffer3.toString();
        if (isDebugEnabled) {
            Log log4 = this.log;
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("  New match='");
            stringBuffer4.append(this.match);
            stringBuffer4.append("'");
            log4.debug(stringBuffer4.toString());
        }
        List match2 = getRules().match(str, this.match);
        this.matches.push(match2);
        if (match2 != null && match2.size() > 0) {
            Substitutor substitutor2 = getSubstitutor();
            if (substitutor2 != null) {
                attributes = substitutor2.substitute(attributes);
            }
            int i10 = 0;
            while (i10 < match2.size()) {
                try {
                    Rule rule = (Rule) match2.get(i10);
                    if (isDebugEnabled) {
                        Log log5 = this.log;
                        StringBuffer stringBuffer5 = new StringBuffer();
                        stringBuffer5.append("  Fire begin() for ");
                        stringBuffer5.append(rule);
                        log5.debug(stringBuffer5.toString());
                    }
                    rule.begin(str, str2, attributes);
                    i10++;
                } catch (Exception e10) {
                    this.log.error("Begin event threw exception", e10);
                    throw createSAXException(e10);
                } catch (Error e11) {
                    this.log.error("Begin event threw error", e11);
                    throw e11;
                }
            }
        } else if (isDebugEnabled) {
            Log log6 = this.log;
            StringBuffer stringBuffer6 = new StringBuffer();
            stringBuffer6.append("  No rules found matching '");
            stringBuffer6.append(this.match);
            stringBuffer6.append("'.");
            log6.debug(stringBuffer6.toString());
        }
    }

    public void startPrefixMapping(String str, String str2) throws SAXException {
        if (this.saxLog.isDebugEnabled()) {
            Log log2 = this.saxLog;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("startPrefixMapping(");
            stringBuffer.append(str);
            stringBuffer.append(AppsFlyerKit.COMMA);
            stringBuffer.append(str2);
            stringBuffer.append(")");
            log2.debug(stringBuffer.toString());
        }
        ArrayStack arrayStack = (ArrayStack) this.namespaces.get(str);
        if (arrayStack == null) {
            arrayStack = new ArrayStack();
            this.namespaces.put(str, arrayStack);
        }
        arrayStack.push(str2);
    }

    public void unparsedEntityDecl(String str, String str2, String str3, String str4) {
        if (this.saxLog.isDebugEnabled()) {
            Log log2 = this.saxLog;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("unparsedEntityDecl(");
            stringBuffer.append(str);
            stringBuffer.append(AppsFlyerKit.COMMA);
            stringBuffer.append(str2);
            stringBuffer.append(AppsFlyerKit.COMMA);
            stringBuffer.append(str3);
            stringBuffer.append(AppsFlyerKit.COMMA);
            stringBuffer.append(str4);
            stringBuffer.append(")");
            log2.debug(stringBuffer.toString());
        }
    }

    public void warning(SAXParseException sAXParseException) throws SAXException {
        if (this.errorHandler != null) {
            Log log2 = this.log;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Parse Warning Error at line ");
            stringBuffer.append(sAXParseException.getLineNumber());
            stringBuffer.append(" column ");
            stringBuffer.append(sAXParseException.getColumnNumber());
            stringBuffer.append(": ");
            stringBuffer.append(sAXParseException.getMessage());
            log2.warn(stringBuffer.toString(), sAXParseException);
            this.errorHandler.warning(sAXParseException);
        }
    }

    public void addBeanPropertySetter(String str, String str2) {
        addRule(str, new BeanPropertySetterRule(str2));
    }

    public void addCallMethod(String str, String str2, int i10) {
        addRule(str, new CallMethodRule(str2, i10));
    }

    public void addCallParam(String str, int i10, String str2) {
        addRule(str, new CallParamRule(i10, str2));
    }

    public void addFactoryCreate(String str, Class cls) {
        addFactoryCreate(str, cls, false);
    }

    public void addObjectCreate(String str, Class cls) {
        addRule(str, new ObjectCreateRule(cls));
    }

    public void addSetNestedProperties(String str, String str2, String str3) {
        addRule(str, new SetNestedPropertiesRule(str2, str3));
    }

    public void addSetNext(String str, String str2, String str3) {
        addRule(str, new SetNextRule(str2, str3));
    }

    public void addSetProperties(String str, String str2, String str3) {
        addRule(str, new SetPropertiesRule(str2, str3));
    }

    public void addSetRoot(String str, String str2, String str3) {
        addRule(str, new SetRootRule(str2, str3));
    }

    public void addSetTop(String str, String str2, String str3) {
        addRule(str, new SetTopRule(str2, str3));
    }

    public void log(String str, Throwable th2) {
        this.log.error(str, th2);
    }

    public void addCallMethod(String str, String str2, int i10, String[] strArr) {
        addRule(str, new CallMethodRule(str2, i10, strArr));
    }

    public void addCallParam(String str, int i10, boolean z10) {
        addRule(str, new CallParamRule(i10, z10));
    }

    public void addFactoryCreate(String str, String str2, String str3) {
        addFactoryCreate(str, str2, str3, false);
    }

    public void addObjectCreate(String str, String str2, String str3) {
        addRule(str, new ObjectCreateRule(str2, str3));
    }

    public void addSetNestedProperties(String str, String[] strArr, String[] strArr2) {
        addRule(str, new SetNestedPropertiesRule(strArr, strArr2));
    }

    public void addSetProperties(String str, String[] strArr, String[] strArr2) {
        addRule(str, new SetPropertiesRule(strArr, strArr2));
    }

    public Object peek(int i10) {
        try {
            return this.stack.peek(i10);
        } catch (EmptyStackException unused) {
            this.log.warn("Empty stack (returning null)");
            return null;
        }
    }

    public Object peekParams(int i10) {
        try {
            return this.params.peek(i10);
        } catch (EmptyStackException unused) {
            this.log.warn("Empty stack (returning null)");
            return null;
        }
    }

    public void addCallMethod(String str, String str2, int i10, Class[] clsArr) {
        addRule(str, new CallMethodRule(str2, i10, clsArr));
    }

    public void addCallParam(String str, int i10, int i11) {
        addRule(str, new CallParamRule(i10, i11));
    }

    public void addFactoryCreate(String str, Class cls, String str2) {
        addFactoryCreate(str, cls, str2, false);
    }

    public void addObjectCreate(String str, String str2, Class cls) {
        addRule(str, new ObjectCreateRule(str2, cls));
    }

    public void register(String str, String str2) {
        if (this.log.isDebugEnabled()) {
            Log log2 = this.log;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("register('");
            stringBuffer.append(str);
            stringBuffer.append("', '");
            stringBuffer.append(str2);
            stringBuffer.append("'");
            log2.debug(stringBuffer.toString());
        }
        try {
            this.entityValidator.put(str, new URL(str2));
        } catch (MalformedURLException e10) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Malformed URL '");
            stringBuffer2.append(str2);
            stringBuffer2.append("' : ");
            stringBuffer2.append(e10.getMessage());
            throw new IllegalArgumentException(stringBuffer2.toString());
        }
    }

    public void addFactoryCreate(String str, ObjectCreationFactory objectCreationFactory) {
        addFactoryCreate(str, objectCreationFactory, false);
    }

    /* access modifiers changed from: package-private */
    public List getRules(String str) {
        return getRules().match(str);
    }

    public Object peek(String str) {
        return peek(str, 0);
    }

    public Object pop(String str) {
        ArrayStack arrayStack = (ArrayStack) this.stacksByName.get(str);
        if (arrayStack == null) {
            if (this.log.isDebugEnabled()) {
                Log log2 = this.log;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Stack '");
                stringBuffer.append(str);
                stringBuffer.append("' is empty");
                log2.debug(stringBuffer.toString());
            }
            throw new EmptyStackException();
        }
        Object pop = arrayStack.pop();
        StackAction stackAction2 = this.stackAction;
        return stackAction2 != null ? stackAction2.onPop(this, str, pop) : pop;
    }

    public void addFactoryCreate(String str, String str2, boolean z10) {
        addRule(str, new FactoryCreateRule(str2, z10));
    }

    public Object peek(String str, int i10) {
        ArrayStack arrayStack = (ArrayStack) this.stacksByName.get(str);
        if (arrayStack != null) {
            return arrayStack.peek(i10);
        }
        if (this.log.isDebugEnabled()) {
            Log log2 = this.log;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Stack '");
            stringBuffer.append(str);
            stringBuffer.append("' is empty");
            log2.debug(stringBuffer.toString());
        }
        throw new EmptyStackException();
    }

    public void push(String str, Object obj) {
        StackAction stackAction2 = this.stackAction;
        if (stackAction2 != null) {
            obj = stackAction2.onPush(this, str, obj);
        }
        ArrayStack arrayStack = (ArrayStack) this.stacksByName.get(str);
        if (arrayStack == null) {
            arrayStack = new ArrayStack();
            this.stacksByName.put(str, arrayStack);
        }
        arrayStack.push(obj);
    }

    public void addFactoryCreate(String str, Class cls, boolean z10) {
        addRule(str, new FactoryCreateRule(cls, z10));
    }

    public InputSource createInputSourceFromURL(String str) throws MalformedURLException, IOException {
        return createInputSourceFromURL(new URL(str));
    }

    public void addFactoryCreate(String str, String str2, String str3, boolean z10) {
        addRule(str, new FactoryCreateRule(str2, str3, z10));
    }

    public Object parse(InputSource inputSource) throws IOException, SAXException {
        if (inputSource != null) {
            configure();
            getXMLReader().parse(inputSource);
            cleanup();
            return this.root;
        }
        throw new IllegalArgumentException("InputSource to parse is null");
    }

    public void addFactoryCreate(String str, Class cls, String str2, boolean z10) {
        addRule(str, new FactoryCreateRule(cls, str2, z10));
    }

    public void addFactoryCreate(String str, ObjectCreationFactory objectCreationFactory, boolean z10) {
        objectCreationFactory.setDigester(this);
        addRule(str, new FactoryCreateRule(objectCreationFactory, z10));
    }

    public SAXException createSAXException(Exception exc) {
        Throwable targetException;
        if ((exc instanceof InvocationTargetException) && (targetException = ((InvocationTargetException) exc).getTargetException()) != null && (targetException instanceof Exception)) {
            exc = (Exception) targetException;
        }
        return createSAXException(exc.getMessage(), exc);
    }

    public Object parse(InputStream inputStream) throws IOException, SAXException {
        if (inputStream != null) {
            configure();
            getXMLReader().parse(new InputSource(inputStream));
            cleanup();
            return this.root;
        }
        throw new IllegalArgumentException("InputStream to parse is null");
    }

    public SAXException createSAXException(String str) {
        return createSAXException(str, (Exception) null);
    }

    public Object parse(Reader reader2) throws IOException, SAXException {
        if (reader2 != null) {
            configure();
            getXMLReader().parse(new InputSource(reader2));
            cleanup();
            return this.root;
        }
        throw new IllegalArgumentException("Reader to parse is null");
    }

    public Object parse(String str) throws IOException, SAXException {
        if (str != null) {
            configure();
            getXMLReader().parse(createInputSourceFromURL(str));
            cleanup();
            return this.root;
        }
        throw new IllegalArgumentException("String URI to parse is null");
    }

    public Object parse(URL url) throws IOException, SAXException {
        if (url != null) {
            configure();
            getXMLReader().parse(createInputSourceFromURL(url));
            cleanup();
            return this.root;
        }
        throw new IllegalArgumentException("URL to parse is null");
    }

    public Digester(SAXParser sAXParser) {
        this.parser = sAXParser;
    }

    public Digester(XMLReader xMLReader) {
        this.reader = xMLReader;
    }
}
