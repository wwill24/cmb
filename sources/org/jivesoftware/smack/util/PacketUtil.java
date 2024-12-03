package org.jivesoftware.smack.util;

import java.util.Collection;
import java.util.Iterator;
import org.jivesoftware.smack.packet.ExtensionElement;

public class PacketUtil {
    public static <PE extends ExtensionElement> PE extensionElementFrom(Collection<ExtensionElement> collection, String str, String str2) {
        Iterator<ExtensionElement> it = collection.iterator();
        while (it.hasNext()) {
            PE pe2 = (ExtensionElement) it.next();
            if ((str == null || pe2.getElementName().equals(str)) && pe2.getNamespace().equals(str2)) {
                return pe2;
            }
        }
        return null;
    }
}
