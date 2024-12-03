package com.facebook.internal;

import android.app.Activity;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.d;
import c.a;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookDialog;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransport;

@Metadata(bv = {}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\b&\u0018\u0000 F*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003:\u0002FGB\u0019\b\u0014\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\bC\u0010DB\u0019\b\u0014\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\bC\u0010EB\u0011\b\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\bC\u0010<J!\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u001e\u0010\u0010\u001a\u0018\u0012\u0014\u0012\u00120\u000fR\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00000\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u001e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012H\u0016J&\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u001e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00172\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012H$J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ&\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020!0 2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0004J\u001e\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020!0 2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001f\u0010#\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b#\u0010$J\u0018\u0010'\u001a\u00020\f2\u0006\u0010&\u001a\u00020%2\u0006\u0010\u0016\u001a\u00020\u0015H\u0004J\b\u0010(\u001a\u00020\u0007H$R\u0016\u0010*\u001a\u0004\u0018\u00010)8\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u0004\u0018\u00010,8\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R.\u0010/\u001a\u001a\u0012\u0014\u0012\u00120\u000fR\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u00102R$\u0010\u000b\u001a\u0004\u0018\u00010\n8A@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u000b\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u0010\u0016\u001a\u00020\u00152\u0006\u00108\u001a\u00020\u00158F@FX\u000e¢\u0006\f\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0016\u0010?\u001a\u0004\u0018\u00010)8DX\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R*\u0010B\u001a\u0018\u0012\u0014\u0012\u00120\u000fR\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00000\u000e8$X¤\u0004¢\u0006\u0006\u001a\u0004\b@\u0010A¨\u0006H"}, d2 = {"Lcom/facebook/internal/FacebookDialogBase;", "CONTENT", "RESULT", "Lcom/facebook/FacebookDialog;", "content", "", "mode", "Lcom/facebook/internal/AppCall;", "createAppCallForMode", "(Ljava/lang/Object;Ljava/lang/Object;)Lcom/facebook/internal/AppCall;", "Lcom/facebook/CallbackManager;", "callbackManager", "", "memorizeCallbackManager", "", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "cachedModeHandlers", "setCallbackManager", "Lcom/facebook/FacebookCallback;", "callback", "registerCallback", "", "requestCode", "Lcom/facebook/internal/CallbackManagerImpl;", "registerCallbackImpl", "", "canShow", "(Ljava/lang/Object;)Z", "canShowImpl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "show", "(Ljava/lang/Object;)V", "Lc/a;", "Lcom/facebook/CallbackManager$ActivityResultParameters;", "createActivityResultContractForShowingDialog", "showImpl", "(Ljava/lang/Object;Ljava/lang/Object;)V", "Landroid/content/Intent;", "intent", "startActivityForResult", "createBaseAppCall", "Landroid/app/Activity;", "activity", "Landroid/app/Activity;", "Lcom/facebook/internal/FragmentWrapper;", "fragmentWrapper", "Lcom/facebook/internal/FragmentWrapper;", "modeHandlers", "Ljava/util/List;", "requestCodeField", "I", "Lcom/facebook/CallbackManager;", "getCallbackManager$facebook_common_release", "()Lcom/facebook/CallbackManager;", "setCallbackManager$facebook_common_release", "(Lcom/facebook/CallbackManager;)V", "value", "getRequestCode", "()I", "setRequestCode", "(I)V", "getActivityContext", "()Landroid/app/Activity;", "activityContext", "getOrderedModeHandlers", "()Ljava/util/List;", "orderedModeHandlers", "<init>", "(Landroid/app/Activity;I)V", "(Lcom/facebook/internal/FragmentWrapper;I)V", "Companion", "ModeHandler", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public abstract class FacebookDialogBase<CONTENT, RESULT> implements FacebookDialog<CONTENT, RESULT> {
    public static final Object BASE_AUTOMATIC_MODE = new Object();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "FacebookDialog";
    private final Activity activity;
    private CallbackManager callbackManager;
    private final FragmentWrapper fragmentWrapper;
    private List<? extends FacebookDialogBase<CONTENT, RESULT>.ModeHandler> modeHandlers;
    private int requestCodeField;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00018\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/internal/FacebookDialogBase$Companion;", "", "()V", "BASE_AUTOMATIC_MODE", "TAG", "", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b¤\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001d\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\tH&¢\u0006\u0002\u0010\fJ\u0017\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "", "(Lcom/facebook/internal/FacebookDialogBase;)V", "mode", "getMode", "()Ljava/lang/Object;", "setMode", "(Ljava/lang/Object;)V", "canShow", "", "content", "isBestEffort", "(Ljava/lang/Object;Z)Z", "createAppCall", "Lcom/facebook/internal/AppCall;", "(Ljava/lang/Object;)Lcom/facebook/internal/AppCall;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    protected abstract class ModeHandler {
        private Object mode = FacebookDialogBase.BASE_AUTOMATIC_MODE;
        final /* synthetic */ FacebookDialogBase<CONTENT, RESULT> this$0;

        public ModeHandler(FacebookDialogBase facebookDialogBase) {
            j.g(facebookDialogBase, "this$0");
            this.this$0 = facebookDialogBase;
        }

        public abstract boolean canShow(CONTENT content, boolean z10);

        public abstract AppCall createAppCall(CONTENT content);

        public Object getMode() {
            return this.mode;
        }

        public void setMode(Object obj) {
            j.g(obj, "<set-?>");
            this.mode = obj;
        }
    }

    protected FacebookDialogBase(Activity activity2, int i10) {
        j.g(activity2, "activity");
        this.activity = activity2;
        this.fragmentWrapper = null;
        this.requestCodeField = i10;
        this.callbackManager = null;
    }

    private final List<FacebookDialogBase<CONTENT, RESULT>.ModeHandler> cachedModeHandlers() {
        if (this.modeHandlers == null) {
            this.modeHandlers = getOrderedModeHandlers();
        }
        List<? extends FacebookDialogBase<CONTENT, RESULT>.ModeHandler> list = this.modeHandlers;
        if (list != null) {
            return list;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.facebook.internal.FacebookDialogBase.ModeHandler<CONTENT of com.facebook.internal.FacebookDialogBase, RESULT of com.facebook.internal.FacebookDialogBase>>");
    }

    /* access modifiers changed from: private */
    public final AppCall createAppCallForMode(CONTENT content, Object obj) {
        boolean z10;
        if (obj == BASE_AUTOMATIC_MODE) {
            z10 = true;
        } else {
            z10 = false;
        }
        AppCall appCall = null;
        Iterator<FacebookDialogBase<CONTENT, RESULT>.ModeHandler> it = cachedModeHandlers().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ModeHandler next = it.next();
            if (!z10) {
                Utility utility = Utility.INSTANCE;
                if (!Utility.areObjectsEqual(next.getMode(), obj)) {
                    continue;
                }
            }
            if (next.canShow(content, true)) {
                try {
                    appCall = next.createAppCall(content);
                    break;
                } catch (FacebookException e10) {
                    appCall = createBaseAppCall();
                    DialogPresenter dialogPresenter = DialogPresenter.INSTANCE;
                    DialogPresenter.setupAppCallForValidationError(appCall, e10);
                }
            }
        }
        if (appCall != null) {
            return appCall;
        }
        AppCall createBaseAppCall = createBaseAppCall();
        DialogPresenter.setupAppCallForCannotShowError(createBaseAppCall);
        return createBaseAppCall;
    }

    private final void memorizeCallbackManager(CallbackManager callbackManager2) {
        if (this.callbackManager == null) {
            this.callbackManager = callbackManager2;
        }
    }

    public boolean canShow(CONTENT content) {
        return canShowImpl(content, BASE_AUTOMATIC_MODE);
    }

    /* access modifiers changed from: protected */
    public boolean canShowImpl(CONTENT content, Object obj) {
        boolean z10;
        j.g(obj, JingleS5BTransport.ATTR_MODE);
        if (obj == BASE_AUTOMATIC_MODE) {
            z10 = true;
        } else {
            z10 = false;
        }
        for (ModeHandler next : cachedModeHandlers()) {
            if (!z10) {
                Utility utility = Utility.INSTANCE;
                if (!Utility.areObjectsEqual(next.getMode(), obj)) {
                    continue;
                }
            }
            if (next.canShow(content, false)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final a<CONTENT, CallbackManager.ActivityResultParameters> createActivityResultContractForShowingDialog(CallbackManager callbackManager2, Object obj) {
        j.g(obj, JingleS5BTransport.ATTR_MODE);
        return new FacebookDialogBase$createActivityResultContractForShowingDialog$1(this, obj, callbackManager2);
    }

    /* access modifiers changed from: protected */
    public abstract AppCall createBaseAppCall();

    /* access modifiers changed from: protected */
    public final Activity getActivityContext() {
        Activity activity2 = this.activity;
        if (activity2 != null) {
            return activity2;
        }
        FragmentWrapper fragmentWrapper2 = this.fragmentWrapper;
        if (fragmentWrapper2 == null) {
            return null;
        }
        return fragmentWrapper2.getActivity();
    }

    public final CallbackManager getCallbackManager$facebook_common_release() {
        return this.callbackManager;
    }

    /* access modifiers changed from: protected */
    public abstract List<FacebookDialogBase<CONTENT, RESULT>.ModeHandler> getOrderedModeHandlers();

    public final int getRequestCode() {
        return this.requestCodeField;
    }

    public void registerCallback(CallbackManager callbackManager2, FacebookCallback<RESULT> facebookCallback) {
        j.g(callbackManager2, "callbackManager");
        j.g(facebookCallback, "callback");
        if (callbackManager2 instanceof CallbackManagerImpl) {
            memorizeCallbackManager(callbackManager2);
            registerCallbackImpl((CallbackManagerImpl) callbackManager2, facebookCallback);
            return;
        }
        throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }

    /* access modifiers changed from: protected */
    public abstract void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, FacebookCallback<RESULT> facebookCallback);

    public final void setCallbackManager(CallbackManager callbackManager2) {
        this.callbackManager = callbackManager2;
    }

    public final void setCallbackManager$facebook_common_release(CallbackManager callbackManager2) {
        this.callbackManager = callbackManager2;
    }

    public final void setRequestCode(int i10) {
        if (!FacebookSdk.isFacebookRequestCode(i10)) {
            this.requestCodeField = i10;
            return;
        }
        throw new IllegalArgumentException(("Request code " + i10 + " cannot be within the range reserved by the Facebook SDK.").toString());
    }

    public void show(CONTENT content) {
        showImpl(content, BASE_AUTOMATIC_MODE);
    }

    /* access modifiers changed from: protected */
    public void showImpl(CONTENT content, Object obj) {
        j.g(obj, JingleS5BTransport.ATTR_MODE);
        AppCall createAppCallForMode = createAppCallForMode(content, obj);
        if (createAppCallForMode != null) {
            if (getActivityContext() instanceof d) {
                Activity activityContext = getActivityContext();
                if (activityContext != null) {
                    DialogPresenter dialogPresenter = DialogPresenter.INSTANCE;
                    ActivityResultRegistry activityResultRegistry = ((d) activityContext).getActivityResultRegistry();
                    j.f(activityResultRegistry, "registryOwner.activityResultRegistry");
                    DialogPresenter.present(createAppCallForMode, activityResultRegistry, this.callbackManager);
                    createAppCallForMode.setPending();
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.activity.result.ActivityResultRegistryOwner");
            }
            FragmentWrapper fragmentWrapper2 = this.fragmentWrapper;
            if (fragmentWrapper2 != null) {
                DialogPresenter.present(createAppCallForMode, fragmentWrapper2);
                return;
            }
            Activity activity2 = this.activity;
            if (activity2 != null) {
                DialogPresenter.present(createAppCallForMode, activity2);
            }
        } else if (!(!FacebookSdk.isDebugEnabled())) {
            throw new IllegalStateException("No code path should ever result in a null appCall".toString());
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void startActivityForResult(android.content.Intent r5, int r6) {
        /*
            r4 = this;
            java.lang.String r0 = "intent"
            kotlin.jvm.internal.j.g(r5, r0)
            android.app.Activity r0 = r4.getActivityContext()
            boolean r1 = r0 instanceof androidx.activity.result.d
            if (r1 == 0) goto L_0x0020
            com.facebook.internal.DialogPresenter r1 = com.facebook.internal.DialogPresenter.INSTANCE
            androidx.activity.result.d r0 = (androidx.activity.result.d) r0
            androidx.activity.result.ActivityResultRegistry r0 = r0.getActivityResultRegistry()
            java.lang.String r1 = "activity as ActivityResultRegistryOwner).activityResultRegistry"
            kotlin.jvm.internal.j.f(r0, r1)
            com.facebook.CallbackManager r1 = r4.callbackManager
            com.facebook.internal.DialogPresenter.startActivityForResultWithAndroidX(r0, r1, r5, r6)
            goto L_0x002d
        L_0x0020:
            if (r0 == 0) goto L_0x0026
            r0.startActivityForResult(r5, r6)
            goto L_0x002d
        L_0x0026:
            com.facebook.internal.FragmentWrapper r0 = r4.fragmentWrapper
            if (r0 == 0) goto L_0x002f
            r0.startActivityForResult(r5, r6)
        L_0x002d:
            r5 = 0
            goto L_0x0031
        L_0x002f:
            java.lang.String r5 = "Failed to find Activity or Fragment to startActivityForResult "
        L_0x0031:
            if (r5 == 0) goto L_0x0048
            com.facebook.internal.Logger$Companion r6 = com.facebook.internal.Logger.Companion
            com.facebook.LoggingBehavior r0 = com.facebook.LoggingBehavior.DEVELOPER_ERRORS
            r1 = 6
            java.lang.Class r2 = r4.getClass()
            java.lang.String r2 = r2.getName()
            java.lang.String r3 = "this.javaClass.name"
            kotlin.jvm.internal.j.f(r2, r3)
            r6.log((com.facebook.LoggingBehavior) r0, (int) r1, (java.lang.String) r2, (java.lang.String) r5)
        L_0x0048:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.FacebookDialogBase.startActivityForResult(android.content.Intent, int):void");
    }

    public a<CONTENT, CallbackManager.ActivityResultParameters> createActivityResultContractForShowingDialog(CallbackManager callbackManager2) {
        return createActivityResultContractForShowingDialog(callbackManager2, BASE_AUTOMATIC_MODE);
    }

    public void registerCallback(CallbackManager callbackManager2, FacebookCallback<RESULT> facebookCallback, int i10) {
        j.g(callbackManager2, "callbackManager");
        j.g(facebookCallback, "callback");
        memorizeCallbackManager(callbackManager2);
        setRequestCode(i10);
        registerCallback(callbackManager2, facebookCallback);
    }

    protected FacebookDialogBase(FragmentWrapper fragmentWrapper2, int i10) {
        j.g(fragmentWrapper2, "fragmentWrapper");
        this.fragmentWrapper = fragmentWrapper2;
        this.activity = null;
        this.requestCodeField = i10;
        if (fragmentWrapper2.getActivity() == null) {
            throw new IllegalArgumentException("Cannot use a fragment that is not attached to an activity".toString());
        }
    }

    protected FacebookDialogBase(int i10) {
        this.requestCodeField = i10;
        this.activity = null;
        this.fragmentWrapper = null;
    }
}
