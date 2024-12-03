package com.facebook.gamingservices;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.CloudGameLoginHandler;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CustomTabUtils;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Validate;
import com.facebook.share.internal.GameRequestValidation;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.internal.WebDialogParameters;
import com.facebook.share.model.GameRequestContent;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.a;
import org.json.b;

public class GameRequestDialog extends FacebookDialogBase<GameRequestContent, Result> {
    private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.GameRequest.toRequestCode();
    private static final String GAME_REQUEST_DIALOG = "apprequests";
    /* access modifiers changed from: private */
    public FacebookCallback mCallback;

    private class ChromeCustomTabHandler extends FacebookDialogBase<GameRequestContent, Result>.ModeHandler {
        private ChromeCustomTabHandler() {
            super(GameRequestDialog.this);
        }

        public boolean canShow(GameRequestContent gameRequestContent, boolean z10) {
            return CustomTabUtils.getChromePackage() != null && Validate.hasCustomTabRedirectActivity(GameRequestDialog.this.getActivityContext(), CustomTabUtils.getDefaultRedirectURI());
        }

        public AppCall createAppCall(GameRequestContent gameRequestContent) {
            GameRequestValidation.validate(gameRequestContent);
            AppCall createBaseAppCall = GameRequestDialog.this.createBaseAppCall();
            Bundle create = WebDialogParameters.create(gameRequestContent);
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            if (currentAccessToken != null) {
                create.putString("app_id", currentAccessToken.getApplicationId());
            } else {
                create.putString("app_id", FacebookSdk.getApplicationId());
            }
            create.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, CustomTabUtils.getDefaultRedirectURI());
            DialogPresenter.setupAppCallForCustomTabDialog(createBaseAppCall, GameRequestDialog.GAME_REQUEST_DIALOG, create);
            return createBaseAppCall;
        }
    }

    private class FacebookAppHandler extends FacebookDialogBase<GameRequestContent, Result>.ModeHandler {
        private FacebookAppHandler() {
            super(GameRequestDialog.this);
        }

        public boolean canShow(GameRequestContent gameRequestContent, boolean z10) {
            PackageManager packageManager = GameRequestDialog.this.getActivityContext().getPackageManager();
            Intent intent = new Intent("com.facebook.games.gaming_services.DEEPLINK");
            intent.setType("text/plain");
            boolean z11 = intent.resolveActivity(packageManager) != null;
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            boolean z12 = (currentAccessToken == null || currentAccessToken.getGraphDomain() == null || !FacebookSdk.GAMING.equals(currentAccessToken.getGraphDomain())) ? false : true;
            if (!z11 || !z12) {
                return false;
            }
            return true;
        }

        public AppCall createAppCall(GameRequestContent gameRequestContent) {
            AppCall createBaseAppCall = GameRequestDialog.this.createBaseAppCall();
            Intent intent = new Intent("com.facebook.games.gaming_services.DEEPLINK");
            intent.setType("text/plain");
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            Bundle bundle = new Bundle();
            bundle.putString(SDKConstants.PARAM_TOURNAMENTS_DEEPLINK, "GAME_REQUESTS");
            if (currentAccessToken != null) {
                bundle.putString("app_id", currentAccessToken.getApplicationId());
            } else {
                bundle.putString("app_id", FacebookSdk.getApplicationId());
            }
            bundle.putString(SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE, gameRequestContent.getActionType() != null ? gameRequestContent.getActionType().name() : null);
            bundle.putString("message", gameRequestContent.getMessage());
            bundle.putString("title", gameRequestContent.getTitle());
            bundle.putString("data", gameRequestContent.getData());
            bundle.putString(SDKConstants.PARAM_GAME_REQUESTS_CTA, gameRequestContent.getCta());
            gameRequestContent.getRecipients();
            a aVar = new a();
            if (gameRequestContent.getRecipients() != null) {
                for (String E : gameRequestContent.getRecipients()) {
                    aVar.E(E);
                }
            }
            bundle.putString("to", aVar.toString());
            NativeProtocol.setupProtocolRequestIntent(intent, createBaseAppCall.getCallId().toString(), "", NativeProtocol.getLatestKnownVersion(), bundle);
            createBaseAppCall.setRequestIntent(intent);
            return createBaseAppCall;
        }
    }

    private class WebHandler extends FacebookDialogBase<GameRequestContent, Result>.ModeHandler {
        private WebHandler() {
            super(GameRequestDialog.this);
        }

        public boolean canShow(GameRequestContent gameRequestContent, boolean z10) {
            return true;
        }

        public AppCall createAppCall(GameRequestContent gameRequestContent) {
            GameRequestValidation.validate(gameRequestContent);
            AppCall createBaseAppCall = GameRequestDialog.this.createBaseAppCall();
            DialogPresenter.setupAppCallForWebDialog(createBaseAppCall, GameRequestDialog.GAME_REQUEST_DIALOG, WebDialogParameters.create(gameRequestContent));
            return createBaseAppCall;
        }
    }

    public GameRequestDialog(Activity activity) {
        super(activity, DEFAULT_REQUEST_CODE);
    }

    public static boolean canShow() {
        return true;
    }

    public static void show(Activity activity, GameRequestContent gameRequestContent) {
        new GameRequestDialog(activity).show(gameRequestContent);
    }

    private void showForCloud(GameRequestContent gameRequestContent, Object obj) {
        String str;
        Activity activityContext = getActivityContext();
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (currentAccessToken == null || currentAccessToken.isExpired()) {
            throw new FacebookException("Attempted to open GameRequestDialog with an invalid access token");
        }
        AnonymousClass3 r12 = new DaemonRequest.Callback() {
            public void onCompleted(GraphResponse graphResponse) {
                if (GameRequestDialog.this.mCallback == null) {
                    return;
                }
                if (graphResponse.getError() != null) {
                    GameRequestDialog.this.mCallback.onError(new FacebookException(graphResponse.getError().getErrorMessage()));
                } else {
                    GameRequestDialog.this.mCallback.onSuccess(new Result(graphResponse));
                }
            }
        };
        String applicationId = currentAccessToken.getApplicationId();
        if (gameRequestContent.getActionType() != null) {
            str = gameRequestContent.getActionType().name();
        } else {
            str = null;
        }
        b bVar = new b();
        a aVar = new a();
        try {
            bVar.put(SDKConstants.PARAM_APP_ID, (Object) applicationId);
            bVar.put(SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE, (Object) str);
            bVar.put("message", (Object) gameRequestContent.getMessage());
            bVar.put(SDKConstants.PARAM_GAME_REQUESTS_CTA, (Object) gameRequestContent.getCta());
            bVar.put("title", (Object) gameRequestContent.getTitle());
            bVar.put("data", (Object) gameRequestContent.getData());
            bVar.put(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, (Object) gameRequestContent.getFilters());
            if (gameRequestContent.getRecipients() != null) {
                for (String E : gameRequestContent.getRecipients()) {
                    aVar.E(E);
                }
            }
            bVar.put("to", (Object) aVar);
            DaemonRequest.executeAsync((Context) activityContext, bVar, (DaemonRequest.Callback) r12, SDKMessageEnum.OPEN_GAME_REQUESTS_DIALOG);
        } catch (JSONException unused) {
            FacebookCallback facebookCallback = this.mCallback;
            if (facebookCallback != null) {
                facebookCallback.onError(new FacebookException("Couldn't prepare Game Request Dialog"));
            }
        }
    }

    /* access modifiers changed from: protected */
    public AppCall createBaseAppCall() {
        return new AppCall(getRequestCode());
    }

    /* access modifiers changed from: protected */
    public List<FacebookDialogBase<GameRequestContent, Result>.ModeHandler> getOrderedModeHandlers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FacebookAppHandler());
        arrayList.add(new ChromeCustomTabHandler());
        arrayList.add(new WebHandler());
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, final FacebookCallback<Result> facebookCallback) {
        final AnonymousClass1 r42;
        this.mCallback = facebookCallback;
        if (facebookCallback == null) {
            r42 = null;
        } else {
            r42 = new ResultProcessor(facebookCallback) {
                public void onSuccess(AppCall appCall, Bundle bundle) {
                    if (bundle != null) {
                        facebookCallback.onSuccess(new Result(bundle));
                    } else {
                        onCancel(appCall);
                    }
                }
            };
        }
        callbackManagerImpl.registerCallback(getRequestCode(), new CallbackManagerImpl.Callback() {
            public boolean onActivityResult(int i10, Intent intent) {
                return ShareInternalUtility.handleActivityResult(GameRequestDialog.this.getRequestCode(), i10, intent, r42);
            }
        });
    }

    public static final class Result {
        String requestId;
        List<String> to;

        public String getRequestId() {
            return this.requestId;
        }

        public List<String> getRequestRecipients() {
            return this.to;
        }

        private Result(Bundle bundle) {
            this.requestId = bundle.getString("request");
            this.to = new ArrayList();
            while (true) {
                if (bundle.containsKey(String.format(ShareConstants.WEB_DIALOG_RESULT_PARAM_TO_ARRAY_MEMBER, new Object[]{Integer.valueOf(this.to.size())}))) {
                    List<String> list = this.to;
                    list.add(bundle.getString(String.format(ShareConstants.WEB_DIALOG_RESULT_PARAM_TO_ARRAY_MEMBER, new Object[]{Integer.valueOf(list.size())})));
                } else {
                    return;
                }
            }
        }

        private Result(GraphResponse graphResponse) {
            try {
                b jSONObject = graphResponse.getJSONObject();
                b optJSONObject = jSONObject.optJSONObject("data");
                jSONObject = optJSONObject != null ? optJSONObject : jSONObject;
                this.requestId = jSONObject.getString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID);
                this.to = new ArrayList();
                a jSONArray = jSONObject.getJSONArray("to");
                for (int i10 = 0; i10 < jSONArray.o(); i10++) {
                    this.to.add(jSONArray.n(i10));
                }
            } catch (JSONException unused) {
                this.requestId = null;
                this.to = new ArrayList();
            }
        }
    }

    public GameRequestDialog(Fragment fragment) {
        this(new FragmentWrapper(fragment));
    }

    public static void show(Fragment fragment, GameRequestContent gameRequestContent) {
        show(new FragmentWrapper(fragment), gameRequestContent);
    }

    /* access modifiers changed from: protected */
    public void showImpl(GameRequestContent gameRequestContent, Object obj) {
        if (CloudGameLoginHandler.isRunningInCloud()) {
            showForCloud(gameRequestContent, obj);
        } else {
            super.showImpl(gameRequestContent, obj);
        }
    }

    public GameRequestDialog(android.app.Fragment fragment) {
        this(new FragmentWrapper(fragment));
    }

    public static void show(android.app.Fragment fragment, GameRequestContent gameRequestContent) {
        show(new FragmentWrapper(fragment), gameRequestContent);
    }

    private GameRequestDialog(FragmentWrapper fragmentWrapper) {
        super(fragmentWrapper, DEFAULT_REQUEST_CODE);
    }

    private static void show(FragmentWrapper fragmentWrapper, GameRequestContent gameRequestContent) {
        new GameRequestDialog(fragmentWrapper).show(gameRequestContent);
    }
}
