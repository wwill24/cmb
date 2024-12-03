package org.jivesoftware.smackx.ox.element;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.util.MultiMap;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.PacketUtil;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jxmpp.jid.Jid;
import org.jxmpp.util.XmppDateTime;

public abstract class OpenPgpContentElement implements ExtensionElement {
    public static final String ATTR_JID = "jid";
    public static final String ATTR_STAMP = "stamp";
    public static final String ELEM_PAYLOAD = "payload";
    public static final String ELEM_TIME = "time";
    public static final String ELEM_TO = "to";
    private final MultiMap<QName, ExtensionElement> payload = new MultiMap<>();
    private final Date timestamp;
    private String timestampString;
    private final Set<? extends Jid> to;

    protected OpenPgpContentElement(Set<? extends Jid> set, Date date, List<ExtensionElement> list) {
        this.to = set;
        this.timestamp = (Date) Objects.requireNonNull(date);
        for (ExtensionElement next : list) {
            this.payload.put(next.getQName(), next);
        }
    }

    /* access modifiers changed from: protected */
    public void addCommonXml(XmlStringBuilder xmlStringBuilder) {
        Set<? extends Jid> set = this.to;
        if (set == null) {
            set = Collections.emptySet();
        }
        for (Jid attribute : set) {
            xmlStringBuilder.halfOpenElement("to").attribute("jid", (CharSequence) attribute).closeEmptyElement();
        }
        ensureTimestampStringSet();
        xmlStringBuilder.halfOpenElement("time").attribute("stamp", this.timestampString).closeEmptyElement();
        xmlStringBuilder.openElement("payload");
        for (ExtensionElement xml : this.payload.values()) {
            xmlStringBuilder.append(xml.toXML(getNamespace()));
        }
        xmlStringBuilder.closeElement("payload");
    }

    /* access modifiers changed from: protected */
    public void ensureTimestampStringSet() {
        if (this.timestampString == null) {
            this.timestampString = XmppDateTime.i(this.timestamp);
        }
    }

    public ExtensionElement getExtension(String str) {
        return PacketUtil.extensionElementFrom(getExtensions(), (String) null, str);
    }

    public final List<ExtensionElement> getExtensions() {
        List<ExtensionElement> values;
        synchronized (this.payload) {
            values = this.payload.values();
        }
        return values;
    }

    public String getNamespace() {
        return "urn:xmpp:openpgp:0";
    }

    public final Date getTimestamp() {
        return this.timestamp;
    }

    public final Set<? extends Jid> getTo() {
        return this.to;
    }

    public InputStream toInputStream() {
        return new ByteArrayInputStream(toXML().toString().getBytes(Charset.forName("UTF-8")));
    }

    public <PE extends ExtensionElement> PE getExtension(String str, String str2) {
        PE pe2;
        if (str2 == null) {
            return null;
        }
        QName qName = new QName(str2, str);
        synchronized (this.payload) {
            pe2 = (ExtensionElement) this.payload.getFirst(qName);
        }
        if (pe2 == null) {
            return null;
        }
        return pe2;
    }

    public List<ExtensionElement> getExtensions(String str, String str2) {
        return this.payload.getAll(new QName(str2, str));
    }
}
