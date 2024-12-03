package org.jivesoftware.smackx.iot.discovery.element;

import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;

public class Tag implements NamedElement {
    private final String name;
    private final Type type;
    private final String value;

    public enum Type {
        str,
        num
    }

    public Tag(String str, Type type2, String str2) {
        String str3 = (String) StringUtils.requireNotNullNorEmpty(str, "name must not be null nor empty");
        this.name = str3;
        Type type3 = (Type) Objects.requireNonNull(type2);
        this.type = type3;
        String str4 = (String) StringUtils.requireNotNullNorEmpty(str2, "value must not be null nor empty");
        this.value = str4;
        if (str3.length() > 32) {
            throw new IllegalArgumentException("Meta Tag names must not be longer then 32 characters (XEP-0347 § 5.2");
        } else if (type3 == Type.str && str4.length() > 128) {
            throw new IllegalArgumentException("Meta Tag string values must not be longer then 128 characters (XEP-0347 § 5.2");
        }
    }

    public String getElementName() {
        return getType().toString();
    }

    public String getName() {
        return this.name;
    }

    public Type getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        return this.name + PropertyUtils.MAPPED_DELIM + this.type + "):" + this.value;
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((NamedElement) this);
        xmlStringBuilder.attribute("name", this.name);
        xmlStringBuilder.attribute("value", this.value);
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }
}
