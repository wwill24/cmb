package org.jivesoftware.smack.packet;

import java.util.Collection;
import java.util.List;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.StanzaBuilder;
import org.jivesoftware.smack.packet.id.StanzaIdSource;
import org.jivesoftware.smack.util.Function;
import org.jivesoftware.smack.util.MultiMap;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.ToStringUtil;
import org.jivesoftware.smack.util.XmppElementUtil;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.impl.a;
import org.jxmpp.stringprep.XmppStringprepException;

public abstract class StanzaBuilder<B extends StanzaBuilder<B>> implements StanzaView {
    MultiMap<QName, ExtensionElement> extensionElements;
    Jid from;
    String language;
    StanzaError stanzaError;
    final String stanzaId;
    final StanzaIdSource stanzaIdSource;
    Jid to;

    protected StanzaBuilder(StanzaBuilder<?> stanzaBuilder) {
        this.extensionElements = new MultiMap<>();
        this.stanzaIdSource = stanzaBuilder.stanzaIdSource;
        this.stanzaId = stanzaBuilder.stanzaId;
        this.to = stanzaBuilder.to;
        this.from = stanzaBuilder.from;
        this.stanzaError = stanzaBuilder.stanzaError;
        this.language = stanzaBuilder.language;
        this.extensionElements = stanzaBuilder.extensionElements.clone();
    }

    public static IqData buildIqData(String str) {
        return new IqData(str);
    }

    public static MessageBuilder buildMessage() {
        return buildMessage((String) null);
    }

    public static MessageBuilder buildMessageFrom(Message message, String str) {
        return new MessageBuilder(message, str);
    }

    public static PresenceBuilder buildPresence() {
        return buildPresence((String) null);
    }

    public static PresenceBuilder buildPresenceFrom(Presence presence, String str) {
        return new PresenceBuilder(presence, str);
    }

    public static <SB extends StanzaBuilder<?>> SB buildResponse(StanzaView stanzaView, Function<SB, String> function) {
        SB sb2 = (StanzaBuilder) function.apply(stanzaView.getStanzaId());
        sb2.to(stanzaView.getFrom()).from(stanzaView.getTo());
        return sb2;
    }

    private void copyFromStanza(Stanza stanza) {
        this.to = stanza.getTo();
        this.from = stanza.getFrom();
        this.stanzaError = stanza.getError();
        this.language = stanza.getLanguage();
        this.extensionElements = stanza.cloneExtensionsMap();
    }

    public final B addExtension(ExtensionElement extensionElement) {
        this.extensionElements.put(extensionElement.getQName(), extensionElement);
        return getThis();
    }

    public final B addExtensions(Collection<? extends ExtensionElement> collection) {
        for (ExtensionElement addExtension : collection) {
            addExtension(addExtension);
        }
        return getThis();
    }

    public final B addOptExtensions(Collection<? extends ExtensionElement> collection) {
        if (collection == null) {
            return getThis();
        }
        return addExtensions(collection);
    }

    /* access modifiers changed from: protected */
    public abstract void addStanzaSpecificAttributes(ToStringUtil.Builder builder);

    public abstract Stanza build();

    public final B from(CharSequence charSequence) throws XmppStringprepException {
        return from(a.n(charSequence));
    }

    public final StanzaError getError() {
        return this.stanzaError;
    }

    public final ExtensionElement getExtension(QName qName) {
        return this.extensionElements.getFirst(qName);
    }

    public final List<ExtensionElement> getExtensions() {
        return this.extensionElements.values();
    }

    public final Jid getFrom() {
        return this.from;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getStanzaId() {
        return this.stanzaId;
    }

    public abstract B getThis();

    public final Jid getTo() {
        return this.to;
    }

    public final B overrideExtension(ExtensionElement extensionElement) {
        QName qName = extensionElement.getQName();
        this.extensionElements.remove(qName);
        this.extensionElements.put(qName, extensionElement);
        return getThis();
    }

    public final B removeExtension(String str, String str2) {
        this.extensionElements.remove(new QName(str2, str));
        return getThis();
    }

    public final B setError(StanzaError stanzaError2) {
        this.stanzaError = stanzaError2;
        return getThis();
    }

    public final B setLanguage(String str) {
        this.language = str;
        return getThis();
    }

    public final void throwIfNoStanzaId() {
        if (!willBuildStanzaWithId()) {
            throw new IllegalArgumentException("The builder will not build a stanza with an ID set, although it is required");
        }
    }

    public final B to(CharSequence charSequence) throws XmppStringprepException {
        return to(a.n(charSequence));
    }

    public final String toString() {
        ToStringUtil.Builder addValue = ToStringUtil.builderFor(getClass()).addValue("id", this.stanzaId).addValue("from", this.from).addValue("to", this.to).addValue("language", this.language).addValue("error", this.stanzaError);
        addStanzaSpecificAttributes(addValue);
        addValue.add("Extension Elements", this.extensionElements.values(), new h());
        return addValue.build();
    }

    public final boolean willBuildStanzaWithId() {
        return this.stanzaIdSource != null || StringUtils.isNotEmpty((CharSequence) this.stanzaId);
    }

    public static MessageBuilder buildMessage(String str) {
        return new MessageBuilder(str);
    }

    public static MessageBuilder buildMessageFrom(Message message, StanzaIdSource stanzaIdSource2) {
        return new MessageBuilder(message, stanzaIdSource2);
    }

    public static PresenceBuilder buildPresence(String str) {
        return new PresenceBuilder(str);
    }

    public static PresenceBuilder buildPresenceFrom(Presence presence, StanzaIdSource stanzaIdSource2) {
        return new PresenceBuilder(presence, stanzaIdSource2);
    }

    public final B from(Jid jid) {
        this.from = jid;
        return getThis();
    }

    public final List<ExtensionElement> getExtensions(QName qName) {
        return this.extensionElements.getAll(qName);
    }

    public final B to(Jid jid) {
        this.to = jid;
        return getThis();
    }

    public final <E extends ExtensionElement> List<E> getExtensions(Class<E> cls) {
        return XmppElementUtil.getElementsFrom(this.extensionElements, cls);
    }

    public final B removeExtension(ExtensionElement extensionElement) {
        this.extensionElements.getAll(extensionElement.getQName()).remove(extensionElement);
        return getThis();
    }

    protected StanzaBuilder(StanzaIdSource stanzaIdSource2) {
        this.extensionElements = new MultiMap<>();
        this.stanzaIdSource = stanzaIdSource2;
        this.stanzaId = null;
    }

    protected StanzaBuilder(String str) {
        this.extensionElements = new MultiMap<>();
        this.stanzaIdSource = null;
        this.stanzaId = (String) StringUtils.requireNullOrNotEmpty(str, "Stanza ID must not be the empty String");
    }

    protected StanzaBuilder(Stanza stanza, String str) {
        this(str);
        copyFromStanza(stanza);
    }

    protected StanzaBuilder(Stanza stanza, StanzaIdSource stanzaIdSource2) {
        this(stanzaIdSource2);
        copyFromStanza(stanza);
    }
}
