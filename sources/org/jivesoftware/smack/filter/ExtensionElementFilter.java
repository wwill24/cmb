package org.jivesoftware.smack.filter;

import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.XmppElementUtil;

public class ExtensionElementFilter<E extends ExtensionElement> implements StanzaFilter {
    private final Class<E> extensionElementClass;
    private final QName extensionElementQName;

    protected ExtensionElementFilter(Class<E> cls) {
        this.extensionElementClass = cls;
        this.extensionElementQName = XmppElementUtil.getQNameFor(cls);
    }

    public boolean accept(E e10) {
        return true;
    }

    public final boolean accept(Stanza stanza) {
        ExtensionElement extension = stanza.getExtension(this.extensionElementQName);
        if (extension != null && this.extensionElementClass.isInstance(extension)) {
            return accept((ExtensionElement) this.extensionElementClass.cast(extension));
        }
        return false;
    }
}
