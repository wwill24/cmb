package com.facebook;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.LegacyTokenHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.leanplum.internal.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.json.JSONException;
import org.json.a;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u001e\n\u0002\u0010\u001e\n\u0002\b\u000b\u0018\u0000 I2\u00020\u0001:\u0003JKIB\u0001\b\u0017\u0012\u0006\u0010@\u001a\u00020\u0002\u0012\u0006\u00105\u001a\u00020\u0002\u0012\u0006\u00107\u001a\u00020\u0002\u0012\u0010\u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010A\u0012\u0010\u0010'\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010A\u0012\u0010\u0010)\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010A\u0012\b\u0010B\u001a\u0004\u0018\u00010\t\u0012\b\u0010C\u001a\u0004\u0018\u00010\u001d\u0012\b\u0010D\u001a\u0004\u0018\u00010\u001d\u0012\b\u00109\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bE\u0010FB\u0011\b\u0010\u0012\u0006\u0010G\u001a\u00020\u0019¢\u0006\u0004\bE\u0010HJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0002J\u001a\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0016J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u000f\u0010\u0017\u001a\u00020\u0014H\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0016J\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0012H\u0016R\u0017\u0010\u001e\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001f\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\"8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001f\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\"8\u0006¢\u0006\f\n\u0004\b'\u0010$\u001a\u0004\b(\u0010&R\u001f\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\"8\u0006¢\u0006\f\n\u0004\b)\u0010$\u001a\u0004\b*\u0010&R\u0017\u0010+\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0017\u0010/\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0017\u00103\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b3\u0010\u001f\u001a\u0004\b4\u0010!R\u0017\u00105\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b5\u0010,\u001a\u0004\b6\u0010.R\u0017\u00107\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b7\u0010,\u001a\u0004\b8\u0010.R\u0017\u00109\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b9\u0010\u001f\u001a\u0004\b:\u0010!R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010,\u001a\u0004\b;\u0010.R\u0011\u0010<\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0011\u0010>\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b>\u0010=R\u0011\u0010?\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b?\u0010=¨\u0006L"}, d2 = {"Lcom/facebook/AccessToken;", "Landroid/os/Parcelable;", "", "tokenToString", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "builder", "", "appendPermissions", "Lcom/facebook/AccessTokenSource;", "tokenSource", "graphDomain", "convertTokenSourceForGraphDomain", "toString", "", "other", "", "equals", "", "hashCode", "Lorg/json/b;", "toJSONObject$facebook_core_release", "()Lorg/json/b;", "toJSONObject", "describeContents", "Landroid/os/Parcel;", "dest", "flags", "writeToParcel", "Ljava/util/Date;", "expires", "Ljava/util/Date;", "getExpires", "()Ljava/util/Date;", "", "permissions", "Ljava/util/Set;", "getPermissions", "()Ljava/util/Set;", "declinedPermissions", "getDeclinedPermissions", "expiredPermissions", "getExpiredPermissions", "token", "Ljava/lang/String;", "getToken", "()Ljava/lang/String;", "source", "Lcom/facebook/AccessTokenSource;", "getSource", "()Lcom/facebook/AccessTokenSource;", "lastRefresh", "getLastRefresh", "applicationId", "getApplicationId", "userId", "getUserId", "dataAccessExpirationTime", "getDataAccessExpirationTime", "getGraphDomain", "isExpired", "()Z", "isDataAccessExpired", "isInstagramToken", "accessToken", "", "accessTokenSource", "expirationTime", "lastRefreshTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Collection;Ljava/util/Collection;Ljava/util/Collection;Lcom/facebook/AccessTokenSource;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;)V", "parcel", "(Landroid/os/Parcel;)V", "Companion", "AccessTokenCreationCallback", "AccessTokenRefreshCallback", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class AccessToken implements Parcelable {
    public static final String ACCESS_TOKEN_KEY = "access_token";
    private static final String APPLICATION_ID_KEY = "application_id";
    public static final Parcelable.Creator<AccessToken> CREATOR = new AccessToken$Companion$CREATOR$1();
    private static final int CURRENT_JSON_FORMAT = 1;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DATA_ACCESS_EXPIRATION_TIME = "data_access_expiration_time";
    private static final String DECLINED_PERMISSIONS_KEY = "declined_permissions";
    private static final AccessTokenSource DEFAULT_ACCESS_TOKEN_SOURCE = AccessTokenSource.FACEBOOK_APPLICATION_WEB;
    private static final Date DEFAULT_EXPIRATION_TIME;
    public static final String DEFAULT_GRAPH_DOMAIN = "facebook";
    private static final Date DEFAULT_LAST_REFRESH_TIME = new Date();
    private static final String EXPIRED_PERMISSIONS_KEY = "expired_permissions";
    private static final String EXPIRES_AT_KEY = "expires_at";
    public static final String EXPIRES_IN_KEY = "expires_in";
    public static final String GRAPH_DOMAIN = "graph_domain";
    private static final String LAST_REFRESH_KEY = "last_refresh";
    private static final Date MAX_DATE;
    private static final String PERMISSIONS_KEY = "permissions";
    private static final String SOURCE_KEY = "source";
    private static final String TOKEN_KEY = "token";
    public static final String USER_ID_KEY = "user_id";
    private static final String VERSION_KEY = "version";
    private final String applicationId;
    private final Date dataAccessExpirationTime;
    private final Set<String> declinedPermissions;
    private final Set<String> expiredPermissions;
    private final Date expires;
    private final String graphDomain;
    private final Date lastRefresh;
    private final Set<String> permissions;
    private final AccessTokenSource source;
    private final String token;
    private final String userId;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/facebook/AccessToken$AccessTokenCreationCallback;", "", "onError", "", "error", "Lcom/facebook/FacebookException;", "onSuccess", "token", "Lcom/facebook/AccessToken;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface AccessTokenCreationCallback {
        void onError(FacebookException facebookException);

        void onSuccess(AccessToken accessToken);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/facebook/AccessToken$AccessTokenRefreshCallback;", "", "OnTokenRefreshFailed", "", "exception", "Lcom/facebook/FacebookException;", "OnTokenRefreshed", "accessToken", "Lcom/facebook/AccessToken;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface AccessTokenRefreshCallback {
        void OnTokenRefreshFailed(FacebookException facebookException);

        void OnTokenRefreshed(AccessToken accessToken);
    }

    @Metadata(bv = {}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bN\u0010OJ<\u0010\r\u001a\u0004\u0018\u00010\f2\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0003H\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0007J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0007J\b\u0010\u0013\u001a\u00020\u0012H\u0007J\b\u0010\u0014\u001a\u00020\u0012H\u0007J\b\u0010\u0015\u001a\u00020\u0012H\u0007J\b\u0010\u0016\u001a\u00020\u0010H\u0007J\b\u0010\u0017\u001a\u00020\u0010H\u0007J\u0012\u0010\u0017\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0007J \u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001cH\u0007J!\u0010\"\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0001¢\u0006\u0004\b \u0010!J\u0017\u0010%\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\fH\u0000¢\u0006\u0004\b#\u0010$J\u0019\u0010(\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0001¢\u0006\u0004\b&\u0010'J)\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010)\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0004\b*\u0010+J\u0017\u00101\u001a\u00020\f2\u0006\u0010.\u001a\u00020-H\u0001¢\u0006\u0004\b/\u00100R\u0014\u00102\u001a\u00020\u00038\u0006XT¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00104\u001a\u00020\u00038\u0002XT¢\u0006\u0006\n\u0004\b4\u00103R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020\f058\u0006X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u00109\u001a\u0002088\u0002XT¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010;\u001a\u00020\u00038\u0006XT¢\u0006\u0006\n\u0004\b;\u00103R\u0014\u0010<\u001a\u00020\u00038\u0002XT¢\u0006\u0006\n\u0004\b<\u00103R\u0014\u0010=\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010?\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010A\u001a\u00020\u00038\u0006XT¢\u0006\u0006\n\u0004\bA\u00103R\u0014\u0010B\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010@R\u0014\u0010C\u001a\u00020\u00038\u0002XT¢\u0006\u0006\n\u0004\bC\u00103R\u0014\u0010D\u001a\u00020\u00038\u0002XT¢\u0006\u0006\n\u0004\bD\u00103R\u0014\u0010E\u001a\u00020\u00038\u0006XT¢\u0006\u0006\n\u0004\bE\u00103R\u0014\u0010F\u001a\u00020\u00038\u0006XT¢\u0006\u0006\n\u0004\bF\u00103R\u0014\u0010G\u001a\u00020\u00038\u0002XT¢\u0006\u0006\n\u0004\bG\u00103R\u0014\u0010H\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010@R\u0014\u0010I\u001a\u00020\u00038\u0002XT¢\u0006\u0006\n\u0004\bI\u00103R\u0014\u0010J\u001a\u00020\u00038\u0002XT¢\u0006\u0006\n\u0004\bJ\u00103R\u0014\u0010K\u001a\u00020\u00038\u0002XT¢\u0006\u0006\n\u0004\bK\u00103R\u0014\u0010L\u001a\u00020\u00038\u0006XT¢\u0006\u0006\n\u0004\bL\u00103R\u0014\u0010M\u001a\u00020\u00038\u0002XT¢\u0006\u0006\n\u0004\bM\u00103¨\u0006P"}, d2 = {"Lcom/facebook/AccessToken$Companion;", "", "", "", "requestedPermissions", "Landroid/os/Bundle;", "bundle", "Lcom/facebook/AccessTokenSource;", "source", "Ljava/util/Date;", "expirationBase", "applicationId", "Lcom/facebook/AccessToken;", "createFromBundle", "getCurrentAccessToken", "accessToken", "", "setCurrentAccessToken", "", "isCurrentAccessTokenActive", "isDataAccessActive", "isLoggedInWithInstagram", "expireCurrentAccessToken", "refreshCurrentAccessTokenAsync", "Lcom/facebook/AccessToken$AccessTokenRefreshCallback;", "callback", "Landroid/content/Intent;", "intent", "Lcom/facebook/AccessToken$AccessTokenCreationCallback;", "accessTokenCallback", "createFromNativeLinkingIntent", "current", "createFromRefresh$facebook_core_release", "(Lcom/facebook/AccessToken;Landroid/os/Bundle;)Lcom/facebook/AccessToken;", "createFromRefresh", "createExpired$facebook_core_release", "(Lcom/facebook/AccessToken;)Lcom/facebook/AccessToken;", "createExpired", "createFromLegacyCache$facebook_core_release", "(Landroid/os/Bundle;)Lcom/facebook/AccessToken;", "createFromLegacyCache", "key", "getPermissionsFromBundle$facebook_core_release", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/util/List;", "getPermissionsFromBundle", "Lorg/json/b;", "jsonObject", "createFromJSONObject$facebook_core_release", "(Lorg/json/b;)Lcom/facebook/AccessToken;", "createFromJSONObject", "ACCESS_TOKEN_KEY", "Ljava/lang/String;", "APPLICATION_ID_KEY", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "", "CURRENT_JSON_FORMAT", "I", "DATA_ACCESS_EXPIRATION_TIME", "DECLINED_PERMISSIONS_KEY", "DEFAULT_ACCESS_TOKEN_SOURCE", "Lcom/facebook/AccessTokenSource;", "DEFAULT_EXPIRATION_TIME", "Ljava/util/Date;", "DEFAULT_GRAPH_DOMAIN", "DEFAULT_LAST_REFRESH_TIME", "EXPIRED_PERMISSIONS_KEY", "EXPIRES_AT_KEY", "EXPIRES_IN_KEY", "GRAPH_DOMAIN", "LAST_REFRESH_KEY", "MAX_DATE", "PERMISSIONS_KEY", "SOURCE_KEY", "TOKEN_KEY", "USER_ID_KEY", "VERSION_KEY", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final AccessToken createFromBundle(List<String> list, Bundle bundle, AccessTokenSource accessTokenSource, Date date, String str) {
            Date bundleLongAsDate;
            String string;
            Bundle bundle2 = bundle;
            String string2 = bundle2.getString("access_token");
            if (string2 == null || (bundleLongAsDate = Utility.getBundleLongAsDate(bundle2, AccessToken.EXPIRES_IN_KEY, date)) == null || (string = bundle2.getString("user_id")) == null) {
                return null;
            }
            return new AccessToken(string2, str, string, list, (Collection) null, (Collection) null, accessTokenSource, bundleLongAsDate, new Date(), Utility.getBundleLongAsDate(bundle2, AccessToken.DATA_ACCESS_EXPIRATION_TIME, new Date(0)), (String) null, 1024, (DefaultConstructorMarker) null);
        }

        public final AccessToken createExpired$facebook_core_release(AccessToken accessToken) {
            j.g(accessToken, "current");
            return new AccessToken(accessToken.getToken(), accessToken.getApplicationId(), accessToken.getUserId(), accessToken.getPermissions(), accessToken.getDeclinedPermissions(), accessToken.getExpiredPermissions(), accessToken.getSource(), new Date(), new Date(), accessToken.getDataAccessExpirationTime(), (String) null, 1024, (DefaultConstructorMarker) null);
        }

        public final AccessToken createFromJSONObject$facebook_core_release(b bVar) throws JSONException {
            Collection collection;
            j.g(bVar, "jsonObject");
            if (bVar.getInt("version") <= 1) {
                String string = bVar.getString("token");
                Date date = new Date(bVar.getLong(AccessToken.EXPIRES_AT_KEY));
                a jSONArray = bVar.getJSONArray("permissions");
                a jSONArray2 = bVar.getJSONArray(AccessToken.DECLINED_PERMISSIONS_KEY);
                a optJSONArray = bVar.optJSONArray(AccessToken.EXPIRED_PERMISSIONS_KEY);
                Date date2 = new Date(bVar.getLong(AccessToken.LAST_REFRESH_KEY));
                String string2 = bVar.getString("source");
                j.f(string2, "jsonObject.getString(SOURCE_KEY)");
                AccessTokenSource valueOf = AccessTokenSource.valueOf(string2);
                String string3 = bVar.getString(AccessToken.APPLICATION_ID_KEY);
                String string4 = bVar.getString("user_id");
                Date date3 = new Date(bVar.optLong(AccessToken.DATA_ACCESS_EXPIRATION_TIME, 0));
                String optString = bVar.optString("graph_domain", (String) null);
                j.f(string, "token");
                j.f(string3, "applicationId");
                j.f(string4, Constants.Params.USER_ID);
                Utility utility = Utility.INSTANCE;
                j.f(jSONArray, "permissionsArray");
                List<String> jsonArrayToStringList = Utility.jsonArrayToStringList(jSONArray);
                j.f(jSONArray2, "declinedPermissionsArray");
                List<String> jsonArrayToStringList2 = Utility.jsonArrayToStringList(jSONArray2);
                if (optJSONArray == null) {
                    collection = new ArrayList();
                } else {
                    collection = Utility.jsonArrayToStringList(optJSONArray);
                }
                return new AccessToken(string, string3, string4, jsonArrayToStringList, jsonArrayToStringList2, collection, valueOf, date, date2, date3, optString);
            }
            throw new FacebookException("Unknown AccessToken serialization format.");
        }

        public final AccessToken createFromLegacyCache$facebook_core_release(Bundle bundle) {
            String str;
            Bundle bundle2 = bundle;
            j.g(bundle2, "bundle");
            List<String> permissionsFromBundle$facebook_core_release = getPermissionsFromBundle$facebook_core_release(bundle2, LegacyTokenHelper.PERMISSIONS_KEY);
            List<String> permissionsFromBundle$facebook_core_release2 = getPermissionsFromBundle$facebook_core_release(bundle2, LegacyTokenHelper.DECLINED_PERMISSIONS_KEY);
            List<String> permissionsFromBundle$facebook_core_release3 = getPermissionsFromBundle$facebook_core_release(bundle2, LegacyTokenHelper.EXPIRED_PERMISSIONS_KEY);
            LegacyTokenHelper.Companion companion = LegacyTokenHelper.Companion;
            String applicationId = companion.getApplicationId(bundle2);
            if (Utility.isNullOrEmpty(applicationId)) {
                applicationId = FacebookSdk.getApplicationId();
            }
            String str2 = applicationId;
            String token = companion.getToken(bundle2);
            if (token == null) {
                return null;
            }
            b awaitGetGraphMeRequestWithCache = Utility.awaitGetGraphMeRequestWithCache(token);
            if (awaitGetGraphMeRequestWithCache == null) {
                str = null;
            } else {
                try {
                    str = awaitGetGraphMeRequestWithCache.getString("id");
                } catch (JSONException unused) {
                    return null;
                }
            }
            if (str2 == null || str == null) {
                return null;
            }
            return new AccessToken(token, str2, str, permissionsFromBundle$facebook_core_release, permissionsFromBundle$facebook_core_release2, permissionsFromBundle$facebook_core_release3, companion.getSource(bundle2), companion.getExpirationDate(bundle2), companion.getLastRefreshDate(bundle2), (Date) null, (String) null, 1024, (DefaultConstructorMarker) null);
        }

        public final void createFromNativeLinkingIntent(Intent intent, String str, AccessTokenCreationCallback accessTokenCreationCallback) {
            boolean z10;
            j.g(intent, SDKConstants.PARAM_INTENT);
            j.g(str, "applicationId");
            j.g(accessTokenCreationCallback, "accessTokenCallback");
            if (intent.getExtras() == null) {
                accessTokenCreationCallback.onError(new FacebookException("No extras found on intent"));
                return;
            }
            Bundle bundle = new Bundle(intent.getExtras());
            String string = bundle.getString("access_token");
            if (string != null) {
                boolean z11 = true;
                if (string.length() == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10) {
                    String string2 = bundle.getString("user_id");
                    if (string2 != null) {
                        if (string2.length() != 0) {
                            z11 = false;
                        }
                        if (!z11) {
                            accessTokenCreationCallback.onSuccess(createFromBundle((List<String>) null, bundle, AccessTokenSource.FACEBOOK_APPLICATION_WEB, new Date(), str));
                            return;
                        }
                    }
                    Utility utility = Utility.INSTANCE;
                    Utility.getGraphMeRequestWithCacheAsync(string, new AccessToken$Companion$createFromNativeLinkingIntent$1(bundle, accessTokenCreationCallback, str));
                    return;
                }
            }
            accessTokenCreationCallback.onError(new FacebookException("No access token found on intent"));
        }

        @SuppressLint({"FieldGetter"})
        public final AccessToken createFromRefresh$facebook_core_release(AccessToken accessToken, Bundle bundle) {
            Bundle bundle2 = bundle;
            j.g(accessToken, "current");
            j.g(bundle2, "bundle");
            if (accessToken.getSource() == AccessTokenSource.FACEBOOK_APPLICATION_WEB || accessToken.getSource() == AccessTokenSource.FACEBOOK_APPLICATION_NATIVE || accessToken.getSource() == AccessTokenSource.FACEBOOK_APPLICATION_SERVICE) {
                Utility utility = Utility.INSTANCE;
                Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle2, AccessToken.EXPIRES_IN_KEY, new Date(0));
                String string = bundle2.getString("access_token");
                if (string == null) {
                    return null;
                }
                String string2 = bundle2.getString("graph_domain");
                Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle2, AccessToken.DATA_ACCESS_EXPIRATION_TIME, new Date(0));
                if (Utility.isNullOrEmpty(string)) {
                    return null;
                }
                return new AccessToken(string, accessToken.getApplicationId(), accessToken.getUserId(), accessToken.getPermissions(), accessToken.getDeclinedPermissions(), accessToken.getExpiredPermissions(), accessToken.getSource(), bundleLongAsDate, new Date(), bundleLongAsDate2, string2);
            }
            throw new FacebookException(j.p("Invalid token source: ", accessToken.getSource()));
        }

        public final void expireCurrentAccessToken() {
            AccessToken currentAccessToken = AccessTokenManager.Companion.getInstance().getCurrentAccessToken();
            if (currentAccessToken != null) {
                setCurrentAccessToken(createExpired$facebook_core_release(currentAccessToken));
            }
        }

        public final AccessToken getCurrentAccessToken() {
            return AccessTokenManager.Companion.getInstance().getCurrentAccessToken();
        }

        public final List<String> getPermissionsFromBundle$facebook_core_release(Bundle bundle, String str) {
            j.g(bundle, "bundle");
            ArrayList<String> stringArrayList = bundle.getStringArrayList(str);
            if (stringArrayList == null) {
                return q.j();
            }
            List<String> unmodifiableList = Collections.unmodifiableList(new ArrayList(stringArrayList));
            j.f(unmodifiableList, "{\n            Collections.unmodifiableList(ArrayList(originalPermissions))\n          }");
            return unmodifiableList;
        }

        public final boolean isCurrentAccessTokenActive() {
            AccessToken currentAccessToken = AccessTokenManager.Companion.getInstance().getCurrentAccessToken();
            if (currentAccessToken == null || currentAccessToken.isExpired()) {
                return false;
            }
            return true;
        }

        public final boolean isDataAccessActive() {
            AccessToken currentAccessToken = AccessTokenManager.Companion.getInstance().getCurrentAccessToken();
            if (currentAccessToken == null || currentAccessToken.isDataAccessExpired()) {
                return false;
            }
            return true;
        }

        public final boolean isLoggedInWithInstagram() {
            AccessToken currentAccessToken = AccessTokenManager.Companion.getInstance().getCurrentAccessToken();
            if (currentAccessToken == null || currentAccessToken.isExpired() || !currentAccessToken.isInstagramToken()) {
                return false;
            }
            return true;
        }

        public final void refreshCurrentAccessTokenAsync() {
            AccessTokenManager.Companion.getInstance().refreshCurrentAccessToken((AccessTokenRefreshCallback) null);
        }

        public final void setCurrentAccessToken(AccessToken accessToken) {
            AccessTokenManager.Companion.getInstance().setCurrentAccessToken(accessToken);
        }

        public final void refreshCurrentAccessTokenAsync(AccessTokenRefreshCallback accessTokenRefreshCallback) {
            AccessTokenManager.Companion.getInstance().refreshCurrentAccessToken(accessTokenRefreshCallback);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AccessTokenSource.values().length];
            iArr[AccessTokenSource.FACEBOOK_APPLICATION_WEB.ordinal()] = 1;
            iArr[AccessTokenSource.CHROME_CUSTOM_TAB.ordinal()] = 2;
            iArr[AccessTokenSource.WEB_VIEW.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        Date date = new Date(Long.MAX_VALUE);
        MAX_DATE = date;
        DEFAULT_EXPIRATION_TIME = date;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AccessToken(java.lang.String r16, java.lang.String r17, java.lang.String r18, java.util.Collection<java.lang.String> r19, java.util.Collection<java.lang.String> r20, java.util.Collection<java.lang.String> r21, com.facebook.AccessTokenSource r22, java.util.Date r23, java.util.Date r24, java.util.Date r25) {
        /*
            r15 = this;
            java.lang.String r0 = "accessToken"
            r2 = r16
            kotlin.jvm.internal.j.g(r2, r0)
            java.lang.String r0 = "applicationId"
            r3 = r17
            kotlin.jvm.internal.j.g(r3, r0)
            java.lang.String r0 = "userId"
            r4 = r18
            kotlin.jvm.internal.j.g(r4, r0)
            r12 = 0
            r13 = 1024(0x400, float:1.435E-42)
            r14 = 0
            r1 = r15
            r5 = r19
            r6 = r20
            r7 = r21
            r8 = r22
            r9 = r23
            r10 = r24
            r11 = r25
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.AccessToken.<init>(java.lang.String, java.lang.String, java.lang.String, java.util.Collection, java.util.Collection, java.util.Collection, com.facebook.AccessTokenSource, java.util.Date, java.util.Date, java.util.Date):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AccessToken(String str, String str2, String str3, Collection collection, Collection collection2, Collection collection3, AccessTokenSource accessTokenSource, Date date, Date date2, Date date3, String str4, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, collection, collection2, collection3, accessTokenSource, date, date2, date3, (i10 & 1024) != 0 ? DEFAULT_GRAPH_DOMAIN : str4);
    }

    private final void appendPermissions(StringBuilder sb2) {
        sb2.append(" permissions:");
        sb2.append("[");
        sb2.append(TextUtils.join(", ", this.permissions));
        sb2.append("]");
    }

    private final AccessTokenSource convertTokenSourceForGraphDomain(AccessTokenSource accessTokenSource, String str) {
        if (str == null || !str.equals(FacebookSdk.INSTAGRAM)) {
            return accessTokenSource;
        }
        int i10 = WhenMappings.$EnumSwitchMapping$0[accessTokenSource.ordinal()];
        if (i10 == 1) {
            return AccessTokenSource.INSTAGRAM_APPLICATION_WEB;
        }
        if (i10 == 2) {
            return AccessTokenSource.INSTAGRAM_CUSTOM_CHROME_TAB;
        }
        if (i10 != 3) {
            return accessTokenSource;
        }
        return AccessTokenSource.INSTAGRAM_WEB_VIEW;
    }

    public static final AccessToken createFromJSONObject$facebook_core_release(b bVar) throws JSONException {
        return Companion.createFromJSONObject$facebook_core_release(bVar);
    }

    public static final AccessToken createFromLegacyCache$facebook_core_release(Bundle bundle) {
        return Companion.createFromLegacyCache$facebook_core_release(bundle);
    }

    public static final void createFromNativeLinkingIntent(Intent intent, String str, AccessTokenCreationCallback accessTokenCreationCallback) {
        Companion.createFromNativeLinkingIntent(intent, str, accessTokenCreationCallback);
    }

    @SuppressLint({"FieldGetter"})
    public static final AccessToken createFromRefresh$facebook_core_release(AccessToken accessToken, Bundle bundle) {
        return Companion.createFromRefresh$facebook_core_release(accessToken, bundle);
    }

    public static final void expireCurrentAccessToken() {
        Companion.expireCurrentAccessToken();
    }

    public static final AccessToken getCurrentAccessToken() {
        return Companion.getCurrentAccessToken();
    }

    public static final List<String> getPermissionsFromBundle$facebook_core_release(Bundle bundle, String str) {
        return Companion.getPermissionsFromBundle$facebook_core_release(bundle, str);
    }

    public static final boolean isCurrentAccessTokenActive() {
        return Companion.isCurrentAccessTokenActive();
    }

    public static final boolean isDataAccessActive() {
        return Companion.isDataAccessActive();
    }

    public static final boolean isLoggedInWithInstagram() {
        return Companion.isLoggedInWithInstagram();
    }

    public static final void refreshCurrentAccessTokenAsync() {
        Companion.refreshCurrentAccessTokenAsync();
    }

    public static final void refreshCurrentAccessTokenAsync(AccessTokenRefreshCallback accessTokenRefreshCallback) {
        Companion.refreshCurrentAccessTokenAsync(accessTokenRefreshCallback);
    }

    public static final void setCurrentAccessToken(AccessToken accessToken) {
        Companion.setCurrentAccessToken(accessToken);
    }

    private final String tokenToString() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.INCLUDE_ACCESS_TOKENS)) {
            return this.token;
        }
        return "ACCESS_TOKEN_REMOVED";
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z10;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccessToken)) {
            return false;
        }
        AccessToken accessToken = (AccessToken) obj;
        if (j.b(this.expires, accessToken.expires) && j.b(this.permissions, accessToken.permissions) && j.b(this.declinedPermissions, accessToken.declinedPermissions) && j.b(this.expiredPermissions, accessToken.expiredPermissions) && j.b(this.token, accessToken.token) && this.source == accessToken.source && j.b(this.lastRefresh, accessToken.lastRefresh) && j.b(this.applicationId, accessToken.applicationId) && j.b(this.userId, accessToken.userId) && j.b(this.dataAccessExpirationTime, accessToken.dataAccessExpirationTime)) {
            String str = this.graphDomain;
            String str2 = accessToken.graphDomain;
            if (str != null) {
                z10 = j.b(str, str2);
            } else if (str2 == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                return true;
            }
        }
        return false;
    }

    public final String getApplicationId() {
        return this.applicationId;
    }

    public final Date getDataAccessExpirationTime() {
        return this.dataAccessExpirationTime;
    }

    public final Set<String> getDeclinedPermissions() {
        return this.declinedPermissions;
    }

    public final Set<String> getExpiredPermissions() {
        return this.expiredPermissions;
    }

    public final Date getExpires() {
        return this.expires;
    }

    public final String getGraphDomain() {
        return this.graphDomain;
    }

    public final Date getLastRefresh() {
        return this.lastRefresh;
    }

    public final Set<String> getPermissions() {
        return this.permissions;
    }

    public final AccessTokenSource getSource() {
        return this.source;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int i10;
        int hashCode = (((((((((((((((((((527 + this.expires.hashCode()) * 31) + this.permissions.hashCode()) * 31) + this.declinedPermissions.hashCode()) * 31) + this.expiredPermissions.hashCode()) * 31) + this.token.hashCode()) * 31) + this.source.hashCode()) * 31) + this.lastRefresh.hashCode()) * 31) + this.applicationId.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.dataAccessExpirationTime.hashCode()) * 31;
        String str = this.graphDomain;
        if (str == null) {
            i10 = 0;
        } else {
            i10 = str.hashCode();
        }
        return hashCode + i10;
    }

    public final boolean isDataAccessExpired() {
        return new Date().after(this.dataAccessExpirationTime);
    }

    public final boolean isExpired() {
        return new Date().after(this.expires);
    }

    public final boolean isInstagramToken() {
        String str = this.graphDomain;
        return str != null && str.equals(FacebookSdk.INSTAGRAM);
    }

    public final b toJSONObject$facebook_core_release() throws JSONException {
        b bVar = new b();
        bVar.put("version", 1);
        bVar.put("token", (Object) this.token);
        bVar.put(EXPIRES_AT_KEY, this.expires.getTime());
        bVar.put("permissions", (Object) new a((Collection<?>) this.permissions));
        bVar.put(DECLINED_PERMISSIONS_KEY, (Object) new a((Collection<?>) this.declinedPermissions));
        bVar.put(EXPIRED_PERMISSIONS_KEY, (Object) new a((Collection<?>) this.expiredPermissions));
        bVar.put(LAST_REFRESH_KEY, this.lastRefresh.getTime());
        bVar.put("source", (Object) this.source.name());
        bVar.put(APPLICATION_ID_KEY, (Object) this.applicationId);
        bVar.put("user_id", (Object) this.userId);
        bVar.put(DATA_ACCESS_EXPIRATION_TIME, this.dataAccessExpirationTime.getTime());
        String str = this.graphDomain;
        if (str != null) {
            bVar.put("graph_domain", (Object) str);
        }
        return bVar;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{AccessToken");
        sb2.append(" token:");
        sb2.append(tokenToString());
        appendPermissions(sb2);
        sb2.append("}");
        String sb3 = sb2.toString();
        j.f(sb3, "builder.toString()");
        return sb3;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "dest");
        parcel.writeLong(this.expires.getTime());
        parcel.writeStringList(new ArrayList(this.permissions));
        parcel.writeStringList(new ArrayList(this.declinedPermissions));
        parcel.writeStringList(new ArrayList(this.expiredPermissions));
        parcel.writeString(this.token);
        parcel.writeString(this.source.name());
        parcel.writeLong(this.lastRefresh.getTime());
        parcel.writeString(this.applicationId);
        parcel.writeString(this.userId);
        parcel.writeLong(this.dataAccessExpirationTime.getTime());
        parcel.writeString(this.graphDomain);
    }

    public AccessToken(String str, String str2, String str3, Collection<String> collection, Collection<String> collection2, Collection<String> collection3, AccessTokenSource accessTokenSource, Date date, Date date2, Date date3, String str4) {
        HashSet hashSet;
        HashSet hashSet2;
        HashSet hashSet3;
        j.g(str, SDKConstants.PARAM_ACCESS_TOKEN);
        j.g(str2, "applicationId");
        j.g(str3, Constants.Params.USER_ID);
        Validate.notEmpty(str, SDKConstants.PARAM_ACCESS_TOKEN);
        Validate.notEmpty(str2, "applicationId");
        Validate.notEmpty(str3, Constants.Params.USER_ID);
        this.expires = date == null ? DEFAULT_EXPIRATION_TIME : date;
        if (collection == null) {
            hashSet = new HashSet();
        }
        Set<String> unmodifiableSet = Collections.unmodifiableSet(hashSet);
        j.f(unmodifiableSet, "unmodifiableSet(if (permissions != null) HashSet(permissions) else HashSet())");
        this.permissions = unmodifiableSet;
        if (collection2 == null) {
            hashSet2 = new HashSet();
        }
        Set<String> unmodifiableSet2 = Collections.unmodifiableSet(hashSet2);
        j.f(unmodifiableSet2, "unmodifiableSet(\n            if (declinedPermissions != null) HashSet(declinedPermissions) else HashSet())");
        this.declinedPermissions = unmodifiableSet2;
        if (collection3 == null) {
            hashSet3 = new HashSet();
        }
        Set<String> unmodifiableSet3 = Collections.unmodifiableSet(hashSet3);
        j.f(unmodifiableSet3, "unmodifiableSet(\n            if (expiredPermissions != null) HashSet(expiredPermissions) else HashSet())");
        this.expiredPermissions = unmodifiableSet3;
        this.token = str;
        this.source = convertTokenSourceForGraphDomain(accessTokenSource == null ? DEFAULT_ACCESS_TOKEN_SOURCE : accessTokenSource, str4);
        this.lastRefresh = date2 == null ? DEFAULT_LAST_REFRESH_TIME : date2;
        this.applicationId = str2;
        this.userId = str3;
        this.dataAccessExpirationTime = (date3 == null || date3.getTime() == 0) ? DEFAULT_EXPIRATION_TIME : date3;
        this.graphDomain = str4 == null ? DEFAULT_GRAPH_DOMAIN : str4;
    }

    public AccessToken(Parcel parcel) {
        AccessTokenSource accessTokenSource;
        j.g(parcel, "parcel");
        this.expires = new Date(parcel.readLong());
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        Set<String> unmodifiableSet = Collections.unmodifiableSet(new HashSet(arrayList));
        j.f(unmodifiableSet, "unmodifiableSet(HashSet(permissionsList))");
        this.permissions = unmodifiableSet;
        arrayList.clear();
        parcel.readStringList(arrayList);
        Set<String> unmodifiableSet2 = Collections.unmodifiableSet(new HashSet(arrayList));
        j.f(unmodifiableSet2, "unmodifiableSet(HashSet(permissionsList))");
        this.declinedPermissions = unmodifiableSet2;
        arrayList.clear();
        parcel.readStringList(arrayList);
        Set<String> unmodifiableSet3 = Collections.unmodifiableSet(new HashSet(arrayList));
        j.f(unmodifiableSet3, "unmodifiableSet(HashSet(permissionsList))");
        this.expiredPermissions = unmodifiableSet3;
        this.token = Validate.notNullOrEmpty(parcel.readString(), "token");
        String readString = parcel.readString();
        if (readString != null) {
            accessTokenSource = AccessTokenSource.valueOf(readString);
        } else {
            accessTokenSource = DEFAULT_ACCESS_TOKEN_SOURCE;
        }
        this.source = accessTokenSource;
        this.lastRefresh = new Date(parcel.readLong());
        this.applicationId = Validate.notNullOrEmpty(parcel.readString(), "applicationId");
        this.userId = Validate.notNullOrEmpty(parcel.readString(), Constants.Params.USER_ID);
        this.dataAccessExpirationTime = new Date(parcel.readLong());
        this.graphDomain = parcel.readString();
    }
}
