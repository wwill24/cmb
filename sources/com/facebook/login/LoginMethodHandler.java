package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.AuthenticationToken;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.text.d;
import org.json.JSONException;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\b'\u0018\u0000 82\u00020\u0001:\u00018B\u0011\b\u0016\u0012\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b5\u00101B\u0011\b\u0014\u0012\u0006\u00106\u001a\u00020\u001f¢\u0006\u0004\b5\u00107J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\"\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0014J\u001c\u0010\u0019\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0014J\u0012\u0010\u001b\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0012H\u0014J\u0018\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0014J\u0018\u0010\"\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0004H\u0016J\b\u0010#\u001a\u00020\nH\u0016R4\u0010%\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010$8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010,\u001a\u00020+8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0014\u00104\u001a\u00020\u00128&X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u00103¨\u00069"}, d2 = {"Lcom/facebook/login/LoginMethodHandler;", "Landroid/os/Parcelable;", "Lcom/facebook/login/LoginClient$Request;", "request", "", "tryAuthorize", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "", "onActivityResult", "needsInternetPermission", "", "cancel", "Lorg/json/b;", "param", "putChallengeParam", "", "getRedirectUrl", "authId", "getClientState", "key", "", "value", "addLoggingExtra", "e2e", "logWebLoginCompleted", "Landroid/os/Bundle;", "values", "processCodeExchange", "Landroid/os/Parcel;", "dest", "flags", "writeToParcel", "shouldKeepTrackOfMultipleIntents", "", "methodLoggingExtras", "Ljava/util/Map;", "getMethodLoggingExtras", "()Ljava/util/Map;", "setMethodLoggingExtras", "(Ljava/util/Map;)V", "Lcom/facebook/login/LoginClient;", "loginClient", "Lcom/facebook/login/LoginClient;", "getLoginClient", "()Lcom/facebook/login/LoginClient;", "setLoginClient", "(Lcom/facebook/login/LoginClient;)V", "getNameForLogging", "()Ljava/lang/String;", "nameForLogging", "<init>", "source", "(Landroid/os/Parcel;)V", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public abstract class LoginMethodHandler implements Parcelable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String NO_SIGNED_REQUEST_ERROR_MESSAGE = "Authorization response does not contain the signed_request";
    public static final String NO_USER_ID_ERROR_MESSAGE = "Failed to retrieve user_id from signed_request";
    public static final String USER_CANCELED_LOG_IN_ERROR_MESSAGE = "User canceled log in.";
    public LoginClient loginClient;
    private Map<String, String> methodLoggingExtras;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0004H\u0007J6\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00102\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0004H\u0007J\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/facebook/login/LoginMethodHandler$Companion;", "", "()V", "NO_SIGNED_REQUEST_ERROR_MESSAGE", "", "NO_USER_ID_ERROR_MESSAGE", "USER_CANCELED_LOG_IN_ERROR_MESSAGE", "createAccessTokenFromNativeLogin", "Lcom/facebook/AccessToken;", "bundle", "Landroid/os/Bundle;", "source", "Lcom/facebook/AccessTokenSource;", "applicationId", "createAccessTokenFromWebBundle", "requestedPermissions", "", "createAuthenticationTokenFromNativeLogin", "Lcom/facebook/AuthenticationToken;", "expectedNonce", "createAuthenticationTokenFromWebBundle", "getUserIDFromSignedRequest", "signedRequest", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AccessToken createAccessTokenFromNativeLogin(Bundle bundle, AccessTokenSource accessTokenSource, String str) {
            boolean z10;
            String string;
            Bundle bundle2 = bundle;
            j.g(bundle, "bundle");
            j.g(str, "applicationId");
            Utility utility = Utility.INSTANCE;
            Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, NativeProtocol.EXTRA_EXPIRES_SECONDS_SINCE_EPOCH, new Date(0));
            ArrayList<String> stringArrayList = bundle.getStringArrayList(NativeProtocol.EXTRA_PERMISSIONS);
            String string2 = bundle.getString(NativeProtocol.EXTRA_ACCESS_TOKEN);
            Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle, NativeProtocol.EXTRA_DATA_ACCESS_EXPIRATION_TIME, new Date(0));
            if (string2 != null) {
                boolean z11 = true;
                if (string2.length() == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10 && (string = bundle.getString(NativeProtocol.EXTRA_USER_ID)) != null) {
                    if (string.length() != 0) {
                        z11 = false;
                    }
                    if (!z11) {
                        return new AccessToken(string2, str, string, stringArrayList, (Collection<String>) null, (Collection<String>) null, accessTokenSource, bundleLongAsDate, new Date(), bundleLongAsDate2, bundle.getString("graph_domain"));
                    }
                }
            }
            return null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x007e  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00bb  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00f6 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00f7  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.facebook.AccessToken createAccessTokenFromWebBundle(java.util.Collection<java.lang.String> r20, android.os.Bundle r21, com.facebook.AccessTokenSource r22, java.lang.String r23) throws com.facebook.FacebookException {
            /*
                r19 = this;
                r0 = r21
                java.lang.String r1 = "bundle"
                kotlin.jvm.internal.j.g(r0, r1)
                java.lang.String r1 = "applicationId"
                r4 = r23
                kotlin.jvm.internal.j.g(r4, r1)
                com.facebook.internal.Utility r1 = com.facebook.internal.Utility.INSTANCE
                java.util.Date r1 = new java.util.Date
                r1.<init>()
                java.lang.String r2 = "expires_in"
                java.util.Date r10 = com.facebook.internal.Utility.getBundleLongAsDate(r0, r2, r1)
                java.lang.String r1 = "access_token"
                java.lang.String r3 = r0.getString(r1)
                r1 = 0
                if (r3 != 0) goto L_0x0025
                return r1
            L_0x0025:
                java.util.Date r2 = new java.util.Date
                r5 = 0
                r2.<init>(r5)
                java.lang.String r5 = "data_access_expiration_time"
                java.util.Date r12 = com.facebook.internal.Utility.getBundleLongAsDate(r0, r5, r2)
                java.lang.String r2 = "granted_scopes"
                java.lang.String r13 = r0.getString(r2)
                java.lang.String r2 = "null cannot be cast to non-null type kotlin.Array<T>"
                java.lang.String r5 = ","
                r6 = 1
                r7 = 0
                if (r13 == 0) goto L_0x0074
                int r8 = r13.length()
                if (r8 <= 0) goto L_0x0048
                r8 = r6
                goto L_0x0049
            L_0x0048:
                r8 = r7
            L_0x0049:
                if (r8 == 0) goto L_0x0074
                java.lang.String[] r14 = new java.lang.String[]{r5}
                r15 = 0
                r16 = 0
                r17 = 6
                r18 = 0
                java.util.List r8 = kotlin.text.StringsKt__StringsKt.C0(r13, r14, r15, r16, r17, r18)
                java.lang.String[] r9 = new java.lang.String[r7]
                java.lang.Object[] r8 = r8.toArray(r9)
                if (r8 == 0) goto L_0x006e
                java.lang.String[] r8 = (java.lang.String[]) r8
                int r9 = r8.length
                java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r9)
                java.util.ArrayList r8 = kotlin.collections.q.f(r8)
                goto L_0x0076
            L_0x006e:
                java.lang.NullPointerException r0 = new java.lang.NullPointerException
                r0.<init>(r2)
                throw r0
            L_0x0074:
                r8 = r20
            L_0x0076:
                java.lang.String r9 = "denied_scopes"
                java.lang.String r13 = r0.getString(r9)
                if (r13 == 0) goto L_0x00b2
                int r9 = r13.length()
                if (r9 <= 0) goto L_0x0086
                r9 = r6
                goto L_0x0087
            L_0x0086:
                r9 = r7
            L_0x0087:
                if (r9 == 0) goto L_0x00b2
                java.lang.String[] r14 = new java.lang.String[]{r5}
                r15 = 0
                r16 = 0
                r17 = 6
                r18 = 0
                java.util.List r9 = kotlin.text.StringsKt__StringsKt.C0(r13, r14, r15, r16, r17, r18)
                java.lang.String[] r11 = new java.lang.String[r7]
                java.lang.Object[] r9 = r9.toArray(r11)
                if (r9 == 0) goto L_0x00ac
                java.lang.String[] r9 = (java.lang.String[]) r9
                int r11 = r9.length
                java.lang.Object[] r9 = java.util.Arrays.copyOf(r9, r11)
                java.util.ArrayList r9 = kotlin.collections.q.f(r9)
                goto L_0x00b3
            L_0x00ac:
                java.lang.NullPointerException r0 = new java.lang.NullPointerException
                r0.<init>(r2)
                throw r0
            L_0x00b2:
                r9 = r1
            L_0x00b3:
                java.lang.String r11 = "expired_scopes"
                java.lang.String r13 = r0.getString(r11)
                if (r13 == 0) goto L_0x00ef
                int r11 = r13.length()
                if (r11 <= 0) goto L_0x00c2
                goto L_0x00c3
            L_0x00c2:
                r6 = r7
            L_0x00c3:
                if (r6 == 0) goto L_0x00ef
                java.lang.String[] r14 = new java.lang.String[]{r5}
                r15 = 0
                r16 = 0
                r17 = 6
                r18 = 0
                java.util.List r5 = kotlin.text.StringsKt__StringsKt.C0(r13, r14, r15, r16, r17, r18)
                java.lang.String[] r6 = new java.lang.String[r7]
                java.lang.Object[] r5 = r5.toArray(r6)
                if (r5 == 0) goto L_0x00e9
                java.lang.String[] r5 = (java.lang.String[]) r5
                int r2 = r5.length
                java.lang.Object[] r2 = java.util.Arrays.copyOf(r5, r2)
                java.util.ArrayList r2 = kotlin.collections.q.f(r2)
                r11 = r2
                goto L_0x00f0
            L_0x00e9:
                java.lang.NullPointerException r0 = new java.lang.NullPointerException
                r0.<init>(r2)
                throw r0
            L_0x00ef:
                r11 = r1
            L_0x00f0:
                boolean r2 = com.facebook.internal.Utility.isNullOrEmpty((java.lang.String) r3)
                if (r2 == 0) goto L_0x00f7
                return r1
            L_0x00f7:
                java.lang.String r1 = "graph_domain"
                java.lang.String r13 = r0.getString(r1)
                java.lang.String r1 = "signed_request"
                java.lang.String r0 = r0.getString(r1)
                r1 = r19
                java.lang.String r5 = r1.getUserIDFromSignedRequest(r0)
                com.facebook.AccessToken r0 = new com.facebook.AccessToken
                java.util.Date r14 = new java.util.Date
                r14.<init>()
                r2 = r0
                r4 = r23
                r6 = r8
                r7 = r9
                r8 = r11
                r9 = r22
                r11 = r14
                r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginMethodHandler.Companion.createAccessTokenFromWebBundle(java.util.Collection, android.os.Bundle, com.facebook.AccessTokenSource, java.lang.String):com.facebook.AccessToken");
        }

        public final AuthenticationToken createAuthenticationTokenFromNativeLogin(Bundle bundle, String str) throws FacebookException {
            boolean z10;
            j.g(bundle, "bundle");
            String string = bundle.getString(NativeProtocol.EXTRA_AUTHENTICATION_TOKEN);
            if (string != null) {
                boolean z11 = true;
                if (string.length() == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10 && str != null) {
                    if (str.length() != 0) {
                        z11 = false;
                    }
                    if (!z11) {
                        try {
                            return new AuthenticationToken(string, str);
                        } catch (Exception e10) {
                            throw new FacebookException(e10.getMessage());
                        }
                    }
                }
            }
            return null;
        }

        public final AuthenticationToken createAuthenticationTokenFromWebBundle(Bundle bundle, String str) throws FacebookException {
            boolean z10;
            j.g(bundle, "bundle");
            String string = bundle.getString("id_token");
            if (string != null) {
                boolean z11 = true;
                if (string.length() == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10 && str != null) {
                    if (str.length() != 0) {
                        z11 = false;
                    }
                    if (!z11) {
                        try {
                            return new AuthenticationToken(string, str);
                        } catch (Exception e10) {
                            throw new FacebookException(e10.getMessage(), (Throwable) e10);
                        }
                    }
                }
            }
            return null;
        }

        public final String getUserIDFromSignedRequest(String str) throws FacebookException {
            boolean z10;
            if (str != null) {
                if (str.length() == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10) {
                    try {
                        Object[] array2 = StringsKt__StringsKt.C0(str, new String[]{"."}, false, 0, 6, (Object) null).toArray(new String[0]);
                        if (array2 != null) {
                            String[] strArr = (String[]) array2;
                            if (strArr.length == 2) {
                                byte[] decode = Base64.decode(strArr[1], 0);
                                j.f(decode, "data");
                                String string = new b(new String(decode, d.f32216b)).getString("user_id");
                                j.f(string, "jsonObject.getString(\"user_id\")");
                                return string;
                            }
                            throw new FacebookException(LoginMethodHandler.NO_USER_ID_ERROR_MESSAGE);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    } catch (UnsupportedEncodingException | JSONException unused) {
                    }
                }
            }
            throw new FacebookException(LoginMethodHandler.NO_SIGNED_REQUEST_ERROR_MESSAGE);
        }
    }

    public LoginMethodHandler(LoginClient loginClient2) {
        j.g(loginClient2, "loginClient");
        setLoginClient(loginClient2);
    }

    public static final AccessToken createAccessTokenFromNativeLogin(Bundle bundle, AccessTokenSource accessTokenSource, String str) {
        return Companion.createAccessTokenFromNativeLogin(bundle, accessTokenSource, str);
    }

    public static final AccessToken createAccessTokenFromWebBundle(Collection<String> collection, Bundle bundle, AccessTokenSource accessTokenSource, String str) throws FacebookException {
        return Companion.createAccessTokenFromWebBundle(collection, bundle, accessTokenSource, str);
    }

    public static final AuthenticationToken createAuthenticationTokenFromNativeLogin(Bundle bundle, String str) throws FacebookException {
        return Companion.createAuthenticationTokenFromNativeLogin(bundle, str);
    }

    public static final AuthenticationToken createAuthenticationTokenFromWebBundle(Bundle bundle, String str) throws FacebookException {
        return Companion.createAuthenticationTokenFromWebBundle(bundle, str);
    }

    public static final String getUserIDFromSignedRequest(String str) throws FacebookException {
        return Companion.getUserIDFromSignedRequest(str);
    }

    /* access modifiers changed from: protected */
    public void addLoggingExtra(String str, Object obj) {
        String str2;
        if (this.methodLoggingExtras == null) {
            this.methodLoggingExtras = new HashMap();
        }
        Map<String, String> map = this.methodLoggingExtras;
        if (map != null) {
            if (obj == null) {
                str2 = null;
            } else {
                str2 = obj.toString();
            }
            String put = map.put(str, str2);
        }
    }

    public void cancel() {
    }

    /* access modifiers changed from: protected */
    public String getClientState(String str) {
        j.g(str, "authId");
        b bVar = new b();
        try {
            bVar.put(LoginLogger.EVENT_PARAM_AUTH_LOGGER_ID, (Object) str);
            bVar.put(LoginLogger.EVENT_PARAM_METHOD, (Object) getNameForLogging());
            putChallengeParam(bVar);
        } catch (JSONException e10) {
            j.p("Error creating client state json: ", e10.getMessage());
        }
        String bVar2 = bVar.toString();
        j.f(bVar2, "param.toString()");
        return bVar2;
    }

    public final LoginClient getLoginClient() {
        LoginClient loginClient2 = this.loginClient;
        if (loginClient2 != null) {
            return loginClient2;
        }
        j.y("loginClient");
        throw null;
    }

    public final Map<String, String> getMethodLoggingExtras() {
        return this.methodLoggingExtras;
    }

    public abstract String getNameForLogging();

    /* access modifiers changed from: protected */
    public String getRedirectUrl() {
        return "fb" + FacebookSdk.getApplicationId() + "://authorize/";
    }

    /* access modifiers changed from: protected */
    public void logWebLoginCompleted(String str) {
        String str2;
        LoginClient.Request pendingRequest = getLoginClient().getPendingRequest();
        if (pendingRequest == null) {
            str2 = null;
        } else {
            str2 = pendingRequest.getApplicationId();
        }
        if (str2 == null) {
            str2 = FacebookSdk.getApplicationId();
        }
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(getLoginClient().getActivity(), str2);
        Bundle bundle = new Bundle();
        bundle.putString(AnalyticsEvents.PARAMETER_WEB_LOGIN_E2E, str);
        bundle.putLong(AnalyticsEvents.PARAMETER_WEB_LOGIN_SWITCHBACK_TIME, System.currentTimeMillis());
        bundle.putString("app_id", str2);
        internalAppEventsLogger.logEventImplicitly(AnalyticsEvents.EVENT_WEB_LOGIN_COMPLETE, (Double) null, bundle);
    }

    public boolean needsInternetPermission() {
        return false;
    }

    public boolean onActivityResult(int i10, int i11, Intent intent) {
        return false;
    }

    /* access modifiers changed from: protected */
    public Bundle processCodeExchange(LoginClient.Request request, Bundle bundle) throws FacebookException {
        GraphRequest graphRequest;
        j.g(request, "request");
        j.g(bundle, "values");
        String string = bundle.getString("code");
        if (!Utility.isNullOrEmpty(string)) {
            String str = null;
            if (string == null) {
                graphRequest = null;
            } else {
                PKCEUtil pKCEUtil = PKCEUtil.INSTANCE;
                String redirectUrl = getRedirectUrl();
                String codeVerifier = request.getCodeVerifier();
                if (codeVerifier == null) {
                    codeVerifier = "";
                }
                graphRequest = PKCEUtil.createCodeExchangeRequest(string, redirectUrl, codeVerifier);
            }
            if (graphRequest != null) {
                GraphResponse executeAndWait = graphRequest.executeAndWait();
                FacebookRequestError error = executeAndWait.getError();
                if (error == null) {
                    try {
                        b jSONObject = executeAndWait.getJSONObject();
                        if (jSONObject != null) {
                            str = jSONObject.getString("access_token");
                        }
                        if (jSONObject == null || Utility.isNullOrEmpty(str)) {
                            throw new FacebookException("No access token found from result");
                        }
                        bundle.putString("access_token", str);
                        if (jSONObject.has("id_token")) {
                            bundle.putString("id_token", jSONObject.getString("id_token"));
                        }
                        return bundle;
                    } catch (JSONException e10) {
                        throw new FacebookException(j.p("Fail to process code exchange response: ", e10.getMessage()));
                    }
                } else {
                    throw new FacebookServiceException(error, error.getErrorMessage());
                }
            } else {
                throw new FacebookException("Failed to create code exchange request");
            }
        } else {
            throw new FacebookException("No code param found from the request");
        }
    }

    public void putChallengeParam(b bVar) throws JSONException {
        j.g(bVar, "param");
    }

    public final void setLoginClient(LoginClient loginClient2) {
        j.g(loginClient2, "<set-?>");
        this.loginClient = loginClient2;
    }

    public final void setMethodLoggingExtras(Map<String, String> map) {
        this.methodLoggingExtras = map;
    }

    public boolean shouldKeepTrackOfMultipleIntents() {
        return false;
    }

    public abstract int tryAuthorize(LoginClient.Request request);

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "dest");
        Utility utility = Utility.INSTANCE;
        Utility.writeStringMapToParcel(parcel, this.methodLoggingExtras);
    }

    protected LoginMethodHandler(Parcel parcel) {
        j.g(parcel, "source");
        Map<String, String> readStringMapFromParcel = Utility.readStringMapFromParcel(parcel);
        this.methodLoggingExtras = readStringMapFromParcel == null ? null : h0.w(readStringMapFromParcel);
    }
}
