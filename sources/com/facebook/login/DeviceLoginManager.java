package com.facebook.login;

import android.net.Uri;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.LoginClient;
import gk.f;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.PropertyReference1Impl;
import wk.l;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0012H\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/facebook/login/DeviceLoginManager;", "Lcom/facebook/login/LoginManager;", "()V", "deviceAuthTargetUserId", "", "getDeviceAuthTargetUserId", "()Ljava/lang/String;", "setDeviceAuthTargetUserId", "(Ljava/lang/String;)V", "deviceRedirectUri", "Landroid/net/Uri;", "getDeviceRedirectUri", "()Landroid/net/Uri;", "setDeviceRedirectUri", "(Landroid/net/Uri;)V", "createLoginRequest", "Lcom/facebook/login/LoginClient$Request;", "permissions", "", "Companion", "facebook-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DeviceLoginManager extends LoginManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final f<DeviceLoginManager> instance$delegate = b.b(DeviceLoginManager$Companion$instance$2.INSTANCE);
    private String deviceAuthTargetUserId;
    private Uri deviceRedirectUri;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/facebook/login/DeviceLoginManager$Companion;", "", "Lcom/facebook/login/DeviceLoginManager;", "instance$delegate", "Lgk/f;", "getInstance", "()Lcom/facebook/login/DeviceLoginManager;", "instance", "<init>", "()V", "facebook-login_release"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        static final /* synthetic */ l<Object>[] $$delegatedProperties = {kotlin.jvm.internal.l.g(new PropertyReference1Impl(kotlin.jvm.internal.l.b(Companion.class), "instance", "getInstance()Lcom/facebook/login/DeviceLoginManager;"))};

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DeviceLoginManager getInstance() {
            return (DeviceLoginManager) DeviceLoginManager.access$getInstance$delegate$cp().getValue();
        }
    }

    public static final /* synthetic */ f access$getInstance$delegate$cp() {
        Class<DeviceLoginManager> cls = DeviceLoginManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return instance$delegate;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public LoginClient.Request createLoginRequest(Collection<String> collection) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            LoginClient.Request createLoginRequest = super.createLoginRequest(collection);
            Uri uri = this.deviceRedirectUri;
            if (uri != null) {
                createLoginRequest.setDeviceRedirectUriString(uri.toString());
            }
            String str = this.deviceAuthTargetUserId;
            if (str != null) {
                createLoginRequest.setDeviceAuthTargetUserId(str);
            }
            return createLoginRequest;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    public final String getDeviceAuthTargetUserId() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.deviceAuthTargetUserId;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    public final Uri getDeviceRedirectUri() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.deviceRedirectUri;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    public final void setDeviceAuthTargetUserId(String str) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                this.deviceAuthTargetUserId = str;
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    public final void setDeviceRedirectUri(Uri uri) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                this.deviceRedirectUri = uri;
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }
}
