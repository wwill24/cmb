package org.jivesoftware.smack;

import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.initializer.SmackInitializer;
import org.jivesoftware.smack.util.CloseableUtil;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;

public final class SmackInitialization {
    private static final String DEFAULT_CONFIG_FILE = "org.jivesoftware.smack/smack-config.xml";
    private static final Logger LOGGER;
    static final String SMACK_VERSION;

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007a A[Catch:{ Exception -> 0x007d }] */
    static {
        /*
            java.lang.Class<org.jivesoftware.smack.SmackInitialization> r0 = org.jivesoftware.smack.SmackInitialization.class
            java.lang.String r0 = r0.getName()
            java.util.logging.Logger r0 = java.util.logging.Logger.getLogger(r0)
            LOGGER = r0
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x002c, all -> 0x0029 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x002c, all -> 0x0029 }
            java.lang.String r4 = "org.jivesoftware.smack/version"
            java.io.InputStream r4 = org.jivesoftware.smack.util.FileUtils.getStreamForClasspathFile(r4, r1)     // Catch:{ Exception -> 0x002c, all -> 0x0029 }
            java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ Exception -> 0x002c, all -> 0x0029 }
            r3.<init>(r4, r5)     // Catch:{ Exception -> 0x002c, all -> 0x0029 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x002c, all -> 0x0029 }
            java.lang.String r3 = r2.readLine()     // Catch:{ Exception -> 0x0027 }
            org.jivesoftware.smack.util.CloseableUtil.maybeClose(r2, r0)
            goto L_0x003d
        L_0x0027:
            r0 = move-exception
            goto L_0x002e
        L_0x0029:
            r0 = move-exception
            goto L_0x011c
        L_0x002c:
            r0 = move-exception
            r2 = r1
        L_0x002e:
            java.util.logging.Logger r3 = LOGGER     // Catch:{ all -> 0x011a }
            java.util.logging.Level r4 = java.util.logging.Level.SEVERE     // Catch:{ all -> 0x011a }
            java.lang.String r5 = "Could not determine Smack version"
            r3.log(r4, r5, r0)     // Catch:{ all -> 0x011a }
            java.lang.String r0 = "unknown"
            org.jivesoftware.smack.util.CloseableUtil.maybeClose(r2, r3)
            r3 = r0
        L_0x003d:
            SMACK_VERSION = r3
            java.lang.String r0 = "smack.disabledClasses"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            if (r0 == 0) goto L_0x005b
            java.lang.String r2 = ","
            java.lang.String[] r0 = r0.split(r2)
            int r2 = r0.length
            r3 = 0
        L_0x004f:
            if (r3 >= r2) goto L_0x005b
            r4 = r0[r3]
            java.util.Set<java.lang.String> r5 = org.jivesoftware.smack.SmackConfiguration.disabledSmackClasses
            r5.add(r4)
            int r3 = r3 + 1
            goto L_0x004f
        L_0x005b:
            java.lang.String r0 = "org.jivesoftware.smack/smack-config.xml"
            java.io.InputStream r0 = org.jivesoftware.smack.util.FileUtils.getStreamForClasspathFile(r0, r1)     // Catch:{ Exception -> 0x0111 }
            processConfigFile(r0, r1)     // Catch:{ Exception -> 0x0108 }
            org.jivesoftware.smack.compression.Java7ZlibInputOutputStream r0 = new org.jivesoftware.smack.compression.Java7ZlibInputOutputStream
            r0.<init>()
            org.jivesoftware.smack.SmackConfiguration.addCompressionHandler(r0)
            org.jivesoftware.smack.compression.zlib.ZlibXmppCompressionFactory r0 = org.jivesoftware.smack.compression.zlib.ZlibXmppCompressionFactory.INSTANCE
            org.jivesoftware.smack.compression.XmppCompressionManager.registerXmppCompressionFactory(r0)
            r0 = 1
            java.lang.String r1 = "smack.debugEnabled"
            boolean r1 = java.lang.Boolean.getBoolean(r1)     // Catch:{ Exception -> 0x007d }
            if (r1 == 0) goto L_0x0087
            org.jivesoftware.smack.SmackConfiguration.DEBUG = r0     // Catch:{ Exception -> 0x007d }
            goto L_0x0087
        L_0x007d:
            r1 = move-exception
            java.util.logging.Logger r2 = LOGGER
            java.util.logging.Level r3 = java.util.logging.Level.FINE
            java.lang.String r4 = "Could not handle debugEnable property on Smack initialization"
            r2.log(r3, r4, r1)
        L_0x0087:
            org.jivesoftware.smack.sasl.core.SCRAMSHA1Mechanism r1 = new org.jivesoftware.smack.sasl.core.SCRAMSHA1Mechanism
            r1.<init>()
            org.jivesoftware.smack.SASLAuthentication.registerSASLMechanism(r1)
            org.jivesoftware.smack.sasl.core.ScramSha1PlusMechanism r1 = new org.jivesoftware.smack.sasl.core.ScramSha1PlusMechanism
            r1.<init>()
            org.jivesoftware.smack.SASLAuthentication.registerSASLMechanism(r1)
            org.jivesoftware.smack.sasl.core.SASLXOauth2Mechanism r1 = new org.jivesoftware.smack.sasl.core.SASLXOauth2Mechanism
            r1.<init>()
            org.jivesoftware.smack.SASLAuthentication.registerSASLMechanism(r1)
            org.jivesoftware.smack.sasl.core.SASLAnonymous r1 = new org.jivesoftware.smack.sasl.core.SASLAnonymous
            r1.<init>()
            org.jivesoftware.smack.SASLAuthentication.registerSASLMechanism(r1)
            org.jivesoftware.smack.provider.BindIQProvider r1 = new org.jivesoftware.smack.provider.BindIQProvider
            r1.<init>()
            java.lang.String r2 = "bind"
            java.lang.String r3 = "urn:ietf:params:xml:ns:xmpp-bind"
            org.jivesoftware.smack.provider.ProviderManager.addIQProvider(r2, r3, r1)
            org.jivesoftware.smack.provider.BodyElementProvider r1 = new org.jivesoftware.smack.provider.BodyElementProvider
            r1.<init>()
            java.lang.String r2 = "body"
            java.lang.String r3 = "jabber:client"
            org.jivesoftware.smack.provider.ProviderManager.addExtensionProvider(r2, r3, r1)
            org.jivesoftware.smack.provider.MessageThreadElementProvider r1 = new org.jivesoftware.smack.provider.MessageThreadElementProvider
            r1.<init>()
            java.lang.String r2 = "thread"
            org.jivesoftware.smack.provider.ProviderManager.addExtensionProvider(r2, r3, r1)
            org.jivesoftware.smack.provider.MessageSubjectElementProvider r1 = new org.jivesoftware.smack.provider.MessageSubjectElementProvider
            r1.<init>()
            java.lang.String r2 = "subject"
            org.jivesoftware.smack.provider.ProviderManager.addExtensionProvider(r2, r3, r1)
            org.jivesoftware.smack.provider.SaslChallengeProvider r1 = org.jivesoftware.smack.provider.SaslChallengeProvider.INSTANCE
            org.jivesoftware.smack.provider.ProviderManager.addNonzaProvider(r1)
            org.jivesoftware.smack.provider.SaslSuccessProvider r1 = org.jivesoftware.smack.provider.SaslSuccessProvider.INSTANCE
            org.jivesoftware.smack.provider.ProviderManager.addNonzaProvider(r1)
            org.jivesoftware.smack.provider.SaslFailureProvider r1 = org.jivesoftware.smack.provider.SaslFailureProvider.INSTANCE
            org.jivesoftware.smack.provider.ProviderManager.addNonzaProvider(r1)
            org.jivesoftware.smack.provider.TlsProceedProvider r1 = org.jivesoftware.smack.provider.TlsProceedProvider.INSTANCE
            org.jivesoftware.smack.provider.ProviderManager.addNonzaProvider(r1)
            org.jivesoftware.smack.provider.TlsFailureProvider r1 = org.jivesoftware.smack.provider.TlsFailureProvider.INSTANCE
            org.jivesoftware.smack.provider.ProviderManager.addNonzaProvider(r1)
            org.jivesoftware.smack.compress.provider.CompressedProvider r1 = org.jivesoftware.smack.compress.provider.CompressedProvider.INSTANCE
            org.jivesoftware.smack.provider.ProviderManager.addNonzaProvider(r1)
            org.jivesoftware.smack.compress.provider.FailureProvider r1 = org.jivesoftware.smack.compress.provider.FailureProvider.INSTANCE
            org.jivesoftware.smack.provider.ProviderManager.addNonzaProvider(r1)
            java.lang.Class<org.jivesoftware.smack.bind2.Bind2ModuleDescriptor> r1 = org.jivesoftware.smack.bind2.Bind2ModuleDescriptor.class
            org.jivesoftware.smack.SmackConfiguration.addModule(r1)
            java.lang.Class<org.jivesoftware.smack.compression.CompressionModuleDescriptor> r1 = org.jivesoftware.smack.compression.CompressionModuleDescriptor.class
            org.jivesoftware.smack.SmackConfiguration.addModule(r1)
            java.lang.Class<org.jivesoftware.smack.isr.InstantStreamResumptionModuleDescriptor> r1 = org.jivesoftware.smack.isr.InstantStreamResumptionModuleDescriptor.class
            org.jivesoftware.smack.SmackConfiguration.addModule(r1)
            org.jivesoftware.smack.SmackConfiguration.smackInitialized = r0
            return
        L_0x0108:
            r0 = move-exception
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Could not parse Smack configuration file"
            r1.<init>(r2, r0)
            throw r1
        L_0x0111:
            r0 = move-exception
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Could not load Smack configuration file"
            r1.<init>(r2, r0)
            throw r1
        L_0x011a:
            r0 = move-exception
            r1 = r2
        L_0x011c:
            java.util.logging.Logger r2 = LOGGER
            org.jivesoftware.smack.util.CloseableUtil.maybeClose(r1, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.SmackInitialization.<clinit>():void");
    }

    private static void loadSmackClass(String str, boolean z10, ClassLoader classLoader) throws Exception {
        Level level;
        try {
            Class<?> cls = Class.forName(str, true, classLoader);
            if (SmackInitializer.class.isAssignableFrom(cls)) {
                List<Exception> initialize = ((SmackInitializer) cls.getConstructor(new Class[0]).newInstance(new Object[0])).initialize();
                if (initialize == null || initialize.size() == 0) {
                    Logger logger = LOGGER;
                    Level level2 = Level.FINE;
                    logger.log(level2, "Loaded SmackInitializer " + str);
                    return;
                }
                for (Exception log : initialize) {
                    LOGGER.log(Level.SEVERE, "Exception in loadSmackClass", log);
                }
                return;
            }
            Logger logger2 = LOGGER;
            Level level3 = Level.FINE;
            logger2.log(level3, "Loaded " + str);
        } catch (ClassNotFoundException e10) {
            if (z10) {
                level = Level.FINE;
            } else {
                level = Level.WARNING;
            }
            Logger logger3 = LOGGER;
            logger3.log(level, "A startup class '" + str + "' could not be loaded.");
            if (!z10) {
                throw e10;
            }
        }
    }

    private static void parseClassesToLoad(XmlPullParser xmlPullParser, boolean z10, Collection<Exception> collection, ClassLoader classLoader) throws Exception {
        String name = xmlPullParser.getName();
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT && "className".equals(xmlPullParser.getName())) {
                String nextText = xmlPullParser.nextText();
                if (!SmackConfiguration.isDisabledSmackClass(nextText)) {
                    try {
                        loadSmackClass(nextText, z10, classLoader);
                    } catch (Exception e10) {
                        if (collection != null) {
                            collection.add(e10);
                        } else {
                            throw e10;
                        }
                    }
                }
            }
            if (next == XmlPullParser.Event.END_ELEMENT && name.equals(xmlPullParser.getName())) {
                return;
            }
        }
    }

    public static void processConfigFile(InputStream inputStream, Collection<Exception> collection) throws Exception {
        processConfigFile(inputStream, collection, SmackInitialization.class.getClassLoader());
    }

    public static void processConfigFile(InputStream inputStream, Collection<Exception> collection, ClassLoader classLoader) throws Exception {
        XmlPullParser parserFor = PacketParserUtils.getParserFor(inputStream);
        XmlPullParser.Event eventType = parserFor.getEventType();
        do {
            if (eventType == XmlPullParser.Event.START_ELEMENT) {
                if (parserFor.getName().equals("startupClasses")) {
                    parseClassesToLoad(parserFor, false, collection, classLoader);
                } else if (parserFor.getName().equals("optionalStartupClasses")) {
                    parseClassesToLoad(parserFor, true, collection, classLoader);
                }
            }
            eventType = parserFor.next();
        } while (eventType != XmlPullParser.Event.END_DOCUMENT);
        CloseableUtil.maybeClose(inputStream, LOGGER);
    }
}
