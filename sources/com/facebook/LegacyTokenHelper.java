package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.Logger;
import com.mparticle.identity.IdentityHttpResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.json.JSONException;
import org.json.a;
import org.json.b;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eJ \u0010\u0011\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/facebook/LegacyTokenHelper;", "", "context", "Landroid/content/Context;", "cacheKey", "", "(Landroid/content/Context;Ljava/lang/String;)V", "cache", "Landroid/content/SharedPreferences;", "clear", "", "deserializeKey", "key", "bundle", "Landroid/os/Bundle;", "load", "save", "serializeKey", "editor", "Landroid/content/SharedPreferences$Editor;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LegacyTokenHelper {
    public static final String APPLICATION_ID_KEY = "com.facebook.TokenCachingStrategy.ApplicationId";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DECLINED_PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.DeclinedPermissions";
    public static final String DEFAULT_CACHE_KEY = "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY";
    public static final String EXPIRATION_DATE_KEY = "com.facebook.TokenCachingStrategy.ExpirationDate";
    public static final String EXPIRED_PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.ExpiredPermissions";
    private static final long INVALID_BUNDLE_MILLISECONDS = Long.MIN_VALUE;
    private static final String IS_SSO_KEY = "com.facebook.TokenCachingStrategy.IsSSO";
    private static final String JSON_VALUE = "value";
    private static final String JSON_VALUE_ENUM_TYPE = "enumType";
    private static final String JSON_VALUE_TYPE = "valueType";
    public static final String LAST_REFRESH_DATE_KEY = "com.facebook.TokenCachingStrategy.LastRefreshDate";
    public static final String PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.Permissions";
    private static final String TAG = LegacyTokenHelper.class.getSimpleName();
    public static final String TOKEN_KEY = "com.facebook.TokenCachingStrategy.Token";
    public static final String TOKEN_SOURCE_KEY = "com.facebook.TokenCachingStrategy.AccessTokenSource";
    private static final String TYPE_BOOLEAN = "bool";
    private static final String TYPE_BOOLEAN_ARRAY = "bool[]";
    private static final String TYPE_BYTE = "byte";
    private static final String TYPE_BYTE_ARRAY = "byte[]";
    private static final String TYPE_CHAR = "char";
    private static final String TYPE_CHAR_ARRAY = "char[]";
    private static final String TYPE_DOUBLE = "double";
    private static final String TYPE_DOUBLE_ARRAY = "double[]";
    private static final String TYPE_ENUM = "enum";
    private static final String TYPE_FLOAT = "float";
    private static final String TYPE_FLOAT_ARRAY = "float[]";
    private static final String TYPE_INTEGER = "int";
    private static final String TYPE_INTEGER_ARRAY = "int[]";
    private static final String TYPE_LONG = "long";
    private static final String TYPE_LONG_ARRAY = "long[]";
    private static final String TYPE_SHORT = "short";
    private static final String TYPE_SHORT_ARRAY = "short[]";
    private static final String TYPE_STRING = "string";
    private static final String TYPE_STRING_LIST = "stringList";
    private final SharedPreferences cache;
    private final String cacheKey;

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010(\u001a\u0004\u0018\u00010\u00042\u0006\u0010)\u001a\u00020*H\u0007J\u001e\u0010+\u001a\u0004\u0018\u00010,2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010-\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010.\u001a\u0004\u0018\u00010,2\u0006\u0010)\u001a\u00020*H\u0007J\u0010\u0010/\u001a\u00020\n2\u0006\u0010)\u001a\u00020*H\u0007J\u0012\u00100\u001a\u0004\u0018\u00010,2\u0006\u0010)\u001a\u00020*H\u0007J\u0010\u00101\u001a\u00020\n2\u0006\u0010)\u001a\u00020*H\u0007J\u0018\u00102\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001032\u0006\u0010)\u001a\u00020*H\u0007J\u0012\u00104\u001a\u0004\u0018\u0001052\u0006\u0010)\u001a\u00020*H\u0007J\u0012\u00106\u001a\u0004\u0018\u00010\u00042\u0006\u0010)\u001a\u00020*H\u0007J\u0012\u00107\u001a\u0002082\b\u0010)\u001a\u0004\u0018\u00010*H\u0007J\u001a\u00109\u001a\u00020:2\u0006\u0010)\u001a\u00020*2\b\u0010;\u001a\u0004\u0018\u00010\u0004H\u0007J\"\u0010<\u001a\u00020:2\u0006\u0010)\u001a\u00020*2\b\u0010-\u001a\u0004\u0018\u00010\u00042\u0006\u0010=\u001a\u00020,H\u0002J\u001e\u0010>\u001a\u00020:2\u0006\u0010)\u001a\u00020*2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00040?H\u0007J\u0018\u0010@\u001a\u00020:2\u0006\u0010)\u001a\u00020*2\u0006\u0010;\u001a\u00020,H\u0007J\u0018\u0010A\u001a\u00020:2\u0006\u0010)\u001a\u00020*2\u0006\u0010;\u001a\u00020\nH\u0007J\u001e\u0010B\u001a\u00020:2\u0006\u0010)\u001a\u00020*2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00040?H\u0007J\u0018\u0010C\u001a\u00020:2\u0006\u0010)\u001a\u00020*2\u0006\u0010;\u001a\u00020,H\u0007J\u0018\u0010D\u001a\u00020:2\u0006\u0010)\u001a\u00020*2\u0006\u0010;\u001a\u00020\nH\u0007J\u001e\u0010E\u001a\u00020:2\u0006\u0010)\u001a\u00020*2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00040?H\u0007J\u0018\u0010F\u001a\u00020:2\u0006\u0010)\u001a\u00020*2\u0006\u0010;\u001a\u000205H\u0007J\u0018\u0010G\u001a\u00020:2\u0006\u0010)\u001a\u00020*2\u0006\u0010;\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0012*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/facebook/LegacyTokenHelper$Companion;", "", "()V", "APPLICATION_ID_KEY", "", "DECLINED_PERMISSIONS_KEY", "DEFAULT_CACHE_KEY", "EXPIRATION_DATE_KEY", "EXPIRED_PERMISSIONS_KEY", "INVALID_BUNDLE_MILLISECONDS", "", "IS_SSO_KEY", "JSON_VALUE", "JSON_VALUE_ENUM_TYPE", "JSON_VALUE_TYPE", "LAST_REFRESH_DATE_KEY", "PERMISSIONS_KEY", "TAG", "kotlin.jvm.PlatformType", "TOKEN_KEY", "TOKEN_SOURCE_KEY", "TYPE_BOOLEAN", "TYPE_BOOLEAN_ARRAY", "TYPE_BYTE", "TYPE_BYTE_ARRAY", "TYPE_CHAR", "TYPE_CHAR_ARRAY", "TYPE_DOUBLE", "TYPE_DOUBLE_ARRAY", "TYPE_ENUM", "TYPE_FLOAT", "TYPE_FLOAT_ARRAY", "TYPE_INTEGER", "TYPE_INTEGER_ARRAY", "TYPE_LONG", "TYPE_LONG_ARRAY", "TYPE_SHORT", "TYPE_SHORT_ARRAY", "TYPE_STRING", "TYPE_STRING_LIST", "getApplicationId", "bundle", "Landroid/os/Bundle;", "getDate", "Ljava/util/Date;", "key", "getExpirationDate", "getExpirationMilliseconds", "getLastRefreshDate", "getLastRefreshMilliseconds", "getPermissions", "", "getSource", "Lcom/facebook/AccessTokenSource;", "getToken", "hasTokenInformation", "", "putApplicationId", "", "value", "putDate", "date", "putDeclinedPermissions", "", "putExpirationDate", "putExpirationMilliseconds", "putExpiredPermissions", "putLastRefreshDate", "putLastRefreshMilliseconds", "putPermissions", "putSource", "putToken", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Date getDate(Bundle bundle, String str) {
            if (bundle == null) {
                return null;
            }
            long j10 = bundle.getLong(str, LegacyTokenHelper.INVALID_BUNDLE_MILLISECONDS);
            if (j10 == LegacyTokenHelper.INVALID_BUNDLE_MILLISECONDS) {
                return null;
            }
            return new Date(j10);
        }

        private final void putDate(Bundle bundle, String str, Date date) {
            bundle.putLong(str, date.getTime());
        }

        public final String getApplicationId(Bundle bundle) {
            j.g(bundle, "bundle");
            return bundle.getString(LegacyTokenHelper.APPLICATION_ID_KEY);
        }

        public final Date getExpirationDate(Bundle bundle) {
            j.g(bundle, "bundle");
            return getDate(bundle, LegacyTokenHelper.EXPIRATION_DATE_KEY);
        }

        public final long getExpirationMilliseconds(Bundle bundle) {
            j.g(bundle, "bundle");
            return bundle.getLong(LegacyTokenHelper.EXPIRATION_DATE_KEY);
        }

        public final Date getLastRefreshDate(Bundle bundle) {
            j.g(bundle, "bundle");
            return getDate(bundle, LegacyTokenHelper.LAST_REFRESH_DATE_KEY);
        }

        public final long getLastRefreshMilliseconds(Bundle bundle) {
            j.g(bundle, "bundle");
            return bundle.getLong(LegacyTokenHelper.LAST_REFRESH_DATE_KEY);
        }

        public final Set<String> getPermissions(Bundle bundle) {
            j.g(bundle, "bundle");
            ArrayList<String> stringArrayList = bundle.getStringArrayList(LegacyTokenHelper.PERMISSIONS_KEY);
            if (stringArrayList == null) {
                return null;
            }
            return new HashSet(stringArrayList);
        }

        public final AccessTokenSource getSource(Bundle bundle) {
            j.g(bundle, "bundle");
            if (bundle.containsKey(LegacyTokenHelper.TOKEN_SOURCE_KEY)) {
                return (AccessTokenSource) bundle.getSerializable(LegacyTokenHelper.TOKEN_SOURCE_KEY);
            }
            if (bundle.getBoolean(LegacyTokenHelper.IS_SSO_KEY)) {
                return AccessTokenSource.FACEBOOK_APPLICATION_WEB;
            }
            return AccessTokenSource.WEB_VIEW;
        }

        public final String getToken(Bundle bundle) {
            j.g(bundle, "bundle");
            return bundle.getString(LegacyTokenHelper.TOKEN_KEY);
        }

        public final boolean hasTokenInformation(Bundle bundle) {
            String string;
            boolean z10;
            if (bundle == null || (string = bundle.getString(LegacyTokenHelper.TOKEN_KEY)) == null) {
                return false;
            }
            if (string.length() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10 && bundle.getLong(LegacyTokenHelper.EXPIRATION_DATE_KEY, 0) != 0) {
                return true;
            }
            return false;
        }

        public final void putApplicationId(Bundle bundle, String str) {
            j.g(bundle, "bundle");
            bundle.putString(LegacyTokenHelper.APPLICATION_ID_KEY, str);
        }

        public final void putDeclinedPermissions(Bundle bundle, Collection<String> collection) {
            j.g(bundle, "bundle");
            j.g(collection, "value");
            bundle.putStringArrayList(LegacyTokenHelper.DECLINED_PERMISSIONS_KEY, new ArrayList(collection));
        }

        public final void putExpirationDate(Bundle bundle, Date date) {
            j.g(bundle, "bundle");
            j.g(date, "value");
            putDate(bundle, LegacyTokenHelper.EXPIRATION_DATE_KEY, date);
        }

        public final void putExpirationMilliseconds(Bundle bundle, long j10) {
            j.g(bundle, "bundle");
            bundle.putLong(LegacyTokenHelper.EXPIRATION_DATE_KEY, j10);
        }

        public final void putExpiredPermissions(Bundle bundle, Collection<String> collection) {
            j.g(bundle, "bundle");
            j.g(collection, "value");
            bundle.putStringArrayList(LegacyTokenHelper.EXPIRED_PERMISSIONS_KEY, new ArrayList(collection));
        }

        public final void putLastRefreshDate(Bundle bundle, Date date) {
            j.g(bundle, "bundle");
            j.g(date, "value");
            putDate(bundle, LegacyTokenHelper.LAST_REFRESH_DATE_KEY, date);
        }

        public final void putLastRefreshMilliseconds(Bundle bundle, long j10) {
            j.g(bundle, "bundle");
            bundle.putLong(LegacyTokenHelper.LAST_REFRESH_DATE_KEY, j10);
        }

        public final void putPermissions(Bundle bundle, Collection<String> collection) {
            j.g(bundle, "bundle");
            j.g(collection, "value");
            bundle.putStringArrayList(LegacyTokenHelper.PERMISSIONS_KEY, new ArrayList(collection));
        }

        public final void putSource(Bundle bundle, AccessTokenSource accessTokenSource) {
            j.g(bundle, "bundle");
            j.g(accessTokenSource, "value");
            bundle.putSerializable(LegacyTokenHelper.TOKEN_SOURCE_KEY, accessTokenSource);
        }

        public final void putToken(Bundle bundle, String str) {
            j.g(bundle, "bundle");
            j.g(str, "value");
            bundle.putString(LegacyTokenHelper.TOKEN_KEY, str);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LegacyTokenHelper(Context context) {
        this(context, (String) null, 2, (DefaultConstructorMarker) null);
        j.g(context, IdentityHttpResponse.CONTEXT);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
        if ((r4.length() == 0) != false) goto L_0x0016;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LegacyTokenHelper(android.content.Context r3, java.lang.String r4) {
        /*
            r2 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.j.g(r3, r0)
            r2.<init>()
            r0 = 0
            if (r4 == 0) goto L_0x0016
            int r1 = r4.length()
            if (r1 != 0) goto L_0x0013
            r1 = 1
            goto L_0x0014
        L_0x0013:
            r1 = r0
        L_0x0014:
            if (r1 == 0) goto L_0x0018
        L_0x0016:
            java.lang.String r4 = "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY"
        L_0x0018:
            r2.cacheKey = r4
            android.content.Context r1 = r3.getApplicationContext()
            if (r1 != 0) goto L_0x0021
            goto L_0x0022
        L_0x0021:
            r3 = r1
        L_0x0022:
            android.content.SharedPreferences r3 = r3.getSharedPreferences(r4, r0)
            java.lang.String r4 = "context.getSharedPreferences(this.cacheKey, Context.MODE_PRIVATE)"
            kotlin.jvm.internal.j.f(r3, r4)
            r2.cache = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.LegacyTokenHelper.<init>(android.content.Context, java.lang.String):void");
    }

    private final void deserializeKey(String str, Bundle bundle) throws JSONException {
        String str2;
        String string;
        String string2 = this.cache.getString(str, "{}");
        if (string2 != null) {
            b bVar = new b(string2);
            String string3 = bVar.getString(JSON_VALUE_TYPE);
            if (string3 != null) {
                int i10 = 0;
                switch (string3.hashCode()) {
                    case -1573317553:
                        if (string3.equals(TYPE_STRING_LIST)) {
                            a jSONArray = bVar.getJSONArray("value");
                            int o10 = jSONArray.o();
                            ArrayList arrayList = new ArrayList(o10);
                            if (o10 > 0) {
                                while (true) {
                                    int i11 = i10 + 1;
                                    Object obj = jSONArray.get(i10);
                                    if (obj == b.NULL) {
                                        str2 = null;
                                    } else if (obj != null) {
                                        str2 = (String) obj;
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                    arrayList.add(i10, str2);
                                    if (i11 < o10) {
                                        i10 = i11;
                                    }
                                }
                            }
                            bundle.putStringArrayList(str, arrayList);
                            return;
                        }
                        return;
                    case -1383386164:
                        if (string3.equals(TYPE_BOOLEAN_ARRAY)) {
                            a jSONArray2 = bVar.getJSONArray("value");
                            int o11 = jSONArray2.o();
                            boolean[] zArr = new boolean[o11];
                            int i12 = o11 - 1;
                            if (i12 >= 0) {
                                while (true) {
                                    int i13 = i10 + 1;
                                    zArr[i10] = jSONArray2.g(i10);
                                    if (i13 <= i12) {
                                        i10 = i13;
                                    }
                                }
                            }
                            bundle.putBooleanArray(str, zArr);
                            return;
                        }
                        return;
                    case -1374008726:
                        if (string3.equals(TYPE_BYTE_ARRAY)) {
                            a jSONArray3 = bVar.getJSONArray("value");
                            int o12 = jSONArray3.o();
                            byte[] bArr = new byte[o12];
                            int i14 = o12 - 1;
                            if (i14 >= 0) {
                                while (true) {
                                    int i15 = i10 + 1;
                                    bArr[i10] = (byte) jSONArray3.getInt(i10);
                                    if (i15 <= i14) {
                                        i10 = i15;
                                    }
                                }
                            }
                            bundle.putByteArray(str, bArr);
                            return;
                        }
                        return;
                    case -1361632968:
                        if (string3.equals(TYPE_CHAR_ARRAY)) {
                            a jSONArray4 = bVar.getJSONArray("value");
                            int o13 = jSONArray4.o();
                            char[] cArr = new char[o13];
                            int i16 = o13 - 1;
                            if (i16 >= 0) {
                                int i17 = 0;
                                while (true) {
                                    int i18 = i17 + 1;
                                    String n10 = jSONArray4.n(i17);
                                    if (n10 != null && n10.length() == 1) {
                                        cArr[i17] = n10.charAt(0);
                                    }
                                    if (i18 <= i16) {
                                        i17 = i18;
                                    }
                                }
                            }
                            bundle.putCharArray(str, cArr);
                            return;
                        }
                        return;
                    case -1325958191:
                        if (string3.equals(TYPE_DOUBLE)) {
                            bundle.putDouble(str, bVar.getDouble("value"));
                            return;
                        }
                        return;
                    case -1097129250:
                        if (string3.equals(TYPE_LONG_ARRAY)) {
                            a jSONArray5 = bVar.getJSONArray("value");
                            int o14 = jSONArray5.o();
                            long[] jArr = new long[o14];
                            int i19 = o14 - 1;
                            if (i19 >= 0) {
                                while (true) {
                                    int i20 = i10 + 1;
                                    jArr[i10] = jSONArray5.m(i10);
                                    if (i20 <= i19) {
                                        i10 = i20;
                                    }
                                }
                            }
                            bundle.putLongArray(str, jArr);
                            return;
                        }
                        return;
                    case -891985903:
                        if (string3.equals("string")) {
                            bundle.putString(str, bVar.getString("value"));
                            return;
                        }
                        return;
                    case -766441794:
                        if (string3.equals(TYPE_FLOAT_ARRAY)) {
                            a jSONArray6 = bVar.getJSONArray("value");
                            int o15 = jSONArray6.o();
                            float[] fArr = new float[o15];
                            int i21 = o15 - 1;
                            if (i21 >= 0) {
                                while (true) {
                                    int i22 = i10 + 1;
                                    fArr[i10] = (float) jSONArray6.i(i10);
                                    if (i22 <= i21) {
                                        i10 = i22;
                                    }
                                }
                            }
                            bundle.putFloatArray(str, fArr);
                            return;
                        }
                        return;
                    case 104431:
                        if (string3.equals("int")) {
                            bundle.putInt(str, bVar.getInt("value"));
                            return;
                        }
                        return;
                    case 3029738:
                        if (string3.equals("bool")) {
                            bundle.putBoolean(str, bVar.getBoolean("value"));
                            return;
                        }
                        return;
                    case 3039496:
                        if (string3.equals(TYPE_BYTE)) {
                            bundle.putByte(str, (byte) bVar.getInt("value"));
                            return;
                        }
                        return;
                    case 3052374:
                        if (string3.equals(TYPE_CHAR) && (string = bVar.getString("value")) != null && string.length() == 1) {
                            bundle.putChar(str, string.charAt(0));
                            return;
                        }
                        return;
                    case 3118337:
                        if (string3.equals(TYPE_ENUM)) {
                            try {
                                bundle.putSerializable(str, Enum.valueOf(Class.forName(bVar.getString(JSON_VALUE_ENUM_TYPE)), bVar.getString("value")));
                                return;
                            } catch (ClassNotFoundException | IllegalArgumentException unused) {
                                return;
                            }
                        } else {
                            return;
                        }
                    case 3327612:
                        if (string3.equals(TYPE_LONG)) {
                            bundle.putLong(str, bVar.getLong("value"));
                            return;
                        }
                        return;
                    case 97526364:
                        if (string3.equals("float")) {
                            bundle.putFloat(str, (float) bVar.getDouble("value"));
                            return;
                        }
                        return;
                    case 100361105:
                        if (string3.equals(TYPE_INTEGER_ARRAY)) {
                            a jSONArray7 = bVar.getJSONArray("value");
                            int o16 = jSONArray7.o();
                            int[] iArr = new int[o16];
                            int i23 = o16 - 1;
                            if (i23 >= 0) {
                                while (true) {
                                    int i24 = i10 + 1;
                                    iArr[i10] = jSONArray7.getInt(i10);
                                    if (i24 <= i23) {
                                        i10 = i24;
                                    }
                                }
                            }
                            bundle.putIntArray(str, iArr);
                            return;
                        }
                        return;
                    case 109413500:
                        if (string3.equals(TYPE_SHORT)) {
                            bundle.putShort(str, (short) bVar.getInt("value"));
                            return;
                        }
                        return;
                    case 1359468275:
                        if (string3.equals(TYPE_DOUBLE_ARRAY)) {
                            a jSONArray8 = bVar.getJSONArray("value");
                            int o17 = jSONArray8.o();
                            double[] dArr = new double[o17];
                            int i25 = o17 - 1;
                            if (i25 >= 0) {
                                while (true) {
                                    int i26 = i10 + 1;
                                    dArr[i10] = jSONArray8.i(i10);
                                    if (i26 <= i25) {
                                        i10 = i26;
                                    }
                                }
                            }
                            bundle.putDoubleArray(str, dArr);
                            return;
                        }
                        return;
                    case 2067161310:
                        if (string3.equals(TYPE_SHORT_ARRAY)) {
                            a jSONArray9 = bVar.getJSONArray("value");
                            int o18 = jSONArray9.o();
                            short[] sArr = new short[o18];
                            int i27 = o18 - 1;
                            if (i27 >= 0) {
                                while (true) {
                                    int i28 = i10 + 1;
                                    sArr[i10] = (short) jSONArray9.getInt(i10);
                                    if (i28 <= i27) {
                                        i10 = i28;
                                    }
                                }
                            }
                            bundle.putShortArray(str, sArr);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        } else {
            throw new IllegalStateException("Required value was null.".toString());
        }
    }

    public static final String getApplicationId(Bundle bundle) {
        return Companion.getApplicationId(bundle);
    }

    public static final Date getExpirationDate(Bundle bundle) {
        return Companion.getExpirationDate(bundle);
    }

    public static final long getExpirationMilliseconds(Bundle bundle) {
        return Companion.getExpirationMilliseconds(bundle);
    }

    public static final Date getLastRefreshDate(Bundle bundle) {
        return Companion.getLastRefreshDate(bundle);
    }

    public static final long getLastRefreshMilliseconds(Bundle bundle) {
        return Companion.getLastRefreshMilliseconds(bundle);
    }

    public static final Set<String> getPermissions(Bundle bundle) {
        return Companion.getPermissions(bundle);
    }

    public static final AccessTokenSource getSource(Bundle bundle) {
        return Companion.getSource(bundle);
    }

    public static final String getToken(Bundle bundle) {
        return Companion.getToken(bundle);
    }

    public static final boolean hasTokenInformation(Bundle bundle) {
        return Companion.hasTokenInformation(bundle);
    }

    public static final void putApplicationId(Bundle bundle, String str) {
        Companion.putApplicationId(bundle, str);
    }

    public static final void putDeclinedPermissions(Bundle bundle, Collection<String> collection) {
        Companion.putDeclinedPermissions(bundle, collection);
    }

    public static final void putExpirationDate(Bundle bundle, Date date) {
        Companion.putExpirationDate(bundle, date);
    }

    public static final void putExpirationMilliseconds(Bundle bundle, long j10) {
        Companion.putExpirationMilliseconds(bundle, j10);
    }

    public static final void putExpiredPermissions(Bundle bundle, Collection<String> collection) {
        Companion.putExpiredPermissions(bundle, collection);
    }

    public static final void putLastRefreshDate(Bundle bundle, Date date) {
        Companion.putLastRefreshDate(bundle, date);
    }

    public static final void putLastRefreshMilliseconds(Bundle bundle, long j10) {
        Companion.putLastRefreshMilliseconds(bundle, j10);
    }

    public static final void putPermissions(Bundle bundle, Collection<String> collection) {
        Companion.putPermissions(bundle, collection);
    }

    public static final void putSource(Bundle bundle, AccessTokenSource accessTokenSource) {
        Companion.putSource(bundle, accessTokenSource);
    }

    public static final void putToken(Bundle bundle, String str) {
        Companion.putToken(bundle, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x018b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void serializeKey(java.lang.String r9, android.os.Bundle r10, android.content.SharedPreferences.Editor r11) throws org.json.JSONException {
        /*
            r8 = this;
            java.lang.Object r10 = r10.get(r9)
            if (r10 != 0) goto L_0x0007
            return
        L_0x0007:
            org.json.b r0 = new org.json.b
            r0.<init>()
            boolean r1 = r10 instanceof java.lang.Byte
            r2 = 0
            java.lang.String r3 = "value"
            if (r1 == 0) goto L_0x0022
            java.lang.Number r10 = (java.lang.Number) r10
            byte r10 = r10.byteValue()
            r0.put((java.lang.String) r3, (int) r10)
            java.lang.String r10 = "byte"
        L_0x001e:
            r1 = r2
            r2 = r10
            goto L_0x0189
        L_0x0022:
            boolean r1 = r10 instanceof java.lang.Short
            if (r1 == 0) goto L_0x0032
            java.lang.Number r10 = (java.lang.Number) r10
            short r10 = r10.shortValue()
            r0.put((java.lang.String) r3, (int) r10)
            java.lang.String r10 = "short"
            goto L_0x001e
        L_0x0032:
            boolean r1 = r10 instanceof java.lang.Integer
            if (r1 == 0) goto L_0x0042
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            r0.put((java.lang.String) r3, (int) r10)
            java.lang.String r10 = "int"
            goto L_0x001e
        L_0x0042:
            boolean r1 = r10 instanceof java.lang.Long
            if (r1 == 0) goto L_0x0052
            java.lang.Number r10 = (java.lang.Number) r10
            long r4 = r10.longValue()
            r0.put((java.lang.String) r3, (long) r4)
            java.lang.String r10 = "long"
            goto L_0x001e
        L_0x0052:
            boolean r1 = r10 instanceof java.lang.Float
            if (r1 == 0) goto L_0x0063
            java.lang.Number r10 = (java.lang.Number) r10
            float r10 = r10.floatValue()
            double r4 = (double) r10
            r0.put((java.lang.String) r3, (double) r4)
            java.lang.String r10 = "float"
            goto L_0x001e
        L_0x0063:
            boolean r1 = r10 instanceof java.lang.Double
            if (r1 == 0) goto L_0x0073
            java.lang.Number r10 = (java.lang.Number) r10
            double r4 = r10.doubleValue()
            r0.put((java.lang.String) r3, (double) r4)
            java.lang.String r10 = "double"
            goto L_0x001e
        L_0x0073:
            boolean r1 = r10 instanceof java.lang.Boolean
            if (r1 == 0) goto L_0x0083
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            r0.put((java.lang.String) r3, (boolean) r10)
            java.lang.String r10 = "bool"
            goto L_0x001e
        L_0x0083:
            boolean r1 = r10 instanceof java.lang.Character
            if (r1 == 0) goto L_0x0091
            java.lang.String r10 = r10.toString()
            r0.put((java.lang.String) r3, (java.lang.Object) r10)
            java.lang.String r10 = "char"
            goto L_0x001e
        L_0x0091:
            boolean r1 = r10 instanceof java.lang.String
            if (r1 == 0) goto L_0x009b
            r0.put((java.lang.String) r3, (java.lang.Object) r10)
            java.lang.String r10 = "string"
            goto L_0x001e
        L_0x009b:
            boolean r1 = r10 instanceof java.lang.Enum
            if (r1 == 0) goto L_0x00b7
            java.lang.String r1 = r10.toString()
            r0.put((java.lang.String) r3, (java.lang.Object) r1)
            java.lang.Class r10 = r10.getClass()
            java.lang.String r10 = r10.getName()
            java.lang.String r1 = "enumType"
            r0.put((java.lang.String) r1, (java.lang.Object) r10)
            java.lang.String r10 = "enum"
            goto L_0x001e
        L_0x00b7:
            org.json.a r1 = new org.json.a
            r1.<init>()
            boolean r4 = r10 instanceof byte[]
            r5 = 0
            if (r4 == 0) goto L_0x00d2
            byte[] r10 = (byte[]) r10
            int r2 = r10.length
        L_0x00c4:
            if (r5 >= r2) goto L_0x00ce
            byte r4 = r10[r5]
            int r5 = r5 + 1
            r1.A(r4)
            goto L_0x00c4
        L_0x00ce:
            java.lang.String r2 = "byte[]"
            goto L_0x0189
        L_0x00d2:
            boolean r4 = r10 instanceof short[]
            if (r4 == 0) goto L_0x00e7
            short[] r10 = (short[]) r10
            int r2 = r10.length
        L_0x00d9:
            if (r5 >= r2) goto L_0x00e3
            short r4 = r10[r5]
            int r5 = r5 + 1
            r1.A(r4)
            goto L_0x00d9
        L_0x00e3:
            java.lang.String r2 = "short[]"
            goto L_0x0189
        L_0x00e7:
            boolean r4 = r10 instanceof int[]
            if (r4 == 0) goto L_0x00fc
            int[] r10 = (int[]) r10
            int r2 = r10.length
        L_0x00ee:
            if (r5 >= r2) goto L_0x00f8
            r4 = r10[r5]
            int r5 = r5 + 1
            r1.A(r4)
            goto L_0x00ee
        L_0x00f8:
            java.lang.String r2 = "int[]"
            goto L_0x0189
        L_0x00fc:
            boolean r4 = r10 instanceof long[]
            if (r4 == 0) goto L_0x0111
            long[] r10 = (long[]) r10
            int r2 = r10.length
        L_0x0103:
            if (r5 >= r2) goto L_0x010d
            r6 = r10[r5]
            int r5 = r5 + 1
            r1.D(r6)
            goto L_0x0103
        L_0x010d:
            java.lang.String r2 = "long[]"
            goto L_0x0189
        L_0x0111:
            boolean r4 = r10 instanceof float[]
            if (r4 == 0) goto L_0x0127
            float[] r10 = (float[]) r10
            int r2 = r10.length
        L_0x0118:
            if (r5 >= r2) goto L_0x0123
            r4 = r10[r5]
            int r5 = r5 + 1
            double r6 = (double) r4
            r1.z(r6)
            goto L_0x0118
        L_0x0123:
            java.lang.String r2 = "float[]"
            goto L_0x0189
        L_0x0127:
            boolean r4 = r10 instanceof double[]
            if (r4 == 0) goto L_0x013b
            double[] r10 = (double[]) r10
            int r2 = r10.length
        L_0x012e:
            if (r5 >= r2) goto L_0x0138
            r6 = r10[r5]
            int r5 = r5 + 1
            r1.z(r6)
            goto L_0x012e
        L_0x0138:
            java.lang.String r2 = "double[]"
            goto L_0x0189
        L_0x013b:
            boolean r4 = r10 instanceof boolean[]
            if (r4 == 0) goto L_0x014f
            boolean[] r10 = (boolean[]) r10
            int r2 = r10.length
        L_0x0142:
            if (r5 >= r2) goto L_0x014c
            boolean r4 = r10[r5]
            int r5 = r5 + 1
            r1.F(r4)
            goto L_0x0142
        L_0x014c:
            java.lang.String r2 = "bool[]"
            goto L_0x0189
        L_0x014f:
            boolean r4 = r10 instanceof char[]
            if (r4 == 0) goto L_0x0167
            char[] r10 = (char[]) r10
            int r2 = r10.length
        L_0x0156:
            if (r5 >= r2) goto L_0x0164
            char r4 = r10[r5]
            int r5 = r5 + 1
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r1.E(r4)
            goto L_0x0156
        L_0x0164:
            java.lang.String r2 = "char[]"
            goto L_0x0189
        L_0x0167:
            boolean r4 = r10 instanceof java.util.List
            if (r4 == 0) goto L_0x0188
            java.util.List r10 = (java.util.List) r10
            java.util.Iterator r10 = r10.iterator()
        L_0x0171:
            boolean r2 = r10.hasNext()
            if (r2 == 0) goto L_0x0185
            java.lang.Object r2 = r10.next()
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L_0x0181
            java.lang.Object r2 = org.json.b.NULL
        L_0x0181:
            r1.E(r2)
            goto L_0x0171
        L_0x0185:
            java.lang.String r2 = "stringList"
            goto L_0x0189
        L_0x0188:
            r1 = r2
        L_0x0189:
            if (r2 == 0) goto L_0x01a1
            java.lang.String r10 = "valueType"
            r0.put((java.lang.String) r10, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x0195
            r0.putOpt(r3, r1)
        L_0x0195:
            java.lang.String r10 = r0.toString()
            java.lang.String r0 = "json.toString()"
            kotlin.jvm.internal.j.f(r10, r0)
            r11.putString(r9, r10)
        L_0x01a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.LegacyTokenHelper.serializeKey(java.lang.String, android.os.Bundle, android.content.SharedPreferences$Editor):void");
    }

    public final void clear() {
        this.cache.edit().clear().apply();
    }

    public final Bundle load() {
        Bundle bundle = new Bundle();
        for (String next : this.cache.getAll().keySet()) {
            try {
                j.f(next, SDKConstants.PARAM_KEY);
                deserializeKey(next, bundle);
            } catch (JSONException e10) {
                Logger.Companion companion = Logger.Companion;
                LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                String str = TAG;
                j.f(str, "TAG");
                companion.log(loggingBehavior, 5, str, "Error reading cached value for key: '" + next + "' -- " + e10);
                return null;
            }
        }
        return bundle;
    }

    public final void save(Bundle bundle) {
        j.g(bundle, "bundle");
        SharedPreferences.Editor edit = this.cache.edit();
        for (String next : bundle.keySet()) {
            try {
                j.f(next, SDKConstants.PARAM_KEY);
                j.f(edit, "editor");
                serializeKey(next, bundle, edit);
            } catch (JSONException e10) {
                Logger.Companion companion = Logger.Companion;
                LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                String str = TAG;
                j.f(str, "TAG");
                companion.log(loggingBehavior, 5, str, "Error processing value for key: '" + next + "' -- " + e10);
                return;
            }
        }
        edit.apply();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LegacyTokenHelper(Context context, String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? null : str);
    }
}
