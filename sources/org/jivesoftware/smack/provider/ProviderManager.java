package org.jivesoftware.smack.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.Smack;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Nonza;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmppElementUtil;

public final class ProviderManager {
    private static final Map<QName, ExtensionElementProvider<ExtensionElement>> extensionProviders = new ConcurrentHashMap();
    private static final Map<QName, C0522IqProvider<IQ>> iqProviders = new ConcurrentHashMap();
    private static final Map<QName, NonzaProvider<? extends Nonza>> nonzaProviders = new ConcurrentHashMap();
    private static final Map<QName, ExtensionElementProvider<ExtensionElement>> streamFeatureProviders = new ConcurrentHashMap();

    static {
        Smack.ensureInitialized();
    }

    public static void addExtensionProvider(String str, String str2, Object obj) {
        validate(str, str2);
        QName removeExtensionProvider = removeExtensionProvider(str, str2);
        if (obj instanceof ExtensionElementProvider) {
            extensionProviders.put(removeExtensionProvider, (ExtensionElementProvider) obj);
            return;
        }
        throw new IllegalArgumentException("Provider must be a PacketExtensionProvider");
    }

    public static void addIQProvider(String str, String str2, Object obj) {
        validate(str, str2);
        QName removeIQProvider = removeIQProvider(str, str2);
        if (obj instanceof C0522IqProvider) {
            iqProviders.put(removeIQProvider, (C0522IqProvider) obj);
            return;
        }
        throw new IllegalArgumentException("Provider must be an instance of IqProvider");
    }

    public static void addLoader(ProviderLoader providerLoader) {
        if (providerLoader.getIQProviderInfo() != null) {
            for (IQProviderInfo next : providerLoader.getIQProviderInfo()) {
                addIQProvider(next.getElementName(), next.getNamespace(), next.getProvider());
            }
        }
        if (providerLoader.getExtensionProviderInfo() != null) {
            for (ExtensionProviderInfo next2 : providerLoader.getExtensionProviderInfo()) {
                addExtensionProvider(next2.getElementName(), next2.getNamespace(), next2.getProvider());
            }
        }
        if (providerLoader.getStreamFeatureProviderInfo() != null) {
            for (StreamFeatureProviderInfo next3 : providerLoader.getStreamFeatureProviderInfo()) {
                addStreamFeatureProvider(next3.getElementName(), next3.getNamespace(), (ExtensionElementProvider) next3.getProvider());
            }
        }
    }

    public static void addNonzaProvider(NonzaProvider<? extends Nonza> nonzaProvider) {
        nonzaProviders.put(XmppElementUtil.getQNameFor(nonzaProvider.getElementClass()), nonzaProvider);
    }

    public static void addStreamFeatureProvider(String str, String str2, ExtensionElementProvider<ExtensionElement> extensionElementProvider) {
        validate(str, str2);
        streamFeatureProviders.put(getQName(str, str2), extensionElementProvider);
    }

    public static ExtensionElementProvider<ExtensionElement> getExtensionProvider(String str, String str2) {
        return getExtensionProvider(getQName(str, str2));
    }

    public static List<ExtensionElementProvider<ExtensionElement>> getExtensionProviders() {
        Map<QName, ExtensionElementProvider<ExtensionElement>> map = extensionProviders;
        ArrayList arrayList = new ArrayList(map.size());
        arrayList.addAll(map.values());
        return arrayList;
    }

    public static C0522IqProvider<IQ> getIQProvider(String str, String str2) {
        return iqProviders.get(getQName(str, str2));
    }

    public static List<C0522IqProvider<IQ>> getIQProviders() {
        Map<QName, C0522IqProvider<IQ>> map = iqProviders;
        ArrayList arrayList = new ArrayList(map.size());
        arrayList.addAll(map.values());
        return arrayList;
    }

    public static NonzaProvider<? extends Nonza> getNonzaProvider(String str, String str2) {
        return getNonzaProvider(getQName(str, str2));
    }

    private static QName getQName(String str, String str2) {
        return new QName(str2, str);
    }

    public static ExtensionElementProvider<ExtensionElement> getStreamFeatureProvider(String str, String str2) {
        return streamFeatureProviders.get(getQName(str, str2));
    }

    public static QName removeExtensionProvider(String str, String str2) {
        QName qName = getQName(str, str2);
        extensionProviders.remove(qName);
        return qName;
    }

    public static QName removeIQProvider(String str, String str2) {
        QName qName = getQName(str, str2);
        iqProviders.remove(qName);
        return qName;
    }

    public static void removeNonzaProvider(Class<? extends Nonza> cls) {
        nonzaProviders.remove(XmppElementUtil.getQNameFor(cls));
    }

    public static void removeStreamFeatureProvider(String str, String str2) {
        streamFeatureProviders.remove(getQName(str, str2));
    }

    private static void validate(String str, String str2) {
        if (StringUtils.isNullOrEmpty((CharSequence) str)) {
            throw new IllegalArgumentException("elementName must not be null or empty");
        } else if (StringUtils.isNullOrEmpty((CharSequence) str2)) {
            throw new IllegalArgumentException("namespace must not be null or empty");
        }
    }

    public static ExtensionElementProvider<ExtensionElement> getExtensionProvider(QName qName) {
        return extensionProviders.get(qName);
    }

    public static NonzaProvider<? extends Nonza> getNonzaProvider(QName qName) {
        return nonzaProviders.get(qName);
    }

    public static void removeNonzaProvider(String str, String str2) {
        nonzaProviders.remove(getQName(str, str2));
    }
}
