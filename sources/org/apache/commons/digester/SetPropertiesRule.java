package org.apache.commons.digester;

import java.util.HashMap;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.xml.sax.Attributes;

public class SetPropertiesRule extends Rule {
    private String[] attributeNames;
    private boolean ignoreMissingProperty;
    private String[] propertyNames;

    public SetPropertiesRule(Digester digester) {
        this();
    }

    public void addAlias(String str, String str2) {
        String[] strArr = this.attributeNames;
        if (strArr == null) {
            String[] strArr2 = new String[1];
            this.attributeNames = strArr2;
            strArr2[0] = str;
            String[] strArr3 = new String[1];
            this.propertyNames = strArr3;
            strArr3[0] = str2;
            return;
        }
        int length = strArr.length;
        int i10 = length + 1;
        String[] strArr4 = new String[i10];
        for (int i11 = 0; i11 < length; i11++) {
            strArr4[i11] = this.attributeNames[i11];
        }
        strArr4[length] = str;
        String[] strArr5 = new String[i10];
        for (int i12 = 0; i12 < length; i12++) {
            String[] strArr6 = this.propertyNames;
            if (i12 >= strArr6.length) {
                break;
            }
            strArr5[i12] = strArr6[i12];
        }
        strArr5[length] = str2;
        this.propertyNames = strArr5;
        this.attributeNames = strArr4;
    }

    public void begin(Attributes attributes) throws Exception {
        int i10;
        int i11;
        HashMap hashMap = new HashMap();
        String[] strArr = this.attributeNames;
        if (strArr != null) {
            i10 = strArr.length;
        } else {
            i10 = 0;
        }
        String[] strArr2 = this.propertyNames;
        if (strArr2 != null) {
            i11 = strArr2.length;
        } else {
            i11 = 0;
        }
        int i12 = 0;
        while (i12 < attributes.getLength()) {
            String localName = attributes.getLocalName(i12);
            if ("".equals(localName)) {
                localName = attributes.getQName(i12);
            }
            String value = attributes.getValue(i12);
            int i13 = 0;
            while (true) {
                if (i13 >= i10) {
                    break;
                } else if (!localName.equals(this.attributeNames[i13])) {
                    i13++;
                } else if (i13 < i11) {
                    localName = this.propertyNames[i13];
                } else {
                    localName = null;
                }
            }
            if (this.digester.log.isDebugEnabled()) {
                Log log = this.digester.log;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("[SetPropertiesRule]{");
                stringBuffer.append(this.digester.match);
                stringBuffer.append("} Setting property '");
                stringBuffer.append(localName);
                stringBuffer.append("' to '");
                stringBuffer.append(value);
                stringBuffer.append("'");
                log.debug(stringBuffer.toString());
            }
            if (this.ignoreMissingProperty || localName == null || PropertyUtils.isWriteable(this.digester.peek(), localName)) {
                if (localName != null) {
                    hashMap.put(localName, value);
                }
                i12++;
            } else {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Property ");
                stringBuffer2.append(localName);
                stringBuffer2.append(" can't be set");
                throw new NoSuchMethodException(stringBuffer2.toString());
            }
        }
        Object peek = this.digester.peek();
        if (this.digester.log.isDebugEnabled()) {
            if (peek != null) {
                Log log2 = this.digester.log;
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("[SetPropertiesRule]{");
                stringBuffer3.append(this.digester.match);
                stringBuffer3.append("} Set ");
                stringBuffer3.append(peek.getClass().getName());
                stringBuffer3.append(" properties");
                log2.debug(stringBuffer3.toString());
            } else {
                Log log3 = this.digester.log;
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("[SetPropertiesRule]{");
                stringBuffer4.append(this.digester.match);
                stringBuffer4.append("} Set NULL properties");
                log3.debug(stringBuffer4.toString());
            }
        }
        BeanUtils.populate(peek, hashMap);
    }

    public boolean isIgnoreMissingProperty() {
        return this.ignoreMissingProperty;
    }

    public void setIgnoreMissingProperty(boolean z10) {
        this.ignoreMissingProperty = z10;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("SetPropertiesRule[");
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public SetPropertiesRule() {
        this.ignoreMissingProperty = true;
    }

    public SetPropertiesRule(String str, String str2) {
        this.ignoreMissingProperty = true;
        String[] strArr = new String[1];
        this.attributeNames = strArr;
        strArr[0] = str;
        String[] strArr2 = new String[1];
        this.propertyNames = strArr2;
        strArr2[0] = str2;
    }

    public SetPropertiesRule(String[] strArr, String[] strArr2) {
        this.ignoreMissingProperty = true;
        this.attributeNames = new String[strArr.length];
        int length = strArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.attributeNames[i10] = strArr[i10];
        }
        this.propertyNames = new String[strArr2.length];
        int length2 = strArr2.length;
        for (int i11 = 0; i11 < length2; i11++) {
            this.propertyNames[i11] = strArr2[i11];
        }
    }
}
