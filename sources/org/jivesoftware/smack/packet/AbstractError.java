package org.jivesoftware.smack.packet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.cli.HelpFormatter;
import org.jivesoftware.smack.util.ExceptionUtil;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.PacketUtil;
import org.jivesoftware.smack.util.XmlStringBuilder;

public class AbstractError {
    protected final Map<String, String> descriptiveTexts;
    protected final List<ExtensionElement> extensions;
    protected final String textNamespace;

    protected AbstractError(Map<String, String> map) {
        this(map, (List<ExtensionElement>) null);
    }

    /* access modifiers changed from: protected */
    public void addDescriptiveTextsAndExtensions(XmlStringBuilder xmlStringBuilder) {
        for (Map.Entry next : this.descriptiveTexts.entrySet()) {
            xmlStringBuilder.halfOpenElement("text").xmlnsAttribute(this.textNamespace).optXmlLangAttribute((String) next.getKey()).rightAngleBracket();
            xmlStringBuilder.escape((String) next.getValue());
            xmlStringBuilder.closeElement("text");
        }
        xmlStringBuilder.append((Collection<? extends Element>) this.extensions);
    }

    public String getDescriptiveText() {
        if (this.descriptiveTexts.isEmpty()) {
            return null;
        }
        Locale locale = Locale.getDefault();
        String[] strArr = {locale.getLanguage() + HelpFormatter.DEFAULT_OPT_PREFIX + locale.getCountry() + HelpFormatter.DEFAULT_OPT_PREFIX + locale.getVariant(), locale.getLanguage() + HelpFormatter.DEFAULT_OPT_PREFIX + locale.getCountry(), locale.getLanguage(), "en", ""};
        for (int i10 = 0; i10 < 5; i10++) {
            String descriptiveText = getDescriptiveText(strArr[i10]);
            if (descriptiveText != null) {
                return descriptiveText;
            }
        }
        return this.descriptiveTexts.values().iterator().next();
    }

    public <PE extends ExtensionElement> PE getExtension(String str, String str2) {
        return PacketUtil.extensionElementFrom(this.extensions, str, str2);
    }

    protected AbstractError(Map<String, String> map, List<ExtensionElement> list) {
        this(map, (String) null, list);
    }

    protected AbstractError(Map<String, String> map, String str, List<ExtensionElement> list) {
        if (map != null) {
            this.descriptiveTexts = map;
        } else {
            this.descriptiveTexts = Collections.emptyMap();
        }
        this.textNamespace = str;
        if (list != null) {
            this.extensions = list;
        } else {
            this.extensions = Collections.emptyList();
        }
    }

    public static abstract class Builder<B extends Builder<B>> {
        protected Map<String, String> descriptiveTexts;
        protected List<ExtensionElement> extensions;
        protected String textNamespace;

        public B addExtension(ExtensionElement extensionElement) {
            if (this.extensions == null) {
                this.extensions = new ArrayList();
            }
            this.extensions.add(extensionElement);
            return getThis();
        }

        /* access modifiers changed from: protected */
        public abstract B getThis();

        public B setDescriptiveEnText(String str) {
            if (this.descriptiveTexts == null) {
                this.descriptiveTexts = new HashMap();
            }
            this.descriptiveTexts.put("en", str);
            return getThis();
        }

        public B setDescriptiveTexts(Map<String, String> map) {
            if (map == null) {
                this.descriptiveTexts = null;
                return getThis();
            }
            for (String str : map.keySet()) {
                if (str == null) {
                    throw new IllegalArgumentException("descriptiveTexts cannot contain null key");
                }
            }
            Map<String, String> map2 = this.descriptiveTexts;
            if (map2 == null) {
                this.descriptiveTexts = map;
            } else {
                map2.putAll(map);
            }
            return getThis();
        }

        public B setExtensions(List<ExtensionElement> list) {
            List<ExtensionElement> list2 = this.extensions;
            if (list2 == null) {
                this.extensions = list;
            } else {
                list2.addAll(list);
            }
            return getThis();
        }

        public B setTextNamespace(String str) {
            this.textNamespace = str;
            return getThis();
        }

        public B setDescriptiveEnText(String str, Exception exc) {
            StringBuilder sb2 = new StringBuilder(512);
            sb2.append(str);
            sb2.append(10);
            sb2.append(ExceptionUtil.getStackTrace(exc));
            return setDescriptiveEnText(sb2.toString());
        }
    }

    public String getDescriptiveText(String str) {
        Objects.requireNonNull(str, "xmllang must not be null");
        return this.descriptiveTexts.get(str);
    }
}
