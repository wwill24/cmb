package org.jivesoftware.smack.packet;

import java.util.Collection;
import java.util.Locale;
import javax.xml.namespace.QName;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.util.EqualsUtil;
import org.jivesoftware.smack.util.HashCode;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.impl.a;
import org.jxmpp.stringprep.XmppStringprepException;

public final class Message extends MessageOrPresence<MessageBuilder> implements MessageView {
    public static final String BODY = "body";
    public static final String ELEMENT = "message";
    private Type type;

    public static final class Body implements ExtensionElement {
        public static final String ELEMENT = "body";
        public static final String NAMESPACE = "jabber:client";
        public static final QName QNAME = new QName("jabber:client", "body");
        private final HashCode.Cache hashCodeCache;
        private final String language;
        private final String message;
        private final BodyElementNamespace namespace;

        enum BodyElementNamespace {
            client("jabber:client"),
            server(StreamOpen.SERVER_NAMESPACE);
            
            /* access modifiers changed from: private */
            public final String xmlNamespace;

            private BodyElementNamespace(String str) {
                this.xmlNamespace = str;
            }

            public String getNamespace() {
                return this.xmlNamespace;
            }
        }

        public Body(String str, String str2) {
            this(str, str2, BodyElementNamespace.client);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$equals$1(EqualsUtil.Builder builder, Body body) {
            builder.append(this.language, body.language).append(this.message, body.message);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$hashCode$0(HashCode.Builder builder) {
            builder.append((Object) this.language).append((Object) this.message);
        }

        public boolean equals(Object obj) {
            return EqualsUtil.equals(this, obj, new c(this));
        }

        public String getElementName() {
            return "body";
        }

        public String getLanguage() {
            return this.language;
        }

        public String getMessage() {
            return this.message;
        }

        public String getNamespace() {
            return this.namespace.xmlNamespace;
        }

        public int hashCode() {
            return this.hashCodeCache.getHashCode(new b(this));
        }

        public Body(String str, String str2, BodyElementNamespace bodyElementNamespace) {
            this.hashCodeCache = new HashCode.Cache();
            if (str2 != null) {
                this.language = str;
                this.message = str2;
                this.namespace = (BodyElementNamespace) Objects.requireNonNull(bodyElementNamespace);
                return;
            }
            throw new NullPointerException("Message cannot be null.");
        }

        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.text(this.message);
            xmlStringBuilder.closeElement(getElementName());
            return xmlStringBuilder;
        }
    }

    public static final class Subject implements ExtensionElement {
        public static final String ELEMENT = "subject";
        public static final String NAMESPACE = "jabber:client";
        public static final QName QNAME = new QName("jabber:client", ELEMENT);
        private final HashCode.Cache hashCodeCache = new HashCode.Cache();
        /* access modifiers changed from: private */
        public final String language;
        private final String subject;

        public Subject(String str, String str2) {
            if (str2 != null) {
                this.language = str;
                this.subject = str2;
                return;
            }
            throw new NullPointerException("Subject cannot be null.");
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$equals$1(EqualsUtil.Builder builder, Subject subject2) {
            builder.append(this.language, subject2.language).append(this.subject, subject2.subject);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$hashCode$0(HashCode.Builder builder) {
            builder.append((Object) this.language).append((Object) this.subject);
        }

        public boolean equals(Object obj) {
            return EqualsUtil.equals(this, obj, new e(this));
        }

        public String getElementName() {
            return ELEMENT;
        }

        public String getLanguage() {
            return this.language;
        }

        public String getNamespace() {
            return "jabber:client";
        }

        public String getSubject() {
            return this.subject;
        }

        public int hashCode() {
            return this.hashCodeCache.getHashCode(new d(this));
        }

        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.escape(this.subject);
            xmlStringBuilder.closeElement(getElementName());
            return xmlStringBuilder;
        }
    }

    public static class Thread implements ExtensionElement {
        public static final String ELEMENT = "thread";
        public static final String NAMESPACE = "jabber:client";
        public static final String PARENT_ATTRIBUTE_NAME = "parent";
        public static final QName QNAME = new QName("jabber:client", ELEMENT);
        private final String parent;
        private final String thread;

        public Thread(String str) {
            this(str, (String) null);
        }

        public String getElementName() {
            return ELEMENT;
        }

        public String getNamespace() {
            return "jabber:client";
        }

        public String getParent() {
            return this.parent;
        }

        public QName getQName() {
            return QNAME;
        }

        public String getThread() {
            return this.thread;
        }

        public Thread(String str, String str2) {
            this.thread = (String) StringUtils.requireNotNullNorEmpty(str, "thread must not be null nor empty");
            this.parent = (String) StringUtils.requireNullOrNotEmpty(str2, "parent must be null or not empty");
        }

        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.optAttribute(PARENT_ATTRIBUTE_NAME, this.parent);
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.escape(this.thread);
            xmlStringBuilder.closeElement((NamedElement) this);
            return xmlStringBuilder;
        }
    }

    public enum Type {
        normal,
        chat,
        groupchat,
        headline,
        error;

        public static Type fromString(String str) {
            return valueOf(str.toLowerCase(Locale.US));
        }
    }

    @Deprecated
    public Message() {
    }

    @Deprecated
    public Body addBody(String str, String str2) {
        String determineLanguage = Stanza.determineLanguage(this, str);
        removeBody(determineLanguage);
        Body body = new Body(determineLanguage, str2);
        addExtension(body);
        return body;
    }

    @Deprecated
    public Subject addSubject(String str, String str2) {
        String determineLanguage = Stanza.determineLanguage(this, str);
        for (E language : getExtensions(Subject.class)) {
            if (determineLanguage.equals(language.getLanguage())) {
                throw new IllegalArgumentException("Subject with the language " + determineLanguage + " already exists");
            }
        }
        Subject subject = new Subject(determineLanguage, str2);
        addExtension(subject);
        return subject;
    }

    public String getElementName() {
        return "message";
    }

    public Type getType() {
        Type type2 = this.type;
        if (type2 == null) {
            return Type.normal;
        }
        return type2;
    }

    @Deprecated
    public boolean removeBody(String str) {
        String determineLanguage = Stanza.determineLanguage(this, str);
        for (Body next : getBodies()) {
            if (Objects.equals(next.getLanguage(), determineLanguage)) {
                removeExtension(next);
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public boolean removeSubject(String str) {
        String determineLanguage = Stanza.determineLanguage(this, str);
        for (E e10 : getExtensions(Subject.class)) {
            if (determineLanguage.equals(e10.language)) {
                return removeSubject((Subject) e10);
            }
        }
        return false;
    }

    @Deprecated
    public void setBody(CharSequence charSequence) {
        setBody(charSequence != null ? charSequence.toString() : null);
    }

    @Deprecated
    public void setSubject(String str) {
        if (str == null) {
            removeSubject("");
        } else {
            addSubject((String) null, str);
        }
    }

    @Deprecated
    public void setThread(String str) {
        addExtension(new Thread(str));
    }

    @Deprecated
    public void setType(Type type2) {
        this.type = type2;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Message Stanza [");
        logCommonAttributes(sb2);
        if (this.type != null) {
            sb2.append("type=");
            sb2.append(this.type);
            sb2.append(',');
        }
        sb2.append(PropertyUtils.INDEXED_DELIM2);
        return sb2.toString();
    }

    @Deprecated
    public Message(Jid jid) {
        setTo(jid);
    }

    @Deprecated
    public Message clone() {
        return new Message(this);
    }

    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        addCommonAttributes(xmlStringBuilder);
        xmlStringBuilder.optAttribute("type", (Enum<?>) this.type);
        xmlStringBuilder.rightAngleBracket();
        if (this.type == Type.error) {
            appendErrorIfExists(xmlStringBuilder);
        }
        xmlStringBuilder.append((Collection<? extends Element>) getExtensions());
        xmlStringBuilder.closeElement("message");
        return xmlStringBuilder;
    }

    @Deprecated
    public void setBody(String str) {
        if (str == null) {
            removeBody("");
        } else {
            addBody((String) null, str);
        }
    }

    @Deprecated
    public Message(Jid jid, Type type2) {
        this(jid);
        setType(type2);
    }

    public MessageBuilder asBuilder() {
        return StanzaBuilder.buildMessageFrom(this, getStanzaId());
    }

    public MessageBuilder asBuilder(String str) {
        return StanzaBuilder.buildMessageFrom(this, str);
    }

    @Deprecated
    public boolean removeSubject(Subject subject) {
        return removeExtension(subject) != null;
    }

    @Deprecated
    public Message(Jid jid, String str) {
        this(jid);
        setBody(str);
    }

    public MessageBuilder asBuilder(XMPPConnection xMPPConnection) {
        return xMPPConnection.getStanzaFactory().buildMessageStanzaFrom(this);
    }

    @Deprecated
    public boolean removeBody(Body body) {
        return removeExtension(body) != null;
    }

    @Deprecated
    public Message(String str, String str2) throws XmppStringprepException {
        this(a.o(str), str2);
    }

    @Deprecated
    public Message(Jid jid, ExtensionElement extensionElement) {
        this(jid);
        addExtension(extensionElement);
    }

    Message(MessageBuilder messageBuilder) {
        super((StanzaBuilder<?>) messageBuilder);
        this.type = messageBuilder.type;
    }

    public Message(Message message) {
        super((Stanza) message);
        this.type = message.type;
    }
}
