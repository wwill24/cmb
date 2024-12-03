package org.jivesoftware.smackx.pubsub;

import java.util.ArrayList;
import java.util.Collection;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.pubsub.Item;

public class PublishItem<T extends Item> extends NodeExtension {
    protected Collection<T> items;

    public PublishItem(String str, T t10) {
        super(PubSubElementType.PUBLISH, str);
        ArrayList arrayList = new ArrayList(1);
        this.items = arrayList;
        arrayList.add(t10);
    }

    /* access modifiers changed from: protected */
    public void addXml(XmlStringBuilder xmlStringBuilder) {
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.append((Collection<? extends Element>) this.items);
        xmlStringBuilder.closeElement((NamedElement) this);
    }

    public PublishItem(String str, Collection<T> collection) {
        super(PubSubElementType.PUBLISH, str);
        this.items = collection;
    }
}
