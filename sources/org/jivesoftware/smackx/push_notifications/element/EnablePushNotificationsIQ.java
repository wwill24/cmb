package org.jivesoftware.smackx.push_notifications.element;

import java.util.HashMap;
import java.util.Map;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.TextSingleFormField;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.jid.Jid;

public class EnablePushNotificationsIQ extends IQ {
    public static final String ELEMENT = "enable";
    public static final String NAMESPACE = "urn:xmpp:push:0";
    private final Jid jid;
    private final String node;
    private final HashMap<String, String> publishOptions;

    public EnablePushNotificationsIQ(Jid jid2, String str, HashMap<String, String> hashMap) {
        super("enable", "urn:xmpp:push:0");
        this.jid = jid2;
        this.node = str;
        this.publishOptions = hashMap;
        setType(IQ.Type.set);
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.attribute("jid", (CharSequence) this.jid);
        iQChildElementXmlStringBuilder.attribute(NodeElement.ELEMENT, this.node);
        iQChildElementXmlStringBuilder.rightAngleBracket();
        if (this.publishOptions != null) {
            DataForm.Builder builder = DataForm.builder();
            builder.addField(FormField.buildHiddenFormType("http://jabber.org/protocol/pubsub#publish-options"));
            for (Map.Entry next : this.publishOptions.entrySet()) {
                TextSingleFormField.Builder builder2 = FormField.builder((String) next.getKey());
                builder2.setValue((CharSequence) next.getValue());
                builder.addField(builder2.build());
            }
            iQChildElementXmlStringBuilder.append((Element) builder.build());
        }
        return iQChildElementXmlStringBuilder;
    }

    public Jid getJid() {
        return this.jid;
    }

    public String getNode() {
        return this.node;
    }

    public HashMap<String, String> getPublishOptions() {
        return this.publishOptions;
    }

    public EnablePushNotificationsIQ(Jid jid2, String str) {
        this(jid2, str, (HashMap<String, String>) null);
    }
}
