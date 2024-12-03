package org.jivesoftware.smackx.rsm;

import java.util.Collection;
import java.util.LinkedList;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.util.PacketUtil;
import org.jivesoftware.smackx.rsm.packet.RSMSet;

public class RSMManager {
    /* access modifiers changed from: package-private */
    public Collection<ExtensionElement> continuePage(int i10, Collection<ExtensionElement> collection) {
        return continuePage(i10, collection, (Collection<ExtensionElement>) null);
    }

    /* access modifiers changed from: package-private */
    public Collection<ExtensionElement> page(int i10) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(new RSMSet(i10));
        return linkedList;
    }

    /* access modifiers changed from: package-private */
    public Collection<ExtensionElement> continuePage(int i10, Collection<ExtensionElement> collection, Collection<ExtensionElement> collection2) {
        if (collection != null) {
            if (collection2 == null) {
                collection2 = new LinkedList<>();
            }
            RSMSet rSMSet = (RSMSet) PacketUtil.extensionElementFrom(collection, "set", RSMSet.NAMESPACE);
            if (rSMSet != null) {
                collection2.add(new RSMSet(i10, rSMSet.getLast(), RSMSet.PageDirection.after));
                return collection2;
            }
            throw new IllegalArgumentException("returnedExtensions did not contain a RSMset");
        }
        throw new IllegalArgumentException("returnedExtensions must no be null");
    }
}
