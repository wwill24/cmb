package org.jivesoftware.smackx.muc.packet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.packet.IQ;

public class MUCOwner extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "http://jabber.org/protocol/muc#owner";
    private Destroy destroy;
    private final List<MUCItem> items = new ArrayList();

    public MUCOwner() {
        super("query", NAMESPACE);
    }

    public void addItem(MUCItem mUCItem) {
        synchronized (this.items) {
            this.items.add(mUCItem);
        }
    }

    public Destroy getDestroy() {
        return this.destroy;
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        synchronized (this.items) {
            for (MUCItem xml : this.items) {
                iQChildElementXmlStringBuilder.append(xml.toXML());
            }
        }
        iQChildElementXmlStringBuilder.optElement(getDestroy());
        return iQChildElementXmlStringBuilder;
    }

    public List<MUCItem> getItems() {
        List<MUCItem> unmodifiableList;
        synchronized (this.items) {
            unmodifiableList = Collections.unmodifiableList(new ArrayList(this.items));
        }
        return unmodifiableList;
    }

    public void setDestroy(Destroy destroy2) {
        this.destroy = destroy2;
    }
}
