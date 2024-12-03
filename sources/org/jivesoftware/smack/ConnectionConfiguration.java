package org.jivesoftware.smack;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import net.bytebuddy.utility.JavaConstant;
import org.apache.commons.cli.HelpFormatter;
import org.jivesoftware.smack.datatypes.UInt16;
import org.jivesoftware.smack.debugger.SmackDebuggerFactory;
import org.jivesoftware.smack.internal.SmackTlsContext;
import org.jivesoftware.smack.packet.id.StandardStanzaIdSource;
import org.jivesoftware.smack.packet.id.StanzaIdSource;
import org.jivesoftware.smack.packet.id.StanzaIdSourceFactory;
import org.jivesoftware.smack.proxy.ProxyInfo;
import org.jivesoftware.smack.sasl.core.SASLAnonymous;
import org.jivesoftware.smack.util.CloseableUtil;
import org.jivesoftware.smack.util.CollectionUtil;
import org.jivesoftware.smack.util.DNSUtil;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.SslContextFactory;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.TLSUtils;
import org.jivesoftware.smack.util.dns.SmackDaneProvider;
import org.jivesoftware.smack.util.dns.SmackDaneVerifier;
import org.jxmpp.jid.DomainBareJid;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.impl.a;
import org.jxmpp.jid.parts.Resourcepart;
import org.jxmpp.stringprep.XmppStringprepException;
import org.minidns.dnsname.DnsName;
import org.minidns.dnsname.InvalidDnsNameException;
import zm.e;

public abstract class ConnectionConfiguration {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    /* access modifiers changed from: private */
    public static final Logger LOGGER = Logger.getLogger(ConnectionConfiguration.class.getName());
    protected final boolean allowNullOrEmptyUsername;
    private final EntityBareJid authzid;
    private final CallbackHandler callbackHandler;
    private final boolean compressionEnabled;
    private final SmackDebuggerFactory debuggerFactory;
    private final DnssecMode dnssecMode;
    private final String[] enabledSSLCiphers;
    private final String[] enabledSSLProtocols;
    private final Set<String> enabledSaslMechanisms;
    protected final DnsName host;
    protected final InetAddress hostAddress;
    private final HostnameVerifier hostnameVerifier;
    private final Locale language;
    private final String password;
    protected final UInt16 port;
    protected final ProxyInfo proxy;
    private final Resourcepart resource;
    private final SecurityMode securityMode;
    private final boolean sendPresence;
    final SmackTlsContext smackTlsContext;
    private final SocketFactory socketFactory;
    private final StanzaIdSourceFactory stanzaIdSourceFactory;
    private final CharSequence username;
    protected final DomainBareJid xmppServiceDomain;
    protected final DnsName xmppServiceDomainDnsName;

    public static abstract class Builder<B extends Builder<B, C>, C extends ConnectionConfiguration> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        /* access modifiers changed from: private */
        public boolean allowEmptyOrNullUsername = false;
        /* access modifiers changed from: private */
        public EntityBareJid authzid;
        /* access modifiers changed from: private */
        public CallbackHandler callbackHandler;
        /* access modifiers changed from: private */
        public boolean compressionEnabled = false;
        /* access modifiers changed from: private */
        public X509TrustManager customX509TrustManager;
        /* access modifiers changed from: private */
        public SmackDebuggerFactory debuggerFactory;
        /* access modifiers changed from: private */
        public DnssecMode dnssecMode = DnssecMode.disabled;
        /* access modifiers changed from: private */
        public String[] enabledSSLCiphers;
        /* access modifiers changed from: private */
        public String[] enabledSSLProtocols;
        /* access modifiers changed from: private */
        public Set<String> enabledSaslMechanisms;
        /* access modifiers changed from: private */
        public DnsName host;
        /* access modifiers changed from: private */
        public InetAddress hostAddress;
        /* access modifiers changed from: private */
        public HostnameVerifier hostnameVerifier;
        /* access modifiers changed from: private */
        public KeyManager[] keyManagers;
        /* access modifiers changed from: private */
        public String keystorePath;
        /* access modifiers changed from: private */
        public String keystoreType;
        /* access modifiers changed from: private */
        public Locale language = Locale.getDefault();
        /* access modifiers changed from: private */
        public String password;
        /* access modifiers changed from: private */
        public String pkcs11Library = "pkcs11.config";
        /* access modifiers changed from: private */
        public UInt16 port = UInt16.from(5222);
        /* access modifiers changed from: private */
        public ProxyInfo proxy;
        /* access modifiers changed from: private */
        public Resourcepart resource;
        private boolean saslMechanismsSealed;
        /* access modifiers changed from: private */
        public SecurityMode securityMode = SecurityMode.required;
        /* access modifiers changed from: private */
        public boolean sendPresence = true;
        /* access modifiers changed from: private */
        public SocketFactory socketFactory;
        /* access modifiers changed from: private */
        public SslContextFactory sslContextFactory;
        /* access modifiers changed from: private */
        public SecureRandom sslContextSecureRandom;
        /* access modifiers changed from: private */
        public StanzaIdSourceFactory stanzaIdSourceFactory = new StandardStanzaIdSource.Factory();
        /* access modifiers changed from: private */
        public CharSequence username;
        /* access modifiers changed from: private */
        public DomainBareJid xmppServiceDomain;

        protected Builder() {
            if (SmackConfiguration.DEBUG) {
                enableDefaultDebugger();
            }
        }

        public static KeyManager[] getKeyManagersFrom(String str, String str2, CallbackHandler callbackHandler2, String str3) throws NoSuchMethodException, SecurityException, ClassNotFoundException, KeyStoreException, NoSuchProviderException, NoSuchAlgorithmException, CertificateException, IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, UnsupportedCallbackException, UnrecoverableKeyException {
            PasswordCallback passwordCallback;
            KeyStore keyStore;
            KeyManagerFactory instance;
            if ("PKCS11".equals(str)) {
                Provider provider = (Provider) Class.forName("sun.security.pkcs11.SunPKCS11").getConstructor(new Class[]{InputStream.class}).newInstance(new Object[]{new ByteArrayInputStream(("name = SmartCard\nlibrary = " + str3).getBytes(StandardCharsets.UTF_8))});
                Security.addProvider(provider);
                keyStore = KeyStore.getInstance("PKCS11", provider);
                passwordCallback = new PasswordCallback("PKCS11 Password: ", false);
                callbackHandler2.handle(new Callback[]{passwordCallback});
                keyStore.load((InputStream) null, passwordCallback.getPassword());
            } else {
                if ("Apple".equals(str)) {
                    keyStore = KeyStore.getInstance("KeychainStore", "Apple");
                    keyStore.load((InputStream) null, (char[]) null);
                } else if (str != null) {
                    keyStore = KeyStore.getInstance(str);
                    if (callbackHandler2 == null || !StringUtils.isNotEmpty((CharSequence) str2)) {
                        FileInputStream defaultTruststoreStreamIfPossible = TLSUtils.getDefaultTruststoreStreamIfPossible();
                        try {
                            keyStore.load(defaultTruststoreStreamIfPossible, "changeit".toCharArray());
                            CloseableUtil.maybeClose(defaultTruststoreStreamIfPossible);
                        } catch (IOException e10) {
                            ConnectionConfiguration.LOGGER.log(Level.FINE, "KeyStore load() threw, attempting 'jks' fallback", e10);
                            keyStore = KeyStore.getInstance("jks");
                            defaultTruststoreStreamIfPossible = TLSUtils.getDefaultTruststoreStreamIfPossible();
                            try {
                                keyStore.load(defaultTruststoreStreamIfPossible, (char[]) null);
                            } finally {
                                CloseableUtil.maybeClose(defaultTruststoreStreamIfPossible);
                            }
                        } finally {
                        }
                    } else {
                        PasswordCallback passwordCallback2 = new PasswordCallback("Keystore Password: ", false);
                        callbackHandler2.handle(new Callback[]{passwordCallback2});
                        keyStore.load(new FileInputStream(str2), passwordCallback2.getPassword());
                        passwordCallback = passwordCallback2;
                    }
                } else {
                    keyStore = null;
                    passwordCallback = null;
                }
                passwordCallback = null;
            }
            if (keyStore == null || (instance = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm())) == null) {
                return null;
            }
            if (passwordCallback == null) {
                instance.init(keyStore, (char[]) null);
            } else {
                instance.init(keyStore, passwordCallback.getPassword());
                passwordCallback.clearPassword();
            }
            return instance.getKeyManagers();
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ SSLContext lambda$setCustomSSLContext$0(SSLContext sSLContext) {
            return sSLContext;
        }

        private void throwIfEnabledSaslMechanismsSet() {
            if (this.enabledSaslMechanisms != null) {
                throw new IllegalStateException("Enabled SASL mechanisms found");
            }
        }

        public B addEnabledSaslMechanism(String str) {
            return addEnabledSaslMechanism((Collection<String>) Arrays.asList(new String[]{(String) StringUtils.requireNotNullNorEmpty(str, "saslMechanism must not be null nor empty")}));
        }

        public B allowEmptyOrNullUsernames() {
            this.allowEmptyOrNullUsername = true;
            return getThis();
        }

        public abstract C build();

        public B enableDefaultDebugger() {
            this.debuggerFactory = SmackConfiguration.getDefaultSmackDebuggerFactory();
            return getThis();
        }

        /* access modifiers changed from: protected */
        public abstract B getThis();

        public B performSaslAnonymousAuthentication() {
            if (SASLAuthentication.isSaslMechanismRegistered(SASLAnonymous.NAME)) {
                throwIfEnabledSaslMechanismsSet();
                allowEmptyOrNullUsernames();
                addEnabledSaslMechanism(SASLAnonymous.NAME);
                this.saslMechanismsSealed = true;
                return getThis();
            }
            throw new IllegalArgumentException("SASL ANONYMOUS is not registered");
        }

        public B performSaslExternalAuthentication(SSLContext sSLContext) {
            if (SASLAuthentication.isSaslMechanismRegistered("EXTERNAL")) {
                setCustomSSLContext(sSLContext);
                throwIfEnabledSaslMechanismsSet();
                allowEmptyOrNullUsernames();
                setSecurityMode(SecurityMode.required);
                addEnabledSaslMechanism("EXTERNAL");
                this.saslMechanismsSealed = true;
                return getThis();
            }
            throw new IllegalArgumentException("SASL EXTERNAL is not registered");
        }

        public B setAuthzid(EntityBareJid entityBareJid) {
            this.authzid = entityBareJid;
            return getThis();
        }

        @Deprecated
        public B setCallbackHandler(CallbackHandler callbackHandler2) {
            this.callbackHandler = callbackHandler2;
            return getThis();
        }

        public B setCompressionEnabled(boolean z10) {
            this.compressionEnabled = z10;
            return getThis();
        }

        @Deprecated
        public B setCustomSSLContext(SSLContext sSLContext) {
            return setSslContextFactory(new k(sSLContext));
        }

        public B setCustomX509TrustManager(X509TrustManager x509TrustManager) {
            this.customX509TrustManager = x509TrustManager;
            return getThis();
        }

        public B setDebuggerFactory(SmackDebuggerFactory smackDebuggerFactory) {
            this.debuggerFactory = smackDebuggerFactory;
            return getThis();
        }

        public B setDnssecMode(DnssecMode dnssecMode2) {
            this.dnssecMode = (DnssecMode) Objects.requireNonNull(dnssecMode2, "DNSSEC mode must not be null");
            return getThis();
        }

        public B setEnabledSSLCiphers(String[] strArr) {
            this.enabledSSLCiphers = strArr;
            return getThis();
        }

        public B setEnabledSSLProtocols(String[] strArr) {
            this.enabledSSLProtocols = strArr;
            return getThis();
        }

        public B setHost(CharSequence charSequence) {
            String charSequence2 = charSequence.toString();
            if (e.c(charSequence2)) {
                try {
                    setHostAddress(InetAddress.getByName(charSequence2));
                } catch (UnknownHostException e10) {
                    throw new AssertionError(e10);
                }
            } else {
                setHost(DnsName.c(charSequence2));
            }
            return getThis();
        }

        public B setHostAddress(InetAddress inetAddress) {
            this.hostAddress = inetAddress;
            return getThis();
        }

        @Deprecated
        public B setHostAddressByNameOrIp(CharSequence charSequence) {
            return setHost(charSequence);
        }

        public B setHostnameVerifier(HostnameVerifier hostnameVerifier2) {
            this.hostnameVerifier = hostnameVerifier2;
            return getThis();
        }

        public B setKeyManager(KeyManager keyManager) {
            return setKeyManagers(new KeyManager[]{keyManager});
        }

        public B setKeyManagers(KeyManager[] keyManagerArr) {
            this.keyManagers = keyManagerArr;
            return getThis();
        }

        @Deprecated
        public B setKeystorePath(String str) {
            this.keystorePath = str;
            return getThis();
        }

        @Deprecated
        public B setKeystoreType(String str) {
            this.keystoreType = str;
            return getThis();
        }

        public B setLanguage(Locale locale) {
            this.language = locale;
            return getThis();
        }

        @Deprecated
        public B setPKCS11Library(String str) {
            this.pkcs11Library = str;
            return getThis();
        }

        public B setPort(int i10) {
            if (i10 >= 0 && i10 <= 65535) {
                return setPort(UInt16.from(i10));
            }
            throw new IllegalArgumentException("Port must be a 16-bit unsigned integer (i.e. between 0-65535. Port was: " + i10);
        }

        public B setProxyInfo(ProxyInfo proxyInfo) {
            this.proxy = proxyInfo;
            return getThis();
        }

        public B setResource(Resourcepart resourcepart) {
            this.resource = resourcepart;
            return getThis();
        }

        public B setSecurityMode(SecurityMode securityMode2) {
            this.securityMode = securityMode2;
            return getThis();
        }

        public B setSendPresence(boolean z10) {
            this.sendPresence = z10;
            return getThis();
        }

        @Deprecated
        public B setServiceName(DomainBareJid domainBareJid) {
            return setXmppDomain(domainBareJid);
        }

        public B setSocketFactory(SocketFactory socketFactory2) {
            this.socketFactory = socketFactory2;
            return getThis();
        }

        public B setSslContextFactory(SslContextFactory sslContextFactory2) {
            this.sslContextFactory = (SslContextFactory) Objects.requireNonNull(sslContextFactory2, "The provided SslContextFactory must not be null");
            return getThis();
        }

        public B setSslContextSecureRandom(SecureRandom secureRandom) {
            this.sslContextSecureRandom = secureRandom;
            return getThis();
        }

        public B setStanzaIdSourceFactory(StanzaIdSourceFactory stanzaIdSourceFactory2) {
            this.stanzaIdSourceFactory = (StanzaIdSourceFactory) Objects.requireNonNull(stanzaIdSourceFactory2);
            return getThis();
        }

        public B setUsernameAndPassword(CharSequence charSequence, String str) {
            this.username = charSequence;
            this.password = str;
            return getThis();
        }

        public B setXmppAddressAndPassword(CharSequence charSequence, String str) throws XmppStringprepException {
            return setXmppAddressAndPassword(a.g(charSequence), str);
        }

        public B setXmppDomain(DomainBareJid domainBareJid) {
            this.xmppServiceDomain = domainBareJid;
            return getThis();
        }

        public B addEnabledSaslMechanism(Collection<String> collection) {
            if (!this.saslMechanismsSealed) {
                CollectionUtil.requireNotEmpty(collection, "saslMechanisms");
                Set<String> blacklistedSASLMechanisms = SASLAuthentication.getBlacklistedSASLMechanisms();
                for (String next : collection) {
                    if (!SASLAuthentication.isSaslMechanismRegistered(next)) {
                        throw new IllegalArgumentException("SASL " + next + " is not available. Consider registering it with Smack");
                    } else if (blacklistedSASLMechanisms.contains(next)) {
                        throw new IllegalArgumentException("SALS " + next + " is blacklisted.");
                    }
                }
                if (this.enabledSaslMechanisms == null) {
                    this.enabledSaslMechanisms = new HashSet(collection.size());
                }
                this.enabledSaslMechanisms.addAll(collection);
                return getThis();
            }
            throw new IllegalStateException("The enabled SASL mechanisms are sealed, you can not add new ones");
        }

        public B setXmppAddressAndPassword(EntityBareJid entityBareJid, String str) {
            setUsernameAndPassword(entityBareJid.c1(), str);
            return setXmppDomain(entityBareJid.R0());
        }

        public B setResource(CharSequence charSequence) throws XmppStringprepException {
            Objects.requireNonNull(charSequence, "resource must not be null");
            return setResource(Resourcepart.b(charSequence.toString()));
        }

        public B setXmppDomain(String str) throws XmppStringprepException {
            this.xmppServiceDomain = a.e(str);
            return getThis();
        }

        public B setPort(UInt16 uInt16) {
            this.port = (UInt16) Objects.requireNonNull(uInt16);
            return getThis();
        }

        public B setHost(DnsName dnsName) {
            this.host = dnsName;
            return getThis();
        }
    }

    public enum DnssecMode {
        disabled,
        needsDnssec,
        needsDnssecAndDane
    }

    public enum SecurityMode {
        required,
        ifpossible,
        disabled
    }

    static {
        Smack.ensureInitialized();
    }

    protected ConnectionConfiguration(Builder<?, ?> builder) {
        DnsName dnsName;
        try {
            this.smackTlsContext = getSmackTlsContext(builder.dnssecMode, builder.sslContextFactory, builder.customX509TrustManager, builder.keyManagers, builder.sslContextSecureRandom, builder.keystoreType, builder.keystorePath, builder.callbackHandler, builder.pkcs11Library);
            this.authzid = builder.authzid;
            this.username = builder.username;
            this.password = builder.password;
            this.callbackHandler = builder.callbackHandler;
            this.resource = builder.resource;
            this.language = builder.language;
            DomainBareJid access$1400 = builder.xmppServiceDomain;
            this.xmppServiceDomain = access$1400;
            if (access$1400 != null) {
                try {
                    dnsName = DnsName.b(access$1400);
                } catch (InvalidDnsNameException e10) {
                    Logger logger = LOGGER;
                    Level level = Level.INFO;
                    logger.log(level, "Could not transform XMPP service domain '" + this.xmppServiceDomain + "' to a DNS name. TLS X.509 certificate validiation may not be possible.", e10);
                    dnsName = null;
                }
                this.xmppServiceDomainDnsName = dnsName;
                this.hostAddress = builder.hostAddress;
                this.host = builder.host;
                this.port = builder.port;
                this.proxy = builder.proxy;
                this.socketFactory = builder.socketFactory;
                this.dnssecMode = builder.dnssecMode;
                this.securityMode = builder.securityMode;
                this.enabledSSLProtocols = builder.enabledSSLProtocols;
                this.enabledSSLCiphers = builder.enabledSSLCiphers;
                this.hostnameVerifier = builder.hostnameVerifier;
                this.sendPresence = builder.sendPresence;
                this.debuggerFactory = builder.debuggerFactory;
                this.allowNullOrEmptyUsername = builder.allowEmptyOrNullUsername;
                this.enabledSaslMechanisms = builder.enabledSaslMechanisms;
                this.compressionEnabled = builder.compressionEnabled;
                this.stanzaIdSourceFactory = builder.stanzaIdSourceFactory;
                return;
            }
            throw new IllegalArgumentException("Must define the XMPP domain");
        } catch (IOException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException | KeyManagementException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableKeyException | CertificateException | UnsupportedCallbackException e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    private static SmackTlsContext getSmackTlsContext(DnssecMode dnssecMode2, SslContextFactory sslContextFactory, X509TrustManager x509TrustManager, KeyManager[] keyManagerArr, SecureRandom secureRandom, String str, String str2, CallbackHandler callbackHandler2, String str3) throws NoSuchAlgorithmException, CertificateException, IOException, KeyStoreException, NoSuchProviderException, UnrecoverableKeyException, KeyManagementException, UnsupportedCallbackException, NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        SSLContext sSLContext;
        if (sslContextFactory != null) {
            sSLContext = sslContextFactory.createSslContext();
        } else {
            sSLContext = SSLContext.getInstance(TLSUtils.TLS);
        }
        if (keyManagerArr == null) {
            keyManagerArr = Builder.getKeyManagersFrom(str, str2, callbackHandler2, str3);
        }
        SmackDaneVerifier smackDaneVerifier = null;
        if (dnssecMode2 == DnssecMode.needsDnssecAndDane) {
            SmackDaneProvider daneProvider = DNSUtil.getDaneProvider();
            if (daneProvider != null) {
                smackDaneVerifier = daneProvider.newInstance();
                if (smackDaneVerifier != null) {
                    smackDaneVerifier.init(sSLContext, keyManagerArr, x509TrustManager, secureRandom);
                } else {
                    throw new IllegalStateException("DANE requested but DANE provider did not return a DANE verifier");
                }
            } else {
                throw new UnsupportedOperationException("DANE enabled but no SmackDaneProvider configured");
            }
        } else {
            sSLContext.init(keyManagerArr, x509TrustManager != null ? new TrustManager[]{x509TrustManager} : null, secureRandom);
        }
        return new SmackTlsContext(sSLContext, smackDaneVerifier);
    }

    /* access modifiers changed from: package-private */
    public StanzaIdSource constructStanzaIdSource() {
        return this.stanzaIdSourceFactory.constructStanzaIdSource();
    }

    public EntityBareJid getAuthzid() {
        return this.authzid;
    }

    public CallbackHandler getCallbackHandler() {
        return this.callbackHandler;
    }

    public SmackDebuggerFactory getDebuggerFactory() {
        return this.debuggerFactory;
    }

    public DnssecMode getDnssecMode() {
        return this.dnssecMode;
    }

    public String[] getEnabledSSLCiphers() {
        return this.enabledSSLCiphers;
    }

    public String[] getEnabledSSLProtocols() {
        return this.enabledSSLProtocols;
    }

    public Set<String> getEnabledSaslMechanisms() {
        Set<String> set = this.enabledSaslMechanisms;
        if (set == null) {
            return null;
        }
        return Collections.unmodifiableSet(set);
    }

    public DnsName getHost() {
        return this.host;
    }

    public InetAddress getHostAddress() {
        return this.hostAddress;
    }

    public HostnameVerifier getHostnameVerifier() {
        HostnameVerifier hostnameVerifier2 = this.hostnameVerifier;
        if (hostnameVerifier2 != null) {
            return hostnameVerifier2;
        }
        return SmackConfiguration.getDefaultHostnameVerifier();
    }

    public Locale getLanguage() {
        return this.language;
    }

    public String getPassword() {
        return this.password;
    }

    public UInt16 getPort() {
        return this.port;
    }

    public ProxyInfo getProxyInfo() {
        return this.proxy;
    }

    public Resourcepart getResource() {
        return this.resource;
    }

    public SecurityMode getSecurityMode() {
        return this.securityMode;
    }

    @Deprecated
    public DomainBareJid getServiceName() {
        return this.xmppServiceDomain;
    }

    public SocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    public CharSequence getUsername() {
        return this.username;
    }

    public DomainBareJid getXMPPServiceDomain() {
        return this.xmppServiceDomain;
    }

    public String getXmlLang() {
        Locale locale = this.language;
        if (locale != null) {
            return locale.toString().replace(JavaConstant.Dynamic.DEFAULT_NAME, HelpFormatter.DEFAULT_OPT_PREFIX);
        }
        return null;
    }

    public DnsName getXmppServiceDomainAsDnsNameIfPossible() {
        return this.xmppServiceDomainDnsName;
    }

    public boolean isCompressionEnabled() {
        return this.compressionEnabled;
    }

    public boolean isEnabledSaslMechanism(String str) {
        Set<String> set = this.enabledSaslMechanisms;
        if (set == null) {
            return !SASLAuthentication.getBlacklistedSASLMechanisms().contains(str);
        }
        return set.contains(str);
    }

    public boolean isSendPresence() {
        return this.sendPresence;
    }
}
