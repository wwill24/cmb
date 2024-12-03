package com.facebook;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.h;
import com.facebook.common.R;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.internal.logging.dumpsys.EndToEndDumper;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\f\b\u0016\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0014J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J9\u0010\u0014\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0012H\u0017¢\u0006\u0004\b\u0014\u0010\u0015R(\u0010\u0017\u001a\u0004\u0018\u00010\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/facebook/FacebookActivity;", "Landroidx/fragment/app/h;", "", "handlePassThroughError", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "Landroidx/fragment/app/Fragment;", "getFragment", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "", "prefix", "Ljava/io/FileDescriptor;", "fd", "Ljava/io/PrintWriter;", "writer", "", "args", "dump", "(Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V", "<set-?>", "currentFragment", "Landroidx/fragment/app/Fragment;", "getCurrentFragment", "()Landroidx/fragment/app/Fragment;", "<init>", "()V", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public class FacebookActivity extends h {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String FRAGMENT_TAG = "SingleFragment";
    public static final String PASS_THROUGH_CANCEL_ACTION = "PassThrough";
    private static final String TAG = FacebookActivity.class.getName();
    private Fragment currentFragment;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0007*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/facebook/FacebookActivity$Companion;", "", "()V", "FRAGMENT_TAG", "", "PASS_THROUGH_CANCEL_ACTION", "TAG", "kotlin.jvm.PlatformType", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void handlePassThroughError() {
        Intent intent = getIntent();
        NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
        j.f(intent, "requestIntent");
        FacebookException exceptionFromErrorData = NativeProtocol.getExceptionFromErrorData(NativeProtocol.getMethodArgumentsFromIntent(intent));
        Intent intent2 = getIntent();
        j.f(intent2, SDKConstants.PARAM_INTENT);
        setResult(0, NativeProtocol.createProtocolResultIntent(intent2, (Bundle) null, exceptionFromErrorData));
        finish();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Boolean bool;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                j.g(str, "prefix");
                j.g(printWriter, "writer");
                EndToEndDumper instance = EndToEndDumper.Companion.getInstance();
                if (instance == null) {
                    bool = null;
                } else {
                    bool = Boolean.valueOf(instance.maybeDump(str, printWriter, strArr));
                }
                if (!j.b(bool, Boolean.TRUE)) {
                    super.dump(str, fileDescriptor, printWriter, strArr);
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    public final Fragment getCurrentFragment() {
        return this.currentFragment;
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [com.facebook.internal.FacebookDialogFragment, androidx.fragment.app.c, androidx.fragment.app.Fragment] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.fragment.app.Fragment getFragment() {
        /*
            r4 = this;
            android.content.Intent r0 = r4.getIntent()
            androidx.fragment.app.FragmentManager r1 = r4.getSupportFragmentManager()
            java.lang.String r2 = "supportFragmentManager"
            kotlin.jvm.internal.j.f(r1, r2)
            java.lang.String r2 = "SingleFragment"
            androidx.fragment.app.Fragment r3 = r1.j0(r2)
            if (r3 != 0) goto L_0x0044
            java.lang.String r0 = r0.getAction()
            java.lang.String r3 = "FacebookDialogFragment"
            boolean r0 = kotlin.jvm.internal.j.b(r3, r0)
            r3 = 1
            if (r0 == 0) goto L_0x002e
            com.facebook.internal.FacebookDialogFragment r0 = new com.facebook.internal.FacebookDialogFragment
            r0.<init>()
            r0.setRetainInstance(r3)
            r0.show((androidx.fragment.app.FragmentManager) r1, (java.lang.String) r2)
            goto L_0x0043
        L_0x002e:
            com.facebook.login.LoginFragment r0 = new com.facebook.login.LoginFragment
            r0.<init>()
            r0.setRetainInstance(r3)
            androidx.fragment.app.b0 r1 = r1.p()
            int r3 = com.facebook.common.R.id.com_facebook_fragment_container
            androidx.fragment.app.b0 r1 = r1.c(r3, r0, r2)
            r1.i()
        L_0x0043:
            r3 = r0
        L_0x0044:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookActivity.getFragment():androidx.fragment.app.Fragment");
    }

    public void onConfigurationChanged(Configuration configuration) {
        j.g(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        Fragment fragment = this.currentFragment;
        if (fragment != null) {
            fragment.onConfigurationChanged(configuration);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (!FacebookSdk.isInitialized()) {
            Utility utility = Utility.INSTANCE;
            Utility.logd(TAG, "Facebook SDK not initialized. Make sure you call sdkInitialize inside your Application's onCreate method.");
            Context applicationContext = getApplicationContext();
            j.f(applicationContext, "applicationContext");
            FacebookSdk.sdkInitialize(applicationContext);
        }
        setContentView(R.layout.com_facebook_activity_layout);
        if (j.b(PASS_THROUGH_CANCEL_ACTION, intent.getAction())) {
            handlePassThroughError();
        } else {
            this.currentFragment = getFragment();
        }
    }
}
