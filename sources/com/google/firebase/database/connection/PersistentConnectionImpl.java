package com.google.firebase.database.connection;

import com.coffeemeetsbagel.models.NetworkProfile;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.database.connection.Connection;
import com.google.firebase.database.connection.ConnectionTokenProvider;
import com.google.firebase.database.connection.PersistentConnection;
import com.google.firebase.database.connection.util.RetryHelper;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.logging.Logger;
import com.google.firebase.database.util.GAuthToken;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

public class PersistentConnectionImpl implements Connection.Delegate, PersistentConnection {
    private static final String IDLE_INTERRUPT_REASON = "connection_idle";
    private static final long IDLE_TIMEOUT = 60000;
    private static final String INVALID_APP_CHECK_TOKEN = "Invalid appcheck token";
    private static final long INVALID_TOKEN_THRESHOLD = 3;
    private static final String REQUEST_ACTION = "a";
    private static final String REQUEST_ACTION_APPCHECK = "appcheck";
    private static final String REQUEST_ACTION_AUTH = "auth";
    private static final String REQUEST_ACTION_GAUTH = "gauth";
    private static final String REQUEST_ACTION_GET = "g";
    private static final String REQUEST_ACTION_MERGE = "m";
    private static final String REQUEST_ACTION_ONDISCONNECT_CANCEL = "oc";
    private static final String REQUEST_ACTION_ONDISCONNECT_MERGE = "om";
    private static final String REQUEST_ACTION_ONDISCONNECT_PUT = "o";
    private static final String REQUEST_ACTION_PUT = "p";
    private static final String REQUEST_ACTION_QUERY = "q";
    private static final String REQUEST_ACTION_QUERY_UNLISTEN = "n";
    private static final String REQUEST_ACTION_STATS = "s";
    private static final String REQUEST_ACTION_UNAPPCHECK = "unappcheck";
    private static final String REQUEST_ACTION_UNAUTH = "unauth";
    private static final String REQUEST_APPCHECK_TOKEN = "token";
    private static final String REQUEST_AUTHVAR = "authvar";
    private static final String REQUEST_COMPOUND_HASH = "ch";
    private static final String REQUEST_COMPOUND_HASH_HASHES = "hs";
    private static final String REQUEST_COMPOUND_HASH_PATHS = "ps";
    private static final String REQUEST_COUNTERS = "c";
    private static final String REQUEST_CREDENTIAL = "cred";
    private static final String REQUEST_DATA_HASH = "h";
    private static final String REQUEST_DATA_PAYLOAD = "d";
    private static final String REQUEST_ERROR = "error";
    private static final String REQUEST_NUMBER = "r";
    private static final String REQUEST_PATH = "p";
    private static final String REQUEST_PAYLOAD = "b";
    private static final String REQUEST_QUERIES = "q";
    private static final String REQUEST_STATUS = "s";
    private static final String REQUEST_TAG = "t";
    private static final String RESPONSE_FOR_REQUEST = "b";
    private static final String SERVER_ASYNC_ACTION = "a";
    private static final String SERVER_ASYNC_APP_CHECK_REVOKED = "apc";
    private static final String SERVER_ASYNC_AUTH_REVOKED = "ac";
    private static final String SERVER_ASYNC_DATA_MERGE = "m";
    private static final String SERVER_ASYNC_DATA_RANGE_MERGE = "rm";
    private static final String SERVER_ASYNC_DATA_UPDATE = "d";
    private static final String SERVER_ASYNC_LISTEN_CANCELLED = "c";
    private static final String SERVER_ASYNC_PAYLOAD = "b";
    private static final String SERVER_ASYNC_SECURITY_DEBUG = "sd";
    private static final String SERVER_DATA_END_PATH = "e";
    private static final String SERVER_DATA_RANGE_MERGE = "m";
    private static final String SERVER_DATA_START_PATH = "s";
    private static final String SERVER_DATA_TAG = "t";
    private static final String SERVER_DATA_UPDATE_BODY = "d";
    private static final String SERVER_DATA_UPDATE_PATH = "p";
    private static final String SERVER_DATA_WARNINGS = "w";
    private static final String SERVER_KILL_INTERRUPT_REASON = "server_kill";
    private static final String SERVER_RESPONSE_DATA = "d";
    private static final long SUCCESSFUL_CONNECTION_ESTABLISHED_DELAY = 30000;
    private static final String TOKEN_REFRESH_INTERRUPT_REASON = "token_refresh";
    private static long connectionIds;
    private String appCheckToken;
    private final ConnectionTokenProvider appCheckTokenProvider;
    /* access modifiers changed from: private */
    public String authToken;
    private final ConnectionTokenProvider authTokenProvider;
    private String cachedHost;
    /* access modifiers changed from: private */
    public ConnectionState connectionState = ConnectionState.Disconnected;
    private final ConnectionContext context;
    private long currentGetTokenAttempt = 0;
    /* access modifiers changed from: private */
    public final PersistentConnection.Delegate delegate;
    private final ScheduledExecutorService executorService;
    private boolean firstConnection = true;
    private boolean forceAppCheckTokenRefresh;
    /* access modifiers changed from: private */
    public boolean forceAuthTokenRefresh;
    private boolean hasOnDisconnects;
    private final HostInfo hostInfo;
    /* access modifiers changed from: private */
    public ScheduledFuture<?> inactivityTimer = null;
    private HashSet<String> interruptReasons = new HashSet<>();
    private int invalidAppCheckTokenCount = 0;
    /* access modifiers changed from: private */
    public int invalidAuthTokenCount = 0;
    private long lastConnectionEstablishedTime;
    private String lastSessionId;
    private long lastWriteTimestamp;
    /* access modifiers changed from: private */
    public Map<QuerySpec, OutstandingListen> listens;
    /* access modifiers changed from: private */
    public final LogWrapper logger;
    private List<OutstandingDisconnect> onDisconnectRequestQueue;
    /* access modifiers changed from: private */
    public Map<Long, OutstandingGet> outstandingGets;
    /* access modifiers changed from: private */
    public Map<Long, OutstandingPut> outstandingPuts;
    private long readCounter = 0;
    /* access modifiers changed from: private */
    public Connection realtime;
    private Map<Long, ConnectionRequestCallback> requestCBHash;
    private long requestCounter = 0;
    /* access modifiers changed from: private */
    public final RetryHelper retryHelper;
    private long writeCounter = 0;

    private interface ConnectionRequestCallback {
        void onResponse(Map<String, Object> map);
    }

    private enum ConnectionState {
        Disconnected,
        GettingToken,
        Connecting,
        Authenticating,
        Connected
    }

    private static class OutstandingDisconnect {
        private final String action;
        private final Object data;
        /* access modifiers changed from: private */
        public final RequestResultCallback onComplete;
        private final List<String> path;

        public String getAction() {
            return this.action;
        }

        public Object getData() {
            return this.data;
        }

        public RequestResultCallback getOnComplete() {
            return this.onComplete;
        }

        public List<String> getPath() {
            return this.path;
        }

        private OutstandingDisconnect(String str, List<String> list, Object obj, RequestResultCallback requestResultCallback) {
            this.action = str;
            this.path = list;
            this.data = obj;
            this.onComplete = requestResultCallback;
        }
    }

    private static class OutstandingGet {
        private final ConnectionRequestCallback onComplete;
        private final Map<String, Object> request;
        private boolean sent;

        /* access modifiers changed from: private */
        public ConnectionRequestCallback getOnComplete() {
            return this.onComplete;
        }

        /* access modifiers changed from: private */
        public Map<String, Object> getRequest() {
            return this.request;
        }

        /* access modifiers changed from: private */
        public boolean markSent() {
            if (this.sent) {
                return false;
            }
            this.sent = true;
            return true;
        }

        private OutstandingGet(String str, Map<String, Object> map, ConnectionRequestCallback connectionRequestCallback) {
            this.request = map;
            this.onComplete = connectionRequestCallback;
            this.sent = false;
        }
    }

    private static class OutstandingListen {
        private final ListenHashProvider hashFunction;
        /* access modifiers changed from: private */
        public final QuerySpec query;
        /* access modifiers changed from: private */
        public final RequestResultCallback resultCallback;
        private final Long tag;

        public ListenHashProvider getHashFunction() {
            return this.hashFunction;
        }

        public QuerySpec getQuery() {
            return this.query;
        }

        public Long getTag() {
            return this.tag;
        }

        public String toString() {
            return this.query.toString() + " (Tag: " + this.tag + ")";
        }

        private OutstandingListen(RequestResultCallback requestResultCallback, QuerySpec querySpec, Long l10, ListenHashProvider listenHashProvider) {
            this.resultCallback = requestResultCallback;
            this.query = querySpec;
            this.hashFunction = listenHashProvider;
            this.tag = l10;
        }
    }

    private static class OutstandingPut {
        private String action;
        /* access modifiers changed from: private */
        public RequestResultCallback onComplete;
        private Map<String, Object> request;
        private boolean sent;

        public String getAction() {
            return this.action;
        }

        public RequestResultCallback getOnComplete() {
            return this.onComplete;
        }

        public Map<String, Object> getRequest() {
            return this.request;
        }

        public void markSent() {
            this.sent = true;
        }

        public boolean wasSent() {
            return this.sent;
        }

        private OutstandingPut(String str, Map<String, Object> map, RequestResultCallback requestResultCallback) {
            this.action = str;
            this.request = map;
            this.onComplete = requestResultCallback;
        }
    }

    private static class QuerySpec {
        /* access modifiers changed from: private */
        public final List<String> path;
        /* access modifiers changed from: private */
        public final Map<String, Object> queryParams;

        public QuerySpec(List<String> list, Map<String, Object> map) {
            this.path = list;
            this.queryParams = map;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof QuerySpec)) {
                return false;
            }
            QuerySpec querySpec = (QuerySpec) obj;
            if (!this.path.equals(querySpec.path)) {
                return false;
            }
            return this.queryParams.equals(querySpec.queryParams);
        }

        public int hashCode() {
            return (this.path.hashCode() * 31) + this.queryParams.hashCode();
        }

        public String toString() {
            return ConnectionUtils.pathToString(this.path) + " (params: " + this.queryParams + ")";
        }
    }

    public PersistentConnectionImpl(ConnectionContext connectionContext, HostInfo hostInfo2, PersistentConnection.Delegate delegate2) {
        this.delegate = delegate2;
        this.context = connectionContext;
        ScheduledExecutorService executorService2 = connectionContext.getExecutorService();
        this.executorService = executorService2;
        this.authTokenProvider = connectionContext.getAuthTokenProvider();
        this.appCheckTokenProvider = connectionContext.getAppCheckTokenProvider();
        this.hostInfo = hostInfo2;
        this.listens = new HashMap();
        this.requestCBHash = new HashMap();
        this.outstandingPuts = new HashMap();
        this.outstandingGets = new ConcurrentHashMap();
        this.onDisconnectRequestQueue = new ArrayList();
        this.retryHelper = new RetryHelper.Builder(executorService2, connectionContext.getLogger(), "ConnectionRetryHelper").withMinDelayAfterFailure(1000).withRetryExponent(1.3d).withMaxDelay(SUCCESSFUL_CONNECTION_ESTABLISHED_DELAY).withJitterFactor(0.7d).build();
        long j10 = connectionIds;
        connectionIds = 1 + j10;
        Logger logger2 = connectionContext.getLogger();
        this.logger = new LogWrapper(logger2, "PersistentConnection", "pc_" + j10);
        this.lastSessionId = null;
        doIdleCheck();
    }

    static /* synthetic */ int access$1008(PersistentConnectionImpl persistentConnectionImpl) {
        int i10 = persistentConnectionImpl.invalidAuthTokenCount;
        persistentConnectionImpl.invalidAuthTokenCount = i10 + 1;
        return i10;
    }

    private boolean canSendReads() {
        return this.connectionState == ConnectionState.Connected;
    }

    private boolean canSendWrites() {
        return this.connectionState == ConnectionState.Connected;
    }

    private void cancelSentTransactions() {
        ArrayList<OutstandingPut> arrayList = new ArrayList<>();
        Iterator<Map.Entry<Long, OutstandingPut>> it = this.outstandingPuts.entrySet().iterator();
        while (it.hasNext()) {
            OutstandingPut outstandingPut = (OutstandingPut) it.next().getValue();
            if (outstandingPut.getRequest().containsKey("h") && outstandingPut.wasSent()) {
                arrayList.add(outstandingPut);
                it.remove();
            }
        }
        for (OutstandingPut onComplete : arrayList) {
            onComplete.getOnComplete().onRequestResult("disconnected", (String) null);
        }
    }

    private boolean connected() {
        ConnectionState connectionState2 = this.connectionState;
        return connectionState2 == ConnectionState.Authenticating || connectionState2 == ConnectionState.Connected;
    }

    /* access modifiers changed from: private */
    public void doIdleCheck() {
        if (isIdle()) {
            ScheduledFuture<?> scheduledFuture = this.inactivityTimer;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.inactivityTimer = this.executorService.schedule(new Runnable() {
                public void run() {
                    ScheduledFuture unused = PersistentConnectionImpl.this.inactivityTimer = null;
                    if (PersistentConnectionImpl.this.idleHasTimedOut()) {
                        PersistentConnectionImpl.this.interrupt(PersistentConnectionImpl.IDLE_INTERRUPT_REASON);
                    } else {
                        PersistentConnectionImpl.this.doIdleCheck();
                    }
                }
            }, 60000, TimeUnit.MILLISECONDS);
        } else if (isInterrupted(IDLE_INTERRUPT_REASON)) {
            ConnectionUtils.hardAssert(!isIdle());
            resume(IDLE_INTERRUPT_REASON);
        }
    }

    private Task<String> fetchAppCheckToken(boolean z10) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.logger.debug("Trying to fetch app check token", new Object[0]);
        this.appCheckTokenProvider.getToken(z10, new ConnectionTokenProvider.GetTokenCallback() {
            public void onError(String str) {
                taskCompletionSource.setException(new Exception(str));
            }

            public void onSuccess(String str) {
                taskCompletionSource.setResult(str);
            }
        });
        return taskCompletionSource.getTask();
    }

    private Task<String> fetchAuthToken(boolean z10) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.logger.debug("Trying to fetch auth token", new Object[0]);
        this.authTokenProvider.getToken(z10, new ConnectionTokenProvider.GetTokenCallback() {
            public void onError(String str) {
                taskCompletionSource.setException(new Exception(str));
            }

            public void onSuccess(String str) {
                taskCompletionSource.setResult(str);
            }
        });
        return taskCompletionSource.getTask();
    }

    private Map<String, Object> getPutObject(List<String> list, Object obj, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(XHTMLText.P, ConnectionUtils.pathToString(list));
        hashMap.put("d", obj);
        if (str != null) {
            hashMap.put("h", str);
        }
        return hashMap;
    }

    private void handleTimestamp(long j10) {
        if (this.logger.logsDebug()) {
            this.logger.debug("handling timestamp", new Object[0]);
        }
        long currentTimeMillis = j10 - System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.DOT_INFO_SERVERTIME_OFFSET, Long.valueOf(currentTimeMillis));
        this.delegate.onServerInfoUpdate(hashMap);
    }

    /* access modifiers changed from: private */
    public boolean idleHasTimedOut() {
        long currentTimeMillis = System.currentTimeMillis();
        if (!isIdle() || currentTimeMillis <= this.lastWriteTimestamp + 60000) {
            return false;
        }
        return true;
    }

    private boolean isIdle() {
        if (!this.listens.isEmpty() || !this.outstandingGets.isEmpty() || !this.requestCBHash.isEmpty() || this.hasOnDisconnects || !this.outstandingPuts.isEmpty()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$get$0(TaskCompletionSource taskCompletionSource, Map map) {
        if (((String) map.get("s")).equals("ok")) {
            taskCompletionSource.setResult(map.get("d"));
        } else {
            taskCompletionSource.setException(new Exception((String) map.get("d")));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$sendAppCheckTokenHelper$4(boolean z10, Map map) {
        String str = (String) map.get("s");
        if (str.equals("ok")) {
            this.invalidAppCheckTokenCount = 0;
        } else {
            this.appCheckToken = null;
            this.forceAppCheckTokenRefresh = true;
            LogWrapper logWrapper = this.logger;
            logWrapper.debug("App check failed: " + str + " (" + ((String) map.get("d")) + ")", new Object[0]);
        }
        if (z10) {
            restoreState();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$tryScheduleReconnect$1(long j10, Task task, Task task2, Void voidR) {
        if (j10 == this.currentGetTokenAttempt) {
            ConnectionState connectionState2 = this.connectionState;
            if (connectionState2 == ConnectionState.GettingToken) {
                this.logger.debug("Successfully fetched token, opening connection", new Object[0]);
                openNetworkConnection((String) task.getResult(), (String) task2.getResult());
            } else if (connectionState2 == ConnectionState.Disconnected) {
                this.logger.debug("Not opening connection after token refresh, because connection was set to disconnected", new Object[0]);
            }
        } else {
            this.logger.debug("Ignoring getToken result, because this was not the latest attempt.", new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$tryScheduleReconnect$2(long j10, Exception exc) {
        if (j10 == this.currentGetTokenAttempt) {
            this.connectionState = ConnectionState.Disconnected;
            LogWrapper logWrapper = this.logger;
            logWrapper.debug("Error fetching token: " + exc, new Object[0]);
            tryScheduleReconnect();
            return;
        }
        this.logger.debug("Ignoring getToken error, because this was not the latest attempt.", new Object[0]);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$tryScheduleReconnect$3(boolean z10, boolean z11) {
        boolean z12;
        ConnectionState connectionState2 = this.connectionState;
        if (connectionState2 == ConnectionState.Disconnected) {
            z12 = true;
        } else {
            z12 = false;
        }
        ConnectionUtils.hardAssert(z12, "Not in disconnected state: %s", connectionState2);
        this.connectionState = ConnectionState.GettingToken;
        long j10 = this.currentGetTokenAttempt + 1;
        this.currentGetTokenAttempt = j10;
        Task<String> fetchAuthToken = fetchAuthToken(z10);
        Task<String> fetchAppCheckToken = fetchAppCheckToken(z11);
        Tasks.whenAll((Task<?>[]) new Task[]{fetchAuthToken, fetchAppCheckToken}).addOnSuccessListener((Executor) this.executorService, new b(this, j10, fetchAuthToken, fetchAppCheckToken)).addOnFailureListener((Executor) this.executorService, (OnFailureListener) new c(this, j10));
    }

    private long nextRequestNumber() {
        long j10 = this.requestCounter;
        this.requestCounter = 1 + j10;
        return j10;
    }

    private void onAppCheckRevoked(String str, String str2) {
        LogWrapper logWrapper = this.logger;
        logWrapper.debug("App check token revoked: " + str + " (" + str2 + ")", new Object[0]);
        this.appCheckToken = null;
        this.forceAppCheckTokenRefresh = true;
    }

    private void onAuthRevoked(String str, String str2) {
        LogWrapper logWrapper = this.logger;
        logWrapper.debug("Auth token revoked: " + str + " (" + str2 + ")", new Object[0]);
        this.authToken = null;
        this.forceAuthTokenRefresh = true;
        this.delegate.onConnectionStatus(false);
        this.realtime.close();
    }

    private void onDataPush(String str, Map<String, Object> map) {
        List<String> list;
        if (this.logger.logsDebug()) {
            this.logger.debug("handleServerMessage: " + str + " " + map, new Object[0]);
        }
        if (str.equals("d") || str.equals(NetworkProfile.MALE)) {
            boolean equals = str.equals(NetworkProfile.MALE);
            String str2 = (String) map.get(XHTMLText.P);
            Object obj = map.get("d");
            Long longFromObject = ConnectionUtils.longFromObject(map.get("t"));
            if (!equals || !(obj instanceof Map) || ((Map) obj).size() != 0) {
                this.delegate.onDataUpdate(ConnectionUtils.stringToPath(str2), obj, equals, longFromObject);
            } else if (this.logger.logsDebug()) {
                this.logger.debug("ignoring empty merge for path " + str2, new Object[0]);
            }
        } else if (str.equals(SERVER_ASYNC_DATA_RANGE_MERGE)) {
            String str3 = (String) map.get(XHTMLText.P);
            List<String> stringToPath = ConnectionUtils.stringToPath(str3);
            Object obj2 = map.get("d");
            Long longFromObject2 = ConnectionUtils.longFromObject(map.get("t"));
            ArrayList arrayList = new ArrayList();
            for (Map map2 : (List) obj2) {
                String str4 = (String) map2.get("s");
                String str5 = (String) map2.get("e");
                List<String> list2 = null;
                if (str4 != null) {
                    list = ConnectionUtils.stringToPath(str4);
                } else {
                    list = null;
                }
                if (str5 != null) {
                    list2 = ConnectionUtils.stringToPath(str5);
                }
                arrayList.add(new RangeMerge(list, list2, map2.get(NetworkProfile.MALE)));
            }
            if (!arrayList.isEmpty()) {
                this.delegate.onRangeMergeUpdate(stringToPath, arrayList, longFromObject2);
            } else if (this.logger.logsDebug()) {
                this.logger.debug("Ignoring empty range merge for path " + str3, new Object[0]);
            }
        } else if (str.equals("c")) {
            onListenRevoked(ConnectionUtils.stringToPath((String) map.get(XHTMLText.P)));
        } else if (str.equals(SERVER_ASYNC_AUTH_REVOKED)) {
            onAuthRevoked((String) map.get("s"), (String) map.get("d"));
        } else if (str.equals(SERVER_ASYNC_APP_CHECK_REVOKED)) {
            onAppCheckRevoked((String) map.get("s"), (String) map.get("d"));
        } else if (str.equals(SERVER_ASYNC_SECURITY_DEBUG)) {
            onSecurityDebugPacket(map);
        } else if (this.logger.logsDebug()) {
            this.logger.debug("Unrecognized action from server: " + str, new Object[0]);
        }
    }

    private void onListenRevoked(List<String> list) {
        Collection<OutstandingListen> removeListens = removeListens(list);
        if (removeListens != null) {
            for (OutstandingListen access$800 : removeListens) {
                access$800.resultCallback.onRequestResult("permission_denied", (String) null);
            }
        }
    }

    private void onSecurityDebugPacket(Map<String, Object> map) {
        this.logger.info((String) map.get(SDKConstants.PARAM_DEBUG_MESSAGE));
    }

    private void putInternal(String str, List<String> list, Object obj, String str2, RequestResultCallback requestResultCallback) {
        Map<String, Object> putObject = getPutObject(list, obj, str2);
        long j10 = this.writeCounter;
        this.writeCounter = 1 + j10;
        this.outstandingPuts.put(Long.valueOf(j10), new OutstandingPut(str, putObject, requestResultCallback));
        if (canSendWrites()) {
            sendPut(j10);
        }
        this.lastWriteTimestamp = System.currentTimeMillis();
        doIdleCheck();
    }

    /* access modifiers changed from: private */
    public OutstandingListen removeListen(QuerySpec querySpec) {
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            logWrapper.debug("removing query " + querySpec, new Object[0]);
        }
        if (this.listens.containsKey(querySpec)) {
            OutstandingListen outstandingListen = this.listens.get(querySpec);
            this.listens.remove(querySpec);
            doIdleCheck();
            return outstandingListen;
        } else if (!this.logger.logsDebug()) {
            return null;
        } else {
            LogWrapper logWrapper2 = this.logger;
            logWrapper2.debug("Trying to remove listener for QuerySpec " + querySpec + " but no listener exists.", new Object[0]);
            return null;
        }
    }

    private Collection<OutstandingListen> removeListens(List<String> list) {
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            logWrapper.debug("removing all listens at path " + list, new Object[0]);
        }
        ArrayList<OutstandingListen> arrayList = new ArrayList<>();
        for (Map.Entry next : this.listens.entrySet()) {
            OutstandingListen outstandingListen = (OutstandingListen) next.getValue();
            if (((QuerySpec) next.getKey()).path.equals(list)) {
                arrayList.add(outstandingListen);
            }
        }
        for (OutstandingListen query : arrayList) {
            this.listens.remove(query.getQuery());
        }
        doIdleCheck();
        return arrayList;
    }

    private void restoreState() {
        boolean z10;
        ConnectionState connectionState2 = this.connectionState;
        if (connectionState2 == ConnectionState.Connected) {
            z10 = true;
        } else {
            z10 = false;
        }
        ConnectionUtils.hardAssert(z10, "Should be connected if we're restoring state, but we are: %s", connectionState2);
        if (this.logger.logsDebug()) {
            this.logger.debug("Restoring outstanding listens", new Object[0]);
        }
        for (OutstandingListen next : this.listens.values()) {
            if (this.logger.logsDebug()) {
                this.logger.debug("Restoring listen " + next.getQuery(), new Object[0]);
            }
            sendListen(next);
        }
        if (this.logger.logsDebug()) {
            this.logger.debug("Restoring writes.", new Object[0]);
        }
        ArrayList arrayList = new ArrayList(this.outstandingPuts.keySet());
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sendPut(((Long) it.next()).longValue());
        }
        for (OutstandingDisconnect next2 : this.onDisconnectRequestQueue) {
            sendOnDisconnect(next2.getAction(), next2.getPath(), next2.getData(), next2.getOnComplete());
        }
        this.onDisconnectRequestQueue.clear();
        if (this.logger.logsDebug()) {
            this.logger.debug("Restoring reads.", new Object[0]);
        }
        ArrayList arrayList2 = new ArrayList(this.outstandingGets.keySet());
        Collections.sort(arrayList2);
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            sendGet((Long) it2.next());
        }
    }

    private void restoreTokens() {
        boolean z10;
        if (this.logger.logsDebug()) {
            this.logger.debug("calling restore tokens", new Object[0]);
        }
        ConnectionState connectionState2 = this.connectionState;
        if (connectionState2 == ConnectionState.Connecting) {
            z10 = true;
        } else {
            z10 = false;
        }
        ConnectionUtils.hardAssert(z10, "Wanted to restore tokens, but was in wrong state: %s", connectionState2);
        if (this.authToken != null) {
            if (this.logger.logsDebug()) {
                this.logger.debug("Restoring auth.", new Object[0]);
            }
            this.connectionState = ConnectionState.Authenticating;
            sendAuthAndRestoreState();
            return;
        }
        if (this.logger.logsDebug()) {
            this.logger.debug("Not restoring auth because auth token is null.", new Object[0]);
        }
        this.connectionState = ConnectionState.Connected;
        sendAppCheckTokenHelper(true);
    }

    private void sendAction(String str, Map<String, Object> map, ConnectionRequestCallback connectionRequestCallback) {
        sendSensitive(str, false, map, connectionRequestCallback);
    }

    /* access modifiers changed from: private */
    public void sendAppCheckTokenHelper(boolean z10) {
        boolean z11;
        if (this.appCheckToken == null) {
            restoreState();
            return;
        }
        ConnectionUtils.hardAssert(connected(), "Must be connected to send auth, but was: %s", this.connectionState);
        if (this.logger.logsDebug()) {
            this.logger.debug("Sending app check.", new Object[0]);
        }
        e eVar = new e(this, z10);
        HashMap hashMap = new HashMap();
        if (this.appCheckToken != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        ConnectionUtils.hardAssert(z11, "App check token must be set!", new Object[0]);
        hashMap.put("token", this.appCheckToken);
        sendSensitive(REQUEST_ACTION_APPCHECK, true, hashMap, eVar);
    }

    private void sendAuthAndRestoreState() {
        sendAuthHelper(true);
    }

    private void sendAuthHelper(final boolean z10) {
        ConnectionUtils.hardAssert(connected(), "Must be connected to send auth, but was: %s", this.connectionState);
        if (this.logger.logsDebug()) {
            this.logger.debug("Sending auth.", new Object[0]);
        }
        AnonymousClass4 r02 = new ConnectionRequestCallback() {
            public void onResponse(Map<String, Object> map) {
                String str = (String) map.get("s");
                if (str.equals("ok")) {
                    ConnectionState unused = PersistentConnectionImpl.this.connectionState = ConnectionState.Connected;
                    int unused2 = PersistentConnectionImpl.this.invalidAuthTokenCount = 0;
                    PersistentConnectionImpl.this.sendAppCheckTokenHelper(z10);
                    return;
                }
                String unused3 = PersistentConnectionImpl.this.authToken = null;
                boolean unused4 = PersistentConnectionImpl.this.forceAuthTokenRefresh = true;
                PersistentConnectionImpl.this.delegate.onConnectionStatus(false);
                LogWrapper access$1500 = PersistentConnectionImpl.this.logger;
                access$1500.debug("Authentication failed: " + str + " (" + ((String) map.get("d")) + ")", new Object[0]);
                PersistentConnectionImpl.this.realtime.close();
                if (str.equals("invalid_token")) {
                    PersistentConnectionImpl.access$1008(PersistentConnectionImpl.this);
                    if (((long) PersistentConnectionImpl.this.invalidAuthTokenCount) >= PersistentConnectionImpl.INVALID_TOKEN_THRESHOLD) {
                        PersistentConnectionImpl.this.retryHelper.setMaxDelay();
                        PersistentConnectionImpl.this.logger.warn("Provided authentication credentials are invalid. This usually indicates your FirebaseApp instance was not initialized correctly. Make sure your google-services.json file has the correct firebase_url and api_key. You can re-download google-services.json from https://console.firebase.google.com/.");
                    }
                }
            }
        };
        HashMap hashMap = new HashMap();
        GAuthToken tryParseFromString = GAuthToken.tryParseFromString(this.authToken);
        if (tryParseFromString != null) {
            hashMap.put(REQUEST_CREDENTIAL, tryParseFromString.getToken());
            if (tryParseFromString.getAuth() != null) {
                hashMap.put(REQUEST_AUTHVAR, tryParseFromString.getAuth());
            }
            sendSensitive(REQUEST_ACTION_GAUTH, true, hashMap, r02);
            return;
        }
        hashMap.put(REQUEST_CREDENTIAL, this.authToken);
        sendSensitive("auth", true, hashMap, r02);
    }

    private void sendConnectStats() {
        HashMap hashMap = new HashMap();
        if (this.context.isPersistenceEnabled()) {
            hashMap.put("persistence.android.enabled", 1);
        }
        hashMap.put("sdk.android." + this.context.getClientSdkVersion().replace('.', SignatureVisitor.SUPER), 1);
        if (this.logger.logsDebug()) {
            this.logger.debug("Sending first connection stats", new Object[0]);
        }
        sendStats(hashMap);
    }

    private void sendGet(final Long l10) {
        ConnectionUtils.hardAssert(canSendReads(), "sendGet called when we can't send gets", new Object[0]);
        final OutstandingGet outstandingGet = this.outstandingGets.get(l10);
        if (outstandingGet.markSent() || !this.logger.logsDebug()) {
            sendAction(REQUEST_ACTION_GET, outstandingGet.getRequest(), new ConnectionRequestCallback() {
                public void onResponse(Map<String, Object> map) {
                    if (((OutstandingGet) PersistentConnectionImpl.this.outstandingGets.get(l10)) == outstandingGet) {
                        PersistentConnectionImpl.this.outstandingGets.remove(l10);
                        outstandingGet.getOnComplete().onResponse(map);
                    } else if (PersistentConnectionImpl.this.logger.logsDebug()) {
                        LogWrapper access$1500 = PersistentConnectionImpl.this.logger;
                        access$1500.debug("Ignoring on complete for get " + l10 + " because it was removed already.", new Object[0]);
                    }
                }
            });
            return;
        }
        LogWrapper logWrapper = this.logger;
        logWrapper.debug("get" + l10 + " cancelled, ignoring.", new Object[0]);
    }

    private void sendListen(final OutstandingListen outstandingListen) {
        HashMap hashMap = new HashMap();
        hashMap.put(XHTMLText.P, ConnectionUtils.pathToString(outstandingListen.getQuery().path));
        Long tag = outstandingListen.getTag();
        if (tag != null) {
            hashMap.put(XHTMLText.Q, outstandingListen.query.queryParams);
            hashMap.put("t", tag);
        }
        ListenHashProvider hashFunction = outstandingListen.getHashFunction();
        hashMap.put("h", hashFunction.getSimpleHash());
        if (hashFunction.shouldIncludeCompoundHash()) {
            CompoundHash compoundHash = hashFunction.getCompoundHash();
            ArrayList arrayList = new ArrayList();
            for (List<String> pathToString : compoundHash.getPosts()) {
                arrayList.add(ConnectionUtils.pathToString(pathToString));
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put(REQUEST_COMPOUND_HASH_HASHES, compoundHash.getHashes());
            hashMap2.put(REQUEST_COMPOUND_HASH_PATHS, arrayList);
            hashMap.put(REQUEST_COMPOUND_HASH, hashMap2);
        }
        sendAction(XHTMLText.Q, hashMap, new ConnectionRequestCallback() {
            public void onResponse(Map<String, Object> map) {
                String str = (String) map.get("s");
                if (str.equals("ok")) {
                    Map map2 = (Map) map.get("d");
                    if (map2.containsKey(PersistentConnectionImpl.SERVER_DATA_WARNINGS)) {
                        PersistentConnectionImpl.this.warnOnListenerWarnings((List) map2.get(PersistentConnectionImpl.SERVER_DATA_WARNINGS), outstandingListen.query);
                    }
                }
                if (((OutstandingListen) PersistentConnectionImpl.this.listens.get(outstandingListen.getQuery())) != outstandingListen) {
                    return;
                }
                if (!str.equals("ok")) {
                    OutstandingListen unused = PersistentConnectionImpl.this.removeListen(outstandingListen.getQuery());
                    outstandingListen.resultCallback.onRequestResult(str, (String) map.get("d"));
                    return;
                }
                outstandingListen.resultCallback.onRequestResult((String) null, (String) null);
            }
        });
    }

    private void sendOnDisconnect(String str, List<String> list, Object obj, final RequestResultCallback requestResultCallback) {
        HashMap hashMap = new HashMap();
        hashMap.put(XHTMLText.P, ConnectionUtils.pathToString(list));
        hashMap.put("d", obj);
        sendAction(str, hashMap, new ConnectionRequestCallback() {
            public void onResponse(Map<String, Object> map) {
                String str = (String) map.get("s");
                String str2 = null;
                if (!str.equals("ok")) {
                    str2 = (String) map.get("d");
                } else {
                    str = null;
                }
                RequestResultCallback requestResultCallback = requestResultCallback;
                if (requestResultCallback != null) {
                    requestResultCallback.onRequestResult(str, str2);
                }
            }
        });
    }

    private void sendPut(long j10) {
        ConnectionUtils.hardAssert(canSendWrites(), "sendPut called when we can't send writes (we're disconnected or writes are paused).", new Object[0]);
        final OutstandingPut outstandingPut = this.outstandingPuts.get(Long.valueOf(j10));
        final RequestResultCallback onComplete = outstandingPut.getOnComplete();
        String action = outstandingPut.getAction();
        outstandingPut.markSent();
        final String str = action;
        final long j11 = j10;
        sendAction(action, outstandingPut.getRequest(), new ConnectionRequestCallback() {
            public void onResponse(Map<String, Object> map) {
                if (PersistentConnectionImpl.this.logger.logsDebug()) {
                    LogWrapper access$1500 = PersistentConnectionImpl.this.logger;
                    access$1500.debug(str + " response: " + map, new Object[0]);
                }
                if (((OutstandingPut) PersistentConnectionImpl.this.outstandingPuts.get(Long.valueOf(j11))) == outstandingPut) {
                    PersistentConnectionImpl.this.outstandingPuts.remove(Long.valueOf(j11));
                    if (onComplete != null) {
                        String str = (String) map.get("s");
                        if (str.equals("ok")) {
                            onComplete.onRequestResult((String) null, (String) null);
                        } else {
                            onComplete.onRequestResult(str, (String) map.get("d"));
                        }
                    }
                } else if (PersistentConnectionImpl.this.logger.logsDebug()) {
                    LogWrapper access$15002 = PersistentConnectionImpl.this.logger;
                    access$15002.debug("Ignoring on complete for put " + j11 + " because it was removed already.", new Object[0]);
                }
                PersistentConnectionImpl.this.doIdleCheck();
            }
        });
    }

    private void sendSensitive(String str, boolean z10, Map<String, Object> map, ConnectionRequestCallback connectionRequestCallback) {
        long nextRequestNumber = nextRequestNumber();
        HashMap hashMap = new HashMap();
        hashMap.put("r", Long.valueOf(nextRequestNumber));
        hashMap.put("a", str);
        hashMap.put(NetworkProfile.BISEXUAL, map);
        this.realtime.sendRequest(hashMap, z10);
        this.requestCBHash.put(Long.valueOf(nextRequestNumber), connectionRequestCallback);
    }

    private void sendStats(Map<String, Integer> map) {
        if (!map.isEmpty()) {
            HashMap hashMap = new HashMap();
            hashMap.put("c", map);
            sendAction("s", hashMap, new ConnectionRequestCallback() {
                public void onResponse(Map<String, Object> map) {
                    String str = (String) map.get("s");
                    if (!str.equals("ok")) {
                        String str2 = (String) map.get("d");
                        if (PersistentConnectionImpl.this.logger.logsDebug()) {
                            LogWrapper access$1500 = PersistentConnectionImpl.this.logger;
                            access$1500.debug("Failed to send stats: " + str + " (message: " + str2 + ")", new Object[0]);
                        }
                    }
                }
            });
        } else if (this.logger.logsDebug()) {
            this.logger.debug("Not sending stats because stats are empty", new Object[0]);
        }
    }

    private void sendUnAppCheck() {
        boolean z10;
        ConnectionUtils.hardAssert(connected(), "Must be connected to send unauth.", new Object[0]);
        if (this.appCheckToken == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        ConnectionUtils.hardAssert(z10, "App check token must not be set.", new Object[0]);
        sendAction(REQUEST_ACTION_UNAPPCHECK, Collections.emptyMap(), (ConnectionRequestCallback) null);
    }

    private void sendUnauth() {
        boolean z10;
        ConnectionUtils.hardAssert(connected(), "Must be connected to send unauth.", new Object[0]);
        if (this.authToken == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        ConnectionUtils.hardAssert(z10, "Auth token must not be set.", new Object[0]);
        sendAction(REQUEST_ACTION_UNAUTH, Collections.emptyMap(), (ConnectionRequestCallback) null);
    }

    private void sendUnlisten(OutstandingListen outstandingListen) {
        HashMap hashMap = new HashMap();
        hashMap.put(XHTMLText.P, ConnectionUtils.pathToString(outstandingListen.query.path));
        Long tag = outstandingListen.getTag();
        if (tag != null) {
            hashMap.put(XHTMLText.Q, outstandingListen.getQuery().queryParams);
            hashMap.put("t", tag);
        }
        sendAction(REQUEST_ACTION_QUERY_UNLISTEN, hashMap, (ConnectionRequestCallback) null);
    }

    private void tryScheduleReconnect() {
        boolean z10;
        if (shouldReconnect()) {
            ConnectionState connectionState2 = this.connectionState;
            if (connectionState2 == ConnectionState.Disconnected) {
                z10 = true;
            } else {
                z10 = false;
            }
            ConnectionUtils.hardAssert(z10, "Not in disconnected state: %s", connectionState2);
            boolean z11 = this.forceAuthTokenRefresh;
            boolean z12 = this.forceAppCheckTokenRefresh;
            this.logger.debug("Scheduling connection attempt", new Object[0]);
            this.forceAuthTokenRefresh = false;
            this.forceAppCheckTokenRefresh = false;
            this.retryHelper.retry(new a(this, z11, z12));
        }
    }

    private void upgradeAppCheck() {
        sendAppCheckTokenHelper(false);
    }

    private void upgradeAuth() {
        sendAuthHelper(false);
    }

    /* access modifiers changed from: private */
    public void warnOnListenerWarnings(List<String> list, QuerySpec querySpec) {
        if (list.contains("no_index")) {
            LogWrapper logWrapper = this.logger;
            logWrapper.warn("Using an unspecified index. Your data will be downloaded and filtered on the client. Consider adding '" + ("\".indexOn\": \"" + querySpec.queryParams.get("i") + '\"') + "' at " + ConnectionUtils.pathToString(querySpec.path) + " to your security and Firebase Database rules for better performance");
        }
    }

    public void compareAndPut(List<String> list, Object obj, String str, RequestResultCallback requestResultCallback) {
        putInternal(XHTMLText.P, list, obj, str, requestResultCallback);
    }

    public Task<Object> get(List<String> list, Map<String, Object> map) {
        QuerySpec querySpec = new QuerySpec(list, map);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        long j10 = this.readCounter;
        this.readCounter = 1 + j10;
        HashMap hashMap = new HashMap();
        hashMap.put(XHTMLText.P, ConnectionUtils.pathToString(querySpec.path));
        hashMap.put(XHTMLText.Q, querySpec.queryParams);
        this.outstandingGets.put(Long.valueOf(j10), new OutstandingGet(REQUEST_ACTION_GET, hashMap, new d(taskCompletionSource)));
        if (canSendReads()) {
            sendGet(Long.valueOf(j10));
        }
        doIdleCheck();
        return taskCompletionSource.getTask();
    }

    public void initialize() {
        tryScheduleReconnect();
    }

    public void injectConnectionFailure() {
        Connection connection = this.realtime;
        if (connection != null) {
            connection.injectConnectionFailure();
        }
    }

    public void interrupt(String str) {
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            logWrapper.debug("Connection interrupted for: " + str, new Object[0]);
        }
        this.interruptReasons.add(str);
        Connection connection = this.realtime;
        if (connection != null) {
            connection.close();
            this.realtime = null;
        } else {
            this.retryHelper.cancel();
            this.connectionState = ConnectionState.Disconnected;
        }
        this.retryHelper.signalSuccess();
    }

    public boolean isInterrupted(String str) {
        return this.interruptReasons.contains(str);
    }

    public void listen(List<String> list, Map<String, Object> map, ListenHashProvider listenHashProvider, Long l10, RequestResultCallback requestResultCallback) {
        QuerySpec querySpec = new QuerySpec(list, map);
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            logWrapper.debug("Listening on " + querySpec, new Object[0]);
        }
        ConnectionUtils.hardAssert(!this.listens.containsKey(querySpec), "listen() called twice for same QuerySpec.", new Object[0]);
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper2 = this.logger;
            logWrapper2.debug("Adding listen query: " + querySpec, new Object[0]);
        }
        OutstandingListen outstandingListen = new OutstandingListen(requestResultCallback, querySpec, l10, listenHashProvider);
        this.listens.put(querySpec, outstandingListen);
        if (connected()) {
            sendListen(outstandingListen);
        }
        doIdleCheck();
    }

    public void merge(List<String> list, Map<String, Object> map, RequestResultCallback requestResultCallback) {
        putInternal(NetworkProfile.MALE, list, map, (String) null, requestResultCallback);
    }

    public void onCacheHost(String str) {
        this.cachedHost = str;
    }

    public void onDataMessage(Map<String, Object> map) {
        if (map.containsKey("r")) {
            ConnectionRequestCallback remove = this.requestCBHash.remove(Long.valueOf((long) ((Integer) map.get("r")).intValue()));
            if (remove != null) {
                remove.onResponse((Map) map.get(NetworkProfile.BISEXUAL));
            }
        } else if (!map.containsKey("error")) {
            if (map.containsKey("a")) {
                onDataPush((String) map.get("a"), (Map) map.get(NetworkProfile.BISEXUAL));
            } else if (this.logger.logsDebug()) {
                LogWrapper logWrapper = this.logger;
                logWrapper.debug("Ignoring unknown message: " + map, new Object[0]);
            }
        }
    }

    public void onDisconnect(Connection.DisconnectReason disconnectReason) {
        boolean z10 = false;
        if (this.logger.logsDebug()) {
            this.logger.debug("Got on disconnect due to " + disconnectReason.name(), new Object[0]);
        }
        this.connectionState = ConnectionState.Disconnected;
        this.realtime = null;
        this.hasOnDisconnects = false;
        this.requestCBHash.clear();
        cancelSentTransactions();
        if (shouldReconnect()) {
            long currentTimeMillis = System.currentTimeMillis();
            long j10 = this.lastConnectionEstablishedTime;
            long j11 = currentTimeMillis - j10;
            if (j10 > 0 && j11 > SUCCESSFUL_CONNECTION_ESTABLISHED_DELAY) {
                z10 = true;
            }
            if (disconnectReason == Connection.DisconnectReason.SERVER_RESET || z10) {
                this.retryHelper.signalSuccess();
            }
            tryScheduleReconnect();
        }
        this.lastConnectionEstablishedTime = 0;
        this.delegate.onDisconnect();
    }

    public void onDisconnectCancel(List<String> list, RequestResultCallback requestResultCallback) {
        if (canSendWrites()) {
            sendOnDisconnect(REQUEST_ACTION_ONDISCONNECT_CANCEL, list, (Object) null, requestResultCallback);
        } else {
            this.onDisconnectRequestQueue.add(new OutstandingDisconnect(REQUEST_ACTION_ONDISCONNECT_CANCEL, list, (Object) null, requestResultCallback));
        }
        doIdleCheck();
    }

    public void onDisconnectMerge(List<String> list, Map<String, Object> map, RequestResultCallback requestResultCallback) {
        this.hasOnDisconnects = true;
        if (canSendWrites()) {
            sendOnDisconnect(REQUEST_ACTION_ONDISCONNECT_MERGE, list, map, requestResultCallback);
        } else {
            this.onDisconnectRequestQueue.add(new OutstandingDisconnect(REQUEST_ACTION_ONDISCONNECT_MERGE, list, map, requestResultCallback));
        }
        doIdleCheck();
    }

    public void onDisconnectPut(List<String> list, Object obj, RequestResultCallback requestResultCallback) {
        this.hasOnDisconnects = true;
        if (canSendWrites()) {
            sendOnDisconnect("o", list, obj, requestResultCallback);
        } else {
            this.onDisconnectRequestQueue.add(new OutstandingDisconnect("o", list, obj, requestResultCallback));
        }
        doIdleCheck();
    }

    public void onKill(String str) {
        if (str.equals(INVALID_APP_CHECK_TOKEN)) {
            int i10 = this.invalidAppCheckTokenCount;
            if (((long) i10) < INVALID_TOKEN_THRESHOLD) {
                this.invalidAppCheckTokenCount = i10 + 1;
                LogWrapper logWrapper = this.logger;
                logWrapper.warn("Detected invalid AppCheck token. Reconnecting (" + (INVALID_TOKEN_THRESHOLD - ((long) this.invalidAppCheckTokenCount)) + " attempts remaining)");
                return;
            }
        }
        LogWrapper logWrapper2 = this.logger;
        logWrapper2.warn("Firebase Database connection was forcefully killed by the server. Will not attempt reconnect. Reason: " + str);
        interrupt(SERVER_KILL_INTERRUPT_REASON);
    }

    public void onReady(long j10, String str) {
        if (this.logger.logsDebug()) {
            this.logger.debug("onReady", new Object[0]);
        }
        this.lastConnectionEstablishedTime = System.currentTimeMillis();
        handleTimestamp(j10);
        if (this.firstConnection) {
            sendConnectStats();
        }
        restoreTokens();
        this.firstConnection = false;
        this.lastSessionId = str;
        this.delegate.onConnect();
    }

    public void openNetworkConnection(String str, String str2) {
        boolean z10;
        ConnectionState connectionState2 = this.connectionState;
        if (connectionState2 == ConnectionState.GettingToken) {
            z10 = true;
        } else {
            z10 = false;
        }
        ConnectionUtils.hardAssert(z10, "Trying to open network connection while in the wrong state: %s", connectionState2);
        if (str == null) {
            this.delegate.onConnectionStatus(false);
        }
        this.authToken = str;
        this.appCheckToken = str2;
        this.connectionState = ConnectionState.Connecting;
        Connection connection = new Connection(this.context, this.hostInfo, this.cachedHost, this, this.lastSessionId, str2);
        this.realtime = connection;
        connection.open();
    }

    public void purgeOutstandingWrites() {
        for (OutstandingPut next : this.outstandingPuts.values()) {
            if (next.onComplete != null) {
                next.onComplete.onRequestResult("write_canceled", (String) null);
            }
        }
        for (OutstandingDisconnect next2 : this.onDisconnectRequestQueue) {
            if (next2.onComplete != null) {
                next2.onComplete.onRequestResult("write_canceled", (String) null);
            }
        }
        this.outstandingPuts.clear();
        this.onDisconnectRequestQueue.clear();
        if (!connected()) {
            this.hasOnDisconnects = false;
        }
        doIdleCheck();
    }

    public void put(List<String> list, Object obj, RequestResultCallback requestResultCallback) {
        putInternal(XHTMLText.P, list, obj, (String) null, requestResultCallback);
    }

    public void refreshAppCheckToken() {
        this.logger.debug("App check token refresh requested", new Object[0]);
        interrupt(TOKEN_REFRESH_INTERRUPT_REASON);
        resume(TOKEN_REFRESH_INTERRUPT_REASON);
    }

    public void refreshAuthToken() {
        this.logger.debug("Auth token refresh requested", new Object[0]);
        interrupt(TOKEN_REFRESH_INTERRUPT_REASON);
        resume(TOKEN_REFRESH_INTERRUPT_REASON);
    }

    public void resume(String str) {
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            logWrapper.debug("Connection no longer interrupted for: " + str, new Object[0]);
        }
        this.interruptReasons.remove(str);
        if (shouldReconnect() && this.connectionState == ConnectionState.Disconnected) {
            tryScheduleReconnect();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean shouldReconnect() {
        return this.interruptReasons.size() == 0;
    }

    public void shutdown() {
        interrupt("shutdown");
    }

    public void unlisten(List<String> list, Map<String, Object> map) {
        QuerySpec querySpec = new QuerySpec(list, map);
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            logWrapper.debug("unlistening on " + querySpec, new Object[0]);
        }
        OutstandingListen removeListen = removeListen(querySpec);
        if (removeListen != null && connected()) {
            sendUnlisten(removeListen);
        }
        doIdleCheck();
    }

    public void refreshAppCheckToken(String str) {
        this.logger.debug("App check token refreshed.", new Object[0]);
        this.appCheckToken = str;
        if (!connected()) {
            return;
        }
        if (str != null) {
            upgradeAppCheck();
        } else {
            sendUnAppCheck();
        }
    }

    public void refreshAuthToken(String str) {
        this.logger.debug("Auth token refreshed.", new Object[0]);
        this.authToken = str;
        if (!connected()) {
            return;
        }
        if (str != null) {
            upgradeAuth();
        } else {
            sendUnauth();
        }
    }
}
