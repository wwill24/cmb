package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.id.StanzaIdSource;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.ToStringUtil;

public final class MessageBuilder extends MessageOrPresenceBuilder<Message, MessageBuilder> implements MessageView {
    static final MessageBuilder EMPTY = new MessageBuilder((StanzaIdSource) new f());
    Message.Type type;

    MessageBuilder(Message message, String str) {
        super((Stanza) message, str);
        copyFromMessage(message);
    }

    private void copyFromMessage(Message message) {
        this.type = message.getType();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$static$0() {
        return null;
    }

    public MessageBuilder addBody(String str, String str2) {
        String str3 = (String) StringUtils.requireNullOrNotEmpty(str, "language must be null or not empty");
        for (E language : getExtensions(Message.Body.class)) {
            if (StringUtils.nullSafeCharSequenceEquals(str3, language.getLanguage())) {
                throw new IllegalArgumentException("Bodyt with the language " + str3 + " already exists");
            }
        }
        addExtension(new Message.Body(str3, str2));
        return this;
    }

    /* access modifiers changed from: protected */
    public void addStanzaSpecificAttributes(ToStringUtil.Builder builder) {
        builder.addValue("type", this.type);
    }

    public MessageBuilder addSubject(String str, String str2) {
        String str3 = (String) StringUtils.requireNullOrNotEmpty(str, "language must be null or not empty");
        for (E language : getExtensions(Message.Subject.class)) {
            if (StringUtils.nullSafeCharSequenceEquals(str3, language.getLanguage())) {
                throw new IllegalArgumentException("Subject with the language " + str3 + " already exists");
            }
        }
        addExtension(new Message.Subject(str3, str2));
        return this;
    }

    public MessageBuilder getThis() {
        return this;
    }

    public Message.Type getType() {
        return this.type;
    }

    public MessageBuilder ofType(Message.Type type2) {
        this.type = type2;
        return getThis();
    }

    public MessageBuilder setBody(CharSequence charSequence) {
        return setBody(charSequence.toString());
    }

    public MessageBuilder setSubject(String str) {
        return addSubject((String) null, str);
    }

    public MessageBuilder setThread(String str) {
        return setThread(str, (String) null);
    }

    public MessageBuilder setBody(String str) {
        return addBody((String) null, str);
    }

    public MessageBuilder setThread(String str, String str2) {
        addExtension(new Message.Thread(str, str2));
        return getThis();
    }

    MessageBuilder(Message message, StanzaIdSource stanzaIdSource) {
        super((Stanza) message, stanzaIdSource);
        copyFromMessage(message);
    }

    public Message build() {
        return new Message(this);
    }

    MessageBuilder(StanzaIdSource stanzaIdSource) {
        super(stanzaIdSource);
    }

    MessageBuilder(String str) {
        super(str);
    }
}
