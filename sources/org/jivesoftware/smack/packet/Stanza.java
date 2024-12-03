package org.jivesoftware.smack.packet;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.packet.id.StandardStanzaIdSource;
import org.jivesoftware.smack.packet.id.StanzaIdSource;
import org.jivesoftware.smack.util.MultiMap;
import org.jivesoftware.smack.util.PacketUtil;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smack.util.XmppElementUtil;
import org.jxmpp.jid.Jid;

public abstract class Stanza implements StanzaView, TopLevelStreamElement {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected static final String DEFAULT_LANGUAGE = Locale.getDefault().getLanguage().toLowerCase(Locale.US);
    public static final String ITEM = "item";
    public static final String TEXT = "text";
    private StanzaError error;
    private final MultiMap<QName, ExtensionElement> extensionElements;
    private Jid from;

    /* renamed from: id  reason: collision with root package name */
    private String f24131id;
    protected String language;
    private final String namespace;
    private Jid to;
    private final StanzaIdSource usedStanzaIdSource;

    protected Stanza() {
        this.namespace = "jabber:client";
        this.f24131id = null;
        this.error = null;
        this.extensionElements = new MultiMap<>();
        this.usedStanzaIdSource = null;
        this.f24131id = StandardStanzaIdSource.DEFAULT.getNewStanzaId();
    }

    static String determineLanguage(XmlLangElement xmlLangElement, String str) {
        if (str == null || str.isEmpty()) {
            return xmlLangElement.getLanguage();
        }
        return str;
    }

    public static String getDefaultLanguage() {
        return DEFAULT_LANGUAGE;
    }

    /* access modifiers changed from: protected */
    public final void addCommonAttributes(XmlStringBuilder xmlStringBuilder) {
        xmlStringBuilder.optAttribute("to", (CharSequence) getTo());
        xmlStringBuilder.optAttribute("from", (CharSequence) getFrom());
        xmlStringBuilder.optAttribute("id", getStanzaId());
    }

    public final void addExtension(ExtensionElement extensionElement) {
        if (extensionElement != null) {
            QName qName = extensionElement.getQName();
            synchronized (this.extensionElements) {
                this.extensionElements.put(qName, extensionElement);
            }
        }
    }

    public final void addExtensions(Collection<? extends ExtensionElement> collection) {
        if (collection != null) {
            for (ExtensionElement addExtension : collection) {
                addExtension(addExtension);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void appendErrorIfExists(XmlStringBuilder xmlStringBuilder) {
        StanzaError error2 = getError();
        if (error2 != null) {
            xmlStringBuilder.append((Element) error2);
        }
    }

    /* access modifiers changed from: package-private */
    public final MultiMap<QName, ExtensionElement> cloneExtensionsMap() {
        MultiMap<QName, ExtensionElement> clone;
        synchronized (this.extensionElements) {
            clone = this.extensionElements.clone();
        }
        return clone;
    }

    public final StanzaError getError() {
        return this.error;
    }

    public final ExtensionElement getExtension(String str) {
        return PacketUtil.extensionElementFrom(getExtensions(), (String) null, str);
    }

    public final ExtensionElement getExtensionElement(String str, String str2) {
        ExtensionElement extension;
        if (str2 == null || (extension = getExtension(new QName(str2, str))) == null) {
            return null;
        }
        return extension;
    }

    public final List<ExtensionElement> getExtensions() {
        List<ExtensionElement> values;
        synchronized (this.extensionElements) {
            values = this.extensionElements.values();
        }
        return values;
    }

    public final MultiMap<QName, ExtensionElement> getExtensionsMap() {
        return cloneExtensionsMap();
    }

    public final Jid getFrom() {
        return this.from;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getNamespace() {
        return "jabber:client";
    }

    public final String getStanzaId() {
        return this.f24131id;
    }

    public final Jid getTo() {
        return this.to;
    }

    public final boolean hasExtension(String str, String str2) {
        boolean containsKey;
        if (str == null) {
            return hasExtension(str2);
        }
        QName qName = new QName(str2, str);
        synchronized (this.extensionElements) {
            containsKey = this.extensionElements.containsKey(qName);
        }
        return containsKey;
    }

    public final boolean hasStanzaIdSet() {
        return this.f24131id != null;
    }

    /* access modifiers changed from: protected */
    public void logCommonAttributes(StringBuilder sb2) {
        if (getTo() != null) {
            sb2.append("to=");
            sb2.append(this.to);
            sb2.append(',');
        }
        if (getFrom() != null) {
            sb2.append("from=");
            sb2.append(this.from);
            sb2.append(',');
        }
        if (hasStanzaIdSet()) {
            sb2.append("id=");
            sb2.append(this.f24131id);
            sb2.append(',');
        }
    }

    public final ExtensionElement overrideExtension(ExtensionElement extensionElement) {
        ExtensionElement removeExtension;
        if (extensionElement == null) {
            return null;
        }
        synchronized (this.extensionElements) {
            removeExtension = removeExtension(extensionElement.getElementName(), extensionElement.getNamespace());
            addExtension(extensionElement);
        }
        return removeExtension;
    }

    public final ExtensionElement removeExtension(String str, String str2) {
        ExtensionElement remove;
        QName qName = new QName(str2, str);
        synchronized (this.extensionElements) {
            remove = this.extensionElements.remove(qName);
        }
        return remove;
    }

    public void setError(StanzaError stanzaError) {
        this.error = stanzaError;
    }

    public void setFrom(Jid jid) {
        this.from = jid;
    }

    @Deprecated
    public void setLanguage(String str) {
        this.language = str;
    }

    /* access modifiers changed from: protected */
    public String setNewStanzaId() {
        StanzaIdSource stanzaIdSource = this.usedStanzaIdSource;
        if (stanzaIdSource != null) {
            this.f24131id = stanzaIdSource.getNewStanzaId();
        } else {
            this.f24131id = StandardStanzaIdSource.DEFAULT.getNewStanzaId();
        }
        return getStanzaId();
    }

    public void setStanzaId(String str) {
        if (str != null) {
            StringUtils.requireNotNullNorEmpty(str, "id must either be null or not the empty String");
        }
        this.f24131id = str;
    }

    public void setTo(Jid jid) {
        this.to = jid;
    }

    public final void throwIfNoStanzaId() {
        if (!hasStanzaIdSet()) {
            throw new IllegalArgumentException("The stanza has no RFC stanza ID set, although one is required");
        }
    }

    public abstract String toString();

    @Deprecated
    public final <E extends ExtensionElement> E getExtension(String str, String str2) {
        return getExtensionElement(str, str2);
    }

    @Deprecated
    public void setError(StanzaError.Builder builder) {
        setError(builder.build());
    }

    public final ExtensionElement getExtension(QName qName) {
        ExtensionElement first;
        synchronized (this.extensionElements) {
            first = this.extensionElements.getFirst(qName);
        }
        return first;
    }

    @Deprecated
    public String setStanzaId() {
        if (!hasStanzaIdSet()) {
            setNewStanzaId();
        }
        return getStanzaId();
    }

    public final List<ExtensionElement> getExtensions(String str, String str2) {
        StringUtils.requireNotNullNorEmpty(str, "elementName must not be null nor empty");
        StringUtils.requireNotNullNorEmpty(str2, "namespace must not be null nor empty");
        return getExtensions(new QName(str2, str));
    }

    @Deprecated
    public final ExtensionElement removeExtension(ExtensionElement extensionElement) {
        QName qName = extensionElement.getQName();
        synchronized (this.extensionElements) {
            if (this.extensionElements.getAll(qName).remove(extensionElement)) {
                return extensionElement;
            }
            return null;
        }
    }

    public final boolean hasExtension(String str) {
        synchronized (this.extensionElements) {
            for (ExtensionElement namespace2 : this.extensionElements.values()) {
                if (namespace2.getNamespace().equals(str)) {
                    return true;
                }
            }
            return false;
        }
    }

    protected Stanza(StanzaBuilder<?> stanzaBuilder) {
        this.namespace = "jabber:client";
        this.f24131id = null;
        this.error = null;
        StanzaIdSource stanzaIdSource = stanzaBuilder.stanzaIdSource;
        if (stanzaIdSource != null) {
            this.f24131id = stanzaIdSource.getNewStanzaId();
            this.usedStanzaIdSource = stanzaBuilder.stanzaIdSource;
        } else {
            this.f24131id = stanzaBuilder.stanzaId;
            this.usedStanzaIdSource = null;
        }
        this.to = stanzaBuilder.to;
        this.from = stanzaBuilder.from;
        this.error = stanzaBuilder.stanzaError;
        this.language = stanzaBuilder.language;
        this.extensionElements = stanzaBuilder.extensionElements.clone();
    }

    public final List<ExtensionElement> getExtensions(QName qName) {
        List<ExtensionElement> all;
        synchronized (this.extensionElements) {
            all = this.extensionElements.getAll(qName);
        }
        return Collections.unmodifiableList(all);
    }

    public final <E extends ExtensionElement> List<E> getExtensions(Class<E> cls) {
        List<E> elementsFrom;
        synchronized (this.extensionElements) {
            elementsFrom = XmppElementUtil.getElementsFrom(this.extensionElements, cls);
        }
        return elementsFrom;
    }

    protected Stanza(Stanza stanza) {
        this.namespace = "jabber:client";
        this.f24131id = null;
        this.error = null;
        this.usedStanzaIdSource = stanza.usedStanzaIdSource;
        this.f24131id = stanza.getStanzaId();
        this.to = stanza.getTo();
        this.from = stanza.getFrom();
        this.error = stanza.error;
        this.extensionElements = stanza.extensionElements.clone();
    }
}
