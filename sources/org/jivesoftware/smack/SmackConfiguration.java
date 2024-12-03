package org.jivesoftware.smack;

import com.coffeemeetsbagel.models.util.FacebookParse;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.HostnameVerifier;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionConfiguration;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModuleDescriptor;
import org.jivesoftware.smack.compression.XMPPInputOutputStream;
import org.jivesoftware.smack.debugger.ReflectionDebuggerFactory;
import org.jivesoftware.smack.debugger.SmackDebuggerFactory;
import org.jivesoftware.smack.parsing.ExceptionThrowingCallbackWithHint;
import org.jivesoftware.smack.parsing.ParsingExceptionCallback;
import org.jivesoftware.smack.util.Objects;

public final class SmackConfiguration {
    public static boolean DEBUG = false;
    private static SmackDebuggerFactory DEFAULT_DEBUGGER_FACTORY = ReflectionDebuggerFactory.INSTANCE;
    private static final Set<Class<? extends ModularXmppClientToServerConnectionModuleDescriptor>> KNOWN_MODULES = new HashSet();
    public static final URL SMACK_URL;
    public static final String SMACK_URL_STRING = "https://igniterealtime.org/projects/smack";
    static final List<XMPPInputOutputStream> compressionHandlers = new ArrayList(2);
    private static ParsingExceptionCallback defaultCallback = new ExceptionThrowingCallbackWithHint();
    private static final int defaultConcurrencyLevelLimit;
    private static HostnameVerifier defaultHostnameVerififer;
    private static List<String> defaultMechs = new ArrayList();
    private static int defaultPacketReplyTimeout = FacebookParse.FB_NO_LIMIT;
    static Set<String> disabledSmackClasses = new HashSet();
    private static int packetCollectorSize = FacebookParse.FB_NO_LIMIT;
    static boolean smackInitialized = false;
    private static UnknownIqRequestReplyMode unknownIqRequestReplyMode = UnknownIqRequestReplyMode.replyFeatureNotImplemented;

    public enum UnknownIqRequestReplyMode {
        doNotReply,
        replyFeatureNotImplemented,
        replyServiceUnavailable
    }

    static {
        try {
            SMACK_URL = new URL(SMACK_URL_STRING);
            int availableProcessors = Runtime.getRuntime().availableProcessors();
            if (availableProcessors < 8) {
                defaultConcurrencyLevelLimit = 8;
            } else {
                defaultConcurrencyLevelLimit = (int) (((double) availableProcessors) * 1.1d);
            }
        } catch (MalformedURLException e10) {
            throw new IllegalStateException(e10);
        }
    }

    public static void addAllKnownModulesTo(ModularXmppClientToServerConnectionConfiguration.Builder builder) {
        Set<Class<? extends ModularXmppClientToServerConnectionModuleDescriptor>> set = KNOWN_MODULES;
        synchronized (set) {
            for (Class<? extends ModularXmppClientToServerConnectionModuleDescriptor> addModule : set) {
                builder.addModule(addModule);
            }
        }
    }

    public static void addCompressionHandler(XMPPInputOutputStream xMPPInputOutputStream) {
        compressionHandlers.add(xMPPInputOutputStream);
    }

    public static void addDisabledSmackClass(Class<?> cls) {
        addDisabledSmackClass(cls.getName());
    }

    public static void addDisabledSmackClasses(String... strArr) {
        for (String addDisabledSmackClass : strArr) {
            addDisabledSmackClass(addDisabledSmackClass);
        }
    }

    public static boolean addModule(Class<? extends ModularXmppClientToServerConnectionModuleDescriptor> cls) {
        boolean add;
        Set<Class<? extends ModularXmppClientToServerConnectionModuleDescriptor>> set = KNOWN_MODULES;
        synchronized (set) {
            add = set.add(cls);
        }
        return add;
    }

    public static void addSaslMech(String str) {
        if (!defaultMechs.contains(str)) {
            defaultMechs.add(str);
        }
    }

    public static void addSaslMechs(Collection<String> collection) {
        for (String addSaslMech : collection) {
            addSaslMech(addSaslMech);
        }
    }

    public static List<XMPPInputOutputStream> getCompressionHandlers() {
        List<XMPPInputOutputStream> list = compressionHandlers;
        ArrayList arrayList = new ArrayList(list.size());
        for (XMPPInputOutputStream next : list) {
            if (next.isSupported()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static int getDefaultConcurrencyLevelLimit() {
        return defaultConcurrencyLevelLimit;
    }

    static HostnameVerifier getDefaultHostnameVerifier() {
        return defaultHostnameVerififer;
    }

    public static ParsingExceptionCallback getDefaultParsingExceptionCallback() {
        return defaultCallback;
    }

    public static int getDefaultReplyTimeout() {
        if (defaultPacketReplyTimeout <= 0) {
            defaultPacketReplyTimeout = FacebookParse.FB_NO_LIMIT;
        }
        return defaultPacketReplyTimeout;
    }

    public static SmackDebuggerFactory getDefaultSmackDebuggerFactory() {
        return DEFAULT_DEBUGGER_FACTORY;
    }

    public static List<String> getSaslMechs() {
        return Collections.unmodifiableList(defaultMechs);
    }

    public static int getStanzaCollectorSize() {
        return packetCollectorSize;
    }

    public static UnknownIqRequestReplyMode getUnknownIqRequestReplyMode() {
        return unknownIqRequestReplyMode;
    }

    @Deprecated
    public static String getVersion() {
        return SmackInitialization.SMACK_VERSION;
    }

    public static boolean isDisabledSmackClass(String str) {
        for (String next : disabledSmackClasses) {
            if (next.equals(str)) {
                return true;
            }
            int lastIndexOf = next.lastIndexOf(46);
            if (next.length() > lastIndexOf && !Character.isUpperCase(next.charAt(lastIndexOf + 1)) && str.startsWith(next)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSmackInitialized() {
        return smackInitialized;
    }

    public static void removeSaslMech(String str) {
        defaultMechs.remove(str);
    }

    public static void removeSaslMechs(Collection<String> collection) {
        defaultMechs.removeAll(collection);
    }

    public static void setDefaultHostnameVerifier(HostnameVerifier hostnameVerifier) {
        defaultHostnameVerififer = hostnameVerifier;
    }

    public static void setDefaultParsingExceptionCallback(ParsingExceptionCallback parsingExceptionCallback) {
        defaultCallback = parsingExceptionCallback;
    }

    public static void setDefaultReplyTimeout(int i10) {
        if (i10 > 0) {
            defaultPacketReplyTimeout = i10;
            return;
        }
        throw new IllegalArgumentException();
    }

    public static void setDefaultSmackDebuggerFactory(SmackDebuggerFactory smackDebuggerFactory) {
        DEFAULT_DEBUGGER_FACTORY = (SmackDebuggerFactory) Objects.requireNonNull(smackDebuggerFactory, "Debugger factory must not be null");
    }

    public static void setStanzaCollectorSize(int i10) {
        packetCollectorSize = i10;
    }

    public static void setUnknownIqRequestReplyMode(UnknownIqRequestReplyMode unknownIqRequestReplyMode2) {
        unknownIqRequestReplyMode = (UnknownIqRequestReplyMode) Objects.requireNonNull(unknownIqRequestReplyMode2, "Must set mode");
    }

    public static void addDisabledSmackClass(String str) {
        disabledSmackClasses.add(str);
    }
}
