package org.jivesoftware.smackx.jingle.element;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.AbstractIqBuilder;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.IqBuilder;
import org.jivesoftware.smack.packet.IqData;
import org.jivesoftware.smack.packet.id.StandardStanzaIdSource;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.jingle.element.JingleReason;
import org.jxmpp.jid.FullJid;

public final class Jingle extends IQ {
    public static final String ACTION_ATTRIBUTE_NAME = "action";
    public static final String ELEMENT = "jingle";
    public static final String INITIATOR_ATTRIBUTE_NAME = "initiator";
    public static final String NAMESPACE = "urn:xmpp:jingle:1";
    public static final String RESPONDER_ATTRIBUTE_NAME = "responder";
    public static final String SESSION_ID_ATTRIBUTE_NAME = "sid";
    private final JingleAction action;
    private final List<JingleContent> contents;
    private final FullJid initiator;
    private final JingleReason reason;
    private final FullJid responder;
    private final String sessionId;

    public static final class Builder extends IqBuilder<Builder, Jingle> {
        private JingleAction action;
        private List<JingleContent> contents;
        private FullJid initiator;
        private JingleReason reason;
        private FullJid responder;
        private String sid;

        Builder(IqData iqData) {
            super((AbstractIqBuilder<?>) iqData);
        }

        public Builder addJingleContent(JingleContent jingleContent) {
            if (this.contents == null) {
                this.contents = new ArrayList(1);
            }
            this.contents.add(jingleContent);
            return this;
        }

        public Builder getThis() {
            return this;
        }

        public Builder setAction(JingleAction jingleAction) {
            this.action = jingleAction;
            return this;
        }

        public Builder setInitiator(FullJid fullJid) {
            this.initiator = fullJid;
            return this;
        }

        public Builder setReason(JingleReason.Reason reason2) {
            this.reason = new JingleReason(reason2);
            return this;
        }

        public Builder setResponder(FullJid fullJid) {
            this.responder = fullJid;
            return this;
        }

        public Builder setSessionId(String str) {
            StringUtils.requireNotNullNorEmpty(str, "Session ID must not be null nor empty");
            this.sid = str;
            return this;
        }

        Builder(XMPPConnection xMPPConnection) {
            super(xMPPConnection);
        }

        public Builder setReason(JingleReason jingleReason) {
            this.reason = jingleReason;
            return this;
        }

        Builder(String str) {
            super(str);
        }

        public Jingle build() {
            return new Jingle(this, this.sid, this.action, this.initiator, this.responder, this.reason, this.contents);
        }
    }

    public static Builder builder(XMPPConnection xMPPConnection) {
        return new Builder(xMPPConnection);
    }

    @Deprecated
    public static Builder getBuilder() {
        return builder(StandardStanzaIdSource.DEFAULT.getNewStanzaId());
    }

    public JingleAction getAction() {
        return this.action;
    }

    public List<JingleContent> getContents() {
        return this.contents;
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.optAttribute(INITIATOR_ATTRIBUTE_NAME, (CharSequence) getInitiator());
        iQChildElementXmlStringBuilder.optAttribute(RESPONDER_ATTRIBUTE_NAME, (CharSequence) getResponder());
        iQChildElementXmlStringBuilder.optAttribute("action", (Enum<?>) getAction());
        iQChildElementXmlStringBuilder.optAttribute("sid", getSid());
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.optElement(this.reason);
        iQChildElementXmlStringBuilder.append((Collection<? extends Element>) this.contents);
        return iQChildElementXmlStringBuilder;
    }

    public FullJid getInitiator() {
        return this.initiator;
    }

    public JingleReason getReason() {
        return this.reason;
    }

    public FullJid getResponder() {
        return this.responder;
    }

    public String getSid() {
        return this.sessionId;
    }

    public JingleContent getSoleContentOrThrow() {
        if (this.contents.isEmpty()) {
            return null;
        }
        if (this.contents.size() <= 1) {
            return this.contents.get(0);
        }
        throw new IllegalStateException();
    }

    private Jingle(Builder builder, String str, JingleAction jingleAction, FullJid fullJid, FullJid fullJid2, JingleReason jingleReason, List<JingleContent> list) {
        super(builder, ELEMENT, "urn:xmpp:jingle:1");
        this.sessionId = (String) StringUtils.requireNotNullNorEmpty(str, "Jingle session ID must not be null");
        this.action = (JingleAction) Objects.requireNonNull(jingleAction, "Jingle action must not be null");
        this.initiator = fullJid;
        this.responder = fullJid2;
        this.reason = jingleReason;
        if (list != null) {
            this.contents = Collections.unmodifiableList(list);
        } else {
            this.contents = Collections.emptyList();
        }
        setType(IQ.Type.set);
    }

    public static Builder builder(IqData iqData) {
        return new Builder(iqData);
    }

    public static Builder builder(String str) {
        return new Builder(str);
    }
}
