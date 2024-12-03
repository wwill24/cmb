package org.apache.commons.digester;

import org.apache.commons.collections.ArrayStack;
import org.apache.commons.logging.Log;
import org.xml.sax.Attributes;

public class FactoryCreateRule extends Rule {
    protected String attributeName;
    protected String className;
    protected ObjectCreationFactory creationFactory;
    private ArrayStack exceptionIgnoredStack;
    private boolean ignoreCreateExceptions;

    public FactoryCreateRule(Digester digester, String str) {
        this(str);
    }

    public void begin(String str, String str2, Attributes attributes) throws Exception {
        String str3;
        String str4 = "null object";
        if (this.ignoreCreateExceptions) {
            if (this.exceptionIgnoredStack == null) {
                this.exceptionIgnoredStack = new ArrayStack();
            }
            try {
                Object createObject = getFactory(attributes).createObject(attributes);
                if (this.digester.log.isDebugEnabled()) {
                    Log log = this.digester.log;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("[FactoryCreateRule]{");
                    stringBuffer.append(this.digester.match);
                    stringBuffer.append("} New ");
                    if (createObject != null) {
                        str4 = createObject.getClass().getName();
                    }
                    stringBuffer.append(str4);
                    log.debug(stringBuffer.toString());
                }
                this.digester.push(createObject);
                this.exceptionIgnoredStack.push(Boolean.FALSE);
            } catch (Exception e10) {
                if (this.digester.log.isInfoEnabled()) {
                    Log log2 = this.digester.log;
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("[FactoryCreateRule] Create exception ignored: ");
                    if (e10.getMessage() == null) {
                        str3 = e10.getClass().getName();
                    } else {
                        str3 = e10.getMessage();
                    }
                    stringBuffer2.append(str3);
                    log2.info(stringBuffer2.toString());
                    if (this.digester.log.isDebugEnabled()) {
                        this.digester.log.debug("[FactoryCreateRule] Ignored exception:", e10);
                    }
                }
                this.exceptionIgnoredStack.push(Boolean.TRUE);
            }
        } else {
            Object createObject2 = getFactory(attributes).createObject(attributes);
            if (this.digester.log.isDebugEnabled()) {
                Log log3 = this.digester.log;
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("[FactoryCreateRule]{");
                stringBuffer3.append(this.digester.match);
                stringBuffer3.append("} New ");
                if (createObject2 != null) {
                    str4 = createObject2.getClass().getName();
                }
                stringBuffer3.append(str4);
                log3.debug(stringBuffer3.toString());
            }
            this.digester.push(createObject2);
        }
    }

    public void end(String str, String str2) throws Exception {
        ArrayStack arrayStack;
        if (!this.ignoreCreateExceptions || (arrayStack = this.exceptionIgnoredStack) == null || arrayStack.empty() || !((Boolean) this.exceptionIgnoredStack.pop()).booleanValue()) {
            Object pop = this.digester.pop();
            if (this.digester.log.isDebugEnabled()) {
                Log log = this.digester.log;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("[FactoryCreateRule]{");
                stringBuffer.append(this.digester.match);
                stringBuffer.append("} Pop ");
                stringBuffer.append(pop.getClass().getName());
                log.debug(stringBuffer.toString());
            }
        } else if (this.digester.log.isTraceEnabled()) {
            this.digester.log.trace("[FactoryCreateRule] No creation so no push so no pop");
        }
    }

    public void finish() throws Exception {
        if (this.attributeName != null) {
            this.creationFactory = null;
        }
    }

    /* access modifiers changed from: protected */
    public ObjectCreationFactory getFactory(Attributes attributes) throws Exception {
        String value;
        if (this.creationFactory == null) {
            String str = this.className;
            String str2 = this.attributeName;
            if (!(str2 == null || (value = attributes.getValue(str2)) == null)) {
                str = value;
            }
            if (this.digester.log.isDebugEnabled()) {
                Log log = this.digester.log;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("[FactoryCreateRule]{");
                stringBuffer.append(this.digester.match);
                stringBuffer.append("} New factory ");
                stringBuffer.append(str);
                log.debug(stringBuffer.toString());
            }
            ObjectCreationFactory objectCreationFactory = (ObjectCreationFactory) this.digester.getClassLoader().loadClass(str).newInstance();
            this.creationFactory = objectCreationFactory;
            objectCreationFactory.setDigester(this.digester);
        }
        return this.creationFactory;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("FactoryCreateRule[");
        stringBuffer.append("className=");
        stringBuffer.append(this.className);
        stringBuffer.append(", attributeName=");
        stringBuffer.append(this.attributeName);
        if (this.creationFactory != null) {
            stringBuffer.append(", creationFactory=");
            stringBuffer.append(this.creationFactory);
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public FactoryCreateRule(Digester digester, Class cls) {
        this(cls);
    }

    public FactoryCreateRule(Digester digester, String str, String str2) {
        this(str, str2);
    }

    public FactoryCreateRule(Digester digester, Class cls, String str) {
        this(cls, str);
    }

    public FactoryCreateRule(Digester digester, ObjectCreationFactory objectCreationFactory) {
        this(objectCreationFactory);
    }

    public FactoryCreateRule(String str) {
        this(str, false);
    }

    public FactoryCreateRule(Class cls) {
        this(cls, false);
    }

    public FactoryCreateRule(String str, String str2) {
        this(str, str2, false);
    }

    public FactoryCreateRule(Class cls, String str) {
        this(cls, str, false);
    }

    public FactoryCreateRule(ObjectCreationFactory objectCreationFactory) {
        this(objectCreationFactory, false);
    }

    public FactoryCreateRule(String str, boolean z10) {
        this(str, (String) null, z10);
    }

    public FactoryCreateRule(Class cls, boolean z10) {
        this(cls, (String) null, z10);
    }

    public FactoryCreateRule(String str, String str2, boolean z10) {
        this.creationFactory = null;
        this.className = str;
        this.attributeName = str2;
        this.ignoreCreateExceptions = z10;
    }

    public FactoryCreateRule(Class cls, String str, boolean z10) {
        this(cls.getName(), str, z10);
    }

    public FactoryCreateRule(ObjectCreationFactory objectCreationFactory, boolean z10) {
        this.attributeName = null;
        this.className = null;
        this.creationFactory = objectCreationFactory;
        this.ignoreCreateExceptions = z10;
    }
}
