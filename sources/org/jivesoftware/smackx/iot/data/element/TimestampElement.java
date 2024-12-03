package org.jivesoftware.smackx.iot.data.element;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

public class TimestampElement extends IoTDataExtensionElement {
    public static final String ELEMENT = "timestamp";
    private final Date date;
    private final List<? extends IoTDataField> fields;

    public TimestampElement(Date date2, List<? extends IoTDataField> list) {
        this.date = date2;
        this.fields = Collections.unmodifiableList(list);
    }

    public List<? extends IoTDataField> getDataFields() {
        return this.fields;
    }

    public String getElementName() {
        return "timestamp";
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        xmlStringBuilder.attribute("value", this.date);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.append((Collection<? extends Element>) this.fields);
        xmlStringBuilder.closeElement((NamedElement) this);
        return xmlStringBuilder;
    }
}
