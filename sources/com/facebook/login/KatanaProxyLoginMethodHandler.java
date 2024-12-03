package com.facebook.login;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.h;
import com.facebook.FacebookSdk;
import com.facebook.internal.CustomTabUtils;
import com.facebook.internal.NativeProtocol;
import com.facebook.login.LoginClient;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/facebook/login/KatanaProxyLoginMethodHandler;", "Lcom/facebook/login/NativeAppLoginMethodHandler;", "loginClient", "Lcom/facebook/login/LoginClient;", "(Lcom/facebook/login/LoginClient;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "nameForLogging", "", "getNameForLogging", "()Ljava/lang/String;", "describeContents", "", "shouldKeepTrackOfMultipleIntents", "", "tryAuthorize", "request", "Lcom/facebook/login/LoginClient$Request;", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class KatanaProxyLoginMethodHandler extends NativeAppLoginMethodHandler {
    public static final Parcelable.Creator<KatanaProxyLoginMethodHandler> CREATOR = new KatanaProxyLoginMethodHandler$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String nameForLogging = "katana_proxy_auth";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/login/KatanaProxyLoginMethodHandler$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/login/KatanaProxyLoginMethodHandler;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KatanaProxyLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        j.g(loginClient, "loginClient");
    }

    public int describeContents() {
        return 0;
    }

    public String getNameForLogging() {
        return this.nameForLogging;
    }

    public boolean shouldKeepTrackOfMultipleIntents() {
        return true;
    }

    public int tryAuthorize(LoginClient.Request request) {
        boolean z10;
        String str;
        j.g(request, "request");
        LoginBehavior loginBehavior = request.getLoginBehavior();
        if (!FacebookSdk.ignoreAppSwitchToLoggedOut || CustomTabUtils.getChromePackage() == null || !loginBehavior.allowsCustomTabAuth()) {
            z10 = false;
        } else {
            z10 = true;
        }
        String e2e = LoginClient.Companion.getE2E();
        NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
        h activity = getLoginClient().getActivity();
        String applicationId = request.getApplicationId();
        Set<String> permissions = request.getPermissions();
        boolean isRerequest = request.isRerequest();
        boolean hasPublishPermission = request.hasPublishPermission();
        DefaultAudience defaultAudience = request.getDefaultAudience();
        if (defaultAudience == null) {
            defaultAudience = DefaultAudience.NONE;
        }
        DefaultAudience defaultAudience2 = defaultAudience;
        String clientState = getClientState(request.getAuthId());
        String authType = request.getAuthType();
        String messengerPageId = request.getMessengerPageId();
        boolean resetMessengerState = request.getResetMessengerState();
        boolean isFamilyLogin = request.isFamilyLogin();
        boolean shouldSkipAccountDeduplication = request.shouldSkipAccountDeduplication();
        String nonce = request.getNonce();
        String codeChallenge = request.getCodeChallenge();
        CodeChallengeMethod codeChallengeMethod = request.getCodeChallengeMethod();
        if (codeChallengeMethod == null) {
            str = null;
        } else {
            str = codeChallengeMethod.name();
        }
        List<Intent> createProxyAuthIntents = NativeProtocol.createProxyAuthIntents(activity, applicationId, permissions, e2e, isRerequest, hasPublishPermission, defaultAudience2, clientState, authType, z10, messengerPageId, resetMessengerState, isFamilyLogin, shouldSkipAccountDeduplication, nonce, codeChallenge, str);
        addLoggingExtra("e2e", e2e);
        int i10 = 0;
        for (Intent tryIntent : createProxyAuthIntents) {
            i10++;
            if (tryIntent(tryIntent, LoginClient.Companion.getLoginRequestCode())) {
                return i10;
            }
        }
        return 0;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KatanaProxyLoginMethodHandler(Parcel parcel) {
        super(parcel);
        j.g(parcel, "source");
    }
}
