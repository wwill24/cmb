package com.facebook.login;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\t"}, d2 = {"com/facebook/login/GetTokenLoginMethodHandler$complete$1", "Lcom/facebook/internal/Utility$GraphMeRequestWithCacheCallback;", "Lorg/json/b;", "userInfo", "", "onSuccess", "Lcom/facebook/FacebookException;", "error", "onFailure", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public final class GetTokenLoginMethodHandler$complete$1 implements Utility.GraphMeRequestWithCacheCallback {
    final /* synthetic */ LoginClient.Request $request;
    final /* synthetic */ Bundle $result;
    final /* synthetic */ GetTokenLoginMethodHandler this$0;

    GetTokenLoginMethodHandler$complete$1(Bundle bundle, GetTokenLoginMethodHandler getTokenLoginMethodHandler, LoginClient.Request request) {
        this.$result = bundle;
        this.this$0 = getTokenLoginMethodHandler;
        this.$request = request;
    }

    public void onFailure(FacebookException facebookException) {
        String str;
        LoginClient loginClient = this.this$0.getLoginClient();
        LoginClient.Result.Companion companion = LoginClient.Result.Companion;
        LoginClient.Request pendingRequest = this.this$0.getLoginClient().getPendingRequest();
        if (facebookException == null) {
            str = null;
        } else {
            str = facebookException.getMessage();
        }
        loginClient.complete(LoginClient.Result.Companion.createErrorResult$default(companion, pendingRequest, "Caught exception", str, (String) null, 8, (Object) null));
    }

    public void onSuccess(b bVar) {
        String str;
        try {
            Bundle bundle = this.$result;
            if (bVar == null) {
                str = null;
            } else {
                str = bVar.getString("id");
            }
            bundle.putString(NativeProtocol.EXTRA_USER_ID, str);
            this.this$0.onComplete(this.$request, this.$result);
        } catch (JSONException e10) {
            this.this$0.getLoginClient().complete(LoginClient.Result.Companion.createErrorResult$default(LoginClient.Result.Companion, this.this$0.getLoginClient().getPendingRequest(), "Caught exception", e10.getMessage(), (String) null, 8, (Object) null));
        }
    }
}
