package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.PerfSession;
import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.WireFormat;
import com.google.protobuf.a;
import com.google.protobuf.f0;
import com.google.protobuf.h;
import com.google.protobuf.n;
import com.google.protobuf.t0;
import com.google.protobuf.w;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class NetworkRequestMetric extends GeneratedMessageLite<NetworkRequestMetric, Builder> implements NetworkRequestMetricOrBuilder {
    public static final int CLIENT_START_TIME_US_FIELD_NUMBER = 7;
    public static final int CUSTOM_ATTRIBUTES_FIELD_NUMBER = 12;
    /* access modifiers changed from: private */
    public static final NetworkRequestMetric DEFAULT_INSTANCE;
    public static final int HTTP_METHOD_FIELD_NUMBER = 2;
    public static final int HTTP_RESPONSE_CODE_FIELD_NUMBER = 5;
    public static final int NETWORK_CLIENT_ERROR_REASON_FIELD_NUMBER = 11;
    private static volatile t0<NetworkRequestMetric> PARSER = null;
    public static final int PERF_SESSIONS_FIELD_NUMBER = 13;
    public static final int REQUEST_PAYLOAD_BYTES_FIELD_NUMBER = 3;
    public static final int RESPONSE_CONTENT_TYPE_FIELD_NUMBER = 6;
    public static final int RESPONSE_PAYLOAD_BYTES_FIELD_NUMBER = 4;
    public static final int TIME_TO_REQUEST_COMPLETED_US_FIELD_NUMBER = 8;
    public static final int TIME_TO_RESPONSE_COMPLETED_US_FIELD_NUMBER = 10;
    public static final int TIME_TO_RESPONSE_INITIATED_US_FIELD_NUMBER = 9;
    public static final int URL_FIELD_NUMBER = 1;
    private int bitField0_;
    private long clientStartTimeUs_;
    private MapFieldLite<String, String> customAttributes_ = MapFieldLite.d();
    private int httpMethod_;
    private int httpResponseCode_;
    private int networkClientErrorReason_;
    private w.j<PerfSession> perfSessions_ = GeneratedMessageLite.emptyProtobufList();
    private long requestPayloadBytes_;
    private String responseContentType_ = "";
    private long responsePayloadBytes_;
    private long timeToRequestCompletedUs_;
    private long timeToResponseCompletedUs_;
    private long timeToResponseInitiatedUs_;
    private String url_ = "";

    /* renamed from: com.google.firebase.perf.v1.NetworkRequestMetric$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke[] r0 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = r0
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.v1.NetworkRequestMetric.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder extends GeneratedMessageLite.a<NetworkRequestMetric, Builder> implements NetworkRequestMetricOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r12) {
            this();
        }

        public Builder addAllPerfSessions(Iterable<? extends PerfSession> iterable) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).addAllPerfSessions(iterable);
            return this;
        }

        public Builder addPerfSessions(PerfSession perfSession) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).addPerfSessions(perfSession);
            return this;
        }

        public Builder clearClientStartTimeUs() {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).clearClientStartTimeUs();
            return this;
        }

        public Builder clearCustomAttributes() {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).getMutableCustomAttributesMap().clear();
            return this;
        }

        public Builder clearHttpMethod() {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).clearHttpMethod();
            return this;
        }

        public Builder clearHttpResponseCode() {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).clearHttpResponseCode();
            return this;
        }

        public Builder clearNetworkClientErrorReason() {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).clearNetworkClientErrorReason();
            return this;
        }

        public Builder clearPerfSessions() {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).clearPerfSessions();
            return this;
        }

        public Builder clearRequestPayloadBytes() {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).clearRequestPayloadBytes();
            return this;
        }

        public Builder clearResponseContentType() {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).clearResponseContentType();
            return this;
        }

        public Builder clearResponsePayloadBytes() {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).clearResponsePayloadBytes();
            return this;
        }

        public Builder clearTimeToRequestCompletedUs() {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).clearTimeToRequestCompletedUs();
            return this;
        }

        public Builder clearTimeToResponseCompletedUs() {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).clearTimeToResponseCompletedUs();
            return this;
        }

        public Builder clearTimeToResponseInitiatedUs() {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).clearTimeToResponseInitiatedUs();
            return this;
        }

        public Builder clearUrl() {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).clearUrl();
            return this;
        }

        public boolean containsCustomAttributes(String str) {
            str.getClass();
            return ((NetworkRequestMetric) this.instance).getCustomAttributesMap().containsKey(str);
        }

        public long getClientStartTimeUs() {
            return ((NetworkRequestMetric) this.instance).getClientStartTimeUs();
        }

        @Deprecated
        public Map<String, String> getCustomAttributes() {
            return getCustomAttributesMap();
        }

        public int getCustomAttributesCount() {
            return ((NetworkRequestMetric) this.instance).getCustomAttributesMap().size();
        }

        public Map<String, String> getCustomAttributesMap() {
            return Collections.unmodifiableMap(((NetworkRequestMetric) this.instance).getCustomAttributesMap());
        }

        public String getCustomAttributesOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> customAttributesMap = ((NetworkRequestMetric) this.instance).getCustomAttributesMap();
            if (customAttributesMap.containsKey(str)) {
                return customAttributesMap.get(str);
            }
            return str2;
        }

        public String getCustomAttributesOrThrow(String str) {
            str.getClass();
            Map<String, String> customAttributesMap = ((NetworkRequestMetric) this.instance).getCustomAttributesMap();
            if (customAttributesMap.containsKey(str)) {
                return customAttributesMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        public HttpMethod getHttpMethod() {
            return ((NetworkRequestMetric) this.instance).getHttpMethod();
        }

        public int getHttpResponseCode() {
            return ((NetworkRequestMetric) this.instance).getHttpResponseCode();
        }

        public NetworkClientErrorReason getNetworkClientErrorReason() {
            return ((NetworkRequestMetric) this.instance).getNetworkClientErrorReason();
        }

        public PerfSession getPerfSessions(int i10) {
            return ((NetworkRequestMetric) this.instance).getPerfSessions(i10);
        }

        public int getPerfSessionsCount() {
            return ((NetworkRequestMetric) this.instance).getPerfSessionsCount();
        }

        public List<PerfSession> getPerfSessionsList() {
            return Collections.unmodifiableList(((NetworkRequestMetric) this.instance).getPerfSessionsList());
        }

        public long getRequestPayloadBytes() {
            return ((NetworkRequestMetric) this.instance).getRequestPayloadBytes();
        }

        public String getResponseContentType() {
            return ((NetworkRequestMetric) this.instance).getResponseContentType();
        }

        public ByteString getResponseContentTypeBytes() {
            return ((NetworkRequestMetric) this.instance).getResponseContentTypeBytes();
        }

        public long getResponsePayloadBytes() {
            return ((NetworkRequestMetric) this.instance).getResponsePayloadBytes();
        }

        public long getTimeToRequestCompletedUs() {
            return ((NetworkRequestMetric) this.instance).getTimeToRequestCompletedUs();
        }

        public long getTimeToResponseCompletedUs() {
            return ((NetworkRequestMetric) this.instance).getTimeToResponseCompletedUs();
        }

        public long getTimeToResponseInitiatedUs() {
            return ((NetworkRequestMetric) this.instance).getTimeToResponseInitiatedUs();
        }

        public String getUrl() {
            return ((NetworkRequestMetric) this.instance).getUrl();
        }

        public ByteString getUrlBytes() {
            return ((NetworkRequestMetric) this.instance).getUrlBytes();
        }

        public boolean hasClientStartTimeUs() {
            return ((NetworkRequestMetric) this.instance).hasClientStartTimeUs();
        }

        public boolean hasHttpMethod() {
            return ((NetworkRequestMetric) this.instance).hasHttpMethod();
        }

        public boolean hasHttpResponseCode() {
            return ((NetworkRequestMetric) this.instance).hasHttpResponseCode();
        }

        public boolean hasNetworkClientErrorReason() {
            return ((NetworkRequestMetric) this.instance).hasNetworkClientErrorReason();
        }

        public boolean hasRequestPayloadBytes() {
            return ((NetworkRequestMetric) this.instance).hasRequestPayloadBytes();
        }

        public boolean hasResponseContentType() {
            return ((NetworkRequestMetric) this.instance).hasResponseContentType();
        }

        public boolean hasResponsePayloadBytes() {
            return ((NetworkRequestMetric) this.instance).hasResponsePayloadBytes();
        }

        public boolean hasTimeToRequestCompletedUs() {
            return ((NetworkRequestMetric) this.instance).hasTimeToRequestCompletedUs();
        }

        public boolean hasTimeToResponseCompletedUs() {
            return ((NetworkRequestMetric) this.instance).hasTimeToResponseCompletedUs();
        }

        public boolean hasTimeToResponseInitiatedUs() {
            return ((NetworkRequestMetric) this.instance).hasTimeToResponseInitiatedUs();
        }

        public boolean hasUrl() {
            return ((NetworkRequestMetric) this.instance).hasUrl();
        }

        public Builder putAllCustomAttributes(Map<String, String> map) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).getMutableCustomAttributesMap().putAll(map);
            return this;
        }

        public Builder putCustomAttributes(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).getMutableCustomAttributesMap().put(str, str2);
            return this;
        }

        public Builder removeCustomAttributes(String str) {
            str.getClass();
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).getMutableCustomAttributesMap().remove(str);
            return this;
        }

        public Builder removePerfSessions(int i10) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).removePerfSessions(i10);
            return this;
        }

        public Builder setClientStartTimeUs(long j10) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).setClientStartTimeUs(j10);
            return this;
        }

        public Builder setHttpMethod(HttpMethod httpMethod) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).setHttpMethod(httpMethod);
            return this;
        }

        public Builder setHttpResponseCode(int i10) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).setHttpResponseCode(i10);
            return this;
        }

        public Builder setNetworkClientErrorReason(NetworkClientErrorReason networkClientErrorReason) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).setNetworkClientErrorReason(networkClientErrorReason);
            return this;
        }

        public Builder setPerfSessions(int i10, PerfSession perfSession) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).setPerfSessions(i10, perfSession);
            return this;
        }

        public Builder setRequestPayloadBytes(long j10) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).setRequestPayloadBytes(j10);
            return this;
        }

        public Builder setResponseContentType(String str) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).setResponseContentType(str);
            return this;
        }

        public Builder setResponseContentTypeBytes(ByteString byteString) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).setResponseContentTypeBytes(byteString);
            return this;
        }

        public Builder setResponsePayloadBytes(long j10) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).setResponsePayloadBytes(j10);
            return this;
        }

        public Builder setTimeToRequestCompletedUs(long j10) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).setTimeToRequestCompletedUs(j10);
            return this;
        }

        public Builder setTimeToResponseCompletedUs(long j10) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).setTimeToResponseCompletedUs(j10);
            return this;
        }

        public Builder setTimeToResponseInitiatedUs(long j10) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).setTimeToResponseInitiatedUs(j10);
            return this;
        }

        public Builder setUrl(String str) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).setUrl(str);
            return this;
        }

        public Builder setUrlBytes(ByteString byteString) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).setUrlBytes(byteString);
            return this;
        }

        private Builder() {
            super(NetworkRequestMetric.DEFAULT_INSTANCE);
        }

        public Builder addPerfSessions(int i10, PerfSession perfSession) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).addPerfSessions(i10, perfSession);
            return this;
        }

        public Builder setPerfSessions(int i10, PerfSession.Builder builder) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).setPerfSessions(i10, (PerfSession) builder.build());
            return this;
        }

        public Builder addPerfSessions(PerfSession.Builder builder) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).addPerfSessions((PerfSession) builder.build());
            return this;
        }

        public Builder addPerfSessions(int i10, PerfSession.Builder builder) {
            copyOnWrite();
            ((NetworkRequestMetric) this.instance).addPerfSessions(i10, (PerfSession) builder.build());
            return this;
        }
    }

    private static final class CustomAttributesDefaultEntryHolder {
        static final f0<String, String> defaultEntry;

        static {
            WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
            defaultEntry = f0.d(fieldType, "", fieldType, "");
        }

        private CustomAttributesDefaultEntryHolder() {
        }
    }

    public enum HttpMethod implements w.c {
        HTTP_METHOD_UNKNOWN(0),
        GET(1),
        PUT(2),
        POST(3),
        DELETE(4),
        HEAD(5),
        PATCH(6),
        OPTIONS(7),
        TRACE(8),
        CONNECT(9);
        
        public static final int CONNECT_VALUE = 9;
        public static final int DELETE_VALUE = 4;
        public static final int GET_VALUE = 1;
        public static final int HEAD_VALUE = 5;
        public static final int HTTP_METHOD_UNKNOWN_VALUE = 0;
        public static final int OPTIONS_VALUE = 7;
        public static final int PATCH_VALUE = 6;
        public static final int POST_VALUE = 3;
        public static final int PUT_VALUE = 2;
        public static final int TRACE_VALUE = 8;
        private static final w.d<HttpMethod> internalValueMap = null;
        private final int value;

        private static final class HttpMethodVerifier implements w.e {
            static final w.e INSTANCE = null;

            static {
                INSTANCE = new HttpMethodVerifier();
            }

            private HttpMethodVerifier() {
            }

            public boolean isInRange(int i10) {
                return HttpMethod.forNumber(i10) != null;
            }
        }

        static {
            internalValueMap = new w.d<HttpMethod>() {
                public HttpMethod findValueByNumber(int i10) {
                    return HttpMethod.forNumber(i10);
                }
            };
        }

        private HttpMethod(int i10) {
            this.value = i10;
        }

        public static HttpMethod forNumber(int i10) {
            switch (i10) {
                case 0:
                    return HTTP_METHOD_UNKNOWN;
                case 1:
                    return GET;
                case 2:
                    return PUT;
                case 3:
                    return POST;
                case 4:
                    return DELETE;
                case 5:
                    return HEAD;
                case 6:
                    return PATCH;
                case 7:
                    return OPTIONS;
                case 8:
                    return TRACE;
                case 9:
                    return CONNECT;
                default:
                    return null;
            }
        }

        public static w.d<HttpMethod> internalGetValueMap() {
            return internalValueMap;
        }

        public static w.e internalGetVerifier() {
            return HttpMethodVerifier.INSTANCE;
        }

        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static HttpMethod valueOf(int i10) {
            return forNumber(i10);
        }
    }

    public enum NetworkClientErrorReason implements w.c {
        NETWORK_CLIENT_ERROR_REASON_UNKNOWN(0),
        GENERIC_CLIENT_ERROR(1);
        
        public static final int GENERIC_CLIENT_ERROR_VALUE = 1;
        public static final int NETWORK_CLIENT_ERROR_REASON_UNKNOWN_VALUE = 0;
        private static final w.d<NetworkClientErrorReason> internalValueMap = null;
        private final int value;

        private static final class NetworkClientErrorReasonVerifier implements w.e {
            static final w.e INSTANCE = null;

            static {
                INSTANCE = new NetworkClientErrorReasonVerifier();
            }

            private NetworkClientErrorReasonVerifier() {
            }

            public boolean isInRange(int i10) {
                return NetworkClientErrorReason.forNumber(i10) != null;
            }
        }

        static {
            internalValueMap = new w.d<NetworkClientErrorReason>() {
                public NetworkClientErrorReason findValueByNumber(int i10) {
                    return NetworkClientErrorReason.forNumber(i10);
                }
            };
        }

        private NetworkClientErrorReason(int i10) {
            this.value = i10;
        }

        public static NetworkClientErrorReason forNumber(int i10) {
            if (i10 == 0) {
                return NETWORK_CLIENT_ERROR_REASON_UNKNOWN;
            }
            if (i10 != 1) {
                return null;
            }
            return GENERIC_CLIENT_ERROR;
        }

        public static w.d<NetworkClientErrorReason> internalGetValueMap() {
            return internalValueMap;
        }

        public static w.e internalGetVerifier() {
            return NetworkClientErrorReasonVerifier.INSTANCE;
        }

        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static NetworkClientErrorReason valueOf(int i10) {
            return forNumber(i10);
        }
    }

    static {
        NetworkRequestMetric networkRequestMetric = new NetworkRequestMetric();
        DEFAULT_INSTANCE = networkRequestMetric;
        GeneratedMessageLite.registerDefaultInstance(NetworkRequestMetric.class, networkRequestMetric);
    }

    private NetworkRequestMetric() {
    }

    /* access modifiers changed from: private */
    public void addAllPerfSessions(Iterable<? extends PerfSession> iterable) {
        ensurePerfSessionsIsMutable();
        a.addAll(iterable, this.perfSessions_);
    }

    /* access modifiers changed from: private */
    public void addPerfSessions(PerfSession perfSession) {
        perfSession.getClass();
        ensurePerfSessionsIsMutable();
        this.perfSessions_.add(perfSession);
    }

    /* access modifiers changed from: private */
    public void clearClientStartTimeUs() {
        this.bitField0_ &= -129;
        this.clientStartTimeUs_ = 0;
    }

    /* access modifiers changed from: private */
    public void clearHttpMethod() {
        this.bitField0_ &= -3;
        this.httpMethod_ = 0;
    }

    /* access modifiers changed from: private */
    public void clearHttpResponseCode() {
        this.bitField0_ &= -33;
        this.httpResponseCode_ = 0;
    }

    /* access modifiers changed from: private */
    public void clearNetworkClientErrorReason() {
        this.bitField0_ &= -17;
        this.networkClientErrorReason_ = 0;
    }

    /* access modifiers changed from: private */
    public void clearPerfSessions() {
        this.perfSessions_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    public void clearRequestPayloadBytes() {
        this.bitField0_ &= -5;
        this.requestPayloadBytes_ = 0;
    }

    /* access modifiers changed from: private */
    public void clearResponseContentType() {
        this.bitField0_ &= -65;
        this.responseContentType_ = getDefaultInstance().getResponseContentType();
    }

    /* access modifiers changed from: private */
    public void clearResponsePayloadBytes() {
        this.bitField0_ &= -9;
        this.responsePayloadBytes_ = 0;
    }

    /* access modifiers changed from: private */
    public void clearTimeToRequestCompletedUs() {
        this.bitField0_ &= -257;
        this.timeToRequestCompletedUs_ = 0;
    }

    /* access modifiers changed from: private */
    public void clearTimeToResponseCompletedUs() {
        this.bitField0_ &= -1025;
        this.timeToResponseCompletedUs_ = 0;
    }

    /* access modifiers changed from: private */
    public void clearTimeToResponseInitiatedUs() {
        this.bitField0_ &= -513;
        this.timeToResponseInitiatedUs_ = 0;
    }

    /* access modifiers changed from: private */
    public void clearUrl() {
        this.bitField0_ &= -2;
        this.url_ = getDefaultInstance().getUrl();
    }

    private void ensurePerfSessionsIsMutable() {
        w.j<PerfSession> jVar = this.perfSessions_;
        if (!jVar.h()) {
            this.perfSessions_ = GeneratedMessageLite.mutableCopy(jVar);
        }
    }

    public static NetworkRequestMetric getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* access modifiers changed from: private */
    public Map<String, String> getMutableCustomAttributesMap() {
        return internalGetMutableCustomAttributes();
    }

    private MapFieldLite<String, String> internalGetCustomAttributes() {
        return this.customAttributes_;
    }

    private MapFieldLite<String, String> internalGetMutableCustomAttributes() {
        if (!this.customAttributes_.k()) {
            this.customAttributes_ = this.customAttributes_.p();
        }
        return this.customAttributes_;
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static NetworkRequestMetric parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (NetworkRequestMetric) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NetworkRequestMetric parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (NetworkRequestMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static t0<NetworkRequestMetric> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    public void removePerfSessions(int i10) {
        ensurePerfSessionsIsMutable();
        this.perfSessions_.remove(i10);
    }

    /* access modifiers changed from: private */
    public void setClientStartTimeUs(long j10) {
        this.bitField0_ |= 128;
        this.clientStartTimeUs_ = j10;
    }

    /* access modifiers changed from: private */
    public void setHttpMethod(HttpMethod httpMethod) {
        this.httpMethod_ = httpMethod.getNumber();
        this.bitField0_ |= 2;
    }

    /* access modifiers changed from: private */
    public void setHttpResponseCode(int i10) {
        this.bitField0_ |= 32;
        this.httpResponseCode_ = i10;
    }

    /* access modifiers changed from: private */
    public void setNetworkClientErrorReason(NetworkClientErrorReason networkClientErrorReason) {
        this.networkClientErrorReason_ = networkClientErrorReason.getNumber();
        this.bitField0_ |= 16;
    }

    /* access modifiers changed from: private */
    public void setPerfSessions(int i10, PerfSession perfSession) {
        perfSession.getClass();
        ensurePerfSessionsIsMutable();
        this.perfSessions_.set(i10, perfSession);
    }

    /* access modifiers changed from: private */
    public void setRequestPayloadBytes(long j10) {
        this.bitField0_ |= 4;
        this.requestPayloadBytes_ = j10;
    }

    /* access modifiers changed from: private */
    public void setResponseContentType(String str) {
        str.getClass();
        this.bitField0_ |= 64;
        this.responseContentType_ = str;
    }

    /* access modifiers changed from: private */
    public void setResponseContentTypeBytes(ByteString byteString) {
        this.responseContentType_ = byteString.T();
        this.bitField0_ |= 64;
    }

    /* access modifiers changed from: private */
    public void setResponsePayloadBytes(long j10) {
        this.bitField0_ |= 8;
        this.responsePayloadBytes_ = j10;
    }

    /* access modifiers changed from: private */
    public void setTimeToRequestCompletedUs(long j10) {
        this.bitField0_ |= 256;
        this.timeToRequestCompletedUs_ = j10;
    }

    /* access modifiers changed from: private */
    public void setTimeToResponseCompletedUs(long j10) {
        this.bitField0_ |= 1024;
        this.timeToResponseCompletedUs_ = j10;
    }

    /* access modifiers changed from: private */
    public void setTimeToResponseInitiatedUs(long j10) {
        this.bitField0_ |= 512;
        this.timeToResponseInitiatedUs_ = j10;
    }

    /* access modifiers changed from: private */
    public void setUrl(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.url_ = str;
    }

    /* access modifiers changed from: private */
    public void setUrlBytes(ByteString byteString) {
        this.url_ = byteString.T();
        this.bitField0_ |= 1;
    }

    public boolean containsCustomAttributes(String str) {
        str.getClass();
        return internalGetCustomAttributes().containsKey(str);
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new NetworkRequestMetric();
            case 2:
                return new Builder((AnonymousClass1) null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\r\u0000\u0001\u0001\r\r\u0001\u0001\u0000\u0001ဈ\u0000\u0002ဌ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005င\u0005\u0006ဈ\u0006\u0007ဂ\u0007\bဂ\b\tဂ\t\nဂ\n\u000bဌ\u0004\f2\r\u001b", new Object[]{"bitField0_", "url_", "httpMethod_", HttpMethod.internalGetVerifier(), "requestPayloadBytes_", "responsePayloadBytes_", "httpResponseCode_", "responseContentType_", "clientStartTimeUs_", "timeToRequestCompletedUs_", "timeToResponseInitiatedUs_", "timeToResponseCompletedUs_", "networkClientErrorReason_", NetworkClientErrorReason.internalGetVerifier(), "customAttributes_", CustomAttributesDefaultEntryHolder.defaultEntry, "perfSessions_", PerfSession.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                t0<NetworkRequestMetric> t0Var = PARSER;
                if (t0Var == null) {
                    synchronized (NetworkRequestMetric.class) {
                        t0Var = PARSER;
                        if (t0Var == null) {
                            t0Var = new GeneratedMessageLite.b<>(DEFAULT_INSTANCE);
                            PARSER = t0Var;
                        }
                    }
                }
                return t0Var;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public long getClientStartTimeUs() {
        return this.clientStartTimeUs_;
    }

    @Deprecated
    public Map<String, String> getCustomAttributes() {
        return getCustomAttributesMap();
    }

    public int getCustomAttributesCount() {
        return internalGetCustomAttributes().size();
    }

    public Map<String, String> getCustomAttributesMap() {
        return Collections.unmodifiableMap(internalGetCustomAttributes());
    }

    public String getCustomAttributesOrDefault(String str, String str2) {
        str.getClass();
        MapFieldLite<String, String> internalGetCustomAttributes = internalGetCustomAttributes();
        if (internalGetCustomAttributes.containsKey(str)) {
            return internalGetCustomAttributes.get(str);
        }
        return str2;
    }

    public String getCustomAttributesOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, String> internalGetCustomAttributes = internalGetCustomAttributes();
        if (internalGetCustomAttributes.containsKey(str)) {
            return internalGetCustomAttributes.get(str);
        }
        throw new IllegalArgumentException();
    }

    public HttpMethod getHttpMethod() {
        HttpMethod forNumber = HttpMethod.forNumber(this.httpMethod_);
        if (forNumber == null) {
            return HttpMethod.HTTP_METHOD_UNKNOWN;
        }
        return forNumber;
    }

    public int getHttpResponseCode() {
        return this.httpResponseCode_;
    }

    public NetworkClientErrorReason getNetworkClientErrorReason() {
        NetworkClientErrorReason forNumber = NetworkClientErrorReason.forNumber(this.networkClientErrorReason_);
        if (forNumber == null) {
            return NetworkClientErrorReason.NETWORK_CLIENT_ERROR_REASON_UNKNOWN;
        }
        return forNumber;
    }

    public PerfSession getPerfSessions(int i10) {
        return this.perfSessions_.get(i10);
    }

    public int getPerfSessionsCount() {
        return this.perfSessions_.size();
    }

    public List<PerfSession> getPerfSessionsList() {
        return this.perfSessions_;
    }

    public PerfSessionOrBuilder getPerfSessionsOrBuilder(int i10) {
        return this.perfSessions_.get(i10);
    }

    public List<? extends PerfSessionOrBuilder> getPerfSessionsOrBuilderList() {
        return this.perfSessions_;
    }

    public long getRequestPayloadBytes() {
        return this.requestPayloadBytes_;
    }

    public String getResponseContentType() {
        return this.responseContentType_;
    }

    public ByteString getResponseContentTypeBytes() {
        return ByteString.s(this.responseContentType_);
    }

    public long getResponsePayloadBytes() {
        return this.responsePayloadBytes_;
    }

    public long getTimeToRequestCompletedUs() {
        return this.timeToRequestCompletedUs_;
    }

    public long getTimeToResponseCompletedUs() {
        return this.timeToResponseCompletedUs_;
    }

    public long getTimeToResponseInitiatedUs() {
        return this.timeToResponseInitiatedUs_;
    }

    public String getUrl() {
        return this.url_;
    }

    public ByteString getUrlBytes() {
        return ByteString.s(this.url_);
    }

    public boolean hasClientStartTimeUs() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasHttpMethod() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasHttpResponseCode() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasNetworkClientErrorReason() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasRequestPayloadBytes() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasResponseContentType() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasResponsePayloadBytes() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasTimeToRequestCompletedUs() {
        return (this.bitField0_ & 256) != 0;
    }

    public boolean hasTimeToResponseCompletedUs() {
        return (this.bitField0_ & 1024) != 0;
    }

    public boolean hasTimeToResponseInitiatedUs() {
        return (this.bitField0_ & 512) != 0;
    }

    public boolean hasUrl() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(NetworkRequestMetric networkRequestMetric) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(networkRequestMetric);
    }

    public static NetworkRequestMetric parseDelimitedFrom(InputStream inputStream, n nVar) throws IOException {
        return (NetworkRequestMetric) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, nVar);
    }

    public static NetworkRequestMetric parseFrom(ByteBuffer byteBuffer, n nVar) throws InvalidProtocolBufferException {
        return (NetworkRequestMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, nVar);
    }

    public static NetworkRequestMetric parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (NetworkRequestMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* access modifiers changed from: private */
    public void addPerfSessions(int i10, PerfSession perfSession) {
        perfSession.getClass();
        ensurePerfSessionsIsMutable();
        this.perfSessions_.add(i10, perfSession);
    }

    public static NetworkRequestMetric parseFrom(ByteString byteString, n nVar) throws InvalidProtocolBufferException {
        return (NetworkRequestMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, nVar);
    }

    public static NetworkRequestMetric parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (NetworkRequestMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static NetworkRequestMetric parseFrom(byte[] bArr, n nVar) throws InvalidProtocolBufferException {
        return (NetworkRequestMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, nVar);
    }

    public static NetworkRequestMetric parseFrom(InputStream inputStream) throws IOException {
        return (NetworkRequestMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NetworkRequestMetric parseFrom(InputStream inputStream, n nVar) throws IOException {
        return (NetworkRequestMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, nVar);
    }

    public static NetworkRequestMetric parseFrom(h hVar) throws IOException {
        return (NetworkRequestMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, hVar);
    }

    public static NetworkRequestMetric parseFrom(h hVar, n nVar) throws IOException {
        return (NetworkRequestMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, hVar, nVar);
    }
}
