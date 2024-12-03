package io.sentry;

import com.coffeemeetsbagel.models.util.FacebookParse;
import io.sentry.clientreport.h;
import io.sentry.protocol.m;
import io.sentry.protocol.v;
import io.sentry.transport.q;
import io.sentry.transport.r;
import io.sentry.transport.t;
import io.sentry.util.n;
import io.sentry.util.o;
import io.sentry.util.p;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import org.jetbrains.annotations.ApiStatus;

public class SentryOptions {
    static final SentryLevel DEFAULT_DIAGNOSTIC_LEVEL = SentryLevel.DEBUG;
    private static final String DEFAULT_ENVIRONMENT = "production";
    private boolean attachServerName;
    private boolean attachStacktrace;
    private boolean attachThreads;
    private a beforeBreadcrumb;
    private b beforeSend;
    private c beforeSendTransaction;
    private String cacheDirPath;
    io.sentry.clientreport.f clientReportRecorder;
    private final List<d0> collectors;
    private int connectionTimeoutMillis;
    private final List<String> contextTags;
    @ApiStatus.Internal
    private v2 dateProvider;
    private boolean debug;
    private final List<String> defaultTracePropagationTargets;
    private SentryLevel diagnosticLevel;
    private String dist;
    private String distinctId;
    private String dsn;
    private String dsnHash;
    private boolean enableAutoSessionTracking;
    private boolean enableDeduplication;
    private boolean enableExternalConfiguration;
    private boolean enableNdk;
    private boolean enableScopeSync;
    private boolean enableShutdownHook;
    private boolean enableTimeToFullDisplayTracing;
    private Boolean enableTracing;
    private boolean enableUncaughtExceptionHandler;
    private boolean enableUserInteractionBreadcrumbs;
    private boolean enableUserInteractionTracing;
    private io.sentry.cache.e envelopeDiskCache;
    private e0 envelopeReader;
    private String environment;
    private final List<t> eventProcessors;
    private k0 executorService;
    private long flushTimeoutMillis;
    private final v fullyDisplayedReporter;
    private final List<io.sentry.internal.gestures.a> gestureTargetLocators;
    private HostnameVerifier hostnameVerifier;
    private Long idleTimeout;
    private final Set<Class<? extends Throwable>> ignoredExceptionsForType;
    private final List<String> inAppExcludes;
    private final List<String> inAppIncludes;
    private Instrumenter instrumenter;
    private final List<Integration> integrations;
    private h0 logger;
    private io.sentry.util.thread.a mainThreadChecker;
    private long maxAttachmentSize;
    private int maxBreadcrumbs;
    private int maxCacheItems;
    private int maxDepth;
    private int maxQueueSize;
    private RequestSize maxRequestBodySize;
    private int maxSpans;
    private long maxTraceFileSize;
    private io.sentry.internal.modules.b modulesLoader;
    private final List<i0> observers;
    private boolean printUncaughtStackTrace;
    private Double profilesSampleRate;
    private d profilesSampler;
    private String proguardUuid;
    private e proxy;
    private int readTimeoutMillis;
    private String release;
    private Double sampleRate;
    private m sdkVersion;
    private boolean sendClientReports;
    private boolean sendDefaultPii;
    private String sentryClientName;
    private l0 serializer;
    private String serverName;
    private long sessionTrackingIntervalMillis;
    private long shutdownTimeoutMillis;
    private SSLSocketFactory sslSocketFactory;
    private final Map<String, String> tags;
    private boolean traceOptionsRequests;
    private List<String> tracePropagationTargets;
    private boolean traceSampling;
    private Double tracesSampleRate;
    private f tracesSampler;
    private v4 transactionPerformanceCollector;
    private o0 transactionProfiler;
    private p0 transportFactory;
    private q transportGate;

    public enum RequestSize {
        NONE,
        SMALL,
        MEDIUM,
        ALWAYS
    }

    public interface a {
        d a(d dVar, w wVar);
    }

    public interface b {
        p3 a(p3 p3Var, w wVar);
    }

    public interface c {
        v a(v vVar, w wVar);
    }

    public interface d {
        Double a(d2 d2Var);
    }

    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        private String f30785a;

        /* renamed from: b  reason: collision with root package name */
        private String f30786b;

        /* renamed from: c  reason: collision with root package name */
        private String f30787c;

        /* renamed from: d  reason: collision with root package name */
        private String f30788d;

        public e(String str, String str2, String str3, String str4) {
            this.f30785a = str;
            this.f30786b = str2;
            this.f30787c = str3;
            this.f30788d = str4;
        }

        public String a() {
            return this.f30785a;
        }

        public String b() {
            return this.f30788d;
        }

        public String c() {
            return this.f30786b;
        }

        public String d() {
            return this.f30787c;
        }
    }

    public interface f {
        Double a(d2 d2Var);
    }

    public SentryOptions() {
        this(false);
    }

    private void addPackageInfo() {
        u3.c().b("maven:io.sentry:sentry", "6.17.0");
    }

    private m createSdkVersion() {
        m mVar = new m("sentry.java", "6.17.0");
        mVar.j("6.17.0");
        return mVar;
    }

    static SentryOptions empty() {
        return new SentryOptions(true);
    }

    @ApiStatus.Internal
    public void addCollector(d0 d0Var) {
        this.collectors.add(d0Var);
    }

    public void addContextTag(String str) {
        this.contextTags.add(str);
    }

    public void addEventProcessor(t tVar) {
        this.eventProcessors.add(tVar);
    }

    public void addIgnoredExceptionForType(Class<? extends Throwable> cls) {
        this.ignoredExceptionsForType.add(cls);
    }

    public void addInAppExclude(String str) {
        this.inAppExcludes.add(str);
    }

    public void addInAppInclude(String str) {
        this.inAppIncludes.add(str);
    }

    public void addIntegration(Integration integration) {
        this.integrations.add(integration);
    }

    public void addScopeObserver(i0 i0Var) {
        this.observers.add(i0Var);
    }

    @Deprecated
    public void addTracingOrigin(String str) {
        if (this.tracePropagationTargets == null) {
            this.tracePropagationTargets = new CopyOnWriteArrayList();
        }
        if (!str.isEmpty()) {
            this.tracePropagationTargets.add(str);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean containsIgnoredExceptionForType(Throwable th2) {
        return this.ignoredExceptionsForType.contains(th2.getClass());
    }

    public a getBeforeBreadcrumb() {
        return this.beforeBreadcrumb;
    }

    public b getBeforeSend() {
        return this.beforeSend;
    }

    public c getBeforeSendTransaction() {
        return this.beforeSendTransaction;
    }

    public String getCacheDirPath() {
        String str = this.cacheDirPath;
        if (str == null || str.isEmpty()) {
            return null;
        }
        if (this.dsnHash != null) {
            return new File(this.cacheDirPath, this.dsnHash).getAbsolutePath();
        }
        return this.cacheDirPath;
    }

    @ApiStatus.Internal
    public io.sentry.clientreport.f getClientReportRecorder() {
        return this.clientReportRecorder;
    }

    @ApiStatus.Internal
    public List<d0> getCollectors() {
        return this.collectors;
    }

    public int getConnectionTimeoutMillis() {
        return this.connectionTimeoutMillis;
    }

    public List<String> getContextTags() {
        return this.contextTags;
    }

    @ApiStatus.Internal
    public v2 getDateProvider() {
        return this.dateProvider;
    }

    public SentryLevel getDiagnosticLevel() {
        return this.diagnosticLevel;
    }

    public String getDist() {
        return this.dist;
    }

    @ApiStatus.Internal
    public String getDistinctId() {
        return this.distinctId;
    }

    public String getDsn() {
        return this.dsn;
    }

    public Boolean getEnableTracing() {
        return this.enableTracing;
    }

    public io.sentry.cache.e getEnvelopeDiskCache() {
        return this.envelopeDiskCache;
    }

    public e0 getEnvelopeReader() {
        return this.envelopeReader;
    }

    public String getEnvironment() {
        String str = this.environment;
        return str != null ? str : DEFAULT_ENVIRONMENT;
    }

    public List<t> getEventProcessors() {
        return this.eventProcessors;
    }

    @ApiStatus.Internal
    public k0 getExecutorService() {
        return this.executorService;
    }

    public long getFlushTimeoutMillis() {
        return this.flushTimeoutMillis;
    }

    @ApiStatus.Internal
    public v getFullyDisplayedReporter() {
        return this.fullyDisplayedReporter;
    }

    public List<io.sentry.internal.gestures.a> getGestureTargetLocators() {
        return this.gestureTargetLocators;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public Long getIdleTimeout() {
        return this.idleTimeout;
    }

    public Set<Class<? extends Throwable>> getIgnoredExceptionsForType() {
        return this.ignoredExceptionsForType;
    }

    public List<String> getInAppExcludes() {
        return this.inAppExcludes;
    }

    public List<String> getInAppIncludes() {
        return this.inAppIncludes;
    }

    public Instrumenter getInstrumenter() {
        return this.instrumenter;
    }

    public List<Integration> getIntegrations() {
        return this.integrations;
    }

    public h0 getLogger() {
        return this.logger;
    }

    public io.sentry.util.thread.a getMainThreadChecker() {
        return this.mainThreadChecker;
    }

    public long getMaxAttachmentSize() {
        return this.maxAttachmentSize;
    }

    public int getMaxBreadcrumbs() {
        return this.maxBreadcrumbs;
    }

    public int getMaxCacheItems() {
        return this.maxCacheItems;
    }

    public int getMaxDepth() {
        return this.maxDepth;
    }

    public int getMaxQueueSize() {
        return this.maxQueueSize;
    }

    public RequestSize getMaxRequestBodySize() {
        return this.maxRequestBodySize;
    }

    @ApiStatus.Experimental
    public int getMaxSpans() {
        return this.maxSpans;
    }

    public long getMaxTraceFileSize() {
        return this.maxTraceFileSize;
    }

    @ApiStatus.Internal
    public io.sentry.internal.modules.b getModulesLoader() {
        return this.modulesLoader;
    }

    public String getOutboxPath() {
        String cacheDirPath2 = getCacheDirPath();
        if (cacheDirPath2 == null) {
            return null;
        }
        return new File(cacheDirPath2, "outbox").getAbsolutePath();
    }

    public Double getProfilesSampleRate() {
        return this.profilesSampleRate;
    }

    public d getProfilesSampler() {
        return this.profilesSampler;
    }

    public String getProfilingTracesDirPath() {
        String cacheDirPath2 = getCacheDirPath();
        if (cacheDirPath2 == null) {
            return null;
        }
        return new File(cacheDirPath2, "profiling_traces").getAbsolutePath();
    }

    public String getProguardUuid() {
        return this.proguardUuid;
    }

    public e getProxy() {
        return this.proxy;
    }

    public int getReadTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    public String getRelease() {
        return this.release;
    }

    public Double getSampleRate() {
        return this.sampleRate;
    }

    /* access modifiers changed from: package-private */
    public List<i0> getScopeObservers() {
        return this.observers;
    }

    public m getSdkVersion() {
        return this.sdkVersion;
    }

    public String getSentryClientName() {
        return this.sentryClientName;
    }

    public l0 getSerializer() {
        return this.serializer;
    }

    public String getServerName() {
        return this.serverName;
    }

    public long getSessionTrackingIntervalMillis() {
        return this.sessionTrackingIntervalMillis;
    }

    @Deprecated
    @ApiStatus.ScheduledForRemoval
    public long getShutdownTimeout() {
        return this.shutdownTimeoutMillis;
    }

    public long getShutdownTimeoutMillis() {
        return this.shutdownTimeoutMillis;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    public Map<String, String> getTags() {
        return this.tags;
    }

    public List<String> getTracePropagationTargets() {
        List<String> list = this.tracePropagationTargets;
        if (list == null) {
            return this.defaultTracePropagationTargets;
        }
        return list;
    }

    public Double getTracesSampleRate() {
        return this.tracesSampleRate;
    }

    public f getTracesSampler() {
        return this.tracesSampler;
    }

    @Deprecated
    public List<String> getTracingOrigins() {
        return getTracePropagationTargets();
    }

    @ApiStatus.Internal
    public v4 getTransactionPerformanceCollector() {
        return this.transactionPerformanceCollector;
    }

    public o0 getTransactionProfiler() {
        return this.transactionProfiler;
    }

    public p0 getTransportFactory() {
        return this.transportFactory;
    }

    public q getTransportGate() {
        return this.transportGate;
    }

    public boolean isAttachServerName() {
        return this.attachServerName;
    }

    public boolean isAttachStacktrace() {
        return this.attachStacktrace;
    }

    public boolean isAttachThreads() {
        return this.attachThreads;
    }

    public boolean isDebug() {
        return this.debug;
    }

    public boolean isEnableAutoSessionTracking() {
        return this.enableAutoSessionTracking;
    }

    public boolean isEnableDeduplication() {
        return this.enableDeduplication;
    }

    public boolean isEnableExternalConfiguration() {
        return this.enableExternalConfiguration;
    }

    public boolean isEnableNdk() {
        return this.enableNdk;
    }

    public boolean isEnableScopeSync() {
        return this.enableScopeSync;
    }

    public boolean isEnableShutdownHook() {
        return this.enableShutdownHook;
    }

    public boolean isEnableTimeToFullDisplayTracing() {
        return this.enableTimeToFullDisplayTracing;
    }

    public boolean isEnableUncaughtExceptionHandler() {
        return this.enableUncaughtExceptionHandler;
    }

    public boolean isEnableUserInteractionBreadcrumbs() {
        return this.enableUserInteractionBreadcrumbs;
    }

    public boolean isEnableUserInteractionTracing() {
        return this.enableUserInteractionTracing;
    }

    public boolean isPrintUncaughtStackTrace() {
        return this.printUncaughtStackTrace;
    }

    public boolean isProfilingEnabled() {
        if ((getProfilesSampleRate() == null || getProfilesSampleRate().doubleValue() <= 0.0d) && getProfilesSampler() == null) {
            return false;
        }
        return true;
    }

    public boolean isSendClientReports() {
        return this.sendClientReports;
    }

    public boolean isSendDefaultPii() {
        return this.sendDefaultPii;
    }

    public boolean isTraceOptionsRequests() {
        return this.traceOptionsRequests;
    }

    @ApiStatus.Experimental
    public boolean isTraceSampling() {
        return this.traceSampling;
    }

    public boolean isTracingEnabled() {
        Boolean bool = this.enableTracing;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (getTracesSampleRate() == null && getTracesSampler() == null) {
            return false;
        }
        return true;
    }

    public void merge(u uVar) {
        if (uVar.j() != null) {
            setDsn(uVar.j());
        }
        if (uVar.n() != null) {
            setEnvironment(uVar.n());
        }
        if (uVar.w() != null) {
            setRelease(uVar.w());
        }
        if (uVar.i() != null) {
            setDist(uVar.i());
        }
        if (uVar.y() != null) {
            setServerName(uVar.y());
        }
        if (uVar.v() != null) {
            setProxy(uVar.v());
        }
        if (uVar.m() != null) {
            setEnableUncaughtExceptionHandler(uVar.m().booleanValue());
        }
        if (uVar.s() != null) {
            setPrintUncaughtStackTrace(uVar.s().booleanValue());
        }
        if (uVar.l() != null) {
            setEnableTracing(uVar.l());
        }
        if (uVar.B() != null) {
            setTracesSampleRate(uVar.B());
        }
        if (uVar.t() != null) {
            setProfilesSampleRate(uVar.t());
        }
        if (uVar.h() != null) {
            setDebug(uVar.h().booleanValue());
        }
        if (uVar.k() != null) {
            setEnableDeduplication(uVar.k().booleanValue());
        }
        if (uVar.x() != null) {
            setSendClientReports(uVar.x().booleanValue());
        }
        for (Map.Entry entry : new HashMap(uVar.z()).entrySet()) {
            this.tags.put((String) entry.getKey(), (String) entry.getValue());
        }
        for (String addInAppInclude : new ArrayList(uVar.r())) {
            addInAppInclude(addInAppInclude);
        }
        for (String addInAppExclude : new ArrayList(uVar.q())) {
            addInAppExclude(addInAppExclude);
        }
        Iterator it = new HashSet(uVar.p()).iterator();
        while (it.hasNext()) {
            addIgnoredExceptionForType((Class) it.next());
        }
        if (uVar.A() != null) {
            setTracePropagationTargets(new ArrayList(uVar.A()));
        }
        for (String addContextTag : new ArrayList(uVar.g())) {
            addContextTag(addContextTag);
        }
        if (uVar.u() != null) {
            setProguardUuid(uVar.u());
        }
        if (uVar.o() != null) {
            setIdleTimeout(uVar.o());
        }
    }

    public void setAttachServerName(boolean z10) {
        this.attachServerName = z10;
    }

    public void setAttachStacktrace(boolean z10) {
        this.attachStacktrace = z10;
    }

    public void setAttachThreads(boolean z10) {
        this.attachThreads = z10;
    }

    public void setBeforeBreadcrumb(a aVar) {
        this.beforeBreadcrumb = aVar;
    }

    public void setBeforeSend(b bVar) {
        this.beforeSend = bVar;
    }

    public void setBeforeSendTransaction(c cVar) {
        this.beforeSendTransaction = cVar;
    }

    public void setCacheDirPath(String str) {
        this.cacheDirPath = str;
    }

    public void setConnectionTimeoutMillis(int i10) {
        this.connectionTimeoutMillis = i10;
    }

    @ApiStatus.Internal
    public void setDateProvider(v2 v2Var) {
        this.dateProvider = v2Var;
    }

    public void setDebug(boolean z10) {
        this.debug = z10;
    }

    public void setDiagnosticLevel(SentryLevel sentryLevel) {
        if (sentryLevel == null) {
            sentryLevel = DEFAULT_DIAGNOSTIC_LEVEL;
        }
        this.diagnosticLevel = sentryLevel;
    }

    public void setDist(String str) {
        this.dist = str;
    }

    @ApiStatus.Internal
    public void setDistinctId(String str) {
        this.distinctId = str;
    }

    public void setDsn(String str) {
        this.dsn = str;
        this.dsnHash = p.a(str, this.logger);
    }

    public void setEnableAutoSessionTracking(boolean z10) {
        this.enableAutoSessionTracking = z10;
    }

    public void setEnableDeduplication(boolean z10) {
        this.enableDeduplication = z10;
    }

    public void setEnableExternalConfiguration(boolean z10) {
        this.enableExternalConfiguration = z10;
    }

    public void setEnableNdk(boolean z10) {
        this.enableNdk = z10;
    }

    public void setEnableScopeSync(boolean z10) {
        this.enableScopeSync = z10;
    }

    public void setEnableShutdownHook(boolean z10) {
        this.enableShutdownHook = z10;
    }

    public void setEnableTimeToFullDisplayTracing(boolean z10) {
        this.enableTimeToFullDisplayTracing = z10;
    }

    public void setEnableTracing(Boolean bool) {
        this.enableTracing = bool;
    }

    public void setEnableUncaughtExceptionHandler(boolean z10) {
        this.enableUncaughtExceptionHandler = z10;
    }

    public void setEnableUserInteractionBreadcrumbs(boolean z10) {
        this.enableUserInteractionBreadcrumbs = z10;
    }

    public void setEnableUserInteractionTracing(boolean z10) {
        this.enableUserInteractionTracing = z10;
    }

    public void setEnvelopeDiskCache(io.sentry.cache.e eVar) {
        if (eVar == null) {
            eVar = r.b();
        }
        this.envelopeDiskCache = eVar;
    }

    public void setEnvelopeReader(e0 e0Var) {
        if (e0Var == null) {
            e0Var = g1.b();
        }
        this.envelopeReader = e0Var;
    }

    public void setEnvironment(String str) {
        this.environment = str;
    }

    @ApiStatus.Internal
    public void setExecutorService(k0 k0Var) {
        if (k0Var != null) {
            this.executorService = k0Var;
        }
    }

    public void setFlushTimeoutMillis(long j10) {
        this.flushTimeoutMillis = j10;
    }

    public void setGestureTargetLocators(List<io.sentry.internal.gestures.a> list) {
        this.gestureTargetLocators.clear();
        this.gestureTargetLocators.addAll(list);
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier2) {
        this.hostnameVerifier = hostnameVerifier2;
    }

    public void setIdleTimeout(Long l10) {
        this.idleTimeout = l10;
    }

    public void setInstrumenter(Instrumenter instrumenter2) {
        this.instrumenter = instrumenter2;
    }

    public void setLogger(h0 h0Var) {
        this.logger = h0Var == null ? i1.e() : new j(this, h0Var);
    }

    public void setMainThreadChecker(io.sentry.util.thread.a aVar) {
        this.mainThreadChecker = aVar;
    }

    public void setMaxAttachmentSize(long j10) {
        this.maxAttachmentSize = j10;
    }

    public void setMaxBreadcrumbs(int i10) {
        this.maxBreadcrumbs = i10;
    }

    public void setMaxCacheItems(int i10) {
        this.maxCacheItems = i10;
    }

    public void setMaxDepth(int i10) {
        this.maxDepth = i10;
    }

    public void setMaxQueueSize(int i10) {
        if (i10 > 0) {
            this.maxQueueSize = i10;
        }
    }

    public void setMaxRequestBodySize(RequestSize requestSize) {
        this.maxRequestBodySize = requestSize;
    }

    @ApiStatus.Experimental
    public void setMaxSpans(int i10) {
        this.maxSpans = i10;
    }

    public void setMaxTraceFileSize(long j10) {
        this.maxTraceFileSize = j10;
    }

    @ApiStatus.Internal
    public void setModulesLoader(io.sentry.internal.modules.b bVar) {
        if (bVar == null) {
            bVar = io.sentry.internal.modules.e.b();
        }
        this.modulesLoader = bVar;
    }

    public void setPrintUncaughtStackTrace(boolean z10) {
        this.printUncaughtStackTrace = z10;
    }

    public void setProfilesSampleRate(Double d10) {
        if (o.a(d10)) {
            this.profilesSampleRate = d10;
            return;
        }
        throw new IllegalArgumentException("The value " + d10 + " is not valid. Use null to disable or values between 0.0 and 1.0.");
    }

    public void setProfilesSampler(d dVar) {
        this.profilesSampler = dVar;
    }

    @Deprecated
    public void setProfilingEnabled(boolean z10) {
        Double d10;
        if (getProfilesSampleRate() == null) {
            if (z10) {
                d10 = Double.valueOf(1.0d);
            } else {
                d10 = null;
            }
            setProfilesSampleRate(d10);
        }
    }

    public void setProguardUuid(String str) {
        this.proguardUuid = str;
    }

    public void setProxy(e eVar) {
        this.proxy = eVar;
    }

    public void setReadTimeoutMillis(int i10) {
        this.readTimeoutMillis = i10;
    }

    public void setRelease(String str) {
        this.release = str;
    }

    public void setSampleRate(Double d10) {
        if (o.c(d10)) {
            this.sampleRate = d10;
            return;
        }
        throw new IllegalArgumentException("The value " + d10 + " is not valid. Use null to disable or values >= 0.0 and <= 1.0.");
    }

    @ApiStatus.Internal
    public void setSdkVersion(m mVar) {
        this.sdkVersion = mVar;
    }

    public void setSendClientReports(boolean z10) {
        this.sendClientReports = z10;
        if (z10) {
            this.clientReportRecorder = new io.sentry.clientreport.d(this);
        } else {
            this.clientReportRecorder = new h();
        }
    }

    public void setSendDefaultPii(boolean z10) {
        this.sendDefaultPii = z10;
    }

    public void setSentryClientName(String str) {
        this.sentryClientName = str;
    }

    public void setSerializer(l0 l0Var) {
        if (l0Var == null) {
            l0Var = n1.f();
        }
        this.serializer = l0Var;
    }

    public void setServerName(String str) {
        this.serverName = str;
    }

    public void setSessionTrackingIntervalMillis(long j10) {
        this.sessionTrackingIntervalMillis = j10;
    }

    @Deprecated
    @ApiStatus.ScheduledForRemoval
    public void setShutdownTimeout(long j10) {
        this.shutdownTimeoutMillis = j10;
    }

    public void setShutdownTimeoutMillis(long j10) {
        this.shutdownTimeoutMillis = j10;
    }

    public void setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.sslSocketFactory = sSLSocketFactory;
    }

    public void setTag(String str, String str2) {
        this.tags.put(str, str2);
    }

    public void setTraceOptionsRequests(boolean z10) {
        this.traceOptionsRequests = z10;
    }

    @ApiStatus.Internal
    public void setTracePropagationTargets(List<String> list) {
        if (list == null) {
            this.tracePropagationTargets = list;
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            if (!next.isEmpty()) {
                arrayList.add(next);
            }
        }
        this.tracePropagationTargets = arrayList;
    }

    @Deprecated
    public void setTraceSampling(boolean z10) {
        this.traceSampling = z10;
    }

    public void setTracesSampleRate(Double d10) {
        if (o.d(d10)) {
            this.tracesSampleRate = d10;
            return;
        }
        throw new IllegalArgumentException("The value " + d10 + " is not valid. Use null to disable or values between 0.0 and 1.0.");
    }

    public void setTracesSampler(f fVar) {
        this.tracesSampler = fVar;
    }

    @Deprecated
    @ApiStatus.Internal
    public void setTracingOrigins(List<String> list) {
        setTracePropagationTargets(list);
    }

    @ApiStatus.Internal
    public void setTransactionPerformanceCollector(v4 v4Var) {
        this.transactionPerformanceCollector = v4Var;
    }

    public void setTransactionProfiler(o0 o0Var) {
        if (o0Var == null) {
            o0Var = r1.c();
        }
        this.transactionProfiler = o0Var;
    }

    public void setTransportFactory(p0 p0Var) {
        if (p0Var == null) {
            p0Var = s1.b();
        }
        this.transportFactory = p0Var;
    }

    public void setTransportGate(q qVar) {
        if (qVar == null) {
            qVar = t.a();
        }
        this.transportGate = qVar;
    }

    private SentryOptions(boolean z10) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.eventProcessors = copyOnWriteArrayList;
        this.ignoredExceptionsForType = new CopyOnWriteArraySet();
        CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
        this.integrations = copyOnWriteArrayList2;
        this.shutdownTimeoutMillis = 2000;
        this.flushTimeoutMillis = 15000;
        this.enableNdk = true;
        this.logger = i1.e();
        this.diagnosticLevel = DEFAULT_DIAGNOSTIC_LEVEL;
        this.envelopeReader = new o(new d1(this));
        this.serializer = new d1(this);
        this.maxDepth = 100;
        this.maxCacheItems = 30;
        this.maxQueueSize = 30;
        this.maxBreadcrumbs = 100;
        this.inAppExcludes = new CopyOnWriteArrayList();
        this.inAppIncludes = new CopyOnWriteArrayList();
        this.transportFactory = s1.b();
        this.transportGate = t.a();
        this.attachStacktrace = true;
        this.enableAutoSessionTracking = true;
        this.sessionTrackingIntervalMillis = 30000;
        this.attachServerName = true;
        this.enableUncaughtExceptionHandler = true;
        this.printUncaughtStackTrace = false;
        this.executorService = m1.e();
        this.connectionTimeoutMillis = FacebookParse.FB_NO_LIMIT;
        this.readTimeoutMillis = FacebookParse.FB_NO_LIMIT;
        this.envelopeDiskCache = r.b();
        this.sendDefaultPii = false;
        this.observers = new ArrayList();
        this.tags = new ConcurrentHashMap();
        this.maxAttachmentSize = 20971520;
        this.enableDeduplication = true;
        this.maxSpans = 1000;
        this.enableShutdownHook = true;
        this.maxRequestBodySize = RequestSize.NONE;
        this.traceSampling = true;
        this.maxTraceFileSize = 5242880;
        this.transactionProfiler = r1.c();
        this.tracePropagationTargets = null;
        this.defaultTracePropagationTargets = Collections.singletonList(".*");
        this.idleTimeout = 3000L;
        this.contextTags = new CopyOnWriteArrayList();
        this.sendClientReports = true;
        this.clientReportRecorder = new io.sentry.clientreport.d(this);
        this.modulesLoader = io.sentry.internal.modules.e.b();
        this.enableUserInteractionTracing = false;
        this.enableUserInteractionBreadcrumbs = true;
        this.instrumenter = Instrumenter.SENTRY;
        this.gestureTargetLocators = new ArrayList();
        this.mainThreadChecker = io.sentry.util.thread.c.e();
        this.traceOptionsRequests = true;
        this.dateProvider = new o2();
        this.collectors = new ArrayList();
        this.transactionPerformanceCollector = q1.c();
        this.enableTimeToFullDisplayTracing = false;
        this.fullyDisplayedReporter = v.a();
        if (!z10) {
            this.executorService = new r3();
            copyOnWriteArrayList2.add(new UncaughtExceptionHandlerIntegration());
            copyOnWriteArrayList2.add(new ShutdownHookIntegration());
            copyOnWriteArrayList.add(new e1(this));
            copyOnWriteArrayList.add(new n(this));
            if (n.b()) {
                copyOnWriteArrayList.add(new y3());
            }
            setSentryClientName("sentry.java/6.17.0");
            setSdkVersion(createSdkVersion());
            addPackageInfo();
        }
    }
}
