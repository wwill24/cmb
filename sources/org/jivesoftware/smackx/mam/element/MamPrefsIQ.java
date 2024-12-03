package org.jivesoftware.smackx.mam.element;

import java.util.List;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.mam.element.MamElements;
import org.jxmpp.jid.Jid;

public class MamPrefsIQ extends IQ {
    public static final String ELEMENT = "prefs";
    public static final String NAMESPACE = "urn:xmpp:mam:2";
    private final List<Jid> alwaysJids;
    private final DefaultBehavior defaultBehavior;
    private final List<Jid> neverJids;

    public enum DefaultBehavior {
        always,
        never,
        roster
    }

    public MamPrefsIQ() {
        super("prefs", "urn:xmpp:mam:2");
        this.alwaysJids = null;
        this.neverJids = null;
        this.defaultBehavior = null;
    }

    public List<Jid> getAlwaysJids() {
        return this.alwaysJids;
    }

    public DefaultBehavior getDefault() {
        return this.defaultBehavior;
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        if (getType().equals(IQ.Type.set) || getType().equals(IQ.Type.result)) {
            iQChildElementXmlStringBuilder.attribute("default", (Enum<?>) this.defaultBehavior);
        }
        if (this.alwaysJids == null && this.neverJids == null) {
            iQChildElementXmlStringBuilder.setEmptyElement();
            return iQChildElementXmlStringBuilder;
        }
        iQChildElementXmlStringBuilder.rightAngleBracket();
        List<Jid> list = this.alwaysJids;
        if (list != null) {
            iQChildElementXmlStringBuilder.append((Element) new MamElements.AlwaysJidListElement(list));
        }
        List<Jid> list2 = this.neverJids;
        if (list2 != null) {
            iQChildElementXmlStringBuilder.append((Element) new MamElements.NeverJidListElement(list2));
        }
        return iQChildElementXmlStringBuilder;
    }

    public List<Jid> getNeverJids() {
        return this.neverJids;
    }

    public MamPrefsIQ(List<Jid> list, List<Jid> list2, DefaultBehavior defaultBehavior2) {
        super("prefs", "urn:xmpp:mam:2");
        setType(IQ.Type.set);
        this.alwaysJids = list;
        this.neverJids = list2;
        this.defaultBehavior = defaultBehavior2;
    }
}
