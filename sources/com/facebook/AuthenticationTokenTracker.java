package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import n1.a;

@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b&\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\u0007\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H$J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR$\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00108\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/facebook/AuthenticationTokenTracker;", "", "", "addBroadcastReceiver", "Lcom/facebook/AuthenticationToken;", "oldAuthenticationToken", "currentAuthenticationToken", "onCurrentAuthenticationTokenChanged", "startTracking", "stopTracking", "Landroid/content/BroadcastReceiver;", "receiver", "Landroid/content/BroadcastReceiver;", "Ln1/a;", "broadcastManager", "Ln1/a;", "", "<set-?>", "isTracking", "Z", "()Z", "<init>", "()V", "Companion", "CurrentAuthenticationTokenBroadcastReceiver", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public abstract class AuthenticationTokenTracker {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final String TAG = AuthenticationTokenTracker.class.getSimpleName();
    private final a broadcastManager;
    private boolean isTracking;
    private final BroadcastReceiver receiver = new CurrentAuthenticationTokenBroadcastReceiver(this);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/AuthenticationTokenTracker$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/facebook/AuthenticationTokenTracker$CurrentAuthenticationTokenBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/facebook/AuthenticationTokenTracker;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private final class CurrentAuthenticationTokenBroadcastReceiver extends BroadcastReceiver {
        final /* synthetic */ AuthenticationTokenTracker this$0;

        public CurrentAuthenticationTokenBroadcastReceiver(AuthenticationTokenTracker authenticationTokenTracker) {
            j.g(authenticationTokenTracker, "this$0");
            this.this$0 = authenticationTokenTracker;
        }

        public void onReceive(Context context, Intent intent) {
            j.g(context, IdentityHttpResponse.CONTEXT);
            j.g(intent, SDKConstants.PARAM_INTENT);
            if (j.b(AuthenticationTokenManager.ACTION_CURRENT_AUTHENTICATION_TOKEN_CHANGED, intent.getAction())) {
                Utility utility = Utility.INSTANCE;
                Utility.logd(AuthenticationTokenTracker.TAG, "AuthenticationTokenChanged");
                this.this$0.onCurrentAuthenticationTokenChanged((AuthenticationToken) intent.getParcelableExtra(AuthenticationTokenManager.EXTRA_OLD_AUTHENTICATION_TOKEN), (AuthenticationToken) intent.getParcelableExtra(AuthenticationTokenManager.EXTRA_NEW_AUTHENTICATION_TOKEN));
            }
        }
    }

    public AuthenticationTokenTracker() {
        Validate.sdkInitialized();
        a b10 = a.b(FacebookSdk.getApplicationContext());
        j.f(b10, "getInstance(FacebookSdk.getApplicationContext())");
        this.broadcastManager = b10;
        startTracking();
    }

    private final void addBroadcastReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(AuthenticationTokenManager.ACTION_CURRENT_AUTHENTICATION_TOKEN_CHANGED);
        this.broadcastManager.c(this.receiver, intentFilter);
    }

    public final boolean isTracking() {
        return this.isTracking;
    }

    /* access modifiers changed from: protected */
    public abstract void onCurrentAuthenticationTokenChanged(AuthenticationToken authenticationToken, AuthenticationToken authenticationToken2);

    public final void startTracking() {
        if (!this.isTracking) {
            addBroadcastReceiver();
            this.isTracking = true;
        }
    }

    public final void stopTracking() {
        if (this.isTracking) {
            this.broadcastManager.e(this.receiver);
            this.isTracking = false;
        }
    }
}
