package org.apache.commons.digester;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;

public class BeanPropertySetterRule extends Rule {
    protected String bodyText;
    protected String propertyName;

    public BeanPropertySetterRule(Digester digester, String str) {
        this(str);
    }

    public void body(String str, String str2, String str3) throws Exception {
        if (this.digester.log.isDebugEnabled()) {
            Log log = this.digester.log;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("[BeanPropertySetterRule]{");
            stringBuffer.append(this.digester.match);
            stringBuffer.append("} Called with text '");
            stringBuffer.append(str3);
            stringBuffer.append("'");
            log.debug(stringBuffer.toString());
        }
        this.bodyText = str3.trim();
    }

    public void end(String str, String str2) throws Exception {
        String str3 = this.propertyName;
        if (str3 != null) {
            str2 = str3;
        }
        Object peek = this.digester.peek();
        if (this.digester.log.isDebugEnabled()) {
            Log log = this.digester.log;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("[BeanPropertySetterRule]{");
            stringBuffer.append(this.digester.match);
            stringBuffer.append("} Set ");
            stringBuffer.append(peek.getClass().getName());
            stringBuffer.append(" property ");
            stringBuffer.append(str2);
            stringBuffer.append(" with text ");
            stringBuffer.append(this.bodyText);
            log.debug(stringBuffer.toString());
        }
        if (peek instanceof DynaBean) {
            if (((DynaBean) peek).getDynaClass().getDynaProperty(str2) == null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Bean has no property named ");
                stringBuffer2.append(str2);
                throw new NoSuchMethodException(stringBuffer2.toString());
            }
        } else if (PropertyUtils.getPropertyDescriptor(peek, str2) == null) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Bean has no property named ");
            stringBuffer3.append(str2);
            throw new NoSuchMethodException(stringBuffer3.toString());
        }
        BeanUtils.setProperty(peek, str2, this.bodyText);
    }

    public void finish() throws Exception {
        this.bodyText = null;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("BeanPropertySetterRule[");
        stringBuffer.append("propertyName=");
        stringBuffer.append(this.propertyName);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public BeanPropertySetterRule(Digester digester) {
        this();
    }

    public BeanPropertySetterRule(String str) {
        this.bodyText = null;
        this.propertyName = str;
    }

    public BeanPropertySetterRule() {
        this((String) null);
    }
}
