package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.Utility;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import n1.a;

@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u0019\b\u0000\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\t\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0006R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R(\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00028F@FX\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0007\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/facebook/AuthenticationTokenManager;", "", "Lcom/facebook/AuthenticationToken;", "currentAuthenticationToken", "", "saveToCache", "", "setCurrentAuthenticationToken", "oldAuthenticationToken", "sendCurrentAuthenticationTokenChangedBroadcastIntent", "loadCurrentAuthenticationToken", "currentAuthenticationTokenChanged", "Ln1/a;", "localBroadcastManager", "Ln1/a;", "Lcom/facebook/AuthenticationTokenCache;", "authenticationTokenCache", "Lcom/facebook/AuthenticationTokenCache;", "currentAuthenticationTokenField", "Lcom/facebook/AuthenticationToken;", "value", "getCurrentAuthenticationToken", "()Lcom/facebook/AuthenticationToken;", "(Lcom/facebook/AuthenticationToken;)V", "<init>", "(Ln1/a;Lcom/facebook/AuthenticationTokenCache;)V", "Companion", "CurrentAuthenticationTokenChangedBroadcastReceiver", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class AuthenticationTokenManager {
    public static final String ACTION_CURRENT_AUTHENTICATION_TOKEN_CHANGED = "com.facebook.sdk.ACTION_CURRENT_AUTHENTICATION_TOKEN_CHANGED";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_NEW_AUTHENTICATION_TOKEN = "com.facebook.sdk.EXTRA_NEW_AUTHENTICATION_TOKEN";
    public static final String EXTRA_OLD_AUTHENTICATION_TOKEN = "com.facebook.sdk.EXTRA_OLD_AUTHENTICATION_TOKEN";
    public static final String SHARED_PREFERENCES_NAME = "com.facebook.AuthenticationTokenManager.SharedPreferences";
    public static final String TAG = "AuthenticationTokenManager";
    /* access modifiers changed from: private */
    public static AuthenticationTokenManager instanceField;
    private final AuthenticationTokenCache authenticationTokenCache;
    private AuthenticationToken currentAuthenticationTokenField;
    private final a localBroadcastManager;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/facebook/AuthenticationTokenManager$Companion;", "", "()V", "ACTION_CURRENT_AUTHENTICATION_TOKEN_CHANGED", "", "EXTRA_NEW_AUTHENTICATION_TOKEN", "EXTRA_OLD_AUTHENTICATION_TOKEN", "SHARED_PREFERENCES_NAME", "TAG", "instanceField", "Lcom/facebook/AuthenticationTokenManager;", "getInstance", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AuthenticationTokenManager getInstance() {
            AuthenticationTokenManager access$getInstanceField$cp;
            AuthenticationTokenManager access$getInstanceField$cp2 = AuthenticationTokenManager.instanceField;
            if (access$getInstanceField$cp2 != null) {
                return access$getInstanceField$cp2;
            }
            synchronized (this) {
                access$getInstanceField$cp = AuthenticationTokenManager.instanceField;
                if (access$getInstanceField$cp == null) {
                    a b10 = a.b(FacebookSdk.getApplicationContext());
                    j.f(b10, "getInstance(applicationContext)");
                    AuthenticationTokenManager authenticationTokenManager = new AuthenticationTokenManager(b10, new AuthenticationTokenCache());
                    AuthenticationTokenManager.instanceField = authenticationTokenManager;
                    access$getInstanceField$cp = authenticationTokenManager;
                }
            }
            return access$getInstanceField$cp;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/facebook/AuthenticationTokenManager$CurrentAuthenticationTokenChangedBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class CurrentAuthenticationTokenChangedBroadcastReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            j.g(context, IdentityHttpResponse.CONTEXT);
            j.g(intent, SDKConstants.PARAM_INTENT);
        }
    }

    public AuthenticationTokenManager(a aVar, AuthenticationTokenCache authenticationTokenCache2) {
        j.g(aVar, "localBroadcastManager");
        j.g(authenticationTokenCache2, "authenticationTokenCache");
        this.localBroadcastManager = aVar;
        this.authenticationTokenCache = authenticationTokenCache2;
    }

    public static final AuthenticationTokenManager getInstance() {
        return Companion.getInstance();
    }

    private final void sendCurrentAuthenticationTokenChangedBroadcastIntent(AuthenticationToken authenticationToken, AuthenticationToken authenticationToken2) {
        Intent intent = new Intent(FacebookSdk.getApplicationContext(), CurrentAuthenticationTokenChangedBroadcastReceiver.class);
        intent.setAction(ACTION_CURRENT_AUTHENTICATION_TOKEN_CHANGED);
        intent.putExtra(EXTRA_OLD_AUTHENTICATION_TOKEN, authenticationToken);
        intent.putExtra(EXTRA_NEW_AUTHENTICATION_TOKEN, authenticationToken2);
        this.localBroadcastManager.d(intent);
    }

    public final void currentAuthenticationTokenChanged() {
        sendCurrentAuthenticationTokenChangedBroadcastIntent(getCurrentAuthenticationToken(), getCurrentAuthenticationToken());
    }

    public final AuthenticationToken getCurrentAuthenticationToken() {
        return this.currentAuthenticationTokenField;
    }

    public final boolean loadCurrentAuthenticationToken() {
        AuthenticationToken load = this.authenticationTokenCache.load();
        if (load == null) {
            return false;
        }
        setCurrentAuthenticationToken(load, false);
        return true;
    }

    public final void setCurrentAuthenticationToken(AuthenticationToken authenticationToken) {
        setCurrentAuthenticationToken(authenticationToken, true);
    }

    private final void setCurrentAuthenticationToken(AuthenticationToken authenticationToken, boolean z10) {
        AuthenticationToken currentAuthenticationToken = getCurrentAuthenticationToken();
        this.currentAuthenticationTokenField = authenticationToken;
        if (z10) {
            if (authenticationToken != null) {
                this.authenticationTokenCache.save(authenticationToken);
            } else {
                this.authenticationTokenCache.clear();
                Utility utility = Utility.INSTANCE;
                Utility.clearFacebookCookies(FacebookSdk.getApplicationContext());
            }
        }
        if (!Utility.areObjectsEqual(currentAuthenticationToken, authenticationToken)) {
            sendCurrentAuthenticationTokenChangedBroadcastIntent(currentAuthenticationToken, authenticationToken);
        }
    }
}
