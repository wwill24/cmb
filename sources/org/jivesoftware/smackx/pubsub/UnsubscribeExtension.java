package org.jivesoftware.smackx.pubsub;

import org.jivesoftware.smack.util.XmlStringBuilder;

public class UnsubscribeExtension extends NodeExtension {

    /* renamed from: id  reason: collision with root package name */
    protected String f24226id;
    protected String jid;

    public UnsubscribeExtension(String str) {
        this(str, (String) null, (String) null);
    }

    /* access modifiers changed from: protected */
    public void addXml(XmlStringBuilder xmlStringBuilder) {
        xmlStringBuilder.attribute("jid", this.jid);
        xmlStringBuilder.optAttribute("subid", this.f24226id);
        xmlStringBuilder.closeEmptyElement();
    }

    public String getId() {
        return this.f24226id;
    }

    public String getJid() {
        return this.jid;
    }

    public UnsubscribeExtension(String str, String str2) {
        this(str, str2, (String) null);
    }

    public UnsubscribeExtension(String str, String str2, String str3) {
        super(PubSubElementType.UNSUBSCRIBE, str2);
        this.jid = str;
        this.f24226id = str3;
    }
}
