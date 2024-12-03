package org.apache.commons.digester;

import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.xml.sax.Attributes;

public class SetNestedPropertiesRule extends Rule {
    /* access modifiers changed from: private */
    public boolean allowUnknownChildElements;
    /* access modifiers changed from: private */
    public HashMap elementNames;
    /* access modifiers changed from: private */
    public Log log;
    /* access modifiers changed from: private */
    public boolean trimData;

    private class AnyChildRule extends Rule {
        private String currChildElementName;
        private String currChildNamespaceURI;

        private AnyChildRule() {
            this.currChildNamespaceURI = null;
            this.currChildElementName = null;
        }

        public void begin(String str, String str2, Attributes attributes) throws Exception {
            this.currChildNamespaceURI = str;
            this.currChildElementName = str2;
        }

        public void body(String str) throws Exception {
            String str2 = this.currChildElementName;
            if (!SetNestedPropertiesRule.this.elementNames.containsKey(this.currChildElementName) || (str2 = (String) SetNestedPropertiesRule.this.elementNames.get(this.currChildElementName)) != null) {
                boolean isDebugEnabled = SetNestedPropertiesRule.this.log.isDebugEnabled();
                if (isDebugEnabled) {
                    Log access$100 = SetNestedPropertiesRule.this.log;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("[SetNestedPropertiesRule]{");
                    stringBuffer.append(this.digester.match);
                    stringBuffer.append("} Setting property '");
                    stringBuffer.append(str2);
                    stringBuffer.append("' to '");
                    stringBuffer.append(str);
                    stringBuffer.append("'");
                    access$100.debug(stringBuffer.toString());
                }
                Object peek = this.digester.peek();
                if (isDebugEnabled) {
                    if (peek != null) {
                        Log access$1002 = SetNestedPropertiesRule.this.log;
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append("[SetNestedPropertiesRule]{");
                        stringBuffer2.append(this.digester.match);
                        stringBuffer2.append("} Set ");
                        stringBuffer2.append(peek.getClass().getName());
                        stringBuffer2.append(" properties");
                        access$1002.debug(stringBuffer2.toString());
                    } else {
                        Log access$1003 = SetNestedPropertiesRule.this.log;
                        StringBuffer stringBuffer3 = new StringBuffer();
                        stringBuffer3.append("[SetPropertiesRule]{");
                        stringBuffer3.append(this.digester.match);
                        stringBuffer3.append("} Set NULL properties");
                        access$1003.debug(stringBuffer3.toString());
                    }
                }
                if (SetNestedPropertiesRule.this.trimData) {
                    str = str.trim();
                }
                if (!SetNestedPropertiesRule.this.allowUnknownChildElements) {
                    if (peek instanceof DynaBean) {
                        if (((DynaBean) peek).getDynaClass().getDynaProperty(str2) == null) {
                            StringBuffer stringBuffer4 = new StringBuffer();
                            stringBuffer4.append("Bean has no property named ");
                            stringBuffer4.append(str2);
                            throw new NoSuchMethodException(stringBuffer4.toString());
                        }
                    } else if (PropertyUtils.getPropertyDescriptor(peek, str2) == null) {
                        StringBuffer stringBuffer5 = new StringBuffer();
                        stringBuffer5.append("Bean has no property named ");
                        stringBuffer5.append(str2);
                        throw new NoSuchMethodException(stringBuffer5.toString());
                    }
                }
                try {
                    BeanUtils.setProperty(peek, str2, str);
                } catch (NullPointerException e10) {
                    Log access$1004 = SetNestedPropertiesRule.this.log;
                    StringBuffer stringBuffer6 = new StringBuffer();
                    stringBuffer6.append("NullPointerException: top=");
                    stringBuffer6.append(peek);
                    stringBuffer6.append(",propName=");
                    stringBuffer6.append(str2);
                    stringBuffer6.append(",value=");
                    stringBuffer6.append(str);
                    stringBuffer6.append("!");
                    access$1004.error(stringBuffer6.toString());
                    throw e10;
                }
            }
        }

        public void end(String str, String str2) throws Exception {
            this.currChildElementName = null;
        }
    }

    private class AnyChildRules implements Rules {
        private Rules decoratedRules = null;
        private String matchPrefix = null;
        private AnyChildRule rule;
        private ArrayList rules;

        public AnyChildRules(AnyChildRule anyChildRule) {
            ArrayList arrayList = new ArrayList(1);
            this.rules = arrayList;
            this.rule = anyChildRule;
            arrayList.add(anyChildRule);
        }

        public void add(String str, Rule rule2) {
        }

        public void clear() {
        }

        public Digester getDigester() {
            return null;
        }

        public String getNamespaceURI() {
            return null;
        }

        public Rules getOldRules() {
            return this.decoratedRules;
        }

        public void init(String str, Rules rules2) {
            this.matchPrefix = str;
            this.decoratedRules = rules2;
        }

        public List match(String str) {
            return match((String) null, str);
        }

        public List rules() {
            SetNestedPropertiesRule.this.log.debug("AnyChildRules.rules invoked.");
            return this.decoratedRules.rules();
        }

        public void setDigester(Digester digester) {
        }

        public void setNamespaceURI(String str) {
        }

        public List match(String str, String str2) {
            List match = this.decoratedRules.match(str, str2);
            if (!str2.startsWith(this.matchPrefix) || str2.indexOf(47, this.matchPrefix.length()) != -1) {
                return match;
            }
            if (match == null || match.size() == 0) {
                return this.rules;
            }
            LinkedList linkedList = new LinkedList(match);
            linkedList.addLast(this.rule);
            return linkedList;
        }
    }

    public SetNestedPropertiesRule() {
        this.log = null;
        this.trimData = true;
        this.allowUnknownChildElements = false;
        this.elementNames = new HashMap();
    }

    public void addAlias(String str, String str2) {
        this.elementNames.put(str, str2);
    }

    public void begin(String str, String str2, Attributes attributes) throws Exception {
        Rules rules = this.digester.getRules();
        AnyChildRule anyChildRule = new AnyChildRule();
        anyChildRule.setDigester(this.digester);
        AnyChildRules anyChildRules = new AnyChildRules(anyChildRule);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.digester.getMatch());
        stringBuffer.append(RemoteSettings.FORWARD_SLASH_STRING);
        anyChildRules.init(stringBuffer.toString(), rules);
        this.digester.setRules(anyChildRules);
    }

    public void body(String str) throws Exception {
        this.digester.setRules(((AnyChildRules) this.digester.getRules()).getOldRules());
    }

    public boolean getAllowUnknownChildElements() {
        return this.allowUnknownChildElements;
    }

    public boolean getTrimData() {
        return this.trimData;
    }

    public void setAllowUnknownChildElements(boolean z10) {
        this.allowUnknownChildElements = z10;
    }

    public void setDigester(Digester digester) {
        super.setDigester(digester);
        this.log = digester.getLogger();
    }

    public void setTrimData(boolean z10) {
        this.trimData = z10;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("SetNestedPropertiesRule[");
        stringBuffer.append("allowUnknownChildElements=");
        stringBuffer.append(this.allowUnknownChildElements);
        stringBuffer.append(", trimData=");
        stringBuffer.append(this.trimData);
        stringBuffer.append(", elementNames=");
        stringBuffer.append(this.elementNames);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public SetNestedPropertiesRule(String str, String str2) {
        this.log = null;
        this.trimData = true;
        this.allowUnknownChildElements = false;
        HashMap hashMap = new HashMap();
        this.elementNames = hashMap;
        hashMap.put(str, str2);
    }

    public SetNestedPropertiesRule(String[] strArr, String[] strArr2) {
        this.log = null;
        this.trimData = true;
        int i10 = 0;
        this.allowUnknownChildElements = false;
        this.elementNames = new HashMap();
        int length = strArr.length;
        while (i10 < length) {
            this.elementNames.put(strArr[i10], i10 < strArr2.length ? strArr2[i10] : null);
            i10++;
        }
    }
}
