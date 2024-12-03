package org.apache.commons.digester;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.xml.sax.Attributes;

public class SetPropertyRule extends Rule {
    protected String name;
    protected String value;

    public SetPropertyRule(Digester digester, String str, String str2) {
        this(str, str2);
    }

    public void begin(Attributes attributes) throws Exception {
        if (attributes.getLength() != 0) {
            String str = null;
            String str2 = null;
            for (int i10 = 0; i10 < attributes.getLength(); i10++) {
                String localName = attributes.getLocalName(i10);
                if ("".equals(localName)) {
                    localName = attributes.getQName(i10);
                }
                String value2 = attributes.getValue(i10);
                if (localName.equals(this.name)) {
                    str = value2;
                } else if (localName.equals(this.value)) {
                    str2 = value2;
                }
            }
            Object peek = this.digester.peek();
            if (this.digester.log.isDebugEnabled()) {
                Log log = this.digester.log;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("[SetPropertyRule]{");
                stringBuffer.append(this.digester.match);
                stringBuffer.append("} Set ");
                stringBuffer.append(peek.getClass().getName());
                stringBuffer.append(" property ");
                stringBuffer.append(str);
                stringBuffer.append(" to ");
                stringBuffer.append(str2);
                log.debug(stringBuffer.toString());
            }
            if (peek instanceof DynaBean) {
                if (((DynaBean) peek).getDynaClass().getDynaProperty(str) == null) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Bean has no property named ");
                    stringBuffer2.append(str);
                    throw new NoSuchMethodException(stringBuffer2.toString());
                }
            } else if (PropertyUtils.getPropertyDescriptor(peek, str) == null) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Bean has no property named ");
                stringBuffer3.append(str);
                throw new NoSuchMethodException(stringBuffer3.toString());
            }
            BeanUtils.setProperty(peek, str, str2);
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("SetPropertyRule[");
        stringBuffer.append("name=");
        stringBuffer.append(this.name);
        stringBuffer.append(", value=");
        stringBuffer.append(this.value);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public SetPropertyRule(String str, String str2) {
        this.name = str;
        this.value = str2;
    }
}
