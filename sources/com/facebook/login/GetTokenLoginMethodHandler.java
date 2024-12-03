package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;
import com.facebook.login.LoginMethodHandler;
import com.mparticle.kits.AppsFlyerKit;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.mam.element.MamElements;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0016\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/facebook/login/GetTokenLoginMethodHandler;", "Lcom/facebook/login/LoginMethodHandler;", "loginClient", "Lcom/facebook/login/LoginClient;", "(Lcom/facebook/login/LoginClient;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getTokenClient", "Lcom/facebook/login/GetTokenClient;", "nameForLogging", "", "getNameForLogging", "()Ljava/lang/String;", "cancel", "", "complete", "request", "Lcom/facebook/login/LoginClient$Request;", "result", "Landroid/os/Bundle;", "describeContents", "", "getTokenCompleted", "onComplete", "tryAuthorize", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class GetTokenLoginMethodHandler extends LoginMethodHandler {
    public static final Parcelable.Creator<GetTokenLoginMethodHandler> CREATOR = new GetTokenLoginMethodHandler$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private GetTokenClient getTokenClient;
    private final String nameForLogging = "get_token";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/login/GetTokenLoginMethodHandler$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/login/GetTokenLoginMethodHandler;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetTokenLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        j.g(loginClient, "loginClient");
    }

    /* access modifiers changed from: private */
    /* renamed from: tryAuthorize$lambda-1  reason: not valid java name */
    public static final void m159tryAuthorize$lambda1(GetTokenLoginMethodHandler getTokenLoginMethodHandler, LoginClient.Request request, Bundle bundle) {
        j.g(getTokenLoginMethodHandler, "this$0");
        j.g(request, "$request");
        getTokenLoginMethodHandler.getTokenCompleted(request, bundle);
    }

    public void cancel() {
        GetTokenClient getTokenClient2 = this.getTokenClient;
        if (getTokenClient2 != null) {
            getTokenClient2.cancel();
            getTokenClient2.setCompletedListener((PlatformServiceClient.CompletedListener) null);
            this.getTokenClient = null;
        }
    }

    public final void complete(LoginClient.Request request, Bundle bundle) {
        boolean z10;
        j.g(request, "request");
        j.g(bundle, MamElements.MamResultExtension.ELEMENT);
        String string = bundle.getString(NativeProtocol.EXTRA_USER_ID);
        if (string == null || string.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            getLoginClient().notifyBackgroundProcessingStart();
            String string2 = bundle.getString(NativeProtocol.EXTRA_ACCESS_TOKEN);
            if (string2 != null) {
                Utility utility = Utility.INSTANCE;
                Utility.getGraphMeRequestWithCacheAsync(string2, new GetTokenLoginMethodHandler$complete$1(bundle, this, request));
                return;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
        onComplete(request, bundle);
    }

    public int describeContents() {
        return 0;
    }

    public String getNameForLogging() {
        return this.nameForLogging;
    }

    public final void getTokenCompleted(LoginClient.Request request, Bundle bundle) {
        boolean z10;
        j.g(request, "request");
        GetTokenClient getTokenClient2 = this.getTokenClient;
        if (getTokenClient2 != null) {
            getTokenClient2.setCompletedListener((PlatformServiceClient.CompletedListener) null);
        }
        this.getTokenClient = null;
        getLoginClient().notifyBackgroundProcessingStop();
        if (bundle != null) {
            List stringArrayList = bundle.getStringArrayList(NativeProtocol.EXTRA_PERMISSIONS);
            if (stringArrayList == null) {
                stringArrayList = q.j();
            }
            Set<String> permissions = request.getPermissions();
            if (permissions == null) {
                permissions = n0.e();
            }
            String string = bundle.getString(NativeProtocol.EXTRA_AUTHENTICATION_TOKEN);
            if (permissions.contains(LoginConfiguration.OPENID)) {
                if (string == null || string.length() == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    getLoginClient().tryNextHandler();
                    return;
                }
            }
            if (stringArrayList.containsAll(permissions)) {
                complete(request, bundle);
                return;
            }
            HashSet hashSet = new HashSet();
            for (String next : permissions) {
                if (!stringArrayList.contains(next)) {
                    hashSet.add(next);
                }
            }
            if (!hashSet.isEmpty()) {
                addLoggingExtra(LoginLogger.EVENT_EXTRAS_NEW_PERMISSIONS, TextUtils.join(AppsFlyerKit.COMMA, hashSet));
            }
            request.setPermissions(hashSet);
        }
        getLoginClient().tryNextHandler();
    }

    public final void onComplete(LoginClient.Request request, Bundle bundle) {
        LoginClient.Result result;
        j.g(request, "request");
        j.g(bundle, MamElements.MamResultExtension.ELEMENT);
        try {
            LoginMethodHandler.Companion companion = LoginMethodHandler.Companion;
            result = LoginClient.Result.Companion.createCompositeTokenResult(request, companion.createAccessTokenFromNativeLogin(bundle, AccessTokenSource.FACEBOOK_APPLICATION_SERVICE, request.getApplicationId()), companion.createAuthenticationTokenFromNativeLogin(bundle, request.getNonce()));
        } catch (FacebookException e10) {
            result = LoginClient.Result.Companion.createErrorResult$default(LoginClient.Result.Companion, getLoginClient().getPendingRequest(), (String) null, e10.getMessage(), (String) null, 8, (Object) null);
        }
        getLoginClient().completeAndValidate(result);
    }

    public int tryAuthorize(LoginClient.Request request) {
        j.g(request, "request");
        Context activity = getLoginClient().getActivity();
        if (activity == null) {
            activity = FacebookSdk.getApplicationContext();
        }
        GetTokenClient getTokenClient2 = new GetTokenClient(activity, request);
        this.getTokenClient = getTokenClient2;
        if (j.b(Boolean.valueOf(getTokenClient2.start()), Boolean.FALSE)) {
            return 0;
        }
        getLoginClient().notifyBackgroundProcessingStart();
        i iVar = new i(this, request);
        GetTokenClient getTokenClient3 = this.getTokenClient;
        if (getTokenClient3 == null) {
            return 1;
        }
        getTokenClient3.setCompletedListener(iVar);
        return 1;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetTokenLoginMethodHandler(Parcel parcel) {
        super(parcel);
        j.g(parcel, "source");
    }
}
