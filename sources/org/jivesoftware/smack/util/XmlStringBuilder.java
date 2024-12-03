package org.jivesoftware.smack.util;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.FullyQualifiedElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jxmpp.util.XmppDateTime;

public class XmlStringBuilder implements Appendable, CharSequence, Element {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String RIGHT_ANGLE_BRACKET = Character.toString('>');
    private final XmlEnvironment effectiveXmlEnvironment;

    /* renamed from: sb  reason: collision with root package name */
    private final LazyStringBuilder f24168sb;

    private static final class WrappedIoException extends RuntimeException {
        private static final long serialVersionUID = 1;
        /* access modifiers changed from: private */
        public final IOException wrappedIoException;

        private WrappedIoException(IOException iOException) {
            this.wrappedIoException = iOException;
        }
    }

    private static final class XmlNsAttribute implements CharSequence {
        /* access modifiers changed from: private */
        public final String value;
        private final String xmlFragment;

        public char charAt(int i10) {
            return this.xmlFragment.charAt(i10);
        }

        public int length() {
            return this.xmlFragment.length();
        }

        public CharSequence subSequence(int i10, int i11) {
            return this.xmlFragment.subSequence(i10, i11);
        }

        public String toString() {
            return this.xmlFragment;
        }

        private XmlNsAttribute(String str) {
            this.value = (String) StringUtils.requireNotNullNorEmpty(str, "Value must not be null");
            this.xmlFragment = " xmlns='" + str + '\'';
        }
    }

    static {
        Class<XmlStringBuilder> cls = XmlStringBuilder.class;
    }

    public XmlStringBuilder() {
        this.f24168sb = new LazyStringBuilder();
        this.effectiveXmlEnvironment = null;
    }

    private void appendXmlTo(Consumer<CharSequence> consumer, XmlEnvironment xmlEnvironment) {
        for (CharSequence next : this.f24168sb.getAsList()) {
            if (next instanceof XmlStringBuilder) {
                ((XmlStringBuilder) next).appendXmlTo(consumer, xmlEnvironment);
            } else if (next instanceof XmlNsAttribute) {
                XmlNsAttribute xmlNsAttribute = (XmlNsAttribute) next;
                if (!xmlNsAttribute.value.equals(xmlEnvironment.getEffectiveNamespace())) {
                    consumer.accept(xmlNsAttribute);
                    xmlEnvironment = new XmlEnvironment(xmlNsAttribute.value);
                }
            } else {
                consumer.accept(next);
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$write$0(Writer writer, CharSequence charSequence) {
        try {
            writer.append(charSequence);
        } catch (IOException e10) {
            throw new WrappedIoException(e10);
        }
    }

    public XmlStringBuilder attribute(String str, String str2) {
        this.f24168sb.append(' ').append((CharSequence) str).append((CharSequence) "='");
        escapeAttributeValue(str2);
        this.f24168sb.append('\'');
        return this;
    }

    public char charAt(int i10) {
        return this.f24168sb.charAt(i10);
    }

    public XmlStringBuilder closeElement(String str) {
        this.f24168sb.append((CharSequence) "</").append((CharSequence) str);
        rightAngleBracket();
        return this;
    }

    public XmlStringBuilder closeEmptyElement() {
        this.f24168sb.append((CharSequence) "/>");
        return this;
    }

    public XmlStringBuilder condAttribute(boolean z10, String str, String str2) {
        if (z10) {
            attribute(str, str2);
        }
        return this;
    }

    public XmlStringBuilder condEmptyElement(boolean z10, String str) {
        if (z10) {
            emptyElement(str);
        }
        return this;
    }

    public XmlStringBuilder element(String str, String str2) {
        if (str2.isEmpty()) {
            return emptyElement(str);
        }
        openElement(str);
        escape(str2);
        closeElement(str);
        return this;
    }

    public XmlStringBuilder emptyElement(Enum<?> enumR) {
        return emptyElement(enumR.toString());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CharSequence)) {
            return false;
        }
        return toString().equals(((CharSequence) obj).toString());
    }

    public XmlStringBuilder escape(String str) {
        this.f24168sb.append(StringUtils.escapeForXml(str));
        return this;
    }

    public XmlStringBuilder escapeAttributeValue(String str) {
        this.f24168sb.append(StringUtils.escapeForXmlAttributeApos(str));
        return this;
    }

    public XmlStringBuilder escapedElement(String str, String str2) {
        openElement(str);
        append((CharSequence) str2);
        closeElement(str);
        return this;
    }

    public XmlEnvironment getXmlEnvironment() {
        return this.effectiveXmlEnvironment;
    }

    public XmlStringBuilder halfOpenElement(String str) {
        this.f24168sb.append('<').append((CharSequence) str);
        return this;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public int length() {
        return this.f24168sb.length();
    }

    public XmlStringBuilder openElement(String str) {
        halfOpenElement(str).rightAngleBracket();
        return this;
    }

    public XmlStringBuilder optAppend(Element element) {
        if (element != null) {
            append(element.toXML(this.effectiveXmlEnvironment));
        }
        return this;
    }

    public XmlStringBuilder optAttribute(String str, String str2) {
        if (str2 != null) {
            attribute(str, str2);
        }
        return this;
    }

    public XmlStringBuilder optAttributeCs(String str, CharSequence charSequence) {
        return optAttribute(str, charSequence);
    }

    public XmlStringBuilder optBooleanAttribute(String str, boolean z10) {
        if (z10) {
            this.f24168sb.append(' ').append((CharSequence) str).append((CharSequence) "='true'");
        }
        return this;
    }

    public XmlStringBuilder optBooleanAttributeDefaultTrue(String str, boolean z10) {
        if (!z10) {
            this.f24168sb.append(' ').append((CharSequence) str).append((CharSequence) "='false'");
        }
        return this;
    }

    public XmlStringBuilder optElement(String str, String str2) {
        if (str2 != null) {
            element(str, str2);
        }
        return this;
    }

    public XmlStringBuilder optEscape(CharSequence charSequence) {
        return charSequence == null ? this : escape(charSequence);
    }

    public XmlStringBuilder optIntAttribute(String str, int i10) {
        if (i10 >= 0) {
            attribute(str, Integer.toString(i10));
        }
        return this;
    }

    public XmlStringBuilder optIntElement(String str, int i10) {
        if (i10 >= 0) {
            element(str, String.valueOf(i10));
        }
        return this;
    }

    public XmlStringBuilder optLongAttribute(String str, Long l10) {
        if (l10 != null && l10.longValue() >= 0) {
            attribute(str, Long.toString(l10.longValue()));
        }
        return this;
    }

    public XmlStringBuilder optTextChild(CharSequence charSequence, NamedElement namedElement) {
        if (charSequence == null) {
            return closeEmptyElement();
        }
        rightAngleBracket();
        escape(charSequence);
        closeElement(namedElement);
        return this;
    }

    public XmlStringBuilder optXmlLangAttribute(String str) {
        if (!StringUtils.isNullOrEmpty((CharSequence) str)) {
            xmllangAttribute(str);
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public XmlStringBuilder prelude(FullyQualifiedElement fullyQualifiedElement) {
        return prelude(fullyQualifiedElement.getElementName(), fullyQualifiedElement.getNamespace());
    }

    public XmlStringBuilder rightAngleBracket() {
        this.f24168sb.append((CharSequence) RIGHT_ANGLE_BRACKET);
        return this;
    }

    public CharSequence subSequence(int i10, int i11) {
        return this.f24168sb.subSequence(i10, i11);
    }

    public XmlStringBuilder text(CharSequence charSequence) {
        this.f24168sb.append(StringUtils.escapeForXmlText(charSequence));
        return this;
    }

    public List<CharSequence> toList(XmlEnvironment xmlEnvironment) {
        ArrayList arrayList = new ArrayList(this.f24168sb.getAsList().size());
        appendXmlTo(new s(arrayList), xmlEnvironment);
        return arrayList;
    }

    public String toString() {
        return this.f24168sb.toString();
    }

    public void write(Writer writer, XmlEnvironment xmlEnvironment) throws IOException {
        try {
            appendXmlTo(new r(writer), xmlEnvironment);
        } catch (WrappedIoException e10) {
            throw e10.wrappedIoException;
        }
    }

    public XmlStringBuilder xmllangAttribute(String str) {
        optAttribute("xml:lang", str);
        return this;
    }

    public XmlStringBuilder xmlnsAttribute(String str) {
        XmlEnvironment xmlEnvironment;
        if (str != null && ((xmlEnvironment = this.effectiveXmlEnvironment) == null || !xmlEnvironment.effectiveNamespaceEquals(str))) {
            append((CharSequence) new XmlNsAttribute(str));
        }
        return this;
    }

    public XmlStringBuilder emptyElement(String str) {
        halfOpenElement(str);
        return closeEmptyElement();
    }

    public XmlStringBuilder escape(CharSequence charSequence) {
        return escape(charSequence.toString());
    }

    public XmlStringBuilder halfOpenElement(NamedElement namedElement) {
        return halfOpenElement(namedElement.getElementName());
    }

    public XmlStringBuilder optAppend(Collection<? extends Element> collection) {
        if (collection != null) {
            append(collection);
        }
        return this;
    }

    public XmlStringBuilder optAttribute(String str, Long l10) {
        if (l10 != null) {
            attribute(str, l10.longValue());
        }
        return this;
    }

    public XmlStringBuilder optElement(String str, Date date) {
        if (date != null) {
            element(str, date);
        }
        return this;
    }

    public XmlStringBuilder optIntAttribute(String str, Integer num) {
        if (num != null) {
            attribute(str, num.toString());
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public XmlStringBuilder prelude(String str, String str2) {
        halfOpenElement(str);
        xmlnsAttribute(str2);
        return this;
    }

    public StringBuilder toXML(XmlEnvironment xmlEnvironment) {
        StringBuilder sb2 = new StringBuilder(length());
        appendXmlTo(new q(sb2), xmlEnvironment);
        return sb2;
    }

    public XmlStringBuilder closeElement(NamedElement namedElement) {
        closeElement(namedElement.getElementName());
        return this;
    }

    public XmlStringBuilder optAttribute(String str, Date date) {
        if (date != null) {
            attribute(str, date);
        }
        return this;
    }

    public XmlStringBuilder optElement(String str, CharSequence charSequence) {
        if (charSequence != null) {
            element(str, charSequence.toString());
        }
        return this;
    }

    public XmlStringBuilder(ExtensionElement extensionElement) {
        this(extensionElement, (XmlEnvironment) null);
    }

    public XmlStringBuilder append(XmlStringBuilder xmlStringBuilder) {
        this.f24168sb.append(xmlStringBuilder.f24168sb);
        return this;
    }

    public XmlStringBuilder attribute(String str, boolean z10) {
        return attribute(str, Boolean.toString(z10));
    }

    public XmlStringBuilder optAttribute(String str, CharSequence charSequence) {
        if (charSequence != null) {
            attribute(str, charSequence.toString());
        }
        return this;
    }

    public XmlStringBuilder optElement(Element element) {
        if (element != null) {
            append(element);
        }
        return this;
    }

    public XmlStringBuilder(NamedElement namedElement) {
        this();
        halfOpenElement(namedElement.getElementName());
    }

    public XmlStringBuilder append(Element element) {
        return append(element.toXML(this.effectiveXmlEnvironment));
    }

    public XmlStringBuilder attribute(String str, Date date) {
        return attribute(str, XmppDateTime.i(date));
    }

    public XmlStringBuilder optAttribute(String str, Enum<?> enumR) {
        if (enumR != null) {
            attribute(str, enumR.toString());
        }
        return this;
    }

    public XmlStringBuilder optElement(String str, Enum<?> enumR) {
        if (enumR != null) {
            element(str, enumR);
        }
        return this;
    }

    public XmlStringBuilder append(Collection<? extends Element> collection) {
        for (Element append : collection) {
            append(append);
        }
        return this;
    }

    public XmlStringBuilder attribute(String str, CharSequence charSequence) {
        return attribute(str, charSequence.toString());
    }

    public XmlStringBuilder element(String str, Date date) {
        return element(str, XmppDateTime.i(date));
    }

    public XmlStringBuilder optAttribute(String str, Number number) {
        if (number != null) {
            attribute(str, number.toString());
        }
        return this;
    }

    public XmlStringBuilder optElement(String str, Object obj) {
        if (obj != null) {
            element(str, obj.toString());
        }
        return this;
    }

    public XmlStringBuilder(FullyQualifiedElement fullyQualifiedElement, XmlEnvironment xmlEnvironment) {
        this(fullyQualifiedElement.getElementName(), fullyQualifiedElement.getNamespace(), fullyQualifiedElement.getLanguage(), xmlEnvironment);
    }

    public XmlStringBuilder attribute(String str, Enum<?> enumR) {
        attribute(str, enumR.toString());
        return this;
    }

    public XmlStringBuilder element(String str, CharSequence charSequence) {
        return element(str, charSequence.toString());
    }

    public XmlStringBuilder(String str, String str2, String str3, XmlEnvironment xmlEnvironment) {
        this.f24168sb = new LazyStringBuilder();
        halfOpenElement(str);
        if (xmlEnvironment == null) {
            xmlnsAttribute(str2);
            xmllangAttribute(str3);
        } else {
            if (!xmlEnvironment.effectiveNamespaceEquals(str2)) {
                xmlnsAttribute(str2);
            }
            if (!xmlEnvironment.effectiveLanguageEquals(str3)) {
                xmllangAttribute(str3);
            }
        }
        this.effectiveXmlEnvironment = XmlEnvironment.builder().withNamespace(str2).withLanguage(str3).withNext(xmlEnvironment).build();
    }

    public XmlStringBuilder append(CharSequence charSequence) {
        this.f24168sb.append(charSequence);
        return this;
    }

    public <E extends Enum<?>> XmlStringBuilder attribute(String str, E e10, E e11) {
        if (!(e10 == null || e10 == e11)) {
            attribute(str, e10.toString());
        }
        return this;
    }

    public XmlStringBuilder element(String str, Enum<?> enumR) {
        element(str, enumR.toString());
        return this;
    }

    public XmlStringBuilder append(CharSequence charSequence, int i10, int i11) {
        this.f24168sb.append(charSequence, i10, i11);
        return this;
    }

    public XmlStringBuilder attribute(String str, int i10) {
        return attribute(str, String.valueOf(i10));
    }

    @Deprecated
    public XmlStringBuilder element(Element element) {
        return append(element.toXML());
    }

    public XmlStringBuilder append(char c10) {
        this.f24168sb.append(c10);
        return this;
    }

    public XmlStringBuilder attribute(String str, long j10) {
        return attribute(str, String.valueOf(j10));
    }
}
