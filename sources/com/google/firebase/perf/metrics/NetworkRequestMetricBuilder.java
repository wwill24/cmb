package com.google.firebase.perf.metrics;

import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.application.AppStateMonitor;
import com.google.firebase.perf.application.AppStateUpdateHandler;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.network.NetworkRequestMetricBuilderUtil;
import com.google.firebase.perf.session.PerfSession;
import com.google.firebase.perf.session.SessionAwareObject;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.session.gauges.GaugeManager;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Utils;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class NetworkRequestMetricBuilder extends AppStateUpdateHandler implements SessionAwareObject {
    private static final char HIGHEST_ASCII_CHAR = '';
    private static final char HIGHEST_CONTROL_CHAR = '\u001f';
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final NetworkRequestMetric.Builder builder;
    private final GaugeManager gaugeManager;
    private boolean isManualNetworkRequestMetric;
    private boolean isReportSent;
    private final List<PerfSession> sessions;
    private final TransportManager transportManager;
    private String userAgent;
    private final WeakReference<SessionAwareObject> weakReference;

    private NetworkRequestMetricBuilder(TransportManager transportManager2) {
        this(transportManager2, AppStateMonitor.getInstance(), GaugeManager.getInstance());
    }

    public static NetworkRequestMetricBuilder builder(TransportManager transportManager2) {
        return new NetworkRequestMetricBuilder(transportManager2);
    }

    private boolean hasStarted() {
        return this.builder.hasClientStartTimeUs();
    }

    private boolean isStopped() {
        return this.builder.hasTimeToResponseCompletedUs();
    }

    private static boolean isValidContentType(String str) {
        if (str.length() > 128) {
            return false;
        }
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (charAt <= 31 || charAt > 127) {
                return false;
            }
        }
        return true;
    }

    public NetworkRequestMetric build() {
        SessionManager.getInstance().unregisterForSessionUpdates(this.weakReference);
        unregisterForAppState();
        com.google.firebase.perf.v1.PerfSession[] buildAndSort = PerfSession.buildAndSort(getSessions());
        if (buildAndSort != null) {
            this.builder.addAllPerfSessions(Arrays.asList(buildAndSort));
        }
        NetworkRequestMetric networkRequestMetric = (NetworkRequestMetric) this.builder.build();
        if (!NetworkRequestMetricBuilderUtil.isAllowedUserAgent(this.userAgent)) {
            logger.debug("Dropping network request from a 'User-Agent' that is not allowed");
            return networkRequestMetric;
        } else if (!this.isReportSent) {
            this.transportManager.log(networkRequestMetric, getAppState());
            this.isReportSent = true;
            return networkRequestMetric;
        } else {
            if (this.isManualNetworkRequestMetric) {
                logger.debug("This metric has already been queued for transmission.  Please create a new HttpMetric for each request/response");
            }
            return networkRequestMetric;
        }
    }

    /* access modifiers changed from: package-private */
    public void clearBuilderFields() {
        this.builder.clear();
    }

    /* access modifiers changed from: package-private */
    public List<PerfSession> getSessions() {
        List<PerfSession> unmodifiableList;
        synchronized (this.sessions) {
            ArrayList arrayList = new ArrayList();
            for (PerfSession next : this.sessions) {
                if (next != null) {
                    arrayList.add(next);
                }
            }
            unmodifiableList = Collections.unmodifiableList(arrayList);
        }
        return unmodifiableList;
    }

    public long getTimeToResponseInitiatedMicros() {
        return this.builder.getTimeToResponseInitiatedUs();
    }

    public String getUrl() {
        return this.builder.getUrl();
    }

    public boolean hasHttpResponseCode() {
        return this.builder.hasHttpResponseCode();
    }

    /* access modifiers changed from: package-private */
    public boolean isReportSent() {
        return this.isReportSent;
    }

    public NetworkRequestMetricBuilder setCustomAttributes(Map<String, String> map) {
        this.builder.clearCustomAttributes().putAllCustomAttributes(map);
        return this;
    }

    public NetworkRequestMetricBuilder setHttpMethod(String str) {
        NetworkRequestMetric.HttpMethod httpMethod;
        if (str != null) {
            NetworkRequestMetric.HttpMethod httpMethod2 = NetworkRequestMetric.HttpMethod.HTTP_METHOD_UNKNOWN;
            String upperCase = str.toUpperCase();
            upperCase.hashCode();
            char c10 = 65535;
            switch (upperCase.hashCode()) {
                case -531492226:
                    if (upperCase.equals(FirebasePerformance.HttpMethod.OPTIONS)) {
                        c10 = 0;
                        break;
                    }
                    break;
                case 70454:
                    if (upperCase.equals("GET")) {
                        c10 = 1;
                        break;
                    }
                    break;
                case 79599:
                    if (upperCase.equals(FirebasePerformance.HttpMethod.PUT)) {
                        c10 = 2;
                        break;
                    }
                    break;
                case 2213344:
                    if (upperCase.equals(FirebasePerformance.HttpMethod.HEAD)) {
                        c10 = 3;
                        break;
                    }
                    break;
                case 2461856:
                    if (upperCase.equals("POST")) {
                        c10 = 4;
                        break;
                    }
                    break;
                case 75900968:
                    if (upperCase.equals(FirebasePerformance.HttpMethod.PATCH)) {
                        c10 = 5;
                        break;
                    }
                    break;
                case 80083237:
                    if (upperCase.equals(FirebasePerformance.HttpMethod.TRACE)) {
                        c10 = 6;
                        break;
                    }
                    break;
                case 1669334218:
                    if (upperCase.equals(FirebasePerformance.HttpMethod.CONNECT)) {
                        c10 = 7;
                        break;
                    }
                    break;
                case 2012838315:
                    if (upperCase.equals(FirebasePerformance.HttpMethod.DELETE)) {
                        c10 = 8;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                    httpMethod = NetworkRequestMetric.HttpMethod.OPTIONS;
                    break;
                case 1:
                    httpMethod = NetworkRequestMetric.HttpMethod.GET;
                    break;
                case 2:
                    httpMethod = NetworkRequestMetric.HttpMethod.PUT;
                    break;
                case 3:
                    httpMethod = NetworkRequestMetric.HttpMethod.HEAD;
                    break;
                case 4:
                    httpMethod = NetworkRequestMetric.HttpMethod.POST;
                    break;
                case 5:
                    httpMethod = NetworkRequestMetric.HttpMethod.PATCH;
                    break;
                case 6:
                    httpMethod = NetworkRequestMetric.HttpMethod.TRACE;
                    break;
                case 7:
                    httpMethod = NetworkRequestMetric.HttpMethod.CONNECT;
                    break;
                case 8:
                    httpMethod = NetworkRequestMetric.HttpMethod.DELETE;
                    break;
                default:
                    httpMethod = NetworkRequestMetric.HttpMethod.HTTP_METHOD_UNKNOWN;
                    break;
            }
            this.builder.setHttpMethod(httpMethod);
        }
        return this;
    }

    public NetworkRequestMetricBuilder setHttpResponseCode(int i10) {
        this.builder.setHttpResponseCode(i10);
        return this;
    }

    public void setManualNetworkRequestMetric() {
        this.isManualNetworkRequestMetric = true;
    }

    public NetworkRequestMetricBuilder setNetworkClientErrorReason() {
        this.builder.setNetworkClientErrorReason(NetworkRequestMetric.NetworkClientErrorReason.GENERIC_CLIENT_ERROR);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void setReportSent() {
        this.isReportSent = true;
    }

    public NetworkRequestMetricBuilder setRequestPayloadBytes(long j10) {
        this.builder.setRequestPayloadBytes(j10);
        return this;
    }

    public NetworkRequestMetricBuilder setRequestStartTimeMicros(long j10) {
        PerfSession perfSession = SessionManager.getInstance().perfSession();
        SessionManager.getInstance().registerForSessionUpdates(this.weakReference);
        this.builder.setClientStartTimeUs(j10);
        updateSession(perfSession);
        if (perfSession.isGaugeAndEventCollectionEnabled()) {
            this.gaugeManager.collectGaugeMetricOnce(perfSession.getTimer());
        }
        return this;
    }

    public NetworkRequestMetricBuilder setResponseContentType(String str) {
        if (str == null) {
            this.builder.clearResponseContentType();
            return this;
        }
        if (isValidContentType(str)) {
            this.builder.setResponseContentType(str);
        } else {
            AndroidLogger androidLogger = logger;
            androidLogger.warn("The content type of the response is not a valid content-type:" + str);
        }
        return this;
    }

    public NetworkRequestMetricBuilder setResponsePayloadBytes(long j10) {
        this.builder.setResponsePayloadBytes(j10);
        return this;
    }

    public NetworkRequestMetricBuilder setTimeToRequestCompletedMicros(long j10) {
        this.builder.setTimeToRequestCompletedUs(j10);
        return this;
    }

    public NetworkRequestMetricBuilder setTimeToResponseCompletedMicros(long j10) {
        this.builder.setTimeToResponseCompletedUs(j10);
        if (SessionManager.getInstance().perfSession().isGaugeAndEventCollectionEnabled()) {
            this.gaugeManager.collectGaugeMetricOnce(SessionManager.getInstance().perfSession().getTimer());
        }
        return this;
    }

    public NetworkRequestMetricBuilder setTimeToResponseInitiatedMicros(long j10) {
        this.builder.setTimeToResponseInitiatedUs(j10);
        return this;
    }

    public NetworkRequestMetricBuilder setUrl(String str) {
        if (str != null) {
            this.builder.setUrl(Utils.truncateURL(Utils.stripSensitiveInfo(str), 2000));
        }
        return this;
    }

    public NetworkRequestMetricBuilder setUserAgent(String str) {
        this.userAgent = str;
        return this;
    }

    public void updateSession(PerfSession perfSession) {
        if (perfSession == null) {
            logger.warn("Unable to add new SessionId to the Network Trace. Continuing without it.");
        } else if (hasStarted() && !isStopped()) {
            this.sessions.add(perfSession);
        }
    }

    public NetworkRequestMetricBuilder(TransportManager transportManager2, AppStateMonitor appStateMonitor, GaugeManager gaugeManager2) {
        super(appStateMonitor);
        this.builder = NetworkRequestMetric.newBuilder();
        this.weakReference = new WeakReference<>(this);
        this.transportManager = transportManager2;
        this.gaugeManager = gaugeManager2;
        this.sessions = Collections.synchronizedList(new ArrayList());
        registerForAppState();
    }
}
