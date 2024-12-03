package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.h;
import com.facebook.AccessTokenSource;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.CustomTab;
import com.facebook.internal.CustomTabUtils;
import com.facebook.internal.InstagramCustomTab;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.json.JSONException;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 32\u00020\u0001:\u00013B\u0011\b\u0016\u0012\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b/\u00100B\u0011\b\u0010\u0012\u0006\u00101\u001a\u00020\u0019¢\u0006\u0004\b/\u00102J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0014J\n\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0014J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\u0018\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u000eH\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0016\u0010 \u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010\u001eR\u001a\u0010!\u001a\u00020\u00028\u0016XD¢\u0006\f\n\u0004\b!\u0010\u001e\u001a\u0004\b\"\u0010#R\u001a\u0010%\u001a\u00020$8\u0016X\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010#R\u0016\u0010,\u001a\u0004\u0018\u00010\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010#¨\u00064"}, d2 = {"Lcom/facebook/login/CustomTabLoginMethodHandler;", "Lcom/facebook/login/WebLoginMethodHandler;", "", "url", "Lcom/facebook/login/LoginClient$Request;", "request", "", "onCustomTabComplete", "Landroid/os/Bundle;", "values", "", "validateChallengeParam", "getRedirectUrl", "getSSODevice", "", "tryAuthorize", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "Lorg/json/b;", "param", "putChallengeParam", "describeContents", "Landroid/os/Parcel;", "dest", "flags", "writeToParcel", "currentPackage", "Ljava/lang/String;", "expectedChallenge", "validRedirectURI", "nameForLogging", "getNameForLogging", "()Ljava/lang/String;", "Lcom/facebook/AccessTokenSource;", "tokenSource", "Lcom/facebook/AccessTokenSource;", "getTokenSource", "()Lcom/facebook/AccessTokenSource;", "getDeveloperDefinedRedirectURI", "developerDefinedRedirectURI", "getChromePackage", "chromePackage", "Lcom/facebook/login/LoginClient;", "loginClient", "<init>", "(Lcom/facebook/login/LoginClient;)V", "source", "(Landroid/os/Parcel;)V", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public final class CustomTabLoginMethodHandler extends WebLoginMethodHandler {
    private static final int API_EC_DIALOG_CANCEL = 4201;
    private static final int CHALLENGE_LENGTH = 20;
    public static final Parcelable.Creator<CustomTabLoginMethodHandler> CREATOR = new CustomTabLoginMethodHandler$Companion$CREATOR$1();
    private static final int CUSTOM_TAB_REQUEST_CODE = 1;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String OAUTH_DIALOG = "oauth";
    public static boolean calledThroughLoggedOutAppSwitch;
    private String currentPackage;
    private String expectedChallenge;
    private final String nameForLogging;
    private final AccessTokenSource tokenSource;
    private String validRedirectURI;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/login/CustomTabLoginMethodHandler$Companion;", "", "()V", "API_EC_DIALOG_CANCEL", "", "CHALLENGE_LENGTH", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/login/CustomTabLoginMethodHandler;", "CUSTOM_TAB_REQUEST_CODE", "OAUTH_DIALOG", "", "calledThroughLoggedOutAppSwitch", "", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomTabLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        j.g(loginClient, "loginClient");
        this.nameForLogging = "custom_tab";
        this.tokenSource = AccessTokenSource.CHROME_CUSTOM_TAB;
        this.expectedChallenge = Utility.generateRandomString(20);
        calledThroughLoggedOutAppSwitch = false;
        CustomTabUtils customTabUtils = CustomTabUtils.INSTANCE;
        this.validRedirectURI = CustomTabUtils.getValidRedirectURI(getDeveloperDefinedRedirectURI());
    }

    private final String getChromePackage() {
        String str = this.currentPackage;
        if (str != null) {
            return str;
        }
        String chromePackage = CustomTabUtils.getChromePackage();
        this.currentPackage = chromePackage;
        return chromePackage;
    }

    private final String getDeveloperDefinedRedirectURI() {
        return super.getRedirectUrl();
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void onCustomTabComplete(java.lang.String r7, com.facebook.login.LoginClient.Request r8) {
        /*
            r6 = this;
            if (r7 == 0) goto L_0x00d1
            java.lang.String r0 = "fbconnect://cct."
            r1 = 0
            r2 = 2
            r3 = 0
            boolean r0 = kotlin.text.r.J(r7, r0, r1, r2, r3)
            if (r0 != 0) goto L_0x0017
            java.lang.String r0 = super.getRedirectUrl()
            boolean r0 = kotlin.text.r.J(r7, r0, r1, r2, r3)
            if (r0 == 0) goto L_0x00d1
        L_0x0017:
            android.net.Uri r7 = android.net.Uri.parse(r7)
            com.facebook.internal.Utility r0 = com.facebook.internal.Utility.INSTANCE
            java.lang.String r0 = r7.getQuery()
            android.os.Bundle r0 = com.facebook.internal.Utility.parseUrlQueryString(r0)
            java.lang.String r7 = r7.getFragment()
            android.os.Bundle r7 = com.facebook.internal.Utility.parseUrlQueryString(r7)
            r0.putAll(r7)
            boolean r7 = r6.validateChallengeParam(r0)
            if (r7 != 0) goto L_0x0041
            com.facebook.FacebookException r7 = new com.facebook.FacebookException
            java.lang.String r0 = "Invalid state parameter"
            r7.<init>((java.lang.String) r0)
            super.onComplete(r8, r3, r7)
            return
        L_0x0041:
            java.lang.String r7 = "error"
            java.lang.String r7 = r0.getString(r7)
            if (r7 != 0) goto L_0x004f
            java.lang.String r7 = "error_type"
            java.lang.String r7 = r0.getString(r7)
        L_0x004f:
            java.lang.String r1 = "error_msg"
            java.lang.String r1 = r0.getString(r1)
            if (r1 != 0) goto L_0x005d
            java.lang.String r1 = "error_message"
            java.lang.String r1 = r0.getString(r1)
        L_0x005d:
            if (r1 != 0) goto L_0x0065
            java.lang.String r1 = "error_description"
            java.lang.String r1 = r0.getString(r1)
        L_0x0065:
            java.lang.String r2 = "error_code"
            java.lang.String r2 = r0.getString(r2)
            r4 = -1
            if (r2 != 0) goto L_0x006f
            goto L_0x0074
        L_0x006f:
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x0074 }
            goto L_0x0075
        L_0x0074:
            r2 = r4
        L_0x0075:
            boolean r5 = com.facebook.internal.Utility.isNullOrEmpty((java.lang.String) r7)
            if (r5 == 0) goto L_0x009c
            boolean r5 = com.facebook.internal.Utility.isNullOrEmpty((java.lang.String) r1)
            if (r5 == 0) goto L_0x009c
            if (r2 != r4) goto L_0x009c
            java.lang.String r7 = "access_token"
            boolean r7 = r0.containsKey(r7)
            if (r7 == 0) goto L_0x008f
            super.onComplete(r8, r0, r3)
            return
        L_0x008f:
            java.util.concurrent.Executor r7 = com.facebook.FacebookSdk.getExecutor()
            com.facebook.login.a r1 = new com.facebook.login.a
            r1.<init>(r6, r8, r0)
            r7.execute(r1)
            goto L_0x00d1
        L_0x009c:
            if (r7 == 0) goto L_0x00b7
            java.lang.String r0 = "access_denied"
            boolean r0 = kotlin.jvm.internal.j.b(r7, r0)
            if (r0 != 0) goto L_0x00ae
            java.lang.String r0 = "OAuthAccessDeniedException"
            boolean r0 = kotlin.jvm.internal.j.b(r7, r0)
            if (r0 == 0) goto L_0x00b7
        L_0x00ae:
            com.facebook.FacebookOperationCanceledException r7 = new com.facebook.FacebookOperationCanceledException
            r7.<init>()
            super.onComplete(r8, r3, r7)
            goto L_0x00d1
        L_0x00b7:
            r0 = 4201(0x1069, float:5.887E-42)
            if (r2 != r0) goto L_0x00c4
            com.facebook.FacebookOperationCanceledException r7 = new com.facebook.FacebookOperationCanceledException
            r7.<init>()
            super.onComplete(r8, r3, r7)
            goto L_0x00d1
        L_0x00c4:
            com.facebook.FacebookRequestError r0 = new com.facebook.FacebookRequestError
            r0.<init>(r2, r7, r1)
            com.facebook.FacebookServiceException r7 = new com.facebook.FacebookServiceException
            r7.<init>(r0, r1)
            super.onComplete(r8, r3, r7)
        L_0x00d1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.CustomTabLoginMethodHandler.onCustomTabComplete(java.lang.String, com.facebook.login.LoginClient$Request):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: onCustomTabComplete$lambda-0  reason: not valid java name */
    public static final void m151onCustomTabComplete$lambda0(CustomTabLoginMethodHandler customTabLoginMethodHandler, LoginClient.Request request, Bundle bundle) {
        j.g(customTabLoginMethodHandler, "this$0");
        j.g(request, "$request");
        j.g(bundle, "$values");
        try {
            customTabLoginMethodHandler.onComplete(request, customTabLoginMethodHandler.processCodeExchange(request, bundle), (FacebookException) null);
        } catch (FacebookException e10) {
            customTabLoginMethodHandler.onComplete(request, (Bundle) null, e10);
        }
    }

    private final boolean validateChallengeParam(Bundle bundle) {
        try {
            String string = bundle.getString("state");
            if (string == null) {
                return false;
            }
            return j.b(new b(string).getString(LoginLogger.EVENT_PARAM_CHALLENGE), this.expectedChallenge);
        } catch (JSONException unused) {
            return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getNameForLogging() {
        return this.nameForLogging;
    }

    /* access modifiers changed from: protected */
    public String getRedirectUrl() {
        return this.validRedirectURI;
    }

    /* access modifiers changed from: protected */
    public String getSSODevice() {
        return "chrome_custom_tab";
    }

    public AccessTokenSource getTokenSource() {
        return this.tokenSource;
    }

    public boolean onActivityResult(int i10, int i11, Intent intent) {
        if (intent != null && intent.getBooleanExtra(CustomTabMainActivity.NO_ACTIVITY_EXCEPTION, false)) {
            return super.onActivityResult(i10, i11, intent);
        }
        if (i10 != 1) {
            return super.onActivityResult(i10, i11, intent);
        }
        LoginClient.Request pendingRequest = getLoginClient().getPendingRequest();
        if (pendingRequest == null) {
            return false;
        }
        String str = null;
        if (i11 == -1) {
            if (intent != null) {
                str = intent.getStringExtra(CustomTabMainActivity.EXTRA_URL);
            }
            onCustomTabComplete(str, pendingRequest);
            return true;
        }
        super.onComplete(pendingRequest, (Bundle) null, new FacebookOperationCanceledException());
        return false;
    }

    public void putChallengeParam(b bVar) throws JSONException {
        j.g(bVar, "param");
        bVar.put(LoginLogger.EVENT_PARAM_CHALLENGE, (Object) this.expectedChallenge);
    }

    public int tryAuthorize(LoginClient.Request request) {
        boolean z10;
        j.g(request, "request");
        LoginClient loginClient = getLoginClient();
        if (getRedirectUrl().length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return 0;
        }
        Bundle addExtraParameters = addExtraParameters(getParameters(request), request);
        if (calledThroughLoggedOutAppSwitch) {
            addExtraParameters.putString(ServerProtocol.DIALOG_PARAM_CCT_OVER_LOGGED_OUT_APP_SWITCH, AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
        if (FacebookSdk.hasCustomTabsPrefetching) {
            if (request.isInstagramLogin()) {
                CustomTabPrefetchHelper.Companion.mayLaunchUrl(InstagramCustomTab.Companion.getURIForAction(OAUTH_DIALOG, addExtraParameters));
            } else {
                CustomTabPrefetchHelper.Companion.mayLaunchUrl(CustomTab.Companion.getURIForAction(OAUTH_DIALOG, addExtraParameters));
            }
        }
        h activity = loginClient.getActivity();
        if (activity == null) {
            return 0;
        }
        Intent intent = new Intent(activity, CustomTabMainActivity.class);
        intent.putExtra(CustomTabMainActivity.EXTRA_ACTION, OAUTH_DIALOG);
        intent.putExtra(CustomTabMainActivity.EXTRA_PARAMS, addExtraParameters);
        intent.putExtra(CustomTabMainActivity.EXTRA_CHROME_PACKAGE, getChromePackage());
        intent.putExtra(CustomTabMainActivity.EXTRA_TARGET_APP, request.getLoginTargetApp().toString());
        Fragment fragment = loginClient.getFragment();
        if (fragment != null) {
            fragment.startActivityForResult(intent, 1);
        }
        return 1;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "dest");
        super.writeToParcel(parcel, i10);
        parcel.writeString(this.expectedChallenge);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomTabLoginMethodHandler(Parcel parcel) {
        super(parcel);
        j.g(parcel, "source");
        this.nameForLogging = "custom_tab";
        this.tokenSource = AccessTokenSource.CHROME_CUSTOM_TAB;
        this.expectedChallenge = parcel.readString();
        CustomTabUtils customTabUtils = CustomTabUtils.INSTANCE;
        this.validRedirectURI = CustomTabUtils.getValidRedirectURI(getDeveloperDefinedRedirectURI());
    }
}
