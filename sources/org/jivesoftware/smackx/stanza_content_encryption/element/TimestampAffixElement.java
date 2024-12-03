package org.jivesoftware.smackx.stanza_content_encryption.element;

import java.util.Date;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.EqualsUtil;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.XmlStringBuilder;

public class TimestampAffixElement implements NamedElement, AffixElement {
    public static final String ATTR_STAMP = "stamp";
    public static final String ELEMENT = "time";
    private final Date timestamp;

    public TimestampAffixElement(Date date) {
        this.timestamp = (Date) Objects.requireNonNull(date, "Date must not be null.");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$equals$0(EqualsUtil.Builder builder, TimestampAffixElement timestampAffixElement) {
        builder.append(getTimestamp(), timestampAffixElement.getTimestamp());
    }

    public boolean equals(Object obj) {
        return EqualsUtil.equals(this, obj, new c(this));
    }

    public String getElementName() {
        return "time";
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return this.timestamp.hashCode();
    }

    public CharSequence toXML(XmlEnvironment xmlEnvironment) {
        return new XmlStringBuilder((NamedElement) this).attribute("stamp", getTimestamp()).closeEmptyElement();
    }
}
