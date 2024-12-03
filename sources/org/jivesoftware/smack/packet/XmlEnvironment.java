package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.xml.XmlPullParser;

public class XmlEnvironment {
    public static final XmlEnvironment EMPTY = new XmlEnvironment((String) null);
    private transient String effectiveLanguage;
    private transient boolean effectiveLanguageDetermined;
    private transient String effectiveNamespace;
    private transient boolean effectiveNamespaceDetermined;
    private final String language;
    private final String namespace;
    private final XmlEnvironment next;
    private transient String toStringCache;

    public static class Builder {
        /* access modifiers changed from: private */
        public String language;
        /* access modifiers changed from: private */
        public String namespace;
        /* access modifiers changed from: private */
        public XmlEnvironment next;

        public XmlEnvironment build() {
            return new XmlEnvironment(this);
        }

        public Builder with(StreamOpen streamOpen) {
            withNamespace(streamOpen.getNamespace());
            withLanguage(streamOpen.getLanguage());
            return this;
        }

        public Builder withLanguage(String str) {
            this.language = str;
            return this;
        }

        public Builder withNamespace(String str) {
            this.namespace = str;
            return this;
        }

        public Builder withNext(XmlEnvironment xmlEnvironment) {
            this.next = xmlEnvironment;
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static XmlEnvironment from(XmlPullParser xmlPullParser) {
        return from(xmlPullParser, (XmlEnvironment) null);
    }

    public boolean effectiveLanguageEquals(String str) {
        String effectiveLanguage2 = getEffectiveLanguage();
        if (effectiveLanguage2 == null) {
            return false;
        }
        return effectiveLanguage2.equals(str);
    }

    public boolean effectiveNamespaceEquals(String str) {
        String effectiveNamespace2 = getEffectiveNamespace();
        if (effectiveNamespace2 == null) {
            return false;
        }
        return effectiveNamespace2.equals(str);
    }

    public String getEffectiveLanguage() {
        if (this.effectiveLanguageDetermined) {
            return this.effectiveLanguage;
        }
        if (StringUtils.isNotEmpty((CharSequence) this.language)) {
            this.effectiveLanguage = this.language;
        } else {
            XmlEnvironment xmlEnvironment = this.next;
            if (xmlEnvironment != null) {
                this.effectiveLanguage = xmlEnvironment.getEffectiveLanguage();
            }
        }
        this.effectiveLanguageDetermined = true;
        return this.effectiveLanguage;
    }

    public String getEffectiveNamespace() {
        if (this.effectiveNamespaceDetermined) {
            return this.effectiveNamespace;
        }
        if (StringUtils.isNotEmpty((CharSequence) this.namespace)) {
            this.effectiveNamespace = this.namespace;
        } else {
            XmlEnvironment xmlEnvironment = this.next;
            if (xmlEnvironment != null) {
                this.effectiveNamespace = xmlEnvironment.getEffectiveNamespace();
            }
        }
        this.effectiveNamespaceDetermined = true;
        return this.effectiveNamespace;
    }

    public String getEffectiveNamespaceOrUse(String str) {
        String effectiveNamespace2 = getEffectiveNamespace();
        if (StringUtils.isNullOrEmpty((CharSequence) effectiveNamespace2)) {
            return str;
        }
        return effectiveNamespace2;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public String toString() {
        if (this.toStringCache == null) {
            this.toStringCache = XmlEnvironment.class.getSimpleName() + ' ' + "xmlns=" + getEffectiveNamespace() + ' ' + "xmllang=" + getEffectiveLanguage() + ' ';
        }
        return this.toStringCache;
    }

    public XmlEnvironment(String str) {
        this(str, (String) null);
    }

    public static XmlEnvironment from(XmlPullParser xmlPullParser, XmlEnvironment xmlEnvironment) {
        return new XmlEnvironment(xmlPullParser.getDefaultNamespace(), ParserUtils.getXmlLang(xmlPullParser), xmlEnvironment);
    }

    public XmlEnvironment(String str, String str2) {
        this(str, str2, (XmlEnvironment) null);
    }

    private XmlEnvironment(Builder builder) {
        this(builder.namespace, builder.language, builder.next);
    }

    public XmlEnvironment(String str, String str2, XmlEnvironment xmlEnvironment) {
        this.namespace = str;
        this.language = str2;
        this.next = xmlEnvironment;
    }
}
