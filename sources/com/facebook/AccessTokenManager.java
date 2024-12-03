package com.facebook;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.internal.Utility;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import n1.a;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 '2\u00020\u0001:\u0005'()*+B\u0019\b\u0000\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b%\u0010&J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\t\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0006J\u0006\u0010\u0011\u001a\u00020\u0006J\u0010\u0010\u0012\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fR\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R(\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010!\u001a\u0004\u0018\u00010\u00028F@FX\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b\u0007\u0010$¨\u0006,"}, d2 = {"Lcom/facebook/AccessTokenManager;", "", "Lcom/facebook/AccessToken;", "currentAccessToken", "", "saveToCache", "", "setCurrentAccessToken", "oldAccessToken", "sendCurrentAccessTokenChangedBroadcastIntent", "setTokenExpirationBroadcastAlarm", "shouldExtendAccessToken", "Lcom/facebook/AccessToken$AccessTokenRefreshCallback;", "callback", "refreshCurrentAccessTokenImpl", "loadCurrentAccessToken", "currentAccessTokenChanged", "extendAccessTokenIfNeeded", "refreshCurrentAccessToken", "Ln1/a;", "localBroadcastManager", "Ln1/a;", "Lcom/facebook/AccessTokenCache;", "accessTokenCache", "Lcom/facebook/AccessTokenCache;", "currentAccessTokenField", "Lcom/facebook/AccessToken;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "tokenRefreshInProgress", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/Date;", "lastAttemptedTokenExtendDate", "Ljava/util/Date;", "value", "getCurrentAccessToken", "()Lcom/facebook/AccessToken;", "(Lcom/facebook/AccessToken;)V", "<init>", "(Ln1/a;Lcom/facebook/AccessTokenCache;)V", "Companion", "FacebookRefreshTokenInfo", "InstagramRefreshTokenInfo", "RefreshResult", "RefreshTokenInfo", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class AccessTokenManager {
    public static final String ACTION_CURRENT_ACCESS_TOKEN_CHANGED = "com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_NEW_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN";
    public static final String EXTRA_OLD_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN";
    private static final String ME_PERMISSIONS_GRAPH_PATH = "me/permissions";
    public static final String SHARED_PREFERENCES_NAME = "com.facebook.AccessTokenManager.SharedPreferences";
    public static final String TAG = "AccessTokenManager";
    private static final int TOKEN_EXTEND_RETRY_SECONDS = 3600;
    private static final int TOKEN_EXTEND_THRESHOLD_SECONDS = 86400;
    /* access modifiers changed from: private */
    public static AccessTokenManager instanceField;
    private final AccessTokenCache accessTokenCache;
    private AccessToken currentAccessTokenField;
    private Date lastAttemptedTokenExtendDate = new Date(0);
    private final a localBroadcastManager;
    private final AtomicBoolean tokenRefreshInProgress = new AtomicBoolean(false);

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/facebook/AccessTokenManager$Companion;", "", "()V", "ACTION_CURRENT_ACCESS_TOKEN_CHANGED", "", "EXTRA_NEW_ACCESS_TOKEN", "EXTRA_OLD_ACCESS_TOKEN", "ME_PERMISSIONS_GRAPH_PATH", "SHARED_PREFERENCES_NAME", "TAG", "TOKEN_EXTEND_RETRY_SECONDS", "", "TOKEN_EXTEND_THRESHOLD_SECONDS", "instanceField", "Lcom/facebook/AccessTokenManager;", "createExtendAccessTokenRequest", "Lcom/facebook/GraphRequest;", "accessToken", "Lcom/facebook/AccessToken;", "callback", "Lcom/facebook/GraphRequest$Callback;", "createGrantedPermissionsRequest", "getInstance", "getRefreshTokenInfoForToken", "Lcom/facebook/AccessTokenManager$RefreshTokenInfo;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final GraphRequest createExtendAccessTokenRequest(AccessToken accessToken, GraphRequest.Callback callback) {
            RefreshTokenInfo refreshTokenInfoForToken = getRefreshTokenInfoForToken(accessToken);
            Bundle bundle = new Bundle();
            bundle.putString("grant_type", refreshTokenInfoForToken.getGrantType());
            bundle.putString("client_id", accessToken.getApplicationId());
            bundle.putString("fields", "access_token,expires_at,expires_in,data_access_expiration_time,graph_domain");
            GraphRequest newGraphPathRequest = GraphRequest.Companion.newGraphPathRequest(accessToken, refreshTokenInfoForToken.getGraphPath(), callback);
            newGraphPathRequest.setParameters(bundle);
            newGraphPathRequest.setHttpMethod(HttpMethod.GET);
            return newGraphPathRequest;
        }

        /* access modifiers changed from: private */
        public final GraphRequest createGrantedPermissionsRequest(AccessToken accessToken, GraphRequest.Callback callback) {
            Bundle bundle = new Bundle();
            bundle.putString("fields", "permission,status");
            GraphRequest newGraphPathRequest = GraphRequest.Companion.newGraphPathRequest(accessToken, AccessTokenManager.ME_PERMISSIONS_GRAPH_PATH, callback);
            newGraphPathRequest.setParameters(bundle);
            newGraphPathRequest.setHttpMethod(HttpMethod.GET);
            return newGraphPathRequest;
        }

        private final RefreshTokenInfo getRefreshTokenInfoForToken(AccessToken accessToken) {
            String graphDomain = accessToken.getGraphDomain();
            if (graphDomain == null) {
                graphDomain = AccessToken.DEFAULT_GRAPH_DOMAIN;
            }
            if (j.b(graphDomain, FacebookSdk.INSTAGRAM)) {
                return new InstagramRefreshTokenInfo();
            }
            return new FacebookRefreshTokenInfo();
        }

        public final AccessTokenManager getInstance() {
            AccessTokenManager access$getInstanceField$cp;
            AccessTokenManager access$getInstanceField$cp2 = AccessTokenManager.instanceField;
            if (access$getInstanceField$cp2 != null) {
                return access$getInstanceField$cp2;
            }
            synchronized (this) {
                access$getInstanceField$cp = AccessTokenManager.instanceField;
                if (access$getInstanceField$cp == null) {
                    a b10 = a.b(FacebookSdk.getApplicationContext());
                    j.f(b10, "getInstance(applicationContext)");
                    AccessTokenManager accessTokenManager = new AccessTokenManager(b10, new AccessTokenCache());
                    AccessTokenManager.instanceField = accessTokenManager;
                    access$getInstanceField$cp = accessTokenManager;
                }
            }
            return access$getInstanceField$cp;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/facebook/AccessTokenManager$FacebookRefreshTokenInfo;", "Lcom/facebook/AccessTokenManager$RefreshTokenInfo;", "()V", "grantType", "", "getGrantType", "()Ljava/lang/String;", "graphPath", "getGraphPath", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class FacebookRefreshTokenInfo implements RefreshTokenInfo {
        private final String grantType = "fb_extend_sso_token";
        private final String graphPath = "oauth/access_token";

        public String getGrantType() {
            return this.grantType;
        }

        public String getGraphPath() {
            return this.graphPath;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/facebook/AccessTokenManager$InstagramRefreshTokenInfo;", "Lcom/facebook/AccessTokenManager$RefreshTokenInfo;", "()V", "grantType", "", "getGrantType", "()Ljava/lang/String;", "graphPath", "getGraphPath", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class InstagramRefreshTokenInfo implements RefreshTokenInfo {
        private final String grantType = "ig_refresh_token";
        private final String graphPath = "refresh_access_token";

        public String getGrantType() {
            return this.grantType;
        }

        public String getGraphPath() {
            return this.graphPath;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/facebook/AccessTokenManager$RefreshResult;", "", "()V", "accessToken", "", "getAccessToken", "()Ljava/lang/String;", "setAccessToken", "(Ljava/lang/String;)V", "dataAccessExpirationTime", "", "getDataAccessExpirationTime", "()Ljava/lang/Long;", "setDataAccessExpirationTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "expiresAt", "", "getExpiresAt", "()I", "setExpiresAt", "(I)V", "expiresIn", "getExpiresIn", "setExpiresIn", "graphDomain", "getGraphDomain", "setGraphDomain", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class RefreshResult {
        private String accessToken;
        private Long dataAccessExpirationTime;
        private int expiresAt;
        private int expiresIn;
        private String graphDomain;

        public final String getAccessToken() {
            return this.accessToken;
        }

        public final Long getDataAccessExpirationTime() {
            return this.dataAccessExpirationTime;
        }

        public final int getExpiresAt() {
            return this.expiresAt;
        }

        public final int getExpiresIn() {
            return this.expiresIn;
        }

        public final String getGraphDomain() {
            return this.graphDomain;
        }

        public final void setAccessToken(String str) {
            this.accessToken = str;
        }

        public final void setDataAccessExpirationTime(Long l10) {
            this.dataAccessExpirationTime = l10;
        }

        public final void setExpiresAt(int i10) {
            this.expiresAt = i10;
        }

        public final void setExpiresIn(int i10) {
            this.expiresIn = i10;
        }

        public final void setGraphDomain(String str) {
            this.graphDomain = str;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/facebook/AccessTokenManager$RefreshTokenInfo;", "", "grantType", "", "getGrantType", "()Ljava/lang/String;", "graphPath", "getGraphPath", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface RefreshTokenInfo {
        String getGrantType();

        String getGraphPath();
    }

    public AccessTokenManager(a aVar, AccessTokenCache accessTokenCache2) {
        j.g(aVar, "localBroadcastManager");
        j.g(accessTokenCache2, "accessTokenCache");
        this.localBroadcastManager = aVar;
        this.accessTokenCache = accessTokenCache2;
    }

    public static final AccessTokenManager getInstance() {
        return Companion.getInstance();
    }

    /* access modifiers changed from: private */
    /* renamed from: refreshCurrentAccessToken$lambda-0  reason: not valid java name */
    public static final void m12refreshCurrentAccessToken$lambda0(AccessTokenManager accessTokenManager, AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback) {
        j.g(accessTokenManager, "this$0");
        accessTokenManager.refreshCurrentAccessTokenImpl(accessTokenRefreshCallback);
    }

    private final void refreshCurrentAccessTokenImpl(AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback) {
        AccessToken currentAccessToken = getCurrentAccessToken();
        if (currentAccessToken == null) {
            if (accessTokenRefreshCallback != null) {
                accessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
            }
        } else if (this.tokenRefreshInProgress.compareAndSet(false, true)) {
            this.lastAttemptedTokenExtendDate = new Date();
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = new HashSet();
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            RefreshResult refreshResult = new RefreshResult();
            Companion companion = Companion;
            GraphRequestBatch graphRequestBatch = new GraphRequestBatch(companion.createGrantedPermissionsRequest(currentAccessToken, new b(atomicBoolean, hashSet, hashSet2, hashSet3)), companion.createExtendAccessTokenRequest(currentAccessToken, new c(refreshResult)));
            graphRequestBatch.addCallback(new d(refreshResult, currentAccessToken, accessTokenRefreshCallback, atomicBoolean, hashSet, hashSet2, hashSet3, this));
            graphRequestBatch.executeAsync();
        } else if (accessTokenRefreshCallback != null) {
            accessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("Refresh already in progress"));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: refreshCurrentAccessTokenImpl$lambda-1  reason: not valid java name */
    public static final void m13refreshCurrentAccessTokenImpl$lambda1(AtomicBoolean atomicBoolean, Set set, Set set2, Set set3, GraphResponse graphResponse) {
        org.json.a optJSONArray;
        j.g(atomicBoolean, "$permissionsCallSucceeded");
        j.g(set, "$permissions");
        j.g(set2, "$declinedPermissions");
        j.g(set3, "$expiredPermissions");
        j.g(graphResponse, "response");
        b jsonObject = graphResponse.getJsonObject();
        if (jsonObject != null && (optJSONArray = jsonObject.optJSONArray("data")) != null) {
            atomicBoolean.set(true);
            int i10 = 0;
            int o10 = optJSONArray.o();
            if (o10 > 0) {
                while (true) {
                    int i11 = i10 + 1;
                    b s10 = optJSONArray.s(i10);
                    if (s10 != null) {
                        String optString = s10.optString("permission");
                        String optString2 = s10.optString("status");
                        if (!Utility.isNullOrEmpty(optString) && !Utility.isNullOrEmpty(optString2)) {
                            j.f(optString2, "status");
                            Locale locale = Locale.US;
                            j.f(locale, "US");
                            String lowerCase = optString2.toLowerCase(locale);
                            j.f(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                            j.f(lowerCase, "status");
                            int hashCode = lowerCase.hashCode();
                            if (hashCode != -1309235419) {
                                if (hashCode != 280295099) {
                                    if (hashCode == 568196142 && lowerCase.equals("declined")) {
                                        set2.add(optString);
                                    }
                                } else if (lowerCase.equals("granted")) {
                                    set.add(optString);
                                }
                            } else if (lowerCase.equals("expired")) {
                                set3.add(optString);
                            }
                            j.p("Unexpected status: ", lowerCase);
                        }
                    }
                    if (i11 < o10) {
                        i10 = i11;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: refreshCurrentAccessTokenImpl$lambda-2  reason: not valid java name */
    public static final void m14refreshCurrentAccessTokenImpl$lambda2(RefreshResult refreshResult, GraphResponse graphResponse) {
        j.g(refreshResult, "$refreshResult");
        j.g(graphResponse, "response");
        b jsonObject = graphResponse.getJsonObject();
        if (jsonObject != null) {
            refreshResult.setAccessToken(jsonObject.optString("access_token"));
            refreshResult.setExpiresAt(jsonObject.optInt("expires_at"));
            refreshResult.setExpiresIn(jsonObject.optInt(AccessToken.EXPIRES_IN_KEY));
            refreshResult.setDataAccessExpirationTime(Long.valueOf(jsonObject.optLong(AccessToken.DATA_ACCESS_EXPIRATION_TIME)));
            refreshResult.setGraphDomain(jsonObject.optString("graph_domain", (String) null));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: refreshCurrentAccessTokenImpl$lambda-3  reason: not valid java name */
    public static final void m15refreshCurrentAccessTokenImpl$lambda3(RefreshResult refreshResult, AccessToken accessToken, AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback, AtomicBoolean atomicBoolean, Set set, Set set2, Set set3, AccessTokenManager accessTokenManager, GraphRequestBatch graphRequestBatch) {
        AccessToken accessToken2;
        String str;
        Set<String> set4;
        Set<String> set5;
        Set<String> set6;
        Date date;
        AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback2 = accessTokenRefreshCallback;
        AccessTokenManager accessTokenManager2 = accessTokenManager;
        j.g(refreshResult, "$refreshResult");
        j.g(atomicBoolean, "$permissionsCallSucceeded");
        Set set7 = set;
        j.g(set7, "$permissions");
        Set set8 = set2;
        j.g(set8, "$declinedPermissions");
        Set set9 = set3;
        j.g(set9, "$expiredPermissions");
        j.g(accessTokenManager2, "this$0");
        j.g(graphRequestBatch, "it");
        String accessToken3 = refreshResult.getAccessToken();
        int expiresAt = refreshResult.getExpiresAt();
        Long dataAccessExpirationTime = refreshResult.getDataAccessExpirationTime();
        String graphDomain = refreshResult.getGraphDomain();
        try {
            Companion companion = Companion;
            if (companion.getInstance().getCurrentAccessToken() != null) {
                AccessToken currentAccessToken = companion.getInstance().getCurrentAccessToken();
                if (currentAccessToken == null) {
                    str = null;
                } else {
                    str = currentAccessToken.getUserId();
                }
                if (str == accessToken.getUserId()) {
                    if (!atomicBoolean.get() && accessToken3 == null && expiresAt == 0) {
                        if (accessTokenRefreshCallback2 != null) {
                            accessTokenRefreshCallback2.OnTokenRefreshFailed(new FacebookException("Failed to refresh access token"));
                        }
                        accessTokenManager2.tokenRefreshInProgress.set(false);
                        return;
                    }
                    Date expires = accessToken.getExpires();
                    if (refreshResult.getExpiresAt() != 0) {
                        expires = new Date(((long) refreshResult.getExpiresAt()) * 1000);
                    } else if (refreshResult.getExpiresIn() != 0) {
                        expires = new Date((((long) refreshResult.getExpiresIn()) * 1000) + new Date().getTime());
                    }
                    Date date2 = expires;
                    if (accessToken3 == null) {
                        accessToken3 = accessToken.getToken();
                    }
                    String str2 = accessToken3;
                    String applicationId = accessToken.getApplicationId();
                    String userId = accessToken.getUserId();
                    if (atomicBoolean.get()) {
                        set4 = set7;
                    } else {
                        set4 = accessToken.getPermissions();
                    }
                    if (atomicBoolean.get()) {
                        set5 = set8;
                    } else {
                        set5 = accessToken.getDeclinedPermissions();
                    }
                    if (atomicBoolean.get()) {
                        set6 = set9;
                    } else {
                        set6 = accessToken.getExpiredPermissions();
                    }
                    AccessTokenSource source = accessToken.getSource();
                    Date date3 = new Date();
                    if (dataAccessExpirationTime != null) {
                        date = new Date(dataAccessExpirationTime.longValue() * 1000);
                    } else {
                        date = accessToken.getDataAccessExpirationTime();
                    }
                    Date date4 = date;
                    if (graphDomain == null) {
                        graphDomain = accessToken.getGraphDomain();
                    }
                    AccessToken accessToken4 = new AccessToken(str2, applicationId, userId, set4, set5, set6, source, date2, date3, date4, graphDomain);
                    try {
                        companion.getInstance().setCurrentAccessToken(accessToken4);
                        accessTokenManager2.tokenRefreshInProgress.set(false);
                        if (accessTokenRefreshCallback2 != null) {
                            accessTokenRefreshCallback2.OnTokenRefreshed(accessToken4);
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        accessToken2 = accessToken4;
                        accessTokenManager2.tokenRefreshInProgress.set(false);
                        if (!(accessTokenRefreshCallback2 == null || accessToken2 == null)) {
                            accessTokenRefreshCallback2.OnTokenRefreshed(accessToken2);
                        }
                        throw th;
                    }
                }
            }
            if (accessTokenRefreshCallback2 != null) {
                accessTokenRefreshCallback2.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
            }
            accessTokenManager2.tokenRefreshInProgress.set(false);
        } catch (Throwable th3) {
            th = th3;
            accessToken2 = null;
            accessTokenManager2.tokenRefreshInProgress.set(false);
            accessTokenRefreshCallback2.OnTokenRefreshed(accessToken2);
            throw th;
        }
    }

    private final void sendCurrentAccessTokenChangedBroadcastIntent(AccessToken accessToken, AccessToken accessToken2) {
        Intent intent = new Intent(FacebookSdk.getApplicationContext(), CurrentAccessTokenExpirationBroadcastReceiver.class);
        intent.setAction(ACTION_CURRENT_ACCESS_TOKEN_CHANGED);
        intent.putExtra(EXTRA_OLD_ACCESS_TOKEN, accessToken);
        intent.putExtra(EXTRA_NEW_ACCESS_TOKEN, accessToken2);
        this.localBroadcastManager.d(intent);
    }

    private final void setTokenExpirationBroadcastAlarm() {
        Date date;
        Context applicationContext = FacebookSdk.getApplicationContext();
        AccessToken.Companion companion = AccessToken.Companion;
        AccessToken currentAccessToken = companion.getCurrentAccessToken();
        AlarmManager alarmManager = (AlarmManager) applicationContext.getSystemService("alarm");
        if (companion.isCurrentAccessTokenActive()) {
            if (currentAccessToken == null) {
                date = null;
            } else {
                date = currentAccessToken.getExpires();
            }
            if (date != null && alarmManager != null) {
                Intent intent = new Intent(applicationContext, CurrentAccessTokenExpirationBroadcastReceiver.class);
                intent.setAction(ACTION_CURRENT_ACCESS_TOKEN_CHANGED);
                try {
                    alarmManager.set(1, currentAccessToken.getExpires().getTime(), PendingIntent.getBroadcast(applicationContext, 0, intent, 67108864));
                } catch (Exception unused) {
                }
            }
        }
    }

    private final boolean shouldExtendAccessToken() {
        AccessToken currentAccessToken = getCurrentAccessToken();
        if (currentAccessToken == null) {
            return false;
        }
        long time = new Date().getTime();
        if (!currentAccessToken.getSource().canExtendToken() || time - this.lastAttemptedTokenExtendDate.getTime() <= DateUtils.MILLIS_IN_HOUR || time - currentAccessToken.getLastRefresh().getTime() <= 86400000) {
            return false;
        }
        return true;
    }

    public final void currentAccessTokenChanged() {
        sendCurrentAccessTokenChangedBroadcastIntent(getCurrentAccessToken(), getCurrentAccessToken());
    }

    public final void extendAccessTokenIfNeeded() {
        if (shouldExtendAccessToken()) {
            refreshCurrentAccessToken((AccessToken.AccessTokenRefreshCallback) null);
        }
    }

    public final AccessToken getCurrentAccessToken() {
        return this.currentAccessTokenField;
    }

    public final boolean loadCurrentAccessToken() {
        AccessToken load = this.accessTokenCache.load();
        if (load == null) {
            return false;
        }
        setCurrentAccessToken(load, false);
        return true;
    }

    public final void refreshCurrentAccessToken(AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback) {
        if (j.b(Looper.getMainLooper(), Looper.myLooper())) {
            refreshCurrentAccessTokenImpl(accessTokenRefreshCallback);
        } else {
            new Handler(Looper.getMainLooper()).post(new a(this, accessTokenRefreshCallback));
        }
    }

    public final void setCurrentAccessToken(AccessToken accessToken) {
        setCurrentAccessToken(accessToken, true);
    }

    private final void setCurrentAccessToken(AccessToken accessToken, boolean z10) {
        AccessToken accessToken2 = this.currentAccessTokenField;
        this.currentAccessTokenField = accessToken;
        this.tokenRefreshInProgress.set(false);
        this.lastAttemptedTokenExtendDate = new Date(0);
        if (z10) {
            if (accessToken != null) {
                this.accessTokenCache.save(accessToken);
            } else {
                this.accessTokenCache.clear();
                Utility utility = Utility.INSTANCE;
                Utility.clearFacebookCookies(FacebookSdk.getApplicationContext());
            }
        }
        if (!Utility.areObjectsEqual(accessToken2, accessToken)) {
            sendCurrentAccessTokenChangedBroadcastIntent(accessToken2, accessToken);
            setTokenExpirationBroadcastAlarm();
        }
    }
}
