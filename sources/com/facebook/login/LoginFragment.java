package com.facebook.login;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.c;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.h;
import c.i;
import com.facebook.common.R;
import com.facebook.login.LoginClient;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u0000 >2\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b<\u0010=J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\rH\u0002J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\b\u0010\u0014\u001a\u00020\u0006H\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0016J\"\u0010\"\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u000fH\u0016J\b\u0010%\u001a\u00020\u0006H\u0014J\b\u0010&\u001a\u00020\u0006H\u0014R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010+\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R$\u0010.\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u00128\u0006@BX.¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R0\u00103\u001a\b\u0012\u0004\u0012\u00020 022\f\u0010-\u001a\b\u0012\u0004\u0012\u00020 028\u0006@BX.¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0016\u00107\u001a\u00020\u00198\u0002@\u0002X.¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010;\u001a\u00020\u001d8UX\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:¨\u0006?"}, d2 = {"Lcom/facebook/login/LoginFragment;", "Landroidx/fragment/app/Fragment;", "Landroidx/fragment/app/h;", "activity", "Lkotlin/Function1;", "Landroidx/activity/result/ActivityResult;", "", "getLoginMethodHandlerCallback", "Lcom/facebook/login/LoginClient$Result;", "outcome", "onLoginClientCompleted", "showSpinner", "hideSpinner", "Landroid/app/Activity;", "initializeCallingPackage", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "Lcom/facebook/login/LoginClient;", "createLoginClient", "onDestroy", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "onResume", "onPause", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "outState", "onSaveInstanceState", "onSpinnerShown", "onSpinnerHidden", "", "callingPackage", "Ljava/lang/String;", "Lcom/facebook/login/LoginClient$Request;", "request", "Lcom/facebook/login/LoginClient$Request;", "<set-?>", "loginClient", "Lcom/facebook/login/LoginClient;", "getLoginClient", "()Lcom/facebook/login/LoginClient;", "Landroidx/activity/result/c;", "launcher", "Landroidx/activity/result/c;", "getLauncher", "()Landroidx/activity/result/c;", "progressBar", "Landroid/view/View;", "getLayoutResId", "()I", "layoutResId", "<init>", "()V", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public class LoginFragment extends Fragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_REQUEST = "request";
    private static final String NULL_CALLING_PKG_ERROR_MSG = "Cannot call LoginFragment with a null calling package. This can occur if the launchMode of the caller is singleInstance.";
    public static final String REQUEST_KEY = "com.facebook.LoginFragment:Request";
    public static final String RESULT_KEY = "com.facebook.LoginFragment:Result";
    private static final String SAVED_LOGIN_CLIENT = "loginClient";
    private static final String TAG = "LoginFragment";
    private String callingPackage;
    private c<Intent> launcher;
    private LoginClient loginClient;
    private View progressBar;
    private LoginClient.Request request;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/facebook/login/LoginFragment$Companion;", "", "()V", "EXTRA_REQUEST", "", "NULL_CALLING_PKG_ERROR_MSG", "REQUEST_KEY", "RESULT_KEY", "SAVED_LOGIN_CLIENT", "TAG", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final Function1<ActivityResult, Unit> getLoginMethodHandlerCallback(h hVar) {
        return new LoginFragment$getLoginMethodHandlerCallback$1(this, hVar);
    }

    /* access modifiers changed from: private */
    public final void hideSpinner() {
        View view = this.progressBar;
        if (view != null) {
            view.setVisibility(8);
            onSpinnerHidden();
            return;
        }
        j.y("progressBar");
        throw null;
    }

    private final void initializeCallingPackage(Activity activity) {
        ComponentName callingActivity = activity.getCallingActivity();
        if (callingActivity != null) {
            this.callingPackage = callingActivity.getPackageName();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m160onCreate$lambda0(LoginFragment loginFragment, LoginClient.Result result) {
        j.g(loginFragment, "this$0");
        j.g(result, "outcome");
        loginFragment.onLoginClientCompleted(result);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-1  reason: not valid java name */
    public static final void m161onCreate$lambda1(Function1 function1, ActivityResult activityResult) {
        j.g(function1, "$tmp0");
        function1.invoke(activityResult);
    }

    private final void onLoginClientCompleted(LoginClient.Result result) {
        int i10;
        this.request = null;
        if (result.code == LoginClient.Result.Code.CANCEL) {
            i10 = 0;
        } else {
            i10 = -1;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable(RESULT_KEY, result);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        h activity = getActivity();
        if (isAdded() && activity != null) {
            activity.setResult(i10, intent);
            activity.finish();
        }
    }

    /* access modifiers changed from: private */
    public final void showSpinner() {
        View view = this.progressBar;
        if (view != null) {
            view.setVisibility(0);
            onSpinnerShown();
            return;
        }
        j.y("progressBar");
        throw null;
    }

    /* access modifiers changed from: protected */
    public LoginClient createLoginClient() {
        return new LoginClient((Fragment) this);
    }

    public final c<Intent> getLauncher() {
        c<Intent> cVar = this.launcher;
        if (cVar != null) {
            return cVar;
        }
        j.y("launcher");
        throw null;
    }

    /* access modifiers changed from: protected */
    public int getLayoutResId() {
        return R.layout.com_facebook_login_fragment;
    }

    public final LoginClient getLoginClient() {
        LoginClient loginClient2 = this.loginClient;
        if (loginClient2 != null) {
            return loginClient2;
        }
        j.y(SAVED_LOGIN_CLIENT);
        throw null;
    }

    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        getLoginClient().onActivityResult(i10, i11, intent);
    }

    public void onCreate(Bundle bundle) {
        LoginClient loginClient2;
        Bundle bundleExtra;
        super.onCreate(bundle);
        if (bundle == null) {
            loginClient2 = null;
        } else {
            loginClient2 = (LoginClient) bundle.getParcelable(SAVED_LOGIN_CLIENT);
        }
        if (loginClient2 != null) {
            loginClient2.setFragment(this);
        } else {
            loginClient2 = createLoginClient();
        }
        this.loginClient = loginClient2;
        getLoginClient().setOnCompletedListener(new j(this));
        h activity = getActivity();
        if (activity != null) {
            initializeCallingPackage(activity);
            Intent intent = activity.getIntent();
            if (!(intent == null || (bundleExtra = intent.getBundleExtra(REQUEST_KEY)) == null)) {
                this.request = (LoginClient.Request) bundleExtra.getParcelable("request");
            }
            c<Intent> registerForActivityResult = registerForActivityResult(new i(), new k(getLoginMethodHandlerCallback(activity)));
            j.f(registerForActivityResult, "registerForActivityResult(\n            ActivityResultContracts.StartActivityForResult(),\n            getLoginMethodHandlerCallback(activity))");
            this.launcher = registerForActivityResult;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.g(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(getLayoutResId(), viewGroup, false);
        View findViewById = inflate.findViewById(R.id.com_facebook_login_fragment_progress_bar);
        j.f(findViewById, "view.findViewById<View>(R.id.com_facebook_login_fragment_progress_bar)");
        this.progressBar = findViewById;
        getLoginClient().setBackgroundProcessingListener(new LoginFragment$onCreateView$1(this));
        return inflate;
    }

    public void onDestroy() {
        getLoginClient().cancelCurrentHandler();
        super.onDestroy();
    }

    public void onPause() {
        View view;
        super.onPause();
        View view2 = getView();
        if (view2 == null) {
            view = null;
        } else {
            view = view2.findViewById(R.id.com_facebook_login_fragment_progress_bar);
        }
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.callingPackage == null) {
            h activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        getLoginClient().startOrContinueAuth(this.request);
    }

    public void onSaveInstanceState(Bundle bundle) {
        j.g(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(SAVED_LOGIN_CLIENT, getLoginClient());
    }

    /* access modifiers changed from: protected */
    public void onSpinnerHidden() {
    }

    /* access modifiers changed from: protected */
    public void onSpinnerShown() {
    }
}
