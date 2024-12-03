package com.appsflyer.internal;

import android.graphics.ImageFormat;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.internal.components.network.http.exceptions.ParsingException;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.Map;
import java.util.UUID;

public final class AFd1hSDK extends AFd1kSDK<Map<String, String>> {
    public AFa1zSDK AFLogger;
    private String AFLogger$LogLevel;
    private String AFVersionDeclaration;
    private String afErrorLogForExcManagerOnly;
    private final AFc1pSDK afWarnLog;
    private final boolean getLevel;
    private final UUID onAppOpenAttributionNative;

    public interface AFa1zSDK {
        void AFInAppEventParameterName(String str);

        void AFInAppEventType(Map<String, String> map);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AFd1hSDK(@NonNull AFc1xSDK aFc1xSDK, @NonNull UUID uuid, @NonNull Uri uri) {
        super(AFd1wSDK.ONELINK, new AFd1wSDK[]{AFd1wSDK.RC_CDN}, aFc1xSDK, uuid.toString());
        Throwable cause;
        boolean z10 = false;
        this.afWarnLog = aFc1xSDK.AFKeystoreWrapper();
        this.onAppOpenAttributionNative = uuid;
        if (!AFb1nSDK.AFInAppEventParameterName(uri.getHost()) && !AFb1nSDK.AFInAppEventParameterName(uri.getPath())) {
            try {
                try {
                    Object invoke = ((Class) AFb1mSDK.values(KeyEvent.keyCodeFromString(""), (char) (55782 - KeyEvent.keyCodeFromString("")), (ViewConfiguration.getPressedStateDuration() >> 16) + 36)).getMethod("values", (Class[]) null).invoke(((Class) AFb1mSDK.values(-1 - TextUtils.lastIndexOf("", '0', 0, 0), (char) (55781 - TextUtils.indexOf("", '0')), ImageFormat.getBitsPerPixel(0) + 37)).getDeclaredConstructor(new Class[]{Uri.class}).newInstance(new Object[]{uri}), (Object[]) null);
                    try {
                        boolean booleanValue = ((Boolean) ((Class) AFb1mSDK.values(37 - (Process.getElapsedCpuTime() > 0 ? 1 : (Process.getElapsedCpuTime() == 0 ? 0 : -1)), (char) (7321 - (ViewConfiguration.getLongPressTimeout() >> 16)), KeyEvent.normalizeMetaState(0) + 51)).getMethod("AFInAppEventParameterName", (Class[]) null).invoke(invoke, (Object[]) null)).booleanValue();
                        try {
                            z10 = ((Boolean) ((Class) AFb1mSDK.values(36 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) ((ViewConfiguration.getEdgeSlop() >> 16) + 7321), 52 - (ViewConfiguration.getZoomControlsTimeout() > 0 ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0 ? 0 : -1)))).getMethod("AFInAppEventType", (Class[]) null).invoke(invoke, (Object[]) null)).booleanValue();
                            String[] split = uri.getPath().split(RemoteSettings.FORWARD_SLASH_STRING);
                            if (booleanValue && split.length == 3) {
                                this.AFLogger$LogLevel = split[1];
                                this.AFVersionDeclaration = split[2];
                                this.afErrorLogForExcManagerOnly = uri.toString();
                            }
                        } catch (Throwable th2) {
                            if (cause != null) {
                                throw cause;
                            }
                            throw th2;
                        }
                    } finally {
                        cause = th2.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                    }
                } finally {
                    Throwable cause2 = th.getCause();
                    if (cause2 != null) {
                        throw cause2;
                    }
                }
            } finally {
                Throwable cause3 = th.getCause();
                if (cause3 != null) {
                    throw cause3;
                }
            }
        }
        this.getLevel = z10;
    }

    /* access modifiers changed from: protected */
    public final AFc1oSDK<Map<String, String>> AFInAppEventParameterName(@NonNull String str) {
        return this.afWarnLog.AFInAppEventType(this.AFLogger$LogLevel, this.AFVersionDeclaration, this.onAppOpenAttributionNative, str);
    }

    public final long AFInAppEventType() {
        return 3000;
    }

    public final void AFKeystoreWrapper() {
        AFc1dSDK<Result> aFc1dSDK;
        super.AFKeystoreWrapper();
        AFa1zSDK aFa1zSDK = this.AFLogger;
        if (aFa1zSDK == null) {
            return;
        }
        if (this.AFInAppEventType != AFc1aSDK.SUCCESS || (aFc1dSDK = this.afDebugLog) == null) {
            Throwable afDebugLog = afDebugLog();
            String str = "Can't get OneLink data";
            if (!(afDebugLog instanceof ParsingException)) {
                String str2 = this.afErrorLogForExcManagerOnly;
                if (str2 != null) {
                    str = str2;
                }
                aFa1zSDK.AFInAppEventParameterName(str);
            } else if (((ParsingException) afDebugLog).getRawResponse().isSuccessful()) {
                aFa1zSDK.AFInAppEventParameterName("Can't parse one link data");
            } else {
                String str3 = this.afErrorLogForExcManagerOnly;
                if (str3 != null) {
                    str = str3;
                }
                aFa1zSDK.AFInAppEventParameterName(str);
            }
        } else {
            aFa1zSDK.AFInAppEventType((Map) aFc1dSDK.getBody());
        }
    }

    /* access modifiers changed from: protected */
    public final boolean AFLogger() {
        return false;
    }

    public final boolean AFLogger$LogLevel() {
        return this.getLevel;
    }

    /* access modifiers changed from: protected */
    public final AppsFlyerRequestListener afErrorLog() {
        return null;
    }

    public final boolean afWarnLog() {
        return !TextUtils.isEmpty(this.AFLogger$LogLevel) && !TextUtils.isEmpty(this.AFVersionDeclaration) && !this.AFLogger$LogLevel.equals("app");
    }

    /* access modifiers changed from: protected */
    public final boolean getLevel() {
        return false;
    }
}
