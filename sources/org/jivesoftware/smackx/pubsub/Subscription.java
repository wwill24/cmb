package org.jivesoftware.smackx.pubsub;

import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jxmpp.jid.Jid;

public class Subscription extends NodeExtension {
    protected boolean configRequired;

    /* renamed from: id  reason: collision with root package name */
    protected String f24225id;
    protected Jid jid;
    protected State state;

    public enum State {
        subscribed,
        unconfigured,
        pending,
        none
    }

    public Subscription(Jid jid2) {
        this(jid2, (String) null, (String) null, (State) null);
    }

    /* access modifiers changed from: protected */
    public void addXml(XmlStringBuilder xmlStringBuilder) {
        xmlStringBuilder.attribute("jid", (CharSequence) this.jid);
        xmlStringBuilder.optAttribute("subid", this.f24225id);
        xmlStringBuilder.optAttribute("subscription", (Enum<?>) this.state);
        xmlStringBuilder.closeEmptyElement();
    }

    public String getId() {
        return this.f24225id;
    }

    public Jid getJid() {
        return this.jid;
    }

    public State getState() {
        return this.state;
    }

    public boolean isConfigRequired() {
        return this.configRequired;
    }

    public Subscription(Jid jid2, String str) {
        this(jid2, str, (String) null, (State) null);
    }

    public Subscription(Jid jid2, State state2) {
        this(jid2, (String) null, (String) null, state2);
    }

    public Subscription(Jid jid2, String str, String str2, State state2) {
        super(PubSubElementType.SUBSCRIPTION, str);
        this.configRequired = false;
        this.jid = jid2;
        this.f24225id = str2;
        this.state = state2;
    }

    public Subscription(Jid jid2, String str, String str2, State state2, boolean z10) {
        super(PubSubElementType.SUBSCRIPTION, str);
        this.jid = jid2;
        this.f24225id = str2;
        this.state = state2;
        this.configRequired = z10;
    }
}
