package org.apache.commons.digester.xmlrules;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.collections.ArrayStack;
import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.apache.commons.digester.BeanPropertySetterRule;
import org.apache.commons.digester.CallMethodRule;
import org.apache.commons.digester.CallParamRule;
import org.apache.commons.digester.Digester;
import org.apache.commons.digester.FactoryCreateRule;
import org.apache.commons.digester.NodeCreateRule;
import org.apache.commons.digester.ObjectCreateRule;
import org.apache.commons.digester.ObjectCreationFactory;
import org.apache.commons.digester.ObjectParamRule;
import org.apache.commons.digester.Rule;
import org.apache.commons.digester.RuleSetBase;
import org.apache.commons.digester.Rules;
import org.apache.commons.digester.SetNestedPropertiesRule;
import org.apache.commons.digester.SetNextRule;
import org.apache.commons.digester.SetPropertiesRule;
import org.apache.commons.digester.SetPropertyRule;
import org.apache.commons.digester.SetRootRule;
import org.apache.commons.digester.SetTopRule;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class DigesterRuleParser extends RuleSetBase {
    public static final String DIGESTER_PUBLIC_ID = "-//Jakarta Apache //DTD digester-rules XML V1.0//EN";
    static /* synthetic */ Class class$org$apache$commons$digester$Rule;
    protected String basePath;
    private String digesterDtdUrl;
    /* access modifiers changed from: private */
    public Set includedFiles;
    protected PatternStack patternStack;
    protected Digester targetDigester;

    private class BeanPropertySetterRuleFactory extends AbstractObjectCreationFactory {
        private BeanPropertySetterRuleFactory() {
        }

        public Object createObject(Attributes attributes) throws Exception {
            String value = attributes.getValue("propertyname");
            if (value == null) {
                return new BeanPropertySetterRule();
            }
            return new BeanPropertySetterRule(value);
        }
    }

    protected class CallMethodRuleFactory extends AbstractObjectCreationFactory {
        protected CallMethodRuleFactory() {
        }

        private String[] getParamTypes(String str) {
            if (str == null) {
                return new String[0];
            }
            ArrayList arrayList = new ArrayList();
            StringTokenizer stringTokenizer = new StringTokenizer(str, " \t\n\r,");
            while (stringTokenizer.hasMoreTokens()) {
                arrayList.add(stringTokenizer.nextToken());
            }
            return (String[]) arrayList.toArray(new String[0]);
        }

        public Object createObject(Attributes attributes) {
            int i10;
            String value = attributes.getValue("methodname");
            String value2 = attributes.getValue("targetoffset");
            if (value2 != null) {
                i10 = Integer.parseInt(value2);
            } else {
                i10 = 0;
            }
            if (attributes.getValue("paramcount") == null) {
                return new CallMethodRule(i10, value);
            }
            int parseInt = Integer.parseInt(attributes.getValue("paramcount"));
            String value3 = attributes.getValue("paramtypes");
            if (value3 == null || value3.length() == 0) {
                return new CallMethodRule(i10, value, parseInt);
            }
            return new CallMethodRule(i10, value, parseInt, getParamTypes(value3));
        }
    }

    protected class CallParamRuleFactory extends AbstractObjectCreationFactory {
        protected CallParamRuleFactory() {
        }

        public Object createObject(Attributes attributes) {
            int parseInt = Integer.parseInt(attributes.getValue("paramnumber"));
            String value = attributes.getValue("attrname");
            String value2 = attributes.getValue("from-stack");
            String value3 = attributes.getValue("stack-index");
            if (value == null) {
                if (value3 != null) {
                    return new CallParamRule(parseInt, Integer.parseInt(value3));
                }
                if (value2 != null) {
                    return new CallParamRule(parseInt, Boolean.valueOf(value2).booleanValue());
                }
                return new CallParamRule(parseInt);
            } else if (value2 == null) {
                return new CallParamRule(parseInt, value);
            } else {
                throw new RuntimeException("Attributes from-stack and attrname cannot both be present.");
            }
        }
    }

    protected class FactoryCreateRuleFactory extends AbstractObjectCreationFactory {
        protected FactoryCreateRuleFactory() {
        }

        public Object createObject(Attributes attributes) {
            String value = attributes.getValue(ViewHierarchyConstants.CLASS_NAME_KEY);
            String value2 = attributes.getValue("attrname");
            boolean equalsIgnoreCase = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(attributes.getValue("ignore-exceptions"));
            if (value2 == null || value2.length() == 0) {
                return new FactoryCreateRule(value, equalsIgnoreCase);
            }
            return new FactoryCreateRule(value, value2, equalsIgnoreCase);
        }
    }

    private class IncludeRule extends Rule {
        public IncludeRule() {
        }

        private void includeProgrammaticRules(String str) throws ClassNotFoundException, ClassCastException, InstantiationException, IllegalAccessException {
            DigesterRulesSource digesterRulesSource = (DigesterRulesSource) Class.forName(str).newInstance();
            Rules rules = DigesterRuleParser.this.targetDigester.getRules();
            DigesterRuleParser digesterRuleParser = DigesterRuleParser.this;
            DigesterRuleParser.this.targetDigester.setRules(new RulesPrefixAdapter(digesterRuleParser.patternStack.toString(), rules));
            try {
                digesterRulesSource.getRules(DigesterRuleParser.this.targetDigester);
            } finally {
                DigesterRuleParser.this.targetDigester.setRules(rules);
            }
        }

        private void includeXMLRules(String str) throws IOException, SAXException, CircularIncludeException {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader == null) {
                contextClassLoader = DigesterRuleParser.this.getClass().getClassLoader();
            }
            URL resource = contextClassLoader.getResource(str);
            if (resource != null) {
                String externalForm = resource.toExternalForm();
                if (DigesterRuleParser.this.includedFiles.add(externalForm)) {
                    DigesterRuleParser digesterRuleParser = DigesterRuleParser.this;
                    DigesterRuleParser digesterRuleParser2 = new DigesterRuleParser(digesterRuleParser.targetDigester, digesterRuleParser.patternStack, digesterRuleParser.includedFiles);
                    digesterRuleParser2.setDigesterRulesDTD(DigesterRuleParser.this.getDigesterRulesDTD());
                    Digester digester = new Digester();
                    digester.addRuleSet(digesterRuleParser2);
                    digester.push(DigesterRuleParser.this);
                    digester.parse(externalForm);
                    DigesterRuleParser.this.includedFiles.remove(externalForm);
                    return;
                }
                throw new CircularIncludeException(externalForm);
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("File \"");
            stringBuffer.append(str);
            stringBuffer.append("\" not found.");
            throw new FileNotFoundException(stringBuffer.toString());
        }

        public void begin(Attributes attributes) throws Exception {
            String value = attributes.getValue("path");
            if (value != null && value.length() > 0) {
                includeXMLRules(value);
            }
            String value2 = attributes.getValue("class");
            if (value2 != null && value2.length() > 0) {
                includeProgrammaticRules(value2);
            }
        }
    }

    protected class NodeCreateRuleFactory extends AbstractObjectCreationFactory {
        protected NodeCreateRuleFactory() {
        }

        public Object createObject(Attributes attributes) throws Exception {
            String value = attributes.getValue("type");
            if (value == null || "".equals(value)) {
                return new NodeCreateRule();
            }
            if ("element".equals(value)) {
                return new NodeCreateRule(1);
            }
            if ("fragment".equals(value)) {
                return new NodeCreateRule(11);
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Unrecognized node type: ");
            stringBuffer.append(value);
            stringBuffer.append(".  This attribute is optional or can have a value of element|fragment.");
            throw new RuntimeException(stringBuffer.toString());
        }
    }

    protected class ObjectCreateRuleFactory extends AbstractObjectCreationFactory {
        protected ObjectCreateRuleFactory() {
        }

        public Object createObject(Attributes attributes) {
            String value = attributes.getValue(ViewHierarchyConstants.CLASS_NAME_KEY);
            String value2 = attributes.getValue("attrname");
            if (value2 == null || value2.length() == 0) {
                return new ObjectCreateRule(value);
            }
            return new ObjectCreateRule(value, value2);
        }
    }

    protected class ObjectParamRuleFactory extends AbstractObjectCreationFactory {
        protected ObjectParamRuleFactory() {
        }

        public Object createObject(Attributes attributes) throws Exception {
            Object obj;
            int parseInt = Integer.parseInt(attributes.getValue("paramnumber"));
            String value = attributes.getValue("attrname");
            String value2 = attributes.getValue("type");
            String value3 = attributes.getValue("value");
            if (value2 != null) {
                Class<?> cls = Class.forName(value2);
                if (value3 == null) {
                    obj = cls.newInstance();
                } else {
                    obj = ConvertUtils.convert(value3, cls);
                }
                if (value == null) {
                    return new ObjectParamRule(parseInt, obj);
                }
                return new ObjectParamRule(parseInt, value, obj);
            }
            throw new RuntimeException("Attribute 'type' is required.");
        }
    }

    private class PatternRule extends Rule {
        private String attrName;
        private String pattern = null;

        public PatternRule(String str) {
            this.attrName = str;
        }

        public void begin(Attributes attributes) {
            String value = attributes.getValue(this.attrName);
            this.pattern = value;
            if (value != null) {
                DigesterRuleParser.this.patternStack.push(value);
            }
        }

        public void end() {
            if (this.pattern != null) {
                DigesterRuleParser.this.patternStack.pop();
            }
        }
    }

    protected class PatternStack extends ArrayStack {
        protected PatternStack() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i10 = 0; i10 < size(); i10++) {
                String obj = get(i10).toString();
                if (obj.length() > 0) {
                    if (stringBuffer.length() > 0) {
                        stringBuffer.append('/');
                    }
                    stringBuffer.append(obj);
                }
            }
            return stringBuffer.toString();
        }
    }

    private class RulesPrefixAdapter implements Rules {
        private Rules delegate;
        private String prefix;

        public RulesPrefixAdapter(String str, Rules rules) {
            this.prefix = str;
            this.delegate = rules;
        }

        public void add(String str, Rule rule) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.prefix);
            if (!str.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                stringBuffer.append('/');
            }
            stringBuffer.append(str);
            this.delegate.add(stringBuffer.toString(), rule);
        }

        public void clear() {
            this.delegate.clear();
        }

        public Digester getDigester() {
            return this.delegate.getDigester();
        }

        public String getNamespaceURI() {
            return this.delegate.getNamespaceURI();
        }

        public List match(String str) {
            return this.delegate.match(str);
        }

        public List rules() {
            return this.delegate.rules();
        }

        public void setDigester(Digester digester) {
            this.delegate.setDigester(digester);
        }

        public void setNamespaceURI(String str) {
            this.delegate.setNamespaceURI(str);
        }

        public List match(String str, String str2) {
            return this.delegate.match(str, str2);
        }
    }

    protected class SetNestedPropertiesAliasRule extends Rule {
        public SetNestedPropertiesAliasRule() {
        }

        public void begin(Attributes attributes) {
            ((SetNestedPropertiesRule) this.digester.peek()).addAlias(attributes.getValue("attr-name"), attributes.getValue("prop-name"));
        }
    }

    protected class SetNestedPropertiesRuleFactory extends AbstractObjectCreationFactory {
        protected SetNestedPropertiesRuleFactory() {
        }

        public Object createObject(Attributes attributes) {
            boolean equalsIgnoreCase = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(attributes.getValue("allow-unknown-child-elements"));
            SetNestedPropertiesRule setNestedPropertiesRule = new SetNestedPropertiesRule();
            setNestedPropertiesRule.setAllowUnknownChildElements(equalsIgnoreCase);
            return setNestedPropertiesRule;
        }
    }

    protected class SetNextRuleFactory extends AbstractObjectCreationFactory {
        protected SetNextRuleFactory() {
        }

        public Object createObject(Attributes attributes) {
            String value = attributes.getValue("methodname");
            String value2 = attributes.getValue("paramtype");
            if (value2 == null || value2.length() == 0) {
                return new SetNextRule(value);
            }
            return new SetNextRule(value, value2);
        }
    }

    protected class SetPropertiesAliasRule extends Rule {
        public SetPropertiesAliasRule() {
        }

        public void begin(Attributes attributes) {
            ((SetPropertiesRule) this.digester.peek()).addAlias(attributes.getValue("attr-name"), attributes.getValue("prop-name"));
        }
    }

    protected class SetPropertiesRuleFactory extends AbstractObjectCreationFactory {
        protected SetPropertiesRuleFactory() {
        }

        public Object createObject(Attributes attributes) {
            return new SetPropertiesRule();
        }
    }

    protected class SetPropertyRuleFactory extends AbstractObjectCreationFactory {
        protected SetPropertyRuleFactory() {
        }

        public Object createObject(Attributes attributes) {
            return new SetPropertyRule(attributes.getValue("name"), attributes.getValue("value"));
        }
    }

    protected class SetRootRuleFactory extends AbstractObjectCreationFactory {
        protected SetRootRuleFactory() {
        }

        public Object createObject(Attributes attributes) {
            String value = attributes.getValue("methodname");
            String value2 = attributes.getValue("paramtype");
            if (value2 == null || value2.length() == 0) {
                return new SetRootRule(value);
            }
            return new SetRootRule(value, value2);
        }
    }

    protected class SetTopRuleFactory extends AbstractObjectCreationFactory {
        protected SetTopRuleFactory() {
        }

        public Object createObject(Attributes attributes) {
            String value = attributes.getValue("methodname");
            String value2 = attributes.getValue("paramtype");
            if (value2 == null || value2.length() == 0) {
                return new SetTopRule(value);
            }
            return new SetTopRule(value, value2);
        }
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError(e10.getMessage());
        }
    }

    public void add(Rule rule) {
        Digester digester = this.targetDigester;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.basePath);
        stringBuffer.append(this.patternStack.toString());
        digester.addRule(stringBuffer.toString(), rule);
    }

    public void addRuleInstances(Digester digester) {
        Class cls = class$org$apache$commons$digester$Rule;
        if (cls == null) {
            cls = class$("org.apache.commons.digester.Rule");
            class$org$apache$commons$digester$Rule = cls;
        }
        String name = cls.getName();
        digester.register(DIGESTER_PUBLIC_ID, getDigesterRulesDTD());
        digester.addRule("*/pattern", new PatternRule("value"));
        digester.addRule("*/include", new IncludeRule());
        digester.addFactoryCreate("*/bean-property-setter-rule", (ObjectCreationFactory) new BeanPropertySetterRuleFactory());
        digester.addRule("*/bean-property-setter-rule", new PatternRule("pattern"));
        digester.addSetNext("*/bean-property-setter-rule", "add", name);
        digester.addFactoryCreate("*/call-method-rule", (ObjectCreationFactory) new CallMethodRuleFactory());
        digester.addRule("*/call-method-rule", new PatternRule("pattern"));
        digester.addSetNext("*/call-method-rule", "add", name);
        digester.addFactoryCreate("*/object-param-rule", (ObjectCreationFactory) new ObjectParamRuleFactory());
        digester.addRule("*/object-param-rule", new PatternRule("pattern"));
        digester.addSetNext("*/object-param-rule", "add", name);
        digester.addFactoryCreate("*/call-param-rule", (ObjectCreationFactory) new CallParamRuleFactory());
        digester.addRule("*/call-param-rule", new PatternRule("pattern"));
        digester.addSetNext("*/call-param-rule", "add", name);
        digester.addFactoryCreate("*/factory-create-rule", (ObjectCreationFactory) new FactoryCreateRuleFactory());
        digester.addRule("*/factory-create-rule", new PatternRule("pattern"));
        digester.addSetNext("*/factory-create-rule", "add", name);
        digester.addFactoryCreate("*/object-create-rule", (ObjectCreationFactory) new ObjectCreateRuleFactory());
        digester.addRule("*/object-create-rule", new PatternRule("pattern"));
        digester.addSetNext("*/object-create-rule", "add", name);
        digester.addFactoryCreate("*/node-create-rule", (ObjectCreationFactory) new NodeCreateRuleFactory());
        digester.addRule("*/node-create-rule", new PatternRule("pattern"));
        digester.addSetNext("*/node-create-rule", "add", name);
        digester.addFactoryCreate("*/set-properties-rule", (ObjectCreationFactory) new SetPropertiesRuleFactory());
        digester.addRule("*/set-properties-rule", new PatternRule("pattern"));
        digester.addSetNext("*/set-properties-rule", "add", name);
        digester.addRule("*/set-properties-rule/alias", new SetPropertiesAliasRule());
        digester.addFactoryCreate("*/set-property-rule", (ObjectCreationFactory) new SetPropertyRuleFactory());
        digester.addRule("*/set-property-rule", new PatternRule("pattern"));
        digester.addSetNext("*/set-property-rule", "add", name);
        digester.addFactoryCreate("*/set-nested-properties-rule", (ObjectCreationFactory) new SetNestedPropertiesRuleFactory());
        digester.addRule("*/set-nested-properties-rule", new PatternRule("pattern"));
        digester.addSetNext("*/set-nested-properties-rule", "add", name);
        digester.addRule("*/set-nested-properties-rule/alias", new SetNestedPropertiesAliasRule());
        digester.addFactoryCreate("*/set-top-rule", (ObjectCreationFactory) new SetTopRuleFactory());
        digester.addRule("*/set-top-rule", new PatternRule("pattern"));
        digester.addSetNext("*/set-top-rule", "add", name);
        digester.addFactoryCreate("*/set-next-rule", (ObjectCreationFactory) new SetNextRuleFactory());
        digester.addRule("*/set-next-rule", new PatternRule("pattern"));
        digester.addSetNext("*/set-next-rule", "add", name);
        digester.addFactoryCreate("*/set-root-rule", (ObjectCreationFactory) new SetRootRuleFactory());
        digester.addRule("*/set-root-rule", new PatternRule("pattern"));
        digester.addSetNext("*/set-root-rule", "add", name);
    }

    /* access modifiers changed from: protected */
    public String getDigesterRulesDTD() {
        return this.digesterDtdUrl;
    }

    public void setBasePath(String str) {
        if (str == null) {
            this.basePath = "";
        } else if (str.length() <= 0 || str.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
            this.basePath = str;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(RemoteSettings.FORWARD_SLASH_STRING);
            this.basePath = stringBuffer.toString();
        }
    }

    public void setDigesterRulesDTD(String str) {
        this.digesterDtdUrl = str;
    }

    public void setTarget(Digester digester) {
        this.targetDigester = digester;
    }

    public DigesterRuleParser() {
        this.basePath = "";
        this.includedFiles = new HashSet();
        this.patternStack = new PatternStack();
    }

    public DigesterRuleParser(Digester digester) {
        this.basePath = "";
        this.includedFiles = new HashSet();
        this.targetDigester = digester;
        this.patternStack = new PatternStack();
    }

    private DigesterRuleParser(Digester digester, PatternStack patternStack2, Set set) {
        this.basePath = "";
        new HashSet();
        this.targetDigester = digester;
        this.patternStack = patternStack2;
        this.includedFiles = set;
    }
}
