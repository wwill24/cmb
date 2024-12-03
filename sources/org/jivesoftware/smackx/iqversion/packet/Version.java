package org.jivesoftware.smackx.iqversion.packet;

import com.facebook.internal.ServerProtocol;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.softwareinfo.form.SoftwareInfoForm;
import org.jxmpp.jid.Jid;

public class Version extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "jabber:iq:version";
    private final String name;
    private String os;
    private final String version;

    public Version() {
        super("query", NAMESPACE);
        this.name = null;
        this.version = null;
        setType(IQ.Type.get);
    }

    public static Version createResultFor(Stanza stanza, Version version2) {
        Version version3 = new Version(version2);
        version3.setStanzaId(stanza.getStanzaId());
        version3.setTo(stanza.getFrom());
        return version3;
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.optElement("name", this.name);
        iQChildElementXmlStringBuilder.optElement(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, this.version);
        iQChildElementXmlStringBuilder.optElement(SoftwareInfoForm.OS, this.os);
        return iQChildElementXmlStringBuilder;
    }

    public String getName() {
        return this.name;
    }

    public String getOs() {
        return this.os;
    }

    public String getVersion() {
        return this.version;
    }

    public void setOs(String str) {
        this.os = str;
    }

    public Version(Jid jid) {
        this();
        setTo(jid);
    }

    public Version(String str, String str2) {
        this(str, str2, (String) null);
    }

    public Version(String str, String str2, String str3) {
        super("query", NAMESPACE);
        setType(IQ.Type.result);
        this.name = (String) StringUtils.requireNotNullNorEmpty(str, "name must not be null");
        this.version = (String) StringUtils.requireNotNullNorEmpty(str2, "version must not be null");
        this.os = str3;
    }

    public Version(Version version2) {
        this(version2.name, version2.version, version2.os);
    }
}
