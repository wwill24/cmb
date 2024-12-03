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
import com.facebook.gamingservices.model.ContextChooseContent;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CustomTabUtils;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareInternalUtility;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransport;
import org.json.JSONException;
import org.json.a;
import org.json.b;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004#$%&B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\n¢\u0006\u0002\u0010\u000bB\u000f\b\u0012\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0014J\u001e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u0014J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u0002H\u0002J\u0018\u0010 \u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"H\u0014R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R*\u0010\u0011\u001a\u0018\u0012\u0014\u0012\u00120\u0013R\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00010\u00128TX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006'"}, d2 = {"Lcom/facebook/gamingservices/ContextChooseDialog;", "Lcom/facebook/internal/FacebookDialogBase;", "Lcom/facebook/gamingservices/model/ContextChooseContent;", "Lcom/facebook/gamingservices/ContextChooseDialog$Result;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "Landroid/app/Fragment;", "(Landroid/app/Fragment;)V", "fragmentWrapper", "Lcom/facebook/internal/FragmentWrapper;", "(Lcom/facebook/internal/FragmentWrapper;)V", "callback", "Lcom/facebook/FacebookCallback;", "orderedModeHandlers", "", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "getOrderedModeHandlers", "()Ljava/util/List;", "canShow", "", "content", "createBaseAppCall", "Lcom/facebook/internal/AppCall;", "registerCallbackImpl", "", "callbackManager", "Lcom/facebook/internal/CallbackManagerImpl;", "showForCloud", "showImpl", "mode", "", "ChromeCustomTabHandler", "Companion", "FacebookAppHandler", "Result", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ContextChooseDialog extends FacebookDialogBase<ContextChooseContent, Result> {
    private static final String CONTEXT_CHOOSE_DIALOG = "context_choose";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.GamingContextChoose.toRequestCode();
    private FacebookCallback<Result> callback;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00120\u0001R\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"Lcom/facebook/gamingservices/ContextChooseDialog$ChromeCustomTabHandler;", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "Lcom/facebook/internal/FacebookDialogBase;", "Lcom/facebook/gamingservices/model/ContextChooseContent;", "Lcom/facebook/gamingservices/ContextChooseDialog$Result;", "(Lcom/facebook/gamingservices/ContextChooseDialog;)V", "canShow", "", "content", "isBestEffort", "createAppCall", "Lcom/facebook/internal/AppCall;", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private final class ChromeCustomTabHandler extends FacebookDialogBase<ContextChooseContent, Result>.ModeHandler {
        final /* synthetic */ ContextChooseDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ChromeCustomTabHandler(ContextChooseDialog contextChooseDialog) {
            super(contextChooseDialog);
            j.g(contextChooseDialog, "this$0");
            this.this$0 = contextChooseDialog;
        }

        public boolean canShow(ContextChooseContent contextChooseContent, boolean z10) {
            j.g(contextChooseContent, "content");
            return CustomTabUtils.getChromePackage() != null;
        }

        public AppCall createAppCall(ContextChooseContent contextChooseContent) {
            String str;
            j.g(contextChooseContent, "content");
            AppCall createBaseAppCall = this.this$0.createBaseAppCall();
            AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
            Bundle bundle = new Bundle();
            Bundle bundle2 = new Bundle();
            Bundle bundle3 = new Bundle();
            if (currentAccessToken == null) {
                str = null;
            } else {
                str = currentAccessToken.getApplicationId();
            }
            if (str == null) {
                str = FacebookSdk.getApplicationId();
            }
            bundle.putString("app_id", str);
            if (contextChooseContent.getMinSize() != null) {
                bundle3.putString("min_size", contextChooseContent.getMinSize().toString());
            }
            if (contextChooseContent.getMaxSize() != null) {
                bundle3.putString("max_size", contextChooseContent.getMaxSize().toString());
            }
            if (contextChooseContent.getFilters() != null) {
                bundle3.putString("filters", new a((Collection<?>) contextChooseContent.getFilters()).toString());
            }
            bundle2.putString("filters", bundle3.toString());
            bundle.putString("payload", bundle2.toString());
            bundle.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, CustomTabUtils.getDefaultRedirectURI());
            DialogPresenter.setupAppCallForCustomTabDialog(createBaseAppCall, ContextChooseDialog.CONTEXT_CHOOSE_DIALOG, bundle);
            return createBaseAppCall;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/facebook/gamingservices/ContextChooseDialog$Companion;", "", "()V", "CONTEXT_CHOOSE_DIALOG", "", "DEFAULT_REQUEST_CODE", "", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00120\u0001R\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"Lcom/facebook/gamingservices/ContextChooseDialog$FacebookAppHandler;", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "Lcom/facebook/internal/FacebookDialogBase;", "Lcom/facebook/gamingservices/model/ContextChooseContent;", "Lcom/facebook/gamingservices/ContextChooseDialog$Result;", "(Lcom/facebook/gamingservices/ContextChooseDialog;)V", "canShow", "", "content", "isBestEffort", "createAppCall", "Lcom/facebook/internal/AppCall;", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private final class FacebookAppHandler extends FacebookDialogBase<ContextChooseContent, Result>.ModeHandler {
        final /* synthetic */ ContextChooseDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FacebookAppHandler(ContextChooseDialog contextChooseDialog) {
            super(contextChooseDialog);
            j.g(contextChooseDialog, "this$0");
            this.this$0 = contextChooseDialog;
        }

        public boolean canShow(ContextChooseContent contextChooseContent, boolean z10) {
            ComponentName componentName;
            j.g(contextChooseContent, "content");
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

        public AppCall createAppCall(ContextChooseContent contextChooseContent) {
            j.g(contextChooseContent, "content");
            AppCall createBaseAppCall = this.this$0.createBaseAppCall();
            Intent intent = new Intent("com.facebook.games.gaming_services.DEEPLINK");
            intent.setType("text/plain");
            AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
            Bundle bundle = new Bundle();
            bundle.putString(SDKConstants.PARAM_TOURNAMENTS_DEEPLINK, "CONTEXT_CHOOSE");
            if (currentAccessToken != null) {
                bundle.putString("game_id", currentAccessToken.getApplicationId());
            } else {
                bundle.putString("game_id", FacebookSdk.getApplicationId());
            }
            if (contextChooseContent.getMinSize() != null) {
                bundle.putString("min_thread_size", contextChooseContent.getMinSize().toString());
            }
            if (contextChooseContent.getMaxSize() != null) {
                bundle.putString("max_thread_size", contextChooseContent.getMaxSize().toString());
            }
            if (contextChooseContent.getFilters() != null) {
                bundle.putString("filters", new a((Collection<?>) contextChooseContent.getFilters()).toString());
            }
            NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
            NativeProtocol.setupProtocolRequestIntent(intent, createBaseAppCall.getCallId().toString(), "", NativeProtocol.getLatestKnownVersion(), bundle);
            createBaseAppCall.setRequestIntent(intent);
            return createBaseAppCall;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContextChooseDialog(Activity activity) {
        super(activity, DEFAULT_REQUEST_CODE);
        j.g(activity, "activity");
    }

    /* access modifiers changed from: private */
    /* renamed from: registerCallbackImpl$lambda-4  reason: not valid java name */
    public static final boolean m101registerCallbackImpl$lambda4(ContextChooseDialog contextChooseDialog, ContextChooseDialog$registerCallbackImpl$resultProcessor$1 contextChooseDialog$registerCallbackImpl$resultProcessor$1, int i10, Intent intent) {
        j.g(contextChooseDialog, "this$0");
        j.g(contextChooseDialog$registerCallbackImpl$resultProcessor$1, "$resultProcessor");
        ShareInternalUtility shareInternalUtility = ShareInternalUtility.INSTANCE;
        return ShareInternalUtility.handleActivityResult(contextChooseDialog.getRequestCode(), i10, intent, contextChooseDialog$registerCallbackImpl$resultProcessor$1);
    }

    private final void showForCloud(ContextChooseContent contextChooseContent) {
        AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
        if (currentAccessToken == null || currentAccessToken.isExpired()) {
            throw new FacebookException("Attempted to open ContextChooseContent with an invalid access token");
        }
        a aVar = new a(this);
        b bVar = new b();
        try {
            bVar.put("filters", (Object) contextChooseContent.getFilters());
            bVar.put(SDKConstants.PARAM_CONTEXT_MIN_SIZE, (Object) contextChooseContent.getMinSize());
            List<String> filters = contextChooseContent.getFilters();
            if (filters != null) {
                a aVar2 = new a();
                for (String E : filters) {
                    aVar2.E(E);
                }
                bVar.put("filters", (Object) aVar2);
            }
            DaemonRequest.executeAsync((Context) getActivityContext(), bVar, (DaemonRequest.Callback) aVar, SDKMessageEnum.CONTEXT_CHOOSE);
        } catch (JSONException unused) {
            FacebookCallback<Result> facebookCallback = this.callback;
            if (facebookCallback != null) {
                facebookCallback.onError(new FacebookException("Couldn't prepare Context Choose Dialog"));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showForCloud$lambda-2  reason: not valid java name */
    public static final void m102showForCloud$lambda2(ContextChooseDialog contextChooseDialog, GraphResponse graphResponse) {
        Unit unit;
        j.g(contextChooseDialog, "this$0");
        FacebookCallback<Result> facebookCallback = contextChooseDialog.callback;
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
    public List<FacebookDialogBase<ContextChooseContent, Result>.ModeHandler> getOrderedModeHandlers() {
        return q.m(new FacebookAppHandler(this), new ChromeCustomTabHandler(this));
    }

    /* access modifiers changed from: protected */
    public void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, FacebookCallback<Result> facebookCallback) {
        j.g(callbackManagerImpl, "callbackManager");
        j.g(facebookCallback, "callback");
        this.callback = facebookCallback;
        callbackManagerImpl.registerCallback(getRequestCode(), new b(this, new ContextChooseDialog$registerCallbackImpl$resultProcessor$1(facebookCallback)));
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/facebook/gamingservices/ContextChooseDialog$Result;", "", "results", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "response", "Lcom/facebook/GraphResponse;", "(Lcom/facebook/GraphResponse;)V", "contextID", "", "getContextID", "()Ljava/lang/String;", "setContextID", "(Ljava/lang/String;)V", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Result {
        private String contextID;

        public Result(Bundle bundle) {
            j.g(bundle, "results");
            this.contextID = bundle.getString("id");
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
    public ContextChooseDialog(Fragment fragment) {
        this(new FragmentWrapper(fragment));
        j.g(fragment, "fragment");
    }

    public boolean canShow(ContextChooseContent contextChooseContent) {
        j.g(contextChooseContent, "content");
        if (CloudGameLoginHandler.isRunningInCloud() || new FacebookAppHandler(this).canShow(contextChooseContent, true) || new ChromeCustomTabHandler(this).canShow(contextChooseContent, true)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void showImpl(ContextChooseContent contextChooseContent, Object obj) {
        j.g(contextChooseContent, "content");
        j.g(obj, JingleS5BTransport.ATTR_MODE);
        if (CloudGameLoginHandler.isRunningInCloud()) {
            showForCloud(contextChooseContent);
        } else {
            super.showImpl(contextChooseContent, obj);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ContextChooseDialog(android.app.Fragment fragment) {
        this(new FragmentWrapper(fragment));
        j.g(fragment, "fragment");
    }

    private ContextChooseDialog(FragmentWrapper fragmentWrapper) {
        super(fragmentWrapper, DEFAULT_REQUEST_CODE);
    }
}
