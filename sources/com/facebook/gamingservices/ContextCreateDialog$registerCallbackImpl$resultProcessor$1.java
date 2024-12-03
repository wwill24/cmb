package com.facebook.gamingservices;

import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.gamingservices.ContextCreateDialog;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AppCall;
import com.facebook.share.internal.ResultProcessor;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/facebook/gamingservices/ContextCreateDialog$registerCallbackImpl$resultProcessor$1", "Lcom/facebook/share/internal/ResultProcessor;", "onSuccess", "", "appCall", "Lcom/facebook/internal/AppCall;", "results", "Landroid/os/Bundle;", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ContextCreateDialog$registerCallbackImpl$resultProcessor$1 extends ResultProcessor {
    final /* synthetic */ FacebookCallback<ContextCreateDialog.Result> $callback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContextCreateDialog$registerCallbackImpl$resultProcessor$1(FacebookCallback<ContextCreateDialog.Result> facebookCallback) {
        super(facebookCallback);
        this.$callback = facebookCallback;
    }

    public void onSuccess(AppCall appCall, Bundle bundle) {
        j.g(appCall, "appCall");
        if (bundle == null) {
            onCancel(appCall);
        } else if (bundle.getString("error_message") != null) {
            this.$callback.onError(new FacebookException(bundle.getString("error_message")));
        } else {
            String string = bundle.getString("id");
            String string2 = bundle.getString(SDKConstants.PARAM_CONTEXT_CONTEXT_ID);
            if (string != null) {
                GamingContext.Companion.setCurrentGamingContext(new GamingContext(string));
                this.$callback.onSuccess(new ContextCreateDialog.Result(string));
            } else if (string2 != null) {
                GamingContext.Companion.setCurrentGamingContext(new GamingContext(string2));
                this.$callback.onSuccess(new ContextCreateDialog.Result(string2));
            }
            this.$callback.onError(new FacebookException(bundle.getString("Invalid response received from server.")));
        }
    }
}
