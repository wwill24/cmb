package org.jivesoftware.smackx.pubsub;

import org.jivesoftware.smack.util.XmlStringBuilder;

public class OptionsExtension extends NodeExtension {

    /* renamed from: id  reason: collision with root package name */
    protected String f24222id;
    protected String jid;

    public OptionsExtension(String str) {
        this(str, (String) null, (String) null);
    }

    /* access modifiers changed from: protected */
    public void addXml(XmlStringBuilder xmlStringBuilder) {
        xmlStringBuilder.attribute("jid", this.jid);
        xmlStringBuilder.optAttribute("subid", this.f24222id);
        xmlStringBuilder.closeEmptyElement();
    }

    public String getId() {
        return this.f24222id;
    }

    public String getJid() {
        return this.jid;
    }

    public OptionsExtension(String str, String str2) {
        this(str, str2, (String) null);
    }

    public OptionsExtension(String str, String str2, String str3) {
        super(PubSubElementType.OPTIONS, str2);
        this.jid = str;
        this.f24222id = str3;
    }
}
