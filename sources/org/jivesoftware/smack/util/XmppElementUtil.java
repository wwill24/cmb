package org.jivesoftware.smack.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.FullyQualifiedElement;
import org.jivesoftware.smack.packet.StandardExtensionElement;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.provider.ProviderManager;
import org.jxmpp.util.cache.LruCache;

public class XmppElementUtil {
    private static final LruCache<Class<? extends FullyQualifiedElement>, QName> CLASS_TO_QNAME_CACHE = new LruCache<>(512);
    public static final Logger LOGGER = Logger.getLogger(XmppElementUtil.class.getName());

    public static <E extends ExtensionElement> E castOrThrow(ExtensionElement extensionElement, Class<E> cls) {
        String str;
        if (cls.isInstance(extensionElement)) {
            return (ExtensionElement) cls.cast(extensionElement);
        }
        QName qNameFor = getQNameFor(cls);
        if (extensionElement instanceof StandardExtensionElement) {
            str = "because there is no according extension element provider registered with ProviderManager for " + qNameFor + ". WARNING: This indicates a serious problem with your Smack setup, probably causing Smack not being able to properly initialize itself.";
        } else {
            ExtensionElementProvider<ExtensionElement> extensionProvider = ProviderManager.getExtensionProvider(qNameFor);
            str = "because there is an inconsistency with the provider registered with ProviderManager: the active provider for " + qNameFor + " '" + extensionProvider.getClass() + "' does not return instances of type " + cls + ", but instead returns instances of type " + extensionElement.getClass() + ".";
        }
        throw new IllegalStateException("Extension element is not of expected class '" + cls.getName() + "', " + str);
    }

    public static <E extends ExtensionElement> List<E> getElementsFrom(MultiMap<QName, ExtensionElement> multiMap, Class<E> cls) {
        List<ExtensionElement> all = multiMap.getAll(getQNameFor(cls));
        if (all.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(all.size());
        for (ExtensionElement castOrThrow : all) {
            arrayList.add(castOrThrow(castOrThrow, cls));
        }
        return arrayList;
    }

    public static QName getQNameFor(Class<? extends FullyQualifiedElement> cls) {
        LruCache<Class<? extends FullyQualifiedElement>, QName> lruCache = CLASS_TO_QNAME_CACHE;
        QName qName = lruCache.get(cls);
        if (qName != null) {
            return qName;
        }
        try {
            Object obj = cls.getField("QNAME").get((Object) null);
            if (QName.class.isAssignableFrom(obj.getClass())) {
                QName qName2 = (QName) obj;
                lruCache.put(cls, qName2);
                return qName2;
            }
            Logger logger = LOGGER;
            logger.warning("The QNAME field of " + cls + " is not of type QNAME.");
            try {
                QName qName3 = new QName((String) cls.getField("NAMESPACE").get((Object) null), (String) cls.getField("ELEMENT").get((Object) null));
                CLASS_TO_QNAME_CACHE.put(cls, qName3);
                return qName3;
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e10) {
                throw new IllegalArgumentException("The " + cls + " has no ELEMENT, NAMESPACE or QNAME member. Consider adding QNAME", e10);
            }
        } catch (NoSuchFieldException unused) {
            Logger logger2 = LOGGER;
            logger2.finer("The " + cls + " has no static QNAME field. Consider adding one.");
        } catch (IllegalAccessException | IllegalArgumentException | SecurityException e11) {
            throw new IllegalArgumentException(e11);
        }
    }
}
