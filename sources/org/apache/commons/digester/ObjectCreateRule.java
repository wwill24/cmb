package org.apache.commons.digester;

import org.apache.commons.logging.Log;
import org.xml.sax.Attributes;

public class ObjectCreateRule extends Rule {
    protected String attributeName;
    protected String className;

    public ObjectCreateRule(Digester digester, String str) {
        this(str);
    }

    public void begin(Attributes attributes) throws Exception {
        String value;
        String str = this.className;
        String str2 = this.attributeName;
        if (!(str2 == null || (value = attributes.getValue(str2)) == null)) {
            str = value;
        }
        if (this.digester.log.isDebugEnabled()) {
            Log log = this.digester.log;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("[ObjectCreateRule]{");
            stringBuffer.append(this.digester.match);
            stringBuffer.append("}New ");
            stringBuffer.append(str);
            log.debug(stringBuffer.toString());
        }
        this.digester.push(this.digester.getClassLoader().loadClass(str).newInstance());
    }

    public void end() throws Exception {
        Object pop = this.digester.pop();
        if (this.digester.log.isDebugEnabled()) {
            Log log = this.digester.log;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("[ObjectCreateRule]{");
            stringBuffer.append(this.digester.match);
            stringBuffer.append("} Pop ");
            stringBuffer.append(pop.getClass().getName());
            log.debug(stringBuffer.toString());
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("ObjectCreateRule[");
        stringBuffer.append("className=");
        stringBuffer.append(this.className);
        stringBuffer.append(", attributeName=");
        stringBuffer.append(this.attributeName);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public ObjectCreateRule(Digester digester, Class cls) {
        this(cls);
    }

    public ObjectCreateRule(Digester digester, String str, String str2) {
        this(str, str2);
    }

    public ObjectCreateRule(Digester digester, String str, Class cls) {
        this(str, cls);
    }

    public ObjectCreateRule(String str) {
        this(str, (String) null);
    }

    public ObjectCreateRule(Class cls) {
        this(cls.getName(), (String) null);
    }

    public ObjectCreateRule(String str, String str2) {
        this.className = str;
        this.attributeName = str2;
    }

    public ObjectCreateRule(String str, Class cls) {
        this(cls.getName(), str);
    }
}
