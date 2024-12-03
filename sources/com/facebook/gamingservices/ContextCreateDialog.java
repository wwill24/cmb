package com.facebook.gamingservices;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.CloudGameLoginHandler;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import com.facebook.gamingservices.model.ContextCreateContent;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;
import com.mparticle.identity.IdentityHttpResponse;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransport;
import org.json.JSONException;
import org.json.b;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004#$%&B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\n¢\u0006\u0002\u0010\u000bB\u000f\b\u0012\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0014J\u001e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u0014J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u0002H\u0002J\u0018\u0010 \u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"H\u0014R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R*\u0010\u0011\u001a\u0018\u0012\u0014\u0012\u00120\u0013R\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00010\u00128TX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006'"}, d2 = {"Lcom/facebook/gamingservices/ContextCreateDialog;", "Lcom/facebook/internal/FacebookDialogBase;", "Lcom/facebook/gamingservices/model/ContextCreateContent;", "Lcom/facebook/gamingservices/ContextCreateDialog$Result;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "Landroid/app/Fragment;", "(Landroid/app/Fragment;)V", "fragmentWrapper", "Lcom/facebook/internal/FragmentWrapper;", "(Lcom/facebook/internal/FragmentWrapper;)V", "callback", "Lcom/facebook/FacebookCallback;", "orderedModeHandlers", "", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "getOrderedModeHandlers", "()Ljava/util/List;", "canShow", "", "content", "createBaseAppCall", "Lcom/facebook/internal/AppCall;", "registerCallbackImpl", "", "callbackManager", "Lcom/facebook/internal/CallbackManagerImpl;", "showForCloud", "showImpl", "mode", "", "Companion", "FacebookAppHandler", "Result", "WebHandler", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ContextCreateDialog extends FacebookDialogBase<ContextCreateContent, Result> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.GamingContextCreate.toRequestCode();
    private FacebookCallback<Result> callback;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/gamingservices/ContextCreateDialog$Companion;", "", "()V", "DEFAULT_REQUEST_CODE", "", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00120\u0001R\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"Lcom/facebook/gamingservices/ContextCreateDialog$FacebookAppHandler;", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "Lcom/facebook/internal/FacebookDialogBase;", "Lcom/facebook/gamingservices/model/ContextCreateContent;", "Lcom/facebook/gamingservices/ContextCreateDialog$Result;", "(Lcom/facebook/gamingservices/ContextCreateDialog;)V", "canShow", "", "content", "isBestEffort", "createAppCall", "Lcom/facebook/internal/AppCall;", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private final class FacebookAppHandler extends FacebookDialogBase<ContextCreateContent, Result>.ModeHandler {
        final /* synthetic */ ContextCreateDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FacebookAppHandler(ContextCreateDialog contextCreateDialog) {
            super(contextCreateDialog);
            j.g(contextCreateDialog, "this$0");
            this.this$0 = contextCreateDialog;
        }

        public boolean canShow(ContextCreateContent contextCreateContent, boolean z10) {
            ComponentName componentName;
            j.g(contextCreateContent, "content");
            Activity access$getActivityContext = this.this$0.getActivityContext();
            String str = null;
            PackageManager packageManager = access$getActivityContext == null ? null : access$getActivityContext.getPackageManager();
            Intent intent = new Intent("com.facebook.games.gaming_services.DEEPLINK");
            intent.setType("text/plain");
            if (packageManager == null) {
                componentName = null;
            } else {
                componentName = intent.resolveActivity(packageManager);
            }
            boolean z11 = componentName != null;
            AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
            if (currentAccessToken != null) {
                str = currentAccessToken.getGraphDomain();
            }
            boolean z12 = str != null && j.b(FacebookSdk.GAMING, currentAccessToken.getGraphDomain());
            if (!z11 || !z12) {
                return false;
            }
            return true;
        }

        public AppCall createAppCall(ContextCreateContent contextCreateContent) {
            j.g(contextCreateContent, "content");
            AppCall createBaseAppCall = this.this$0.createBaseAppCall();
            Intent intent = new Intent("com.facebook.games.gaming_services.DEEPLINK");
            intent.setType("text/plain");
            AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
            Bundle bundle = new Bundle();
            bundle.putString(SDKConstants.PARAM_TOURNAMENTS_DEEPLINK, "CONTEXT_CREATE");
            if (currentAccessToken != null) {
                bundle.putString("game_id", currentAccessToken.getApplicationId());
            } else {
                bundle.putString("game_id", FacebookSdk.getApplicationId());
            }
            if (contextCreateContent.getSuggestedPlayerID() != null) {
                bundle.putString("player_id", contextCreateContent.getSuggestedPlayerID());
            }
            NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
            NativeProtocol.setupProtocolRequestIntent(intent, createBaseAppCall.getCallId().toString(), "", NativeProtocol.getLatestKnownVersion(), bundle);
            createBaseAppCall.setRequestIntent(intent);
            return createBaseAppCall;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00120\u0001R\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"Lcom/facebook/gamingservices/ContextCreateDialog$WebHandler;", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "Lcom/facebook/internal/FacebookDialogBase;", "Lcom/facebook/gamingservices/model/ContextCreateContent;", "Lcom/facebook/gamingservices/ContextCreateDialog$Result;", "(Lcom/facebook/gamingservices/ContextCreateDialog;)V", "canShow", "", "content", "isBestEffort", "createAppCall", "Lcom/facebook/internal/AppCall;", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private final class WebHandler extends FacebookDialogBase<ContextCreateContent, Result>.ModeHandler {
        final /* synthetic */ ContextCreateDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WebHandler(ContextCreateDialog contextCreateDialog) {
            super(contextCreateDialog);
            j.g(contextCreateDialog, "this$0");
            this.this$0 = contextCreateDialog;
        }

        public boolean canShow(ContextCreateContent contextCreateContent, boolean z10) {
            j.g(contextCreateContent, "content");
            return true;
        }

        public AppCall createAppCall(ContextCreateContent contextCreateContent) {
            j.g(contextCreateContent, "content");
            AppCall createBaseAppCall = this.this$0.createBaseAppCall();
            Bundle bundle = new Bundle();
            bundle.putString("player_id", contextCreateContent.getSuggestedPlayerID());
            AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
            if (currentAccessToken != null) {
                bundle.putString("dialog_access_token", currentAccessToken.getToken());
            }
            DialogPresenter.setupAppCallForWebDialog(createBaseAppCall, IdentityHttpResponse.CONTEXT, bundle);
            return createBaseAppCall;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContextCreateDialog(Activity activity) {
        super(activity, DEFAULT_REQUEST_CODE);
        j.g(activity, "activity");
    }

    /* access modifiers changed from: private */
    /* renamed from: registerCallbackImpl$lambda-3  reason: not valid java name */
    public static final boolean m103registerCallbackImpl$lambda3(ContextCreateDialog contextCreateDialog, ResultProcessor resultProcessor, int i10, Intent intent) {
        j.g(contextCreateDialog, "this$0");
        j.g(resultProcessor, "$resultProcessor");
        ShareInternalUtility shareInternalUtility = ShareInternalUtility.INSTANCE;
        return ShareInternalUtility.handleActivityResult(contextCreateDialog.getRequestCode(), i10, intent, resultProcessor);
    }

    private final void showForCloud(ContextCreateContent contextCreateContent) {
        AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
        if (currentAccessToken == null || currentAccessToken.isExpired()) {
            throw new FacebookException("Attempted to open ContextCreateContent with an invalid access token");
        }
        d dVar = new d(this);
        b bVar = new b();
        try {
            if (contextCreateContent.getSuggestedPlayerID() != null) {
                bVar.put("id", (Object) contextCreateContent.getSuggestedPlayerID());
            }
            DaemonRequest.executeAsync((Context) getActivityContext(), bVar, (DaemonRequest.Callback) dVar, SDKMessageEnum.CONTEXT_CREATE);
        } catch (JSONException unused) {
            FacebookCallback<Result> facebookCallback = this.callback;
            if (facebookCallback != null) {
                facebookCallback.onError(new FacebookException("Couldn't prepare Context Create Dialog"));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showForCloud$lambda-2  reason: not valid java name */
    public static final void m104showForCloud$lambda2(ContextCreateDialog contextCreateDialog, GraphResponse graphResponse) {
        Unit unit;
        j.g(contextCreateDialog, "this$0");
        FacebookCallback<Result> facebookCallback = contextCreateDialog.callback;
        if (facebookCallback != null) {
            FacebookRequestError error = graphResponse.getError();
            if (error == null) {
                unit = null;
            } else {
                facebookCallback.onError(new FacebookException(error.getErrorMessage()));
                unit = Unit.f32013a;
            }
            if (unit == null) {
                j.f(graphResponse, "response");
                facebookCallback.onSuccess(new Result(graphResponse));
            }
        }
    }

    /* access modifiers changed from: protected */
    public AppCall createBaseAppCall() {
        return new AppCall(getRequestCode(), (UUID) null, 2, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: protected */
    public List<FacebookDialogBase<ContextCreateContent, Result>.ModeHandler> getOrderedModeHandlers() {
        return q.m(new FacebookAppHandler(this), new WebHandler(this));
    }

    /* access modifiers changed from: protected */
    public void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, FacebookCallback<Result> facebookCallback) {
        j.g(callbackManagerImpl, "callbackManager");
        j.g(facebookCallback, "callback");
        this.callback = facebookCallback;
        callbackManagerImpl.registerCallback(getRequestCode(), new c(this, new ContextCreateDialog$registerCallbackImpl$resultProcessor$1(facebookCallback)));
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/facebook/gamingservices/ContextCreateDialog$Result;", "", "contextID", "", "(Ljava/lang/String;)V", "response", "Lcom/facebook/GraphResponse;", "(Lcom/facebook/GraphResponse;)V", "getContextID", "()Ljava/lang/String;", "setContextID", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Result {
        private String contextID;

        public Result(String str) {
            j.g(str, "contextID");
            this.contextID = str;
        }

        public final String getContextID() {
            return this.contextID;
        }

        public final void setContextID(String str) {
            this.contextID = str;
        }

        public Result(GraphResponse graphResponse) {
            j.g(graphResponse, "response");
            try {
                b jSONObject = graphResponse.getJSONObject();
                if (jSONObject != null) {
                    b optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject != null) {
                        setContextID(optJSONObject.getString("id"));
                    }
                }
            } catch (JSONException unused) {
                this.contextID = null;
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ContextCreateDialog(Fragment fragment) {
        this(new FragmentWrapper(fragment));
        j.g(fragment, "fragment");
    }

    public boolean canShow(ContextCreateContent contextCreateContent) {
        j.g(contextCreateContent, "content");
        if (CloudGameLoginHandler.isRunningInCloud() || new FacebookAppHandler(this).canShow(contextCreateContent, true) || new WebHandler(this).canShow(contextCreateContent, true)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void showImpl(ContextCreateContent contextCreateContent, Object obj) {
        j.g(contextCreateContent, "content");
        j.g(obj, JingleS5BTransport.ATTR_MODE);
        if (CloudGameLoginHandler.isRunningInCloud()) {
            showForCloud(contextCreateContent);
        } else {
            super.showImpl(contextCreateContent, obj);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ContextCreateDialog(android.app.Fragment fragment) {
        this(new FragmentWrapper(fragment));
        j.g(fragment, "fragment");
    }

    private ContextCreateDialog(FragmentWrapper fragmentWrapper) {
        super(fragmentWrapper, DEFAULT_REQUEST_CODE);
    }
}
