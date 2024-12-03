package com.facebook.appevents.cloudbridge;

import com.facebook.GraphRequest;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.stetho.server.http.HttpHeaders;
import com.google.firebase.sessions.settings.RemoteSettings;
import gk.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.p;
import kotlin.ranges.IntRange;
import org.apache.commons.beanutils.PropertyUtils;
import org.json.a;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001DB\t\b\u0002¢\u0006\u0004\bB\u0010CJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0007J\n\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0007J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0007J$\u0010\u000e\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\r\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\tH\u0002J=\u0010\u0015\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0018\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\r0\f2\b\b\u0002\u0010\u0012\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u0019\u001a\u00020\u00062\u001a\u0010\u0016\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\r\u0018\u00010\fH\u0000¢\u0006\u0004\b\u0017\u0010\u0018Ji\u0010#\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r2\b\b\u0002\u0010\u001e\u001a\u00020\u000f2\u001e\u0010 \u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001fH\u0000¢\u0006\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u000f8\u0000XT¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\u000f8\u0002XT¢\u0006\u0006\n\u0004\b(\u0010'R\u0014\u0010)\u001a\u00020\u000f8\u0002XT¢\u0006\u0006\n\u0004\b)\u0010'R$\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u000f0*j\b\u0012\u0004\u0012\u00020\u000f`+8\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R$\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\u000f0*j\b\u0012\u0004\u0012\u00020\u000f`+8\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010-R\"\u00100\u001a\u00020/8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R4\u00107\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\r068\u0000@\u0000X.¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010\u0018R\u0014\u0010<\u001a\u00020\u000f8\u0000XT¢\u0006\u0006\n\u0004\b<\u0010'R\"\u0010=\u001a\u00020\u000f8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b=\u0010'\u001a\u0004\b>\u0010?\"\u0004\b@\u0010A¨\u0006E"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests;", "", "", "datasetID", "url", "accessKey", "", "configure", "getCredentials", "Lcom/facebook/GraphRequest;", "request", "transformGraphRequestAndSendToCAPIGEndPoint", "", "", "transformAppEventRequestForCAPIG", "", "responseCode", "processedEvents", "maxRetryCount", "handleError$facebook_core_release", "(Ljava/lang/Integer;Ljava/util/List;I)V", "handleError", "events", "appendEvents$facebook_core_release", "(Ljava/util/List;)V", "appendEvents", "urlStr", "requestMethod", "jsonBodyStr", "requestProperties", "timeOutInterval", "Lkotlin/Function2;", "requestCallback", "makeHttpRequest$facebook_core_release", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;ILkotlin/jvm/functions/Function2;)V", "makeHttpRequest", "TAG", "Ljava/lang/String;", "MAX_CACHED_TRANSFORMED_EVENTS", "I", "MAX_PROCESSED_TRANSFORMED_EVENTS", "TIMEOUT_INTERVAL", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "ACCEPTABLE_HTTP_RESPONSE", "Ljava/util/HashSet;", "RETRY_EVENTS_HTTP_RESPONSE", "Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials;", "credentials", "Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials;", "getCredentials$facebook_core_release", "()Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials;", "setCredentials$facebook_core_release", "(Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials;)V", "", "transformedEvents", "Ljava/util/List;", "getTransformedEvents$facebook_core_release", "()Ljava/util/List;", "setTransformedEvents$facebook_core_release", "MAX_RETRY_COUNT", "currentRetryCount", "getCurrentRetryCount$facebook_core_release", "()I", "setCurrentRetryCount$facebook_core_release", "(I)V", "<init>", "()V", "CloudBridgeCredentials", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class AppEventsConversionsAPITransformerWebRequests {
    /* access modifiers changed from: private */
    public static final HashSet<Integer> ACCEPTABLE_HTTP_RESPONSE = n0.f(200, 202);
    public static final AppEventsConversionsAPITransformerWebRequests INSTANCE = new AppEventsConversionsAPITransformerWebRequests();
    public static final int MAX_CACHED_TRANSFORMED_EVENTS = 1000;
    private static final int MAX_PROCESSED_TRANSFORMED_EVENTS = 10;
    public static final int MAX_RETRY_COUNT = 5;
    private static final HashSet<Integer> RETRY_EVENTS_HTTP_RESPONSE = n0.f(503, 504, 429);
    private static final String TAG = "CAPITransformerWebRequests";
    private static final int TIMEOUT_INTERVAL = 60000;
    public static CloudBridgeCredentials credentials;
    private static int currentRetryCount;
    public static List<Map<String, Object>> transformedEvents;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials;", "", "datasetID", "", "cloudBridgeURL", "accessKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccessKey", "()Ljava/lang/String;", "getCloudBridgeURL", "getDatasetID", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class CloudBridgeCredentials {
        private final String accessKey;
        private final String cloudBridgeURL;
        private final String datasetID;

        public CloudBridgeCredentials(String str, String str2, String str3) {
            j.g(str, "datasetID");
            j.g(str2, "cloudBridgeURL");
            j.g(str3, "accessKey");
            this.datasetID = str;
            this.cloudBridgeURL = str2;
            this.accessKey = str3;
        }

        public static /* synthetic */ CloudBridgeCredentials copy$default(CloudBridgeCredentials cloudBridgeCredentials, String str, String str2, String str3, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = cloudBridgeCredentials.datasetID;
            }
            if ((i10 & 2) != 0) {
                str2 = cloudBridgeCredentials.cloudBridgeURL;
            }
            if ((i10 & 4) != 0) {
                str3 = cloudBridgeCredentials.accessKey;
            }
            return cloudBridgeCredentials.copy(str, str2, str3);
        }

        public final String component1() {
            return this.datasetID;
        }

        public final String component2() {
            return this.cloudBridgeURL;
        }

        public final String component3() {
            return this.accessKey;
        }

        public final CloudBridgeCredentials copy(String str, String str2, String str3) {
            j.g(str, "datasetID");
            j.g(str2, "cloudBridgeURL");
            j.g(str3, "accessKey");
            return new CloudBridgeCredentials(str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CloudBridgeCredentials)) {
                return false;
            }
            CloudBridgeCredentials cloudBridgeCredentials = (CloudBridgeCredentials) obj;
            return j.b(this.datasetID, cloudBridgeCredentials.datasetID) && j.b(this.cloudBridgeURL, cloudBridgeCredentials.cloudBridgeURL) && j.b(this.accessKey, cloudBridgeCredentials.accessKey);
        }

        public final String getAccessKey() {
            return this.accessKey;
        }

        public final String getCloudBridgeURL() {
            return this.cloudBridgeURL;
        }

        public final String getDatasetID() {
            return this.datasetID;
        }

        public int hashCode() {
            return (((this.datasetID.hashCode() * 31) + this.cloudBridgeURL.hashCode()) * 31) + this.accessKey.hashCode();
        }

        public String toString() {
            return "CloudBridgeCredentials(datasetID=" + this.datasetID + ", cloudBridgeURL=" + this.cloudBridgeURL + ", accessKey=" + this.accessKey + PropertyUtils.MAPPED_DELIM2;
        }
    }

    private AppEventsConversionsAPITransformerWebRequests() {
    }

    public static final void configure(String str, String str2, String str3) {
        j.g(str, "datasetID");
        j.g(str2, "url");
        j.g(str3, "accessKey");
        Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG, " \n\nCloudbridge Configured: \n================\ndatasetID: %s\nurl: %s\naccessKey: %s\n\n", str, str2, str3);
        AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests = INSTANCE;
        appEventsConversionsAPITransformerWebRequests.setCredentials$facebook_core_release(new CloudBridgeCredentials(str, str2, str3));
        appEventsConversionsAPITransformerWebRequests.setTransformedEvents$facebook_core_release(new ArrayList());
    }

    public static final String getCredentials() {
        try {
            CloudBridgeCredentials credentials$facebook_core_release = INSTANCE.getCredentials$facebook_core_release();
            if (credentials$facebook_core_release == null) {
                return null;
            }
            return credentials$facebook_core_release.toString();
        } catch (UninitializedPropertyAccessException unused) {
            return null;
        }
    }

    public static /* synthetic */ void handleError$facebook_core_release$default(AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests, Integer num, List list, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = 5;
        }
        appEventsConversionsAPITransformerWebRequests.handleError$facebook_core_release(num, list, i10);
    }

    public static /* synthetic */ void makeHttpRequest$facebook_core_release$default(AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests, String str, String str2, String str3, Map map, int i10, Function2 function2, int i11, Object obj) {
        if ((i11 & 16) != 0) {
            i10 = TIMEOUT_INTERVAL;
        }
        appEventsConversionsAPITransformerWebRequests.makeHttpRequest$facebook_core_release(str, str2, str3, map, i10, function2);
    }

    private final List<Map<String, Object>> transformAppEventRequestForCAPIG(GraphRequest graphRequest) {
        b graphObject = graphRequest.getGraphObject();
        if (graphObject == null) {
            return null;
        }
        Map w10 = h0.w(Utility.convertJSONObjectToHashMap(graphObject));
        Object tag = graphRequest.getTag();
        if (tag != null) {
            w10.put("custom_events", tag);
            StringBuilder sb2 = new StringBuilder();
            for (String str : w10.keySet()) {
                sb2.append(str);
                sb2.append(" : ");
                sb2.append(w10.get(str));
                sb2.append(System.getProperty("line.separator"));
            }
            Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG, "\nGraph Request data: \n\n%s \n\n", sb2);
            return AppEventsConversionsAPITransformer.INSTANCE.conversionsAPICompatibleEvent$facebook_core_release(w10);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
    }

    public static final void transformGraphRequestAndSendToCAPIGEndPoint(GraphRequest graphRequest) {
        j.g(graphRequest, "request");
        Utility utility = Utility.INSTANCE;
        Utility.runOnNonUiThread(new b(graphRequest));
    }

    /* access modifiers changed from: private */
    /* renamed from: transformGraphRequestAndSendToCAPIGEndPoint$lambda-0  reason: not valid java name */
    public static final void m57transformGraphRequestAndSendToCAPIGEndPoint$lambda0(GraphRequest graphRequest) {
        List list;
        j.g(graphRequest, "$request");
        String graphPath = graphRequest.getGraphPath();
        if (graphPath == null) {
            list = null;
        } else {
            list = StringsKt__StringsKt.C0(graphPath, new String[]{RemoteSettings.FORWARD_SLASH_STRING}, false, 0, 6, (Object) null);
        }
        if (list == null || list.size() != 2) {
            Logger.Companion.log(LoggingBehavior.DEVELOPER_ERRORS, TAG, "\n GraphPathComponents Error when logging: \n%s", graphRequest);
            return;
        }
        try {
            AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests = INSTANCE;
            String str = appEventsConversionsAPITransformerWebRequests.getCredentials$facebook_core_release().getCloudBridgeURL() + "/capi/" + appEventsConversionsAPITransformerWebRequests.getCredentials$facebook_core_release().getDatasetID() + "/events";
            List<Map<String, Object>> transformAppEventRequestForCAPIG = appEventsConversionsAPITransformerWebRequests.transformAppEventRequestForCAPIG(graphRequest);
            if (transformAppEventRequestForCAPIG != null) {
                appEventsConversionsAPITransformerWebRequests.appendEvents$facebook_core_release(transformAppEventRequestForCAPIG);
                int min = Math.min(appEventsConversionsAPITransformerWebRequests.getTransformedEvents$facebook_core_release().size(), 10);
                List n02 = CollectionsKt___CollectionsKt.n0(appEventsConversionsAPITransformerWebRequests.getTransformedEvents$facebook_core_release(), new IntRange(0, min - 1));
                appEventsConversionsAPITransformerWebRequests.getTransformedEvents$facebook_core_release().subList(0, min).clear();
                a aVar = new a((Collection<?>) n02);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("data", aVar);
                linkedHashMap.put("accessKey", appEventsConversionsAPITransformerWebRequests.getCredentials$facebook_core_release().getAccessKey());
                b bVar = new b((Map<?, ?>) linkedHashMap);
                Logger.Companion companion = Logger.Companion;
                LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
                String bVar2 = bVar.toString(2);
                j.f(bVar2, "jsonBodyStr.toString(2)");
                companion.log(loggingBehavior, TAG, "\nTransformed_CAPI_JSON:\nURL: %s\nFROM=========\n%s\n>>>>>>TO>>>>>>\n%s\n=============\n", str, graphRequest, bVar2);
                appEventsConversionsAPITransformerWebRequests.makeHttpRequest$facebook_core_release(str, "POST", bVar.toString(), g0.f(h.a(HttpHeaders.CONTENT_TYPE, "application/json")), TIMEOUT_INTERVAL, new AppEventsConversionsAPITransformerWebRequests$transformGraphRequestAndSendToCAPIGEndPoint$1$1(n02));
            }
        } catch (UninitializedPropertyAccessException e10) {
            Logger.Companion.log(LoggingBehavior.DEVELOPER_ERRORS, TAG, "\n Credentials not initialized Error when logging: \n%s", e10);
        }
    }

    public final void appendEvents$facebook_core_release(List<? extends Map<String, ? extends Object>> list) {
        if (list != null) {
            getTransformedEvents$facebook_core_release().addAll(list);
        }
        int max = Math.max(0, getTransformedEvents$facebook_core_release().size() - 1000);
        if (max > 0) {
            setTransformedEvents$facebook_core_release(p.b(CollectionsKt___CollectionsKt.G(getTransformedEvents$facebook_core_release(), max)));
        }
    }

    public final CloudBridgeCredentials getCredentials$facebook_core_release() {
        CloudBridgeCredentials cloudBridgeCredentials = credentials;
        if (cloudBridgeCredentials != null) {
            return cloudBridgeCredentials;
        }
        j.y("credentials");
        throw null;
    }

    public final int getCurrentRetryCount$facebook_core_release() {
        return currentRetryCount;
    }

    public final List<Map<String, Object>> getTransformedEvents$facebook_core_release() {
        List<Map<String, Object>> list = transformedEvents;
        if (list != null) {
            return list;
        }
        j.y("transformedEvents");
        throw null;
    }

    public final void handleError$facebook_core_release(Integer num, List<? extends Map<String, ? extends Object>> list, int i10) {
        j.g(list, "processedEvents");
        if (!CollectionsKt___CollectionsKt.E(RETRY_EVENTS_HTTP_RESPONSE, num)) {
            return;
        }
        if (currentRetryCount >= i10) {
            getTransformedEvents$facebook_core_release().clear();
            currentRetryCount = 0;
            return;
        }
        getTransformedEvents$facebook_core_release().addAll(0, list);
        currentRetryCount++;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b3, code lost:
        r11 = kotlin.Unit.f32013a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        kotlin.io.b.a(r10, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00bb, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        kotlin.io.b.a(r10, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00bf, code lost:
        throw r9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009b A[Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e3 A[Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void makeHttpRequest$facebook_core_release(java.lang.String r8, java.lang.String r9, java.lang.String r10, java.util.Map<java.lang.String, java.lang.String> r11, int r12, kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Integer, kotlin.Unit> r13) {
        /*
            r7 = this;
            java.lang.String r0 = "UTF-8"
            java.lang.String r1 = "CAPITransformerWebRequests"
            java.lang.String r2 = "urlStr"
            kotlin.jvm.internal.j.g(r8, r2)
            java.lang.String r2 = "requestMethod"
            kotlin.jvm.internal.j.g(r9, r2)
            r2 = 0
            r3 = 0
            r4 = 1
            java.net.URL r5 = new java.net.URL     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            r5.<init>(r8)     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            java.net.URLConnection r8 = r5.openConnection()     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            if (r8 == 0) goto L_0x00ef
            java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            r8.setRequestMethod(r9)     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            if (r11 != 0) goto L_0x0024
            goto L_0x0045
        L_0x0024:
            java.util.Set r9 = r11.keySet()     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            if (r9 != 0) goto L_0x002b
            goto L_0x0045
        L_0x002b:
            java.util.Iterator r9 = r9.iterator()     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
        L_0x002f:
            boolean r5 = r9.hasNext()     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            if (r5 == 0) goto L_0x0045
            java.lang.Object r5 = r9.next()     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            java.lang.Object r6 = r11.get(r5)     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            r8.setRequestProperty(r5, r6)     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            goto L_0x002f
        L_0x0045:
            java.lang.String r9 = r8.getRequestMethod()     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            java.lang.String r11 = "POST"
            boolean r9 = r9.equals(r11)     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            if (r9 != 0) goto L_0x0060
            java.lang.String r9 = r8.getRequestMethod()     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            java.lang.String r11 = "PUT"
            boolean r9 = r9.equals(r11)     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            if (r9 == 0) goto L_0x005e
            goto L_0x0060
        L_0x005e:
            r9 = r3
            goto L_0x0061
        L_0x0060:
            r9 = r4
        L_0x0061:
            r8.setDoOutput(r9)     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            r8.setConnectTimeout(r12)     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            java.io.BufferedOutputStream r9 = new java.io.BufferedOutputStream     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            java.io.OutputStream r11 = r8.getOutputStream()     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            r9.<init>(r11)     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            java.io.BufferedWriter r11 = new java.io.BufferedWriter     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            java.io.OutputStreamWriter r12 = new java.io.OutputStreamWriter     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            r12.<init>(r9, r0)     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            r11.<init>(r12)     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            r11.write(r10)     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            r11.flush()     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            r11.close()     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            r9.close()     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            r9.<init>()     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            java.util.HashSet<java.lang.Integer> r10 = ACCEPTABLE_HTTP_RESPONSE     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            int r11 = r8.getResponseCode()     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            boolean r10 = r10.contains(r11)     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            if (r10 == 0) goto L_0x00c0
            java.io.BufferedReader r10 = new java.io.BufferedReader     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            java.io.InputStreamReader r11 = new java.io.InputStreamReader     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            java.io.InputStream r12 = r8.getInputStream()     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            r11.<init>(r12, r0)     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            r10.<init>(r11)     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
        L_0x00a9:
            java.lang.String r11 = r10.readLine()     // Catch:{ all -> 0x00b9 }
            if (r11 == 0) goto L_0x00b3
            r9.append(r11)     // Catch:{ all -> 0x00b9 }
            goto L_0x00a9
        L_0x00b3:
            kotlin.Unit r11 = kotlin.Unit.f32013a     // Catch:{ all -> 0x00b9 }
            kotlin.io.b.a(r10, r2)     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            goto L_0x00c0
        L_0x00b9:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x00bb }
        L_0x00bb:
            r9 = move-exception
            kotlin.io.b.a(r10, r8)     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            throw r9     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
        L_0x00c0:
            java.lang.String r9 = r9.toString()     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            java.lang.String r10 = "connResponseSB.toString()"
            kotlin.jvm.internal.j.f(r9, r10)     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            com.facebook.internal.Logger$Companion r10 = com.facebook.internal.Logger.Companion     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            com.facebook.LoggingBehavior r11 = com.facebook.LoggingBehavior.APP_EVENTS     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            java.lang.String r12 = "\nResponse Received: \n%s\n%s"
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            r0[r3] = r9     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            int r5 = r8.getResponseCode()     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            r0[r4] = r5     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            r10.log((com.facebook.LoggingBehavior) r11, (java.lang.String) r1, (java.lang.String) r12, (java.lang.Object[]) r0)     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            if (r13 == 0) goto L_0x0127
            int r8 = r8.getResponseCode()     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            r13.invoke(r9, r8)     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            goto L_0x0127
        L_0x00ef:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            java.lang.String r9 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            r8.<init>(r9)     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
            throw r8     // Catch:{ UnknownHostException -> 0x010a, IOException -> 0x00f7 }
        L_0x00f7:
            r8 = move-exception
            com.facebook.internal.Logger$Companion r9 = com.facebook.internal.Logger.Companion
            com.facebook.LoggingBehavior r10 = com.facebook.LoggingBehavior.DEVELOPER_ERRORS
            java.lang.Object[] r11 = new java.lang.Object[r4]
            java.lang.String r8 = r8.toString()
            r11[r3] = r8
            java.lang.String r8 = "Send to server failed: \n%s"
            r9.log((com.facebook.LoggingBehavior) r10, (java.lang.String) r1, (java.lang.String) r8, (java.lang.Object[]) r11)
            goto L_0x0127
        L_0x010a:
            r8 = move-exception
            com.facebook.internal.Logger$Companion r9 = com.facebook.internal.Logger.Companion
            com.facebook.LoggingBehavior r10 = com.facebook.LoggingBehavior.APP_EVENTS
            java.lang.Object[] r11 = new java.lang.Object[r4]
            java.lang.String r8 = r8.toString()
            r11[r3] = r8
            java.lang.String r8 = "Connection failed, retrying: \n%s"
            r9.log((com.facebook.LoggingBehavior) r10, (java.lang.String) r1, (java.lang.String) r8, (java.lang.Object[]) r11)
            if (r13 == 0) goto L_0x0127
            r8 = 503(0x1f7, float:7.05E-43)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r13.invoke(r2, r8)
        L_0x0127:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformerWebRequests.makeHttpRequest$facebook_core_release(java.lang.String, java.lang.String, java.lang.String, java.util.Map, int, kotlin.jvm.functions.Function2):void");
    }

    public final void setCredentials$facebook_core_release(CloudBridgeCredentials cloudBridgeCredentials) {
        j.g(cloudBridgeCredentials, "<set-?>");
        credentials = cloudBridgeCredentials;
    }

    public final void setCurrentRetryCount$facebook_core_release(int i10) {
        currentRetryCount = i10;
    }

    public final void setTransformedEvents$facebook_core_release(List<Map<String, Object>> list) {
        j.g(list, "<set-?>");
        transformedEvents = list;
    }
}
